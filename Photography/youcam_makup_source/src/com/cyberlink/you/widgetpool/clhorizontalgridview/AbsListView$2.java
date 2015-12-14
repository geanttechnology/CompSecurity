// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.clhorizontalgridview;


// Referenced classes of package com.cyberlink.you.widgetpool.clhorizontalgridview:
//            AbsListView

class a
    implements Runnable
{

    final AbsListView a;

    public void run()
    {
        if (a.v)
        {
            AbsListView abslistview = a;
            a.w = false;
            abslistview.v = false;
            AbsListView.a(a, false);
            if ((a.getPersistentDrawingCache() & 2) == 0)
            {
                AbsListView.b(a, false);
            }
            if (!a.isAlwaysDrawnWithCacheEnabled())
            {
                a.invalidate();
            }
        }
    }

    (AbsListView abslistview)
    {
        a = abslistview;
        super();
    }
}
