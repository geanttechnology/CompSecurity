// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.view.MotionEvent;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SlideShowFragment

class this._cls0 extends android.view.leOnGestureListener
{

    final SlideShowFragment this$0;

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        if (mScreenModeManager.isFullScreen())
        {
            exitFullScreen(true);
        } else
        {
            enterFullScreen(true);
        }
        return false;
    }

    ()
    {
        this$0 = SlideShowFragment.this;
        super();
    }
}
