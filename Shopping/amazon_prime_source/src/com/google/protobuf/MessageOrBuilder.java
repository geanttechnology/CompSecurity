// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.Map;

// Referenced classes of package com.google.protobuf:
//            MessageLiteOrBuilder, Message, UnknownFieldSet

public interface MessageOrBuilder
    extends MessageLiteOrBuilder
{

    public abstract Map getAllFields();

    public abstract Message getDefaultInstanceForType();

    public abstract Descriptors.Descriptor getDescriptorForType();

    public abstract Object getField(Descriptors.FieldDescriptor fielddescriptor);

    public abstract UnknownFieldSet getUnknownFields();

    public abstract boolean hasField(Descriptors.FieldDescriptor fielddescriptor);
}
