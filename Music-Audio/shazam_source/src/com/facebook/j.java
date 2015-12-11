// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import com.facebook.b.k;
import com.facebook.b.t;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.Set;
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

    private static final class b
    {

        final int a;
        final int b;

        private b()
        {
            a = 200;
            b = 299;
        }

        b(byte byte0)
        {
            this();
        }
    }


    static final b a = new b((byte)0);
    final int b;
    public final int c;
    final String d;
    public final h e;
    private final a f;
    private final int g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final JSONObject l;
    private final JSONObject m;
    private final Object n;
    private final HttpURLConnection o;

    private j(int i1, int j1, int k1, String s, String s1, String s2, String s3, 
            boolean flag, JSONObject jsonobject, JSONObject jsonobject1, Object obj, HttpURLConnection httpurlconnection, h h1)
    {
        b = i1;
        c = j1;
        g = k1;
        d = s;
        h = s1;
        m = jsonobject;
        l = jsonobject1;
        n = obj;
        o = httpurlconnection;
        i = s2;
        j = s3;
        i1 = 0;
        if (h1 != null)
        {
            e = h1;
            i1 = 1;
        } else
        {
            e = new m(this, s1);
        }
        s1 = b();
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            s = a.c;
        } else
        {
label0:
            {
                if (((k) (s1)).a == null || !((k) (s1)).a.containsKey(Integer.valueOf(j1)))
                {
                    break label0;
                }
                s = (Set)((k) (s1)).a.get(Integer.valueOf(j1));
                if (s != null && !s.contains(Integer.valueOf(k1)))
                {
                    break label0;
                }
                s = a.b;
            }
        }
_L7:
        f = s;
        s = f;
        com.facebook.b.k._cls3.a[s.ordinal()];
        JVM INSTR tableswitch 1 3: default 148
    //                   1 396
    //                   2 406
    //                   3 416;
           goto _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_416;
_L3:
        s = null;
_L10:
        k = s;
        return;
label1:
        {
            if (((k) (s1)).c == null || !((k) (s1)).c.containsKey(Integer.valueOf(j1)))
            {
                break label1;
            }
            s = (Set)((k) (s1)).c.get(Integer.valueOf(j1));
            if (s != null && !s.contains(Integer.valueOf(k1)))
            {
                break label1;
            }
            s = a.a;
        }
          goto _L7
        if (((k) (s1)).b == null || !((k) (s1)).b.containsKey(Integer.valueOf(j1))) goto _L2; else goto _L8
_L8:
        s = (Set)((k) (s1)).b.get(Integer.valueOf(j1));
        if (s != null && !s.contains(Integer.valueOf(k1))) goto _L2; else goto _L9
_L9:
        s = a.c;
          goto _L7
_L2:
        s = a.b;
          goto _L7
_L4:
        s = ((k) (s1)).d;
          goto _L10
_L5:
        s = ((k) (s1)).f;
          goto _L10
        s = ((k) (s1)).e;
          goto _L10
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
        obj1 = t.a(jsonobject, "body", "FACEBOOK_NON_JSON_RESULT");
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
        i1 = 0;
        j1 = 0;
        flag = false;
        if (!jsonobject2.has("error")) goto _L7; else goto _L6
_L6:
        Object obj2;
        String s1;
        boolean flag1;
        jsonobject1 = (JSONObject)t.a(jsonobject2, "error", null);
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
        obj1 = a;
        if (((b) (obj1)).a <= k1 && k1 <= ((b) (obj1)).b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag) goto _L2; else goto _L11
_L11:
        if (!jsonobject.has("body"))
        {
            break MISSING_BLOCK_LABEL_378;
        }
        obj1 = (JSONObject)t.a(jsonobject, "body", "FACEBOOK_NON_JSON_RESULT");
_L12:
        jsonobject = new j(k1, -1, -1, null, null, null, null, false, ((JSONObject) (obj1)), jsonobject, obj, httpurlconnection, null);
        return jsonobject;
        jsonobject;
_L2:
        return null;
        obj1 = null;
          goto _L12
    }

    private static k b()
    {
        com/facebook/j;
        JVM INSTR monitorenter ;
        Object obj = t.d(com.facebook.k.j());
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = com.facebook.b.k.a();
_L4:
        com/facebook/j;
        JVM INSTR monitorexit ;
        return ((k) (obj));
_L2:
        obj = ((com.facebook.b.t.b) (obj)).c;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final String a()
    {
        if (h != null)
        {
            return h;
        } else
        {
            return e.getLocalizedMessage();
        }
    }

    public final String toString()
    {
        return (new StringBuilder("{HttpStatus: ")).append(b).append(", errorCode: ").append(c).append(", errorType: ").append(d).append(", errorMessage: ").append(a()).append("}").toString();
    }

}
