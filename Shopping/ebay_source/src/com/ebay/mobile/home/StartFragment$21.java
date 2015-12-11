// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.text.TextUtils;
import android.view.View;
import com.ebay.common.net.SimpleHttpGETRequest;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.RTMViewModel;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.Listener
{

    final StartFragment this$0;

    private void sendRtmTracking(RTMViewModel rtmviewmodel)
    {
        com.ebay.nautilus.kernel.content.EbayContext ebaycontext = getBaseActivity().getEbayContext();
        if (rtmviewmodel.rtmTrackingUrl != null)
        {
            try
            {
                SimpleHttpGETRequest simplehttpgetrequest = new SimpleHttpGETRequest(ebaycontext, new URL(rtmviewmodel.rtmTrackingUrl));
                StartFragment.access$1000(StartFragment.this).start(10, simplehttpgetrequest, false);
            }
            catch (MalformedURLException malformedurlexception) { }
        }
        if (!TextUtils.isEmpty(rtmviewmodel.clickId))
        {
            TrackingData trackingdata = new TrackingData("RTMItemList", TrackingType.EVENT);
            trackingdata.addKeyValuePair("trkp", rtmviewmodel.clickId);
            trackingdata.send(ebaycontext);
        }
    }

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof RTMViewModel)
        {
            view = (RTMViewModel)viewmodel;
            sendRtmTracking(view);
            startActivity(view.getIntent(getActivity()));
        }
    }

    l()
    {
        this$0 = StartFragment.this;
        super();
    }
}
