// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.caching;

import android.content.Context;
import com.flurry.android.AppCloudResponseHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.flurry.android.caching:
//            n, l, ObjectOperationData, a

public class CachingManager
{

    private ExecutorService eD;
    private n gs;
    private l gt;

    public CachingManager(Context context)
    {
        gs = new n();
        gt = new l(context);
        eD = Executors.newSingleThreadExecutor();
    }

    static n a(CachingManager cachingmanager)
    {
        return cachingmanager.gs;
    }

    static l b(CachingManager cachingmanager)
    {
        return cachingmanager.gt;
    }

    public void decrementOperation(ObjectOperationData objectoperationdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        objectoperationdata.setOperationType(32);
        gs.j(objectoperationdata);
        eD.submit(new a(this, appcloudresponsehandler));
    }

    public void deleteOperation(ObjectOperationData objectoperationdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        objectoperationdata.setOperationType(4);
        gs.j(objectoperationdata);
        eD.submit(new a(this, appcloudresponsehandler));
    }

    public void getOperation(ObjectOperationData objectoperationdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        objectoperationdata.setOperationType(2);
        gs.j(objectoperationdata);
        eD.submit(new a(this, appcloudresponsehandler));
    }

    public void incrementOperation(ObjectOperationData objectoperationdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        objectoperationdata.setOperationType(16);
        gs.j(objectoperationdata);
        eD.submit(new a(this, appcloudresponsehandler));
    }

    public void saveOrCreateOperation(ObjectOperationData objectoperationdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        objectoperationdata.setOperationType(1);
        gs.j(objectoperationdata);
        eD.submit(new a(this, appcloudresponsehandler));
    }

    public void searchOperation(ObjectOperationData objectoperationdata, AppCloudResponseHandler appcloudresponsehandler)
    {
        objectoperationdata.setOperationType(8);
        gs.j(objectoperationdata);
        eD.submit(new a(this, appcloudresponsehandler));
    }
}
