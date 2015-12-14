// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.ui.layout.mosaic;

import android.graphics.RectF;
import com.amazon.gallery.framework.kindle.recyclerview.MosaicGenerationResult;

// Referenced classes of package com.amazon.gallery.foundation.ui.layout.mosaic:
//            ImageEater, SplitDimension

public class SplitImageEater extends ImageEater
{

    public transient SplitImageEater(SplitDimension splitdimension, ImageEater aimageeater[])
    {
        super(numSpanned(splitdimension, aimageeater), splitdimension, aimageeater);
    }

    private static int numSpanned(SplitDimension splitdimension, ImageEater aimageeater[])
    {
        int i = 0;
        int k = aimageeater.length;
        int j = 0;
        while (j < k) 
        {
            ImageEater imageeater = aimageeater[j];
            if (imageeater.dimension == SplitDimension.NONE || imageeater.dimension == splitdimension)
            {
                i += imageeater.numSpanned;
            } else
            {
                i++;
            }
            j++;
        }
        return i;
    }

    protected int addPostcards(RectF rectf, MosaicGenerationResult mosaicgenerationresult, int i, int j, int k)
    {
        int l = 0;
        int j1 = 0;
        int i1 = 0;
        if (dimension == SplitDimension.VERTICAL)
        {
            float f = rectf.top;
            int l1 = (int)((rectf.height() - (float)((numSpanned - 1) * j)) / (float)numSpanned);
            j1 = 0;
            l = i1;
            do
            {
                i1 = l;
                if (j1 >= children.length)
                {
                    break;
                }
                ImageEater imageeater = children[j1];
                RectF rectf1;
                if (imageeater.dimension == SplitDimension.NONE || imageeater.dimension == dimension)
                {
                    i1 = imageeater.numSpanned;
                } else
                {
                    i1 = 1;
                }
                i1 = i1 * l1 + (i1 - 1) * j;
                if (j1 == children.length - 1)
                {
                    rectf1 = new RectF(rectf.left, f, rectf.right, rectf.bottom);
                } else
                {
                    rectf1 = new RectF(rectf.left, f, rectf.right, (float)i1 + f);
                }
                f += i1 + j;
                l += imageeater.addPostcards(rectf1, mosaicgenerationresult, i + l, j, k);
                j1++;
            } while (true);
        } else
        {
            i1 = j1;
            if (dimension == SplitDimension.HORIZONTAL)
            {
                float f1 = rectf.left;
                int i2 = (int)((rectf.width() - (float)((numSpanned - 1) * j)) / (float)numSpanned);
                int k1 = 0;
                do
                {
                    i1 = l;
                    if (k1 >= children.length)
                    {
                        break;
                    }
                    ImageEater imageeater1 = children[k1];
                    RectF rectf2;
                    if (imageeater1.dimension == SplitDimension.NONE || imageeater1.dimension == dimension)
                    {
                        i1 = imageeater1.numSpanned;
                    } else
                    {
                        i1 = 1;
                    }
                    i1 = i1 * i2 + (i1 - 1) * j;
                    if (k1 == children.length - 1)
                    {
                        rectf2 = new RectF(f1, rectf.top, rectf.right, rectf.bottom);
                    } else
                    {
                        rectf2 = new RectF(f1, rectf.top, (float)i1 + f1, rectf.bottom);
                    }
                    f1 += i1 + j;
                    l += imageeater1.addPostcards(rectf2, mosaicgenerationresult, i + l, j, k);
                    k1++;
                } while (true);
            }
        }
        return i1;
    }
}
