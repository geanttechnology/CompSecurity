// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ColorizedCircleButton extends ImageView
{

    public static final int PRESSED = 2;
    public static final int UNPRESSED = 1;
    private int mColor;
    private final int mGray;
    private Drawable mIcon;
    private int mState;

    public ColorizedCircleButton(Context context)
    {
        this(context, null);
    }

    public ColorizedCircleButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ColorizedCircleButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mGray = getResources().getColor(0x7f090019);
        mColor = mGray;
        mIcon = getDrawable();
    }

    protected void onDraw(Canvas canvas)
    {
        if (isPressed() || mState == 2)
        {
            mIcon.setColorFilter(mColor, android.graphics.PorterDuff.Mode.SRC_ATOP);
        } else
        {
            mIcon.setColorFilter(mGray, android.graphics.PorterDuff.Mode.SRC_ATOP);
        }
        super.onDraw(canvas);
    }

    public void setColor(int i)
    {
        mColor = i;
        invalidate();
    }

    public void setSelected(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        setState(byte0);
        super.setSelected(flag);
    }

    public void setState(int i)
    {
        mState = i;
    }
}
