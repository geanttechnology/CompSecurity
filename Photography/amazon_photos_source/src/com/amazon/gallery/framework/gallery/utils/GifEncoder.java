// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.amazon.gallery.framework.gallery.utils:
//            NeuQuant, LZWEncoder

public class GifEncoder
{

    protected boolean closeStream;
    protected int colorDepth;
    protected byte colorTab[];
    protected int delay;
    protected int dispose;
    protected boolean firstFrame;
    protected int height;
    protected Bitmap image;
    protected byte indexedPixels[];
    protected OutputStream out;
    protected int palSize;
    protected byte pixels[];
    protected int repeat;
    protected int sample;
    protected boolean sizeSet;
    protected boolean started;
    protected int transIndex;
    protected int transparent;
    protected boolean usedEntry[];
    protected int width;
    protected int x;
    protected int y;

    public GifEncoder()
    {
        x = 0;
        y = 0;
        transparent = -1;
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

    protected void analyzePixels()
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
        if (transparent != -1)
        {
            transIndex = findClosest(transparent);
        }
    }

    protected int findClosest(int i)
    {
        if (colorTab != null) goto _L2; else goto _L1
_L1:
        int l = -1;
_L4:
        return l;
_L2:
        int j = 0;
        int k = 0x1000000;
        int l1 = colorTab.length;
        int i1 = 0;
        do
        {
            l = j;
            if (i1 >= l1)
            {
                continue;
            }
            byte abyte0[] = colorTab;
            int j1 = i1 + 1;
            l = (i >> 16 & 0xff) - (abyte0[i1] & 0xff);
            abyte0 = colorTab;
            int i2 = j1 + 1;
            i1 = (i >> 8 & 0xff) - (abyte0[j1] & 0xff);
            j1 = (i >> 0 & 0xff) - (colorTab[i2] & 0xff);
            int k1 = l * l + i1 * i1 + j1 * j1;
            j1 = i2 / 3;
            i1 = k;
            l = j;
            if (usedEntry[j1])
            {
                i1 = k;
                l = j;
                if (k1 < k)
                {
                    i1 = k1;
                    l = j1;
                }
            }
            j = i2 + 1;
            k = i1;
            i1 = j;
            j = l;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
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

    protected int[] getImageData(Bitmap bitmap)
    {
        int i = bitmap.getWidth();
        int j = bitmap.getHeight();
        int ai[] = new int[i * j];
        bitmap.getPixels(ai, 0, i, 0, 0, i, j);
        return ai;
    }

    protected void getImagePixels()
    {
        int i = image.getWidth();
        int k = image.getHeight();
        if (i != width || k != height)
        {
            Bitmap bitmap = Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.RGB_565);
            (new Canvas(bitmap)).drawBitmap(image, 0.0F, 0.0F, new Paint());
            image = bitmap;
        }
        int ai[] = getImageData(image);
        pixels = new byte[ai.length * 3];
        for (int j = 0; j < ai.length; j++)
        {
            int l = ai[j];
            int i1 = j * 3;
            byte abyte0[] = pixels;
            int j1 = i1 + 1;
            abyte0[i1] = (byte)(l >> 0 & 0xff);
            pixels[j1] = (byte)(l >> 8 & 0xff);
            pixels[j1 + 1] = (byte)(l >> 16 & 0xff);
        }

    }

    public void setDelay(int i)
    {
        delay = i / 10;
    }

    public void setQuality(int i)
    {
        int j = i;
        if (i < 1)
        {
            j = 1;
        }
        sample = j;
    }

    public void setRepeat(int i)
    {
        if (i >= 0)
        {
            repeat = i;
        }
    }

    public void setSize(int i, int j)
    {
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

    protected void writeGraphicCtrlExt()
        throws IOException
    {
        out.write(33);
        out.write(249);
        out.write(4);
        int i;
        boolean flag;
        if (transparent == -1)
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

    protected void writeImageDesc()
        throws IOException
    {
        out.write(44);
        writeShort(x);
        writeShort(y);
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

    protected void writeLSD()
        throws IOException
    {
        writeShort(width);
        writeShort(height);
        out.write(palSize | 0xf0);
        out.write(0);
        out.write(0);
    }

    protected void writeNetscapeExt()
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

    protected void writePalette()
        throws IOException
    {
        out.write(colorTab, 0, colorTab.length);
        int j = colorTab.length;
        for (int i = 0; i < 768 - j; i++)
        {
            out.write(0);
        }

    }

    protected void writePixels()
        throws IOException
    {
        (new LZWEncoder(width, height, indexedPixels, colorDepth)).encode(out);
    }

    protected void writeShort(int i)
        throws IOException
    {
        out.write(i & 0xff);
        out.write(i >> 8 & 0xff);
    }

    protected void writeString(String s)
        throws IOException
    {
        for (int i = 0; i < s.length(); i++)
        {
            out.write((byte)s.charAt(i));
        }

    }
}
