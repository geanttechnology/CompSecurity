// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fullscreenad;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.fotoable.fullscreenad:
//            FullScreenAdView

class a
    implements android.view.r
{

    final FullScreenAdView a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return true;
    }

    (FullScreenAdView fullscreenadview)
    {
        a = fullscreenadview;
        super();
    }
}
