// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileEvent

public class GeneralEvent extends MobileEvent
{

    public String action;
    public String eventCategory;
    public String extraInfo;
    public String label;
    public int value;

    public GeneralEvent()
    {
        eventCategory = "";
        action = "";
        label = "";
        extraInfo = "";
        eventType = "GRP8";
    }

    public GeneralEvent(String s, String s1, String s2, int i, EncodedNSTField encodednstfield)
    {
        super("GRP8");
        eventCategory = "";
        action = "";
        label = "";
        extraInfo = "";
        eventCategory = s;
        action = s1;
        label = s2;
        value = i;
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
        packer.pack(eventCategory);
        packer.pack(action);
        packer.pack(label);
        packer.pack(value);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        eventCategory = "";
        action = "";
        label = "";
        value = 0;
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("GeneralEvent")).append("[").append(eventCategory).append(",").append(action).append(",").append(label).append(",").append(value).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
