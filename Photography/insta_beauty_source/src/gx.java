// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.NativeAd;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.ads.FotoNativeAbroadIcon;

public class gx
    implements Runnable
{

    final anw a;
    final FotoNativeAbroadIcon b;

    public gx(FotoNativeAbroadIcon fotonativeabroadicon, anw anw)
    {
        b = fotonativeabroadicon;
        a = anw;
        super();
    }

    public void run()
    {
        Looper.prepare();
        try
        {
            FotoNativeAbroadIcon.access$002(b, new Handler());
            if (FotoNativeAbroadIcon.access$100(b) != null)
            {
                FotoNativeAbroadIcon.access$100(b).a = new NativeAd(b.getContext(), FotoNativeAbroadIcon.access$200(b));
                FotoNativeAbroadIcon.access$100(b).a.setAdListener(new gy(this));
                FotoNativeAbroadIcon.access$100(b).a.loadAd();
                StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeIconAD, StaticFlurryEvent.adRequest);
                StaticFlurryEvent.recordNativeAdRequestTimes(b.getContext(), true, false);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        Looper.loop();
    }
}
