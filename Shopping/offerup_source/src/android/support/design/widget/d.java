// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;


// Referenced classes of package android.support.design.widget:
//            bm, bk, CoordinatorLayout, AppBarLayout

final class d
    implements bm
{

    private CoordinatorLayout a;
    private AppBarLayout b;
    private AppBarLayout.Behavior c;

    d(AppBarLayout.Behavior behavior, CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout)
    {
        c = behavior;
        a = coordinatorlayout;
        b = appbarlayout;
        super();
    }

    public final void a(bk bk1)
    {
        c.a(a, b, bk1.c());
    }
}
