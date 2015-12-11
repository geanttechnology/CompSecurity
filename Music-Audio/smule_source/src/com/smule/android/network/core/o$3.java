// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import android.util.Log;
import com.fasterxml.jackson.databind.JsonNode;

// Referenced classes of package com.smule.android.network.core:
//            q, o

final class Node
    implements q
{

    public Integer a(JsonNode jsonnode, Integer integer)
    {
        Log.d(o.c(), (new StringBuilder()).append("node as Int ").append(jsonnode).append(" ret ").append(jsonnode.asInt()).toString());
        return Integer.valueOf(jsonnode.asInt(integer.intValue()));
    }

    public volatile Object a(JsonNode jsonnode, Object obj)
    {
        return a(jsonnode, (Integer)obj);
    }

    Node()
    {
    }
}
