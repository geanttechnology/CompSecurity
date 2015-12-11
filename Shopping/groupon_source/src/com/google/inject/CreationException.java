// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject;

import com.google.inject.internal.Errors;
import java.util.Collection;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

public class CreationException extends RuntimeException
{

    private static final long serialVersionUID = 0L;
    private final ImmutableSet messages;

    public CreationException(Collection collection)
    {
        messages = ImmutableSet.copyOf(collection);
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

    public Collection getErrorMessages()
    {
        return messages;
    }

    public String getMessage()
    {
        return Errors.format("Unable to create injector, see the following errors", messages);
    }
}
