// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;


public class EbaySecureDataEncoder
{

    private final int DFLT_ROUNDS = 4;
    private final int MASKS_LEN = 10;
    private final int MAX_ROUNDS = 20;
    private final byte bMask1[] = {
        59, -27
    };
    private final byte bMask2[] = {
        -46, -90
    };
    private final byte bMask3[] = {
        110, 93
    };
    private final byte bMask4[] = {
        -57, 26
    };
    private final byte bMask5[] = {
        -84, -47
    };
    private byte bMasks[];
    private int rounds;

    public EbaySecureDataEncoder()
    {
        bMasks = null;
        rounds = 4;
        bMasks = new byte[10];
        setDefaults();
    }

    public void decode(byte abyte0[])
    {
        if (abyte0 != null && abyte0.length >= 2)
        {
            byte abyte1[] = new byte[2];
            int i = 0;
            while (i < rounds) 
            {
                abyte1[0] = (byte)(bMasks[2] + bMasks[4] + bMasks[6] + bMasks[8]);
                abyte1[1] = (byte)(bMasks[3] + bMasks[5] + bMasks[7] + bMasks[9]);
                int k = bMasks[0] & 0xff;
                int l = bMasks[1] & 0xff;
                int j = 0;
                while (j < abyte0.length) 
                {
label0:
                    {
                        byte byte0 = abyte0[j];
                        byte byte1 = abyte0[j + 1];
                        byte0 &= 0xff;
                        byte byte4;
                        byte byte7;
                        if (byte0 >= k)
                        {
                            byte0 -= k;
                        } else
                        {
                            byte0 = (byte)((byte0 - k) + 256);
                        }
                        byte1 &= 0xff;
                        if (byte1 >= l)
                        {
                            byte1 -= l;
                        } else
                        {
                            byte1 = (byte)((byte1 - l) + 256);
                        }
                        if ((byte0 & 4) == 4 || (byte1 & 2) == 2)
                        {
                            byte byte2 = (byte)(bMasks[6] ^ byte0);
                            byte0 = (byte)(bMasks[7] ^ byte1);
                            byte1 = byte2;
                        } else
                        {
                            byte0 = (byte)(bMasks[8] ^ byte0);
                            byte byte5 = (byte)(bMasks[9] ^ byte1);
                            byte1 = byte0;
                            byte0 = byte5;
                        }
                        if ((byte1 & 2) == 2 || (byte0 & 4) == 4)
                        {
                            byte byte3 = (byte)(bMasks[2] ^ byte1);
                            byte1 = (byte)(bMasks[3] ^ byte0);
                            byte0 = byte3;
                        } else
                        {
                            byte1 = (byte)(bMasks[4] ^ byte1);
                            byte byte6 = (byte)(bMasks[5] ^ byte0);
                            byte0 = byte1;
                            byte1 = byte6;
                        }
                        if ((byte0 & 1) != 1)
                        {
                            byte7 = byte0;
                            byte4 = byte1;
                            if ((byte1 & 1) != 1)
                            {
                                break label0;
                            }
                        }
                        byte4 = byte0;
                        byte7 = byte1;
                    }
                    byte0 = j + 1;
                    abyte0[j] = (byte)(bMasks[0] ^ byte7 ^ abyte1[0]);
                    j = byte0 + 1;
                    abyte0[byte0] = (byte)(bMasks[1] ^ byte4 ^ abyte1[1]);
                    abyte1[0] = (byte)(abyte1[0] + abyte0[j - 2]);
                    abyte1[1] = (byte)(abyte1[1] + abyte0[j - 1]);
                }
                i++;
            }
        }
_L2:
        return;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void encode(byte abyte0[])
    {
        if (abyte0 != null && abyte0.length >= 2)
        {
            byte abyte1[] = new byte[2];
            int i = 0;
            while (i < rounds) 
            {
                abyte1[0] = (byte)(bMasks[2] + bMasks[4] + bMasks[6] + bMasks[8]);
                abyte1[1] = (byte)(bMasks[3] + bMasks[5] + bMasks[7] + bMasks[9]);
                int j = 0;
                while (j < abyte0.length) 
                {
                    byte byte0;
                    byte byte4;
label0:
                    {
                        byte byte1 = abyte0[j];
                        byte0 = abyte0[j + 1];
                        byte1 = (byte)((byte)(bMasks[0] ^ abyte1[0]) ^ byte1);
                        byte byte3 = (byte)((byte)(bMasks[1] ^ abyte1[1]) ^ byte0);
                        if ((byte1 & 1) != 1)
                        {
                            byte4 = byte1;
                            byte0 = byte3;
                            if ((byte3 & 1) != 1)
                            {
                                break label0;
                            }
                        }
                        byte0 = byte1;
                        byte4 = byte3;
                    }
                    byte byte2;
                    int k;
                    if ((byte4 & 2) == 2 || (byte0 & 4) == 4)
                    {
                        byte2 = (byte)(bMasks[2] ^ byte4);
                        byte0 = (byte)(bMasks[3] ^ byte0);
                    } else
                    {
                        byte2 = (byte)(bMasks[4] ^ byte4);
                        byte0 = (byte)(bMasks[5] ^ byte0);
                    }
                    if ((byte2 & 4) == 4 || (byte0 & 2) == 2)
                    {
                        byte2 = (byte)(bMasks[6] ^ byte2);
                        byte0 = (byte)(bMasks[7] ^ byte0);
                    } else
                    {
                        byte2 = (byte)(bMasks[8] ^ byte2);
                        byte0 = (byte)(bMasks[9] ^ byte0);
                    }
                    abyte1[0] = (byte)(abyte1[0] + abyte0[j]);
                    abyte1[1] = (byte)(abyte1[1] + abyte0[j + 1]);
                    k = j + 1;
                    abyte0[j] = (byte)(bMasks[0] + byte2);
                    j = k + 1;
                    abyte0[k] = (byte)(bMasks[1] + byte0);
                }
                i++;
            }
        }
_L2:
        return;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setDefaults()
    {
        setMasks(bMask1, bMask2, bMask3, bMask4, bMask5);
        setRounds(4);
    }

    public void setMasks(byte abyte0[], int i)
    {
        if (abyte0 != null && abyte0.length - i >= 10)
        {
            int j = i + 1;
            byte byte0 = abyte0[i];
            i = j + 1;
            byte byte1 = abyte0[j];
            j = i + 1;
            byte byte2 = abyte0[i];
            i = j + 1;
            byte byte3 = abyte0[j];
            j = i + 1;
            byte byte4 = abyte0[i];
            i = j + 1;
            byte byte5 = abyte0[j];
            j = i + 1;
            byte byte6 = abyte0[i];
            i = j + 1;
            byte byte7 = abyte0[j];
            byte byte8 = abyte0[i];
            byte byte9 = abyte0[i + 1];
            setMasks(new byte[] {
                byte0, byte1
            }, new byte[] {
                byte2, byte3
            }, new byte[] {
                byte4, byte5
            }, new byte[] {
                byte6, byte7
            }, new byte[] {
                byte8, byte9
            });
        }
    }

    public void setMasks(byte abyte0[], byte abyte1[], byte abyte2[], byte abyte3[], byte abyte4[])
    {
        if (abyte0 != null && abyte0.length == 2)
        {
            bMasks[0] = abyte0[0];
            bMasks[1] = abyte0[1];
        }
        if (abyte1 != null && abyte1.length == 2)
        {
            bMasks[2] = (byte)(abyte1[0] & 0xf9);
            bMasks[3] = (byte)(abyte1[1] & 0xf9);
        }
        if (abyte2 != null && abyte2.length == 2)
        {
            bMasks[4] = (byte)(abyte2[0] & 0xf9);
            bMasks[5] = (byte)(abyte2[1] & 0xf9);
        }
        if (abyte3 != null && abyte3.length == 2)
        {
            bMasks[6] = (byte)(abyte3[0] & 0xf9);
            bMasks[7] = (byte)(abyte3[1] & 0xf9);
        }
        if (abyte4 != null && abyte4.length == 2)
        {
            bMasks[8] = (byte)(abyte4[0] & 0xf9);
            bMasks[9] = (byte)(abyte4[1] & 0xf9);
        }
    }

    public void setRounds(int i)
    {
        if (i > 0 && i <= 20)
        {
            rounds = i;
        }
    }
}
