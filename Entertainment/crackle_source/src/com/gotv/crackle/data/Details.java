// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.model.ChannelItem;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.DateTimeFormatter;
import com.gotv.crackle.util.StringUtil;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package com.gotv.crackle.data:
//            Localization

public class Details
{

    public String cast;
    public String description;
    public String directors;
    public String duration;
    public String expires;
    public String genres;
    public String rating;
    public Integer starRating;
    public String title;
    public String whyItCrackles;
    public String writers;

    public Details(ChannelItem channelitem)
    {
        title = null;
        starRating = null;
        description = null;
        expires = null;
        rating = null;
        duration = null;
        genres = null;
        cast = null;
        directors = null;
        writers = null;
        whyItCrackles = null;
        title = channelitem.getName();
        description = channelitem.getDescription();
        rating = channelitem.getRating();
        genres = channelitem.getGenre();
        if (channelitem.getDirector() != null && channelitem.getDirector().compareTo("") != 0)
        {
            directors = StringUtil.removeHtmlFromString(channelitem.getDirector()).trim();
        }
        whyItCrackles = StringUtil.removeHtmlFromString(channelitem.getWhyItCrackles()).trim();
    }

    public Details(MediaDetailsItem mediadetailsitem)
    {
        title = null;
        starRating = null;
        description = null;
        expires = null;
        rating = null;
        duration = null;
        genres = null;
        cast = null;
        directors = null;
        writers = null;
        whyItCrackles = null;
        fillInWithMediaDetails(mediadetailsitem);
    }

    public void fillInWithMediaDetails(MediaDetailsItem mediadetailsitem)
    {
        title = mediadetailsitem.getTitle();
        description = mediadetailsitem.getDescription();
        starRating = mediadetailsitem.getUserRating();
        Date date = mediadetailsitem.getRightsExpirationDate();
        if (date == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(5, 90);
        if ((new Date(calendar.getTimeInMillis())).after(date))
        {
            String s;
            if (!Application.getInstance().getLocalization().isLatinAmericaUI())
            {
                s = "MMM d, yyyy";
            } else
            {
                s = "d MMM, yyyy";
            }
            try
            {
                expires = DateTimeFormatter.stringWithDateFormat(date, s);
            }
            catch (Exception exception) { }
        }
        rating = mediadetailsitem.getRating();
        if (mediadetailsitem.getDuration() != null && mediadetailsitem.getDuration().compareTo("") != 0)
        {
            duration = DateTimeFormatter.getHourMinuteString(mediadetailsitem.getDuration());
        }
        genres = mediadetailsitem.getGenre();
        cast = mediadetailsitem.getCast();
        if (mediadetailsitem.getDirectors() != null && mediadetailsitem.getDirectors().compareTo("") != 0)
        {
            directors = StringUtil.removeHtmlFromString(mediadetailsitem.getDirectors()).trim();
        }
        writers = mediadetailsitem.getWriters();
        whyItCrackles = StringUtil.removeHtmlFromString(mediadetailsitem.getWhyItCrackles()).trim();
        return;
    }
}
