// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.support.v7.js;
import android.support.v7.kb;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            m, h, k

public final class j
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/facebook/j$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("LOGIN_RECOVERABLE", 0);
            b = new a("OTHER", 1);
            c = new a("TRANSIENT", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i1)
        {
            super(s, i1);
        }
    }

    private static class b
    {

        private final int a;
        private final int b;

        boolean a(int i1)
        {
            return a <= i1 && i1 <= b;
        }

        private b(int i1, int j1)
        {
            a = i1;
            b = j1;
        }

    }


    static final b a = new b(200, 299);
    private final a b;
    private final int c;
    private final int d;
    private final int e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final JSONObject k;
    private final JSONObject l;
    private final Object m;
    private final HttpURLConnection n;
    private final h o;

    private j(int i1, int j1, int k1, String s, String s1, String s2, String s3, 
            boolean flag, JSONObject jsonobject, JSONObject jsonobject1, Object obj, HttpURLConnection httpurlconnection, h h1)
    {
        c = i1;
        d = j1;
        e = k1;
        f = s;
        g = s1;
        l = jsonobject;
        k = jsonobject1;
        m = obj;
        n = httpurlconnection;
        h = s2;
        i = s3;
        i1 = 0;
        if (h1 != null)
        {
            o = h1;
            i1 = 1;
        } else
        {
            o = new m(this, s1);
        }
        s1 = f();
        if (i1 != 0)
        {
            s = a.b;
        } else
        {
            s = s1.a(j1, k1, flag);
        }
        b = s;
        j = s1.a(b);
    }

    public j(int i1, String s, String s1)
    {
        this(-1, i1, -1, s, s1, null, null, false, null, null, null, null, null);
    }

    j(HttpURLConnection httpurlconnection, Exception exception)
    {
        if (exception instanceof h)
        {
            exception = (h)exception;
        } else
        {
            exception = new h(exception);
        }
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpurlconnection, ((h) (exception)));
    }

    static j a(JSONObject jsonobject, Object obj, HttpURLConnection httpurlconnection)
    {
        if (!jsonobject.has("code")) goto _L2; else goto _L1
_L1:
        Object obj1;
        int k1;
        k1 = jsonobject.getInt("code");
        obj1 = kb.a(jsonobject, "body", "FACEBOOK_NON_JSON_RESULT");
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        if (!(obj1 instanceof JSONObject)) goto _L4; else goto _L5
_L5:
        JSONObject jsonobject2 = (JSONObject)obj1;
        String s;
        JSONObject jsonobject1;
        Object obj3;
        boolean flag;
        int i1;
        int j1;
        boolean flag2;
        obj1 = null;
        s = null;
        jsonobject1 = null;
        obj3 = null;
        flag2 = false;
        i1 = -1;
        j1 = -1;
        flag = false;
        if (!jsonobject2.has("error")) goto _L7; else goto _L6
_L6:
        Object obj2;
        String s1;
        boolean flag1;
        jsonobject1 = (JSONObject)kb.a(jsonobject2, "error", null);
        obj1 = jsonobject1.optString("type", null);
        s = jsonobject1.optString("message", null);
        i1 = jsonobject1.optInt("code", -1);
        j1 = jsonobject1.optInt("error_subcode", -1);
        obj2 = jsonobject1.optString("error_user_msg", null);
        s1 = jsonobject1.optString("error_user_title", null);
        flag1 = jsonobject1.optBoolean("is_transient", false);
        flag = true;
_L10:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        return new j(k1, i1, j1, ((String) (obj1)), s, s1, ((String) (obj2)), flag1, jsonobject2, jsonobject, obj, httpurlconnection, null);
_L7:
        if (jsonobject2.has("error_code") || jsonobject2.has("error_msg")) goto _L9; else goto _L8
_L8:
        s1 = obj3;
        obj2 = jsonobject1;
        flag1 = flag2;
        if (!jsonobject2.has("error_reason"))
        {
            continue; /* Loop/switch isn't completed */
        }
_L9:
        obj1 = jsonobject2.optString("error_reason", null);
        s = jsonobject2.optString("error_msg", null);
        i1 = jsonobject2.optInt("error_code", -1);
        j1 = jsonobject2.optInt("error_subcode", -1);
        flag = true;
        s1 = obj3;
        obj2 = jsonobject1;
        flag1 = flag2;
        if (true) goto _L10; else goto _L4
_L4:
        if (a.a(k1)) goto _L2; else goto _L11
_L11:
        if (!jsonobject.has("body"))
        {
            break MISSING_BLOCK_LABEL_353;
        }
        obj1 = (JSONObject)kb.a(jsonobject, "body", "FACEBOOK_NON_JSON_RESULT");
_L12:
        jsonobject = new j(k1, -1, -1, null, null, null, null, false, ((JSONObject) (obj1)), jsonobject, obj, httpurlconnection, null);
        return jsonobject;
        jsonobject;
_L2:
        return null;
        obj1 = null;
          goto _L12
    }

    static js f()
    {
        com/facebook/j;
        JVM INSTR monitorenter ;
        Object obj = kb.c(com.facebook.k.i());
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = js.a();
_L4:
        com/facebook/j;
        JVM INSTR monitorexit ;
        return ((js) (obj));
_L2:
        obj = ((android.support.v7.kb.b) (obj)).c();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public int a()
    {
        return c;
    }

    public int b()
    {
        return d;
    }

    public String c()
    {
        return f;
    }

    public String d()
    {
        if (g != null)
        {
            return g;
        } else
        {
            return o.getLocalizedMessage();
        }
    }

    public h e()
    {
        return o;
    }

    public String toString()
    {
        return (new StringBuilder("{HttpStatus: ")).append(c).append(", errorCode: ").append(d).append(", errorType: ").append(f).append(", errorMessage: ").append(d()).append("}").toString();
    }

}
