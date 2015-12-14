// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import com.fotoable.fotoproedit.activity.ProEditNewStretchActivity;
import com.fotoable.fotoproedit.activity.stretch.StretchNewImageView;

public class aib
    implements android.view.View.OnTouchListener
{

    final ProEditNewStretchActivity a;

    public aib(ProEditNewStretchActivity proeditnewstretchactivity)
    {
        a = proeditnewstretchactivity;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        a.g = true;
        if (motionevent.getAction() == 1)
        {
            a.a.resstProcessImage();
        }
        return false;
    }
}
