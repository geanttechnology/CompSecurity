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

class jr extends AsyncTask
{

    final jq a;

    private jr(jq jq1)
    {
        a = jq1;
        super();
    }

    jr(jq jq1, jq._cls1 _pcls1)
    {
        this(jq1);
    }

    protected transient jo a(Void avoid[])
    {
        avoid = new jo();
        Object obj;
        obj = new DefaultHttpClient();
        Object obj1 = new HttpGet(jq.a(a));
        org.apache.http.params.HttpParams httpparams = ((DefaultHttpClient) (obj)).getParams();
        HttpConnectionParams.setConnectionTimeout(httpparams, jq.b(a).d());
        HttpConnectionParams.setSoTimeout(httpparams, jq.b(a).e());
        obj = (String)((DefaultHttpClient) (obj)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)), new BasicResponseHandler());
        Log.d("response", ((String) (obj)));
        obj = new JSONObject(((String) (obj)));
        obj1 = jk.a(((JSONObject) (obj)).getString("status"));
        avoid.a(((GeocodingStatus) (obj1)));
        jq.c(a).a(((GeocodingStatus) (obj1)));
        if (obj1 == GeocodingStatus.OK)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        if (obj1 == GeocodingStatus.ZERO_RESULTS)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        jq.a(a, true);
        jq.c(a).a(jk.a(((GeocodingStatus) (obj1))));
        return null;
        jq.a(a, true);
        jq.c(a).a();
        return null;
        int k;
        obj = ((JSONObject) (obj)).getJSONArray("results");
        k = ((JSONArray) (obj)).length();
        Log.d("", (new StringBuilder()).append("Found results: ").append(k).toString());
        int i = 0;
_L9:
        if (i >= k) goto _L2; else goto _L1
_L1:
        jl jl1;
        JSONArray jsonarray;
        Object obj2;
        obj2 = ((JSONArray) (obj)).getJSONObject(i);
        jl1 = new jl();
        jl1.a(((JSONObject) (obj2)).getString("formatted_address"));
        jl1.a(jk.c(((JSONObject) (obj2)).get("types").toString()));
        if (((JSONObject) (obj2)).has("partial_match"))
        {
            jl1.a(((JSONObject) (obj2)).getString("partial_match").equalsIgnoreCase("true"));
        }
        jsonarray = ((JSONObject) (obj2)).getJSONArray("address_components");
        int j = 0;
_L4:
        if (j >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = jsonarray.getJSONObject(j);
        jt jt1 = new jt();
        String s = jsonobject.getString("long_name");
        String s1 = jsonobject.getString("short_name");
        jt1.a(s);
        jt1.b(s1);
        jt1.a(jk.c(jsonobject.get("types").toString()));
        jl1.a(jt1);
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        ju ju1 = new ju();
        JSONObject jsonobject1 = ((JSONObject) (obj2)).getJSONObject("geometry");
        obj2 = jsonobject1.getJSONObject("location");
        ju1.a(((JSONObject) (obj2)).getDouble("lat"));
        ju1.b(((JSONObject) (obj2)).getDouble("lng"));
        ju1.a(jk.b(jsonobject1.getString("location_type")));
        obj2 = new jv();
        jsonobject1 = jsonobject1.getJSONObject("viewport");
        JSONObject jsonobject2 = jsonobject1.getJSONObject("southwest");
        ((jv) (obj2)).a(jsonobject2.getDouble("lat"));
        ((jv) (obj2)).b(jsonobject2.getDouble("lng"));
        jsonobject1 = jsonobject1.getJSONObject("northeast");
        ((jv) (obj2)).c(jsonobject1.getDouble("lat"));
        ((jv) (obj2)).d(jsonobject1.getDouble("lng"));
        ju1.a(((jv) (obj2)));
        jl1.a(ju1);
        if (jq.b(a).f().size() <= 0 || !jl1.b(jq.b(a).f())) goto _L6; else goto _L5
_L5:
        Log.d("", "accuracies size is normal");
        if (jq.d(a).size() == 0)
        {
            avoid.a(jl1);
            break MISSING_BLOCK_LABEL_818;
        }
        Throwable throwable;
        if (jq.d(a).contains(jl1.e()) && jl1.e().equalsIgnoreCase(jq.e(a)))
        {
            Log.d("", "country added && it's correct with an item");
            avoid.a(jl1);
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
                jq.a(a, true);
                jq.c(a).b();
            } else
            {
                jq.a(a, true);
                jq.c(a).a("Some error beat us.");
            }
        }
          goto _L7
_L2:
        return avoid;
_L7:
        if (true) goto _L2; else goto _L6
_L6:
        if (jq.b(a).f().size() == 0)
        {
            Log.d("", "accuracies size is 0");
            avoid.a(jl1);
            break MISSING_BLOCK_LABEL_818;
        }
        Log.d("", "error with accuracies");
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void a(jo jo1)
    {
        super.onPostExecute(jo1);
        if (jq.h(a) != null && jq.h(a).isShowing())
        {
            jq.h(a).dismiss();
        }
        if (jq.i(a))
        {
            return;
        }
        if (jo1 == null)
        {
            jq.c(a).a("Result is null");
            return;
        }
        if (jo1.a() > 0)
        {
            jq.c(a).a(jo1.a(0));
            return;
        } else
        {
            jq.c(a).a();
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((jo)obj);
    }

    protected void onPreExecute()
    {
        if (jq.f(a) && jq.g(a) != null)
        {
            jq.a(a, ProgressDialog.show(jq.g(a), "", "Validating address..."));
        }
        super.onPreExecute();
    }
}
