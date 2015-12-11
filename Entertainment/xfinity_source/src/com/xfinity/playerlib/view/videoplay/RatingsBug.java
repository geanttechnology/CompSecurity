// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.comcast.cim.model.Rating;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import java.util.Locale;

public class RatingsBug
{

    private Animation fadeRatingsBugIn;
    private boolean isMovie;
    private View ratingsBugView;

    public RatingsBug(Activity activity, VideoFacade videofacade)
    {
        isMovie = false;
        isMovie = videofacade.isMovie();
        ratingsBugView = activity.findViewById(com.xfinity.playerlib.R.id.ratings_bug);
        TextView textview = (TextView)ratingsBugView.findViewById(com.xfinity.playerlib.R.id.rating_bug_program);
        TextView textview1 = (TextView)ratingsBugView.findViewById(com.xfinity.playerlib.R.id.rating_bug_rating);
        TextView textview2 = (TextView)ratingsBugView.findViewById(com.xfinity.playerlib.R.id.rating_bug_sub_rating);
        Rating rating = videofacade.getVideoRating();
        textview.setText(activity.getString(com.xfinity.playerlib.R.string.TV));
        if (rating != null)
        {
            textview1.setText(rating.getRating().toUpperCase(Locale.US));
        } else
        {
            textview1.setText("");
        }
        if (videofacade.getVideoSubRating() != null)
        {
            textview2.setVisibility(0);
            textview2.setText(convertSubRatingsDelimitedString(videofacade.getVideoSubRating()));
        }
        fadeRatingsBugIn = AnimationUtils.loadAnimation(activity, com.xfinity.playerlib.R.anim.ratings_bug_fade);
        ratingsBugView.setContentDescription(activity.getString(com.xfinity.playerlib.R.string.content_description_ratings_bug_info, new Object[] {
            textview1.getText(), textview2.getText()
        }));
    }

    private String convertSubRatingsDelimitedString(String s)
    {
        String as[] = s.split(",");
        StringBuffer stringbuffer = new StringBuffer();
        int i = 0;
        while (i < as.length) 
        {
            if (i > 0)
            {
                s = " ";
            } else
            {
                s = "";
            }
            stringbuffer.append(s).append(as[i]);
            i++;
        }
        return stringbuffer.toString();
    }

    public void start()
    {
        if (!isMovie)
        {
            ratingsBugView.setVisibility(0);
            ratingsBugView.startAnimation(fadeRatingsBugIn);
        }
    }

    public void stop()
    {
        if (!isMovie)
        {
            ratingsBugView.setVisibility(4);
            ratingsBugView.clearAnimation();
        }
    }
}
