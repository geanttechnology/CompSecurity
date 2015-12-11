// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            co

public final class cl
{

    private static final Object hC = new Object();
    private static String iw;

    public static String as()
    {
        String s;
        synchronized (hC)
        {
            s = iw;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static String b(Context context, String s, String s1)
    {
        synchronized (hC)
        {
            if (iw == null && !TextUtils.isEmpty(s))
            {
                c(context, s, s1);
            }
            context = iw;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static void c(Context context, String s, String s1)
    {
        Class class1;
        String as1[];
        try
        {
            s1 = context.createPackageContext(s1, 3).getClassLoader();
            class1 = Class.forName("com.google.ads.mediation.MediationAdapter", false, s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            iw = "err";
            return;
        }
        context = new BigInteger(new byte[1]);
        as1 = s.split(",");
        for (int i = 0; i < as1.length;)
        {
            s = context;
            if (co.a(s1, class1, as1[i]))
            {
                s = context.setBit(i);
            }
            i++;
            context = s;
        }

        iw = String.format(Locale.US, "%X", new Object[] {
            context
        });
    }

}
