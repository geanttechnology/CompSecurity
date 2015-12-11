// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class AppStartupAttempt extends MobileFunnelEvent
{

    public String extraInfo;
    public long startTime;

    public AppStartupAttempt()
    {
        extraInfo = "";
        eventType = "GRP38";
    }

    public AppStartupAttempt(String s, long l, EncodedNSTField encodednstfield)
    {
        super("GRP38", s);
        extraInfo = "";
        startTime = l;
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
            j = 8;
        }
        super.pack(j, packer);
        packer.pack(startTime);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        startTime = 0L;
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("AppStartupAttempt")).append("[").append(startTime).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
