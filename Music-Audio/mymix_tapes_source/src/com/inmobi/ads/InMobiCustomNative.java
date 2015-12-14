// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.view.View;
import com.inmobi.commons.core.utilities.Logger;
import java.net.URL;
import java.util.Map;
import java.util.WeakHashMap;

// Referenced classes of package com.inmobi.ads:
//            InMobiNative, o

public final class InMobiCustomNative extends InMobiNative
{

    private static final String TAG = com/inmobi/ads/InMobiCustomNative.getSimpleName();

    public InMobiCustomNative(long l, InMobiNative.NativeAdListener nativeadlistener)
    {
        super(l, nativeadlistener);
    }

    public static void bind(View view, InMobiNative inmobinative, String s)
    {
        if (view == null || inmobinative == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Please pass non-null instances of a view and InMobiNative to bind.");
        } else
        {
            if ((o)sMappedAdUnits.get(view) != null)
            {
                unbind(view);
            }
            inmobinative = inmobinative.mNativeAdUnit;
            if (inmobinative != null)
            {
                sMappedAdUnits.remove(view);
                sMappedAdUnits.put(view, inmobinative);
                inmobinative.a(view, null, s);
                return;
            }
        }
    }

    public static void bind(View view, InMobiNative inmobinative, URL url)
    {
        if (view == null || inmobinative == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Please pass non-null instances of a view and InMobiNative to bind.");
        } else
        {
            if ((o)sMappedAdUnits.get(view) != null)
            {
                unbind(view);
            }
            inmobinative = inmobinative.mNativeAdUnit;
            if (inmobinative != null)
            {
                sMappedAdUnits.remove(view);
                sMappedAdUnits.put(view, inmobinative);
                inmobinative.a(view, url, null);
                return;
            }
        }
    }

    public final void reportAdClick(String s, Map map)
    {
        if (mNativeAdUnit != null)
        {
            mNativeAdUnit.a(map, null, s);
        }
    }

    public final void reportAdClick(URL url, Map map)
    {
        if (mNativeAdUnit != null)
        {
            mNativeAdUnit.a(map, url, null);
        }
    }

    public final void reportAdClickAndOpenLandingPage(String s, Map map)
    {
        if (mNativeAdUnit != null)
        {
            mNativeAdUnit.a(map, null, s);
            mNativeAdUnit.B();
        }
    }

    public final void reportAdClickAndOpenLandingPage(URL url, Map map)
    {
        if (mNativeAdUnit != null)
        {
            mNativeAdUnit.a(map, url, null);
            mNativeAdUnit.B();
        }
    }

}
