// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.HashMap;
import java.util.LinkedHashMap;

// Referenced classes of package com.tapjoy.internal:
//            cy

public final class da
{

    static final cu.a a;

    public static HashMap a()
    {
        return new HashMap();
    }

    public static LinkedHashMap b()
    {
        return new LinkedHashMap();
    }

    static 
    {
        a = new cu.a(cy.a, "=", (byte)0);
    }
}
