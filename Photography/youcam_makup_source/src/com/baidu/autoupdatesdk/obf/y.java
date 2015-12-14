// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import com.baidu.android.bba.common.util.CommonParam;
import org.json.JSONObject;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            x, ak, af, am, 
//            w

public class y extends x
{

    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private String g;

    protected y(Context context, String s)
    {
        super(context, s);
    }

    public static y a(Context context)
    {
        y y1 = new y(context, "http://appu.91.com/AppU/Api?ActionID=_ActionID&Ver=_Ver/");
        y1.a((short)1002);
        y1.a = ak.a(context);
        y1.b = ak.b(context);
        y1.c = context.getPackageName();
        y1.d = (new StringBuilder()).append(af.b(context)).append("").toString();
        y1.e = b(context);
        y1.f = 1;
        y1.g = am.b();
        return y1;
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

    protected boolean a(int i, w w, JSONObject jsonobject)
    {
        return true;
    }

    protected JSONObject g()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("AppId", a);
        jsonobject.put("AppKey", b);
        jsonobject.put("AppPackage", c);
        jsonobject.put("AppVersionCode", d);
        jsonobject.put("CUID", e);
        jsonobject.put("IsNew", f);
        jsonobject.put("IPAddress", g);
        return jsonobject;
    }
}
