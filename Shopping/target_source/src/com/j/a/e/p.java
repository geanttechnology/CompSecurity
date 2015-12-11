// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.a.a.a.e;
import com.a.a.a.j;
import com.a.a.l;
import com.a.a.o;
import com.a.a.t;
import com.a.a.u;
import com.j.a.g.w;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.a.a.a.a.a.a;
import org.a.a.a.a.a.c;
import org.a.a.a.a.a.g;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.json.JSONException;
import org.json.JSONObject;

public class p extends j
{

    org.a.a.a.a.j a;
    HttpEntity b;
    com.a.a.o.b c;
    com.a.a.o.a d;
    private Map e;

    public p(int i, String s, JSONObject jsonobject, Map map, com.a.a.o.b b1, com.a.a.o.a a1)
    {
        String s1;
        if (jsonobject == null)
        {
            s1 = null;
        } else
        if (!(jsonobject instanceof JSONObject))
        {
            s1 = jsonobject.toString();
        } else
        {
            s1 = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        super(i, s, s1, b1, a1);
        a = org.a.a.a.a.j.a();
        e = new HashMap();
        d = a1;
        c = b1;
        a(map);
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        map = a;
        if (jsonobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        s = jsonobject.toString();
_L3:
        map.a("body", new g(s, c.c));
_L2:
        return;
        try
        {
            s = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            w.b("Adding string to multipart entity", s);
            return;
        }
          goto _L3
    }

    private void a(Map map)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); a.a("image", new a((byte[])entry.getValue(), (String)entry.getKey())))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    protected void a(JSONObject jsonobject)
    {
        c.onResponse(jsonobject);
    }

    public void deliverError(t t)
    {
        if (t != null)
        {
            d.onErrorResponse(t);
        }
        w.b("Volley error", t);
    }

    protected void deliverResponse(Object obj)
    {
        a((JSONObject)obj);
    }

    public byte[] getBody()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            b = a.c();
            b.writeTo(bytearrayoutputstream);
        }
        catch (IOException ioexception)
        {
            u.c("IOException writing to ByteArrayOutputStream", new Object[0]);
        }
        return bytearrayoutputstream.toByteArray();
    }

    public String getBodyContentType()
    {
        return b.getContentType().getValue();
    }

    public Map getHeaders()
        throws com.a.a.a
    {
        return e;
    }

    protected o parseNetworkResponse(com.a.a.j j1)
    {
        try
        {
            j1 = o.a(JSONObjectInstrumentation.init(new String(j1.data, com.a.a.a.e.a(j1.headers))), com.a.a.a.e.a(j1));
        }
        // Misplaced declaration of an exception variable
        catch (com.a.a.j j1)
        {
            return o.a(new l(j1));
        }
        // Misplaced declaration of an exception variable
        catch (com.a.a.j j1)
        {
            return o.a(new l(j1));
        }
        return j1;
    }
}
