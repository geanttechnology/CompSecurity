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

    public volatile Object a(JsonNode jsonnode, Object obj)
    {
        return a(jsonnode, (String)obj);
    }

    public String a(JsonNode jsonnode, String s)
    {
        return jsonnode.asText(s);
    }

    Node()
    {
    }
}
