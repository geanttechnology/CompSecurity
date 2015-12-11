// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.fasterxml.jackson.databind.JsonNode;
import com.smule.android.network.core.o;

public class av
{

    public long a;
    public o b;
    public String c;
    public String d;
    public Long e;
    public boolean f;
    public int g;
    public int h;
    public int i;

    public av(o o1)
    {
        f = true;
        b = o1;
        if (o1 != null && o1.j != null)
        {
            if (o1.j.get("playerId") != null)
            {
                a = o1.j.get("playerId").asLong();
            }
            if (o1.j.get("testId") != null)
            {
                c = o1.j.get("testId").asText();
            }
            if (o1.j.get("groupId") != null)
            {
                d = o1.j.get("groupId").asText();
            }
            if (o1.j.has("playerStat"))
            {
                JsonNode jsonnode = o1.j.get("playerStat");
                if (jsonnode.has("installDate"))
                {
                    e = Long.valueOf(jsonnode.get("installDate").asLong());
                }
            }
            if (o1.j.has("elControl"))
            {
                JsonNode jsonnode1 = o1.j.get("elControl");
                if (jsonnode1.has("npt"))
                {
                    f = jsonnode1.get("npt").asBoolean(true);
                }
            }
            g = o.a(o1.j, "loginCount", 0);
            if (o1.j.has("notificationCount"))
            {
                o1 = o1.j.get("notificationCount");
                if (o1.has("activity"))
                {
                    h = o1.get("activity").asInt(0);
                }
                if (o1.has("invite"))
                {
                    i = o1.get("invite").asInt(0);
                }
            }
        }
    }
}
