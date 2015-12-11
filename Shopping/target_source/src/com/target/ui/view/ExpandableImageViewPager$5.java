// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.view.MotionEvent;

// Referenced classes of package com.target.ui.view:
//            ExpandableImageViewPager

class stener extends android.view.tureListener
{

    final ExpandableImageViewPager this$0;

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        ExpandableImageViewPager.a(ExpandableImageViewPager.this, Float.valueOf(f), true);
        return true;
    }

    stener()
    {
        this$0 = ExpandableImageViewPager.this;
        super();
    }
}
