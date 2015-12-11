// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class Login extends MobileFunnelEvent
{

    public String extraInfo;
    public String optionalDealID;
    public String triggered;

    public Login()
    {
        triggered = "";
        optionalDealID = "";
        extraInfo = "";
        eventType = "GRP29";
    }

    public Login(String s, String s1, String s2, EncodedNSTField encodednstfield)
    {
        super("GRP29", s);
        triggered = "";
        optionalDealID = "";
        extraInfo = "";
        triggered = s1;
        optionalDealID = s2;
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
        packer.pack(triggered);
        packer.pack(optionalDealID);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        triggered = "";
        optionalDealID = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("Login")).append("[").append(triggered).append(",").append(optionalDealID).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
