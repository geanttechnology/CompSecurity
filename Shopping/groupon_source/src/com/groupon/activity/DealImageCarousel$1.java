// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v7.app.ActionBar;
import com.groupon.models.nst.DealImageCarouselMetadata;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.activity:
//            DealImageCarousel

class val.count
    implements android.support.v4.view.geListener
{

    final DealImageCarousel this$0;
    final int val$count;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        i++;
        LoggingUtils loggingutils = DealImageCarousel.access$000(DealImageCarousel.this);
        String s = (new StringBuilder()).append(i).append(":").append(val$count).toString();
        Object obj;
        if (jsonEncodedNSTField != null)
        {
            obj = jsonEncodedNSTField;
        } else
        {
            obj = new DealImageCarouselMetadata(channel);
        }
        loggingutils.logImpression("", "deal_image", "image_carousel", s, ((com.groupon.models.nst.JsonEncodedNSTField) (obj)));
        getSupportActionBar().setTitle(String.format(DEAL_IMAGE_CAROUSEL_ACTION_BAR_TITLE, new Object[] {
            Integer.valueOf(i), Integer.valueOf(val$count)
        }));
    }

    etadata()
    {
        this$0 = final_dealimagecarousel;
        val$count = I.this;
        super();
    }
}
