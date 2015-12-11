// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import com.ebay.common.Preferences;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ViewItemDataManager;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemFragmentSellerUtil

static final class val.item
    implements android.content.er
{

    final Fragment val$fragment;
    final Item val$item;
    final ViewItemDataManager val$viewItemDataManager;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        String s = null;
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 116
    //                   1 122
    //                   2 128
    //                   3 134
    //                   4 140;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        if (s != null)
        {
            com.ebay.nautilus.domain.app.Authentication authentication = MyApp.getPrefs().getAuthentication();
            if (authentication != null && val$viewItemDataManager != null)
            {
                dialoginterface = EbayApiUtil.getTradingApi(((Dialog)dialoginterface).getContext(), authentication);
                if (val$fragment.getActivity() instanceof ItemViewActivity)
                {
                    ((ItemViewActivity)val$fragment.getActivity()).showProgress();
                }
                val$viewItemDataManager.sellerEndItem(dialoginterface, val$item.id, s);
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

    (ViewItemDataManager viewitemdatamanager, Fragment fragment1, Item item1)
    {
        val$viewItemDataManager = viewitemdatamanager;
        val$fragment = fragment1;
        val$item = item1;
        super();
    }
}
