// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class InAppMessage extends MobileFunnelEvent
{

    public String extraInfo;
    public String fullUrl;
    public String marketingText;
    public String mid;

    public InAppMessage()
    {
        marketingText = "";
        fullUrl = "";
        mid = "";
        extraInfo = "";
        eventType = "GRP19";
    }

    public InAppMessage(String s, String s1, String s2, String s3, EncodedNSTField encodednstfield)
    {
        super("GRP19", s);
        marketingText = "";
        fullUrl = "";
        mid = "";
        extraInfo = "";
        marketingText = s1;
        fullUrl = s2;
        mid = s3;
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
        packer.pack(marketingText);
        packer.pack(fullUrl);
        packer.pack(mid);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        marketingText = "";
        fullUrl = "";
        mid = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("InAppMessage")).append("[").append(marketingText).append(",").append(fullUrl).append(",").append(mid).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
