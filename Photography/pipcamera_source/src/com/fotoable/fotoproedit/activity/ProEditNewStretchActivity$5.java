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
    implements android.view.NewStretchActivity._cls5
{

    final ProEditNewStretchActivity a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        a.h = true;
        if (motionevent.getAction() == 1)
        {
            a.a.resstProcessImage();
        }
        return false;
    }

    (ProEditNewStretchActivity proeditnewstretchactivity)
    {
        a = proeditnewstretchactivity;
        super();
    }
}
