// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.ActionBarContainer;

public class by extends Drawable
{

    final ActionBarContainer a;

    public by(ActionBarContainer actionbarcontainer)
    {
        a = actionbarcontainer;
    }

    public void draw(Canvas canvas)
    {
        if (a.mIsSplit)
        {
            if (a.mSplitBackground != null)
            {
                a.mSplitBackground.draw(canvas);
            }
        } else
        {
            if (a.mBackground != null)
            {
                a.mBackground.draw(canvas);
            }
            if (a.mStackedBackground != null && a.mIsStacked)
            {
                a.mStackedBackground.draw(canvas);
                return;
            }
        }
    }

    public int getOpacity()
    {
        return 0;
    }

    public void setAlpha(int i)
    {
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }
}
