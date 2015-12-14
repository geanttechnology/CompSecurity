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

public class kj extends AsyncTask
{

    int a;
    int b;
    private kk c;
    private String d;

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
            Crashlytics.logException(as);
            if (c != null)
            {
                c.a(as);
            }
            return null;
        }
        return as;
    }

    protected void a(String s)
    {
        super.onPostExecute(s);
        if (c != null)
        {
            c.a(d, s);
        }
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
