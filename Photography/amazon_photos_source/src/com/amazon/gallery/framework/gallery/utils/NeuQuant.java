// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.utils;


public class NeuQuant
{

    protected static final int minpicturebytes = primes[3] * 3;
    protected static final int primes[] = {
        499, 491, 487, 503
    };
    protected int alphadec;
    protected int bias[];
    protected int freq[];
    protected int lengthcount;
    protected int netindex[];
    protected int network[][];
    protected int radpower[];
    protected int samplefac;
    protected byte thepicture[];

    public NeuQuant(byte abyte0[], int i, int j)
    {
        netindex = new int[256];
        bias = new int[256];
        freq = new int[256];
        radpower = new int[32];
        thepicture = abyte0;
        lengthcount = i;
        samplefac = j;
        network = new int[256][];
        for (i = 0; i < 256; i++)
        {
            network[i] = new int[4];
            abyte0 = network[i];
            j = (i << 12) / 256;
            abyte0[2] = j;
            abyte0[1] = j;
            abyte0[0] = j;
            freq[i] = 256;
            bias[i] = 0;
        }

    }

    protected void alterneigh(int i, int j, int k, int l, int i1)
    {
        int j1;
        int l1;
        int i2;
        j1 = j - i;
        l1 = j1;
        if (j1 < -1)
        {
            l1 = -1;
        }
        i = j + i;
        i2 = i;
        if (i > 256)
        {
            i2 = 256;
        }
        boolean flag = true;
        j1 = j - 1;
        i = j + 1;
        j = ((flag) ? 1 : 0);
_L6:
        if (i >= i2 && j1 <= l1) goto _L2; else goto _L1
_L1:
        int ai[];
        int k1;
        int j2;
        Object obj = radpower;
        k1 = j + 1;
        j2 = obj[j];
        if (i >= i2)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        obj = network;
        j = i + 1;
        ai = obj[i];
        ai[0] = ai[0] - ((ai[0] - k) * j2) / 0x40000;
        ai[1] = ai[1] - ((ai[1] - l) * j2) / 0x40000;
        ai[2] = ai[2] - ((ai[2] - i1) * j2) / 0x40000;
        i = j;
_L4:
        if (j1 <= l1)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1 = network;
        j = j1 - 1;
        obj1 = obj1[j1];
        try
        {
            obj1[0] = obj1[0] - ((obj1[0] - k) * j2) / 0x40000;
            obj1[1] = obj1[1] - ((obj1[1] - l) * j2) / 0x40000;
            obj1[2] = obj1[2] - ((obj1[2] - i1) * j2) / 0x40000;
        }
        catch (Exception exception)
        {
            j1 = j;
            j = k1;
            continue; /* Loop/switch isn't completed */
        }
        j1 = j;
        j = k1;
        continue; /* Loop/switch isn't completed */
_L2:
        return;
        Exception exception1;
        exception1;
        i = j;
        if (true) goto _L4; else goto _L3
_L3:
        j = k1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void altersingle(int i, int j, int k, int l, int i1)
    {
        int ai[] = network[j];
        ai[0] = ai[0] - ((ai[0] - k) * i) / 1024;
        ai[1] = ai[1] - ((ai[1] - l) * i) / 1024;
        ai[2] = ai[2] - ((ai[2] - i1) * i) / 1024;
    }

    public byte[] colorMap()
    {
        byte abyte0[] = new byte[768];
        int ai[] = new int[256];
        for (int i = 0; i < 256; i++)
        {
            ai[network[i][3]] = i;
        }

        int j = 0;
        for (int k = 0; j < 256; k++)
        {
            int l = ai[j];
            int i1 = k + 1;
            abyte0[k] = (byte)network[l][0];
            k = i1 + 1;
            abyte0[i1] = (byte)network[l][1];
            abyte0[k] = (byte)network[l][2];
            j++;
        }

        return abyte0;
    }

    protected int contest(int i, int j, int k)
    {
        int k1 = 0x7fffffff;
        int i1 = 0x7fffffff;
        int l1 = -1;
        int j1 = -1;
        for (int l = 0; l < 256;)
        {
            int ai[] = network[l];
            int j2 = ai[0] - i;
            int i2 = j2;
            if (j2 < 0)
            {
                i2 = -j2;
            }
            int k2 = ai[1] - j;
            j2 = k2;
            if (k2 < 0)
            {
                j2 = -k2;
            }
            int l2 = ai[2] - k;
            k2 = l2;
            if (l2 < 0)
            {
                k2 = -l2;
            }
            j2 = i2 + j2 + k2;
            i2 = k1;
            if (j2 < k1)
            {
                i2 = j2;
                l1 = l;
            }
            j2 -= bias[l] >> 12;
            k1 = i1;
            if (j2 < i1)
            {
                k1 = j2;
                j1 = l;
            }
            i1 = freq[l] >> 10;
            ai = freq;
            ai[l] = ai[l] - i1;
            ai = bias;
            ai[l] = ai[l] + (i1 << 10);
            l++;
            i1 = k1;
            k1 = i2;
        }

        int ai1[] = freq;
        ai1[l1] = ai1[l1] + 64;
        ai1 = bias;
        ai1[l1] = ai1[l1] - 0x10000;
        return j1;
    }

    public void inxbuild()
    {
        int l1 = 0;
        int k1 = 0;
        for (int i = 0; i < 256;)
        {
            int ai[] = network[i];
            int k2 = i;
            int k = ai[1];
            for (int l = i + 1; l < 256;)
            {
                int ai1[] = network[l];
                int i2 = k;
                if (ai1[1] < k)
                {
                    k2 = l;
                    i2 = ai1[1];
                }
                l++;
                k = i2;
            }

            int ai2[] = network[k2];
            if (i != k2)
            {
                int i1 = ai2[0];
                ai2[0] = ai[0];
                ai[0] = i1;
                i1 = ai2[1];
                ai2[1] = ai[1];
                ai[1] = i1;
                i1 = ai2[2];
                ai2[2] = ai[2];
                ai[2] = i1;
                i1 = ai2[3];
                ai2[3] = ai[3];
                ai[3] = i1;
            }
            int j2 = l1;
            int j1 = k1;
            if (k != l1)
            {
                netindex[l1] = k1 + i >> 1;
                for (j1 = l1 + 1; j1 < k; j1++)
                {
                    netindex[j1] = i;
                }

                j1 = i;
                j2 = k;
            }
            i++;
            l1 = j2;
            k1 = j1;
        }

        netindex[l1] = k1 + 255 >> 1;
        for (int j = l1 + 1; j < 256; j++)
        {
            netindex[j] = 255;
        }

    }

    public void learn()
    {
        if (lengthcount < minpicturebytes)
        {
            samplefac = 1;
        }
        alphadec = (samplefac - 1) / 3 + 30;
        byte abyte0[] = thepicture;
        int j2 = 0;
        int j4 = lengthcount;
        int k4 = lengthcount / (samplefac * 3);
        int i2 = k4 / 100;
        int k2 = 1024;
        int j1 = 2048;
        int i = 2048 >> 6;
        int j = i;
        if (i <= 1)
        {
            j = 0;
        }
        for (i = 0; i < j; i++)
        {
            radpower[i] = (((j * j - i * i) * 256) / (j * j)) * 1024;
        }

        int k1;
        int l1;
        if (lengthcount < minpicturebytes)
        {
            i = 3;
        } else
        if (lengthcount % primes[0] != 0)
        {
            i = primes[0] * 3;
        } else
        if (lengthcount % primes[1] != 0)
        {
            i = primes[1] * 3;
        } else
        if (lengthcount % primes[2] != 0)
        {
            i = primes[2] * 3;
        } else
        {
            i = primes[3] * 3;
        }
        k1 = 0;
        l1 = j;
        do
        {
label0:
            {
                int k;
                int l2;
                int k3;
                do
                {
                    if (k1 >= k4)
                    {
                        break label0;
                    }
                    k = (abyte0[j2 + 0] & 0xff) << 4;
                    int l = (abyte0[j2 + 1] & 0xff) << 4;
                    l2 = (abyte0[j2 + 2] & 0xff) << 4;
                    int i3 = contest(k, l, l2);
                    altersingle(k2, i3, k, l, l2);
                    if (l1 != 0)
                    {
                        alterneigh(l1, i3, k, l, l2);
                    }
                    l = j2 + i;
                    k = l;
                    if (l >= j4)
                    {
                        k = l - lengthcount;
                    }
                    k3 = k1 + 1;
                    l2 = i2;
                    if (i2 == 0)
                    {
                        l2 = 1;
                    }
                    i2 = l2;
                    k1 = k3;
                    j2 = k;
                } while (k3 % l2 != 0);
                int l3 = k2 - k2 / alphadec;
                int i4 = j1 - j1 / 30;
                j1 = i4 >> 6;
                int i1 = j1;
                if (j1 <= 1)
                {
                    i1 = 0;
                }
                int j3 = 0;
                do
                {
                    k2 = l3;
                    l1 = i1;
                    i2 = l2;
                    k1 = k3;
                    j2 = k;
                    j1 = i4;
                    if (j3 >= i1)
                    {
                        break;
                    }
                    radpower[j3] = (((i1 * i1 - j3 * j3) * 256) / (i1 * i1)) * l3;
                    j3++;
                } while (true);
            }
        } while (true);
    }

    public int map(int i, int j, int k)
    {
        int j1 = 1000;
        int i1 = -1;
        int j2 = netindex[j];
        int l = j2 - 1;
        do
        {
            if (j2 >= 256 && l < 0)
            {
                break;
            }
            int l1 = i1;
            int i2 = j1;
            int k1 = j2;
            int ai[];
            if (j2 < 256)
            {
                ai = network[j2];
                l1 = ai[1] - j;
                if (l1 >= j1)
                {
                    k1 = 256;
                    i2 = j1;
                    l1 = i1;
                } else
                {
                    j2++;
                    k1 = l1;
                    if (l1 < 0)
                    {
                        k1 = -l1;
                    }
                    i2 = ai[0] - i;
                    l1 = i2;
                    if (i2 < 0)
                    {
                        l1 = -i2;
                    }
                    int k2 = k1 + l1;
                    l1 = i1;
                    i2 = j1;
                    k1 = j2;
                    if (k2 < j1)
                    {
                        l1 = ai[2] - k;
                        k1 = l1;
                        if (l1 < 0)
                        {
                            k1 = -l1;
                        }
                        k2 += k1;
                        l1 = i1;
                        i2 = j1;
                        k1 = j2;
                        if (k2 < j1)
                        {
                            i2 = k2;
                            l1 = ai[3];
                            k1 = j2;
                        }
                    }
                }
            }
            i1 = l1;
            j1 = i2;
            j2 = k1;
            if (l >= 0)
            {
                ai = network[l];
                i1 = j - ai[1];
                if (i1 >= i2)
                {
                    l = -1;
                    i1 = l1;
                    j1 = i2;
                    j2 = k1;
                } else
                {
                    int l2 = l - 1;
                    l = i1;
                    if (i1 < 0)
                    {
                        l = -i1;
                    }
                    j1 = ai[0] - i;
                    i1 = j1;
                    if (j1 < 0)
                    {
                        i1 = -j1;
                    }
                    int i3 = l + i1;
                    i1 = l1;
                    j1 = i2;
                    j2 = k1;
                    l = l2;
                    if (i3 < i2)
                    {
                        i1 = ai[2] - k;
                        l = i1;
                        if (i1 < 0)
                        {
                            l = -i1;
                        }
                        i3 += l;
                        i1 = l1;
                        j1 = i2;
                        j2 = k1;
                        l = l2;
                        if (i3 < i2)
                        {
                            j1 = i3;
                            i1 = ai[3];
                            j2 = k1;
                            l = l2;
                        }
                    }
                }
            }
        } while (true);
        return i1;
    }

    public byte[] process()
    {
        learn();
        unbiasnet();
        inxbuild();
        return colorMap();
    }

    public void unbiasnet()
    {
        for (int i = 0; i < 256; i++)
        {
            int ai[] = network[i];
            ai[0] = ai[0] >> 4;
            ai = network[i];
            ai[1] = ai[1] >> 4;
            ai = network[i];
            ai[2] = ai[2] >> 4;
            network[i][3] = i;
        }

    }

}
