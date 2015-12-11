// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import com.offerup.android.dto.Blocked;
import java.util.List;

// Referenced classes of package com.offerup.android.dto.response:
//            MessagesResponse

class this._cls0
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

    private A()
    {
        this$0 = MessagesResponse.this;
        super();
    }
}
