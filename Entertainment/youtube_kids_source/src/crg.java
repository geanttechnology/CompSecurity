// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class crg
    implements mj
{

    private Class a;

    public crg(Class class1)
    {
        a = class1;
        super();
    }

    public final void a(Object obj)
    {
        obj = String.valueOf(a.getCanonicalName());
        if (((String) (obj)).length() != 0)
        {
            obj = "Successful volley request for type ".concat(((String) (obj)));
        } else
        {
            obj = new String("Successful volley request for type ");
        }
        bmo.e(((String) (obj)));
    }

    public final void a(mp mp)
    {
        String s = String.valueOf(a.getCanonicalName());
        if (s.length() != 0)
        {
            s = "Volley request failed for type ".concat(s);
        } else
        {
            s = new String("Volley request failed for type ");
        }
        bmo.a(s, mp);
    }
}
