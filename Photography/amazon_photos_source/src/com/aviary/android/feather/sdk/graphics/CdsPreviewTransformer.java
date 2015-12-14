// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.library.utils.BitmapUtils;
import it.sephiroth.android.library.picasso.Transformation;
import java.util.concurrent.Callable;

public class CdsPreviewTransformer
    implements Transformation, Callable
{

    static com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    final String mDisplayName;
    int mInputDensity;
    int mMaxH;
    int mMaxW;
    final String mPath;
    int mTargetDensity;
    final String mType;

    public CdsPreviewTransformer(String s, String s1, String s2)
    {
        mMaxW = -1;
        mMaxH = -1;
        mDisplayName = s1;
        mType = s2;
        mPath = s;
    }

    public CdsPreviewTransformer(String s, String s1, String s2, int i, int j, int k, int l)
    {
        this(s, s1, s2);
        mTargetDensity = j;
        mInputDensity = i;
        mMaxW = k;
        mMaxH = l;
    }

    private Bitmap decode()
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        options.inInputShareable = true;
        options.inPurgeable = true;
        options.inTargetDensity = mTargetDensity;
        options.inDensity = mInputDensity;
        Bitmap bitmap = BitmapFactory.decodeFile(mPath, options);
        logger.log("input.density: %d, target.density: %d", new Object[] {
            Integer.valueOf(mInputDensity), Integer.valueOf(mTargetDensity)
        });
        logger.log("options.size: %dx%d", new Object[] {
            Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)
        });
        return bitmap;
    }

    public Bitmap call()
        throws Exception
    {
        return transform(decode());
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public String key()
    {
        return mPath;
    }

    public Bitmap transform(Bitmap bitmap)
    {
        Bitmap bitmap1 = bitmap;
        if (bitmap != null)
        {
            bitmap1 = bitmap;
            if (mMaxW > 0)
            {
                bitmap1 = bitmap;
                if (mMaxH > 0)
                {
                    logger.log("need to resize to: %dx%d", new Object[] {
                        Integer.valueOf(mMaxW), Integer.valueOf(mMaxH)
                    });
                    Bitmap bitmap2 = BitmapUtils.resizeBitmap(bitmap, mMaxW, mMaxH);
                    bitmap1 = bitmap;
                    if (!bitmap2.equals(bitmap))
                    {
                        bitmap.recycle();
                        bitmap1 = bitmap2;
                    }
                }
            }
        }
        Object obj = bitmap1;
        if ("effect".equals(mType))
        {
            bitmap = bitmap1;
            if (!bitmap1.isMutable())
            {
                obj = bitmap1.copy(bitmap1.getConfig(), true);
                bitmap = bitmap1;
                if (obj != bitmap1)
                {
                    bitmap1.recycle();
                    bitmap = ((Bitmap) (obj));
                }
            }
            obj = bitmap;
            if (bitmap != null)
            {
                obj = bitmap;
                if (bitmap.isMutable())
                {
                    Canvas canvas = new Canvas(bitmap);
                    obj = new Paint(129);
                    ((Paint) (obj)).setColor(-1);
                    ((Paint) (obj)).setTextSize(bitmap.getHeight() / 10);
                    Rect rect = new Rect();
                    ((Paint) (obj)).getTextBounds(mDisplayName, 0, mDisplayName.length(), rect);
                    canvas.drawText(mDisplayName, (bitmap.getWidth() - rect.width()) / 2, (float)bitmap.getHeight() - ((Paint) (obj)).descent() - 2.0F, ((Paint) (obj)));
                    obj = bitmap;
                }
            }
        }
        logger.log("final bitmap.size: %dx%d", new Object[] {
            Integer.valueOf(((Bitmap) (obj)).getWidth()), Integer.valueOf(((Bitmap) (obj)).getHeight())
        });
        return ((Bitmap) (obj));
    }

    static 
    {
        logger = LoggerFactory.getLogger(com/aviary/android/feather/sdk/graphics/CdsPreviewTransformer.getSimpleName(), com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }
}
