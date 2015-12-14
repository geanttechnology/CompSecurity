// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.graphics;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.util.Collections;
import java.util.List;

public final class Palette
{

    private static final int DEFAULT_CALCULATE_NUMBER_COLORS = 16;
    private static final Filter DEFAULT_FILTER = new _cls1();
    private static final int DEFAULT_RESIZE_BITMAP_MAX_DIMENSION = 192;
    private static final String LOG_TAG = "Palette";
    private static final boolean LOG_TIMINGS = false;
    private static final float MIN_CONTRAST_BODY_TEXT = 4.5F;
    private static final float MIN_CONTRAST_TITLE_TEXT = 3F;
    private final Generator mGenerator;
    private final List mSwatches;

    private Palette(List list, Generator generator)
    {
        mSwatches = list;
        mGenerator = generator;
    }

    Palette(List list, Generator generator, _cls1 _pcls1)
    {
        this(list, generator);
    }

    public static Builder from(Bitmap bitmap)
    {
        return new Builder(bitmap);
    }

    public static Palette from(List list)
    {
        return (new Builder(list)).generate();
    }

    public static Palette generate(Bitmap bitmap)
    {
        return from(bitmap).generate();
    }

    public static Palette generate(Bitmap bitmap, int i)
    {
        return from(bitmap).maximumColorCount(i).generate();
    }

    public static AsyncTask generateAsync(Bitmap bitmap, int i, PaletteAsyncListener paletteasynclistener)
    {
        return from(bitmap).maximumColorCount(i).generate(paletteasynclistener);
    }

    public static AsyncTask generateAsync(Bitmap bitmap, PaletteAsyncListener paletteasynclistener)
    {
        return from(bitmap).generate(paletteasynclistener);
    }

    private static Bitmap scaleBitmapDown(Bitmap bitmap, int i)
    {
        int j = Math.max(bitmap.getWidth(), bitmap.getHeight());
        if (j <= i)
        {
            return bitmap;
        } else
        {
            double d = (double)i / (double)j;
            return Bitmap.createScaledBitmap(bitmap, (int)Math.ceil((double)bitmap.getWidth() * d), (int)Math.ceil(d * (double)bitmap.getHeight()), false);
        }
    }

    public final int getDarkMutedColor(int i)
    {
        Swatch swatch = getDarkMutedSwatch();
        if (swatch != null)
        {
            i = swatch.getRgb();
        }
        return i;
    }

    public final Swatch getDarkMutedSwatch()
    {
        return mGenerator.getDarkMutedSwatch();
    }

    public final int getDarkVibrantColor(int i)
    {
        Swatch swatch = getDarkVibrantSwatch();
        if (swatch != null)
        {
            i = swatch.getRgb();
        }
        return i;
    }

    public final Swatch getDarkVibrantSwatch()
    {
        return mGenerator.getDarkVibrantSwatch();
    }

    public final int getLightMutedColor(int i)
    {
        Swatch swatch = getLightMutedSwatch();
        if (swatch != null)
        {
            i = swatch.getRgb();
        }
        return i;
    }

    public final Swatch getLightMutedSwatch()
    {
        return mGenerator.getLightMutedSwatch();
    }

    public final int getLightVibrantColor(int i)
    {
        Swatch swatch = getLightVibrantSwatch();
        if (swatch != null)
        {
            i = swatch.getRgb();
        }
        return i;
    }

    public final Swatch getLightVibrantSwatch()
    {
        return mGenerator.getLightVibrantSwatch();
    }

    public final int getMutedColor(int i)
    {
        Swatch swatch = getMutedSwatch();
        if (swatch != null)
        {
            i = swatch.getRgb();
        }
        return i;
    }

    public final Swatch getMutedSwatch()
    {
        return mGenerator.getMutedSwatch();
    }

    public final List getSwatches()
    {
        return Collections.unmodifiableList(mSwatches);
    }

    public final int getVibrantColor(int i)
    {
        Swatch swatch = getVibrantSwatch();
        if (swatch != null)
        {
            i = swatch.getRgb();
        }
        return i;
    }

    public final Swatch getVibrantSwatch()
    {
        return mGenerator.getVibrantSwatch();
    }




    /* member class not found */
    class Builder {}


    private class Swatch
    {

        private final int mBlue;
        private int mBodyTextColor;
        private boolean mGeneratedTextColors;
        private final int mGreen;
        private float mHsl[];
        private final int mPopulation;
        private final int mRed;
        private final int mRgb;
        private int mTitleTextColor;

        private void ensureTextColorsGenerated()
        {
            int i;
            int j;
label0:
            {
                if (!mGeneratedTextColors)
                {
                    i = ColorUtils.calculateMinimumAlpha(-1, mRgb, 4.5F);
                    j = ColorUtils.calculateMinimumAlpha(-1, mRgb, 3F);
                    if (i == -1 || j == -1)
                    {
                        break label0;
                    }
                    mBodyTextColor = ColorUtils.setAlphaComponent(-1, i);
                    mTitleTextColor = ColorUtils.setAlphaComponent(-1, j);
                    mGeneratedTextColors = true;
                }
                return;
            }
            int l = ColorUtils.calculateMinimumAlpha(0xff000000, mRgb, 4.5F);
            int k = ColorUtils.calculateMinimumAlpha(0xff000000, mRgb, 3F);
            if (l != -1 && l != -1)
            {
                mBodyTextColor = ColorUtils.setAlphaComponent(0xff000000, l);
                mTitleTextColor = ColorUtils.setAlphaComponent(0xff000000, k);
                mGeneratedTextColors = true;
                return;
            }
            if (i != -1)
            {
                i = ColorUtils.setAlphaComponent(-1, i);
            } else
            {
                i = ColorUtils.setAlphaComponent(0xff000000, l);
            }
            mBodyTextColor = i;
            if (j != -1)
            {
                i = ColorUtils.setAlphaComponent(-1, j);
            } else
            {
                i = ColorUtils.setAlphaComponent(0xff000000, k);
            }
            mTitleTextColor = i;
            mGeneratedTextColors = true;
        }

        public final boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (Swatch)obj;
                if (mPopulation != ((Swatch) (obj)).mPopulation || mRgb != ((Swatch) (obj)).mRgb)
                {
                    return false;
                }
            }
            return true;
        }

        public final int getBodyTextColor()
        {
            ensureTextColorsGenerated();
            return mBodyTextColor;
        }

        public final float[] getHsl()
        {
            if (mHsl == null)
            {
                mHsl = new float[3];
                ColorUtils.RGBToHSL(mRed, mGreen, mBlue, mHsl);
            }
            return mHsl;
        }

        public final int getPopulation()
        {
            return mPopulation;
        }

        public final int getRgb()
        {
            return mRgb;
        }

        public final int getTitleTextColor()
        {
            ensureTextColorsGenerated();
            return mTitleTextColor;
        }

        public final int hashCode()
        {
            return mRgb * 31 + mPopulation;
        }

        public final String toString()
        {
            return (new StringBuilder(getClass().getSimpleName())).append(" [RGB: #").append(Integer.toHexString(getRgb())).append(']').append(" [HSL: ").append(Arrays.toString(getHsl())).append(']').append(" [Population: ").append(mPopulation).append(']').append(" [Title Text: #").append(Integer.toHexString(getTitleTextColor())).append(']').append(" [Body Text: #").append(Integer.toHexString(getBodyTextColor())).append(']').toString();
        }

        public Swatch(int i, int j)
        {
            mRed = Color.red(i);
            mGreen = Color.green(i);
            mBlue = Color.blue(i);
            mRgb = i;
            mPopulation = j;
        }

        Swatch(int i, int j, int k, int l)
        {
            mRed = i;
            mGreen = j;
            mBlue = k;
            mRgb = Color.rgb(i, j, k);
            mPopulation = l;
        }
    }


    /* member class not found */
    class Generator {}


    /* member class not found */
    class _cls1 {}

}
