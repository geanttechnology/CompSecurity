// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            PLog

class PushHistory
{
    private static class Entry
        implements Comparable
    {

        public String pushId;
        public String timestamp;

        public int compareTo(Entry entry)
        {
            return timestamp.compareTo(entry.timestamp);
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Entry)obj);
        }

        public Entry(String s, String s1)
        {
            pushId = s;
            timestamp = s1;
        }
    }


    private static final String TAG = "com.parse.PushHistory";
    private final PriorityQueue entries;
    private String lastTime;
    private final int maxHistoryLength;
    private final HashSet pushIds;

    public PushHistory(int i, JSONObject jsonobject)
    {
        maxHistoryLength = i;
        entries = new PriorityQueue(i + 1);
        pushIds = new HashSet(i + 1);
        lastTime = null;
        if (jsonobject != null)
        {
            JSONObject jsonobject1 = jsonobject.optJSONObject("seen");
            if (jsonobject1 != null)
            {
                Iterator iterator = jsonobject1.keys();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator.next();
                    String s1 = jsonobject1.optString(s, null);
                    if (s != null && s1 != null)
                    {
                        tryInsertPush(s, s1);
                    }
                } while (true);
            }
            setLastReceivedTimestamp(jsonobject.optString("lastTime", null));
        }
    }

    public String getLastReceivedTimestamp()
    {
        return lastTime;
    }

    public void setLastReceivedTimestamp(String s)
    {
        lastTime = s;
    }

    public JSONObject toJSON()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        if (entries.size() > 0)
        {
            JSONObject jsonobject1 = new JSONObject();
            Entry entry;
            for (Iterator iterator = entries.iterator(); iterator.hasNext(); jsonobject1.put(entry.pushId, entry.timestamp))
            {
                entry = (Entry)iterator.next();
            }

            jsonobject.put("seen", jsonobject1);
        }
        jsonobject.putOpt("lastTime", lastTime);
        return jsonobject;
    }

    public boolean tryInsertPush(String s, String s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("Can't insert null pushId or timestamp into history");
        }
        if (lastTime == null || s1.compareTo(lastTime) > 0)
        {
            lastTime = s1;
        }
        if (pushIds.contains(s))
        {
            PLog.e("com.parse.PushHistory", (new StringBuilder()).append("Ignored duplicate push ").append(s).toString());
            return false;
        }
        entries.add(new Entry(s, s1));
        pushIds.add(s);
        for (; entries.size() > maxHistoryLength; pushIds.remove(((Entry) (s)).pushId))
        {
            s = (Entry)entries.remove();
        }

        return true;
    }
}
