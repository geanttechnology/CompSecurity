// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.connection;

import amazon.communication.CommunicationBaseException;

public class IllegalConnectionStateException extends CommunicationBaseException
{

    private int mState;

    public IllegalConnectionStateException(String s, int i)
    {
        super(s);
        mState = i;
    }
}
