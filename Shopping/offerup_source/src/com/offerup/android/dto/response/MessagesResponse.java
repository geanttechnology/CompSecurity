// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import com.offerup.android.dto.Blocked;
import java.util.List;

// Referenced classes of package com.offerup.android.dto.response:
//            BaseResponse

public class MessagesResponse extends BaseResponse
{

    LocalData data;

    public MessagesResponse()
    {
    }

    public Blocked getBlocked()
    {
        if (data != null)
        {
            return data.getBlocked();
        } else
        {
            return null;
        }
    }

    public List getMessages()
    {
        if (data != null)
        {
            return data.getMessages();
        } else
        {
            return null;
        }
    }

    private class LocalData
    {

        Blocked blocked;
        List messages;
        final MessagesResponse this$0;

        public Blocked getBlocked()
        {
            return blocked;
        }

        public List getMessages()
        {
            return messages;
        }

        private LocalData()
        {
            this$0 = MessagesResponse.this;
            super();
        }
    }

}
