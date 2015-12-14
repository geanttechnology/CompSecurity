// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.view.MenuItem;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            AndroidNavigationPane

private class <init>
    implements android.support.design.widget.
{

    final AndroidNavigationPane this$0;

    public boolean onNavigationItemSelected(MenuItem menuitem)
    {
        boolean flag;
        if (AndroidNavigationPane.access$200(AndroidNavigationPane.this) == null)
        {
            flag = false;
        } else
        {
            flag = AndroidNavigationPane.access$200(AndroidNavigationPane.this).vigationItemSelected(menuitem);
        }
        if (flag)
        {
            select(menuitem.getItemId());
            for (Iterator iterator = AndroidNavigationPane.access$300(AndroidNavigationPane.this).iterator(); iterator.hasNext(); ((com.amazon.gallery.thor.view.r.this._cls0)iterator.next())._mth0(menuitem)) { }
            close();
        }
        return flag;
    }

    private ()
    {
        this$0 = AndroidNavigationPane.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
