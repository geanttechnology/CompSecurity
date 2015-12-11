// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.location.LocationManager;
import java.util.Iterator;
import java.util.List;

public class p
{

    private static final String TAG = com/target/ui/util/p.getSimpleName();
    private static Boolean sIsMockLocationServicesEnabled = null;

    public p()
    {
    }

    public static boolean a(Context context)
    {
        for (context = ((LocationManager)context.getSystemService("location")).getProviders(true).iterator(); context.hasNext();)
        {
            String s = (String)context.next();
            if (s.equals("gps") || s.equals("network"))
            {
                return true;
            }
        }

        return false;
    }

}
