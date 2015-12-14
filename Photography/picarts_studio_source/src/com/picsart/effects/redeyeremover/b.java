// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.redeyeremover;

import android.graphics.PointF;

// Referenced classes of package com.picsart.effects.redeyeremover:
//            a

public final class b
{

    PointF a;
    float b;
    PointF c;

    public b(PointF pointf, float f)
    {
        a = pointf;
        b = f;
        c = new PointF();
        a();
    }

    private void a()
    {
        c.x = a.x + b + com.picsart.effects.redeyeremover.a.a();
        c.y = a.y + b + com.picsart.effects.redeyeremover.a.a();
    }

    public final void a(float f)
    {
        b = f;
        a();
    }

    public final void a(float f, float f1)
    {
        a.x = f;
        a.y = f1;
        a();
    }
}
