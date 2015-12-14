// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.input.gesture;

import android.graphics.PointF;

// Referenced classes of package com.socialin.android.brushlib.input.gesture:
//            e, f

final class a
    implements Runnable
{

    private e a;

    public final void run()
    {
        if (e.a(a) != null)
        {
            e.a(a).a(e.b(a).x, e.b(a).y);
        }
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
