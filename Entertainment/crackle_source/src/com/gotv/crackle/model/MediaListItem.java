// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.model;

import com.gotv.crackle.util.DateTimeFormatter;
import com.gotv.crackle.util.Log;
import java.text.ParseException;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaListItem
{

    private static final String DESCRIPTION = "Description";
    private static final String DURATION = "Duration";
    private static final String EPISODE = "Episode";
    private static final String GENRE = "Genre";
    private static final String ID = "ID";
    private static final String IS_DUBBED = "IsDubbed";
    private static final String MEDIA_TYPE = "MediaType";
    private static final String MPMNUMBER = "MPMNumber";
    private static final String ONE_SHEET_IMAGE_185x277 = "OneSheetImage185x277";
    private static final String PARENT_CHANNEL_ID = "ParentChannelID";
    private static final String PARENT_CHANNEL_NAME = "ParentChannelName";
    private static final String RATING = "Rating";
    private static final String RELEASE_DATE = "ReleaseDate";
    private static final String SEASON = "Season";
    private static final String TITLE = "Title";
    private static final String USER_RATING = "UserRating";
    private static final String XITEMID = "XItemId";
    private String mDescription;
    private String mDuration;
    private Integer mDurationInSeconds;
    private String mEpisode;
    private String mGenres[];
    private String mID;
    private Boolean mIsDubbed;
    private String mMPMNumber;
    private String mMediaType;
    private String mOneSheetImage185x277;
    private String mParentChannelID;
    private String mParentChannelName;
    private String mRating;
    private Date mReleaseDate;
    private String mSeason;
    private String mTitle;
    private int mUserRating;
    private String mXItemId;

    public MediaListItem(JSONObject jsonobject)
        throws JSONException
    {
        mID = jsonobject.getString("ID");
        Log.d(getClass().getSimpleName(), (new StringBuilder()).append("Media Item ID = ").append(mID).toString());
        mTitle = jsonobject.getString("Title");
        mMediaType = jsonobject.getString("MediaType");
        mDuration = jsonobject.getString("Duration");
        if (mDuration.compareTo("null") != 0)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        mDurationInSeconds = Integer.valueOf(0);
_L1:
        mOneSheetImage185x277 = jsonobject.getString("OneSheetImage185x277");
        mSeason = jsonobject.getString("Season");
        mEpisode = jsonobject.getString("Episode");
        mRating = jsonobject.getString("Rating");
        mGenres = jsonobject.getString("Genre").split(", ");
        Exception exception;
        try
        {
            mReleaseDate = DateTimeFormatter.parseJSONDateString(jsonobject.getString("ReleaseDate"), "M/d/yyyy");
        }
        catch (ParseException parseexception) { }
        mDescription = jsonobject.getString("Description");
        mUserRating = jsonobject.getInt("UserRating");
        mXItemId = jsonobject.getString("XItemId");
        mParentChannelID = jsonobject.getString("ParentChannelID");
        mParentChannelName = jsonobject.getString("ParentChannelName");
        mIsDubbed = Boolean.valueOf(jsonobject.getBoolean("IsDubbed"));
        mMPMNumber = jsonobject.getString("MPMNumber");
        return;
        try
        {
            mDurationInSeconds = Integer.valueOf(Integer.parseInt(DateTimeFormatter.getHourMinuteString(mDuration)));
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            mDurationInSeconds = Integer.valueOf(0);
        }
          goto _L1
    }

    public Boolean IsDubbed()
    {
        return mIsDubbed;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public String getDuration()
    {
        return mDuration;
    }

    public Integer getDurationInSeconds()
    {
        return mDurationInSeconds;
    }

    public String getEpisode()
    {
        return mEpisode;
    }

    public String[] getGenres()
    {
        return mGenres;
    }

    public String getID()
    {
        return mID;
    }

    public String getMPMNumber()
    {
        return mMPMNumber;
    }

    public String getMediaType()
    {
        return mMediaType;
    }

    public String getOneSheetImage185x277()
    {
        return mOneSheetImage185x277;
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

    public Date getReleaseDate()
    {
        return mReleaseDate;
    }

    public String getSeason()
    {
        return mSeason;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public int getUserRating()
    {
        return mUserRating;
    }

    public String getXItemId()
    {
        return mXItemId;
    }
}
