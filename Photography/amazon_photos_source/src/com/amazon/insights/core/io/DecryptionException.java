// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.io;

import java.io.IOException;

public class DecryptionException extends IOException
{

    public DecryptionException(Exception exception)
    {
        super(exception.toString());
    }
}
