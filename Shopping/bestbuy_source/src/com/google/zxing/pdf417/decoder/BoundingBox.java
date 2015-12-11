// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

final class BoundingBox
{

    private ResultPoint bottomLeft;
    private ResultPoint bottomRight;
    private BitMatrix image;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private ResultPoint topLeft;
    private ResultPoint topRight;

    BoundingBox(BitMatrix bitmatrix, ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3)
    {
        if (resultpoint == null && resultpoint2 == null || resultpoint1 == null && resultpoint3 == null || resultpoint != null && resultpoint1 == null || resultpoint2 != null && resultpoint3 == null)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            init(bitmatrix, resultpoint, resultpoint1, resultpoint2, resultpoint3);
            return;
        }
    }

    BoundingBox(BoundingBox boundingbox)
    {
        init(boundingbox.image, boundingbox.topLeft, boundingbox.bottomLeft, boundingbox.topRight, boundingbox.bottomRight);
    }

    private void calculateMinMaxValues()
    {
        if (topLeft != null) goto _L2; else goto _L1
_L1:
        topLeft = new ResultPoint(0.0F, topRight.getY());
        bottomLeft = new ResultPoint(0.0F, bottomRight.getY());
_L4:
        minX = (int)Math.min(topLeft.getX(), bottomLeft.getX());
        maxX = (int)Math.max(topRight.getX(), bottomRight.getX());
        minY = (int)Math.min(topLeft.getY(), topRight.getY());
        maxY = (int)Math.max(bottomLeft.getY(), bottomRight.getY());
        return;
_L2:
        if (topRight == null)
        {
            topRight = new ResultPoint(image.getWidth() - 1, topLeft.getY());
            bottomRight = new ResultPoint(image.getWidth() - 1, bottomLeft.getY());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void init(BitMatrix bitmatrix, ResultPoint resultpoint, ResultPoint resultpoint1, ResultPoint resultpoint2, ResultPoint resultpoint3)
    {
        image = bitmatrix;
        topLeft = resultpoint;
        bottomLeft = resultpoint1;
        topRight = resultpoint2;
        bottomRight = resultpoint3;
        calculateMinMaxValues();
    }

    static BoundingBox merge(BoundingBox boundingbox, BoundingBox boundingbox1)
    {
        if (boundingbox == null)
        {
            return boundingbox1;
        }
        if (boundingbox1 == null)
        {
            return boundingbox;
        } else
        {
            return new BoundingBox(boundingbox.image, boundingbox.topLeft, boundingbox.bottomLeft, boundingbox1.topRight, boundingbox1.bottomRight);
        }
    }

    BoundingBox addMissingRows(int i, int j, boolean flag)
    {
        ResultPoint resultpoint = topLeft;
        ResultPoint resultpoint1 = bottomLeft;
        ResultPoint resultpoint5 = topRight;
        ResultPoint resultpoint4 = bottomRight;
        ResultPoint resultpoint2;
        ResultPoint resultpoint3;
        if (i > 0)
        {
            int k;
            if (flag)
            {
                resultpoint2 = topLeft;
            } else
            {
                resultpoint2 = topRight;
            }
            k = (int)resultpoint2.getY() - i;
            i = k;
            if (k < 0)
            {
                i = 0;
            }
            resultpoint3 = new ResultPoint(resultpoint2.getX(), i);
            if (flag)
            {
                resultpoint2 = resultpoint5;
                resultpoint = resultpoint3;
            } else
            {
                resultpoint2 = resultpoint3;
            }
        } else
        {
            resultpoint2 = resultpoint5;
        }
        if (j > 0)
        {
            if (flag)
            {
                resultpoint3 = bottomLeft;
            } else
            {
                resultpoint3 = bottomRight;
            }
            j = (int)resultpoint3.getY() + j;
            i = j;
            if (j >= image.getHeight())
            {
                i = image.getHeight() - 1;
            }
            resultpoint3 = new ResultPoint(resultpoint3.getX(), i);
            if (flag)
            {
                resultpoint1 = resultpoint3;
            } else
            {
                resultpoint4 = resultpoint3;
            }
        }
        calculateMinMaxValues();
        return new BoundingBox(image, resultpoint, resultpoint1, resultpoint2, resultpoint4);
    }

    ResultPoint getBottomLeft()
    {
        return bottomLeft;
    }

    ResultPoint getBottomRight()
    {
        return bottomRight;
    }

    int getMaxX()
    {
        return maxX;
    }

    int getMaxY()
    {
        return maxY;
    }

    int getMinX()
    {
        return minX;
    }

    int getMinY()
    {
        return minY;
    }

    ResultPoint getTopLeft()
    {
        return topLeft;
    }

    ResultPoint getTopRight()
    {
        return topRight;
    }
}
