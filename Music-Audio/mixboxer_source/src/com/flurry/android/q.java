// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.util.List;

// Referenced classes of package com.flurry.android:
//            FlurryDataSenderIndex

final class q
    implements Runnable
{

    private String V;
    private List W;
    private FlurryDataSenderIndex X;

    q(FlurryDataSenderIndex flurrydatasenderindex, String s, List list)
    {
        X = flurrydatasenderindex;
        V = s;
        W = list;
        super();
    }

    public final void run()
    {
        FlurryDataSenderIndex.a(X, V, W);
    }
}
