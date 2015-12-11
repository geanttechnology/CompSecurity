// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.c.a.b;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package android.support.v7.internal.view.menu:
//            i

class j extends i
{
    class a extends i.a
        implements android.view.ActionProvider.VisibilityListener
    {

        android.support.v4.view.d.b c;
        final j d;

        public View a(MenuItem menuitem)
        {
            return a.onCreateActionView(menuitem);
        }

        public void a(android.support.v4.view.d.b b1)
        {
            c = b1;
            ActionProvider actionprovider = a;
            if (b1 != null)
            {
                b1 = this;
            } else
            {
                b1 = null;
            }
            actionprovider.setVisibilityListener(b1);
        }

        public boolean b()
        {
            return a.overridesItemVisibility();
        }

        public boolean c()
        {
            return a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean flag)
        {
            if (c != null)
            {
                c.a(flag);
            }
        }

        public a(Context context, ActionProvider actionprovider)
        {
            d = j.this;
            super(j.this, context, actionprovider);
        }
    }


    j(Context context, b b)
    {
        super(context, b);
    }

    i.a a(ActionProvider actionprovider)
    {
        return new a(a, actionprovider);
    }
}
