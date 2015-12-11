// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.GetProductService;
import com.abtnprojects.ambatana.datasource.api.c;
import com.abtnprojects.ambatana.models.product.ApiProduct;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            aqo

public class dj
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(ApiProduct apiproduct);
    }


    private final GetProductService a;
    private boolean b;

    public dj(String s)
    {
        a = c.h(s);
    }

    static boolean a(dj dj1, boolean flag)
    {
        dj1.b = flag;
        return flag;
    }

    public void a(String s, a a1)
    {
        if (b)
        {
            return;
        }
        b = true;
        try
        {
            a.getProduct(s, new Callback(a1) {

                final a a;
                final dj b;

                public void a(ApiProduct apiproduct, Response response)
                {
                    dj.a(b, false);
                    a.a(apiproduct);
                }

                public void failure(RetrofitError retrofiterror)
                {
                    aqo.a(retrofiterror, "Error getProducts from %s", new Object[] {
                        retrofiterror.getUrl()
                    });
                    dj.a(b, false);
                    a.a();
                }

                public void success(Object obj, Response response)
                {
                    a((ApiProduct)obj, response);
                }

            
            {
                b = dj.this;
                a = a1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.b(s, "Error getProducts", new Object[0]);
        }
    }
}
