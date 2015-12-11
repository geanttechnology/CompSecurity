// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.nps;

import java.util.HashMap;
import java.util.Map;

public class Message
{

    private final Map extras;
    private final int type;

    public Message()
    {
        this(0);
    }

    public Message(int i)
    {
        this(i, ((Map) (new HashMap())));
    }

    public Message(int i, Map map)
    {
        type = i;
        validateExtras(map);
        extras = map;
    }

    private void validateExtras(Map map)
    {
        if (map == null)
        {
            throw new IllegalArgumentException("Message extras must not be null.");
        } else
        {
            return;
        }
    }
}
