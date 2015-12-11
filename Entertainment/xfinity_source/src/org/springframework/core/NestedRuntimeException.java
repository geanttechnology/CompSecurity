// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.core;


// Referenced classes of package org.springframework.core:
//            NestedExceptionUtils

public abstract class NestedRuntimeException extends RuntimeException
{

    public NestedRuntimeException(String s)
    {
        super(s);
    }

    public NestedRuntimeException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public String getMessage()
    {
        return NestedExceptionUtils.buildMessage(super.getMessage(), getCause());
    }

    static 
    {
        org/springframework/core/NestedExceptionUtils.getName();
    }
}
