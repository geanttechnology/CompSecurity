// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.view.m;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package android.support.v7.internal.view.menu:
//            p, t

final class u extends p
    implements android.view.ActionProvider.VisibilityListener
{

    private m b;

    public u(t t, Context context, ActionProvider actionprovider)
    {
        super(t, context, actionprovider);
    }

    public final View a(MenuItem menuitem)
    {
        return a.onCreateActionView(menuitem);
    }

    public final void a(m m1)
    {
        b = m1;
        a.setVisibilityListener(this);
    }

    public final boolean b()
    {
        return a.overridesItemVisibility();
    }

    public final boolean c()
    {
        return a.isVisible();
    }

    public final void onActionProviderVisibilityChanged(boolean flag)
    {
        if (b != null)
        {
            b.a();
        }
    }
}
