// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class PageLoad extends MobileFunnelEvent
{

    public int duration;
    public String extraInfo;
    public int group;
    public String pageID;
    public long startTime;

    public PageLoad()
    {
        pageID = "";
        extraInfo = "";
        eventType = "GRP36";
    }

    public PageLoad(String s, String s1, int i, long l, int j, EncodedNSTField encodednstfield)
    {
        super("GRP36", s);
        pageID = "";
        extraInfo = "";
        pageID = s1;
        group = i;
        startTime = l;
        duration = j;
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
        packer.pack(pageID);
        packer.pack(group);
        packer.pack(startTime);
        packer.pack(duration);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        pageID = "";
        group = 0;
        startTime = 0L;
        duration = 0;
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("PageLoad")).append("[").append(pageID).append(",").append(group).append(",").append(startTime).append(",").append(duration).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
