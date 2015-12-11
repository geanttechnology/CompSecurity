// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class LogsKeeper
{

    private ArrayList lines;
    private final int maxSize;

    public LogsKeeper(int i)
    {
        maxSize = i;
        lines = new ArrayList();
    }

    public void addLine(JSONObject jsonobject)
    {
        lines.add(jsonobject);
        for (; lines.size() > maxSize; lines.remove(0)) { }
    }

    public void cleanLogs()
    {
        lines = new ArrayList();
    }

    public JSONArray getLogs()
    {
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = lines.iterator(); iterator.hasNext(); jsonarray.put((JSONObject)iterator.next())) { }
        return jsonarray;
    }
}
