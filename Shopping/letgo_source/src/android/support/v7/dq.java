// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.ReportProductService;
import com.abtnprojects.ambatana.datasource.api.a;
import com.abtnprojects.ambatana.datasource.api.c;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            aqo

public class dq
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }


    private final ReportProductService a;
    private boolean b;

    public dq(String s)
    {
        a = c.g(s);
    }

    static boolean a(dq dq1, boolean flag)
    {
        dq1.b = flag;
        return flag;
    }

    public void a(String s, String s1, a a1)
    {
        if (!b)
        {
            b = true;
            a.reportProduct(s, s1, com.abtnprojects.ambatana.datasource.api.a.a, new Callback(a1, s, s1) {

                final a a;
                final String b;
                final String c;
                final dq d;

                public void a(String s2, Response response)
                {
                    android.support.v7.dq.a(d, false);
                    a.a();
                }

                public void failure(RetrofitError retrofiterror)
                {
                    android.support.v7.dq.a(d, false);
                    aqo.b(retrofiterror, "Error reporting : userId : %s, productId : %s", new Object[] {
                        b, c
                    });
                    a.b();
                }

                public void success(Object obj, Response response)
                {
                    a((String)obj, response);
                }

            
            {
                d = dq.this;
                a = a1;
                b = s;
                c = s1;
                super();
            }
            });
        }
    }
}
