// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.net.Uri;
import com.perfectcorp.model.Model;
import java.util.Date;

public class  extends Model
{

    public static int EVENT_EXPIRED = -1;
    public static int EVENT_ONGOING = 1;
    public static int EVENT_UPCOMING = 0;
    public static String LimitProdNum = "LimitProdNum";
    public static String SelectUser = "SelectUser";
    public Long brandId;
    public Date endTime;
    public String eventLink;
    public String eventType;
    public Long id;
    public Uri imageUrl;
    public Integer joinNum;
    public Date lastModified;
    public String locale;
    public Integer priority;
    public Integer quantity;
    public String serviceType;
    public Date startTime;
    public String userStatus;

    public int a(Date date)
    {
label0:
        {
            int j = EVENT_EXPIRED;
            int i = j;
            if (date != null)
            {
                i = j;
                if (startTime != null)
                {
                    i = j;
                    if (endTime != null)
                    {
                        if (date.compareTo(startTime) >= 0)
                        {
                            break label0;
                        }
                        i = EVENT_UPCOMING;
                    }
                }
            }
            return i;
        }
        if (date.compareTo(endTime) < 0)
        {
            return EVENT_ONGOING;
        } else
        {
            return EVENT_EXPIRED;
        }
    }

    public Long b_()
    {
        return id;
    }


    public ()
    {
    }
}
