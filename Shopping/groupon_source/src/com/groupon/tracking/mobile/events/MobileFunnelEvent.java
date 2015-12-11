// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileEvent

public class MobileFunnelEvent extends MobileEvent
{

    public int eventID;
    public String funnelID;
    public int parentEventID;

    public MobileFunnelEvent()
    {
        funnelID = "";
    }

    public MobileFunnelEvent(String s, String s1)
    {
        super(s);
        funnelID = "";
        funnelID = s1;
    }

    public void pack(int i, Packer packer)
        throws IOException
    {
        int j = i;
        if (i == -1)
        {
            j = 6;
        }
        super.pack(j, packer);
        packer.pack(funnelID);
        packer.pack(eventID);
        packer.pack(parentEventID);
    }

    public void reset()
    {
        super.reset();
        funnelID = "";
        eventID = 0;
        parentEventID = 0;
    }

    public String toString()
    {
        return (new StringBuilder("MobileFunnelEvent")).append("[").append(funnelID).append(",").append(eventID).append(",").append(parentEventID).append(",").append("]").toString();
    }
}
