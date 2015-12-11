// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

// Referenced classes of package co.vine.android.recorder:
//            PictureConverter, RecordConfigUtils

public class <init>
{

    private final Bitmap mPreScaleBitmap;
    private final Canvas mPreScaleCanvas;
    private final Matrix mPreScaleMatrix;
    private final int scaledH;
    private final int scaledW;
    final PictureConverter this$0;

    private void scale()
    {
        mPreScaleCanvas.drawBitmap(PictureConverter.access$200(PictureConverter.this), mPreScaleMatrix, PictureConverter.access$300(PictureConverter.this));
    }





    private _cls9(float f)
    {
        this$0 = PictureConverter.this;
        super();
        mPreScaleMatrix = new Matrix();
        scaledW = (int)((float)PictureConverter.access$000(PictureConverter.this) * f);
        scaledH = PictureConverter.access$000(PictureConverter.this);
        mPreScaleMatrix.setScale((float)scaledW / (float)PictureConverter.access$100(PictureConverter.this), 1.0F);
        mPreScaleBitmap = Bitmap.createBitmap(scaledW, scaledH, RecordConfigUtils.DEFAULT_BITMAP_CONFIG);
        mPreScaleCanvas = new Canvas(mPreScaleBitmap);
    }

    mPreScaleBitmap(float f, mPreScaleBitmap mprescalebitmap)
    {
        this(f);
    }
}
