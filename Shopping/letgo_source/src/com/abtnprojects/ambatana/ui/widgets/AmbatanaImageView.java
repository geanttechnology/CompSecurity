// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

public class AmbatanaImageView extends ImageView
{

    private ScaleGestureDetector a;
    private float b;
    private Matrix c;

    public AmbatanaImageView(Context context)
    {
        super(context);
        b = 1.0F;
        c = new Matrix();
        a(context);
    }

    public AmbatanaImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AmbatanaImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = 1.0F;
        c = new Matrix();
        a(context);
    }

    private void a(Context context)
    {
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (a != null)
        {
            a.onTouchEvent(motionevent);
        }
        return true;
    }
}
