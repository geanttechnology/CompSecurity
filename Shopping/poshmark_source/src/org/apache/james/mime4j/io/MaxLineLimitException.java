// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.io;

import java.io.IOException;

public class MaxLineLimitException extends IOException
{

    private static final long serialVersionUID = 0x19c1ca7eb42b098aL;

    public MaxLineLimitException(String s)
    {
        super(s);
    }
}
