// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class UserInteraction extends MobileFunnelEvent
{

    public String extraInfo;
    public String interactionMetadata;
    public String interactionType;
    public String specifier;

    public UserInteraction()
    {
        interactionType = "";
        specifier = "";
        interactionMetadata = "";
        extraInfo = "";
        eventType = "GRP35";
    }

    public UserInteraction(String s, String s1, String s2, String s3, EncodedNSTField encodednstfield)
    {
        super("GRP35", s);
        interactionType = "";
        specifier = "";
        interactionMetadata = "";
        extraInfo = "";
        interactionType = s1;
        specifier = s2;
        interactionMetadata = s3;
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
        packer.pack(interactionType);
        packer.pack(specifier);
        packer.pack(interactionMetadata);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        interactionType = "";
        specifier = "";
        interactionMetadata = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("UserInteraction")).append("[").append(interactionType).append(",").append(specifier).append(",").append(interactionMetadata).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
