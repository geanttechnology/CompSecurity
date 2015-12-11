// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import android.view.View;
import android.widget.AdapterView;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.view.BitmapImageView;

// Referenced classes of package com.target.ui.fragment.cart:
//            CartHomeFragment

private class <init>
    implements android.widget.lickListener
{

    final CartHomeFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (ProductDetails)adapterview.getItemAtPosition(i);
        view = (BitmapImageView)view.findViewById(0x7f1004ed);
        CartHomeFragment.a(CartHomeFragment.this, view, adapterview);
    }

    private ProductDetails()
    {
        this$0 = CartHomeFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
