// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import org.apache.james.mime4j.MimeException;

// Referenced classes of package org.apache.james.mime4j.stream:
//            Event

public class MimeParseEventException extends MimeException
{

    private static final long serialVersionUID = 0x404bb151428032ceL;
    private final Event event;

    public MimeParseEventException(Event event1)
    {
        super(event1.toString());
        event = event1;
    }

    public Event getEvent()
    {
        return event;
    }
}
