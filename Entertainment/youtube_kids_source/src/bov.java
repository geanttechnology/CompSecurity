// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class bov
{

    public final bow a;
    private final boy b;
    private final List c = new ArrayList();
    private final Handler d;
    private box e;

    public bov(boy boy1, Handler handler, bow bow1)
    {
        b = (boy)b.a(boy1);
        d = (Handler)b.a(handler);
        a = (bow)b.a(bow1);
    }

    public static dnp a()
    {
        dnp dnp1 = new dnp();
        dnp1.d = System.currentTimeMillis();
        return dnp1;
    }

    public static ece a(bvz bvz1)
    {
        ece ece1 = new ece();
        if (bvz1.a() != null)
        {
            ece1.b = bvz1.a();
        }
        return ece1;
    }

    public static void a(String s, byte abyte0[], byte abyte1[], String s1, bvz bvz1)
    {
        if (abyte0 != null)
        {
            abyte0 = Base64.encodeToString(abyte0, 2);
        } else
        {
            abyte0 = "null";
        }
        if (abyte1 != null)
        {
            abyte1 = Base64.encodeToString(abyte1, 2);
        } else
        {
            abyte1 = "null";
        }
        bvz1 = String.valueOf(bvz1.getClass().getName());
        bmo.d((new StringBuilder(String.valueOf(s).length() + 25 + String.valueOf(abyte0).length() + String.valueOf(abyte1).length() + String.valueOf(s1).length() + String.valueOf(bvz1).length())).append(s).append(" req: ").append(abyte0).append(" el: ").append(abyte1).append(" csn: ").append(s1).append(" class: ").append(bvz1).toString());
    }

    public static boolean a(byte abyte0[])
    {
        return abyte0 != null && abyte0.length > 0;
    }

    public static boolean b(byte abyte0[])
    {
        return abyte0 != null && abyte0.length > 0;
    }

    public final void a(bvy bvy1, bvz bvz1, dha dha)
    {
        if (a.o() && a(bvz1.a()))
        {
            dha = a();
            dha.e = new dwf();
            if (b(bvy1.a))
            {
                ((dnp) (dha)).e.d = bvy1.a;
            }
            ((dnp) (dha)).e.c = bvy1.b;
            ((dnp) (dha)).e.b = (new ece[] {
                a(bvz1)
            });
            if (bvz1.b() != null)
            {
                ((dnp) (dha)).e.a = a(bvz1.b());
            }
            a(((dnp) (dha)));
            if (a.r())
            {
                a("ATTACH_CHILD:", bvy1.a, bvz1.a(), bvy1.b, bvz1);
                return;
            }
        }
    }

    public final void a(bvy bvy1, bwa bwa1, dha dha)
    {
        if (a.o())
        {
            dha = a();
            dha.c = new dwh();
            ((dnp) (dha)).c.a = bwa1.d;
            if (b(bvy1.a))
            {
                ((dnp) (dha)).c.b = bvy1.a;
            }
            ((dnp) (dha)).c.c = bvy1.b;
            a(((dnp) (dha)));
            if (bwa1 != bwa.a)
            {
                bvy1.c.clear();
            }
            if (a.r())
            {
                byte abyte0[] = bvy1.a;
                dha = bvy1.b;
                String s;
                int i;
                if (abyte0 != null)
                {
                    bvy1 = Base64.encodeToString(abyte0, 2);
                } else
                {
                    bvy1 = "null";
                }
                s = String.valueOf(bwa1.toString());
                i = bwa1.d;
                bwa1 = (new StringBuilder(String.valueOf(s).length() + 14)).append(s).append(" (").append(i).append(")").toString();
                bmo.d((new StringBuilder(String.valueOf("GRAFT:").length() + 18 + String.valueOf(bvy1).length() + String.valueOf(bwa1).length() + String.valueOf(dha).length())).append("GRAFT:").append(" req: ").append(bvy1).append(" elt: ").append(bwa1).append(" csn: ").append(dha).toString());
                return;
            }
        }
    }

    public void a(dnp dnp1)
    {
        c.add(dnp1);
        if (a.q() != 0 && c.size() >= a.q())
        {
            b();
        } else
        if (e == null && !c.isEmpty())
        {
            if (a.p() == 0)
            {
                b();
                return;
            } else
            {
                e = new box(this);
                d.postDelayed(e, a.p());
                return;
            }
        }
    }

    void b()
    {
        if (c.size() != 0)
        {
            Object obj = b;
            obj = new boz(((boy) (obj)).b, ((boy) (obj)).c.b());
            dnp dnp1;
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((boz) (obj)).a.add(dnp1))
            {
                dnp1 = (dnp)iterator.next();
            }

            boy boy1 = b;
            crg crg1 = new crg(dnq);
            boy1.e.a(((bxi) (obj)), crg1);
            c.clear();
            if (e != null)
            {
                d.removeCallbacks(e);
                e = null;
                return;
            }
        }
    }
}
