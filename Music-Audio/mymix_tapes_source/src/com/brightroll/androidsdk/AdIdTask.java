// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

// Referenced classes of package com.brightroll.androidsdk:
//            Ad, AdDelegate

class AdIdTask extends AsyncTask
{

    Ad ad;
    public String adId;
    public boolean isLimitAdTrackingEnabled;

    AdIdTask()
    {
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            avoid = AdvertisingIdClient.getAdvertisingIdInfo(ad.getDelegate().getAdActivity());
            adId = avoid.getId();
            isLimitAdTrackingEnabled = avoid.isLimitAdTrackingEnabled();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        ad.justFetch();
    }

    public void setAd(Ad ad1)
    {
        ad = ad1;
    }
}
