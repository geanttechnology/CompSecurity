// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import java.util.List;

// Referenced classes of package com.offerup.android.dto.response:
//            BaseResponse

public class UserWatchlistResponse extends BaseResponse
{

    Data data;

    public UserWatchlistResponse()
    {
    }

    public List getItems()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.getItems();
        }
    }

    private class Data
    {

        List items;

        public List getItems()
        {
            return items;
        }

        public Data()
        {
        }
    }

}
