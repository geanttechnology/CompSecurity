// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ant.liao;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.ant.liao:
//            GifAction, GifFrame

public class GifDecoder extends Thread
{

    private static final int MAX_QUEUE = 15;
    private static final int MaxStackSize = 4096;
    public static final int STATUS_FINISH = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARSING = 0;
    private int act[];
    private GifAction action;
    private InputStream backUpIn;
    private int bgColor;
    private int bgIndex;
    private byte block[];
    private int blockSize;
    private int delay;
    private int dest[];
    private int dispose;
    private int fileType;
    private ArrayList frameCache;
    private int frameCount;
    private Queue frameQueue;
    private int gct[];
    private boolean gctFlag;
    private int gctSize;
    private byte gifData[];
    public int height;
    private int iCurrentFrame;
    private int icacheParse;
    private int ih;
    private Bitmap image;
    private InputStream in;
    private boolean interlace;
    public boolean isDestroy;
    private boolean isLoop;
    private int iw;
    private int ix;
    private int iy;
    private int lastBgColor;
    private int lastDispose;
    private Bitmap lastImage;
    private int lct[];
    private boolean lctFlag;
    private int lctSize;
    private final ReentrantLock lock;
    private boolean loopCache;
    private int loopCount;
    private boolean loopParse;
    private int lrh;
    private int lrw;
    private int lrx;
    private int lry;
    private int pixelAspect;
    private byte pixelStack[];
    private byte pixels[];
    private short prefix[];
    private final Condition rCondition;
    private Resources res;
    private int resId;
    private int status;
    private String strFileName;
    private byte suffix[];
    private int tab[];
    private int transIndex;
    private boolean transparency;
    private final Condition wCondition;
    public int width;

    public GifDecoder(GifAction gifaction)
    {
        isDestroy = false;
        loopCount = 1;
        block = new byte[256];
        blockSize = 0;
        dispose = 0;
        lastDispose = 0;
        transparency = false;
        delay = 0;
        frameQueue = new ArrayBlockingQueue(15);
        lock = new ReentrantLock();
        rCondition = lock.newCondition();
        wCondition = lock.newCondition();
        icacheParse = 0;
        loopParse = false;
        frameCache = new ArrayList(frameCount);
        iCurrentFrame = 0;
        loopCache = false;
        action = null;
        gifData = null;
        isLoop = false;
        fileType = 0;
        res = null;
        resId = 0;
        strFileName = null;
        dest = null;
        tab = new int[256];
        action = gifaction;
    }

    public GifDecoder(GifAction gifaction, boolean flag)
    {
        isDestroy = false;
        loopCount = 1;
        block = new byte[256];
        blockSize = 0;
        dispose = 0;
        lastDispose = 0;
        transparency = false;
        delay = 0;
        frameQueue = new ArrayBlockingQueue(15);
        lock = new ReentrantLock();
        rCondition = lock.newCondition();
        wCondition = lock.newCondition();
        icacheParse = 0;
        loopParse = false;
        frameCache = new ArrayList(frameCount);
        iCurrentFrame = 0;
        loopCache = false;
        action = null;
        gifData = null;
        isLoop = false;
        fileType = 0;
        res = null;
        resId = 0;
        strFileName = null;
        dest = null;
        tab = new int[256];
        action = gifaction;
        isLoop = flag;
    }

    private void checkLoop()
    {
        if (isLoop && !loopCache) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (frameCount > 15) goto _L4; else goto _L3
_L3:
        lock.lockInterruptibly();
        loopCache = true;
        status = -1;
        if (action != null)
        {
            action.parseReturn(2);
        }
        rCondition.signal();
        lock.unlock();
_L9:
        fileType;
        JVM INSTR tableswitch 1 3: default 104
    //                   1 160
    //                   2 167
    //                   3 174;
           goto _L5 _L6 _L7 _L8
_L5:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_174;
_L10:
        loopParse = true;
        if (!isDestroy)
        {
            readStream();
            return;
        }
          goto _L1
        Object obj;
        obj;
        lock.unlock();
          goto _L9
        obj;
        lock.unlock();
        throw obj;
_L4:
        if (frameCache != null)
        {
            frameCache.clear();
        }
          goto _L9
_L6:
        openResourceFile();
          goto _L10
_L7:
        openFile();
          goto _L10
        openInputstream();
          goto _L10
    }

    private void decodeImageData()
    {
        int i;
        int k;
        int l;
        int j1;
        int k2;
        int j4;
        int k4;
        int l4;
        j4 = iw * ih;
        if (pixels == null || pixels.length < j4)
        {
            pixels = new byte[j4];
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
        k4 = read();
        l4 = 1 << k4;
        k2 = l4 + 2;
        j1 = -1;
        l = k4 + 1;
        k = (1 << l) - 1;
        i = 0;
_L5:
        if (i < l4) goto _L2; else goto _L1
_L1:
        int j;
        int i1;
        int l1;
        int i2;
        int j2;
        int l2;
        int i3;
        j2 = 0;
        l2 = 0;
        i2 = 0;
        i1 = 0;
        boolean flag = false;
        i3 = 0;
        l1 = 0;
        j = 0;
        i = j1;
        j1 = ((flag) ? 1 : 0);
_L7:
        if (i3 < j4) goto _L4; else goto _L3
_L2:
        prefix[i] = 0;
        suffix[i] = (byte)i;
        i++;
          goto _L5
_L4:
        int k1;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_644;
        }
        if (i1 >= l)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        k1 = i2;
        if (i2 != 0)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        k1 = readBlock();
        if (k1 > 0) goto _L6; else goto _L3
_L6:
        j2 = 0;
        j1 += (block[j2] & 0xff) << i1;
        i1 += 8;
        j2++;
        i2 = k1 - 1;
          goto _L7
        k1 = j1 & k;
        i4 = j1 >> l;
        j3 = i1 - l;
        if (k1 <= k2 && k1 != l4 + 1) goto _L8; else goto _L3
_L8:
        if (k1 == l4)
        {
            l = k4 + 1;
            k = (1 << l) - 1;
            k2 = l4 + 2;
            i = -1;
            i1 = j3;
            j1 = i4;
        } else
        {
label0:
            {
                if (i != -1)
                {
                    break label0;
                }
                pixelStack[j] = suffix[k1];
                i = k1;
                j++;
                i1 = j3;
                j1 = i4;
                l2 = k1;
            }
        }
          goto _L7
        i1 = k1;
        j1 = j;
        if (k1 == k2)
        {
            pixelStack[j] = (byte)l2;
            i1 = i;
            j1 = j + 1;
        }
_L9:
label1:
        {
            if (i1 > l4)
            {
                break label1;
            }
            l2 = suffix[i1] & 0xff;
            if (k2 < 4096)
            {
                break MISSING_BLOCK_LABEL_486;
            }
        }
          goto _L3
        pixelStack[j1] = suffix[i1];
        i1 = prefix[i1];
        j1++;
          goto _L9
        byte abyte0[] = pixelStack;
        i1 = j1 + 1;
        abyte0[j1] = (byte)l2;
        prefix[k2] = (short)i;
        suffix[k2] = (byte)l2;
        k2++;
        i = k;
        j = l;
        if ((k2 & k) == 0)
        {
            i = k;
            j = l;
            if (k2 < 4096)
            {
                j = l + 1;
                i = k + k2;
            }
        }
        l = i1;
        j1 = i4;
        k = i;
        i1 = j3;
_L10:
        int k3 = l - 1;
        pixels[l1] = pixelStack[k3];
        i3++;
        l1++;
        l = j;
        i = k1;
        j = k3;
          goto _L7
_L3:
        do
        {
            int j3;
            int i4;
            if (l1 >= j4)
            {
                return;
            }
            pixels[l1] = 0;
            l1++;
        } while (true);
        int l3 = j;
        j = l;
        k1 = i;
        l = l3;
          goto _L10
    }

    private boolean err()
    {
        return status != 0;
    }

    private void free()
    {
        if (in != null)
        {
            try
            {
                in.close();
            }
            catch (Exception exception) { }
            in = null;
        }
        gifData = null;
        status = 0;
        if (frameCache != null)
        {
            frameCache.clear();
            frameCache = null;
        }
        if (frameQueue != null)
        {
            frameQueue.clear();
            frameQueue = null;
        }
    }

    private void init()
    {
        status = 0;
        if (!loopParse)
        {
            frameCount = 0;
        }
        gct = null;
        lct = null;
        icacheParse = 0;
    }

    private void openFile()
    {
        try
        {
            in = new FileInputStream(strFileName);
            return;
        }
        catch (Exception exception)
        {
            Log.e("open failed", exception.toString());
        }
    }

    private void openInputstream()
    {
        in = new ByteArrayInputStream(gifData);
    }

    private void openResourceFile()
    {
        in = res.openRawResource(resId);
    }

    private int read()
    {
        int i;
        try
        {
            i = in.read();
        }
        catch (Exception exception)
        {
            status = 1;
            return 0;
        }
        return i;
    }

    private int readBlock()
    {
        int i;
        int j;
        blockSize = read();
        j = 0;
        i = 0;
        if (blockSize <= 0) goto _L2; else goto _L1
_L1:
        j = blockSize;
        if (i < j) goto _L4; else goto _L3
_L3:
        j = i;
        if (i < blockSize)
        {
            status = 1;
            j = i;
        }
_L2:
        return j;
_L4:
        j = in.read(block, i, blockSize - i);
        if (j == -1) goto _L3; else goto _L5
_L5:
        i += j;
          goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L3
    }

    private int[] readColorTable(int i)
    {
        byte abyte0[];
        int j;
        int j1;
        j1 = i * 3;
        abyte0 = new byte[j1];
        j = 0;
        int l = in.read(abyte0);
        j = l;
_L1:
        Exception exception;
        if (j < j1)
        {
            status = 1;
        } else
        {
            int i1 = 0;
            int k = 0;
            while (k < i) 
            {
                int l1 = i1 + 1;
                i1 = abyte0[i1];
                int k1 = l1 + 1;
                l1 = abyte0[l1];
                byte byte0 = abyte0[k1];
                tab[k] = 0xff000000 | (i1 & 0xff) << 16 | (l1 & 0xff) << 8 | byte0 & 0xff;
                i1 = k1 + 1;
                k++;
            }
        }
        return tab;
        exception;
        exception.printStackTrace();
          goto _L1
    }

    private void readContents()
    {
        boolean flag = false;
label0:
        do
        {
            if (flag || err() || isDestroy)
            {
                return;
            }
            switch (read())
            {
            default:
                status = 1;
                continue;

            case 0: // '\0'
                break;

            case 44: // ','
                readImage();
                continue;

            case 33: // '!'
                String s;
                int i;
                switch (read())
                {
                default:
                    skip();
                    continue;

                case 249: 
                    readGraphicControlExt();
                    continue;

                case 255: 
                    readBlock();
                    s = "";
                    i = 0;
                    break;
                }
                do
                {
                    if (i >= 11)
                    {
                        if (s.equals("NETSCAPE2.0"))
                        {
                            readNetscapeExt();
                        } else
                        {
                            skip();
                        }
                        continue label0;
                    }
                    s = (new StringBuilder(String.valueOf(s))).append((char)block[i]).toString();
                    i++;
                } while (true);

            case 59: // ';'
                flag = true;
                break;
            }
        } while (true);
    }

    private void readGraphicControlExt()
    {
        boolean flag = true;
        read();
        int i = read();
        dispose = (i & 0x1c) >> 2;
        if (dispose == 0)
        {
            dispose = 1;
        }
        if ((i & 1) == 0)
        {
            flag = false;
        }
        transparency = flag;
        delay = readShort() * 10;
        if (delay == 0)
        {
            delay = 100;
        }
        transIndex = read();
        read();
    }

    private void readHeader()
    {
        String s;
        int i;
        s = "";
        i = 0;
_L8:
        if (i < 6) goto _L2; else goto _L1
_L1:
        if (s.startsWith("GIF")) goto _L4; else goto _L3
_L3:
        status = 1;
_L6:
        return;
_L2:
        s = (new StringBuilder(String.valueOf(s))).append((char)read()).toString();
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        readLSD();
        if (!gctFlag || err()) goto _L6; else goto _L5
_L5:
        gct = readColorTable(gctSize);
        bgColor = gct[bgIndex];
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void readImage()
    {
        int i;
        ix = readShort();
        iy = readShort();
        iw = readShort();
        ih = readShort();
        i = read();
        boolean flag;
        boolean flag1;
        if ((i & 0x80) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        lctFlag = flag1;
        if ((i & 0x40) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        interlace = flag1;
        lctSize = 2 << (i & 7);
        if (lctFlag)
        {
            lct = readColorTable(lctSize);
            act = lct;
        } else
        {
            act = gct;
            if (bgIndex == transIndex)
            {
                bgColor = 0;
            }
        }
_L14:
        flag = false;
        i = ((flag) ? 1 : 0);
        if (transparency)
        {
            i = ((flag) ? 1 : 0);
            if (act != null)
            {
                i = ((flag) ? 1 : 0);
                if (act.length > 0)
                {
                    i = ((flag) ? 1 : 0);
                    if (act.length > transIndex)
                    {
                        i = act[transIndex];
                        act[transIndex] = 0;
                    }
                }
            }
        }
        if (act == null)
        {
            status = 1;
        }
        if (!err()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        decodeImageData();
        skip();
        if (err()) goto _L1; else goto _L3
_L3:
        if (!loopParse)
        {
            frameCount = frameCount + 1;
        }
        setPixels();
        lock.lockInterruptibly();
_L11:
        if (frameQueue != null && frameQueue.size() >= 15) goto _L5; else goto _L4
_L4:
        if (frameQueue == null) goto _L7; else goto _L6
_L6:
        GifFrame gifframe = new GifFrame(image, delay);
        frameQueue.add(gifframe);
        if (!loopParse)
        {
            frameCache.add(gifframe);
        }
        rCondition.signal();
        if (loopParse || icacheParse < 0) goto _L7; else goto _L8
_L8:
        icacheParse = icacheParse + 1;
        if (icacheParse < 15) goto _L10; else goto _L9
_L9:
        action.parseReturn(3);
        icacheParse = -1;
_L7:
        Object obj;
        try
        {
            lock.unlock();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
_L12:
        if (transparency)
        {
            act[transIndex] = i;
        }
        resetFrame();
        return;
_L5:
        wCondition.await();
          goto _L11
        obj;
        wCondition.signal();
        lock.unlock();
          goto _L12
_L10:
        if (icacheParse != 1) goto _L7; else goto _L13
_L13:
        action.parseReturn(1);
          goto _L7
        obj;
        lock.unlock();
        throw obj;
          goto _L14
    }

    private void readLSD()
    {
        width = readShort();
        height = readShort();
        int i = read();
        boolean flag;
        if ((i & 0x80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        gctFlag = flag;
        gctSize = 2 << (i & 7);
        bgIndex = read();
        pixelAspect = read();
    }

    private void readNetscapeExt()
    {
        do
        {
            readBlock();
            if (block[0] == 1)
            {
                byte byte0 = block[1];
                loopCount = (block[2] & 0xff) << 8 | byte0 & 0xff;
            }
        } while (blockSize > 0 && !err());
    }

    private int readShort()
    {
        return read() | read() << 8;
    }

    private int readStream()
    {
        init();
        if (in == null) goto _L2; else goto _L1
_L1:
        readHeader();
        if (!err())
        {
            readContents();
            if (!loopParse && frameCount < 0)
            {
                status = 1;
                if (action != null)
                {
                    action.parseReturn(4);
                }
            }
        }
        try
        {
            if (in != null)
            {
                in.close();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        in = null;
        checkLoop();
_L4:
        return status;
_L2:
        status = 2;
        if (action != null)
        {
            action.parseReturn(4);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void resetFrame()
    {
        lastDispose = dispose;
        lrx = ix;
        lry = iy;
        lrw = iw;
        lrh = ih;
        lastImage = image;
        lastBgColor = bgColor;
        dispose = 0;
        transparency = false;
        delay = 0;
        lct = null;
    }

    private void setPixels()
    {
        if (dest == null)
        {
            dest = new int[width * height];
        }
        if (lastDispose <= 0) goto _L2; else goto _L1
_L1:
        if (lastDispose == 3)
        {
            if (frameCount - 2 <= 0)
            {
                lastImage = null;
            }
            lastImage = null;
        }
        if (lastImage == null) goto _L2; else goto _L3
_L3:
        lastImage.getPixels(dest, 0, width, 0, 0, width, height);
        int i;
        if (lastDispose != 2) goto _L2; else goto _L4
_L21:
        int j;
        if (j < lrh) goto _L5; else goto _L2
_L22:
        int k;
        if (k >= ih)
        {
            image = Bitmap.createBitmap(dest, width, height, android.graphics.Bitmap.Config.ARGB_8888);
            return;
        }
          goto _L6
_L5:
        int l;
        int i1;
        l = (lry + j) * width + lrx;
        i1 = lrw;
        k = l;
          goto _L7
_L24:
        dest[k] = i;
        k++;
        continue; /* Loop/switch isn't completed */
_L6:
        int j1;
        int k1;
        int l1;
        l1 = k;
        i = l;
        j = i1;
        k1 = j1;
        if (!interlace) goto _L9; else goto _L8
_L8:
        i = l;
        j = i1;
        k1 = j1;
        if (l < ih) goto _L11; else goto _L10
_L10:
        k1 = j1 + 1;
        k1;
        JVM INSTR tableswitch 2 4: default 476
    //                   2 518
    //                   3 526
    //                   4 533;
           goto _L12 _L13 _L14 _L15
_L9:
        l = l1 + iy;
        if (l >= height) goto _L17; else goto _L16
_L16:
        l1 = l * width;
        i1 = l1 + ix;
        j1 = i1 + iw;
        l = j1;
        if (width + l1 < j1)
        {
            l = l1 + width;
        }
        j1 = k * iw;
          goto _L18
_L25:
        l1 = pixels[j1];
        l1 = act[l1 & 0xff];
        if (l1 == 0) goto _L20; else goto _L19
_L19:
        dest[i1] = l1;
_L20:
        i1++;
        j1++;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 0;
        try
        {
            if (!transparency)
            {
                i = lastBgColor;
            }
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            outofmemoryerror.printStackTrace();
            return;
        }
        catch (StackOverflowError stackoverflowerror)
        {
            stackoverflowerror.printStackTrace();
            return;
        }
        catch (Exception exception)
        {
            Log.e("GifView decode setpixel", exception.toString());
            return;
        }
        j = 0;
          goto _L21
_L2:
        j1 = 1;
        i1 = 8;
        l = 0;
        k = 0;
          goto _L22
_L7:
        if (k < l + i1) goto _L24; else goto _L23
_L23:
        j++;
          goto _L21
_L12:
        j = i1;
        i = l;
_L11:
        l1 = i;
        i += j;
          goto _L9
_L18:
        if (i1 < l) goto _L25; else goto _L17
_L17:
        k++;
        l = i;
        i1 = j;
        j1 = k1;
          goto _L22
_L13:
        i = 4;
        j = i1;
          goto _L11
_L14:
        i = 2;
        j = 4;
          goto _L11
_L15:
        i = 1;
        j = 2;
          goto _L11
    }

    private void skip()
    {
        do
        {
            readBlock();
        } while (blockSize > 0 && !err());
    }

    public void destroy()
    {
        isDestroy = true;
        free();
        action = null;
    }

    public GifFrame getCurrentFrame()
    {
        if (!loopCache || frameQueue.size() != 0) goto _L2; else goto _L1
_L1:
        GifFrame gifframe;
        if (iCurrentFrame >= frameCount)
        {
            iCurrentFrame = 0;
            action.loopEnd();
        }
        gifframe = (GifFrame)frameCache.get(iCurrentFrame);
        iCurrentFrame = iCurrentFrame + 1;
_L4:
        return gifframe;
_L2:
        try
        {
            lock.lockInterruptibly();
        }
        catch (Exception exception1)
        {
            lock.unlock();
            return null;
        }
        if (!loopCache && frameQueue.size() == 0)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        gifframe = (GifFrame)frameQueue.poll();
        wCondition.signal();
        iCurrentFrame = iCurrentFrame + 1;
        if (loopParse && iCurrentFrame >= frameCount)
        {
            action.loopEnd();
            iCurrentFrame = 0;
        }
        lock.unlock();
        continue; /* Loop/switch isn't completed */
        try
        {
            rCondition.await();
            break MISSING_BLOCK_LABEL_78;
        }
        catch (Exception exception) { }
        finally
        {
            lock.unlock();
            throw exception2;
        }
        rCondition.signal();
        lock.unlock();
        return null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int getFrameCount()
    {
        if (!loopParse && status != -1)
        {
            return -1;
        } else
        {
            return frameCount;
        }
    }

    public Bitmap getFrameImage()
    {
        GifFrame gifframe = getCurrentFrame();
        if (gifframe == null)
        {
            return null;
        } else
        {
            return gifframe.image;
        }
    }

    public Bitmap getImage()
    {
        return getFrameImage();
    }

    public InputStream getInputStream()
    {
        return backUpIn;
    }

    public int getLoopCount()
    {
        return loopCount;
    }

    public int getStatus()
    {
        return status;
    }

    public GifFrame next()
    {
        return getCurrentFrame();
    }

    public void run()
    {
        try
        {
            readStream();
            return;
        }
        catch (Exception exception)
        {
            Log.e("GifView decode run", exception.toString());
            exception.printStackTrace();
            return;
        }
    }

    public void setGifImage(Resources resources, int i)
    {
        res = resources;
        resId = i;
        openResourceFile();
        fileType = 1;
    }

    public void setGifImage(String s)
    {
        strFileName = s;
        fileType = 2;
        openFile();
    }

    public void setGifImage(byte abyte0[])
    {
        gifData = abyte0;
        openInputstream();
        fileType = 3;
    }

    public void setLoopAnimation()
    {
        isLoop = true;
    }
}
