// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;

// Referenced classes of package com.g.c:
//            z, x, ah

final class aa extends z
{

    private final Context a;

    aa(Context context)
    {
        a = context;
    }

    public final boolean a(x x1)
    {
        if (x1.e != 0)
        {
            return true;
        } else
        {
            return "android.resource".equals(x1.d.getScheme());
        }
    }

    public final z.a b(x x1)
    {
        android.content.res.Resources resources = ah.a(a, x1);
        int i = ah.a(resources, x1);
        android.graphics.BitmapFactory.Options options = d(x1);
        if (a(options))
        {
            BitmapFactory.decodeResource(resources, i, options);
            a(x1.h, x1.i, options, x1);
        }
        return new z.a(BitmapFactory.decodeResource(resources, i, options), u.d.b);
    }
}
