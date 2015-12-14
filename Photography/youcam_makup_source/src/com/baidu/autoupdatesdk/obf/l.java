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
import com.baidu.autoupdatesdk.UICheckUpdateCallback;
import java.io.File;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            af, ac, g, ad, 
//            an, e, i, aj, 
//            am, a

public class l
{

    private UICheckUpdateCallback a;

    public l()
    {
    }

    static UICheckUpdateCallback a(l l1)
    {
        return l1.a;
    }

    private void a(Context context, AppUpdateInfo appupdateinfo)
    {
        if (af.e(context))
        {
            String s;
            String s1;
            if (TextUtils.isEmpty(appupdateinfo.getAppPath()))
            {
                s = af.a(appupdateinfo.getAppSize());
            } else
            {
                s = af.a(appupdateinfo.getAppPathSize());
            }
            s1 = context.getString(ac.b(context, "bdp_update_download_main_tip"), new Object[] {
                af.a(context), appupdateinfo.getAppVersionName(), s
            });
            if (!TextUtils.isEmpty(appupdateinfo.getAppChangeLog()))
            {
                s = (new StringBuilder()).append(context.getString(ac.b(context, "bdp_update_minor_tip"))).append("<br>").toString();
                s = (new StringBuilder()).append(s).append(appupdateinfo.getAppChangeLog()).toString();
            } else
            {
                s = "";
            }
            ConfirmDialoigActivity.show(context, 1, s1, s, new com.baidu.autoupdatesdk.ConfirmDialoigActivity.OnActionListener(context, appupdateinfo) {

                final Context a;
                final AppUpdateInfo b;
                final l c;

                public void onAction()
                {
                    l.b(c, a, b);
                }

                public void onClose()
                {
                    l.a(c).onCheckComplete();
                }

                public void onIgnoreUpdate()
                {
                    an.a(a, b.getAppVersionCode());
                }

            
            {
                c = l.this;
                a = context;
                b = appupdateinfo;
                super();
            }
            });
            return;
        } else
        {
            g.a(context).a(appupdateinfo, new g.a(context, appupdateinfo) {

                final Context a;
                final AppUpdateInfo b;
                final l c;

                public void a()
                {
                    l.b(c, a, b);
                }

            
            {
                c = l.this;
                a = context;
                b = appupdateinfo;
                super();
            }
            });
            a.onCheckComplete();
            return;
        }
    }

    private void a(Context context, AppUpdateInfo appupdateinfo, String s)
    {
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
            final l c;

            public void a()
            {
                ad.a(a, b);
            }

            
            {
                c = l.this;
                a = context;
                b = s;
                super();
            }
        });
        ad.a(context, s);
    }

    static void a(l l1, Context context, AppUpdateInfo appupdateinfo)
    {
        l1.a(context, appupdateinfo);
    }

    static void a(l l1, Context context, AppUpdateInfo appupdateinfo, String s)
    {
        l1.b(context, appupdateinfo, s);
    }

    private void b(Context context, AppUpdateInfo appupdateinfo)
    {
        e.a().a(context, e.b.a, appupdateinfo, new e.c(context, appupdateinfo) {

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
                    s = new i(a, ((String) (obj)), s, b, new i.a(this) {

                        final _cls7 a;

                        public void a(boolean flag, String s)
                        {
                            if (flag)
                            {
                                com.baidu.autoupdatesdk.obf.a.a(a.a);
                                l.b(a.c, a.a, a.b, s);
                                return;
                            } else
                            {
                                g.a(a.a).a();
                                return;
                            }
                        }

            
            {
                a = _pcls7;
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
                c = l.this;
                a = context;
                b = appupdateinfo;
                super();
            }
        });
    }

    private void b(Context context, AppUpdateInfo appupdateinfo, String s)
    {
        String s1 = null;
        if (i.a())
        {
            a.onCheckComplete();
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
                final l c;

                public void onAction()
                {
                    ad.a(a, b);
                }

                public void onClose()
                {
                    l.a(c).onCheckComplete();
                }

                public void onIgnoreUpdate()
                {
                }

            
            {
                c = l.this;
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
            final l c;

            public void a()
            {
                ad.a(a, b);
            }

            
            {
                c = l.this;
                a = context;
                b = s;
                super();
            }
        });
        a.onCheckComplete();
    }

    static void b(l l1, Context context, AppUpdateInfo appupdateinfo)
    {
        l1.b(context, appupdateinfo);
    }

    static void b(l l1, Context context, AppUpdateInfo appupdateinfo, String s)
    {
        l1.a(context, appupdateinfo, s);
    }

    public void a(Context context, UICheckUpdateCallback uicheckupdatecallback)
    {
        if (uicheckupdatecallback == null)
        {
            return;
        }
        a = uicheckupdatecallback;
        uicheckupdatecallback = context.getApplicationContext();
        int j = an.a(context);
        aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("ignoreVersionCode: ").append(j).toString());
        if (am.a(uicheckupdatecallback))
        {
            com.baidu.autoupdatesdk.obf.a.a(uicheckupdatecallback, new ICallback(uicheckupdatecallback, j) {

                final Context a;
                final int b;
                final l c;

                public void a(int k, String s, AppUpdateInfo appupdateinfo)
                {
                    if (k == 0 && appupdateinfo != null)
                    {
                        aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("newVersionCode: ").append(appupdateinfo.getAppVersionCode()).toString());
                        s = e.a().a(a, appupdateinfo.getAppVersionCode() - 1, b);
                        if (TextUtils.isEmpty(s))
                        {
                            if (appupdateinfo.getAppVersionCode() > af.b(a) && appupdateinfo.getAppVersionCode() != b)
                            {
                                l.a(c, a, appupdateinfo);
                                return;
                            } else
                            {
                                l.a(c).onCheckComplete();
                                return;
                            }
                        } else
                        {
                            l.a(c, a, appupdateinfo, s);
                            return;
                        }
                    } else
                    {
                        l.a(c).onCheckComplete();
                        return;
                    }
                }

                public void onCallback(int k, String s, Object obj)
                {
                    a(k, s, (AppUpdateInfo)obj);
                }

            
            {
                c = l.this;
                a = context;
                b = j;
                super();
            }
            });
            return;
        }
        context = e.a().a(context, j);
        if (!TextUtils.isEmpty(context))
        {
            b(uicheckupdatecallback, ((AppUpdateInfo) (null)), context);
            return;
        } else
        {
            a.onCheckComplete();
            return;
        }
    }
}
