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

public class BrowseEntry extends BrowseModel
{

    private static final String CHANNELART_185_277 = "ChannelArt_185_277";
    private static final String DESCRIPTION = "Description";
    private static final String DURATIONINSECONDS = "DurationInSeconds";
    public static final String ENTRIES = "Entries";
    private static final String GENRE = "Genre";
    private static final String ID = "ID";
    private static final String ITEMTYPE = "ItemType";
    private static final String NAME = "Name";
    private static final String RATING = "Rating";
    private static final String RELEASEYEAR = "ReleaseYear";
    private static final String RIGHTSEXPIRATIONDATE = "RightsExpirationDate";
    private static final String ROOTCHANNEL = "RootChannel";
    private static final String ROOTCHANNEL_ID = "RootChannelID";
    private static final String USERRATING = "UserRating";
    private static final String WHYITCRACKLES = "WhyItCrackles";
    private static final String XITEMID = "XItemId";
    private String mChannelArt_185_277;
    private String mDescription;
    private String mDurationInSeconds;
    private String mGenre;
    private String mID;
    private String mItemType;
    private String mName;
    private String mRating;
    private String mReleaseYear;
    private String mRootChannel;
    private String mRootChannelID;
    private String mUserRating;
    private String mWhyItCrackles;
    private String mXItemId;
    private Integer m_expiresInDays;
    private boolean m_expiresInLessThan5days;
    private Date m_rightsExpirationDate;

    public BrowseEntry(JSONObject jsonobject)
        throws JSONException
    {
        mChannelArt_185_277 = jsonobject.getString("ChannelArt_185_277");
        mDescription = jsonobject.getString("Description");
        mDurationInSeconds = jsonobject.getString("DurationInSeconds");
        mGenre = jsonobject.getString("Genre");
        mID = jsonobject.getString("ID");
        mItemType = jsonobject.getString("ItemType");
        mName = StringUtil.removeHtmlFromString(jsonobject.getString("Name"));
        mRating = jsonobject.getString("Rating");
        mReleaseYear = jsonobject.getString("ReleaseYear");
        mRootChannel = jsonobject.getString("RootChannel");
        mRootChannelID = jsonobject.getString("RootChannelID");
        mUserRating = jsonobject.getString("UserRating");
        mWhyItCrackles = jsonobject.getString("WhyItCrackles");
        mXItemId = jsonobject.getString("XItemId");
        try
        {
            m_rightsExpirationDate = DateTimeFormatter.parseJSONDateString(jsonobject.getString("RightsExpirationDate"), "M/d/yyyy h:mm:ss a");
            if (m_rightsExpirationDate != null)
            {
                jsonobject = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(jsonobject);
                calendar.add(6, 5);
                jsonobject = calendar.getTime();
                m_expiresInDays = Integer.valueOf((int)Math.round((double)(m_rightsExpirationDate.getTime() - (new Date()).getTime()) / 86400000D) + 1);
                if (m_rightsExpirationDate.before(jsonobject))
                {
                    m_expiresInLessThan5days = true;
                }
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return;
        }
    }

    public String getChannelArt_185_277()
    {
        return mChannelArt_185_277;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public String getDuration()
    {
        return DateTimeFormatter.getHourMinuteStringFromSeconds(mDurationInSeconds);
    }

    public String getDurationInSeconds()
    {
        return mDurationInSeconds;
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

    public String getGenre()
    {
        return mGenre;
    }

    public String getID()
    {
        return mID;
    }

    public String getImageUrl()
    {
        return mChannelArt_185_277;
    }

    public String getItemType()
    {
        return mItemType;
    }

    public String getName()
    {
        return mName;
    }

    public String getRating()
    {
        return mRating;
    }

    public String getReleaseYear()
    {
        return mReleaseYear;
    }

    public Date getRightsExpirationDate()
    {
        return m_rightsExpirationDate;
    }

    public String getRootChannel()
    {
        return mRootChannel;
    }

    public String getRootChannelID()
    {
        return mRootChannelID;
    }

    public String getTitle()
    {
        return mName;
    }

    public String getUserRating()
    {
        return mUserRating;
    }

    public String getWhyItCrackles()
    {
        return mWhyItCrackles;
    }

    public String getXItemId()
    {
        return mXItemId;
    }
}
