// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            CollageTextView, b, CollageTextPainter

class _cls1.a
    implements android.view.er
{

    final CollageTextView a;
    private GestureDetector b;

    private void a()
    {
        if (CollageTextView.b(a) != null)
        {
            CollageTextView.b(a).a(a.getContext());
        }
    }

    static void a(tContext tcontext)
    {
        tcontext.a();
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

    _cls1.a(CollageTextView collagetextview)
    {
        a = collagetextview;
        super();
        b = new GestureDetector(a.getContext(), new android.view.GestureDetector.SimpleOnGestureListener() {

            final CollageTextView._cls2 a;

            public boolean onSingleTapConfirmed(MotionEvent motionevent)
            {
                CollageTextView._cls2.a(a);
                return true;
            }

            
            {
                a = CollageTextView._cls2.this;
                super();
            }
        });
    }
}
