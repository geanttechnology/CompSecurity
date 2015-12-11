// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.model;

import com.gotv.crackle.util.DateTimeFormatter;
import com.gotv.crackle.util.StringUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.model:
//            MediaListItem

public class PlayListItem
{

    private static final String DATE_CREATED = "DateCreated";
    private static final String DATE_LAST_MODIFIED = "DateLastModified";
    private static final String DISPLAY_CHANNEL_IMAGE = "DisplayChannelImage";
    private static final String HIDDEN_PLAY_LIST = "HiddenPlaylist";
    private static final String ID = "ID";
    private static final String LOCKED_TO_CHANNEL = "LockedToChannel";
    private static final String MEDIA_LIST = "MediaList";
    private static final String MOVIE_PLAY_LIST = "MoviePlaylist";
    private static final String NAME = "Name";
    private static final String XITEMID = "XItemId";
    private Date mDateCreated;
    private Date mDateLastModified;
    private Boolean mDisplayChannelImage;
    private Boolean mHiddenPlaylist;
    private String mID;
    private Boolean mLockedToChannel;
    private List mMediaList;
    private Boolean mMoviePlaylist;
    private String mName;
    private String mXItemId;

    public PlayListItem(JSONObject jsonobject)
        throws JSONException
    {
        mID = jsonobject.getString("ID");
        mName = StringUtil.removeHtmlFromString(jsonobject.getString("Name"));
        mDisplayChannelImage = Boolean.valueOf(jsonobject.getBoolean("DisplayChannelImage"));
        mHiddenPlaylist = Boolean.valueOf(jsonobject.getBoolean("HiddenPlaylist"));
        mMoviePlaylist = Boolean.valueOf(jsonobject.getBoolean("MoviePlaylist"));
        mLockedToChannel = Boolean.valueOf(jsonobject.getBoolean("LockedToChannel"));
        String s = jsonobject.getString("DateCreated");
        try
        {
            mDateCreated = DateTimeFormatter.parseJSONDateString(s, "M/d/yyyy h:mm:ss a");
        }
        catch (ParseException parseexception1) { }
        s = jsonobject.getString("DateLastModified");
        try
        {
            mDateLastModified = DateTimeFormatter.parseJSONDateString(s, "M/d/yyyy h:mm:ss a");
        }
        catch (ParseException parseexception) { }
        mXItemId = jsonobject.getString("XItemId");
        mMediaList = new ArrayList();
        jsonobject = jsonobject.getJSONArray("MediaList");
        for (int i = 0; i < jsonobject.length(); i++)
        {
            MediaListItem medialistitem = new MediaListItem(jsonobject.getJSONObject(i));
            if (medialistitem != null)
            {
                mMediaList.add(medialistitem);
            }
        }

    }

    public Date getDateCreated()
    {
        return mDateCreated;
    }

    public Date getDateLastModified()
    {
        return mDateLastModified;
    }

    public Boolean getDisplayChannelImage()
    {
        return mDisplayChannelImage;
    }

    public String getID()
    {
        return mID;
    }

    public List getMediaList()
    {
        return mMediaList;
    }

    public String getName()
    {
        return mName;
    }

    public String getXItemId()
    {
        return mXItemId;
    }

    public Boolean isHiddenPlaylist()
    {
        return mHiddenPlaylist;
    }

    public Boolean isLockedToChannel()
    {
        return mLockedToChannel;
    }

    public Boolean isMoviePlaylist()
    {
        return mMoviePlaylist;
    }
}
