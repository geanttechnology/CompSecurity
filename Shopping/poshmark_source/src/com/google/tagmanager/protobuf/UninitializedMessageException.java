// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.tagmanager.protobuf:
//            InvalidProtocolBufferException, MessageLite

public class UninitializedMessageException extends RuntimeException
{

    private static final long serialVersionUID = 0x986022c4d65db14dL;
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
        boolean flag = true;
        list = list.iterator();
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

    public List getMissingFields()
    {
        return Collections.unmodifiableList(missingFields);
    }
}
