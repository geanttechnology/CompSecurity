// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import java.util.Date;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

public static interface 
{

    public abstract void chatSessionClosed();

    public abstract void chatSessionCreated();

    public abstract void chatSessionEnded();

    public abstract void chatSessionStarted();

    public abstract void messageArrived(String s, String s1, Date date);

    public abstract void operatorTyping();
}
