// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.onlineconfig;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.g;
import java.util.Iterator;
import org.json.JSONObject;
import u.aly.bi;
import u.aly.bj;
import u.aly.bo;
import u.aly.bp;
import u.aly.bv;

// Referenced classes of package com.umeng.analytics.onlineconfig:
//            b, UmengOnlineConfigureListener, c

public class com.umeng.analytics.onlineconfig.a
{
    public class a extends bp
    {

        final com.umeng.analytics.onlineconfig.a a;
        private JSONObject e;

        public JSONObject a()
        {
            return e;
        }

        public String b()
        {
            return d;
        }

        public a(JSONObject jsonobject)
        {
            a = com.umeng.analytics.onlineconfig.a.this;
            super(null);
            e = jsonobject;
        }
    }

    public class b extends bo
        implements Runnable
    {

        Context a;
        final com.umeng.analytics.onlineconfig.a b;

        private void b()
        {
            Object obj;
            a a1;
            String as[];
            int i1;
            obj = com.umeng.analytics.onlineconfig.a.a(b, a);
            a1 = b. new a(((JSONObject) (obj)));
            as = com.umeng.analytics.a.g;
            i1 = 0;
            obj = null;
_L5:
            if (i1 < as.length) goto _L2; else goto _L1
_L1:
            if (obj == null)
            {
                com.umeng.analytics.onlineconfig.a.a(b, null);
                return;
            }
            break; /* Loop/switch isn't completed */
_L2:
            com.umeng.analytics.onlineconfig.b b1;
            a1.a(as[i1]);
            b1 = (com.umeng.analytics.onlineconfig.b)a(a1, com/umeng/analytics/onlineconfig/b);
            obj = b1;
            if (b1 != null) goto _L1; else goto _L3
_L3:
            i1++;
            obj = b1;
            if (true) goto _L5; else goto _L4
_L4:
            if (((com.umeng.analytics.onlineconfig.b) (obj)).b)
            {
                if (com.umeng.analytics.onlineconfig.a.a(b) != null)
                {
                    com.umeng.analytics.onlineconfig.a.a(b).a(((com.umeng.analytics.onlineconfig.b) (obj)).c, ((com.umeng.analytics.onlineconfig.b) (obj)).d);
                }
                com.umeng.analytics.onlineconfig.a.a(b, a, ((com.umeng.analytics.onlineconfig.b) (obj)));
                com.umeng.analytics.onlineconfig.a.b(b, a, ((com.umeng.analytics.onlineconfig.b) (obj)));
                com.umeng.analytics.onlineconfig.a.a(b, ((com.umeng.analytics.onlineconfig.b) (obj)).a);
                return;
            } else
            {
                com.umeng.analytics.onlineconfig.a.a(b, null);
                return;
            }
        }

        public boolean a()
        {
            return false;
        }

        public void run()
        {
            if (AnalyticsConfig.UPDATE_IN_MAIN_PROCESS && !com.umeng.analytics.b.a(a))
            {
                break MISSING_BLOCK_LABEL_20;
            }
            b();
            return;
            Exception exception;
            exception;
            com.umeng.analytics.onlineconfig.a.a(b, null);
            bj.c("MobclickAgent", "reques update error", exception);
            return;
        }

        public b(Context context)
        {
            b = com.umeng.analytics.onlineconfig.a.this;
            super();
            a = context.getApplicationContext();
        }
    }


    public static final String a = "type";
    public static final String b = "package";
    public static final String c = "channel";
    public static final String d = "idmd5";
    public static final String e = "version_code";
    public static final String f = "appkey";
    public static final String g = "sdk_version";
    private final String h = "last_config_time";
    private final String i = "report_policy";
    private final String j = "online_config";
    private UmengOnlineConfigureListener k;
    private c l;
    private long m;

    public com.umeng.analytics.onlineconfig.a()
    {
        k = null;
        l = null;
        m = 0L;
    }

    static c a(com.umeng.analytics.onlineconfig.a a1)
    {
        return a1.l;
    }

    static JSONObject a(com.umeng.analytics.onlineconfig.a a1, Context context)
    {
        return a1.b(context);
    }

    private void a(Context context, com.umeng.analytics.onlineconfig.b b1)
    {
        android.content.SharedPreferences.Editor editor = com.umeng.analytics.g.a(context).g().edit();
        if (!TextUtils.isEmpty(b1.e))
        {
            editor.putString("umeng_last_config_time", b1.e);
            editor.commit();
        }
        if (b1.c != -1)
        {
            com.umeng.analytics.g.a(context).a(b1.c, b1.d);
        }
    }

    static void a(com.umeng.analytics.onlineconfig.a a1, Context context, com.umeng.analytics.onlineconfig.b b1)
    {
        a1.a(context, b1);
    }

    static void a(com.umeng.analytics.onlineconfig.a a1, JSONObject jsonobject)
    {
        a1.a(jsonobject);
    }

    private void a(JSONObject jsonobject)
    {
        if (k != null)
        {
            k.onDataReceived(jsonobject);
        }
    }

    private JSONObject b(Context context)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("type", "online_config");
            jsonobject.put("appkey", AnalyticsConfig.getAppkey(context));
            jsonobject.put("version_code", bi.c(context));
            jsonobject.put("package", bi.u(context));
            jsonobject.put("sdk_version", "5.2.4");
            jsonobject.put("idmd5", bv.b(bi.f(context)));
            jsonobject.put("channel", AnalyticsConfig.getChannel(context));
            jsonobject.put("report_policy", com.umeng.analytics.g.a(context).a()[0]);
            jsonobject.put("last_config_time", c(context));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "exception in onlineConfigInternal");
            return null;
        }
        return jsonobject;
    }

    private void b(Context context, com.umeng.analytics.onlineconfig.b b1)
    {
        if (b1.a == null || b1.a.length() == 0)
        {
            return;
        }
        context = com.umeng.analytics.g.a(context).g().edit();
        Iterator iterator;
        b1 = b1.a;
        iterator = b1.keys();
_L1:
        if (!iterator.hasNext())
        {
            context.commit();
            bj.a("MobclickAgent", (new StringBuilder("get online setting params: ")).append(b1).toString());
            return;
        }
        try
        {
            String s = (String)iterator.next();
            context.putString(s, b1.getString(s));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.c("MobclickAgent", "save online config params", context);
            return;
        }
          goto _L1
    }

    static void b(com.umeng.analytics.onlineconfig.a a1, Context context, com.umeng.analytics.onlineconfig.b b1)
    {
        a1.b(context, b1);
    }

    private String c(Context context)
    {
        return com.umeng.analytics.g.a(context).g().getString("umeng_last_config_time", "");
    }

    public void a()
    {
        k = null;
    }

    public void a(Context context)
    {
        if (context == null)
        {
            try
            {
                bj.b("MobclickAgent", "unexpected null context in updateOnlineConfig");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                bj.b("MobclickAgent", "exception in updateOnlineConfig");
            }
            break MISSING_BLOCK_LABEL_57;
        }
        if (bj.a && bi.w(context))
        {
            (new Thread(new b(context.getApplicationContext()))).start();
            return;
        }
        break MISSING_BLOCK_LABEL_58;
        return;
        long l1 = System.currentTimeMillis();
        if (l1 - m > 0x36ee80L)
        {
            m = l1;
            (new Thread(new b(context.getApplicationContext()))).start();
        }
        return;
    }

    public void a(UmengOnlineConfigureListener umengonlineconfigurelistener)
    {
        k = umengonlineconfigurelistener;
    }

    public void a(c c1)
    {
        l = c1;
    }

    public void b()
    {
        l = null;
    }
}
