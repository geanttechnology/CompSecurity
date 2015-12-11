// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


// Referenced classes of package a.a:
//            dc, da

public final class db
{

    public int a;
    public int b;

    public db(Throwable throwable)
    {
label0:
        {
            super();
            a = dc.d.ordinal();
            b = da.a.ordinal();
            if (throwable != null)
            {
                a = dc.a(throwable);
                if (a != dc.d.ordinal())
                {
                    break label0;
                }
                b = da.a(throwable).a();
            }
            return;
        }
        b = Integer.parseInt(throwable.getMessage());
    }
}
