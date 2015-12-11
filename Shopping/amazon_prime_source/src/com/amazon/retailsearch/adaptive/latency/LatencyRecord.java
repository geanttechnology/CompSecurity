// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.adaptive.latency;

import com.amazon.retailsearch.adaptive.NetworkType;
import com.amazon.retailsearch.adaptive.framework.AdaptiveTreatmentEnum;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Referenced classes of package com.amazon.retailsearch.adaptive.latency:
//            ImageQualityTreatment

public class LatencyRecord
    implements Serializable
{

    private static final long EXPIRATION = 0x45d964b800L;
    private static final long serialVersionUID = 0x1337a7dL;
    private int latency;
    private NetworkType networkType;
    private transient long time;
    private AdaptiveTreatmentEnum treatment;

    public LatencyRecord(int i, AdaptiveTreatmentEnum adaptivetreatmentenum, NetworkType networktype)
    {
        latency = i;
        time = System.nanoTime();
        treatment = adaptivetreatmentenum;
        networkType = networktype;
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        latency = objectinputstream.readInt();
        treatment = (ImageQualityTreatment)objectinputstream.readObject();
        networkType = (NetworkType)objectinputstream.readObject();
        time = System.nanoTime();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeInt(latency);
        objectoutputstream.writeObject(treatment);
        objectoutputstream.writeObject(networkType);
    }

    public int getLatency()
    {
        return latency;
    }

    public NetworkType getNetworkType()
    {
        return networkType;
    }

    public long getTime()
    {
        return time;
    }

    public AdaptiveTreatmentEnum getTreatment()
    {
        return treatment;
    }

    public boolean hasExpired(long l)
    {
        return l - time > 0x45d964b800L;
    }

    public String toString()
    {
        return String.format("(%d, %d, %s, %s)", new Object[] {
            Integer.valueOf(latency), Long.valueOf(time), treatment, networkType
        });
    }
}
