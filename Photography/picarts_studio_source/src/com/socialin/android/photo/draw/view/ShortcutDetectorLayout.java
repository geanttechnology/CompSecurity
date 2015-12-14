// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.melnykov.fab.a;
import com.socialin.android.util.l;

public class ShortcutDetectorLayout extends FrameLayout
    implements android.view.GestureDetector.OnDoubleTapListener
{

    private GestureDetector a;
    private a b;
    private float c;

    public ShortcutDetectorLayout(Context context)
    {
        super(context);
        a();
    }

    public ShortcutDetectorLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ShortcutDetectorLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        a = new GestureDetector(getContext(), new android.view.GestureDetector.SimpleOnGestureListener());
        a.setOnDoubleTapListener(this);
        c = getResources().getDisplayMetrics().density;
    }

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        if (b == null)
        {
            return false;
        }
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        if (l.a(0.0F, 0.0F, f, f1) / c < 100F)
        {
            motionevent = Shortcut.TOP_LEFT;
            return false;
        }
        if (l.a(getWidth(), 0.0F, f, f1) / c < 100F)
        {
            motionevent = Shortcut.TOP_RIGHT;
            return false;
        }
        if (l.a(0.0F, getHeight(), f, f1) / c < 100F)
        {
            motionevent = Shortcut.BOTTOM_LEFT;
            return false;
        }
        if (l.a(getWidth(), getHeight(), f, f1) / c < 100F)
        {
            motionevent = Shortcut.BOTTOM_RIGHT;
            return false;
        } else
        {
            motionevent = Shortcut.CENTER;
            return false;
        }
    }

    public boolean onDoubleTapEvent(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        a.onTouchEvent(motionevent);
        return super.onInterceptTouchEvent(motionevent);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        return false;
    }

    public void setOnShortcutListener$7ee1778(a a1)
    {
        b = a1;
    }

    private class Shortcut extends Enum
    {

        private static final Shortcut $VALUES[];
        public static final Shortcut BOTTOM_LEFT;
        public static final Shortcut BOTTOM_RIGHT;
        public static final Shortcut CENTER;
        public static final Shortcut TOP_LEFT;
        public static final Shortcut TOP_RIGHT;

        public static Shortcut valueOf(String s)
        {
            return (Shortcut)Enum.valueOf(com/socialin/android/photo/draw/view/ShortcutDetectorLayout$Shortcut, s);
        }

        public static Shortcut[] values()
        {
            return (Shortcut[])$VALUES.clone();
        }

        static 
        {
            TOP_LEFT = new Shortcut("TOP_LEFT", 0);
            TOP_RIGHT = new Shortcut("TOP_RIGHT", 1);
            BOTTOM_LEFT = new Shortcut("BOTTOM_LEFT", 2);
            BOTTOM_RIGHT = new Shortcut("BOTTOM_RIGHT", 3);
            CENTER = new Shortcut("CENTER", 4);
            $VALUES = (new Shortcut[] {
                TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, CENTER
            });
        }

        private Shortcut(String s, int i)
        {
            super(s, i);
        }
    }

}
