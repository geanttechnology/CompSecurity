// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class CardScanStatus extends MobileFunnelEvent
{

    public String extraInfo;
    public String medium;
    public String status;

    public CardScanStatus()
    {
        medium = "";
        status = "";
        extraInfo = "";
        eventType = "GRP33";
    }

    public CardScanStatus(String s, String s1, String s2, EncodedNSTField encodednstfield)
    {
        super("GRP33", s);
        medium = "";
        status = "";
        extraInfo = "";
        medium = s1;
        status = s2;
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
        packer.pack(medium);
        packer.pack(status);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        medium = "";
        status = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("CardScanStatus")).append("[").append(medium).append(",").append(status).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
