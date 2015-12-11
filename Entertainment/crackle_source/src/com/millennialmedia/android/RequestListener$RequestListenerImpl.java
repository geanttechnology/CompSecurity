// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.util.Log;

// Referenced classes of package com.millennialmedia.android:
//            RequestListener, MMException, MMAd

public static class 
    implements RequestListener
{

    public void MMAdOverlayLaunched(MMAd mmad)
    {
        Log.i("MillennialMediaSDK", "Millennial Media Ad View overlay launched");
    }

    public void MMAdRequestIsCaching(MMAd mmad)
    {
        Log.i("MillennialMediaSDK", "Millennial Media Ad View caching request");
    }

    public void requestCompleted(MMAd mmad)
    {
        Log.i("MillennialMediaSDK", "Ad request succeeded");
    }

    public void requestFailed(MMAd mmad, MMException mmexception)
    {
        Log.i("MillennialMediaSDK", String.format("Ad request failed with error: %d %s.", new Object[] {
            Integer.valueOf(mmexception.getCode()), mmexception.getMessage()
        }));
    }

    public ()
    {
    }
}
