// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.support.v7.jv;
import android.support.v7.kb;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.facebook:
//            j, GraphRequest, AccessToken, h, 
//            s, o

public class p
{

    private final HttpURLConnection a;
    private final JSONObject b;
    private final JSONArray c;
    private final j d;
    private final String e;
    private final GraphRequest f;

    p(GraphRequest graphrequest, HttpURLConnection httpurlconnection, j j1)
    {
        this(graphrequest, httpurlconnection, null, null, null, j1);
    }

    p(GraphRequest graphrequest, HttpURLConnection httpurlconnection, String s1, JSONArray jsonarray)
    {
        this(graphrequest, httpurlconnection, s1, null, jsonarray, null);
    }

    p(GraphRequest graphrequest, HttpURLConnection httpurlconnection, String s1, JSONObject jsonobject)
    {
        this(graphrequest, httpurlconnection, s1, jsonobject, null, null);
    }

    p(GraphRequest graphrequest, HttpURLConnection httpurlconnection, String s1, JSONObject jsonobject, JSONArray jsonarray, j j1)
    {
        f = graphrequest;
        a = httpurlconnection;
        e = s1;
        b = jsonobject;
        c = jsonarray;
        d = j1;
    }

    private static p a(GraphRequest graphrequest, HttpURLConnection httpurlconnection, Object obj, Object obj1)
        throws JSONException
    {
        Object obj2 = obj;
        if (obj instanceof JSONObject)
        {
            obj = (JSONObject)obj;
            obj1 = j.a(((JSONObject) (obj)), obj1, httpurlconnection);
            if (obj1 != null)
            {
                if (((j) (obj1)).b() == 190 && kb.a(graphrequest.f()))
                {
                    AccessToken.a(null);
                }
                return new p(graphrequest, httpurlconnection, ((j) (obj1)));
            }
            obj = kb.a(((JSONObject) (obj)), "body", "FACEBOOK_NON_JSON_RESULT");
            if (obj instanceof JSONObject)
            {
                return new p(graphrequest, httpurlconnection, obj.toString(), (JSONObject)obj);
            }
            if (obj instanceof JSONArray)
            {
                return new p(graphrequest, httpurlconnection, obj.toString(), (JSONArray)obj);
            }
            obj2 = JSONObject.NULL;
        }
        if (obj2 == JSONObject.NULL)
        {
            return new p(graphrequest, httpurlconnection, obj2.toString(), (JSONObject)null);
        } else
        {
            throw new h((new StringBuilder()).append("Got unexpected object type in response, class: ").append(obj2.getClass().getSimpleName()).toString());
        }
    }

    static List a(InputStream inputstream, HttpURLConnection httpurlconnection, o o1)
        throws h, JSONException, IOException
    {
        inputstream = kb.a(inputstream);
        jv.a(s.c, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", new Object[] {
            Integer.valueOf(inputstream.length()), inputstream
        });
        return a(((String) (inputstream)), httpurlconnection, o1);
    }

    static List a(String s1, HttpURLConnection httpurlconnection, o o1)
        throws h, JSONException, IOException
    {
        httpurlconnection = a(httpurlconnection, ((List) (o1)), (new JSONTokener(s1)).nextValue());
        jv.a(s.a, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", new Object[] {
            o1.b(), Integer.valueOf(s1.length()), httpurlconnection
        });
        return httpurlconnection;
    }

    static List a(HttpURLConnection httpurlconnection, o o1)
    {
        InputStream inputstream;
        Object obj1;
        InputStream inputstream1;
        Object obj2;
        InputStream inputstream2;
        InputStream inputstream3;
        List list;
        Object obj3;
        Object obj4;
        Object obj5;
        list = null;
        obj3 = null;
        obj4 = null;
        obj5 = null;
        inputstream = null;
        inputstream1 = inputstream;
        obj2 = list;
        inputstream2 = obj3;
        inputstream3 = obj4;
        obj1 = obj5;
        if (httpurlconnection.getResponseCode() < 400) goto _L2; else goto _L1
_L1:
        inputstream1 = inputstream;
        obj2 = list;
        inputstream2 = obj3;
        inputstream3 = obj4;
        obj1 = obj5;
        inputstream = httpurlconnection.getErrorStream();
_L4:
        inputstream1 = inputstream;
        obj2 = inputstream;
        inputstream2 = inputstream;
        inputstream3 = inputstream;
        obj1 = inputstream;
        list = a(inputstream, httpurlconnection, o1);
        kb.a(inputstream);
        return list;
_L2:
        inputstream1 = inputstream;
        obj2 = list;
        inputstream2 = obj3;
        inputstream3 = obj4;
        obj1 = obj5;
        inputstream = httpurlconnection.getInputStream();
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        obj1 = inputstream1;
        jv.a(s.a, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = inputstream1;
        httpurlconnection = a(((List) (o1)), httpurlconnection, ((h) (obj)));
        kb.a(inputstream1);
        return httpurlconnection;
        obj;
        obj1 = obj2;
        jv.a(s.a, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = obj2;
        httpurlconnection = a(((List) (o1)), httpurlconnection, new h(((Throwable) (obj))));
        kb.a(((java.io.Closeable) (obj2)));
        return httpurlconnection;
        obj;
        obj1 = inputstream2;
        jv.a(s.a, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = inputstream2;
        httpurlconnection = a(((List) (o1)), httpurlconnection, new h(((Throwable) (obj))));
        kb.a(inputstream2);
        return httpurlconnection;
        obj;
        obj1 = inputstream3;
        jv.a(s.a, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = inputstream3;
        httpurlconnection = a(((List) (o1)), httpurlconnection, new h(((Throwable) (obj))));
        kb.a(inputstream3);
        return httpurlconnection;
        httpurlconnection;
        kb.a(((java.io.Closeable) (obj1)));
        throw httpurlconnection;
    }

    private static List a(HttpURLConnection httpurlconnection, List list, Object obj)
        throws h, JSONException
    {
        ArrayList arraylist;
        boolean flag;
        int l;
        flag = false;
        l = list.size();
        arraylist = new ArrayList(l);
        if (l != 1) goto _L2; else goto _L1
_L1:
        GraphRequest graphrequest = (GraphRequest)list.get(0);
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("body", obj);
        if (httpurlconnection == null) goto _L4; else goto _L3
_L3:
        int i = httpurlconnection.getResponseCode();
_L5:
        Object obj1;
        jsonobject.put("code", i);
        obj1 = new JSONArray();
        ((JSONArray) (obj1)).put(jsonobject);
_L6:
        if (!(obj1 instanceof JSONArray) || ((JSONArray)obj1).length() != l)
        {
            throw new h("Unexpected number of results");
        }
        break MISSING_BLOCK_LABEL_196;
_L4:
        i = 200;
          goto _L5
        obj1;
        arraylist.add(new p(graphrequest, httpurlconnection, new j(httpurlconnection, ((Exception) (obj1)))));
        obj1 = obj;
          goto _L6
        obj1;
        arraylist.add(new p(graphrequest, httpurlconnection, new j(httpurlconnection, ((Exception) (obj1)))));
_L2:
        obj1 = obj;
          goto _L6
        obj1 = (JSONArray)obj1;
        int k = ((flag) ? 1 : 0);
        while (k < ((JSONArray) (obj1)).length()) 
        {
            GraphRequest graphrequest1 = (GraphRequest)list.get(k);
            try
            {
                arraylist.add(a(graphrequest1, httpurlconnection, ((JSONArray) (obj1)).get(k), obj));
            }
            catch (JSONException jsonexception)
            {
                arraylist.add(new p(graphrequest1, httpurlconnection, new j(httpurlconnection, jsonexception)));
            }
            catch (h h1)
            {
                arraylist.add(new p(graphrequest1, httpurlconnection, new j(httpurlconnection, h1)));
            }
            k++;
        }
        return arraylist;
          goto _L5
    }

    static List a(List list, HttpURLConnection httpurlconnection, h h1)
    {
        int k = list.size();
        ArrayList arraylist = new ArrayList(k);
        for (int i = 0; i < k; i++)
        {
            arraylist.add(new p((GraphRequest)list.get(i), httpurlconnection, new j(httpurlconnection, h1)));
        }

        return arraylist;
    }

    public final j a()
    {
        return d;
    }

    public final JSONObject b()
    {
        return b;
    }

    public String toString()
    {
        Object obj = Locale.US;
        if (a == null) goto _L2; else goto _L1
_L1:
        int i = a.getResponseCode();
_L3:
        obj = String.format(((Locale) (obj)), "%d", new Object[] {
            Integer.valueOf(i)
        });
_L4:
        return (new StringBuilder()).append("{Response: ").append(" responseCode: ").append(((String) (obj))).append(", graphObject: ").append(b).append(", error: ").append(d).append("}").toString();
_L2:
        i = 200;
          goto _L3
        IOException ioexception;
        ioexception;
        ioexception = "unknown";
          goto _L4
    }
}
