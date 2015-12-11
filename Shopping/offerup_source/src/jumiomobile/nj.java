// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;

// Referenced classes of package jumiomobile:
//            mt, np

public abstract class nj extends View
    implements mt
{

    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected np n;
    protected np o;
    protected np p;
    protected np q;
    protected int r;
    protected int s;
    protected boolean t;

    public nj(Context context)
    {
        super(context);
        h = 0;
        i = 0;
        j = 0;
        k = 0;
        l = 0;
        m = 0;
        n = null;
        o = null;
        p = null;
        q = null;
        r = 0;
        s = 0;
    }

    public void a(boolean flag)
    {
    }

    public int getOverlayHeight()
    {
        return m - j - k;
    }

    public int getOverlayLeft()
    {
        return s + h;
    }

    public int getOverlayTop()
    {
        return r + j;
    }

    public int getOverlayWidth()
    {
        return l - h - i;
    }

    public abstract int getROIXOffset();

    public RectF getRoiPosition()
    {
        return new RectF(h, j, (s + l) - i, (r + m) - k);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }

    public void setIsFrontCam(boolean flag)
    {
        t = flag;
        invalidate();
    }
}
