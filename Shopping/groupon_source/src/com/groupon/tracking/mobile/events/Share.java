// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileEvent

public class Share extends MobileEvent
{

    public String extraInfo;
    public String medium;
    public String shareContext;

    public Share()
    {
        shareContext = "";
        medium = "";
        extraInfo = "";
        eventType = "GRP28";
    }

    public Share(String s, String s1, EncodedNSTField encodednstfield)
    {
        super("GRP28");
        shareContext = "";
        medium = "";
        extraInfo = "";
        shareContext = s;
        medium = s1;
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
            j = 6;
        }
        super.pack(j, packer);
        packer.pack(shareContext);
        packer.pack(medium);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        shareContext = "";
        medium = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("Share")).append("[").append(shareContext).append(",").append(medium).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
