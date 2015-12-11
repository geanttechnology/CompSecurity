// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class Click extends MobileFunnelEvent
{

    public String clickMetadata;
    public String clickType;
    public String extraInfo;
    public String specifier;

    public Click()
    {
        clickType = "";
        specifier = "";
        clickMetadata = "";
        extraInfo = "";
        eventType = "GRP17";
    }

    public Click(String s, String s1, String s2, String s3, EncodedNSTField encodednstfield)
    {
        super("GRP17", s);
        clickType = "";
        specifier = "";
        clickMetadata = "";
        extraInfo = "";
        clickType = s1;
        specifier = s2;
        clickMetadata = s3;
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
        packer.pack(clickType);
        packer.pack(specifier);
        packer.pack(clickMetadata);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        clickType = "";
        specifier = "";
        clickMetadata = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("Click")).append("[").append(clickType).append(",").append(specifier).append(",").append(clickMetadata).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
