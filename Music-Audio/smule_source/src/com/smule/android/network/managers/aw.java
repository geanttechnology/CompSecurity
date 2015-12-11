// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.fasterxml.jackson.databind.JsonNode;
import com.smule.android.f.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.t;

public class aw extends t
{

    public long b;
    public long c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public Long i;
    public boolean j;
    public int k;
    public b l;
    public int m;
    public int n;
    public Boolean o;

    public aw(o o1)
    {
        j = true;
        m = 0;
        n = 0;
        o = Boolean.valueOf(false);
        a = o1;
        if (o1 != null && o1.j != null)
        {
            c = com.smule.android.network.core.o.a(o1.j, "accountId", 0L);
            d = com.smule.android.network.core.o.b(o1.j, "email");
            b = com.smule.android.network.core.o.a(o1.j, "playerId", 0L);
            e = com.smule.android.network.core.o.b(o1.j, "handle");
            o = Boolean.valueOf(com.smule.android.network.core.o.a(o1.j, "handleNew", false));
            k = com.smule.android.network.core.o.a(o1.j, "loginCount", 0);
            l = com.smule.android.f.b.a(com.smule.android.network.core.o.a(o1.j, "newsletter", -1));
            if (o1.j.get("picUrl") != null)
            {
                f = o1.j.get("picUrl").asText();
            }
            if (o1.j.get("testId") != null)
            {
                g = o1.j.get("testId").asText();
            }
            if (o1.j.get("groupId") != null)
            {
                h = o1.j.get("groupId").asText();
            }
            if (o1.j.has("playerStat"))
            {
                JsonNode jsonnode = o1.j.get("playerStat");
                if (jsonnode.has("installDate"))
                {
                    i = Long.valueOf(jsonnode.get("installDate").asLong());
                }
            }
            if (o1.j.has("elControl"))
            {
                JsonNode jsonnode1 = o1.j.get("elControl");
                if (jsonnode1.has("npt"))
                {
                    j = jsonnode1.get("npt").asBoolean(true);
                }
            }
            if (o1.j.has("notificationCount"))
            {
                o1 = o1.j.get("notificationCount");
                if (o1.has("activity"))
                {
                    m = o1.get("activity").asInt(0);
                }
                if (o1.has("invite"))
                {
                    n = o1.get("invite").asInt(0);
                }
            }
        }
    }
}
