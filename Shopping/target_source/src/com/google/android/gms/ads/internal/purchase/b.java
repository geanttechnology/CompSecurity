// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.Method;

public class b
{

    Object a;
    private final Context b;

    public b(Context context)
    {
        b = context;
    }

    public Bundle a(String s, String s1, String s2)
    {
        try
        {
            Class class1 = b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            s = (Bundle)class1.getDeclaredMethod("getBuyIntent", new Class[] {
                Integer.TYPE, java/lang/String, java/lang/String, java/lang/String, java/lang/String
            }).invoke(class1.cast(a), new Object[] {
                Integer.valueOf(3), s, s1, "inapp", s2
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.b.c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", s);
            return null;
        }
        return s;
    }

    public void a()
    {
        a = null;
    }

    public void a(IBinder ibinder)
    {
        try
        {
            a = b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[] {
                android/os/IBinder
            }).invoke(null, new Object[] {
                ibinder
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            com.google.android.gms.ads.internal.util.client.b.e("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
        }
    }
}
