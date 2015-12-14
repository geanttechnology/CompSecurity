// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;

public class ul extends AsyncTask
{

    int a;
    int b;
    private String c;
    private ue d;
    private String e;
    private Context f;
    private HashMap g;

    public ul(Context context, String s)
    {
        c = "TMaterialTypeRequestJsonTask";
        a = 5000;
        b = 5000;
        f = context;
        e = s;
    }

    private String a(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L1
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        Crashlytics.logException(ioexception);
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
        }
        return stringbuilder.toString();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
        }
        throw exception;
    }

    protected transient String a(String as[])
    {
        if (e == null || e.length() == 0)
        {
            return "";
        }
        if (a().size() <= 0) goto _L2; else goto _L1
_L1:
        Object obj;
        as = new HttpPost(e);
        obj = new ArrayList();
        HashMap hashmap = a();
        String s;
        for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); ((List) (obj)).add(new BasicNameValuePair(s, (String)hashmap.get(s))))
        {
            s = (String)iterator.next();
        }

          goto _L3
_L8:
        return "";
_L3:
        as.setEntity(new UrlEncodedFormEntity(((List) (obj)), "UTF-8"));
        obj = new DefaultHttpClient();
        org.apache.http.params.HttpParams httpparams = ((DefaultHttpClient) (obj)).getParams();
        HttpConnectionParams.setConnectionTimeout(httpparams, a);
        HttpConnectionParams.setSoTimeout(httpparams, b);
        Log.v(c, (new StringBuilder()).append(c).append(" request url: ").append(e).toString());
        as = ((DefaultHttpClient) (obj)).execute(as);
          goto _L4
_L2:
        as = new HttpGet(e);
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        org.apache.http.params.HttpParams httpparams1 = defaulthttpclient.getParams();
        HttpConnectionParams.setConnectionTimeout(httpparams1, a);
        HttpConnectionParams.setSoTimeout(httpparams1, b);
        as = defaulthttpclient.execute(as);
          goto _L4
_L6:
        int i;
        i = as.getStatusLine().getStatusCode();
        as = as.getEntity();
        Log.v(c, (new StringBuilder()).append(c).append(" responseCode: ").append(i).toString());
        if (i != 200 || as == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        as = a(as.getContent());
        return as;
        as;
        as.printStackTrace();
        return "";
        as;
        try
        {
            as.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            try
            {
                Crashlytics.logException(as);
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                Crashlytics.logException(as);
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (as != null) goto _L6; else goto _L5
_L5:
        return null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public HashMap a()
    {
        if (g == null)
        {
            g = new HashMap();
        }
        return g;
    }

    protected void a(String s)
    {
        super.onPostExecute(s);
        if (d != null)
        {
            d.a(s);
        }
    }

    public void a(String s, String s1)
    {
        a().put(s, s1);
    }

    public void a(ue ue1)
    {
        d = ue1;
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
