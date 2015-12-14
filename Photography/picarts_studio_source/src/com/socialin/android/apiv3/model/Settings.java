// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import com.socialin.android.apiv3.SocialinV3;

// Referenced classes of package com.socialin.android.apiv3.model:
//            Response, AppProps

public class Settings extends Response
{

    public static final Settings emptySettings = new Settings();
    public Boolean contactSyncEnabled;
    public Boolean contactSyncOnInvite;
    public Boolean inviteFriendsEnabled;
    public Boolean isQQEnabled;
    public Boolean isWeChatEnabled;
    public Boolean isWeiboEnabled;
    public Boolean nativeAdEnabled;
    public String segments[];
    public Boolean showFbInvites;
    public Boolean uploadOptimization;
    public Boolean useFeatureAdjust;
    public Boolean useFeatureAppboy;
    public Boolean useFeatureApptimize;
    public Boolean useFeatureAutoRedeem;
    public Boolean useFeatureBandwidthUpload;
    public Boolean useFeatureEditorAds;
    public Boolean useFeatureEditorGifExport;
    public Boolean useFeatureExif;
    public Boolean useFeatureMatureContent;
    public Boolean useFeaturePacketZoom;
    public Boolean useFeatureTumblr;
    public Boolean useSquareFitOnInstagramShare;
    public int version;

    public Settings()
    {
        version = 1;
        useFeatureEditorAds = Boolean.valueOf(true);
        useFeatureMatureContent = Boolean.valueOf(false);
    }

    public String[] getSegments()
    {
        if (segments != null)
        {
            return segments;
        } else
        {
            return new String[0];
        }
    }

    public boolean isAdjustEnabled()
    {
        if (useFeatureAdjust != null)
        {
            return useFeatureAdjust.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isAdjustEnabled();
        }
    }

    public boolean isAppboyEnabled()
    {
        if (useFeatureAppboy != null)
        {
            return useFeatureAppboy.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isAppboyEnabled();
        }
    }

    public boolean isApptimizeEnabled()
    {
        if (useFeatureApptimize != null)
        {
            return useFeatureApptimize.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isApptimizeEnabled();
        }
    }

    public boolean isAutoRedeemEnabled()
    {
        if (useFeatureAutoRedeem != null)
        {
            return useFeatureAutoRedeem.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isAutoRedeemEnabled();
        }
    }

    public boolean isContactSyncEnabled()
    {
        if (contactSyncEnabled != null)
        {
            return contactSyncEnabled.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isContactSyncEnabled();
        }
    }

    public boolean isContactSyncOnInviteEnabled()
    {
        if (contactSyncOnInvite != null)
        {
            return contactSyncOnInvite.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isContactSyncOnInviteEnabled();
        }
    }

    public boolean isEditorAdsEnabled()
    {
        if (useFeatureEditorAds != null)
        {
            return useFeatureEditorAds.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isAdsEnabled();
        }
    }

    public boolean isEditorGifExportEnabled()
    {
        if (useFeatureEditorGifExport != null)
        {
            return useFeatureEditorGifExport.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isEditorGifExportEnabled();
        }
    }

    public boolean isExifEnabled()
    {
        if (useFeatureExif != null)
        {
            return useFeatureExif.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isExifEnabled();
        }
    }

    public boolean isFeatureBandwidthUploadEnabled()
    {
        if (useFeatureBandwidthUpload != null)
        {
            return useFeatureBandwidthUpload.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isFeatureBandwidthUploadEnabled();
        }
    }

    public boolean isInviteFriendsEnabled()
    {
        if (inviteFriendsEnabled != null)
        {
            return inviteFriendsEnabled.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isInviteFriendsEnabled();
        }
    }

    public boolean isMatureContentEnabled()
    {
        if (useFeatureMatureContent != null)
        {
            return useFeatureMatureContent.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isMatureContentEnabled();
        }
    }

    public boolean isNativeAdEnabled()
    {
        if (nativeAdEnabled != null)
        {
            return nativeAdEnabled.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isNativeAdEnabled();
        }
    }

    public boolean isPacketZoomEnabled()
    {
        if (useFeaturePacketZoom != null)
        {
            return useFeaturePacketZoom.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isPacketZoomEnabled();
        }
    }

    public boolean isQQEnabled()
    {
        if (isQQEnabled != null)
        {
            return isQQEnabled.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isQQEnabled();
        }
    }

    public boolean isShowFbInvitesEnabled()
    {
        if (showFbInvites != null)
        {
            return showFbInvites.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isShowFbInvitesEnabled();
        }
    }

    public boolean isSquareFitOnInstagramShareEnabled()
    {
        if (useSquareFitOnInstagramShare != null)
        {
            return useSquareFitOnInstagramShare.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isSquareFitOnInstagramShareEnabled();
        }
    }

    public boolean isTumblrEnabled()
    {
        if (useFeatureTumblr != null)
        {
            return useFeatureTumblr.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isTumblrEnabled();
        }
    }

    public boolean isWeChatEnabled()
    {
        if (isWeChatEnabled != null)
        {
            return isWeChatEnabled.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isWeChatEnabled();
        }
    }

    public boolean isWeiboEnabled()
    {
        if (isWeiboEnabled != null)
        {
            return isWeiboEnabled.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isWeiboEnabled();
        }
    }

    public boolean isuploadOptimizationeEnabled()
    {
        if (uploadOptimization != null)
        {
            return uploadOptimization.booleanValue();
        } else
        {
            return SocialinV3.getInstance().getAppProps().isuploadOptimizationeEnabled();
        }
    }

}
