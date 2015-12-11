// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import java.util.List;

// Referenced classes of package com.offerup.android.dto.response:
//            BaseResponse

public class DiscussionsResponse extends BaseResponse
{

    LocalData data;

    public DiscussionsResponse()
    {
    }

    public List getDiscussions()
    {
        if (data != null)
        {
            return data.getDiscussions();
        } else
        {
            return null;
        }
    }

    private class LocalData
    {

        List discussions;
        final DiscussionsResponse this$0;

        public List getDiscussions()
        {
            return discussions;
        }

        private LocalData()
        {
            this$0 = DiscussionsResponse.this;
            super();
        }
    }

}
