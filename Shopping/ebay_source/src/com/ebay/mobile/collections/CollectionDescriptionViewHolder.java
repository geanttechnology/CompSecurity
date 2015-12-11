// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewModel;

// Referenced classes of package com.ebay.mobile.collections:
//            CollectionItemViewHolder, CollectionDescriptionViewModel

public class CollectionDescriptionViewHolder extends CollectionItemViewHolder
{

    public TextView description;
    public TextView headline;

    public CollectionDescriptionViewHolder(View view)
    {
        super(view);
        description = (TextView)itemView.findViewById(0x7f100123);
        headline = (TextView)itemView.findViewById(0x7f100122);
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        if (!(viewmodel instanceof CollectionDescriptionViewModel))
        {
            return false;
        } else
        {
            return isNotEmpty(new CharSequence[] {
                ((CollectionDescriptionViewModel)viewmodel).description
            });
        }
    }

    public void bind(ViewModel viewmodel)
    {
label0:
        {
            super.bind(viewmodel);
            if (viewmodel instanceof CollectionDescriptionViewModel)
            {
                viewmodel = (CollectionDescriptionViewModel)viewmodel;
                if (headline != null)
                {
                    if (!TextUtils.isEmpty(((CollectionDescriptionViewModel) (viewmodel)).headline))
                    {
                        headline.setVisibility(0);
                        headline.setText(((CollectionDescriptionViewModel) (viewmodel)).headline);
                    } else
                    {
                        headline.setVisibility(8);
                    }
                }
                if (description != null)
                {
                    if (TextUtils.isEmpty(((CollectionDescriptionViewModel) (viewmodel)).description))
                    {
                        break label0;
                    }
                    description.setVisibility(0);
                    description.setText(((CollectionDescriptionViewModel) (viewmodel)).description);
                }
            }
            return;
        }
        description.setVisibility(8);
    }
}
