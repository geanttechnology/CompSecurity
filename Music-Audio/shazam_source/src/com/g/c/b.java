// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.util.List;

// Referenced classes of package com.g.c:
//            z, x

final class b extends z
{

    private static final int a = 22;
    private final AssetManager b;

    public b(Context context)
    {
        b = context.getAssets();
    }

    public final boolean a(x x1)
    {
        boolean flag1 = false;
        x1 = x1.d;
        boolean flag = flag1;
        if ("file".equals(x1.getScheme()))
        {
            flag = flag1;
            if (!x1.getPathSegments().isEmpty())
            {
                flag = flag1;
                if ("android_asset".equals(x1.getPathSegments().get(0)))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final z.a b(x x1)
    {
        return new z.a(b.open(x1.d.toString().substring(a)), u.d.b);
    }

}
