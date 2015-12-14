// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SlideShowFragment

class val.gestureDetector
    implements android.view.
{

    final SlideShowFragment this$0;
    final GestureDetector val$gestureDetector;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        val$gestureDetector.onTouchEvent(motionevent);
        return false;
    }

    ()
    {
        this$0 = final_slideshowfragment;
        val$gestureDetector = GestureDetector.this;
        super();
    }
}
