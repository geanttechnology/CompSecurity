// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import com.baidu.autoupdatesdk.AppUpdateInfo;
import java.io.File;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            e, aj

class c
    implements c
{

    final e a;
    private Context b;
    private AppUpdateInfo c;

    public void a()
    {
        e.a(a, c);
        if (e.a(a) != null)
        {
            e.a(a).a();
        }
        aj.a("BDAutoUpdateSDK", "download: onStart");
    }

    public void a(int i, long l, long l1)
    {
        if (e.a(a) != null)
        {
            e.a(a).a(i, l, l1);
        }
    }

    public void a(String s)
    {
        File file = new File((new StringBuilder()).append(e.a(a, b)).append(e.b(a, c)).toString());
        if (e.a(a) != null)
        {
            if (file.exists())
            {
                File file1 = new File((new StringBuilder()).append(e.a(a, b)).append(e.c(a, c)).toString());
                file.renameTo(file1);
                e.a(a).a(file1.getAbsolutePath());
            } else
            {
                e.a(a).a(new RuntimeException("download failed."), "download failed.");
            }
        }
        e.a(a, null);
        aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("download: onSuccess, ").append(s).toString());
    }

    public void a(Throwable throwable, String s)
    {
        if (e.a(a) != null)
        {
            e.a(a).a(throwable, s);
        }
        e.a(a, null);
        aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("download: onFail ").append(s).toString());
    }

    public void b()
    {
    }

    public void c()
    {
    }

    public eInfo(e e1, Context context, AppUpdateInfo appupdateinfo)
    {
        a = e1;
        super();
        b = context;
        c = appupdateinfo;
    }
}
