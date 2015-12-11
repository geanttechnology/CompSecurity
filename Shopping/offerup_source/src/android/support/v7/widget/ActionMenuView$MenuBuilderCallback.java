// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.j;
import android.view.MenuItem;

// Referenced classes of package android.support.v7.widget:
//            ActionMenuView

class <init>
    implements j
{

    final ActionMenuView this$0;

    public boolean onMenuItemSelected(i i, MenuItem menuitem)
    {
        return ActionMenuView.access$200(ActionMenuView.this) != null && ActionMenuView.access$200(ActionMenuView.this).onMenuItemClick(menuitem);
    }

    public void onMenuModeChange(i i)
    {
        if (ActionMenuView.access$300(ActionMenuView.this) != null)
        {
            ActionMenuView.access$300(ActionMenuView.this).onMenuModeChange(i);
        }
    }

    private ner()
    {
        this$0 = ActionMenuView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
