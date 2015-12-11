// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class DealSearch extends MobileFunnelEvent
{

    public String channel;
    public String extraInfo;
    public float lat;
    public String locationType;
    public float lon;
    public String parameter;
    public int responseCount;
    public String searchCategory;
    public String searchSource;

    public DealSearch()
    {
        channel = "";
        parameter = "";
        searchSource = "";
        searchCategory = "";
        locationType = "";
        extraInfo = "";
        eventType = "GRP1";
    }

    public DealSearch(String s, String s1, String s2, String s3, String s4, float f, float f1, 
            String s5, int i, EncodedNSTField encodednstfield)
    {
        super("GRP1", s);
        channel = "";
        parameter = "";
        searchSource = "";
        searchCategory = "";
        locationType = "";
        extraInfo = "";
        channel = s1;
        parameter = s2;
        searchSource = s3;
        searchCategory = s4;
        lat = f;
        lon = f1;
        locationType = s5;
        responseCount = i;
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
            j = 15;
        }
        super.pack(j, packer);
        packer.pack(channel);
        packer.pack(parameter);
        packer.pack(searchSource);
        packer.pack(searchCategory);
        packer.pack(lat);
        packer.pack(lon);
        packer.pack(locationType);
        packer.pack(responseCount);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        channel = "";
        parameter = "";
        searchSource = "";
        searchCategory = "";
        lat = 0.0F;
        lon = 0.0F;
        locationType = "";
        responseCount = 0;
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("DealSearch")).append("[").append(channel).append(",").append(parameter).append(",").append(searchSource).append(",").append(searchCategory).append(",").append(lat).append(",").append(lon).append(",").append(locationType).append(",").append(responseCount).append(",").append(extraInfo).append(",").append("]").toString();
    }
}
