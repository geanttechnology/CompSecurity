// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.crash;

import com.amazon.device.crashmanager.rtla.RtlaCrashDetails;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.Feature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RtlaCrashDetailsProvider
    implements RtlaCrashDetails
{

    public RtlaCrashDetailsProvider()
    {
    }

    public List getActiveWebLabs()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = Features.getInstance().getFeaturesMap().entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s = ((Feature)entry.getValue()).getClientTreatmentPath();
            if (!Util.isEmpty(s))
            {
                arraylist.add((new StringBuilder()).append((String)entry.getKey()).append(":").append(s).toString());
            }
        } while (true);
        return arraylist;
    }

    public String getPageType()
    {
        return AppLocale.getInstance().getCurrentLocaleName();
    }

    public String getSessionId()
    {
        return CookieBridge.getCurrentSessionId();
    }

    public String getSubPageType()
    {
        return null;
    }

    public String getUserAgent()
    {
        return AndroidPlatform.getInstance().getUserAgent();
    }
}
