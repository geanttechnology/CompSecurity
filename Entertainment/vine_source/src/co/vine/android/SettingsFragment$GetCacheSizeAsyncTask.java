// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.AsyncTask;
import android.widget.TextView;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            SettingsFragment

public class this._cls0 extends AsyncTask
{

    final SettingsFragment this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        try
        {
            avoid = Util.formatFileSize(getResources(), Util.getCacheSize(getActivity()));
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            CrashUtil.logException(avoid);
            return null;
        }
        return avoid;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        if (s != null)
        {
            SettingsFragment.access$000(SettingsFragment.this).setText(s);
        }
    }

    public ()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
