// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundedCornerImageView extends ImageView
{

    private float a;
    private Path b;
    private RectF c;

    public RoundedCornerImageView(Context context)
    {
        this(context, null);
    }

    public RoundedCornerImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RoundedCornerImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = 10F;
        if (attributeset == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        context = context.obtainStyledAttributes(attributeset, new int[] {
            0x7f010002
        });
        a = context.getDimension(0, 6F);
        context.recycle();
        b = new Path();
        c = new RectF();
        if (android.os.Build.VERSION.SDK_INT < 18 && 1 != getLayerType())
        {
            setLayerType(1, null);
        }
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    protected void onDraw(Canvas canvas)
    {
        b.reset();
        c.set(0.0F, 0.0F, getWidth(), getHeight());
        b.addRoundRect(c, a, a, android.graphics.Path.Direction.CW);
        canvas.clipPath(b);
        super.onDraw(canvas);
    }
}
