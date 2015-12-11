// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader

public final class Code128Reader extends OneDReader
{

    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int CODE_PATTERNS[][];
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final int MAX_AVG_VARIANCE = 64;
    private static final int MAX_INDIVIDUAL_VARIANCE = 179;

    public Code128Reader()
    {
    }

    private static int decodeCode(BitArray bitarray, int ai[], int i)
    {
        recordPattern(bitarray, i, ai);
        int j = 64;
        int l = -1;
        for (i = 0; i < CODE_PATTERNS.length;)
        {
            int i1 = patternMatchVariance(ai, CODE_PATTERNS[i], 179);
            int k = j;
            if (i1 < j)
            {
                l = i;
                k = i1;
            }
            i++;
            j = k;
        }

        if (l >= 0)
        {
            return l;
        } else
        {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private static int[] findStartPattern(BitArray bitarray)
    {
        int k2 = bitarray.getSize();
        int i = bitarray.getNextSet(0);
        int ai[] = new int[6];
        int l2 = ai.length;
        int i2 = i;
        boolean flag = false;
        int j = 0;
        while (i2 < k2) 
        {
            int l;
            if (bitarray.get(i2) ^ flag)
            {
                ai[j] = ai[j] + 1;
                int k = j;
                j = i;
                i = k;
            } else
            {
                if (j == l2 - 1)
                {
                    int l1 = 64;
                    byte byte0 = -1;
                    for (int i1 = 103; i1 <= 105; i1++)
                    {
                        int j2 = patternMatchVariance(ai, CODE_PATTERNS[i1], 179);
                        if (j2 < l1)
                        {
                            byte0 = i1;
                            l1 = j2;
                        }
                    }

                    if (byte0 >= 0 && bitarray.isRange(Math.max(0, i - (i2 - i) / 2), i, false))
                    {
                        return (new int[] {
                            i, i2, byte0
                        });
                    }
                    int j1 = ai[0] + ai[1] + i;
                    System.arraycopy(ai, 2, ai, 0, l2 - 2);
                    ai[l2 - 2] = 0;
                    ai[l2 - 1] = 0;
                    i = j - 1;
                    j = j1;
                } else
                {
                    int k1 = j + 1;
                    j = i;
                    i = k1;
                }
                ai[i] = 1;
                if (!flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            i2++;
            l = i;
            i = j;
            j = l;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public Result decodeRow(int i, BitArray bitarray, Map map)
    {
        int ai[];
        int j1;
        boolean flag1;
        if (map != null && map.containsKey(DecodeHintType.ASSUME_GS1))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ai = findStartPattern(bitarray);
        j1 = ai[2];
        map = new ArrayList(20);
        map.add(Byte.valueOf((byte)j1));
        j1;
        JVM INSTR tableswitch 103 105: default 84
    //                   103 94
    //                   104 266
    //                   105 273;
           goto _L1 _L2 _L3 _L4
_L1:
        throw FormatException.getFormatInstance();
_L2:
        int j = 101;
_L48:
        Object obj;
        int ai1[];
        int l;
        int i1;
        int k1;
        int l1;
        int i2;
        int k2;
        int l2;
        int i3;
        obj = new StringBuilder(20);
        k2 = ai[0];
        k1 = ai[1];
        ai1 = new int[6];
        i1 = 1;
        l2 = 0;
        l1 = 0;
        i3 = 0;
        i2 = 0;
        boolean flag = false;
        l = j;
        j = ((flag) ? 1 : 0);
_L14:
        if (j != 0) goto _L6; else goto _L5
_L5:
        int j2;
        int j3;
        int k3;
        boolean flag2;
        boolean flag3;
        flag3 = false;
        flag2 = false;
        k3 = decodeCode(bitarray, ai1, k1);
        map.add(Byte.valueOf((byte)k3));
        if (k3 != 106)
        {
            i1 = 1;
        }
        j3 = l1;
        i3 = j1;
        if (k3 != 106)
        {
            j3 = l1 + 1;
            i3 = j1 + j3 * k3;
        }
        l1 = ai1.length;
        j1 = 0;
        j2 = k1;
        for (; j1 < l1; j1++)
        {
            j2 += ai1[j1];
        }

          goto _L7
_L3:
        j = 100;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 99;
        continue; /* Loop/switch isn't completed */
_L7:
        k3;
        JVM INSTR tableswitch 103 105: default 308
    //                   103 450
    //                   104 450
    //                   105 450;
           goto _L8 _L9 _L9 _L9
_L8:
        l;
        JVM INSTR tableswitch 99 101: default 336
    //                   99 1072
    //                   100 784
    //                   101 454;
           goto _L10 _L11 _L12 _L13
_L10:
        j1 = i1;
_L45:
        i1 = j;
        j = j1;
        l1 = l;
        l = 0;
        j1 = i1;
        i1 = l;
        l = j;
        j = l1;
_L17:
        l1 = j;
        if (l2 != 0)
        {
            if (j == 101)
            {
                l1 = 100;
            } else
            {
                l1 = 101;
            }
        }
        l2 = i1;
        i1 = l1;
        j = i2;
        i2 = k3;
        k2 = l;
        l = j1;
        l1 = j3;
        j1 = i3;
        i3 = j;
        j = l;
        l = i1;
        i1 = k2;
        k2 = k1;
        k1 = j2;
          goto _L14
_L9:
        throw FormatException.getFormatInstance();
_L13:
        if (k3 >= 64) goto _L16; else goto _L15
_L15:
        ((StringBuilder) (obj)).append((char)(k3 + 32));
        j1 = j;
        j = l;
        l1 = 0;
        l = i1;
        i1 = l1;
          goto _L17
_L16:
        if (k3 >= 96) goto _L19; else goto _L18
_L18:
        ((StringBuilder) (obj)).append((char)(k3 - 64));
        j1 = j;
        j = l;
        l1 = 0;
        l = i1;
        i1 = l1;
          goto _L17
_L19:
        l1 = i1;
        if (k3 != 106)
        {
            l1 = 0;
        }
        j1 = ((flag2) ? 1 : 0);
        k2 = j;
        i1 = l;
        k3;
        JVM INSTR tableswitch 96 106: default 624
    //                   96 636
    //                   97 636
    //                   98 726
    //                   99 755
    //                   100 740
    //                   101 636
    //                   102 655
    //                   103 636
    //                   104 636
    //                   105 636
    //                   106 770;
           goto _L20 _L21 _L21 _L22 _L23 _L24 _L21 _L25 _L21 _L21 _L21 _L26
_L21:
        break; /* Loop/switch isn't completed */
_L20:
        i1 = l;
        k2 = j;
        j1 = ((flag2) ? 1 : 0);
_L27:
        l = l1;
        j = i1;
        i1 = j1;
        j1 = k2;
          goto _L17
_L25:
        j1 = ((flag2) ? 1 : 0);
        k2 = j;
        i1 = l;
        if (flag1)
        {
            if (((StringBuilder) (obj)).length() == 0)
            {
                ((StringBuilder) (obj)).append("]C1");
                j1 = ((flag2) ? 1 : 0);
                k2 = j;
                i1 = l;
            } else
            {
                ((StringBuilder) (obj)).append('\035');
                j1 = ((flag2) ? 1 : 0);
                k2 = j;
                i1 = l;
            }
        }
          goto _L27
_L22:
        j1 = 1;
        i1 = 100;
        k2 = j;
          goto _L27
_L24:
        i1 = 100;
        j1 = ((flag2) ? 1 : 0);
        k2 = j;
          goto _L27
_L23:
        i1 = 99;
        j1 = ((flag2) ? 1 : 0);
        k2 = j;
          goto _L27
_L26:
        k2 = 1;
        j1 = ((flag2) ? 1 : 0);
        i1 = l;
          goto _L27
_L12:
        if (k3 >= 96) goto _L29; else goto _L28
_L28:
        ((StringBuilder) (obj)).append((char)(k3 + 32));
        j1 = j;
        j = l;
        l1 = 0;
        l = i1;
        i1 = l1;
          goto _L17
_L29:
        l1 = i1;
        if (k3 != 106)
        {
            l1 = 0;
        }
        j1 = ((flag3) ? 1 : 0);
        k2 = j;
        i1 = l;
        k3;
        JVM INSTR tableswitch 96 106: default 912
    //                   96 924
    //                   97 924
    //                   98 1014
    //                   99 1043
    //                   100 924
    //                   101 1028
    //                   102 943
    //                   103 924
    //                   104 924
    //                   105 924
    //                   106 1058;
           goto _L30 _L31 _L31 _L32 _L33 _L31 _L34 _L35 _L31 _L31 _L31 _L36
_L31:
        break; /* Loop/switch isn't completed */
_L30:
        i1 = l;
        k2 = j;
        j1 = ((flag3) ? 1 : 0);
_L37:
        l = l1;
        j = i1;
        i1 = j1;
        j1 = k2;
          goto _L17
_L35:
        j1 = ((flag3) ? 1 : 0);
        k2 = j;
        i1 = l;
        if (flag1)
        {
            if (((StringBuilder) (obj)).length() == 0)
            {
                ((StringBuilder) (obj)).append("]C1");
                j1 = ((flag3) ? 1 : 0);
                k2 = j;
                i1 = l;
            } else
            {
                ((StringBuilder) (obj)).append('\035');
                j1 = ((flag3) ? 1 : 0);
                k2 = j;
                i1 = l;
            }
        }
          goto _L37
_L32:
        j1 = 1;
        i1 = 101;
        k2 = j;
          goto _L37
_L34:
        i1 = 101;
        j1 = ((flag3) ? 1 : 0);
        k2 = j;
          goto _L37
_L33:
        i1 = 99;
        j1 = ((flag3) ? 1 : 0);
        k2 = j;
          goto _L37
_L36:
        k2 = 1;
        j1 = ((flag3) ? 1 : 0);
        i1 = l;
          goto _L37
_L11:
        if (k3 >= 100) goto _L39; else goto _L38
_L38:
        if (k3 < 10)
        {
            ((StringBuilder) (obj)).append('0');
        }
        ((StringBuilder) (obj)).append(k3);
        j1 = j;
        j = l;
        l1 = 0;
        l = i1;
        i1 = l1;
          goto _L17
_L39:
        if (k3 != 106)
        {
            i1 = 0;
        }
        k3;
        JVM INSTR tableswitch 100 106: default 1180
    //                   100 1187
    //                   101 1282
    //                   102 1205
    //                   103 1180
    //                   104 1180
    //                   105 1180
    //                   106 1300;
           goto _L40 _L41 _L42 _L43 _L40 _L40 _L40 _L44
_L40:
        j1 = i1;
          goto _L45
_L41:
        j1 = j;
        l = i1;
        j = 100;
        i1 = 0;
          goto _L17
_L43:
        j1 = i1;
        if (!flag1) goto _L45; else goto _L46
_L46:
        if (((StringBuilder) (obj)).length() == 0)
        {
            ((StringBuilder) (obj)).append("]C1");
            j1 = j;
            j = l;
            l1 = 0;
            l = i1;
            i1 = l1;
        } else
        {
            ((StringBuilder) (obj)).append('\035');
            j1 = j;
            j = l;
            l1 = 0;
            l = i1;
            i1 = l1;
        }
          goto _L17
_L42:
        j1 = j;
        l = i1;
        j = 101;
        i1 = 0;
          goto _L17
_L44:
        j1 = 1;
        j = l;
        l1 = 0;
        l = i1;
        i1 = l1;
          goto _L17
_L6:
        int k = bitarray.getNextUnset(k1);
        if (!bitarray.isRange(k, Math.min(bitarray.getSize(), (k - k2) / 2 + k), false))
        {
            throw NotFoundException.getNotFoundInstance();
        }
        if ((j1 - l1 * i3) % 103 != i3)
        {
            throw ChecksumException.getChecksumInstance();
        }
        k = ((StringBuilder) (obj)).length();
        if (k == 0)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        float f;
        float f1;
        float f2;
        if (k > 0 && i1 != 0)
        {
            if (l == 99)
            {
                ((StringBuilder) (obj)).delete(k - 2, k);
            } else
            {
                ((StringBuilder) (obj)).delete(k - 1, k);
            }
        }
        f = (float)(ai[1] + ai[0]) / 2.0F;
        f1 = k2;
        f2 = (float)(k1 - k2) / 2.0F;
        l = map.size();
        bitarray = new byte[l];
        for (k = 0; k < l; k++)
        {
            bitarray[k] = ((Byte)map.get(k)).byteValue();
        }

        map = ((StringBuilder) (obj)).toString();
        obj = new ResultPoint(f, i);
        ResultPoint resultpoint = new ResultPoint(f1 + f2, i);
        BarcodeFormat barcodeformat = BarcodeFormat.CODE_128;
        return new Result(map, bitarray, new ResultPoint[] {
            obj, resultpoint
        }, barcodeformat);
        if (true) goto _L48; else goto _L47
_L47:
    }

    static 
    {
        int ai[] = {
            2, 1, 2, 2, 2, 2
        };
        int ai1[] = {
            2, 2, 2, 1, 2, 2
        };
        int ai2[] = {
            1, 2, 1, 2, 2, 3
        };
        int ai3[] = {
            1, 2, 1, 3, 2, 2
        };
        int ai4[] = {
            1, 2, 2, 2, 1, 3
        };
        int ai5[] = {
            1, 2, 2, 3, 1, 2
        };
        int ai6[] = {
            1, 3, 2, 2, 1, 2
        };
        int ai7[] = {
            2, 2, 1, 2, 1, 3
        };
        int ai8[] = {
            2, 2, 1, 3, 1, 2
        };
        int ai9[] = {
            1, 2, 2, 2, 3, 1
        };
        int ai10[] = {
            1, 1, 3, 2, 2, 2
        };
        int ai11[] = {
            1, 2, 3, 1, 2, 2
        };
        int ai12[] = {
            1, 2, 3, 2, 2, 1
        };
        int ai13[] = {
            2, 2, 1, 2, 3, 1
        };
        int ai14[] = {
            2, 1, 3, 2, 1, 2
        };
        int ai15[] = {
            2, 2, 3, 1, 1, 2
        };
        int ai16[] = {
            3, 1, 2, 1, 3, 1
        };
        int ai17[] = {
            3, 2, 1, 1, 2, 2
        };
        int ai18[] = {
            3, 2, 1, 2, 2, 1
        };
        int ai19[] = {
            2, 1, 2, 1, 2, 3
        };
        int ai20[] = {
            2, 3, 2, 1, 2, 1
        };
        int ai21[] = {
            1, 3, 1, 1, 2, 3
        };
        int ai22[] = {
            1, 3, 2, 1, 1, 3
        };
        int ai23[] = {
            2, 1, 1, 3, 1, 3
        };
        int ai24[] = {
            1, 1, 2, 3, 3, 1
        };
        int ai25[] = {
            1, 1, 3, 3, 2, 1
        };
        int ai26[] = {
            3, 3, 1, 1, 2, 1
        };
        int ai27[] = {
            3, 3, 2, 1, 1, 1
        };
        int ai28[] = {
            2, 2, 1, 4, 1, 1
        };
        int ai29[] = {
            1, 1, 1, 2, 2, 4
        };
        int ai30[] = {
            1, 1, 1, 4, 2, 2
        };
        int ai31[] = {
            1, 2, 1, 1, 2, 4
        };
        int ai32[] = {
            1, 1, 2, 2, 1, 4
        };
        int ai33[] = {
            1, 2, 2, 1, 1, 4
        };
        int ai34[] = {
            1, 2, 2, 4, 1, 1
        };
        int ai35[] = {
            1, 4, 2, 2, 1, 1
        };
        int ai36[] = {
            2, 4, 1, 2, 1, 1
        };
        int ai37[] = {
            2, 2, 1, 1, 1, 4
        };
        int ai38[] = {
            4, 1, 3, 1, 1, 1
        };
        int ai39[] = {
            1, 2, 1, 1, 4, 2
        };
        int ai40[] = {
            1, 2, 1, 2, 4, 1
        };
        int ai41[] = {
            1, 1, 4, 2, 1, 2
        };
        int ai42[] = {
            1, 2, 4, 2, 1, 1
        };
        int ai43[] = {
            4, 2, 1, 2, 1, 1
        };
        int ai44[] = {
            2, 1, 4, 1, 2, 1
        };
        int ai45[] = {
            1, 1, 1, 1, 4, 3
        };
        int ai46[] = {
            1, 1, 1, 3, 4, 1
        };
        int ai47[] = {
            1, 1, 4, 1, 1, 3
        };
        int ai48[] = {
            1, 1, 4, 3, 1, 1
        };
        int ai49[] = {
            4, 1, 1, 1, 1, 3
        };
        int ai50[] = {
            1, 1, 3, 1, 4, 1
        };
        int ai51[] = {
            1, 1, 4, 1, 3, 1
        };
        int ai52[] = {
            3, 1, 1, 1, 4, 1
        };
        int ai53[] = {
            2, 3, 3, 1, 1, 1, 2
        };
        CODE_PATTERNS = (new int[][] {
            ai, ai1, new int[] {
                2, 2, 2, 2, 2, 1
            }, ai2, ai3, new int[] {
                1, 3, 1, 2, 2, 2
            }, ai4, ai5, ai6, ai7, 
            ai8, new int[] {
                2, 3, 1, 2, 1, 2
            }, new int[] {
                1, 1, 2, 2, 3, 2
            }, new int[] {
                1, 2, 2, 1, 3, 2
            }, ai9, ai10, ai11, ai12, new int[] {
                2, 2, 3, 2, 1, 1
            }, new int[] {
                2, 2, 1, 1, 3, 2
            }, 
            ai13, ai14, ai15, ai16, new int[] {
                3, 1, 1, 2, 2, 2
            }, ai17, ai18, new int[] {
                3, 1, 2, 2, 1, 2
            }, new int[] {
                3, 2, 2, 1, 1, 2
            }, new int[] {
                3, 2, 2, 2, 1, 1
            }, 
            ai19, new int[] {
                2, 1, 2, 3, 2, 1
            }, ai20, new int[] {
                1, 1, 1, 3, 2, 3
            }, ai21, new int[] {
                1, 3, 1, 3, 2, 1
            }, new int[] {
                1, 1, 2, 3, 1, 3
            }, ai22, new int[] {
                1, 3, 2, 3, 1, 1
            }, ai23, 
            new int[] {
                2, 3, 1, 1, 1, 3
            }, new int[] {
                2, 3, 1, 3, 1, 1
            }, new int[] {
                1, 1, 2, 1, 3, 3
            }, ai24, new int[] {
                1, 3, 2, 1, 3, 1
            }, new int[] {
                1, 1, 3, 1, 2, 3
            }, ai25, new int[] {
                1, 3, 3, 1, 2, 1
            }, new int[] {
                3, 1, 3, 1, 2, 1
            }, new int[] {
                2, 1, 1, 3, 3, 1
            }, 
            new int[] {
                2, 3, 1, 1, 3, 1
            }, new int[] {
                2, 1, 3, 1, 1, 3
            }, new int[] {
                2, 1, 3, 3, 1, 1
            }, new int[] {
                2, 1, 3, 1, 3, 1
            }, new int[] {
                3, 1, 1, 1, 2, 3
            }, new int[] {
                3, 1, 1, 3, 2, 1
            }, ai26, new int[] {
                3, 1, 2, 1, 1, 3
            }, new int[] {
                3, 1, 2, 3, 1, 1
            }, ai27, 
            new int[] {
                3, 1, 4, 1, 1, 1
            }, ai28, new int[] {
                4, 3, 1, 1, 1, 1
            }, ai29, ai30, ai31, new int[] {
                1, 2, 1, 4, 2, 1
            }, new int[] {
                1, 4, 1, 1, 2, 2
            }, new int[] {
                1, 4, 1, 2, 2, 1
            }, ai32, 
            new int[] {
                1, 1, 2, 4, 1, 2
            }, ai33, ai34, new int[] {
                1, 4, 2, 1, 1, 2
            }, ai35, ai36, ai37, ai38, new int[] {
                2, 4, 1, 1, 1, 2
            }, new int[] {
                1, 3, 4, 1, 1, 1
            }, 
            new int[] {
                1, 1, 1, 2, 4, 2
            }, ai39, ai40, ai41, new int[] {
                1, 2, 4, 1, 1, 2
            }, ai42, new int[] {
                4, 1, 1, 2, 1, 2
            }, new int[] {
                4, 2, 1, 1, 1, 2
            }, ai43, new int[] {
                2, 1, 2, 1, 4, 1
            }, 
            ai44, new int[] {
                4, 1, 2, 1, 2, 1
            }, ai45, ai46, new int[] {
                1, 3, 1, 1, 4, 1
            }, ai47, ai48, ai49, new int[] {
                4, 1, 1, 3, 1, 1
            }, ai50, 
            ai51, ai52, new int[] {
                4, 1, 1, 1, 3, 1
            }, new int[] {
                2, 1, 1, 4, 1, 2
            }, new int[] {
                2, 1, 1, 2, 1, 4
            }, new int[] {
                2, 1, 1, 2, 3, 2
            }, ai53
        });
    }
}
