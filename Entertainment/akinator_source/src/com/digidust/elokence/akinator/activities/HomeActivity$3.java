// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.os.AsyncTask;
import com.digidust.elokence.akinator.webservices.AkHomeBannerWS;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity

class this._cls0 extends AsyncTask
{

    final HomeActivity this$0;

    protected transient Integer doInBackground(Void avoid[])
    {
        return Integer.valueOf((new AkHomeBannerWS()).call());
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Integer integer)
    {
        HomeActivity.access$000(HomeActivity.this);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Integer)obj);
    }

    ()
    {
        this$0 = HomeActivity.this;
        super();
    }
}
