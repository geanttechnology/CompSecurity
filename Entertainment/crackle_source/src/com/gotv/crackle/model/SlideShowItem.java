// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.model;

import org.json.JSONException;
import org.json.JSONObject;

public class SlideShowItem
{

    private static final String ADDITIONALINFO = "additionalInfo";
    private static final String APPDATAID = "appDataID";
    private static final String APPNEXTSCREENTYPE = "appNextScreenType";
    public static final String CHANNEL_HOME_SCREEN_TYPE = "ChannelHome";
    private static final String LABEL = "label";
    private static final String LINK = "link";
    private static final String LINKTEXT = "linkText";
    private static final String ONESHEETIMAGE_185_277 = "OneSheetImage_185_277";
    private static final String PARENTCHANNELID = "ParentChannelID";
    private static final String PARENTCHANNELNAME = "ParentChannelName";
    private static final String RATING = "Rating";
    private static final String ROOTCHANNEL = "RootChannel";
    private static final String ROOTCHANNEL_ID = "RootChannelID";
    private static final String SLIDEDESCRIPTION = "slideDescription";
    private static final String SLIDEID = "slideID";
    private static final String SLIDEIMAGE = "slideImage";
    private static final String SLIDEIMAGE_1024x350 = "SlideImage_1024x350";
    private static final String SLIDEIMAGE_640X350 = "SlideImage_640x350";
    public static final String SLIDE_SHOW_ITEM = "slideList";
    private static final String SPONSOREDBYIMAGE = "SponsoredByImage";
    private static final String SPONSORED_BY_IMAGE_240x100 = "SponsoredByImage_240x100";
    private static final String SPONSORED_BY_URL = "SponsoredByUrl";
    private static final String TITLE = "title";
    public static final String VIDEO_DETAIL_SCREEN_TYPE = "VideoDetail";
    private String mAdditionalInfo;
    private String mAppDataID;
    private String mAppNextScreenType;
    private String mLabel;
    private String mLink;
    private String mLinkText;
    private String mOneSheetImage_185_277;
    private String mParentChannelID;
    private String mParentChannelName;
    private String mRating;
    private String mRootChannel;
    private String mRootChannelID;
    private String mSlideDescription;
    private String mSlideID;
    private String mSlideImage;
    private String mSlideImage_1024x350;
    private String mSlideImage_640x350;
    private String mSponsoredByImage;
    private String mSponsoredByImage240x100;
    private String mSponsoredByUrl;
    private String mTitle;

    public SlideShowItem(JSONObject jsonobject)
        throws JSONException
    {
        mOneSheetImage_185_277 = jsonobject.getString("OneSheetImage_185_277");
        mParentChannelID = jsonobject.getString("ParentChannelID");
        mParentChannelName = jsonobject.getString("ParentChannelName");
        mRating = jsonobject.getString("Rating");
        mRootChannel = jsonobject.getString("RootChannel");
        mRootChannelID = jsonobject.getString("RootChannelID");
        mSlideImage_640x350 = jsonobject.getString("SlideImage_640x350");
        mSponsoredByImage = jsonobject.getString("SponsoredByImage");
        mAdditionalInfo = jsonobject.getString("additionalInfo");
        mAppDataID = jsonobject.getString("appDataID");
        mAppNextScreenType = jsonobject.getString("appNextScreenType");
        mLabel = jsonobject.getString("label");
        mLink = jsonobject.getString("link");
        mLinkText = jsonobject.getString("linkText");
        mSlideDescription = jsonobject.getString("slideDescription");
        mSlideID = jsonobject.getString("slideID");
        mSlideImage = jsonobject.getString("slideImage");
        mSlideImage_1024x350 = jsonobject.getString("SlideImage_1024x350");
        mTitle = jsonobject.getString("title");
        mSponsoredByImage240x100 = jsonobject.getString("SponsoredByImage_240x100");
        mSponsoredByUrl = jsonobject.getString("SponsoredByUrl");
    }

    public String getAdditionalInfo()
    {
        return mAdditionalInfo;
    }

    public String getAppDataID()
    {
        return mAppDataID;
    }

    public String getAppNextScreenType()
    {
        return mAppNextScreenType;
    }

    public String getLabel()
    {
        return mLabel;
    }

    public String getLink()
    {
        return mLink;
    }

    public String getLinkText()
    {
        return mLinkText;
    }

    public String getOneSheetImage_185_277()
    {
        return mOneSheetImage_185_277;
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

    public String getRootChannel()
    {
        return mRootChannel;
    }

    public String getRootChannelID()
    {
        return mRootChannelID;
    }

    public String getSlideDescription()
    {
        return mSlideDescription;
    }

    public String getSlideID()
    {
        return mSlideID;
    }

    public String getSlideImage()
    {
        return mSlideImage;
    }

    public String getSlideImage_1024x350()
    {
        return mSlideImage_1024x350;
    }

    public String getSlideImage_640x350()
    {
        return mSlideImage_640x350;
    }

    public String getSponsoredByImage()
    {
        return mSponsoredByImage;
    }

    public String getSponsoredByImage240x100()
    {
        return mSponsoredByImage240x100;
    }

    public String getSponsoredByUrl()
    {
        return mSponsoredByUrl;
    }

    public String getTitle()
    {
        return mTitle;
    }
}
