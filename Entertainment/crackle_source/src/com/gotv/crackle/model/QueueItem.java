// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.model;

import com.gotv.crackle.util.DateTimeFormatter;
import com.gotv.crackle.util.StringUtil;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.model:
//            BrowseModel

public class QueueItem extends BrowseModel
{

    private static final String DURATION = "Duration";
    private static final String DURATION_IN_SECONDS = "DurationInSeconds";
    private static final String EPISODE = "Episode";
    private static final String ID = "ID";
    private static final String IMAGE_URL = "OneSheetImage_185_277";
    public static final String ITEMS = "Items";
    private static final String ITEM_TYPE = "ItemType";
    private static final String LAST_VIEWED_DATE = "LastViewedDate";
    private static final String PARENT_CHANNEL_ID = "ParentChannelID";
    private static final String RATING = "Rating";
    private static final String RIGHTSEXPIRATIONDATE = "RightsExpirationDate";
    private static final String ROOT_CHANNEL_ID = "RootChannelID";
    private static final String SEASON = "Season";
    private static final String TITLE = "Title";
    private String mDuration;
    private String mDurationInSeconds;
    private String mEpisode;
    private String mID;
    private String mImageUrl;
    private Date mLastViewedDate;
    private String mParentChannelID;
    private String mRating;
    private String mRootChannelID;
    private String mSeason;
    private String mTitle;
    private Integer mViewedDaysAgo;
    private String m_ItemType;
    private Integer m_expiresInDays;
    private boolean m_expiresInLessThan5days;
    private Date m_rightsExpirationDate;

    public QueueItem(JSONObject jsonobject)
        throws JSONException
    {
        mID = jsonobject.getString("ID");
        mTitle = StringUtil.removeHtmlFromString(jsonobject.getString("Title"));
        mDuration = jsonobject.getString("Duration");
        mDurationInSeconds = jsonobject.getString("DurationInSeconds");
        mImageUrl = jsonobject.getString("OneSheetImage_185_277");
        mParentChannelID = jsonobject.getString("ParentChannelID");
        mRootChannelID = jsonobject.getString("RootChannelID");
        mRating = jsonobject.getString("Rating");
        m_ItemType = jsonobject.getString("ItemType");
        mEpisode = jsonobject.getString("Episode");
        if (mEpisode != null && mEpisode.equalsIgnoreCase("null"))
        {
            mEpisode = null;
        }
        mSeason = jsonobject.getString("Season");
        if (mSeason != null && mSeason.equalsIgnoreCase("null"))
        {
            mSeason = null;
        }
        try
        {
            m_rightsExpirationDate = DateTimeFormatter.parseJSONDateString(jsonobject.getString("RightsExpirationDate"), "M/d/yyyy h:mm:ss a");
            if (m_rightsExpirationDate != null)
            {
                Date date = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(6, 5);
                date = calendar.getTime();
                m_expiresInDays = Integer.valueOf((int)Math.round((double)(m_rightsExpirationDate.getTime() - (new Date()).getTime()) / 86400000D) + 1);
                if (m_rightsExpirationDate.before(date))
                {
                    m_expiresInLessThan5days = true;
                }
            }
        }
        catch (ParseException parseexception) { }
        try
        {
            mLastViewedDate = DateTimeFormatter.parseJSONDateString(jsonobject.getString("LastViewedDate"), "M/d/yyyy h:mm:ss a");
            mViewedDaysAgo = Integer.valueOf((int)Math.round((double)((new Date()).getTime() - mLastViewedDate.getTime()) / 86400000D) + 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return;
        }
    }

    public String getDuration()
    {
        return DateTimeFormatter.getHourMinuteString(mDuration);
    }

    public String getDurationInSeconds()
    {
        return mDurationInSeconds;
    }

    public String getEpisode()
    {
        return mEpisode;
    }

    public String getExpires()
    {
        if (m_rightsExpirationDate == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        String s = DateTimeFormatter.stringWithDateFormat(m_rightsExpirationDate, "MMM d, yyyy");
        return s;
        ParseException parseexception;
        parseexception;
        return "";
    }

    public Integer getExpiresInDays()
    {
        return m_expiresInDays;
    }

    public boolean getExpiresInLessThan5days()
    {
        return m_expiresInLessThan5days;
    }

    public String getID()
    {
        return mID;
    }

    public String getImageUrl()
    {
        return mImageUrl;
    }

    public String getItemType()
    {
        return m_ItemType;
    }

    public Date getLastViewedDate()
    {
        return mLastViewedDate;
    }

    public String getParentChannelID()
    {
        return mParentChannelID;
    }

    public String getRating()
    {
        return mRating;
    }

    public Date getRightsExpirationDate()
    {
        return m_rightsExpirationDate;
    }

    public String getRootChannel()
    {
        return mRootChannelID;
    }

    public String getRootChannelID()
    {
        return mRootChannelID;
    }

    public String getSeason()
    {
        return mSeason;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public Integer getViewedDaysAgo()
    {
        return mViewedDaysAgo;
    }
}
