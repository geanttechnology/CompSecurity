// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.text.TextUtils;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.HttpUtils;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.millennialmedia.internal:
//            AdPlacementReporter, Handshake

static final class 
    implements Runnable
{

    public void run()
    {
        Object obj;
        Object obj1;
        String s;
        obj = cess._mth600();
        obj1 = .IDLE;
        s = Handshake.getReportingBaseUrl();
        if (s == null)
        {
            MMLog.e(AdPlacementReporter.access$100(), "Unable to determine base url for request");
            return;
        }
        s = s.concat(AdPlacementReporter.SSP_REPORTING_PATH);
        if (obj.length <= 0) goto _L2; else goto _L1
_L1:
        obj1 = cess._mth700();
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            MMLog.e(AdPlacementReporter.access$100(), "Unable to upload report -- siteId has not been set");
            obj = .ERROR_SENDING_TO_SERVER;
        } else
        {
            String s1 = cess._mth800(((java.io.File []) (obj)));
            obj1 = HttpUtils.getContentFromPostRequest((new StringBuilder()).append(s).append(AdPlacementReporter.SSP_SITE_ID_PARAMETER).append(((String) (obj1))).toString(), s1, "application/json");
            if (((com.millennialmedia.internal.utils.ETER) (obj1)).ETER == 200)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(AdPlacementReporter.access$100(), (new StringBuilder()).append("Reporting successfully uploaded ").append(obj.length).append(" events").toString());
                }
                cess._mth900(((java.io.File []) (obj)));
                if (AdPlacementReporter.access$200().get() >= Handshake.getReportingBatchSize())
                {
                    loadNow();
                    return;
                }
                obj = .IDLE;
            } else
            if (!EnvironmentUtils.isNetworkAvailable())
            {
                MMLog.e(AdPlacementReporter.access$100(), "Reporting failed to upload because network is unavailable");
                obj = .ERROR_NETWORK_UNAVAILABLE;
            } else
            {
                MMLog.e(AdPlacementReporter.access$100(), (new StringBuilder()).append("Reporting failed to upload with response code <").append(((com.millennialmedia.internal.utils._NETWORK_UNAVAILABLE) (obj1))._NETWORK_UNAVAILABLE).append(">").toString());
                obj = .ERROR_SENDING_TO_SERVER;
            }
        }
_L4:
        tUploadState((() (obj)));
        return;
_L2:
        obj = obj1;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(AdPlacementReporter.access$100(), "Reporting found no events to upload");
            obj = obj1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ()
    {
    }
}
