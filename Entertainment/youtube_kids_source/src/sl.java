// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

final class sl
    implements mj
{

    boolean a;
    private final String b;
    private sj c;

    sl(sj sj1, String s)
    {
        c = sj1;
        super();
        b = s;
    }

    public final void a(Object obj)
    {
        boolean flag1;
label0:
        {
            flag1 = false;
            obj = (bum)obj;
            if (a || ((bum) (obj)).c() == null || c.d == null)
            {
                return;
            }
            obj = new bqj(((bum) (obj)).c());
            if (c.d.L != null)
            {
                bry bry1 = c.d.L;
                if (bry1.b == null)
                {
                    bry1.b = new ArrayList();
                    dnb adnb[] = bry1.a.a;
                    int j = adnb.length;
                    for (int i = 0; i < j; i++)
                    {
                        dnb dnb1 = adnb[i];
                        bry1.b.add(new brx(dnb1.b));
                    }

                }
                if (!bry1.b.isEmpty())
                {
                    break label0;
                }
            }
            Object obj1 = c.a;
            if (((bqj) (obj)).b == null && ((bqj) (obj)).a.a != null)
            {
                obj.b = byf.a(((bqj) (obj)).a.a).toString();
            }
            ((sh) (obj1)).a(((bqj) (obj)).b);
            if (((bqj) (obj)).a() != null)
            {
                c.f = bhx.a(new sk(c));
                c.b.a(((bqj) (obj)).a().a, bhy.a(c.c, c.f));
            }
            obj1 = c;
            if (((bqj) (obj)).d == null && ((bqj) (obj)).a.d != null)
            {
                obj.d = ((bqj) (obj)).a.d;
            }
            obj1.e = ((bqj) (obj)).d;
        }
        sj sj1 = c;
        if (((bqj) (obj)).c == null && ((bqj) (obj)).a.b != null)
        {
            obj.c = byf.a(((bqj) (obj)).a.b).toString();
        }
        boolean flag = flag1;
        if (((bqj) (obj)).c != null)
        {
            flag = flag1;
            if (c.d.p != null)
            {
                flag = true;
            }
        }
        sj1.a(flag);
    }

    public final void a(mp mp)
    {
        if (!a)
        {
            String s = String.valueOf(b);
            if (s.length() != 0)
            {
                s = "Couldn't retrieve ad overlay for video ".concat(s);
            } else
            {
                s = new String("Couldn't retrieve ad overlay for video ");
            }
            bmo.a(s, mp);
        }
    }
}
