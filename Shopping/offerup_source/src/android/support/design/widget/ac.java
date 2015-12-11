// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package android.support.design.widget:
//            aa, an

abstract class ac extends Animation
{

    private float a;
    private float b;
    private aa c;

    private ac(aa aa1)
    {
        c = aa1;
        super();
    }

    ac(aa aa1, byte byte0)
    {
        this(aa1);
    }

    protected abstract float a();

    protected void applyTransformation(float f, Transformation transformation)
    {
        transformation = c.a;
        transformation.a(a + b * f, ((an) (transformation)).a);
    }

    public void reset()
    {
        super.reset();
        a = c.a.b;
        b = a() - a;
    }
}
