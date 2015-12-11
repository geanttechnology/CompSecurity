// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.EbayCategory;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            CategoryViewModel

public final class CategoryTileViewHolder extends ViewHolder
{

    private RemoteImageView categoryImage;
    private TextView categoryName;

    public CategoryTileViewHolder(View view)
    {
        super(view);
        if (itemView != null)
        {
            itemView.setOnClickListener(this);
            categoryImage = (RemoteImageView)itemView.findViewById(0x7f1000c2);
            categoryName = (TextView)itemView.findViewById(0x7f1000c3);
        }
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof CategoryViewModel)
        {
            viewmodel = ((CategoryViewModel)viewmodel).category;
            if (itemView != null && categoryImage != null && categoryName != null && viewmodel != null)
            {
                categoryName.setText(((EbayCategory) (viewmodel)).name);
                String s = CategoryViewModel.getCategoryImageUrl(((EbayCategory) (viewmodel)).id);
                categoryImage.setRemoteImageUrl(s);
                if (android.os.Build.VERSION.SDK_INT >= 21)
                {
                    categoryImage.setTransitionName((new StringBuilder()).append("categoryImage-").append(Long.toString(((EbayCategory) (viewmodel)).id)).toString());
                    categoryName.setTransitionName((new StringBuilder()).append("categoryLineItem-").append(Long.toString(((EbayCategory) (viewmodel)).id)).toString());
                }
                itemView.setTag(0x7f100010, viewmodel);
            }
        }
    }
}
