// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.webm;

import java.nio.charset.Charset;
import java.util.Stack;
import shared_presage.com.google.android.exoplayer.extractor.ExtractorInput;
import shared_presage.com.google.android.exoplayer.util.Assertions;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.webm:
//            b, e, c

final class shared_presage.com.google.android.exoplayer.extractor.webm.a
    implements b
{
    private static final class a
    {

        private final int a;
        private final long b;

        static long a(a a1)
        {
            return a1.b;
        }

        static int b(a a1)
        {
            return a1.a;
        }

        private a(int i, long l)
        {
            a = i;
            b = l;
        }

        a(int i, long l, byte byte0)
        {
            this(i, l);
        }
    }


    private final byte a[] = new byte[8];
    private final Stack b = new Stack();
    private final e c = new e();
    private c d;
    private int e;
    private int f;
    private long g;

    shared_presage.com.google.android.exoplayer.extractor.webm.a()
    {
    }

    private long a(ExtractorInput extractorinput, int i)
    {
        int j = 0;
        extractorinput.readFully(a, 0, i);
        long l = 0L;
        for (; j < i; j++)
        {
            l = l << 8 | (long)(a[j] & 0xff);
        }

        return l;
    }

    public final void a()
    {
        e = 0;
        b.clear();
        c.a();
    }

    public final void a(c c1)
    {
        d = c1;
    }

    public final boolean a(ExtractorInput extractorinput)
    {
        boolean flag;
        if (d != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        do
        {
            if (!b.isEmpty() && extractorinput.getPosition() >= a.a((a)b.peek()))
            {
                d.b(a.b((a)b.pop()));
                return true;
            }
            if (e == 0)
            {
                long l1 = c.a(extractorinput, true, false);
                if (l1 == -1L)
                {
                    return false;
                }
                f = (int)l1;
                e = 1;
            }
            if (e == 1)
            {
                g = c.a(extractorinput, false, true);
                e = 2;
            }
            int i = d.a(f);
            switch (i)
            {
            default:
                throw new IllegalStateException((new StringBuilder("Invalid element type ")).append(i).toString());

            case 1: // '\001'
                long l2 = extractorinput.getPosition();
                long l4 = g;
                b.add(new a(f, l4 + l2, (byte)0));
                d.a(f, l2, g);
                e = 0;
                return true;

            case 2: // '\002'
                if (g > 8L)
                {
                    throw new IllegalStateException((new StringBuilder("Invalid integer size: ")).append(g).toString());
                } else
                {
                    d.a(f, a(extractorinput, (int)g));
                    e = 0;
                    return true;
                }

            case 5: // '\005'
                if (g != 4L && g != 8L)
                {
                    throw new IllegalStateException((new StringBuilder("Invalid float size: ")).append(g).toString());
                }
                c c1 = d;
                int j = f;
                int l = (int)g;
                long l3 = a(extractorinput, l);
                double d1;
                if (l == 4)
                {
                    d1 = Float.intBitsToFloat((int)l3);
                } else
                {
                    d1 = Double.longBitsToDouble(l3);
                }
                c1.a(j, d1);
                e = 0;
                return true;

            case 3: // '\003'
                if (g > 0x7fffffffL)
                {
                    throw new IllegalStateException((new StringBuilder("String element size: ")).append(g).toString());
                } else
                {
                    c c2 = d;
                    int k = f;
                    int i1 = (int)g;
                    byte abyte0[] = new byte[i1];
                    extractorinput.readFully(abyte0, 0, i1);
                    c2.a(k, new String(abyte0, Charset.forName("UTF-8")));
                    e = 0;
                    return true;
                }

            case 4: // '\004'
                d.a(f, (int)g, extractorinput);
                e = 0;
                return true;

            case 0: // '\0'
                extractorinput.skipFully((int)g);
                e = 0;
                break;
            }
        } while (true);
    }
}
