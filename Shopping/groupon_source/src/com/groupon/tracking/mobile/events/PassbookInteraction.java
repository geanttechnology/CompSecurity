// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class PassbookInteraction extends MobileFunnelEvent
{

    public String action;
    public String dealID;
    public String extraInfo;

    public PassbookInteraction()
    {
        dealID = "";
        action = "";
        extraInfo = "";
        eventType = "GRP27";
    }

    public PassbookInteraction(String s, String s1, String s2, EncodedNSTField encodednstfield)
    {
        super("GRP27", s);
        dealID = "";
        action = "";
        extraInfo = "";
        dealID = s1;
        action = s2;
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
        packer.pack(dealID);
        packer.pack(action);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        dealID = "";
        action = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("PassbookInteraction")).append("[").append(dealID).append(",").append(action).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
