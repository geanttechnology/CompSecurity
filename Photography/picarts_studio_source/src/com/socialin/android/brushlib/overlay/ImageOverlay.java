// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.overlay;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.controller.c;
import com.socialin.android.brushlib.util.b;
import com.socialin.android.d;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

// Referenced classes of package com.socialin.android.brushlib.overlay:
//            Overlay

public class ImageOverlay extends Overlay
{

    private static final String TAG = com/socialin/android/brushlib/overlay/ImageOverlay.getSimpleName();
    private static final Paint paint = new Paint(2);
    private static final long serialVersionUID = 0x82ab7bbdf8fda2f5L;
    private transient RectF bounds;
    private Bitmap image;
    private transient Point imageDimensions;
    private RectF originalBounds;
    private String savedImageName;

    public ImageOverlay(Bitmap bitmap, File file)
    {
        bounds = new RectF();
        image = bitmap;
        originalBounds = new RectF(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
        imageDimensions = new Point(bitmap.getWidth(), bitmap.getHeight());
        savedImageName = UUID.randomUUID().toString();
        (new ModernAsyncTask(bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, false), file) {

            private Bitmap a;
            private File b;
            private ImageOverlay c;

            protected final Object doInBackground(Object aobj[])
            {
                com.socialin.android.brushlib.util.b.a(a, new File(b, c.savedImageName));
                a.recycle();
                return null;
            }

            
            {
                c = ImageOverlay.this;
                a = bitmap;
                b = file;
                super();
            }
        }).execute(new Void[0]);
    }

    public ImageOverlay(ImageOverlay imageoverlay)
    {
        bounds = new RectF();
        image = imageoverlay.image;
        savedImageName = imageoverlay.savedImageName;
        originalBounds = new RectF(0.0F, 0.0F, image.getWidth(), image.getHeight());
        imageDimensions = new Point(image.getWidth(), image.getHeight());
        getTransform().set(imageoverlay.getTransform());
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
            savedImageName = (String)objectinputstream.readObject();
            imageDimensions = new Point(objectinputstream.readInt(), objectinputstream.readInt());
            bounds = new RectF();
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
            objectoutputstream.writeObject(savedImageName);
            objectoutputstream.writeInt(imageDimensions.x);
            objectoutputstream.writeInt(imageDimensions.y);
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

    public ImageOverlay clone()
    {
        return new ImageOverlay(this);
    }

    public volatile Object clone()
    {
        return clone();
    }

    public void drawWithoutTransform(Canvas canvas)
    {
        if (image != null && !image.isRecycled())
        {
            if (getTransform().getRotation() % 90F != 0.0F)
            {
                paint.setAntiAlias(true);
            } else
            {
                paint.setAntiAlias(false);
            }
            canvas.drawBitmap(image, 0.0F, 0.0F, paint);
        }
    }

    public a getController$442001be()
    {
        return new c();
    }

    public Bitmap getImage()
    {
        return image;
    }

    public float getOrigHeight()
    {
        return (float)(int)originalBounds.height();
    }

    public float getOrigWidth()
    {
        return (float)(int)originalBounds.width();
    }

    public RectF getTransformedBounds(boolean flag)
    {
        bounds.set(originalBounds);
        RectF rectf = bounds;
        rectf.right = rectf.right * Math.abs(getTransform().getSx());
        rectf = bounds;
        rectf.left = rectf.left * Math.abs(getTransform().getSx());
        rectf = bounds;
        rectf.top = rectf.top * Math.abs(getTransform().getSy());
        rectf = bounds;
        rectf.bottom = rectf.bottom * Math.abs(getTransform().getSy());
        bounds.sort();
        if (flag)
        {
            Transform.rotateRectF(bounds, bounds, getTransform().getRotation());
        }
        return bounds;
    }

    public void initImage(File file)
    {
        image = w.a(imageDimensions.x, imageDimensions.y, (new File(file, savedImageName)).getAbsolutePath());
        originalBounds = new RectF(0.0F, 0.0F, imageDimensions.x, imageDimensions.y);
    }

    public void recycle()
    {
        image.recycle();
        image = null;
    }


}
