// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.c;
import com.abtnprojects.ambatana.services.SendMessageService;
import com.parse.ParseUser;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedString;

// Referenced classes of package android.support.v7:
//            aqo, cw, cx, cy

public class dr
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(cw cw);
    }


    private SendMessageService a;

    public dr(String s)
    {
        a = c.m(s);
    }

    public void a(String s, int i, String s1, String s2, a a1)
    {
        aqo.a("Will send message about productId : %s, type : %d, content : %s, userTo : %s, myUser : %s", new Object[] {
            s, Integer.valueOf(i), s1, s2, ParseUser.getCurrentUser().getObjectId()
        });
        a.sendMessage(s, new TypedString((new StringBuilder()).append(i).append("").toString()), new TypedString(s1), new TypedString(s2), new Callback(a1) {

            final a a;
            final dr b;

            public void failure(RetrofitError retrofiterror)
            {
                static class _cls2
                {

                    static final int a[];

                    static 
                    {
                        a = new int[retrofit.RetrofitError.Kind.values().length];
                        try
                        {
                            a[retrofit.RetrofitError.Kind.HTTP.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror) { }
                    }
                }

                _cls2.a[retrofiterror.getKind().ordinal()];
                JVM INSTR tableswitch 1 1: default 28
            //                           1 62;
                   goto _L1 _L2
_L1:
                a.a(new cx());
_L4:
                aqo.b(retrofiterror, "sendMessageService : %s", new Object[] {
                    retrofiterror.getUrl()
                });
                return;
_L2:
                if (retrofiterror.getResponse() != null)
                {
                    if (403 == retrofiterror.getResponse().getStatus())
                    {
                        a.a(new cy());
                    } else
                    {
                        a.a(new cx());
                    }
                } else
                {
                    a.a(new cx());
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public void success(Object obj, Response response)
            {
                a.a();
            }

            
            {
                b = dr.this;
                a = a1;
                super();
            }
        });
    }
}
