// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.ansel.fetch.ImageLoader;
import com.amazon.ansel.fetch.ResourceLoader;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.ansel.fetch.tools.collection.Factory;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout

class val.product
    implements Factory
{

    final StackLayout this$0;
    final Product val$product;

    public ResourceLoader get()
    {
        return new ImageLoader(StackLayout.access$300(StackLayout.this).getContext(), 0L, StackLayout.access$400(StackLayout.this).fromUrl(val$product.getImage().getUrl()));
    }

    public volatile Object get()
    {
        return get();
    }

    ()
    {
        this$0 = final_stacklayout;
        val$product = Product.this;
        super();
    }
}
