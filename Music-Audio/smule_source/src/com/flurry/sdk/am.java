// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            ai, al, hp, gd

public class am extends ai
{

    private static final String d = com/flurry/sdk/am.getSimpleName();
    protected final al a;
    protected final String b;
    protected al.c c;

    public am(al al1, String s)
    {
        a = al1;
        b = s;
    }

    protected OutputStream f()
    {
        if (c != null)
        {
            return c.a();
        }
        if (a == null)
        {
            throw new IOException("No cache specified");
        }
        if (TextUtils.isEmpty(b))
        {
            throw new IOException("No cache key specified");
        }
        c = a.b(b);
        if (c == null)
        {
            throw new IOException((new StringBuilder()).append("Could not open writer for key: ").append(b).toString());
        } else
        {
            return c.a();
        }
    }

    protected void g()
    {
        hp.a(c);
        c = null;
    }

    protected void h()
    {
        while (a == null || TextUtils.isEmpty(b)) 
        {
            return;
        }
        try
        {
            a.c(b);
            return;
        }
        catch (Exception exception)
        {
            gd.a(3, d, (new StringBuilder()).append("Error removing result for key: ").append(b).append(" -- ").append(exception).toString());
        }
    }

}
