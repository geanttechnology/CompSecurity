// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.mainViewPager;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.pipcamera.activity.mainViewPager:
//            ViewMainPage1

class a
    implements android.view.ener
{

    final ViewMainPage1 a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 57
    //                   1 32
    //                   2 57;
           goto _L1 _L2 _L1 _L2
_L1:
        a.img_collage.getBackground().clearColorFilter();
_L4:
        a.img_collage.invalidate();
        return false;
_L2:
        a.img_collage.getBackground().setColorFilter(0xff888888, android.graphics.MULTIPLY);
        if (true) goto _L4; else goto _L3
_L3:
    }

    (ViewMainPage1 viewmainpage1)
    {
        a = viewmainpage1;
        super();
    }
}
