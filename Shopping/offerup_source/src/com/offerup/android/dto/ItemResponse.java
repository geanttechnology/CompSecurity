// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import com.offerup.android.dto.response.BaseResponse;

// Referenced classes of package com.offerup.android.dto:
//            Item

public class ItemResponse extends BaseResponse
{

    Data data;

    public ItemResponse()
    {
    }

    public Item getItem()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.getItem();
        }
    }

    public boolean isSuccess()
    {
        if (getItem() == null)
        {
            return false;
        } else
        {
            return super.isSuccess();
        }
    }

    private class Data
    {

        Item item;

        public Item getItem()
        {
            return item;
        }

        public Data()
        {
        }
    }

}
