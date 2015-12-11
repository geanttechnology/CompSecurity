// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.net.Uri;
import android.os.AsyncTask;
import com.wishabi.flipp.content.FlyerInfo;
import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.wishabi.flipp.b:
//            ak

public class aa extends AsyncTask
{

    private final int a;
    private final String b;
    private final Double c;
    private final Double d;

    public aa(int i, String s, Double double1, Double double2)
    {
        a = i;
        b = s;
        c = double1;
        d = double2;
    }

    protected Object doInBackground(Object aobj[])
    {
        aobj = Uri.parse("https://backflipp.wishabi.com/flipp/flyers").buildUpon();
        ((android.net.Uri.Builder) (aobj)).appendEncodedPath(Integer.toString(a));
        ((android.net.Uri.Builder) (aobj)).appendEncodedPath("info");
        ((android.net.Uri.Builder) (aobj)).appendQueryParameter("postal_code", b);
        ((android.net.Uri.Builder) (aobj)).appendQueryParameter("locale", Locale.getDefault().toString());
        if (c != null && d != null)
        {
            ((android.net.Uri.Builder) (aobj)).appendQueryParameter("lat", String.valueOf(c));
            ((android.net.Uri.Builder) (aobj)).appendQueryParameter("lon", String.valueOf(d));
        }
        aobj = ((android.net.Uri.Builder) (aobj)).build();
        if (aobj != null)
        {
            if ((aobj = ak.a(((Uri) (aobj)))) != null && (aobj = ((JSONObject) (aobj)).optJSONObject("info")) != null)
            {
                return FlyerInfo.a(((JSONObject) (aobj)));
            }
        }
        return null;
    }
}
