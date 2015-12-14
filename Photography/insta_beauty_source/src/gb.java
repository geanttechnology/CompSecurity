// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class gb
    implements eu
{

    final Toolbar a;

    public gb(Toolbar toolbar)
    {
        a = toolbar;
        super();
    }

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
}
