// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.MenuItem;

// Referenced classes of package android.support.v4.view:
//            ar

final class as
    implements android.view.MenuItem.OnActionExpandListener
{

    private ar a;

    public as(ar ar1)
    {
        a = ar1;
    }

    public final boolean onMenuItemActionCollapse(MenuItem menuitem)
    {
        return a.b(menuitem);
    }

    public final boolean onMenuItemActionExpand(MenuItem menuitem)
    {
        return a.a(menuitem);
    }
}
