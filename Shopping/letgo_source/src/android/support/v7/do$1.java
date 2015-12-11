// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            do, aqo

class a
    implements Callback
{

    final  a;
    final do b;

    public void a(String s, Response response)
    {
        android.support.v7.do.a(b, false);
        a.a();
    }

    public void failure(RetrofitError retrofiterror)
    {
        android.support.v7.do.a(b, false);
        aqo.b(retrofiterror, "Error marking as sold", new Object[0]);
        a.b();
    }

    public void success(Object obj, Response response)
    {
        a((String)obj, response);
    }

    (do do1,  )
    {
        b = do1;
        a = ;
        super();
    }
}
