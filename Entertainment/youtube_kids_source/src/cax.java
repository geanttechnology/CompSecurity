// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.net.Uri;
import java.util.Arrays;
import java.util.List;

public final class cax
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener, bzm
{

    private Uri a;
    private Uri b;
    private final SharedPreferences c;

    public cax(SharedPreferences sharedpreferences)
    {
        (new android.net.Uri.Builder()).scheme("http").authority("uploads.gdata.youtube.com").build();
        b.a(sharedpreferences);
        c = sharedpreferences;
        c.registerOnSharedPreferenceChangeListener(this);
    }

    public final Uri a()
    {
        if (a == null)
        {
            android.net.Uri.Builder builder = (new android.net.Uri.Builder()).scheme("http");
            String s = c.getString("gdata_hostname", "gdata.youtube.com");
            if (!Arrays.asList(new String[] {
    "gdata.youtube.com", "stage.gdata.youtube.com", "dev.gdata.youtube.com"
}).contains(s))
            {
                s = "gdata.youtube.com";
            }
            a = builder.authority(s).appendPath("feeds").appendPath("api").build();
        }
        return a;
    }

    public final Uri b()
    {
        if (b == null)
        {
            b = a().buildUpon().scheme("https").build();
        }
        return b;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if ("gdata_hostname".equals(s))
        {
            a = null;
            b = null;
        }
    }
}
