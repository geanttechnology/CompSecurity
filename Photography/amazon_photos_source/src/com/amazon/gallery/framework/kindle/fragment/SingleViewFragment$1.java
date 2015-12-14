// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SingleViewFragment

class ener extends com.amazon.gallery.foundation.touch.or.EnhancedSimpleOnGestureListener
{

    final SingleViewFragment this$0;

    public boolean onTwoFingerTapUp(MotionEvent motionevent)
    {
        getActivity().onBackPressed();
        return true;
    }

    edSimpleOnGestureListener()
    {
        this$0 = SingleViewFragment.this;
        super();
    }
}
