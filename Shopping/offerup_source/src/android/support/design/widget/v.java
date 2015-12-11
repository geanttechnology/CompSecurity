// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;


// Referenced classes of package android.support.design.widget:
//            CoordinatorLayout

final class v
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    private CoordinatorLayout a;

    v(CoordinatorLayout coordinatorlayout)
    {
        a = coordinatorlayout;
        super();
    }

    public final boolean onPreDraw()
    {
        a.a(false);
        return true;
    }
}
