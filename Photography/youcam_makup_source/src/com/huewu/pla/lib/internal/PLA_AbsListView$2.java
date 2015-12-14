// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib.internal;


// Referenced classes of package com.huewu.pla.lib.internal:
//            PLA_AbsListView

class a
    implements Runnable
{

    final PLA_AbsListView a;

    public void run()
    {
        if (a.p)
        {
            a.p = false;
            PLA_AbsListView.a(a, false);
            if ((a.getPersistentDrawingCache() & 2) == 0)
            {
                PLA_AbsListView.b(a, false);
            }
            if (!a.isAlwaysDrawnWithCacheEnabled())
            {
                a.invalidate();
            }
        }
    }

    (PLA_AbsListView pla_abslistview)
    {
        a = pla_abslistview;
        super();
    }
}
