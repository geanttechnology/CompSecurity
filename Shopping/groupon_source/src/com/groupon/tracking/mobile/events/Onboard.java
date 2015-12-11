// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class Onboard extends MobileFunnelEvent
{

    public String email;
    public String extraInfo;
    public String gender;
    public String prefilledZip;
    public String zipcode;

    public Onboard()
    {
        prefilledZip = "";
        email = "";
        zipcode = "";
        gender = "";
        extraInfo = "";
        eventType = "GRP23";
    }

    public Onboard(String s, String s1, String s2, String s3, String s4, EncodedNSTField encodednstfield)
    {
        super("GRP23", s);
        prefilledZip = "";
        email = "";
        zipcode = "";
        gender = "";
        extraInfo = "";
        prefilledZip = s1;
        email = s2;
        zipcode = s3;
        gender = s4;
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
            j = 11;
        }
        super.pack(j, packer);
        packer.pack(prefilledZip);
        packer.pack(email);
        packer.pack(zipcode);
        packer.pack(gender);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        prefilledZip = "";
        email = "";
        zipcode = "";
        gender = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("Onboard")).append("[").append(prefilledZip).append(",").append(email).append(",").append(zipcode).append(",").append(gender).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
