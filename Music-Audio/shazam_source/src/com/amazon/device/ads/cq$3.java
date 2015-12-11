// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.amazon.device.ads:
//            cq

final class b
    implements android.view.OnTouchListener
{

    final BitmapDrawable a;
    final BitmapDrawable b;
    final cq c;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        BitmapDrawable bitmapdrawable;
        BitmapDrawable bitmapdrawable1;
        view = c;
        bitmapdrawable = a;
        bitmapdrawable1 = b;
        motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 44
    //                   0 46
    //                   1 58;
           goto _L1 _L2 _L3
_L1:
        return false;
_L2:
        ((cq) (view)).a.setImageDrawable(bitmapdrawable1);
        continue; /* Loop/switch isn't completed */
_L3:
        ((cq) (view)).a.setImageDrawable(bitmapdrawable);
        if (true) goto _L1; else goto _L4
_L4:
    }

    itmapDrawable(cq cq1, BitmapDrawable bitmapdrawable, BitmapDrawable bitmapdrawable1)
    {
        c = cq1;
        a = bitmapdrawable;
        b = bitmapdrawable1;
        super();
    }
}
