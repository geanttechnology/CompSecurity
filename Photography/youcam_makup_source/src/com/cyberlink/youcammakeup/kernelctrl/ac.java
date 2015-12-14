// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.content.pm.ResolveInfo;
import android.view.MenuItem;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            ShareActionProvider

class ac
    implements android.view.MenuItem.OnMenuItemClickListener
{

    final ShareActionProvider a;

    private ac(ShareActionProvider shareactionprovider)
    {
        a = shareactionprovider;
        super();
    }

    ac(ShareActionProvider shareactionprovider, ShareActionProvider._cls1 _pcls1)
    {
        this(shareactionprovider);
    }

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        menuitem = (ResolveInfo)ShareActionProvider.a(a).get(menuitem.getItemId());
        a.b(menuitem);
        return true;
    }
}
