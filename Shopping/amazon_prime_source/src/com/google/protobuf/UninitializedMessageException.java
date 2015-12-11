// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.protobuf:
//            InvalidProtocolBufferException, MessageLite

public class UninitializedMessageException extends RuntimeException
{

    private final List missingFields;

    public UninitializedMessageException(MessageLite messagelite)
    {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        missingFields = null;
    }

    public UninitializedMessageException(List list)
    {
        super(buildDescription(list));
        missingFields = list;
    }

    private static String buildDescription(List list)
    {
        StringBuilder stringbuilder = new StringBuilder("Message missing required fields: ");
        list = list.iterator();
        boolean flag = true;
        while (list.hasNext()) 
        {
            String s = (String)list.next();
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(s);
        }
        return stringbuilder.toString();
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException()
    {
        return new InvalidProtocolBufferException(getMessage());
    }
}
