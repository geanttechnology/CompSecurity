// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.shape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.brush.c;
import com.socialin.android.brushlib.overlay.ArrowOverlay;
import com.socialin.android.brushlib.overlay.LineOverlay;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.overlay.ShapeOverlay;
import com.socialin.android.brushlib.svg.ShapeParams;
import com.socialin.android.brushlib.svg.b;

// Referenced classes of package com.socialin.android.photo.draw.shape:
//            b

public class ShapePreview extends View
{

    private RectF a;
    private Overlay b;
    private final PointF c = new PointF();
    private final PointF d = new PointF();
    private com.socialin.android.photo.draw.shape.b e;

    public ShapePreview(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        new RectF();
        new RectF();
        com.socialin.android.brushlib.brush.c.g();
        (new b()).a();
        new Matrix();
        a = new RectF();
        setLayerType(1, null);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        float f;
        float f1;
        int i;
        if (e != null)
        {
            if (b instanceof ShapeOverlay)
            {
                ((ShapeOverlay)b).setParams(e.a());
            } else
            if (b instanceof LineOverlay)
            {
                ((LineOverlay)b).setParams(e.a());
            }
        }
        i = e.a().getColor();
        f = (float)Color.red(i) / 255F;
        f1 = (float)Color.green(i) / 255F;
        if (((float)Color.blue(i) / 255F + (f + f1)) / 3F > 0.8F)
        {
            i = 0xff252525;
        } else
        {
            i = -1;
        }
        if (i != -1)
        {
            canvas.drawColor(0xff252525);
        }
        b.draw(canvas);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
label0:
        {
            super.onSizeChanged(i, j, k, l);
            a.set((float)i / 8F, (float)j / 8F, (float)(i * 7) / 8F, (float)(j * 7) / 8F);
            c.set(a.left, a.bottom);
            d.set(a.right, a.top);
            if (b != null)
            {
                if (!(b instanceof LineOverlay))
                {
                    break label0;
                }
                ((LineOverlay)b).setStartPoint(a.left, a.bottom);
                ((LineOverlay)b).setEndPoint(a.right, a.top);
            }
            return;
        }
        Transform transform = b.getTransform();
        transform.setPosition(a.centerX(), a.centerY());
        float f = Math.min(a.width(), a.height());
        if (b.getOrigWidth() < b.getOrigHeight())
        {
            f /= b.getOrigHeight();
        } else
        {
            f /= b.getOrigWidth();
        }
        transform.setScale(f);
    }

    public void setParamsProvider(com.socialin.android.photo.draw.shape.b b1)
    {
        e = b1;
    }

    public void setShape(String s)
    {
        if ("line".equals(s))
        {
            b = new LineOverlay();
            ((LineOverlay)b).setStartPoint(a.left, a.bottom);
            ((LineOverlay)b).setEndPoint(a.right, a.top);
            return;
        }
        if ("arrow".equals(s))
        {
            b = new ArrowOverlay();
            ((LineOverlay)b).setStartPoint(a.left, a.bottom);
            ((LineOverlay)b).setEndPoint(a.right, a.top);
            return;
        }
        b = new ShapeOverlay(s);
        s = b.getTransform();
        s.setPosition(a.centerX(), a.centerY());
        float f = Math.min(a.width(), a.height());
        if (b.getOrigWidth() < b.getOrigHeight())
        {
            f /= b.getOrigHeight();
        } else
        {
            f /= b.getOrigWidth();
        }
        s.setScale(f);
    }
}
