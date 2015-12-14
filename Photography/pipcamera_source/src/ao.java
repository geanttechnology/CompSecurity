// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

class ao extends aj
    implements android.view.ActionProvider.VisibilityListener
{

    android.support.v4.view.ActionProvider.VisibilityListener c;
    final an d;

    public ao(an an, Context context, ActionProvider actionprovider)
    {
        d = an;
        super(an, context, actionprovider);
    }

    public boolean isVisible()
    {
        return a.isVisible();
    }

    public void onActionProviderVisibilityChanged(boolean flag)
    {
        if (c != null)
        {
            c.onActionProviderVisibilityChanged(flag);
        }
    }

    public View onCreateActionView(MenuItem menuitem)
    {
        return a.onCreateActionView(menuitem);
    }

    public boolean overridesItemVisibility()
    {
        return a.overridesItemVisibility();
    }

    public void refreshVisibility()
    {
        a.refreshVisibility();
    }

    public void setVisibilityListener(android.support.v4.view.ActionProvider.VisibilityListener visibilitylistener)
    {
        c = visibilitylistener;
        ActionProvider actionprovider = a;
        if (visibilitylistener != null)
        {
            visibilitylistener = this;
        } else
        {
            visibilitylistener = null;
        }
        actionprovider.setVisibilityListener(visibilitylistener);
    }
}
