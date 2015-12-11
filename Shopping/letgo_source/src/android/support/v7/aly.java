// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            anh, anb, alz, ano, 
//            alt, amc, alw, alx, 
//            ang

class aly extends anh
{

    final alz a;

    public aly(alz alz1)
    {
        a = alz1;
    }

    private anb a(String s)
    {
        s = new anb((new StringBuilder()).append(a.getIdentifier()).append(".").append(s).toString(), "KitInitialization");
        s.a();
        return s;
    }

    protected volatile Object a(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected transient Object a(Void avoid[])
    {
        anb anb1 = a("doInBackground");
        avoid = null;
        if (!d())
        {
            avoid = ((Void []) (a.doInBackground()));
        }
        anb1.b();
        return avoid;
    }

    protected void a()
    {
        anb anb1;
        super.a();
        anb1 = a("onPreExecute");
        boolean flag = a.onPreExecute();
        anb1.b();
        if (!flag)
        {
            a(true);
        }
        return;
        Object obj;
        obj;
        throw obj;
        obj;
        anb1.b();
        a(true);
        throw obj;
        obj;
        alt.h().e("Fabric", "Failure onPreExecute()", ((Throwable) (obj)));
        anb1.b();
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
        obj = new alx((new StringBuilder()).append(a.getIdentifier()).append(" Initialization was cancelled").toString());
        a.initializationCallback.a(((Exception) (obj)));
    }

    public ang getPriority()
    {
        return ang.c;
    }
}
