// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            MessageOrBuilder, Message, InvalidProtocolBufferException, ByteString, 
//            ExtensionRegistryLite, UnknownFieldSet

public static interface dDescriptor
    extends der, MessageOrBuilder
{

    public abstract dDescriptor addRepeatedField(dDescriptor ddescriptor, Object obj);

    public abstract Message build();

    public abstract Message buildPartial();

    public abstract riptor getDescriptorForType();

    public abstract yLite mergeFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException;

    public abstract ufferException mergeFrom(Message message);

    public abstract dDescriptor newBuilderForField(dDescriptor ddescriptor);

    public abstract dDescriptor setField(dDescriptor ddescriptor, Object obj);

    public abstract dDescriptor setUnknownFields(UnknownFieldSet unknownfieldset);
}
