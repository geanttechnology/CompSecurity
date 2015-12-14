// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.overlay;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import com.socialin.android.NoProGuard;
import com.socialin.android.brushlib.SimpleTransform;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.view.Camera;
import java.io.Serializable;

public abstract class Overlay
    implements NoProGuard, Serializable, Cloneable
{

    private static final long serialVersionUID = 0x37610218dfe16fa1L;
    private transient PointF tempPointF;
    private final Transform transform = SimpleTransform.createDefault();

    public Overlay()
    {
        tempPointF = new PointF();
    }

    public boolean contains(float f, float f1)
    {
        tempPointF.set(f, f1);
        transform.reverseMapPoint(tempPointF);
        return Math.abs(tempPointF.x) <= getOrigWidth() / 2.0F && Math.abs(tempPointF.y) <= getOrigHeight() / 2.0F;
    }

    public void draw(Canvas canvas)
    {
        canvas.save();
        transform.apply(canvas);
        canvas.translate(-getOrigWidth() / 2.0F, -getOrigHeight() / 2.0F);
        drawWithoutTransform(canvas);
        canvas.restore();
    }

    protected abstract void drawWithoutTransform(Canvas canvas);

    public abstract a getController$442001be();

    public abstract float getOrigHeight();

    public abstract float getOrigWidth();

    public final Transform getTransform()
    {
        return transform;
    }

    public abstract RectF getTransformedBounds(boolean flag);

    public final Transform getViewportTransform(Camera camera)
    {
        return SimpleTransform.createMapped(transform, camera);
    }

    public final void setSizeInViewport(float f, Camera camera)
    {
        if (getOrigWidth() < getOrigHeight())
        {
            f /= getOrigHeight();
        } else
        {
            f /= getOrigWidth();
        }
        getViewportTransform(camera).setScale(f);
    }
}
