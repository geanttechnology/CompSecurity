// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.DeleteProductService;
import com.abtnprojects.ambatana.datasource.api.c;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            aqo

public class dc
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }


    private DeleteProductService a;
    private boolean b;

    public dc(String s)
    {
        a = c.a(s);
        b = false;
    }

    static boolean a(dc dc1, boolean flag)
    {
        dc1.b = flag;
        return flag;
    }

    public void a(String s, a a1)
    {
        if (b)
        {
            return;
        } else
        {
            b = true;
            aqo.a("deleteProduct", new Object[0]);
            a.deleteProduct(s, new Callback(a1) {

                final a a;
                final dc b;

                public void a(String s1, Response response)
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

            
            {
                b = dc.this;
                a = a1;
                super();
            }
            });
            return;
        }
    }
}
