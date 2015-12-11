// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import android.content.Context;
import java.io.File;

// Referenced classes of package com.ebay.nautilus.kernel.cachemanager:
//            CacheManager

public class PersistenceManager extends CacheManager
{

    public static final String DIR_NAME = "persistenceManager";
    private static final CacheManager.SharedInitState persistInitState = new CacheManager.SharedInitState();

    public PersistenceManager(Context context, CacheManager.PersitenceMapper persitencemapper, Class class1, String s, int i, int j)
    {
        super(context, context.getFilesDir(), persitencemapper, class1, s, i, j, 0x7fffffffffffffffL, 0x3fffffffffffffffL, false);
    }

    public static void TEST_resetInitState()
    {
        persistInitState.TEST_resetState();
    }

    public static void clearAllData()
    {
        persistInitState.clearAllData();
    }

    protected String getTopLevelDirName()
    {
        return "persistenceManager";
    }

    protected void scheduleDiskTrim()
    {
    }

    protected void sharedInit(File file)
    {
        persistInitState.sharedInit(file);
    }

}
