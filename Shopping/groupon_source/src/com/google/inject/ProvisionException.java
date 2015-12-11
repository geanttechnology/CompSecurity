// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.spi.Message;
import java.util.Collection;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

public final class ProvisionException extends RuntimeException
{

    private static final long serialVersionUID = 0L;
    private final ImmutableSet messages;

    public ProvisionException(Iterable iterable)
    {
        messages = ImmutableSet.copyOf(iterable);
        boolean flag;
        if (!messages.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        initCause(Errors.getOnlyCause(messages));
    }

    public ProvisionException(String s)
    {
        messages = ImmutableSet.of(new Message(s));
    }

    public ProvisionException(String s, Throwable throwable)
    {
        super(throwable);
        messages = ImmutableSet.of(new Message(s, throwable));
    }

    public Collection getErrorMessages()
    {
        return messages;
    }

    public String getMessage()
    {
        return Errors.format("Unable to provision, see the following errors", messages);
    }
}
