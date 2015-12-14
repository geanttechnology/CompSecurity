// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.autoupdatesdk.AppUpdateInfo;
import java.io.File;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            a, l, g, af, 
//            i

class a
    implements a
{

    final a a;

    public void a(boolean flag, String s)
    {
        if (flag)
        {
            com.baidu.autoupdatesdk.obf.a.a(a.a);
            l.b(a.a, a.a, a.a, s);
            return;
        } else
        {
            g.a(a.a).a();
            return;
        }
    }

    nfo(nfo nfo)
    {
        a = nfo;
        super();
    }

    // Unreferenced inner class com/baidu/autoupdatesdk/obf/l$7

/* anonymous class */
    class l._cls7
        implements e.c
    {

        final Context a;
        final AppUpdateInfo b;
        final l c;

        public void a()
        {
            long l1;
            if (TextUtils.isEmpty(b.getAppPath()))
            {
                l1 = b.getAppSize();
            } else
            {
                l1 = b.getAppPathSize();
            }
            g.a(a).a(b.getAppSname(), af.a(l1), 0);
        }

        public void a(int j, long l1, long l2)
        {
            if (TextUtils.isEmpty(b.getAppPath()))
            {
                l1 = b.getAppSize();
            } else
            {
                j = (int)((double)j * 0.90000000000000002D);
                l1 = b.getAppPathSize();
            }
            g.a(a).a(b.getAppSname(), af.a(l1), j);
        }

        public void a(String s)
        {
            Object obj;
            obj = new File(s);
            if (!((File) (obj)).exists())
            {
                return;
            }
            if (s.endsWith(".apk"))
            {
                com.baidu.autoupdatesdk.obf.a.a(a);
                l.b(c, a, b, s);
                return;
            }
            if (!s.endsWith(".xdt"))
            {
                break MISSING_BLOCK_LABEL_157;
            }
            try
            {
                obj = a.getPackageManager().getPackageInfo(b.getAppPackage(), 0).applicationInfo.sourceDir;
                s = new i(a, ((String) (obj)), s, b, new l._cls7._cls1(this));
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    s.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                g.a(a).a();
                return;
            }
            s.execute(new Void[0]);
            return;
            ((File) (obj)).delete();
            g.a(a).a();
            return;
        }

        public void a(Throwable throwable, String s)
        {
            g.a(a).a();
        }

        public void b()
        {
            g.a(a).a();
        }

            
            {
                c = l1;
                a = context;
                b = appupdateinfo;
                super();
            }
    }

}
