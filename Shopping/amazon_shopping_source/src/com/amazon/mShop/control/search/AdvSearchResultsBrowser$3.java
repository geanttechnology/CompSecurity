// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.search;

import com.amazon.rio.j2me.client.services.mShop.HyperText;

// Referenced classes of package com.amazon.mShop.control.search:
//            AdvSearchResultsBrowser

class val.value
    implements Runnable
{

    final AdvSearchResultsBrowser this$0;
    final HyperText val$value;

    public void run()
    {
        AdvSearchResultsBrowser.access$1502(AdvSearchResultsBrowser.this, val$value.getText());
    }

    ()
    {
        this$0 = final_advsearchresultsbrowser;
        val$value = HyperText.this;
        super();
    }
}
