// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.generic;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;

// Referenced classes of package com.facebook.drawee.generic:
//            GenericDraweeHierarchy

public static class  extends ForwardingDrawable
    implements VisibilityAwareDrawable
{

    private VisibilityCallback mVisibilityCallback;

    public void draw(Canvas canvas)
    {
        if (!isVisible())
        {
            return;
        }
        if (mVisibilityCallback != null)
        {
            mVisibilityCallback.onDraw();
        }
        super.draw(canvas);
    }

    public int getIntrinsicHeight()
    {
        return -1;
    }

    public int getIntrinsicWidth()
    {
        return -1;
    }

    public void setVisibilityCallback(VisibilityCallback visibilitycallback)
    {
        mVisibilityCallback = visibilitycallback;
    }

    public boolean setVisible(boolean flag, boolean flag1)
    {
        if (mVisibilityCallback != null)
        {
            mVisibilityCallback.onVisibilityChange(flag);
        }
        return super.setVisible(flag, flag1);
    }

    public (Drawable drawable)
    {
        super(drawable);
    }
}
