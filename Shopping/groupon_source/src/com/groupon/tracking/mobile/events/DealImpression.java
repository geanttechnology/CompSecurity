// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class DealImpression extends MobileFunnelEvent
{

    public String channel;
    public String dealID;
    public String dealUUID;
    public float distance;
    public String extraInfo;
    public int placement;
    public String presentation;

    public DealImpression()
    {
        channel = "";
        presentation = "";
        dealID = "";
        dealUUID = "";
        extraInfo = "";
        eventType = "GRP2";
    }

    public DealImpression(String s, String s1, String s2, String s3, int i, float f, String s4, 
            EncodedNSTField encodednstfield)
    {
        super("GRP2", s);
        channel = "";
        presentation = "";
        dealID = "";
        dealUUID = "";
        extraInfo = "";
        channel = s1;
        presentation = s2;
        dealID = s3;
        placement = i;
        distance = f;
        dealUUID = s4;
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
            j = 13;
        }
        super.pack(j, packer);
        packer.pack(channel);
        packer.pack(presentation);
        packer.pack(dealID);
        packer.pack(placement);
        packer.pack(distance);
        packer.pack(dealUUID);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        channel = "";
        presentation = "";
        dealID = "";
        placement = 0;
        distance = 0.0F;
        dealUUID = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("DealImpression")).append("[").append(channel).append(",").append(presentation).append(",").append(dealID).append(",").append(placement).append(",").append(distance).append(",").append(dealUUID).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
