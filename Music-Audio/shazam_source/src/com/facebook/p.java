// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import com.facebook.b.o;
import com.facebook.b.t;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.facebook:
//            s, o, h, GraphRequest, 
//            j, AccessToken

public final class p
{

    public final JSONObject a;
    public final j b;
    private final HttpURLConnection c;
    private final JSONArray d;
    private final String e;
    private final GraphRequest f;

    p(GraphRequest graphrequest, HttpURLConnection httpurlconnection, j j1)
    {
        this(graphrequest, httpurlconnection, null, null, null, j1);
    }

    private p(GraphRequest graphrequest, HttpURLConnection httpurlconnection, String s1, JSONArray jsonarray)
    {
        this(graphrequest, httpurlconnection, s1, null, jsonarray, null);
    }

    p(GraphRequest graphrequest, HttpURLConnection httpurlconnection, String s1, JSONObject jsonobject)
    {
        this(graphrequest, httpurlconnection, s1, jsonobject, null, null);
    }

    private p(GraphRequest graphrequest, HttpURLConnection httpurlconnection, String s1, JSONObject jsonobject, JSONArray jsonarray, j j1)
    {
        f = graphrequest;
        c = httpurlconnection;
        e = s1;
        a = jsonobject;
        d = jsonarray;
        b = j1;
    }

    static List a(String s1, HttpURLConnection httpurlconnection, com.facebook.o o1)
    {
        httpurlconnection = a(httpurlconnection, ((List) (o1)), (new JSONTokener(s1)).nextValue());
        o.a(s.a, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", new Object[] {
            o1.d, Integer.valueOf(s1.length()), httpurlconnection
        });
        return httpurlconnection;
    }

    static List a(HttpURLConnection httpurlconnection, com.facebook.o o1)
    {
        java.io.InputStream inputstream;
        Object obj1;
        java.io.InputStream inputstream1;
        Object obj2;
        java.io.InputStream inputstream2;
        java.io.InputStream inputstream3;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        obj3 = null;
        obj4 = null;
        obj5 = null;
        obj6 = null;
        inputstream = null;
        inputstream1 = inputstream;
        obj2 = obj3;
        inputstream2 = obj4;
        inputstream3 = obj5;
        obj1 = obj6;
        if (httpurlconnection.getResponseCode() < 400) goto _L2; else goto _L1
_L1:
        inputstream1 = inputstream;
        obj2 = obj3;
        inputstream2 = obj4;
        inputstream3 = obj5;
        obj1 = obj6;
        inputstream = httpurlconnection.getErrorStream();
_L4:
        inputstream1 = inputstream;
        obj2 = inputstream;
        inputstream2 = inputstream;
        inputstream3 = inputstream;
        obj1 = inputstream;
        obj3 = t.a(inputstream);
        inputstream1 = inputstream;
        obj2 = inputstream;
        inputstream2 = inputstream;
        inputstream3 = inputstream;
        obj1 = inputstream;
        o.a(s.c, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", new Object[] {
            Integer.valueOf(((String) (obj3)).length()), obj3
        });
        inputstream1 = inputstream;
        obj2 = inputstream;
        inputstream2 = inputstream;
        inputstream3 = inputstream;
        obj1 = inputstream;
        obj3 = a(((String) (obj3)), httpurlconnection, o1);
        t.a(inputstream);
        return ((List) (obj3));
_L2:
        inputstream1 = inputstream;
        obj2 = obj3;
        inputstream2 = obj4;
        inputstream3 = obj5;
        obj1 = obj6;
        inputstream = httpurlconnection.getInputStream();
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        obj1 = inputstream1;
        o.a(s.a, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = inputstream1;
        httpurlconnection = a(((List) (o1)), httpurlconnection, ((h) (obj)));
        t.a(inputstream1);
        return httpurlconnection;
        obj;
        obj1 = obj2;
        o.a(s.a, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = obj2;
        httpurlconnection = a(((List) (o1)), httpurlconnection, new h(((Throwable) (obj))));
        t.a(((java.io.Closeable) (obj2)));
        return httpurlconnection;
        obj;
        obj1 = inputstream2;
        o.a(s.a, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = inputstream2;
        httpurlconnection = a(((List) (o1)), httpurlconnection, new h(((Throwable) (obj))));
        t.a(inputstream2);
        return httpurlconnection;
        obj;
        obj1 = inputstream3;
        o.a(s.a, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = inputstream3;
        httpurlconnection = a(((List) (o1)), httpurlconnection, new h(((Throwable) (obj))));
        t.a(inputstream3);
        return httpurlconnection;
        httpurlconnection;
        t.a(((java.io.Closeable) (obj1)));
        throw httpurlconnection;
    }

    private static List a(HttpURLConnection httpurlconnection, List list, Object obj)
    {
        ArrayList arraylist;
        int k;
        k = list.size();
        arraylist = new ArrayList(k);
        if (k != 1) goto _L2; else goto _L1
_L1:
        Object obj2 = (GraphRequest)list.get(0);
        Object obj3;
        obj3 = new JSONObject();
        ((JSONObject) (obj3)).put("body", obj);
        if (httpurlconnection == null) goto _L4; else goto _L3
_L3:
        int i = httpurlconnection.getResponseCode();
_L16:
        Object obj1;
        ((JSONObject) (obj3)).put("code", i);
        obj1 = new JSONArray();
        ((JSONArray) (obj1)).put(obj3);
_L6:
        if (!(obj1 instanceof JSONArray) || ((JSONArray)obj1).length() != k)
        {
            throw new h("Unexpected number of results");
        }
        break; /* Loop/switch isn't completed */
_L4:
        i = 200;
        continue; /* Loop/switch isn't completed */
        obj1;
        arraylist.add(new p(((GraphRequest) (obj2)), httpurlconnection, new j(httpurlconnection, ((Exception) (obj1)))));
        obj1 = obj;
        continue; /* Loop/switch isn't completed */
        obj1;
        arraylist.add(new p(((GraphRequest) (obj2)), httpurlconnection, new j(httpurlconnection, ((Exception) (obj1)))));
_L2:
        obj1 = obj;
        if (true) goto _L6; else goto _L5
_L5:
        obj2 = (JSONArray)obj1;
        i = 0;
_L14:
        if (i >= ((JSONArray) (obj2)).length())
        {
            break MISSING_BLOCK_LABEL_498;
        }
        obj3 = (GraphRequest)list.get(i);
        obj1 = ((JSONArray) (obj2)).get(i);
        if (!(obj1 instanceof JSONObject)) goto _L8; else goto _L7
_L7:
        j j1;
        obj1 = (JSONObject)obj1;
        j1 = j.a(((JSONObject) (obj1)), obj, httpurlconnection);
        if (j1 == null) goto _L10; else goto _L9
_L9:
        if (j1.c == 190 && t.a(((GraphRequest) (obj3)).b))
        {
            AccessToken.a(null);
        }
        obj1 = new p(((GraphRequest) (obj3)), httpurlconnection, j1);
_L12:
        arraylist.add(obj1);
        break MISSING_BLOCK_LABEL_504;
_L10:
        obj1 = t.a(((JSONObject) (obj1)), "body", "FACEBOOK_NON_JSON_RESULT");
        if (obj1 instanceof JSONObject)
        {
            obj1 = new p(((GraphRequest) (obj3)), httpurlconnection, obj1.toString(), (JSONObject)obj1);
            continue; /* Loop/switch isn't completed */
        }
        if (obj1 instanceof JSONArray)
        {
            obj1 = new p(((GraphRequest) (obj3)), httpurlconnection, obj1.toString(), (JSONArray)obj1);
            continue; /* Loop/switch isn't completed */
        }
        obj1 = JSONObject.NULL;
_L8:
        if (obj1 != JSONObject.NULL)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = new p(((GraphRequest) (obj3)), httpurlconnection, obj1.toString(), ((JSONObject) (null)));
        if (true) goto _L12; else goto _L11
_L11:
        try
        {
            throw new h((new StringBuilder("Got unexpected object type in response, class: ")).append(obj1.getClass().getSimpleName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            arraylist.add(new p(((GraphRequest) (obj3)), httpurlconnection, new j(httpurlconnection, ((Exception) (obj1)))));
        }
        catch (h h1)
        {
            arraylist.add(new p(((GraphRequest) (obj3)), httpurlconnection, new j(httpurlconnection, h1)));
        }
        break MISSING_BLOCK_LABEL_504;
        return arraylist;
        i++;
        if (true) goto _L14; else goto _L13
_L13:
        if (true) goto _L16; else goto _L15
_L15:
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

    public final String toString()
    {
        Object obj = Locale.US;
        if (c == null) goto _L2; else goto _L1
_L1:
        int i = c.getResponseCode();
_L3:
        obj = String.format(((Locale) (obj)), "%d", new Object[] {
            Integer.valueOf(i)
        });
_L4:
        return (new StringBuilder("{Response:  responseCode: ")).append(((String) (obj))).append(", graphObject: ").append(a).append(", error: ").append(b).append("}").toString();
_L2:
        i = 200;
          goto _L3
        IOException ioexception;
        ioexception;
        ioexception = "unknown";
          goto _L4
    }
}
