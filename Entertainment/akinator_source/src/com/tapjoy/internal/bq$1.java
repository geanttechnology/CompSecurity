// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.graphics.Point;

// Referenced classes of package com.tapjoy.internal:
//            bp, bq, bu

static final class 
    implements bp
{

    public final Object a(bu bu1)
    {
        Point point = new Point();
        bu1.i();
        while (bu1.k()) 
        {
            String s = bu1.m();
            if ("x".equals(s))
            {
                point.x = bu1.s();
            } else
            if ("y".equals(s))
            {
                point.y = bu1.s();
            } else
            {
                bu1.t();
            }
        }
        bu1.j();
        return point;
    }

    ()
    {
    }
}
