// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.db.models.HotelReview;
import com.groupon.util.HumanReadableDateTimeDifferenceFormat;
import com.groupon.view.ExpandablePanel;
import com.groupon.view.TripAdvisorRatingBar;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class TripAdvisorReviewAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    private class OnReviewClickListener
        implements android.view.View.OnClickListener
    {

        private final int reviewPos;
        private final TextView reviewText;
        final TripAdvisorReviewAdapter this$0;

        public void onClick(View view)
        {
            int i = 0x7fffffff;
            if (expandablePanel.isExpanding())
            {
                return;
            }
            int j = reviewText.getHeight();
            ViewTreeObserver viewtreeobserver;
            TripAdvisorReviewAdapter tripadvisorreviewadapter;
            TextView textview;
            boolean flag;
            if (reviewText.getMaxLines() == 0x7fffffff)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view = reviewText;
            if (flag)
            {
                i = 4;
            }
            view.setMaxLines(i);
            viewtreeobserver = reviewText.getViewTreeObserver();
            tripadvisorreviewadapter = TripAdvisorReviewAdapter.this;
            textview = reviewText;
            i = reviewPos;
            if (flag)
            {
                view = "collapse";
            } else
            {
                view = "expand";
            }
            viewtreeobserver.addOnGlobalLayoutListener(tripadvisorreviewadapter. new OnReviewLayoutListener(textview, i, j, view));
        }

        public OnReviewClickListener(TextView textview, int i)
        {
            this$0 = TripAdvisorReviewAdapter.this;
            super();
            reviewText = textview;
            reviewPos = i;
        }
    }

    public static interface OnReviewExpandListener
    {

        public abstract void onReviewExpand(String s, double d, int i, int j);
    }

    private class OnReviewLayoutListener
        implements android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        private final String actionType;
        private final int reviewPos;
        private final TextView reviewText;
        private final int startingHeight;
        final TripAdvisorReviewAdapter this$0;

        public void onGlobalLayout()
        {
            int i = reviewText.getHeight() - startingHeight;
            if (i != 0)
            {
                onReviewExpandListener.onReviewExpand(actionType, ((HotelReview)hotelReviews.get(reviewPos)).rating, reviewPos + 1, i);
            }
            reviewText.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public OnReviewLayoutListener(TextView textview, int i, int j, String s)
        {
            this$0 = TripAdvisorReviewAdapter.this;
            super();
            reviewText = textview;
            reviewPos = i;
            startingHeight = j;
            actionType = s;
        }
    }

    public static class ReviewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        TextView body;
        TextView date;
        TripAdvisorRatingBar ratingBar;
        TextView reviewerName;
        TextView title;

        public ReviewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    private static final int DEFAULT_LINES = 4;
    private ExpandablePanel expandablePanel;
    private List hotelReviews;
    private HumanReadableDateTimeDifferenceFormat humanReadableDateTimeDifferenceFormat;
    private OnReviewExpandListener onReviewExpandListener;

    public TripAdvisorReviewAdapter(Context context, List list, ExpandablePanel expandablepanel)
    {
        hotelReviews = list;
        expandablePanel = expandablepanel;
        RoboGuice.getInjector(context).injectMembers(this);
    }

    public int getItemCount()
    {
        return hotelReviews.size();
    }

    public volatile void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        onBindViewHolder((ReviewHolder)viewholder, i);
    }

    public void onBindViewHolder(ReviewHolder reviewholder, int i)
    {
        Object obj = (HotelReview)hotelReviews.get(i);
        double d = ((HotelReview) (obj)).rating;
        String s = ((HotelReview) (obj)).title;
        String s1 = ((HotelReview) (obj)).body;
        if (Double.compare(d, 0.0D) != 0)
        {
            reviewholder.ratingBar.setRating(d);
            reviewholder.ratingBar.setVisibility(0);
        } else
        {
            reviewholder.ratingBar.setVisibility(8);
        }
        reviewholder.reviewerName.setText(((HotelReview) (obj)).userName);
        if (((HotelReview) (obj)).publishedDate != null)
        {
            reviewholder.date.setVisibility(0);
            reviewholder.date.setText(humanReadableDateTimeDifferenceFormat.getReadableTimer(((HotelReview) (obj)).publishedDate));
        } else
        {
            reviewholder.date.setVisibility(8);
        }
        reviewholder.title.setText(s);
        obj = reviewholder.title;
        if (Strings.isEmpty(s))
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((TextView) (obj)).setVisibility(i);
        if (Strings.notEmpty(s1))
        {
            reviewholder.body.setText(s1.trim());
            reviewholder.body.setVisibility(0);
        } else
        {
            reviewholder.body.setVisibility(8);
        }
        reviewholder.itemView.setOnClickListener(new OnReviewClickListener(reviewholder.body, reviewholder.getPosition()));
    }

    public volatile android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return onCreateViewHolder(viewgroup, i);
    }

    public ReviewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return new ReviewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f03021b, viewgroup, false));
    }

    public void setOnReviewExpandListener(OnReviewExpandListener onreviewexpandlistener)
    {
        onReviewExpandListener = onreviewexpandlistener;
    }



}
