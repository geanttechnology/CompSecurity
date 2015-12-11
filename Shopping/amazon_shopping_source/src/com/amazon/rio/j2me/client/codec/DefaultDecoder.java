// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.ApplicationException;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            DefaultEncoder, Decoder, StreamedResponseListener

public class DefaultDecoder
{

    private static final int EMPTY_PATH[] = new int[0];
    private static final Decoder booleanDecoder = new Decoder() {

        public Boolean decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
            throws IOException
        {
            if (datainputstream.readBoolean())
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }
        }

        public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
            throws IOException
        {
            return decode(datainputstream, streamedresponselistener);
        }

    };
    private static final Decoder octetArrayDecoder = new Decoder() {

        public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
            throws IOException
        {
            return decode(datainputstream, streamedresponselistener);
        }

        public byte[] decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
            throws IOException
        {
            streamedresponselistener = new byte[datainputstream.readInt()];
            datainputstream.readFully(streamedresponselistener);
            return streamedresponselistener;
        }

    };
    private static final Decoder octetDecoder = new Decoder() {

        public Byte decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
            throws IOException
        {
            return new Byte(datainputstream.readByte());
        }

        public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
            throws IOException
        {
            return decode(datainputstream, streamedresponselistener);
        }

    };
    private static final Decoder stringDecoder = new Decoder() {

        public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
            throws IOException
        {
            return decode(datainputstream, streamedresponselistener);
        }

        public String decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
            throws IOException
        {
            return datainputstream.readUTF();
        }

    };

    public DefaultDecoder()
    {
    }

    public static ApplicationException decodeApplicationException(DataInputStream datainputstream)
        throws IOException
    {
        return new ApplicationException(datainputstream.readUTF(), datainputstream.readUTF());
    }

    private static long decodeIntegerInRange(long l, long l1, DataInputStream datainputstream)
        throws IOException
    {
        int i = DefaultEncoder.numBytesPerValueInRange(l, l1);
        if (i == 1)
        {
            return (long)datainputstream.readUnsignedByte() + l;
        }
        if (i == 2)
        {
            return (long)datainputstream.readUnsignedShort() + l;
        }
        if (i == 4)
        {
            int j = datainputstream.readInt();
            if (j < 0)
            {
                l1 = 0x100000000L + (long)j;
            } else
            {
                l1 = j;
            }
            return l1 + l;
        } else
        {
            return datainputstream.readLong();
        }
    }

    public static Decoder getArrayInstance(Decoder decoder)
    {
        return new Decoder(decoder) {

            final Decoder val$elementDecoder;

            public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
                throws IOException
            {
                return decode(datainputstream, streamedresponselistener);
            }

            public List decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
                throws IOException
            {
                int j = datainputstream.readInt();
                ArrayList arraylist;
                int ai[];
                int i;
                if (streamedresponselistener == null)
                {
                    arraylist = new ArrayList(j);
                } else
                {
                    arraylist = null;
                }
                if (streamedresponselistener != null)
                {
                    ai = new int[1];
                } else
                {
                    ai = null;
                }
                if (streamedresponselistener != null)
                {
                    streamedresponselistener.aboutToReceiveArrayOfSize(j, DefaultDecoder.EMPTY_PATH);
                }
                i = 0;
                while (i < j) 
                {
                    Object obj = elementDecoder.decode(datainputstream, null);
                    if (streamedresponselistener == null)
                    {
                        arraylist.add(obj);
                    } else
                    {
                        ai[0] = i;
                        streamedresponselistener.receivedObject(obj, ai);
                    }
                    i++;
                }
                if (streamedresponselistener != null)
                {
                    streamedresponselistener.receivedObject(arraylist, DefaultDecoder.EMPTY_PATH);
                }
                return arraylist;
            }

            
            {
                elementDecoder = decoder;
                super();
            }
        };
    }

    public static Decoder getBooleanInstance()
    {
        return booleanDecoder;
    }

    public static Decoder getEnumInstance(int i)
    {
        return getIntegerInstance(0L, i - 1);
    }

    public static Decoder getIntegerInstance(long l, long l1)
    {
        return new Decoder(l, l1) {

            final long val$lowerBound;
            final long val$upperBound;

            public Integer decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
                throws IOException
            {
                return Integer.valueOf((int)DefaultDecoder.decodeIntegerInRange(lowerBound, upperBound, datainputstream));
            }

            public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
                throws IOException
            {
                return decode(datainputstream, streamedresponselistener);
            }

            
            {
                lowerBound = l;
                upperBound = l1;
                super();
            }
        };
    }

    public static Decoder getOctetArrayInstance()
    {
        return octetArrayDecoder;
    }

    public static Decoder getStringInstance()
    {
        return stringDecoder;
    }

    public static boolean isErrorResponse(DataInputStream datainputstream)
        throws IOException
    {
        return !datainputstream.readBoolean();
    }



}
