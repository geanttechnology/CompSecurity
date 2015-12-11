// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events;

import android.content.Context;
import com.amazon.device.analytics.util.FileManager;

// Referenced classes of package com.amazon.device.analytics.events:
//            InternalStorageUniqueIdResolver, RandomUniqueIdResolver, ExternalStorageUniqueIdResolver, MASUniqueIdResolver, 
//            UniqueIdResolver

public class UniqueIdService
{

    private static UniqueIdResolver chain = null;
    private static String uniqueId = null;

    public UniqueIdService()
    {
    }

    private static UniqueIdResolver buildResolverChain(Context context)
    {
        Object obj = new InternalStorageUniqueIdResolver(context, new RandomUniqueIdResolver());
        obj = new ExternalStorageUniqueIdResolver(FileManager.getInstance(), ((UniqueIdResolver) (obj)));
        return new MASUniqueIdResolver(FileManager.getInstance(), context, ((UniqueIdResolver) (obj)));
    }

    public static String getUniqueId()
    {
        return uniqueId;
    }

    public static void initialize(Context context)
    {
        com/amazon/device/analytics/events/UniqueIdService;
        JVM INSTR monitorenter ;
        if (chain == null)
        {
            chain = buildResolverChain(context);
            uniqueId = chain.resolveUniqueId();
        }
        com/amazon/device/analytics/events/UniqueIdService;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

}
