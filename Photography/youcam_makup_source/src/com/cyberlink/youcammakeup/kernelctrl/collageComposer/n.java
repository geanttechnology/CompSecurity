// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.cyberlink.youcammakeup.j;

public class n extends android.view.ViewGroup.LayoutParams
{

    public int a;
    public int b;
    public int c;
    public Path d;
    public Region e;

    public n(int i, int k, int l, int i1, int j1)
    {
        super(i, k);
        d = null;
        e = null;
        a = l;
        b = i1;
        c = j1;
        Path path = new Path();
        path.addRect(0.0F, 0.0F, i, k, android.graphics.Path.Direction.CCW);
        a(path);
    }

    public n(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = null;
        e = null;
        context = context.obtainStyledAttributes(attributeset, j.CollageLayout_Layout);
        a = context.getDimensionPixelOffset(0, 0);
        b = context.getDimensionPixelOffset(1, 0);
        context.recycle();
        context = new Path();
        context.addRect(0.0F, 0.0F, width, height, android.graphics.Path.Direction.CCW);
        a(context);
    }

    public n(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
        d = null;
        e = null;
        a(((n)layoutparams).a());
    }

    public Path a()
    {
        return d;
    }

    public void a(Path path)
    {
        d = path;
        path = new RectF();
        d.computeBounds(path, true);
        e = new Region();
        e.setPath(d, new Region((int)((RectF) (path)).left, (int)((RectF) (path)).top, (int)((RectF) (path)).right, (int)((RectF) (path)).bottom));
    }

    public boolean a(MotionEvent motionevent)
    {
        if (e == null)
        {
            return true;
        } else
        {
            return e.contains((int)motionevent.getX(), (int)motionevent.getY());
        }
    }
}
