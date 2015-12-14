// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.model;


public class ContactInfo
{

    private String email;
    private String name;
    private boolean smsAllowed;
    private String textPhoneNumber;

    public ContactInfo()
    {
        smsAllowed = true;
    }

    public String getEmail()
    {
        return email;
    }

    public String getTextPhoneNumber()
    {
        return textPhoneNumber;
    }

    public boolean isSmsAllowed()
    {
        return smsAllowed;
    }

    public void setEmail(String s)
    {
        email = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setSmsAllowed(boolean flag)
    {
        smsAllowed = flag;
    }

    public void setTextPhoneNumber(String s)
    {
        if (!s.equals("null"))
        {
            textPhoneNumber = s;
        }
    }
}
