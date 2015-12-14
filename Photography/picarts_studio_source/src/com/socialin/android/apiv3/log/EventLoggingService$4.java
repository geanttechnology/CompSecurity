// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;

import android.os.Handler;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.AppProps;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

// Referenced classes of package com.socialin.android.apiv3.log:
//            EventLoggingService

final class a
    implements Runnable
{

    private Handler a;
    private EventLoggingService b;

    public final void run()
    {
        try
        {
            String s1;
            for (Iterator iterator = EventLoggingService.access$800(b).iterator(); iterator.hasNext(); EventLoggingService.access$1100(b, s1, EventLoggingService.access$900(b, s1), EventLoggingService.access$1000(b, s1)))
            {
                s1 = (String)iterator.next();
            }

        }
        catch (Exception exception)
        {
            exception.getMessage();
            ExceptionReportService.report(exception);
            return;
        }
        if (EventLoggingService.access$1200(b) == null || EventLoggingService.access$1200(b).length() <= 0) goto _L2; else goto _L1
_L1:
        String s;
        s = EventLoggingService.access$1200(b).toString();
        if (SocialinV3.getInstance().getAppProps().getData()._fld1200 == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        b.sendRequest(SocialinV3.getInstance().getAppProps().getData().Request.Url, s);
_L4:
        EventLoggingService.access$1202(b, new JSONArray());
_L2:
        if (SocialinV3.getInstance().getAppProps().getData()._fld1202 != null)
        {
            a.postDelayed(EventLoggingService.access$1300(), SocialinV3.getInstance().getAppProps().getData()._fld1300.chTime);
            return;
        }
        break MISSING_BLOCK_LABEL_216;
        b.sendRequest(b.analyticsUrl, s);
        if (true) goto _L4; else goto _L3
_L3:
        a.postDelayed(EventLoggingService.access$1300(), b.eventsBatchTime);
        return;
    }

    ervice(EventLoggingService eventloggingservice, Handler handler)
    {
        b = eventloggingservice;
        a = handler;
        super();
    }
}
