// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class ABTest extends MobileFunnelEvent
{

    public String context;
    public String extraInfo;
    public String scope;
    public String testName;
    public String treatment;

    public ABTest()
    {
        testName = "";
        context = "";
        treatment = "";
        scope = "";
        extraInfo = "";
        eventType = "GRP15";
    }

    public ABTest(String s, String s1, String s2, String s3, String s4, EncodedNSTField encodednstfield)
    {
        super("GRP15", s);
        testName = "";
        context = "";
        treatment = "";
        scope = "";
        extraInfo = "";
        testName = s1;
        context = s2;
        treatment = s3;
        scope = s4;
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
        packer.pack(testName);
        packer.pack(context);
        packer.pack(treatment);
        packer.pack(scope);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        testName = "";
        context = "";
        treatment = "";
        scope = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("ABTest")).append("[").append(testName).append(",").append(context).append(",").append(treatment).append(",").append(scope).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
