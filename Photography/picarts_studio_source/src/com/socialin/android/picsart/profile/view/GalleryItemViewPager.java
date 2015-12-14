// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.view;

import android.content.Context;
import android.graphics.PointF;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.adapter.u;
import com.sonyericsson.zoom.ImageZoomView;
import com.sonyericsson.zoom.b;
import com.sonyericsson.zoom.c;

// Referenced classes of package com.socialin.android.picsart.profile.view:
//            GalleryPagerItemView, b, a

public class GalleryItemViewPager extends ViewPager
{

    private com.socialin.android.picsart.profile.view.b a;
    private android.support.v4.view.ViewPager.OnPageChangeListener b;
    private PointF c;
    private long d;
    private int e;
    private boolean f;

    public GalleryItemViewPager(Context context)
    {
        super(context);
        b = null;
        c = new PointF();
        d = 0L;
        e = 0;
        f = false;
    }

    public GalleryItemViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = null;
        c = new PointF();
        d = 0L;
        e = 0;
        f = false;
    }

    static int a(GalleryItemViewPager galleryitemviewpager, int i)
    {
        galleryitemviewpager.e = i;
        return i;
    }

    static android.support.v4.view.ViewPager.OnPageChangeListener a(GalleryItemViewPager galleryitemviewpager)
    {
        return galleryitemviewpager.b;
    }

    private boolean a(MotionEvent motionevent)
    {
        boolean flag;
        try
        {
            flag = super.onInterceptTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            com.socialin.android.d.b((new StringBuilder("galleryItem-touch: outOfBounds ")).append(motionevent).toString());
            return true;
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            com.socialin.android.d.b((new StringBuilder("galleryItem-touch: illegalArgument ")).append(motionevent).toString());
            return true;
        }
        return flag;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        float f1;
        float f3;
        u u1;
        GalleryPagerItemView gallerypageritemview;
        int i;
        int k;
        u1 = (u)getAdapter();
        if (u1 == null || !(u1.a() instanceof GalleryPagerItemView))
        {
            return super.onInterceptTouchEvent(motionevent);
        }
        gallerypageritemview = (GalleryPagerItemView)u1.a();
        if (gallerypageritemview == null)
        {
            return super.onInterceptTouchEvent(motionevent);
        }
        float f4;
        float f6;
        float f8;
        float f10;
        if (a != null && e != 1 && e != 2)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0) goto _L2; else goto _L1
_L1:
        i = gallerypageritemview.a;
        k = motionevent.getAction() & 0xff;
        f1 = motionevent.getX();
        f3 = motionevent.getY();
        if (k != 0) goto _L4; else goto _L3
_L3:
        c.set(motionevent.getX(), motionevent.getY());
        f4 = c.x;
        f6 = c.x;
        f8 = c.y;
        f10 = c.y;
        if (Math.abs(d - SystemClock.uptimeMillis()) > 350L || i != 4 || (f1 - f4) * (f1 - f6) + (f3 - f8) * (f3 - f10) >= 3600F) goto _L6; else goto _L5
_L5:
        f = true;
        a.a(2, f1, f3);
        i = 1;
_L7:
        if (i != 0)
        {
            return true;
        }
        break; /* Loop/switch isn't completed */
_L6:
        d = SystemClock.uptimeMillis();
_L8:
        i = 0;
        if (true) goto _L7; else goto _L2
_L4:
        if (k == 1)
        {
            float f5 = c.x;
            float f7 = c.x;
            float f9 = c.y;
            float f11 = c.y;
            if (Math.abs(d - SystemClock.uptimeMillis()) <= 175L && (f1 - f5) * (f1 - f7) + (f3 - f9) * (f3 - f11) <= 900F)
            {
                a.a(1, f1, f3);
            }
        }
          goto _L8
_L2:
        if (gallerypageritemview.a != 4)
        {
            return super.onInterceptTouchEvent(motionevent);
        }
        int j = getCurrentItem();
        float f2 = 1.0F;
        int l = motionevent.getAction() & 0xff;
        b b1 = ((ImageZoomView) (gallerypageritemview)).h;
        if (b1 != null)
        {
            f2 = b1.a.a;
        }
        if (j != 0 && j != u1.getCount() - 1 && f2 == 1.0F)
        {
            if (b1 != null)
            {
                b1.update(null, null);
            }
            return super.onInterceptTouchEvent(motionevent);
        }
        if ((l == 5 || gallerypageritemview.c() == 0) && l != 0 && l != 1)
        {
            return false;
        }
        if (l == 0 || l == 1)
        {
            super.onInterceptTouchEvent(motionevent);
            return false;
        }
        l = gallerypageritemview.c();
        if (j == 0 && l == 1 || j == u1.getCount() - 1 && l == 2)
        {
            return false;
        } else
        {
            return a(motionevent);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (f)
        {
            f = false;
            return false;
        }
        boolean flag;
        try
        {
            flag = super.onTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            com.socialin.android.d.b((new StringBuilder("galleryItem-touch")).append(motionevent).toString());
            return false;
        }
        return flag;
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        super.setOnPageChangeListener(new a(this, (byte)0));
        b = onpagechangelistener;
    }

    public void setOnTapListener(com.socialin.android.picsart.profile.view.b b1)
    {
        a = b1;
    }
}
