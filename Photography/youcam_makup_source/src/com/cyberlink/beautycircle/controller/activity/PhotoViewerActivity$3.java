// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PhotoViewerActivity

class a extends android.view.OnGestureListener
{

    final PhotoViewerActivity a;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        PhotoViewerActivity.a(a, (UICImageView)PhotoViewerActivity.h(a), motionevent.getX(), motionevent.getY());
        return true;
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return true;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        float f4 = (f * 0.2F) / 2.0F;
        float f3 = (0.2F * f1) / 2.0F;
        float f2 = f4;
        if ((motionevent.getX() - motionevent1.getX()) * f < 0.0F)
        {
            f2 = f4 * -1F;
        }
        f = f3;
        if ((motionevent.getY() - motionevent1.getY()) * f1 < 0.0F)
        {
            f = f3 * -1F;
        }
        PhotoViewerActivity.a(a, f2, f);
        return true;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        PhotoViewerActivity.b(a, (UICImageView)PhotoViewerActivity.h(a), f, f1);
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        int i = PhotoViewerActivity.b(a).getVisibility();
        if (i == 0 || i == 8)
        {
            PhotoViewerActivity.b(a).setVisibility(4);
            PhotoViewerActivity.g(a).setVisibility(4);
        } else
        {
            PhotoViewerActivity.b(a).setVisibility(0);
            PhotoViewerActivity.g(a).setVisibility(0);
        }
        return true;
    }

    (PhotoViewerActivity photovieweractivity)
    {
        a = photovieweractivity;
        super();
    }
}
