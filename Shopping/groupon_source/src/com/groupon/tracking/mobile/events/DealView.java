// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class DealView extends MobileFunnelEvent
{

    public String channel;
    public String dealID;
    public String dealUUID;
    public String extraInfo;

    public DealView()
    {
        channel = "";
        dealID = "";
        dealUUID = "";
        extraInfo = "";
        eventType = "GRP3";
    }

    public DealView(String s, String s1, String s2, String s3, EncodedNSTField encodednstfield)
    {
        super("GRP3", s);
        channel = "";
        dealID = "";
        dealUUID = "";
        extraInfo = "";
        channel = s1;
        dealID = s2;
        dealUUID = s3;
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
        packer.pack(channel);
        packer.pack(dealID);
        packer.pack(dealUUID);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        channel = "";
        dealID = "";
        dealUUID = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("DealView")).append("[").append(channel).append(",").append(dealID).append(",").append(dealUUID).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
