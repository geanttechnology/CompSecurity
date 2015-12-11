// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            dc, aqo

class a
    implements Callback
{

    final  a;
    final dc b;

    public void a(String s, Response response)
    {
        aqo.a("deleteProduct : url %s", new Object[] {
            response.getUrl()
        });
        dc.a(b, false);
        a.a();
    }

    public void failure(RetrofitError retrofiterror)
    {
        aqo.d("deleteProduct error : url %s", new Object[] {
            retrofiterror.getUrl()
        });
        dc.a(b, false);
        a.b();
    }

    public void success(Object obj, Response response)
    {
        a((String)obj, response);
    }

    (dc dc1,  )
    {
        b = dc1;
        a = ;
        super();
    }
}
