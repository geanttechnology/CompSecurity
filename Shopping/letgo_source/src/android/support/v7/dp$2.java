// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import org.json.JSONObject;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            dp, aqo

class a
    implements Callback
{

    final  a;
    final dp b;

    public void a(JSONObject jsonobject, Response response)
    {
        dp.a(b, false);
        a.b();
    }

    public void failure(RetrofitError retrofiterror)
    {
        dp.a(b, false);
        aqo.b(retrofiterror, "Error deleteFavorite", new Object[0]);
        a.a();
    }

    public void success(Object obj, Response response)
    {
        a((JSONObject)obj, response);
    }

    (dp dp1,  )
    {
        b = dp1;
        a = ;
        super();
    }
}
