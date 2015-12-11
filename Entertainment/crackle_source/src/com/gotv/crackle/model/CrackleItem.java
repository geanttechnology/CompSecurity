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

public class CrackleItem extends BrowseModel
{

    public static final String DESCRIPTION = "Description";
    public static final String DURATION = "Duration";
    public static final String GENRE = "Genre";
    public static final String ID = "ID";
    public static final String IMAGE_URL_10 = "ImageUrl10";
    public static final String ITEM_TYPE = "ItemType";
    public static final String MEDIA_TYPE = "MediaType";
    public static final String PARENT_CHANNEL_ID = "ParentChannelID";
    public static final String PARENT_CHANNEL_NAME = "ParentChannelName";
    public static final String RATING = "Rating";
    private static final String RIGHTSEXPIRATIONDATE = "RightsExpirationDate";
    public static final String ROOT_CHANNEL = "RootChannel";
    public static final String ROOT_CHANNEL_ID = "RootChannelID";
    public static final String TITLE = "Title";
    public static final String USER_RATING = "UserRating";
    public static final String XITEM_ID = "XItemId";
    private String mDescription;
    private String mDuration;
    private String mGenres[];
    private String mID;
    private String mImageUrl;
    private String mItemType;
    private String mMediaType;
    private String mParentChannelID;
    private String mParentChannelName;
    private String mRating;
    private String mRootChannel;
    private String mRootChannelID;
    private String mTitle;
    private int mUserRating;
    private String mXitemID;
    private Integer m_expiresInDays;
    private boolean m_expiresInLessThan5days;
    private Date m_rightsExpirationDate;

    public CrackleItem()
    {
    }

    public CrackleItem(JSONObject jsonobject)
        throws JSONException
    {
        mItemType = jsonobject.getString("ItemType");
        mMediaType = jsonobject.getString("MediaType");
        mID = jsonobject.getString("ID");
        mTitle = StringUtil.removeHtmlFromString(jsonobject.getString("Title"));
        mDescription = jsonobject.getString("Description");
        mImageUrl = jsonobject.getString("ImageUrl10");
        mGenres = jsonobject.getString("Genre").split(",");
        mRating = jsonobject.getString("Rating");
        mDuration = jsonobject.getString("Duration");
        mUserRating = jsonobject.getInt("UserRating");
        mRootChannel = jsonobject.getString("RootChannel");
        mRootChannelID = jsonobject.getString("RootChannelID");
        mXitemID = jsonobject.getString("XItemId");
        mParentChannelID = jsonobject.getString("ParentChannelID");
        mParentChannelName = jsonobject.getString("ParentChannelName");
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

    public String getDescription()
    {
        return mDescription;
    }

    public String getDuration()
    {
        return DateTimeFormatter.getHourMinuteString(mDuration);
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

    public String[] getGenres()
    {
        return mGenres;
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
        return mItemType;
    }

    public String getMediaType()
    {
        return mMediaType;
    }

    public String getParentChannelID()
    {
        return mParentChannelID;
    }

    public String getParentChannelName()
    {
        return mParentChannelName;
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
        return mRootChannel;
    }

    public String getRootChannelID()
    {
        return mRootChannelID;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public int getUserRating()
    {
        return mUserRating;
    }

    public String getXitemID()
    {
        return mXitemID;
    }

    public void setID(String s)
    {
        mID = s;
    }

    public void setImageUrl(String s)
    {
        mImageUrl = s;
    }
}
