// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.fotoable.comlib.util.AsyncTask;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

class app extends AsyncTask
{

    final apn a;

    private app(apn apn1)
    {
        a = apn1;
        super();
    }

    app(apn apn1, apo apo)
    {
        this(apn1);
    }

    protected transient Integer a(Void avoid[])
    {
        Object obj = azn.b();
        Log.v(apn.a(a), (new StringBuilder()).append(apn.a(a)).append("requestURL: ").append(((String) (obj))).toString());
        int i;
        try
        {
            avoid = new DefaultHttpClient();
            obj = new HttpGet(((String) (obj)));
            org.apache.http.params.HttpParams httpparams = avoid.getParams();
            HttpConnectionParams.setConnectionTimeout(httpparams, 2000);
            HttpConnectionParams.setSoTimeout(httpparams, 2000);
            avoid = (String)avoid.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)), new BasicResponseHandler());
            Log.d(apn.a(a), (new StringBuilder()).append(apn.a(a)).append(" ").append(avoid).toString());
            obj = new JSONObject(avoid);
            if (apn.a(a, ((JSONObject) (obj))))
            {
                apn.b(a).c("json_magrecommend_library");
                apn.b(a).a("json_magrecommend_library", avoid, 600);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        i = apn.c(a).size();
        Log.d(apn.a(a), (new StringBuilder()).append(apn.a(a)).append(" ").append(apn.c(a).size()).toString());
        return Integer.valueOf(i);
    }

    protected void a(Integer integer)
    {
        super.onPostExecute(integer);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Integer)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }
}
