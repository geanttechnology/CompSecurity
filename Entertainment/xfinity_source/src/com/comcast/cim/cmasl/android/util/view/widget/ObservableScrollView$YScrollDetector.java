// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.view.MotionEvent;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            ObservableScrollView

class this._cls0 extends android.view.er
{

    final ObservableScrollView this$0;

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        boolean flag = false;
        try
        {
            f1 = Math.abs(f1);
            f = Math.abs(f);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            return false;
        }
        if (f1 > f)
        {
            flag = true;
        }
        return flag;
    }

    Y()
    {
        this$0 = ObservableScrollView.this;
        super();
    }
}
