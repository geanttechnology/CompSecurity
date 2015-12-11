// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.UsableShipMode;
import com.target.mothership.model.guest.interfaces.Guest;

// Referenced classes of package com.target.ui.fragment.cart:
//            ShippingMethodDialogFragment

public static interface 
{

    public abstract void a(CartProduct cartproduct, UsableShipMode usableshipmode);

    public abstract void b(Guest guest);

    public abstract void h();
}
