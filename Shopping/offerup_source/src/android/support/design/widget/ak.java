// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.j;
import android.view.MenuItem;

// Referenced classes of package android.support.design.widget:
//            NavigationView, al

final class ak
    implements j
{

    private NavigationView a;

    ak(NavigationView navigationview)
    {
        a = navigationview;
        super();
    }

    public final boolean onMenuItemSelected(i i, MenuItem menuitem)
    {
        return NavigationView.a(a) != null && NavigationView.a(a).a();
    }

    public final void onMenuModeChange(i i)
    {
    }
}
