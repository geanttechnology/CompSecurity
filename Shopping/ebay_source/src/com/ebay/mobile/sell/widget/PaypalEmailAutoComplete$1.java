// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.widget;

import android.view.View;

// Referenced classes of package com.ebay.mobile.sell.widget:
//            PaypalEmailAutoComplete

class this._cls0
    implements android.view.AutoComplete._cls1
{

    final PaypalEmailAutoComplete this$0;

    public void onClick(View view)
    {
        if (!isPopupShowing())
        {
            forceSuggestionQuery();
        }
    }

    ()
    {
        this$0 = PaypalEmailAutoComplete.this;
        super();
    }
}
