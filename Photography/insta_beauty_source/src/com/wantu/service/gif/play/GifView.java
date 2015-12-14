// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.gif.play;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import bnu;
import bnv;
import bnx;
import bny;
import bnz;
import java.io.InputStream;
import java.util.Timer;

public class GifView extends ImageView
    implements bnu
{

    private GifImageType animationType;
    private View backView;
    private boolean cacheImage;
    private Context context;
    private Bitmap currentImage;
    private bnv gifDecoder;
    private boolean isRun;
    private bnu listener;
    private Timer mFlashTimer;
    private boolean pause;
    private Handler redrawHandler;

    public GifView(Context context1)
    {
        super(context1);
        gifDecoder = null;
        currentImage = null;
        isRun = true;
        pause = false;
        context = null;
        cacheImage = false;
        backView = null;
        animationType = GifImageType.SYNC_DECODER;
        redrawHandler = new bnx(this);
        context = context1;
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
    }

    public GifView(Context context1, AttributeSet attributeset)
    {
        this(context1, attributeset, 0);
    }

    public GifView(Context context1, AttributeSet attributeset, int i)
    {
        super(context1, attributeset, i);
        gifDecoder = null;
        currentImage = null;
        isRun = true;
        pause = false;
        context = null;
        cacheImage = false;
        backView = null;
        animationType = GifImageType.SYNC_DECODER;
        redrawHandler = new bnx(this);
        context = context1;
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
    }

    private void drawImage()
    {
        if (currentImage != null && isRun)
        {
            setImageBitmap(currentImage);
            invalidate();
        }
    }

    private void reDraw()
    {
        if (redrawHandler != null)
        {
            android.os.Message message = redrawHandler.obtainMessage();
            redrawHandler.sendMessage(message);
        }
    }

    private void scheduleTimer(long l)
    {
        if (mFlashTimer == null)
        {
            mFlashTimer = new Timer();
        } else
        {
            mFlashTimer.cancel();
            mFlashTimer = new Timer();
        }
        if (l == 0L)
        {
            l = 100L;
        }
        mFlashTimer.scheduleAtFixedRate(new bnz(this), 0L, l);
    }

    private void setGifDecoderImage(InputStream inputstream)
    {
        isRun = true;
        if (gifDecoder == null)
        {
            gifDecoder = new bnv(this);
        }
        gifDecoder.a(inputstream);
        gifDecoder.start();
    }

    private void setGifDecoderImage(byte abyte0[])
    {
        isRun = true;
        if (gifDecoder == null)
        {
            gifDecoder = new bnv(this);
        }
        gifDecoder.a(abyte0);
        gifDecoder.start();
    }

    public void destroy()
    {
        isRun = false;
        if (mFlashTimer != null)
        {
            mFlashTimer.cancel();
            mFlashTimer = null;
        }
        try
        {
            Thread.sleep(100L);
        }
        catch (InterruptedException interruptedexception) { }
        setImageBitmap(null);
        currentImage = null;
        if (gifDecoder != null)
        {
            gifDecoder.a();
        }
        gifDecoder = null;
    }

    public bnu getListener()
    {
        return listener;
    }

    public void parseOk(boolean flag, int i)
    {
        if (listener != null)
        {
            listener.parseOk(flag, i);
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (gifDecoder == null)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        bny.a[animationType.ordinal()];
        JVM INSTR tableswitch 1 2: default 64
    //                   1 65
    //                   2 100;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        if (i == -1)
        {
            if (gifDecoder.b() > 1)
            {
                scheduleTimer(gifDecoder.a(0));
                return;
            } else
            {
                reDraw();
                return;
            }
        }
        if (true) goto _L2; else goto _L4
_L4:
        if (i == 1)
        {
            currentImage = gifDecoder.c();
            reDraw();
            return;
        }
        if (i != -1) goto _L2; else goto _L5
_L5:
        if (gifDecoder.b() > 1)
        {
            scheduleTimer(gifDecoder.a(0));
            return;
        } else
        {
            reDraw();
            return;
        }
        Log.e("gif", "parse error");
        return;
    }

    public void setAsBackground(View view)
    {
        backView = view;
    }

    public void setCahceImage()
    {
        if (gifDecoder == null)
        {
            gifDecoder = new bnv(this);
        }
        cacheImage = true;
        gifDecoder.a(true, context);
    }

    public void setGifImage(int i)
    {
        setGifDecoderImage(getResources().openRawResource(i));
    }

    public void setGifImage(InputStream inputstream)
    {
        setGifDecoderImage(inputstream);
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

    public void setListener(bnu bnu1)
    {
        listener = bnu1;
    }

    public void showAnimation()
    {
        if (pause)
        {
            pause = false;
        }
    }

    public void showCover()
    {
        if (gifDecoder == null)
        {
            return;
        } else
        {
            pause = true;
            currentImage = gifDecoder.c();
            invalidate();
            return;
        }
    }




/*
    public static Bitmap access$102(GifView gifview, Bitmap bitmap)
    {
        gifview.currentImage = bitmap;
        return bitmap;
    }

*/





    private class GifImageType extends Enum
    {

        private static final GifImageType $VALUES[];
        public static final GifImageType COVER;
        public static final GifImageType SYNC_DECODER;
        public static final GifImageType WAIT_FINISH;
        final int nativeInt;

        public static GifImageType valueOf(String s)
        {
            return (GifImageType)Enum.valueOf(com/wantu/service/gif/play/GifView$GifImageType, s);
        }

        public static GifImageType[] values()
        {
            return (GifImageType[])$VALUES.clone();
        }

        static 
        {
            WAIT_FINISH = new GifImageType("WAIT_FINISH", 0, 0);
            SYNC_DECODER = new GifImageType("SYNC_DECODER", 1, 1);
            COVER = new GifImageType("COVER", 2, 2);
            $VALUES = (new GifImageType[] {
                WAIT_FINISH, SYNC_DECODER, COVER
            });
        }

        private GifImageType(String s, int i, int j)
        {
            super(s, i);
            nativeInt = j;
        }
    }

}
