// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.cart;

import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.ui.view.BitmapImageView;

// Referenced classes of package com.target.ui.adapter.cart:
//            CartProductAdapter

public static interface Product
{

    public abstract void a(CartProduct cartproduct);

    public abstract void a(CartProduct cartproduct, int i);

    public abstract void a(GiftProduct giftproduct);

    public abstract void a(BitmapImageView bitmapimageview, CartProduct cartproduct);

    public abstract void b(CartProduct cartproduct);

    public abstract void c(CartProduct cartproduct);

    public abstract void d(CartProduct cartproduct);

    public abstract void e(CartProduct cartproduct);

    public abstract void f(CartProduct cartproduct);
}
