// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.b.a.a.g;
import com.offerup.android.dto.response.UserWatchlistResponse;
import java.util.concurrent.Executors;
import retrofit.Callback;
import retrofit.RetrofitError;

// Referenced classes of package com.offerup.android.network:
//            o, WatchListService

public class t
{

    public t()
    {
    }

    public static UserWatchlistResponse a()
    {
        com/offerup/android/network/t;
        JVM INSTR monitorenter ;
        Object obj = o.f(o.a(Executors.newSingleThreadExecutor()));
        obj = ((WatchListService) (obj)).getItemsWatched();
_L2:
        com/offerup/android/network/t;
        JVM INSTR monitorexit ;
        return ((UserWatchlistResponse) (obj));
        Object obj1;
        obj1;
        g.a(com/offerup/android/network/t, ((Throwable) (obj1)));
        obj1 = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        throw obj1;
    }

    public static void a(long l, Callback callback)
    {
        com/offerup/android/network/t;
        JVM INSTR monitorenter ;
        o.f(o.a(Executors.newSingleThreadExecutor())).addToWatchlist(l, callback);
        com/offerup/android/network/t;
        JVM INSTR monitorexit ;
        return;
        callback;
        throw callback;
    }

    public static void b(long l, Callback callback)
    {
        com/offerup/android/network/t;
        JVM INSTR monitorenter ;
        o.f(o.a(Executors.newSingleThreadExecutor())).removeFromWatchlist(l, callback);
        com/offerup/android/network/t;
        JVM INSTR monitorexit ;
        return;
        callback;
        throw callback;
    }
}
