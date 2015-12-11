// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.b.a.a.g;
import com.offerup.android.dto.response.DiscussionsResponse;
import com.offerup.android.dto.response.MessagesResponse;
import java.util.concurrent.Executors;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.network:
//            o, MessagingService

public class c
{

    public c()
    {
    }

    public static DiscussionsResponse a()
    {
        com/offerup/android/network/c;
        JVM INSTR monitorenter ;
        Object obj = o.d(o.a(Executors.newSingleThreadExecutor()));
        obj = ((MessagingService) (obj)).getBuyingDiscussions();
_L2:
        com/offerup/android/network/c;
        JVM INSTR monitorexit ;
        return ((DiscussionsResponse) (obj));
        Object obj1;
        obj1;
        g.a(com/offerup/android/network/c, ((Throwable) (obj1)));
        obj1 = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        throw obj1;
    }

    public static DiscussionsResponse a(long l)
    {
        com/offerup/android/network/c;
        JVM INSTR monitorenter ;
        Object obj = o.d(o.a(Executors.newSingleThreadExecutor()));
        obj = ((MessagingService) (obj)).getItemDiscussions(l);
_L2:
        com/offerup/android/network/c;
        JVM INSTR monitorexit ;
        return ((DiscussionsResponse) (obj));
        Object obj1;
        obj1;
        g.a(com/offerup/android/network/c, ((Throwable) (obj1)));
        obj1 = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        throw obj1;
    }

    public static MessagesResponse b(long l)
    {
        com/offerup/android/network/c;
        JVM INSTR monitorenter ;
        Object obj = o.d(o.a(Executors.newSingleThreadExecutor()));
        obj = ((MessagingService) (obj)).getMessages(l);
_L2:
        com/offerup/android/network/c;
        JVM INSTR monitorexit ;
        return ((MessagesResponse) (obj));
        Object obj1;
        obj1;
        g.a(com/offerup/android/network/c, ((Throwable) (obj1)));
        if (((RetrofitError) (obj1)).getResponse() != null && ((RetrofitError) (obj1)).getResponse().getStatus() == 401)
        {
            obj1 = new MessagesResponse();
            ((MessagesResponse) (obj1)).setAuthenticationError(true);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_75;
        obj1;
        throw obj1;
        obj1 = null;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
