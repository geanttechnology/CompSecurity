// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.models.inner_models.AddToBundleButtonFeature;
import com.poshmark.data_model.models.inner_models.AutoCompleteFeature;
import com.poshmark.data_model.models.inner_models.EditListingWithNFSFeature;
import com.poshmark.data_model.models.inner_models.FbDialogShareFeature;
import com.poshmark.data_model.models.inner_models.FeedAutoRefreshFeature;
import com.poshmark.data_model.models.inner_models.FeedLazyLoadFeature;
import com.poshmark.data_model.models.inner_models.FilterBarv2Feature;
import com.poshmark.data_model.models.inner_models.ListingDetailsV2Feature;
import com.poshmark.data_model.models.inner_models.ListingFeature;
import com.poshmark.data_model.models.inner_models.MakeAnOfferFeature;
import com.poshmark.data_model.models.inner_models.MyLikesFilterFeature;
import com.poshmark.data_model.models.inner_models.PinterestShareFeature;
import com.poshmark.data_model.models.inner_models.PriceDropFeature;
import com.poshmark.data_model.models.inner_models.ShareViaFBMessengerFeature;
import com.poshmark.data_model.models.inner_models.ShopTabLuxuryFeature;
import com.poshmark.data_model.models.inner_models.SignupFlowFeature;
import com.poshmark.data_model.models.inner_models.SimilarListings;
import com.poshmark.triggers.TriggerThresholds;
import java.util.Observable;

public class Features extends Observable
{
    class FeatureSettings
    {

        AutoCompleteFeature ac;
        EditListingWithNFSFeature ael_nfs;
        FbDialogShareFeature app_external_share;
        FilterBarv2Feature app_filter_bar_v2;
        AddToBundleButtonFeature app_listing_details_add_to_bundle;
        ListingDetailsV2Feature app_listing_details_v2;
        ShareViaFBMessengerFeature app_share_via_fb_messenger;
        ShopTabLuxuryFeature app_shop_tab_luxury;
        TriggerThresholds app_trigger_app_rating;
        TriggerThresholds app_trigger_brand_share;
        FeedAutoRefreshFeature feed_auto_refresh;
        FeedLazyLoadFeature feed_lazy_load;
        ListingFeature listing;
        MyLikesFilterFeature mlf;
        MakeAnOfferFeature offers;
        PriceDropFeature pd;
        PinterestShareFeature pinterest_share;
        SimilarListings rp;
        SignupFlowFeature sup_flow;
        final Features this$0;

        FeatureSettings()
        {
            this$0 = Features.this;
            super();
        }
    }


    FeatureSettings feature_settings;
    int schema_version;
    String updated_at;

    public Features()
    {
        feature_settings = new FeatureSettings();
    }

    public AddToBundleButtonFeature getAddToBundleButtonFeature()
    {
        return feature_settings.app_listing_details_add_to_bundle;
    }

    public TriggerThresholds getBrandShareTriggerFeature()
    {
        return feature_settings.app_trigger_brand_share;
    }

    public com.poshmark.data_model.models.inner_models.FbDialogShareFeature.TipInfo getFbShareProTipInfo(com.poshmark.utils.ShareManager.SHARE_MODE share_mode)
    {
        if (feature_settings.app_external_share != null)
        {
            return feature_settings.app_external_share.getProTipInfo(share_mode);
        } else
        {
            return null;
        }
    }

    public FeedAutoRefreshFeature getFeedAutoRefreshFeature()
    {
        return feature_settings.feed_auto_refresh;
    }

    public FeedLazyLoadFeature getLazyFeedLoadFeature()
    {
        return feature_settings.feed_lazy_load;
    }

    public ListingFeature getListingFeature()
    {
        return feature_settings.listing;
    }

    public ShopTabLuxuryFeature getLuxuryFeature()
    {
        return feature_settings.app_shop_tab_luxury;
    }

    public TriggerThresholds getRateAppTriggerFeature()
    {
        return feature_settings.app_trigger_app_rating;
    }

    public SimilarListings getSimilarListingsFeature()
    {
        return feature_settings.rp;
    }

    public boolean isAddToBundleButtonFeatureEnabled()
    {
        if (feature_settings.app_listing_details_add_to_bundle != null)
        {
            return feature_settings.app_listing_details_add_to_bundle.isEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isAutoCompleteEnabled()
    {
        if (feature_settings.ac != null)
        {
            return feature_settings.ac.isEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isBrandPriceDropEnabled()
    {
        if (feature_settings.pd != null && feature_settings.pd.br != null)
        {
            return feature_settings.pd.br.enabled;
        } else
        {
            return false;
        }
    }

    public boolean isBrandsFollowOnSignupEnabled()
    {
        if (feature_settings.sup_flow != null)
        {
            return feature_settings.sup_flow.isBrandFollowEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isEditListingWithNFSEnabled()
    {
        if (feature_settings.ael_nfs != null)
        {
            return feature_settings.ael_nfs.isEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isFBMessengerSharingEnabled()
    {
        if (feature_settings.app_share_via_fb_messenger != null)
        {
            return feature_settings.app_share_via_fb_messenger.isEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isFbExplicitShareEnabled()
    {
        if (feature_settings.app_external_share != null)
        {
            return feature_settings.app_external_share.isEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isFilterBarv2FeatureEnabled()
    {
        if (feature_settings.app_filter_bar_v2 != null)
        {
            return feature_settings.app_filter_bar_v2.isEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isListingDetailsPriceDropEnabled()
    {
        if (feature_settings.pd != null && feature_settings.pd.ld != null)
        {
            return feature_settings.pd.ld.enabled;
        } else
        {
            return false;
        }
    }

    public boolean isListingFeatureEnabled()
    {
        if (feature_settings.listing != null)
        {
            return feature_settings.listing.isEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isLuxuryFeatureEnabled()
    {
        if (feature_settings.app_shop_tab_luxury != null)
        {
            return feature_settings.app_shop_tab_luxury.isEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isMakeAnOfferEnabled()
    {
        if (feature_settings.offers != null)
        {
            return feature_settings.offers.isEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isMyLikesFiltersEnabled()
    {
        if (feature_settings.mlf != null)
        {
            return feature_settings.mlf.isEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isMyLikesPriceDropEnabled()
    {
        if (feature_settings.pd != null && feature_settings.pd.mlk != null)
        {
            return feature_settings.pd.mlk.enabled;
        } else
        {
            return false;
        }
    }

    public boolean isNewListingDetailsFeatureEnabled()
    {
        if (feature_settings.app_listing_details_v2 != null)
        {
            return feature_settings.app_listing_details_v2.isEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isPinterestButtonEnabled()
    {
        if (feature_settings.pinterest_share != null)
        {
            return feature_settings.pinterest_share.listing_flow_share;
        } else
        {
            return false;
        }
    }

    public boolean isPinterestConnectionDialogShowable()
    {
        if (feature_settings.pinterest_share != null)
        {
            return feature_settings.pinterest_share.listing_share_sheet_connect;
        } else
        {
            return false;
        }
    }

    public boolean isShareProTipEnabled(com.poshmark.utils.ShareManager.SHARE_MODE share_mode)
    {
        if (feature_settings.app_external_share != null)
        {
            return feature_settings.app_external_share.isProTipEnabled(share_mode);
        } else
        {
            return false;
        }
    }

    public boolean isShowRoomsEnabled()
    {
        return false;
    }

    public boolean isShowroomPriceDropEnabled()
    {
        if (feature_settings.pd != null && feature_settings.pd.shr != null)
        {
            return feature_settings.pd.shr.enabled;
        } else
        {
            return false;
        }
    }

    public boolean isSimilarListingsFeatureEnabled()
    {
        if (feature_settings.app_listing_details_v2 != null)
        {
            return feature_settings.app_listing_details_v2.isEnabled();
        } else
        {
            return false;
        }
    }
}
