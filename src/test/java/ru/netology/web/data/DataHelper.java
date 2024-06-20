package ru.netology.web.data;


import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import ru.netology.web.page.VerificationPage;

import java.util.Locale;
import java.util.Random;

public class DataHelper {
    private static final Faker FAKER = new Faker(new Locale("en"));
    private DataHelper() {}



    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }


    public static String generateRandomLogin() {
        return  FAKER.name().username();
    }

    public static String generateRandomPassword() {
        return  FAKER.internet().password();
    }

    public static AuthInfo generateRandomUser(){
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }

    public static VerificationCode generateRandomVerificationCode(){
        return new VerificationCode(FAKER.numerify("######"));
    }


    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public  static class VerificationCode{
        String code;
    }





    public static String getVerificationCode(){
        return "12345";
    }



    public static CardInfo getFirstCardInfo(){
        return new CardInfo("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }

    public static CardInfo getSecondCardInfo(){
        return new CardInfo("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }

    public static String getMaskedNumber(String cardNumber){
        return "**** **** **** " + cardNumber.substring(15);
    }

    public static int generateValidAmount(int balance){
        return new Random().nextInt(Math.abs(balance)) + 1;
    }

    public static int generateInvalidAmount(int balance){
        return Math.abs(balance) + new Random().nextInt(1000);
    }
    @Value
    public static class CardInfo {
        String cardNumber;
        String testId;
    }


}