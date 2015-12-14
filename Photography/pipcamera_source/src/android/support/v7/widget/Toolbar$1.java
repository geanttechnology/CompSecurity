// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.MenuItem;
import cz;
import dr;

// Referenced classes of package android.support.v7.widget:
//            Toolbar

public class a
    implements cz
{

    final Toolbar a;

    public boolean a(MenuItem menuitem)
    {
        if (Toolbar.access$000(a) != null)
        {
            return Toolbar.access$000(a).a(menuitem);
        } else
        {
            return false;
        }
    }

    (Toolbar toolbar)
    {
        a = toolbar;
        super();
    }
}
