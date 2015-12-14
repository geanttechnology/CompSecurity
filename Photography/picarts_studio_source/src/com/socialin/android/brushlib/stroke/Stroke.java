// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.stroke;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.socialin.android.brushlib.brush.math.BezierSpline;
import com.socialin.android.d;
import java.io.Serializable;
import java.util.LinkedList;

// Referenced classes of package com.socialin.android.brushlib.stroke:
//            SimpleStroke

public class Stroke
    implements Serializable
{

    public static final int DEFAULT_CAPACITY = 70;
    private static final int MAX_POOL_SIZE = 12;
    public static final int POSITION_MATRIX_FLAG = 1;
    private static final String TAG = "Stroke";
    public static final int TANGENT_MATRIX_FLAG = 2;
    private static final long serialVersionUID = 0xff41b6d807a499baL;
    private static final LinkedList strokePool = new LinkedList();
    private boolean constPressure;
    private boolean constVelocity;
    private BezierSpline distToPressure;
    private BezierSpline distToVelocity;
    private boolean isRecycled;
    private SimpleStroke simpleStroke;

    private Stroke()
    {
        this(70);
    }

    private Stroke(int i)
    {
        isRecycled = false;
        d.b("Stroke", new Object[] {
            "New instance of Stroke created"
        });
        simpleStroke = new SimpleStroke();
        distToVelocity = new BezierSpline(i);
        distToPressure = new BezierSpline(i);
        constVelocity = false;
        constPressure = false;
    }

    public static Stroke obtain()
    {
        return obtain(70);
    }

    public static Stroke obtain(int i)
    {
        if (!strokePool.isEmpty())
        {
            Stroke stroke = (Stroke)strokePool.removeFirst();
            stroke.isRecycled = false;
            return stroke;
        } else
        {
            return new Stroke(i);
        }
    }

    public void addPoint(float f, float f1, float f2, float f3)
    {
        simpleStroke.addPoint(f, f1);
        distToVelocity.addPoint(simpleStroke.getLength(), f2);
        distToPressure.addPoint(simpleStroke.getLength(), f3);
    }

    public void clear()
    {
        simpleStroke.clear();
        distToVelocity.clear();
    }

    public void computeBounds(RectF rectf, boolean flag)
    {
        simpleStroke.computeBounds(rectf, flag);
    }

    public float getLength()
    {
        if (simpleStroke.isEmpty())
        {
            return 0.0F;
        }
        float f;
        try
        {
            if (constVelocity)
            {
                return simpleStroke.getLength();
            }
            f = distToVelocity.getRightBound();
        }
        catch (Exception exception)
        {
            return 0.0F;
        }
        return f;
    }

    public void getMatrix(float f, Matrix matrix, int i)
    {
        if (f < 0.0F || f > simpleStroke.getLength())
        {
            throw new IllegalArgumentException();
        }
        if (matrix == null)
        {
            throw new NullPointerException();
        } else
        {
            simpleStroke.getMatrix(f, matrix, i);
            return;
        }
    }

    public Path getPath()
    {
        return simpleStroke.getPath();
    }

    public void getPosTan(float f, float af[], float af1[])
    {
        if (f < 0.0F || f > simpleStroke.getLength())
        {
            throw new IllegalArgumentException((new StringBuilder("dist : ")).append(f).append(" strokeLen : ").append(simpleStroke.getLength()).toString());
        } else
        {
            simpleStroke.getPosTan(f, af, af1);
            return;
        }
    }

    public float getPressure(float f)
    {
        if (f < 0.0F || f > simpleStroke.getLength())
        {
            throw new IllegalArgumentException();
        }
        if (constPressure)
        {
            return 1.0F;
        } else
        {
            return distToPressure.value(f);
        }
    }

    public float getStrokeLength()
    {
        if (simpleStroke.isEmpty())
        {
            return 0.0F;
        } else
        {
            return simpleStroke.getLength();
        }
    }

    public float getVelocity(float f)
    {
        if (f < 0.0F || f > simpleStroke.getLength())
        {
            throw new IllegalArgumentException();
        }
        if (constVelocity)
        {
            return 1.0F;
        } else
        {
            return distToVelocity.value(f);
        }
    }

    public boolean isEmpty()
    {
        return simpleStroke.isEmpty();
    }

    public boolean isRecycled()
    {
        return isRecycled;
    }

    public void recycle()
    {
        if (strokePool.size() < 12)
        {
            rewind();
            strokePool.add(this);
            isRecycled = true;
        }
    }

    public void rewind()
    {
        simpleStroke.rewind();
        distToVelocity.rewind();
        distToPressure.rewind();
    }

    public void setConstPressure(boolean flag)
    {
        constPressure = flag;
    }

    public void setConstVelocity(boolean flag)
    {
        constVelocity = flag;
    }

    public void setPath(Path path)
    {
        simpleStroke.setPath(path);
        constVelocity = true;
        constPressure = true;
    }

    public void setStartPoint(float f, float f1, float f2, float f3)
    {
        constVelocity = false;
        simpleStroke.setStartPoint(f, f1);
        distToVelocity.rewind();
        distToPressure.rewind();
        distToVelocity.addPoint(simpleStroke.getLength(), f2);
        distToPressure.addPoint(simpleStroke.getLength(), f3);
    }

    public void setToLine(float f, float f1, float f2, float f3)
    {
        simpleStroke.setToLine(f, f1, f2, f3);
        distToVelocity.rewind();
        constVelocity = true;
        constPressure = true;
    }

    public void setToOval(RectF rectf)
    {
        simpleStroke.setToOval(rectf);
        distToVelocity.rewind();
        constVelocity = true;
        constPressure = true;
    }

    public void setToRect(float f, float f1, float f2, float f3)
    {
        simpleStroke.setToRect(f, f1, f2, f3);
        distToVelocity.rewind();
        constVelocity = true;
        constPressure = true;
    }

}
