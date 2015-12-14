// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.autoupdatesdk.AppUpdateInfo;
import java.io.File;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            af, ad, aj, f

public class e
{

    private static com.baidu.autoupdatesdk.obf.e a;
    private static a b;
    private static e c;
    private f d;
    private AppUpdateInfo e;
    private b f;
    private c g;

    private e()
    {
    }

    static AppUpdateInfo a(e e1, AppUpdateInfo appupdateinfo)
    {
        e1.e = appupdateinfo;
        return appupdateinfo;
    }

    static c a(e e1)
    {
        return e1.g;
    }

    public static e a()
    {
        if (a == null)
        {
            a = new e();
        }
        return a;
    }

    private String a(AppUpdateInfo appupdateinfo)
    {
        if (appupdateinfo == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder(appupdateinfo.getAppPackage());
        stringbuilder.append('-');
        stringbuilder.append(appupdateinfo.getAppVersionCode());
        if (!TextUtils.isEmpty(appupdateinfo.getAppPath()))
        {
            stringbuilder.append(".xdt");
        } else
        {
            stringbuilder.append(".apk");
        }
        return stringbuilder.toString();
    }

    static String a(e e1, Context context)
    {
        return e1.b(context);
    }

    private void a(c c1)
    {
        if (g != null)
        {
            g.b();
        }
        g = c1;
    }

    private String b(Context context)
    {
        StringBuilder stringbuilder;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            stringbuilder = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
        } else
        {
            stringbuilder = new StringBuilder("/sdcard");
        }
        stringbuilder.append("/com.baidu.autoupdate");
        stringbuilder.append((new StringBuilder()).append("/").append(context.getPackageName()).append("/").toString());
        return stringbuilder.toString();
    }

    private String b(AppUpdateInfo appupdateinfo)
    {
        if (appupdateinfo == null)
        {
            return null;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder(appupdateinfo.getAppPackage());
            stringbuilder.append('-');
            stringbuilder.append(appupdateinfo.getAppVersionCode());
            stringbuilder.append(".tmp");
            return stringbuilder.toString();
        }
    }

    static String b(e e1, AppUpdateInfo appupdateinfo)
    {
        return e1.b(appupdateinfo);
    }

    private a c()
    {
        if (b == null)
        {
            b = new a();
        }
        return b;
    }

    static String c(e e1, AppUpdateInfo appupdateinfo)
    {
        return e1.a(appupdateinfo);
    }

    private void c(Context context)
    {
        context = new File(a(context));
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

    private e d()
    {
        if (c == null)
        {
            c = new e();
        }
        return c;
    }

    public String a(Context context)
    {
        context = b(context);
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

    public String a(Context context, int i)
    {
        return a(context, af.b(context), i);
    }

    public String a(Context context, int i, int j)
    {
        Object obj = new File(b(context));
        if (((File) (obj)).exists() && ((File) (obj)).isDirectory()) goto _L2; else goto _L1
_L1:
        File afile[];
        return null;
_L2:
        if ((afile = ((File) (obj)).listFiles(c())) == null || afile.length == 0) goto _L1; else goto _L3
_L3:
        int k;
        obj = null;
        k = 0;
_L5:
        Object obj1;
        File file;
        if (k >= afile.length)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        file = afile[k];
        obj1 = obj;
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        int l;
        obj1 = file.getName().replace(".apk", "");
        l = Integer.valueOf(((String) (obj1)).substring(((String) (obj1)).lastIndexOf("-") + 1, ((String) (obj1)).length())).intValue();
        if (l <= i || l == j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l <= af.b(context))
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = file.getAbsolutePath();
_L6:
        k++;
        obj = obj1;
        if (true) goto _L5; else goto _L4
        obj1;
        ((Exception) (obj1)).printStackTrace();
_L4:
        obj1 = obj;
        if (!ad.a(context).equals(file.getAbsolutePath()))
        {
            file.delete();
            obj1 = obj;
        }
          goto _L6
        aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("latestApkPath: ").append(((String) (obj))).toString());
        return ((String) (obj));
    }

    public void a(Context context, b b1, AppUpdateInfo appupdateinfo, c c1)
    {
        if (e != null && e.getAppVersionCode() == appupdateinfo.getAppVersionCode())
        {
            if (b1 == b.a && f == b.c || b1 == b.b && f != b.b)
            {
                a(c1);
            }
            return;
        }
        f = b1;
        a(c1);
        if (d != null)
        {
            d.a(true);
            d = null;
        }
        c1 = a(context);
        long l;
        if (!TextUtils.isEmpty(appupdateinfo.getAppPath()))
        {
            l = appupdateinfo.getAppPathSize();
            b1 = appupdateinfo.getAppPath();
            aj.a("BDAutoUpdateSDK", "update type: patch");
        } else
        {
            l = appupdateinfo.getAppSize();
            b1 = appupdateinfo.getAppUrl();
            aj.a("BDAutoUpdateSDK", "update type: full");
        }
        c(context);
        d = new f();
        d.a(context, (new StringBuilder()).append(c1).append(b(appupdateinfo)).toString(), l, b1, new d(context, appupdateinfo));
    }

    public AppUpdateInfo b()
    {
        return e;
    }

    private class c
    {

        public abstract void a();

        public abstract void a(int i, long l, long l1);

        public abstract void a(String s);

        public abstract void a(Throwable throwable, String s);

        public abstract void b();
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


    private class e
        implements FilenameFilter
    {

        public boolean accept(File file, String s)
        {
            return !TextUtils.isEmpty(s) && s.endsWith(".tmp");
        }

        private e()
        {
        }

    }


    private class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        private static final b d[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/baidu/autoupdatesdk/obf/e$b, s);
        }

        public static b[] values()
        {
            return (b[])d.clone();
        }

        static 
        {
            a = new b("uiupdate", 0);
            b = new b("nouiupdate", 1);
            c = new b("silence", 2);
            d = (new b[] {
                a, b, c
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    private class d
        implements f.c
    {

        final com.baidu.autoupdatesdk.obf.e a;
        private Context b;
        private AppUpdateInfo c;

        public void a()
        {
            com.baidu.autoupdatesdk.obf.e.a(a, c);
            if (com.baidu.autoupdatesdk.obf.e.a(a) != null)
            {
                com.baidu.autoupdatesdk.obf.e.a(a).a();
            }
            aj.a("BDAutoUpdateSDK", "download: onStart");
        }

        public void a(int i, long l, long l1)
        {
            if (com.baidu.autoupdatesdk.obf.e.a(a) != null)
            {
                com.baidu.autoupdatesdk.obf.e.a(a).a(i, l, l1);
            }
        }

        public void a(String s)
        {
            File file = new File((new StringBuilder()).append(com.baidu.autoupdatesdk.obf.e.a(a, b)).append(com.baidu.autoupdatesdk.obf.e.b(a, c)).toString());
            if (com.baidu.autoupdatesdk.obf.e.a(a) != null)
            {
                if (file.exists())
                {
                    File file1 = new File((new StringBuilder()).append(com.baidu.autoupdatesdk.obf.e.a(a, b)).append(com.baidu.autoupdatesdk.obf.e.c(a, c)).toString());
                    file.renameTo(file1);
                    com.baidu.autoupdatesdk.obf.e.a(a).a(file1.getAbsolutePath());
                } else
                {
                    com.baidu.autoupdatesdk.obf.e.a(a).a(new RuntimeException("download failed."), "download failed.");
                }
            }
            com.baidu.autoupdatesdk.obf.e.a(a, null);
            aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("download: onSuccess, ").append(s).toString());
        }

        public void a(Throwable throwable, String s)
        {
            if (com.baidu.autoupdatesdk.obf.e.a(a) != null)
            {
                com.baidu.autoupdatesdk.obf.e.a(a).a(throwable, s);
            }
            com.baidu.autoupdatesdk.obf.e.a(a, null);
            aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("download: onFail ").append(s).toString());
        }

        public void b()
        {
        }

        public void c()
        {
        }

        public d(Context context, AppUpdateInfo appupdateinfo)
        {
            a = com.baidu.autoupdatesdk.obf.e.this;
            super();
            b = context;
            c = appupdateinfo;
        }
    }

}
