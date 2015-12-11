// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            acm, vn, abo

class abn
    implements acm
{

    private final long a;
    private final long b;
    private final int c;
    private double d;
    private long e;
    private final Object f = new Object();
    private final String g;
    private final vn h;

    public abn(int i, long l, long l1, String s, vn vn1)
    {
        c = i;
        d = c;
        a = l;
        b = l1;
        g = s;
        h = vn1;
    }

    public boolean a()
    {
        long l;
label0:
        {
            synchronized (f)
            {
                l = h.a();
                if (l - e >= b)
                {
                    break label0;
                }
                abo.b((new StringBuilder()).append("Excessive ").append(g).append(" detected; call ignored.").toString());
            }
            return false;
        }
        double d1;
        if (d >= (double)c)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        d1 = (double)(l - e) / (double)a;
        if (d1 <= 0.0D)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        d = Math.min(c, d1 + d);
        e = l;
        if (d < 1.0D)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        d = d - 1.0D;
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        abo.b((new StringBuilder()).append("Excessive ").append(g).append(" detected; call ignored.").toString());
        obj;
        JVM INSTR monitorexit ;
        return false;
    }
}
