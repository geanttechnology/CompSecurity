// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import com.fotoable.fullscreenad.FullScreenAdView;

public class aoi
    implements android.view.View.OnTouchListener
{

    final FullScreenAdView a;

    public aoi(FullScreenAdView fullscreenadview)
    {
        a = fullscreenadview;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return true;
    }
}
