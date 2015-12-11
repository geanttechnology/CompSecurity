// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.util.Args;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn.tsccm:
//            BasicPoolEntry

public class BasicPoolEntryRef extends WeakReference
{

    private final HttpRoute route;

    public BasicPoolEntryRef(BasicPoolEntry basicpoolentry, ReferenceQueue referencequeue)
    {
        super(basicpoolentry, referencequeue);
        Args.notNull(basicpoolentry, "Pool entry");
        route = basicpoolentry.getPlannedRoute();
    }

    public final HttpRoute getRoute()
    {
        return route;
    }
}
