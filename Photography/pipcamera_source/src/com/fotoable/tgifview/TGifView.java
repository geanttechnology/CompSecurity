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
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.StaticFlurryEvent;
import ew;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import kl;
import km;
import kn;
import pc;
import pd;
import pe;
import pg;

public class TGifView extends ImageView
    implements pd
{

    private GifImageType animationType;
    private boolean bIsOnce;
    public BitmapDrawable bitmapDrawable;
    private Bitmap currentImage;
    private pg drawThread;
    private long endTime;
    private pe gifDecoder;
    private kn imageCache;
    private boolean isRun;
    private kl mDownload;
    private String mHomeWallCacheDir;
    public byte mImageByteArray[];
    private boolean pause;
    private Rect rect;
    private Handler redrawHandler = new Handler() {

        final TGifView a;

        public void handleMessage(Message message)
        {
            a.invalidate();
        }

            
            {
                a = TGifView.this;
                super();
            }
    };
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
        mDownload = new kl();
        imageCache = null;
        mHomeWallCacheDir = "homewallImages";
        mImageByteArray = null;
        startTime = 0L;
        endTime = 0L;
        bIsOnce = false;
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        imageCache = new kn(context, mHomeWallCacheDir);
    }

    public TGifView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        imageCache = new kn(context, mHomeWallCacheDir);
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
        mDownload = new kl();
        imageCache = null;
        mHomeWallCacheDir = "homewallImages";
        mImageByteArray = null;
        startTime = 0L;
        endTime = 0L;
        bIsOnce = false;
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        imageCache = new kn(context, mHomeWallCacheDir);
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
        mDownload = new kl();
        imageCache = null;
        mHomeWallCacheDir = "homewallImages";
        mImageByteArray = null;
        startTime = 0L;
        endTime = 0L;
        bIsOnce = false;
        setGifTimes(flag);
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        imageCache = new kn(context, mHomeWallCacheDir);
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
        if (ew.a())
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
            Message message = redrawHandler.obtainMessage();
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
        gifDecoder = new pe(inputstream, this);
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
        gifDecoder = new pe(abyte0, this);
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

    public void loadImage(String s, String s1, pc pc1)
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
        if (pc1 == null) goto _L1; else goto _L3
_L3:
        try
        {
            pc1.a();
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
        mDownload.a(s, new km(s1, pc1) {

            final String a;
            final pc b;
            final TGifView c;

            public void a(Exception exception)
            {
                StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_imageRequest, "wall_fail");
            }

            public void a(String s4, byte abyte0[])
            {
                String s5;
                c.mImageByteArray = abyte0;
                s5 = c.getExtension(s4);
                String s6 = (new StringBuilder()).append(a).append(".").append(s5).toString();
                c.imageCache.a(s6, abyte0);
                c.imageCache.a(s4);
                if (!s5.equalsIgnoreCase("gif"))
                {
                    break MISSING_BLOCK_LABEL_117;
                }
                c.setGifImage(c.mImageByteArray);
_L1:
                if (b != null)
                {
                    b.a();
                }
                c.postHomeWallIconRequestTime(false);
                return;
                try
                {
                    c.setImageBitmap(BitmapFactory.decodeByteArray(c.mImageByteArray, 0, c.mImageByteArray.length));
                }
                // Misplaced declaration of an exception variable
                catch (String s4)
                {
                    Crashlytics.logException(s4);
                    StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_imageRequest, "wall_fail");
                    return;
                }
                  goto _L1
            }

            
            {
                c = TGifView.this;
                a = s;
                b = pc1;
                super();
            }
        });
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
        class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[GifImageType.values().length];
                try
                {
                    a[GifImageType.WAIT_FINISH.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[GifImageType.COVER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[GifImageType.SYNC_DECODER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3.a[animationType.ordinal()];
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
                (new pg(this)).start();
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
                    drawThread = new pg(this);
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
        drawThread = new pg(this);
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
