// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ix
    implements ka
{

    final jv a;
    boolean b;
    private iu c;

    public ix(iu iu1, Object obj)
    {
        c = iu1;
        super();
        iu1 = iu1.a;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            iu1 = new jw(iu1, obj);
        } else
        {
            iu1 = new jy(iu1, obj);
        }
        a = iu1;
        a.b = this;
        a();
    }

    public final void a()
    {
        a.a(c.f);
    }

    public final void a(int i)
    {
        if (!b && c.i != null)
        {
            c.i.a(i);
        }
    }

    public final void b(int i)
    {
        if (!b && c.i != null)
        {
            c.i.b(i);
        }
    }
}
