// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            dm, dn

public final class dl extends dm
{

    private byte a[];
    private int b;
    private int c;

    public dl()
    {
    }

    public dl(byte abyte0[])
    {
        a(abyte0);
    }

    public dl(byte abyte0[], int i, int j)
    {
        c(abyte0, i, j);
    }

    public int a(byte abyte0[], int i, int j)
        throws dn
    {
        int l = h();
        int k = j;
        if (j > l)
        {
            k = l;
        }
        if (k > 0)
        {
            System.arraycopy(a, b, abyte0, i, k);
            a(k);
        }
        return k;
    }

    public void a(int i)
    {
        b = b + i;
    }

    public void a(byte abyte0[])
    {
        c(abyte0, 0, abyte0.length);
    }

    public boolean a()
    {
        return true;
    }

    public void b()
        throws dn
    {
    }

    public void b(byte abyte0[], int i, int j)
        throws dn
    {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    public void c()
    {
    }

    public void c(byte abyte0[], int i, int j)
    {
        a = abyte0;
        b = i;
        c = i + j;
    }

    public void e()
    {
        a = null;
    }

    public byte[] f()
    {
        return a;
    }

    public int g()
    {
        return b;
    }

    public int h()
    {
        return c - b;
    }
}
