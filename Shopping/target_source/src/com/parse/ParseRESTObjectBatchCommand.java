// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.parse.http.ParseHttpResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTCommand, ParseRESTObjectCommand, Lists, ParseIOUtils, 
//            ParseHttpClient, ProgressCallback, ParseException

class ParseRESTObjectBatchCommand extends ParseRESTCommand
{

    public static final int COMMAND_OBJECT_BATCH_MAX_SIZE = 50;
    private static final String KEY_RESULTS = "results";

    private ParseRESTObjectBatchCommand(String s, com.parse.http.ParseHttpRequest.Method method, Map map, String s1)
    {
        super(s, method, map, s1);
    }

    public static List executeBatch(ParseHttpClient parsehttpclient, List list, String s)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        ArrayList arraylist2;
        int k;
        int i = 0;
        k = list.size();
        arraylist = new ArrayList(k);
        if (k == 1)
        {
            arraylist.add(((ParseRESTObjectCommand)list.get(0)).executeAsync(parsehttpclient));
            return arraylist;
        }
        if (k > 50)
        {
            list = Lists.partition(list, 50);
            k = list.size();
            for (i = 0; i < k; i++)
            {
                arraylist.addAll(executeBatch(parsehttpclient, (List)list.get(i), s));
            }

            return arraylist;
        }
        arraylist1 = new ArrayList(k);
        for (; i < k; i++)
        {
            a.j.a a = j.a();
            arraylist1.add(a);
            arraylist.add(a.a());
        }

        arraylist2 = new ArrayList(k);
        list = list.iterator();
_L1:
        JSONObject jsonobject;
        Object obj;
        if (!list.hasNext())
        {
            break MISSING_BLOCK_LABEL_303;
        }
        obj = (ParseRESTObjectCommand)list.next();
        jsonobject = new JSONObject();
        jsonobject.put("method", ((ParseRESTObjectCommand) (obj)).method.toString());
        jsonobject.put("path", String.format("/1/%s", new Object[] {
            ((ParseRESTObjectCommand) (obj)).httpPath
        }));
        obj = ((ParseRESTObjectCommand) (obj)).jsonParameters;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        jsonobject.put("body", obj);
        arraylist2.add(jsonobject);
          goto _L1
        parsehttpclient;
        throw new RuntimeException(parsehttpclient);
        list = new HashMap();
        list.put("requests", arraylist2);
        (new ParseRESTObjectBatchCommand("batch", com.parse.http.ParseHttpRequest.Method.POST, list, s)).executeAsync(parsehttpclient).a(new i(k, arraylist1) {

            final int val$batchSize;
            final List val$tcss;

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            public Void then(j j1)
                throws Exception
            {
                boolean flag = false;
                if (j1.d() || j1.c())
                {
                    int l = 0;
                    while (l < batchSize) 
                    {
                        a.j.a a1 = (a.j.a)tcss.get(l);
                        if (j1.d())
                        {
                            a1.b(j1.f());
                        } else
                        {
                            a1.c();
                        }
                        l++;
                    }
                }
                j1 = ((JSONObject)j1.e()).getJSONArray("results");
                int l1 = j1.length();
                int k1 = ((flag) ? 1 : 0);
                if (l1 != batchSize)
                {
                    int i1 = 0;
                    do
                    {
                        k1 = ((flag) ? 1 : 0);
                        if (i1 >= batchSize)
                        {
                            break;
                        }
                        ((a.j.a)tcss.get(i1)).b(new IllegalStateException((new StringBuilder()).append("Batch command result count expected: ").append(batchSize).append(" but was: ").append(l1).toString()));
                        i1++;
                    } while (true);
                }
                while (k1 < batchSize) 
                {
                    JSONObject jsonobject1 = j1.getJSONObject(k1);
                    a.j.a a2 = (a.j.a)tcss.get(k1);
                    if (jsonobject1.has("success"))
                    {
                        a2.b(jsonobject1.getJSONObject("success"));
                    } else
                    if (jsonobject1.has("error"))
                    {
                        jsonobject1 = jsonobject1.getJSONObject("error");
                        a2.b(new ParseException(jsonobject1.getInt("code"), jsonobject1.getString("error")));
                    }
                    k1++;
                }
                return null;
            }

            
            {
                batchSize = k;
                tcss = list;
                super();
            }
        });
        return arraylist;
    }

    protected j onResponseAsync(ParseHttpResponse parsehttpresponse, ProgressCallback progresscallback)
    {
        Object obj;
        obj = null;
        progresscallback = null;
        parsehttpresponse = parsehttpresponse.getContent();
        progresscallback = parsehttpresponse;
        obj = parsehttpresponse;
        String s = new String(ParseIOUtils.toByteArray(parsehttpresponse));
        ParseIOUtils.closeQuietly(parsehttpresponse);
        try
        {
            parsehttpresponse = JSONArrayInstrumentation.init(s);
            progresscallback = new JSONObject();
            progresscallback.put("results", parsehttpresponse);
        }
        // Misplaced declaration of an exception variable
        catch (ParseHttpResponse parsehttpresponse)
        {
            return j.a(newTemporaryException("bad json response", parsehttpresponse));
        }
        return j.a(progresscallback);
        parsehttpresponse;
        obj = progresscallback;
        parsehttpresponse = j.a(parsehttpresponse);
        ParseIOUtils.closeQuietly(progresscallback);
        return parsehttpresponse;
        parsehttpresponse;
        ParseIOUtils.closeQuietly(((java.io.InputStream) (obj)));
        throw parsehttpresponse;
    }
}
