// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.json.JSONObject;

// Referenced classes of package com.boldchat.visitor.api:
//            Form, Account, Chat

public class PostChat extends Form
{

    protected PostChat(Account account, Chat chat, JSONObject jsonobject)
    {
        super(jsonobject);
    }
}
