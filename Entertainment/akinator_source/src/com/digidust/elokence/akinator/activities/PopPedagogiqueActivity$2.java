// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Context;
import android.os.AsyncTask;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.supersonicads.sdk.SSAPublisher;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            PopPedagogiqueActivity

class applicationKey extends AsyncTask
{

    final String applicationKey;
    String applicationUserId;
    Map paramsSSA;
    final PopPedagogiqueActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        AkLog.d("AkinatorUnlock", "Supersonic background");
        paramsSSA.put("useClientSideCallbacks", "true");
        applicationUserId = android.provider.(getApplicationContext().getContentResolver(), "android_id");
        try
        {
            applicationUserId = AdvertisingIdClient.getAdvertisingIdInfo(PopPedagogiqueActivity.this).getId();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            AkLog.e("AkinatorUnlock", (new StringBuilder()).append("Google AdvertisingId pas r\351cup\351r\351 (IOE) : ").append(avoid).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            AkLog.e("AkinatorUnlock", (new StringBuilder()).append("Google AdvertisingId pas r\351cup\351r\351 (ISE) : ").append(avoid).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            AkLog.e("AkinatorUnlock", (new StringBuilder()).append("Google AdvertisingId pas r\351cup\351r\351 (notAvailable) : ").append(avoid).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            AkLog.e("AkinatorUnlock", (new StringBuilder()).append("Google AdvertisingId pas r\351cup\351r\351 (repairable) : ").append(avoid).toString());
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        AkLog.d("AkinatorUnlock", "Supersonic PostExec");
        mSSAPublisher.showOfferWall(applicationKey, applicationUserId, paramsSSA, PopPedagogiqueActivity.this);
    }

    ()
    {
        this$0 = PopPedagogiqueActivity.this;
        super();
        paramsSSA = new TreeMap();
        if (AkConfigFactory.sharedInstance().isPaid())
        {
            poppedagogiqueactivity = "39253b09";
        } else
        {
            poppedagogiqueactivity = "2c86277d";
        }
        applicationKey = PopPedagogiqueActivity.this;
    }
}
