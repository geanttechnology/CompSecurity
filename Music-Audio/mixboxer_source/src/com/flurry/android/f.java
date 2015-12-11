// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            fp, FlurryAgent, ce

final class f extends fp
{

    private boolean t;

    f(boolean flag)
    {
        t = flag;
        super();
    }

    public final void c()
    {
        FlurryAgent.an.s().onNetworkStateChanged(t);
    }
}
