// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ant.liao;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

// Referenced classes of package com.ant.liao:
//            GifAction, GifReDraw, GifImageType, GifAnimation, 
//            GifListener, GifDecoder, GifFrame

public class GifView extends ImageView
    implements GifAction, GifReDraw
{

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
    private Handler redrawHandler = new Handler() {

        final GifView this$0;

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
                this$0 = GifView.this;
                super();
            }
    };
    private boolean singleFrame;

    public GifView(Context context)
    {
        super(context);
        gifDecoder = null;
        currentImage = null;
        animation = null;
        animationRun = false;
        loopNum = -1;
        isLoop = false;
        currentLoop = 0;
        currentFrame = 0;
        listener = null;
        singleFrame = false;
        iListenerType = 0;
        animationType = GifImageType.SYNC_DECODER;
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        animation = new GifAnimation();
        animation.setRedraw(this);
    }

    public GifView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public GifView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        gifDecoder = null;
        currentImage = null;
        animation = null;
        animationRun = false;
        loopNum = -1;
        isLoop = false;
        currentLoop = 0;
        currentFrame = 0;
        listener = null;
        singleFrame = false;
        iListenerType = 0;
        animationType = GifImageType.SYNC_DECODER;
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        animation = new GifAnimation();
        animation.setRedraw(this);
    }

    private void drawImage()
    {
        if (currentImage == null || currentImage != null && !currentImage.isRecycled())
        {
            setImageBitmap(currentImage);
            invalidate();
            if (listener != null && (iListenerType == 2 || iListenerType == 3))
            {
                currentFrame = currentFrame + 1;
                listener.frameCount(currentFrame);
            }
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

    private void setGifDecoderImage(Resources resources, int i)
    {
        init();
        gifDecoder.setGifImage(resources, i);
        gifDecoder.start();
    }

    private void setGifDecoderImage(byte abyte0[])
    {
        init();
        gifDecoder.setGifImage(abyte0);
        gifDecoder.start();
    }

    private void stopDecodeThread()
    {
        if (gifDecoder != null && gifDecoder.getState() != Thread.State.TERMINATED)
        {
            gifDecoder.interrupt();
            gifDecoder.destroy();
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

    public void dispatchWindowVisibilityChanged(int i)
    {
        if (i != 8 && i != 4) goto _L2; else goto _L1
_L1:
        pauseGifAnimation();
_L4:
        super.dispatchWindowVisibilityChanged(i);
        return;
_L2:
        if (i == 0)
        {
            restartGifAnimation();
        }
        if (true) goto _L4; else goto _L3
_L3:
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

    protected void onWindowVisibilityChanged(int i)
    {
    }

    public void parseReturn(int i)
    {
        if (getVisibility() != 8 && getVisibility() != 4) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            Log.d("parseReturn", "FIRST");
            if (animationType == GifImageType.COVER || animationType == GifImageType.SYNC_DECODER)
            {
                currentImage = gifDecoder.getFrameImage();
                invalidateImage();
                return;
            }
            break;

        case 2: // '\002'
            Log.d("parseReturn", "FINISH");
            if (gifDecoder.getFrameCount() == 1)
            {
                getCurrentFrame();
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
            break;

        case 3: // '\003'
            Log.d("parseReturn", "CACHE_FINISH");
            if (!animationRun)
            {
                reAnimation();
                animationRun = true;
                return;
            }
            break;

        case 4: // '\004'
            Log.e("parseReturn", "ERROR");
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
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

    public void setGifImage(int i)
    {
        setGifDecoderImage(getResources(), i);
    }

    public void setGifImage(String s)
    {
        init();
        gifDecoder.setGifImage(s);
        gifDecoder.start();
    }

    public void setGifImage(byte abyte0[])
    {
        setGifDecoderImage(abyte0);
    }

    public void setGifImageType(GifImageType gifimagetype)
    {
        if (gifDecoder == null)
        {
            animationType = gifimagetype;
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

    public void setVisibility(int i)
    {
        super.setVisibility(i);
        if (i == 8 || i == 4)
        {
            stopDrawThread();
        } else
        if (i == 0)
        {
            reAnimation();
            return;
        }
    }

}
