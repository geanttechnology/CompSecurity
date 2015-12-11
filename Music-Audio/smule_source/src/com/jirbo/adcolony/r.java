// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

// Referenced classes of package com.jirbo.adcolony:
//            bl, bh, q

class r extends AsyncTask
{

    Activity a;
    String b;
    boolean c;

    r(Activity activity)
    {
        b = "";
        a = activity;
    }

    protected transient Void a(Void avoid[])
    {
        try
        {
            avoid = AdvertisingIdClient.getAdvertisingIdInfo(a);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            bl.d.b("Google Play Services SDK not installed! Collecting Android Id instead of Advertising Id.");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            bl.d.b("Google Play Services SDK is out of date! Collecting Android Id instead of Advertising Id.");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            bl.d.b("Advertising Id not available! Collecting Android Id instead of Advertising Id.");
            avoid.printStackTrace();
            return null;
        }
        b = avoid.getId();
        c = avoid.isLimitAdTrackingEnabled();
        return null;
    }

    protected void a(Void void1)
    {
        bh.a = b;
        bh.b = c;
        q.a = true;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }
}
