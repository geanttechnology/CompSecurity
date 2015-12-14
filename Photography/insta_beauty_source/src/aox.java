// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ProgressDialog;
import android.util.Log;
import com.fotoable.comlib.util.AsyncTask;
import com.fotoable.geocoderlib.enums.GeocodingStatus;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONObject;

class aox extends AsyncTask
{

    final aov a;

    private aox(aov aov1)
    {
        a = aov1;
        super();
    }

    aox(aov aov1, aow aow)
    {
        this(aov1);
    }

    protected transient aot a(Void avoid[])
    {
        avoid = new aot();
        Object obj;
        obj = new DefaultHttpClient();
        Object obj1 = new HttpGet(aov.a(a));
        org.apache.http.params.HttpParams httpparams = ((DefaultHttpClient) (obj)).getParams();
        HttpConnectionParams.setConnectionTimeout(httpparams, aov.b(a).d());
        HttpConnectionParams.setSoTimeout(httpparams, aov.b(a).e());
        obj = (String)((DefaultHttpClient) (obj)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)), new BasicResponseHandler());
        Log.d("response", ((String) (obj)));
        obj = new JSONObject(((String) (obj)));
        obj1 = aop.a(((JSONObject) (obj)).getString("status"));
        avoid.a(((GeocodingStatus) (obj1)));
        aov.c(a).a(((GeocodingStatus) (obj1)));
        if (obj1 == GeocodingStatus.OK)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        if (obj1 == GeocodingStatus.ZERO_RESULTS)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        aov.a(a, true);
        aov.c(a).a(aop.a(((GeocodingStatus) (obj1))));
        return null;
        aov.a(a, true);
        aov.c(a).a();
        return null;
        int k;
        obj = ((JSONObject) (obj)).getJSONArray("results");
        k = ((JSONArray) (obj)).length();
        Log.d("", (new StringBuilder()).append("Found results: ").append(k).toString());
        int i = 0;
_L9:
        if (i >= k) goto _L2; else goto _L1
_L1:
        aoq aoq1;
        JSONArray jsonarray;
        Object obj2;
        obj2 = ((JSONArray) (obj)).getJSONObject(i);
        aoq1 = new aoq();
        aoq1.a(((JSONObject) (obj2)).getString("formatted_address"));
        aoq1.a(aop.c(((JSONObject) (obj2)).get("types").toString()));
        if (((JSONObject) (obj2)).has("partial_match"))
        {
            aoq1.a(((JSONObject) (obj2)).getString("partial_match").equalsIgnoreCase("true"));
        }
        jsonarray = ((JSONObject) (obj2)).getJSONArray("address_components");
        int j = 0;
_L4:
        if (j >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = jsonarray.getJSONObject(j);
        aoz aoz1 = new aoz();
        String s = jsonobject.getString("long_name");
        String s1 = jsonobject.getString("short_name");
        aoz1.a(s);
        aoz1.b(s1);
        aoz1.a(aop.c(jsonobject.get("types").toString()));
        aoq1.a(aoz1);
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        apa apa1 = new apa();
        JSONObject jsonobject1 = ((JSONObject) (obj2)).getJSONObject("geometry");
        obj2 = jsonobject1.getJSONObject("location");
        apa1.a(((JSONObject) (obj2)).getDouble("lat"));
        apa1.b(((JSONObject) (obj2)).getDouble("lng"));
        apa1.a(aop.b(jsonobject1.getString("location_type")));
        obj2 = new apb();
        jsonobject1 = jsonobject1.getJSONObject("viewport");
        JSONObject jsonobject2 = jsonobject1.getJSONObject("southwest");
        ((apb) (obj2)).a(jsonobject2.getDouble("lat"));
        ((apb) (obj2)).b(jsonobject2.getDouble("lng"));
        jsonobject1 = jsonobject1.getJSONObject("northeast");
        ((apb) (obj2)).c(jsonobject1.getDouble("lat"));
        ((apb) (obj2)).d(jsonobject1.getDouble("lng"));
        apa1.a(((apb) (obj2)));
        aoq1.a(apa1);
        if (aov.b(a).f().size() <= 0 || !aoq1.b(aov.b(a).f())) goto _L6; else goto _L5
_L5:
        Log.d("", "accuracies size is normal");
        if (aov.d(a).size() == 0)
        {
            avoid.a(aoq1);
            break MISSING_BLOCK_LABEL_818;
        }
        Throwable throwable;
        if (aov.d(a).contains(aoq1.e()) && aoq1.e().equalsIgnoreCase(aov.e(a)))
        {
            Log.d("", "country added && it's correct with an item");
            avoid.a(aoq1);
            break MISSING_BLOCK_LABEL_818;
        }
        try
        {
            Log.d("", "country not in list");
            break MISSING_BLOCK_LABEL_818;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            if ((throwable instanceof UnknownHostException) || (throwable instanceof IOException))
            {
                aov.a(a, true);
                aov.c(a).b();
            } else
            {
                aov.a(a, true);
                aov.c(a).a("Some error beat us.");
            }
        }
          goto _L7
_L2:
        return avoid;
_L7:
        if (true) goto _L2; else goto _L6
_L6:
        if (aov.b(a).f().size() == 0)
        {
            Log.d("", "accuracies size is 0");
            avoid.a(aoq1);
            break MISSING_BLOCK_LABEL_818;
        }
        Log.d("", "error with accuracies");
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void a(aot aot1)
    {
        super.onPostExecute(aot1);
        if (aov.h(a) != null && aov.h(a).isShowing())
        {
            aov.h(a).dismiss();
        }
        if (aov.i(a))
        {
            return;
        }
        if (aot1 == null)
        {
            aov.c(a).a("Result is null");
            return;
        }
        if (aot1.a() > 0)
        {
            aov.c(a).a(aot1.a(0));
            return;
        } else
        {
            aov.c(a).a();
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((aot)obj);
    }

    protected void onPreExecute()
    {
        if (aov.f(a) && aov.g(a) != null)
        {
            aov.a(a, ProgressDialog.show(aov.g(a), "", "Validating address..."));
        }
        super.onPreExecute();
    }
}
