// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mdot;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.bestbuy.android.activities.mdot:
//            MdotWebFragment

class a
    implements android.view.er
{

    final MdotWebFragment a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 34
    //                   1 61
    //                   2 48;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L2:
        MdotWebFragment.a(a, motionevent.getY());
        return false;
_L4:
        MdotWebFragment.a(a).setVisibility(0);
        return false;
_L3:
        MdotWebFragment.b(a, motionevent.getY());
        motionevent = a;
        boolean flag;
        if (MdotWebFragment.b(a) - MdotWebFragment.c(a) > 300F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        MdotWebFragment.a(motionevent, flag);
        if (!view.hasFocus())
        {
            view.requestFocus();
            return false;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    (MdotWebFragment mdotwebfragment)
    {
        a = mdotwebfragment;
        super();
    }
}
