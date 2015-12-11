// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import com.ebay.nautilus.domain.net.EbayResponseError;
import java.util.Iterator;
import java.util.List;

public final class EbayErrorUtil
{

    private static final String CARRIER_INVALID = "21916773";
    public static final int EXPIRED_IAF_TOKEN = 0x14e6d7d;
    public static final String EXPIRED_IAF_TOKEN_STR = String.valueOf(0x14e6d7d);
    private static final String FORCED_CHANGE_PASSWORD = "2007";
    private static final String INCORRECT_CREDENTIALS = "2001";
    public static final int INVALID_IAF_TOKEN = 0x14e6d38;
    public static final String INVALID_IAF_TOKEN_STR = String.valueOf(0x14e6d38);
    private static final String MISSING_CREDENTIALS = "21003";
    private static final String MISSING_PAYPAL_SECURITY_KEY = "2006";
    private static final String NO_PRODUCT_MATCH = "41";
    public static final int OATH_INVALID_TOKEN = 1001;
    public static final String PPA_UPGRADE_REQUIRED = "7005";
    private static final String PRODUCT_ID_INVALID = "18";
    private static final String SAVED_SEARCH_ERROR = "28";
    public static final int SOA_INVALID_IAF_TOKEN = 11002;
    public static final String USER_ACCESS_LEVEL_UPGRADE_REQUIRED = "21918010";

    public EbayErrorUtil()
    {
    }

    public static final boolean carrierInvalid(List list)
    {
        return checkErrorId(list, new String[] {
            "21916773"
        });
    }

    private static final transient boolean checkErrorId(List list, String as[])
    {
        if (list != null && !list.isEmpty() && as != null && as.length != 0)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                Object obj = (com.ebay.nautilus.kernel.content.ResultStatus.Message)list.next();
                if (obj instanceof EbayResponseError)
                {
                    obj = (EbayResponseError)obj;
                    int j = as.length;
                    int i = 0;
                    while (i < j) 
                    {
                        String s = as[i];
                        if (((EbayResponseError) (obj)).code.equals(s))
                        {
                            return true;
                        }
                        i++;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean containsError(List list, String s)
    {
        return checkErrorId(list, new String[] {
            s
        });
    }

    public static final boolean forcedChangePassword(List list)
    {
        return checkErrorId(list, new String[] {
            "2007"
        });
    }

    public static final boolean incorrectCredentials(List list)
    {
        return checkErrorId(list, new String[] {
            "2001", "21003"
        });
    }

    public static final boolean missingPaypalSecurityKey(List list)
    {
        return checkErrorId(list, new String[] {
            "2006"
        });
    }

    public static final boolean noProductMatch(List list)
    {
        return checkErrorId(list, new String[] {
            "41"
        });
    }

    public static final boolean productIdInvalid(List list)
    {
        return checkErrorId(list, new String[] {
            "18"
        });
    }

    public static final boolean savedSearchError(List list)
    {
        return checkErrorId(list, new String[] {
            "28"
        });
    }

    public static final boolean userAccessLevelUpgradeRequired(String s)
    {
        return "21918010".equals(s) || "7005".equals(s);
    }

    public static final boolean userAccessLevelUpgradeRequired(List list)
    {
        return checkErrorId(list, new String[] {
            "21918010", "7005"
        });
    }

    public static final boolean userNotLoggedIn(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        if (!(message instanceof EbayResponseError))
        {
            return false;
        }
        switch (message.getId())
        {
        default:
            return false;

        case 21916984: 
        case 21917053: 
            return true;

        case 11002: 
            return "Security".equals(message.getDomain());

        case 1001: 
            return "OAuth".equals(message.getDomain());
        }
    }

    public static final boolean userNotLoggedIn(List list)
    {
        if (list != null && !list.isEmpty())
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                if (userNotLoggedIn((com.ebay.nautilus.kernel.content.ResultStatus.Message)list.next()))
                {
                    return true;
                }
            }
        }
        return false;
    }

}
