// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.PersonType;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatListViewHistory

static class 
{

    static final int $SwitchMap$com$boldchat$visitor$api$PersonType[];

    static 
    {
        $SwitchMap$com$boldchat$visitor$api$PersonType = new int[PersonType.values().length];
        try
        {
            $SwitchMap$com$boldchat$visitor$api$PersonType[PersonType.Operator.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$boldchat$visitor$api$PersonType[PersonType.Visitor.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
