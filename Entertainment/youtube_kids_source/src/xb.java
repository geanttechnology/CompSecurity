// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;
import com.google.android.apps.youtube.kids.activities.DeveloperActivity;
import com.google.android.apps.youtube.kids.application.KidsApplication;

public final class xb extends AsyncTask
{

    private DeveloperActivity a;

    xb(DeveloperActivity developeractivity)
    {
        a = developeractivity;
        super();
    }

    private transient bou a()
    {
        DeveloperActivity.b(a).edit().remove("com.google.android.libraries.youtube.innertube.pref.inner_tube_config").remove("com.google.android.libraries.youtube.innertube.pref.inner_tube_config_last_sync_timestamp").apply();
        try
        {
            DeveloperActivity.d(a).h().S().a();
        }
        catch (bou bou1)
        {
            return bou1;
        }
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (bou)obj;
        if (obj == null)
        {
            DeveloperActivity.d(a).h().O().b(DeveloperActivity.b(a));
            return;
        }
        DeveloperActivity developeractivity = a;
        obj = String.valueOf(((bou) (obj)).getMessage());
        if (((String) (obj)).length() != 0)
        {
            obj = "InnerTube Config request failed! ".concat(((String) (obj)));
        } else
        {
            obj = new String("InnerTube Config request failed! ");
        }
        Toast.makeText(developeractivity, ((CharSequence) (obj)), 1).show();
    }
}
