// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import com.groupon.callbacks.OnDealImageEventListener;
import com.groupon.models.nst.DealImageCarouselMetadata;
import com.groupon.util.LoggingUtils;
import java.util.List;

// Referenced classes of package com.groupon.view:
//            DealImageView

class this._cls0
    implements android.support.v4.view.ChangeListener
{

    final DealImageView this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        DealImageView.access$802(DealImageView.this, i);
        if (DealImageView.access$900(DealImageView.this) != null)
        {
            DealImageView.access$900(DealImageView.this).onImageChange(i);
        }
        DealImageView.access$1000(DealImageView.this).logImpression("", "deal_image", "deal_details", (new StringBuilder()).append(i + 1).append(":").append(DealImageView.access$200(DealImageView.this).size()).toString(), new DealImageCarouselMetadata(DealImageView.access$400(DealImageView.this)));
    }

    arouselMetadata()
    {
        this$0 = DealImageView.this;
        super();
    }
}
