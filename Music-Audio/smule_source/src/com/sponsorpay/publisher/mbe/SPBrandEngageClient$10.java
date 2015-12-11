// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.sponsorpay.publisher.mbe:
//            SPBrandEngageClient

class val.gestureDetector
    implements android.view.EngageClient._cls10
{

    final SPBrandEngageClient this$0;
    private final GestureDetector val$gestureDetector;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return val$gestureDetector.onTouchEvent(motionevent);
    }

    _cls9()
    {
        this$0 = final_spbrandengageclient;
        val$gestureDetector = GestureDetector.this;
        super();
    }
}
