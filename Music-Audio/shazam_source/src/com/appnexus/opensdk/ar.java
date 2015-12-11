// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.e;
import com.appnexus.opensdk.b.i;
import com.appnexus.opensdk.b.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.appnexus.opensdk:
//            z, b, aa

final class ar
{

    String a;
    int b;
    int c;
    LinkedList d;
    HashMap e;
    boolean f;
    boolean g;
    com.appnexus.opensdk.b h;
    private String i;
    private z j;

    public ar()
    {
        e = new HashMap();
        f = false;
        g = false;
        g = true;
    }

    public ar(e e1, z z1)
    {
        e = new HashMap();
        f = false;
        g = false;
        j = z1;
        a(e1.c);
        a(e1.b);
    }

    public ar(String s, Header aheader[], z z1)
    {
        e = new HashMap();
        f = false;
        g = false;
        if (k.a(s))
        {
            com.appnexus.opensdk.b.b.a();
            return;
        } else
        {
            com.appnexus.opensdk.b.b.b(s);
            com.appnexus.opensdk.b.b.b(b.f, com.appnexus.opensdk.b.b.a(an.d.response_body, s));
            j = z1;
            a(aheader);
            a(s);
            return;
        }
    }

    private void a(String s)
    {
        boolean flag2;
        boolean flag3;
        flag3 = true;
        flag2 = true;
        if (k.a(s)) goto _L2; else goto _L1
_L1:
        Object obj = new JSONObject(s);
        s = com.appnexus.opensdk.b.i.c(((JSONObject) (obj)), "status");
        boolean flag;
        if (s != null && s.equals("error"))
        {
            s = com.appnexus.opensdk.b.i.c(((JSONObject) (obj)), "errorMessage");
            com.appnexus.opensdk.b.b.e(b.f, com.appnexus.opensdk.b.b.a(an.d.response_error, s));
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag) goto _L3; else goto _L2
_L2:
        return;
        obj;
        com.appnexus.opensdk.b.b.e(b.f, com.appnexus.opensdk.b.b.a(an.d.response_json_error, s));
        return;
_L3:
        if (j == z.c) goto _L5; else goto _L4
_L4:
        s = com.appnexus.opensdk.b.i.a(((JSONObject) (obj)), "ads");
        if (s == null) goto _L7; else goto _L6
_L6:
        s = com.appnexus.opensdk.b.i.a(s, 0);
        i = com.appnexus.opensdk.b.i.c(s, "type");
        b = com.appnexus.opensdk.b.i.d(s, "height");
        c = com.appnexus.opensdk.b.i.d(s, "width");
        a = com.appnexus.opensdk.b.i.c(s, "content");
        if (!k.a(a)) goto _L9; else goto _L8
_L8:
        com.appnexus.opensdk.b.b.e(b.f, com.appnexus.opensdk.b.b.a(an.d.blank_ad));
_L7:
        boolean flag1 = false;
_L11:
        if (flag1) goto _L2; else goto _L10
_L10:
        if (a(((JSONObject) (obj))))
        {
            return;
        }
          goto _L2
_L9:
        if (a.contains("mraid.js"))
        {
            a("MRAID", Boolean.valueOf(true));
        }
        f = true;
        flag1 = flag2;
          goto _L11
_L5:
        s = com.appnexus.opensdk.b.i.a(((JSONObject) (obj)), "native");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        s = com.appnexus.opensdk.b.i.a(s, 0);
        i = com.appnexus.opensdk.b.i.c(s, "type");
        h = com.appnexus.opensdk.b.a(s);
        if (h == null)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        f = true;
        flag1 = flag3;
_L12:
        if (flag1)
        {
            return;
        }
          goto _L10
        flag1 = false;
          goto _L12
    }

    private static void a(Header aheader[])
    {
        if (aheader != null)
        {
            int i1 = aheader.length;
            for (int l = 0; l < i1; l++)
            {
                Header header = aheader[l];
                com.appnexus.opensdk.b.b.a(b.f, com.appnexus.opensdk.b.b.a(an.d.response_header, header.getName(), header.getValue()));
            }

        }
    }

    private boolean a(JSONObject jsonobject)
    {
        JSONArray jsonarray = com.appnexus.opensdk.b.i.a(jsonobject, "mediated");
        if (jsonarray != null)
        {
            d = new LinkedList();
            for (int l = 0; l < jsonarray.length(); l++)
            {
                JSONObject jsonobject1 = com.appnexus.opensdk.b.i.a(jsonarray, l);
                if (jsonobject1 == null)
                {
                    continue;
                }
                JSONArray jsonarray1 = com.appnexus.opensdk.b.i.a(jsonobject1, "handler");
                if (jsonarray1 == null)
                {
                    continue;
                }
                for (int i1 = 0; i1 < jsonarray1.length(); i1++)
                {
                    Object obj = com.appnexus.opensdk.b.i.a(jsonarray1, i1);
                    if (obj == null)
                    {
                        continue;
                    }
                    String s = com.appnexus.opensdk.b.i.c(((JSONObject) (obj)), "type");
                    jsonobject = s;
                    if (s != null)
                    {
                        jsonobject = s.toLowerCase(Locale.US);
                    }
                    if (jsonobject == null || !jsonobject.equals("android"))
                    {
                        continue;
                    }
                    jsonobject = com.appnexus.opensdk.b.i.c(((JSONObject) (obj)), "class");
                    s = com.appnexus.opensdk.b.i.c(((JSONObject) (obj)), "param");
                    int j1 = com.appnexus.opensdk.b.i.d(((JSONObject) (obj)), "height");
                    int k1 = com.appnexus.opensdk.b.i.d(((JSONObject) (obj)), "width");
                    obj = com.appnexus.opensdk.b.i.c(((JSONObject) (obj)), "id");
                    String s1 = com.appnexus.opensdk.b.i.c(jsonobject1, "result_cb");
                    if (!k.a(jsonobject))
                    {
                        d.add(new aa(jsonobject, s, k1, j1, ((String) (obj)), s1));
                    }
                }

            }

            if (!d.isEmpty())
            {
                f = true;
                return true;
            }
        }
        return false;
    }

    final void a(String s, Object obj)
    {
        e.put(s, obj);
    }
}
