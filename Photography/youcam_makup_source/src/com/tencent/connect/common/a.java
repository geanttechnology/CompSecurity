// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.connect.b.l;
import com.tencent.open.a.k;
import com.tencent.open.utils.c;
import com.tencent.open.utils.i;
import com.tencent.open.utils.m;
import com.tencent.tauth.b;
import com.tencent.tauth.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.common:
//            AssistActivity, b

public abstract class a
{

    protected static int e = 1000;
    public static String g = null;
    public static String h = null;
    public static String i = null;
    public static boolean j = false;
    private static final String k = com/tencent/connect/common/a.getName();
    protected l a;
    protected com.tencent.connect.b.m b;
    protected List c;
    protected Intent d;
    protected b f;

    public a(l l, com.tencent.connect.b.m m1)
    {
        c = null;
        d = null;
        f = null;
        a = l;
        b = m1;
        c = new ArrayList();
    }

    public a(com.tencent.connect.b.m m1)
    {
        this(null, m1);
    }

    private Intent a(Activity activity)
    {
        activity = new Intent(activity.getApplicationContext(), com/tencent/connect/common/AssistActivity);
        activity.putExtra("is_login", true);
        return activity;
    }

    public static void a(Intent intent, b b1)
    {
        if (intent == null)
        {
            b1.a();
        } else
        {
            Object obj = intent.getStringExtra("key_action");
            if ("action_login".equals(obj))
            {
                int l = intent.getIntExtra("key_error_code", 0);
                if (l == 0)
                {
                    intent = intent.getStringExtra("key_response");
                    if (intent != null)
                    {
                        try
                        {
                            b1.a(m.d(intent));
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            b1.a(new d(-4, "\u670D\u52A1\u5668\u8FD4\u56DE\u6570\u636E\u683C\u5F0F\u6709\u8BEF!", intent));
                        }
                        com.tencent.open.a.k.b("openSDK_LOG", "OpenUi, onActivityResult, json error", ((Throwable) (obj)));
                        return;
                    } else
                    {
                        com.tencent.open.a.k.b("openSDK_LOG", "OpenUi, onActivityResult, onComplete");
                        b1.a(new JSONObject());
                        return;
                    }
                } else
                {
                    com.tencent.open.a.k.e("openSDK_LOG", (new StringBuilder()).append("OpenUi, onActivityResult, onError = ").append(l).append("").toString());
                    b1.a(new d(l, intent.getStringExtra("key_error_msg"), intent.getStringExtra("key_error_detail")));
                    return;
                }
            }
            if ("action_share".equals(obj))
            {
                String s1 = intent.getStringExtra("result");
                String s = intent.getStringExtra("response");
                if ("cancel".equals(s1))
                {
                    b1.a();
                    return;
                }
                if ("error".equals(s1))
                {
                    b1.a(new d(-6, "unknown error", (new StringBuilder()).append(s).append("").toString()));
                    return;
                }
                if ("complete".equals(s1))
                {
                    if (s == null)
                    {
                        intent = "{\"ret\": 0}";
                    } else
                    {
                        intent = s;
                    }
                    try
                    {
                        b1.a(new JSONObject(intent));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Intent intent)
                    {
                        intent.printStackTrace();
                    }
                    b1.a(new d(-4, "json error", (new StringBuilder()).append(s).append("").toString()));
                    return;
                }
            }
        }
    }

    protected Intent a(String s)
    {
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", s);
        if (com.tencent.open.utils.i.a(com.tencent.open.utils.c.a(), intent))
        {
            return intent;
        } else
        {
            return null;
        }
    }

    public void a()
    {
    }

    public void a(Activity activity, int l, int i1, Intent intent)
    {
        Object obj = c.iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        com.tencent.connect.common.b b1 = (com.tencent.connect.common.b)((Iterator) (obj)).next();
        if (b1.a != l) goto _L4; else goto _L3
_L3:
        obj = b1.b;
        c.remove(b1);
_L6:
        if (obj == null)
        {
            com.tencent.open.a.k.b(k, "BaseApi--onActivityResult-- listener == null");
            AssistActivity.a(activity, intent);
            return;
        }
        if (i1 == -1)
        {
            a(intent, ((b) (obj)));
        } else
        {
            com.tencent.open.a.k.b("openSDK_LOG", "OpenUi, onActivityResult, Constants.ACTIVITY_CANCEL");
            ((b) (obj)).a();
        }
        com.tencent.open.a.k.b();
        return;
_L2:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void a(Activity activity, b b1)
    {
        AssistActivity.a(this);
        int l = e;
        e = l + 1;
        d.putExtra("key_request_code", l);
        c.add(new com.tencent.connect.common.b(this, l, b1));
        activity.startActivityForResult(a(activity), 10100);
    }

    protected void a(Fragment fragment, b b1)
    {
        AssistActivity.a(this);
        int l = e;
        e = l + 1;
        d.putExtra("key_request_code", l);
        c.add(new com.tencent.connect.common.b(this, l, b1));
        fragment.startActivityForResult(a(((Activity) (fragment.getActivity()))), 10100);
    }

    Intent b()
    {
        return d;
    }

    protected Bundle c()
    {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", android.os.Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", android.os.Build.VERSION.SDK);
        bundle.putString("sdkv", "2.9.1.lite");
        bundle.putString("sdkp", "a");
        if (b != null && b.a())
        {
            bundle.putString("access_token", b.c());
            bundle.putString("oauth_consumer_key", b.b());
            bundle.putString("openid", b.d());
            bundle.putString("appid_for_getting_config", b.b());
        }
        SharedPreferences sharedpreferences = com.tencent.open.utils.c.a().getSharedPreferences("pfStore", 0);
        if (j)
        {
            bundle.putString("pf", (new StringBuilder()).append("desktop_m_qq-").append(h).append("-").append("android").append("-").append(g).append("-").append(i).toString());
            return bundle;
        } else
        {
            bundle.putString("pf", sharedpreferences.getString("pf", "openmobile_android"));
            return bundle;
        }
    }

    protected Bundle d()
    {
        Bundle bundle = new Bundle();
        bundle.putString("appid", b.b());
        if (b.a())
        {
            bundle.putString("keystr", b.c());
            bundle.putString("keytype", "0x80");
        }
        Object obj = b.d();
        if (obj != null)
        {
            bundle.putString("hopenid", ((String) (obj)));
        }
        bundle.putString("platform", "androidqz");
        obj = com.tencent.open.utils.c.a().getSharedPreferences("pfStore", 0);
        if (j)
        {
            bundle.putString("pf", (new StringBuilder()).append("desktop_m_qq-").append(h).append("-").append("android").append("-").append(g).append("-").append(i).toString());
        } else
        {
            bundle.putString("pf", ((SharedPreferences) (obj)).getString("pf", "openmobile_android"));
            bundle.putString("pf", "openmobile_android");
        }
        bundle.putString("sdkv", "2.9.1.lite");
        bundle.putString("sdkp", "a");
        return bundle;
    }

    protected boolean e()
    {
        if (d != null)
        {
            return com.tencent.open.utils.i.a(com.tencent.open.utils.c.a(), d);
        } else
        {
            return false;
        }
    }

}
