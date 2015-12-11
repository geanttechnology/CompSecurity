// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import com.offerup.android.dto.response.BaseResponse;

// Referenced classes of package com.offerup.android.dto:
//            Message

public class MessagingResponse extends BaseResponse
{

    private Data data;

    public MessagingResponse()
    {
    }

    public Message getMessage()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.getMessage();
        }
    }

    private class Data
    {

        Message message;

        public Message getMessage()
        {
            return message;
        }

        private Data()
        {
        }
    }

}
