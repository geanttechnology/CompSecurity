// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.bumptech.glide.gifdecoder:
//            GifHeader, GifFrame

public class GifDecoder
{
    public static interface BitmapProvider
    {

        public abstract Bitmap obtain(int i, int j, android.graphics.Bitmap.Config config);

        public abstract void release(Bitmap bitmap);
    }


    private static final android.graphics.Bitmap.Config BITMAP_CONFIG;
    private static final String TAG = com/bumptech/glide/gifdecoder/GifDecoder.getSimpleName();
    private int act[];
    private BitmapProvider bitmapProvider;
    private final byte block[] = new byte[256];
    private byte data[];
    private int framePointer;
    private GifHeader header;
    private byte mainPixels[];
    private int mainScratch[];
    private byte pixelStack[];
    private short prefix[];
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private boolean savePrevious;
    private int status;
    private byte suffix[];

    public GifDecoder(BitmapProvider bitmapprovider)
    {
        bitmapProvider = bitmapprovider;
        header = new GifHeader();
    }

    private void decodeBitmapData(GifFrame gifframe)
    {
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int i4;
        int i5;
        int j5;
        if (gifframe != null)
        {
            rawData.position(gifframe.bufferFrameStart);
        }
        if (gifframe == null)
        {
            l2 = header.width * header.height;
        } else
        {
            l2 = gifframe.iw * gifframe.ih;
        }
        if (mainPixels == null || mainPixels.length < l2)
        {
            mainPixels = new byte[l2];
        }
        if (prefix == null)
        {
            prefix = new short[4096];
        }
        if (suffix == null)
        {
            suffix = new byte[4096];
        }
        if (pixelStack == null)
        {
            pixelStack = new byte[4097];
        }
        i5 = read();
        j5 = 1 << i5;
        i4 = j5 + 2;
        k = -1;
        l1 = i5 + 1;
        k1 = (1 << l1) - 1;
        for (int i = 0; i < j5; i++)
        {
            prefix[i] = 0;
            suffix[i] = (byte)i;
        }

        i2 = 0;
        j1 = 0;
        j = 0;
        j2 = 0;
        i1 = 0;
        l = 0;
        k2 = 0;
        i3 = 0;
        break MISSING_BLOCK_LABEL_211;
        j3 = 0;
        int j4;
        int k4;
        k2 += (block[j3] & 0xff) << l;
        i1 = l + 8;
        k4 = j3 + 1;
        j4 = i2 - 1;
        i2 = i4;
        break MISSING_BLOCK_LABEL_316;
_L2:
        int j3;
        if (i3 < l2)
        {
            j3 = i2;
            i2 = i1;
            if (i1 != 0)
            {
                break MISSING_BLOCK_LABEL_274;
            }
            i2 = readBlock();
            if (i2 > 0)
            {
                break MISSING_BLOCK_LABEL_271;
            }
            status = 3;
        }
        for (; j1 < l2; j1++)
        {
            mainPixels[j1] = 0;
        }

        return;
        do
        {
            if (i1 < l1)
            {
                break;
            }
            l = k2 & k1;
            int k3 = k2 >> l1;
            int l3 = i1 - l1;
            if (l == j5)
            {
                l1 = i5 + 1;
                k1 = (1 << l1) - 1;
                i2 = j5 + 2;
                k = -1;
                i1 = l3;
                k2 = k3;
                continue;
            }
            if (l > i2)
            {
                status = 3;
                i4 = i2;
                i2 = k4;
                l = l3;
                i1 = j4;
                k2 = k3;
                continue; /* Loop/switch isn't completed */
            }
            if (l == j5 + 1)
            {
                i4 = i2;
                i2 = k4;
                l = l3;
                i1 = j4;
                k2 = k3;
                continue; /* Loop/switch isn't completed */
            }
            if (k == -1)
            {
                pixelStack[j] = suffix[l];
                k = l;
                j++;
                i1 = l3;
                k2 = k3;
                j2 = l;
                continue;
            }
            i1 = l;
            k2 = j;
            if (l >= i2)
            {
                pixelStack[j] = (byte)j2;
                i1 = k;
                k2 = j + 1;
            }
            while (i1 >= j5) 
            {
                pixelStack[k2] = suffix[i1];
                i1 = prefix[i1];
                k2++;
            }
            int l4 = suffix[i1] & 0xff;
            gifframe = pixelStack;
            i4 = k2 + 1;
            gifframe[k2] = (byte)l4;
            i1 = i2;
            k2 = k1;
            j2 = l1;
            if (i2 < 4096)
            {
                prefix[i2] = (short)k;
                suffix[i2] = (byte)l4;
                j = i2 + 1;
                i1 = j;
                k2 = k1;
                j2 = l1;
                if ((j & k1) == 0)
                {
                    i1 = j;
                    k2 = k1;
                    j2 = l1;
                    if (j < 4096)
                    {
                        j2 = l1 + 1;
                        k2 = k1 + j;
                        i1 = j;
                    }
                }
            }
            j = j1;
            for (k = i4; k > 0;)
            {
                k--;
                mainPixels[j] = pixelStack[k];
                i3++;
                j++;
            }

            i4 = k;
            i2 = i1;
            i1 = l3;
            k1 = k2;
            l1 = j2;
            k2 = k3;
            j2 = l4;
            k = l;
            j1 = j;
            j = i4;
        } while (true);
        i4 = i2;
        i2 = k4;
        l = i1;
        i1 = j4;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private Bitmap getNextBitmap()
    {
        Bitmap bitmap1 = bitmapProvider.obtain(header.width, header.height, BITMAP_CONFIG);
        Bitmap bitmap = bitmap1;
        if (bitmap1 == null)
        {
            bitmap = Bitmap.createBitmap(header.width, header.height, BITMAP_CONFIG);
        }
        setAlpha(bitmap);
        return bitmap;
    }

    private int read()
    {
        byte byte0;
        try
        {
            byte0 = rawData.get();
        }
        catch (Exception exception)
        {
            status = 1;
            return 0;
        }
        return byte0 & 0xff;
    }

    private int readBlock()
    {
        int i;
        int j;
        int k;
        k = read();
        j = 0;
        i = 0;
        if (k <= 0) goto _L2; else goto _L1
_L1:
        j = i;
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        j = k - i;
        rawData.get(block, i, j);
        i += j;
        if (true) goto _L1; else goto _L2
        Exception exception;
        exception;
        Log.w(TAG, "Error Reading Block", exception);
        status = 1;
        j = i;
_L2:
        return j;
    }

    private static void setAlpha(Bitmap bitmap)
    {
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            bitmap.setHasAlpha(true);
        }
    }

    private Bitmap setPixels(GifFrame gifframe, GifFrame gifframe1)
    {
        int ai[];
        int l2;
        int i3;
        l2 = header.width;
        i3 = header.height;
        ai = mainScratch;
        if (gifframe1 == null || gifframe1.dispose <= 0) goto _L2; else goto _L1
_L1:
        if (gifframe1.dispose != 2) goto _L4; else goto _L3
_L3:
        int i = 0;
        if (!gifframe.transparency)
        {
            i = header.bgColor;
        }
        Arrays.fill(ai, i);
_L2:
        int l;
        int i1;
        int j1;
        int k1;
        decodeBitmapData(gifframe);
        j1 = 1;
        i1 = 8;
        k1 = 0;
        l = 0;
_L16:
        if (l >= gifframe.ih) goto _L6; else goto _L5
_L5:
        int j;
        int k;
        int l1;
        int i2;
        i2 = l;
        j = k1;
        k = i1;
        l1 = j1;
        if (!gifframe.interlace) goto _L8; else goto _L7
_L7:
        j = k1;
        k = i1;
        l1 = j1;
        if (k1 < gifframe.ih) goto _L10; else goto _L9
_L9:
        l1 = j1 + 1;
        l1;
        JVM INSTR tableswitch 2 4: default 172
    //                   2 372
    //                   3 382
    //                   4 391;
           goto _L11 _L12 _L13 _L14
_L11:
        k = i1;
        j = k1;
_L10:
        i2 = j;
        j += k;
_L8:
        i1 = i2 + gifframe.iy;
        if (i1 < header.height)
        {
            int j2 = i1 * header.width;
            k1 = j2 + gifframe.ix;
            j1 = k1 + gifframe.iw;
            i1 = j1;
            if (header.width + j2 < j1)
            {
                i1 = j2 + header.width;
            }
            for (j1 = l * gifframe.iw; k1 < i1; j1++)
            {
                int k2 = mainPixels[j1];
                k2 = act[k2 & 0xff];
                if (k2 != 0)
                {
                    ai[k1] = k2;
                }
                k1++;
            }

        }
        break; /* Loop/switch isn't completed */
_L4:
        if (gifframe1.dispose == 3 && previousImage != null)
        {
            previousImage.getPixels(ai, 0, l2, 0, 0, l2, i3);
        }
        continue; /* Loop/switch isn't completed */
_L12:
        j = 4;
        k = i1;
        continue; /* Loop/switch isn't completed */
_L13:
        j = 2;
        k = 4;
        continue; /* Loop/switch isn't completed */
_L14:
        j = 1;
        k = 2;
        if (true) goto _L10; else goto _L15
_L15:
        l++;
        k1 = j;
        i1 = k;
        j1 = l1;
          goto _L16
_L6:
        if (savePrevious && (gifframe.dispose == 0 || gifframe.dispose == 1))
        {
            if (previousImage == null)
            {
                previousImage = getNextBitmap();
            }
            previousImage.setPixels(ai, 0, l2, 0, 0, l2, i3);
        }
        gifframe = getNextBitmap();
        gifframe.setPixels(ai, 0, l2, 0, 0, l2, i3);
        return gifframe;
        if (true) goto _L2; else goto _L17
_L17:
    }

    public void advance()
    {
        framePointer = (framePointer + 1) % header.frameCount;
    }

    public void clear()
    {
        header = null;
        data = null;
        mainPixels = null;
        mainScratch = null;
        if (previousImage != null)
        {
            bitmapProvider.release(previousImage);
        }
        previousImage = null;
    }

    public int getCurrentFrameIndex()
    {
        return framePointer;
    }

    public int getDelay(int i)
    {
        byte byte0 = -1;
        int j = byte0;
        if (i >= 0)
        {
            j = byte0;
            if (i < header.frameCount)
            {
                j = ((GifFrame)header.frames.get(i)).delay;
            }
        }
        return j;
    }

    public int getFrameCount()
    {
        return header.frameCount;
    }

    public int getLoopCount()
    {
        return header.loopCount;
    }

    public int getNextDelay()
    {
        if (header.frameCount <= 0 || framePointer < 0)
        {
            return -1;
        } else
        {
            return getDelay(framePointer);
        }
    }

    public Bitmap getNextFrame()
    {
        Bitmap bitmap = null;
        this;
        JVM INSTR monitorenter ;
        if (header.frameCount <= 0 || framePointer < 0)
        {
            if (Log.isLoggable(TAG, 3))
            {
                Log.d(TAG, (new StringBuilder()).append("unable to decode frame, frameCount=").append(header.frameCount).append(" framePointer=").append(framePointer).toString());
            }
            status = 1;
        }
        if (status != 1 && status != 2) goto _L2; else goto _L1
_L1:
        Object obj = bitmap;
        if (!Log.isLoggable(TAG, 3))
        {
            break MISSING_BLOCK_LABEL_140;
        }
        Log.d(TAG, (new StringBuilder()).append("Unable to decode frame, status=").append(status).toString());
        obj = bitmap;
_L5:
        this;
        JVM INSTR monitorexit ;
        return ((Bitmap) (obj));
_L2:
        GifFrame gifframe;
        status = 0;
        gifframe = (GifFrame)header.frames.get(framePointer);
        obj = null;
        int i = framePointer - 1;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        obj = (GifFrame)header.frames.get(i);
        if (gifframe.lct != null)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        act = header.gct;
_L3:
        i = 0;
        if (gifframe.transparency)
        {
            i = act[gifframe.transIndex];
            act[gifframe.transIndex] = 0;
        }
        if (act != null)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        if (Log.isLoggable(TAG, 3))
        {
            Log.d(TAG, "No Valid Color Table");
        }
        status = 1;
        obj = bitmap;
        continue; /* Loop/switch isn't completed */
        obj;
        throw obj;
        act = gifframe.lct;
        if (header.bgIndex == gifframe.transIndex)
        {
            header.bgColor = 0;
        }
          goto _L3
        bitmap = setPixels(gifframe, ((GifFrame) (obj)));
        obj = bitmap;
        if (!gifframe.transparency)
        {
            continue; /* Loop/switch isn't completed */
        }
        act[gifframe.transIndex] = i;
        obj = bitmap;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void setData(GifHeader gifheader, byte abyte0[])
    {
        header = gifheader;
        data = abyte0;
        status = 0;
        framePointer = -1;
        rawData = ByteBuffer.wrap(abyte0);
        rawData.rewind();
        rawData.order(ByteOrder.LITTLE_ENDIAN);
        savePrevious = false;
        abyte0 = gifheader.frames.iterator();
        do
        {
            if (!abyte0.hasNext())
            {
                break;
            }
            if (((GifFrame)abyte0.next()).dispose != 3)
            {
                continue;
            }
            savePrevious = true;
            break;
        } while (true);
        mainPixels = new byte[gifheader.width * gifheader.height];
        mainScratch = new int[gifheader.width * gifheader.height];
    }

    static 
    {
        BITMAP_CONFIG = android.graphics.Bitmap.Config.ARGB_8888;
    }
}
