// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import com.fotoable.fullscreenad.FullScreenAdView;

public class aof
    implements android.view.View.OnTouchListener
{

    final FullScreenAdView a;

    public aof(FullScreenAdView fullscreenadview)
    {
        a = fullscreenadview;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0 || motionevent.getAction() == 2)
        {
            FullScreenAdView.access$000(a).setBackgroundColor(0x33000000);
            return false;
        } else
        {
            FullScreenAdView.access$000(a).setBackgroundColor(0);
            return false;
        }
    }
}
