// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import com.facebook.internal.j;
import com.facebook.internal.o;
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
//            h, GraphRequest, AccessToken, f, 
//            q, m

public class n
{

    private final HttpURLConnection a;
    private final JSONObject b;
    private final JSONArray c;
    private final h d;
    private final String e;
    private final GraphRequest f;

    n(GraphRequest graphrequest, HttpURLConnection httpurlconnection, h h1)
    {
        this(graphrequest, httpurlconnection, null, null, null, h1);
    }

    n(GraphRequest graphrequest, HttpURLConnection httpurlconnection, String s, JSONArray jsonarray)
    {
        this(graphrequest, httpurlconnection, s, null, jsonarray, null);
    }

    n(GraphRequest graphrequest, HttpURLConnection httpurlconnection, String s, JSONObject jsonobject)
    {
        this(graphrequest, httpurlconnection, s, jsonobject, null, null);
    }

    n(GraphRequest graphrequest, HttpURLConnection httpurlconnection, String s, JSONObject jsonobject, JSONArray jsonarray, h h1)
    {
        f = graphrequest;
        a = httpurlconnection;
        e = s;
        b = jsonobject;
        c = jsonarray;
        d = h1;
    }

    private static n a(GraphRequest graphrequest, HttpURLConnection httpurlconnection, Object obj, Object obj1)
        throws JSONException
    {
        Object obj2 = obj;
        if (obj instanceof JSONObject)
        {
            obj = (JSONObject)obj;
            obj1 = h.a(((JSONObject) (obj)), obj1, httpurlconnection);
            if (obj1 != null)
            {
                if (((h) (obj1)).b() == 190 && o.a(graphrequest.f()))
                {
                    AccessToken.a(null);
                }
                return new n(graphrequest, httpurlconnection, ((h) (obj1)));
            }
            obj = o.a(((JSONObject) (obj)), "body", "FACEBOOK_NON_JSON_RESULT");
            if (obj instanceof JSONObject)
            {
                return new n(graphrequest, httpurlconnection, obj.toString(), (JSONObject)obj);
            }
            if (obj instanceof JSONArray)
            {
                return new n(graphrequest, httpurlconnection, obj.toString(), (JSONArray)obj);
            }
            obj2 = JSONObject.NULL;
        }
        if (obj2 == JSONObject.NULL)
        {
            return new n(graphrequest, httpurlconnection, obj2.toString(), (JSONObject)null);
        } else
        {
            throw new f((new StringBuilder()).append("Got unexpected object type in response, class: ").append(obj2.getClass().getSimpleName()).toString());
        }
    }

    static List a(InputStream inputstream, HttpURLConnection httpurlconnection, m m1)
        throws f, JSONException, IOException
    {
        inputstream = o.a(inputstream);
        j.a(q.c, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", new Object[] {
            Integer.valueOf(inputstream.length()), inputstream
        });
        return a(((String) (inputstream)), httpurlconnection, m1);
    }

    static List a(String s, HttpURLConnection httpurlconnection, m m1)
        throws f, JSONException, IOException
    {
        httpurlconnection = a(httpurlconnection, ((List) (m1)), (new JSONTokener(s)).nextValue());
        j.a(q.a, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", new Object[] {
            m1.b(), Integer.valueOf(s.length()), httpurlconnection
        });
        return httpurlconnection;
    }

    static List a(HttpURLConnection httpurlconnection, m m1)
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
        list = a(inputstream, httpurlconnection, m1);
        o.a(inputstream);
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
        j.a(q.a, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = inputstream1;
        httpurlconnection = a(((List) (m1)), httpurlconnection, ((f) (obj)));
        o.a(inputstream1);
        return httpurlconnection;
        obj;
        obj1 = obj2;
        j.a(q.a, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = obj2;
        httpurlconnection = a(((List) (m1)), httpurlconnection, new f(((Throwable) (obj))));
        o.a(((java.io.Closeable) (obj2)));
        return httpurlconnection;
        obj;
        obj1 = inputstream2;
        j.a(q.a, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = inputstream2;
        httpurlconnection = a(((List) (m1)), httpurlconnection, new f(((Throwable) (obj))));
        o.a(inputstream2);
        return httpurlconnection;
        obj;
        obj1 = inputstream3;
        j.a(q.a, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = inputstream3;
        httpurlconnection = a(((List) (m1)), httpurlconnection, new f(((Throwable) (obj))));
        o.a(inputstream3);
        return httpurlconnection;
        httpurlconnection;
        o.a(((java.io.Closeable) (obj1)));
        throw httpurlconnection;
    }

    private static List a(HttpURLConnection httpurlconnection, List list, Object obj)
        throws f, JSONException
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
            throw new f("Unexpected number of results");
        }
        break MISSING_BLOCK_LABEL_196;
_L4:
        i = 200;
          goto _L5
        obj1;
        arraylist.add(new n(graphrequest, httpurlconnection, new h(httpurlconnection, ((Exception) (obj1)))));
        obj1 = obj;
          goto _L6
        obj1;
        arraylist.add(new n(graphrequest, httpurlconnection, new h(httpurlconnection, ((Exception) (obj1)))));
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
                arraylist.add(new n(graphrequest1, httpurlconnection, new h(httpurlconnection, jsonexception)));
            }
            catch (f f1)
            {
                arraylist.add(new n(graphrequest1, httpurlconnection, new h(httpurlconnection, f1)));
            }
            k++;
        }
        return arraylist;
          goto _L5
    }

    static List a(List list, HttpURLConnection httpurlconnection, f f1)
    {
        int k = list.size();
        ArrayList arraylist = new ArrayList(k);
        for (int i = 0; i < k; i++)
        {
            arraylist.add(new n((GraphRequest)list.get(i), httpurlconnection, new h(httpurlconnection, f1)));
        }

        return arraylist;
    }

    public final h a()
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
