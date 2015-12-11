// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import com.amazon.rio.j2me.client.services.mShop.KeyValuePair;
import java.util.List;

public class AmazonPointsSummaryView extends TableLayout
{

    public AmazonPointsSummaryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setColumnShrinkable(0, true);
        setColumnStretchable(0, true);
    }

    private void addRow(LayoutInflater layoutinflater, KeyValuePair keyvaluepair, int i)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(com.amazon.mShop.android.lib.R.layout.amazonpoints_summary_row, null);
        layoutinflater.setBackgroundColor(i);
        ((TextView)layoutinflater.findViewById(com.amazon.mShop.android.lib.R.id.amazonpoints_summary_row_name)).setText(keyvaluepair.getKey());
        ((TextView)layoutinflater.findViewById(com.amazon.mShop.android.lib.R.id.amazonpoints_summary_row_amount)).setText(keyvaluepair.getValue());
        addView(layoutinflater);
    }

    public void update(List list)
    {
        removeAllViews();
        if (list != null)
        {
            LayoutInflater layoutinflater = LayoutInflater.from(getContext());
            int j = getResources().getColor(com.amazon.mShop.android.lib.R.color.transparent);
            int i = getResources().getColor(com.amazon.mShop.android.lib.R.color.background_gray_light);
            for (int k = 0; k < list.size();)
            {
                addRow(layoutinflater, (KeyValuePair)list.get(k), j);
                int l = j;
                k++;
                j = i;
                i = l;
            }

        }
    }
}
