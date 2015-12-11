// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.blueshirt;

import gu;
import java.io.Serializable;

public class StoreAppointment
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String appointmentId;
    private long appointmentTime;
    private long reminderTime;
    private String storeAddress;
    private String storeCity;
    private String storeId;
    private String storeName;
    private String storeOpenTime;

    public StoreAppointment()
    {
    }

    public String getAppointmentId()
    {
        return appointmentId;
    }

    public long getAppointmentTime()
    {
        return appointmentTime;
    }

    public long getReminderTime()
    {
        return reminderTime;
    }

    public String getStoreAddress()
    {
        return storeAddress;
    }

    public String getStoreCity()
    {
        return storeCity;
    }

    public String getStoreId()
    {
        return storeId;
    }

    public String getStoreName()
    {
        return storeName;
    }

    public String getStoreOpenTime()
    {
        return storeOpenTime;
    }

    public void setAppointmentId(String s)
    {
        appointmentId = s;
    }

    public void setAppointmentTime(long l)
    {
        appointmentTime = l;
    }

    public void setReminderTime(long l)
    {
        reminderTime = l;
    }

    public void setStoreAddress(String s)
    {
        storeAddress = s;
    }

    public void setStoreCity(String s)
    {
        storeCity = s;
    }

    public void setStoreId(String s)
    {
        storeId = s;
    }

    public void setStoreName(String s)
    {
        storeName = s;
    }

    public void setStoreOpenTime(String s)
    {
        storeOpenTime = s;
    }
}
