// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.io;

import org.apache.james.mime4j.MimeException;

public class MaxHeaderLimitException extends MimeException
{

    private static final long serialVersionUID = 0x1de5804864f14e11L;

    public MaxHeaderLimitException(String s)
    {
        super(s);
    }
}
