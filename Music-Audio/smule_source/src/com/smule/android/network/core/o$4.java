// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import com.fasterxml.jackson.databind.JsonNode;

// Referenced classes of package com.smule.android.network.core:
//            q, o

final class Node
    implements q
{

    public Long a(JsonNode jsonnode, Long long1)
    {
        return Long.valueOf(jsonnode.asLong(long1.longValue()));
    }

    public volatile Object a(JsonNode jsonnode, Object obj)
    {
        return a(jsonnode, (Long)obj);
    }

    Node()
    {
    }
}
