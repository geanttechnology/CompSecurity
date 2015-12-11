// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;

public class DataToken extends HarvestableArray
{

    private int accountId;
    private int agentId;

    public DataToken()
    {
    }

    public DataToken(int i, int j)
    {
        accountId = i;
        agentId = j;
    }

    public JsonArray asJsonArray()
    {
        JsonArray jsonarray = new JsonArray();
        jsonarray.add(new JsonPrimitive(Integer.valueOf(accountId)));
        jsonarray.add(new JsonPrimitive(Integer.valueOf(agentId)));
        return jsonarray;
    }

    public void clear()
    {
        accountId = 0;
        agentId = 0;
    }

    public int getAccountId()
    {
        return accountId;
    }

    public int getAgentId()
    {
        return agentId;
    }

    public boolean isValid()
    {
        return accountId > 0 && agentId > 0;
    }

    public void setAccountId(int i)
    {
        accountId = i;
    }

    public void setAgentId(int i)
    {
        agentId = i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("DataToken{accountId=").append(accountId).append(", agentId=").append(agentId).append('}').toString();
    }
}
