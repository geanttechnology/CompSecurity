// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.encode;


// Referenced classes of package com.google.userfeedback.android.api.encode:
//            Base64

public class count extends count
{

    static final boolean $assertionsDisabled;
    private static final byte ENCODE[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte ENCODE_WEBSAFE[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    public static final int LINE_GROUPS = 19;
    private final byte alphabet[];
    private int count;
    public final boolean do_cr;
    public final boolean do_newline;
    public final boolean do_padding;
    private final byte tail[] = new byte[2];
    public int tailLen;

    public int maxOutputSize(int i)
    {
        return (i << 3) / 5 + 10;
    }

    public boolean process(byte abyte0[], int i, int j, boolean flag)
    {
        byte abyte1[];
        byte abyte2[];
        int l;
        int i1;
        int l1;
        abyte1 = alphabet;
        abyte2 = output;
        l = 0;
        i1 = count;
        l1 = j + i;
        tailLen;
        JVM INSTR tableswitch 0 2: default 56
    //                   0 335
    //                   1 345
    //                   2 413;
           goto _L1 _L2 _L3 _L4
_L1:
        int k;
        j = -1;
        k = i;
        i = j;
_L6:
        if (i != -1)
        {
            abyte2[0] = abyte1[i >> 18 & 0x3f];
            abyte2[1] = abyte1[i >> 12 & 0x3f];
            abyte2[2] = abyte1[i >> 6 & 0x3f];
            j = 4;
            abyte2[3] = abyte1[i & 0x3f];
            i = i1 - 1;
            byte abyte3[];
            int j1;
            int k1;
            if (i == 0)
            {
                i = j;
                if (do_cr)
                {
                    i = 5;
                    abyte2[4] = 13;
                }
                l = i + 1;
                abyte2[i] = 10;
                j = 19;
                i = l;
            } else
            {
                j = i;
                i = 4;
            }
        } else
        {
            j = i1;
            i = l;
        }
        do
        {
            if (k + 3 > l1)
            {
                break;
            }
            l = (abyte0[k] & 0xff) << 16 | (abyte0[k + 1] & 0xff) << 8 | abyte0[k + 2] & 0xff;
            abyte2[i] = abyte1[l >> 18 & 0x3f];
            abyte2[i + 1] = abyte1[l >> 12 & 0x3f];
            abyte2[i + 2] = abyte1[l >> 6 & 0x3f];
            abyte2[i + 3] = abyte1[l & 0x3f];
            k += 3;
            i += 4;
            j--;
            if (j == 0)
            {
                if (do_cr)
                {
                    j = i + 1;
                    abyte2[i] = 13;
                    i = j;
                }
                j = i + 1;
                abyte2[i] = 10;
                l = 19;
                i = j;
                j = l;
            }
        } while (true);
          goto _L5
_L2:
        j = -1;
        k = i;
        i = j;
          goto _L6
_L3:
        if (i + 2 > l1) goto _L1; else goto _L7
_L7:
        k = tail[0];
        j = i + 1;
        i = abyte0[i];
        j1 = abyte0[j];
        tailLen = 0;
        i = (k & 0xff) << 16 | (i & 0xff) << 8 | j1 & 0xff;
        k = j + 1;
          goto _L6
_L4:
        if (i + 1 > l1) goto _L1; else goto _L8
_L8:
        j = tail[0];
        j1 = tail[1];
        k = i + 1;
        i = abyte0[i];
        tailLen = 0;
        i = (j & 0xff) << 16 | (j1 & 0xff) << 8 | i & 0xff;
          goto _L6
_L5:
        if (!flag) goto _L10; else goto _L9
_L9:
        if (k - tailLen != l1 - 1) goto _L12; else goto _L11
_L11:
        l = 0;
        if (tailLen > 0)
        {
            abyte0 = tail;
            l = 1;
            i1 = abyte0[0];
        } else
        {
            i1 = abyte0[k];
            k++;
        }
        i1 = (i1 & 0xff) << 4;
        tailLen = tailLen - l;
        j1 = i + 1;
        abyte2[i] = abyte1[i1 >> 6 & 0x3f];
        l = j1 + 1;
        abyte2[j1] = abyte1[i1 & 0x3f];
        i = l;
        if (do_padding)
        {
            i1 = l + 1;
            abyte2[l] = 61;
            i = i1 + 1;
            abyte2[i1] = 61;
        }
        l = i;
        if (do_newline)
        {
            l = i;
            if (do_cr)
            {
                abyte2[i] = 13;
                l = i + 1;
            }
            abyte2[l] = 10;
            l++;
        }
        i1 = k;
_L14:
        if (!$assertionsDisabled && tailLen != 0)
        {
            throw new AssertionError();
        }
        break; /* Loop/switch isn't completed */
_L12:
        if (k - tailLen == l1 - 2)
        {
            l = 0;
            if (tailLen > 1)
            {
                abyte3 = tail;
                j1 = 1;
                i1 = abyte3[0];
                l = k;
                k = j1;
            } else
            {
                i1 = abyte0[k];
                j1 = k + 1;
                k = l;
                l = j1;
            }
            if (tailLen > 0)
            {
                j1 = tail[k];
                k1 = k + 1;
                k = l;
                l = k1;
            } else
            {
                j1 = abyte0[l];
                k1 = l + 1;
                l = k;
                k = k1;
            }
            i1 = (j1 & 0xff) << 2 | (i1 & 0xff) << 10;
            tailLen = tailLen - l;
            l = i + 1;
            abyte2[i] = abyte1[i1 >> 12 & 0x3f];
            j1 = l + 1;
            abyte2[l] = abyte1[i1 >> 6 & 0x3f];
            i = j1 + 1;
            abyte2[j1] = abyte1[i1 & 0x3f];
            if (do_padding)
            {
                l = i + 1;
                abyte2[i] = 61;
                i = l;
            }
            l = i;
            if (do_newline)
            {
                l = i;
                if (do_cr)
                {
                    abyte2[i] = 13;
                    l = i + 1;
                }
                abyte2[l] = 10;
                l++;
            }
            i1 = k;
        } else
        {
            i1 = k;
            l = i;
            if (do_newline)
            {
                i1 = k;
                l = i;
                if (i > 0)
                {
                    i1 = k;
                    l = i;
                    if (j != 19)
                    {
                        if (do_cr)
                        {
                            l = i + 1;
                            abyte2[i] = 13;
                            i = l;
                        }
                        l = i + 1;
                        abyte2[i] = 10;
                        i1 = k;
                    }
                }
            }
        }
        if (true) goto _L14; else goto _L13
_L13:
        j1 = l;
        if (!$assertionsDisabled)
        {
            j1 = l;
            if (i1 != l1)
            {
                throw new AssertionError();
            }
        }
          goto _L15
_L10:
        if (k != l1 - 1) goto _L17; else goto _L16
_L16:
        abyte1 = tail;
        l = tailLen;
        tailLen = l + 1;
        abyte1[l] = abyte0[k];
        j1 = i;
_L15:
        op = j1;
        count = j;
        return true;
_L17:
        j1 = i;
        if (k == l1 - 2)
        {
            abyte1 = tail;
            l = tailLen;
            tailLen = l + 1;
            abyte1[l] = abyte0[k];
            abyte1 = tail;
            l = tailLen;
            tailLen = l + 1;
            abyte1[l] = abyte0[k + 1];
            j1 = i;
        }
        if (true) goto _L15; else goto _L18
_L18:
    }

    static 
    {
        boolean flag;
        if (!com/google/userfeedback/android/api/encode/Base64.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

    public (int i, byte abyte0[])
    {
        boolean flag1 = true;
        super();
        output = abyte0;
        boolean flag;
        if ((i & 1) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        do_padding = flag;
        if ((i & 2) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        do_newline = flag;
        if ((i & 4) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        do_cr = flag;
        if ((i & 8) == 0)
        {
            abyte0 = ENCODE;
        } else
        {
            abyte0 = ENCODE_WEBSAFE;
        }
        alphabet = abyte0;
        tailLen = 0;
        if (do_newline)
        {
            i = 19;
        } else
        {
            i = -1;
        }
        count = i;
    }
}
