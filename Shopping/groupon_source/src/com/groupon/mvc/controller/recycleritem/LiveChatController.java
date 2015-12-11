// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.db.models.Deal;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.livechat.LiveChatUtil;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class LiveChatController extends RecyclerItemViewController
{

    private Channel channel;
    private CurrentCountryManager currentCountryManager;
    private Deal deal;
    private boolean liveChatGADealPage1508USEnabled;
    private LiveChatUtil liveChatUtil;
    private String pageViewId;

    public LiveChatController(Context context)
    {
        super(context);
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public Void getCallback()
    {
        return null;
    }

    public void processData()
    {
        boolean flag;
        if (liveChatGADealPage1508USEnabled && currentCountryManager.getCurrentCountry().isUSOnly() && Strings.equalsIgnoreCase(channel, Channel.GETAWAYS.toString()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            setState(0);
            return;
        } else
        {
            liveChatUtil.channel = channel;
            liveChatUtil.dealId = deal.remoteId;
            liveChatUtil.pageId = pageViewId;
            setState(2);
            return;
        }
    }

    public void setChannel(Channel channel1)
    {
        setState(1);
        channel = channel1;
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setLiveChatGADealPage1508USEnabled(boolean flag)
    {
        setState(1);
        liveChatGADealPage1508USEnabled = flag;
    }

    public void setPageViewId(String s)
    {
        setState(1);
        pageViewId = s;
    }
}
