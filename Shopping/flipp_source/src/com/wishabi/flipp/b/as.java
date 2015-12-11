// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import com.wishabi.flipp.content.SimpleSearchResult;
import java.util.Locale;

// Referenced classes of package com.wishabi.flipp.b:
//            ak, at

public class as extends AsyncTask
{

    private final String a;
    private final String b;
    private final Context c;
    public boolean d;
    private final int e = 60000;
    private Handler f;
    private Runnable g;

    public as(String s, String s1, Context context)
    {
        a = s;
        b = s1;
        c = context;
    }

    static boolean a(as as1)
    {
        as1.d = true;
        return true;
    }

    public void a(SimpleSearchResult simplesearchresult)
    {
        if (f == null || g == null)
        {
            return;
        } else
        {
            f.removeCallbacks(g);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        aobj = Uri.parse("https://backflipp.wishabi.com/flipp/items/count").buildUpon();
        ((android.net.Uri.Builder) (aobj)).appendQueryParameter("postal_code", a);
        ((android.net.Uri.Builder) (aobj)).appendQueryParameter("locale", Locale.getDefault().toString());
        ((android.net.Uri.Builder) (aobj)).appendQueryParameter("q", b);
        aobj = ((android.net.Uri.Builder) (aobj)).build();
        String s = b;
        if (aobj != null)
        {
            if ((aobj = ak.a(((Uri) (aobj)))) != null)
            {
                return SimpleSearchResult.a(((org.json.JSONObject) (aobj)));
            }
        }
        return null;
    }

    public void onPostExecute(Object obj)
    {
        a((SimpleSearchResult)obj);
    }

    protected void onPreExecute()
    {
        f = new Handler(c.getMainLooper());
        g = new at(this);
        f.postDelayed(g, e);
    }
}
