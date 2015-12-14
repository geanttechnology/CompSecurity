// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.recyclerview;

import android.graphics.PointF;
import android.graphics.RectF;
import com.amazon.gallery.foundation.ui.layout.ScrollDirection;
import com.amazon.gallery.foundation.ui.layout.mosaic.RootImageEater;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.recyclerview:
//            AspectRatioLookUp, MosaicGenerationResult

public class MosaicAndroidGenerator
{

    private AspectRatioLookUp aspectRatioLookUp;
    private final RectF clientRect = new RectF();
    private RootImageEater eaters[];
    private int padding;
    private ScrollDirection scrollDirection;

    public MosaicAndroidGenerator()
    {
        scrollDirection = ScrollDirection.HORIZONTAL;
    }

    private List calculateLayout(int i, int j, int k, boolean flag)
    {
        boolean flag1 = true;
        int ai[] = new int[eaters.length];
        int i1 = k - j;
        float af[] = new float[i1 + 1];
        int ai1[] = new int[i1 + 1];
        float af1[] = new float[i1];
        k = 0;
        while (k < i1 && k + j < i) 
        {
            if (aspectRatioLookUp != null)
            {
                af1[k] = aspectRatioLookUp.getAspectRatio(j + k);
            } else
            {
                af1[k] = 0.6666667F;
            }
            af[k + 1] = 3.402823E+38F;
            k++;
        }
        af[0] = 0.0F;
        float f2 = clientRect.width() / clientRect.height();
        j = 0;
        i = ((flag1) ? 1 : 0);
label0:
        do
        {
            if (j <= i1)
            {
                k = 0;
                do
                {
                    int l;
                    int j1;
label1:
                    {
                        if (k < eaters.length)
                        {
                            j1 = j + eaters[k].imageRatios.length;
                            if ((ai1[j] & 0x80) > 0)
                            {
                                l = ai1[j] & 0x7f;
                            } else
                            {
                                l = -1;
                            }
                            if (j1 <= i1)
                            {
                                break label1;
                            }
                        }
                        j++;
                        continue label0;
                    }
                    float f1 = af[j];
                    float f = f1;
                    if (l == k)
                    {
                        f = f1 + 2.0F;
                    }
                    f1 = f;
                    if (k == 0)
                    {
                        float f3;
                        if (flag)
                        {
                            f1 = 2.0F;
                        } else
                        {
                            f1 = 10F;
                        }
                        f1 = f + f1;
                    }
                    f = f1;
                    if (flag)
                    {
                        f = f2 - eaters[k].rootRatio;
                        f = f1 + f * f;
                    }
                    f1 = (float)((double)f + ((double)ai[k] * 0.59999999999999998D) / (double)i);
                    f = 0.0F;
                    for (l = 0; l < eaters[k].imageRatios.length; l++)
                    {
                        f3 = af1[l + j];
                        f3 = Math.max(f3 - eaters[k].imageRatios[l], 1.0F / f3 - 1.0F / eaters[k].imageRatios[l]);
                        f += f3 * f3;
                    }

                    f = f1 + f;
                    l = i;
                    if (f < af[j1])
                    {
                        l = i;
                        if ((ai1[j1] & 0x80) > 0)
                        {
                            l = ai1[j1] & 0x7f;
                            ai[l] = ai[l] - 1;
                            l = i - 1;
                        }
                        af[j1] = f;
                        ai1[j1] = j << 8 | 0x80 | k;
                        ai[k] = ai[k] + 1;
                        l++;
                    }
                    k++;
                    i = l;
                } while (true);
            }
            return reconstructEaters(ai1);
        } while (true);
    }

    private float ceil(float f)
    {
        return (float)Math.ceil(f);
    }

    private float floor(float f)
    {
        return (float)Math.floor(f);
    }

    private MosaicGenerationResult performLayout(int i, int j, List list)
    {
        MosaicGenerationResult mosaicgenerationresult = new MosaicGenerationResult();
        PointF pointf = new PointF(clientRect.left + (float)padding, clientRect.top + (float)padding);
        float f = (clientRect.width() - (float)padding) + clientRect.left;
        float f1 = (clientRect.height() - (float)padding) + clientRect.top;
        RectF rectf = new RectF();
        RectF rectf1 = new RectF();
        int k = i;
        i = list.size() - 1;
        while (i >= 0) 
        {
            RootImageEater rootimageeater = (RootImageEater)list.get(i);
            if (scrollDirection == ScrollDirection.HORIZONTAL)
            {
                rectf1.set(ceil(pointf.x), pointf.y, floor(pointf.x + rootimageeater.rootRatio * f1), f1);
            } else
            {
                rectf1.set(ceil(pointf.x), pointf.y, floor(f), pointf.y + f / rootimageeater.rootRatio);
            }
            rectf.union(rectf1);
            k += rootimageeater.addPostcards(rectf1, mosaicgenerationresult, k, padding, i);
            if (scrollDirection == ScrollDirection.HORIZONTAL)
            {
                pointf.set(rectf1.right + (float)padding, clientRect.top + (float)padding);
            } else
            {
                pointf.set(clientRect.left + (float)padding, rectf1.bottom + (float)padding);
            }
            i--;
        }
        if (k == j);
        mosaicgenerationresult.setPageBounds(rectf);
        return mosaicgenerationresult;
    }

    private List reconstructEaters(int ai[])
    {
        ArrayList arraylist = new ArrayList();
        for (int i = ai.length - 1; i != 0; i = ai[i] >> 8)
        {
            arraylist.add(eaters[ai[i] & 0x7f]);
        }

        return arraylist;
    }

    public MosaicGenerationResult generate(int i, int j, int k, boolean flag)
    {
        return performLayout(j, k, calculateLayout(i, j, k, flag));
    }

    public RectF getClientRect()
    {
        return clientRect;
    }

    public void setAspectRatioLookUp(AspectRatioLookUp aspectratiolookup)
    {
        aspectRatioLookUp = aspectratiolookup;
    }

    public void setClientRect(RectF rectf)
    {
        clientRect.set(rectf);
    }

    public void setEaters(RootImageEater arootimageeater[])
    {
        eaters = arootimageeater;
    }
}
