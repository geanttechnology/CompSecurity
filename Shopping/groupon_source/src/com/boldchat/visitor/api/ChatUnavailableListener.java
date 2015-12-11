// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;


// Referenced classes of package com.boldchat.visitor.api:
//            UnavailableForm

public interface ChatUnavailableListener
{

    public abstract void onChatUnavailable(UnavailableForm unavailableform);

    public abstract void onChatUnavailableFailed(int i, String s);
}
