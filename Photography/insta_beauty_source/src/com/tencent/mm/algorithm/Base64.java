// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.algorithm;

import java.util.Arrays;

public class Base64
{

    private static final char a[];
    private static final int b[];

    public Base64()
    {
    }

    public static final byte[] decode(String s)
    {
        int i;
        if (s != null)
        {
            i = s.length();
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            return new byte[0];
        }
        int i1 = 0;
        int k;
        int j1;
        for (k = 0; i1 < i; k = j1)
        {
            j1 = k;
            if (b[s.charAt(i1)] < 0)
            {
                j1 = k + 1;
            }
            i1++;
        }

        if ((i - k) % 4 != 0)
        {
            return null;
        }
        i1 = i;
        int k1 = 0;
        do
        {
            if (i1 <= 1)
            {
                break;
            }
            int ai[] = b;
            int i2 = i1 - 1;
            if (ai[s.charAt(i2)] > 0)
            {
                break;
            }
            i1 = i2;
            if (s.charAt(i2) == '=')
            {
                k1++;
                i1 = i2;
            }
        } while (true);
        int k2 = ((i - k) * 6 >> 3) - k1;
        byte abyte0[] = new byte[k2];
        i1 = 0;
        int l;
        for (int j = 0; i1 < k2; j = l)
        {
            int l1 = 0;
            int j2 = 0;
            l = j;
            j = j2;
            while (j < 4) 
            {
                j2 = b[s.charAt(l)];
                if (j2 >= 0)
                {
                    l1 |= j2 << 18 - j * 6;
                } else
                {
                    j--;
                }
                j++;
                l++;
            }
            j2 = i1 + 1;
            abyte0[i1] = (byte)(l1 >> 16);
            j = j2;
            if (j2 < k2)
            {
                j = j2 + 1;
                abyte0[j2] = (byte)(l1 >> 8);
                if (j < k2)
                {
                    i1 = j + 1;
                    abyte0[j] = (byte)l1;
                    j = i1;
                }
            }
            i1 = j;
        }

        return abyte0;
    }

    public static final byte[] decode(byte abyte0[])
    {
        int k1 = abyte0.length;
        int k = 0;
        int i;
        int i1;
        for (i = 0; k < k1; i = i1)
        {
            i1 = i;
            if (b[abyte0[k] & 0xff] < 0)
            {
                i1 = i + 1;
            }
            k++;
        }

        if ((k1 - i) % 4 != 0)
        {
            return null;
        }
        k = k1;
        int j1 = 0;
        do
        {
            if (k <= 1)
            {
                break;
            }
            int ai[] = b;
            int i2 = k - 1;
            if (ai[abyte0[i2] & 0xff] > 0)
            {
                break;
            }
            k = i2;
            if (abyte0[i2] == 61)
            {
                j1++;
                k = i2;
            }
        } while (true);
        int k2 = ((k1 - i) * 6 >> 3) - j1;
        byte abyte1[] = new byte[k2];
        j1 = 0;
        int l;
        for (int j = 0; j1 < k2; j = l)
        {
            int l1 = 0;
            int j2 = 0;
            l = j;
            j = j2;
            while (j < 4) 
            {
                j2 = b[abyte0[l] & 0xff];
                if (j2 >= 0)
                {
                    l1 |= j2 << 18 - j * 6;
                } else
                {
                    j--;
                }
                j++;
                l++;
            }
            j2 = j1 + 1;
            abyte1[j1] = (byte)(l1 >> 16);
            j = j2;
            if (j2 < k2)
            {
                j = j2 + 1;
                abyte1[j2] = (byte)(l1 >> 8);
                if (j < k2)
                {
                    j1 = j + 1;
                    abyte1[j] = (byte)l1;
                    j = j1;
                }
            }
            j1 = j;
        }

        return abyte1;
    }

    public static final byte[] decode(char ac[])
    {
        int i;
        if (ac != null)
        {
            i = ac.length;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            return new byte[0];
        }
        int i1 = 0;
        int k;
        int j1;
        for (k = 0; i1 < i; k = j1)
        {
            j1 = k;
            if (b[ac[i1]] < 0)
            {
                j1 = k + 1;
            }
            i1++;
        }

        if ((i - k) % 4 != 0)
        {
            return null;
        }
        i1 = i;
        int k1 = 0;
        do
        {
            if (i1 <= 1)
            {
                break;
            }
            int ai[] = b;
            int i2 = i1 - 1;
            if (ai[ac[i2]] > 0)
            {
                break;
            }
            i1 = i2;
            if (ac[i2] == '=')
            {
                k1++;
                i1 = i2;
            }
        } while (true);
        int k2 = ((i - k) * 6 >> 3) - k1;
        byte abyte0[] = new byte[k2];
        i1 = 0;
        int l;
        for (int j = 0; i1 < k2; j = l)
        {
            int l1 = 0;
            int j2 = 0;
            l = j;
            j = j2;
            while (j < 4) 
            {
                j2 = b[ac[l]];
                if (j2 >= 0)
                {
                    l1 |= j2 << 18 - j * 6;
                } else
                {
                    j--;
                }
                j++;
                l++;
            }
            j2 = i1 + 1;
            abyte0[i1] = (byte)(l1 >> 16);
            j = j2;
            if (j2 < k2)
            {
                j = j2 + 1;
                abyte0[j2] = (byte)(l1 >> 8);
                if (j < k2)
                {
                    i1 = j + 1;
                    abyte0[j] = (byte)l1;
                    j = i1;
                }
            }
            i1 = j;
        }

        return abyte0;
    }

    public static final byte[] decodeFast(String s)
    {
        boolean flag = false;
        int l = s.length();
        if (l == 0)
        {
            return new byte[0];
        }
        int k1 = l - 1;
        int i;
        for (i = 0; i < k1 && b[s.charAt(i) & 0xff] < 0; i++) { }
        for (; k1 > 0 && b[s.charAt(k1) & 0xff] < 0; k1--) { }
        byte abyte0[];
        int k;
        int i1;
        int l1;
        int k3;
        if (s.charAt(k1) == '=')
        {
            if (s.charAt(k1 - 1) == '=')
            {
                k = 2;
            } else
            {
                k = 1;
            }
        } else
        {
            k = 0;
        }
        i1 = (k1 - i) + 1;
        if (l > 76)
        {
            int ai[];
            int k2;
            int i3;
            int j3;
            int l3;
            int i4;
            if (s.charAt(76) == '\r')
            {
                l = i1 / 78;
            } else
            {
                l = 0;
            }
            l1 = l << 1;
        } else
        {
            l1 = 0;
        }
        k3 = ((i1 - l1) * 6 >> 3) - k;
        abyte0 = new byte[k3];
        l3 = k3 / 3;
        i1 = 0;
        l = 0;
        do
        {
            if (l >= l3 * 3)
            {
                break;
            }
            ai = b;
            i3 = i + 1;
            i = ai[s.charAt(i)];
            ai = b;
            k2 = i3 + 1;
            i3 = ai[s.charAt(i3)];
            ai = b;
            j3 = k2 + 1;
            i4 = ai[s.charAt(k2)];
            ai = b;
            k2 = j3 + 1;
            i = i4 << 6 | (i << 18 | i3 << 12) | ai[s.charAt(j3)];
            i3 = l + 1;
            abyte0[l] = (byte)(i >> 16);
            l = i3 + 1;
            abyte0[i3] = (byte)(i >> 8);
            i3 = l + 1;
            abyte0[l] = (byte)i;
            i = k2;
            l = i3;
            if (l1 > 0)
            {
                j3 = i1 + 1;
                i1 = j3;
                i = k2;
                l = i3;
                if (j3 == 19)
                {
                    i = k2 + 2;
                    i1 = 0;
                    l = i3;
                }
            }
        } while (true);
        if (l < k3)
        {
            int i2 = i;
            int j1 = 0;
            i = ((flag) ? 1 : 0);
            do
            {
                int j2 = i;
                if (i2 > k1 - k)
                {
                    break;
                }
                int l2 = b[s.charAt(i2)];
                i = j2 + 1;
                j1 = l2 << 18 - j2 * 6 | j1;
                i2++;
            } while (true);
            k = 16;
            for (int j = l; j < k3; j++)
            {
                abyte0[j] = (byte)(j1 >> k);
                k -= 8;
            }

        }
        return abyte0;
    }

    public static final byte[] decodeFast(byte abyte0[])
    {
        boolean flag = false;
        int l = abyte0.length;
        if (l == 0)
        {
            return new byte[0];
        }
        int k1 = l - 1;
        int i;
        for (i = 0; i < k1 && b[abyte0[i] & 0xff] < 0; i++) { }
        for (; k1 > 0 && b[abyte0[k1] & 0xff] < 0; k1--) { }
        byte abyte1[];
        int k;
        int i1;
        int l1;
        int k3;
        if (abyte0[k1] == 61)
        {
            if (abyte0[k1 - 1] == 61)
            {
                k = 2;
            } else
            {
                k = 1;
            }
        } else
        {
            k = 0;
        }
        i1 = (k1 - i) + 1;
        if (l > 76)
        {
            int ai[];
            int k2;
            int i3;
            int j3;
            int l3;
            int i4;
            if (abyte0[76] == 13)
            {
                l = i1 / 78;
            } else
            {
                l = 0;
            }
            l1 = l << 1;
        } else
        {
            l1 = 0;
        }
        k3 = ((i1 - l1) * 6 >> 3) - k;
        abyte1 = new byte[k3];
        l3 = k3 / 3;
        i1 = 0;
        l = 0;
        do
        {
            if (l >= l3 * 3)
            {
                break;
            }
            ai = b;
            i3 = i + 1;
            i = ai[abyte0[i]];
            ai = b;
            k2 = i3 + 1;
            i3 = ai[abyte0[i3]];
            ai = b;
            j3 = k2 + 1;
            i4 = ai[abyte0[k2]];
            ai = b;
            k2 = j3 + 1;
            i = i4 << 6 | (i << 18 | i3 << 12) | ai[abyte0[j3]];
            i3 = l + 1;
            abyte1[l] = (byte)(i >> 16);
            l = i3 + 1;
            abyte1[i3] = (byte)(i >> 8);
            i3 = l + 1;
            abyte1[l] = (byte)i;
            i = k2;
            l = i3;
            if (l1 > 0)
            {
                j3 = i1 + 1;
                i1 = j3;
                i = k2;
                l = i3;
                if (j3 == 19)
                {
                    i = k2 + 2;
                    i1 = 0;
                    l = i3;
                }
            }
        } while (true);
        if (l < k3)
        {
            int i2 = i;
            int j1 = 0;
            i = ((flag) ? 1 : 0);
            do
            {
                int j2 = i;
                if (i2 > k1 - k)
                {
                    break;
                }
                int l2 = b[abyte0[i2]];
                i = j2 + 1;
                j1 = l2 << 18 - j2 * 6 | j1;
                i2++;
            } while (true);
            k = 16;
            for (int j = l; j < k3; j++)
            {
                abyte1[j] = (byte)(j1 >> k);
                k -= 8;
            }

        }
        return abyte1;
    }

    public static final byte[] decodeFast(char ac[])
    {
        boolean flag = false;
        int l = ac.length;
        if (l == 0)
        {
            return new byte[0];
        }
        int k1 = l - 1;
        int i;
        for (i = 0; i < k1 && b[ac[i]] < 0; i++) { }
        for (; k1 > 0 && b[ac[k1]] < 0; k1--) { }
        byte abyte0[];
        int k;
        int i1;
        int l1;
        int k3;
        if (ac[k1] == '=')
        {
            if (ac[k1 - 1] == '=')
            {
                k = 2;
            } else
            {
                k = 1;
            }
        } else
        {
            k = 0;
        }
        i1 = (k1 - i) + 1;
        if (l > 76)
        {
            int ai[];
            int k2;
            int i3;
            int j3;
            int l3;
            int i4;
            if (ac[76] == '\r')
            {
                l = i1 / 78;
            } else
            {
                l = 0;
            }
            l1 = l << 1;
        } else
        {
            l1 = 0;
        }
        k3 = ((i1 - l1) * 6 >> 3) - k;
        abyte0 = new byte[k3];
        l3 = k3 / 3;
        i1 = 0;
        l = 0;
        do
        {
            if (l >= l3 * 3)
            {
                break;
            }
            ai = b;
            i3 = i + 1;
            i = ai[ac[i]];
            ai = b;
            k2 = i3 + 1;
            i3 = ai[ac[i3]];
            ai = b;
            j3 = k2 + 1;
            i4 = ai[ac[k2]];
            ai = b;
            k2 = j3 + 1;
            i = i4 << 6 | (i << 18 | i3 << 12) | ai[ac[j3]];
            i3 = l + 1;
            abyte0[l] = (byte)(i >> 16);
            l = i3 + 1;
            abyte0[i3] = (byte)(i >> 8);
            i3 = l + 1;
            abyte0[l] = (byte)i;
            i = k2;
            l = i3;
            if (l1 > 0)
            {
                j3 = i1 + 1;
                i1 = j3;
                i = k2;
                l = i3;
                if (j3 == 19)
                {
                    i = k2 + 2;
                    i1 = 0;
                    l = i3;
                }
            }
        } while (true);
        if (l < k3)
        {
            int i2 = i;
            int j1 = 0;
            i = ((flag) ? 1 : 0);
            do
            {
                int j2 = i;
                if (i2 > k1 - k)
                {
                    break;
                }
                int l2 = b[ac[i2]];
                i = j2 + 1;
                j1 = l2 << 18 - j2 * 6 | j1;
                i2++;
            } while (true);
            k = 16;
            for (int j = l; j < k3; j++)
            {
                abyte0[j] = (byte)(j1 >> k);
                k -= 8;
            }

        }
        return abyte0;
    }

    public static final byte[] encodeToByte(byte abyte0[], boolean flag)
    {
        boolean flag1 = false;
        int l;
        if (abyte0 != null)
        {
            l = abyte0.length;
        } else
        {
            l = 0;
        }
        if (l == 0)
        {
            return new byte[0];
        }
        int j2 = (l / 3) * 3;
        int k = (l - 1) / 3 + 1 << 2;
        byte abyte1[];
        int i;
        int i1;
        int k2;
        if (flag)
        {
            i = (k - 1) / 76 << 1;
        } else
        {
            i = 0;
        }
        k2 = k + i;
        abyte1 = new byte[k2];
        i = 0;
        k = 0;
        i1 = 0;
        do
        {
            if (i1 >= j2)
            {
                break;
            }
            int j1 = i1 + 1;
            i1 = abyte0[i1];
            int k1 = j1 + 1;
            int l1 = abyte0[j1];
            j1 = k1 + 1;
            i1 = (l1 & 0xff) << 8 | (i1 & 0xff) << 16 | abyte0[k1] & 0xff;
            k1 = k + 1;
            abyte1[k] = (byte)a[i1 >>> 18 & 0x3f];
            k = k1 + 1;
            abyte1[k1] = (byte)a[i1 >>> 12 & 0x3f];
            l1 = k + 1;
            abyte1[k] = (byte)a[i1 >>> 6 & 0x3f];
            k1 = l1 + 1;
            abyte1[l1] = (byte)a[i1 & 0x3f];
            k = k1;
            i1 = j1;
            if (flag)
            {
                int i2 = i + 1;
                i = i2;
                k = k1;
                i1 = j1;
                if (i2 == 19)
                {
                    i = i2;
                    k = k1;
                    i1 = j1;
                    if (k1 < k2 - 2)
                    {
                        i = k1 + 1;
                        abyte1[k1] = 13;
                        abyte1[i] = 10;
                        k = i + 1;
                        i = 0;
                        i1 = j1;
                    }
                }
            }
        } while (true);
        k = l - j2;
        if (k > 0)
        {
            byte byte1 = abyte0[j2];
            int j = ((flag1) ? 1 : 0);
            if (k == 2)
            {
                j = (abyte0[l - 1] & 0xff) << 2;
            }
            j |= (byte1 & 0xff) << 10;
            abyte1[k2 - 4] = (byte)a[j >> 12];
            abyte1[k2 - 3] = (byte)a[j >>> 6 & 0x3f];
            byte byte0;
            if (k == 2)
            {
                byte0 = (byte)a[j & 0x3f];
            } else
            {
                byte0 = 61;
            }
            abyte1[k2 - 2] = byte0;
            abyte1[k2 - 1] = 61;
        }
        return abyte1;
    }

    public static final char[] encodeToChar(byte abyte0[], boolean flag)
    {
        boolean flag1 = false;
        int l;
        if (abyte0 != null)
        {
            l = abyte0.length;
        } else
        {
            l = 0;
        }
        if (l == 0)
        {
            return new char[0];
        }
        int j2 = (l / 3) * 3;
        int k = (l - 1) / 3 + 1 << 2;
        char ac[];
        int i;
        int i1;
        int k2;
        if (flag)
        {
            i = (k - 1) / 76 << 1;
        } else
        {
            i = 0;
        }
        k2 = k + i;
        ac = new char[k2];
        i = 0;
        k = 0;
        i1 = 0;
        do
        {
            if (i1 >= j2)
            {
                break;
            }
            int j1 = i1 + 1;
            i1 = abyte0[i1];
            int k1 = j1 + 1;
            int l1 = abyte0[j1];
            j1 = k1 + 1;
            i1 = (l1 & 0xff) << 8 | (i1 & 0xff) << 16 | abyte0[k1] & 0xff;
            k1 = k + 1;
            ac[k] = a[i1 >>> 18 & 0x3f];
            k = k1 + 1;
            ac[k1] = a[i1 >>> 12 & 0x3f];
            l1 = k + 1;
            ac[k] = a[i1 >>> 6 & 0x3f];
            k1 = l1 + 1;
            ac[l1] = a[i1 & 0x3f];
            k = k1;
            i1 = j1;
            if (flag)
            {
                int i2 = i + 1;
                i = i2;
                k = k1;
                i1 = j1;
                if (i2 == 19)
                {
                    i = i2;
                    k = k1;
                    i1 = j1;
                    if (k1 < k2 - 2)
                    {
                        i = k1 + 1;
                        ac[k1] = '\r';
                        ac[i] = '\n';
                        k = i + 1;
                        i = 0;
                        i1 = j1;
                    }
                }
            }
        } while (true);
        k = l - j2;
        if (k > 0)
        {
            byte byte0 = abyte0[j2];
            int j = ((flag1) ? 1 : 0);
            if (k == 2)
            {
                j = (abyte0[l - 1] & 0xff) << 2;
            }
            j |= (byte0 & 0xff) << 10;
            ac[k2 - 4] = a[j >> 12];
            ac[k2 - 3] = a[j >>> 6 & 0x3f];
            char c;
            if (k == 2)
            {
                c = a[j & 0x3f];
            } else
            {
                c = '=';
            }
            ac[k2 - 2] = c;
            ac[k2 - 1] = '=';
        }
        return ac;
    }

    public static final String encodeToString(byte abyte0[], boolean flag)
    {
        return new String(encodeToChar(abyte0, flag));
    }

    static 
    {
        a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        int ai[] = new int[256];
        b = ai;
        Arrays.fill(ai, -1);
        int j = a.length;
        for (int i = 0; i < j; i++)
        {
            b[a[i]] = i;
        }

        b[61] = 0;
    }
}
