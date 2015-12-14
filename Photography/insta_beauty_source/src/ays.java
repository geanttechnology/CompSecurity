// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.fotoable.comlib.util.AsyncTask;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

public class ays extends AsyncTask
{

    int a;
    int b;
    private ayt c;
    private String d;
    private String e;

    public ays()
    {
        a = 5000;
        b = 5000;
        d = "";
        e = "";
    }

    protected transient JSONObject a(String as[])
    {
        if (as.length < 2)
        {
            Log.v("WeatherManagerRequestTask", "WeatherManagerRequestTaskparameters error");
            return null;
        }
        d = as[0];
        e = as[1];
        as = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(d);
        org.apache.http.params.HttpParams httpparams = as.getParams();
        HttpConnectionParams.setConnectionTimeout(httpparams, a);
        HttpConnectionParams.setSoTimeout(httpparams, b);
        as = (String)as.execute(httpget, new BasicResponseHandler());
        Log.d("response", as);
        try
        {
            as = new JSONObject(as);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            try
            {
                as.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                as.printStackTrace();
            }
            as = null;
        }
        return as;
    }

    public void a(ayt ayt1)
    {
        c = ayt1;
    }

    protected void a(JSONObject jsonobject)
    {
        super.onPostExecute(jsonobject);
        if (c != null)
        {
            c.a(jsonobject, e);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((JSONObject)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }
}
