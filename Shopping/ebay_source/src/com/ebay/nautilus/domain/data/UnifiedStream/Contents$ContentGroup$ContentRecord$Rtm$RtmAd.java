// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents

public static final class Summary
{
    public static final class Details
    {

        public GoogleDfpCampaign googleDfpCampaign;

        public Details()
        {
        }
    }

    public static final class Details.GoogleDfpCampaign
    {

        public int adSizeHeight;
        public int adSizeWidth;
        public String adUnitId;
        public Parameters parameters;
        public String ppid;
        public boolean userTargetedFlag;

        public Details.GoogleDfpCampaign()
        {
        }
    }

    public static final class Details.GoogleDfpCampaign.Parameters
    {

        public List parameters;

        public Details.GoogleDfpCampaign.Parameters()
        {
        }
    }

    public static final class Summary
    {

        public String clickId;
        public String rtmTrackingUrl;
        public String subtitle;
        public String thumbnailUrl;
        public String title;

        public Summary()
        {
        }
    }


    public Details details;
    public Summary summary;

    public Summary()
    {
    }
}
