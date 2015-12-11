// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            t

public final class j extends t
{

    private final byte a[];
    private final int b;
    private final int c;
    private final int d;
    private final int e;

    public j(byte abyte0[], int i, int k, int l, int i1, int j1, int k1)
    {
        super(j1, k1);
        if (l + j1 > i || i1 + k1 > k)
        {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        } else
        {
            a = abyte0;
            b = i;
            c = k;
            d = l;
            e = i1;
            return;
        }
    }

    public final byte[] a()
    {
        int i;
        int l;
        int i1;
        i = 0;
        l = b();
        i1 = c();
        if (l != b || i1 != c) goto _L2; else goto _L1
_L1:
        byte abyte0[] = a;
_L4:
        return abyte0;
_L2:
        int j1 = l * i1;
        byte abyte1[] = new byte[j1];
        int k = e * b + d;
        if (l == b)
        {
            System.arraycopy(a, k, abyte1, 0, j1);
            return abyte1;
        }
        byte abyte2[] = a;
        do
        {
            abyte0 = abyte1;
            if (i >= i1)
            {
                continue;
            }
            System.arraycopy(abyte2, k, abyte1, i * l, l);
            k += b;
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final byte[] a(int i, byte abyte0[])
    {
        byte abyte1[];
        int k;
label0:
        {
            if (i < 0 || i >= c())
            {
                throw new IllegalArgumentException((new StringBuilder("Requested row is outside the image: ")).append(i).toString());
            }
            k = b();
            if (abyte0 != null)
            {
                abyte1 = abyte0;
                if (abyte0.length >= k)
                {
                    break label0;
                }
            }
            abyte1 = new byte[k];
        }
        int l = e;
        int i1 = b;
        int j1 = d;
        System.arraycopy(a, (l + i) * i1 + j1, abyte1, 0, k);
        return abyte1;
    }
}
