// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.os.AsyncTask;
import com.ebay.nautilus.kernel.EbayIdentity;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity

class this._cls0 extends AsyncTask
{

    final ShowWebViewActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return EbayIdentity.getDeviceIdString(getApplicationContext());
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        if (!isFinishing())
        {
            cachedDeviceId = s;
            addDeviceIdToUrl();
            onRefresh();
        }
    }

    ()
    {
        this$0 = ShowWebViewActivity.this;
        super();
    }
}
