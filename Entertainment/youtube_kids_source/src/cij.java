// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;

public final class cij
{

    final cik a;
    final aon b;
    private byte c;

    public cij(cik cik1, aon aon)
    {
        a = cik1;
        b = aon;
        c = 0;
        a.a(a("474000100000b00d0001c100000001f0002ab104b2"));
        a.a(a("475000100002b0180001c10000e100f0000fe100f0060a04756e6400152c6928"));
    }

    private static byte[] a(String s)
    {
        boolean flag1 = true;
        byte abyte0[];
        int j;
        boolean flag;
        if (s.length() % 2 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        j = s.length();
        abyte0 = new byte[j << 1];
        for (int i = 0; i < j; i += 2)
        {
            abyte0[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        if (abyte0.length <= 188)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        b.b(flag);
        return a.a(abyte0, 188, (byte)-1);
    }

    byte[] a(byte abyte0[], long l, boolean flag)
    {
        byte abyte1[] = new byte[2];
        byte[] _tmp = abyte1;
        abyte1[0] = 1;
        abyte1[1] = 0;
        if (flag)
        {
            abyte1[0] = (byte)(abyte1[0] | 0x40);
        }
        byte byte0 = (byte)(c | 0x30);
        c = (byte)(c + 1 & 0xf);
        byte byte1 = abyte1[0];
        byte byte2 = abyte1[1];
        int j = abyte0.length;
        byte abyte2[];
        int i;
        if (l != -1L)
        {
            abyte1 = new byte[7];
            abyte1[0] = 80;
            abyte1[1] = (byte)(int)(l >> 25 & 255L);
            abyte1[2] = (byte)(int)(l >> 17 & 255L);
            abyte1[3] = (byte)(int)(l >> 9 & 255L);
            abyte1[4] = (byte)(int)(l >> 1 & 255L);
            abyte1[5] = (byte)(int)(l << 7 & 128L);
            abyte1[6] = 0;
        } else
        {
            abyte1 = new byte[1];
            abyte1[0] = 0;
        }
        i = abyte1.length + 1;
        j = 184 - i - j;
        if (j >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        abyte2 = new byte[j];
        Arrays.fill(abyte2, (byte)-1);
        abyte1 = a.a(new byte[][] {
            new byte[] {
                (byte)((i + j) - 1)
            }, abyte1, abyte2
        });
        abyte0 = a.a(new byte[][] {
            new byte[] {
                71, byte1, byte2, byte0
            }, abyte1, abyte0
        });
        if (abyte0.length == 188)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        return abyte0;
    }
}
