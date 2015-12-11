// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class PageView extends MobileFunnelEvent
{

    public String extraInfo;
    public String pageID;

    public PageView()
    {
        pageID = "";
        extraInfo = "";
        eventType = "GRP14";
    }

    public PageView(String s, String s1, EncodedNSTField encodednstfield)
    {
        super("GRP14", s);
        pageID = "";
        extraInfo = "";
        pageID = s1;
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
        packer.pack(pageID);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        pageID = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("PageView")).append("[").append(pageID).append(",").append(extraInfo).append("]").toString();
    }
}
