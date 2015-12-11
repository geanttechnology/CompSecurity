// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import com.ebay.common.model.SavedSeller;
import java.util.List;

// Referenced classes of package com.ebay.common:
//            UserCache

class val.savedSellers
    implements Runnable
{

    final llers this$0;
    final List val$savedSellers;

    public void run()
    {
        if (val$savedSellers != null)
        {
            for (int i = 0; i < val$savedSellers.size(); i++)
            {
                String s = ((SavedSeller)val$savedSellers.get(i)).userId;
                cess._mth1200(this._cls0.this).ler(s);
            }

        }
        cess._mth1200(this._cls0.this).llers();
    }

    ()
    {
        this$0 = final_;
        val$savedSellers = List.this;
        super();
    }
}
