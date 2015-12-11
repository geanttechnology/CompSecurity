// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;

public class ColoredOvalDrawable extends ShapeDrawable
{
    public class ColoredOvalShape extends OvalShape
    {

        final ColoredOvalDrawable this$0;

        public void draw(Canvas canvas, Paint paint)
        {
            paint.setColor(mColor);
            super.draw(canvas, paint);
        }

        public ColoredOvalShape()
        {
            this$0 = ColoredOvalDrawable.this;
            super();
        }
    }


    public int mColor;

    public ColoredOvalDrawable()
    {
        setShape(new ColoredOvalShape());
    }

    public void setColor(int i)
    {
        mColor = i;
    }
}
