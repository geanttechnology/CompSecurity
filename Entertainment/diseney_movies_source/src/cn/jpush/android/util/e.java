// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;


// Referenced classes of package cn.jpush.android.util:
//            d, c

final class e extends d
{

    static final boolean g;
    private static final byte h[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte i[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    private final byte j[] = new byte[2];
    private int k;
    private final byte l[];

    public e(int i1, byte abyte0[])
    {
        boolean flag1 = true;
        super();
        a = null;
        boolean flag;
        if ((i1 & 1) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
        if ((i1 & 2) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
        if ((i1 & 4) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        f = flag;
        if ((i1 & 8) == 0)
        {
            abyte0 = h;
        } else
        {
            abyte0 = i;
        }
        l = abyte0;
        c = 0;
        if (e)
        {
            i1 = 19;
        } else
        {
            i1 = -1;
        }
        k = i1;
    }

    public final boolean a(byte abyte0[], int i1, int j1, boolean flag)
    {
        byte abyte1[];
        byte abyte2[];
        int k1;
        int l1;
        int k2;
        abyte1 = l;
        abyte2 = a;
        l1 = 0;
        k1 = k;
        k2 = j1 + i1;
        c;
        JVM INSTR tableswitch 0 2: default 56
    //                   0 343
    //                   1 354
    //                   2 421;
           goto _L1 _L2 _L3 _L4
_L1:
        byte byte0 = -1;
        j1 = i1;
        i1 = byte0;
_L6:
        if (i1 != -1)
        {
            abyte2[0] = abyte1[i1 >> 18 & 0x3f];
            abyte2[1] = abyte1[i1 >> 12 & 0x3f];
            abyte2[2] = abyte1[i1 >> 6 & 0x3f];
            l1 = 4;
            abyte2[3] = abyte1[i1 & 0x3f];
            k1--;
            byte abyte3[];
            int i2;
            int j2;
            if (k1 == 0)
            {
                i1 = l1;
                if (f)
                {
                    i1 = 5;
                    abyte2[4] = 13;
                }
                l1 = i1 + 1;
                abyte2[i1] = 10;
                k1 = 19;
                i1 = l1;
            } else
            {
                i1 = 4;
            }
        } else
        {
            i1 = l1;
        }
        do
        {
            if (j1 + 3 > k2)
            {
                break;
            }
            l1 = (abyte0[j1] & 0xff) << 16 | (abyte0[j1 + 1] & 0xff) << 8 | abyte0[j1 + 2] & 0xff;
            abyte2[i1] = abyte1[l1 >> 18 & 0x3f];
            abyte2[i1 + 1] = abyte1[l1 >> 12 & 0x3f];
            abyte2[i1 + 2] = abyte1[l1 >> 6 & 0x3f];
            abyte2[i1 + 3] = abyte1[l1 & 0x3f];
            j1 += 3;
            i1 += 4;
            k1--;
            if (k1 == 0)
            {
                if (f)
                {
                    k1 = i1 + 1;
                    abyte2[i1] = 13;
                    i1 = k1;
                }
                k1 = i1 + 1;
                abyte2[i1] = 10;
                l1 = 19;
                i1 = k1;
                k1 = l1;
            }
        } while (true);
          goto _L5
_L2:
        i2 = -1;
        j1 = i1;
        i1 = i2;
          goto _L6
_L3:
        if (i1 + 2 > k2) goto _L1; else goto _L7
_L7:
        i2 = j[0];
        j1 = i1 + 1;
        i1 = abyte0[i1];
        j2 = abyte0[j1];
        c = 0;
        i1 = (i2 & 0xff) << 16 | (i1 & 0xff) << 8 | j2 & 0xff;
        j1++;
          goto _L6
_L4:
        if (i1 + 1 > k2) goto _L1; else goto _L8
_L8:
        i2 = j[0];
        j2 = j[1];
        j1 = i1 + 1;
        i1 = abyte0[i1];
        c = 0;
        i1 = (i2 & 0xff) << 16 | (j2 & 0xff) << 8 | i1 & 0xff;
          goto _L6
_L5:
        if (j1 - c != k2 - 1) goto _L10; else goto _L9
_L9:
        if (c > 0)
        {
            abyte0 = j;
            l1 = 1;
            i2 = abyte0[0];
        } else
        {
            i2 = abyte0[j1];
            j1++;
            l1 = 0;
        }
        i2 = (i2 & 0xff) << 4;
        c = c - l1;
        j2 = i1 + 1;
        abyte2[i1] = abyte1[i2 >> 6 & 0x3f];
        l1 = j2 + 1;
        abyte2[j2] = abyte1[i2 & 0x3f];
        i1 = l1;
        if (d)
        {
            i2 = l1 + 1;
            abyte2[l1] = 61;
            i1 = i2 + 1;
            abyte2[i2] = 61;
        }
        l1 = i1;
        if (e)
        {
            l1 = i1;
            if (f)
            {
                abyte2[i1] = 13;
                l1 = i1 + 1;
            }
            abyte2[l1] = 10;
            l1++;
        }
        i2 = j1;
_L12:
        if (!g && c != 0)
        {
            throw new AssertionError();
        }
        break; /* Loop/switch isn't completed */
_L10:
        if (j1 - c == k2 - 2)
        {
            if (c > 1)
            {
                abyte3 = j;
                l1 = 1;
                i2 = abyte3[0];
            } else
            {
                i2 = abyte0[j1];
                j1++;
                l1 = 0;
            }
            if (c > 0)
            {
                j2 = j[l1];
                l1++;
            } else
            {
                j2 = abyte0[j1];
                j1++;
            }
            i2 = (j2 & 0xff) << 2 | (i2 & 0xff) << 10;
            c = c - l1;
            l1 = i1 + 1;
            abyte2[i1] = abyte1[i2 >> 12 & 0x3f];
            j2 = l1 + 1;
            abyte2[l1] = abyte1[i2 >> 6 & 0x3f];
            i1 = j2 + 1;
            abyte2[j2] = abyte1[i2 & 0x3f];
            if (d)
            {
                l1 = i1 + 1;
                abyte2[i1] = 61;
                i1 = l1;
            }
            l1 = i1;
            if (e)
            {
                l1 = i1;
                if (f)
                {
                    abyte2[i1] = 13;
                    l1 = i1 + 1;
                }
                abyte2[l1] = 10;
                l1++;
            }
            i2 = j1;
        } else
        {
            i2 = j1;
            l1 = i1;
            if (e)
            {
                i2 = j1;
                l1 = i1;
                if (i1 > 0)
                {
                    i2 = j1;
                    l1 = i1;
                    if (k1 != 19)
                    {
                        if (f)
                        {
                            l1 = i1 + 1;
                            abyte2[i1] = 13;
                            i1 = l1;
                        }
                        l1 = i1 + 1;
                        abyte2[i1] = 10;
                        i2 = j1;
                    }
                }
            }
        }
        if (true) goto _L12; else goto _L11
_L11:
        if (!g && i2 != k2)
        {
            throw new AssertionError();
        } else
        {
            b = l1;
            k = k1;
            return true;
        }
    }

    static 
    {
        boolean flag;
        if (!cn/jpush/android/util/c.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g = flag;
    }
}
