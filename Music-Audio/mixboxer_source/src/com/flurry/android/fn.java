// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.RequestListener;
import java.util.Collections;

// Referenced classes of package com.flurry.android:
//            fo

final class fn
    implements RequestListener
{

    private fo hI;

    fn(fo fo1)
    {
        hI = fo1;
        super();
    }

    public final void MMAdOverlayLaunched(MMAd mmad)
    {
        hI.onAdClicked(Collections.emptyMap());
        Log.d(fo.d(), "Millennial MMAdView banner overlay launched.");
    }

    public final void MMAdRequestIsCaching(MMAd mmad)
    {
        Log.d(fo.d(), "Millennial MMAdView banner request is caching.");
    }

    public final void requestCompleted(MMAd mmad)
    {
        hI.onAdShown(Collections.emptyMap());
        Log.d(fo.d(), (new StringBuilder()).append("Millennial MMAdView returned ad.").append(System.currentTimeMillis()).toString());
    }

    public final void requestFailed(MMAd mmad, MMException mmexception)
    {
        hI.onRenderFailed(Collections.emptyMap());
        Log.d(fo.d(), String.format("Millennial MMAdView failed to load ad with error: %d %s.", new Object[] {
            Integer.valueOf(mmexception.getCode()), mmexception.getMessage()
        }));
    }
}
