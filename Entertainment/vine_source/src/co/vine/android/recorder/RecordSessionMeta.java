// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class RecordSessionMeta
    implements Externalizable
{

    private static final long serialVersionUID = 0x2f5b08d7602a389cL;
    private long mLastModified;
    private int mProgress;

    public RecordSessionMeta()
    {
    }

    public RecordSessionMeta(int i)
    {
        mLastModified = System.currentTimeMillis();
        mProgress = i;
    }

    public long getLastModified()
    {
        return mLastModified;
    }

    public int getProgress()
    {
        return mProgress;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        mProgress = objectinput.readInt();
        mLastModified = objectinput.readLong();
    }

    public void setProgress(int i)
    {
        mProgress = i;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeInt(mProgress);
        objectoutput.writeLong(mLastModified);
    }
}
