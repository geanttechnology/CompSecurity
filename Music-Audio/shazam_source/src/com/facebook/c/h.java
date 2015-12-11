// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.c;

import android.os.Handler;
import android.view.Choreographer;

// Referenced classes of package com.facebook.c:
//            b, g

public final class h extends b
{

    private h(g g)
    {
        super(g);
    }

    public static h b()
    {
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            obj = new a.a(Choreographer.getInstance());
        } else
        {
            obj = new a.b(new Handler());
        }
        return new h(((g) (obj)));
    }
}
