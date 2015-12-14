// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.autoupdatesdk.AppUpdateInfo;
import com.baidu.autoupdatesdk.AppUpdateInfoForInstall;
import com.baidu.autoupdatesdk.ConfirmDialoigActivity;
import com.baidu.autoupdatesdk.ICallback;
import com.baidu.autoupdatesdk.UICheckUpdateCallback;
import java.io.File;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            ae, af, ac, g, 
//            i, an, d, ad, 
//            c, aj, am, a, 
//            e

public class h
{

    private UICheckUpdateCallback a;

    public h()
    {
    }

    static UICheckUpdateCallback a(h h1)
    {
        return h1.a;
    }

    private void a(Context context)
    {
        if (ae.b(context))
        {
            ae.a(context);
            return;
        } else
        {
            b(context);
            return;
        }
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
                final h c;

                public void onAction()
                {
                    h.a(c, a);
                }

                public void onClose()
                {
                    h.a(c).onCheckComplete();
                }

                public void onIgnoreUpdate()
                {
                    an.a(a, b.getAppVersionCode());
                }

            
            {
                c = h.this;
                a = context;
                b = appupdateinfo;
                super();
            }
            });
            return;
        } else
        {
            g.a(context).a(appupdateinfo, new g.a(context) {

                final Context a;
                final h b;

                public void a()
                {
                    h.a(b, a);
                }

            
            {
                b = h.this;
                a = context;
                super();
            }
            });
            a.onCheckComplete();
            return;
        }
    }

    private void a(Context context, AppUpdateInfo appupdateinfo, String s)
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
                final h c;

                public void onAction()
                {
                    ad.a(a, b);
                }

                public void onClose()
                {
                    h.a(c).onCheckComplete();
                }

                public void onIgnoreUpdate()
                {
                }

            
            {
                c = h.this;
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
            final h c;

            public void a()
            {
                ad.a(a, b);
            }

            
            {
                c = h.this;
                a = context;
                b = s;
                super();
            }
        });
        a.onCheckComplete();
    }

    private void a(Context context, String s)
    {
        d.a(context).b(new d.a(context, s) {

            final Context a;
            final String b;
            final h c;

            public void a()
            {
                ad.b(a, b);
            }

            
            {
                c = h.this;
                a = context;
                b = s;
                super();
            }
        });
        ad.b(context, s);
    }

    static void a(h h1, Context context)
    {
        h1.a(context);
    }

    static void a(h h1, Context context, AppUpdateInfo appupdateinfo)
    {
        h1.a(context, appupdateinfo);
    }

    static void a(h h1, Context context, AppUpdateInfo appupdateinfo, String s)
    {
        h1.a(context, appupdateinfo, s);
    }

    static void a(h h1, Context context, String s)
    {
        h1.a(context, s);
    }

    private void b(Context context)
    {
        if (af.e(context))
        {
            ConfirmDialoigActivity.show(context, 3, "", context.getString(ac.b(context, "bdp_update_as_install_tip")), new com.baidu.autoupdatesdk.ConfirmDialoigActivity.OnActionListener(context) {

                final Context a;
                final h b;

                public void onAction()
                {
                    h.b(b, a);
                }

                public void onClose()
                {
                    h.a(b).onCheckComplete();
                }

                public void onIgnoreUpdate()
                {
                }

            
            {
                b = h.this;
                a = context;
                super();
            }
            });
            return;
        } else
        {
            d.a(context).a(new d.a(context) {

                final Context a;
                final h b;

                public void a()
                {
                    h.b(b, a);
                }

            
            {
                b = h.this;
                a = context;
                super();
            }
            });
            a.onCheckComplete();
            return;
        }
    }

    static void b(h h1, Context context)
    {
        h1.c(context);
    }

    private void c(Context context)
    {
        com.baidu.autoupdatesdk.obf.c.a().a(context);
        com.baidu.autoupdatesdk.obf.c.a().a(context, new c.b(context) {

            final Context a;
            final h b;

            public void a()
            {
                d.a(a).a(af.a(0x7fffffffffffffffL), 0);
            }

            public void a(int j, long l, long l1)
            {
                d.a(a).a(af.a(l1), j);
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

            
            {
                b = h.this;
                a = context;
                super();
            }
        });
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
                final h c;

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
                                h.a(c, a, appupdateinfo);
                                return;
                            } else
                            {
                                h.a(c).onCheckComplete();
                                return;
                            }
                        } else
                        {
                            h.a(c, a, appupdateinfo, s);
                            return;
                        }
                    } else
                    {
                        h.a(c).onCheckComplete();
                        return;
                    }
                }

                public void onCallback(int k, String s, Object obj)
                {
                    a(k, s, (AppUpdateInfo)obj);
                }

            
            {
                c = h.this;
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
            a(((Context) (uicheckupdatecallback)), ((AppUpdateInfo) (null)), ((String) (context)));
            return;
        } else
        {
            a.onCheckComplete();
            return;
        }
    }
}
