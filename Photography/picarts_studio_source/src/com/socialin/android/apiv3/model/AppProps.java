// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import com.socialin.android.d;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.socialin.android.apiv3.model:
//            Response

public class AppProps extends Response
{

    public static final String PROCESS_MULTY = "multy";
    public static final String PROCESS_SINGLE = "single";
    public static final AppProps emptyAppProps = new AppProps();
    public static final Data emptyData = new Data();
    private ArrayList response;

    public AppProps()
    {
    }

    public ContestTab createTab(boolean flag, boolean flag1, boolean flag2, String s, String s1)
    {
        return new ContestTab(flag, flag1, flag2, s, s1);
    }

    public AutoRedeemProps getAutoRedeemProps()
    {
        if (getData() == null)
        {
            return null;
        } else
        {
            return getData().autoRedeemProps;
        }
    }

    public int getContentRefreshTime()
    {
        if (getData().social == null)
        {
            return 15;
        } else
        {
            return getData().social.contentRefreshTime;
        }
    }

    public ArrayList getContestNewSystemTabs()
    {
        return getData().getContestNewSystemTabs();
    }

    public ArrayList getContestTabs()
    {
        return getData().getContestTabs();
    }

    public Data getData()
    {
        if (response == null || response.isEmpty() || response.get(0) == null || ((AppPropsResponse)response.get(0)).data == null)
        {
            return emptyData;
        } else
        {
            return ((AppPropsResponse)response.get(0)).data;
        }
    }

    public String getDownlaodUrl()
    {
        return getData().downloadAnonymousUrl;
    }

    public String getGalleryPromoTags()
    {
        return getData().galleryPromoTags();
    }

    public List getMyNetworkTags()
    {
        return getData().myNetworkPublicTags;
    }

    public boolean getPacketZoomEnabled()
    {
        return getData().useFeaturePacketZoom;
    }

    public String getProcess()
    {
        return getData().process;
    }

    public String getResourceUrl()
    {
        if (d.b)
        {
            return "http://static153.picsart.com/";
        } else
        {
            return getData().resourceUrl;
        }
    }

    public String getServerUrl()
    {
        return getData().serverUrl;
    }

    public ArrayList getShopTabs()
    {
        return getData().getShopTabs();
    }

    public String getUploadAnonymousUrl()
    {
        return getData().uploadAnonymousUrl;
    }

    public String getUploadBaseUrl()
    {
        if (getData().uploadUserCDN)
        {
            return getData().uploadCDNUrl;
        } else
        {
            return getData().uploadAnonymousUrl;
        }
    }

    public boolean isAdjustEnabled()
    {
        return getData().useFeatureAdjust;
    }

    public boolean isAdsEnabled()
    {
        return getData().useFeatureEditorAds;
    }

    public boolean isAppboyEnabled()
    {
        return getData().useFeatureAppboy;
    }

    public boolean isApptimizeEnabled()
    {
        return getData().useFeatureApptimize.booleanValue();
    }

    public boolean isAutoRedeemEnabled()
    {
        return getData() != null && getData().useFeatureAutoRedeem;
    }

    public boolean isContactSyncEnabled()
    {
        return getData().contactSyncEnabled;
    }

    public boolean isContactSyncOnInviteEnabled()
    {
        return getData().contactSyncOnInvite;
    }

    public boolean isEditorGifExportEnabled()
    {
        return getData().useFeatureEditorGifExport;
    }

    public boolean isExifEnabled()
    {
        return getData().useFeatureExif;
    }

    public boolean isFeatureBandwidthUploadEnabled()
    {
        return getData().useFeatureBandwidthUpload;
    }

    public boolean isInviteFriendsEnabled()
    {
        return getData().inviteFriendsEnabled;
    }

    public boolean isMatureContentEnabled()
    {
        return getData().useFeatureMatureContent;
    }

    public boolean isNativeAdEnabled()
    {
        return getData().nativeAdEnabled;
    }

    public boolean isPacketZoomEnabled()
    {
        return getData().useFeaturePacketZoom;
    }

    public boolean isQQEnabled()
    {
        return getData().isQQEnabled;
    }

    public boolean isShowDesigns()
    {
        return getData().showDesigns;
    }

    public boolean isShowFbInvitesEnabled()
    {
        return getData().showFbInvites;
    }

    public boolean isSquareFitOnInstagramEnabled()
    {
        return getData().useSquareFitOnInstagramShare;
    }

    public boolean isSquareFitOnInstagramShareEnabled()
    {
        return getData().useSquareFitOnInstagramShare;
    }

    public boolean isTumblrEnabled()
    {
        return getData().useFeatureTumblr;
    }

    public boolean isWeChatEnabled()
    {
        return getData().isWeChatEnabled;
    }

    public boolean isWeiboEnabled()
    {
        return getData().isWeiboEnabled;
    }

    public boolean isuploadOptimizationeEnabled()
    {
        return getData().uploadOptimization;
    }


    private class ContestTab
    {

        public boolean hideAfterSubmit;
        public boolean hideBeforeVoting;
        public boolean isVoting;
        public String order;
        final AppProps this$0;
        public String title;

        public ContestTab(boolean flag, boolean flag1, boolean flag2, String s, String s1)
        {
            this$0 = AppProps.this;
            super();
            hideAfterSubmit = false;
            hideBeforeVoting = false;
            isVoting = flag;
            hideAfterSubmit = flag1;
            hideBeforeVoting = flag2;
            title = s;
            order = s1;
        }
    }


    private class Data
    {

        public String adInterstitialDraw;
        public String adInterstitialExport;
        public String adInterstitialProvider;
        public String adProvider;
        public ArrayList adProviderAndroidVersionItems;
        public ArrayList adProviderAppVersionItems;
        public ArrayList adProviderLocItems;
        public String adProviderNew;
        public int adProviderVersion;
        public NestedAds adapterAds;
        public Api api;
        public AutoRedeemProps autoRedeemProps;
        public Billing billing;
        public boolean contactSyncEnabled;
        public boolean contactSyncOnInvite;
        public ContestProps contestProps;
        public ContestProps contestsEditorProps;
        public boolean dealocMemory;
        public String downloadAnonymousUrl;
        private String galleryPromoTags;
        public String gooPackage;
        public InviteData inviteData;
        public boolean inviteFriendsEnabled;
        public boolean isQQEnabled;
        public boolean isWeChatEnabled;
        public boolean isWeiboEnabled;
        public String kaleidoscopePackage;
        public String keyWords;
        public int lastHighVersion;
        public int lastLowVersion;
        public Log log;
        public String marketQuery;
        public JsonArray moreApps;
        public boolean moreShow;
        public boolean moreShowGoo;
        public boolean moreShowKaleidoscope;
        public List myNetworkPublicTags;
        public boolean nativeAdEnabled;
        public String process;
        public boolean registerDevice;
        public String resourceUrl;
        public String serverUrl;
        public ShopProps shopProps;
        public boolean showDesigns;
        public boolean showFbInvites;
        public int siRversion;
        public ArrayList skipRenderscriptDevices;
        public Social social;
        public String theme;
        public String uploadAnonymousUrl;
        public String uploadCDNUrl;
        public String uploadFileSystemUrl;
        public boolean uploadOptimization;
        public boolean uploadUserCDN;
        public boolean useFeatureAdjust;
        public boolean useFeatureAppboy;
        public Boolean useFeatureApptimize;
        public boolean useFeatureAutoRedeem;
        public boolean useFeatureBandwidthUpload;
        public boolean useFeatureEditorAds;
        public boolean useFeatureEditorGifExport;
        public boolean useFeatureEmailHTML;
        public boolean useFeatureExif;
        public boolean useFeatureMatureContent;
        public boolean useFeaturePacketZoom;
        public boolean useFeatureTumblr;
        public boolean useSquareFitOnInstagramShare;
        public int versionCode;

        public final String galleryPromoTags()
        {
            if (galleryPromoTags == null)
            {
                return "";
            } else
            {
                return galleryPromoTags;
            }
        }

        public final int getAppLastVersion()
        {
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 8 && i < 14)
            {
                return lastLowVersion;
            } else
            {
                return lastHighVersion;
            }
        }

        public final ArrayList getContestNewSystemTabs()
        {
            if (contestsEditorProps == null)
            {
                return null;
            } else
            {
                return contestsEditorProps.tabs;
            }
        }

        public final ArrayList getContestTabs()
        {
            if (contestProps == null)
            {
                return null;
            } else
            {
                return contestProps.tabs;
            }
        }

        public final ArrayList getShopTabs()
        {
            if (shopProps == null)
            {
                return null;
            } else
            {
                return shopProps.tabs;
            }
        }

        public final int getSubmissionLimit()
        {
            if (contestProps == null)
            {
                return 2;
            } else
            {
                return contestProps.submission_limit;
            }
        }

        public final boolean showVoteOnSubmit()
        {
            return contestProps == null || contestProps.voteOnSubmit;
        }

        public Data()
        {
            serverUrl = "stage.picsart.com";
            uploadUserCDN = true;
            adInterstitialExport = "NONE";
            adInterstitialDraw = "NONE";
            skipRenderscriptDevices = new ArrayList();
            process = "single";
            useFeatureExif = false;
            inviteFriendsEnabled = true;
            useSquareFitOnInstagramShare = false;
            isWeiboEnabled = true;
            isWeChatEnabled = true;
            isQQEnabled = true;
            showFbInvites = false;
            useFeatureTumblr = false;
            useFeatureAdjust = false;
            useFeatureEmailHTML = true;
            useFeaturePacketZoom = false;
            useFeatureEditorGifExport = false;
            contactSyncEnabled = false;
            useFeatureBandwidthUpload = false;
            useFeatureAppboy = true;
            useFeatureEditorAds = false;
            useFeatureMatureContent = false;
            contactSyncOnInvite = false;
            registerDevice = true;
            nativeAdEnabled = false;
            useFeatureApptimize = Boolean.valueOf(true);
            useFeatureAutoRedeem = true;
            showDesigns = false;
        }

        private class ContestProps
        {

            int submission_limit;
            public ArrayList tabs;
            boolean voteOnSubmit;

            public ContestProps()
            {
                voteOnSubmit = true;
                submission_limit = 2;
            }
        }


        private class ShopProps
        {

            public ArrayList tabs;

            public ShopProps()
            {
            }
        }

    }


    private class Social
    {

        public int contactChangeDiff;
        public int contactRefreshIntervalDays;
        public int contentRefreshTime;

        public final long getIntervalInMillis()
        {
            return (long)(contactRefreshIntervalDays * 24 * 60 * 60 * 1000);
        }

        public Social()
        {
        }
    }


    private class AppPropsResponse
    {

        private Date created;
        public Data data;
        private String type;

        public AppPropsResponse()
        {
        }
    }

}
