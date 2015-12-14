// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.graphics;

import java.util.Arrays;

// Referenced classes of package android.support.v7.graphics:
//            ColorCutQuantizer

class fitBox
{

    private int mLowerIndex;
    private int mMaxBlue;
    private int mMaxGreen;
    private int mMaxRed;
    private int mMinBlue;
    private int mMinGreen;
    private int mMinRed;
    private int mPopulation;
    private int mUpperIndex;
    final ColorCutQuantizer this$0;

    final boolean canSplit()
    {
        return getColorCount() > 1;
    }

    final int findSplitPoint()
    {
        int i = getLongestColorDimension();
        int ai[] = mColors;
        int ai1[] = mHistogram;
        ColorCutQuantizer.access$300(ai, i, mLowerIndex, mUpperIndex);
        Arrays.sort(ai, mLowerIndex, mUpperIndex + 1);
        ColorCutQuantizer.access$300(ai, i, mLowerIndex, mUpperIndex);
        int k = mPopulation / 2;
        i = mLowerIndex;
        int j = 0;
        for (; i <= mUpperIndex; i++)
        {
            j += ai1[ai[i]];
            if (j >= k)
            {
                return i;
            }
        }

        return mLowerIndex;
    }

    final void fitBox()
    {
        int ai[] = mColors;
        int ai1[] = mHistogram;
        int l = 0x80000000;
        int i2 = 0;
        int k = mLowerIndex;
        int j2 = 0x80000000;
        int i = 0x7fffffff;
        int j = 0x7fffffff;
        int k1 = 0x7fffffff;
        int j1 = 0x80000000;
        while (k <= mUpperIndex) 
        {
            int i1 = ai[k];
            int i3 = i2 + ai1[i1];
            int l2 = ColorCutQuantizer.access$000(i1);
            int k2 = ColorCutQuantizer.access$100(i1);
            i2 = ColorCutQuantizer.access$200(i1);
            i1 = j2;
            if (l2 > j2)
            {
                i1 = l2;
            }
            int l1 = k1;
            if (l2 < k1)
            {
                l1 = l2;
            }
            k1 = j1;
            if (k2 > j1)
            {
                k1 = k2;
            }
            l2 = j;
            if (k2 < j)
            {
                l2 = k2;
            }
            j1 = l;
            if (i2 > l)
            {
                j1 = i2;
            }
            j = i;
            if (i2 < i)
            {
                j = i2;
            }
            k++;
            i2 = i3;
            l = j1;
            j1 = k1;
            j2 = i1;
            i = j;
            j = l2;
            k1 = l1;
        }
        mMinRed = k1;
        mMaxRed = j2;
        mMinGreen = j;
        mMaxGreen = j1;
        mMinBlue = i;
        mMaxBlue = l;
        mPopulation = i2;
    }

    final mPopulation getAverageColor()
    {
        int i1 = 0;
        int ai[] = mColors;
        int ai1[] = mHistogram;
        int l = mLowerIndex;
        int i = 0;
        int j = 0;
        int k = 0;
        for (; l <= mUpperIndex; l++)
        {
            int j1 = ai[l];
            int k1 = ai1[j1];
            i1 += k1;
            k += ColorCutQuantizer.access$000(j1) * k1;
            j += ColorCutQuantizer.access$100(j1) * k1;
            i += ColorCutQuantizer.access$200(j1) * k1;
        }

        return new s._cls200(ColorCutQuantizer.access$400(Math.round((float)k / (float)i1), Math.round((float)j / (float)i1), Math.round((float)i / (float)i1)), i1);
    }

    final int getColorCount()
    {
        return (mUpperIndex + 1) - mLowerIndex;
    }

    final int getLongestColorDimension()
    {
        int i = mMaxRed - mMinRed;
        int j = mMaxGreen - mMinGreen;
        int k = mMaxBlue - mMinBlue;
        if (i >= j && i >= k)
        {
            return -3;
        }
        return j < i || j < k ? -1 : -2;
    }

    final int getVolume()
    {
        return ((mMaxRed - mMinRed) + 1) * ((mMaxGreen - mMinGreen) + 1) * ((mMaxBlue - mMinBlue) + 1);
    }

    final mMinBlue splitBox()
    {
        if (!canSplit())
        {
            throw new IllegalStateException("Can not split a box with only 1 color");
        } else
        {
            int i = findSplitPoint();
            mMinBlue mminblue = new <init>(i + 1, mUpperIndex);
            mUpperIndex = i;
            fitBox();
            return mminblue;
        }
    }

    (int i, int j)
    {
        this$0 = ColorCutQuantizer.this;
        super();
        mLowerIndex = i;
        mUpperIndex = j;
        fitBox();
    }
}
