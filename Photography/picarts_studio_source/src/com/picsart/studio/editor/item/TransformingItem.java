// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.os.Parcel;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.SimpleTransform;
import com.picsart.studio.editor.g;
import com.picsart.studio.editor.h;

// Referenced classes of package com.picsart.studio.editor.item:
//            Item

public abstract class TransformingItem extends Item
    implements h
{

    protected SimpleTransform q;
    protected PointF r;

    protected TransformingItem()
    {
        r = new PointF();
        q = SimpleTransform.f();
        q.c = this;
    }

    protected TransformingItem(Parcel parcel)
    {
        super(parcel);
        r = new PointF();
        q = (SimpleTransform)parcel.readParcelable(com/picsart/studio/editor/SimpleTransform.getClassLoader());
        q.c = this;
    }

    public final g a(Camera camera)
    {
        return SimpleTransform.a(q, camera);
    }

    public final void a()
    {
        o();
    }

    public void a(Canvas canvas)
    {
        canvas.save();
        q.a(canvas);
        canvas.translate(-i() / 2.0F, -j() / 2.0F);
        b(canvas);
        canvas.restore();
    }

    public final boolean a(Camera camera, float f, float f1)
    {
        r.set(f, f1);
        camera = q;
        PointF pointf = r;
        camera.a(pointf, pointf);
        return Math.abs(r.x) <= i() / 2.0F && Math.abs(r.y) <= j() / 2.0F;
    }

    public final float b(Camera camera)
    {
        return i() * a(camera).c();
    }

    public abstract void b(Canvas canvas);

    public final float c(Camera camera)
    {
        return j() * a(camera).d();
    }

    public abstract float i();

    public abstract float j();

    public final g r()
    {
        return q;
    }

    public final float s()
    {
        return i() * q.a;
    }

    public final float t()
    {
        return j() * q.b;
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        super.writeToParcel(parcel, k);
        parcel.writeParcelable(q, k);
    }
}
