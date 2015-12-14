// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.InitializationException;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

class aac extends abq
{

    final aad a;

    public aac(aad aad1)
    {
        a = aad1;
    }

    private abj a(String s)
    {
        s = new abj((new StringBuilder()).append(a.getIdentifier()).append(".").append(s).toString(), "KitInitialization");
        s.a();
        return s;
    }

    protected volatile Object a(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected transient Object a(Void avoid[])
    {
        abj abj1 = a("doInBackground");
        avoid = null;
        if (!d())
        {
            avoid = ((Void []) (a.doInBackground()));
        }
        abj1.b();
        return avoid;
    }

    protected void a()
    {
        abj abj1;
        super.a();
        abj1 = a("onPreExecute");
        boolean flag = a.onPreExecute();
        abj1.b();
        if (!flag)
        {
            a(true);
        }
        return;
        Object obj;
        obj;
        throw obj;
        obj;
        abj1.b();
        a(true);
        throw obj;
        obj;
        zw.h().e("Fabric", "Failure onPreExecute()", ((Throwable) (obj)));
        abj1.b();
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
