// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.Method;

public class zzb
{

    private final Context mContext;
    Object zzAB;

    public zzb(Context context)
    {
        mContext = context;
    }

    public void destroy()
    {
        zzAB = null;
    }

    public void zzK(IBinder ibinder)
    {
        try
        {
            zzAB = mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[] {
                android/os/IBinder
            }).invoke(null, new Object[] {
                ibinder
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
        }
    }

    public Bundle zzb(String s, String s1, String s2)
    {
        try
        {
            Class class1 = mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            s = (Bundle)class1.getDeclaredMethod("getBuyIntent", new Class[] {
                Integer.TYPE, java/lang/String, java/lang/String, java/lang/String, java/lang/String
            }).invoke(class1.cast(zzAB), new Object[] {
                Integer.valueOf(3), s, s1, "inapp", s2
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", s);
            return null;
        }
        return s;
    }
}
