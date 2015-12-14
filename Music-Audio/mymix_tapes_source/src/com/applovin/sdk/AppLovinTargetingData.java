// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.sdk;

import android.location.Location;

public interface AppLovinTargetingData
{

    public static final char GENDER_FEMALE = 102;
    public static final char GENDER_MALE = 109;

    public abstract void clearData();

    public abstract void putExtra(String s, String s1);

    public abstract void setBirthYear(int i);

    public abstract void setCarrier(String s);

    public abstract void setCountry(String s);

    public abstract void setGender(char c);

    public transient abstract void setInterests(String as[]);

    public transient abstract void setKeywords(String as[]);

    public abstract void setLanguage(String s);

    public abstract void setLocation(Location location);
}
