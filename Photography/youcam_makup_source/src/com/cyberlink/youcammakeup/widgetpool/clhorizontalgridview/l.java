// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;


// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
//            AbsListView

class l
{

    private int a;
    final AbsListView c;

    private l(AbsListView abslistview)
    {
        c = abslistview;
        super();
    }

    l(AbsListView abslistview, AbsListView._cls1 _pcls1)
    {
        this(abslistview);
    }

    public void a()
    {
        a = AbsListView.a(c);
    }

    public boolean b()
    {
        return c.hasWindowFocus() && AbsListView.b(c) == a;
    }
}
