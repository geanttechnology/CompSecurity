// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.caching;

import android.util.Log;
import com.flurry.android.AppCloudResponseHandler;

// Referenced classes of package com.flurry.android.caching:
//            CachingManager, n, l, m

final class a
    implements Runnable
{

    private AppCloudResponseHandler cP;
    private CachingManager cQ;

    public a(CachingManager cachingmanager, AppCloudResponseHandler appcloudresponsehandler)
    {
        cQ = cachingmanager;
        super();
        cP = null;
        cP = appcloudresponsehandler;
    }

    public final void run()
    {
        Object obj;
        obj = CachingManager.a(cQ).bE();
        obj = CachingManager.b(cQ).i(((ObjectOperationData) (obj)));
        CachingManager.a(cQ).bF();
        ((m) (obj)).it;
        JVM INSTR lookupswitch 4: default 80
    //                   701: 102
    //                   711: 124
    //                   721: 113
    //                   731: 135;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_135;
_L1:
        Log.e("CachingManager", "ERROR! UNKNOWN RESPONSE CODE!");
_L6:
        try
        {
            cP.handleResponse(((m) (obj)).iu);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_151;
_L2:
        Log.i("CachingManager", "OPERATION_STATUS_SUCCEEDED");
          goto _L6
_L4:
        Log.e("CachingManager", "OPERATION_STATUS_TIME_OUT");
          goto _L6
_L3:
        Log.e("CachingManager", "OPERATION_STATUS_FAILED");
          goto _L6
        Log.e("CachingManager", "OPERATION_STATUS_BAD_RESPONSE");
          goto _L6
    }
}
