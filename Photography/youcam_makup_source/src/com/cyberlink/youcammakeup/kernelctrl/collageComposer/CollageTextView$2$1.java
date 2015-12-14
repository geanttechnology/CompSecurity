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

class a extends android.view.leOnGestureListener
{

    final a a;

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        a(a);
        return true;
    }

    <init>(<init> <init>1)
    {
        a = <init>1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/kernelctrl/collageComposer/CollageTextView$2

/* anonymous class */
    class CollageTextView._cls2
        implements android.view.View.OnTouchListener
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

        static void a(CollageTextView._cls2 _pcls2)
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
                a = collagetextview;
                super();
                b = new GestureDetector(a.getContext(), new CollageTextView._cls2._cls1(this));
            }
    }

}
