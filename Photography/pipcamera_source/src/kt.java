// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

public class kt extends AsyncTask
{

    int a;
    int b;
    private ku c;
    private String d;

    public kt(String s)
    {
        a = 1000;
        b = 1000;
        d = s;
    }

    protected transient String a(String as[])
    {
        try
        {
            as = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(d);
            org.apache.http.params.HttpParams httpparams = as.getParams();
            HttpConnectionParams.setConnectionTimeout(httpparams, a);
            HttpConnectionParams.setSoTimeout(httpparams, b);
            as = (String)as.execute(httpget, new BasicResponseHandler());
            Log.d("response", as);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            if (c != null)
            {
                c.a(as);
            }
            Crashlytics.logException(as);
            return null;
        }
        return as;
    }

    protected void a(String s)
    {
        super.onPostExecute(s);
        if (c != null)
        {
            c.a(s);
        }
    }

    public void a(ku ku1)
    {
        c = ku1;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }
}
