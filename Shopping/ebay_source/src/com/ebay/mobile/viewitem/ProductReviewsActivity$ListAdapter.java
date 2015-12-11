// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.mobile.Item;
import com.ebay.mobile.common.eBayRating;
import com.ebay.nautilus.domain.net.api.guidesandreviews.Reviews;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ProductReviewsActivity

private class headerView extends ArrayAdapter
{

    private int ELLIPSIS_LENGTH_THRESHOLD;
    private final Context context;
    private final DateFormat dateFormatter = DateFormat.getDateInstance(2, Locale.getDefault());
    private final String ellipsis;
    private final View headerView;
    private final LayoutInflater inflater;
    private final TextView reviewsCount;
    private final eBayRating reviewsRating;
    final ProductReviewsActivity this$0;

    public void addItems(List list)
    {
        addAll(list);
        notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (i == 0)
        {
            viewgroup = headerView;
        } else
        {
            com.ebay.nautilus.domain.net.api.guidesandreviews.  = (com.ebay.nautilus.domain.net.api.guidesandreviews.)getItem(i);
            String s;
            int j;
            boolean flag;
            if (view != null && (view.getTag() instanceof getItem))
            {
                viewgroup = (getItem)view.getTag();
            } else
            {
                view = inflater.inflate(0x7f030291, viewgroup, false);
                viewgroup = new init>(null);
                viewgroup.itleTextView = (TextView)view.findViewById(0x7f1008bc);
                viewgroup.extTextView = (TextView)view.findViewById(0x7f1008c0);
                viewgroup.extFullTextView = (TextView)view.findViewById(0x7f1008c2);
                viewgroup.ateTextView = (TextView)view.findViewById(0x7f1008bf);
                viewgroup.eviewByTextView = (TextView)view.findViewById(0x7f1008be);
                viewgroup.eviewRating = (eBayRating)view.findViewById(0x7f1008bd);
                ((eviewRating) (viewgroup)).eviewRating.setFeedbackStarResources(0x7f02022b, 0x7f02022d, 0, 0x7f02022c);
                ((eviewRating) (viewgroup)).eviewRating.setOnTouchListener(null);
                viewgroup.xpandImage = (ImageView)view.findViewById(0x7f1008c1);
                view.setTag(viewgroup);
            }
            ((xpandImage) (viewgroup)).itleTextView.setText(..t());
            s = "";
            if (. != null)
            {
                s = ..t();
                ((ontent) (viewgroup)).extFullTextView.setText(s);
            }
            ((extFullTextView) (viewgroup)).eviewByTextView.setText(context.getString(0x7f070934, new Object[] {
                ..name
            }));
            ((.username) (viewgroup)).eviewRating.setValue(..floatValue());
            if (. != null)
            {
                ((view.lastModifiedDate) (viewgroup)).ateTextView.setText(context.getString(0x7f070276, new Object[] {
                    dateFormatter.format(..lastModifiedDate)
                }));
                ((view.lastModifiedDate) (viewgroup)).ateTextView.setVisibility(0);
            } else
            {
                ((ateTextView) (viewgroup)).ateTextView.setVisibility(8);
            }
            flag = ProductReviewsActivity.access$100(ProductReviewsActivity.this).get(i);
            if (s.length() > ELLIPSIS_LENGTH_THRESHOLD)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (j != 0)
            {
                ((ELLIPSIS_LENGTH_THRESHOLD) (viewgroup)).extTextView.setText((new StringBuilder()).append(s.substring(0, ELLIPSIS_LENGTH_THRESHOLD - 1)).append(ellipsis).toString());
                if (flag)
                {
                    ((ellipsis) (viewgroup)).extFullTextView.setVisibility(0);
                    ((extFullTextView) (viewgroup)).extTextView.setVisibility(8);
                    ((extTextView) (viewgroup)).xpandImage.setImageResource(0x7f020256);
                } else
                {
                    ((xpandImage) (viewgroup)).extFullTextView.setVisibility(8);
                    ((extFullTextView) (viewgroup)).extTextView.setVisibility(0);
                    ((extTextView) (viewgroup)).xpandImage.setImageResource(0x7f020252);
                }
            } else
            {
                ((xpandImage) (viewgroup)).extTextView.setText(s);
            }
            viewgroup = ((extTextView) (viewgroup)).xpandImage;
            if (j != 0)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            viewgroup.setVisibility(j);
            j = getCount() - 1;
            if (ProductReviewsActivity.logTag.unt)
            {
                ProductReviewsActivity.logTag.unt((new StringBuilder()).append("count=").append(j).append(";position=").append(i).append(";reviewCount=").append(ProductReviewsActivity.access$200(ProductReviewsActivity.this).count).append(";pageNumber=").append(ProductReviewsActivity.access$300(ProductReviewsActivity.this)).toString());
            }
            viewgroup = view;
            if (i == j - 1)
            {
                viewgroup = view;
                if (j < ProductReviewsActivity.access$200(ProductReviewsActivity.this).count)
                {
                    viewgroup = view;
                    if (j <= ProductReviewsActivity.access$300(ProductReviewsActivity.this) * 10)
                    {
                        getMore();
                        return view;
                    }
                }
            }
        }
        return viewgroup;
    }

    public (Context context1, int i, int j, List list)
    {
        this$0 = ProductReviewsActivity.this;
        super(context1, i, j, list);
        ELLIPSIS_LENGTH_THRESHOLD = 250;
        inflater = (LayoutInflater)context1.getSystemService("layout_inflater");
        context = context1;
        headerView = inflater.inflate(0x7f0301aa, null);
        headerView.setTag(Boolean.valueOf(false));
        reviewsCount = (TextView)headerView.findViewById(0x7f1004f7);
        reviewsRating = (eBayRating)headerView.findViewById(0x7f1004f6);
        reviewsRating.setFeedbackStarResources(0x7f02022b, 0x7f02022d, 0x7f02022b, 0x7f02022c);
        reviewsRating.setOnTouchListener(null);
        reviewsRating.setValue(item.productReviewAverageRating);
        reviewsRating.invalidate();
        reviewsCount.setText(getString(0x7f0708d2, new Object[] {
            Long.valueOf(item.productReviewCount)
        }));
        ellipsis = context1.getString(0x7f0703a7);
        if (context1.getResources().getBoolean(0x7f0b0006))
        {
            ELLIPSIS_LENGTH_THRESHOLD = 800;
        }
        headerStart(0x7f03012c, (ViewGroup)headerView);
    }
}
