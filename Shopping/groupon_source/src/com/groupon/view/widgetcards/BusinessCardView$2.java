// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.widget.ImageView;
import com.groupon.db.models.Business;
import com.groupon.view.BusinessMapSlice;
import com.groupon.view.UrlImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.groupon.view.widgetcards:
//            BusinessCardView

class val.business
    implements Callback
{

    final BusinessCardView this$0;
    final Business val$business;

    public void onError(ImageView imageview)
    {
        BusinessCardView.access$000(BusinessCardView.this).setVisibility(8);
        setMapSliceImage(val$business);
    }

    public void onSuccess(ImageView imageview)
    {
        mapSlice.setVisibility(8);
    }

    ()
    {
        this$0 = final_businesscardview;
        val$business = Business.this;
        super();
    }
}
