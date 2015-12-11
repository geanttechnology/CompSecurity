// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.queue;


// Referenced classes of package com.amazon.client.metrics.batch.queue:
//            VolatileBoundedByteArrayQueue

class mSerializedObject
{

    private byte mSerializedObject[];
    private long mTimeStamp;
    final VolatileBoundedByteArrayQueue this$0;

    public byte[] getSerializedObject()
    {
        return mSerializedObject;
    }

    public long getTimeStamp()
    {
        return mTimeStamp;
    }

    public (long l, byte abyte0[])
    {
        this$0 = VolatileBoundedByteArrayQueue.this;
        super();
        mTimeStamp = l;
        mSerializedObject = abyte0;
    }
}
