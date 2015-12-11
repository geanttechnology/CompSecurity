// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class Profile
{

    public String city;
    public String dress_size;
    public String shoe_size;
    public String state;
    public String website;
    public String zip;

    public Profile()
    {
    }

    public String getLocation()
    {
        if (city != null && state != null && city.length() > 0 && state.length() > 0)
        {
            return (new StringBuilder()).append(city).append(", ").append(state).toString();
        }
        if (city != null && city.length() > 0)
        {
            return city;
        }
        if (state != null && state.length() > 0)
        {
            return state;
        } else
        {
            return "";
        }
    }
}
