// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.stroke;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import com.socialin.android.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.socialin.android.brushlib.stroke:
//            SerializableStroke

public class SimpleStroke
    implements Serializable
{

    private static final int CAPACITY = 70;
    public static final int POSITION_MATRIX_FLAG = 1;
    private static final String TAG = com/socialin/android/brushlib/stroke/SimpleStroke.getSimpleName();
    public static final int TANGENT_MATRIX_FLAG = 2;
    private static final long serialVersionUID = 0x29f71ce842f6535eL;
    private float lastX;
    private float lastY;
    private float length;
    private PathMeasure measure;
    private Path path;
    private boolean pathChanged;
    private SerializableStroke serializableStroke;

    public SimpleStroke()
    {
        init();
    }

    private void init()
    {
        path = new Path();
        path.incReserve(70);
        measure = new PathMeasure();
        length = 0.0F;
        pathChanged = true;
        serializableStroke = new SerializableStroke();
    }

    private void initFromSerilizableStroke(List list)
    {
        if (list != null && list.size() != 0)
        {
            setStartPoint(((SerializableStroke.StrokePoint)list.get(0)).getX(), ((SerializableStroke.StrokePoint)list.get(0)).getY());
            int j = list.size();
            for (int i = 1; i < j; i++)
            {
                SerializableStroke.StrokePoint strokepoint = (SerializableStroke.StrokePoint)list.get(i);
                addPoint(strokepoint.getX(), strokepoint.getY());
            }

        } else
        {
            throw new IllegalArgumentException("Provided list is null or empty");
        }
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        init();
        try
        {
            SerializableStroke serializablestroke = (SerializableStroke)objectinputstream.readObject();
            length = objectinputstream.readFloat();
            pathChanged = objectinputstream.readBoolean();
            initFromSerilizableStroke(serializablestroke.getPoints());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream) { }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream) { }
        d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(objectinputstream.getMessage()).toString()
        });
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        try
        {
            objectoutputstream.writeObject(serializableStroke);
            objectoutputstream.writeFloat(length);
            objectoutputstream.writeBoolean(pathChanged);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            d.b(TAG, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(objectoutputstream.getMessage()).toString()
            });
        }
    }

    void addPoint(float f, float f1)
    {
        serializableStroke.addPoint(f, f1);
        if (path.isEmpty())
        {
            path.lineTo((lastX + f) / 2.0F, (lastY + f1) / 2.0F);
        } else
        {
            path.quadTo(lastX, lastY, (lastX + f) / 2.0F, (lastY + f1) / 2.0F);
        }
        lastX = f;
        lastY = f1;
        pathChanged = true;
    }

    void addPoint(PointF pointf)
    {
        addPoint(pointf.x, pointf.y);
    }

    public void clear()
    {
        path.reset();
        path.incReserve(70);
        length = 0.0F;
        pathChanged = true;
    }

    public void computeBounds(RectF rectf, boolean flag)
    {
        path.computeBounds(rectf, flag);
    }

    public float getLength()
    {
        if (pathChanged)
        {
            measure.setPath(path, false);
            length = measure.getLength();
            pathChanged = false;
        }
        return length;
    }

    public void getMatrix(float f, Matrix matrix, int i)
    {
        if (pathChanged)
        {
            measure.setPath(path, false);
            pathChanged = false;
        }
        measure.getMatrix(f, matrix, i);
    }

    public Path getPath()
    {
        return path;
    }

    public void getPosTan(float f, float af[], float af1[])
    {
        if (pathChanged)
        {
            measure.setPath(path, false);
            pathChanged = false;
        }
        measure.getPosTan(f, af, af1);
    }

    public SerializableStroke getSerializableStroke()
    {
        return serializableStroke;
    }

    public boolean isEmpty()
    {
        return path.isEmpty();
    }

    public void rewind()
    {
        path.rewind();
        path.incReserve(70);
        length = 0.0F;
        pathChanged = true;
    }

    void setPath(Path path1)
    {
        path.set(path1);
        pathChanged = true;
    }

    void setStartPoint(float f, float f1)
    {
        serializableStroke.addPoint(f, f1);
        path.rewind();
        path.moveTo(f, f1);
        lastX = f;
        lastY = f1;
        pathChanged = true;
    }

    public void setToLine(float f, float f1, float f2, float f3)
    {
        path.rewind();
        path.moveTo(f, f1);
        path.lineTo(f2, f3);
        measure.setPath(path, false);
        length = measure.getLength();
        pathChanged = false;
    }

    public void setToOval(RectF rectf)
    {
        path.rewind();
        path.addOval(rectf, android.graphics.Path.Direction.CW);
        measure.setPath(path, false);
        length = measure.getLength();
        pathChanged = false;
    }

    public void setToRect(float f, float f1, float f2, float f3)
    {
        path.rewind();
        path.addRect(f, f1, f2, f3, android.graphics.Path.Direction.CW);
        measure.setPath(path, false);
        length = measure.getLength();
        pathChanged = false;
    }

}
