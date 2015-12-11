// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;

import android.app.Activity;
import android.net.Uri;
import android.webkit.WebView;
import com.sponsorpay.mediation.SPMediationCoordinator;
import com.sponsorpay.publisher.SponsorPayPublisher;
import com.sponsorpay.publisher.mbe.mediation.SPMediationValidationEvent;
import com.sponsorpay.publisher.mbe.mediation.SPMediationVideoEvent;
import com.sponsorpay.publisher.mbe.mediation.SPTPNVideoEvent;
import com.sponsorpay.publisher.mbe.mediation.SPTPNVideoValidationResult;
import com.sponsorpay.utils.SPWebClient;
import com.sponsorpay.utils.SponsorPayLogger;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.sponsorpay.publisher.mbe:
//            SPBrandEngageClient, SPBrandEngageOffersStatus

class this._cls1
    implements SPMediationVideoEvent
{

    final is._cls0 this$1;

    public void videoEventOccured(String s, SPTPNVideoEvent sptpnvideoevent, Map map)
    {
        if (sptpnvideoevent == SPTPNVideoEvent.SPTPNVideoEventStarted)
        {
            SPBrandEngageClient.access$14(_fld0, "STARTED");
        }
        s = String.format("%s('play', {tpn:'%s', id:%s, result:'%s'})", new Object[] {
            "javascript:Sponsorpay.MBE.SDKInterface.notify", s, map.get("id"), sptpnvideoevent
        });
        SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("Notifying - ")).append(s).toString());
        SPBrandEngageClient.access$15(_fld0, s);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/sponsorpay/publisher/mbe/SPBrandEngageClient$6

/* anonymous class */
    class SPBrandEngageClient._cls6 extends SPWebClient
    {

        final SPBrandEngageClient this$0;

        protected Activity getHostActivity()
        {
            return SPBrandEngageClient.access$16(SPBrandEngageClient.this);
        }

        protected void onPlayStoreNotFound()
        {
            SPBrandEngageClient.access$2(SPBrandEngageClient.this, SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.ERROR_PLAY_STORE_UNAVAILABLE));
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("onReceivedError url - ")).append(s1).append(" - ").append(s).toString());
            if (SPBrandEngageClient.access$0(SPBrandEngageClient.this) == SPBrandEngageOffersStatus.QUERYING_SERVER_FOR_OFFERS)
            {
                SPBrandEngageClient.access$8(SPBrandEngageClient.this, SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.ERROR);
                SPBrandEngageClient.access$9(SPBrandEngageClient.this);
            } else
            {
                SPBrandEngageClient.access$2(SPBrandEngageClient.this, SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.MBE_ERROR_DIALOG_MESSAGE_DEFAULT));
            }
            super.onReceivedError(webview, i, s, s1);
        }

        protected void onSponsorPayExitScheme(int i, String s)
        {
            Activity activity = getHostActivity();
            if (activity == null)
            {
                return;
            } else
            {
                activity.setResult(i);
                launchActivityWithUrl(s);
                return;
            }
        }

        protected void onTargetActivityStart(String s)
        {
            SPBrandEngageClient.access$14(SPBrandEngageClient.this, "USER_ENGAGED");
            SPBrandEngageClient.access$8(SPBrandEngageClient.this, SPBrandEngageClientStatusListener.SPBrandEngageClientStatus.PENDING_CLOSE);
        }

        protected void processSponsorPayScheme(String s, Uri uri)
        {
            if (s.equals("requestOffers"))
            {
                SPBrandEngageClient.access$3(SPBrandEngageClient.this, Integer.parseInt(uri.getQueryParameter("n")));
            } else
            {
                if (s.equals("start"))
                {
                    SPBrandEngageClient.access$14(SPBrandEngageClient.this, uri.getQueryParameter("status"));
                    return;
                }
                if (s.equals("validate"))
                {
                    s = uri.getQueryParameter("tpn");
                    SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("MBE client asks to validate a third party network: ")).append(s).toString());
                    HashMap hashmap = new HashMap(1);
                    hashmap.put("id", uri.getQueryParameter("id"));
                    SPMediationCoordinator.INSTANCE.validateVideoNetwork(SPBrandEngageClient.access$12(SPBrandEngageClient.this), s, hashmap, new SPBrandEngageClient._cls6._cls1());
                    return;
                }
                if (s.equals("play"))
                {
                    s = uri.getQueryParameter("tpn");
                    HashMap hashmap1 = new HashMap(1);
                    hashmap1.put("id", uri.getQueryParameter("id"));
                    SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("MBE client asks to play an offer from a third party network:")).append(s).toString());
                    SPMediationCoordinator.INSTANCE.startVideoEngagement(SPBrandEngageClient.access$16(SPBrandEngageClient.this), s, hashmap1, new SPBrandEngageClient._cls6._cls2());
                    return;
                }
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (s.contains("youtube.com"))
            {
                SponsorPayLogger.d("SPBrandEngageClient", "Preventing Youtube app");
                return true;
            } else
            {
                return super.shouldOverrideUrlLoading(webview, s);
            }
        }


            
            {
                this$0 = SPBrandEngageClient.this;
                super(activity);
            }

        // Unreferenced inner class com/sponsorpay/publisher/mbe/SPBrandEngageClient$6$1

/* anonymous class */
        class SPBrandEngageClient._cls6._cls1
            implements SPMediationValidationEvent
        {

            final SPBrandEngageClient._cls6 this$1;

            public void validationEventResult(String s, SPTPNVideoValidationResult sptpnvideovalidationresult, Map map)
            {
                s = String.format("%s('validate', {tpn:'%s', id:%s, result:'%s'})", new Object[] {
                    "javascript:Sponsorpay.MBE.SDKInterface.notify", s, map.get("id"), sptpnvideovalidationresult
                });
                SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("Notifying - ")).append(s).toString());
                SPBrandEngageClient.access$15(this$0, s);
            }

                    
                    {
                        this$1 = SPBrandEngageClient._cls6.this;
                        super();
                    }
        }

    }

}
