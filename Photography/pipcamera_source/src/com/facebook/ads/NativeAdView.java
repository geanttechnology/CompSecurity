// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.view.b;

// Referenced classes of package com.facebook.ads:
//            NativeAd, NativeAdViewAttributes

public class NativeAdView
{

    public NativeAdView()
    {
    }

    public static View render(Context context, NativeAd nativead, Type type)
    {
        return render(context, nativead, type, null);
    }

    public static View render(Context context, NativeAd nativead, Type type, NativeAdViewAttributes nativeadviewattributes)
    {
        if (!nativead.isNativeConfigEnabled()) goto _L2; else goto _L1
_L1:
        NativeAdViewAttributes nativeadviewattributes1 = nativead.getAdViewAttributes();
_L4:
        nativead.a(type);
        return new b(context, nativead, type, nativeadviewattributes1);
_L2:
        nativeadviewattributes1 = nativeadviewattributes;
        if (nativeadviewattributes == null)
        {
            nativeadviewattributes1 = new NativeAdViewAttributes();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
