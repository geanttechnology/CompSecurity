// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ant.liao;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.ant.liao:
//            GifAction, GifReDraw, GifImageType, GifAnimation, 
//            GifListener, GifDecoder, GifFrame

public class GifDrawable extends Drawable
    implements GifAction, GifReDraw
{
    static final class BitmapState extends android.graphics.drawable.Drawable.ConstantState
    {

        Bitmap mBitmap;
        int mChangingConfigurations;
        int mGravity;
        Paint mPaint;
        boolean mRebuildShader;
        int mTargetDensity;
        android.graphics.Shader.TileMode mTileModeX;
        android.graphics.Shader.TileMode mTileModeY;

        public int getChangingConfigurations()
        {
            return mChangingConfigurations;
        }

        public Drawable newDrawable()
        {
            return new GifDrawable(this, null, null);
        }

        public Drawable newDrawable(Resources resources)
        {
            return new GifDrawable(this, resources, null);
        }

        BitmapState(Bitmap bitmap)
        {
            mGravity = 119;
            mPaint = new Paint(6);
            mTileModeX = null;
            mTileModeY = null;
            mTargetDensity = 160;
            mBitmap = bitmap;
        }

        BitmapState(BitmapState bitmapstate)
        {
            this(bitmapstate.mBitmap);
            mChangingConfigurations = bitmapstate.mChangingConfigurations;
            mGravity = bitmapstate.mGravity;
            mTileModeX = bitmapstate.mTileModeX;
            mTileModeY = bitmapstate.mTileModeY;
            mTargetDensity = bitmapstate.mTargetDensity;
            mPaint = new Paint(bitmapstate.mPaint);
            mRebuildShader = bitmapstate.mRebuildShader;
        }
    }


    private static final int DEFAULT_PAINT_FLAGS = 6;
    private GifAnimation animation;
    private boolean animationRun;
    private GifImageType animationType;
    private int currentFrame;
    private Bitmap currentImage;
    private int currentLoop;
    private GifDecoder gifDecoder;
    private int iListenerType;
    private boolean isLoop;
    private GifListener listener;
    private int loopNum;
    private boolean mApplyGravity;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private BitmapState mBitmapState;
    private int mBitmapWidth;
    private final Rect mDstRect;
    private boolean mMutated;
    private int mTargetDensity;
    private Handler redrawHandler = new Handler() {

        final GifDrawable this$0;

        public void handleMessage(Message message)
        {
            try
            {
                drawImage();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                Log.e("GifView", message.toString());
            }
        }

            
            {
                this$0 = GifDrawable.this;
                super();
            }
    };
    private boolean singleFrame;

    public GifDrawable()
    {
        gifDecoder = null;
        animationType = GifImageType.SYNC_DECODER;
        loopNum = -1;
        currentLoop = 0;
        animation = null;
        animationRun = false;
        isLoop = false;
        singleFrame = false;
        currentImage = null;
        listener = null;
        iListenerType = 0;
        currentFrame = 0;
        mDstRect = new Rect();
        mBitmapState = new BitmapState(null);
        mBitmapState.mTargetDensity = mTargetDensity;
        animation = new GifAnimation();
        animation.setRedraw(this);
    }

    private GifDrawable(BitmapState bitmapstate, Resources resources)
    {
        Object obj = null;
        super();
        gifDecoder = null;
        animationType = GifImageType.SYNC_DECODER;
        loopNum = -1;
        currentLoop = 0;
        animation = null;
        animationRun = false;
        isLoop = false;
        singleFrame = false;
        currentImage = null;
        listener = null;
        iListenerType = 0;
        currentFrame = 0;
        mDstRect = new Rect();
        mBitmapState = bitmapstate;
        if (resources != null)
        {
            mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else
        {
            mTargetDensity = bitmapstate.mTargetDensity;
        }
        resources = obj;
        if (bitmapstate != null)
        {
            resources = bitmapstate.mBitmap;
        }
        setBitmap(resources);
    }

    GifDrawable(BitmapState bitmapstate, Resources resources, GifDrawable gifdrawable)
    {
        this(bitmapstate, resources);
    }

    private void computeBitmapSize()
    {
        mBitmapWidth = mBitmap.getScaledWidth(mTargetDensity);
        mBitmapHeight = mBitmap.getScaledHeight(mTargetDensity);
    }

    private void drawImage()
    {
        if (currentImage == null || currentImage != null && !currentImage.isRecycled())
        {
            setBitmap(currentImage);
            if (listener != null && (iListenerType == 2 || iListenerType == 3))
            {
                currentFrame = currentFrame + 1;
                listener.frameCount(currentFrame);
            }
            invalidateSelf();
        }
    }

    private int getCurrentFrame()
    {
        GifFrame gifframe;
label0:
        {
            if (gifDecoder != null)
            {
                gifframe = gifDecoder.next();
                if (gifframe != null)
                {
                    break label0;
                }
            }
            return -1;
        }
        if (gifframe.image != null)
        {
            currentImage = gifframe.image;
            mTargetDensity = (new BitmapState(currentImage)).mTargetDensity;
            mBitmapState.mTargetDensity = mTargetDensity;
        }
        return gifframe.delay;
    }

    private void init()
    {
        stopDrawThread();
        if (currentImage != null)
        {
            currentImage = null;
        }
        if (gifDecoder != null)
        {
            stopDecodeThread();
            gifDecoder.destroy();
            gifDecoder = null;
        }
        currentLoop = 0;
        gifDecoder = new GifDecoder(this);
        if (isLoop)
        {
            gifDecoder.setLoopAnimation();
        }
    }

    private void invalidateImage()
    {
        if (redrawHandler != null)
        {
            Message message = redrawHandler.obtainMessage();
            redrawHandler.sendMessage(message);
        }
    }

    private void reAnimation()
    {
        if (singleFrame)
        {
            return;
        } else
        {
            stopDrawThread();
            currentLoop = 0;
            animation.runAnimation();
            return;
        }
    }

    private void setBitmap(Bitmap bitmap)
    {
        if (bitmap != mBitmap)
        {
            mBitmap = bitmap;
            if (bitmap != null)
            {
                if (mTargetDensity == 0)
                {
                    mTargetDensity = mBitmap.getDensity();
                }
                computeBitmapSize();
            } else
            {
                mBitmapHeight = -1;
                mBitmapWidth = -1;
            }
            mApplyGravity = true;
            invalidateSelf();
        }
    }

    private void stopDecodeThread()
    {
        if (gifDecoder != null && gifDecoder.getState() != Thread.State.TERMINATED)
        {
            gifDecoder.interrupt();
        }
    }

    private void stopDrawThread()
    {
        if (singleFrame)
        {
            return;
        } else
        {
            animation.stopAnimation();
            animationRun = false;
            return;
        }
    }

    public void destroy()
    {
        stopDrawThread();
        stopDecodeThread();
        animation.destroy();
        gifDecoder.destroy();
        gifDecoder = null;
        animation = null;
    }

    public void draw(Canvas canvas)
    {
        BitmapState bitmapstate;
label0:
        {
            Bitmap bitmap = mBitmap;
            if (bitmap != null)
            {
                bitmapstate = mBitmapState;
                if (bitmapstate.mRebuildShader)
                {
                    android.graphics.Shader.TileMode tilemode1 = bitmapstate.mTileModeX;
                    android.graphics.Shader.TileMode tilemode2 = bitmapstate.mTileModeY;
                    if (tilemode1 == null && tilemode2 == null)
                    {
                        bitmapstate.mPaint.setShader(null);
                    } else
                    {
                        Paint paint = bitmapstate.mPaint;
                        android.graphics.Shader.TileMode tilemode = tilemode1;
                        if (tilemode1 == null)
                        {
                            tilemode = android.graphics.Shader.TileMode.CLAMP;
                        }
                        tilemode1 = tilemode2;
                        if (tilemode2 == null)
                        {
                            tilemode1 = android.graphics.Shader.TileMode.CLAMP;
                        }
                        paint.setShader(new BitmapShader(bitmap, tilemode, tilemode1));
                    }
                    bitmapstate.mRebuildShader = false;
                    copyBounds(mDstRect);
                }
                if (bitmapstate.mPaint.getShader() != null)
                {
                    break label0;
                }
                if (mApplyGravity)
                {
                    Gravity.apply(bitmapstate.mGravity, mBitmapWidth, mBitmapHeight, getBounds(), mDstRect);
                    mApplyGravity = false;
                }
                canvas.drawBitmap(bitmap, null, mDstRect, bitmapstate.mPaint);
            }
            return;
        }
        if (mApplyGravity)
        {
            copyBounds(mDstRect);
            mApplyGravity = false;
        }
        canvas.drawRect(mDstRect, bitmapstate.mPaint);
    }

    public final Bitmap getBitmap()
    {
        return mBitmap;
    }

    public int getChangingConfigurations()
    {
        return super.getChangingConfigurations() | mBitmapState.mChangingConfigurations;
    }

    public final android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        mBitmapState.mChangingConfigurations = getChangingConfigurations();
        return mBitmapState;
    }

    public int getGravity()
    {
        return mBitmapState.mGravity;
    }

    public int getIntrinsicHeight()
    {
        return mBitmapHeight;
    }

    public int getIntrinsicWidth()
    {
        return mBitmapWidth;
    }

    public int getOpacity()
    {
        Bitmap bitmap;
        if (mBitmapState.mGravity == 119)
        {
            if ((bitmap = mBitmap) != null && !bitmap.hasAlpha() && mBitmapState.mPaint.getAlpha() >= 255)
            {
                return -1;
            }
        }
        return -3;
    }

    public final Paint getPaint()
    {
        return mBitmapState.mPaint;
    }

    public android.graphics.Shader.TileMode getTileModeX()
    {
        return mBitmapState.mTileModeX;
    }

    public android.graphics.Shader.TileMode getTileModeY()
    {
        return mBitmapState.mTileModeY;
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset)
        throws XmlPullParserException, IOException
    {
        super.inflate(resources, xmlpullparser, attributeset);
    }

    public void loopEnd()
    {
        currentLoop = currentLoop + 1;
        if (loopNum > 0 && currentLoop >= loopNum)
        {
            stopDrawThread();
            stopDecodeThread();
        }
        if (listener != null)
        {
            if (iListenerType == 1 || iListenerType == 3)
            {
                listener.gifEnd(currentLoop);
            }
            currentFrame = 0;
        }
    }

    public Drawable mutate()
    {
        if (!mMutated && super.mutate() == this)
        {
            mBitmapState = new BitmapState(mBitmapState);
            mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        mApplyGravity = true;
    }

    public void parseReturn(int i)
    {
        i;
        JVM INSTR tableswitch 1 4: default 32
    //                   1 33
    //                   2 79
    //                   3 146
    //                   4 173;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        Log.d("parseReturn", "FIRST");
        if (animationType == GifImageType.COVER || animationType == GifImageType.SYNC_DECODER)
        {
            currentImage = gifDecoder.getFrameImage();
            invalidateImage();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        Log.d("parseReturn", "FINISH");
        if (gifDecoder.getFrameCount() == 1)
        {
            currentImage = gifDecoder.getFrameImage();
            invalidateImage();
            stopDrawThread();
            stopDecodeThread();
            singleFrame = true;
            return;
        }
        if (!animationRun)
        {
            reAnimation();
            animationRun = true;
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        Log.d("parseReturn", "CACHE_FINISH");
        if (!animationRun)
        {
            reAnimation();
            animationRun = true;
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
        Log.d("parseReturn", "ERROR");
        return;
    }

    public void pauseGifAnimation()
    {
        if (singleFrame)
        {
            return;
        } else
        {
            animation.pauseAnimation();
            return;
        }
    }

    public int reDraw()
    {
        int i = getCurrentFrame();
        drawImage();
        return i;
    }

    public void restartGifAnimation()
    {
        while (singleFrame || !animationRun) 
        {
            return;
        }
        animation.restartAnimation();
    }

    public void setAlpha(int i)
    {
        if (i != mBitmapState.mPaint.getAlpha())
        {
            mBitmapState.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean flag)
    {
        mBitmapState.mPaint.setAntiAlias(flag);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mBitmapState.mPaint.setColorFilter(colorfilter);
        invalidateSelf();
    }

    public void setDither(boolean flag)
    {
        mBitmapState.mPaint.setDither(flag);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean flag)
    {
        mBitmapState.mPaint.setFilterBitmap(flag);
        invalidateSelf();
    }

    public void setGifImage(Resources resources, int i)
    {
        init();
        gifDecoder.setGifImage(resources, i);
        gifDecoder.start();
    }

    public void setGifImage(String s)
    {
        init();
        gifDecoder.setGifImage(s);
        gifDecoder.start();
    }

    public void setGifImage(byte abyte0[])
    {
        init();
        gifDecoder.setGifImage(abyte0);
        gifDecoder.start();
    }

    public void setGravity(int i)
    {
        if (mBitmapState.mGravity != i)
        {
            mBitmapState.mGravity = i;
            mApplyGravity = true;
            invalidateSelf();
        }
    }

    public void setListener(GifListener giflistener, int i)
    {
        listener = giflistener;
        if (i >= 1 && i <= 3)
        {
            iListenerType = i;
        }
    }

    public void setLoopAnimation()
    {
        isLoop = true;
        if (gifDecoder != null)
        {
            gifDecoder.setLoopAnimation();
        }
    }

    public void setLoopNumber(int i)
    {
        if (i > 1)
        {
            loopNum = i;
            setLoopAnimation();
        }
    }

    public void setTargetDensity(int i)
    {
        if (mTargetDensity != i)
        {
            int j = i;
            if (i == 0)
            {
                j = 160;
            }
            mTargetDensity = j;
            if (mBitmap != null)
            {
                computeBitmapSize();
            }
            invalidateSelf();
        }
    }

    public void setTargetDensity(Canvas canvas)
    {
        setTargetDensity(canvas.getDensity());
    }

    public void setTargetDensity(DisplayMetrics displaymetrics)
    {
        setTargetDensity(displaymetrics.densityDpi);
    }

    public void setTileModeX(android.graphics.Shader.TileMode tilemode)
    {
        setTileModeXY(tilemode, mBitmapState.mTileModeY);
    }

    public void setTileModeXY(android.graphics.Shader.TileMode tilemode, android.graphics.Shader.TileMode tilemode1)
    {
        BitmapState bitmapstate = mBitmapState;
        if (bitmapstate.mTileModeX != tilemode || bitmapstate.mTileModeY != tilemode1)
        {
            bitmapstate.mTileModeX = tilemode;
            bitmapstate.mTileModeY = tilemode1;
            bitmapstate.mRebuildShader = true;
            invalidateSelf();
        }
    }

    public final void setTileModeY(android.graphics.Shader.TileMode tilemode)
    {
        setTileModeXY(mBitmapState.mTileModeX, tilemode);
    }

}
