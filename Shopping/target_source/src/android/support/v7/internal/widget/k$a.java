// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.c.a.a;

// Referenced classes of package android.support.v7.internal.widget:
//            k

private static class a extends a
{

    private boolean a;

    void a(boolean flag)
    {
        a = flag;
    }

    public void draw(Canvas canvas)
    {
        if (a)
        {
            super.draw(canvas);
        }
    }

    public void setHotspot(float f, float f1)
    {
        if (a)
        {
            super.setHotspot(f, f1);
        }
    }

    public void setHotspotBounds(int i, int j, int l, int i1)
    {
        if (a)
        {
            super.setHotspotBounds(i, j, l, i1);
        }
    }

    public boolean setState(int ai[])
    {
        if (a)
        {
            return super.setState(ai);
        } else
        {
            return false;
        }
    }

    public boolean setVisible(boolean flag, boolean flag1)
    {
        if (a)
        {
            return super.setVisible(flag, flag1);
        } else
        {
            return false;
        }
    }

    public (Drawable drawable)
    {
        super(drawable);
        a = true;
    }
}
