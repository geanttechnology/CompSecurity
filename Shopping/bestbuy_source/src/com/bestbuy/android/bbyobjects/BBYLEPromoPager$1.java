// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

// Referenced classes of package com.bestbuy.android.bbyobjects:
//            BBYLEPromoPager

class a
    implements android.view.er
{

    final ScrollView a;
    final BBYLEPromoPager b;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 2 && a != null)
        {
            a.requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }

    (BBYLEPromoPager bbylepromopager, ScrollView scrollview)
    {
        b = bbylepromopager;
        a = scrollview;
        super();
    }
}
