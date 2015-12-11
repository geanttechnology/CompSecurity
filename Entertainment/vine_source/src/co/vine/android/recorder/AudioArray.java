// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.media.AudioRecord;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class AudioArray
{
    public static final class AudioArrayType extends Enum
    {

        private static final AudioArrayType $VALUES[];
        public static final AudioArrayType BYTE;
        public static final AudioArrayType SHORT;

        public static AudioArrayType valueOf(String s)
        {
            return (AudioArrayType)Enum.valueOf(co/vine/android/recorder/AudioArray$AudioArrayType, s);
        }

        public static AudioArrayType[] values()
        {
            return (AudioArrayType[])$VALUES.clone();
        }

        static 
        {
            BYTE = new AudioArrayType("BYTE", 0);
            SHORT = new AudioArrayType("SHORT", 1);
            $VALUES = (new AudioArrayType[] {
                BYTE, SHORT
            });
        }

        private AudioArrayType(String s, int i)
        {
            super(s, i);
        }
    }


    public final int length;
    private final byte mDataByte[];
    private final short mDataShort[];
    private final AudioArrayType mType;

    public AudioArray(int i, AudioArrayType audioarraytype)
    {
        mType = audioarraytype;
        if (mType == AudioArrayType.BYTE)
        {
            mDataShort = null;
            mDataByte = new byte[i * 2];
        } else
        {
            mDataByte = null;
            mDataShort = new short[i];
        }
        length = i;
    }

    public AudioArray(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("audioData == null");
        }
        if (obj instanceof byte[])
        {
            mType = AudioArrayType.BYTE;
            mDataShort = null;
            mDataByte = (byte[])(byte[])obj;
            length = mDataByte.length;
            return;
        } else
        {
            mType = AudioArrayType.SHORT;
            mDataByte = null;
            mDataShort = (short[])(short[])obj;
            length = mDataShort.length;
            return;
        }
    }

    public Object getData()
    {
        if (mType == AudioArrayType.BYTE)
        {
            return mDataByte;
        } else
        {
            return mDataShort;
        }
    }

    public byte[] getDataByte()
    {
        if (mType == AudioArrayType.BYTE)
        {
            return mDataByte;
        } else
        {
            throw new IllegalArgumentException("The Data type for this is byte");
        }
    }

    public short[] getDataShort()
    {
        if (mType == AudioArrayType.SHORT)
        {
            return mDataShort;
        } else
        {
            throw new IllegalArgumentException("The Data type for this is byte");
        }
    }

    public void getFrom(Buffer buffer)
    {
        if (buffer instanceof ShortBuffer)
        {
            ((ShortBuffer)buffer).get(getDataShort());
            return;
        }
        if (buffer instanceof ByteBuffer)
        {
            ((ByteBuffer)buffer).get(getDataByte());
            return;
        } else
        {
            throw new IllegalArgumentException("Invalid buffer type");
        }
    }

    public AudioArrayType getType()
    {
        return mType;
    }

    public void putInto(AudioArray audioarray, int i, int j)
    {
        if (mType != audioarray.mType)
        {
            throw new IllegalStateException("Incompatible types.");
        }
        if (mType == AudioArrayType.BYTE)
        {
            ByteBuffer.wrap(mDataByte, 0, j).get(audioarray.mDataByte, i, j);
            return;
        } else
        {
            ShortBuffer.wrap(mDataShort, 0, j).get(audioarray.mDataShort, i, j);
            return;
        }
    }

    public void putInto(Buffer buffer, int i, int j)
    {
        if (buffer instanceof ShortBuffer)
        {
            ((ShortBuffer)buffer).put(getDataShort(), i, j);
        } else
        if (buffer instanceof ByteBuffer)
        {
            ((ByteBuffer)buffer).put(getDataByte(), i, j);
            return;
        }
    }

    public int readFrom(AudioRecord audiorecord, int i)
    {
        if (mType == AudioArrayType.BYTE)
        {
            return audiorecord.read(mDataByte, 0, i);
        } else
        {
            return audiorecord.read(mDataShort, 0, i);
        }
    }
}
