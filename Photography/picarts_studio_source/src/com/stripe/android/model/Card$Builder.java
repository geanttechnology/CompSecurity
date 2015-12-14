// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.model;


// Referenced classes of package com.stripe.android.model:
//            Card

public class cvc
{

    private String addressCity;
    private String addressCountry;
    private String addressLine1;
    private String addressLine2;
    private String addressState;
    private String addressZip;
    private String country;
    private final String cvc;
    private final Integer expMonth;
    private final Integer expYear;
    private String fingerprint;
    private String last4;
    private String name;
    private final String number;
    private String type;

    public cvc addressCity(String s)
    {
        addressCity = s;
        return this;
    }

    public addressCity addressCountry(String s)
    {
        addressCountry = s;
        return this;
    }

    public addressCountry addressLine1(String s)
    {
        addressLine1 = s;
        return this;
    }

    public addressLine1 addressLine2(String s)
    {
        addressLine2 = s;
        return this;
    }

    public addressLine2 addressState(String s)
    {
        addressState = s;
        return this;
    }

    public addressState addressZip(String s)
    {
        addressZip = s;
        return this;
    }

    public Card build()
    {
        return new Card(this, null);
    }

    public addressZip country(String s)
    {
        country = s;
        return this;
    }

    public country fingerprint(String s)
    {
        fingerprint = s;
        return this;
    }

    public fingerprint last4(String s)
    {
        last4 = s;
        return this;
    }

    public last4 name(String s)
    {
        name = s;
        return this;
    }

    public name type(String s)
    {
        type = s;
        return this;
    }
















    public (String s, Integer integer, Integer integer1, String s1)
    {
        number = s;
        expMonth = integer;
        expYear = integer1;
        cvc = s1;
    }
}
