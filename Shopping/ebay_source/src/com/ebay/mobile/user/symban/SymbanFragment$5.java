// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import com.ebay.nautilus.domain.content.dm.SymbanDataManager;

// Referenced classes of package com.ebay.mobile.user.symban:
//            SymbanFragment

class this._cls0
    implements Runnable
{

    final SymbanFragment this$0;

    public void run()
    {
        if (ensureActivity() == null)
        {
            return;
        } else
        {
            setListShown(false);
            symbanDm.reloadList();
            return;
        }
    }

    aManager()
    {
        this$0 = SymbanFragment.this;
        super();
    }
}
