// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.widget;

import android.view.View;

// Referenced classes of package com.ebay.mobile.sell.widget:
//            PaypalEmailAutoComplete

class this._cls0
    implements android.view.
{

    final PaypalEmailAutoComplete this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
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
