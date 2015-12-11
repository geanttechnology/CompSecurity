// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.AsyncTask;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;

// Referenced classes of package jumiomobile:
//            ap, ab, as

class aq extends AsyncTask
{

    final Exception a[];
    final ap b;

    aq(ap ap1, Exception aexception[])
    {
        b = ap1;
        a = aexception;
        super();
    }

    protected transient Boolean a(String as1[])
    {
        as1 = (HttpURLConnection)(new URL(as1[0])).openConnection();
        as1.setDoInput(true);
        as1.connect();
        boolean flag;
        if (as1.getResponseCode() == 200)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
        as1;
        a[0] = as1;
        ab.a(jumiomobile/ap.getSimpleName(), as1);
        return Boolean.valueOf(false);
    }

    protected void a(Boolean boolean1)
    {
        if (ap.b(b) != null)
        {
            ab.d("DownloadTask", "killing timer");
            ap.b(b).cancel();
            ap.b(b).purge();
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    protected void onPreExecute()
    {
        ap.b(b).schedule(new as(b, this), ap.a(b));
        ab.d("DownloadTask", (new StringBuilder("started timer at ")).append(ap.a(b)).append(" s").toString());
        super.onPreExecute();
    }
}
