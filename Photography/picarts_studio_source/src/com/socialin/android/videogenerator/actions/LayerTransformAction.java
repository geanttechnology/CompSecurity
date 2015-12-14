// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action

public class LayerTransformAction extends Action
{

    private static final long serialVersionUID = 0x81a8970ae7f34365L;
    private UUID layerId;
    private Matrix matrix;

    public LayerTransformAction(UUID uuid, Matrix matrix1, String s)
    {
        super(s);
        matrix = matrix1;
        layerId = uuid;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
            layerId = (UUID)objectinputstream.readObject();
            objectinputstream = (float[])objectinputstream.readObject();
            matrix = new Matrix();
            matrix.setValues(objectinputstream);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            objectinputstream.printStackTrace();
        }
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        try
        {
            objectoutputstream.writeObject(layerId);
            float af[] = new float[9];
            matrix.getValues(af);
            objectoutputstream.writeObject(af);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            objectoutputstream.printStackTrace();
        }
    }

    public void apply(a a1)
    {
        a1 = a1.a(layerId);
        Matrix matrix1 = matrix;
        Paint paint = new Paint(3);
        Bitmap bitmap = Bitmap.createBitmap(((com.socialin.android.videogenerator.layer.a) (a1)).f, ((com.socialin.android.videogenerator.layer.a) (a1)).g, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        matrix1.preScale(1.0F / ((com.socialin.android.videogenerator.layer.a) (a1)).h, 1.0F / ((com.socialin.android.videogenerator.layer.a) (a1)).i);
        canvas.drawBitmap(((com.socialin.android.videogenerator.layer.a) (a1)).a, matrix1, paint);
        ((com.socialin.android.videogenerator.layer.a) (a1)).a.recycle();
        a1.a = Bitmap.createScaledBitmap(bitmap, ((com.socialin.android.videogenerator.layer.a) (a1)).a.getWidth(), ((com.socialin.android.videogenerator.layer.a) (a1)).a.getHeight(), false);
        bitmap.recycle();
        a1.d = null;
    }

    public String getActionDescription()
    {
        return "TransformLayer";
    }
}
