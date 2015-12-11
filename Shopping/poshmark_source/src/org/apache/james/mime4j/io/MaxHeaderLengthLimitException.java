// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.io;

import org.apache.james.mime4j.MimeException;

public class MaxHeaderLengthLimitException extends MimeException
{

    private static final long serialVersionUID = 0x7bd9732624cdd7f9L;

    public MaxHeaderLengthLimitException(String s)
    {
        super(s);
    }
}
