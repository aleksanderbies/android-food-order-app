package com.abies.foodorderapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abies.foodorderapp.Models.BasketModel;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.ArrayList;
import java.util.Properties;

import static java.lang.Double.parseDouble;


public class OrderActivity extends AppCompatActivity {
    EditText nameAndSurname, addressAndNumber, postCodeAndCity, email, phoneNumber;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logoactionbar);
        setContentView(R.layout.activity_order);
        DataBaseHelper helper = new DataBaseHelper(this);
        ArrayList<BasketModel> basket = helper.getProductsFromBasket();
        nameAndSurname = findViewById(R.id.nameAndSurnane);
        addressAndNumber = findViewById(R.id.addressAndNumber);
        postCodeAndCity = findViewById(R.id.postCodeAndCity);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phoneNumber);

        nameAndSurname.setOnClickListener(v -> nameAndSurname.getText().clear());
        addressAndNumber.setOnClickListener(v -> addressAndNumber.getText().clear());
        postCodeAndCity.setOnClickListener(v -> postCodeAndCity.getText().clear());
        email.setOnClickListener(v -> email.getText().clear());
        phoneNumber.setOnClickListener(v -> phoneNumber.getText().clear());

        Button orderNow = findViewById(R.id.orderNow);

        orderNow.setOnClickListener(v -> {
            String n = nameAndSurname.getText().toString();
            String a = addressAndNumber.getText().toString();
            String p = postCodeAndCity.getText().toString();
            String t = phoneNumber.getText().toString();
            String e = email.getText().toString();
            if (n.equals("Imię i nazwisko") || n.equals("") || n.equals(" ")){
                Toast.makeText(OrderActivity.this, "Podaj swoje imię i nazwisko", Toast.LENGTH_SHORT).show();
            }else if (a.equals("Ulica, Nr domu") || a.equals("") || a.equals(" ")){
                Toast.makeText(OrderActivity.this, "Podaj swój adres", Toast.LENGTH_SHORT).show();
            }else if (p.equals("Kod pocztowy, Miasto") || p.equals("") || p.equals(" ")){
                Toast.makeText(OrderActivity.this, "Podaj swój kod pocztowy oraz miasto", Toast.LENGTH_SHORT).show();
            }else if(!e.contains("@") || e.chars().filter(ch -> ch == '@').count() != 1){
                Toast.makeText(OrderActivity.this, "Podaj poprawny adres email", Toast.LENGTH_SHORT).show();
            }else if(t.length()!=9){
                Toast.makeText(OrderActivity.this, "Podaj poprawny numer telefonu", Toast.LENGTH_SHORT).show();
            }else {
                final String username = "";//restaurant e-mail address
                final String password = "";//restaurant e-mail password

                String order = "Zamówienie: \n";
                double fullPrice = 0.0;

                for (BasketModel model : basket){
                    order+= model.getBasketFoodName() + " " + model.getBasketQuantity() + "szt. " + model.getBasketPrice() + "\n";
                    fullPrice += parseDouble(model.getBasketPrice());
                }

                order += "Razem do zapłaty: " + fullPrice + "\n \n \n" + "Adres Dostawy: \n" + n + "\n" + a + "\n" + p + "\n" + e + "\n" + t + "\n";

                Properties properties = new Properties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable","true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");

                Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(username, password);
                    }
                });

                try{
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
                    message.setSubject("Zamówienie od " + n);
                    message.setText(order);
                    Transport.send(message);
                } catch (AddressException addressException) {
                    addressException.printStackTrace();
                } catch (MessagingException messagingException) {
                    messagingException.printStackTrace();
                }

                helper.clearBasket();
                OrderActivity.this.startActivity(new Intent(OrderActivity.this, FinishActivity.class));
                OrderActivity.this.finish();
            }
        });
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}