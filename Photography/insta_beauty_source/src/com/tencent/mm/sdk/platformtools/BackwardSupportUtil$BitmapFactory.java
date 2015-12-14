// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log

public class 
{

    public static Bitmap decodeFile(String s, float f)
    {
        android.graphics.l.BitmapFactory bitmapfactory = new android.graphics.l.BitmapFactory();
        f = 160F * f;
        bitmapfactory.BitmapFactory = (int)f;
        s = BitmapFactory.decodeFile(s, bitmapfactory);
        if (s != null)
        {
            s.setDensity((int)f);
        }
        return s;
    }

    public static Bitmap decodeStream(InputStream inputstream)
    {
        android.graphics.l.BitmapFactory bitmapfactory = new android.graphics.l.BitmapFactory();
        bitmapfactory.BitmapFactory = 160;
        bitmapfactory.onfig = android.graphics.onfig;
        return BitmapFactory.decodeStream(inputstream, null, bitmapfactory);
    }

    public static Bitmap decodeStream(InputStream inputstream, float f)
    {
        android.graphics.onfig onfig = new android.graphics.onfig();
        onfig.onfig = (int)(160F * f);
        onfig.onfig = android.graphics.onfig;
        return BitmapFactory.decodeStream(inputstream, null, onfig);
    }

    public static int fromDPToPix(Context context, float f)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        return Math.round(((float)displaymetrics.densityDpi * f) / 160F);
    }

    public static Bitmap getBitmapFromURL(String s)
    {
        Bitmap bitmap;
        Log.d("MicroMsg.SDK.BackwardSupportUtil", (new StringBuilder("get bitmap from url:")).append(s).toString());
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setDoInput(true);
        s.connect();
        s = s.getInputStream();
        bitmap = decodeStream(s);
        s.close();
        return bitmap;
        s;
        Log.e("MicroMsg.SDK.BackwardSupportUtil", "get bitmap from url failed");
        s.printStackTrace();
        return null;
        s;
        throw s;
    }

    public static String getDisplayDensityType(Context context)
    {
        Object obj = context.getResources().getDisplayMetrics();
        Configuration configuration = context.getResources().getConfiguration();
        if (((DisplayMetrics) (obj)).density < 1.0F)
        {
            context = (new StringBuilder()).append("").append("LDPI").toString();
        } else
        if (((DisplayMetrics) (obj)).density >= 1.5F)
        {
            context = (new StringBuilder()).append("").append("HDPI").toString();
        } else
        {
            context = (new StringBuilder()).append("").append("MDPI").toString();
        }
        obj = (new StringBuilder()).append(context);
        if (configuration.orientation == 2)
        {
            context = "_L";
        } else
        {
            context = "_P";
        }
        return ((StringBuilder) (obj)).append(context).toString();
    }

    public ()
    {
    }
}
