// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.graphics;

import android.support.v4.graphics.ColorUtils;
import java.util.Iterator;
import java.util.List;

class DefaultGenerator extends Palette.Generator
{

    private static final float MAX_DARK_LUMA = 0.45F;
    private static final float MAX_MUTED_SATURATION = 0.4F;
    private static final float MAX_NORMAL_LUMA = 0.7F;
    private static final float MIN_LIGHT_LUMA = 0.55F;
    private static final float MIN_NORMAL_LUMA = 0.3F;
    private static final float MIN_VIBRANT_SATURATION = 0.35F;
    private static final float TARGET_DARK_LUMA = 0.26F;
    private static final float TARGET_LIGHT_LUMA = 0.74F;
    private static final float TARGET_MUTED_SATURATION = 0.3F;
    private static final float TARGET_NORMAL_LUMA = 0.5F;
    private static final float TARGET_VIBRANT_SATURATION = 1F;
    private static final float WEIGHT_LUMA = 6F;
    private static final float WEIGHT_POPULATION = 1F;
    private static final float WEIGHT_SATURATION = 3F;
    private Palette.Swatch mDarkMutedSwatch;
    private Palette.Swatch mDarkVibrantSwatch;
    private int mHighestPopulation;
    private Palette.Swatch mLightMutedSwatch;
    private Palette.Swatch mLightVibrantSwatch;
    private Palette.Swatch mMutedSwatch;
    private List mSwatches;
    private Palette.Swatch mVibrantSwatch;

    DefaultGenerator()
    {
    }

    private static float[] copyHslValues(Palette.Swatch swatch)
    {
        float af[] = new float[3];
        System.arraycopy(swatch.getHsl(), 0, af, 0, 3);
        return af;
    }

    private static float createComparisonValue(float f, float f1, float f2, float f3, float f4, float f5, int i, int j, 
            float f6)
    {
        return weightedMean(new float[] {
            invertDiff(f, f1), f2, invertDiff(f3, f4), f5, (float)i / (float)j, f6
        });
    }

    private static float createComparisonValue(float f, float f1, float f2, float f3, int i, int j)
    {
        return createComparisonValue(f, f1, 3F, f2, f3, 6F, i, j, 1.0F);
    }

    private Palette.Swatch findColorVariation(float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6;
        Palette.Swatch swatch;
        Iterator iterator;
        swatch = null;
        f6 = 0.0F;
        iterator = mSwatches.iterator();
_L2:
        float f7;
        Palette.Swatch swatch1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        Palette.Swatch swatch2 = (Palette.Swatch)iterator.next();
        f7 = swatch2.getHsl()[1];
        float f8 = swatch2.getHsl()[2];
        if (f7 < f4 || f7 > f5 || f8 < f1 || f8 > f2 || isAlreadySelected(swatch2))
        {
            break MISSING_BLOCK_LABEL_160;
        }
        f8 = createComparisonValue(f7, f3, f8, f, swatch2.getPopulation(), mHighestPopulation);
        f7 = f8;
        swatch1 = swatch2;
        if (swatch != null)
        {
            if (f8 <= f6)
            {
                break MISSING_BLOCK_LABEL_160;
            }
            swatch1 = swatch2;
            f7 = f8;
        }
_L3:
        f6 = f7;
        swatch = swatch1;
        if (true) goto _L2; else goto _L1
_L1:
        return swatch;
        f7 = f6;
        swatch1 = swatch;
          goto _L3
    }

    private int findMaxPopulation()
    {
        Iterator iterator = mSwatches.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = Math.max(i, ((Palette.Swatch)iterator.next()).getPopulation())) { }
        return i;
    }

    private void generateEmptySwatches()
    {
        if (mVibrantSwatch == null && mDarkVibrantSwatch != null)
        {
            float af[] = copyHslValues(mDarkVibrantSwatch);
            af[2] = 0.5F;
            mVibrantSwatch = new Palette.Swatch(ColorUtils.HSLToColor(af), 0);
        }
        if (mDarkVibrantSwatch == null && mVibrantSwatch != null)
        {
            float af1[] = copyHslValues(mVibrantSwatch);
            af1[2] = 0.26F;
            mDarkVibrantSwatch = new Palette.Swatch(ColorUtils.HSLToColor(af1), 0);
        }
    }

    private void generateVariationColors()
    {
        mVibrantSwatch = findColorVariation(0.5F, 0.3F, 0.7F, 1.0F, 0.35F, 1.0F);
        mLightVibrantSwatch = findColorVariation(0.74F, 0.55F, 1.0F, 1.0F, 0.35F, 1.0F);
        mDarkVibrantSwatch = findColorVariation(0.26F, 0.0F, 0.45F, 1.0F, 0.35F, 1.0F);
        mMutedSwatch = findColorVariation(0.5F, 0.3F, 0.7F, 0.3F, 0.0F, 0.4F);
        mLightMutedSwatch = findColorVariation(0.74F, 0.55F, 1.0F, 0.3F, 0.0F, 0.4F);
        mDarkMutedSwatch = findColorVariation(0.26F, 0.0F, 0.45F, 0.3F, 0.0F, 0.4F);
    }

    private static float invertDiff(float f, float f1)
    {
        return 1.0F - Math.abs(f - f1);
    }

    private boolean isAlreadySelected(Palette.Swatch swatch)
    {
        return mVibrantSwatch == swatch || mDarkVibrantSwatch == swatch || mLightVibrantSwatch == swatch || mMutedSwatch == swatch || mDarkMutedSwatch == swatch || mLightMutedSwatch == swatch;
    }

    private static transient float weightedMean(float af[])
    {
        float f = 0.0F;
        int i = 0;
        float f1 = 0.0F;
        for (; i < af.length; i += 2)
        {
            float f3 = af[i];
            float f2 = af[i + 1];
            f1 += f3 * f2;
            f += f2;
        }

        return f1 / f;
    }

    public void generate(List list)
    {
        mSwatches = list;
        mHighestPopulation = findMaxPopulation();
        generateVariationColors();
        generateEmptySwatches();
    }

    public Palette.Swatch getDarkMutedSwatch()
    {
        return mDarkMutedSwatch;
    }

    public Palette.Swatch getDarkVibrantSwatch()
    {
        return mDarkVibrantSwatch;
    }

    public Palette.Swatch getLightMutedSwatch()
    {
        return mLightMutedSwatch;
    }

    public Palette.Swatch getLightVibrantSwatch()
    {
        return mLightVibrantSwatch;
    }

    public Palette.Swatch getMutedSwatch()
    {
        return mMutedSwatch;
    }

    public Palette.Swatch getVibrantSwatch()
    {
        return mVibrantSwatch;
    }
}
