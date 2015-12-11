// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.UserFavoritesService;
import com.abtnprojects.ambatana.datasource.api.a;
import com.abtnprojects.ambatana.datasource.api.c;
import org.json.JSONObject;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            aqo

public class dp
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }


    private UserFavoritesService a;
    private boolean b;

    public dp(String s)
    {
        a = c.c(s);
        b = false;
    }

    static boolean a(dp dp1, boolean flag)
    {
        dp1.b = flag;
        return flag;
    }

    public void a(String s, String s1, a a1)
    {
        if (b)
        {
            a1.a();
            return;
        } else
        {
            b = true;
            a.insertFavorite(s, s1, com.abtnprojects.ambatana.datasource.api.a.a, new Callback(a1) {

                final a a;
                final dp b;

                public void a(JSONObject jsonobject, Response response)
                {
                    android.support.v7.dp.a(b, false);
                    a.b();
                }

                public void failure(RetrofitError retrofiterror)
                {
                    android.support.v7.dp.a(b, false);
                    aqo.b(retrofiterror, "Error insertFavorite", new Object[0]);
                    a.a();
                }

                public void success(Object obj, Response response)
                {
                    a((JSONObject)obj, response);
                }

            
            {
                b = dp.this;
                a = a1;
                super();
            }
            });
            return;
        }
    }

    public void b(String s, String s1, a a1)
    {
        if (b)
        {
            a1.a();
            return;
        } else
        {
            b = true;
            a.deleteFavorite(s, s1, new Callback(a1) {

                final a a;
                final dp b;

                public void a(JSONObject jsonobject, Response response)
                {
                    android.support.v7.dp.a(b, false);
                    a.b();
                }

                public void failure(RetrofitError retrofiterror)
                {
                    android.support.v7.dp.a(b, false);
                    aqo.b(retrofiterror, "Error deleteFavorite", new Object[0]);
                    a.a();
                }

                public void success(Object obj, Response response)
                {
                    a((JSONObject)obj, response);
                }

            
            {
                b = dp.this;
                a = a1;
                super();
            }
            });
            return;
        }
    }
}
