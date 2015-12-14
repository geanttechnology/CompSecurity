// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.b;
import com.tencent.open.a.k;
import com.tencent.open.b.d;
import com.tencent.open.utils.c;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.open.utils.m;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.b:
//            m, d, b, e

public class a extends com.tencent.connect.common.a
{

    private com.tencent.tauth.b k;
    private String l;
    private Activity m;

    public a(com.tencent.connect.b.m m1)
    {
        super(m1);
    }

    private int a(boolean flag, com.tencent.tauth.b b1)
    {
        com.tencent.open.a.k.c("openSDK_LOG", "OpenUi, showDialog -- start");
        CookieSyncManager.createInstance(com.tencent.open.utils.c.a());
        Object obj = c();
        if (flag)
        {
            ((Bundle) (obj)).putString("isadd", "1");
        }
        ((Bundle) (obj)).putString("scope", l);
        ((Bundle) (obj)).putString("client_id", b.b());
        Object obj1;
        if (j)
        {
            ((Bundle) (obj)).putString("pf", (new StringBuilder()).append("desktop_m_qq-").append(h).append("-").append("android").append("-").append(g).append("-").append(i).toString());
        } else
        {
            ((Bundle) (obj)).putString("pf", "openmobile_android");
        }
        obj1 = (new StringBuilder()).append(System.currentTimeMillis() / 1000L).append("").toString();
        ((Bundle) (obj)).putString("sign", i.b(com.tencent.open.utils.c.a(), ((String) (obj1))));
        ((Bundle) (obj)).putString("time", ((String) (obj1)));
        ((Bundle) (obj)).putString("display", "mobile");
        ((Bundle) (obj)).putString("response_type", "token");
        ((Bundle) (obj)).putString("redirect_uri", "auth://tauth.qq.com/");
        ((Bundle) (obj)).putString("cancel_display", "1");
        ((Bundle) (obj)).putString("switch", "1");
        ((Bundle) (obj)).putString("status_userip", com.tencent.open.utils.m.a());
        obj1 = new StringBuilder();
        ((StringBuilder) (obj1)).append(com.tencent.open.utils.h.a().a(com.tencent.open.utils.c.a(), "http://openmobile.qq.com/oauth2.0/m_authorize?"));
        ((StringBuilder) (obj1)).append(com.tencent.open.utils.m.a(((Bundle) (obj))));
        obj = ((StringBuilder) (obj1)).toString();
        b1 = new com.tencent.connect.b.d(this, com.tencent.open.utils.c.a(), b1, true, false);
        com.tencent.open.a.k.b("openSDK_LOG", "OpenUi, showDialog TDialog");
        com.tencent.open.utils.k.a(new Runnable(((String) (obj)), b1) {

            final String a;
            final com.tencent.tauth.b b;
            final a c;

            public void run()
            {
                i.a("libwbsafeedit", "libwbsafeedit.so", 2);
                if (a.e(c) != null)
                {
                    a.e(c).runOnUiThread(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            e e1 = new e(a.e(a.c), "action_login", a.a, a.b, a.f(a.c));
                            if (a.e(a.c) != null && !a.e(a.c).isFinishing())
                            {
                                e1.show();
                            }
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }
            }

            
            {
                c = a.this;
                a = s;
                b = b1;
                super();
            }
        });
        com.tencent.open.a.k.c("openSDK_LOG", "OpenUi, showDialog -- end");
        return 2;
    }

    static com.tencent.connect.b.m a(a a1)
    {
        return a1.b;
    }

    private boolean a(Activity activity, Fragment fragment, boolean flag)
    {
        com.tencent.open.a.k.c("openSDK_LOG", "startActionActivity() -- start");
        Intent intent = a("com.tencent.open.agent.AgentActivity");
        if (intent != null)
        {
            Bundle bundle = c();
            if (flag)
            {
                bundle.putString("isadd", "1");
            }
            bundle.putString("scope", l);
            bundle.putString("client_id", b.b());
            if (j)
            {
                bundle.putString("pf", (new StringBuilder()).append("desktop_m_qq-").append(h).append("-").append("android").append("-").append(g).append("-").append(i).toString());
            } else
            {
                bundle.putString("pf", "openmobile_android");
            }
            bundle.putString("need_pay", "1");
            bundle.putString("oauth_app_name", i.a(com.tencent.open.utils.c.a()));
            intent.putExtra("key_action", "action_login");
            intent.putExtra("key_params", bundle);
            d = intent;
            if (e())
            {
                k = new com.tencent.connect.b.b(this, k);
                if (fragment != null)
                {
                    com.tencent.open.a.k.b("AuthAgent", "startAssitActivity fragment");
                    a(fragment, k);
                } else
                {
                    com.tencent.open.a.k.b("AuthAgent", "startAssitActivity activity");
                    a(activity, k);
                }
                com.tencent.open.a.k.c("openSDK_LOG", "startActionActivity() -- end");
                com.tencent.open.b.d.a().a(0, "LOGIN_CHECK_SDK", "1000", b.b(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                return true;
            }
        }
        com.tencent.open.b.d.a().a(1, "LOGIN_CHECK_SDK", "1000", b.b(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        com.tencent.open.a.k.c("openSDK_LOG", "startActionActivity() -- end");
        return false;
    }

    static com.tencent.connect.b.m b(a a1)
    {
        return a1.b;
    }

    private void b(String s)
    {
        try
        {
            Object obj = com.tencent.open.utils.m.d(s);
            s = ((JSONObject) (obj)).getString("access_token");
            String s1 = ((JSONObject) (obj)).getString("expires_in");
            obj = ((JSONObject) (obj)).getString("openid");
            if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1) && !TextUtils.isEmpty(((CharSequence) (obj))))
            {
                b.a(s, s1);
                b.a(((String) (obj)));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    static com.tencent.connect.b.m c(a a1)
    {
        return a1.b;
    }

    static com.tencent.connect.b.m d(a a1)
    {
        return a1.b;
    }

    static Activity e(a a1)
    {
        return a1.m;
    }

    static com.tencent.connect.b.m f(a a1)
    {
        return a1.b;
    }

    static Bundle g(a a1)
    {
        return a1.d();
    }

    static com.tencent.connect.b.m h(a a1)
    {
        return a1.b;
    }

    public int a(Activity activity, String s, com.tencent.tauth.b b1)
    {
        return a(activity, s, b1, false, null);
    }

    public int a(Activity activity, String s, com.tencent.tauth.b b1, boolean flag, Fragment fragment)
    {
        l = s;
        m = activity;
        k = b1;
        if (a(activity, fragment, flag))
        {
            com.tencent.open.a.k.c("openSDK_LOG", "OpenUi, showUi, return Constants.UI_ACTIVITY");
            com.tencent.open.b.d.a().a(b.d(), b.b(), "2", "1", "5", "0", "0", "0");
            return 1;
        } else
        {
            com.tencent.open.b.d.a().a(b.d(), b.b(), "2", "1", "5", "1", "0", "0");
            com.tencent.open.a.k.d("openSDK_LOG", "startActivity fail show dialog.");
            k = new com.tencent.connect.b.b(this, k);
            return a(flag, k);
        }
    }

    public void a()
    {
        m = null;
        k = null;
    }

    public void a(Activity activity, int j, int i1, Intent intent)
    {
        Object obj;
        com.tencent.open.utils.k.a(new Runnable() {

            final a a;

            public void run()
            {
                com.tencent.open.utils.c.d();
            }

            
            {
                a = a.this;
                super();
            }
        });
        obj = c.iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        b b1 = (b)((Iterator) (obj)).next();
        if (b1.a != j) goto _L4; else goto _L3
_L3:
        obj = b1.b;
        c.remove(b1);
_L6:
        if (intent == null)
        {
            if (obj != null)
            {
                ((com.tencent.tauth.b) (obj)).a();
            }
            return;
        }
        b(intent.getStringExtra("key_response"));
        if (obj == null)
        {
            AssistActivity.a(activity, intent);
            return;
        }
        if (i1 == -1)
        {
            a(intent, ((com.tencent.tauth.b) (obj)));
        } else
        {
            com.tencent.open.a.k.b("openSDK_LOG", "OpenUi, onActivityResult, Constants.ACTIVITY_CANCEL");
            ((com.tencent.tauth.b) (obj)).a();
        }
        a();
        com.tencent.open.a.k.b();
        return;
_L2:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
