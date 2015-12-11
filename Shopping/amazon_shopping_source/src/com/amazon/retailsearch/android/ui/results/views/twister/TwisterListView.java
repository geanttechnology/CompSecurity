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
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.DetailPageType;

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
                return editions.length;
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
            if (i < 0 || i >= editions.length)
            {
                return view;
            }
            view = editions[i];
            TextView textview = (TextView)viewgroup.findViewById(com.amazon.retailsearch.R.id.rs_twister_item_edition_info);
            StyledSpannableString styledspannablestring = new StyledSpannableString(getContext());
            styledspannablestring.append(((TwisterModel.Edition) (view)).text);
            if (!TextUtils.isEmpty(((TwisterModel.Edition) (view)).price))
            {
                styledspannablestring.append(" - ");
                styledspannablestring.append(((TwisterModel.Edition) (view)).price, com.amazon.retailsearch.R.style.Rs_Twister_ItemInfo_PriceSpan);
            }
            if (!TextUtils.isEmpty(((TwisterModel.Edition) (view)).srdsBadgeId))
            {
                styledspannablestring.append(" ");
                styledspannablestring.appendBadge(((TwisterModel.Edition) (view)).srdsBadgeId, Integer.valueOf(com.amazon.retailsearch.R.style.Rs_Twister_ItemInfo_BadgeSpan));
            }
            textview.setText(styledspannablestring);
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
    protected TwisterModel.Edition editions[];
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

    public TwisterModel.Edition[] getEditions()
    {
        return editions;
    }

    public void setEditions(TwisterModel.Edition aedition[])
    {
        editions = aedition;
    }

    protected void setTwisterDialog(TwisterDialog twisterdialog)
    {
        dialog = twisterdialog;
    }

}
