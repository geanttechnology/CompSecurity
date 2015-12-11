// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.ShareActionProvider;
import android.view.MenuItem;

public final class lk
    implements android.view.MenuItem.OnMenuItemClickListener
{

    private ShareActionProvider a;

    public lk(ShareActionProvider shareactionprovider)
    {
        a = shareactionprovider;
        super();
    }

    public final boolean onMenuItemClick(MenuItem menuitem)
    {
        menuitem = hl.a(ShareActionProvider.a(a), ShareActionProvider.b(a)).b(menuitem.getItemId());
        if (menuitem != null)
        {
            menuitem.addFlags(0x80000);
            ShareActionProvider.a(a).startActivity(menuitem);
        }
        return true;
    }
}
