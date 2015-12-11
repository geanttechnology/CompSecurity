// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v7.internal.view.menu.ac;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.y;
import android.view.MenuItem;

// Referenced classes of package android.support.v7.widget:
//            ActionMenuPresenter

class <init>
    implements y
{

    final ActionMenuPresenter this$0;

    public void onCloseMenu(i j, boolean flag)
    {
        if (j instanceof ac)
        {
            ((ac)j).n().a(false);
        }
        y y1 = getCallback();
        if (y1 != null)
        {
            y1.onCloseMenu(j, flag);
        }
    }

    public boolean onOpenSubMenu(i j)
    {
        if (j == null)
        {
            return false;
        }
        mOpenSubMenuId = ((ac)j).getItem().getItemId();
        y y1 = getCallback();
        if (y1 != null)
        {
            return y1.onOpenSubMenu(j);
        } else
        {
            return false;
        }
    }

    private ()
    {
        this$0 = ActionMenuPresenter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
