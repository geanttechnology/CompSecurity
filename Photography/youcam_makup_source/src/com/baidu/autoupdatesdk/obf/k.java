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
import com.baidu.autoupdatesdk.ConfirmDialoigActivity;
import com.baidu.autoupdatesdk.ICallback;
import java.io.File;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            i, af, ac, an, 
//            g, e, aj, am, 
//            a, ad

public class k
{

    public k()
    {
    }

    private void a(Context context, AppUpdateInfo appupdateinfo)
    {
        b(context, appupdateinfo);
    }

    private void a(Context context, AppUpdateInfo appupdateinfo, String s)
    {
        String s1 = null;
        if (i.a())
        {
            return;
        }
        if (af.e(context))
        {
            Object obj;
            if (appupdateinfo != null)
            {
                s1 = context.getString(ac.b(context, "bdp_update_install_main_tip"), new Object[] {
                    af.a(context), appupdateinfo.getAppVersionName()
                });
                appupdateinfo = appupdateinfo.getAppChangeLog();
            } else
            {
                appupdateinfo = an.b(context);
                if (appupdateinfo != null)
                {
                    s1 = context.getString(ac.b(context, "bdp_update_install_main_tip"), new Object[] {
                        af.a(context), appupdateinfo.getAppVersionName()
                    });
                    appupdateinfo = appupdateinfo.getAppChangeLog();
                } else
                {
                    Object obj1 = null;
                    appupdateinfo = s1;
                    s1 = obj1;
                }
            }
            obj = appupdateinfo;
            if (!TextUtils.isEmpty(appupdateinfo))
            {
                obj = (new StringBuilder()).append(context.getString(ac.b(context, "bdp_update_minor_tip"))).append("<br>").toString();
                obj = (new StringBuilder()).append(((String) (obj))).append(appupdateinfo).toString();
            }
            ConfirmDialoigActivity.show(context, 2, s1, ((String) (obj)), new com.baidu.autoupdatesdk.ConfirmDialoigActivity.OnActionListener(context, s) {

                final Context a;
                final String b;
                final k c;

                public void onAction()
                {
                    ad.a(a, b);
                }

                public void onClose()
                {
                }

                public void onIgnoreUpdate()
                {
                }

            
            {
                c = k.this;
                a = context;
                b = s;
                super();
            }
            });
            return;
        }
        if (appupdateinfo != null)
        {
            appupdateinfo = appupdateinfo.getAppSname();
        } else
        {
            appupdateinfo = an.b(context).getAppSName();
        }
        g.a(context).a(appupdateinfo, new g.a(context, s) {

            final Context a;
            final String b;
            final k c;

            public void a()
            {
                ad.a(a, b);
            }

            
            {
                c = k.this;
                a = context;
                b = s;
                super();
            }
        });
    }

    static void a(k k1, Context context, AppUpdateInfo appupdateinfo)
    {
        k1.a(context, appupdateinfo);
    }

    static void a(k k1, Context context, AppUpdateInfo appupdateinfo, String s)
    {
        k1.a(context, appupdateinfo, s);
    }

    private void b(Context context, AppUpdateInfo appupdateinfo)
    {
        e.a().a(context, e.b.c, appupdateinfo, new e.c(context, appupdateinfo) {

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
                    s = new i(a, ((String) (obj)), s, b, new i.a(this) {

                        final _cls2 a;

                        public void a(boolean flag, String s)
                        {
                            com.baidu.autoupdatesdk.obf.a.a(a.a);
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
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

            
            {
                c = k.this;
                a = context;
                b = appupdateinfo;
                super();
            }
        });
    }

    public void a(Context context)
    {
        Context context1 = context.getApplicationContext();
        int j = an.a(context);
        aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("ignoreVersionCode: ").append(j).toString());
        if (am.b(context1))
        {
            com.baidu.autoupdatesdk.obf.a.a(context1, new ICallback(j, context1) {

                final int a;
                final Context b;
                final k c;

                public void a(int l, String s, AppUpdateInfo appupdateinfo)
                {
label0:
                    {
                        if (l == 0 && appupdateinfo != null)
                        {
                            aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("ignoreVersionCode: ").append(a).append(", newVersionCode: ").append(appupdateinfo.getAppVersionCode()).toString());
                            s = e.a().a(b, appupdateinfo.getAppVersionCode() - 1, a);
                            if (!TextUtils.isEmpty(s))
                            {
                                break label0;
                            }
                            if (appupdateinfo.getAppVersionCode() > af.b(b) && appupdateinfo.getAppVersionCode() != a)
                            {
                                k.a(c, b, appupdateinfo);
                            }
                        }
                        return;
                    }
                    k.a(c, b, null, s);
                }

                public void onCallback(int l, String s, Object obj)
                {
                    a(l, s, (AppUpdateInfo)obj);
                }

            
            {
                c = k.this;
                a = j;
                b = context;
                super();
            }
            });
        } else
        {
            context = e.a().a(context, j);
            if (!TextUtils.isEmpty(context))
            {
                a(context1, ((AppUpdateInfo) (null)), ((String) (context)));
                return;
            }
        }
    }
}
