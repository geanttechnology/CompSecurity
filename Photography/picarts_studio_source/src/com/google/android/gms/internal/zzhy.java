// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.math.BigInteger;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            zzid

public final class zzhy
{

    private static String zzIk;
    private static final Object zzpy = new Object();

    public static String zza(Context context, String s, String s1)
    {
        synchronized (zzpy)
        {
            if (zzIk == null && !TextUtils.isEmpty(s))
            {
                zzb(context, s, s1);
            }
            context = zzIk;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static void zzb(Context context, String s, String s1)
    {
        Class class1;
        String as[];
        try
        {
            s1 = context.createPackageContext(s1, 3).getClassLoader();
            class1 = Class.forName("com.google.ads.mediation.MediationAdapter", false, s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            zzIk = "err";
            return;
        }
        context = new BigInteger(new byte[1]);
        as = s.split(",");
        for (int i = 0; i < as.length;)
        {
            s = context;
            if (zzp.zzbv().zza(s1, class1, as[i]))
            {
                s = context.setBit(i);
            }
            i++;
            context = s;
        }

        zzIk = String.format(Locale.US, "%X", new Object[] {
            context
        });
    }

    public static String zzgy()
    {
        String s;
        synchronized (zzpy)
        {
            s = zzIk;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
