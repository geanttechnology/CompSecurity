// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;


// Referenced classes of package co.vine.android.api:
//            VinePagedData, VineParsers

public static class lastMessage extends VinePagedData
{

    public long lastMessage;
    public long lastMessageRead;
    public int networkType;
    public long unreadMessageCount;

    public ()
    {
        unreadMessageCount = 0L;
        lastMessageRead = 0L;
        lastMessage = 0L;
    }
}
