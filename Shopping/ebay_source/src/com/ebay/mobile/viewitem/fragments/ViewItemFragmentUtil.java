// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import com.ebay.app.AlertDialogFragment;
import com.ebay.common.Preferences;
import com.ebay.common.model.ItemTransaction;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ComposeNewMessageActivity;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.mobile.sell.ListingFragmentActivity;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.shell.app.FwActivity;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemBaseFragment

public class ViewItemFragmentUtil
{

    private ViewItemFragmentUtil()
    {
    }

    public static void contactUser(ViewItemBaseFragment viewitembasefragment, Item item, ViewItemViewData viewitemviewdata, int i)
    {
        boolean flag = item.isSeller;
        Object obj;
        Authentication authentication;
        com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageRequestParams membermessagerequestparams;
        if (flag)
        {
            obj = item.iTransaction.buyerUserId;
        } else
        {
            obj = item.sellerUserId;
        }
        authentication = MyApp.getPrefs().getAuthentication();
        membermessagerequestparams = new com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageRequestParams(Long.valueOf(item.id), authentication.user, ((String) (obj)), "", flag);
        if (flag)
        {
            obj = null;
            Object obj1 = item.currentPriceForType(viewitembasefragment.getFwActivity().getEbayContext(), viewitemviewdata);
            viewitemviewdata = ((ViewItemViewData) (obj1));
            if (obj1 == null)
            {
                viewitemviewdata = item.currentPrice;
            }
            if (viewitemviewdata != null)
            {
                obj = new CurrencyAmount(viewitemviewdata);
            }
            if (obj == null)
            {
                viewitemviewdata = "";
            } else
            {
                viewitemviewdata = Double.toString(((CurrencyAmount) (obj)).getValueAsDouble());
            }
            obj1 = item.site;
            if (item.primaryCategoryId != -1L)
            {
                obj = Long.toString(item.primaryCategoryId);
            } else
            {
                obj = "";
            }
            viewitemviewdata = new com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageTrackingInfo(viewitemviewdata, ((String) (obj1)), ((String) (obj)));
            viewitemviewdata.setSid(new SourceIdentification("ViewItem"));
            obj = new HashMap();
            ((Map) (obj)).put(com.ebay.mobile.analytics.Tracking.Tag.MESSAGE_DIRECTION, com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageTagValues.BUYER_ASK_QUESTION);
            viewitemviewdata.setMessageTag(((Map) (obj)));
            membermessagerequestparams.setTrackingData(viewitemviewdata);
            membermessagerequestparams.setQuestionType(com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType.CustomizedSubject);
            membermessagerequestparams.setSubject(viewitembasefragment.getResources().getString(0x7f0704db, new Object[] {
                Long.toString(item.id)
            }));
        }
        ComposeNewMessageActivity.StartActivity(viewitembasefragment, i, flag, membermessagerequestparams);
    }

    public static String getEndItemEarlyUrl()
    {
        return DeviceConfiguration.getAsync().get(DcsString.EndItemEarlyWarning);
    }

    public static void sellOneLikeThis(Fragment fragment, Item item)
    {
        Intent intent = new Intent(fragment.getActivity(), com/ebay/mobile/sell/ListingFragmentActivity);
        intent.putExtra("site", EbaySite.getInstanceFromId(item.site));
        intent.putExtra("source_item_id", item.getIdString());
        intent.putExtra("listing_mode", "SellLikeItem");
        fragment.startActivity(intent);
    }

    public static void showDialog(Fragment fragment, String s, String s1, String s2, String s3, int i)
    {
        com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
        if (s != null)
        {
            builder.setTitle(s);
        }
        builder.setMessage(s1);
        builder.setPositiveButton(s2);
        if (s3 != null)
        {
            builder.setNegativeButton(s3);
        }
        builder.createFromFragment(i, fragment).show(fragment.getFragmentManager(), null);
    }

    public static void showDialogOk(Fragment fragment, String s)
    {
        showDialog(fragment, fragment.getString(0x7f07049c), s, fragment.getString(0x7f070738), null, 0);
    }

    public static void showRelistedItem(Fragment fragment, Item item)
    {
        try
        {
            long l = Long.parseLong(item.relistedId);
            ItemViewActivity.StartActivity(fragment.getActivity(), Long.valueOf(l).longValue(), com.ebay.common.ConstantsCommon.ItemKind.Found);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Fragment fragment)
        {
            return;
        }
    }
}
