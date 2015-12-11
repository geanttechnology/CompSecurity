// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.EbayCategory;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            CategoryViewModel

public class CategoryLineItemViewHolder extends ViewHolder
{

    private final TextView textView;

    public CategoryLineItemViewHolder(View view)
    {
        super(view);
        view.setOnClickListener(this);
        textView = (TextView)view.findViewById(0x1020014);
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof CategoryViewModel)
        {
            viewmodel = ((CategoryViewModel)viewmodel).category;
            itemView.setTag(viewmodel);
            if (viewmodel != null && android.os.Build.VERSION.SDK_INT >= 21)
            {
                itemView.setTransitionName((new StringBuilder()).append("categoryLineItem-").append(Long.toString(((EbayCategory) (viewmodel)).id)).toString());
            }
            if (textView != null)
            {
                TextView textview = textView;
                if (viewmodel != null)
                {
                    viewmodel = ((EbayCategory) (viewmodel)).name;
                } else
                {
                    viewmodel = "";
                }
                textview.setText(viewmodel);
                return;
            }
        }
    }
}
