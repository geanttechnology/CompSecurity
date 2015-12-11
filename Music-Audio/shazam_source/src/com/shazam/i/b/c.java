// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b;

import android.app.NotificationManager;
import android.content.Context;
import android.location.LocationManager;
import com.shazam.android.d;
import com.shazam.android.e;

public final class c
{

    public static Context a()
    {
        return (new e()).b();
    }

    public static NotificationManager b()
    {
        return (NotificationManager)a().getSystemService("notification");
    }

    public static LocationManager c()
    {
        return (LocationManager)a().getSystemService("location");
    }
}
