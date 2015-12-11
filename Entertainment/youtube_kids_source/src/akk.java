// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class akk
    implements bhv
{

    private akj a;

    akk(akj akj1)
    {
        a = akj1;
        super();
    }

    public final volatile void a(Object obj, Exception exception)
    {
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (String)obj1;
        obj1 = new cgo();
        if (obj != null)
        {
            ((cgo) (obj1)).a("authToken", ((String) (obj)));
        }
        akj.a(a, cgl.y, ((cgo) (obj1)));
    }
}
