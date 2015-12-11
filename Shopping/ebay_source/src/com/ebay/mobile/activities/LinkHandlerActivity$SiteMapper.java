// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.ebay.nautilus.domain.EbaySite;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.activities:
//            LinkHandlerActivity

private static class <init>
    implements 
{

    public String rewriteUri(String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Uri uri;
        List list;
        boolean flag;
        boolean flag1;
        obj2 = new HashSet();
        do
        {
            uri = Uri.parse(s);
            uri.getQueryParameterNames();
            ((Set) (obj2)).clear();
            for (Iterator iterator = uri.getQueryParameterNames().iterator(); iterator.hasNext(); ((Set) (obj2)).add(((String)iterator.next()).toLowerCase(Locale.getDefault()))) { }
            if ("market".equals(uri.getScheme()) && ((Set) (obj2)).contains("url"))
            {
                return uri.getQueryParameter("url");
            }
        } while (false);
        list = uri.getPathSegments();
        if (list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj = (String)list.get(0);
        } else
        {
            obj = "";
        }
        if (flag)
        {
            obj1 = (String)list.get(list.size() - 1);
        } else
        {
            obj1 = "";
        }
        flag1 = "eBayISAPI.dll".equalsIgnoreCase(((String) (obj1)));
        if ((!flag1 || !((Set) (obj2)).contains("viewitem")) && !((Set) (obj2)).contains("binconfirm") && !"itm".equalsIgnoreCase(((String) (obj)))) goto _L2; else goto _L1
_L1:
        obj1 = null;
        if (!"itm".equalsIgnoreCase(((String) (obj)))) goto _L4; else goto _L3
_L3:
        obj2 = (String)list.get(list.size() - 1);
        obj = obj1;
        if (TextUtils.isDigitsOnly(((CharSequence) (obj2))))
        {
            obj = obj2;
        }
_L6:
        if (obj != null)
        {
            obj1 = obj;
            if (12 < ((String) (obj)).length())
            {
                obj1 = ((String) (obj)).substring(0, Math.min(((String) (obj)).length(), 12));
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                return LinkHandlerActivity.buildItemViewLink(((String) (obj1)));
            }
        }
        break; /* Loop/switch isn't completed */
_L4:
        obj = obj1;
        if (flag1)
        {
            obj = uri.getQueryParameter("item");
        }
        if (true) goto _L6; else goto _L5
_L2:
        if (!flag1 || !((Set) (obj2)).contains("managebestoffers")) goto _L8; else goto _L7
_L7:
        obj = uri.getQueryParameter("itemid");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return LinkHandlerActivity.buildItemViewLink(((String) (obj)));
        }
          goto _L5
_L8:
        if (flag1 && ((Set) (obj2)).contains("buyhub"))
        {
            return LinkHandlerActivity.buildHomeLink();
        }
        if ((!flag1 || !((Set) (obj2)).contains("myebay")) && !"myebay".equalsIgnoreCase(((String) (obj))) && !"myb".equalsIgnoreCase(((String) (obj)))) goto _L10; else goto _L9
_L9:
        s = "user.myebay";
        obj = uri.getQueryParameter("actionName");
        obj2 = uri.getQueryParameter("CurrentPage");
        if (!"WATCHING".equals(obj) && !"WatchList".equalsIgnoreCase(((String) (obj1)))) goto _L12; else goto _L11
_L11:
        s = "user.watching";
_L13:
        return LinkHandlerActivity.buildDeepLink(s, new Pair[0]);
_L12:
        if ("BUY_OVERVIEW".equals(obj) || "MyeBayBidding".equals(obj2) || "MyeBayWon".equals(obj2))
        {
            s = "user.buying";
        } else
        if ("SELL_OVERVIEW".equals(obj) || "MyeBayAllSelling".equals(obj2))
        {
            s = "user.selling";
        }
        if (true) goto _L13; else goto _L10
_L10:
        if (uri.getHost().endsWith("feedback.ebay.com") && flag1 && ((Set) (obj2)).contains("viewfeedback"))
        {
            obj = uri.getQueryParameter("userid");
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                return LinkHandlerActivity.buildViewUserFeedbackLink(((String) (obj)));
            }
        } else
        {
            String s2 = uri.getHost().toLowerCase(Locale.getDefault());
            Object obj3 = null;
            if (EbaySite.getInstanceFromDomain(s2) != null)
            {
                if (!flag)
                {
                    return LinkHandlerActivity.buildHomeLink();
                }
                if ("seller".equalsIgnoreCase(((String) (obj))))
                {
                    obj = uri.getQueryParameter("sid");
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        return LinkHandlerActivity.buildViewUserDetailsLink(((String) (obj)));
                    }
                } else
                if ("usr".equalsIgnoreCase(((String) (obj))))
                {
                    obj = obj3;
                    if (list.size() >= 2)
                    {
                        obj = (String)list.get(1);
                    }
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        return LinkHandlerActivity.buildViewUserDetailsLink(((String) (obj)));
                    }
                } else
                {
                    if ("syi".equalsIgnoreCase(((String) (obj))) || "csr.ebay.com".equalsIgnoreCase(s2) && ("sell.jsf".equals(obj1) || "start.jsf".equals(obj1)) || flag1 && "SellHub3".equalsIgnoreCase(uri.getQueryParameter("MfcISAPICommand")))
                    {
                        return LinkHandlerActivity.buildDeepLink("user.sell", new Pair[0]);
                    }
                    if ("myworld.ebay.com".equalsIgnoreCase(s2))
                    {
                        String s1 = (String)uri.getPathSegments().get(0);
                        if (!TextUtils.isEmpty(s1))
                        {
                            return LinkHandlerActivity.buildViewUserDetailsLink(s1);
                        }
                    }
                }
            }
        }
_L5:
        return s;
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
