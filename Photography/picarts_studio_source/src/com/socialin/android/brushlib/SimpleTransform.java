// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib;


// Referenced classes of package com.socialin.android.brushlib:
//            Transform

public class SimpleTransform extends Transform
{

    private static final long serialVersionUID = 1L;
    private float cx;
    private float cy;
    private float rotation;
    private float sx;
    private float sy;

    protected SimpleTransform(float f, float f1, float f2, float f3, float f4)
    {
        setPosition(f, f1);
        setScale(f2, f3);
        setRotation(f4);
    }

    public SimpleTransform clone()
    {
        return new SimpleTransform(cx, cy, sx, sy, rotation);
    }

    public volatile Transform clone()
    {
        return clone();
    }

    public volatile Object clone()
    {
        return clone();
    }

    public float getCx()
    {
        return cx;
    }

    public float getCy()
    {
        return cy;
    }

    public float getRotation()
    {
        return rotation;
    }

    public float getSx()
    {
        return sx;
    }

    public float getSy()
    {
        return sy;
    }

    public SimpleTransform setCx(float f)
    {
        cx = f;
        return this;
    }

    public volatile Transform setCx(float f)
    {
        return setCx(f);
    }

    public SimpleTransform setCy(float f)
    {
        cy = f;
        return this;
    }

    public volatile Transform setCy(float f)
    {
        return setCy(f);
    }

    public SimpleTransform setRotation(float f)
    {
        rotation = f;
        return this;
    }

    public volatile Transform setRotation(float f)
    {
        return setRotation(f);
    }

    public SimpleTransform setSx(float f)
    {
        sx = f;
        return this;
    }

    public volatile Transform setSx(float f)
    {
        return setSx(f);
    }

    public SimpleTransform setSy(float f)
    {
        sy = f;
        return this;
    }

    public volatile Transform setSy(float f)
    {
        return setSy(f);
    }
}
