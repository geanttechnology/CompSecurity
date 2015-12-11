// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout

class val.asin
    implements ler.ModelMatcher
{

    final StackLayout this$0;
    final String val$asin;

    public boolean match(Object obj)
    {
        return (obj instanceof Product) && val$asin.equals(((Product)obj).getAsin());
    }

    ler.ModelMatcher()
    {
        this$0 = final_stacklayout;
        val$asin = String.this;
        super();
    }
}
