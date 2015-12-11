// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Symbol

public static class symToSkip extends ion
{

    public final Symbol symToSkip;

    public ion flatten(Map map, Map map1)
    {
        return new <init>(symToSkip.flatten(map, map1));
    }

    public volatile Symbol flatten(Map map, Map map1)
    {
        return flatten(map, map1);
    }

    public ion(Symbol symbol)
    {
        super(true, null);
        symToSkip = symbol;
    }
}
