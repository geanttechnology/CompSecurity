// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;

import java.util.ArrayList;

// Referenced classes of package com.ebay.common.net.api.finding:
//            PagedList

private static final class loadState
{

    public static final int STATE_FAILED = -1;
    public static final int STATE_LOADED = 1;
    public static final int STATE_NOT_LOADED = 0;
    public final int count;
    public int loadState;
    public final ArrayList rows;
    public final int start;

    public String toString()
    {
        loadState;
        JVM INSTR tableswitch -1 1: default 32
    //                   -1 95
    //                   0 32
    //                   1 89;
           goto _L1 _L2 _L1 _L3
_L1:
        String s = "";
_L5:
        return (new StringBuilder()).append("P(").append(start).append("-").append(String.valueOf((count + start) - 1)).append(s).append(')').toString();
_L3:
        s = " rdy";
        continue; /* Loop/switch isn't completed */
_L2:
        s = " err";
        if (true) goto _L5; else goto _L4
_L4:
    }

    public (int i, int j)
    {
        start = i;
        count = j;
        rows = new ArrayList(j);
        loadState = 0;
    }
}
