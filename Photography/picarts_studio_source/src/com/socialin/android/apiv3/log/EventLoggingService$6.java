// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;

import android.util.Log;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.log:
//            EventLoggingService

final class a
    implements d
{

    private EventLoggingService a;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        a.isSending = false;
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (String)obj;
        a.isSending = false;
        if (!"OK".equals((new JSONObject(((String) (obj)))).get("status")))
        {
            return;
        }
        try
        {
            if (EventLoggingService.access$1400(a) != null && EventLoggingService.access$1400(a).size() > 0)
            {
                EventLoggingService.access$1500(a, EventLoggingService.access$1400(a));
                EventLoggingService.access$1400(a).clear();
            }
            if (EventLoggingService.access$1600(a) != null && EventLoggingService.access$1600(a).size() > 0)
            {
                EventLoggingService.access$1700(a, EventLoggingService.access$1600(a));
                EventLoggingService.access$1600(a).clear();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Request request)
        {
            Log.e("EventLoggingService", (new StringBuilder("Could not parse malformed JSON: \"")).append(((String) (obj))).append("\"").toString());
        }
        return;
    }

    (EventLoggingService eventloggingservice)
    {
        a = eventloggingservice;
        super();
    }
}
