// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.gotv.crackle.Application;
import com.gotv.crackle.data.SubtitlesParser;
import com.gotv.crackle.util.DateTimeFormatter;
import com.gotv.crackle.util.Log;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.model:
//            RelatedItem, MediaChapter, MediaUrlItem

public class MediaDetailsItem
    implements Parcelable
{

    private static final String AMAZON_LINK = "AmazonLink";
    private static final String CAST = "Cast";
    private static final String CHAPTERS = "Chapters";
    private static final String CLOSED_CAPTION_DEFAULT = "Default";
    private static final String CLOSED_CAPTION_FILES = "ClosedCaptionFiles";
    private static final String CLOSED_CAPTION_LOCALE = "Locale";
    private static final String CLOSED_CAPTION_PATH = "Path";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public MediaDetailsItem createFromParcel(Parcel parcel)
        {
            return new MediaDetailsItem(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public MediaDetailsItem[] newArray(int i)
        {
            return new MediaDetailsItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final String DESCRIPTION = "Description";
    private static final String DIMENSIONS = "Dimensions";
    private static final String DIRECTORS = "Directors";
    private static final String DURATION = "Duration";
    private static final String DURATION_IN_SECONDS = "DurationInSeconds";
    private static final String EPISODE = "Episode";
    private static final String GENRE = "Genre";
    private static final String ID = "ID";
    private static final String IS_DUBBED = "IsDubbed";
    private static final String LOCALIZED_LANGUAGE = "LocalizedLanguage";
    private static final String MEDIA_TYPE = "MediaType";
    private static final String MEDIA_URLS = "MediaURLs";
    private static final String MPMNUMBER = "MPMNumber";
    private static final String NAME = "Name";
    private static final String OMNITURE_TRACKING_VARS = "OmnitureTrackingVars";
    private static final String PARENT_CHANNEL_DETAILS_SUMMARY = "ParentChannelDetailsSummary";
    private static final String PERMALINK = "PermaLink";
    private static final String PORTUGUESE_CODE = "pt-BR";
    private static final String PRODUCERS = "Producers";
    private static final String RATING = "Rating";
    private static final String RELEASE_DATE = "ReleaseDate";
    private static final String RELEASE_YEAR = "ReleaseYear";
    private static final String RIGHTS_EXPIRATION_DATE = "RightsExpirationDate";
    private static final String ROOT_CHANNEL = "RootChannel";
    private static final String ROOT_CHANNEL_ID = "RootChannelID";
    private static final String SCRUBBING_FORGIVENESS = "ScrubbingForgiveness";
    private static final String SEASON = "Season";
    private static final String SHOW_NAME = "ShowName";
    private static final String SPANISH_CODE = "es-MX";
    private static final String SPLASH_VIDEO_URL = "SplashVideoUrl";
    private static final String STUDIO = "Studio";
    private static final String THUMBNAIL_240x180 = "Thumbnail_240x180";
    private static final String THUMBNAIL_854x480 = "Thumbnail_854x480";
    private static final String THUMBNAIL_ONE_SHEET_185x277 = "Thumbnail_OneSheet185x277";
    private static final String TITLE = "Title";
    private static final String USER_RATING = "UserRating";
    private static final String WHY_IT_CRACKLES = "WhyItCrackles";
    private static final String WRITERS = "Writers";
    private static final String XITEMID = "XItemId";
    private String mAmazonLink;
    private String mCast;
    private MediaChapter mChapters[];
    private Map mClosedCaptionFileUrls;
    private Map mClosedCaptionFiles;
    private Map mClosedCaptionLangauges;
    private Map mClosedCaptionLocales;
    private String mDefaultLang;
    private String mDescription;
    private String mDimensions;
    private String mDirectors;
    private String mDuration;
    private String mDurationInSeconds;
    private String mEpisode;
    private String mGenre;
    private String mID;
    private boolean mIsDubbed;
    private String mLocalizedLanguage;
    private String mMPMNumber;
    private String mMediaType;
    private Map mMediaUrls;
    private Map mOmnitureTrackingVars;
    private String mParentChannelID;
    private String mParentChannelName;
    private String mPermaLink;
    private String mProducers;
    private String mRating;
    private Date mReleaseDate;
    private String mReleaseYear;
    private Date mRightsExpirationDate;
    private String mRootChannel;
    private String mRootChannelID;
    private Integer mScrubbingForgiveness;
    private String mSeason;
    private String mShowName;
    private String mSplashVideoUrl;
    private String mStudio;
    private String mThumbnail240x180;
    private String mThumbnailOneSheet185x277;
    private String mThumbnail_854x480;
    private String mTitle;
    private Integer mUserRating;
    private String mWhyItCrackles;
    private String mWriters;
    private String mXItemId;
    private Integer m_expiresInDays;
    private boolean m_expiresInLessThan5days;
    private RelatedItem relatedItems[];

    public MediaDetailsItem(Parcel parcel)
    {
        mClosedCaptionFiles = new TreeMap();
        mClosedCaptionFileUrls = new TreeMap();
        mClosedCaptionLocales = new TreeMap();
        mClosedCaptionLangauges = new TreeMap();
        mMediaUrls = new HashMap();
        mOmnitureTrackingVars = new HashMap();
    }

    public MediaDetailsItem(JSONObject jsonobject)
        throws JSONException
    {
        int j;
        mClosedCaptionFiles = new TreeMap();
        mClosedCaptionFileUrls = new TreeMap();
        mClosedCaptionLocales = new TreeMap();
        mClosedCaptionLangauges = new TreeMap();
        mMediaUrls = new HashMap();
        mOmnitureTrackingVars = new HashMap();
        mID = jsonobject.optString("ID");
        mTitle = jsonobject.optString("Title");
        mShowName = jsonobject.optString("ShowName");
        mRootChannelID = jsonobject.optString("RootChannelID");
        mRootChannel = jsonobject.optString("RootChannel");
        mReleaseYear = jsonobject.optString("ReleaseYear");
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        JSONException jsonexception;
        String s;
        String s1;
        java.util.List list;
        try
        {
            mReleaseDate = DateTimeFormatter.parseJSONDateString(jsonobject.optString("ReleaseDate"), "M/d/yyyy");
        }
        catch (ParseException parseexception1) { }
        mDescription = jsonobject.optString("Description");
        mAmazonLink = jsonobject.optString("AmazonLink");
        mEpisode = jsonobject.optString("Episode");
        mSeason = jsonobject.optString("Season");
        mMediaType = jsonobject.optString("MediaType");
        mScrubbingForgiveness = Integer.valueOf(jsonobject.getInt("ScrubbingForgiveness"));
        mCast = jsonobject.optString("Cast");
        mDirectors = jsonobject.optString("Directors");
        mWriters = jsonobject.optString("Writers");
        mProducers = jsonobject.optString("Producers");
        mStudio = jsonobject.optString("Studio");
        mGenre = jsonobject.optString("Genre");
        mPermaLink = jsonobject.optString("PermaLink");
        mDuration = jsonobject.optString("Duration");
        mDurationInSeconds = jsonobject.optString("DurationInSeconds");
        mDimensions = jsonobject.optString("Dimensions");
        mThumbnailOneSheet185x277 = jsonobject.optString("Thumbnail_OneSheet185x277");
        mThumbnail_854x480 = jsonobject.optString("Thumbnail_854x480");
        mThumbnail240x180 = jsonobject.optString("Thumbnail_240x180");
        mUserRating = Integer.valueOf(jsonobject.getInt("UserRating"));
        mRating = jsonobject.optString("Rating");
        mWhyItCrackles = jsonobject.optString("WhyItCrackles");
        mXItemId = jsonobject.optString("XItemId");
        mMPMNumber = jsonobject.optString("MPMNumber");
        mIsDubbed = jsonobject.getBoolean("IsDubbed");
        mLocalizedLanguage = jsonobject.optString("LocalizedLanguage");
        obj = jsonobject.optJSONArray("RelatedItemsByMPM");
        if (obj != null)
        {
            relatedItems = new RelatedItem[((JSONArray) (obj)).length()];
            for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
            {
                relatedItems[i] = new RelatedItem(((JSONArray) (obj)).getJSONObject(i));
            }

        }
        try
        {
            mRightsExpirationDate = DateTimeFormatter.parseJSONDateString(jsonobject.optString("RightsExpirationDate"), "M/d/yyyy");
            if (mRightsExpirationDate != null)
            {
                obj = new Date();
                ((Date) (obj)).setTime(((Date) (obj)).getTime() + 0x19bfcc00L);
                if (mRightsExpirationDate.before(((Date) (obj))))
                {
                    setExpiresInLessThan5days(true);
                }
                setExpiresInDays(Integer.valueOf((int)Math.round((double)(mRightsExpirationDate.getTime() - (new Date()).getTime()) / 86400000D) + 1));
            }
        }
        catch (ParseException parseexception) { }
        obj2 = new SubtitlesParser();
        obj3 = jsonobject.getJSONArray("ClosedCaptionFiles");
        j = 0;
_L11:
        if (j >= ((JSONArray) (obj3)).length())
        {
            break MISSING_BLOCK_LABEL_777;
        }
        s = ((JSONObject)((JSONArray) (obj3)).get(j)).optString("Locale");
        if (!s.equalsIgnoreCase("es-MX")) goto _L2; else goto _L1
_L1:
        obj = Application.getInstance().getString(0x7f0b00d2);
_L3:
        s1 = ((JSONObject)((JSONArray) (obj3)).get(j)).optString("Path");
        list = ((SubtitlesParser) (obj2)).parseDFXP(s1);
        mClosedCaptionFiles.put(obj, list);
        mClosedCaptionFileUrls.put(obj, s1);
        mClosedCaptionLocales.put(obj, s);
        mClosedCaptionLangauges.put(s, obj);
        if (((JSONObject)((JSONArray) (obj3)).get(j)).getBoolean("Default"))
        {
            mDefaultLang = ((String) (obj));
        }
        break MISSING_BLOCK_LABEL_1139;
_L2:
label0:
        {
            if (!s.equalsIgnoreCase("pt-BR"))
            {
                break label0;
            }
            obj = Application.getInstance().getString(0x7f0b00d3);
        }
          goto _L3
        obj = Application.getInstance().getString(0x7f0b00d1);
          goto _L3
        obj1;
        try
        {
            obj1 = jsonobject.getJSONArray("Chapters");
            mChapters = new MediaChapter[((JSONArray) (obj1)).length()];
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        j = 0;
_L5:
        if (j >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = new MediaChapter(((JSONArray) (obj1)).getJSONObject(j));
        mChapters[j] = ((MediaChapter) (obj2));
        j++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L5; else goto _L4
_L4:
        obj1 = jsonobject.getJSONArray("MediaURLs");
        Log.d("MEDIA URL", (new StringBuilder()).append("MEDIA URL = ").append(((JSONArray) (obj1)).toString()).toString());
        j = 0;
_L6:
        if (j >= ((JSONArray) (obj1)).length())
        {
            break MISSING_BLOCK_LABEL_1013;
        }
        obj2 = new MediaUrlItem();
        obj2.path = ((JSONArray) (obj1)).getJSONObject(j).optString("Path").trim().replace(" ", "");
        obj2.useDrm = ((JSONArray) (obj1)).getJSONObject(j).getBoolean("UseDRM");
_L7:
        try
        {
            obj2.drmPath = ((JSONArray) (obj1)).getJSONObject(j).optString("DRMPath").trim().replace(" ", "");
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception) { }
        obj3 = ((JSONArray) (obj1)).getJSONObject(j).optString("Type");
        mMediaUrls.put(obj3, obj2);
        j++;
          goto _L6
        jsonexception;
        obj2.useDrm = false;
          goto _L7
        obj1;
        try
        {
            obj1 = jsonobject.getJSONArray("OmnitureTrackingVars");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        j = 0;
_L9:
        if (j >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        mOmnitureTrackingVars.put(((JSONArray) (obj1)).getJSONObject(j).optString("Key"), ((JSONArray) (obj1)).getJSONObject(j).optString("Value"));
        j++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L9; else goto _L8
_L8:
        try
        {
            mParentChannelID = jsonobject.getJSONObject("ParentChannelDetailsSummary").optString("ID");
            mParentChannelName = jsonobject.getJSONObject("ParentChannelDetailsSummary").optString("Name");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        mSplashVideoUrl = jsonobject.getJSONObject("ParentChannelDetailsSummary").optString("SplashVideoUrl");
        return;
        j++;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private void setExpiresInDays(Integer integer)
    {
        m_expiresInDays = integer;
    }

    private void setExpiresInLessThan5days(boolean flag)
    {
        m_expiresInLessThan5days = flag;
    }

    public boolean IsDubbed()
    {
        return mIsDubbed;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAmazonLink()
    {
        return mAmazonLink;
    }

    public String getCaptionLanguageFromLocale(String s)
    {
        return (String)mClosedCaptionLangauges.get(s);
    }

    public String getCaptionLocaleFromLanguage(String s)
    {
        return (String)mClosedCaptionLocales.get(s);
    }

    public String getCast()
    {
        return mCast;
    }

    public MediaChapter[] getChapters()
    {
        return mChapters;
    }

    public Map getClosedCaptionFileUrls()
    {
        return mClosedCaptionFileUrls;
    }

    public Map getClosedCaptionFiles()
    {
        return mClosedCaptionFiles;
    }

    public String getDefaultLang()
    {
        return mDefaultLang;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public String getDimensions()
    {
        return mDimensions;
    }

    public String getDirectors()
    {
        return mDirectors;
    }

    public String getDuration()
    {
        return mDuration;
    }

    public String getDurationInSeconds()
    {
        return mDurationInSeconds;
    }

    public String getEpisode()
    {
        return mEpisode;
    }

    public String getEpisodeFancy()
    {
        if (!TextUtils.isEmpty(getSeason()) && !TextUtils.isEmpty(getEpisode()))
        {
            return String.format("S%s E%s: %s", new Object[] {
                getSeason(), getEpisode(), getTitle()
            });
        } else
        {
            return "";
        }
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

    public String getLocalizedLanguage()
    {
        return mLocalizedLanguage;
    }

    public String getMPMNumber()
    {
        return mMPMNumber;
    }

    public String getMediaType()
    {
        return mMediaType;
    }

    public Map getMediaUrls()
    {
        return mMediaUrls;
    }

    public Map getOmnitureTrackingVars()
    {
        return mOmnitureTrackingVars;
    }

    public String getParentChannelID()
    {
        return mParentChannelID;
    }

    public String getParentChannelName()
    {
        return mParentChannelName;
    }

    public String getPermaLink()
    {
        return mPermaLink;
    }

    public String getProducers()
    {
        return mProducers;
    }

    public String getRating()
    {
        return mRating;
    }

    public RelatedItem[] getRelatedItems()
    {
        return relatedItems;
    }

    public Date getReleaseDate()
    {
        return mReleaseDate;
    }

    public String getReleaseYear()
    {
        return mReleaseYear;
    }

    public Date getRightsExpirationDate()
    {
        return mRightsExpirationDate;
    }

    public String getRootChannel()
    {
        return mRootChannel;
    }

    public String getRootChannelID()
    {
        return mRootChannelID;
    }

    public Integer getScrubbingForgiveness()
    {
        return mScrubbingForgiveness;
    }

    public String getSeason()
    {
        return mSeason;
    }

    public String getShowName()
    {
        return mShowName;
    }

    public String getSplashVideoUrl()
    {
        return mSplashVideoUrl;
    }

    public String getStudio()
    {
        return mStudio;
    }

    public String getThumbnail240x180()
    {
        return mThumbnail240x180;
    }

    public String getThumbnailOneSheet185x277()
    {
        return mThumbnailOneSheet185x277;
    }

    public String getThumbnail_854x480()
    {
        return mThumbnail_854x480;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public Integer getUserRating()
    {
        return mUserRating;
    }

    public String getWhyItCrackles()
    {
        return mWhyItCrackles;
    }

    public String getWriters()
    {
        return mWriters;
    }

    public String getXItemId()
    {
        return mXItemId;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }

}
