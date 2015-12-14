// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.ads.InterstitialAd;
import java.util.Date;

public class gt extends ans
{

    private String b;
    private InterstitialAd c;

    public gt()
    {
        b = "AbroadInterstitialAd";
        c = null;
    }

    static InterstitialAd a(gt gt1)
    {
        return gt1.c;
    }

    static InterstitialAd a(gt gt1, InterstitialAd interstitialad)
    {
        gt1.c = interstitialad;
        return interstitialad;
    }

    static String b(gt gt1)
    {
        return gt1.b;
    }

    private static void b(Context context)
    {
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        context.getSharedPreferences("FotoAdStrategy", 0).edit().putLong("AbroadInterstitialAdTimeOut", (new Date()).getTime()).apply();
        return;
        context;
    }

    public void a()
    {
        if (c != null)
        {
            c.destroy();
            c = null;
        }
    }

    public void a(Context context)
    {
        long l1 = 0L;
        long l;
        long l2;
        try
        {
            l2 = (new Date()).getTime();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        l = l1;
        if (context != null)
        {
            try
            {
                l = context.getSharedPreferences("FotoAdStrategy", 0).getLong("AbroadInterstitialAdTimeOut", 0L);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                l = l1;
            }
        }
        if (!a || l2 - l < 10000L)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        a = false;
        if (c != null)
        {
            c.setAdListener(null);
            c.destroy();
            c = null;
        }
    }

    public void a(Context context, String s, boolean flag)
    {
        if (context != null)
        {
            a(context);
            if (!a)
            {
                a = true;
                b(context);
                try
                {
                    (new Thread(new gu(this, context, s, flag))).start();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    context.printStackTrace();
                }
                a = false;
                return;
            }
        }
    }

    public void a(Context context, boolean flag)
    {
        if (c != null && c.isAdLoaded())
        {
            a = false;
            c.show();
            context.getSharedPreferences("FotoAdStrategy", 0).edit().putLong("InterstitialDisplayTime", (new Date()).getTime()).apply();
            if (flag)
            {
                c = null;
            }
        }
    }
}
