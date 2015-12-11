// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import android.net.Uri;
import atr;
import atv;
import atw;
import atx;
import atz;
import aua;
import aui;
import auj;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import pp;
import qm;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods, WearableDataRequest

public final class DataListenerHandheld
{

    public DataListenerHandheld()
    {
    }

    private static void handleRequest(atz atz1, qm qm1, Context context)
    {
        if (qm1 == null || context == null || atz1 == null)
        {
            StaticMethods.logDebugFormat("Wearable - GoogleApiClient or Context or DataMap is null", new Object[0]);
            return;
        }
        WearableDataRequest wearabledatarequest = WearableDataRequest.createRequestFromDataMap(atz1);
        if (wearabledatarequest == null)
        {
            StaticMethods.logDebugFormat("Wearable - Invalid data request (%s)", new Object[] {
                atz1.toString()
            });
            return;
        }
        if (!qm1.a(15000L, TimeUnit.MILLISECONDS).b())
        {
            StaticMethods.logDebugFormat("Wearable - Failed to setup connection", new Object[0]);
            return;
        } else
        {
            atz1 = wearabledatarequest.handle(context);
            context = aui.a("/abdmobile/data/response");
            context.a().a(atz1);
            auj.a.a(qm1, context.b());
            return;
        }
    }

    public static void onDataChanged(atw atw1, qm qm1, Context context)
    {
        if (atw1 != null)
        {
            atw1 = atw1.iterator();
            while (atw1.hasNext()) 
            {
                Object obj = (atv)atw1.next();
                if (((atv) (obj)).c() == 1)
                {
                    obj = ((atv) (obj)).b();
                    if (obj != null)
                    {
                        Uri uri = ((atx) (obj)).b();
                        if (uri != null && uri.getPath() != null && uri.getPath().startsWith("/abdmobile/data/request"))
                        {
                            handleRequest(aua.a(((atx) (obj))).a(), qm1, context);
                        }
                    }
                }
            }
        }
    }
}
