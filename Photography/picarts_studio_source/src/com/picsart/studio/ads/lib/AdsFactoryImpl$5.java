// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads.lib;

import android.util.Log;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.RequestListener;

// Referenced classes of package com.picsart.studio.ads.lib:
//            AdsFactoryImpl

final class 
    implements RequestListener
{

    public final void MMAdOverlayClosed(MMAd mmad)
    {
    }

    public final void MMAdOverlayLaunched(MMAd mmad)
    {
    }

    public final void MMAdRequestIsCaching(MMAd mmad)
    {
    }

    public final void onSingleTap(MMAd mmad)
    {
    }

    public final void requestCompleted(MMAd mmad)
    {
        Log.i("ads", "MMAd::requestCompleted");
    }

    public final void requestFailed(MMAd mmad, MMException mmexception)
    {
        Log.i("ads", "-MMAd::requestFailed");
    }

    ()
    {
    }
}
