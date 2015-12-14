// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import com.baidu.autoupdatesdk.AppUpdateInfo;
import java.io.File;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            k, a, i

class b
    implements b
{

    final Context a;
    final AppUpdateInfo b;
    final k c;

    public void a()
    {
    }

    public void a(int j, long l, long l1)
    {
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
            return;
        }
        if (!s.endsWith(".xdt"))
        {
            break MISSING_BLOCK_LABEL_131;
        }
        try
        {
            obj = a.getPackageManager().getPackageInfo(b.getAppPackage(), 0).applicationInfo.sourceDir;
            s = new i(a, ((String) (obj)), s, b, new i.a() {

                final k._cls2 a;

                public void a(boolean flag, String s1)
                {
                    com.baidu.autoupdatesdk.obf.a.a(a.a);
                }

            
            {
                a = k._cls2.this;
                super();
            }
            });
            if (android.os.d.VERSION.SDK_INT >= 11)
            {
                s.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        s.execute(new Void[0]);
        return;
        ((File) (obj)).delete();
        return;
    }

    public void a(Throwable throwable, String s)
    {
    }

    public void b()
    {
    }

    eInfo(k k1, Context context, AppUpdateInfo appupdateinfo)
    {
        c = k1;
        a = context;
        b = appupdateinfo;
        super();
    }
}
