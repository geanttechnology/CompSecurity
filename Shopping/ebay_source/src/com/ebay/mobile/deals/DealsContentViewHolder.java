// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.ListOfListingsViewModel;
import com.ebay.mobile.home.cards.ListingViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.ebay.mobile.deals:
//            ListingViewHolder

public class DealsContentViewHolder extends ViewHolder
{

    private static final int SCREEN_WIDTH_WIDE = 768;
    private static final int dealIds[] = {
        0x7f1000fd, 0x7f1000fe, 0x7f1000ff, 0x7f100238, 0x7f100246
    };
    protected static boolean isTablet;
    public final List dealViews = new ArrayList();
    private final int dp;
    public final TextView groupTitle;
    private boolean isButtonWidthSet;
    private final Resources resources;
    private final Button showMoreButton;

    public DealsContentViewHolder(View view)
    {
        super(view);
        resources = view.getResources();
        isTablet = resources.getBoolean(0x7f0b0006);
        DisplayMetrics displaymetrics;
        int ai[];
        int j;
        boolean flag;
        if (isTablet)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        isButtonWidthSet = flag;
        displaymetrics = resources.getDisplayMetrics();
        dp = (int)((float)displaymetrics.widthPixels / displaymetrics.density);
        ai = dealIds;
        j = ai.length;
        for (int i = 0; i < j; i++)
        {
            int k = ai[i];
            View view1 = itemView.findViewById(k);
            if (view1 != null)
            {
                dealViews.add(new ListingViewHolder(view1));
            }
        }

        groupTitle = (TextView)view.findViewById(0x7f10005f);
        showMoreButton = (Button)view.findViewById(0x7f10029c);
        showMoreButton.setOnClickListener(this);
        setFullSpan(true);
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        if (viewmodel instanceof ListOfListingsViewModel)
        {
            viewmodel = (ListOfListingsViewModel)viewmodel;
            ListIterator listiterator = ((ListOfListingsViewModel) (viewmodel)).listings.listIterator();
            do
            {
                if (!listiterator.hasNext())
                {
                    break;
                }
                if (TextUtils.isEmpty(((ListingViewModel)listiterator.next()).title))
                {
                    listiterator.remove();
                }
            } while (true);
            if (((ListOfListingsViewModel) (viewmodel)).listings.size() >= 0)
            {
                return true;
            }
        }
        return false;
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (!isButtonWidthSet && (viewmodel.viewType == 2 || viewmodel.viewType == 41 || viewmodel.viewType == 40) && dp < 768)
        {
            android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)showMoreButton.getLayoutParams();
            layoutparams.width = resources.getDimensionPixelSize(0x7f090139);
            showMoreButton.setLayoutParams(layoutparams);
            isButtonWidthSet = true;
        }
        if (viewmodel instanceof ListOfListingsViewModel)
        {
            ListOfListingsViewModel listoflistingsviewmodel = (ListOfListingsViewModel)viewmodel;
            groupTitle.setText(((ListOfListingsViewModel)viewmodel).listingsTitle);
            if (viewmodel.viewType == 2 || viewmodel.viewType == 14)
            {
                showMoreButton.setText(0x7f0701ea);
            }
            int j = listoflistingsviewmodel.listings.size();
            int i = 0;
            while (i < dealViews.size()) 
            {
                viewmodel = (ListingViewHolder)dealViews.get(i);
                if (i < j)
                {
                    viewmodel.bind((ListingViewModel)listoflistingsviewmodel.listings.get(i));
                    ((ListingViewHolder) (viewmodel)).itemView.setVisibility(0);
                } else
                {
                    ((ListingViewHolder) (viewmodel)).itemView.setVisibility(4);
                }
                i++;
            }
            showMoreButton.setVisibility(0);
        }
    }

}
