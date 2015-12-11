// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class AdTracking extends MobileFunnelEvent
{

    public String extraInfo;
    public String settingsMap;

    public AdTracking()
    {
        settingsMap = "";
        extraInfo = "";
        eventType = "GRP41";
    }

    public AdTracking(String s, EncodedNSTField encodednstfield, EncodedNSTField encodednstfield1)
    {
        super("GRP41", s);
        settingsMap = "";
        extraInfo = "";
        settingsMap = encodednstfield.toEncodedString();
        extraInfo = encodednstfield1.toEncodedString();
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
        packer.pack(settingsMap);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        settingsMap = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("AdTracking")).append("[").append(settingsMap).append(",").append(extraInfo).append("]").toString();
    }
}
