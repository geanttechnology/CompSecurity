// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a;

import android.support.v4.app.r;
import c.a.a.a.a.b.ag;
import c.a.a.a.a.c.o;
import c.a.a.a.a.c.p;
import c.a.a.a.a.c.z;

// Referenced classes of package c.a.a.a:
//            n, e, q, k

final class m extends p
{

    private n b;

    public m(n n1)
    {
        b = n1;
    }

    private ag a(String s)
    {
        s = new ag((new StringBuilder()).append(b.getIdentifier()).append(".").append(s).toString(), "KitInitialization");
        s.a();
        return s;
    }

    protected final Object a(Object aobj[])
    {
        ag ag1 = a("doInBackground");
        aobj = null;
        if (!d())
        {
            aobj = ((Object []) (b.doInBackground()));
        }
        ag1.b();
        return ((Object) (aobj));
    }

    protected final void a()
    {
        ag ag1;
        super.a();
        ag1 = a("onPreExecute");
        boolean flag = b.onPreExecute();
        ag1.b();
        if (!flag)
        {
            a(true);
        }
        return;
        Object obj;
        obj;
        throw obj;
        obj;
        ag1.b();
        a(true);
        throw obj;
        obj;
        e.d().c("Fabric", "Failure onPreExecute()", ((Throwable) (obj)));
        ag1.b();
        a(true);
        return;
    }

    protected final void a(Object obj)
    {
        b.onPostExecute(obj);
        b.initializationCallback.a();
    }

    protected final void b(Object obj)
    {
        b.onCancelled(obj);
        obj = new r((new StringBuilder()).append(b.getIdentifier()).append(" Initialization was cancelled").toString());
        b.initializationCallback.a(((Exception) (obj)));
    }

    public final int getPriority$16699175()
    {
        return o.b;
    }
}
