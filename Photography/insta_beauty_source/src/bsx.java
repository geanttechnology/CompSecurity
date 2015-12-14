// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.InitializationException;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

class bsx extends buy
{

    final bsy a;

    public bsx(bsy bsy1)
    {
        a = bsy1;
    }

    private bum a(String s)
    {
        s = new bum((new StringBuilder()).append(a.getIdentifier()).append(".").append(s).toString(), "KitInitialization");
        s.a();
        return s;
    }

    protected volatile Object a(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected transient Object a(Void avoid[])
    {
        bum bum1 = a("doInBackground");
        avoid = null;
        if (!d())
        {
            avoid = ((Void []) (a.doInBackground()));
        }
        bum1.b();
        return avoid;
    }

    protected void a()
    {
        bum bum1;
        super.a();
        bum1 = a("onPreExecute");
        boolean flag = a.onPreExecute();
        bum1.b();
        if (!flag)
        {
            a(true);
        }
        return;
        Object obj;
        obj;
        throw obj;
        obj;
        bum1.b();
        a(true);
        throw obj;
        obj;
        bso.h().e("Fabric", "Failure onPreExecute()", ((Throwable) (obj)));
        bum1.b();
        a(true);
        return;
    }

    protected void a(Object obj)
    {
        a.onPostExecute(obj);
        a.initializationCallback.a(obj);
    }

    protected void b(Object obj)
    {
        a.onCancelled(obj);
        obj = new InitializationException((new StringBuilder()).append(a.getIdentifier()).append(" Initialization was cancelled").toString());
        a.initializationCallback.a(((Exception) (obj)));
    }

    public Priority getPriority()
    {
        return Priority.HIGH;
    }
}
