// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import com.facebook.ads.Ad;
import com.facebook.ads.NativeAd;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.ads.FotoNativeAbroadWall;
import com.fotoable.ads.fbnativeadsubview;
import java.util.HashMap;

class hh
    implements Runnable
{

    final Ad a;
    final hf b;

    hh(hf hf1, Ad ad)
    {
        b = hf1;
        a = ad;
        super();
    }

    public void run()
    {
        new HashMap();
        if (b.a == null || b.a != a)
        {
            return;
        }
        StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeAD, StaticFlurryEvent.adLoaded);
        fbnativeadsubview fbnativeadsubview1 = new fbnativeadsubview(b.b.a);
        fbnativeadsubview1.loadViewWithAd(b.a);
        float f = b.b.a.getResources().getDisplayMetrics().widthPixels;
        f -= f / 8F;
        float f1 = (207F * f) / 300F;
        fbnativeadsubview1.setLayoutParams(new android.view.ViewGroup.LayoutParams((int)f, (int)f1));
        if (fbnativeadsubview1.getParent() != null)
        {
            ((ViewGroup)fbnativeadsubview1.getParent()).removeView(fbnativeadsubview1);
        }
        b.b.d.addView(fbnativeadsubview1, -2, -2);
        if (b.b.c != null)
        {
            b.b.c.adLoaded(b.b.d);
            b.a.registerViewForInteraction(fbnativeadsubview1);
        }
        Log.d("NativeAbroadWall", "load native ad succeed!");
    }
}
