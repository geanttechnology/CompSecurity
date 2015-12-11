// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.EbayContext;

public class FollowQaDeepLinkUtil
{

    public FollowQaDeepLinkUtil()
    {
    }

    public static Intent parseDeepLink(Context context, EbayContext ebaycontext, String s, Uri uri)
    {
        if (MyApp.getPrefs().isSignedIn()) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        String s1;
        s = (FollowedEntityDataManager)DataManager.get(ebaycontext, FollowedEntityDataManager.KEY);
        s1 = uri.getQueryParameter("action");
        if (TextUtils.isEmpty(s1)) goto _L1; else goto _L3
_L3:
        String s2;
        byte byte0;
        s2 = uri.getQueryParameter("interestId");
        uri = uri.getQueryParameter("title");
        byte0 = -1;
        s1.hashCode();
        JVM INSTR tableswitch -403877141 -403877141: default 80
    //                   -403877141 118;
           goto _L4 _L5
_L4:
        byte0;
        JVM INSTR tableswitch 0 0: default 100
    //                   0 134;
           goto _L6 _L7
_L6:
        context = ActivityStarter.getSavedSearchIntent(context, ebaycontext, null, null);
        context.putExtra("saved_search_from_notification", true);
        return context;
_L5:
        if (s1.equals("addInterest"))
        {
            byte0 = 0;
        }
          goto _L4
_L7:
        if (!TextUtils.isEmpty(s2))
        {
            s.QA_followInterest(MyApp.getPrefs().getAuthentication().iafToken, s2, MyApp.getPrefs().getCurrentSite().idString, uri, null);
        }
          goto _L6
    }
}
