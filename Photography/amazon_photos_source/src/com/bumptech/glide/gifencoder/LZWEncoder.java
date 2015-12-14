// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.gifencoder;

import java.io.IOException;
import java.io.OutputStream;

class LZWEncoder
{

    int ClearCode;
    int EOFCode;
    int a_count;
    byte accum[];
    boolean clear_flg;
    int codetab[];
    private int curPixel;
    int cur_accum;
    int cur_bits;
    int free_ent;
    int g_init_bits;
    int hsize;
    int htab[];
    private int imgH;
    private int imgW;
    private int initCodeSize;
    int masks[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535
    };
    int maxbits;
    int maxcode;
    int maxmaxcode;
    int n_bits;
    private byte pixAry[];
    private int remaining;

    LZWEncoder(int i, int j, byte abyte0[], int k)
    {
        maxbits = 12;
        maxmaxcode = 4096;
        htab = new int[5003];
        codetab = new int[5003];
        hsize = 5003;
        free_ent = 0;
        clear_flg = false;
        cur_accum = 0;
        cur_bits = 0;
        accum = new byte[256];
        imgW = i;
        imgH = j;
        pixAry = abyte0;
        initCodeSize = Math.max(2, k);
    }

    private int nextPixel()
    {
        if (remaining == 0)
        {
            return -1;
        } else
        {
            remaining = remaining - 1;
            byte abyte0[] = pixAry;
            int i = curPixel;
            curPixel = i + 1;
            return abyte0[i] & 0xff;
        }
    }

    final int MAXCODE(int i)
    {
        return (1 << i) - 1;
    }

    void char_out(byte byte0, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = accum;
        int i = a_count;
        a_count = i + 1;
        abyte0[i] = byte0;
        if (a_count >= 254)
        {
            flush_char(outputstream);
        }
    }

    void cl_block(OutputStream outputstream)
        throws IOException
    {
        cl_hash(hsize);
        free_ent = ClearCode + 2;
        clear_flg = true;
        output(ClearCode, outputstream);
    }

    void cl_hash(int i)
    {
        for (int j = 0; j < i; j++)
        {
            htab[j] = -1;
        }

    }

    void compress(int i, OutputStream outputstream)
        throws IOException
    {
        g_init_bits = i;
        clear_flg = false;
        n_bits = g_init_bits;
        maxcode = MAXCODE(n_bits);
        ClearCode = 1 << i - 1;
        EOFCode = ClearCode + 1;
        free_ent = ClearCode + 2;
        a_count = 0;
        int j = nextPixel();
        int i1 = 0;
        for (i = hsize; i < 0x10000; i *= 2)
        {
            i1++;
        }

        int i2 = hsize;
        cl_hash(i2);
        output(ClearCode, outputstream);
        i = j;
label0:
        do
        {
            int l1 = nextPixel();
            if (l1 == -1)
            {
                break;
            }
            int j2 = (l1 << maxbits) + i;
            int k = l1 << 8 - i1 ^ i;
            if (htab[k] == j2)
            {
                i = codetab[k];
                continue;
            }
            int j1 = k;
            if (htab[k] >= 0)
            {
                j1 = i2 - k;
                int k1 = k;
                if (k == 0)
                {
                    j1 = 1;
                    k1 = k;
                }
                do
                {
                    k1 -= j1;
                    k = k1;
                    if (k1 < 0)
                    {
                        k = k1 + i2;
                    }
                    if (htab[k] == j2)
                    {
                        i = codetab[k];
                        continue label0;
                    }
                    k1 = k;
                } while (htab[k] >= 0);
                j1 = k;
            }
            output(i, outputstream);
            i = l1;
            if (free_ent < maxmaxcode)
            {
                int ai[] = codetab;
                int l = free_ent;
                free_ent = l + 1;
                ai[j1] = l;
                htab[j1] = j2;
            } else
            {
                cl_block(outputstream);
            }
        } while (true);
        output(i, outputstream);
        output(EOFCode, outputstream);
    }

    void encode(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(initCodeSize);
        remaining = imgW * imgH;
        curPixel = 0;
        compress(initCodeSize + 1, outputstream);
        outputstream.write(0);
    }

    void flush_char(OutputStream outputstream)
        throws IOException
    {
        if (a_count > 0)
        {
            outputstream.write(a_count);
            outputstream.write(accum, 0, a_count);
            a_count = 0;
        }
    }

    void output(int i, OutputStream outputstream)
        throws IOException
    {
        cur_accum = cur_accum & masks[cur_bits];
        if (cur_bits > 0)
        {
            cur_accum = cur_accum | i << cur_bits;
        } else
        {
            cur_accum = i;
        }
        for (cur_bits = cur_bits + n_bits; cur_bits >= 8; cur_bits = cur_bits - 8)
        {
            char_out((byte)(cur_accum & 0xff), outputstream);
            cur_accum = cur_accum >> 8;
        }

        if (free_ent > maxcode || clear_flg)
        {
            if (clear_flg)
            {
                int j = g_init_bits;
                n_bits = j;
                maxcode = MAXCODE(j);
                clear_flg = false;
            } else
            {
                n_bits = n_bits + 1;
                if (n_bits == maxbits)
                {
                    maxcode = maxmaxcode;
                } else
                {
                    maxcode = MAXCODE(n_bits);
                }
            }
        }
        if (i == EOFCode)
        {
            for (; cur_bits > 0; cur_bits = cur_bits - 8)
            {
                char_out((byte)(cur_accum & 0xff), outputstream);
                cur_accum = cur_accum >> 8;
            }

            flush_char(outputstream);
        }
    }
}
