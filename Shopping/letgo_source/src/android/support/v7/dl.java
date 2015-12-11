// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.UnreadMessagesService;
import com.abtnprojects.ambatana.datasource.api.c;
import com.abtnprojects.ambatana.models.chat.ApiUnreadMessagesCount;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            aqo

public class dl
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(int i);
    }


    private UnreadMessagesService a;
    private boolean b;

    public dl(String s)
    {
        a = (UnreadMessagesService)c.a(s, com/abtnprojects/ambatana/datasource/api/UnreadMessagesService);
    }

    static boolean a(dl dl1, boolean flag)
    {
        dl1.b = flag;
        return flag;
    }

    public void a(a a1)
    {
        if (b)
        {
            return;
        }
        b = true;
        try
        {
            a.countUnread(new Callback(a1) {

                final a a;
                final dl b;

                public void a(ApiUnreadMessagesCount apiunreadmessagescount, Response response)
                {
                    dl.a(b, false);
                    a.a(apiunreadmessagescount.getCount());
                }

                public void failure(RetrofitError retrofiterror)
                {
                    dl.a(b, false);
                    a.a();
                }

                public void success(Object obj, Response response)
                {
                    a((ApiUnreadMessagesCount)obj, response);
                }

            
            {
                b = dl.this;
                a = a1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            aqo.b(a1, "countUnread error", new Object[0]);
        }
    }
}
