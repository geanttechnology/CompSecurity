// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import com.ebay.mobile.sell.widget.PaypalEmailAutoComplete;

// Referenced classes of package com.ebay.mobile.sell:
//            PreferencesSpokeFragment

class this._cls0
    implements Runnable
{

    final PreferencesSpokeFragment this$0;

    public void run()
    {
        paypalEmailAddress.dismissDropDown();
    }

    ete()
    {
        this$0 = PreferencesSpokeFragment.this;
        super();
    }
}
