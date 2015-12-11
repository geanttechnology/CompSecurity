// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.protobuf:
//            AbstractMessage, FieldSet, UnknownFieldSet, Message, 
//            Parser, CodedOutputStream, MessageLite, AbstractParser, 
//            InvalidProtocolBufferException, CodedInputStream, ExtensionRegistryLite

public final class DynamicMessage extends AbstractMessage
{
    public static final class Builder extends AbstractMessage.Builder
    {

        private FieldSet fields;
        private final Descriptors.Descriptor type;
        private UnknownFieldSet unknownFields;

        private void ensureIsMutable()
        {
            if (fields.isImmutable())
            {
                fields = fields.clone();
            }
        }

        private void verifyContainingType(Descriptors.FieldDescriptor fielddescriptor)
        {
            if (fielddescriptor.getContainingType() != type)
            {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            } else
            {
                return;
            }
        }

        public Builder addRepeatedField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            verifyContainingType(fielddescriptor);
            ensureIsMutable();
            fields.addRepeatedField(fielddescriptor, obj);
            return this;
        }

        public volatile Message.Builder addRepeatedField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            return addRepeatedField(fielddescriptor, obj);
        }

        public DynamicMessage build()
        {
            if (!isInitialized())
            {
                throw newUninitializedMessageException(new DynamicMessage(type, fields, unknownFields));
            } else
            {
                return buildPartial();
            }
        }

        public volatile Message build()
        {
            return build();
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public DynamicMessage buildPartial()
        {
            fields.makeImmutable();
            return new DynamicMessage(type, fields, unknownFields);
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public Builder clear()
        {
            if (fields.isImmutable())
            {
                fields = FieldSet.newFieldSet();
            } else
            {
                fields.clear();
            }
            unknownFields = UnknownFieldSet.getDefaultInstance();
            return this;
        }

        public volatile Message.Builder clear()
        {
            return clear();
        }

        public volatile MessageLite.Builder clear()
        {
            return clear();
        }

        public Builder clearField(Descriptors.FieldDescriptor fielddescriptor)
        {
            verifyContainingType(fielddescriptor);
            ensureIsMutable();
            fields.clearField(fielddescriptor);
            return this;
        }

        public volatile Message.Builder clearField(Descriptors.FieldDescriptor fielddescriptor)
        {
            return clearField(fielddescriptor);
        }

        public volatile AbstractMessage.Builder clone()
        {
            return clone();
        }

        public volatile AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public Builder clone()
        {
            Builder builder = new Builder(type);
            builder.fields.mergeFrom(fields);
            builder.mergeUnknownFields(unknownFields);
            return builder;
        }

        public volatile Message.Builder clone()
        {
            return clone();
        }

        public volatile MessageLite.Builder clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public Map getAllFields()
        {
            return fields.getAllFields();
        }

        public DynamicMessage getDefaultInstanceForType()
        {
            return DynamicMessage.getDefaultInstance(type);
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return type;
        }

        public Object getField(Descriptors.FieldDescriptor fielddescriptor)
        {
label0:
            {
                verifyContainingType(fielddescriptor);
                Object obj1 = fields.getField(fielddescriptor);
                Object obj = obj1;
                if (obj1 == null)
                {
                    if (fielddescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE)
                    {
                        break label0;
                    }
                    obj = DynamicMessage.getDefaultInstance(fielddescriptor.getMessageType());
                }
                return obj;
            }
            return fielddescriptor.getDefaultValue();
        }

        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor fielddescriptor)
        {
            throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
        }

        public UnknownFieldSet getUnknownFields()
        {
            return unknownFields;
        }

        public boolean hasField(Descriptors.FieldDescriptor fielddescriptor)
        {
            verifyContainingType(fielddescriptor);
            return fields.hasField(fielddescriptor);
        }

        public boolean isInitialized()
        {
            return DynamicMessage.isInitialized(type, fields);
        }

        public volatile AbstractMessage.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DynamicMessage)
            {
                message = (DynamicMessage)message;
                if (((DynamicMessage) (message)).type != type)
                {
                    throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
                } else
                {
                    ensureIsMutable();
                    fields.mergeFrom(((DynamicMessage) (message)).fields);
                    mergeUnknownFields(((DynamicMessage) (message)).unknownFields);
                    return this;
                }
            } else
            {
                return (Builder)super.mergeFrom(message);
            }
        }

        public volatile Message.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet unknownfieldset)
        {
            return mergeUnknownFields(unknownfieldset);
        }

        public Builder mergeUnknownFields(UnknownFieldSet unknownfieldset)
        {
            unknownFields = UnknownFieldSet.newBuilder(unknownFields).mergeFrom(unknownfieldset).build();
            return this;
        }

        public volatile Message.Builder mergeUnknownFields(UnknownFieldSet unknownfieldset)
        {
            return mergeUnknownFields(unknownfieldset);
        }

        public Builder newBuilderForField(Descriptors.FieldDescriptor fielddescriptor)
        {
            verifyContainingType(fielddescriptor);
            if (fielddescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE)
            {
                throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
            } else
            {
                return new Builder(fielddescriptor.getMessageType());
            }
        }

        public volatile Message.Builder newBuilderForField(Descriptors.FieldDescriptor fielddescriptor)
        {
            return newBuilderForField(fielddescriptor);
        }

        public Builder setField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            verifyContainingType(fielddescriptor);
            ensureIsMutable();
            fields.setField(fielddescriptor, obj);
            return this;
        }

        public volatile Message.Builder setField(Descriptors.FieldDescriptor fielddescriptor, Object obj)
        {
            return setField(fielddescriptor, obj);
        }

        public Builder setUnknownFields(UnknownFieldSet unknownfieldset)
        {
            unknownFields = unknownfieldset;
            return this;
        }

        public volatile Message.Builder setUnknownFields(UnknownFieldSet unknownfieldset)
        {
            return setUnknownFields(unknownfieldset);
        }

        private Builder(Descriptors.Descriptor descriptor)
        {
            type = descriptor;
            fields = FieldSet.newFieldSet();
            unknownFields = UnknownFieldSet.getDefaultInstance();
        }

    }


    private final FieldSet fields;
    private int memoizedSize;
    private final Descriptors.Descriptor type;
    private final UnknownFieldSet unknownFields;

    private DynamicMessage(Descriptors.Descriptor descriptor, FieldSet fieldset, UnknownFieldSet unknownfieldset)
    {
        memoizedSize = -1;
        type = descriptor;
        fields = fieldset;
        unknownFields = unknownfieldset;
    }


    public static DynamicMessage getDefaultInstance(Descriptors.Descriptor descriptor)
    {
        return new DynamicMessage(descriptor, FieldSet.emptySet(), UnknownFieldSet.getDefaultInstance());
    }

    private static boolean isInitialized(Descriptors.Descriptor descriptor, FieldSet fieldset)
    {
        for (descriptor = descriptor.getFields().iterator(); descriptor.hasNext();)
        {
            Descriptors.FieldDescriptor fielddescriptor = (Descriptors.FieldDescriptor)descriptor.next();
            if (fielddescriptor.isRequired() && !fieldset.hasField(fielddescriptor))
            {
                return false;
            }
        }

        return fieldset.isInitialized();
    }

    public static Builder newBuilder(Descriptors.Descriptor descriptor)
    {
        return new Builder(descriptor);
    }

    private void verifyContainingType(Descriptors.FieldDescriptor fielddescriptor)
    {
        if (fielddescriptor.getContainingType() != type)
        {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        } else
        {
            return;
        }
    }

    public Map getAllFields()
    {
        return fields.getAllFields();
    }

    public DynamicMessage getDefaultInstanceForType()
    {
        return getDefaultInstance(type);
    }

    public volatile Message getDefaultInstanceForType()
    {
        return getDefaultInstanceForType();
    }

    public Descriptors.Descriptor getDescriptorForType()
    {
        return type;
    }

    public Object getField(Descriptors.FieldDescriptor fielddescriptor)
    {
label0:
        {
            verifyContainingType(fielddescriptor);
            Object obj1 = fields.getField(fielddescriptor);
            Object obj = obj1;
            if (obj1 == null)
            {
                if (!fielddescriptor.isRepeated())
                {
                    break label0;
                }
                obj = Collections.emptyList();
            }
            return obj;
        }
        if (fielddescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        {
            return getDefaultInstance(fielddescriptor.getMessageType());
        } else
        {
            return fielddescriptor.getDefaultValue();
        }
    }

    public Parser getParserForType()
    {
        return new AbstractParser() {

            final DynamicMessage this$0;

            public DynamicMessage parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                Builder builder = DynamicMessage.newBuilder(type);
                try
                {
                    builder.mergeFrom(codedinputstream, extensionregistrylite);
                }
                // Misplaced declaration of an exception variable
                catch (CodedInputStream codedinputstream)
                {
                    throw codedinputstream.setUnfinishedMessage(builder.buildPartial());
                }
                // Misplaced declaration of an exception variable
                catch (CodedInputStream codedinputstream)
                {
                    throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(builder.buildPartial());
                }
                return builder.buildPartial();
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

            
            {
                this$0 = DynamicMessage.this;
                super();
            }
        };
    }

    public int getSerializedSize()
    {
        int i = memoizedSize;
        if (i != -1)
        {
            return i;
        }
        if (type.getOptions().getMessageSetWireFormat())
        {
            i = fields.getMessageSetSerializedSize() + unknownFields.getSerializedSizeAsMessageSet();
        } else
        {
            i = fields.getSerializedSize() + unknownFields.getSerializedSize();
        }
        memoizedSize = i;
        return i;
    }

    public UnknownFieldSet getUnknownFields()
    {
        return unknownFields;
    }

    public boolean hasField(Descriptors.FieldDescriptor fielddescriptor)
    {
        verifyContainingType(fielddescriptor);
        return fields.hasField(fielddescriptor);
    }

    public boolean isInitialized()
    {
        return isInitialized(type, fields);
    }

    public Builder newBuilderForType()
    {
        return new Builder(type);
    }

    public volatile Message.Builder newBuilderForType()
    {
        return newBuilderForType();
    }

    public Builder toBuilder()
    {
        return newBuilderForType().mergeFrom(this);
    }

    public volatile Message.Builder toBuilder()
    {
        return toBuilder();
    }

    public volatile MessageLite.Builder toBuilder()
    {
        return toBuilder();
    }

    public void writeTo(CodedOutputStream codedoutputstream)
        throws IOException
    {
        if (type.getOptions().getMessageSetWireFormat())
        {
            fields.writeMessageSetTo(codedoutputstream);
            unknownFields.writeAsMessageSetTo(codedoutputstream);
            return;
        } else
        {
            fields.writeTo(codedoutputstream);
            unknownFields.writeTo(codedoutputstream);
            return;
        }
    }




}
