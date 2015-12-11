// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package co.vine.android.recorder:
//            RecordConfigUtils

public class AudioData
    implements Externalizable
{

    int size;
    int start;

    public AudioData()
    {
    }

    public AudioData(int i, int j)
    {
        start = i;
        size = j;
    }

    public AudioData(AudioData audiodata)
    {
        start = audiodata.start;
        size = audiodata.size;
    }

    public long getDurationNs()
    {
        return (long)RecordConfigUtils.getTimeStampInNsFromSampleCounted(size);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        start = objectinput.readInt();
        size = objectinput.readInt();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeInt(start);
        objectoutput.writeInt(size);
    }
}
