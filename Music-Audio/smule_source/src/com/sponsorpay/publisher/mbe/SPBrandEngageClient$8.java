// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;

import android.view.MotionEvent;
import com.sponsorpay.utils.SponsorPayLogger;

// Referenced classes of package com.sponsorpay.publisher.mbe:
//            SPBrandEngageClient

class this._cls0
    implements android.view.leTapListener
{

    final SPBrandEngageClient this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        SponsorPayLogger.d("SPBrandEngageClient", "double tap event");
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionevent)
    {
        SponsorPayLogger.d("SPBrandEngageClient", "double tap event");
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        return false;
    }

    ()
    {
        this$0 = SPBrandEngageClient.this;
        super();
    }
}
