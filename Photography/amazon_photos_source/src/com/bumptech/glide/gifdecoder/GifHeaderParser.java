// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.bumptech.glide.gifdecoder:
//            GifHeader, GifFrame

public class GifHeaderParser
{

    private final byte block[] = new byte[256];
    private int blockSize;
    private GifHeader header;
    private ByteBuffer rawData;

    public GifHeaderParser()
    {
        blockSize = 0;
    }

    private boolean err()
    {
        return header.status != 0;
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
            header.status = 1;
            return 0;
        }
        return byte0 & 0xff;
    }

    private void readBitmap()
    {
        boolean flag1 = true;
        header.currentFrame.ix = readShort();
        header.currentFrame.iy = readShort();
        header.currentFrame.iw = readShort();
        header.currentFrame.ih = readShort();
        int i = read();
        GifFrame gifframe;
        boolean flag;
        int j;
        if ((i & 0x80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = (int)Math.pow(2D, (i & 7) + 1);
        gifframe = header.currentFrame;
        if ((i & 0x40) == 0)
        {
            flag1 = false;
        }
        gifframe.interlace = flag1;
        if (flag)
        {
            header.currentFrame.lct = readColorTable(j);
        } else
        {
            header.currentFrame.lct = null;
        }
        header.currentFrame.bufferFrameStart = rawData.position();
        skipImageData();
        if (err())
        {
            return;
        } else
        {
            GifHeader gifheader = header;
            gifheader.frameCount = gifheader.frameCount + 1;
            header.frames.add(header.currentFrame);
            return;
        }
    }

    private int readBlock()
    {
        int i;
        int l;
        blockSize = read();
        l = 0;
        i = 0;
        if (blockSize <= 0) goto _L2; else goto _L1
_L1:
        int j = 0;
_L3:
        int k;
        k = j;
        l = i;
        if (i >= blockSize)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j;
        j = blockSize - i;
        k = j;
        rawData.get(block, i, j);
        i += j;
        if (true) goto _L3; else goto _L2
        Exception exception;
        exception;
        if (Log.isLoggable("GifHeaderParser", 3))
        {
            Log.d("GifHeaderParser", (new StringBuilder()).append("Error Reading Block n: ").append(i).append(" count: ").append(k).append(" blockSize: ").append(blockSize).toString(), exception);
        }
        header.status = 1;
        l = i;
_L2:
        return l;
    }

    private int[] readColorTable(int i)
    {
        int ai[];
        byte abyte0[];
        ai = null;
        abyte0 = new byte[i * 3];
        int ai1[];
        rawData.get(abyte0);
        ai1 = new int[256];
        int k = 0;
        int j = 0;
        do
        {
            ai = ai1;
            if (j >= i)
            {
                break;
            }
            int l = k + 1;
            k = abyte0[k];
            int i1 = l + 1;
            ai1[j] = 0xff000000 | (k & 0xff) << 16 | (abyte0[l] & 0xff) << 8 | abyte0[i1] & 0xff;
            k = i1 + 1;
            j++;
        } while (true);
        break MISSING_BLOCK_LABEL_139;
        BufferUnderflowException bufferunderflowexception;
        bufferunderflowexception;
        if (Log.isLoggable("GifHeaderParser", 3))
        {
            Log.d("GifHeaderParser", "Format Error Reading Color Table", bufferunderflowexception);
        }
        header.status = 1;
        return ai;
    }

    private void readContents()
    {
        boolean flag = false;
        do
        {
            if (flag || err())
            {
                break;
            }
            switch (read())
            {
            default:
                header.status = 1;
                continue;

            case 44: // ','
                if (header.currentFrame == null)
                {
                    header.currentFrame = new GifFrame();
                }
                readBitmap();
                continue;

            case 33: // '!'
                switch (read())
                {
                default:
                    skip();
                    break;

                case 249: 
                    header.currentFrame = new GifFrame();
                    readGraphicControlExt();
                    break;

                case 255: 
                    readBlock();
                    String s = "";
                    for (int i = 0; i < 11; i++)
                    {
                        s = (new StringBuilder()).append(s).append((char)block[i]).toString();
                    }

                    if (s.equals("NETSCAPE2.0"))
                    {
                        readNetscapeExt();
                    } else
                    {
                        skip();
                    }
                    break;

                case 254: 
                    skip();
                    break;

                case 1: // '\001'
                    skip();
                    break;
                }
                break;

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
        header.currentFrame.dispose = (i & 0x1c) >> 2;
        if (header.currentFrame.dispose == 0)
        {
            header.currentFrame.dispose = 1;
        }
        GifFrame gifframe = header.currentFrame;
        int j;
        if ((i & 1) == 0)
        {
            flag = false;
        }
        gifframe.transparency = flag;
        j = readShort();
        i = j;
        if (j < 3)
        {
            i = 10;
        }
        header.currentFrame.delay = i * 10;
        header.currentFrame.transIndex = read();
        read();
    }

    private void readHeader()
    {
        String s = "";
        for (int i = 0; i < 6; i++)
        {
            s = (new StringBuilder()).append(s).append((char)read()).toString();
        }

        if (!s.startsWith("GIF"))
        {
            header.status = 1;
        } else
        {
            readLSD();
            if (header.gctFlag && !err())
            {
                header.gct = readColorTable(header.gctSize);
                header.bgColor = header.gct[header.bgIndex];
                return;
            }
        }
    }

    private void readLSD()
    {
        header.width = readShort();
        header.height = readShort();
        int i = read();
        GifHeader gifheader = header;
        boolean flag;
        if ((i & 0x80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        gifheader.gctFlag = flag;
        header.gctSize = 2 << (i & 7);
        header.bgIndex = read();
        header.pixelAspect = read();
    }

    private void readNetscapeExt()
    {
        do
        {
            readBlock();
            if (block[0] == 1)
            {
                byte byte0 = block[1];
                byte byte1 = block[2];
                header.loopCount = (byte1 & 0xff) << 8 | byte0 & 0xff;
            }
        } while (blockSize > 0 && !err());
    }

    private int readShort()
    {
        return rawData.getShort();
    }

    private void reset()
    {
        rawData = null;
        Arrays.fill(block, (byte)0);
        header = new GifHeader();
        blockSize = 0;
    }

    private void skip()
    {
        int i;
        do
        {
            i = read();
            rawData.position(rawData.position() + i);
        } while (i > 0);
    }

    private void skipImageData()
    {
        read();
        skip();
    }

    public void clear()
    {
        rawData = null;
        header = null;
    }

    public GifHeader parseHeader()
    {
        if (rawData == null)
        {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (err())
        {
            return header;
        }
        readHeader();
        if (!err())
        {
            readContents();
            if (header.frameCount < 0)
            {
                header.status = 1;
            }
        }
        return header;
    }

    public GifHeaderParser setData(byte abyte0[])
    {
        reset();
        if (abyte0 != null)
        {
            rawData = ByteBuffer.wrap(abyte0);
            rawData.rewind();
            rawData.order(ByteOrder.LITTLE_ENDIAN);
            return this;
        } else
        {
            rawData = null;
            header.status = 2;
            return this;
        }
    }
}
