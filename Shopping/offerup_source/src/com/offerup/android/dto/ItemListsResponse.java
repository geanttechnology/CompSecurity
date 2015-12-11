// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import com.offerup.android.dto.response.BaseResponse;
import java.util.List;

public class ItemListsResponse extends BaseResponse
{

    Data data;

    public ItemListsResponse()
    {
    }

    public List getItemLists()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.getItemLists();
        }
    }

    public boolean isSuccess()
    {
        if (getItemLists() == null || getItemLists().size() == 0)
        {
            return false;
        } else
        {
            return super.isSuccess();
        }
    }

    private class Data
    {

        List itemLists;

        public List getItemLists()
        {
            return itemLists;
        }

        public Data()
        {
        }
    }

}
