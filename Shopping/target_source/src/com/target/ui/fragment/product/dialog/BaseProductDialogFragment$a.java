// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import com.target.mothership.common.a.g;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.helper.product.b;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ProductVariationModel;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            BaseProductDialogFragment

public static interface 
{

    public abstract void a(ProductDetails productdetails, b b1, ProductDetails productdetails1, ProductVariationModel productvariationmodel, Store store, g g);

    public abstract void a(Store store);

    public abstract void a(GridItem griditem);

    public abstract void a(ProductVariationModel productvariationmodel);

    public abstract void b(b b1);
}
