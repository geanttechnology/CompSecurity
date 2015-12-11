// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class cmo
    implements art
{

    float a;
    private final bmi b;
    private final art c;
    private final int d;
    private final int e;
    private long f;

    public cmo(bmi bmi1, art art1, int i, int j)
    {
        b = (bmi)b.a(bmi1);
        c = (art)b.a(art1);
        d = i;
        e = j;
    }

    private int b(byte abyte0[], int i, int j)
    {
        long l = b();
        if (l > 0L)
        {
            try
            {
                Thread.sleep(l);
            }
            catch (InterruptedException interruptedexception) { }
        }
        return a(abyte0, i, j);
    }

    protected abstract float a(long l);

    public final int a(byte abyte0[], int i, int j)
    {
        if (i < 0 || j < 0 || i + j > abyte0.length)
        {
            throw new IndexOutOfBoundsException();
        }
        long l = b.b();
        long l1 = f;
        f = l;
        a = Math.min(a + a(l - l1), d);
        if (a < 1.0F)
        {
            i = b(abyte0, i, j);
        } else
        {
            j = Math.min(j, (int)a);
            j = c.a(abyte0, i, j);
            i = j;
            if (j > 0)
            {
                a = a - (float)j;
                return j;
            }
        }
        return i;
    }

    public long a(arx arx)
    {
        a = e;
        f = b.b();
        return c.a(arx);
    }

    public final void a()
    {
        c.a();
    }

    protected abstract long b();
}
