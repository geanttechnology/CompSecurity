// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.model;


public class MobileState
{

    public boolean loggedIn;
    public boolean networkAvailable;
    public String oneClickCity;
    public boolean oneClickEnabled;
    public String oneClickName;
    public boolean prime;
    public boolean supportedLocale;
    public long updateTime;
    public boolean weblabOneClickDisabled;
    public boolean weblabWearableDeviceDisabled;

    public MobileState()
    {
        updateTime = 0L;
        oneClickEnabled = false;
        loggedIn = false;
        prime = false;
        supportedLocale = false;
        networkAvailable = false;
        weblabOneClickDisabled = false;
        weblabWearableDeviceDisabled = false;
        oneClickCity = null;
        oneClickName = null;
    }
}
