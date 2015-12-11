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

public class ChannelItem
{

    private static final String CHANNELART_185_277 = "ChannelArt_185_277";
    private static final String COUNT = "Count";
    private static final String DESCRIPTION = "Description";
    private static final String DIRECTOR = "Director";
    private static final String GENRE = "Genre";
    private static final String ID = "ID";
    private static final String NAME = "Name";
    private static final String RATING = "Rating";
    private static final String RELEASEYEAR = "ReleaseYear";
    private static final String RIGHTSEXPIRATIONDATE = "RightsExpirationDate";
    private static final String ROOTCHANNEL_ID = "RootChannelID";
    private static final String ROOT_CHANNEL = "RootChannel";
    private static final String SPLASHVIDEOURL = "SplashVideoUrl";
    private static final String STARRING = "Starring";
    private static final String TAGS = "Tags";
    private static final String THUMBNAILURL = "ThumbnailURL";
    private static final String THUMBNAIL_LARGE = "ChannelArt_315_236";
    private static final String WHYITCRACKLES = "WhyItCrackles";
    private static final String XITEMID = "XItemId";
    private String m_channelArt_185_277;
    private Number m_count;
    private String m_description;
    private String m_director;
    private Integer m_expiresInDays;
    private boolean m_expiresInLessThan5days;
    private String m_genre;
    private String m_iD;
    private String m_name;
    private String m_rating;
    private Number m_releaseYear;
    private Date m_rightsExpirationDate;
    private String m_rootChannel;
    private String m_rootChannelID;
    private String m_splashVideoUrl;
    private String m_starring;
    private String m_tags;
    private String m_thumbnailLarge;
    private String m_thumbnailURL;
    private String m_whyItCrackles;
    private String m_xItemId;

    public ChannelItem(JSONObject jsonobject)
        throws JSONException
    {
        m_channelArt_185_277 = jsonobject.getString("ChannelArt_185_277");
        m_thumbnailLarge = jsonobject.getString("ChannelArt_315_236");
        m_count = Integer.valueOf(jsonobject.getInt("Count"));
        m_description = jsonobject.getString("Description");
        m_director = jsonobject.getString("Director");
        m_genre = jsonobject.getString("Genre");
        m_iD = jsonobject.getString("ID");
        Log.d(getClass().getSimpleName(), (new StringBuilder()).append("Channel Item ID = ").append(m_iD).toString());
        m_name = jsonobject.getString("Name");
        m_rating = jsonobject.getString("Rating");
        m_releaseYear = Integer.valueOf(jsonobject.getInt("ReleaseYear"));
        try
        {
            m_rightsExpirationDate = DateTimeFormatter.parseJSONDateString(jsonobject.getString("RightsExpirationDate"), "M/d/yyyy h:mm:ss a");
            if (m_rightsExpirationDate != null)
            {
                Date date = new Date();
                date.setTime(date.getTime() + 0x19bfcc00L);
                if (m_rightsExpirationDate.before(date))
                {
                    m_expiresInLessThan5days = true;
                }
                m_expiresInDays = Integer.valueOf((int)Math.round((double)(m_rightsExpirationDate.getTime() - (new Date()).getTime()) / 86400000D) + 1);
            }
        }
        catch (ParseException parseexception) { }
        m_rootChannelID = jsonobject.getString("RootChannelID");
        m_rootChannel = jsonobject.getString("RootChannel");
        m_splashVideoUrl = jsonobject.getString("SplashVideoUrl");
        m_starring = jsonobject.getString("Starring");
        m_tags = jsonobject.getString("Tags");
        m_thumbnailURL = jsonobject.getString("ThumbnailURL");
        m_whyItCrackles = jsonobject.getString("WhyItCrackles");
        m_xItemId = jsonobject.getString("XItemId");
    }

    public String getChannelArt_185_277()
    {
        return m_channelArt_185_277;
    }

    public Number getCount()
    {
        return m_count;
    }

    public String getDescription()
    {
        return m_description;
    }

    public String getDirector()
    {
        return m_director;
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
        return m_genre;
    }

    public String getID()
    {
        return m_iD;
    }

    public String getName()
    {
        return m_name;
    }

    public String getRating()
    {
        return m_rating;
    }

    public Number getReleaseYear()
    {
        return m_releaseYear;
    }

    public Date getRightsExpirationDate()
    {
        return m_rightsExpirationDate;
    }

    public String getRootChannel()
    {
        return m_rootChannel;
    }

    public String getRrootChannelID()
    {
        return m_rootChannelID;
    }

    public String getSplashVideoUrl()
    {
        return m_splashVideoUrl;
    }

    public String getStarring()
    {
        return m_starring;
    }

    public String getTags()
    {
        return m_tags;
    }

    public String getThumbnailLarge()
    {
        return m_thumbnailLarge;
    }

    public String getThumbnailURL()
    {
        return m_thumbnailURL;
    }

    public String getWhyItCrackles()
    {
        return m_whyItCrackles;
    }

    public String getXItemId()
    {
        return m_xItemId;
    }
}
