// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.ui.layout.mosaic;

import android.graphics.RectF;
import com.amazon.gallery.framework.kindle.recyclerview.MosaicGenerationResult;

// Referenced classes of package com.amazon.gallery.foundation.ui.layout.mosaic:
//            ImageEater, SplitDimension

public class RootImageEater extends ImageEater
{

    public final float imageAreas[];
    public final float imageRatios[];
    public final float rootRatio;

    public RootImageEater(int i, int j, ImageEater imageeater)
    {
        super(imageeater.numSpanned, SplitDimension.NONE, new ImageEater[] {
            imageeater
        });
        rootRatio = (float)i / (float)j;
        int k = numLeafNodes(children[0]);
        imageRatios = new float[k];
        imageAreas = new float[k];
        calculateAspectRatio(children[0], this, i, j, 0);
    }

    private int calculateAspectRatio(ImageEater imageeater, ImageEater imageeater1, float f, float f1, int i)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$foundation$ui$layout$mosaic$SplitDimension[];

            static 
            {
                $SwitchMap$com$amazon$gallery$foundation$ui$layout$mosaic$SplitDimension = new int[SplitDimension.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$ui$layout$mosaic$SplitDimension[SplitDimension.HORIZONTAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$ui$layout$mosaic$SplitDimension[SplitDimension.VERTICAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$foundation$ui$layout$mosaic$SplitDimension[SplitDimension.NONE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.foundation.ui.layout.mosaic.SplitDimension[imageeater.dimension.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 101
    //                   2 134
    //                   3 167;
           goto _L1 _L2 _L3 _L4
_L1:
        float f2;
        float f3;
        f3 = f1;
        f2 = f;
_L6:
        int l;
        int j = 0;
        imageeater1 = imageeater.children;
        int i1 = imageeater1.length;
        int k = 0;
        do
        {
            l = j;
            if (k >= i1)
            {
                break;
            }
            j += calculateAspectRatio(imageeater1[k], imageeater, f2, f3, i + j);
            k++;
        } while (true);
        break; /* Loop/switch isn't completed */
_L2:
        f2 = f;
        f3 = f1;
        if (imageeater1.dimension != SplitDimension.HORIZONTAL)
        {
            f2 = f / (float)imageeater.numSpanned;
            f3 = f1;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        f2 = f;
        f3 = f1;
        if (imageeater1.dimension != SplitDimension.VERTICAL)
        {
            f3 = f1 / (float)imageeater.numSpanned;
            f2 = f;
        }
        if (true) goto _L6; else goto _L5
_L4:
        imageRatios[i] = f / f1 / (float)imageeater.numSpanned;
        imageAreas[i] = f * f1 * (float)imageeater.numSpanned;
        l = 1;
_L5:
        return l;
    }

    private static int numLeafNodes(ImageEater imageeater)
    {
        if (imageeater.children.length != 0) goto _L2; else goto _L1
_L1:
        int k = 1;
_L4:
        return k;
_L2:
        int i = 0;
        imageeater = imageeater.children;
        int l = imageeater.length;
        int j = 0;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            i += numLeafNodes(imageeater[j]);
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int addPostcards(RectF rectf, MosaicGenerationResult mosaicgenerationresult, int i, int j, int k)
    {
        return children[0].addPostcards(rectf, mosaicgenerationresult, i, j, k);
    }
}
