// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.ebay.mobile.photomanager.PhotoManagerFragment;
import com.ebay.mobile.sell.hubitem.CustomHubItem;
import com.ebay.mobile.ui_stuff.Util;
import java.util.HashMap;

// Referenced classes of package com.ebay.mobile.sell:
//            BaseSpokeFragment, HubFragment, TitleSpokeFragment, CategorySpokeFragment, 
//            ConditionSpokeFragment, ItemSpecificsSpokeFragment, DescriptionSpokeFragment, FormatPriceSpokeFragment, 
//            ShippingSpokeFragment, PreferencesSpokeFragment, PhotosSpokeFragment

public class SpokeLauncher
{
    private static final class Spoke extends Enum
    {

        private static final Spoke $VALUES[];
        public static final Spoke CATEGORY;
        public static final Spoke CONDITION;
        public static final Spoke DESCRIPTION;
        public static final Spoke FORMAT_PRICE;
        public static final Spoke ITEM_SPECIFICS;
        public static final Spoke PHOTOS;
        public static final Spoke PREFERENCES;
        public static final Spoke SHIPPING;
        public static final Spoke TITLE;

        public static Spoke valueOf(String s)
        {
            return (Spoke)Enum.valueOf(com/ebay/mobile/sell/SpokeLauncher$Spoke, s);
        }

        public static Spoke[] values()
        {
            return (Spoke[])$VALUES.clone();
        }

        static 
        {
            PHOTOS = new Spoke("PHOTOS", 0);
            TITLE = new Spoke("TITLE", 1);
            CATEGORY = new Spoke("CATEGORY", 2);
            CONDITION = new Spoke("CONDITION", 3);
            ITEM_SPECIFICS = new Spoke("ITEM_SPECIFICS", 4);
            DESCRIPTION = new Spoke("DESCRIPTION", 5);
            FORMAT_PRICE = new Spoke("FORMAT_PRICE", 6);
            SHIPPING = new Spoke("SHIPPING", 7);
            PREFERENCES = new Spoke("PREFERENCES", 8);
            $VALUES = (new Spoke[] {
                PHOTOS, TITLE, CATEGORY, CONDITION, ITEM_SPECIFICS, DESCRIPTION, FORMAT_PRICE, SHIPPING, PREFERENCES
            });
        }

        private Spoke(String s, int i)
        {
            super(s, i);
        }
    }


    private static final HashMap fieldToSpokeMap;
    private static final HashMap resToSpokeMap;
    private static final HashMap spokeToResMap;

    public SpokeLauncher()
    {
    }

    private static void executeFragmentTransition(HubFragment hubfragment, Spoke spoke, Fragment fragment, boolean flag)
    {
        Fragment fragment1 = getCurrentSpokeFragment(hubfragment);
        if (fragment1 instanceof BaseSpokeFragment)
        {
            ((BaseSpokeFragment)fragment1).saveOutstandingChanges(false);
        }
        if (hubfragment.getResources().getBoolean(0x7f0b0006) && !hubfragment.isDetached())
        {
            Util.hideSoftInput(hubfragment.getActivity(), hubfragment.getView());
            hubfragment.clearHubSelection();
            ((CustomHubItem)hubfragment.getView().findViewById(((Integer)spokeToResMap.get(spoke)).intValue())).setSelected();
        }
        getFragmentTransaction(hubfragment, fragment, flag).commitAllowingStateLoss();
    }

    private static Spoke getCurrentSpoke(Fragment fragment)
    {
        if (fragment.getResources().getBoolean(0x7f0b0006))
        {
            fragment = fragment.getFragmentManager().findFragmentByTag("currentFragment");
            if (fragment instanceof PhotoManagerFragment)
            {
                return Spoke.PHOTOS;
            }
            if (fragment instanceof TitleSpokeFragment)
            {
                return Spoke.TITLE;
            }
            if (fragment instanceof CategorySpokeFragment)
            {
                return Spoke.CATEGORY;
            }
            if (fragment instanceof ConditionSpokeFragment)
            {
                return Spoke.CONDITION;
            }
            if (fragment instanceof ItemSpecificsSpokeFragment)
            {
                return Spoke.ITEM_SPECIFICS;
            }
            if (fragment instanceof DescriptionSpokeFragment)
            {
                return Spoke.DESCRIPTION;
            }
            if (fragment instanceof FormatPriceSpokeFragment)
            {
                return Spoke.FORMAT_PRICE;
            }
            if (fragment instanceof ShippingSpokeFragment)
            {
                return Spoke.SHIPPING;
            }
            if (fragment instanceof PreferencesSpokeFragment)
            {
                return Spoke.PREFERENCES;
            }
        }
        return null;
    }

    private static Fragment getCurrentSpokeFragment(HubFragment hubfragment)
    {
        return hubfragment.getFragmentManager().findFragmentByTag("currentFragment");
    }

    private static FragmentTransaction getFragmentTransaction(HubFragment hubfragment, Fragment fragment, boolean flag)
    {
        FragmentTransaction fragmenttransaction = hubfragment.getFragmentManager().beginTransaction();
        if (flag)
        {
            fragmenttransaction.setTransition(4097);
        }
        fragmenttransaction.replace(0x7f100648, fragment, "currentFragment");
        if (!hubfragment.getResources().getBoolean(0x7f0b0006))
        {
            fragmenttransaction.addToBackStack(null);
        }
        return fragmenttransaction;
    }

    private static Spoke getSpokeForErrorParameter(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        if (s.contains("Listing.Item.Picture"))
        {
            return (Spoke)fieldToSpokeMap.get("Listing.Item.Picture");
        } else
        {
            return (Spoke)fieldToSpokeMap.get(s);
        }
    }

    public static void launchFromValidationError(HubFragment hubfragment, String s)
    {
        Spoke spoke = getSpokeForErrorParameter(s);
        if (spoke != null)
        {
            if (getCurrentSpoke(hubfragment) != spoke)
            {
                launchSpoke(hubfragment, spoke, s);
                return;
            }
            hubfragment = getCurrentSpokeFragment(hubfragment);
            if (hubfragment instanceof BaseSpokeFragment)
            {
                ((BaseSpokeFragment)hubfragment).handleValidationError(s);
                return;
            }
        }
    }

    public static void launchFromViewClick(HubFragment hubfragment, CustomHubItem customhubitem)
    {
        for (customhubitem = (Spoke)resToSpokeMap.get(Integer.valueOf(customhubitem.getId())); customhubitem == null || getCurrentSpoke(hubfragment) == customhubitem;)
        {
            return;
        }

        launchSpoke(hubfragment, customhubitem, null);
    }

    public static void launchPhotosForUploadNotification(HubFragment hubfragment)
    {
        PhotosSpokeFragment photosspokefragment = new PhotosSpokeFragment();
        Bundle bundle = new Bundle();
        bundle.putAll(hubfragment.getArguments());
        bundle.putBoolean("upload_notification", true);
        photosspokefragment.setArguments(bundle);
        executeFragmentTransition(hubfragment, Spoke.PHOTOS, photosspokefragment, false);
    }

    public static void launchPhotosOnLoad(HubFragment hubfragment)
    {
        Bundle bundle = new Bundle();
        bundle.putAll(hubfragment.getArguments());
        PhotosSpokeFragment photosspokefragment = new PhotosSpokeFragment();
        photosspokefragment.setArguments(bundle);
        executeFragmentTransition(hubfragment, Spoke.PHOTOS, photosspokefragment, false);
    }

    private static void launchSpoke(HubFragment hubfragment, Spoke spoke, String s)
    {
        Object obj = null;
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$sell$SpokeLauncher$Spoke[];

            static 
            {
                $SwitchMap$com$ebay$mobile$sell$SpokeLauncher$Spoke = new int[Spoke.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$SpokeLauncher$Spoke[Spoke.PHOTOS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$SpokeLauncher$Spoke[Spoke.TITLE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$SpokeLauncher$Spoke[Spoke.CATEGORY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$SpokeLauncher$Spoke[Spoke.CONDITION.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$SpokeLauncher$Spoke[Spoke.ITEM_SPECIFICS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$SpokeLauncher$Spoke[Spoke.DESCRIPTION.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$SpokeLauncher$Spoke[Spoke.FORMAT_PRICE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$SpokeLauncher$Spoke[Spoke.SHIPPING.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$SpokeLauncher$Spoke[Spoke.PREFERENCES.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.mobile.sell.SpokeLauncher.Spoke[spoke.ordinal()];
        JVM INSTR tableswitch 1 9: default 60
    //                   1 109
    //                   2 120
    //                   3 131
    //                   4 142
    //                   5 153
    //                   6 164
    //                   7 175
    //                   8 186
    //                   9 197;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        if (obj != null)
        {
            Bundle bundle = new Bundle();
            bundle.putAll(hubfragment.getArguments());
            if (s != null)
            {
                bundle.putString("errorField", s);
            }
            ((Fragment) (obj)).setArguments(bundle);
        }
        executeFragmentTransition(hubfragment, spoke, ((Fragment) (obj)), true);
        return;
_L2:
        obj = new PhotosSpokeFragment();
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new TitleSpokeFragment();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new CategorySpokeFragment();
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new ConditionSpokeFragment();
        continue; /* Loop/switch isn't completed */
_L6:
        obj = new ItemSpecificsSpokeFragment();
        continue; /* Loop/switch isn't completed */
_L7:
        obj = new DescriptionSpokeFragment();
        continue; /* Loop/switch isn't completed */
_L8:
        obj = new FormatPriceSpokeFragment();
        continue; /* Loop/switch isn't completed */
_L9:
        obj = new ShippingSpokeFragment();
        continue; /* Loop/switch isn't completed */
_L10:
        obj = new PreferencesSpokeFragment();
        if (true) goto _L1; else goto _L11
_L11:
    }

    static 
    {
        resToSpokeMap = new HashMap();
        spokeToResMap = new HashMap();
        fieldToSpokeMap = new HashMap();
        resToSpokeMap.put(Integer.valueOf(0x7f100712), Spoke.PHOTOS);
        resToSpokeMap.put(Integer.valueOf(0x7f100713), Spoke.TITLE);
        resToSpokeMap.put(Integer.valueOf(0x7f100714), Spoke.CATEGORY);
        resToSpokeMap.put(Integer.valueOf(0x7f100715), Spoke.CONDITION);
        resToSpokeMap.put(Integer.valueOf(0x7f100716), Spoke.ITEM_SPECIFICS);
        resToSpokeMap.put(Integer.valueOf(0x7f100717), Spoke.DESCRIPTION);
        resToSpokeMap.put(Integer.valueOf(0x7f100718), Spoke.FORMAT_PRICE);
        resToSpokeMap.put(Integer.valueOf(0x7f100719), Spoke.SHIPPING);
        resToSpokeMap.put(Integer.valueOf(0x7f10071a), Spoke.PREFERENCES);
        spokeToResMap.put(Spoke.PHOTOS, Integer.valueOf(0x7f100712));
        spokeToResMap.put(Spoke.TITLE, Integer.valueOf(0x7f100713));
        spokeToResMap.put(Spoke.CATEGORY, Integer.valueOf(0x7f100714));
        spokeToResMap.put(Spoke.CONDITION, Integer.valueOf(0x7f100715));
        spokeToResMap.put(Spoke.ITEM_SPECIFICS, Integer.valueOf(0x7f100716));
        spokeToResMap.put(Spoke.DESCRIPTION, Integer.valueOf(0x7f100717));
        spokeToResMap.put(Spoke.FORMAT_PRICE, Integer.valueOf(0x7f100718));
        spokeToResMap.put(Spoke.SHIPPING, Integer.valueOf(0x7f100719));
        spokeToResMap.put(Spoke.PREFERENCES, Integer.valueOf(0x7f10071a));
        fieldToSpokeMap.put("Listing.Item.Picture", Spoke.PHOTOS);
        fieldToSpokeMap.put("Listing.Item.Title", Spoke.TITLE);
        fieldToSpokeMap.put("Listing.EnhancementInfo.SubTitle", Spoke.TITLE);
        fieldToSpokeMap.put("Listing.CategoryInfo[0].Id", Spoke.CATEGORY);
        fieldToSpokeMap.put("Listing.Condition", Spoke.CONDITION);
        fieldToSpokeMap.put("Listing.Item.ItemSpecific", Spoke.ITEM_SPECIFICS);
        fieldToSpokeMap.put("Listing.Item.Description", Spoke.DESCRIPTION);
        fieldToSpokeMap.put("Listing.Item.AddToDescription", Spoke.DESCRIPTION);
        fieldToSpokeMap.put("Listing.Format", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.ListingCurrency", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.StartPrice", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.Price", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.AuctionReservePrice", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.Quantity", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.BestOffer.BestOfferEnabled", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.BestOffer.AutoAccept", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.BestOffer.AutoAcceptAmount", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.BestOffer.AutoDecline", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.BestOffer.AutodeclineAmount", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.Duration", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.ScheduledListing", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.StartDate", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.StartDateDay", Spoke.FORMAT_PRICE);
        fieldToSpokeMap.put("Listing.ShippingInfo.DomesticShippingType", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.DomesticItemShippingService[1].ShippingFee", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.DomesticItemShippingService[2].ShippingFee", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.DomesticItemShippingService[3].ShippingFee", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlShippingType", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[0].ShippingFee", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[1].ShippingFee", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[2].ShippingFee", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[3].ShippingFee", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[4].ShippingFee", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[0].ShipToLocation", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[1].ShipToLocation", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[2].ShipToLocation", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[3].ShipToLocation", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IntlItemShippingService[4].ShipToLocation", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.ShipToLocation", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.ShippingPackageDetails.PackageType", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.ShippingPackageDetails.PackageWidth.Value", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.ShippingPackageDetails.PackageLength.Value", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.ShippingPackageDetails.PackageDepth.Value", Spoke.SHIPPING);
        fieldToSpokeMap.put("shippingDimension", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.IrregularPackage", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingPackageDetails.EstimatedWeight", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.ShippingPackageDetails.MajorWeight.Value", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.ShippingInfo.ShippingPackageDetails.MinorWeight.Value", Spoke.SHIPPING);
        fieldToSpokeMap.put("Listing.PaymentInfo.AcceptedPaymentMethod", Spoke.PREFERENCES);
        fieldToSpokeMap.put("Listing.PaymentInfo.PaypalEmailAddress", Spoke.PREFERENCES);
        fieldToSpokeMap.put("Listing.PaymentInfo.ImmediatePay", Spoke.PREFERENCES);
        fieldToSpokeMap.put("Listing.ShippingInfo.HandlingDuration", Spoke.PREFERENCES);
        fieldToSpokeMap.put("Listing.ItemLocation.CountryCode", Spoke.PREFERENCES);
        fieldToSpokeMap.put("Listing.ItemLocation.ZipCode", Spoke.PREFERENCES);
        fieldToSpokeMap.put("Listing.ItemLocation.CityState", Spoke.PREFERENCES);
        fieldToSpokeMap.put("Listing.ReturnPolicy.ReturnsAccepted", Spoke.PREFERENCES);
        fieldToSpokeMap.put("Listing.ReturnPolicy.ReturnPeriod", Spoke.PREFERENCES);
        fieldToSpokeMap.put("Listing.ReturnPolicy.RefundMethod", Spoke.PREFERENCES);
        fieldToSpokeMap.put("Listing.ReturnPolicy.RefundShipmentPayee", Spoke.PREFERENCES);
        fieldToSpokeMap.put("Listing.ReturnPolicy.PolicyDetails", Spoke.PREFERENCES);
    }
}
