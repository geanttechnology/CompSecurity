// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import java.io.File;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            c, aj

class b
    implements b
{

    final c a;
    private Context b;

    public void a()
    {
        if (com.baidu.autoupdatesdk.obf.c.a(a) != null)
        {
            com.baidu.autoupdatesdk.obf.c.a(a).a();
        }
        aj.a("BDAutoUpdateSDK", "download: onStart");
    }

    public void a(int i, long l, long l1)
    {
        if (com.baidu.autoupdatesdk.obf.c.a(a) != null)
        {
            com.baidu.autoupdatesdk.obf.c.a(a).a(i, l, l1);
        }
    }

    public void a(String s)
    {
        File file = new File((new StringBuilder()).append(com.baidu.autoupdatesdk.obf.c.a(a, b)).append(com.baidu.autoupdatesdk.obf.c.b(a)).toString());
        if (com.baidu.autoupdatesdk.obf.c.a(a) != null)
        {
            if (file.exists())
            {
                File file1 = new File((new StringBuilder()).append(com.baidu.autoupdatesdk.obf.c.a(a, b)).append(com.baidu.autoupdatesdk.obf.c.c(a)).toString());
                file.renameTo(file1);
                com.baidu.autoupdatesdk.obf.c.a(a).a(file1.getAbsolutePath());
            } else
            {
                com.baidu.autoupdatesdk.obf.c.a(a).a(new RuntimeException("download failed."), "download failed.");
            }
        }
        aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("download: onSuccess, ").append(s).toString());
    }

    public void a(Throwable throwable, String s)
    {
        if (com.baidu.autoupdatesdk.obf.c.a(a) != null)
        {
            com.baidu.autoupdatesdk.obf.c.a(a).a(throwable, s);
        }
        aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("download: onFail ").append(s).toString());
    }

    public void b()
    {
    }

    public void c()
    {
    }

    public (c c1, Context context)
    {
        a = c1;
        super();
        b = context;
    }
}
