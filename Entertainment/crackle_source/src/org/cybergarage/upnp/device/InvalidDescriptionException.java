// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.device;

import java.io.File;

public class InvalidDescriptionException extends Exception
{

    public InvalidDescriptionException()
    {
    }

    public InvalidDescriptionException(Exception exception)
    {
        super(exception.getMessage());
    }

    public InvalidDescriptionException(String s)
    {
        super(s);
    }

    public InvalidDescriptionException(String s, File file)
    {
        super((new StringBuilder(String.valueOf(s))).append(" (").append(file.toString()).append(")").toString());
    }
}
