// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class MultiOption extends MobileFunnelEvent
{

    public String dealID;
    public String extraInfo;
    public int optionCount;
    public String optionIDSelected;
    public int optionPosition;

    public MultiOption()
    {
        dealID = "";
        optionIDSelected = "";
        extraInfo = "";
        eventType = "GRP26";
    }

    public MultiOption(String s, String s1, String s2, int i, int j, String s3)
    {
        super("GRP26", s);
        dealID = "";
        optionIDSelected = "";
        extraInfo = "";
        dealID = s1;
        optionIDSelected = s2;
        optionCount = i;
        optionPosition = j;
        extraInfo = s3;
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
        packer.pack(dealID);
        packer.pack(optionIDSelected);
        packer.pack(optionCount);
        packer.pack(optionPosition);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        dealID = "";
        optionIDSelected = "";
        optionCount = 0;
        optionPosition = 0;
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("MultiOption")).append("[").append(dealID).append(",").append(optionIDSelected).append(",").append(optionCount).append(",").append(optionPosition).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
