// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.zzlk;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class zza
{

    public static final Handler zzGF = new Handler(Looper.getMainLooper());

    public zza()
    {
    }

    public boolean zzQ(Context context)
    {
        if (context.getResources().getConfiguration().orientation == 2)
        {
            if ((int)((float)((DisplayMetrics) (context = context.getResources().getDisplayMetrics())).heightPixels / ((DisplayMetrics) (context)).density) < 600)
            {
                return true;
            }
        }
        return false;
    }

    public boolean zzR(Context context)
    {
        DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        int i;
        int j;
        int k;
        int l;
        boolean flag;
        if (zzlk.zzoW())
        {
            context.getRealMetrics(displaymetrics);
            j = displaymetrics.heightPixels;
            i = displaymetrics.widthPixels;
        } else
        {
            try
            {
                j = ((Integer)android/view/Display.getMethod("getRawHeight", new Class[0]).invoke(context, new Object[0])).intValue();
                i = ((Integer)android/view/Display.getMethod("getRawWidth", new Class[0]).invoke(context, new Object[0])).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
        }
        context.getMetrics(displaymetrics);
        k = displaymetrics.heightPixels;
        l = displaymetrics.widthPixels;
        if (k == j && l == i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public int zzS(Context context)
    {
        int i = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        if (i > 0)
        {
            return context.getResources().getDimensionPixelSize(i);
        } else
        {
            return 0;
        }
    }

    public int zza(DisplayMetrics displaymetrics, int i)
    {
        return (int)TypedValue.applyDimension(1, i, displaymetrics);
    }

    public String zzax(String s)
    {
        int i = 0;
_L2:
        if (i >= 2)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj;
        obj = MessageDigest.getInstance("MD5");
        ((MessageDigest) (obj)).update(s.getBytes());
        obj = String.format(Locale.US, "%032X", new Object[] {
            new BigInteger(1, ((MessageDigest) (obj)).digest())
        });
        return ((String) (obj));
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }

    public int zzb(Context context, int i)
    {
        return zza(context.getResources().getDisplayMetrics(), i);
    }

    public int zzb(DisplayMetrics displaymetrics, int i)
    {
        return Math.round((float)i / displaymetrics.density);
    }

    public int zzc(Context context, int i)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        context.getMetrics(displaymetrics);
        return zzb(displaymetrics, i);
    }

    public boolean zzgw()
    {
        return Looper.myLooper() == Looper.getMainLooper();
    }

}
