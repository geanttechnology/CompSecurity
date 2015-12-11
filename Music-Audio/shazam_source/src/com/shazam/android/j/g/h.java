// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.g;

import android.app.Application;
import android.telephony.TelephonyManager;

// Referenced classes of package com.shazam.android.j.g:
//            d

public final class h
    implements d
{

    private final Application b;

    public h(Application application)
    {
        b = application;
    }

    public final String a()
    {
        Object obj = (TelephonyManager)b.getSystemService("phone");
        String s;
        try
        {
            obj = ((TelephonyManager) (obj)).getDeviceId();
        }
        catch (Exception exception)
        {
            exception = null;
        }
        s = ((String) (obj));
        if (obj == null)
        {
            s = "unknown";
        }
        return s;
    }

    public final String b()
    {
        Object obj = (TelephonyManager)b.getSystemService("phone");
        String s;
        try
        {
            obj = ((TelephonyManager) (obj)).getSubscriberId();
        }
        catch (Exception exception)
        {
            exception = null;
        }
        s = ((String) (obj));
        if (obj == null)
        {
            s = "unknown";
        }
        return s;
    }

    public final String c()
    {
        return android.provider.Settings.Secure.getString(b.getContentResolver(), "android_id");
    }
}
