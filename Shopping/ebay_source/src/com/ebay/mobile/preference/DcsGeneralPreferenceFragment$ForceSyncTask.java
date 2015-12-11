// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.app.Activity;
import android.os.AsyncTask;
import android.preference.Preference;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.mobile.preference:
//            DcsGeneralPreferenceFragment

private final class <init> extends AsyncTask
{

    final DcsGeneralPreferenceFragment this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Boolean[])aobj);
    }

    protected transient Void doInBackground(Boolean aboolean[])
    {
        dc.refresh(aboolean[0].booleanValue(), Boolean.valueOf(true));
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        forceSyncTask = null;
        void1 = getActivity();
        if (void1 == null || void1.isFinishing())
        {
            return;
        } else
        {
            findPreference("force_sync").setSummary(getLastSyncedSummary());
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        findPreference("force_sync").setSummary("Syncing...");
    }

    private ()
    {
        this$0 = DcsGeneralPreferenceFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
