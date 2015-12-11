// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.caching;

import android.util.Log;
import java.util.LinkedHashMap;

// Referenced classes of package com.flurry.android.caching:
//            ObjectOperationData

final class c
{

    c()
    {
    }

    public static long h(ObjectOperationData objectoperationdata)
    {
        int i = objectoperationdata.getRetryCount();
        objectoperationdata = objectoperationdata.getRetryPolicy();
        Log.i("RetryPolicyChecker", (new StringBuilder()).append("checkOperation retryAttemps = ").append(i + 1).append(" / ").append(objectoperationdata.size()).toString());
        if (i >= objectoperationdata.size())
        {
            return -1L;
        } else
        {
            return ((Long)objectoperationdata.get(Integer.valueOf(i))).longValue();
        }
    }
}
