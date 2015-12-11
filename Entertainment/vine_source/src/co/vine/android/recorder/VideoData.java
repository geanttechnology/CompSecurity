// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package co.vine.android.recorder:
//            RecordSegment

public class VideoData
    implements Externalizable
{

    private static final long serialVersionUID = 0x773635a4cd84a345L;
    private static final long version = -2L;
    byte data[];
    public boolean keyFrame;
    RecordSegment segment;
    int size;
    public int start;
    long timestamp;

    public VideoData()
    {
    }

    public VideoData(long l, byte abyte0[])
    {
        timestamp = l;
        data = abyte0;
        start = -1;
        size = -1;
    }

    public VideoData(VideoData videodata)
    {
        timestamp = videodata.timestamp;
        data = videodata.data;
        size = videodata.size;
        start = videodata.start;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        if (objectinput.readLong() >= 0L)
        {
            timestamp = -2L;
        } else
        {
            keyFrame = objectinput.readBoolean();
            timestamp = objectinput.readLong();
        }
        start = objectinput.readInt();
        size = objectinput.readInt();
    }

    public void setSegment(RecordSegment recordsegment)
    {
        segment = recordsegment;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeLong(-2L);
        objectoutput.writeBoolean(keyFrame);
        objectoutput.writeLong(timestamp);
        objectoutput.writeInt(start);
        objectoutput.writeInt(size);
    }
}
