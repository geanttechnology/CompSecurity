// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifFrameLoader

public class GifDrawable extends GlideDrawable
    implements GifFrameLoader.FrameCallback
{
    static class GifState extends android.graphics.drawable.Drawable.ConstantState
    {

        BitmapPool bitmapPool;
        com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider;
        Context context;
        byte data[];
        Bitmap firstFrame;
        Transformation frameTransformation;
        GifHeader gifHeader;
        int targetHeight;
        int targetWidth;

        public int getChangingConfigurations()
        {
            return 0;
        }

        public Drawable newDrawable()
        {
            return new GifDrawable(this);
        }

        public Drawable newDrawable(Resources resources)
        {
            return newDrawable();
        }

        public GifState(GifHeader gifheader, byte abyte0[], Context context1, Transformation transformation, int i, int j, com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider bitmapprovider, 
                BitmapPool bitmappool, Bitmap bitmap)
        {
            if (bitmap == null)
            {
                throw new NullPointerException("The first frame of the GIF must not be null");
            } else
            {
                gifHeader = gifheader;
                data = abyte0;
                bitmapPool = bitmappool;
                firstFrame = bitmap;
                context = context1.getApplicationContext();
                frameTransformation = transformation;
                targetWidth = i;
                targetHeight = j;
                bitmapProvider = bitmapprovider;
                return;
            }
        }
    }


    private boolean applyGravity;
    private final GifDecoder decoder;
    private final Rect destRect;
    private final GifFrameLoader frameLoader;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private final Paint paint;
    private final GifState state;

    public GifDrawable(Context context, com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider bitmapprovider, BitmapPool bitmappool, Transformation transformation, int i, int j, GifHeader gifheader, 
            byte abyte0[], Bitmap bitmap)
    {
        this(new GifState(gifheader, abyte0, context, transformation, i, j, bitmapprovider, bitmappool, bitmap));
    }

    GifDrawable(GifState gifstate)
    {
        destRect = new Rect();
        isVisible = true;
        maxLoopCount = -1;
        if (gifstate == null)
        {
            throw new NullPointerException("GifState must not be null");
        } else
        {
            state = gifstate;
            decoder = new GifDecoder(gifstate.bitmapProvider);
            paint = new Paint();
            decoder.setData(gifstate.gifHeader, gifstate.data);
            frameLoader = new GifFrameLoader(gifstate.context, this, decoder, gifstate.targetWidth, gifstate.targetHeight);
            return;
        }
    }

    private void reset()
    {
        frameLoader.clear();
        invalidateSelf();
    }

    private void resetLoopCount()
    {
        loopCount = 0;
    }

    private void startRunning()
    {
        if (decoder.getFrameCount() == 1)
        {
            invalidateSelf();
        } else
        if (!isRunning)
        {
            isRunning = true;
            frameLoader.start();
            invalidateSelf();
            return;
        }
    }

    private void stopRunning()
    {
        isRunning = false;
        frameLoader.stop();
    }

    public void draw(Canvas canvas)
    {
        if (isRecycled)
        {
            return;
        }
        if (applyGravity)
        {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), destRect);
            applyGravity = false;
        }
        Bitmap bitmap = frameLoader.getCurrentFrame();
        if (bitmap == null)
        {
            bitmap = state.firstFrame;
        }
        canvas.drawBitmap(bitmap, null, destRect, paint);
    }

    public android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        return state;
    }

    public byte[] getData()
    {
        return state.data;
    }

    public Bitmap getFirstFrame()
    {
        return state.firstFrame;
    }

    public int getFrameCount()
    {
        return decoder.getFrameCount();
    }

    public Transformation getFrameTransformation()
    {
        return state.frameTransformation;
    }

    public int getIntrinsicHeight()
    {
        return state.firstFrame.getHeight();
    }

    public int getIntrinsicWidth()
    {
        return state.firstFrame.getWidth();
    }

    public int getOpacity()
    {
        return -2;
    }

    public boolean isAnimated()
    {
        return true;
    }

    public boolean isRunning()
    {
        return isRunning;
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        applyGravity = true;
    }

    public void onFrameReady(int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11 && getCallback() == null)
        {
            stop();
            reset();
        } else
        {
            invalidateSelf();
            if (i == decoder.getFrameCount() - 1)
            {
                loopCount = loopCount + 1;
            }
            if (maxLoopCount != -1 && loopCount >= maxLoopCount)
            {
                stop();
                return;
            }
        }
    }

    public void recycle()
    {
        isRecycled = true;
        state.bitmapPool.put(state.firstFrame);
        frameLoader.clear();
        frameLoader.stop();
    }

    public void setAlpha(int i)
    {
        paint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        paint.setColorFilter(colorfilter);
    }

    public void setFrameTransformation(Transformation transformation, Bitmap bitmap)
    {
        if (bitmap == null)
        {
            throw new NullPointerException("The first frame of the GIF must not be null");
        }
        if (transformation == null)
        {
            throw new NullPointerException("The frame transformation must not be null");
        } else
        {
            state.frameTransformation = transformation;
            state.firstFrame = bitmap;
            frameLoader.setFrameTransformation(transformation);
            return;
        }
    }

    public void setLoopCount(int i)
    {
        if (i <= 0 && i != -1 && i != 0)
        {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i == 0)
        {
            maxLoopCount = decoder.getLoopCount();
            return;
        } else
        {
            maxLoopCount = i;
            return;
        }
    }

    public boolean setVisible(boolean flag, boolean flag1)
    {
        isVisible = flag;
        if (flag) goto _L2; else goto _L1
_L1:
        stopRunning();
_L4:
        return super.setVisible(flag, flag1);
_L2:
        if (isStarted)
        {
            startRunning();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void start()
    {
        isStarted = true;
        resetLoopCount();
        if (isVisible)
        {
            startRunning();
        }
    }

    public void stop()
    {
        isStarted = false;
        stopRunning();
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            reset();
        }
    }
}
