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
import com.baidu.autoupdatesdk.AppUpdateInfoForInstall;
import com.baidu.autoupdatesdk.CPCheckUpdateCallback;
import com.baidu.autoupdatesdk.CPUpdateDownloadCallback;
import com.baidu.autoupdatesdk.ICallback;
import java.io.File;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            e, am, a, af, 
//            i, an, ad

public class j
{

    private CPCheckUpdateCallback a;
    private CPUpdateDownloadCallback b;

    public j()
    {
    }

    static CPCheckUpdateCallback a(j j1)
    {
        return j1.a;
    }

    static CPUpdateDownloadCallback b(j j1)
    {
        return j1.b;
    }

    public void a(Context context, AppUpdateInfo appupdateinfo, CPUpdateDownloadCallback cpupdatedownloadcallback)
    {
        if (cpupdatedownloadcallback == null)
        {
            return;
        } else
        {
            b = cpupdatedownloadcallback;
            b.onStart();
            e.a().a(context, e.b.b, appupdateinfo, new e.c(context, appupdateinfo) {

                final Context a;
                final AppUpdateInfo b;
                final j c;

                public void a()
                {
                }

                public void a(int k, long l, long l1)
                {
                    j.b(c).onPercent(k, l, l1);
                }

                public void a(String s)
                {
                    Object obj;
                    obj = new File(s);
                    if (!((File) (obj)).exists())
                    {
                        j.b(c).onFail(new RuntimeException("download file is not exists."), "download file is not exists.");
                        return;
                    }
                    if (!s.endsWith(".apk")) goto _L2; else goto _L1
_L1:
                    com.baidu.autoupdatesdk.obf.a.a(a);
                    if (!i.a())
                    {
                        j.b(c).onDownloadComplete(ad.c(a, s));
                    }
_L4:
                    j.b(c).onStop();
                    return;
_L2:
                    if (!s.endsWith(".xdt"))
                    {
                        break MISSING_BLOCK_LABEL_198;
                    }
                    obj = a.getPackageManager().getPackageInfo(b.getAppPackage(), 0).applicationInfo.sourceDir;
                    s = new i(a, ((String) (obj)), s, b, new i.a(this) {

                        final _cls2 a;

                        public void a(boolean flag, String s)
                        {
                            if (flag)
                            {
                                com.baidu.autoupdatesdk.obf.a.a(a.a);
                                j.b(a.c).onDownloadComplete(ad.c(a.a, s));
                                return;
                            } else
                            {
                                j.b(a.c).onFail(new RuntimeException("merge patch failed."), "merge patch failed.");
                                return;
                            }
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        s.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        continue; /* Loop/switch isn't completed */
                    }
                    try
                    {
                        s.execute(new Void[0]);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        s.printStackTrace();
                    }
                    continue; /* Loop/switch isn't completed */
                    ((File) (obj)).delete();
                    if (true) goto _L4; else goto _L3
_L3:
                }

                public void a(Throwable throwable, String s)
                {
                    j.b(c).onFail(throwable, s);
                }

                public void b()
                {
                    j.b(c).onStop();
                }

            
            {
                c = j.this;
                a = context;
                b = appupdateinfo;
                super();
            }
            });
            return;
        }
    }

    public void a(Context context, CPCheckUpdateCallback cpcheckupdatecallback)
    {
        if (cpcheckupdatecallback == null)
        {
            return;
        }
        a = cpcheckupdatecallback;
        context = context.getApplicationContext();
        if (am.a(context))
        {
            com.baidu.autoupdatesdk.obf.a.a(context, new ICallback(context) {

                final Context a;
                final j b;

                public void a(int k, String s, AppUpdateInfo appupdateinfo)
                {
                    s = null;
                    if (k != 0 || appupdateinfo == null) goto _L2; else goto _L1
_L1:
                    String s1 = e.a().a(a, appupdateinfo.getAppVersionCode() - 1, -1);
                    if (!TextUtils.isEmpty(s1)) goto _L4; else goto _L3
_L3:
                    if (appupdateinfo.getAppVersionCode() <= af.b(a)) goto _L2; else goto _L5
_L5:
                    j.a(b).onCheckUpdateCallback(appupdateinfo, s);
                    return;
_L4:
                    if (!i.a())
                    {
                        s = an.b(a);
                        if (s != null)
                        {
                            s.setInstallPath(ad.c(a, s1));
                        }
                        appupdateinfo = null;
                        continue; /* Loop/switch isn't completed */
                    }
_L2:
                    appupdateinfo = null;
                    if (true) goto _L5; else goto _L6
_L6:
                }

                public void onCallback(int k, String s, Object obj)
                {
                    a(k, s, (AppUpdateInfo)obj);
                }

            
            {
                b = j.this;
                a = context;
                super();
            }
            });
            return;
        } else
        {
            a.onCheckUpdateCallback(null, null);
            return;
        }
    }
}
