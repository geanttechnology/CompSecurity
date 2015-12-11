// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

// Referenced classes of package com.g.c:
//            z, x

class g extends z
{

    final Context a;

    g(Context context)
    {
        a = context;
    }

    public boolean a(x x1)
    {
        return "content".equals(x1.d.getScheme());
    }

    public z.a b(x x1)
    {
        return new z.a(c(x1), u.d.b);
    }

    final InputStream c(x x1)
    {
        return a.getContentResolver().openInputStream(x1.d);
    }
}
