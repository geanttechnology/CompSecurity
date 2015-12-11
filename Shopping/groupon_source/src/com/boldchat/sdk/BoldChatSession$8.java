// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.UnavailableReason;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

static class eReason
{

    static final int $SwitchMap$com$boldchat$visitor$api$UnavailableReason[];

    static 
    {
        $SwitchMap$com$boldchat$visitor$api$UnavailableReason = new int[UnavailableReason.values().length];
        try
        {
            $SwitchMap$com$boldchat$visitor$api$UnavailableReason[UnavailableReason.Unsecure.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
    }
}
