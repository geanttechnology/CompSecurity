// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package android.support.v7:
//            dr, cx, aqo, cy

class a
    implements Callback
{

    final a a;
    final dr b;

    public void failure(RetrofitError retrofiterror)
    {
        a[retrofiterror.getKind().ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 62;
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

    (dr dr1,  )
    {
        b = dr1;
        a = ;
        super();
    }
}
