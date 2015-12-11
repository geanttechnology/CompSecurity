// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.MarkAsSoldService;
import com.abtnprojects.ambatana.datasource.entities.MarkAsSoldEntity;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            aqo

public class do
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }


    private final MarkAsSoldService a;
    private boolean b;
    private final MarkAsSoldEntity c = new MarkAsSoldEntity();

    public do(MarkAsSoldService markassoldservice)
    {
        a = markassoldservice;
    }

    static boolean a(do do1, boolean flag)
    {
        do1.b = flag;
        return flag;
    }

    public void a(String s, a a1)
    {
        if (!b)
        {
            b = true;
            a.markProductAsSold(s, c, new Callback(a1) {

                final a a;
                final do b;

                public void a(String s1, Response response)
                {
                    do.a(b, false);
                    a.a();
                }

                public void failure(RetrofitError retrofiterror)
                {
                    do.a(b, false);
                    aqo.b(retrofiterror, "Error marking as sold", new Object[0]);
                    a.b();
                }

                public void success(Object obj, Response response)
                {
                    a((String)obj, response);
                }

            
            {
                b = do.this;
                a = a1;
                super();
            }
            });
        }
    }
}
