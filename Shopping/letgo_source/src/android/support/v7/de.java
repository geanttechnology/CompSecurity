// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.FavoriteReportedService;
import com.abtnprojects.ambatana.datasource.api.c;
import com.abtnprojects.ambatana.models.product.ApiFavoriteReported;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            aqo

public class de
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(ApiFavoriteReported apifavoritereported);
    }


    private FavoriteReportedService a;
    private boolean b;

    public de(String s)
    {
        a = c.l(s);
        b = false;
    }

    static boolean a(de de1, boolean flag)
    {
        de1.b = flag;
        return flag;
    }

    public void a(String s, String s1, a a1)
    {
        if (b)
        {
            return;
        }
        b = true;
        try
        {
            a.getFavoriteReported(s, s1, new Callback(a1, s, s1) {

                final a a;
                final String b;
                final String c;
                final de d;

                public void a(ApiFavoriteReported apifavoritereported, Response response)
                {
                    de.a(d, false);
                    a.a(apifavoritereported);
                }

                public void failure(RetrofitError retrofiterror)
                {
                    aqo.b(retrofiterror, "getFavoriteReported: productId: %s, userId: %s, url: %s", new Object[] {
                        b, c, retrofiterror.getUrl()
                    });
                    de.a(d, false);
                    a.a();
                }

                public void success(Object obj, Response response)
                {
                    a((ApiFavoriteReported)obj, response);
                }

            
            {
                d = de.this;
                a = a1;
                b = s;
                c = s1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            b = false;
        }
        aqo.b(s1, "Error getting favorite and reported for productId: %s", new Object[] {
            s
        });
    }
}
