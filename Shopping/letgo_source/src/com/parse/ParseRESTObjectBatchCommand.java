// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
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
//            ParseRESTCommand, ParseRESTObjectCommand, Lists, ParseHttpResponse, 
//            ParseIOUtils, ParseHttpClient, ProgressCallback, ParseException

class ParseRESTObjectBatchCommand extends ParseRESTCommand
{

    public static final int COMMAND_OBJECT_BATCH_MAX_SIZE = 50;
    private static final String KEY_RESULTS = "results";

    private ParseRESTObjectBatchCommand(String s, ParseRequest.Method method, Map map, String s1)
    {
        super(s, method, map, s1);
    }

    public static List executeBatch(ParseHttpClient parsehttpclient, List list, String s)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        ArrayList arraylist2;
        int j;
        int i = 0;
        j = list.size();
        arraylist = new ArrayList(j);
        if (j == 1)
        {
            arraylist.add(((ParseRESTObjectCommand)list.get(0)).executeAsync(parsehttpclient));
            return arraylist;
        }
        if (j > 50)
        {
            list = Lists.partition(list, 50);
            j = list.size();
            for (i = 0; i < j; i++)
            {
                arraylist.addAll(executeBatch(parsehttpclient, (List)list.get(i), s));
            }

            return arraylist;
        }
        arraylist1 = new ArrayList(j);
        for (; i < j; i++)
        {
            android.support.v7.cu.a a = cu.a();
            arraylist1.add(a);
            arraylist.add(a.a());
        }

        arraylist2 = new ArrayList(j);
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
        (new ParseRESTObjectBatchCommand("batch", ParseRequest.Method.POST, list, s)).executeAsync(parsehttpclient).a(new ct(j, arraylist1) {

            final int val$batchSize;
            final List val$tcss;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
                throws Exception
            {
                boolean flag = false;
                if (cu1.d() || cu1.c())
                {
                    int k = 0;
                    while (k < batchSize) 
                    {
                        android.support.v7.cu.a a1 = (android.support.v7.cu.a)tcss.get(k);
                        if (cu1.d())
                        {
                            a1.b(cu1.f());
                        } else
                        {
                            a1.c();
                        }
                        k++;
                    }
                }
                cu1 = ((JSONObject)cu1.e()).getJSONArray("results");
                int j1 = cu1.length();
                int i1 = ((flag) ? 1 : 0);
                if (j1 != batchSize)
                {
                    int l = 0;
                    do
                    {
                        i1 = ((flag) ? 1 : 0);
                        if (l >= batchSize)
                        {
                            break;
                        }
                        ((android.support.v7.cu.a)tcss.get(l)).b(new IllegalStateException((new StringBuilder()).append("Batch command result count expected: ").append(batchSize).append(" but was: ").append(j1).toString()));
                        l++;
                    } while (true);
                }
                while (i1 < batchSize) 
                {
                    JSONObject jsonobject1 = cu1.getJSONObject(i1);
                    android.support.v7.cu.a a2 = (android.support.v7.cu.a)tcss.get(i1);
                    if (jsonobject1.has("success"))
                    {
                        a2.b(jsonobject1.getJSONObject("success"));
                    } else
                    if (jsonobject1.has("error"))
                    {
                        jsonobject1 = jsonobject1.getJSONObject("error");
                        a2.b(new ParseException(jsonobject1.getInt("code"), jsonobject1.getString("error")));
                    }
                    i1++;
                }
                return null;
            }

            
            {
                batchSize = i;
                tcss = list;
                super();
            }
        });
        return arraylist;
    }

    protected cu onResponseAsync(ParseHttpResponse parsehttpresponse, ProgressCallback progresscallback)
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
            return cu.a(newTemporaryException("bad json response", parsehttpresponse));
        }
        return cu.a(progresscallback);
        parsehttpresponse;
        obj = progresscallback;
        parsehttpresponse = cu.a(parsehttpresponse);
        ParseIOUtils.closeQuietly(progresscallback);
        return parsehttpresponse;
        parsehttpresponse;
        ParseIOUtils.closeQuietly(((java.io.InputStream) (obj)));
        throw parsehttpresponse;
    }
}
