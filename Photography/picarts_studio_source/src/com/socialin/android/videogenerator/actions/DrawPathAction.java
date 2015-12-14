// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.brush.f;
import com.socialin.android.brushlib.brush.j;
import com.socialin.android.brushlib.brush.k;
import com.socialin.android.brushlib.stroke.Stroke;
import com.socialin.android.brushlib.svg.d;
import com.socialin.android.util.ak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action

public class DrawPathAction extends Action
{

    private static final String TAG = com/socialin/android/videogenerator/actions/DrawPathAction.getSimpleName();
    private static final long serialVersionUID = 0xbe11d2143405844L;
    private Brush brush;
    private UUID layerId;
    private float scale;
    private Stroke stroke;

    public DrawPathAction(UUID uuid, Stroke stroke1, Brush brush1, String s, float f1)
    {
        super(s);
        layerId = uuid;
        stroke = stroke1;
        brush = brush1;
        scale = f1;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
            layerId = (UUID)objectinputstream.readObject();
            stroke = (Stroke)objectinputstream.readObject();
            scale = objectinputstream.readFloat();
            brush = Brush.a(d.a(), objectinputstream.readInt());
            brush.a((com.socialin.android.brushlib.brush.Brush.Params)objectinputstream.readObject());
            brush.a(scale);
            if (brush instanceof f)
            {
                ((f)brush).c = (String)objectinputstream.readObject();
            }
            if (brush instanceof j)
            {
                int i = objectinputstream.readInt();
                ak ak1 = ak.a(d.a(), "drawing");
                ((j)brush).a(ak1.b(i));
                ((j)brush).a(com.socialin.android.util.d.a(ak1.c(i)));
                ((j)brush).c = i;
            }
            brush.a((com.socialin.android.brushlib.view.DrawingView.DrawingMode)objectinputstream.readObject());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream) { }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream) { }
        com.socialin.android.d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(objectinputstream.getMessage()).toString()
        });
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        com.socialin.android.brushlib.brush.Brush.Params params;
        params = new com.socialin.android.brushlib.brush.Brush.Params();
        brush.b(params);
        objectoutputstream.writeObject(layerId);
        objectoutputstream.writeObject(stroke);
        objectoutputstream.writeFloat(scale);
        if (!(brush instanceof k))
        {
            break MISSING_BLOCK_LABEL_129;
        }
        objectoutputstream.writeInt(((k)brush).d);
_L1:
        objectoutputstream.writeObject(params);
        if (brush instanceof f)
        {
            objectoutputstream.writeObject(((f)brush).c);
        }
        if (brush instanceof j)
        {
            objectoutputstream.writeInt(((j)brush).c);
        }
        objectoutputstream.writeObject(brush.b());
        return;
        try
        {
            objectoutputstream.writeInt(brush.c());
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            com.socialin.android.d.b(TAG, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(objectoutputstream.getMessage()).toString()
            });
            return;
        }
          goto _L1
    }

    public void apply(a a1)
    {
        a1 = a1.a(getLayerId());
        brush.a(stroke, a1.b());
    }

    public String getActionDescription()
    {
        return "Drawing Path";
    }

    public Brush getBrush()
    {
        return brush;
    }

    public UUID getLayerId()
    {
        return layerId;
    }

    public Stroke getStroke()
    {
        return stroke;
    }

    public void setBrush(Brush brush1)
    {
        brush = brush1;
    }

    public void setLayerId(UUID uuid)
    {
        layerId = uuid;
    }

    public void setStroke(Stroke stroke1)
    {
        stroke = stroke1;
    }

}
