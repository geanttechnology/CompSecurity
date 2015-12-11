// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class Impression extends MobileFunnelEvent
{

    public String extraInfo;
    public String impressionType;
    public String placement;
    public String specifier;

    public Impression()
    {
        impressionType = "";
        specifier = "";
        placement = "";
        extraInfo = "";
        eventType = "GRP16";
    }

    public Impression(String s, String s1, String s2, String s3, EncodedNSTField encodednstfield)
    {
        super("GRP16", s);
        impressionType = "";
        specifier = "";
        placement = "";
        extraInfo = "";
        impressionType = s1;
        specifier = s2;
        placement = s3;
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
        packer.pack(impressionType);
        packer.pack(specifier);
        packer.pack(placement);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        impressionType = "";
        specifier = "";
        placement = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("Impression")).append("[").append(impressionType).append(",").append(specifier).append(",").append(placement).append(",").append(extraInfo).append("]").toString();
    }
}
