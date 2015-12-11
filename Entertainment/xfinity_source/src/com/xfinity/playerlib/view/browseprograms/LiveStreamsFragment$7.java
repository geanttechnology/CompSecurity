// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.support.v4.view.ViewPager;
import android.view.ViewTreeObserver;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            LiveStreamsFragment

class val.viewTreeObserver
    implements android.view.balLayoutListener
{

    final LiveStreamsFragment this$0;
    final ViewTreeObserver val$viewTreeObserver;

    public void onGlobalLayout()
    {
label0:
        {
            if (LiveStreamsFragment.access$300(LiveStreamsFragment.this).getMeasuredWidth() > 0)
            {
                LiveStreamsFragment.access$1900(LiveStreamsFragment.this);
                if (val$viewTreeObserver.isAlive())
                {
                    if (android.os.live < 16)
                    {
                        break label0;
                    }
                    val$viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
            return;
        }
        val$viewTreeObserver.removeGlobalOnLayoutListener(this);
    }

    ()
    {
        this$0 = final_livestreamsfragment;
        val$viewTreeObserver = ViewTreeObserver.this;
        super();
    }
}
