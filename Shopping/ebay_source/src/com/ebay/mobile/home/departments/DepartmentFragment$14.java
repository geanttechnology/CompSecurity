// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.ebay.common.net.SimpleHttpGETRequest;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.RTMViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class this._cls0
    implements com.ebay.mobile.common.view.ner
{

    final DepartmentFragment this$0;

    private void sendRtmTracking(RTMViewModel rtmviewmodel)
    {
        com.ebay.nautilus.kernel.content.EbayContext ebaycontext = getBaseActivity().getEbayContext();
        if (rtmviewmodel.rtmTrackingUrl != null)
        {
            try
            {
                SimpleHttpGETRequest simplehttpgetrequest = new SimpleHttpGETRequest(ebaycontext, new URL(rtmviewmodel.rtmTrackingUrl));
                DepartmentFragment.access$600(DepartmentFragment.this).start(10, simplehttpgetrequest, false);
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
label0:
        {
            if (viewmodel instanceof RTMViewModel)
            {
                viewmodel = (RTMViewModel)viewmodel;
                sendRtmTracking(viewmodel);
                view = getActivity();
                if (view != null)
                {
                    break label0;
                }
            }
            return;
        }
        if (((RTMViewModel) (viewmodel)).viewType == 11 && !TextUtils.isEmpty(((RTMViewModel) (viewmodel)).logoUrl) && (view instanceof com.ebay.mobile.home.nnelHost))
        {
            try
            {
                viewmodel = ChannelEnum.valueOf(((RTMViewModel) (viewmodel)).logoUrl.toUpperCase(Locale.US));
                switch (.SwitchMap.com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum[viewmodel.ordinal()])
                {
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                    ((com.ebay.mobile.home.nnelHost)view).navigateToChannel(viewmodel, true, true);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return;
            }
        } else
        {
            view.startActivity(viewmodel.getIntent(view));
            return;
        }
    }

    ()
    {
        this$0 = DepartmentFragment.this;
        super();
    }
}
