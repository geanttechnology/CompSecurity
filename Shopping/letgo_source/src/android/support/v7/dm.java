// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.GetUserService;
import com.abtnprojects.ambatana.datasource.api.c;
import com.abtnprojects.ambatana.models.user.User;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            aqo

public class dm
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(User user);
    }


    private final GetUserService a;

    public dm(String s)
    {
        a = (GetUserService)c.a(s, com/abtnprojects/ambatana/datasource/api/GetUserService);
    }

    public void a(String s, a a1)
    {
        try
        {
            a.getUser(s, new Callback(a1) {

                final a a;
                final dm b;

                public void a(User user, Response response)
                {
                    a.a(user);
                }

                public void failure(RetrofitError retrofiterror)
                {
                    a.a();
                }

                public void success(Object obj, Response response)
                {
                    a((User)obj, response);
                }

            
            {
                b = dm.this;
                a = a1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.b(s, "Error getting user", new Object[0]);
        }
    }
}
