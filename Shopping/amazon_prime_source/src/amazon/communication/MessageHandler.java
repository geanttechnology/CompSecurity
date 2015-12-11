// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;

import amazon.communication.identity.EndpointIdentity;

// Referenced classes of package amazon.communication:
//            Message

public interface MessageHandler
{

    public abstract void onMessage(EndpointIdentity endpointidentity, Message message);
}
