// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.widget.TextView;
import com.groupon.v3.util.ScrollEventRecyclerView;

// Referenced classes of package com.groupon.view:
//            TripAdvisorReviewSection, TripAdvisorRatingBar

public class 
    implements butterknife.nder
{

    public void bind(butterknife.nder nder, TripAdvisorReviewSection tripadvisorreviewsection, Object obj)
    {
        tripadvisorreviewsection.header = (View)nder.nder(obj, 0x7f10056b, "field 'header'");
        tripadvisorreviewsection.content = (View)nder.(obj, 0x7f10056f, "field 'content'");
        tripadvisorreviewsection.hotelRating = (TripAdvisorRatingBar)nder.ting((View)nder.ting(obj, 0x7f10056c, "field 'hotelRating'"), 0x7f10056c, "field 'hotelRating'");
        tripadvisorreviewsection.reviewCountText = (TextView)nder.ountText((View)nder.ountText(obj, 0x7f10056d, "field 'reviewCountText'"), 0x7f10056d, "field 'reviewCountText'");
        tripadvisorreviewsection.expandButton = (View)nder.utton(obj, 0x7f10056e, "field 'expandButton'");
        tripadvisorreviewsection.mostRecentText = (TextView)nder.entText((View)nder.entText(obj, 0x7f100570, "field 'mostRecentText'"), 0x7f100570, "field 'mostRecentText'");
        tripadvisorreviewsection.reviewList = (ScrollEventRecyclerView)nder.ist((View)nder.ist(obj, 0x7f100571, "field 'reviewList'"), 0x7f100571, "field 'reviewList'");
    }

    public volatile void bind(butterknife.nder nder, Object obj, Object obj1)
    {
        bind(nder, (TripAdvisorReviewSection)obj, obj1);
    }

    public void unbind(TripAdvisorReviewSection tripadvisorreviewsection)
    {
        tripadvisorreviewsection.header = null;
        tripadvisorreviewsection.content = null;
        tripadvisorreviewsection.hotelRating = null;
        tripadvisorreviewsection.reviewCountText = null;
        tripadvisorreviewsection.expandButton = null;
        tripadvisorreviewsection.mostRecentText = null;
        tripadvisorreviewsection.reviewList = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((TripAdvisorReviewSection)obj);
    }

    public ()
    {
    }
}
