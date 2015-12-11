// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.blueshirt;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class AppointmentSlots
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String date;
    private ArrayList slots;

    public AppointmentSlots()
    {
    }

    public String getDate()
    {
        return date;
    }

    public ArrayList getSlots()
    {
        return slots;
    }

    public void setDate(String s)
    {
        date = s;
    }

    public void setSlots(ArrayList arraylist)
    {
        slots = arraylist;
    }
}
