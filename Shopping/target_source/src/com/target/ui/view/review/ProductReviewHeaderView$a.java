// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.review;

import com.target.mothership.model.bazaar_voice.interfaces.ProductSecondaryReview;
import com.target.ui.view.common.ViewPagerIndicator;
import java.util.List;

// Referenced classes of package com.target.ui.view.review:
//            ProductReviewHeaderView

private class <init>
    implements android.support.v4.view.a
{

    final ProductReviewHeaderView this$0;

    public void a(int i)
    {
        ProductReviewHeaderView.a(ProductReviewHeaderView.this).indicator.a(i);
        ProductReviewHeaderView.a(ProductReviewHeaderView.this).indicator.setContentDescription(((ProductSecondaryReview)ProductReviewHeaderView.b(ProductReviewHeaderView.this).get(i)).b());
    }

    public void a(int i, float f, int j)
    {
    }

    public void b(int i)
    {
    }

    private ProductSecondaryReview()
    {
        this$0 = ProductReviewHeaderView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
