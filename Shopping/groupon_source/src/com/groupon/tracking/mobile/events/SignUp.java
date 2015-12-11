// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class SignUp extends MobileFunnelEvent
{

    public String attributionDownloadId;
    public String attributionId;
    public long attributionTimeOverlap;
    public String attributionType;
    public String cid;
    public String downloadCid;
    public String extraInfo;

    public SignUp()
    {
        cid = "";
        attributionId = "";
        attributionType = "";
        attributionDownloadId = "";
        downloadCid = "";
        extraInfo = "";
        eventType = "GRP12";
    }

    public SignUp(String s, String s1, String s2, String s3, long l, String s4, 
            String s5, EncodedNSTField encodednstfield)
    {
        super("GRP12", s);
        cid = "";
        attributionId = "";
        attributionType = "";
        attributionDownloadId = "";
        downloadCid = "";
        extraInfo = "";
        cid = s1;
        attributionId = s2;
        attributionType = s3;
        attributionTimeOverlap = l;
        attributionDownloadId = s4;
        downloadCid = s5;
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
            j = 13;
        }
        super.pack(j, packer);
        packer.pack(cid);
        packer.pack(attributionId);
        packer.pack(attributionType);
        packer.pack(attributionTimeOverlap);
        packer.pack(attributionDownloadId);
        packer.pack(downloadCid);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        cid = "";
        attributionId = "";
        attributionType = "";
        attributionTimeOverlap = 0L;
        attributionDownloadId = "";
        downloadCid = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("SignUp")).append("[").append(cid).append(",").append(attributionId).append(",").append(attributionType).append(",").append(attributionTimeOverlap).append(",").append(attributionDownloadId).append(",").append(downloadCid).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
