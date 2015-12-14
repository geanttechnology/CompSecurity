// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

public class aql extends AsyncTask
{

    int a;
    int b;
    private aqm c;
    private String d;

    public aql(String s)
    {
        a = 5000;
        b = 5000;
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
            return null;
        }
        return as;
    }

    public void a(aqm aqm1)
    {
        c = aqm1;
    }

    protected void a(String s)
    {
        super.onPostExecute(s);
        if (c != null)
        {
            c.a(s);
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
