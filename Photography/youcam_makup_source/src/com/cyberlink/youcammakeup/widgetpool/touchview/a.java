// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.touchview;

import android.view.MotionEvent;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.touchview:
//            e

public class a extends e
{

    protected a(MotionEvent motionevent)
    {
        super(motionevent);
    }

    public float a(int i)
    {
        return a.getX(i);
    }

    public float b(int i)
    {
        return a.getY(i);
    }
}
