// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.os.Environment;
import java.io.File;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            f

public class c
{

    private static final String a = "http://dl.ops.baidu.com/appsearch_AndroidPhone_1012700a.apk";
    private static com.baidu.autoupdatesdk.obf.c b;
    private static a c;
    private static d d;
    private f e;
    private b f;

    private c()
    {
    }

    static b a(c c1)
    {
        return c1.f;
    }

    public static c a()
    {
        if (b == null)
        {
            b = new c();
        }
        return b;
    }

    static String a(c c1, Context context)
    {
        return c1.c(context);
    }

    private String b()
    {
        return "com.baidu.appsearch.apk";
    }

    static String b(c c1)
    {
        return c1.c();
    }

    private String c()
    {
        StringBuilder stringbuilder = new StringBuilder("com.baidu.appsearch");
        stringbuilder.append(".tmp");
        return stringbuilder.toString();
    }

    private String c(Context context)
    {
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            context = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
        } else
        {
            context = new StringBuilder("/sdcard");
        }
        context.append("/com.baidu.autoupdate");
        context.append("/appsearchcache/");
        return context.toString();
    }

    static String c(c c1)
    {
        return c1.b();
    }

    private a d()
    {
        if (c == null)
        {
            c = new a();
        }
        return c;
    }

    private void d(Context context)
    {
        context = new File(b(context));
        if (context.exists() && context.isDirectory())
        {
            context = context.listFiles(e());
            if (context != null && context.length > 0)
            {
                for (int i = 0; i < context.length; i++)
                {
                    context[i].delete();
                }

            }
        }
    }

    private d e()
    {
        if (d == null)
        {
            d = new d();
        }
        return d;
    }

    public void a(Context context)
    {
        context = new File(b(context));
        if (context.exists() && context.isDirectory())
        {
            context = context.listFiles(d());
            if (context != null && context.length > 0)
            {
                for (int i = 0; i < context.length; i++)
                {
                    context[i].delete();
                }

            }
        }
    }

    public void a(Context context, b b1)
    {
        f = b1;
        if (e != null)
        {
            e.a(true);
            e = null;
        }
        b1 = b(context);
        d(context);
        e = new f();
        e.a(context, (new StringBuilder()).append(b1).append(c()).toString(), 0L, "http://dl.ops.baidu.com/appsearch_AndroidPhone_1012700a.apk", new c(context));
    }

    public String b(Context context)
    {
        context = c(context);
        File file = new File(context);
        try
        {
            if (!file.exists())
            {
                file.mkdirs();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return context;
        }
        return context;
    }

    private class a
        implements FilenameFilter
    {

        public boolean accept(File file, String s)
        {
            return !TextUtils.isEmpty(s) && s.endsWith(".apk");
        }

        private a()
        {
        }

    }


    private class d
        implements FilenameFilter
    {

        public boolean accept(File file, String s)
        {
            return !TextUtils.isEmpty(s) && s.endsWith(".tmp");
        }

        private d()
        {
        }

    }


    private class c
        implements f.c
    {

        final com.baidu.autoupdatesdk.obf.c a;
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

        public c(Context context)
        {
            a = com.baidu.autoupdatesdk.obf.c.this;
            super();
            b = context;
        }

        private class b
        {

            public abstract void a();

            public abstract void a(int i, long l, long l1);

            public abstract void a(String s);

            public abstract void a(Throwable throwable, String s);
        }

    }

}
