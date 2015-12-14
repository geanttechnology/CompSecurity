// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.net.Uri;
import com.perfectcorp.model.Model;
import java.util.Date;

public class a extends Model
{

    public static int EVENT_EXPIRED = -1;
    public static int EVENT_ONGOING = 2;
    public static int EVENT_UPCOMING = 0;
    public static int EVENT_VOTING = 1;
    private Integer a;
    public String contestDeepLink;
    public String contestURL;
    public String description;
    public String descriptionForFacebook;
    public Integer entries;
    public String eventEndDate;
    public String eventStartDate;
    public Long id;
    public String joinContestURL;
    public Integer priority;
    public String shareURL;
    public String status;
    public Date submitEndDate;
    public Date submitStartDate;
    public Uri thumbnail;
    public String title;
    public Date voteEndDate;
    public Date voteStartDate;

    public int a(Date date)
    {
        if (a != null)
        {
            return a.intValue();
        }
        int j = EVENT_EXPIRED;
        int i = j;
        if (date != null)
        {
            i = j;
            if (submitStartDate != null)
            {
                i = j;
                if (submitEndDate != null)
                {
                    i = j;
                    if (voteStartDate != null)
                    {
                        i = j;
                        if (voteEndDate != null)
                        {
                            if (date.compareTo(submitStartDate) < 0)
                            {
                                i = EVENT_UPCOMING;
                            } else
                            if (date.compareTo(submitEndDate) < 0)
                            {
                                i = EVENT_ONGOING;
                            } else
                            if (date.compareTo(voteStartDate) >= 0 && date.compareTo(voteEndDate) < 0)
                            {
                                i = EVENT_VOTING;
                            } else
                            {
                                i = EVENT_EXPIRED;
                            }
                        }
                    }
                }
            }
        }
        a = Integer.valueOf(i);
        return i;
    }

    public Long b_()
    {
        return id;
    }


    public ()
    {
        a = null;
    }
}
