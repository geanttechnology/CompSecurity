// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.zxing.pdf417.detector:
//            PDF417DetectorResult

public final class Detector
{

    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final int INDEXES_START_PATTERN[] = {
        0, 4, 1, 5
    };
    private static final int INDEXES_STOP_PATTERN[] = {
        6, 2, 7, 3
    };
    private static final int INTEGER_MATH_SHIFT = 8;
    private static final int MAX_AVG_VARIANCE = 107;
    private static final int MAX_INDIVIDUAL_VARIANCE = 204;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int PATTERN_MATCH_RESULT_SCALE_FACTOR = 256;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int START_PATTERN[] = {
        8, 1, 1, 1, 1, 1, 1, 3
    };
    private static final int STOP_PATTERN[] = {
        7, 1, 1, 3, 1, 1, 1, 2, 1
    };

    private Detector()
    {
    }

    private static void copyToResult(ResultPoint aresultpoint[], ResultPoint aresultpoint1[], int ai[])
    {
        for (int i = 0; i < ai.length; i++)
        {
            aresultpoint[ai[i]] = aresultpoint1[i];
        }

    }

    public static PDF417DetectorResult detect(BinaryBitmap binarybitmap, Map map, boolean flag)
    {
        BitMatrix bitmatrix = binarybitmap.getBlackMatrix();
        map = detect(flag, bitmatrix);
        binarybitmap = map;
        if (map.isEmpty())
        {
            rotate180(bitmatrix);
            binarybitmap = detect(flag, bitmatrix);
        }
        return new PDF417DetectorResult(bitmatrix, binarybitmap);
    }

    private static List detect(boolean flag, BitMatrix bitmatrix)
    {
        ArrayList arraylist;
        int i;
        int j;
        int k;
        arraylist = new ArrayList();
        j = 0;
        k = 0;
        i = 0;
_L8:
        if (i >= bitmatrix.getHeight()) goto _L2; else goto _L1
_L1:
        Object obj = findVertices(bitmatrix, i, k);
        if (obj[0] != null || obj[3] != null) goto _L4; else goto _L3
_L3:
        if (j != 0) goto _L5; else goto _L2
_L2:
        return arraylist;
_L5:
        obj = arraylist.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            ResultPoint aresultpoint[] = (ResultPoint[])((Iterator) (obj)).next();
            j = i;
            if (aresultpoint[1] != null)
            {
                j = (int)Math.max(i, aresultpoint[1].getY());
            }
            i = j;
            if (aresultpoint[3] != null)
            {
                i = Math.max(j, (int)aresultpoint[3].getY());
            }
        } while (true);
        k = 0;
        i += 5;
        j = 0;
        continue; /* Loop/switch isn't completed */
_L4:
        arraylist.add(obj);
        if (!flag) goto _L2; else goto _L6
_L6:
        int l;
        if (obj[2] != null)
        {
            i = (int)obj[2].getX();
            j = (int)obj[2].getY();
        } else
        {
            i = (int)obj[4].getX();
            j = (int)obj[4].getY();
        }
        l = j;
        j = 1;
        k = i;
        i = l;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static int[] findGuardPattern(BitMatrix bitmatrix, int i, int j, int k, boolean flag, int ai[], int ai1[])
    {
        Arrays.fill(ai1, 0, ai1.length, 0);
        int k1 = ai.length;
        for (int l = 0; bitmatrix.get(i, j) && i > 0 && l < 3; l++)
        {
            i--;
        }

        boolean flag1 = false;
        int i1 = i;
        int j1 = i;
        i = i1;
        i1 = ((flag1) ? 1 : 0);
        while (j1 < k) 
        {
            if (bitmatrix.get(j1, j) ^ flag)
            {
                ai1[i1] = ai1[i1] + 1;
            } else
            {
                if (i1 == k1 - 1)
                {
                    if (patternMatchVariance(ai1, ai, 204) < 107)
                    {
                        return (new int[] {
                            i, j1
                        });
                    }
                    i += ai1[0] + ai1[1];
                    System.arraycopy(ai1, 2, ai1, 0, k1 - 2);
                    ai1[k1 - 2] = 0;
                    ai1[k1 - 1] = 0;
                    i1--;
                } else
                {
                    i1++;
                }
                ai1[i1] = 1;
                if (!flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            j1++;
        }
        if (i1 == k1 - 1 && patternMatchVariance(ai1, ai, 204) < 107)
        {
            return (new int[] {
                i, j1 - 1
            });
        } else
        {
            return null;
        }
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitmatrix, int i, int j, int k, int l, int ai[])
    {
        ResultPoint aresultpoint[];
        int ai4[];
        aresultpoint = new ResultPoint[4];
        ai4 = new int[ai.length];
_L10:
        int ai1[];
        if (k >= i)
        {
            break MISSING_BLOCK_LABEL_354;
        }
        ai1 = findGuardPattern(bitmatrix, l, k, j, false, ai, ai4);
        if (ai1 == null) goto _L2; else goto _L1
_L1:
label0:
        {
            int i1 = k;
            do
            {
                k = i1;
                if (i1 <= 0)
                {
                    break label0;
                }
                i1--;
                int ai2[] = findGuardPattern(bitmatrix, l, i1, j, false, ai, ai4);
                if (ai2 == null)
                {
                    break;
                }
                ai1 = ai2;
            } while (true);
            k = i1 + 1;
        }
        aresultpoint[0] = new ResultPoint(ai1[0], k);
        aresultpoint[1] = new ResultPoint(ai1[1], k);
        boolean flag = true;
        l = k;
        k = ((flag) ? 1 : 0);
_L13:
        int j1;
        int k1;
        j1 = l + 1;
        k1 = j1;
        if (k == 0) goto _L4; else goto _L3
_L3:
        ai1 = new int[2];
        ai1[0] = (int)aresultpoint[0].getX();
        ai1[1] = (int)aresultpoint[1].getX();
        k = 0;
_L9:
        if (j1 >= i) goto _L6; else goto _L5
_L5:
        int ai3[] = findGuardPattern(bitmatrix, ai1[0], j1, j, false, ai, ai4);
        if (ai3 == null || Math.abs(ai1[0] - ai3[0]) >= 5 || Math.abs(ai1[1] - ai3[1]) >= 5) goto _L8; else goto _L7
_L7:
        k = 0;
        ai1 = ai3;
_L12:
        j1++;
          goto _L9
_L2:
        k += 5;
          goto _L10
_L8:
        if (k <= 25) goto _L11; else goto _L6
_L6:
        k1 = j1 - (k + 1);
        aresultpoint[2] = new ResultPoint(ai1[0], k1);
        aresultpoint[3] = new ResultPoint(ai1[1], k1);
          goto _L4
_L11:
        k++;
          goto _L12
_L4:
        if (k1 - l < 10)
        {
            for (i = 0; i < aresultpoint.length; i++)
            {
                aresultpoint[i] = null;
            }

        }
        return aresultpoint;
        boolean flag1 = false;
        l = k;
        k = ((flag1) ? 1 : 0);
          goto _L13
    }

    private static ResultPoint[] findVertices(BitMatrix bitmatrix, int i, int j)
    {
        int k = bitmatrix.getHeight();
        int l = bitmatrix.getWidth();
        ResultPoint aresultpoint[] = new ResultPoint[8];
        copyToResult(aresultpoint, findRowsWithPattern(bitmatrix, k, l, i, j, START_PATTERN), INDEXES_START_PATTERN);
        if (aresultpoint[4] != null)
        {
            j = (int)aresultpoint[4].getX();
            i = (int)aresultpoint[4].getY();
        }
        copyToResult(aresultpoint, findRowsWithPattern(bitmatrix, k, l, i, j, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return aresultpoint;
    }

    static BitArray mirror(BitArray bitarray, BitArray bitarray1)
    {
        bitarray1.clear();
        int j = bitarray.getSize();
        for (int i = 0; i < j; i++)
        {
            if (bitarray.get(i))
            {
                bitarray1.set(j - 1 - i);
            }
        }

        return bitarray1;
    }

    private static int patternMatchVariance(int ai[], int ai1[], int i)
    {
        int j;
        int i1;
        int k1;
        k1 = ai.length;
        int k = 0;
        i1 = 0;
        j = 0;
        for (; k < k1; k++)
        {
            j += ai[k];
            i1 += ai1[k];
        }

        if (j >= i1) goto _L2; else goto _L1
_L1:
        return 0x7fffffff;
_L2:
        int l1 = (j << 8) / i1;
        int l = 0;
        i1 = 0;
        do
        {
label0:
            {
                if (l >= k1)
                {
                    break label0;
                }
                int j1 = ai[l] << 8;
                int i2 = ai1[l] * l1;
                if (j1 > i2)
                {
                    j1 -= i2;
                } else
                {
                    j1 = i2 - j1;
                }
                if (j1 > i * l1 >> 8)
                {
                    continue; /* Loop/switch isn't completed */
                }
                i1 += j1;
                l++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return i1 / j;
    }

    static void rotate180(BitMatrix bitmatrix)
    {
        int i = bitmatrix.getWidth();
        int k = bitmatrix.getHeight();
        BitArray bitarray = new BitArray(i);
        BitArray bitarray1 = new BitArray(i);
        BitArray bitarray2 = new BitArray(i);
        for (int j = 0; j < k + 1 >> 1; j++)
        {
            bitarray = bitmatrix.getRow(j, bitarray);
            bitmatrix.setRow(j, mirror(bitmatrix.getRow(k - 1 - j, bitarray1), bitarray2));
            bitmatrix.setRow(k - 1 - j, mirror(bitarray, bitarray2));
        }

    }

}
