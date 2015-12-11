// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.app;

import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.j;
import android.support.v7.internal.widget.DecorToolbar;
import android.view.MenuItem;

// Referenced classes of package android.support.v7.internal.app:
//            ToolbarActionBar

final class <init>
    implements j
{

    final ToolbarActionBar this$0;

    public final boolean onMenuItemSelected(i i, MenuItem menuitem)
    {
        return false;
    }

    public final void onMenuModeChange(i i)
    {
        if (ToolbarActionBar.access$000(ToolbarActionBar.this) != null)
        {
            if (ToolbarActionBar.access$300(ToolbarActionBar.this).isOverflowMenuShowing())
            {
                ToolbarActionBar.access$000(ToolbarActionBar.this)._mth0(108, i);
            } else
            if (ToolbarActionBar.access$000(ToolbarActionBar.this)._mth0(0, null, i))
            {
                ToolbarActionBar.access$000(ToolbarActionBar.this)._mth0(108, i);
                return;
            }
        }
    }

    private ()
    {
        this$0 = ToolbarActionBar.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
