// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import java.io.File;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            h, d, af, a

class a
    implements a
{

    final Context a;
    final h b;

    public void a()
    {
        d.a(a).a(af.a(0x7fffffffffffffffL), 0);
    }

    public void a(int i, long l, long l1)
    {
        d.a(a).a(af.a(l1), i);
    }

    public void a(String s)
    {
        File file = new File(s);
        if (!file.exists())
        {
            return;
        }
        if (s.endsWith(".apk"))
        {
            com.baidu.autoupdatesdk.obf.a.a(a);
            h.a(b, a, s);
            return;
        } else
        {
            file.delete();
            d.a(a).a();
            return;
        }
    }

    public void a(Throwable throwable, String s)
    {
        d.a(a).a();
    }

    (h h1, Context context)
    {
        b = h1;
        a = context;
        super();
    }
}
