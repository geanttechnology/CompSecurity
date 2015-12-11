// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.lang.reflect.Method;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage, Message, ProtocolMessageEnum

public static final class Retriever
{

    private Retriever descriptorRetriever;
    private final Method enumGetValueDescriptor;
    private final Method enumValueOf;
    private final Message messageDefaultInstance;
    private final Class singularType;

    private Retriever(Retriever retriever, Class class1, Message message)
    {
        if (com/google/protobuf/Message.isAssignableFrom(class1) && !class1.isInstance(message))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Bad messageDefaultInstance for ").append(class1.getName()).toString());
        }
        descriptorRetriever = retriever;
        singularType = class1;
        messageDefaultInstance = message;
        if (com/google/protobuf/ProtocolMessageEnum.isAssignableFrom(class1))
        {
            enumValueOf = GeneratedMessage.access$1300(class1, "valueOf", new Class[] {
                com/google/protobuf/Descriptors$EnumValueDescriptor
            });
            enumGetValueDescriptor = GeneratedMessage.access$1300(class1, "getValueDescriptor", new Class[0]);
            return;
        } else
        {
            enumValueOf = null;
            enumGetValueDescriptor = null;
            return;
        }
    }

    Retriever(Retriever retriever, Class class1, Message message, Retriever retriever1)
    {
        this(retriever, class1, message);
    }
}
