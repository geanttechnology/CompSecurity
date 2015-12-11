// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.app.Activity;
import android.content.Intent;
import com.ebay.mobile.activities.RtmDownloadAppActivity;
import com.ebay.mobile.activities.RtmHtmlActivity;
import com.ebay.mobile.activities.RtmItemListActivity;
import com.ebay.mobile.activities.RtmThemedSearchActivity;
import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RTMViewModel extends ViewModel
{

    public static final int CARD_STYLE_NORMAL = 0;
    public static final int CARD_STYLE_SLIM = 1;
    public final String buttonText = getButtonText();
    public final int cardStyle;
    public final String clickId;
    public final String description;
    public final String imageUrl;
    public final String logoUrl;
    private final com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm rtmPromo;
    public final String rtmTrackingUrl;
    public final String subTitle;
    public final String title;

    public RTMViewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm rtm, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        logoUrl = rtm.logoUrl;
        imageUrl = rtm.imageUrl;
        title = rtm.title;
        subTitle = rtm.subTitle;
        description = rtm.description;
        clickId = rtm.clickId;
        rtmTrackingUrl = rtm.rtmTrackingUrl;
        cardStyle = rtm.cardStyle;
        rtmPromo = rtm;
    }

    private String getButtonText()
    {
        if (rtmPromo.htmlCampaign != null)
        {
            return rtmPromo.htmlCampaign.title;
        }
        if (rtmPromo.multiThemedSearchCampaign != null)
        {
            return rtmPromo.multiThemedSearchCampaign.title;
        }
        if (rtmPromo.themedSearchCampaign != null)
        {
            return rtmPromo.themedSearchCampaign.title;
        }
        if (rtmPromo.itemCampaign != null)
        {
            return rtmPromo.itemCampaign.title;
        }
        if (rtmPromo.downloadAppCampaign != null)
        {
            return rtmPromo.downloadAppCampaign.title;
        } else
        {
            return null;
        }
    }

    public Intent getIntent(Activity activity)
    {
        Object obj = null;
        if (rtmPromo.htmlCampaign == null) goto _L2; else goto _L1
_L1:
        obj = new Intent(activity, com/ebay/mobile/activities/RtmHtmlActivity);
        ((Intent) (obj)).putExtra("android.intent.extra.TITLE", rtmPromo.htmlCampaign.title);
        ((Intent) (obj)).putExtra("android.intent.extra.TEXT", rtmPromo.subTitle);
        ((Intent) (obj)).putExtra("url", rtmPromo.htmlCampaign.htmlPageUrl);
_L4:
        return ((Intent) (obj));
_L2:
        if (rtmPromo.multiThemedSearchCampaign == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = rtmPromo.multiThemedSearchCampaign;
        activity = new Intent(activity, com/ebay/mobile/activities/RtmThemedSearchActivity);
        activity.putExtra("android.intent.extra.TITLE", ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmMultiThemedSearchCampaign) (obj)).title);
        activity.putExtra("android.intent.extra.TEXT", rtmPromo.subTitle);
        activity.putExtra("url", ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmMultiThemedSearchCampaign) (obj)).bannerImageUrl);
        Object obj3 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmMultiThemedSearchCampaign) (obj)).themedSearchCampaignList;
        obj = activity;
        if (obj3 != null)
        {
            obj = activity;
            if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmMultiThemedSearchCampaign.ThemedSearchCampaignList) (obj3)).themedSearchCampaign != null)
            {
                obj = new ArrayList();
                ArrayList arraylist1 = new ArrayList();
                obj3 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmMultiThemedSearchCampaign.ThemedSearchCampaignList) (obj3)).themedSearchCampaign.iterator();
                do
                {
                    if (!((Iterator) (obj3)).hasNext())
                    {
                        break;
                    }
                    Object obj5 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmThemedSearchCampaign)((Iterator) (obj3)).next()).listItems;
                    if (obj5 != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmThemedSearchCampaign.RTMListItems) (obj5)).listItem != null)
                    {
                        obj5 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmThemedSearchCampaign.RTMListItems) (obj5)).listItem.iterator();
                        while (((Iterator) (obj5)).hasNext()) 
                        {
                            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmListItem rtmlistitem1 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmListItem)((Iterator) (obj5)).next();
                            arraylist1.add(rtmlistitem1.searchDescription);
                            ((ArrayList) (obj)).add(rtmlistitem1.itemSearchUrl);
                        }
                    }
                } while (true);
                activity.putStringArrayListExtra("searchDescriptions", arraylist1);
                activity.putStringArrayListExtra("itemSearchURLs", ((ArrayList) (obj)));
                return activity;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (rtmPromo.themedSearchCampaign == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = rtmPromo.themedSearchCampaign;
        activity = new Intent(activity, com/ebay/mobile/activities/RtmThemedSearchActivity);
        activity.putExtra("android.intent.extra.TITLE", ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmThemedSearchCampaign) (obj)).title);
        activity.putExtra("android.intent.extra.TEXT", rtmPromo.subTitle);
        activity.putExtra("url", ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmThemedSearchCampaign) (obj)).bannerImageUrl);
        Object obj4 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmThemedSearchCampaign) (obj)).listItems;
        obj = activity;
        if (obj4 != null)
        {
            obj = activity;
            if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmThemedSearchCampaign.RTMListItems) (obj4)).listItem != null)
            {
                obj = new ArrayList();
                ArrayList arraylist2 = new ArrayList();
                com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmListItem rtmlistitem;
                for (obj4 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmThemedSearchCampaign.RTMListItems) (obj4)).listItem.iterator(); ((Iterator) (obj4)).hasNext(); ((ArrayList) (obj)).add(rtmlistitem.itemSearchUrl))
                {
                    rtmlistitem = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmListItem)((Iterator) (obj4)).next();
                    arraylist2.add(rtmlistitem.searchDescription);
                }

                activity.putStringArrayListExtra("searchDescriptions", arraylist2);
                activity.putStringArrayListExtra("itemSearchURLs", ((ArrayList) (obj)));
                return activity;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (rtmPromo.itemCampaign == null)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1 = rtmPromo.itemCampaign;
        activity = new Intent(activity, com/ebay/mobile/activities/RtmItemListActivity);
        activity.putExtra("title", ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmItemCampaign) (obj1)).title);
        activity.putExtra("banner_url", ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmItemCampaign) (obj1)).imageUrl);
        obj = activity;
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmItemCampaign) (obj1)).listings != null)
        {
            obj = new ArrayList();
            for (obj1 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmItemCampaign) (obj1)).listings.iterator(); ((Iterator) (obj1)).hasNext(); ((ArrayList) (obj)).add(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmListing)((Iterator) (obj1)).next()).listingId)) { }
            activity.putStringArrayListExtra("item_ids", ((ArrayList) (obj)));
            return activity;
        }
        if (true) goto _L4; else goto _L6
_L6:
        Object obj2;
        if (rtmPromo.tabletItemCampaign == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = rtmPromo.tabletItemCampaign;
        activity = new Intent(activity, com/ebay/mobile/activities/RtmItemListActivity);
        activity.putExtra("title", rtmPromo.title);
        activity.putExtra("banner_url", rtmPromo.imageUrl);
        obj = activity;
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmTabletItemCampaign) (obj2)).listings == null) goto _L4; else goto _L7
_L7:
        ArrayList arraylist = new ArrayList();
        for (obj2 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmTabletItemCampaign) (obj2)).listings.iterator(); ((Iterator) (obj2)).hasNext(); arraylist.add(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmListing)((Iterator) (obj2)).next()).listingId)) { }
        activity.putStringArrayListExtra("item_ids", arraylist);
        return activity;
        if (rtmPromo.downloadAppCampaign == null) goto _L4; else goto _L8
_L8:
        com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Rtm.RtmDownloadCampaign rtmdownloadcampaign = rtmPromo.downloadAppCampaign;
        activity = new Intent(activity, com/ebay/mobile/activities/RtmDownloadAppActivity);
        activity.putExtra("android.intent.extra.TITLE", rtmdownloadcampaign.title);
        activity.putExtra("android.intent.extra.TEXT", rtmPromo.subTitle);
        activity.putExtra("url", rtmdownloadcampaign.infoUrl);
        activity.putExtra("downloadUrl", rtmdownloadcampaign.appStoreUrl);
        return activity;
    }
}
