// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import android.net.Uri;
import atr;
import att;
import atv;
import atw;
import atx;
import atz;
import aua;
import auf;
import aug;
import aui;
import auj;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import pp;
import qm;
import qn;
import qp;
import qq;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods, WearableDataResponse, WearableDataRequest

final class WearableDataConnection
    implements att, qp
{

    protected atz mDataMap;
    private final qm mGoogleApiClient;
    private CountDownLatch mInTimeCountDownLatch;
    protected String requestID;

    protected WearableDataConnection(Context context)
    {
        mGoogleApiClient = (new qn(context)).a(this).a(auj.g).b();
    }

    private boolean connect(int i)
    {
        mGoogleApiClient.b();
        if (!waitForConnect(i))
        {
            StaticMethods.logWarningFormat("Wearable - Timeout setup connection", new Object[0]);
            return false;
        }
        if (!hasNodes())
        {
            StaticMethods.logWarningFormat("Wearable - No connected Node found", new Object[0]);
            return false;
        } else
        {
            return true;
        }
    }

    private boolean hasNodes()
    {
        aug aug1 = (aug)auj.c.a(mGoogleApiClient).b();
        return aug1 != null && aug1.a() != null && aug1.a().size() > 0;
    }

    private boolean waitForConnect(int i)
    {
        if (mGoogleApiClient.d())
        {
            return true;
        } else
        {
            return mGoogleApiClient.a(i, TimeUnit.MILLISECONDS).b();
        }
    }

    protected WearableDataResponse getResponse()
    {
        if (mDataMap == null)
        {
            return null;
        } else
        {
            return WearableDataResponse.createResponseFromDataMap(mDataMap, mGoogleApiClient);
        }
    }

    public void onConnectionFailed(pp pp1)
    {
    }

    public void onDataChanged(atw atw1)
    {
        atw1 = atw1.iterator();
        do
        {
            Object obj;
label0:
            {
                if (atw1.hasNext())
                {
                    obj = (atv)atw1.next();
                    if (((atv) (obj)).c() == 1)
                    {
                        break label0;
                    }
                }
                return;
            }
            Object obj1 = ((atv) (obj)).b();
            if (obj1 != null)
            {
                obj1 = ((atx) (obj1)).b();
                if (obj1 != null && ((Uri) (obj1)).getPath() != null && ((Uri) (obj1)).getPath().compareTo("/abdmobile/data/response") == 0)
                {
                    obj = aua.a(((atv) (obj)).b()).a();
                    if (obj != null && ((atz) (obj)).a("ID") && ((atz) (obj)).f("ID").equals(requestID))
                    {
                        mDataMap = ((atz) (obj));
                        mInTimeCountDownLatch.countDown();
                        return;
                    }
                }
            }
        } while (true);
    }

    protected WearableDataResponse send(WearableDataRequest wearabledatarequest)
    {
        if (!connect(wearabledatarequest.getTimeOut()))
        {
            return null;
        }
        auj.a.a(mGoogleApiClient, this);
        requestID = wearabledatarequest.getUUID();
        Object obj = aui.a("/abdmobile/data/request");
        ((aui) (obj)).a().a(wearabledatarequest.getDataMap());
        obj = ((aui) (obj)).b();
        mInTimeCountDownLatch = new CountDownLatch(1);
        auj.a.a(mGoogleApiClient, ((com.google.android.gms.wearable.PutDataRequest) (obj)));
        if (mInTimeCountDownLatch.await(wearabledatarequest.getTimeOut(), TimeUnit.MILLISECONDS))
        {
            break MISSING_BLOCK_LABEL_135;
        }
        StaticMethods.logWarningFormat("Wearable - Failed to get data from handheld app", new Object[0]);
        auj.a.b(mGoogleApiClient, this);
        mGoogleApiClient.c();
        return null;
        wearabledatarequest = getResponse();
        auj.a.b(mGoogleApiClient, this);
        mGoogleApiClient.c();
        return wearabledatarequest;
        wearabledatarequest;
        StaticMethods.logWarningFormat("Wearable - Failed to get data from handheld app", new Object[0]);
        auj.a.b(mGoogleApiClient, this);
        mGoogleApiClient.c();
        return null;
        wearabledatarequest;
        auj.a.b(mGoogleApiClient, this);
        mGoogleApiClient.c();
        throw wearabledatarequest;
    }
}
