// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils.do.do;

import android.content.Context;

// Referenced classes of package io.presage.utils.do.do:
//            d, b, c

public final class f
{

    private static f a = null;

    private f()
    {
    }

    public static c a(Context context, b b)
    {
        return new d(context, b);
    }

    public static f a()
    {
        if (a == null)
        {
            a = new f();
        }
        return a;
    }

}
