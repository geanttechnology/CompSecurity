// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import android.net.Uri;
import com.groupon.Channel;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.DivisionTimeZone;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.restlet.engine.util.InternetDateFormat;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.manager:
//            WidgetsSyncHelper, WidgetsDeepLinkParameterProcessor

public class WidgetsOnDealSubsetFragmentSyncHelper extends WidgetsSyncHelper
{

    private DeepLinkData deepLink;
    DeepLinkUtil deepLinkUtil;
    private String partialDealSubsetWidgetUrl;

    public WidgetsOnDealSubsetFragmentSyncHelper(Context context)
    {
        super(context, Channel.UNKNOWN.toString(), Channel.ALLDEALS.toString(), "unknown");
    }

    protected Object[] addExtraNstNameValueParams(Object aobj[])
    {
        aobj = super.addExtraNstNameValueParams(aobj);
        int i = aobj.length;
        Object aobj1[] = new Object[i + 2];
        System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj1)), 0, i);
        aobj1[i] = "andcon_extra";
        aobj1[i + 1] = Uri.encode(Uri.parse(partialDealSubsetWidgetUrl).getPath());
        return aobj1;
    }

    public void configure(String s, String s1, String s2, String s3)
    {
        partialDealSubsetWidgetUrl = s;
        try
        {
            deepLink = deepLinkUtil.getDeepLink(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        configureChannels(s1, s2, s3);
    }

    protected List getNameValueParams()
    {
        List list = super.getNameValueParams();
        list.addAll(Arrays.asList(new String[] {
            "datetime", ((InternetUsDateFormat)internetDateFormat.get()).toString((new DivisionTimeZone(((CurrentDivisionManager)currentDivisionManager.get()).getCurrentDivision())).getNow().getTimeInMillis(), InternetDateFormat.UTC, false)
        }));
        return (new WidgetsDeepLinkParameterProcessor(partialDealSubsetWidgetUrl, list)).process();
    }

    public String getScenarioIdName()
    {
        if (deepLink == null)
        {
            return "";
        } else
        {
            return deepLink.getSpecifier();
        }
    }

    public String getWidgetsChannelName(String s)
    {
        return widgetsChannel;
    }
}
