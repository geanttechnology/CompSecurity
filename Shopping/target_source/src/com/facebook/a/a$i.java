// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.a;

import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.internal.a;
import com.facebook.internal.b;
import com.facebook.internal.o;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.a:
//            a

static class f
{

    private List a;
    private List b;
    private int c;
    private b d;
    private String e;
    private String f;
    private final int g = 1000;

    private void a(GraphRequest graphrequest, int j, JSONArray jsonarray, boolean flag)
    {
        JSONObject jsonobject = com.facebook.internal.a.a(com.facebook.internal.b, d, f, flag, com.facebook.a.a.h());
        Object obj = jsonobject;
        if (c <= 0)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        jsonobject.put("num_skipped_events", j);
        obj = jsonobject;
_L1:
        graphrequest.a(((JSONObject) (obj)));
        Bundle bundle = graphrequest.e();
        obj = bundle;
        if (bundle == null)
        {
            obj = new Bundle();
        }
        JSONException jsonexception;
        if (!(jsonarray instanceof JSONArray))
        {
            jsonarray = jsonarray.toString();
        } else
        {
            jsonarray = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
        }
        if (jsonarray != null)
        {
            ((Bundle) (obj)).putByteArray("custom_events_file", a(((String) (jsonarray))));
            graphrequest.a(jsonarray);
        }
        graphrequest.a(((Bundle) (obj)));
        return;
        jsonexception;
        jsonexception = new JSONObject();
          goto _L1
    }

    private byte[] a(String s)
    {
        try
        {
            s = s.getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            o.a("Encoding exception: ", s);
            return null;
        }
        return s;
    }

    public int a()
    {
        this;
        JVM INSTR monitorenter ;
        int j = a.size();
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    public int a(GraphRequest graphrequest, boolean flag, boolean flag1)
    {
        this;
        JVM INSTR monitorenter ;
        JSONArray jsonarray;
        Iterator iterator;
        int j;
        j = c;
        b.addAll(a);
        a.clear();
        jsonarray = new JSONArray();
        iterator = b.iterator();
_L3:
        n n;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        n = (hasNext)iterator.next();
        if (flag) goto _L2; else goto _L1
_L1:
        if (n.b()) goto _L3; else goto _L2
_L2:
        jsonarray.put(n.c());
          goto _L3
        graphrequest;
        this;
        JVM INSTR monitorexit ;
        throw graphrequest;
        if (jsonarray.length() != 0)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        this;
        JVM INSTR monitorexit ;
        return 0;
        this;
        JVM INSTR monitorexit ;
        a(graphrequest, j, jsonarray, flag1);
        return jsonarray.length();
    }

    public void a(length length)
    {
        this;
        JVM INSTR monitorenter ;
        if (a.size() + b.size() < 1000) goto _L2; else goto _L1
_L1:
        c = c + 1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        a.add(length);
        if (true) goto _L4; else goto _L3
_L3:
        length;
        throw length;
    }

    public void a(List list)
    {
        this;
        JVM INSTR monitorenter ;
        a.addAll(list);
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
    }

    public void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        a.addAll(b);
        b.clear();
        c = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public List b()
    {
        this;
        JVM INSTR monitorenter ;
        List list;
        list = a;
        a = new ArrayList();
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    public al.b(b b1, String s, String s1)
    {
        a = new ArrayList();
        b = new ArrayList();
        d = b1;
        e = s;
        f = s1;
    }
}
