// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.preference.Preference;
import com.ebay.nautilus.kernel.EbayIdentity;

// Referenced classes of package com.ebay.mobile.preference:
//            DeveloperPreferenceFragment

private final class pref extends AsyncTask
{

    private final Preference pref;
    final DeveloperPreferenceFragment this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Context[])aobj);
    }

    protected transient String doInBackground(Context acontext[])
    {
        return EbayIdentity.getDeviceIdString(acontext[0]);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing())
        {
            pref.setSummary(s);
        }
    }

    public (Preference preference)
    {
        this$0 = DeveloperPreferenceFragment.this;
        super();
        pref = preference;
    }
}
