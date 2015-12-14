// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.Message;
import amazon.communication.MessageFactory;
import android.os.Parcel;
import android.os.Parcelable;
import com.dp.utils.FailFast;
import java.nio.ByteBuffer;

// Referenced classes of package com.amazon.communication:
//            ByteBufferChainMessageImpl, InputStreamMessageImpl, InputStreamProxy, ServiceSideInputStreamProxy, 
//            LargeArrayOptimizedIInputStream

public class MessageEnvelope
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        private MessageEnvelope createFromByteArrayParcel(Parcel parcel)
        {
            int k = parcel.readInt();
            int l = parcel.readInt();
            ByteBuffer abytebuffer[] = new ByteBuffer[l];
            int j = 0;
            int i = 0;
            while (j < k) 
            {
                byte abyte0[] = parcel.createByteArray();
                boolean flag;
                if (abyte0.length + j <= k)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                FailFast.expectTrue(flag, new Object[] {
                    "Received more data than expected from a Parcel"
                });
                abytebuffer[i] = ByteBuffer.wrap(abyte0);
                j += abyte0.length;
                i++;
            }
            FailFast.expectEquals(k, j, new Object[] {
                "Expected message size did not match total number of bytes read"
            });
            FailFast.expectEquals(l, i, new Object[] {
                "Did not read the expected number of buffers from the parcel"
            });
            return new MessageEnvelope(MessageFactory.createMessage(abytebuffer));
        }

        private MessageEnvelope createFromInputStreamParcel(Parcel parcel)
        {
            return new MessageEnvelope(MessageFactory.createMessage(new ServiceSideInputStreamProxy(LargeArrayOptimizedIInputStream.makeIInputStream(parcel.readStrongBinder()))));
        }

        public MessageEnvelope createFromParcel(Parcel parcel)
        {
            if (parcel.readByte() == 1)
            {
                return createFromInputStreamParcel(parcel);
            } else
            {
                return createFromByteArrayParcel(parcel);
            }
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public MessageEnvelope[] newArray(int i)
        {
            return new MessageEnvelope[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private Message mMessage;

    MessageEnvelope(Message message)
    {
        mMessage = message;
    }

    private void copyDataIntoParcelOrConvertToInputStream(Parcel parcel)
    {
        ByteBufferChainMessageImpl bytebufferchainmessageimpl = (ByteBufferChainMessageImpl)mMessage;
        int k = bytebufferchainmessageimpl.getPayloadSize();
        boolean flag;
        if (k > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        FailFast.expectTrue(flag, new Object[] {
            "Message payload size is not greater than 0"
        });
        if (k > 0x19000)
        {
            putInputStreamIntoParcel(parcel);
            return;
        }
        parcel.writeByte((byte)0);
        parcel.writeInt(k);
        ByteBuffer abytebuffer[] = bytebufferchainmessageimpl.getByteBuffers();
        parcel.writeInt(abytebuffer.length);
        int j = 0;
        int i;
        for (i = 0; i < abytebuffer.length; i++)
        {
            parcel.writeByteArray(abytebuffer[i].array(), abytebuffer[i].position(), abytebuffer[i].remaining());
            j += abytebuffer[i].remaining();
        }

        FailFast.expectEquals(k, j, new Object[] {
            "Message payload size did not match the number of bytes written"
        });
        FailFast.expectEquals(abytebuffer.length, i, new Object[] {
            "Did not write the expected number of buffers into the Parcel"
        });
    }

    private boolean isInputStreamBackedMessage()
    {
        return mMessage instanceof InputStreamMessageImpl;
    }

    private void putInputStreamIntoParcel(Parcel parcel)
    {
        parcel.writeByte((byte)1);
        parcel.writeStrongBinder((new InputStreamProxy(mMessage.getPayload())).asBinder());
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (isInputStreamBackedMessage())
        {
            putInputStreamIntoParcel(parcel);
            return;
        } else
        {
            copyDataIntoParcelOrConvertToInputStream(parcel);
            return;
        }
    }

}
