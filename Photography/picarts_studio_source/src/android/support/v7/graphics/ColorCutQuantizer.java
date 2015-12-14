// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.graphics;

import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

final class ColorCutQuantizer
{

    private static final int COMPONENT_BLUE = -1;
    private static final int COMPONENT_GREEN = -2;
    private static final int COMPONENT_RED = -3;
    private static final String LOG_TAG = "ColorCutQuantizer";
    private static final boolean LOG_TIMINGS = false;
    private static final int QUANTIZE_WORD_MASK = 31;
    private static final int QUANTIZE_WORD_WIDTH = 5;
    private static final Comparator VBOX_COMPARATOR_VOLUME = new _cls1();
    final int mColors[];
    final Palette.Filter mFilters[];
    final int mHistogram[];
    final List mQuantizedColors;
    private final float mTempHsl[] = new float[3];
    final TimingLogger mTimingLogger = null;

    ColorCutQuantizer(int ai[], int i, Palette.Filter afilter[])
    {
        boolean flag = false;
        super();
        mFilters = afilter;
        afilter = new int[32768];
        mHistogram = afilter;
        for (int j = 0; j < ai.length; j++)
        {
            int i1 = quantizeFromRgb888(ai[j]);
            ai[j] = i1;
            afilter[i1] = afilter[i1] + 1;
        }

        int k = 0;
        int j1;
        int l1;
        for (j1 = 0; k < 32768; j1 = l1)
        {
            if (afilter[k] > 0 && shouldIgnoreColor(k))
            {
                afilter[k] = 0;
            }
            l1 = j1;
            if (afilter[k] > 0)
            {
                l1 = j1 + 1;
            }
            k++;
        }

        ai = new int[j1];
        mColors = ai;
        int i2 = 0;
        k = 0;
        for (; i2 < 32768; i2++)
        {
            if (afilter[i2] > 0)
            {
                int j2 = k + 1;
                ai[k] = i2;
                k = j2;
            }
        }

        if (j1 <= i)
        {
            mQuantizedColors = new ArrayList();
            int l = ai.length;
            for (i = ((flag) ? 1 : 0); i < l; i++)
            {
                int k1 = ai[i];
                mQuantizedColors.add(new Palette.Swatch(approximateToRgb888(k1), afilter[k1]));
            }

        } else
        {
            mQuantizedColors = quantizePixels(i);
        }
    }

    private static int approximateToRgb888(int i)
    {
        return approximateToRgb888(quantizedRed(i), quantizedGreen(i), quantizedBlue(i));
    }

    private static int approximateToRgb888(int i, int j, int k)
    {
        return Color.rgb(modifyWordWidth(i, 5, 8), modifyWordWidth(j, 5, 8), modifyWordWidth(k, 5, 8));
    }

    private List generateAverageColors(Collection collection)
    {
        ArrayList arraylist = new ArrayList(collection.size());
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            Palette.Swatch swatch = ((Vbox)collection.next()).getAverageColor();
            if (!shouldIgnoreColor(swatch))
            {
                arraylist.add(swatch);
            }
        } while (true);
        return arraylist;
    }

    private static void modifySignificantOctet(int ai[], int i, int j, int k)
    {
        int l = j;
        i;
        JVM INSTR tableswitch -3 -1: default 32
    //                   -3 32
    //                   -2 33
    //                   -1 82;
           goto _L1 _L1 _L2 _L3
_L1:
        return;
_L2:
        while (l <= k) 
        {
            i = ai[l];
            j = quantizedGreen(i);
            int j1 = quantizedRed(i);
            ai[l] = quantizedBlue(i) | (j << 10 | j1 << 5);
            l++;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        while (j <= k) 
        {
            i = ai[j];
            int i1 = quantizedBlue(i);
            int k1 = quantizedGreen(i);
            ai[j] = quantizedRed(i) | (i1 << 10 | k1 << 5);
            j++;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private static int modifyWordWidth(int i, int j, int k)
    {
        if (k > j)
        {
            i <<= k - j;
        } else
        {
            i >>= j - k;
        }
        return i & (1 << k) - 1;
    }

    private static int quantizeFromRgb888(int i)
    {
        return modifyWordWidth(Color.red(i), 8, 5) << 10 | modifyWordWidth(Color.green(i), 8, 5) << 5 | modifyWordWidth(Color.blue(i), 8, 5);
    }

    private List quantizePixels(int i)
    {
        PriorityQueue priorityqueue = new PriorityQueue(i, VBOX_COMPARATOR_VOLUME);
        priorityqueue.offer(new Vbox(0, mColors.length - 1));
        splitBoxes(priorityqueue, i);
        return generateAverageColors(priorityqueue);
    }

    private static int quantizedBlue(int i)
    {
        return i & 0x1f;
    }

    private static int quantizedGreen(int i)
    {
        return i >> 5 & 0x1f;
    }

    private static int quantizedRed(int i)
    {
        return i >> 10 & 0x1f;
    }

    private boolean shouldIgnoreColor(int i)
    {
        i = approximateToRgb888(i);
        ColorUtils.colorToHSL(i, mTempHsl);
        return shouldIgnoreColor(i, mTempHsl);
    }

    private boolean shouldIgnoreColor(int i, float af[])
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (mFilters == null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (mFilters.length <= 0) goto _L2; else goto _L3
_L3:
        int j;
        int k;
        k = mFilters.length;
        j = 0;
_L8:
        flag = flag1;
        if (j >= k) goto _L2; else goto _L4
_L4:
        if (mFilters[j].isAllowed(i, af)) goto _L6; else goto _L5
_L5:
        flag = true;
_L2:
        return flag;
_L6:
        j++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private boolean shouldIgnoreColor(Palette.Swatch swatch)
    {
        return shouldIgnoreColor(swatch.getRgb(), swatch.getHsl());
    }

    private void splitBoxes(PriorityQueue priorityqueue, int i)
    {
        do
        {
            if (priorityqueue.size() >= i)
            {
                break;
            }
            Vbox vbox = (Vbox)priorityqueue.poll();
            if (vbox == null || !vbox.canSplit())
            {
                break;
            }
            priorityqueue.offer(vbox.splitBox());
            priorityqueue.offer(vbox);
        } while (true);
    }

    final List getQuantizedColors()
    {
        return mQuantizedColors;
    }







    private class Vbox
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
            ColorCutQuantizer.modifySignificantOctet(ai, i, mLowerIndex, mUpperIndex);
            Arrays.sort(ai, mLowerIndex, mUpperIndex + 1);
            ColorCutQuantizer.modifySignificantOctet(ai, i, mLowerIndex, mUpperIndex);
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
                int l2 = ColorCutQuantizer.quantizedRed(i1);
                int k2 = ColorCutQuantizer.quantizedGreen(i1);
                i2 = ColorCutQuantizer.quantizedBlue(i1);
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

        final Palette.Swatch getAverageColor()
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
                k += ColorCutQuantizer.quantizedRed(j1) * k1;
                j += ColorCutQuantizer.quantizedGreen(j1) * k1;
                i += ColorCutQuantizer.quantizedBlue(j1) * k1;
            }

            return new Palette.Swatch(ColorCutQuantizer.approximateToRgb888(Math.round((float)k / (float)i1), Math.round((float)j / (float)i1), Math.round((float)i / (float)i1)), i1);
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

        final Vbox splitBox()
        {
            if (!canSplit())
            {
                throw new IllegalStateException("Can not split a box with only 1 color");
            } else
            {
                int i = findSplitPoint();
                Vbox vbox = new Vbox(i + 1, mUpperIndex);
                mUpperIndex = i;
                fitBox();
                return vbox;
            }
        }

        Vbox(int i, int j)
        {
            this$0 = ColorCutQuantizer.this;
            super();
            mLowerIndex = i;
            mUpperIndex = j;
            fitBox();
        }
    }


    /* member class not found */
    class _cls1 {}

}
