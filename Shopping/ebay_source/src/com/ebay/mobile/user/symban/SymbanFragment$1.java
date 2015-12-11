// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;


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
            commitDismissedItems();
            return;
        }
    }

    ()
    {
        this$0 = SymbanFragment.this;
        super();
    }
}
