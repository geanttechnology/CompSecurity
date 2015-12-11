// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class Spinner extends MobileFunnelEvent
{

    public String extraInfo;
    public long start;
    public String status;
    public String viewed;

    public Spinner()
    {
        status = "";
        viewed = "";
        extraInfo = "";
        eventType = "GRP37";
    }

    public Spinner(String s, String s1, long l, String s2, EncodedNSTField encodednstfield)
    {
        super("GRP37", s);
        status = "";
        viewed = "";
        extraInfo = "";
        status = s1;
        start = l;
        viewed = s2;
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
            j = 10;
        }
        super.pack(j, packer);
        packer.pack(status);
        packer.pack(start);
        packer.pack(viewed);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        status = "";
        start = 0L;
        viewed = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("Spinner")).append("[").append(status).append(",").append(start).append(",").append(viewed).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
