// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codebutler.android_websockets;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.codebutler.android_websockets:
//            WebSocketClient

public class HybiParser
{
    public static class HappyDataInputStream extends DataInputStream
    {

        public byte[] readBytes(int i)
            throws IOException
        {
            byte abyte0[] = new byte[i];
            readFully(abyte0);
            return abyte0;
        }

        public HappyDataInputStream(InputStream inputstream)
        {
            super(inputstream);
        }
    }

    public static class ProtocolError extends IOException
    {

        public ProtocolError(String s)
        {
            super(s);
        }
    }


    private static final int BYTE = 255;
    private static final int FIN = 128;
    private static final List FRAGMENTED_OPCODES = Arrays.asList(new Integer[] {
        Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2)
    });
    private static final int LENGTH = 127;
    private static final int MASK = 128;
    private static final int MODE_BINARY = 2;
    private static final int MODE_TEXT = 1;
    private static final int OPCODE = 15;
    private static final List OPCODES = Arrays.asList(new Integer[] {
        Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10)
    });
    private static final int OP_BINARY = 2;
    private static final int OP_CLOSE = 8;
    private static final int OP_CONTINUATION = 0;
    private static final int OP_PING = 9;
    private static final int OP_PONG = 10;
    private static final int OP_TEXT = 1;
    private static final int RSV1 = 64;
    private static final int RSV2 = 32;
    private static final int RSV3 = 16;
    private static final String TAG = "HybiParser";
    private ByteArrayOutputStream mBuffer;
    private WebSocketClient mClient;
    private boolean mClosed;
    private boolean mFinal;
    private int mLength;
    private int mLengthSize;
    private byte mMask[];
    private boolean mMasked;
    private boolean mMasking;
    private int mMode;
    private int mOpcode;
    private byte mPayload[];
    private int mStage;

    public HybiParser(WebSocketClient websocketclient)
    {
        mMasking = true;
        mMask = new byte[0];
        mPayload = new byte[0];
        mClosed = false;
        mBuffer = new ByteArrayOutputStream();
        mClient = websocketclient;
    }

    private static long byteArrayToLong(byte abyte0[], int i, int j)
    {
        if (abyte0.length < j)
        {
            throw new IllegalArgumentException("length must be less than or equal to b.length");
        }
        long l = 0L;
        for (int k = 0; k < j; k++)
        {
            l += (abyte0[k + i] & 0xff) << (j - 1 - k) * 8;
        }

        return l;
    }

    private byte[] decode(String s)
    {
        try
        {
            s = s.getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    private void emitFrame()
        throws IOException
    {
        int i = 0;
        byte abyte0[] = mask(mPayload, mMask, 0);
        int j = mOpcode;
        if (j == 0)
        {
            if (mMode == 0)
            {
                throw new ProtocolError("Mode was not set.");
            }
            mBuffer.write(abyte0);
            if (mFinal)
            {
                abyte0 = mBuffer.toByteArray();
                if (mMode == 1)
                {
                    mClient.getListener().onMessage(encode(abyte0));
                } else
                {
                    mClient.getListener().onMessage(abyte0);
                }
                reset();
            }
        } else
        {
            if (j == 1)
            {
                if (mFinal)
                {
                    abyte0 = encode(abyte0);
                    mClient.getListener().onMessage(abyte0);
                    return;
                } else
                {
                    mMode = 1;
                    mBuffer.write(abyte0);
                    return;
                }
            }
            if (j == 2)
            {
                if (mFinal)
                {
                    mClient.getListener().onMessage(abyte0);
                    return;
                } else
                {
                    mMode = 2;
                    mBuffer.write(abyte0);
                    return;
                }
            }
            if (j == 8)
            {
                if (abyte0.length >= 2)
                {
                    i = abyte0[0] * 256 + abyte0[1];
                }
                if (abyte0.length > 2)
                {
                    abyte0 = encode(slice(abyte0, 2));
                } else
                {
                    abyte0 = null;
                }
                Log.d("HybiParser", (new StringBuilder()).append("Got close op! ").append(i).append(" ").append(abyte0).toString());
                mClient.getListener().onDisconnect(i, abyte0);
                return;
            }
            if (j == 9)
            {
                if (abyte0.length > 125)
                {
                    throw new ProtocolError("Ping payload too large");
                } else
                {
                    Log.d("HybiParser", "Sending pong!!");
                    mClient.sendFrame(frame(abyte0, 10, -1));
                    return;
                }
            }
            if (j == 10)
            {
                String s = encode(abyte0);
                Log.d("HybiParser", (new StringBuilder()).append("Got pong! ").append(s).toString());
                return;
            }
        }
    }

    private String encode(byte abyte0[])
    {
        try
        {
            abyte0 = new String(abyte0, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException(abyte0);
        }
        return abyte0;
    }

    private byte[] frame(Object obj, int i, int j)
    {
        if (mClosed)
        {
            obj = null;
        } else
        {
            Log.d("HybiParser", (new StringBuilder()).append("Creating frame for: ").append(obj).append(" op: ").append(i).append(" err: ").append(j).toString());
            byte abyte0[];
            byte byte0;
            byte byte1;
            char c;
            int k;
            int l;
            if (obj instanceof String)
            {
                obj = decode((String)obj);
            } else
            {
                obj = (byte[])(byte[])obj;
            }
            if (j > 0)
            {
                byte1 = 2;
            } else
            {
                byte1 = 0;
            }
            k = obj.length + byte1;
            if (k <= 125)
            {
                byte0 = 2;
            } else
            if (k <= 65535)
            {
                byte0 = 4;
            } else
            {
                byte0 = 10;
            }
            if (mMasking)
            {
                c = '\004';
            } else
            {
                c = '\0';
            }
            l = byte0 + c;
            if (mMasking)
            {
                c = '\200';
            } else
            {
                c = '\0';
            }
            abyte0 = new byte[k + l];
            abyte0[0] = (byte)((byte)i | 0xffffff80);
            if (k <= 125)
            {
                abyte0[1] = (byte)(c | k);
            } else
            if (k <= 65535)
            {
                abyte0[1] = (byte)(c | 0x7e);
                abyte0[2] = (byte)(int)Math.floor(k / 256);
                abyte0[3] = (byte)(k & 0xff);
            } else
            {
                abyte0[1] = (byte)(c | 0x7f);
                abyte0[2] = (byte)((int)Math.floor((double)k / Math.pow(2D, 56D)) & 0xff);
                abyte0[3] = (byte)((int)Math.floor((double)k / Math.pow(2D, 48D)) & 0xff);
                abyte0[4] = (byte)((int)Math.floor((double)k / Math.pow(2D, 40D)) & 0xff);
                abyte0[5] = (byte)((int)Math.floor((double)k / Math.pow(2D, 32D)) & 0xff);
                abyte0[6] = (byte)((int)Math.floor((double)k / Math.pow(2D, 24D)) & 0xff);
                abyte0[7] = (byte)((int)Math.floor((double)k / Math.pow(2D, 16D)) & 0xff);
                abyte0[8] = (byte)((int)Math.floor((double)k / Math.pow(2D, 8D)) & 0xff);
                abyte0[9] = (byte)(k & 0xff);
            }
            if (j > 0)
            {
                abyte0[l] = (byte)((int)Math.floor(j / 256) & 0xff);
                abyte0[l + 1] = (byte)(j & 0xff);
            }
            System.arraycopy(obj, 0, abyte0, l + byte1, obj.length);
            obj = abyte0;
            if (mMasking)
            {
                obj = new byte[4];
                obj[0] = (byte)(int)Math.floor(Math.random() * 256D);
                obj[1] = (byte)(int)Math.floor(Math.random() * 256D);
                obj[2] = (byte)(int)Math.floor(Math.random() * 256D);
                obj[3] = (byte)(int)Math.floor(Math.random() * 256D);
                System.arraycopy(obj, 0, abyte0, byte0, obj.length);
                mask(abyte0, ((byte []) (obj)), l);
                return abyte0;
            }
        }
        return ((byte []) (obj));
    }

    private byte[] frame(String s, int i, int j)
    {
        return frame(s, i, j);
    }

    private byte[] frame(byte abyte0[], int i, int j)
    {
        return frame(abyte0, i, j);
    }

    private int getInteger(byte abyte0[])
        throws ProtocolError
    {
        long l = byteArrayToLong(abyte0, 0, abyte0.length);
        if (l < 0L || l > 0x7fffffffL)
        {
            throw new ProtocolError((new StringBuilder()).append("Bad integer: ").append(l).toString());
        } else
        {
            return (int)l;
        }
    }

    private static byte[] mask(byte abyte0[], byte abyte1[], int i)
    {
        if (abyte1.length != 0)
        {
            int j = 0;
            while (j < abyte0.length - i) 
            {
                abyte0[i + j] = (byte)(abyte0[i + j] ^ abyte1[j % 4]);
                j++;
            }
        }
        return abyte0;
    }

    private void parseExtendedLength(byte abyte0[])
        throws ProtocolError
    {
        mLength = getInteger(abyte0);
        int i;
        if (mMasked)
        {
            i = 3;
        } else
        {
            i = 4;
        }
        mStage = i;
    }

    private void parseLength(byte byte0)
    {
        boolean flag;
        if ((byte0 & 0x80) == 128)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mMasked = flag;
        mLength = byte0 & 0x7f;
        if (mLength >= 0 && mLength <= 125)
        {
            if (mMasked)
            {
                byte0 = 3;
            } else
            {
                byte0 = 4;
            }
            mStage = byte0;
            return;
        }
        if (mLength == 126)
        {
            byte0 = 2;
        } else
        {
            byte0 = 8;
        }
        mLengthSize = byte0;
        mStage = 2;
    }

    private void parseOpcode(byte byte0)
        throws ProtocolError
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        if ((byte0 & 0x40) == 64)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((byte0 & 0x20) == 32)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if ((byte0 & 0x10) == 16)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag || flag1 || flag2)
        {
            throw new ProtocolError("RSV not zero");
        }
        boolean flag3;
        if ((byte0 & 0x80) == 128)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        mFinal = flag3;
        mOpcode = byte0 & 0xf;
        mMask = new byte[0];
        mPayload = new byte[0];
        if (!OPCODES.contains(Integer.valueOf(mOpcode)))
        {
            throw new ProtocolError("Bad opcode");
        }
        if (!FRAGMENTED_OPCODES.contains(Integer.valueOf(mOpcode)) && !mFinal)
        {
            throw new ProtocolError("Expected non-final packet");
        } else
        {
            mStage = 1;
            return;
        }
    }

    private void reset()
    {
        mMode = 0;
        mBuffer.reset();
    }

    private byte[] slice(byte abyte0[], int i)
    {
        return Arrays.copyOfRange(abyte0, i, abyte0.length);
    }

    public void close(int i, String s)
    {
        if (mClosed)
        {
            return;
        } else
        {
            mClient.send(frame(s, 8, i));
            mClosed = true;
            return;
        }
    }

    public byte[] frame(String s)
    {
        return frame(s, 1, -1);
    }

    public byte[] frame(byte abyte0[])
    {
        return frame(abyte0, 2, -1);
    }

    public void ping(String s)
    {
        mClient.send(frame(s, 9, -1));
    }

    public void start(HappyDataInputStream happydatainputstream)
        throws IOException
    {
        do
        {
            if (happydatainputstream.available() == -1)
            {
                mClient.getListener().onDisconnect(0, "EOF");
                return;
            }
            switch (mStage)
            {
            case 0: // '\0'
                parseOpcode(happydatainputstream.readByte());
                break;

            case 1: // '\001'
                parseLength(happydatainputstream.readByte());
                break;

            case 2: // '\002'
                parseExtendedLength(happydatainputstream.readBytes(mLengthSize));
                break;

            case 3: // '\003'
                mMask = happydatainputstream.readBytes(4);
                mStage = 4;
                break;

            case 4: // '\004'
                mPayload = happydatainputstream.readBytes(mLength);
                emitFrame();
                mStage = 0;
                break;
            }
        } while (true);
    }

}
