// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.dagger;

import android.content.Context;
import android.content.res.Resources;
import android.location.LocationManager;
import android.view.LayoutInflater;

public class AndroidServicesModule
{

    public AndroidServicesModule()
    {
    }

    LayoutInflater provideLayoutInflater(Context context)
    {
        return (LayoutInflater)context.getSystemService("layout_inflater");
    }

    LocationManager provideLocationManager(Context context)
    {
        return (LocationManager)context.getSystemService("location");
    }

    Resources provideResources(Context context)
    {
        return context.getResources();
    }
}
