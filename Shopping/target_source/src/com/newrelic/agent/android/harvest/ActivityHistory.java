// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.newrelic.agent.android.harvest:
//            ActivitySighting

public class ActivityHistory extends HarvestableArray
{

    private final List activityHistory;

    public ActivityHistory(List list)
    {
        activityHistory = list;
    }

    public static ActivityHistory newFromJson(JsonArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (jsonarray = jsonarray.iterator(); jsonarray.hasNext(); arraylist.add(ActivitySighting.newFromJson(((JsonElement)jsonarray.next()).getAsJsonArray()))) { }
        return new ActivityHistory(arraylist);
    }

    public JsonArray asJsonArray()
    {
        JsonArray jsonarray = new JsonArray();
        for (Iterator iterator = activityHistory.iterator(); iterator.hasNext(); jsonarray.add(((ActivitySighting)iterator.next()).asJsonArray())) { }
        return jsonarray;
    }

    public JsonArray asJsonArrayWithoutDuration()
    {
        JsonArray jsonarray = new JsonArray();
        for (Iterator iterator = activityHistory.iterator(); iterator.hasNext(); jsonarray.add(((ActivitySighting)iterator.next()).asJsonArrayWithoutDuration())) { }
        return jsonarray;
    }

    public int size()
    {
        return activityHistory.size();
    }
}
