// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class DealConfirmationView extends MobileFunnelEvent
{

    public String cartStatus;
    public String cartUUID;
    public String channel;
    public String dealID;
    public String dealUUID;
    public String extraInfo;

    public DealConfirmationView()
    {
        channel = "";
        dealID = "";
        cartUUID = "";
        dealUUID = "";
        cartStatus = "";
        extraInfo = "";
        eventType = "GRP13";
    }

    public DealConfirmationView(String s, String s1, String s2, String s3, String s4, String s5, EncodedNSTField encodednstfield)
    {
        super("GRP13", s);
        channel = "";
        dealID = "";
        cartUUID = "";
        dealUUID = "";
        cartStatus = "";
        extraInfo = "";
        channel = s1;
        dealID = s2;
        cartUUID = s3;
        dealUUID = s4;
        cartStatus = s5;
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
            j = 12;
        }
        super.pack(j, packer);
        packer.pack(channel);
        packer.pack(dealID);
        packer.pack(cartUUID);
        packer.pack(dealUUID);
        packer.pack(cartStatus);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        channel = "";
        dealID = "";
        cartUUID = "";
        dealUUID = "";
        cartStatus = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("DealConfirmationView")).append("[").append(channel).append(",").append(dealID).append(",").append(cartUUID).append(",").append(dealUUID).append(",").append(cartStatus).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
