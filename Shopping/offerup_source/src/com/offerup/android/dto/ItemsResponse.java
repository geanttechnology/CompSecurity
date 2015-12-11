// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import com.offerup.android.dto.response.BaseResponse;
import java.util.List;

public class ItemsResponse extends BaseResponse
{

    Data data;

    public ItemsResponse()
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

    public int getTotal()
    {
        if (data == null)
        {
            return 0;
        } else
        {
            return data.getTotal();
        }
    }

    private class Data
    {

        List items;
        int total;

        public List getItems()
        {
            return items;
        }

        public int getTotal()
        {
            return total;
        }

        private Data()
        {
        }
    }

}
