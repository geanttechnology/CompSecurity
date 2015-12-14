// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.AdSettings;
import com.facebook.ads.NativeAd;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.ads.FotoNativeAbroadWall;

public class he
    implements Runnable
{

    final Context a;
    final String b;
    final anv c;
    final FotoNativeAbroadWall d;

    public he(FotoNativeAbroadWall fotonativeabroadwall, Context context, String s, anv anv)
    {
        d = fotonativeabroadwall;
        a = context;
        b = s;
        c = anv;
        super();
    }

    public void run()
    {
        Looper.prepare();
        try
        {
            FotoNativeAbroadWall.access$002(d, new Handler());
            NativeAd nativead = new NativeAd(a, b);
            AdSettings.addTestDevice("016a0279b084789242a778031e29285e");
            AdSettings.addTestDevice("d590623f0b352e2ea94dc0a41365d8ef");
            AdSettings.addTestDevice("3909cdec8a6015f686178e83f17287d4");
            nativead.setAdListener(new hf(this, nativead));
            nativead.loadAd();
            StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeAD, StaticFlurryEvent.adRequest);
            StaticFlurryEvent.recordNativeAdRequestTimes(d.getContext(), false, true);
        }
        catch (Exception exception) { }
        Looper.loop();
    }
}
