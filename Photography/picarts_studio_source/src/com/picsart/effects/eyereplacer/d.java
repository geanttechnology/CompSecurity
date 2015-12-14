// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.eyereplacer;

import android.graphics.PointF;

// Referenced classes of package com.picsart.effects.eyereplacer:
//            c

public final class d
{

    PointF a;
    float b;
    PointF c;

    public d(PointF pointf)
    {
        a = pointf;
        b = 25F;
        c = new PointF();
        a();
    }

    final void a()
    {
        c.x = a.x + b + com.picsart.effects.eyereplacer.c.b();
        c.y = a.y + b + com.picsart.effects.eyereplacer.c.b();
    }

    public final void a(float f)
    {
        b = f;
        a();
    }
}
