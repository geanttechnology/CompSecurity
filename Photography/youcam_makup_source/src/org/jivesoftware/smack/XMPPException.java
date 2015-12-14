// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;


public abstract class XMPPException extends Exception
{

    private static final long serialVersionUID = 0x5f8089b3520ec431L;

    protected XMPPException()
    {
    }

    protected XMPPException(String s)
    {
        super(s);
    }
}
