// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class dr
{

    private static volatile boolean a = false;
    private static final dr c = new dr((byte)0);
    private final Map b;

    dr()
    {
        b = new HashMap();
    }

    private dr(byte byte0)
    {
        b = Collections.emptyMap();
    }

    public static dr a()
    {
        return c;
    }

}
