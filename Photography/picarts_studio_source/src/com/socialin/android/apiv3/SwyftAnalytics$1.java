// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.apiv3:
//            SwyftAnalytics

final class 
    implements d
{

    public final void onCancelRequest(Object obj, Request request)
    {
        com.socialin.android.d.b("swyft_analytics", new Object[] {
            "logEvent - onCancelRequest"
        });
    }

    public final void onFailure(Exception exception, Request request)
    {
        com.socialin.android.d.b("swyft_analytics", new Object[] {
            (new StringBuilder("logEvent - onFailure! \n")).append(exception.getLocalizedMessage()).toString()
        });
        exception.printStackTrace();
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (String)obj;
        com.socialin.android.d.b("swyft_analytics", new Object[] {
            (new StringBuilder("logEvent - onSuccess! \n")).append(((String) (obj))).toString()
        });
    }

    ()
    {
    }
}
