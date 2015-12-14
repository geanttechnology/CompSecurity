// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.MotionEvent;
import android.view.View;
import com.fotoable.fotoproedit.activity.stretch.StretchNewImageView;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditNewStretchActivity

class a
    implements android.view.NewStretchActivity._cls2
{

    final ProEditNewStretchActivity a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() != 0) goto _L2; else goto _L1
_L1:
        if (a.a != null)
        {
            a.a.showPreImage();
        }
_L4:
        return false;
_L2:
        if ((motionevent.getAction() == 1 || motionevent.getAction() == 3) && a.a != null)
        {
            a.a.hidePreImage();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (ProEditNewStretchActivity proeditnewstretchactivity)
    {
        a = proeditnewstretchactivity;
        super();
    }
}
