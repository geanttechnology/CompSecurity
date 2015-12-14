// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer;
import com.pf.common.utility.m;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            w, CollageLayout, y

class z
    implements android.view.View.OnTouchListener
{

    final w a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;

    z(w w1)
    {
        a = w1;
        super();
        b = false;
        c = false;
    }

    private View a(View view, MotionEvent motionevent)
    {
        motionevent = MotionEvent.obtain(motionevent);
        motionevent.offsetLocation(view.getLeft() - w.b(a).getScrollX(), view.getTop() - w.b(a).getScrollY());
        view = w.b(a).a(motionevent);
        motionevent.recycle();
        m.e(w.c(a), (new StringBuilder()).append("getViewFromPoint, view = ").append(view).toString());
        return view;
    }

    private void a()
    {
        if (w.a(a) != null && w.a(a).getVisibility() == 0)
        {
            w.a(a).setVisibility(4);
        }
    }

    private void a(View view)
    {
        w.a(a, view);
    }

    private void b()
    {
        if (w.a(a) != null && w.a(a).getVisibility() == 4)
        {
            w.a(a).setVisibility(0);
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (w.d(a) == null || w.d(a) == view) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 5: default 64
    //                   0 73
    //                   1 544
    //                   2 430
    //                   3 665
    //                   4 64
    //                   5 402;
           goto _L3 _L4 _L5 _L6 _L7 _L3 _L8
_L3:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_665;
_L9:
        if (c)
        {
            return false;
        }
          goto _L1
_L4:
        m.e(w.c(a), (new StringBuilder()).append("ACTION_DOWN, imageID = ").append(((y)w.e(a).get(Integer.valueOf(view.hashCode()))).b).toString());
        a(view);
        motionevent = a(view, motionevent);
        boolean flag;
        if (motionevent != null && motionevent == view)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        if (c)
        {
            if (w.a(a) != null)
            {
                view = ((y)w.e(a).get(Integer.valueOf(view.hashCode()))).c;
                view.setAlpha(240);
                w.a(a).setImageDrawable(view);
                w.a(a).setX(0.0F);
                w.a(a).setY(0.0F);
                if (w.f(a) == null)
                {
                    w.a(a, new int[2]);
                    w.a(a).getLocationInWindow(w.f(a));
                    m.e(w.c(a), (new StringBuilder()).append("mThumbnailOffsets[0] = ").append(w.f(a)[0]).append(", mThumbnailOffsets[1] = ").append(w.f(a)[1]).toString());
                }
                if (view.getBitmap() != null)
                {
                    d = w.f(a)[0] + view.getBitmap().getWidth() / 2;
                    int i = w.f(a)[1];
                    e = view.getBitmap().getHeight() / 2 + i;
                }
            }
            b = false;
        }
          goto _L9
_L8:
        m.e(w.c(a), "ACTION_POINTER_DOWN");
        if (c)
        {
            b = true;
        }
          goto _L9
_L6:
        if (c)
        {
label0:
            {
                if (b || motionevent.getPointerCount() != 1)
                {
                    break MISSING_BLOCK_LABEL_537;
                }
                view = a(view, motionevent);
                if (view == null || view != w.d(a))
                {
                    break label0;
                }
                a();
            }
        }
          goto _L9
        b();
        if (w.a(a) != null)
        {
            w.a(a).setX(motionevent.getRawX() - (float)d);
            w.a(a).setY(motionevent.getRawY() - (float)e);
            return true;
        }
          goto _L1
        a();
          goto _L9
_L5:
        m.e(w.c(a), "ACTION_UP");
        a(null);
        if (c)
        {
            a();
            if (!b && motionevent.getPointerCount() == 1)
            {
                motionevent = a(view, motionevent);
                if (motionevent != view && (motionevent instanceof PanZoomViewer))
                {
                    view = (y)w.e(a).get(Integer.valueOf(view.hashCode()));
                    motionevent = (y)w.e(a).get(Integer.valueOf(motionevent.hashCode()));
                    w.a(a, view, motionevent);
                }
            }
        }
          goto _L9
        m.e(w.c(a), "ACTION_CANCEL");
        a(null);
        if (c)
        {
            a();
        }
          goto _L9
    }
}
