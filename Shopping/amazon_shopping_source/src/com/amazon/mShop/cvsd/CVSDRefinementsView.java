// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.cvsd.CVSDReceivedResult;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.Address;
import java.util.Iterator;
import java.util.List;

public class CVSDRefinementsView extends ScrollView
    implements TitleProvider
{

    public static final String KEY_REFINEMENTS_SELECTED_INDEX = "com.amazon.mShop.cvsd.CVSDRefinementsView.KEY_REFINEMENTS_SELECTED_INDEX";
    final AmazonActivity amazonActivity;
    final LayoutInflater layoutInflater;

    public CVSDRefinementsView(AmazonActivity amazonactivity)
    {
        super(amazonactivity);
        amazonActivity = amazonactivity;
        layoutInflater = LayoutInflater.from(amazonactivity);
        amazonactivity = new LinearLayout(amazonActivity);
        amazonactivity.setOrientation(1);
        amazonactivity.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
        addView(amazonactivity);
        if (!Util.isEmpty(CVSDReceivedResult.message))
        {
            TextView textview = new TextView(amazonActivity);
            textview.setText(CVSDReceivedResult.message);
            int i = (int)getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.padding);
            textview.setPadding(i, i, i, i);
            amazonactivity.addView(textview);
        }
        if (CVSDReceivedResult.receivedAddresss != null)
        {
            Object obj = CVSDReceivedResult.receivedAddresss;
            final int selectedIndex = 0;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                Address address = (Address)((Iterator) (obj)).next();
                View view = layoutInflater.inflate(com.amazon.mShop.android.lib.R.layout.cvsd_refinement_option_item, null);
                Button button = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.opl_cvsd_refinement_option_item_button);
                button.setText(address.getName());
                button.setOnClickListener(new android.view.View.OnClickListener() {

                    final CVSDRefinementsView this$0;
                    final int val$selectedIndex;

                    public void onClick(View view1)
                    {
                        view1 = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putInt("com.amazon.mShop.cvsd.CVSDRefinementsView.KEY_REFINEMENTS_SELECTED_INDEX", selectedIndex);
                        view1.putExtras(bundle);
                        amazonActivity.setResult(-1, view1);
                        amazonActivity.finish();
                    }

            
            {
                this$0 = CVSDRefinementsView.this;
                selectedIndex = i;
                super();
            }
                });
                amazonactivity.addView(view);
                selectedIndex++;
            }

        }
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_for_a_convenience_store);
    }
}
