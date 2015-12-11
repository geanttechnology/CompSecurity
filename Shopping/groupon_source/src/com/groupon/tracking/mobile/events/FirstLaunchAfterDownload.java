// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class FirstLaunchAfterDownload extends MobileFunnelEvent
{

    public String attributedInstall;
    public String attributionDownloadId;
    public String downloadCid;
    public String extraInfo;
    public String fullUrl;

    public FirstLaunchAfterDownload()
    {
        fullUrl = "";
        attributionDownloadId = "";
        downloadCid = "";
        attributedInstall = "";
        extraInfo = "";
        eventType = "GRP10";
    }

    public FirstLaunchAfterDownload(String s, String s1, String s2, String s3, String s4, EncodedNSTField encodednstfield)
    {
        super("GRP10", s);
        fullUrl = "";
        attributionDownloadId = "";
        downloadCid = "";
        attributedInstall = "";
        extraInfo = "";
        fullUrl = s1;
        attributionDownloadId = s2;
        downloadCid = s3;
        attributedInstall = s4;
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
        packer.pack(fullUrl);
        packer.pack(attributionDownloadId);
        packer.pack(downloadCid);
        packer.pack(attributedInstall);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        fullUrl = "";
        attributionDownloadId = "";
        downloadCid = "";
        attributedInstall = "";
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("FirstLaunchAfterDownload")).append("[").append(fullUrl).append(",").append(attributionDownloadId).append(",").append(downloadCid).append(",").append(attributedInstall).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
