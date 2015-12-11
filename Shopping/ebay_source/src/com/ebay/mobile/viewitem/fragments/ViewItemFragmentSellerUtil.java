// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.ItemTransaction;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.AddEditTrackingInfoActivity;
import com.ebay.mobile.activities.ComposeNewMessageActivity;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.sell.ListingFragmentActivity;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemFragmentUtil, ViewItemBaseFragment

public class ViewItemFragmentSellerUtil
{

    private ViewItemFragmentSellerUtil()
    {
    }

    public static void addShipmentTrackingDetails(Fragment fragment, Item item, int i)
    {
        Intent intent = new Intent(fragment.getActivity(), com/ebay/mobile/activities/AddEditTrackingInfoActivity);
        intent.putExtra("number", item.iTransaction.getShipmentTrackingNumber());
        intent.putExtra("carrier", item.iTransaction.getShippingCarrierUsed());
        intent.putExtra("enter_vs_edit", true);
        fragment.startActivityForResult(intent, i);
    }

    public static void endListing(Fragment fragment, ViewItemDataManager viewitemdatamanager, Item item)
    {
        Resources resources = fragment.getResources();
        if (DeviceConfiguration.getAsync().get(DcsBoolean.VI_auctionEndEarlyWarning))
        {
            android.text.Spanned spanned = Util.linkifyText(resources.getString(0x7f0703ba), ViewItemFragmentUtil.getEndItemEarlyUrl(), resources.getString(0x7f0703bb));
            fragment = (new android.support.v7.app.AlertDialog.Builder(fragment.getActivity())).setPositiveButton(0x7f070738, new android.content.DialogInterface.OnClickListener(item, fragment, viewitemdatamanager, resources) {

                final Fragment val$fragment;
                final Item val$item;
                final Resources val$resources;
                final ViewItemDataManager val$viewItemDataManager;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    ViewItemFragmentSellerUtil.showEndItemReasonDialog(item, fragment, viewItemDataManager, resources);
                }

            
            {
                item = item1;
                fragment = fragment1;
                viewItemDataManager = viewitemdatamanager;
                resources = resources1;
                super();
            }
            }).setNegativeButton(0x7f0701cc, null).setMessage(spanned).create();
            fragment.show();
            ((TextView)fragment.findViewById(0x102000b)).setMovementMethod(LinkMovementMethod.getInstance());
            return;
        } else
        {
            showEndItemReasonDialog(item, fragment, viewitemdatamanager, resources);
            return;
        }
    }

    public static void relistItem(Fragment fragment, Item item, int i)
    {
        Intent intent = new Intent(fragment.getActivity(), com/ebay/mobile/sell/ListingFragmentActivity);
        intent.putExtra("site", EbaySite.getInstanceFromId(item.site));
        intent.putExtra("source_item_id", item.idForDraftSource);
        intent.putExtra("listing_mode", "RelistItem");
        fragment.startActivityForResult(intent, i);
    }

    public static void reviseListing(ViewItemBaseFragment viewitembasefragment, Item item, int i)
    {
        viewitembasefragment.activityRefreshListener.deleteCachedItem();
        Intent intent = new Intent(viewitembasefragment.getActivity(), com/ebay/mobile/sell/ListingFragmentActivity);
        intent.putExtra("site", EbaySite.getInstanceFromId(item.site));
        intent.putExtra("source_item_id", item.idForDraftSource);
        intent.putExtra("listing_mode", "ReviseItem");
        viewitembasefragment.startActivityForResult(intent, i);
    }

    public static void sellSimilar(Fragment fragment, Item item, int i)
    {
        Intent intent = new Intent(fragment.getActivity(), com/ebay/mobile/sell/ListingFragmentActivity);
        intent.putExtra("site", EbaySite.getInstanceFromId(item.site));
        intent.putExtra("source_item_id", item.idForDraftSource);
        intent.putExtra("listing_mode", "SellSimilarItem");
        fragment.startActivityForResult(intent, i);
    }

    public static void sendPaymentReminder(Fragment fragment, Item item)
    {
        Object obj2 = fragment.getResources();
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        Object obj;
        Object obj1;
        if (item.iTransaction != null)
        {
            obj = item.iTransaction.transactionPrice;
        } else
        {
            obj = null;
        }
        obj1 = "";
        if (obj != null)
        {
            obj1 = EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.ItemCurrency) (obj)), EbayCountry.getInstance(EbaySite.getInstanceFromId(item.site)).getSiteLocale(), 0);
        }
        obj1 = String.format(((Resources) (obj2)).getString(0x7f07076a), new Object[] {
            item.title.getContent(false), obj1
        });
        obj2 = String.format(((Resources) (obj2)).getString(0x7f07076b), new Object[] {
            item.title.getContent(false)
        });
        if (item.iTransaction != null)
        {
            obj = item.iTransaction.buyerUserId;
        } else
        {
            obj = null;
        }
        item = new com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageRequestParams(Long.valueOf(item.id), authentication.user, ((String) (obj)), ((String) (obj1)), true);
        item.setQuestionType(com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType.CustomizedSubject);
        item.setSubject(((String) (obj2)));
        obj = new com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageTrackingInfo();
        ((com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageTrackingInfo) (obj)).setSid(new SourceIdentification("ViewItem"));
        obj1 = new HashMap();
        ((Map) (obj1)).put(com.ebay.mobile.analytics.Tracking.Tag.MESSAGE_DIRECTION, com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageTagValues.PAYMENT_REMINDER);
        ((com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageTrackingInfo) (obj)).setMessageTag(((Map) (obj1)));
        item.setTrackingData(((com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageTrackingInfo) (obj)));
        ComposeNewMessageActivity.StartActivity(fragment, 101, true, true, item);
    }

    private static void showDialogEndItem(int i, Fragment fragment, ViewItemDataManager viewitemdatamanager, Item item, CharSequence acharsequence[])
    {
        android.support.v7.app.AlertDialog.Builder builder = (new android.support.v7.app.AlertDialog.Builder(fragment.getActivity())).setTitle(fragment.getResources().getString(i));
        builder.setItems(acharsequence, new android.content.DialogInterface.OnClickListener(viewitemdatamanager, fragment, item) {

            final Fragment val$fragment;
            final Item val$item;
            final ViewItemDataManager val$viewItemDataManager;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                String s = null;
                j;
                JVM INSTR tableswitch 0 4: default 36
            //                           0 116
            //                           1 122
            //                           2 128
            //                           3 134
            //                           4 140;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
                if (s != null)
                {
                    Authentication authentication = MyApp.getPrefs().getAuthentication();
                    if (authentication != null && viewItemDataManager != null)
                    {
                        dialoginterface = EbayApiUtil.getTradingApi(((Dialog)dialoginterface).getContext(), authentication);
                        if (fragment.getActivity() instanceof ItemViewActivity)
                        {
                            ((ItemViewActivity)fragment.getActivity()).showProgress();
                        }
                        viewItemDataManager.sellerEndItem(dialoginterface, item.id, s);
                    }
                }
                return;
_L2:
                s = "Incorrect";
                continue; /* Loop/switch isn't completed */
_L3:
                s = "LostOrBroken";
                continue; /* Loop/switch isn't completed */
_L4:
                s = "NotAvailable";
                continue; /* Loop/switch isn't completed */
_L5:
                s = "OtherListingError";
                continue; /* Loop/switch isn't completed */
_L6:
                s = "SellToHighBidder";
                if (true) goto _L1; else goto _L7
_L7:
            }

            
            {
                viewItemDataManager = viewitemdatamanager;
                fragment = fragment1;
                item = item1;
                super();
            }
        });
        builder.show();
    }

    private static void showEndItemReasonDialog(Item item, Fragment fragment, ViewItemDataManager viewitemdatamanager, Resources resources)
    {
        CharSequence acharsequence[];
        if (item.isListingTypeBid && item.bidCount > 0 && item.isReserveMet)
        {
            acharsequence = new CharSequence[5];
            acharsequence[4] = resources.getString(0x7f0703bf);
        } else
        {
            acharsequence = new CharSequence[4];
        }
        acharsequence[0] = resources.getString(0x7f0703bd);
        acharsequence[1] = resources.getString(0x7f0703be);
        acharsequence[2] = resources.getString(0x7f0703c0);
        acharsequence[3] = resources.getString(0x7f0703bc);
        showDialogEndItem(0x7f0704b9, fragment, viewitemdatamanager, item, acharsequence);
    }

}
