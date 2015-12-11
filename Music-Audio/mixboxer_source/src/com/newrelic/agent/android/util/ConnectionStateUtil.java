// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import android.content.SharedPreferences;
import com.newrelic.agent.android.api.common.ConnectionState;
import com.newrelic.agent.android.api.v1.DeviceInfo;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONTokener;

public final class ConnectionStateUtil
{

    private static final AgentLog log = AgentLogManager.getAgentLog();

    private ConnectionStateUtil()
    {
    }

    public static void clearSharedPreferences(SharedPreferences sharedpreferences)
    {
        sharedpreferences = sharedpreferences.edit();
        sharedpreferences.remove("dataToken").remove("agentVersion").remove("crossProcessId").remove("serverTimestamp").remove("harvestIntervalInSeconds").remove("maxTransactionAgeInSeconds").remove("maxTransactionCount").remove("stackTraceLimit").remove("responseBodyLimit").remove("collectNetworkErrors").remove("errorLimit").remove("appToken");
        sharedpreferences.commit();
    }

    public static ConnectionState fromSharedPreferences(SharedPreferences sharedpreferences)
    {
        Object obj = sharedpreferences.getString("dataToken", null);
        String s;
        int i;
        int j;
        int k;
        long l;
        long l1;
        long l2;
        long l3;
        boolean flag;
        try
        {
            obj = (new JSONTokener(((String) (obj)))).nextValue();
        }
        catch (JSONException jsonexception)
        {
            obj = null;
            log.error("Failed to parse data token", jsonexception);
        }
        s = sharedpreferences.getString("crossProcessId", null);
        l = sharedpreferences.getLong("serverTimestamp", 0L);
        l1 = sharedpreferences.getLong("harvestIntervalInSeconds", 0L);
        l2 = sharedpreferences.getLong("maxTransactionAgeInSeconds", 0L);
        l3 = sharedpreferences.getLong("maxTransactionCount", 0L);
        i = sharedpreferences.getInt("stackTraceLimit", 0);
        j = sharedpreferences.getInt("responseBodyLimit", 0);
        flag = sharedpreferences.getBoolean("collectNetworkErrors", true);
        k = sharedpreferences.getInt("errorLimit", 10);
        return new ConnectionState(obj, s, l, l1, TimeUnit.SECONDS, l2, TimeUnit.SECONDS, l3, i, j, flag, k);
    }

    private static boolean isBlank(String s)
    {
        return s == null || s.trim().length() == 0;
    }

    public static boolean isValid(ConnectionState connectionstate)
    {
        return connectionstate.getDataToken() != null && !isBlank(connectionstate.getCrossProcessId());
    }

    public static void saveSharedPreferences(SharedPreferences sharedpreferences, ConnectionState connectionstate, DeviceInfo deviceinfo, String s)
    {
        sharedpreferences = sharedpreferences.edit();
        sharedpreferences.putString("dataToken", connectionstate.getDataToken().toString()).putString("agentVersion", deviceinfo.toString()).putString("crossProcessId", connectionstate.getCrossProcessId()).putLong("serverTimestamp", connectionstate.getServerTimestamp()).putLong("harvestIntervalInSeconds", connectionstate.getHarvestIntervalInSeconds()).putLong("maxTransactionAgeInSeconds", connectionstate.getMaxTransactionAgeInSeconds()).putLong("maxTransactionCount", connectionstate.getMaxTransactionCount()).putInt("stackTraceLimit", connectionstate.getStackTraceLimit()).putInt("responseBodyLimit", connectionstate.getResponseBodyLimit()).putBoolean("collectNetworkErrors", connectionstate.isCollectingNetworkErrors()).putInt("errorLimit", connectionstate.getErrorLimit()).putString("appToken", s);
        sharedpreferences.commit();
    }

}
