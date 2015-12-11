// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


// Referenced classes of package com.tapjoy:
//            TJCacheListener, TJPlacement

final class a
    implements TJCacheListener
{

    final TJCacheListener a;
    final TJPlacement b;

    public final void onCachingComplete(int i)
    {
        a.onCachingComplete(i);
    }

    r(TJPlacement tjplacement, TJCacheListener tjcachelistener)
    {
        b = tjplacement;
        a = tjcachelistener;
        super();
    }
}
