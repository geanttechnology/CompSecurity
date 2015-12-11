// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.Message;
import com.amazon.dp.logger.DPFormattedMessage;
import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.communication:
//            BetterInputStream

public class InputStreamMessageImpl
    implements Message
{
    private class PayloadInputStream extends InputStream
        implements BetterInputStream
    {

        private boolean mEndOfStream;
        private final ByteBuffer mPrependedDataArray[];
        private int mPrependedReadIndex;
        final InputStreamMessageImpl this$0;

        private int readFromPrepends(byte abyte0[], int i, int j)
        {
            boolean flag = false;
            int k = i;
            for (i = ((flag) ? 1 : 0); i < j && mPrependedReadIndex < mPrependedDataArray.length;)
            {
                ByteBuffer bytebuffer = mPrependedDataArray[mPrependedReadIndex];
                if (bytebuffer.hasRemaining())
                {
                    int i1 = j - i;
                    int l = i1;
                    if (i1 > bytebuffer.remaining())
                    {
                        l = bytebuffer.remaining();
                    }
                    bytebuffer.get(abyte0, k, l);
                    k += l;
                    i += l;
                } else
                {
                    mPrependedReadIndex = mPrependedReadIndex + 1;
                }
            }

            InputStreamMessageImpl.log.verbose("readFromPrepends", "final", new Object[] {
                "maxBytesToRead", Integer.valueOf(j), "currentOffset", Integer.valueOf(k), "bytesRead", Integer.valueOf(i)
            });
            return i;
        }

        public int available()
            throws IOException
        {
            int k = 0;
            if (!mEndOfStream)
            {
                for (int i = mPrependedReadIndex; i < mPrependedDataArray.length; i++)
                {
                    k += mPrependedDataArray[i].remaining();
                }

                k += mInputStream.available();
                int j = k;
                if (!(mInputStream instanceof BetterInputStream))
                {
                    j = k;
                    if (k == 0)
                    {
                        j = 1;
                    }
                }
                return j;
            } else
            {
                return 1;
            }
        }

        public void close()
            throws IOException
        {
            mInputStream.close();
        }

        public int read()
            throws IOException
        {
            int i = -1;
            if (!mEndOfStream)
            {
                boolean flag;
                if (mPrependedReadIndex < mPrependedDataArray.length)
                {
                    for (; mPrependedReadIndex < mPrependedDataArray.length && !mPrependedDataArray[mPrependedReadIndex].hasRemaining(); mPrependedReadIndex = mPrependedReadIndex + 1) { }
                    if (mPrependedReadIndex < mPrependedDataArray.length)
                    {
                        i = mPrependedDataArray[mPrependedReadIndex].get() & 0xff;
                    } else
                    {
                        i = mInputStream.read();
                    }
                } else
                {
                    i = mInputStream.read();
                }
                if (i == -1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                mEndOfStream = flag;
            }
            InputStreamMessageImpl.log.verbose("read", "single-byte read; too many invocations may indicate inefficiency, and that bulk read operations should be used", new Object[0]);
            return i;
        }

        public int read(byte abyte0[])
            throws IOException
        {
            return read(abyte0, 0, abyte0.length);
        }

        public int read(byte abyte0[], int i, int j)
            throws IOException
        {
            boolean flag = true;
            if (abyte0 == null)
            {
                throw new NullPointerException("Array cannot be null");
            }
            if (i < 0 || i >= abyte0.length || j < 0 || i + j > abyte0.length)
            {
                throw new IndexOutOfBoundsException(DPFormattedMessage.toDPFormat("read", "array index out of bounds", new Object[] {
                    "array.length", Integer.valueOf(abyte0.length), "offset", Integer.valueOf(i), "length", Integer.valueOf(j)
                }));
            }
            if (j == 0)
            {
                return 0;
            }
            int l = -1;
            if (!mEndOfStream)
            {
                InputStreamMessageImpl.log.verbose("read", "reading with offset", new Object[] {
                    "array.length", Integer.valueOf(abyte0.length), "length", Integer.valueOf(j), "offset", Integer.valueOf(i)
                });
                l = readFromPrepends(abyte0, i, j);
                InputStreamMessageImpl.log.verbose("read", "finished reading with offset", new Object[] {
                    "bytesRead", Integer.valueOf(l)
                });
                int k = l;
                if (l < j)
                {
                    i = mInputStream.read(abyte0, i + l, j - l);
                    if (i != -1)
                    {
                        flag = false;
                    }
                    mEndOfStream = flag;
                    k = l;
                    if (i > 0)
                    {
                        k = l + i;
                    }
                }
                l = k;
                if (k == 0)
                {
                    l = -1;
                }
            }
            return l;
        }

        PayloadInputStream()
        {
            this$0 = InputStreamMessageImpl.this;
            super();
            mPrependedReadIndex = 0;
            mEndOfStream = false;
            mPrependedDataArray = (ByteBuffer[])mPrependedData.toArray(new ByteBuffer[mPrependedData.size()]);
        }
    }


    private static final DPLogger log = new DPLogger("TComm.InputStreamMessageImpl");
    private final InputStream mInputStream;
    private boolean mIsGetPayloadInvoked;
    private final List mPrependedData;

    public InputStreamMessageImpl(InputStream inputstream)
    {
        mPrependedData = new ArrayList();
        mInputStream = inputstream;
        mIsGetPayloadInvoked = false;
    }

    public InputStreamMessageImpl(List list, InputStream inputstream)
    {
        mPrependedData = new ArrayList(list);
        mInputStream = inputstream;
        mIsGetPayloadInvoked = false;
    }

    public void appendPayload(ByteBuffer bytebuffer)
    {
        throw new UnsupportedOperationException("We don't support append a payload to InputStream based message.");
    }

    public Message extractPayload()
    {
        return new InputStreamMessageImpl(mPrependedData, mInputStream);
    }

    public InputStream getPayload()
    {
        if (mIsGetPayloadInvoked)
        {
            throw new UnsupportedOperationException("getPayload can only be called once for InputStream based message.");
        } else
        {
            mIsGetPayloadInvoked = true;
            return new PayloadInputStream();
        }
    }

    public int getPayloadSize()
    {
        return -1;
    }

    public void prependPayload(ByteBuffer bytebuffer)
    {
        if (mIsGetPayloadInvoked)
        {
            throw new UnsupportedOperationException("Can't prepend more payload after getPayload is called.");
        } else
        {
            mPrependedData.add(0, bytebuffer);
            return;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("InputStreamMessageImpl [PrependedData=").append(mPrependedData).append("] [InputStream=").append(mInputStream).append("]").toString();
    }




}
