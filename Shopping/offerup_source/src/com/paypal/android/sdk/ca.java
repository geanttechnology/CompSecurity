// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.paypal.android.sdk:
//            by

final class ca
    implements Runnable
{

    private by a;

    ca(by by1)
    {
        a = by1;
        super();
    }

    public final void run()
    {
        ((Runnable)by.b(a).poll()).run();
    }
}
