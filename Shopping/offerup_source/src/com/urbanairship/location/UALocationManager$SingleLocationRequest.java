// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import android.os.Bundle;
import android.util.SparseArray;

// Referenced classes of package com.urbanairship.location:
//            PendingLocationResult, UALocationManager, LocationRequestOptions

class options extends PendingLocationResult
{

    private final LocationRequestOptions options;
    private final int requestId;
    final UALocationManager this$0;

    protected void onCancel()
    {
        if (!isDone())
        {
            UALocationManager.access$500(UALocationManager.this, 6, requestId, null);
        }
        synchronized (UALocationManager.access$400(UALocationManager.this))
        {
            UALocationManager.access$400(UALocationManager.this).remove(requestId);
        }
        return;
        exception;
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void sendLocationRequest()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isDone();
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.urbanairship.location.EXTRA_LOCATION_REQUEST_OPTIONS", options);
        UALocationManager.access$500(UALocationManager.this, 5, requestId, bundle);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    (int i, LocationRequestOptions locationrequestoptions)
    {
        this$0 = UALocationManager.this;
        super();
        requestId = i;
        options = locationrequestoptions;
    }
}
