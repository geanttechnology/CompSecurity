// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            cs, dj, cf, dm, 
//            da, cy

public final class de extends cs
{
    public static class a
        implements da
    {

        public cy a(dm dm)
        {
            return new de(dm);
        }

        public a()
        {
        }
    }


    public de(dm dm)
    {
        super(dm);
    }

    public static BitSet a(byte abyte0[])
    {
        BitSet bitset = new BitSet();
        int i = 0;
        do
        {
            if (i >= abyte0.length * 8)
            {
                return bitset;
            }
            if ((abyte0[abyte0.length - i / 8 - 1] & 1 << i % 8) > 0)
            {
                bitset.set(i);
            }
            i++;
        } while (true);
    }

    public static byte[] b(BitSet bitset, int i)
    {
        byte abyte0[] = new byte[(int)Math.ceil((double)i / 8D)];
        i = 0;
        do
        {
            if (i >= bitset.length())
            {
                return abyte0;
            }
            if (bitset.get(i))
            {
                int j = abyte0.length - i / 8 - 1;
                abyte0[j] = (byte)(abyte0[j] | 1 << i % 8);
            }
            i++;
        } while (true);
    }

    public Class D()
    {
        return u/aly/dj;
    }

    public void a(BitSet bitset, int i)
        throws cf
    {
        bitset = b(bitset, i);
        int j = bitset.length;
        i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            a(bitset[i]);
            i++;
        } while (true);
    }

    public BitSet b(int i)
        throws cf
    {
        int j = (int)Math.ceil((double)i / 8D);
        byte abyte0[] = new byte[j];
        i = 0;
        do
        {
            if (i >= j)
            {
                return a(abyte0);
            }
            abyte0[i] = u();
            i++;
        } while (true);
    }
}
