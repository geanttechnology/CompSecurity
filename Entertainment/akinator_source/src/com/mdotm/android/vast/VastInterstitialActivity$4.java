// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.vast;

import android.view.MotionEvent;
import android.view.View;
import com.mdotm.android.utils.MdotMLogger;

// Referenced classes of package com.mdotm.android.vast:
//            VastInterstitialActivity

class this._cls0
    implements android.view.ctivity._cls4
{

    final VastInterstitialActivity this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (VastInterstitialActivity.access$14(VastInterstitialActivity.this))
        {
            int i = motionevent.getAction();
            MdotMLogger.i(this, (new StringBuilder("onTouch :: ")).append(i).toString());
            if (i == 0 && !VastInterstitialActivity.access$0(VastInterstitialActivity.this))
            {
                VastInterstitialActivity.access$1(VastInterstitialActivity.this, true);
                VastInterstitialActivity.access$2(VastInterstitialActivity.this);
            }
        }
        return false;
    }

    ()
    {
        this$0 = VastInterstitialActivity.this;
        super();
    }
}
