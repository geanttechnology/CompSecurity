// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class PushNotification extends MobileFunnelEvent
{

    public long expiration;
    public String extraInfo;
    public String fullUrl;
    public String marketingText;
    public String nid;

    public PushNotification()
    {
        marketingText = "";
        fullUrl = "";
        nid = "";
        extraInfo = "";
        eventType = "GRP18";
    }

    public PushNotification(String s, String s1, String s2, String s3, long l, EncodedNSTField encodednstfield)
    {
        super("GRP18", s);
        marketingText = "";
        fullUrl = "";
        nid = "";
        extraInfo = "";
        marketingText = s1;
        fullUrl = s2;
        nid = s3;
        expiration = l;
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
        packer.pack(marketingText);
        packer.pack(fullUrl);
        packer.pack(nid);
        packer.pack(expiration);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        marketingText = "";
        fullUrl = "";
        nid = "";
        expiration = 0L;
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("PushNotification")).append("[").append(marketingText).append(",").append(fullUrl).append(",").append(nid).append(",").append(expiration).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
