// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import com.ebay.nautilus.kernel.util.FileUtil;
import java.io.File;

// Referenced classes of package com.ebay.nautilus.kernel.cachemanager:
//            CacheManager

protected static class 
{

    private volatile boolean anyInstanceInitialized;
    private final Object clearLock = new Object();
    private volatile boolean needClearAllData;

    public void TEST_resetState()
    {
        needClearAllData = false;
        anyInstanceInitialized = false;
    }

    public void clearAllData()
    {
        if (anyInstanceInitialized)
        {
            throw new IllegalStateException("clearAllData() cannot be called after the first instance has been initialized.");
        } else
        {
            needClearAllData = true;
            return;
        }
    }

    public void sharedInit(File file)
    {
        anyInstanceInitialized = true;
        Object obj = clearLock;
        obj;
        JVM INSTR monitorenter ;
        if (needClearAllData)
        {
            needClearAllData = false;
            if (file.isDirectory())
            {
                break MISSING_BLOCK_LABEL_39;
            }
            file.delete();
        }
_L2:
        return;
        FileUtil.recursiveDelete(file, true);
        if (true) goto _L2; else goto _L1
_L1:
        file;
        obj;
        JVM INSTR monitorexit ;
        throw file;
    }

    protected ()
    {
    }
}
