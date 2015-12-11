// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.view.MotionEvent;
import android.view.View;
import com.mopub.mobileads.ViewGestureDetector;

// Referenced classes of package com.mopub.mraid:
//            MraidBridge

class eDetector
    implements android.view.stener
{

    final MraidBridge this$0;
    final ViewGestureDetector val$gestureDetector;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        val$gestureDetector.sendTouchEvent(motionevent);
        motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 36
    //                   0 38
    //                   1 38;
           goto _L1 _L2 _L2
_L1:
        return false;
_L2:
        if (!view.hasFocus())
        {
            view.requestFocus();
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    eDetector()
    {
        this$0 = final_mraidbridge;
        val$gestureDetector = ViewGestureDetector.this;
        super();
    }
}
