// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import java.util.Date;

// Referenced classes of package com.socialin.android.apiv3.model:
//            ImageItem

public class Contest2
{

    public static final int CONTEST_SYS_TYPE_NEW = 2;
    public static final int CONTEST_SYS_TYPE_OLD = 1;
    public static final int CONTEST_SYS_TYPE_THREE = 3;
    public static final int TYPE_ACTIVE = 0;
    public static final int TYPE_JUST_ENDED = 1;
    public static final int TYPE_NOT_STARTED = 3;
    public static final int TYPE_PAST = 2;
    public static final String prefixLarge = "?r1024x1024";
    public static final String prefixMidle = "?r640x640";
    public static final String prefixSmall = "?r240x240";
    public static final String prefixThumb = "?c120x120";
    public String category;
    public int contestSystemType;
    public String coverUrl;
    public Date createDate;
    public String descUrl;
    public String description;
    public Date endDate;
    public String fullName;
    public String name;
    public ImageItem photo;
    public int photosCount;
    public Date startDate;
    public Date submitDate;
    public String thumbUrl;
    public int tillEnd;
    public int tillSubmit;
    public int type;

    public Contest2()
    {
        type = 0;
        tillSubmit = -1;
        tillEnd = -1;
        contestSystemType = 1;
    }

    public String getCoverUrl()
    {
        if (getThumbUrl() != null && !getThumbUrl().equals(""))
        {
            return getThumbUrl();
        }
        if (getSmallUrl() != null && !getSmallUrl().equals(""))
        {
            return getSmallUrl();
        }
        if (getMidleUrl() != null && !getMidleUrl().equals(""))
        {
            return getMidleUrl();
        }
        if (getLargeUrl() != null && !getLargeUrl().equals(""))
        {
            return getLargeUrl();
        } else
        {
            return coverUrl;
        }
    }

    public String getLargeUrl()
    {
        if (coverUrl != null)
        {
            return (new StringBuilder()).append(coverUrl).append("?r1024x1024").toString();
        } else
        {
            return null;
        }
    }

    public String getMidleUrl()
    {
        if (coverUrl != null)
        {
            return (new StringBuilder()).append(coverUrl).append("?r640x640").toString();
        } else
        {
            return null;
        }
    }

    public String getSmallUrl()
    {
        if (coverUrl != null)
        {
            return (new StringBuilder()).append(coverUrl).append("?r240x240").toString();
        } else
        {
            return null;
        }
    }

    public String getThumbUrl()
    {
        if (coverUrl != null)
        {
            return (new StringBuilder()).append(coverUrl).append("?c120x120").toString();
        } else
        {
            return null;
        }
    }
}
