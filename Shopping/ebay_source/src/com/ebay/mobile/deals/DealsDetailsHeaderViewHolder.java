// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;

// Referenced classes of package com.ebay.mobile.deals:
//            DealsDetailsHeaderViewModel

public class DealsDetailsHeaderViewHolder extends ViewHolder
{

    private final TextView subtitle;
    private final TextView title;

    public DealsDetailsHeaderViewHolder(View view)
    {
        super(view);
        title = (TextView)view.findViewById(0x1020014);
        subtitle = (TextView)view.findViewById(0x1020015);
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        viewmodel = (DealsDetailsHeaderViewModel)viewmodel;
        title.setText(((DealsDetailsHeaderViewModel) (viewmodel)).title);
        if (TextUtils.isEmpty(((DealsDetailsHeaderViewModel) (viewmodel)).subtitle))
        {
            subtitle.setVisibility(8);
            return;
        } else
        {
            subtitle.setVisibility(0);
            subtitle.setText(((DealsDetailsHeaderViewModel) (viewmodel)).subtitle);
            return;
        }
    }
}
