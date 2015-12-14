// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            CollageTextPainter, b, c

public class CollageTextView extends View
{

    private CollageTextPainter a;
    private b b;
    private c c = new c() {

        final CollageTextView a;

        public void a(long l)
        {
            if (CollageTextView.a(a) != null)
            {
                CollageTextView.a(a).a(l);
                a.postInvalidate();
            }
        }

            
            {
                a = CollageTextView.this;
                super();
            }
    };

    public CollageTextView(Context context)
    {
        super(context);
        a = null;
        a();
    }

    public CollageTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = null;
        a();
    }

    static CollageTextPainter a(CollageTextView collagetextview)
    {
        return collagetextview.a;
    }

    private void a()
    {
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final CollageTextView a;
            private GestureDetector b;

            private void a()
            {
                if (CollageTextView.b(a) != null)
                {
                    CollageTextView.b(a).a(a.getContext());
                }
            }

            static void a(_cls2 _pcls2)
            {
                _pcls2.a();
            }

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (CollageTextView.a(a) != null && CollageTextView.a(a).b().contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    b.onTouchEvent(motionevent);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = CollageTextView.this;
                super();
                b = new GestureDetector(a.getContext(), new _cls1(this));
            }
        });
    }

    static b b(CollageTextView collagetextview)
    {
        return collagetextview.b;
    }

    public b getCollageDatePickerCtrl()
    {
        return b;
    }

    public CollageTextPainter getTextPainter()
    {
        return a;
    }

    protected void onDraw(Canvas canvas)
    {
        if (a != null)
        {
            a.a(canvas);
        }
    }

    public void setCollageDatePickerCtrl(b b1)
    {
        if (b1 != null)
        {
            b1.a(c);
        }
        b = b1;
    }

    public void setTextPainter(CollageTextPainter collagetextpainter)
    {
        a = collagetextpainter;
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/kernelctrl/collageComposer/CollageTextView$2$1

/* anonymous class */
    class _cls1 extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final _cls2 a;

        public boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            _cls2.a(a);
            return true;
        }

            
            {
                a = _pcls2;
                super();
            }
    }

}
