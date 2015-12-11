// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.identity.EndpointIdentity;

public class MessageIdentity
{

    protected final EndpointIdentity mEndpoint;
    private final int mMessageId;

    public MessageIdentity(EndpointIdentity endpointidentity, int i)
    {
        mEndpoint = endpointidentity;
        mMessageId = i;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (MessageIdentity)obj;
            if (mMessageId != ((MessageIdentity) (obj)).mMessageId || !mEndpoint.equals(((MessageIdentity) (obj)).mEndpoint))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return mEndpoint.hashCode() + mMessageId;
    }

    public String toString()
    {
        return (new StringBuilder()).append("MessageIdentity [endpoint=").append(EndpointIdentity.logSafe(mEndpoint)).append(", messageId=").append(mMessageId).append("]").toString();
    }
}
