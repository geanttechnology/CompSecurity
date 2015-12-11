// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import android.content.Intent;

// Referenced classes of package com.ebay.mobile.user.symban:
//            SymbanFragment

class val.finalIntent
    implements Runnable
{

    final SymbanFragment this$0;
    final Intent val$finalIntent;

    public void run()
    {
        if (ensureActivity() == null)
        {
            return;
        } else
        {
            startActivity(val$finalIntent);
            return;
        }
    }

    ()
    {
        this$0 = final_symbanfragment;
        val$finalIntent = Intent.this;
        super();
    }
}
