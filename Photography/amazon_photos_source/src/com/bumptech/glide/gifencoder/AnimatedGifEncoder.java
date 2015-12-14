// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.gifencoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.bumptech.glide.gifencoder:
//            NeuQuant, LZWEncoder

public class AnimatedGifEncoder
{

    private boolean closeStream;
    private int colorDepth;
    private byte colorTab[];
    private int delay;
    private int dispose;
    private boolean firstFrame;
    private boolean hasTransparentPixels;
    private int height;
    private Bitmap image;
    private byte indexedPixels[];
    private OutputStream out;
    private int palSize;
    private byte pixels[];
    private int repeat;
    private int sample;
    private boolean sizeSet;
    private boolean started;
    private int transIndex;
    private Integer transparent;
    private boolean usedEntry[];
    private int width;

    public AnimatedGifEncoder()
    {
        transparent = null;
        repeat = -1;
        delay = 0;
        started = false;
        usedEntry = new boolean[256];
        palSize = 7;
        dispose = -1;
        closeStream = false;
        firstFrame = true;
        sizeSet = false;
        sample = 10;
    }

    private void analyzePixels()
    {
        int i = pixels.length;
        int k = i / 3;
        indexedPixels = new byte[k];
        NeuQuant neuquant = new NeuQuant(pixels, i, sample);
        colorTab = neuquant.process();
        for (i = 0; i < colorTab.length; i += 3)
        {
            byte byte0 = colorTab[i];
            colorTab[i] = colorTab[i + 2];
            colorTab[i + 2] = byte0;
            usedEntry[i / 3] = false;
        }

        i = 0;
        for (int j = 0; i < k; j++)
        {
            byte abyte0[] = pixels;
            int l = j + 1;
            byte byte1 = abyte0[j];
            abyte0 = pixels;
            j = l + 1;
            l = neuquant.map(byte1 & 0xff, abyte0[l] & 0xff, pixels[j] & 0xff);
            usedEntry[l] = true;
            indexedPixels[i] = (byte)l;
            i++;
        }

        pixels = null;
        colorDepth = 8;
        palSize = 7;
        if (transparent != null)
        {
            transIndex = findClosest(transparent.intValue());
        } else
        if (hasTransparentPixels)
        {
            transIndex = findClosest(0);
            return;
        }
    }

    private int findClosest(int i)
    {
        if (colorTab != null) goto _L2; else goto _L1
_L1:
        int k = -1;
_L4:
        return k;
_L2:
        int k1 = Color.red(i);
        int l1 = Color.green(i);
        int i2 = Color.blue(i);
        i = 0;
        int j = 0x1000000;
        int j2 = colorTab.length;
        int l = 0;
        do
        {
            k = i;
            if (l >= j2)
            {
                continue;
            }
            byte abyte0[] = colorTab;
            int i1 = l + 1;
            k = k1 - (abyte0[l] & 0xff);
            abyte0 = colorTab;
            int k2 = i1 + 1;
            l = l1 - (abyte0[i1] & 0xff);
            i1 = i2 - (colorTab[k2] & 0xff);
            int j1 = k * k + l * l + i1 * i1;
            i1 = k2 / 3;
            l = j;
            k = i;
            if (usedEntry[i1])
            {
                l = j;
                k = i;
                if (j1 < j)
                {
                    l = j1;
                    k = i1;
                }
            }
            i = k2 + 1;
            j = l;
            l = i;
            i = k;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void getImagePixels()
    {
        int i = image.getWidth();
        int j = image.getHeight();
        if (i != width || j != height)
        {
            Bitmap bitmap = Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888);
            (new Canvas(bitmap)).drawBitmap(bitmap, 0.0F, 0.0F, null);
            image = bitmap;
        }
        int ai[] = new int[i * j];
        image.getPixels(ai, 0, i, 0, 0, i, j);
        pixels = new byte[ai.length * 3];
        hasTransparentPixels = false;
        int i1 = 0;
        int j1 = ai.length;
        i = 0;
        int l = 0;
        while (i < j1) 
        {
            int k1 = ai[i];
            int k = i1;
            if (k1 == 0)
            {
                k = i1 + 1;
            }
            byte abyte0[] = pixels;
            i1 = l + 1;
            abyte0[l] = (byte)(k1 & 0xff);
            abyte0 = pixels;
            l = i1 + 1;
            abyte0[i1] = (byte)(k1 >> 8 & 0xff);
            pixels[l] = (byte)(k1 >> 16 & 0xff);
            i++;
            l++;
            i1 = k;
        }
        double d = (double)(i1 * 100) / (double)ai.length;
        boolean flag;
        if (d > 4D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasTransparentPixels = flag;
        if (Log.isLoggable("AnimatedGifEncoder", 3))
        {
            Log.d("AnimatedGifEncoder", (new StringBuilder()).append("got pixels for frame with ").append(d).append("% transparent pixels").toString());
        }
    }

    private void writeGraphicCtrlExt()
        throws IOException
    {
        out.write(33);
        out.write(249);
        out.write(4);
        int i;
        boolean flag;
        if (transparent == null && !hasTransparentPixels)
        {
            flag = false;
            i = 0;
        } else
        {
            flag = true;
            i = 2;
        }
        if (dispose >= 0)
        {
            i = dispose & 7;
        }
        out.write(i << 2 | 0 | 0 | flag);
        writeShort(delay);
        out.write(transIndex);
        out.write(0);
    }

    private void writeImageDesc()
        throws IOException
    {
        out.write(44);
        writeShort(0);
        writeShort(0);
        writeShort(width);
        writeShort(height);
        if (firstFrame)
        {
            out.write(0);
            return;
        } else
        {
            out.write(palSize | 0x80);
            return;
        }
    }

    private void writeLSD()
        throws IOException
    {
        writeShort(width);
        writeShort(height);
        out.write(palSize | 0xf0);
        out.write(0);
        out.write(0);
    }

    private void writeNetscapeExt()
        throws IOException
    {
        out.write(33);
        out.write(255);
        out.write(11);
        writeString("NETSCAPE2.0");
        out.write(3);
        out.write(1);
        writeShort(repeat);
        out.write(0);
    }

    private void writePalette()
        throws IOException
    {
        out.write(colorTab, 0, colorTab.length);
        int j = colorTab.length;
        for (int i = 0; i < 768 - j; i++)
        {
            out.write(0);
        }

    }

    private void writePixels()
        throws IOException
    {
        (new LZWEncoder(width, height, indexedPixels, colorDepth)).encode(out);
    }

    private void writeShort(int i)
        throws IOException
    {
        out.write(i & 0xff);
        out.write(i >> 8 & 0xff);
    }

    private void writeString(String s)
        throws IOException
    {
        for (int i = 0; i < s.length(); i++)
        {
            out.write((byte)s.charAt(i));
        }

    }

    public boolean addFrame(Bitmap bitmap)
    {
        if (bitmap == null || !started)
        {
            return false;
        }
        try
        {
            if (!sizeSet)
            {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            image = bitmap;
            getImagePixels();
            analyzePixels();
            if (firstFrame)
            {
                writeLSD();
                writePalette();
                if (repeat >= 0)
                {
                    writeNetscapeExt();
                }
            }
            writeGraphicCtrlExt();
            writeImageDesc();
            if (!firstFrame)
            {
                writePalette();
            }
            writePixels();
            firstFrame = false;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return false;
        }
        return true;
    }

    public boolean finish()
    {
        boolean flag1;
        if (!started)
        {
            return false;
        }
        flag1 = true;
        started = false;
        out.write(59);
        out.flush();
        boolean flag = flag1;
        if (!closeStream)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        out.close();
        flag = flag1;
_L2:
        transIndex = 0;
        out = null;
        image = null;
        pixels = null;
        indexedPixels = null;
        colorTab = null;
        closeStream = false;
        firstFrame = true;
        return flag;
        IOException ioexception;
        ioexception;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setDelay(int i)
    {
        delay = Math.round((float)i / 10F);
    }

    public void setSize(int i, int j)
    {
        if (started && !firstFrame)
        {
            return;
        }
        width = i;
        height = j;
        if (width < 1)
        {
            width = 320;
        }
        if (height < 1)
        {
            height = 240;
        }
        sizeSet = true;
    }

    public boolean start(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            return false;
        }
        boolean flag = true;
        closeStream = false;
        out = outputstream;
        try
        {
            writeString("GIF89a");
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            flag = false;
        }
        started = flag;
        return flag;
    }
}
