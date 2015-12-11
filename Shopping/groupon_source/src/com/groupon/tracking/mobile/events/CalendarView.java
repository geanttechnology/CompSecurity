// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class CalendarView extends MobileFunnelEvent
{

    public String action;
    public String dealID;
    public String extraInfo;

    public CalendarView()
    {
        action = "";
        dealID = "";
        extraInfo = "";
        eventType = "GRP30";
    }

    public CalendarView(String s, String s1, String s2, EncodedNSTField encodednstfield)
    {
        super("GRP30", s);
        action = "";
        dealID = "";
        extraInfo = "";
        action = s1;
        dealID = s2;
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
        packer.pack(action);
        packer.pack(dealID);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        action = "";
        dealID = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("CalendarView")).append("[").append(action).append(",").append(dealID).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
