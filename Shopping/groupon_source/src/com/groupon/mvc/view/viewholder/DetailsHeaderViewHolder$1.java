// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.groupon.view.DealDetailsTemporaryImage;
import com.squareup.picasso.Callback;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            DetailsHeaderViewHolder

class this._cls0
    implements Callback
{

    final DetailsHeaderViewHolder this$0;

    public void onError(ImageView imageview)
    {
    }

    public void onSuccess(ImageView imageview)
    {
        temporaryDealImageView.animate().alpha(0.0F).setDuration(200L).setStartDelay(400L);
    }

    ()
    {
        this$0 = DetailsHeaderViewHolder.this;
        super();
    }
}
