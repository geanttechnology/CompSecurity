// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.adapter.TripAdvisorReviewAdapter;
import com.groupon.db.models.HotelReviews;
import com.groupon.models.nst.TravelReviewsClickExtraInfo;
import com.groupon.models.nst.TravelReviewsDetailImpressionExtraInfo;
import com.groupon.tracking.mobile.EncodedNSTField;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.v3.util.ScrollEventRecyclerView;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.view:
//            ExpandablePanel, WrapContentLinearLayoutManager, TripAdvisorRatingBar

public class TripAdvisorReviewSection extends ExpandablePanel
{
    private class OnTripAdvisorReviewExpandListener
        implements com.groupon.adapter.TripAdvisorReviewAdapter.OnReviewExpandListener
    {

        final TripAdvisorReviewSection this$0;

        public void onReviewExpand(String s, double d, int i, int j)
        {
            reviewList.getLayoutParams().height = reviewList.getHeight() + j;
            reviewList.setLayoutParams(reviewList.getLayoutParams());
            content.getLayoutParams().height = content.getHeight() + j;
            content.setLayoutParams(content.getLayoutParams());
            logger.logClick("", "travel_reviews_item_click", uuid, new EncodedNSTField() {

                final OnTripAdvisorReviewExpandListener this$1;

                public String toEncodedString()
                {
                    return dealType;
                }

            
            {
                this$1 = OnTripAdvisorReviewExpandListener.this;
                super();
            }
            }, new TravelReviewsClickExtraInfo("TA", s, Double.valueOf(d), Integer.valueOf(i)));
        }

        private OnTripAdvisorReviewExpandListener()
        {
            this$0 = TripAdvisorReviewSection.this;
            super();
        }

    }


    View content;
    private String dealType;
    View expandButton;
    View header;
    TripAdvisorRatingBar hotelRating;
    protected Logger logger;
    TextView mostRecentText;
    TextView reviewCountText;
    ScrollEventRecyclerView reviewList;
    private HotelReviews tripAdvisorInfo;
    private String uuid;

    public TripAdvisorReviewSection(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void init(Context context, AttributeSet attributeset)
    {
        ButterKnife.bind(this, LayoutInflater.from(context).inflate(0x7f03021c, this, true));
        RoboGuice.getInjector(context).injectMembers(this);
        setCollapsedHeight(0);
        setAnimationDuration(500);
        handleView = header;
        contentView = content;
        reviewList.setLayoutManager(new WrapContentLinearLayoutManager(context, 1, false));
    }

    public void updatePanelState(boolean flag, boolean flag1)
    {
        super.updatePanelState(flag, flag1);
        ViewPropertyAnimator viewpropertyanimator = expandButton.animate();
        float f;
        long l;
        if (flag)
        {
            f = 180F;
        } else
        {
            f = 0.0F;
        }
        viewpropertyanimator = viewpropertyanimator.rotation(f);
        if (flag1)
        {
            l = animationDuration;
        } else
        {
            l = 0L;
        }
        viewpropertyanimator.setDuration(l).start();
        if (flag1)
        {
            Logger logger1 = logger;
            String s1 = uuid;
            EncodedNSTField encodednstfield = new EncodedNSTField() {

                final TripAdvisorReviewSection this$0;

                public String toEncodedString()
                {
                    return dealType;
                }

            
            {
                this$0 = TripAdvisorReviewSection.this;
                super();
            }
            };
            String s;
            if (flag)
            {
                s = "expand";
            } else
            {
                s = "collapse";
            }
            logger1.logClick("", "travel_reviews_header_click", s1, encodednstfield, new TravelReviewsClickExtraInfo("TA", s));
            if (flag)
            {
                logger.logImpression("", "travel_reviews_details", uuid, dealType, new TravelReviewsDetailImpressionExtraInfo(tripAdvisorInfo));
            }
        }
    }

    public void updateViews(HotelReviews hotelreviews, String s, String s1)
    {
        tripAdvisorInfo = hotelreviews;
        uuid = s;
        dealType = s1;
        double d = hotelreviews.rating;
        s = new ArrayList(hotelreviews.reviews);
        double d1 = hotelreviews.reviewCount;
        if (Double.compare(d, 0.0D) != 0)
        {
            hotelRating.setRating(d);
        } else
        {
            hotelRating.setVisibility(8);
        }
        if (s.size() > 0)
        {
            mostRecentText.setText(String.format(getContext().getString(0x7f080424), new Object[] {
                Integer.valueOf(s.size())
            }));
            hotelreviews = new TripAdvisorReviewAdapter(getContext(), s, this);
            hotelreviews.setOnReviewExpandListener(new OnTripAdvisorReviewExpandListener());
            reviewList.setAdapter(hotelreviews);
            expandButton.setRotation(0.0F);
        } else
        {
            expandButton.setVisibility(8);
            content.setVisibility(8);
            header.setClickable(false);
        }
        if (Double.compare(d, 0.0D) != 0 || s.size() > 0)
        {
            if (Double.compare(d1, 0.0D) != 0)
            {
                reviewCountText.setText((new StringBuilder()).append("(").append(NumberFormat.getNumberInstance().format(d1)).append(")").toString());
            }
            setVisibility(0);
            updatePanelState(shouldExpandAfterLayout, false);
        }
    }


}
