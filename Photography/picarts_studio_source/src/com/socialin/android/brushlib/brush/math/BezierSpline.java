// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush.math;

import android.graphics.PointF;
import java.io.Serializable;

// Referenced classes of package com.socialin.android.brushlib.brush.math:
//            BezierSplineSegment

public class BezierSpline
    implements Serializable
{

    private static final long serialVersionUID = 0xf7c95d4ea1222302L;
    private int ctrlPointCount;
    private TFloatList ctrlPointX;
    private TFloatList ctrlPointY;
    private int lastUsedSegmentInd;
    private BezierSplineSegment segment;

    public BezierSpline(int i)
    {
        ctrlPointX = new TFloatList(i);
        ctrlPointY = new TFloatList(i);
        ctrlPointCount = 0;
        lastUsedSegmentInd = -1;
        segment = new BezierSplineSegment();
    }

    private void computeSegment(int i)
    {
        if (ctrlPointCount == 0)
        {
            throw new IllegalStateException();
        }
        if (i < 0 || i >= ctrlPointCount)
        {
            throw new IndexOutOfBoundsException();
        }
        if (lastUsedSegmentInd == i)
        {
            return;
        }
        if (i == 0)
        {
            segment.set(ctrlPointX.get(0), ctrlPointY.get(0), ctrlPointX.get(0), ctrlPointY.get(0), ctrlPointX.get(1), ctrlPointY.get(1));
        } else
        {
            segment.set(ctrlPointX.get(i - 1), ctrlPointY.get(i - 1), ctrlPointX.get(i), ctrlPointY.get(i), ctrlPointX.get(i + 1), ctrlPointY.get(i + 1));
        }
        lastUsedSegmentInd = i;
    }

    private boolean containsPoint(int i, float f)
    {
        if (ctrlPointCount == 0)
        {
            throw new IllegalStateException();
        }
        if (i < 0 || i >= ctrlPointCount)
        {
            throw new IndexOutOfBoundsException();
        }
        if (i != 0) goto _L2; else goto _L1
_L1:
        float f1;
        float f3;
        f1 = ctrlPointX.get(0);
        f3 = (ctrlPointX.get(1) + f1) / 2.0F;
        if (f1 > f || f > f3) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        float f2 = ctrlPointX.get(i);
        float f5 = ctrlPointX.get(i - 1);
        float f4 = ctrlPointX.get(i + 1);
        f5 = (f5 + f2) / 2.0F;
        f2 = (f2 + f4) / 2.0F;
        if (f5 >= f || f > f2)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private int getContainingSegmentInd(float f)
    {
        if (lastUsedSegmentInd == -1 || !containsPoint(lastUsedSegmentInd, f)) goto _L2; else goto _L1
_L1:
        int j = lastUsedSegmentInd;
_L4:
        return j;
_L2:
        if (lastUsedSegmentInd < ctrlPointCount - 2 && containsPoint(lastUsedSegmentInd + 1, f))
        {
            return lastUsedSegmentInd + 1;
        }
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= ctrlPointCount - 1)
                {
                    break label1;
                }
                j = i;
                if (containsPoint(i, f))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
    }

    public void addPoint(float f, float f1)
    {
        if (ctrlPointCount > 0 && f <= ctrlPointX.get(ctrlPointCount - 1))
        {
            return;
        }
        if (ctrlPointCount == ctrlPointX.size())
        {
            ctrlPointX.add(f);
            ctrlPointY.add(f1);
        } else
        {
            ctrlPointX.set(ctrlPointCount, f);
            ctrlPointY.set(ctrlPointCount, f1);
        }
        ctrlPointCount = ctrlPointCount + 1;
    }

    public void addPoint(PointF pointf)
    {
        addPoint(pointf.x, pointf.y);
    }

    public void clear()
    {
        ctrlPointX.clear();
        ctrlPointCount = 0;
        lastUsedSegmentInd = -1;
    }

    public int getCtrlPointCount()
    {
        return ctrlPointCount;
    }

    public float getLeftBound()
    {
        if (ctrlPointCount < 2)
        {
            throw new IllegalStateException();
        } else
        {
            return ctrlPointX.get(0);
        }
    }

    public float getRightBound()
    {
        if (ctrlPointCount < 2)
        {
            throw new IllegalStateException();
        } else
        {
            return (ctrlPointX.get(ctrlPointCount - 2) + ctrlPointX.get(ctrlPointCount - 1)) / 2.0F;
        }
    }

    public int getSegmentCount()
    {
        return ctrlPointCount - 1;
    }

    public void rewind()
    {
        ctrlPointCount = 0;
        lastUsedSegmentInd = -1;
    }

    public float value(float f)
    {
        if (ctrlPointCount < 2)
        {
            throw new IllegalStateException();
        }
        int i = getContainingSegmentInd(f);
        if (i == -1)
        {
            throw new IllegalArgumentException();
        } else
        {
            computeSegment(i);
            return segment.value(f);
        }
    }

    public float valueDeriv(float f)
    {
        if (ctrlPointCount < 2)
        {
            throw new IllegalStateException();
        }
        int i = getContainingSegmentInd(f);
        if (i == -1)
        {
            throw new IllegalArgumentException();
        } else
        {
            computeSegment(i);
            return segment.valueDeriv(f);
        }
    }

    private class TFloatList
        implements Serializable
    {

        private static final long serialVersionUID = 0x8272adaa072b600dL;
        private float array[];
        private int capacity;
        private int cursor;

        public void add(float f)
        {
            if (cursor == capacity)
            {
                capacity = capacity * 2;
                float af[] = new float[capacity];
                System.arraycopy(array, 0, af, 0, array.length);
                array = af;
            }
            float af1[] = array;
            int i = cursor;
            cursor = i + 1;
            af1[i] = f;
        }

        public void clear()
        {
            cursor = 0;
        }

        public float get(int i)
        {
            if (i < 0 || i >= capacity)
            {
                throw new IllegalArgumentException();
            } else
            {
                return array[i];
            }
        }

        public void set(int i, float f)
        {
            if (i < 0 || i >= capacity)
            {
                throw new IllegalArgumentException();
            } else
            {
                array[i] = f;
                return;
            }
        }

        public int size()
        {
            return cursor;
        }

        public TFloatList(int i)
        {
            capacity = i;
            array = new float[i];
            cursor = 0;
        }
    }

}
