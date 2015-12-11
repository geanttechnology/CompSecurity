// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;


// Referenced classes of package co.vine.android.service:
//            RealTimeChatService

public static class lastMessageId
{

    private boolean connected;
    private long lastMessageId;
    private boolean typing;

    public lastMessageId build()
    {
        return new lastMessageId(this, null);
    }

    public lastMessageId setConnected()
    {
        connected = true;
        return this;
    }

    public connected setLastMessageId(long l)
    {
        lastMessageId = l;
        return this;
    }

    public lastMessageId setTyping(boolean flag)
    {
        typing = flag;
        return this;
    }




    public ()
    {
        connected = false;
        typing = false;
        lastMessageId = 0L;
    }
}
