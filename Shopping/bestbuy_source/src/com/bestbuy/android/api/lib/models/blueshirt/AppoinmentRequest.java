// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.blueshirt;

import gu;
import java.io.Serializable;

public class AppoinmentRequest
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String date;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private boolean sendEmail;
    private String time;

    public AppoinmentRequest()
    {
    }

    public String getDate()
    {
        return date;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getTime()
    {
        return time;
    }

    public boolean isSendEmail()
    {
        return sendEmail;
    }

    public void setDate(String s)
    {
        date = s;
    }

    public void setEmailAddress(String s)
    {
        emailAddress = s;
    }

    public void setFirstName(String s)
    {
        firstName = s;
    }

    public void setLastName(String s)
    {
        lastName = s;
    }

    public void setPhoneNumber(String s)
    {
        phoneNumber = s;
    }

    public void setSendEmail(boolean flag)
    {
        sendEmail = flag;
    }

    public void setTime(String s)
    {
        time = s;
    }
}
