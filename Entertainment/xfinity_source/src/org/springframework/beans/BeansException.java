// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.beans;

import org.springframework.core.NestedRuntimeException;
import org.springframework.util.ObjectUtils;

public abstract class BeansException extends NestedRuntimeException
{

    public BeansException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof BeansException))
            {
                return false;
            }
            obj = (BeansException)obj;
            if (!getMessage().equals(((BeansException) (obj)).getMessage()) || !ObjectUtils.nullSafeEquals(getCause(), ((BeansException) (obj)).getCause()))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return getMessage().hashCode();
    }
}
