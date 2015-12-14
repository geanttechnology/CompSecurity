// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log

public final class MMEntryLock
{

    private static Set aF = new HashSet();

    private MMEntryLock()
    {
    }

    public static boolean isLocked(String s)
    {
        return aF.contains(s);
    }

    public static boolean lock(String s)
    {
        if (isLocked(s))
        {
            Log.d("MicroMsg.MMEntryLock", (new StringBuilder("locked-")).append(s).toString());
            return false;
        } else
        {
            Log.d("MicroMsg.MMEntryLock", (new StringBuilder("lock-")).append(s).toString());
            return aF.add(s);
        }
    }

    public static void unlock(String s)
    {
        aF.remove(s);
        Log.d("MicroMsg.MMEntryLock", (new StringBuilder("unlock-")).append(s).toString());
    }

}
