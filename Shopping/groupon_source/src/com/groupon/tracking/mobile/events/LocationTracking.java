// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class LocationTracking extends MobileFunnelEvent
{

    public int accuracy;
    public String extraInfo;
    public float lat;
    public float lng;
    public long loctime;

    public LocationTracking()
    {
        extraInfo = "";
        eventType = "GRP20";
    }

    public LocationTracking(String s, float f, float f1, int i, long l, EncodedNSTField encodednstfield)
    {
        super("GRP20", s);
        extraInfo = "";
        lat = f;
        lng = f1;
        accuracy = i;
        loctime = l;
        if (encodednstfield != null)
        {
            extraInfo = encodednstfield.toEncodedString();
        }
    }

    public void pack(int i, Packer packer)
        throws IOException
    {
        int j = i;
        if (i == -1)
        {
            j = 11;
        }
        super.pack(j, packer);
        packer.pack(lat);
        packer.pack(lng);
        packer.pack(accuracy);
        packer.pack(loctime);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        lat = 0.0F;
        lng = 0.0F;
        accuracy = 0;
        loctime = 0L;
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("LocationTracking")).append("[").append(lat).append(",").append(lng).append(",").append(accuracy).append(",").append(loctime).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
