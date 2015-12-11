// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage, DescriptorProtos, ByteString, Internal, 
//            MessageLite, CodedOutputStream, UnknownFieldSet, Message, 
//            RepeatedFieldBuilder, CodedInputStream, ExtensionRegistryLite, MessageOrBuilder

public static final class memoizedSerializedSize extends GeneratedMessage
    implements rBuilder
{
    public static final class Builder extends GeneratedMessage.Builder
        implements DescriptorProtos.UninterpretedOptionOrBuilder
    {

        private Object aggregateValue_;
        private int bitField0_;
        private double doubleValue_;
        private Object identifierValue_;
        private RepeatedFieldBuilder nameBuilder_;
        private List name_;
        private long negativeIntValue_;
        private long positiveIntValue_;
        private ByteString stringValue_;

        private static Builder create()
        {
            return new Builder();
        }

        private void ensureNameIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                name_ = new ArrayList(name_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private RepeatedFieldBuilder getNameFieldBuilder()
        {
            boolean flag = true;
            if (nameBuilder_ == null)
            {
                List list = name_;
                if ((bitField0_ & 1) != 1)
                {
                    flag = false;
                }
                nameBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                name_ = null;
            }
            return nameBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getNameFieldBuilder();
            }
        }

        public Builder addName(NamePart namepart)
        {
            if (nameBuilder_ == null)
            {
                if (namepart == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureNameIsMutable();
                    name_.add(namepart);
                    onChanged();
                    return this;
                }
            } else
            {
                nameBuilder_.addMessage(namepart);
                return this;
            }
        }

        public DescriptorProtos.UninterpretedOption build()
        {
            DescriptorProtos.UninterpretedOption uninterpretedoption = buildPartial();
            if (!uninterpretedoption.isInitialized())
            {
                throw newUninitializedMessageException(uninterpretedoption);
            } else
            {
                return uninterpretedoption;
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

        public DescriptorProtos.UninterpretedOption buildPartial()
        {
            int j = 1;
            DescriptorProtos.UninterpretedOption uninterpretedoption = new DescriptorProtos.UninterpretedOption(this, null);
            int k = bitField0_;
            int i;
            if (nameBuilder_ == null)
            {
                if ((bitField0_ & 1) == 1)
                {
                    name_ = Collections.unmodifiableList(name_);
                    bitField0_ = bitField0_ & -2;
                }
                uninterpretedoption.name_ = name_;
            } else
            {
                uninterpretedoption.name_ = nameBuilder_.build();
            }
            if ((k & 2) != 2)
            {
                j = 0;
            }
            uninterpretedoption.identifierValue_ = identifierValue_;
            i = j;
            if ((k & 4) == 4)
            {
                i = j | 2;
            }
            uninterpretedoption.positiveIntValue_ = positiveIntValue_;
            j = i;
            if ((k & 8) == 8)
            {
                j = i | 4;
            }
            uninterpretedoption.negativeIntValue_ = negativeIntValue_;
            i = j;
            if ((k & 0x10) == 16)
            {
                i = j | 8;
            }
            uninterpretedoption.doubleValue_ = doubleValue_;
            j = i;
            if ((k & 0x20) == 32)
            {
                j = i | 0x10;
            }
            uninterpretedoption.stringValue_ = stringValue_;
            i = j;
            if ((k & 0x40) == 64)
            {
                i = j | 0x20;
            }
            uninterpretedoption.aggregateValue_ = aggregateValue_;
            uninterpretedoption.bitField0_ = i;
            onBuilt();
            return uninterpretedoption;
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
            super.clear();
            if (nameBuilder_ == null)
            {
                name_ = Collections.emptyList();
                bitField0_ = bitField0_ & -2;
            } else
            {
                nameBuilder_.clear();
            }
            identifierValue_ = "";
            bitField0_ = bitField0_ & -3;
            positiveIntValue_ = 0L;
            bitField0_ = bitField0_ & -5;
            negativeIntValue_ = 0L;
            bitField0_ = bitField0_ & -9;
            doubleValue_ = 0.0D;
            bitField0_ = bitField0_ & 0xffffffef;
            stringValue_ = ByteString.EMPTY;
            bitField0_ = bitField0_ & 0xffffffdf;
            aggregateValue_ = "";
            bitField0_ = bitField0_ & 0xffffffbf;
            return this;
        }

        public volatile GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile Message.Builder clear()
        {
            return clear();
        }

        public volatile MessageLite.Builder clear()
        {
            return clear();
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
            return create().mergeFrom(buildPartial());
        }

        public volatile GeneratedMessage.Builder clone()
        {
            return clone();
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

        public DescriptorProtos.UninterpretedOption getDefaultInstanceForType()
        {
            return DescriptorProtos.UninterpretedOption.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return DescriptorProtos.UninterpretedOption.getDescriptor();
        }

        public NamePart getName(int i)
        {
            if (nameBuilder_ == null)
            {
                return (NamePart)name_.get(i);
            } else
            {
                return (NamePart)nameBuilder_.getMessage(i);
            }
        }

        public int getNameCount()
        {
            if (nameBuilder_ == null)
            {
                return name_.size();
            } else
            {
                return nameBuilder_.getCount();
            }
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.access$16900();
        }

        public final boolean isInitialized()
        {
            for (int i = 0; i < getNameCount(); i++)
            {
                if (!getName(i).isInitialized())
                {
                    return false;
                }
            }

            return true;
        }

        public volatile AbstractMessage.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile AbstractMessage.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder(getUnknownFields());
            do
            {
                int i = codedinputstream.readTag();
                switch (i)
                {
                default:
                    if (!parseUnknownField(codedinputstream, builder, extensionregistrylite, i))
                    {
                        setUnknownFields(builder.build());
                        onChanged();
                        return this;
                    }
                    break;

                case 0: // '\0'
                    setUnknownFields(builder.build());
                    onChanged();
                    return this;

                case 18: // '\022'
                    NamePart.Builder builder1 = NamePart.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addName(builder1.buildPartial());
                    break;

                case 26: // '\032'
                    bitField0_ = bitField0_ | 2;
                    identifierValue_ = codedinputstream.readBytes();
                    break;

                case 32: // ' '
                    bitField0_ = bitField0_ | 4;
                    positiveIntValue_ = codedinputstream.readUInt64();
                    break;

                case 40: // '('
                    bitField0_ = bitField0_ | 8;
                    negativeIntValue_ = codedinputstream.readInt64();
                    break;

                case 49: // '1'
                    bitField0_ = bitField0_ | 0x10;
                    doubleValue_ = codedinputstream.readDouble();
                    break;

                case 58: // ':'
                    bitField0_ = bitField0_ | 0x20;
                    stringValue_ = codedinputstream.readBytes();
                    break;

                case 66: // 'B'
                    bitField0_ = bitField0_ | 0x40;
                    aggregateValue_ = codedinputstream.readBytes();
                    break;
                }
            } while (true);
        }

        public Builder mergeFrom(DescriptorProtos.UninterpretedOption uninterpretedoption)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (uninterpretedoption == DescriptorProtos.UninterpretedOption.getDefaultInstance())
            {
                return this;
            }
            if (nameBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!uninterpretedoption.name_.isEmpty())
            {
                if (name_.isEmpty())
                {
                    name_ = uninterpretedoption.name_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensureNameIsMutable();
                    name_.addAll(uninterpretedoption.name_);
                }
                onChanged();
            }
_L4:
            if (uninterpretedoption.hasIdentifierValue())
            {
                setIdentifierValue(uninterpretedoption.getIdentifierValue());
            }
            if (uninterpretedoption.hasPositiveIntValue())
            {
                setPositiveIntValue(uninterpretedoption.getPositiveIntValue());
            }
            if (uninterpretedoption.hasNegativeIntValue())
            {
                setNegativeIntValue(uninterpretedoption.getNegativeIntValue());
            }
            if (uninterpretedoption.hasDoubleValue())
            {
                setDoubleValue(uninterpretedoption.getDoubleValue());
            }
            if (uninterpretedoption.hasStringValue())
            {
                setStringValue(uninterpretedoption.getStringValue());
            }
            if (uninterpretedoption.hasAggregateValue())
            {
                setAggregateValue(uninterpretedoption.getAggregateValue());
            }
            mergeUnknownFields(uninterpretedoption.getUnknownFields());
            return this;
_L2:
            if (!uninterpretedoption.name_.isEmpty())
            {
                if (nameBuilder_.isEmpty())
                {
                    nameBuilder_.dispose();
                    nameBuilder_ = null;
                    name_ = uninterpretedoption.name_;
                    bitField0_ = bitField0_ & -2;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getNameFieldBuilder();
                    }
                    nameBuilder_ = repeatedfieldbuilder;
                } else
                {
                    nameBuilder_.addAllMessages(uninterpretedoption.name_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DescriptorProtos.UninterpretedOption)
            {
                return mergeFrom((DescriptorProtos.UninterpretedOption)message);
            } else
            {
                super.mergeFrom(message);
                return this;
            }
        }

        public volatile Message.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile Message.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Builder setAggregateValue(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x40;
                aggregateValue_ = s;
                onChanged();
                return this;
            }
        }

        public Builder setDoubleValue(double d)
        {
            bitField0_ = bitField0_ | 0x10;
            doubleValue_ = d;
            onChanged();
            return this;
        }

        public Builder setIdentifierValue(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                identifierValue_ = s;
                onChanged();
                return this;
            }
        }

        public Builder setNegativeIntValue(long l)
        {
            bitField0_ = bitField0_ | 8;
            negativeIntValue_ = l;
            onChanged();
            return this;
        }

        public Builder setPositiveIntValue(long l)
        {
            bitField0_ = bitField0_ | 4;
            positiveIntValue_ = l;
            onChanged();
            return this;
        }

        public Builder setStringValue(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x20;
                stringValue_ = bytestring;
                onChanged();
                return this;
            }
        }


        private Builder()
        {
            name_ = Collections.emptyList();
            identifierValue_ = "";
            stringValue_ = ByteString.EMPTY;
            aggregateValue_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = Collections.emptyList();
            identifierValue_ = "";
            stringValue_ = ByteString.EMPTY;
            aggregateValue_ = "";
            maybeForceBuilderInitialization();
        }

        Builder(GeneratedMessage.BuilderParent builderparent, DescriptorProtos._cls1 _pcls1)
        {
            this(builderparent);
        }
    }

    public static final class NamePart extends GeneratedMessage
        implements NamePartOrBuilder
    {

        private static final NamePart defaultInstance;
        private int bitField0_;
        private boolean isExtension_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object namePart_;

        public static NamePart getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.access$17000();
        }

        private ByteString getNamePartBytes()
        {
            Object obj = namePart_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                namePart_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private void initFields()
        {
            namePart_ = "";
            isExtension_ = false;
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(NamePart namepart)
        {
            return newBuilder().mergeFrom(namepart);
        }

        public NamePart getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public boolean getIsExtension()
        {
            return isExtension_;
        }

        public String getNamePart()
        {
            Object obj = namePart_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                namePart_ = s;
            }
            return s;
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            if ((bitField0_ & 1) == 1)
            {
                i = 0 + CodedOutputStream.computeBytesSize(1, getNamePartBytes());
            }
            int j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeBoolSize(2, isExtension_);
            }
            i = j + getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public boolean hasIsExtension()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasNamePart()
        {
            return (bitField0_ & 1) == 1;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.access$17100();
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            if (!hasNamePart())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIsExtension())
            {
                memoizedIsInitialized = 0;
                return false;
            } else
            {
                memoizedIsInitialized = 1;
                return true;
            }
        }

        public Builder newBuilderForType()
        {
            return newBuilder();
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent builderparent)
        {
            return new Builder(builderparent, null);
        }

        public volatile Message.Builder newBuilderForType()
        {
            return newBuilderForType();
        }

        protected volatile Message.Builder newBuilderForType(GeneratedMessage.BuilderParent builderparent)
        {
            return newBuilderForType(builderparent);
        }

        public Builder toBuilder()
        {
            return newBuilder(this);
        }

        public volatile MessageLite.Builder toBuilder()
        {
            return toBuilder();
        }

        protected Object writeReplace()
            throws ObjectStreamException
        {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedoutputstream)
            throws IOException
        {
            getSerializedSize();
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeBytes(1, getNamePartBytes());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBool(2, isExtension_);
            }
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new NamePart(true);
            defaultInstance.initFields();
        }


/*
        static Object access$17602(NamePart namepart, Object obj)
        {
            namepart.namePart_ = obj;
            return obj;
        }

*/


/*
        static boolean access$17702(NamePart namepart, boolean flag)
        {
            namepart.isExtension_ = flag;
            return flag;
        }

*/


/*
        static int access$17802(NamePart namepart, int i)
        {
            namepart.bitField0_ = i;
            return i;
        }

*/

        private NamePart(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }

        NamePart(Builder builder, DescriptorProtos._cls1 _pcls1)
        {
            this(builder);
        }

        private NamePart(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class NamePart.Builder extends GeneratedMessage.Builder
        implements NamePartOrBuilder
    {

        private int bitField0_;
        private boolean isExtension_;
        private Object namePart_;

        private static NamePart.Builder create()
        {
            return new NamePart.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
            if (!GeneratedMessage.alwaysUseFieldBuilders);
        }

        public NamePart build()
        {
            NamePart namepart = buildPartial();
            if (!namepart.isInitialized())
            {
                throw newUninitializedMessageException(namepart);
            } else
            {
                return namepart;
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

        public NamePart buildPartial()
        {
            int i = 1;
            NamePart namepart = new NamePart(this, null);
            int k = bitField0_;
            int j;
            if ((k & 1) != 1)
            {
                i = 0;
            }
            namepart.namePart_ = namePart_;
            j = i;
            if ((k & 2) == 2)
            {
                j = i | 2;
            }
            namepart.isExtension_ = isExtension_;
            namepart.bitField0_ = j;
            onBuilt();
            return namepart;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public NamePart.Builder clear()
        {
            super.clear();
            namePart_ = "";
            bitField0_ = bitField0_ & -2;
            isExtension_ = false;
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public volatile GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile Message.Builder clear()
        {
            return clear();
        }

        public volatile MessageLite.Builder clear()
        {
            return clear();
        }

        public volatile AbstractMessage.Builder clone()
        {
            return clone();
        }

        public volatile AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public NamePart.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile GeneratedMessage.Builder clone()
        {
            return clone();
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

        public NamePart getDefaultInstanceForType()
        {
            return NamePart.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return NamePart.getDescriptor();
        }

        public boolean hasIsExtension()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasNamePart()
        {
            return (bitField0_ & 1) == 1;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.access$17100();
        }

        public final boolean isInitialized()
        {
            while (!hasNamePart() || !hasIsExtension()) 
            {
                return false;
            }
            return true;
        }

        public volatile AbstractMessage.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile AbstractMessage.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public NamePart.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder(getUnknownFields());
            do
            {
                int i = codedinputstream.readTag();
                switch (i)
                {
                default:
                    if (!parseUnknownField(codedinputstream, builder, extensionregistrylite, i))
                    {
                        setUnknownFields(builder.build());
                        onChanged();
                        return this;
                    }
                    break;

                case 0: // '\0'
                    setUnknownFields(builder.build());
                    onChanged();
                    return this;

                case 10: // '\n'
                    bitField0_ = bitField0_ | 1;
                    namePart_ = codedinputstream.readBytes();
                    break;

                case 16: // '\020'
                    bitField0_ = bitField0_ | 2;
                    isExtension_ = codedinputstream.readBool();
                    break;
                }
            } while (true);
        }

        public NamePart.Builder mergeFrom(NamePart namepart)
        {
            if (namepart == NamePart.getDefaultInstance())
            {
                return this;
            }
            if (namepart.hasNamePart())
            {
                setNamePart(namepart.getNamePart());
            }
            if (namepart.hasIsExtension())
            {
                setIsExtension(namepart.getIsExtension());
            }
            mergeUnknownFields(namepart.getUnknownFields());
            return this;
        }

        public NamePart.Builder mergeFrom(Message message)
        {
            if (message instanceof NamePart)
            {
                return mergeFrom((NamePart)message);
            } else
            {
                super.mergeFrom(message);
                return this;
            }
        }

        public volatile Message.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile Message.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public NamePart.Builder setIsExtension(boolean flag)
        {
            bitField0_ = bitField0_ | 2;
            isExtension_ = flag;
            onChanged();
            return this;
        }

        public NamePart.Builder setNamePart(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                namePart_ = s;
                onChanged();
                return this;
            }
        }


        private NamePart.Builder()
        {
            namePart_ = "";
            maybeForceBuilderInitialization();
        }

        private NamePart.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            namePart_ = "";
            maybeForceBuilderInitialization();
        }

        NamePart.Builder(GeneratedMessage.BuilderParent builderparent, DescriptorProtos._cls1 _pcls1)
        {
            this(builderparent);
        }
    }

    public static interface NamePartOrBuilder
        extends MessageOrBuilder
    {
    }


    private static final initFields defaultInstance;
    private Object aggregateValue_;
    private int bitField0_;
    private double doubleValue_;
    private Object identifierValue_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List name_;
    private long negativeIntValue_;
    private long positiveIntValue_;
    private ByteString stringValue_;

    private ByteString getAggregateValueBytes()
    {
        Object obj = aggregateValue_;
        if (obj instanceof String)
        {
            obj = ByteString.copyFromUtf8((String)obj);
            aggregateValue_ = obj;
            return ((ByteString) (obj));
        } else
        {
            return (ByteString)obj;
        }
    }

    public static aggregateValue_ getDefaultInstance()
    {
        return defaultInstance;
    }

    public static final defaultInstance getDescriptor()
    {
        return DescriptorProtos.access$16800();
    }

    private ByteString getIdentifierValueBytes()
    {
        Object obj = identifierValue_;
        if (obj instanceof String)
        {
            obj = ByteString.copyFromUtf8((String)obj);
            identifierValue_ = obj;
            return ((ByteString) (obj));
        } else
        {
            return (ByteString)obj;
        }
    }

    private void initFields()
    {
        name_ = Collections.emptyList();
        identifierValue_ = "";
        positiveIntValue_ = 0L;
        negativeIntValue_ = 0L;
        doubleValue_ = 0.0D;
        stringValue_ = ByteString.EMPTY;
        aggregateValue_ = "";
    }

    public static Builder newBuilder()
    {
        return Builder.create();
    }

    public static Builder newBuilder(Builder.create create)
    {
        return newBuilder().mergeFrom(create);
    }

    public String getAggregateValue()
    {
        Object obj = aggregateValue_;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (ByteString)obj;
        String s = ((ByteString) (obj)).toStringUtf8();
        if (Internal.isValidUtf8(((ByteString) (obj))))
        {
            aggregateValue_ = s;
        }
        return s;
    }

    public aggregateValue_ getDefaultInstanceForType()
    {
        return defaultInstance;
    }

    public volatile Message getDefaultInstanceForType()
    {
        return getDefaultInstanceForType();
    }

    public double getDoubleValue()
    {
        return doubleValue_;
    }

    public String getIdentifierValue()
    {
        Object obj = identifierValue_;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (ByteString)obj;
        String s = ((ByteString) (obj)).toStringUtf8();
        if (Internal.isValidUtf8(((ByteString) (obj))))
        {
            identifierValue_ = s;
        }
        return s;
    }

    public NamePart getName(int i)
    {
        return (NamePart)name_.get(i);
    }

    public int getNameCount()
    {
        return name_.size();
    }

    public long getNegativeIntValue()
    {
        return negativeIntValue_;
    }

    public long getPositiveIntValue()
    {
        return positiveIntValue_;
    }

    public int getSerializedSize()
    {
        int i = memoizedSerializedSize;
        if (i != -1)
        {
            return i;
        }
        int j = 0;
        i = 0;
        for (; j < name_.size(); j++)
        {
            i += CodedOutputStream.computeMessageSize(2, (MessageLite)name_.get(j));
        }

        j = i;
        if ((bitField0_ & 1) == 1)
        {
            j = i + CodedOutputStream.computeBytesSize(3, getIdentifierValueBytes());
        }
        i = j;
        if ((bitField0_ & 2) == 2)
        {
            i = j + CodedOutputStream.computeUInt64Size(4, positiveIntValue_);
        }
        j = i;
        if ((bitField0_ & 4) == 4)
        {
            j = i + CodedOutputStream.computeInt64Size(5, negativeIntValue_);
        }
        i = j;
        if ((bitField0_ & 8) == 8)
        {
            i = j + CodedOutputStream.computeDoubleSize(6, doubleValue_);
        }
        j = i;
        if ((bitField0_ & 0x10) == 16)
        {
            j = i + CodedOutputStream.computeBytesSize(7, stringValue_);
        }
        i = j;
        if ((bitField0_ & 0x20) == 32)
        {
            i = j + CodedOutputStream.computeBytesSize(8, getAggregateValueBytes());
        }
        i = getUnknownFields().getSerializedSize() + i;
        memoizedSerializedSize = i;
        return i;
    }

    public ByteString getStringValue()
    {
        return stringValue_;
    }

    public boolean hasAggregateValue()
    {
        return (bitField0_ & 0x20) == 32;
    }

    public boolean hasDoubleValue()
    {
        return (bitField0_ & 8) == 8;
    }

    public boolean hasIdentifierValue()
    {
        return (bitField0_ & 1) == 1;
    }

    public boolean hasNegativeIntValue()
    {
        return (bitField0_ & 4) == 4;
    }

    public boolean hasPositiveIntValue()
    {
        return (bitField0_ & 2) == 2;
    }

    public boolean hasStringValue()
    {
        return (bitField0_ & 0x10) == 16;
    }

    protected bitField0_ internalGetFieldAccessorTable()
    {
        return DescriptorProtos.access$16900();
    }

    public final boolean isInitialized()
    {
        byte byte0 = memoizedIsInitialized;
        if (byte0 != -1)
        {
            return byte0 == 1;
        }
        for (int i = 0; i < getNameCount(); i++)
        {
            if (!getName(i).isInitialized())
            {
                memoizedIsInitialized = 0;
                return false;
            }
        }

        memoizedIsInitialized = 1;
        return true;
    }

    public Builder newBuilderForType()
    {
        return newBuilder();
    }

    protected Builder newBuilderForType(newBuilder newbuilder)
    {
        return new Builder(newbuilder, null);
    }

    public volatile Builder newBuilderForType()
    {
        return newBuilderForType();
    }

    protected volatile newBuilderForType newBuilderForType(newBuilderForType newbuilderfortype)
    {
        return newBuilderForType(newbuilderfortype);
    }

    public Builder toBuilder()
    {
        return newBuilder(this);
    }

    public volatile newBuilder toBuilder()
    {
        return toBuilder();
    }

    protected Object writeReplace()
        throws ObjectStreamException
    {
        return super.writeReplace();
    }

    public void writeTo(CodedOutputStream codedoutputstream)
        throws IOException
    {
        getSerializedSize();
        for (int i = 0; i < name_.size(); i++)
        {
            codedoutputstream.writeMessage(2, (MessageLite)name_.get(i));
        }

        if ((bitField0_ & 1) == 1)
        {
            codedoutputstream.writeBytes(3, getIdentifierValueBytes());
        }
        if ((bitField0_ & 2) == 2)
        {
            codedoutputstream.writeUInt64(4, positiveIntValue_);
        }
        if ((bitField0_ & 4) == 4)
        {
            codedoutputstream.writeInt64(5, negativeIntValue_);
        }
        if ((bitField0_ & 8) == 8)
        {
            codedoutputstream.writeDouble(6, doubleValue_);
        }
        if ((bitField0_ & 0x10) == 16)
        {
            codedoutputstream.writeBytes(7, stringValue_);
        }
        if ((bitField0_ & 0x20) == 32)
        {
            codedoutputstream.writeBytes(8, getAggregateValueBytes());
        }
        getUnknownFields().writeTo(codedoutputstream);
    }

    static 
    {
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
    }



/*
    static List access$18302(Builder builder, List list)
    {
        builder.name_ = list;
        return list;
    }

*/


/*
    static Object access$18402(name_ name_1, Object obj)
    {
        name_1.identifierValue_ = obj;
        return obj;
    }

*/


/*
    static long access$18502(identifierValue_ identifiervalue_, long l)
    {
        identifiervalue_.positiveIntValue_ = l;
        return l;
    }

*/


/*
    static long access$18602(positiveIntValue_ positiveintvalue_, long l)
    {
        positiveintvalue_.negativeIntValue_ = l;
        return l;
    }

*/


/*
    static double access$18702(negativeIntValue_ negativeintvalue_, double d)
    {
        negativeintvalue_.doubleValue_ = d;
        return d;
    }

*/


/*
    static ByteString access$18802(doubleValue_ doublevalue_, ByteString bytestring)
    {
        doublevalue_.stringValue_ = bytestring;
        return bytestring;
    }

*/


/*
    static Object access$18902(stringValue_ stringvalue_, Object obj)
    {
        stringvalue_.aggregateValue_ = obj;
        return obj;
    }

*/


/*
    static int access$19002(aggregateValue_ aggregatevalue_, int i)
    {
        aggregatevalue_.bitField0_ = i;
        return i;
    }

*/

    private Builder(Builder builder)
    {
        super(builder);
        memoizedIsInitialized = -1;
        memoizedSerializedSize = -1;
    }

    Builder(Builder builder, Builder builder1)
    {
        this(builder);
    }

    private Builder(boolean flag)
    {
        memoizedIsInitialized = -1;
        memoizedSerializedSize = -1;
    }
}
