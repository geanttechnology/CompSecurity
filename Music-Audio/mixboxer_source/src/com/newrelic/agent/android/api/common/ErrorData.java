// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.api.common;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class ErrorData
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private int count;
    private final String digest = computeHash();
    private final int httpStatusCode;
    private final Map params;
    private final String responseBody;
    private final String stackTrace = getSanitizedStackTrace();
    private final String url;

    public ErrorData(String s, int i, String s1, Map map)
    {
        url = s;
        httpStatusCode = i;
        count = 1;
        responseBody = s1;
        params = map;
    }

    private boolean shouldFilterStackTraceElement(StackTraceElement stacktraceelement)
    {
        String s = stacktraceelement.getClassName();
        for (stacktraceelement = stacktraceelement.getMethodName(); s.startsWith("com.newrelic") || s.startsWith("dalvik.system.VMStack") && stacktraceelement.startsWith("getThreadStackTrace") || s.startsWith("java.lang.Thread") && stacktraceelement.startsWith("getStackTrace");)
        {
            return true;
        }

        return false;
    }

    public List asList()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(url);
        arraylist.add(Integer.valueOf(httpStatusCode));
        arraylist.add(Integer.valueOf(count));
        arraylist.add(responseBody);
        arraylist.add(stackTrace);
        TreeMap treemap = new TreeMap();
        treemap.put("custom_params", new JSONObject(params));
        arraylist.add(new JSONObject(treemap));
        return arraylist;
    }

    public String computeHash()
    {
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("SHA-1");
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            log.error("Unable to initialize SHA-1 hash algorithm");
            return null;
        }
        messagedigest.update(url.getBytes());
        messagedigest.update(ByteBuffer.allocate(8).putInt(httpStatusCode).array());
        if (stackTrace != null && stackTrace.length() > 0)
        {
            messagedigest.update(stackTrace.getBytes());
        }
        return new String(messagedigest.digest());
    }

    public int getCount()
    {
        return count;
    }

    public String getHash()
    {
        return digest;
    }

    public int getHttpStatusCode()
    {
        return httpStatusCode;
    }

    public Map getParams()
    {
        return params;
    }

    public String getResponseBody()
    {
        return responseBody;
    }

    public String getSanitizedStackTrace()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        int k = 0;
        int j = 0;
        do
        {
            int i;
label0:
            {
                if (j < astacktraceelement.length)
                {
                    StackTraceElement stacktraceelement = astacktraceelement[j];
                    i = k;
                    if (shouldFilterStackTraceElement(stacktraceelement))
                    {
                        break label0;
                    }
                    stringbuilder.append(stacktraceelement.toString());
                    if (j <= astacktraceelement.length - 1)
                    {
                        stringbuilder.append("\n");
                    }
                    k++;
                    i = k;
                    if (k < Agent.getStackTraceLimit())
                    {
                        break label0;
                    }
                }
                return stringbuilder.toString();
            }
            j++;
            k = i;
        } while (true);
    }

    public String getStackTrace()
    {
        return stackTrace;
    }

    public String getUrl()
    {
        return url;
    }

    public void incrementCount()
    {
        count = count + 1;
    }

}
