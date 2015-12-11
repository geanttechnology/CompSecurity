// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


// Referenced classes of package com.tapjoy:
//            TJPlacement, TJPlacementManager

final class a
    implements nitWebViewListener
{

    final TJPlacement a;

    public final void onClosed()
    {
        if (TJPlacement.b(a))
        {
            TJPlacementManager.decrementPlacementCacheCount();
            TJPlacement.c(a);
        }
        if (TJPlacement.d(a))
        {
            TJPlacementManager.decrementPlacementPreRenderCount();
            TJPlacement.a(a, false);
        }
    }

    public final void onContentReady()
    {
        TJPlacement.a(a);
    }

    ager(TJPlacement tjplacement)
    {
        a = tjplacement;
        super();
    }
}
