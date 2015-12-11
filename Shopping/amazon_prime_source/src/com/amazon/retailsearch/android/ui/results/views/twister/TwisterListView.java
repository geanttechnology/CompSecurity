// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.twister;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.RetailSearchResultStyles;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.FeatureStateUtil;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.DetailPageType;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.StyledText;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.twister:
//            TwisterDialog

public class TwisterListView extends ListView
{
    private class TwisterListAdapter extends BaseAdapter
    {

        final TwisterListView this$0;

        public int getCount()
        {
            if (editions == null)
            {
                return 0;
            } else
            {
                return editions.size();
            }
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = View.inflate(getContext(), com.amazon.retailsearch.R.layout.rs_twister_list_item, null);
            }
            if (i < 0 || i >= editions.size())
            {
                return view;
            }
            view = (TwisterModel.Edition)editions.get(i);
            TextView textview = (TextView)viewgroup.findViewById(com.amazon.retailsearch.R.id.rs_twister_item_edition_info);
            if ("T1".equals(FeatureStateUtil.getTwisterRentalPriceWeblab(featureConfig)) && !Utils.isEmpty(((TwisterModel.Edition) (view)).styledRentalPrices))
            {
                textview.setText(generateMultiplePrices(view));
                i = getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_twister_item_multiple_lines_padding_top_bottom);
            } else
            {
                textview.setText(generateSinglePrice(view));
                i = getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_twister_item_padding_top_bottom);
            }
            viewgroup.setPadding(viewgroup.getPaddingLeft(), i, viewgroup.getPaddingRight(), i);
            viewgroup.setOnClickListener(((TwisterModel.Edition) (view)).resultItem. new android.view.View.OnClickListener() {

                final TwisterListAdapter this$1;
                final RetailSearchResultItem val$resultItem;

                public void onClick(View view)
                {
                    if (dialog != null && userInteractionListener != null)
                    {
                        userInteractionListener.resultItemSelected(resultItem, DetailPageType.TWISTER);
                        dialog.dismiss();
                    }
                }

            
            {
                this$1 = final_twisterlistadapter;
                resultItem = RetailSearchResultItem.this;
                super();
            }
            });
            return viewgroup;
        }

        private TwisterListAdapter()
        {
            this$0 = TwisterListView.this;
            super();
        }

    }


    private TwisterDialog dialog;
    protected List editions;
    FeatureConfiguration featureConfig;
    UserInteractionListener userInteractionListener;

    public TwisterListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
        setDivider(new ColorDrawable(getResources().getColor(com.amazon.retailsearch.R.color.rs_twister_divider)));
        setDividerHeight(1);
        setOverScrollMode(2);
        setAdapter(new TwisterListAdapter());
    }

    private StyledSpannableString generateMultiplePrices(TwisterModel.Edition edition)
    {
        StyledSpannableString styledspannablestring = new StyledSpannableString(getContext());
        if (!TextUtils.isEmpty(edition.text))
        {
            styledspannablestring.append(edition.text, com.amazon.retailsearch.R.style.Rs_Twister_ItemInfo_TitleSpan);
        }
        populateStyledPrice(styledspannablestring, edition.styledRentalPrices, edition.srdsBadgeId);
        populateStyledPrice(styledspannablestring, edition.styledPrice, edition.srdsBadgeId);
        return styledspannablestring;
    }

    private StyledSpannableString generateSinglePrice(TwisterModel.Edition edition)
    {
        StyledSpannableString styledspannablestring = new StyledSpannableString(getContext());
        if (!TextUtils.isEmpty(edition.text))
        {
            styledspannablestring.append(edition.text, com.amazon.retailsearch.R.style.Rs_Twister_ItemInfo_TitleSpan);
            if (!TextUtils.isEmpty(edition.price))
            {
                styledspannablestring.append(" - ");
            }
        }
        if (!TextUtils.isEmpty(edition.price))
        {
            styledspannablestring.append(edition.price, com.amazon.retailsearch.R.style.Rs_Twister_ItemInfo_PriceSpan);
        }
        if (!TextUtils.isEmpty(edition.srdsBadgeId))
        {
            styledspannablestring.append(" ");
            styledspannablestring.appendBadge(edition.srdsBadgeId, Integer.valueOf(com.amazon.retailsearch.R.style.Rs_Twister_ItemInfo_BadgeSpan));
        }
        return styledspannablestring;
    }

    private void populateStyledPrice(StyledSpannableString styledspannablestring, List list, String s)
    {
        if (styledspannablestring != null && list != null)
        {
            styledspannablestring.appendNewLine();
            styledspannablestring.append("  ");
            for (list = list.iterator(); list.hasNext();)
            {
                StyledText styledtext = (StyledText)list.next();
                if (RetailSearchResultStyles.STYLE_HIGHLIGHT.equals(styledtext.getStyle()))
                {
                    styledspannablestring.append(styledtext.getText(), com.amazon.retailsearch.R.style.Rs_Twister_ItemInfo_PriceSpan);
                } else
                {
                    styledspannablestring.append(styledtext.getText(), com.amazon.retailsearch.R.style.Rs_Twister_ItemInfo_TextSpan);
                }
            }

            if (!TextUtils.isEmpty(s))
            {
                styledspannablestring.append(" ");
                styledspannablestring.appendBadge(s, Integer.valueOf(com.amazon.retailsearch.R.style.Rs_Twister_ItemInfo_BadgeSpan));
                return;
            }
        }
    }

    public List getEditions()
    {
        return editions;
    }

    public void setEditions(List list)
    {
        editions = list;
    }

    protected void setTwisterDialog(TwisterDialog twisterdialog)
    {
        dialog = twisterdialog;
    }



}
