// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.user;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Registration
{

    private String confirmEmail;
    private String confirmPassword;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private String password;
    private String rewardZoneId;
    private String zip;

    public Registration()
    {
    }

    public static Registration loadData(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            String s8)
    {
        s6 = new Registration();
        s6.firstName = s;
        s6.middleName = s1;
        s6.lastName = s2;
        s6.email = s3;
        s6.confirmEmail = s4;
        s6.password = s5;
        s6.confirmPassword = s5;
        s6.zip = s7;
        s6.rewardZoneId = s8;
        return s6;
    }

    public String getConfirmEmail()
    {
        return confirmEmail;
    }

    public String getConfirmPassword()
    {
        return confirmPassword;
    }

    public String getEmail()
    {
        return email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRewardZoneId()
    {
        return rewardZoneId;
    }

    public Document getXML()
    {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("user");
        document.appendChild(element);
        Element element1 = document.createElement("firstname");
        element1.setTextContent(firstName);
        element.appendChild(element1);
        element1 = document.createElement("middlename");
        element1.setTextContent(middleName);
        element.appendChild(element1);
        element1 = document.createElement("lastname");
        element1.setTextContent(lastName);
        element.appendChild(element1);
        element1 = document.createElement("emailaddress");
        element1.setTextContent(email);
        element.appendChild(element1);
        element1 = document.createElement("confirmemailaddress");
        element1.setTextContent(confirmEmail);
        element.appendChild(element1);
        element1 = document.createElement("password");
        element1.setTextContent(password);
        element.appendChild(element1);
        element1 = document.createElement("confirmpassword");
        element1.setTextContent(confirmPassword);
        element.appendChild(element1);
        element1 = document.createElement("postalcode");
        element1.setTextContent(zip);
        element.appendChild(element1);
        element1 = document.createElement("rewardzoneid");
        element1.setTextContent(rewardZoneId);
        element.appendChild(element1);
        return document;
    }

    public String getZip()
    {
        return zip;
    }
}
