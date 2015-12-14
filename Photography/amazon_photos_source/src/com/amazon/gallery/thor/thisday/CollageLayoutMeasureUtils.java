// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import java.lang.reflect.Array;

public class CollageLayoutMeasureUtils
{
    public static class IntTuple
    {

        public final int first;
        public final int second;

        IntTuple(int i, int j)
        {
            first = i;
            second = j;
        }
    }


    private boolean cacheInitialized;
    private IntTuple imageBoundsMap[][];
    private byte marginsMap[][];
    private byte reverseLayoutMarginsMap[][];

    public CollageLayoutMeasureUtils()
    {
        imageBoundsMap = (IntTuple[][])Array.newInstance(com/amazon/gallery/thor/thisday/CollageLayoutMeasureUtils$IntTuple, new int[] {
            5, 5
        });
        marginsMap = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            5, 5
        });
        reverseLayoutMarginsMap = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            5, 5
        });
        cacheInitialized = false;
    }

    public IntTuple getBoundingBoxForCollageImage(int i, int j)
    {
        if (!cacheInitialized)
        {
            throw new IllegalStateException("Cache has not been initialized yet");
        } else
        {
            return imageBoundsMap[i - 1][j];
        }
    }

    public byte getMarginsBitmaskForCollageItem(int i, int j, boolean flag)
    {
        if (!cacheInitialized)
        {
            throw new IllegalStateException("Cache has not been initialized yet");
        }
        if (flag)
        {
            return reverseLayoutMarginsMap[i - 1][j];
        } else
        {
            return marginsMap[i - 1][j];
        }
    }

    public void initializeDimensCache(int i, int j, float f)
    {
        int k = Math.round((float)i * f);
        int l = Math.round((float)i * (1.0F - f));
        int i1 = l / 2;
        int j1 = j / 2;
        IntTuple inttuple = new IntTuple(k, j);
        IntTuple inttuple1 = new IntTuple(l, j1);
        IntTuple inttuple2 = new IntTuple(i1, j1);
        IntTuple inttuple3 = new IntTuple(i, j);
        IntTuple inttuple4 = new IntTuple(l, j);
        imageBoundsMap[0] = (new IntTuple[] {
            inttuple3, null, null, null, null
        });
        imageBoundsMap[1] = (new IntTuple[] {
            inttuple, inttuple4, null, null, null
        });
        imageBoundsMap[2] = (new IntTuple[] {
            inttuple, inttuple1, inttuple1, null, null
        });
        imageBoundsMap[3] = (new IntTuple[] {
            inttuple, inttuple1, inttuple2, inttuple2, null
        });
        imageBoundsMap[4] = (new IntTuple[] {
            inttuple, inttuple2, inttuple2, inttuple2, inttuple2
        });
        marginsMap[0] = (new byte[] {
            4, 0, 0, 0, 0
        });
        marginsMap[1] = (new byte[] {
            4, 12, 0, 0, 0
        });
        marginsMap[2] = (new byte[] {
            4, 12, 12, 0, 0
        });
        marginsMap[3] = (new byte[] {
            4, 12, 12, 12, 0
        });
        marginsMap[4] = (new byte[] {
            4, 12, 12, 12, 12
        });
        reverseLayoutMarginsMap[0] = (new byte[] {
            4, 0, 0, 0, 0
        });
        reverseLayoutMarginsMap[1] = (new byte[] {
            4, 6, 0, 0, 0
        });
        reverseLayoutMarginsMap[2] = (new byte[] {
            4, 6, 6, 0, 0
        });
        reverseLayoutMarginsMap[3] = (new byte[] {
            4, 6, 6, 6, 0
        });
        reverseLayoutMarginsMap[4] = (new byte[] {
            4, 6, 6, 6, 6
        });
        cacheInitialized = true;
    }
}
