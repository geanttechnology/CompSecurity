// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.applovin.impl.adview:
//            o

class p
    implements android.view.View.OnTouchListener
{

    final o a;

    p(o o)
    {
        a = o;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag;
        if (motionevent.getAction() == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return true;
        }
        if (!view.hasFocus())
        {
            view.requestFocus();
        }
        return false;
    }
}
