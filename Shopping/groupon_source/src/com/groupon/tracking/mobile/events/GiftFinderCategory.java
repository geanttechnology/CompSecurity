// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class GiftFinderCategory extends MobileFunnelEvent
{

    public String extraInfo;
    public int numOptionsSelected;

    public GiftFinderCategory()
    {
        extraInfo = "";
        eventType = "GRP32";
    }

    public GiftFinderCategory(String s, int i, EncodedNSTField encodednstfield)
    {
        super("GRP32", s);
        extraInfo = "";
        numOptionsSelected = i;
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
        packer.pack(numOptionsSelected);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        numOptionsSelected = 0;
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("GiftFinderCategory")).append("[").append(numOptionsSelected).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
