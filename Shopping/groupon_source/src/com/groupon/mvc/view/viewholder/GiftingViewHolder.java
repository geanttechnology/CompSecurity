// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class GiftingViewHolder extends RecyclerItemViewHolder
{

    View giftingInstructionSection;
    View giftingSectionView;

    public GiftingViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        giftingInstructionSection.setOnClickListener((android.view.View.OnClickListener)callback);
        giftingSectionView.setVisibility(0);
    }
}
