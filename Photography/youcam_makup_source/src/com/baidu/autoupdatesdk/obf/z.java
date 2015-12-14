// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.bba.common.util.CommonParam;
import com.baidu.autoupdatesdk.AppUpdateInfo;
import java.io.File;
import org.json.JSONObject;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            x, ak, af, am, 
//            ag, v, ai, w, 
//            an, al, ah

public class z extends x
{

    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    protected z(Context context, String s)
    {
        super(context, s);
    }

    public static z a(Context context)
    {
        z z1 = new z(context, "http://appu.91.com/AppU/Api?ActionID=_ActionID&Ver=_Ver/");
        z1.a((short)1001);
        z1.a((short)1001);
        z1.a = ak.a(context);
        z1.b = ak.b(context);
        z1.c = context.getPackageName();
        z1.d = (new StringBuilder()).append(af.b(context)).append("").toString();
        z1.e = af.d(context);
        z1.f = b(context);
        z1.g = c(context);
        z1.h = "";
        String s;
        if (am.b(context))
        {
            s = "wf";
        } else
        {
            s = "3g";
        }
        z1.i = s;
        z1.j = (new StringBuilder()).append(ag.f(context)).append("_").append(ag.g(context)).toString();
        z1.k = (new StringBuilder()).append(android.os.Build.VERSION.SDK_INT).append("").toString();
        z1.l = am.b();
        return z1;
    }

    private static String b(Context context)
    {
        Object obj = "";
        try
        {
            context = CommonParam.getCUID(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            context = ((Context) (obj));
        }
        obj = context;
        if (context == null)
        {
            obj = "";
        }
        return ((String) (obj));
    }

    private static String c(Context context)
    {
        context = ag.d(context);
        if (!TextUtils.isEmpty(context))
        {
            StringBuilder stringbuilder = new StringBuilder();
            for (int i1 = 0; i1 < context.length(); i1++)
            {
                char c1 = context.charAt(i1);
                if (Character.isLetterOrDigit(c1))
                {
                    stringbuilder.append(c1);
                }
            }

            return stringbuilder.toString().toUpperCase(v.b);
        } else
        {
            return "";
        }
    }

    protected boolean a(int i1, w w1, JSONObject jsonobject)
    {
        if (i1 != 0 || jsonobject == null)
        {
            return true;
        }
        String s = ai.a(jsonobject, "AppSname");
        if (TextUtils.isEmpty(s))
        {
            w1.a = b("AppSname");
            return false;
        }
        String s1 = ai.a(jsonobject, "AppVersionName");
        if (TextUtils.isEmpty(s1))
        {
            w1.a = b("AppVersionName");
            return false;
        }
        String s2 = ai.a(jsonobject, "AppPackage");
        if (TextUtils.isEmpty(s2))
        {
            w1.a = b("AppPackage");
            return false;
        }
        Number number = ai.c(jsonobject, "AppVersionCode");
        if (number == null)
        {
            w1.a = b("AppVersionCode");
            return false;
        }
        String s3 = ai.a(jsonobject, "AppUrl");
        if (TextUtils.isEmpty(s3))
        {
            w1.a = b("AppUrl");
            return false;
        }
        Number number1 = ai.c(jsonobject, "AppSize");
        if (number1 == null)
        {
            w1.a = b("AppSize");
            return false;
        }
        String s4 = ai.a(jsonobject, "AppPath");
        Number number2 = ai.c(jsonobject, "AppPathSize");
        String s5 = ai.a(jsonobject, "AppIconUrl");
        if (TextUtils.isEmpty(s5))
        {
            w1.a = b("AppIconUrl");
            return false;
        }
        String s6 = ai.a(jsonobject, "AppChangeLog");
        jsonobject = ai.a(jsonobject, "AppMd5");
        i1 = number.intValue();
        long l2 = number1.longValue();
        long l1;
        if (number2 == null)
        {
            l1 = 0L;
        } else
        {
            l1 = number2.longValue();
        }
        jsonobject = new AppUpdateInfo(s, s1, s2, i1, s3, l2, s4, l1, s5, s6, jsonobject);
        w1.b = jsonobject;
        an.a(c(), jsonobject);
        return true;
    }

    protected JSONObject g()
    {
        Object obj = an.d(c());
        al al1 = new al(c(), c().getPackageName());
        al1.a();
        File file = new File(al1.a.e);
        String s = ((String) (obj));
        if (file != null)
        {
            s = ((String) (obj));
            if (file.exists())
            {
                long l1 = an.c(c());
                s = ((String) (obj));
                if (l1 != file.lastModified())
                {
                    s = ah.d(al1.a.e);
                    an.a(c(), l1);
                    an.a(c(), s);
                }
            }
        }
        obj = new JSONObject();
        ((JSONObject) (obj)).put("AppId", a);
        ((JSONObject) (obj)).put("AppKey", b);
        ((JSONObject) (obj)).put("AppPackage", c);
        ((JSONObject) (obj)).put("AppVersionCode", d);
        ((JSONObject) (obj)).put("AppSignMD5", e);
        ((JSONObject) (obj)).put("AppMD5", s);
        ((JSONObject) (obj)).put("CUID", f);
        if (!TextUtils.isEmpty(g))
        {
            ((JSONObject) (obj)).put("MAC", g);
        }
        if (!TextUtils.isEmpty(h))
        {
            ((JSONObject) (obj)).put("CID", h);
        }
        if (!TextUtils.isEmpty(i))
        {
            ((JSONObject) (obj)).put("BEAR", i);
        }
        if (!TextUtils.isEmpty(j))
        {
            ((JSONObject) (obj)).put("DPI", j);
        }
        if (!TextUtils.isEmpty(k))
        {
            ((JSONObject) (obj)).put("ApiLevel", k);
        }
        if (!TextUtils.isEmpty(l))
        {
            ((JSONObject) (obj)).put("IPAddress", l);
        }
        return ((JSONObject) (obj));
    }
}
