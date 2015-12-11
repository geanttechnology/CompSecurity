// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            MessageLite, MessageOrBuilder, Parser, InvalidProtocolBufferException, 
//            ByteString, ExtensionRegistryLite, UnknownFieldSet

public interface Message
    extends MessageLite, MessageOrBuilder
{
    public static interface Builder
        extends MessageLite.Builder, MessageOrBuilder
    {

        public abstract Builder addRepeatedField(Descriptors.FieldDescriptor fielddescriptor, Object obj);

        public abstract Message build();

        public abstract Message buildPartial();

        public abstract Builder clearField(Descriptors.FieldDescriptor fielddescriptor);

        public abstract Descriptors.Descriptor getDescriptorForType();

        public abstract Builder mergeFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException;

        public abstract Builder mergeFrom(Message message);

        public abstract Builder newBuilderForField(Descriptors.FieldDescriptor fielddescriptor);

        public abstract Builder setField(Descriptors.FieldDescriptor fielddescriptor, Object obj);

        public abstract Builder setUnknownFields(UnknownFieldSet unknownfieldset);
    }


    public abstract Parser getParserForType();

    public abstract Builder newBuilderForType();

    public abstract Builder toBuilder();
}
