// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.view.MotionEvent;
import android.view.View;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            MosaicFragment

class this._cls0
    implements android.view.ner
{

    final MosaicFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getRawY() < (float)MosaicFragment.access$100(MosaicFragment.this) && mScreenModeManager.isFullScreen())
        {
            exitFullScreen();
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = MosaicFragment.this;
        super();
    }
}
