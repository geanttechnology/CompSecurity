// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.tgifview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import apx;
import aqc;
import axx;
import axy;
import axz;
import ayb;
import ayc;
import ayd;
import aye;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.StaticFlurryEvent;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import yp;

public class TGifView extends ImageView
    implements axy
{

    private GifImageType animationType;
    private boolean bIsOnce;
    public BitmapDrawable bitmapDrawable;
    private Bitmap currentImage;
    private aye drawThread;
    private long endTime;
    private axz gifDecoder;
    private aqc imageCache;
    private boolean isRun;
    private apx mDownload;
    private String mHomeWallCacheDir;
    public byte mImageByteArray[];
    private boolean pause;
    private Rect rect;
    private Handler redrawHandler;
    private int showHeight;
    private int showWidth;
    private long startTime;

    public TGifView(Context context)
    {
        super(context);
        gifDecoder = null;
        currentImage = null;
        isRun = true;
        pause = false;
        showWidth = -1;
        showHeight = -1;
        rect = null;
        drawThread = null;
        animationType = GifImageType.SYNC_DECODER;
        mDownload = new apx();
        imageCache = null;
        mHomeWallCacheDir = "homewallImages";
        mImageByteArray = null;
        startTime = 0L;
        endTime = 0L;
        bIsOnce = false;
        redrawHandler = new ayb(this);
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        imageCache = new aqc(context, mHomeWallCacheDir);
    }

    public TGifView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        imageCache = new aqc(context, mHomeWallCacheDir);
    }

    public TGifView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        gifDecoder = null;
        currentImage = null;
        isRun = true;
        pause = false;
        showWidth = -1;
        showHeight = -1;
        rect = null;
        drawThread = null;
        animationType = GifImageType.SYNC_DECODER;
        mDownload = new apx();
        imageCache = null;
        mHomeWallCacheDir = "homewallImages";
        mImageByteArray = null;
        startTime = 0L;
        endTime = 0L;
        bIsOnce = false;
        redrawHandler = new ayb(this);
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        imageCache = new aqc(context, mHomeWallCacheDir);
    }

    public TGifView(Context context, boolean flag)
    {
        super(context);
        gifDecoder = null;
        currentImage = null;
        isRun = true;
        pause = false;
        showWidth = -1;
        showHeight = -1;
        rect = null;
        drawThread = null;
        animationType = GifImageType.SYNC_DECODER;
        mDownload = new apx();
        imageCache = null;
        mHomeWallCacheDir = "homewallImages";
        mImageByteArray = null;
        startTime = 0L;
        endTime = 0L;
        bIsOnce = false;
        redrawHandler = new ayb(this);
        setGifTimes(flag);
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        imageCache = new aqc(context, mHomeWallCacheDir);
    }

    private int getOSVersionSDK()
    {
        int i;
        try
        {
            i = Integer.valueOf(android.os.Build.VERSION.SDK).intValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0;
        }
        return i;
    }

    private void postHomeWallIconRequestTime(boolean flag)
    {
        float f = 10F;
        float f1;
        endTime = (new Date()).getTime();
        f1 = (float)(endTime - startTime) / 1000F;
        if (f1 < 10F) goto _L2; else goto _L1
_L1:
        f = (int)Math.ceil(f);
        new HashMap();
        if (!flag) goto _L4; else goto _L3
_L3:
        if (yp.a())
        {
            StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_imageLoadTimeCN, (new StringBuilder()).append("wall_").append(f).append("s").toString());
            return;
        }
        try
        {
            StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_imageLoadTimeEN, (new StringBuilder()).append("wall_").append(f).append("s").toString());
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        return;
_L6:
        f = f1;
        continue; /* Loop/switch isn't completed */
_L4:
        return;
_L2:
        if (f1 > 0.0F) goto _L6; else goto _L5
_L5:
        f = 0.0F;
        if (true) goto _L1; else goto _L7
_L7:
    }

    private void reDraw()
    {
        if (redrawHandler != null)
        {
            android.os.Message message = redrawHandler.obtainMessage();
            redrawHandler.sendMessage(message);
        }
    }

    private void setGifDecoderImage(InputStream inputstream)
    {
        if (gifDecoder != null)
        {
            gifDecoder.a();
            gifDecoder = null;
        }
        gifDecoder = new axz(inputstream, this);
        gifDecoder.a(bIsOnce);
        gifDecoder.start();
    }

    private void setGifDecoderImage(byte abyte0[])
    {
        if (gifDecoder != null)
        {
            gifDecoder.a();
            gifDecoder = null;
        }
        gifDecoder = new axz(abyte0, this);
        gifDecoder.a(bIsOnce);
        gifDecoder.start();
    }

    private void setdefaultShowRect()
    {
        showWidth = getWidth();
        showHeight = getHeight();
        rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        rect.right = getWidth();
        rect.bottom = getHeight();
    }

    public String getExtension(String s)
    {
        String s2 = "jpg";
        String s1 = s2;
        if (s != null)
        {
            s1 = s2;
            if (s.length() > 0)
            {
                int i = s.lastIndexOf('.');
                s1 = s2;
                if (i > -1)
                {
                    s1 = s2;
                    if (i < s.length() - 1)
                    {
                        s1 = s.substring(i + 1);
                    }
                }
            }
        }
        return s1;
    }

    public void loadImage(String s, String s1, axx axx1)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s2;
        startTime = (new Date()).getTime();
        if (imageCache == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        s2 = getExtension(s);
        String s3 = (new StringBuilder()).append(s1).append(".").append(s2).toString();
        if (!imageCache.b(s3).booleanValue())
        {
            break MISSING_BLOCK_LABEL_162;
        }
        mImageByteArray = imageCache.c(s3);
        if (mImageByteArray == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        if (!s2.equalsIgnoreCase("gif"))
        {
            break MISSING_BLOCK_LABEL_136;
        }
        setGifImage(mImageByteArray);
_L4:
        postHomeWallIconRequestTime(true);
        if (axx1 == null) goto _L1; else goto _L3
_L3:
        try
        {
            axx1.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
        break MISSING_BLOCK_LABEL_161;
        setImageBitmap(BitmapFactory.decodeByteArray(mImageByteArray, 0, mImageByteArray.length));
          goto _L4
        return;
        StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_imageRequest, "wall_start");
        startTime = (new Date()).getTime();
        mDownload.a(s, new ayc(this, s1, axx1));
        return;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (gifDecoder != null)
        {
            if (currentImage == null || currentImage.isRecycled())
            {
                currentImage = gifDecoder.c();
            }
            if (currentImage != null)
            {
                int i = canvas.getSaveCount();
                canvas.save();
                canvas.translate(getPaddingLeft(), getPaddingTop());
                if (showWidth == -1)
                {
                    canvas.drawBitmap(currentImage, 0.0F, 0.0F, null);
                } else
                {
                    canvas.drawBitmap(currentImage, null, rect, null);
                }
                canvas.restoreToCount(i);
                return;
            }
        }
    }

    protected void onMeasure(int i, int j)
    {
        int k = 1;
        int k1 = getPaddingLeft();
        int l1 = getPaddingRight();
        int i1 = getPaddingTop();
        int j1 = getPaddingBottom();
        int l;
        if (gifDecoder == null)
        {
            l = 1;
        } else
        {
            l = gifDecoder.a;
            k = gifDecoder.b;
        }
        l = Math.max(l + (k1 + l1), getSuggestedMinimumWidth());
        k = Math.max(k + (i1 + j1), getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSize(l, i), resolveSize(k, j));
    }

    public void parseOk(boolean flag, int i)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (gifDecoder == null)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        ayd.a[animationType.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 49
    //                   2 83
    //                   3 153;
           goto _L2 _L3 _L4 _L5
_L2:
        return;
_L3:
        if (i == -1)
        {
            if (gifDecoder.b() > 1)
            {
                (new aye(this, null)).start();
                return;
            } else
            {
                reDraw();
                return;
            }
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        if (i == 1)
        {
            currentImage = gifDecoder.c();
            reDraw();
            return;
        }
        if (i == -1)
        {
            if (gifDecoder.b() > 1)
            {
                if (drawThread == null)
                {
                    drawThread = new aye(this, null);
                    drawThread.start();
                    return;
                }
            } else
            {
                reDraw();
                return;
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (i == 1)
        {
            currentImage = gifDecoder.c();
            reDraw();
            return;
        }
        if (i == -1)
        {
            reDraw();
            return;
        }
        if (drawThread != null) goto _L2; else goto _L6
_L6:
        drawThread = new aye(this, null);
        drawThread.start();
        return;
        Log.e("gif", "parse error");
        return;
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

    public void setGifTimes(boolean flag)
    {
        bIsOnce = flag;
    }

    public void setShowDimension(int i, int j)
    {
        if (i > 0 && j > 0)
        {
            showWidth = i;
            showHeight = j;
            rect = new Rect();
            rect.left = 0;
            rect.top = 0;
            rect.right = i;
            rect.bottom = j;
        }
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
    public static Bitmap access$402(TGifView tgifview, Bitmap bitmap)
    {
        tgifview.currentImage = bitmap;
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
            return (GifImageType)Enum.valueOf(com/fotoable/tgifview/TGifView$GifImageType, s);
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
