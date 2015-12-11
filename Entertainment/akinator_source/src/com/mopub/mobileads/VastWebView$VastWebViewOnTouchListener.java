// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.mopub.mobileads:
//            VastWebView

class this._cls0
    implements android.view.stener
{

    private boolean mClickStarted;
    final VastWebView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 28
    //                   0 30
    //                   1 37;
           goto _L1 _L2 _L3
_L1:
        return false;
_L2:
        mClickStarted = true;
        return false;
_L3:
        if (mClickStarted)
        {
            mClickStarted = false;
            if (mVastWebViewClickListener != null)
            {
                mVastWebViewClickListener.VastWebViewClick();
                return false;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    ()
    {
        this$0 = VastWebView.this;
        super();
    }
}
