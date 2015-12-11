// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.aa;
import com.smule.android.f.e;
import com.smule.android.network.core.o;

// Referenced classes of package com.smule.android.network.managers:
//            ap

public class aq
{

    public o a;
    public Boolean b;
    public long c;
    public String d;
    final ap e;

    public aq(ap ap1, o o1)
    {
        e = ap1;
        super();
        a = o1;
        if (a == null || a.h == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        ap1 = (JsonNode)com.smule.android.f.e.a().readValue(a.h, com/fasterxml/jackson/databind/JsonNode);
        if (ap1.has("data"))
        {
            ap1 = ap1.get("data");
            if (ap1.has("isActive"))
            {
                b = Boolean.valueOf(ap1.get("isActive").booleanValue());
            }
            if (ap1.has("expireAt"))
            {
                c = ap1.get("expireAt").longValue();
            }
            if (ap1.has("status"))
            {
                d = ap1.get("status").textValue();
            }
        }
        return;
        ap1;
        aa.b(ap.j(), "Error parsing SubscriptionStatusResponse!");
        return;
    }
}
