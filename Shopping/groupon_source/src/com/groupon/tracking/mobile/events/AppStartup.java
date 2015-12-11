// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class AppStartup extends MobileFunnelEvent
{

    public int duration;
    public String extraInfo;
    public long startTime;

    public AppStartup()
    {
        extraInfo = "";
        eventType = "GRP24";
    }

    public AppStartup(String s, long l, int i, EncodedNSTField encodednstfield)
    {
        super("GRP24", s);
        extraInfo = "";
        startTime = l;
        duration = i;
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
            j = 9;
        }
        super.pack(j, packer);
        packer.pack(startTime);
        packer.pack(duration);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        startTime = 0L;
        duration = 0;
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("AppStartup")).append("[").append(startTime).append(",").append(duration).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
