// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.network.http.rest.account.AccountDetails;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;

// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            FTUEScreen, AccountDetailsListener

public abstract class FTUEPrimeBenefitScreen extends FTUEScreen
    implements AccountDetailsListener
{

    private Endpoint endpoint;
    private boolean hasPrimeBenefit;
    private ImageView primeBenefitLogo;
    private View primeBenefitView;

    public FTUEPrimeBenefitScreen()
    {
        hasPrimeBenefit = false;
    }

    private static int getPrimeDrawable(Endpoint endpoint1)
    {
        if (endpoint1 != null)
        {
            endpoint1 = endpoint1.getExactMarketplace();
            if (endpoint1 == com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.FRANCE || endpoint1 == com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.SPAIN)
            {
                return 0x7f02003f;
            }
        }
        return 0x7f0201e0;
    }

    private void tryToSetPrimeLogo()
    {
        if (primeBenefitLogo != null && activity != null)
        {
            activity.runOnUiThread(new Runnable() {

                final FTUEPrimeBenefitScreen this$0;

                public void run()
                {
                    primeBenefitLogo.setImageResource(FTUEPrimeBenefitScreen.getPrimeDrawable(endpoint));
                }

            
            {
                this$0 = FTUEPrimeBenefitScreen.this;
                super();
            }
            });
        }
    }

    private void updatePrimeVisibility()
    {
        int i;
        if (hasPrimeBenefit)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        primeBenefitView.setVisibility(i);
    }

    public void onAccountDetailsReceived(AccountDetails accountdetails)
    {
        boolean flag;
        if (accountdetails != null && accountdetails.hasBenefit("CDSPB00001"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasPrimeBenefit = flag;
        accountdetails = getActivity();
        if (accountdetails != null && primeBenefitView != null)
        {
            accountdetails.runOnUiThread(new Runnable() {

                final FTUEPrimeBenefitScreen this$0;

                public void run()
                {
                    updatePrimeVisibility();
                }

            
            {
                this$0 = FTUEPrimeBenefitScreen.this;
                super();
            }
            });
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        GlobalMessagingBus.register(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        primeBenefitView = layoutinflater.findViewById(0x7f0c01c2);
        primeBenefitLogo = (ImageView)primeBenefitView.findViewById(0x7f0c0125);
        tryToSetPrimeLogo();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        GlobalMessagingBus.unregister(this);
    }

    public void onEndpointLoaded(Endpoint endpoint1)
    {
        endpoint = endpoint1;
        tryToSetPrimeLogo();
    }

    public void onResume()
    {
        super.onResume();
        updatePrimeVisibility();
    }




}
