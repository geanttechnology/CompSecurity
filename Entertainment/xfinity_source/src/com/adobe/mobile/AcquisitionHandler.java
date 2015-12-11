// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods, RequestHandler

final class AcquisitionHandler
{

    AcquisitionHandler()
    {
    }

    protected static void campaignStartForApp(String s, Map map)
    {
        s = constructURLForCampaignStartRequest(s, StaticMethods.getAdvertisingIdentifier(), map);
        StaticMethods.logDebugFormat("Acquisition - Sending acquisition request  (%s)", new Object[] {
            s
        });
        RequestHandler.sendGenericRequest(s, null, 5000, "Acquisition");
    }

    protected static String constructURLForCampaignStartRequest(String s, String s1, Map map)
    {
        if (s == null || s.length() <= 0)
        {
            StaticMethods.logDebugFormat("Acquisition - Acquisition application identifier is blank", new Object[0]);
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("http://c00.adobe.com/v3/").append(s).append("/start?");
        StringBuilder stringbuilder1 = new StringBuilder();
        if (s1 != null)
        {
            Object obj;
            if (stringbuilder1.length() > 0)
            {
                s = "&";
            } else
            {
                s = "";
            }
            stringbuilder1.append(s);
            stringbuilder1.append("a_cid=").append(StaticMethods.URLEncode(s1));
        }
        if (map != null && map.size() > 0)
        {
            s1 = map.entrySet().iterator();
            do
            {
                if (!s1.hasNext())
                {
                    break;
                }
                s = (java.util.Map.Entry)s1.next();
                map = (String)s.getKey();
                obj = s.getValue();
                if (map != null && map.length() != 0 && obj != null && obj.toString().length() != 0)
                {
                    if (stringbuilder1.length() > 0)
                    {
                        s = "&";
                    } else
                    {
                        s = "";
                    }
                    stringbuilder1.append(s);
                    stringbuilder1.append("ctx");
                    stringbuilder1.append(StaticMethods.URLEncode(map));
                    stringbuilder1.append("=");
                    stringbuilder1.append(StaticMethods.URLEncode(obj.toString()));
                }
            } while (true);
        }
        return stringbuilder.append(stringbuilder1).toString();
    }
}
