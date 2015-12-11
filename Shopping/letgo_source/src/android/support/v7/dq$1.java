// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            dq, aqo

class c
    implements Callback
{

    final  a;
    final String b;
    final String c;
    final dq d;

    public void a(String s, Response response)
    {
        dq.a(d, false);
        a.a();
    }

    public void failure(RetrofitError retrofiterror)
    {
        dq.a(d, false);
        aqo.b(retrofiterror, "Error reporting : userId : %s, productId : %s", new Object[] {
            b, c
        });
        a.b();
    }

    public void success(Object obj, Response response)
    {
        a((String)obj, response);
    }

    (dq dq1,  , String s, String s1)
    {
        d = dq1;
        a = ;
        b = s;
        c = s1;
        super();
    }
}
