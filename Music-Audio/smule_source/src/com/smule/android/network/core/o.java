// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import android.util.Log;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;

// Referenced classes of package com.smule.android.network.core:
//            p, r, q

public class o
{

    private static final String m = com/smule/android/network/core/o.getName();
    public p a;
    public int b;
    public String c;
    public int d;
    public String e;
    public int f;
    public String g;
    public String h;
    public HttpResponse i;
    public JsonNode j;
    protected JsonNode k;
    public String l;
    private String n;

    public o(String s)
    {
        a = p.e;
        b = -1;
        if (s != null)
        {
            b(s);
        }
    }

    public o(HttpResponse httpresponse, String s)
    {
        a = p.e;
        b = -1;
        n = s;
        if (httpresponse == null) goto _L2; else goto _L1
_L1:
        s = "";
        String s1 = r.a(httpresponse);
        s = s1;
_L4:
        b(s);
        a(httpresponse);
        i = httpresponse;
_L2:
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        a = p.f;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int a(JsonNode jsonnode, String s, int i1)
    {
        return ((Integer)a(jsonnode, s, Integer.valueOf(i1), new q() {

            public Integer a(JsonNode jsonnode1, Integer integer)
            {
                Log.d(o.c(), (new StringBuilder()).append("node as Int ").append(jsonnode1).append(" ret ").append(jsonnode1.asInt()).toString());
                return Integer.valueOf(jsonnode1.asInt(integer.intValue()));
            }

            public volatile Object a(JsonNode jsonnode1, Object obj)
            {
                return a(jsonnode1, (Integer)obj);
            }

        })).intValue();
    }

    public static long a(JsonNode jsonnode, String s, long l1)
    {
        return ((Long)a(jsonnode, s, Long.valueOf(l1), new q() {

            public Long a(JsonNode jsonnode1, Long long1)
            {
                return Long.valueOf(jsonnode1.asLong(long1.longValue()));
            }

            public volatile Object a(JsonNode jsonnode1, Object obj)
            {
                return a(jsonnode1, (Long)obj);
            }

        })).longValue();
    }

    protected static JsonNode a(JsonNode jsonnode, String s)
    {
        if (jsonnode != null)
        {
            jsonnode = jsonnode.get(s);
            if (jsonnode != null)
            {
                return jsonnode;
            }
        }
        return null;
    }

    private static Object a(JsonNode jsonnode, String s, Object obj, q q1)
    {
        s = new ArrayList(Arrays.asList(s.split("\\.")));
        String s1 = (String)s.remove(s.size() - 1);
        for (s = s.iterator(); s.hasNext();)
        {
            jsonnode = a(jsonnode, (String)s.next());
        }

        s = ((String) (obj));
        if (jsonnode != null)
        {
            jsonnode = jsonnode.get(s1);
            s = ((String) (obj));
            if (jsonnode != null)
            {
                s = ((String) (q1.a(jsonnode, obj)));
            }
        }
        return s;
    }

    static String a(o o1)
    {
        return o1.n;
    }

    public static boolean a(JsonNode jsonnode, String s, boolean flag)
    {
        boolean flag1 = flag;
        if (jsonnode != null)
        {
            jsonnode = jsonnode.get(s);
            flag1 = flag;
            if (jsonnode != null)
            {
                flag1 = jsonnode.asBoolean(flag);
            }
        }
        return flag1;
    }

    public static String b(JsonNode jsonnode, String s)
    {
        return (String)a(jsonnode, s, null, new q() {

            public volatile Object a(JsonNode jsonnode1, Object obj)
            {
                return a(jsonnode1, (String)obj);
            }

            public String a(JsonNode jsonnode1, String s1)
            {
                return jsonnode1.asText(s1);
            }

        });
    }

    static String c()
    {
        return m;
    }

    public int a(String s, int i1)
    {
        return a(j, s, i1);
    }

    protected String a(JsonNode jsonnode)
    {
        Object obj = Arrays.asList(new String[] {
            "email", "handle", "webUrl"
        });
        jsonnode = (ObjectNode)jsonnode.deepCopy();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            String s = (String)((Iterator) (obj)).next();
            Iterator iterator = jsonnode.findParents(s).iterator();
            while (iterator.hasNext()) 
            {
                ((ObjectNode)(JsonNode)iterator.next()).remove(s);
            }
        }

        return jsonnode.toString();
    }

    public String a(String s)
    {
        return b(j, s);
    }

    protected void a(HttpMessage httpmessage)
    {
        if (httpmessage.containsHeader("etag"))
        {
            l = httpmessage.getFirstHeader("etag").getValue();
        }
    }

    public boolean a()
    {
        return a == p.a && b == 0;
    }

    public JsonNode b()
    {
        return j;
    }

    protected void b(String s)
    {
        ObjectMapper objectmapper;
        h = s;
        if (s == null || s.equals(""))
        {
            Log.i("NetworkResponse", "Empty response from server");
            return;
        }
        objectmapper = new ObjectMapper();
        k = (JsonNode)objectmapper.readValue(s, com/fasterxml/jackson/databind/JsonNode);
        if (k.has("status"))
        {
            JsonNode jsonnode = k.get("status");
            b = a(jsonnode, "code", 1);
            c = b(jsonnode, "message");
            e = b(jsonnode, "info");
            d = a(jsonnode, "version", -1);
        }
        if (k.has("data"))
        {
            j = k.get("data");
            f = a(j, "reason", 0);
            g = b(j, "session");
            if (g == null)
            {
                g = b(j, "sessionToken");
            }
        }
        if (b != 0)
        {
            if (b != 51)
            {
                break MISSING_BLOCK_LABEL_299;
            }
            Log.d(m, "Session expired");
        }
_L1:
        IOException ioexception;
        if (s.length() > 50000)
        {
            Log.i("NetworkResponse", String.format("response (too big to log, thread will log response later) (%s)", new Object[] {
                n
            }));
            (new Thread(new Runnable() {

                final o a;

                public void run()
                {
                    Log.i("NetworkResponse", String.format("response (delayed log) (%s) : %s", new Object[] {
                        o.a(a), a.a(a.k)
                    }));
                }

            
            {
                a = o.this;
                super();
            }
            })).start();
            return;
        }
        break MISSING_BLOCK_LABEL_344;
        try
        {
            Log.e("NetworkResponse", (new StringBuilder()).append("Error code returned from server: ").append(b).append(", for API ").append(n).toString());
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            Log.e("NetworkResponse", (new StringBuilder()).append("Error parsing json response: ").append(s).toString(), ioexception);
            return;
        }
          goto _L1
        Log.i("NetworkResponse", String.format("response (%s) : %s", new Object[] {
            n, a(k)
        }));
        return;
    }

}
