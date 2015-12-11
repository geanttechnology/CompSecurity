// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.PendingIntent;
import android.util.Log;
import java.util.List;

class nit> extends aet
{

    final List b;
    final aes c;

    protected void a(afd afd1)
    {
        aih aih = new aih() {

            final aes._cls3 a;

            public void a(int i, PendingIntent pendingintent)
            {
                Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
            }

            public void a(int i, String as[])
            {
                a.a(aia.b(i));
            }

            
            {
                a = aes._cls3.this;
                super();
            }
        };
        afd1.a(b, aih);
    }

    protected void b(qd qd)
    {
        a((afd)qd);
    }

    (aes aes1, qm qm, List list)
    {
        c = aes1;
        b = list;
        super(qm);
    }
}
