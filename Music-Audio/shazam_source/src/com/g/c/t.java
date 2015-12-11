// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.content.Context;
import android.net.Uri;
import com.g.b.c;
import com.g.b.d;
import com.g.b.e;
import com.g.b.s;
import com.g.b.x;
import com.g.b.y;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.g.c:
//            j, ah, r

public final class t
    implements j
{

    private final s a;

    public t(Context context)
    {
        this(ah.b(context));
    }

    private t(s s1)
    {
        a = s1;
    }

    private t(File file)
    {
        this(file, ah.a(file));
    }

    private t(File file, long l)
    {
        s s1 = new s();
        s1.a(15000L, TimeUnit.MILLISECONDS);
        s1.b(20000L, TimeUnit.MILLISECONDS);
        s1.a(TimeUnit.MILLISECONDS);
        this(s1);
        try
        {
            a.a(new c(file, l));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return;
        }
    }

    public final j.a a(Uri uri, int i)
    {
        Object obj = null;
        int k;
        if (i != 0)
        {
            if (com.g.c.r.c(i))
            {
                obj = d.b;
            } else
            {
                obj = new com.g.b.d.a();
                if (!r.a(i))
                {
                    ((com.g.b.d.a) (obj)).a();
                }
                if (!r.b(i))
                {
                    ((com.g.b.d.a) (obj)).b();
                }
                obj = ((com.g.b.d.a) (obj)).c();
            }
        }
        uri = (new com.g.b.v.a()).a(uri.toString());
        if (obj != null)
        {
            uri.a(((d) (obj)));
        }
        uri = a.a(uri.a()).a();
        k = uri.a();
        if (k >= 300)
        {
            uri.c().close();
            throw new j.b((new StringBuilder()).append(k).append(" ").append(uri.b()).toString(), i, k);
        }
        boolean flag;
        if (uri.e() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        uri = uri.c();
        return new j.a(uri.c(), flag, uri.a());
    }
}
