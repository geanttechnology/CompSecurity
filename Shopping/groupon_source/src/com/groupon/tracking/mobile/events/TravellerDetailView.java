// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class TravellerDetailView extends MobileFunnelEvent
{

    public String dealID;
    public String extraInfo;

    public TravellerDetailView()
    {
        dealID = "";
        extraInfo = "";
        eventType = "GRP31";
    }

    public TravellerDetailView(String s, String s1, EncodedNSTField encodednstfield)
    {
        super("GRP31", s);
        dealID = "";
        extraInfo = "";
        dealID = s1;
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
        packer.pack(dealID);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        dealID = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("TravellerDetailView")).append("[").append(dealID).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
