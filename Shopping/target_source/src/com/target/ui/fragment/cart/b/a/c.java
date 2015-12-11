// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart.b.a;

import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.services.x;
import com.target.ui.helper.b.a;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.cart.b.a:
//            a

public class c extends com.target.ui.fragment.cart.b.a.a
    implements com.target.ui.helper.b.a.b, com.target.ui.helper.b.a.c
{

    private ProductRecommendations mProductRecommendations;

    public c(a a1)
    {
        super(a1);
    }

    public void a(CartDetails cartdetails)
    {
        if (mProductRecommendations == null || mProductRecommendations.a().isEmpty())
        {
            mCartDataHelper.a(cartdetails, this, this);
        } else
        if (mCartPresentation != null)
        {
            mCartPresentation.b(mProductRecommendations);
            return;
        }
    }

    public void a(ProductRecommendations productrecommendations)
    {
        mProductRecommendations = productrecommendations;
        if (mCartPresentation == null)
        {
            return;
        }
        if (productrecommendations.a().isEmpty())
        {
            mCartPresentation.q();
            return;
        } else
        {
            mCartPresentation.b(productrecommendations);
            return;
        }
    }

    public void a(x x)
    {
        if (mCartPresentation == null)
        {
            return;
        } else
        {
            mCartPresentation.q();
            return;
        }
    }

    public void b()
    {
        if (mCartPresentation == null)
        {
            return;
        } else
        {
            mCartPresentation.e();
            return;
        }
    }

    public void k()
    {
        if (mCartPresentation == null)
        {
            return;
        } else
        {
            mCartPresentation.t();
            return;
        }
    }
}
