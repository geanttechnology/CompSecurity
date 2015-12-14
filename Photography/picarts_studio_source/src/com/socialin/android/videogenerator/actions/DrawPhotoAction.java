// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.socialin.android.brushlib.Transform;
import java.util.UUID;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action

public class DrawPhotoAction extends Action
{

    private static final long serialVersionUID = 0xbc8cfe3f62537668L;
    private Bitmap bitmap;
    private UUID layerId;
    private Paint paint;
    private Transform transform;

    public DrawPhotoAction(Transform transform1, Bitmap bitmap1, UUID uuid, Paint paint1, String s)
    {
        super(s);
        transform = transform1;
        bitmap = bitmap1;
        layerId = uuid;
        paint = paint1;
    }

    public void apply(a a1)
    {
        a1 = a1.a(getLayerId()).b();
        transform.saveAndApply(a1);
        a1.drawBitmap(getBitmap(), 0.0F, 0.0F, getPaint());
        a1.restore();
    }

    public void apply(a a1, int i)
    {
        a1 = a1.a(getLayerId()).b();
        transform.setSx((float)i * transform.getSx());
        transform.setSy((float)i * transform.getSy());
        transform.saveAndApply(a1);
        a1.drawBitmap(getBitmap(), 0.0F, 0.0F, getPaint());
        a1.restore();
    }

    public String getActionDescription()
    {
        return null;
    }

    public Bitmap getBitmap()
    {
        return bitmap;
    }

    public UUID getLayerId()
    {
        return layerId;
    }

    public Paint getPaint()
    {
        return paint;
    }

    public Transform getTransform()
    {
        return transform;
    }

    public void setBitmap(Bitmap bitmap1)
    {
        bitmap = bitmap1;
    }

    public void setLayerId(UUID uuid)
    {
        layerId = uuid;
    }

    public void setPaint(Paint paint1)
    {
        paint = paint1;
    }

    public void setTransform(Transform transform1)
    {
        transform = transform1;
    }
}
