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
//            GeneratedMessage, ByteString, Internal, CodedOutputStream, 
//            MessageLite, UnknownFieldSet, Message, RepeatedFieldBuilder, 
//            SingleFieldBuilder, CodedInputStream, ExtensionRegistryLite, ExtensionRegistry, 
//            MessageOrBuilder, ProtocolMessageEnum, LazyStringArrayList, InvalidProtocolBufferException, 
//            LazyStringList, UninitializedMessageException, UnmodifiableLazyStringList

public final class DescriptorProtos
{
    public static final class DescriptorProto extends GeneratedMessage
        implements DescriptorProtoOrBuilder
    {

        private static final DescriptorProto defaultInstance;
        private int bitField0_;
        private List enumType_;
        private List extensionRange_;
        private List extension_;
        private List field_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private List nestedType_;
        private MessageOptions options_;

        public static DescriptorProto getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
        }

        private ByteString getNameBytes()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                name_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private void initFields()
        {
            name_ = "";
            field_ = Collections.emptyList();
            extension_ = Collections.emptyList();
            nestedType_ = Collections.emptyList();
            enumType_ = Collections.emptyList();
            extensionRange_ = Collections.emptyList();
            options_ = MessageOptions.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(DescriptorProto descriptorproto)
        {
            return newBuilder().mergeFrom(descriptorproto);
        }

        public DescriptorProto getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public EnumDescriptorProto getEnumType(int i)
        {
            return (EnumDescriptorProto)enumType_.get(i);
        }

        public int getEnumTypeCount()
        {
            return enumType_.size();
        }

        public FieldDescriptorProto getExtension(int i)
        {
            return (FieldDescriptorProto)extension_.get(i);
        }

        public int getExtensionCount()
        {
            return extension_.size();
        }

        public List getExtensionRangeList()
        {
            return extensionRange_;
        }

        public FieldDescriptorProto getField(int i)
        {
            return (FieldDescriptorProto)field_.get(i);
        }

        public int getFieldCount()
        {
            return field_.size();
        }

        public String getName()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                name_ = s;
            }
            return s;
        }

        public DescriptorProto getNestedType(int i)
        {
            return (DescriptorProto)nestedType_.get(i);
        }

        public int getNestedTypeCount()
        {
            return nestedType_.size();
        }

        public MessageOptions getOptions()
        {
            return options_;
        }

        public int getSerializedSize()
        {
            boolean flag = false;
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            int j;
            int k;
            int l;
            if ((bitField0_ & 1) == 1)
            {
                i = CodedOutputStream.computeBytesSize(1, getNameBytes()) + 0;
            } else
            {
                i = 0;
            }
            for (j = 0; j < field_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(2, (MessageLite)field_.get(j));
            }

            for (j = 0; j < nestedType_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(3, (MessageLite)nestedType_.get(j));
            }

            for (j = 0; j < enumType_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(4, (MessageLite)enumType_.get(j));
            }

            k = 0;
            do
            {
                l = ((flag) ? 1 : 0);
                j = i;
                if (k >= extensionRange_.size())
                {
                    break;
                }
                i += CodedOutputStream.computeMessageSize(5, (MessageLite)extensionRange_.get(k));
                k++;
            } while (true);
            for (; l < extension_.size(); l++)
            {
                j += CodedOutputStream.computeMessageSize(6, (MessageLite)extension_.get(l));
            }

            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeMessageSize(7, options_);
            }
            i = getUnknownFields().getSerializedSize() + i;
            memoizedSerializedSize = i;
            return i;
        }

        public boolean hasName()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 2) == 2;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            boolean flag = true;
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                if (byte0 != 1)
                {
                    flag = false;
                }
                return flag;
            }
            for (int i = 0; i < getFieldCount(); i++)
            {
                if (!getField(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int j = 0; j < getExtensionCount(); j++)
            {
                if (!getExtension(j).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int k = 0; k < getNestedTypeCount(); k++)
            {
                if (!getNestedType(k).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int l = 0; l < getEnumTypeCount(); l++)
            {
                if (!getEnumType(l).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (hasOptions() && !getOptions().isInitialized())
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
            return new Builder(builderparent);
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
            boolean flag = false;
            getSerializedSize();
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeBytes(1, getNameBytes());
            }
            for (int i = 0; i < field_.size(); i++)
            {
                codedoutputstream.writeMessage(2, (MessageLite)field_.get(i));
            }

            for (int j = 0; j < nestedType_.size(); j++)
            {
                codedoutputstream.writeMessage(3, (MessageLite)nestedType_.get(j));
            }

            for (int k = 0; k < enumType_.size(); k++)
            {
                codedoutputstream.writeMessage(4, (MessageLite)enumType_.get(k));
            }

            int l = 0;
            int i1;
            do
            {
                i1 = ((flag) ? 1 : 0);
                if (l >= extensionRange_.size())
                {
                    break;
                }
                codedoutputstream.writeMessage(5, (MessageLite)extensionRange_.get(l));
                l++;
            } while (true);
            for (; i1 < extension_.size(); i1++)
            {
                codedoutputstream.writeMessage(6, (MessageLite)extension_.get(i1));
            }

            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeMessage(7, options_);
            }
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new DescriptorProto(true);
            defaultInstance.initFields();
        }


/*
        static Object access$3802(DescriptorProto descriptorproto, Object obj)
        {
            descriptorproto.name_ = obj;
            return obj;
        }

*/



/*
        static List access$3902(DescriptorProto descriptorproto, List list)
        {
            descriptorproto.field_ = list;
            return list;
        }

*/



/*
        static List access$4002(DescriptorProto descriptorproto, List list)
        {
            descriptorproto.extension_ = list;
            return list;
        }

*/



/*
        static List access$4102(DescriptorProto descriptorproto, List list)
        {
            descriptorproto.nestedType_ = list;
            return list;
        }

*/



/*
        static List access$4202(DescriptorProto descriptorproto, List list)
        {
            descriptorproto.enumType_ = list;
            return list;
        }

*/



/*
        static List access$4302(DescriptorProto descriptorproto, List list)
        {
            descriptorproto.extensionRange_ = list;
            return list;
        }

*/


/*
        static MessageOptions access$4402(DescriptorProto descriptorproto, MessageOptions messageoptions)
        {
            descriptorproto.options_ = messageoptions;
            return messageoptions;
        }

*/


/*
        static int access$4502(DescriptorProto descriptorproto, int i)
        {
            descriptorproto.bitField0_ = i;
            return i;
        }

*/

        private DescriptorProto(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private DescriptorProto(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class DescriptorProto.Builder extends GeneratedMessage.Builder
        implements DescriptorProtoOrBuilder
    {

        private int bitField0_;
        private RepeatedFieldBuilder enumTypeBuilder_;
        private List enumType_;
        private RepeatedFieldBuilder extensionBuilder_;
        private RepeatedFieldBuilder extensionRangeBuilder_;
        private List extensionRange_;
        private List extension_;
        private RepeatedFieldBuilder fieldBuilder_;
        private List field_;
        private Object name_;
        private RepeatedFieldBuilder nestedTypeBuilder_;
        private List nestedType_;
        private SingleFieldBuilder optionsBuilder_;
        private MessageOptions options_;

        private static DescriptorProto.Builder create()
        {
            return new DescriptorProto.Builder();
        }

        private void ensureEnumTypeIsMutable()
        {
            if ((bitField0_ & 0x10) != 16)
            {
                enumType_ = new ArrayList(enumType_);
                bitField0_ = bitField0_ | 0x10;
            }
        }

        private void ensureExtensionIsMutable()
        {
            if ((bitField0_ & 4) != 4)
            {
                extension_ = new ArrayList(extension_);
                bitField0_ = bitField0_ | 4;
            }
        }

        private void ensureExtensionRangeIsMutable()
        {
            if ((bitField0_ & 0x20) != 32)
            {
                extensionRange_ = new ArrayList(extensionRange_);
                bitField0_ = bitField0_ | 0x20;
            }
        }

        private void ensureFieldIsMutable()
        {
            if ((bitField0_ & 2) != 2)
            {
                field_ = new ArrayList(field_);
                bitField0_ = bitField0_ | 2;
            }
        }

        private void ensureNestedTypeIsMutable()
        {
            if ((bitField0_ & 8) != 8)
            {
                nestedType_ = new ArrayList(nestedType_);
                bitField0_ = bitField0_ | 8;
            }
        }

        private RepeatedFieldBuilder getEnumTypeFieldBuilder()
        {
            if (enumTypeBuilder_ == null)
            {
                List list = enumType_;
                boolean flag;
                if ((bitField0_ & 0x10) == 16)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                enumTypeBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                enumType_ = null;
            }
            return enumTypeBuilder_;
        }

        private RepeatedFieldBuilder getExtensionFieldBuilder()
        {
            if (extensionBuilder_ == null)
            {
                List list = extension_;
                boolean flag;
                if ((bitField0_ & 4) == 4)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                extensionBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                extension_ = null;
            }
            return extensionBuilder_;
        }

        private RepeatedFieldBuilder getExtensionRangeFieldBuilder()
        {
            if (extensionRangeBuilder_ == null)
            {
                List list = extensionRange_;
                boolean flag;
                if ((bitField0_ & 0x20) == 32)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                extensionRangeBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                extensionRange_ = null;
            }
            return extensionRangeBuilder_;
        }

        private RepeatedFieldBuilder getFieldFieldBuilder()
        {
            if (fieldBuilder_ == null)
            {
                List list = field_;
                boolean flag;
                if ((bitField0_ & 2) == 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                fieldBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                field_ = null;
            }
            return fieldBuilder_;
        }

        private RepeatedFieldBuilder getNestedTypeFieldBuilder()
        {
            if (nestedTypeBuilder_ == null)
            {
                List list = nestedType_;
                boolean flag;
                if ((bitField0_ & 8) == 8)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                nestedTypeBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                nestedType_ = null;
            }
            return nestedTypeBuilder_;
        }

        private SingleFieldBuilder getOptionsFieldBuilder()
        {
            if (optionsBuilder_ == null)
            {
                optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
                options_ = null;
            }
            return optionsBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getFieldFieldBuilder();
                getExtensionFieldBuilder();
                getNestedTypeFieldBuilder();
                getEnumTypeFieldBuilder();
                getExtensionRangeFieldBuilder();
                getOptionsFieldBuilder();
            }
        }

        public DescriptorProto.Builder addEnumType(EnumDescriptorProto enumdescriptorproto)
        {
            if (enumTypeBuilder_ == null)
            {
                if (enumdescriptorproto == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureEnumTypeIsMutable();
                    enumType_.add(enumdescriptorproto);
                    onChanged();
                    return this;
                }
            } else
            {
                enumTypeBuilder_.addMessage(enumdescriptorproto);
                return this;
            }
        }

        public DescriptorProto.Builder addExtension(FieldDescriptorProto fielddescriptorproto)
        {
            if (extensionBuilder_ == null)
            {
                if (fielddescriptorproto == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureExtensionIsMutable();
                    extension_.add(fielddescriptorproto);
                    onChanged();
                    return this;
                }
            } else
            {
                extensionBuilder_.addMessage(fielddescriptorproto);
                return this;
            }
        }

        public DescriptorProto.Builder addExtensionRange(DescriptorProto.ExtensionRange extensionrange)
        {
            if (extensionRangeBuilder_ == null)
            {
                if (extensionrange == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureExtensionRangeIsMutable();
                    extensionRange_.add(extensionrange);
                    onChanged();
                    return this;
                }
            } else
            {
                extensionRangeBuilder_.addMessage(extensionrange);
                return this;
            }
        }

        public DescriptorProto.Builder addField(FieldDescriptorProto fielddescriptorproto)
        {
            if (fieldBuilder_ == null)
            {
                if (fielddescriptorproto == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureFieldIsMutable();
                    field_.add(fielddescriptorproto);
                    onChanged();
                    return this;
                }
            } else
            {
                fieldBuilder_.addMessage(fielddescriptorproto);
                return this;
            }
        }

        public DescriptorProto.Builder addNestedType(DescriptorProto descriptorproto)
        {
            if (nestedTypeBuilder_ == null)
            {
                if (descriptorproto == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureNestedTypeIsMutable();
                    nestedType_.add(descriptorproto);
                    onChanged();
                    return this;
                }
            } else
            {
                nestedTypeBuilder_.addMessage(descriptorproto);
                return this;
            }
        }

        public DescriptorProto build()
        {
            DescriptorProto descriptorproto = buildPartial();
            if (!descriptorproto.isInitialized())
            {
                throw newUninitializedMessageException(descriptorproto);
            } else
            {
                return descriptorproto;
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

        public DescriptorProto buildPartial()
        {
            int i = 1;
            DescriptorProto descriptorproto = new DescriptorProto(this);
            int j = bitField0_;
            if ((j & 1) != 1)
            {
                i = 0;
            }
            descriptorproto.name_ = name_;
            if (fieldBuilder_ == null)
            {
                if ((bitField0_ & 2) == 2)
                {
                    field_ = Collections.unmodifiableList(field_);
                    bitField0_ = bitField0_ & -3;
                }
                descriptorproto.field_ = field_;
            } else
            {
                descriptorproto.field_ = fieldBuilder_.build();
            }
            if (extensionBuilder_ == null)
            {
                if ((bitField0_ & 4) == 4)
                {
                    extension_ = Collections.unmodifiableList(extension_);
                    bitField0_ = bitField0_ & -5;
                }
                descriptorproto.extension_ = extension_;
            } else
            {
                descriptorproto.extension_ = extensionBuilder_.build();
            }
            if (nestedTypeBuilder_ == null)
            {
                if ((bitField0_ & 8) == 8)
                {
                    nestedType_ = Collections.unmodifiableList(nestedType_);
                    bitField0_ = bitField0_ & -9;
                }
                descriptorproto.nestedType_ = nestedType_;
            } else
            {
                descriptorproto.nestedType_ = nestedTypeBuilder_.build();
            }
            if (enumTypeBuilder_ == null)
            {
                if ((bitField0_ & 0x10) == 16)
                {
                    enumType_ = Collections.unmodifiableList(enumType_);
                    bitField0_ = bitField0_ & 0xffffffef;
                }
                descriptorproto.enumType_ = enumType_;
            } else
            {
                descriptorproto.enumType_ = enumTypeBuilder_.build();
            }
            if (extensionRangeBuilder_ == null)
            {
                if ((bitField0_ & 0x20) == 32)
                {
                    extensionRange_ = Collections.unmodifiableList(extensionRange_);
                    bitField0_ = bitField0_ & 0xffffffdf;
                }
                descriptorproto.extensionRange_ = extensionRange_;
            } else
            {
                descriptorproto.extensionRange_ = extensionRangeBuilder_.build();
            }
            if ((j & 0x40) == 64)
            {
                i |= 2;
            }
            if (optionsBuilder_ == null)
            {
                descriptorproto.options_ = options_;
            } else
            {
                descriptorproto.options_ = (MessageOptions)optionsBuilder_.build();
            }
            descriptorproto.bitField0_ = i;
            onBuilt();
            return descriptorproto;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public DescriptorProto.Builder clear()
        {
            super.clear();
            name_ = "";
            bitField0_ = bitField0_ & -2;
            if (fieldBuilder_ == null)
            {
                field_ = Collections.emptyList();
                bitField0_ = bitField0_ & -3;
            } else
            {
                fieldBuilder_.clear();
            }
            if (extensionBuilder_ == null)
            {
                extension_ = Collections.emptyList();
                bitField0_ = bitField0_ & -5;
            } else
            {
                extensionBuilder_.clear();
            }
            if (nestedTypeBuilder_ == null)
            {
                nestedType_ = Collections.emptyList();
                bitField0_ = bitField0_ & -9;
            } else
            {
                nestedTypeBuilder_.clear();
            }
            if (enumTypeBuilder_ == null)
            {
                enumType_ = Collections.emptyList();
                bitField0_ = bitField0_ & 0xffffffef;
            } else
            {
                enumTypeBuilder_.clear();
            }
            if (extensionRangeBuilder_ == null)
            {
                extensionRange_ = Collections.emptyList();
                bitField0_ = bitField0_ & 0xffffffdf;
            } else
            {
                extensionRangeBuilder_.clear();
            }
            if (optionsBuilder_ == null)
            {
                options_ = MessageOptions.getDefaultInstance();
            } else
            {
                optionsBuilder_.clear();
            }
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

        public DescriptorProto.Builder clone()
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

        public DescriptorProto getDefaultInstanceForType()
        {
            return DescriptorProto.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return DescriptorProto.getDescriptor();
        }

        public EnumDescriptorProto getEnumType(int i)
        {
            if (enumTypeBuilder_ == null)
            {
                return (EnumDescriptorProto)enumType_.get(i);
            } else
            {
                return (EnumDescriptorProto)enumTypeBuilder_.getMessage(i);
            }
        }

        public int getEnumTypeCount()
        {
            if (enumTypeBuilder_ == null)
            {
                return enumType_.size();
            } else
            {
                return enumTypeBuilder_.getCount();
            }
        }

        public FieldDescriptorProto getExtension(int i)
        {
            if (extensionBuilder_ == null)
            {
                return (FieldDescriptorProto)extension_.get(i);
            } else
            {
                return (FieldDescriptorProto)extensionBuilder_.getMessage(i);
            }
        }

        public int getExtensionCount()
        {
            if (extensionBuilder_ == null)
            {
                return extension_.size();
            } else
            {
                return extensionBuilder_.getCount();
            }
        }

        public FieldDescriptorProto getField(int i)
        {
            if (fieldBuilder_ == null)
            {
                return (FieldDescriptorProto)field_.get(i);
            } else
            {
                return (FieldDescriptorProto)fieldBuilder_.getMessage(i);
            }
        }

        public int getFieldCount()
        {
            if (fieldBuilder_ == null)
            {
                return field_.size();
            } else
            {
                return fieldBuilder_.getCount();
            }
        }

        public DescriptorProto getNestedType(int i)
        {
            if (nestedTypeBuilder_ == null)
            {
                return (DescriptorProto)nestedType_.get(i);
            } else
            {
                return (DescriptorProto)nestedTypeBuilder_.getMessage(i);
            }
        }

        public int getNestedTypeCount()
        {
            if (nestedTypeBuilder_ == null)
            {
                return nestedType_.size();
            } else
            {
                return nestedTypeBuilder_.getCount();
            }
        }

        public MessageOptions getOptions()
        {
            if (optionsBuilder_ == null)
            {
                return options_;
            } else
            {
                return (MessageOptions)optionsBuilder_.getMessage();
            }
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 0x40) == 64;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L13:
            if (i >= getFieldCount()) goto _L2; else goto _L1
_L1:
            if (getField(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            i = 0;
_L6:
            if (i >= getExtensionCount())
            {
                break MISSING_BLOCK_LABEL_58;
            }
            if (!getExtension(i).isInitialized()) goto _L3; else goto _L5
_L5:
            i++;
              goto _L6
            i = 0;
_L8:
            if (i >= getNestedTypeCount())
            {
                break MISSING_BLOCK_LABEL_86;
            }
            if (!getNestedType(i).isInitialized()) goto _L3; else goto _L7
_L7:
            i++;
              goto _L8
            i = 0;
_L10:
            if (i >= getEnumTypeCount())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!getEnumType(i).isInitialized()) goto _L3; else goto _L9
_L9:
            i++;
              goto _L10
            if (hasOptions() && !getOptions().isInitialized()) goto _L3; else goto _L11
_L11:
            return true;
            if (true) goto _L13; else goto _L12
_L12:
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

        public DescriptorProto.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
                    name_ = codedinputstream.readBytes();
                    break;

                case 18: // '\022'
                    FieldDescriptorProto.Builder builder1 = FieldDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addField(builder1.buildPartial());
                    break;

                case 26: // '\032'
                    DescriptorProto.Builder builder2 = DescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder2, extensionregistrylite);
                    addNestedType(builder2.buildPartial());
                    break;

                case 34: // '"'
                    EnumDescriptorProto.Builder builder3 = EnumDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder3, extensionregistrylite);
                    addEnumType(builder3.buildPartial());
                    break;

                case 42: // '*'
                    DescriptorProto.ExtensionRange.Builder builder4 = DescriptorProto.ExtensionRange.newBuilder();
                    codedinputstream.readMessage(builder4, extensionregistrylite);
                    addExtensionRange(builder4.buildPartial());
                    break;

                case 50: // '2'
                    FieldDescriptorProto.Builder builder5 = FieldDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder5, extensionregistrylite);
                    addExtension(builder5.buildPartial());
                    break;

                case 58: // ':'
                    MessageOptions.Builder builder6 = MessageOptions.newBuilder();
                    if (hasOptions())
                    {
                        builder6.mergeFrom(getOptions());
                    }
                    codedinputstream.readMessage(builder6, extensionregistrylite);
                    setOptions(builder6.buildPartial());
                    break;
                }
            } while (true);
        }

        public DescriptorProto.Builder mergeFrom(DescriptorProto descriptorproto)
        {
            Object obj = null;
            if (descriptorproto == DescriptorProto.getDefaultInstance())
            {
                return this;
            }
            if (descriptorproto.hasName())
            {
                setName(descriptorproto.getName());
            }
            if (fieldBuilder_ == null)
            {
                if (!descriptorproto.field_.isEmpty())
                {
                    if (field_.isEmpty())
                    {
                        field_ = descriptorproto.field_;
                        bitField0_ = bitField0_ & -3;
                    } else
                    {
                        ensureFieldIsMutable();
                        field_.addAll(descriptorproto.field_);
                    }
                    onChanged();
                }
            } else
            if (!descriptorproto.field_.isEmpty())
            {
                if (fieldBuilder_.isEmpty())
                {
                    fieldBuilder_.dispose();
                    fieldBuilder_ = null;
                    field_ = descriptorproto.field_;
                    bitField0_ = bitField0_ & -3;
                    RepeatedFieldBuilder repeatedfieldbuilder;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getFieldFieldBuilder();
                    } else
                    {
                        repeatedfieldbuilder = null;
                    }
                    fieldBuilder_ = repeatedfieldbuilder;
                } else
                {
                    fieldBuilder_.addAllMessages(descriptorproto.field_);
                }
            }
            if (extensionBuilder_ == null)
            {
                if (!descriptorproto.extension_.isEmpty())
                {
                    if (extension_.isEmpty())
                    {
                        extension_ = descriptorproto.extension_;
                        bitField0_ = bitField0_ & -5;
                    } else
                    {
                        ensureExtensionIsMutable();
                        extension_.addAll(descriptorproto.extension_);
                    }
                    onChanged();
                }
            } else
            if (!descriptorproto.extension_.isEmpty())
            {
                if (extensionBuilder_.isEmpty())
                {
                    extensionBuilder_.dispose();
                    extensionBuilder_ = null;
                    extension_ = descriptorproto.extension_;
                    bitField0_ = bitField0_ & -5;
                    RepeatedFieldBuilder repeatedfieldbuilder1;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder1 = getExtensionFieldBuilder();
                    } else
                    {
                        repeatedfieldbuilder1 = null;
                    }
                    extensionBuilder_ = repeatedfieldbuilder1;
                } else
                {
                    extensionBuilder_.addAllMessages(descriptorproto.extension_);
                }
            }
            if (nestedTypeBuilder_ == null)
            {
                if (!descriptorproto.nestedType_.isEmpty())
                {
                    if (nestedType_.isEmpty())
                    {
                        nestedType_ = descriptorproto.nestedType_;
                        bitField0_ = bitField0_ & -9;
                    } else
                    {
                        ensureNestedTypeIsMutable();
                        nestedType_.addAll(descriptorproto.nestedType_);
                    }
                    onChanged();
                }
            } else
            if (!descriptorproto.nestedType_.isEmpty())
            {
                if (nestedTypeBuilder_.isEmpty())
                {
                    nestedTypeBuilder_.dispose();
                    nestedTypeBuilder_ = null;
                    nestedType_ = descriptorproto.nestedType_;
                    bitField0_ = bitField0_ & -9;
                    RepeatedFieldBuilder repeatedfieldbuilder2;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder2 = getNestedTypeFieldBuilder();
                    } else
                    {
                        repeatedfieldbuilder2 = null;
                    }
                    nestedTypeBuilder_ = repeatedfieldbuilder2;
                } else
                {
                    nestedTypeBuilder_.addAllMessages(descriptorproto.nestedType_);
                }
            }
            if (enumTypeBuilder_ == null)
            {
                if (!descriptorproto.enumType_.isEmpty())
                {
                    if (enumType_.isEmpty())
                    {
                        enumType_ = descriptorproto.enumType_;
                        bitField0_ = bitField0_ & 0xffffffef;
                    } else
                    {
                        ensureEnumTypeIsMutable();
                        enumType_.addAll(descriptorproto.enumType_);
                    }
                    onChanged();
                }
            } else
            if (!descriptorproto.enumType_.isEmpty())
            {
                if (enumTypeBuilder_.isEmpty())
                {
                    enumTypeBuilder_.dispose();
                    enumTypeBuilder_ = null;
                    enumType_ = descriptorproto.enumType_;
                    bitField0_ = bitField0_ & 0xffffffef;
                    RepeatedFieldBuilder repeatedfieldbuilder3;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder3 = getEnumTypeFieldBuilder();
                    } else
                    {
                        repeatedfieldbuilder3 = null;
                    }
                    enumTypeBuilder_ = repeatedfieldbuilder3;
                } else
                {
                    enumTypeBuilder_.addAllMessages(descriptorproto.enumType_);
                }
            }
            if (extensionRangeBuilder_ == null)
            {
                if (!descriptorproto.extensionRange_.isEmpty())
                {
                    if (extensionRange_.isEmpty())
                    {
                        extensionRange_ = descriptorproto.extensionRange_;
                        bitField0_ = bitField0_ & 0xffffffdf;
                    } else
                    {
                        ensureExtensionRangeIsMutable();
                        extensionRange_.addAll(descriptorproto.extensionRange_);
                    }
                    onChanged();
                }
            } else
            if (!descriptorproto.extensionRange_.isEmpty())
            {
                if (extensionRangeBuilder_.isEmpty())
                {
                    extensionRangeBuilder_.dispose();
                    extensionRangeBuilder_ = null;
                    extensionRange_ = descriptorproto.extensionRange_;
                    bitField0_ = bitField0_ & 0xffffffdf;
                    RepeatedFieldBuilder repeatedfieldbuilder4 = obj;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder4 = getExtensionRangeFieldBuilder();
                    }
                    extensionRangeBuilder_ = repeatedfieldbuilder4;
                } else
                {
                    extensionRangeBuilder_.addAllMessages(descriptorproto.extensionRange_);
                }
            }
            if (descriptorproto.hasOptions())
            {
                mergeOptions(descriptorproto.getOptions());
            }
            mergeUnknownFields(descriptorproto.getUnknownFields());
            return this;
        }

        public DescriptorProto.Builder mergeFrom(Message message)
        {
            if (message instanceof DescriptorProto)
            {
                return mergeFrom((DescriptorProto)message);
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

        public DescriptorProto.Builder mergeOptions(MessageOptions messageoptions)
        {
            if (optionsBuilder_ == null)
            {
                if ((bitField0_ & 0x40) == 64 && options_ != MessageOptions.getDefaultInstance())
                {
                    options_ = MessageOptions.newBuilder(options_).mergeFrom(messageoptions).buildPartial();
                } else
                {
                    options_ = messageoptions;
                }
                onChanged();
            } else
            {
                optionsBuilder_.mergeFrom(messageoptions);
            }
            bitField0_ = bitField0_ | 0x40;
            return this;
        }

        public DescriptorProto.Builder setName(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                name_ = s;
                onChanged();
                return this;
            }
        }

        public DescriptorProto.Builder setOptions(MessageOptions messageoptions)
        {
            if (optionsBuilder_ == null)
            {
                if (messageoptions == null)
                {
                    throw new NullPointerException();
                }
                options_ = messageoptions;
                onChanged();
            } else
            {
                optionsBuilder_.setMessage(messageoptions);
            }
            bitField0_ = bitField0_ | 0x40;
            return this;
        }


        private DescriptorProto.Builder()
        {
            name_ = "";
            field_ = Collections.emptyList();
            extension_ = Collections.emptyList();
            nestedType_ = Collections.emptyList();
            enumType_ = Collections.emptyList();
            extensionRange_ = Collections.emptyList();
            options_ = MessageOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        private DescriptorProto.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            field_ = Collections.emptyList();
            extension_ = Collections.emptyList();
            nestedType_ = Collections.emptyList();
            enumType_ = Collections.emptyList();
            extensionRange_ = Collections.emptyList();
            options_ = MessageOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

    }

    public static final class DescriptorProto.ExtensionRange extends GeneratedMessage
        implements DescriptorProto.ExtensionRangeOrBuilder
    {

        private static final DescriptorProto.ExtensionRange defaultInstance;
        private int bitField0_;
        private int end_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int start_;

        public static DescriptorProto.ExtensionRange getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor;
        }

        private void initFields()
        {
            start_ = 0;
            end_ = 0;
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(DescriptorProto.ExtensionRange extensionrange)
        {
            return newBuilder().mergeFrom(extensionrange);
        }

        public DescriptorProto.ExtensionRange getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getEnd()
        {
            return end_;
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
                i = 0 + CodedOutputStream.computeInt32Size(1, start_);
            }
            int j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeInt32Size(2, end_);
            }
            i = j + getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public int getStart()
        {
            return start_;
        }

        public boolean hasEnd()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasStart()
        {
            return (bitField0_ & 1) == 1;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
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
            return new Builder(builderparent);
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
                codedoutputstream.writeInt32(1, start_);
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeInt32(2, end_);
            }
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new DescriptorProto.ExtensionRange(true);
            defaultInstance.initFields();
        }


/*
        static int access$3102(DescriptorProto.ExtensionRange extensionrange, int i)
        {
            extensionrange.start_ = i;
            return i;
        }

*/


/*
        static int access$3202(DescriptorProto.ExtensionRange extensionrange, int i)
        {
            extensionrange.end_ = i;
            return i;
        }

*/


/*
        static int access$3302(DescriptorProto.ExtensionRange extensionrange, int i)
        {
            extensionrange.bitField0_ = i;
            return i;
        }

*/

        private DescriptorProto.ExtensionRange(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private DescriptorProto.ExtensionRange(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class DescriptorProto.ExtensionRange.Builder extends GeneratedMessage.Builder
        implements DescriptorProto.ExtensionRangeOrBuilder
    {

        private int bitField0_;
        private int end_;
        private int start_;

        private static DescriptorProto.ExtensionRange.Builder create()
        {
            return new DescriptorProto.ExtensionRange.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
            if (!GeneratedMessage.alwaysUseFieldBuilders);
        }

        public DescriptorProto.ExtensionRange build()
        {
            DescriptorProto.ExtensionRange extensionrange = buildPartial();
            if (!extensionrange.isInitialized())
            {
                throw newUninitializedMessageException(extensionrange);
            } else
            {
                return extensionrange;
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

        public DescriptorProto.ExtensionRange buildPartial()
        {
            int i = 1;
            DescriptorProto.ExtensionRange extensionrange = new DescriptorProto.ExtensionRange(this);
            int k = bitField0_;
            int j;
            if ((k & 1) != 1)
            {
                i = 0;
            }
            extensionrange.start_ = start_;
            j = i;
            if ((k & 2) == 2)
            {
                j = i | 2;
            }
            extensionrange.end_ = end_;
            extensionrange.bitField0_ = j;
            onBuilt();
            return extensionrange;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public DescriptorProto.ExtensionRange.Builder clear()
        {
            super.clear();
            start_ = 0;
            bitField0_ = bitField0_ & -2;
            end_ = 0;
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

        public DescriptorProto.ExtensionRange.Builder clone()
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

        public DescriptorProto.ExtensionRange getDefaultInstanceForType()
        {
            return DescriptorProto.ExtensionRange.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return DescriptorProto.ExtensionRange.getDescriptor();
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
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

        public DescriptorProto.ExtensionRange.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

                case 8: // '\b'
                    bitField0_ = bitField0_ | 1;
                    start_ = codedinputstream.readInt32();
                    break;

                case 16: // '\020'
                    bitField0_ = bitField0_ | 2;
                    end_ = codedinputstream.readInt32();
                    break;
                }
            } while (true);
        }

        public DescriptorProto.ExtensionRange.Builder mergeFrom(DescriptorProto.ExtensionRange extensionrange)
        {
            if (extensionrange == DescriptorProto.ExtensionRange.getDefaultInstance())
            {
                return this;
            }
            if (extensionrange.hasStart())
            {
                setStart(extensionrange.getStart());
            }
            if (extensionrange.hasEnd())
            {
                setEnd(extensionrange.getEnd());
            }
            mergeUnknownFields(extensionrange.getUnknownFields());
            return this;
        }

        public DescriptorProto.ExtensionRange.Builder mergeFrom(Message message)
        {
            if (message instanceof DescriptorProto.ExtensionRange)
            {
                return mergeFrom((DescriptorProto.ExtensionRange)message);
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

        public DescriptorProto.ExtensionRange.Builder setEnd(int i)
        {
            bitField0_ = bitField0_ | 2;
            end_ = i;
            onChanged();
            return this;
        }

        public DescriptorProto.ExtensionRange.Builder setStart(int i)
        {
            bitField0_ = bitField0_ | 1;
            start_ = i;
            onChanged();
            return this;
        }


        private DescriptorProto.ExtensionRange.Builder()
        {
            maybeForceBuilderInitialization();
        }

        private DescriptorProto.ExtensionRange.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            maybeForceBuilderInitialization();
        }

    }

    public static interface DescriptorProto.ExtensionRangeOrBuilder
        extends MessageOrBuilder
    {
    }

    public static interface DescriptorProtoOrBuilder
        extends MessageOrBuilder
    {
    }

    public static final class EnumDescriptorProto extends GeneratedMessage
        implements EnumDescriptorProtoOrBuilder
    {

        private static final EnumDescriptorProto defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private EnumOptions options_;
        private List value_;

        public static EnumDescriptorProto getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
        }

        private ByteString getNameBytes()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                name_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private void initFields()
        {
            name_ = "";
            value_ = Collections.emptyList();
            options_ = EnumOptions.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(EnumDescriptorProto enumdescriptorproto)
        {
            return newBuilder().mergeFrom(enumdescriptorproto);
        }

        public EnumDescriptorProto getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public String getName()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                name_ = s;
            }
            return s;
        }

        public EnumOptions getOptions()
        {
            return options_;
        }

        public int getSerializedSize()
        {
            int j = 0;
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            if ((bitField0_ & 1) == 1)
            {
                i = CodedOutputStream.computeBytesSize(1, getNameBytes()) + 0;
            } else
            {
                i = 0;
            }
            while (j < value_.size()) 
            {
                int k = CodedOutputStream.computeMessageSize(2, (MessageLite)value_.get(j));
                j++;
                i = k + i;
            }
            j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeMessageSize(3, options_);
            }
            i = getUnknownFields().getSerializedSize() + j;
            memoizedSerializedSize = i;
            return i;
        }

        public EnumValueDescriptorProto getValue(int i)
        {
            return (EnumValueDescriptorProto)value_.get(i);
        }

        public int getValueCount()
        {
            return value_.size();
        }

        public boolean hasName()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 2) == 2;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i = 0; i < getValueCount(); i++)
            {
                if (!getValue(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (hasOptions() && !getOptions().isInitialized())
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
            return new Builder(builderparent);
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
                codedoutputstream.writeBytes(1, getNameBytes());
            }
            for (int i = 0; i < value_.size(); i++)
            {
                codedoutputstream.writeMessage(2, (MessageLite)value_.get(i));
            }

            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeMessage(3, options_);
            }
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new EnumDescriptorProto(true);
            defaultInstance.initFields();
        }


/*
        static Object access$6702(EnumDescriptorProto enumdescriptorproto, Object obj)
        {
            enumdescriptorproto.name_ = obj;
            return obj;
        }

*/



/*
        static List access$6802(EnumDescriptorProto enumdescriptorproto, List list)
        {
            enumdescriptorproto.value_ = list;
            return list;
        }

*/


/*
        static EnumOptions access$6902(EnumDescriptorProto enumdescriptorproto, EnumOptions enumoptions)
        {
            enumdescriptorproto.options_ = enumoptions;
            return enumoptions;
        }

*/


/*
        static int access$7002(EnumDescriptorProto enumdescriptorproto, int i)
        {
            enumdescriptorproto.bitField0_ = i;
            return i;
        }

*/

        private EnumDescriptorProto(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private EnumDescriptorProto(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class EnumDescriptorProto.Builder extends GeneratedMessage.Builder
        implements EnumDescriptorProtoOrBuilder
    {

        private int bitField0_;
        private Object name_;
        private SingleFieldBuilder optionsBuilder_;
        private EnumOptions options_;
        private RepeatedFieldBuilder valueBuilder_;
        private List value_;

        private static EnumDescriptorProto.Builder create()
        {
            return new EnumDescriptorProto.Builder();
        }

        private void ensureValueIsMutable()
        {
            if ((bitField0_ & 2) != 2)
            {
                value_ = new ArrayList(value_);
                bitField0_ = bitField0_ | 2;
            }
        }

        private SingleFieldBuilder getOptionsFieldBuilder()
        {
            if (optionsBuilder_ == null)
            {
                optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
                options_ = null;
            }
            return optionsBuilder_;
        }

        private RepeatedFieldBuilder getValueFieldBuilder()
        {
            if (valueBuilder_ == null)
            {
                List list = value_;
                boolean flag;
                if ((bitField0_ & 2) == 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                valueBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                value_ = null;
            }
            return valueBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getValueFieldBuilder();
                getOptionsFieldBuilder();
            }
        }

        public EnumDescriptorProto.Builder addValue(EnumValueDescriptorProto enumvaluedescriptorproto)
        {
            if (valueBuilder_ == null)
            {
                if (enumvaluedescriptorproto == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureValueIsMutable();
                    value_.add(enumvaluedescriptorproto);
                    onChanged();
                    return this;
                }
            } else
            {
                valueBuilder_.addMessage(enumvaluedescriptorproto);
                return this;
            }
        }

        public EnumDescriptorProto build()
        {
            EnumDescriptorProto enumdescriptorproto = buildPartial();
            if (!enumdescriptorproto.isInitialized())
            {
                throw newUninitializedMessageException(enumdescriptorproto);
            } else
            {
                return enumdescriptorproto;
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

        public EnumDescriptorProto buildPartial()
        {
            int i = 1;
            EnumDescriptorProto enumdescriptorproto = new EnumDescriptorProto(this);
            int j = bitField0_;
            if ((j & 1) != 1)
            {
                i = 0;
            }
            enumdescriptorproto.name_ = name_;
            if (valueBuilder_ == null)
            {
                if ((bitField0_ & 2) == 2)
                {
                    value_ = Collections.unmodifiableList(value_);
                    bitField0_ = bitField0_ & -3;
                }
                enumdescriptorproto.value_ = value_;
            } else
            {
                enumdescriptorproto.value_ = valueBuilder_.build();
            }
            if ((j & 4) == 4)
            {
                i |= 2;
            }
            if (optionsBuilder_ == null)
            {
                enumdescriptorproto.options_ = options_;
            } else
            {
                enumdescriptorproto.options_ = (EnumOptions)optionsBuilder_.build();
            }
            enumdescriptorproto.bitField0_ = i;
            onBuilt();
            return enumdescriptorproto;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public EnumDescriptorProto.Builder clear()
        {
            super.clear();
            name_ = "";
            bitField0_ = bitField0_ & -2;
            if (valueBuilder_ == null)
            {
                value_ = Collections.emptyList();
                bitField0_ = bitField0_ & -3;
            } else
            {
                valueBuilder_.clear();
            }
            if (optionsBuilder_ == null)
            {
                options_ = EnumOptions.getDefaultInstance();
            } else
            {
                optionsBuilder_.clear();
            }
            bitField0_ = bitField0_ & -5;
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

        public EnumDescriptorProto.Builder clone()
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

        public EnumDescriptorProto getDefaultInstanceForType()
        {
            return EnumDescriptorProto.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return EnumDescriptorProto.getDescriptor();
        }

        public EnumOptions getOptions()
        {
            if (optionsBuilder_ == null)
            {
                return options_;
            } else
            {
                return (EnumOptions)optionsBuilder_.getMessage();
            }
        }

        public EnumValueDescriptorProto getValue(int i)
        {
            if (valueBuilder_ == null)
            {
                return (EnumValueDescriptorProto)value_.get(i);
            } else
            {
                return (EnumValueDescriptorProto)valueBuilder_.getMessage(i);
            }
        }

        public int getValueCount()
        {
            if (valueBuilder_ == null)
            {
                return value_.size();
            } else
            {
                return valueBuilder_.getCount();
            }
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 4) == 4;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L7:
            if (i >= getValueCount()) goto _L2; else goto _L1
_L1:
            if (getValue(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (hasOptions() && !getOptions().isInitialized()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
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

        public EnumDescriptorProto.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
                    name_ = codedinputstream.readBytes();
                    break;

                case 18: // '\022'
                    EnumValueDescriptorProto.Builder builder1 = EnumValueDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addValue(builder1.buildPartial());
                    break;

                case 26: // '\032'
                    EnumOptions.Builder builder2 = EnumOptions.newBuilder();
                    if (hasOptions())
                    {
                        builder2.mergeFrom(getOptions());
                    }
                    codedinputstream.readMessage(builder2, extensionregistrylite);
                    setOptions(builder2.buildPartial());
                    break;
                }
            } while (true);
        }

        public EnumDescriptorProto.Builder mergeFrom(EnumDescriptorProto enumdescriptorproto)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (enumdescriptorproto == EnumDescriptorProto.getDefaultInstance())
            {
                return this;
            }
            if (enumdescriptorproto.hasName())
            {
                setName(enumdescriptorproto.getName());
            }
            if (valueBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!enumdescriptorproto.value_.isEmpty())
            {
                if (value_.isEmpty())
                {
                    value_ = enumdescriptorproto.value_;
                    bitField0_ = bitField0_ & -3;
                } else
                {
                    ensureValueIsMutable();
                    value_.addAll(enumdescriptorproto.value_);
                }
                onChanged();
            }
_L4:
            if (enumdescriptorproto.hasOptions())
            {
                mergeOptions(enumdescriptorproto.getOptions());
            }
            mergeUnknownFields(enumdescriptorproto.getUnknownFields());
            return this;
_L2:
            if (!enumdescriptorproto.value_.isEmpty())
            {
                if (valueBuilder_.isEmpty())
                {
                    valueBuilder_.dispose();
                    valueBuilder_ = null;
                    value_ = enumdescriptorproto.value_;
                    bitField0_ = bitField0_ & -3;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getValueFieldBuilder();
                    }
                    valueBuilder_ = repeatedfieldbuilder;
                } else
                {
                    valueBuilder_.addAllMessages(enumdescriptorproto.value_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public EnumDescriptorProto.Builder mergeFrom(Message message)
        {
            if (message instanceof EnumDescriptorProto)
            {
                return mergeFrom((EnumDescriptorProto)message);
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

        public EnumDescriptorProto.Builder mergeOptions(EnumOptions enumoptions)
        {
            if (optionsBuilder_ == null)
            {
                if ((bitField0_ & 4) == 4 && options_ != EnumOptions.getDefaultInstance())
                {
                    options_ = EnumOptions.newBuilder(options_).mergeFrom(enumoptions).buildPartial();
                } else
                {
                    options_ = enumoptions;
                }
                onChanged();
            } else
            {
                optionsBuilder_.mergeFrom(enumoptions);
            }
            bitField0_ = bitField0_ | 4;
            return this;
        }

        public EnumDescriptorProto.Builder setName(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                name_ = s;
                onChanged();
                return this;
            }
        }

        public EnumDescriptorProto.Builder setOptions(EnumOptions enumoptions)
        {
            if (optionsBuilder_ == null)
            {
                if (enumoptions == null)
                {
                    throw new NullPointerException();
                }
                options_ = enumoptions;
                onChanged();
            } else
            {
                optionsBuilder_.setMessage(enumoptions);
            }
            bitField0_ = bitField0_ | 4;
            return this;
        }


        private EnumDescriptorProto.Builder()
        {
            name_ = "";
            value_ = Collections.emptyList();
            options_ = EnumOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        private EnumDescriptorProto.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            value_ = Collections.emptyList();
            options_ = EnumOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

    }

    public static interface EnumDescriptorProtoOrBuilder
        extends MessageOrBuilder
    {
    }

    public static final class EnumOptions extends GeneratedMessage.ExtendableMessage
        implements EnumOptionsOrBuilder
    {

        private static final EnumOptions defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List uninterpretedOption_;

        public static EnumOptions getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor;
        }

        private void initFields()
        {
            uninterpretedOption_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(EnumOptions enumoptions)
        {
            return newBuilder().mergeFrom(enumoptions);
        }

        public EnumOptions getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            int j = 0;
            for (; i < uninterpretedOption_.size(); i++)
            {
                j += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
            }

            i = extensionsSerializedSize() + j + getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            return (UninterpretedOption)uninterpretedOption_.get(i);
        }

        public int getUninterpretedOptionCount()
        {
            return uninterpretedOption_.size();
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++)
            {
                if (!getUninterpretedOption(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (!extensionsAreInitialized())
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
            return new Builder(builderparent);
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
            GeneratedMessage.ExtendableMessage.ExtensionWriter extensionwriter = newExtensionWriter();
            for (int i = 0; i < uninterpretedOption_.size(); i++)
            {
                codedoutputstream.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
            }

            extensionwriter.writeUntil(0x20000000, codedoutputstream);
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new EnumOptions(true);
            defaultInstance.initFields();
        }



/*
        static List access$14602(EnumOptions enumoptions, List list)
        {
            enumoptions.uninterpretedOption_ = list;
            return list;
        }

*/

        private EnumOptions(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private EnumOptions(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class EnumOptions.Builder extends GeneratedMessage.ExtendableBuilder
        implements EnumOptionsOrBuilder
    {

        private int bitField0_;
        private RepeatedFieldBuilder uninterpretedOptionBuilder_;
        private List uninterpretedOption_;

        private static EnumOptions.Builder create()
        {
            return new EnumOptions.Builder();
        }

        private void ensureUninterpretedOptionIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                uninterpretedOption_ = new ArrayList(uninterpretedOption_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder()
        {
            boolean flag = true;
            if (uninterpretedOptionBuilder_ == null)
            {
                List list = uninterpretedOption_;
                if ((bitField0_ & 1) != 1)
                {
                    flag = false;
                }
                uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                uninterpretedOption_ = null;
            }
            return uninterpretedOptionBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getUninterpretedOptionFieldBuilder();
            }
        }

        public EnumOptions.Builder addUninterpretedOption(UninterpretedOption uninterpretedoption)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                if (uninterpretedoption == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.add(uninterpretedoption);
                    onChanged();
                    return this;
                }
            } else
            {
                uninterpretedOptionBuilder_.addMessage(uninterpretedoption);
                return this;
            }
        }

        public EnumOptions build()
        {
            EnumOptions enumoptions = buildPartial();
            if (!enumoptions.isInitialized())
            {
                throw newUninitializedMessageException(enumoptions);
            } else
            {
                return enumoptions;
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

        public EnumOptions buildPartial()
        {
            EnumOptions enumoptions = new EnumOptions(this);
            int i = bitField0_;
            if (uninterpretedOptionBuilder_ == null)
            {
                if ((bitField0_ & 1) == 1)
                {
                    uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
                    bitField0_ = bitField0_ & -2;
                }
                enumoptions.uninterpretedOption_ = uninterpretedOption_;
            } else
            {
                enumoptions.uninterpretedOption_ = uninterpretedOptionBuilder_.build();
            }
            onBuilt();
            return enumoptions;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public EnumOptions.Builder clear()
        {
            super.clear();
            if (uninterpretedOptionBuilder_ == null)
            {
                uninterpretedOption_ = Collections.emptyList();
                bitField0_ = bitField0_ & -2;
                return this;
            } else
            {
                uninterpretedOptionBuilder_.clear();
                return this;
            }
        }

        public volatile GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile GeneratedMessage.ExtendableBuilder clear()
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

        public EnumOptions.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile GeneratedMessage.Builder clone()
        {
            return clone();
        }

        public volatile GeneratedMessage.ExtendableBuilder clone()
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

        public EnumOptions getDefaultInstanceForType()
        {
            return EnumOptions.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return EnumOptions.getDescriptor();
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return (UninterpretedOption)uninterpretedOption_.get(i);
            } else
            {
                return (UninterpretedOption)uninterpretedOptionBuilder_.getMessage(i);
            }
        }

        public int getUninterpretedOptionCount()
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return uninterpretedOption_.size();
            } else
            {
                return uninterpretedOptionBuilder_.getCount();
            }
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L7:
            if (i >= getUninterpretedOptionCount()) goto _L2; else goto _L1
_L1:
            if (getUninterpretedOption(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (!extensionsAreInitialized()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
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

        public EnumOptions.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

                case 7994: 
                    UninterpretedOption.Builder builder1 = UninterpretedOption.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addUninterpretedOption(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public EnumOptions.Builder mergeFrom(EnumOptions enumoptions)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (enumoptions == EnumOptions.getDefaultInstance())
            {
                return this;
            }
            if (uninterpretedOptionBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!enumoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOption_.isEmpty())
                {
                    uninterpretedOption_ = enumoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.addAll(enumoptions.uninterpretedOption_);
                }
                onChanged();
            }
_L4:
            mergeExtensionFields(enumoptions);
            mergeUnknownFields(enumoptions.getUnknownFields());
            return this;
_L2:
            if (!enumoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOptionBuilder_.isEmpty())
                {
                    uninterpretedOptionBuilder_.dispose();
                    uninterpretedOptionBuilder_ = null;
                    uninterpretedOption_ = enumoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & -2;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getUninterpretedOptionFieldBuilder();
                    }
                    uninterpretedOptionBuilder_ = repeatedfieldbuilder;
                } else
                {
                    uninterpretedOptionBuilder_.addAllMessages(enumoptions.uninterpretedOption_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public EnumOptions.Builder mergeFrom(Message message)
        {
            if (message instanceof EnumOptions)
            {
                return mergeFrom((EnumOptions)message);
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


        private EnumOptions.Builder()
        {
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private EnumOptions.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

    }

    public static interface EnumOptionsOrBuilder
        extends GeneratedMessage.ExtendableMessageOrBuilder
    {
    }

    public static final class EnumValueDescriptorProto extends GeneratedMessage
        implements EnumValueDescriptorProtoOrBuilder
    {

        private static final EnumValueDescriptorProto defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private int number_;
        private EnumValueOptions options_;

        public static EnumValueDescriptorProto getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_descriptor;
        }

        private ByteString getNameBytes()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                name_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private void initFields()
        {
            name_ = "";
            number_ = 0;
            options_ = EnumValueOptions.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(EnumValueDescriptorProto enumvaluedescriptorproto)
        {
            return newBuilder().mergeFrom(enumvaluedescriptorproto);
        }

        public EnumValueDescriptorProto getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public String getName()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                name_ = s;
            }
            return s;
        }

        public int getNumber()
        {
            return number_;
        }

        public EnumValueOptions getOptions()
        {
            return options_;
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            int j = 0;
            if ((bitField0_ & 1) == 1)
            {
                j = 0 + CodedOutputStream.computeBytesSize(1, getNameBytes());
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeInt32Size(2, number_);
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeMessageSize(3, options_);
            }
            i = j + getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public boolean hasName()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasNumber()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 4) == 4;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            if (hasOptions() && !getOptions().isInitialized())
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
            return new Builder(builderparent);
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
                codedoutputstream.writeBytes(1, getNameBytes());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeInt32(2, number_);
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeMessage(3, options_);
            }
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new EnumValueDescriptorProto(true);
            defaultInstance.initFields();
        }


/*
        static Object access$7702(EnumValueDescriptorProto enumvaluedescriptorproto, Object obj)
        {
            enumvaluedescriptorproto.name_ = obj;
            return obj;
        }

*/


/*
        static int access$7802(EnumValueDescriptorProto enumvaluedescriptorproto, int i)
        {
            enumvaluedescriptorproto.number_ = i;
            return i;
        }

*/


/*
        static EnumValueOptions access$7902(EnumValueDescriptorProto enumvaluedescriptorproto, EnumValueOptions enumvalueoptions)
        {
            enumvaluedescriptorproto.options_ = enumvalueoptions;
            return enumvalueoptions;
        }

*/


/*
        static int access$8002(EnumValueDescriptorProto enumvaluedescriptorproto, int i)
        {
            enumvaluedescriptorproto.bitField0_ = i;
            return i;
        }

*/

        private EnumValueDescriptorProto(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private EnumValueDescriptorProto(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class EnumValueDescriptorProto.Builder extends GeneratedMessage.Builder
        implements EnumValueDescriptorProtoOrBuilder
    {

        private int bitField0_;
        private Object name_;
        private int number_;
        private SingleFieldBuilder optionsBuilder_;
        private EnumValueOptions options_;

        private static EnumValueDescriptorProto.Builder create()
        {
            return new EnumValueDescriptorProto.Builder();
        }

        private SingleFieldBuilder getOptionsFieldBuilder()
        {
            if (optionsBuilder_ == null)
            {
                optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
                options_ = null;
            }
            return optionsBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getOptionsFieldBuilder();
            }
        }

        public EnumValueDescriptorProto build()
        {
            EnumValueDescriptorProto enumvaluedescriptorproto = buildPartial();
            if (!enumvaluedescriptorproto.isInitialized())
            {
                throw newUninitializedMessageException(enumvaluedescriptorproto);
            } else
            {
                return enumvaluedescriptorproto;
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

        public EnumValueDescriptorProto buildPartial()
        {
            int i = 1;
            EnumValueDescriptorProto enumvaluedescriptorproto = new EnumValueDescriptorProto(this);
            int k = bitField0_;
            int j;
            if ((k & 1) != 1)
            {
                i = 0;
            }
            enumvaluedescriptorproto.name_ = name_;
            j = i;
            if ((k & 2) == 2)
            {
                j = i | 2;
            }
            enumvaluedescriptorproto.number_ = number_;
            if ((k & 4) == 4)
            {
                i = j | 4;
            } else
            {
                i = j;
            }
            if (optionsBuilder_ == null)
            {
                enumvaluedescriptorproto.options_ = options_;
            } else
            {
                enumvaluedescriptorproto.options_ = (EnumValueOptions)optionsBuilder_.build();
            }
            enumvaluedescriptorproto.bitField0_ = i;
            onBuilt();
            return enumvaluedescriptorproto;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public EnumValueDescriptorProto.Builder clear()
        {
            super.clear();
            name_ = "";
            bitField0_ = bitField0_ & -2;
            number_ = 0;
            bitField0_ = bitField0_ & -3;
            if (optionsBuilder_ == null)
            {
                options_ = EnumValueOptions.getDefaultInstance();
            } else
            {
                optionsBuilder_.clear();
            }
            bitField0_ = bitField0_ & -5;
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

        public EnumValueDescriptorProto.Builder clone()
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

        public EnumValueDescriptorProto getDefaultInstanceForType()
        {
            return EnumValueDescriptorProto.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return EnumValueDescriptorProto.getDescriptor();
        }

        public EnumValueOptions getOptions()
        {
            if (optionsBuilder_ == null)
            {
                return options_;
            } else
            {
                return (EnumValueOptions)optionsBuilder_.getMessage();
            }
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 4) == 4;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            return !hasOptions() || getOptions().isInitialized();
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

        public EnumValueDescriptorProto.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
                    name_ = codedinputstream.readBytes();
                    break;

                case 16: // '\020'
                    bitField0_ = bitField0_ | 2;
                    number_ = codedinputstream.readInt32();
                    break;

                case 26: // '\032'
                    EnumValueOptions.Builder builder1 = EnumValueOptions.newBuilder();
                    if (hasOptions())
                    {
                        builder1.mergeFrom(getOptions());
                    }
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    setOptions(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public EnumValueDescriptorProto.Builder mergeFrom(EnumValueDescriptorProto enumvaluedescriptorproto)
        {
            if (enumvaluedescriptorproto == EnumValueDescriptorProto.getDefaultInstance())
            {
                return this;
            }
            if (enumvaluedescriptorproto.hasName())
            {
                setName(enumvaluedescriptorproto.getName());
            }
            if (enumvaluedescriptorproto.hasNumber())
            {
                setNumber(enumvaluedescriptorproto.getNumber());
            }
            if (enumvaluedescriptorproto.hasOptions())
            {
                mergeOptions(enumvaluedescriptorproto.getOptions());
            }
            mergeUnknownFields(enumvaluedescriptorproto.getUnknownFields());
            return this;
        }

        public EnumValueDescriptorProto.Builder mergeFrom(Message message)
        {
            if (message instanceof EnumValueDescriptorProto)
            {
                return mergeFrom((EnumValueDescriptorProto)message);
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

        public EnumValueDescriptorProto.Builder mergeOptions(EnumValueOptions enumvalueoptions)
        {
            if (optionsBuilder_ == null)
            {
                if ((bitField0_ & 4) == 4 && options_ != EnumValueOptions.getDefaultInstance())
                {
                    options_ = EnumValueOptions.newBuilder(options_).mergeFrom(enumvalueoptions).buildPartial();
                } else
                {
                    options_ = enumvalueoptions;
                }
                onChanged();
            } else
            {
                optionsBuilder_.mergeFrom(enumvalueoptions);
            }
            bitField0_ = bitField0_ | 4;
            return this;
        }

        public EnumValueDescriptorProto.Builder setName(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                name_ = s;
                onChanged();
                return this;
            }
        }

        public EnumValueDescriptorProto.Builder setNumber(int i)
        {
            bitField0_ = bitField0_ | 2;
            number_ = i;
            onChanged();
            return this;
        }

        public EnumValueDescriptorProto.Builder setOptions(EnumValueOptions enumvalueoptions)
        {
            if (optionsBuilder_ == null)
            {
                if (enumvalueoptions == null)
                {
                    throw new NullPointerException();
                }
                options_ = enumvalueoptions;
                onChanged();
            } else
            {
                optionsBuilder_.setMessage(enumvalueoptions);
            }
            bitField0_ = bitField0_ | 4;
            return this;
        }


        private EnumValueDescriptorProto.Builder()
        {
            name_ = "";
            options_ = EnumValueOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        private EnumValueDescriptorProto.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            options_ = EnumValueOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

    }

    public static interface EnumValueDescriptorProtoOrBuilder
        extends MessageOrBuilder
    {
    }

    public static final class EnumValueOptions extends GeneratedMessage.ExtendableMessage
        implements EnumValueOptionsOrBuilder
    {

        private static final EnumValueOptions defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List uninterpretedOption_;

        public static EnumValueOptions getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
        }

        private void initFields()
        {
            uninterpretedOption_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(EnumValueOptions enumvalueoptions)
        {
            return newBuilder().mergeFrom(enumvalueoptions);
        }

        public EnumValueOptions getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            int j = 0;
            for (; i < uninterpretedOption_.size(); i++)
            {
                j += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
            }

            i = extensionsSerializedSize() + j + getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            return (UninterpretedOption)uninterpretedOption_.get(i);
        }

        public int getUninterpretedOptionCount()
        {
            return uninterpretedOption_.size();
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++)
            {
                if (!getUninterpretedOption(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (!extensionsAreInitialized())
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
            return new Builder(builderparent);
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
            GeneratedMessage.ExtendableMessage.ExtensionWriter extensionwriter = newExtensionWriter();
            for (int i = 0; i < uninterpretedOption_.size(); i++)
            {
                codedoutputstream.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
            }

            extensionwriter.writeUntil(0x20000000, codedoutputstream);
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new EnumValueOptions(true);
            defaultInstance.initFields();
        }



/*
        static List access$15302(EnumValueOptions enumvalueoptions, List list)
        {
            enumvalueoptions.uninterpretedOption_ = list;
            return list;
        }

*/

        private EnumValueOptions(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private EnumValueOptions(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class EnumValueOptions.Builder extends GeneratedMessage.ExtendableBuilder
        implements EnumValueOptionsOrBuilder
    {

        private int bitField0_;
        private RepeatedFieldBuilder uninterpretedOptionBuilder_;
        private List uninterpretedOption_;

        private static EnumValueOptions.Builder create()
        {
            return new EnumValueOptions.Builder();
        }

        private void ensureUninterpretedOptionIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                uninterpretedOption_ = new ArrayList(uninterpretedOption_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder()
        {
            boolean flag = true;
            if (uninterpretedOptionBuilder_ == null)
            {
                List list = uninterpretedOption_;
                if ((bitField0_ & 1) != 1)
                {
                    flag = false;
                }
                uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                uninterpretedOption_ = null;
            }
            return uninterpretedOptionBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getUninterpretedOptionFieldBuilder();
            }
        }

        public EnumValueOptions.Builder addUninterpretedOption(UninterpretedOption uninterpretedoption)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                if (uninterpretedoption == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.add(uninterpretedoption);
                    onChanged();
                    return this;
                }
            } else
            {
                uninterpretedOptionBuilder_.addMessage(uninterpretedoption);
                return this;
            }
        }

        public EnumValueOptions build()
        {
            EnumValueOptions enumvalueoptions = buildPartial();
            if (!enumvalueoptions.isInitialized())
            {
                throw newUninitializedMessageException(enumvalueoptions);
            } else
            {
                return enumvalueoptions;
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

        public EnumValueOptions buildPartial()
        {
            EnumValueOptions enumvalueoptions = new EnumValueOptions(this);
            int i = bitField0_;
            if (uninterpretedOptionBuilder_ == null)
            {
                if ((bitField0_ & 1) == 1)
                {
                    uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
                    bitField0_ = bitField0_ & -2;
                }
                enumvalueoptions.uninterpretedOption_ = uninterpretedOption_;
            } else
            {
                enumvalueoptions.uninterpretedOption_ = uninterpretedOptionBuilder_.build();
            }
            onBuilt();
            return enumvalueoptions;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public EnumValueOptions.Builder clear()
        {
            super.clear();
            if (uninterpretedOptionBuilder_ == null)
            {
                uninterpretedOption_ = Collections.emptyList();
                bitField0_ = bitField0_ & -2;
                return this;
            } else
            {
                uninterpretedOptionBuilder_.clear();
                return this;
            }
        }

        public volatile GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile GeneratedMessage.ExtendableBuilder clear()
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

        public EnumValueOptions.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile GeneratedMessage.Builder clone()
        {
            return clone();
        }

        public volatile GeneratedMessage.ExtendableBuilder clone()
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

        public EnumValueOptions getDefaultInstanceForType()
        {
            return EnumValueOptions.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return EnumValueOptions.getDescriptor();
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return (UninterpretedOption)uninterpretedOption_.get(i);
            } else
            {
                return (UninterpretedOption)uninterpretedOptionBuilder_.getMessage(i);
            }
        }

        public int getUninterpretedOptionCount()
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return uninterpretedOption_.size();
            } else
            {
                return uninterpretedOptionBuilder_.getCount();
            }
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L7:
            if (i >= getUninterpretedOptionCount()) goto _L2; else goto _L1
_L1:
            if (getUninterpretedOption(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (!extensionsAreInitialized()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
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

        public EnumValueOptions.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

                case 7994: 
                    UninterpretedOption.Builder builder1 = UninterpretedOption.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addUninterpretedOption(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public EnumValueOptions.Builder mergeFrom(EnumValueOptions enumvalueoptions)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (enumvalueoptions == EnumValueOptions.getDefaultInstance())
            {
                return this;
            }
            if (uninterpretedOptionBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!enumvalueoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOption_.isEmpty())
                {
                    uninterpretedOption_ = enumvalueoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.addAll(enumvalueoptions.uninterpretedOption_);
                }
                onChanged();
            }
_L4:
            mergeExtensionFields(enumvalueoptions);
            mergeUnknownFields(enumvalueoptions.getUnknownFields());
            return this;
_L2:
            if (!enumvalueoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOptionBuilder_.isEmpty())
                {
                    uninterpretedOptionBuilder_.dispose();
                    uninterpretedOptionBuilder_ = null;
                    uninterpretedOption_ = enumvalueoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & -2;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getUninterpretedOptionFieldBuilder();
                    }
                    uninterpretedOptionBuilder_ = repeatedfieldbuilder;
                } else
                {
                    uninterpretedOptionBuilder_.addAllMessages(enumvalueoptions.uninterpretedOption_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public EnumValueOptions.Builder mergeFrom(Message message)
        {
            if (message instanceof EnumValueOptions)
            {
                return mergeFrom((EnumValueOptions)message);
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


        private EnumValueOptions.Builder()
        {
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private EnumValueOptions.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

    }

    public static interface EnumValueOptionsOrBuilder
        extends GeneratedMessage.ExtendableMessageOrBuilder
    {
    }

    public static final class FieldDescriptorProto extends GeneratedMessage
        implements FieldDescriptorProtoOrBuilder
    {

        private static final FieldDescriptorProto defaultInstance;
        private int bitField0_;
        private Object defaultValue_;
        private Object extendee_;
        private Label label_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private int number_;
        private FieldOptions options_;
        private Object typeName_;
        private Type type_;

        public static FieldDescriptorProto getDefaultInstance()
        {
            return defaultInstance;
        }

        private ByteString getDefaultValueBytes()
        {
            Object obj = defaultValue_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                defaultValue_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
        }

        private ByteString getExtendeeBytes()
        {
            Object obj = extendee_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                extendee_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private ByteString getNameBytes()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                name_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private ByteString getTypeNameBytes()
        {
            Object obj = typeName_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                typeName_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private void initFields()
        {
            name_ = "";
            number_ = 0;
            label_ = Label.LABEL_OPTIONAL;
            type_ = Type.TYPE_DOUBLE;
            typeName_ = "";
            extendee_ = "";
            defaultValue_ = "";
            options_ = FieldOptions.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(FieldDescriptorProto fielddescriptorproto)
        {
            return newBuilder().mergeFrom(fielddescriptorproto);
        }

        public FieldDescriptorProto getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public String getDefaultValue()
        {
            Object obj = defaultValue_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                defaultValue_ = s;
            }
            return s;
        }

        public String getExtendee()
        {
            Object obj = extendee_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                extendee_ = s;
            }
            return s;
        }

        public Label getLabel()
        {
            return label_;
        }

        public String getName()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                name_ = s;
            }
            return s;
        }

        public int getNumber()
        {
            return number_;
        }

        public FieldOptions getOptions()
        {
            return options_;
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            int j = 0;
            if ((bitField0_ & 1) == 1)
            {
                j = 0 + CodedOutputStream.computeBytesSize(1, getNameBytes());
            }
            i = j;
            if ((bitField0_ & 0x20) == 32)
            {
                i = j + CodedOutputStream.computeBytesSize(2, getExtendeeBytes());
            }
            j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeInt32Size(3, number_);
            }
            i = j;
            if ((bitField0_ & 4) == 4)
            {
                i = j + CodedOutputStream.computeEnumSize(4, label_.getNumber());
            }
            j = i;
            if ((bitField0_ & 8) == 8)
            {
                j = i + CodedOutputStream.computeEnumSize(5, type_.getNumber());
            }
            i = j;
            if ((bitField0_ & 0x10) == 16)
            {
                i = j + CodedOutputStream.computeBytesSize(6, getTypeNameBytes());
            }
            j = i;
            if ((bitField0_ & 0x40) == 64)
            {
                j = i + CodedOutputStream.computeBytesSize(7, getDefaultValueBytes());
            }
            i = j;
            if ((bitField0_ & 0x80) == 128)
            {
                i = j + CodedOutputStream.computeMessageSize(8, options_);
            }
            i += getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public Type getType()
        {
            return type_;
        }

        public String getTypeName()
        {
            Object obj = typeName_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                typeName_ = s;
            }
            return s;
        }

        public boolean hasDefaultValue()
        {
            return (bitField0_ & 0x40) == 64;
        }

        public boolean hasExtendee()
        {
            return (bitField0_ & 0x20) == 32;
        }

        public boolean hasLabel()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasName()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasNumber()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 0x80) == 128;
        }

        public boolean hasType()
        {
            return (bitField0_ & 8) == 8;
        }

        public boolean hasTypeName()
        {
            return (bitField0_ & 0x10) == 16;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            if (hasOptions() && !getOptions().isInitialized())
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
            return new Builder(builderparent);
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
                codedoutputstream.writeBytes(1, getNameBytes());
            }
            if ((bitField0_ & 0x20) == 32)
            {
                codedoutputstream.writeBytes(2, getExtendeeBytes());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeInt32(3, number_);
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeEnum(4, label_.getNumber());
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeEnum(5, type_.getNumber());
            }
            if ((bitField0_ & 0x10) == 16)
            {
                codedoutputstream.writeBytes(6, getTypeNameBytes());
            }
            if ((bitField0_ & 0x40) == 64)
            {
                codedoutputstream.writeBytes(7, getDefaultValueBytes());
            }
            if ((bitField0_ & 0x80) == 128)
            {
                codedoutputstream.writeMessage(8, options_);
            }
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new FieldDescriptorProto(true);
            defaultInstance.initFields();
        }


/*
        static Object access$5202(FieldDescriptorProto fielddescriptorproto, Object obj)
        {
            fielddescriptorproto.name_ = obj;
            return obj;
        }

*/


/*
        static int access$5302(FieldDescriptorProto fielddescriptorproto, int i)
        {
            fielddescriptorproto.number_ = i;
            return i;
        }

*/


/*
        static Label access$5402(FieldDescriptorProto fielddescriptorproto, Label label)
        {
            fielddescriptorproto.label_ = label;
            return label;
        }

*/


/*
        static Type access$5502(FieldDescriptorProto fielddescriptorproto, Type type)
        {
            fielddescriptorproto.type_ = type;
            return type;
        }

*/


/*
        static Object access$5602(FieldDescriptorProto fielddescriptorproto, Object obj)
        {
            fielddescriptorproto.typeName_ = obj;
            return obj;
        }

*/


/*
        static Object access$5702(FieldDescriptorProto fielddescriptorproto, Object obj)
        {
            fielddescriptorproto.extendee_ = obj;
            return obj;
        }

*/


/*
        static Object access$5802(FieldDescriptorProto fielddescriptorproto, Object obj)
        {
            fielddescriptorproto.defaultValue_ = obj;
            return obj;
        }

*/


/*
        static FieldOptions access$5902(FieldDescriptorProto fielddescriptorproto, FieldOptions fieldoptions)
        {
            fielddescriptorproto.options_ = fieldoptions;
            return fieldoptions;
        }

*/


/*
        static int access$6002(FieldDescriptorProto fielddescriptorproto, int i)
        {
            fielddescriptorproto.bitField0_ = i;
            return i;
        }

*/

        private FieldDescriptorProto(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private FieldDescriptorProto(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class FieldDescriptorProto.Builder extends GeneratedMessage.Builder
        implements FieldDescriptorProtoOrBuilder
    {

        private int bitField0_;
        private Object defaultValue_;
        private Object extendee_;
        private FieldDescriptorProto.Label label_;
        private Object name_;
        private int number_;
        private SingleFieldBuilder optionsBuilder_;
        private FieldOptions options_;
        private Object typeName_;
        private FieldDescriptorProto.Type type_;

        private static FieldDescriptorProto.Builder create()
        {
            return new FieldDescriptorProto.Builder();
        }

        private SingleFieldBuilder getOptionsFieldBuilder()
        {
            if (optionsBuilder_ == null)
            {
                optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
                options_ = null;
            }
            return optionsBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getOptionsFieldBuilder();
            }
        }

        public FieldDescriptorProto build()
        {
            FieldDescriptorProto fielddescriptorproto = buildPartial();
            if (!fielddescriptorproto.isInitialized())
            {
                throw newUninitializedMessageException(fielddescriptorproto);
            } else
            {
                return fielddescriptorproto;
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

        public FieldDescriptorProto buildPartial()
        {
            int j = 1;
            FieldDescriptorProto fielddescriptorproto = new FieldDescriptorProto(this);
            int k = bitField0_;
            int i;
            if ((k & 1) != 1)
            {
                j = 0;
            }
            fielddescriptorproto.name_ = name_;
            i = j;
            if ((k & 2) == 2)
            {
                i = j | 2;
            }
            fielddescriptorproto.number_ = number_;
            j = i;
            if ((k & 4) == 4)
            {
                j = i | 4;
            }
            fielddescriptorproto.label_ = label_;
            i = j;
            if ((k & 8) == 8)
            {
                i = j | 8;
            }
            fielddescriptorproto.type_ = type_;
            j = i;
            if ((k & 0x10) == 16)
            {
                j = i | 0x10;
            }
            fielddescriptorproto.typeName_ = typeName_;
            i = j;
            if ((k & 0x20) == 32)
            {
                i = j | 0x20;
            }
            fielddescriptorproto.extendee_ = extendee_;
            j = i;
            if ((k & 0x40) == 64)
            {
                j = i | 0x40;
            }
            fielddescriptorproto.defaultValue_ = defaultValue_;
            if ((k & 0x80) == 128)
            {
                i = j | 0x80;
            } else
            {
                i = j;
            }
            if (optionsBuilder_ == null)
            {
                fielddescriptorproto.options_ = options_;
            } else
            {
                fielddescriptorproto.options_ = (FieldOptions)optionsBuilder_.build();
            }
            fielddescriptorproto.bitField0_ = i;
            onBuilt();
            return fielddescriptorproto;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public FieldDescriptorProto.Builder clear()
        {
            super.clear();
            name_ = "";
            bitField0_ = bitField0_ & -2;
            number_ = 0;
            bitField0_ = bitField0_ & -3;
            label_ = FieldDescriptorProto.Label.LABEL_OPTIONAL;
            bitField0_ = bitField0_ & -5;
            type_ = FieldDescriptorProto.Type.TYPE_DOUBLE;
            bitField0_ = bitField0_ & -9;
            typeName_ = "";
            bitField0_ = bitField0_ & 0xffffffef;
            extendee_ = "";
            bitField0_ = bitField0_ & 0xffffffdf;
            defaultValue_ = "";
            bitField0_ = bitField0_ & 0xffffffbf;
            if (optionsBuilder_ == null)
            {
                options_ = FieldOptions.getDefaultInstance();
            } else
            {
                optionsBuilder_.clear();
            }
            bitField0_ = bitField0_ & 0xffffff7f;
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

        public FieldDescriptorProto.Builder clone()
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

        public FieldDescriptorProto getDefaultInstanceForType()
        {
            return FieldDescriptorProto.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return FieldDescriptorProto.getDescriptor();
        }

        public FieldOptions getOptions()
        {
            if (optionsBuilder_ == null)
            {
                return options_;
            } else
            {
                return (FieldOptions)optionsBuilder_.getMessage();
            }
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 0x80) == 128;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            return !hasOptions() || getOptions().isInitialized();
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

        public FieldDescriptorProto.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
                    name_ = codedinputstream.readBytes();
                    break;

                case 18: // '\022'
                    bitField0_ = bitField0_ | 0x20;
                    extendee_ = codedinputstream.readBytes();
                    break;

                case 24: // '\030'
                    bitField0_ = bitField0_ | 2;
                    number_ = codedinputstream.readInt32();
                    break;

                case 32: // ' '
                    int j = codedinputstream.readEnum();
                    FieldDescriptorProto.Label label = FieldDescriptorProto.Label.valueOf(j);
                    if (label == null)
                    {
                        builder.mergeVarintField(4, j);
                    } else
                    {
                        bitField0_ = bitField0_ | 4;
                        label_ = label;
                    }
                    break;

                case 40: // '('
                    int k = codedinputstream.readEnum();
                    FieldDescriptorProto.Type type = FieldDescriptorProto.Type.valueOf(k);
                    if (type == null)
                    {
                        builder.mergeVarintField(5, k);
                    } else
                    {
                        bitField0_ = bitField0_ | 8;
                        type_ = type;
                    }
                    break;

                case 50: // '2'
                    bitField0_ = bitField0_ | 0x10;
                    typeName_ = codedinputstream.readBytes();
                    break;

                case 58: // ':'
                    bitField0_ = bitField0_ | 0x40;
                    defaultValue_ = codedinputstream.readBytes();
                    break;

                case 66: // 'B'
                    FieldOptions.Builder builder1 = FieldOptions.newBuilder();
                    if (hasOptions())
                    {
                        builder1.mergeFrom(getOptions());
                    }
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    setOptions(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public FieldDescriptorProto.Builder mergeFrom(FieldDescriptorProto fielddescriptorproto)
        {
            if (fielddescriptorproto == FieldDescriptorProto.getDefaultInstance())
            {
                return this;
            }
            if (fielddescriptorproto.hasName())
            {
                setName(fielddescriptorproto.getName());
            }
            if (fielddescriptorproto.hasNumber())
            {
                setNumber(fielddescriptorproto.getNumber());
            }
            if (fielddescriptorproto.hasLabel())
            {
                setLabel(fielddescriptorproto.getLabel());
            }
            if (fielddescriptorproto.hasType())
            {
                setType(fielddescriptorproto.getType());
            }
            if (fielddescriptorproto.hasTypeName())
            {
                setTypeName(fielddescriptorproto.getTypeName());
            }
            if (fielddescriptorproto.hasExtendee())
            {
                setExtendee(fielddescriptorproto.getExtendee());
            }
            if (fielddescriptorproto.hasDefaultValue())
            {
                setDefaultValue(fielddescriptorproto.getDefaultValue());
            }
            if (fielddescriptorproto.hasOptions())
            {
                mergeOptions(fielddescriptorproto.getOptions());
            }
            mergeUnknownFields(fielddescriptorproto.getUnknownFields());
            return this;
        }

        public FieldDescriptorProto.Builder mergeFrom(Message message)
        {
            if (message instanceof FieldDescriptorProto)
            {
                return mergeFrom((FieldDescriptorProto)message);
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

        public FieldDescriptorProto.Builder mergeOptions(FieldOptions fieldoptions)
        {
            if (optionsBuilder_ == null)
            {
                if ((bitField0_ & 0x80) == 128 && options_ != FieldOptions.getDefaultInstance())
                {
                    options_ = FieldOptions.newBuilder(options_).mergeFrom(fieldoptions).buildPartial();
                } else
                {
                    options_ = fieldoptions;
                }
                onChanged();
            } else
            {
                optionsBuilder_.mergeFrom(fieldoptions);
            }
            bitField0_ = bitField0_ | 0x80;
            return this;
        }

        public FieldDescriptorProto.Builder setDefaultValue(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x40;
                defaultValue_ = s;
                onChanged();
                return this;
            }
        }

        public FieldDescriptorProto.Builder setExtendee(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x20;
                extendee_ = s;
                onChanged();
                return this;
            }
        }

        public FieldDescriptorProto.Builder setLabel(FieldDescriptorProto.Label label)
        {
            if (label == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                label_ = label;
                onChanged();
                return this;
            }
        }

        public FieldDescriptorProto.Builder setName(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                name_ = s;
                onChanged();
                return this;
            }
        }

        public FieldDescriptorProto.Builder setNumber(int i)
        {
            bitField0_ = bitField0_ | 2;
            number_ = i;
            onChanged();
            return this;
        }

        public FieldDescriptorProto.Builder setOptions(FieldOptions fieldoptions)
        {
            if (optionsBuilder_ == null)
            {
                if (fieldoptions == null)
                {
                    throw new NullPointerException();
                }
                options_ = fieldoptions;
                onChanged();
            } else
            {
                optionsBuilder_.setMessage(fieldoptions);
            }
            bitField0_ = bitField0_ | 0x80;
            return this;
        }

        public FieldDescriptorProto.Builder setType(FieldDescriptorProto.Type type)
        {
            if (type == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 8;
                type_ = type;
                onChanged();
                return this;
            }
        }

        public FieldDescriptorProto.Builder setTypeName(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x10;
                typeName_ = s;
                onChanged();
                return this;
            }
        }


        private FieldDescriptorProto.Builder()
        {
            name_ = "";
            label_ = FieldDescriptorProto.Label.LABEL_OPTIONAL;
            type_ = FieldDescriptorProto.Type.TYPE_DOUBLE;
            typeName_ = "";
            extendee_ = "";
            defaultValue_ = "";
            options_ = FieldOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        private FieldDescriptorProto.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            label_ = FieldDescriptorProto.Label.LABEL_OPTIONAL;
            type_ = FieldDescriptorProto.Type.TYPE_DOUBLE;
            typeName_ = "";
            extendee_ = "";
            defaultValue_ = "";
            options_ = FieldOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

    }

    public static final class FieldDescriptorProto.Label extends Enum
        implements ProtocolMessageEnum
    {

        private static final FieldDescriptorProto.Label $VALUES[];
        public static final FieldDescriptorProto.Label LABEL_OPTIONAL;
        public static final FieldDescriptorProto.Label LABEL_REPEATED;
        public static final FieldDescriptorProto.Label LABEL_REQUIRED;
        private static final FieldDescriptorProto.Label VALUES[];
        private static Internal.EnumLiteMap internalValueMap = new Internal.EnumLiteMap() {

        };
        private final int index;
        private final int value;

        public static FieldDescriptorProto.Label valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return LABEL_OPTIONAL;

            case 2: // '\002'
                return LABEL_REQUIRED;

            case 3: // '\003'
                return LABEL_REPEATED;
            }
        }

        public static FieldDescriptorProto.Label valueOf(String s)
        {
            return (FieldDescriptorProto.Label)Enum.valueOf(com/google/protobuf/DescriptorProtos$FieldDescriptorProto$Label, s);
        }

        public static FieldDescriptorProto.Label[] values()
        {
            return (FieldDescriptorProto.Label[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            LABEL_OPTIONAL = new FieldDescriptorProto.Label("LABEL_OPTIONAL", 0, 0, 1);
            LABEL_REQUIRED = new FieldDescriptorProto.Label("LABEL_REQUIRED", 1, 1, 2);
            LABEL_REPEATED = new FieldDescriptorProto.Label("LABEL_REPEATED", 2, 2, 3);
            $VALUES = (new FieldDescriptorProto.Label[] {
                LABEL_OPTIONAL, LABEL_REQUIRED, LABEL_REPEATED
            });
            VALUES = (new FieldDescriptorProto.Label[] {
                LABEL_OPTIONAL, LABEL_REQUIRED, LABEL_REPEATED
            });
        }

        private FieldDescriptorProto.Label(String s, int i, int j, int k)
        {
            super(s, i);
            index = j;
            value = k;
        }
    }

    public static final class FieldDescriptorProto.Type extends Enum
        implements ProtocolMessageEnum
    {

        private static final FieldDescriptorProto.Type $VALUES[];
        public static final FieldDescriptorProto.Type TYPE_BOOL;
        public static final FieldDescriptorProto.Type TYPE_BYTES;
        public static final FieldDescriptorProto.Type TYPE_DOUBLE;
        public static final FieldDescriptorProto.Type TYPE_ENUM;
        public static final FieldDescriptorProto.Type TYPE_FIXED32;
        public static final FieldDescriptorProto.Type TYPE_FIXED64;
        public static final FieldDescriptorProto.Type TYPE_FLOAT;
        public static final FieldDescriptorProto.Type TYPE_GROUP;
        public static final FieldDescriptorProto.Type TYPE_INT32;
        public static final FieldDescriptorProto.Type TYPE_INT64;
        public static final FieldDescriptorProto.Type TYPE_MESSAGE;
        public static final FieldDescriptorProto.Type TYPE_SFIXED32;
        public static final FieldDescriptorProto.Type TYPE_SFIXED64;
        public static final FieldDescriptorProto.Type TYPE_SINT32;
        public static final FieldDescriptorProto.Type TYPE_SINT64;
        public static final FieldDescriptorProto.Type TYPE_STRING;
        public static final FieldDescriptorProto.Type TYPE_UINT32;
        public static final FieldDescriptorProto.Type TYPE_UINT64;
        private static final FieldDescriptorProto.Type VALUES[];
        private static Internal.EnumLiteMap internalValueMap = new Internal.EnumLiteMap() {

        };
        private final int index;
        private final int value;

        public static FieldDescriptorProto.Type valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return TYPE_DOUBLE;

            case 2: // '\002'
                return TYPE_FLOAT;

            case 3: // '\003'
                return TYPE_INT64;

            case 4: // '\004'
                return TYPE_UINT64;

            case 5: // '\005'
                return TYPE_INT32;

            case 6: // '\006'
                return TYPE_FIXED64;

            case 7: // '\007'
                return TYPE_FIXED32;

            case 8: // '\b'
                return TYPE_BOOL;

            case 9: // '\t'
                return TYPE_STRING;

            case 10: // '\n'
                return TYPE_GROUP;

            case 11: // '\013'
                return TYPE_MESSAGE;

            case 12: // '\f'
                return TYPE_BYTES;

            case 13: // '\r'
                return TYPE_UINT32;

            case 14: // '\016'
                return TYPE_ENUM;

            case 15: // '\017'
                return TYPE_SFIXED32;

            case 16: // '\020'
                return TYPE_SFIXED64;

            case 17: // '\021'
                return TYPE_SINT32;

            case 18: // '\022'
                return TYPE_SINT64;
            }
        }

        public static FieldDescriptorProto.Type valueOf(String s)
        {
            return (FieldDescriptorProto.Type)Enum.valueOf(com/google/protobuf/DescriptorProtos$FieldDescriptorProto$Type, s);
        }

        public static FieldDescriptorProto.Type[] values()
        {
            return (FieldDescriptorProto.Type[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            TYPE_DOUBLE = new FieldDescriptorProto.Type("TYPE_DOUBLE", 0, 0, 1);
            TYPE_FLOAT = new FieldDescriptorProto.Type("TYPE_FLOAT", 1, 1, 2);
            TYPE_INT64 = new FieldDescriptorProto.Type("TYPE_INT64", 2, 2, 3);
            TYPE_UINT64 = new FieldDescriptorProto.Type("TYPE_UINT64", 3, 3, 4);
            TYPE_INT32 = new FieldDescriptorProto.Type("TYPE_INT32", 4, 4, 5);
            TYPE_FIXED64 = new FieldDescriptorProto.Type("TYPE_FIXED64", 5, 5, 6);
            TYPE_FIXED32 = new FieldDescriptorProto.Type("TYPE_FIXED32", 6, 6, 7);
            TYPE_BOOL = new FieldDescriptorProto.Type("TYPE_BOOL", 7, 7, 8);
            TYPE_STRING = new FieldDescriptorProto.Type("TYPE_STRING", 8, 8, 9);
            TYPE_GROUP = new FieldDescriptorProto.Type("TYPE_GROUP", 9, 9, 10);
            TYPE_MESSAGE = new FieldDescriptorProto.Type("TYPE_MESSAGE", 10, 10, 11);
            TYPE_BYTES = new FieldDescriptorProto.Type("TYPE_BYTES", 11, 11, 12);
            TYPE_UINT32 = new FieldDescriptorProto.Type("TYPE_UINT32", 12, 12, 13);
            TYPE_ENUM = new FieldDescriptorProto.Type("TYPE_ENUM", 13, 13, 14);
            TYPE_SFIXED32 = new FieldDescriptorProto.Type("TYPE_SFIXED32", 14, 14, 15);
            TYPE_SFIXED64 = new FieldDescriptorProto.Type("TYPE_SFIXED64", 15, 15, 16);
            TYPE_SINT32 = new FieldDescriptorProto.Type("TYPE_SINT32", 16, 16, 17);
            TYPE_SINT64 = new FieldDescriptorProto.Type("TYPE_SINT64", 17, 17, 18);
            $VALUES = (new FieldDescriptorProto.Type[] {
                TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, TYPE_GROUP, 
                TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64
            });
            VALUES = (new FieldDescriptorProto.Type[] {
                TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, TYPE_GROUP, 
                TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64
            });
        }

        private FieldDescriptorProto.Type(String s, int i, int j, int k)
        {
            super(s, i);
            index = j;
            value = k;
        }
    }

    public static interface FieldDescriptorProtoOrBuilder
        extends MessageOrBuilder
    {
    }

    public static final class FieldOptions extends GeneratedMessage.ExtendableMessage
        implements FieldOptionsOrBuilder
    {

        private static final FieldOptions defaultInstance;
        private int bitField0_;
        private CType ctype_;
        private boolean deprecated_;
        private Object experimentalMapKey_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean packed_;
        private List uninterpretedOption_;

        public static FieldOptions getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
        }

        private ByteString getExperimentalMapKeyBytes()
        {
            Object obj = experimentalMapKey_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                experimentalMapKey_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private void initFields()
        {
            ctype_ = CType.STRING;
            packed_ = false;
            deprecated_ = false;
            experimentalMapKey_ = "";
            uninterpretedOption_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(FieldOptions fieldoptions)
        {
            return newBuilder().mergeFrom(fieldoptions);
        }

        public CType getCtype()
        {
            return ctype_;
        }

        public FieldOptions getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public boolean getDeprecated()
        {
            return deprecated_;
        }

        public String getExperimentalMapKey()
        {
            Object obj = experimentalMapKey_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                experimentalMapKey_ = s;
            }
            return s;
        }

        public boolean getPacked()
        {
            return packed_;
        }

        public int getSerializedSize()
        {
            boolean flag = false;
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            int j;
            if ((bitField0_ & 1) == 1)
            {
                j = CodedOutputStream.computeEnumSize(1, ctype_.getNumber()) + 0;
            } else
            {
                j = 0;
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeBoolSize(2, packed_);
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeBoolSize(3, deprecated_);
            }
            i = j;
            if ((bitField0_ & 8) == 8)
            {
                i = j + CodedOutputStream.computeBytesSize(9, getExperimentalMapKeyBytes());
            }
            for (j = ((flag) ? 1 : 0); j < uninterpretedOption_.size();)
            {
                int k = CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(j));
                j++;
                i = k + i;
            }

            i = extensionsSerializedSize() + i + getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            return (UninterpretedOption)uninterpretedOption_.get(i);
        }

        public int getUninterpretedOptionCount()
        {
            return uninterpretedOption_.size();
        }

        public boolean hasCtype()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasDeprecated()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasExperimentalMapKey()
        {
            return (bitField0_ & 8) == 8;
        }

        public boolean hasPacked()
        {
            return (bitField0_ & 2) == 2;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++)
            {
                if (!getUninterpretedOption(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (!extensionsAreInitialized())
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
            return new Builder(builderparent);
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
            GeneratedMessage.ExtendableMessage.ExtensionWriter extensionwriter = newExtensionWriter();
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeEnum(1, ctype_.getNumber());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBool(2, packed_);
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeBool(3, deprecated_);
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeBytes(9, getExperimentalMapKeyBytes());
            }
            for (int i = 0; i < uninterpretedOption_.size(); i++)
            {
                codedoutputstream.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
            }

            extensionwriter.writeUntil(0x20000000, codedoutputstream);
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new FieldOptions(true);
            defaultInstance.initFields();
        }


/*
        static CType access$13402(FieldOptions fieldoptions, CType ctype)
        {
            fieldoptions.ctype_ = ctype;
            return ctype;
        }

*/


/*
        static boolean access$13502(FieldOptions fieldoptions, boolean flag)
        {
            fieldoptions.packed_ = flag;
            return flag;
        }

*/


/*
        static boolean access$13602(FieldOptions fieldoptions, boolean flag)
        {
            fieldoptions.deprecated_ = flag;
            return flag;
        }

*/


/*
        static Object access$13702(FieldOptions fieldoptions, Object obj)
        {
            fieldoptions.experimentalMapKey_ = obj;
            return obj;
        }

*/



/*
        static List access$13802(FieldOptions fieldoptions, List list)
        {
            fieldoptions.uninterpretedOption_ = list;
            return list;
        }

*/


/*
        static int access$13902(FieldOptions fieldoptions, int i)
        {
            fieldoptions.bitField0_ = i;
            return i;
        }

*/

        private FieldOptions(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private FieldOptions(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class FieldOptions.Builder extends GeneratedMessage.ExtendableBuilder
        implements FieldOptionsOrBuilder
    {

        private int bitField0_;
        private FieldOptions.CType ctype_;
        private boolean deprecated_;
        private Object experimentalMapKey_;
        private boolean packed_;
        private RepeatedFieldBuilder uninterpretedOptionBuilder_;
        private List uninterpretedOption_;

        private static FieldOptions.Builder create()
        {
            return new FieldOptions.Builder();
        }

        private void ensureUninterpretedOptionIsMutable()
        {
            if ((bitField0_ & 0x10) != 16)
            {
                uninterpretedOption_ = new ArrayList(uninterpretedOption_);
                bitField0_ = bitField0_ | 0x10;
            }
        }

        private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder()
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                List list = uninterpretedOption_;
                boolean flag;
                if ((bitField0_ & 0x10) == 16)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                uninterpretedOption_ = null;
            }
            return uninterpretedOptionBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getUninterpretedOptionFieldBuilder();
            }
        }

        public FieldOptions.Builder addUninterpretedOption(UninterpretedOption uninterpretedoption)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                if (uninterpretedoption == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.add(uninterpretedoption);
                    onChanged();
                    return this;
                }
            } else
            {
                uninterpretedOptionBuilder_.addMessage(uninterpretedoption);
                return this;
            }
        }

        public FieldOptions build()
        {
            FieldOptions fieldoptions = buildPartial();
            if (!fieldoptions.isInitialized())
            {
                throw newUninitializedMessageException(fieldoptions);
            } else
            {
                return fieldoptions;
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

        public FieldOptions buildPartial()
        {
            int j = 1;
            FieldOptions fieldoptions = new FieldOptions(this);
            int k = bitField0_;
            int i;
            if ((k & 1) != 1)
            {
                j = 0;
            }
            fieldoptions.ctype_ = ctype_;
            i = j;
            if ((k & 2) == 2)
            {
                i = j | 2;
            }
            fieldoptions.packed_ = packed_;
            j = i;
            if ((k & 4) == 4)
            {
                j = i | 4;
            }
            fieldoptions.deprecated_ = deprecated_;
            i = j;
            if ((k & 8) == 8)
            {
                i = j | 8;
            }
            fieldoptions.experimentalMapKey_ = experimentalMapKey_;
            if (uninterpretedOptionBuilder_ == null)
            {
                if ((bitField0_ & 0x10) == 16)
                {
                    uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
                    bitField0_ = bitField0_ & 0xffffffef;
                }
                fieldoptions.uninterpretedOption_ = uninterpretedOption_;
            } else
            {
                fieldoptions.uninterpretedOption_ = uninterpretedOptionBuilder_.build();
            }
            fieldoptions.bitField0_ = i;
            onBuilt();
            return fieldoptions;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public FieldOptions.Builder clear()
        {
            super.clear();
            ctype_ = FieldOptions.CType.STRING;
            bitField0_ = bitField0_ & -2;
            packed_ = false;
            bitField0_ = bitField0_ & -3;
            deprecated_ = false;
            bitField0_ = bitField0_ & -5;
            experimentalMapKey_ = "";
            bitField0_ = bitField0_ & -9;
            if (uninterpretedOptionBuilder_ == null)
            {
                uninterpretedOption_ = Collections.emptyList();
                bitField0_ = bitField0_ & 0xffffffef;
                return this;
            } else
            {
                uninterpretedOptionBuilder_.clear();
                return this;
            }
        }

        public volatile GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile GeneratedMessage.ExtendableBuilder clear()
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

        public FieldOptions.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile GeneratedMessage.Builder clone()
        {
            return clone();
        }

        public volatile GeneratedMessage.ExtendableBuilder clone()
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

        public FieldOptions getDefaultInstanceForType()
        {
            return FieldOptions.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return FieldOptions.getDescriptor();
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return (UninterpretedOption)uninterpretedOption_.get(i);
            } else
            {
                return (UninterpretedOption)uninterpretedOptionBuilder_.getMessage(i);
            }
        }

        public int getUninterpretedOptionCount()
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return uninterpretedOption_.size();
            } else
            {
                return uninterpretedOptionBuilder_.getCount();
            }
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L7:
            if (i >= getUninterpretedOptionCount()) goto _L2; else goto _L1
_L1:
            if (getUninterpretedOption(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (!extensionsAreInitialized()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
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

        public FieldOptions.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

                case 8: // '\b'
                    int j = codedinputstream.readEnum();
                    FieldOptions.CType ctype = FieldOptions.CType.valueOf(j);
                    if (ctype == null)
                    {
                        builder.mergeVarintField(1, j);
                    } else
                    {
                        bitField0_ = bitField0_ | 1;
                        ctype_ = ctype;
                    }
                    break;

                case 16: // '\020'
                    bitField0_ = bitField0_ | 2;
                    packed_ = codedinputstream.readBool();
                    break;

                case 24: // '\030'
                    bitField0_ = bitField0_ | 4;
                    deprecated_ = codedinputstream.readBool();
                    break;

                case 74: // 'J'
                    bitField0_ = bitField0_ | 8;
                    experimentalMapKey_ = codedinputstream.readBytes();
                    break;

                case 7994: 
                    UninterpretedOption.Builder builder1 = UninterpretedOption.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addUninterpretedOption(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public FieldOptions.Builder mergeFrom(FieldOptions fieldoptions)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (fieldoptions == FieldOptions.getDefaultInstance())
            {
                return this;
            }
            if (fieldoptions.hasCtype())
            {
                setCtype(fieldoptions.getCtype());
            }
            if (fieldoptions.hasPacked())
            {
                setPacked(fieldoptions.getPacked());
            }
            if (fieldoptions.hasDeprecated())
            {
                setDeprecated(fieldoptions.getDeprecated());
            }
            if (fieldoptions.hasExperimentalMapKey())
            {
                setExperimentalMapKey(fieldoptions.getExperimentalMapKey());
            }
            if (uninterpretedOptionBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!fieldoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOption_.isEmpty())
                {
                    uninterpretedOption_ = fieldoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & 0xffffffef;
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.addAll(fieldoptions.uninterpretedOption_);
                }
                onChanged();
            }
_L4:
            mergeExtensionFields(fieldoptions);
            mergeUnknownFields(fieldoptions.getUnknownFields());
            return this;
_L2:
            if (!fieldoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOptionBuilder_.isEmpty())
                {
                    uninterpretedOptionBuilder_.dispose();
                    uninterpretedOptionBuilder_ = null;
                    uninterpretedOption_ = fieldoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & 0xffffffef;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getUninterpretedOptionFieldBuilder();
                    }
                    uninterpretedOptionBuilder_ = repeatedfieldbuilder;
                } else
                {
                    uninterpretedOptionBuilder_.addAllMessages(fieldoptions.uninterpretedOption_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public FieldOptions.Builder mergeFrom(Message message)
        {
            if (message instanceof FieldOptions)
            {
                return mergeFrom((FieldOptions)message);
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

        public FieldOptions.Builder setCtype(FieldOptions.CType ctype)
        {
            if (ctype == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                ctype_ = ctype;
                onChanged();
                return this;
            }
        }

        public FieldOptions.Builder setDeprecated(boolean flag)
        {
            bitField0_ = bitField0_ | 4;
            deprecated_ = flag;
            onChanged();
            return this;
        }

        public FieldOptions.Builder setExperimentalMapKey(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 8;
                experimentalMapKey_ = s;
                onChanged();
                return this;
            }
        }

        public FieldOptions.Builder setPacked(boolean flag)
        {
            bitField0_ = bitField0_ | 2;
            packed_ = flag;
            onChanged();
            return this;
        }


        private FieldOptions.Builder()
        {
            ctype_ = FieldOptions.CType.STRING;
            experimentalMapKey_ = "";
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private FieldOptions.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            ctype_ = FieldOptions.CType.STRING;
            experimentalMapKey_ = "";
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

    }

    public static final class FieldOptions.CType extends Enum
        implements ProtocolMessageEnum
    {

        private static final FieldOptions.CType $VALUES[];
        public static final FieldOptions.CType CORD;
        public static final FieldOptions.CType STRING;
        public static final FieldOptions.CType STRING_PIECE;
        private static final FieldOptions.CType VALUES[];
        private static Internal.EnumLiteMap internalValueMap = new Internal.EnumLiteMap() {

        };
        private final int index;
        private final int value;

        public static FieldOptions.CType valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 0: // '\0'
                return STRING;

            case 1: // '\001'
                return CORD;

            case 2: // '\002'
                return STRING_PIECE;
            }
        }

        public static FieldOptions.CType valueOf(String s)
        {
            return (FieldOptions.CType)Enum.valueOf(com/google/protobuf/DescriptorProtos$FieldOptions$CType, s);
        }

        public static FieldOptions.CType[] values()
        {
            return (FieldOptions.CType[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            STRING = new FieldOptions.CType("STRING", 0, 0, 0);
            CORD = new FieldOptions.CType("CORD", 1, 1, 1);
            STRING_PIECE = new FieldOptions.CType("STRING_PIECE", 2, 2, 2);
            $VALUES = (new FieldOptions.CType[] {
                STRING, CORD, STRING_PIECE
            });
            VALUES = (new FieldOptions.CType[] {
                STRING, CORD, STRING_PIECE
            });
        }

        private FieldOptions.CType(String s, int i, int j, int k)
        {
            super(s, i);
            index = j;
            value = k;
        }
    }

    public static interface FieldOptionsOrBuilder
        extends GeneratedMessage.ExtendableMessageOrBuilder
    {
    }

    public static final class FileDescriptorProto extends GeneratedMessage
        implements FileDescriptorProtoOrBuilder
    {

        private static final FileDescriptorProto defaultInstance;
        private int bitField0_;
        private LazyStringList dependency_;
        private List enumType_;
        private List extension_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List messageType_;
        private Object name_;
        private FileOptions options_;
        private Object package_;
        private List service_;
        private SourceCodeInfo sourceCodeInfo_;

        public static FileDescriptorProto getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
        }

        private ByteString getNameBytes()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                name_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private ByteString getPackageBytes()
        {
            Object obj = package_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                package_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private void initFields()
        {
            name_ = "";
            package_ = "";
            dependency_ = LazyStringArrayList.EMPTY;
            messageType_ = Collections.emptyList();
            enumType_ = Collections.emptyList();
            service_ = Collections.emptyList();
            extension_ = Collections.emptyList();
            options_ = FileOptions.getDefaultInstance();
            sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(FileDescriptorProto filedescriptorproto)
        {
            return newBuilder().mergeFrom(filedescriptorproto);
        }

        public static FileDescriptorProto parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(abyte0)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(abyte0, extensionregistrylite)).buildParsed();
        }

        public FileDescriptorProto getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public String getDependency(int i)
        {
            return (String)dependency_.get(i);
        }

        public int getDependencyCount()
        {
            return dependency_.size();
        }

        public List getDependencyList()
        {
            return dependency_;
        }

        public EnumDescriptorProto getEnumType(int i)
        {
            return (EnumDescriptorProto)enumType_.get(i);
        }

        public int getEnumTypeCount()
        {
            return enumType_.size();
        }

        public FieldDescriptorProto getExtension(int i)
        {
            return (FieldDescriptorProto)extension_.get(i);
        }

        public int getExtensionCount()
        {
            return extension_.size();
        }

        public DescriptorProto getMessageType(int i)
        {
            return (DescriptorProto)messageType_.get(i);
        }

        public int getMessageTypeCount()
        {
            return messageType_.size();
        }

        public String getName()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                name_ = s;
            }
            return s;
        }

        public FileOptions getOptions()
        {
            return options_;
        }

        public String getPackage()
        {
            Object obj = package_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                package_ = s;
            }
            return s;
        }

        public int getSerializedSize()
        {
            boolean flag = false;
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            int j;
            int k;
            int l;
            if ((bitField0_ & 1) == 1)
            {
                i = CodedOutputStream.computeBytesSize(1, getNameBytes()) + 0;
            } else
            {
                i = 0;
            }
            j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeBytesSize(2, getPackageBytes());
            }
            k = 0;
            i = 0;
            for (; k < dependency_.size(); k++)
            {
                i += CodedOutputStream.computeBytesSizeNoTag(dependency_.getByteString(k));
            }

            l = getDependencyList().size();
            k = 0;
            i = j + i + l * 1;
            for (j = k; j < messageType_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(4, (MessageLite)messageType_.get(j));
            }

            for (j = 0; j < enumType_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(5, (MessageLite)enumType_.get(j));
            }

            k = 0;
            do
            {
                l = ((flag) ? 1 : 0);
                j = i;
                if (k >= service_.size())
                {
                    break;
                }
                i += CodedOutputStream.computeMessageSize(6, (MessageLite)service_.get(k));
                k++;
            } while (true);
            for (; l < extension_.size(); l++)
            {
                j += CodedOutputStream.computeMessageSize(7, (MessageLite)extension_.get(l));
            }

            i = j;
            if ((bitField0_ & 4) == 4)
            {
                i = j + CodedOutputStream.computeMessageSize(8, options_);
            }
            j = i;
            if ((bitField0_ & 8) == 8)
            {
                j = i + CodedOutputStream.computeMessageSize(9, sourceCodeInfo_);
            }
            i = getUnknownFields().getSerializedSize() + j;
            memoizedSerializedSize = i;
            return i;
        }

        public ServiceDescriptorProto getService(int i)
        {
            return (ServiceDescriptorProto)service_.get(i);
        }

        public int getServiceCount()
        {
            return service_.size();
        }

        public SourceCodeInfo getSourceCodeInfo()
        {
            return sourceCodeInfo_;
        }

        public boolean hasName()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasPackage()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasSourceCodeInfo()
        {
            return (bitField0_ & 8) == 8;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            boolean flag = true;
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                if (byte0 != 1)
                {
                    flag = false;
                }
                return flag;
            }
            for (int i = 0; i < getMessageTypeCount(); i++)
            {
                if (!getMessageType(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int j = 0; j < getEnumTypeCount(); j++)
            {
                if (!getEnumType(j).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int k = 0; k < getServiceCount(); k++)
            {
                if (!getService(k).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int l = 0; l < getExtensionCount(); l++)
            {
                if (!getExtension(l).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (hasOptions() && !getOptions().isInitialized())
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
            return new Builder(builderparent);
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
            boolean flag = false;
            getSerializedSize();
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeBytes(1, getNameBytes());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBytes(2, getPackageBytes());
            }
            for (int i = 0; i < dependency_.size(); i++)
            {
                codedoutputstream.writeBytes(3, dependency_.getByteString(i));
            }

            for (int j = 0; j < messageType_.size(); j++)
            {
                codedoutputstream.writeMessage(4, (MessageLite)messageType_.get(j));
            }

            for (int k = 0; k < enumType_.size(); k++)
            {
                codedoutputstream.writeMessage(5, (MessageLite)enumType_.get(k));
            }

            int l = 0;
            int i1;
            do
            {
                i1 = ((flag) ? 1 : 0);
                if (l >= service_.size())
                {
                    break;
                }
                codedoutputstream.writeMessage(6, (MessageLite)service_.get(l));
                l++;
            } while (true);
            for (; i1 < extension_.size(); i1++)
            {
                codedoutputstream.writeMessage(7, (MessageLite)extension_.get(i1));
            }

            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeMessage(8, options_);
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeMessage(9, sourceCodeInfo_);
            }
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new FileDescriptorProto(true);
            defaultInstance.initFields();
        }


/*
        static Object access$1302(FileDescriptorProto filedescriptorproto, Object obj)
        {
            filedescriptorproto.name_ = obj;
            return obj;
        }

*/


/*
        static Object access$1402(FileDescriptorProto filedescriptorproto, Object obj)
        {
            filedescriptorproto.package_ = obj;
            return obj;
        }

*/



/*
        static LazyStringList access$1502(FileDescriptorProto filedescriptorproto, LazyStringList lazystringlist)
        {
            filedescriptorproto.dependency_ = lazystringlist;
            return lazystringlist;
        }

*/



/*
        static List access$1602(FileDescriptorProto filedescriptorproto, List list)
        {
            filedescriptorproto.messageType_ = list;
            return list;
        }

*/



/*
        static List access$1702(FileDescriptorProto filedescriptorproto, List list)
        {
            filedescriptorproto.enumType_ = list;
            return list;
        }

*/



/*
        static List access$1802(FileDescriptorProto filedescriptorproto, List list)
        {
            filedescriptorproto.service_ = list;
            return list;
        }

*/



/*
        static List access$1902(FileDescriptorProto filedescriptorproto, List list)
        {
            filedescriptorproto.extension_ = list;
            return list;
        }

*/


/*
        static FileOptions access$2002(FileDescriptorProto filedescriptorproto, FileOptions fileoptions)
        {
            filedescriptorproto.options_ = fileoptions;
            return fileoptions;
        }

*/


/*
        static SourceCodeInfo access$2102(FileDescriptorProto filedescriptorproto, SourceCodeInfo sourcecodeinfo)
        {
            filedescriptorproto.sourceCodeInfo_ = sourcecodeinfo;
            return sourcecodeinfo;
        }

*/


/*
        static int access$2202(FileDescriptorProto filedescriptorproto, int i)
        {
            filedescriptorproto.bitField0_ = i;
            return i;
        }

*/

        private FileDescriptorProto(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private FileDescriptorProto(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class FileDescriptorProto.Builder extends GeneratedMessage.Builder
        implements FileDescriptorProtoOrBuilder
    {

        private int bitField0_;
        private LazyStringList dependency_;
        private RepeatedFieldBuilder enumTypeBuilder_;
        private List enumType_;
        private RepeatedFieldBuilder extensionBuilder_;
        private List extension_;
        private RepeatedFieldBuilder messageTypeBuilder_;
        private List messageType_;
        private Object name_;
        private SingleFieldBuilder optionsBuilder_;
        private FileOptions options_;
        private Object package_;
        private RepeatedFieldBuilder serviceBuilder_;
        private List service_;
        private SingleFieldBuilder sourceCodeInfoBuilder_;
        private SourceCodeInfo sourceCodeInfo_;

        private FileDescriptorProto buildParsed()
            throws InvalidProtocolBufferException
        {
            FileDescriptorProto filedescriptorproto = buildPartial();
            if (!filedescriptorproto.isInitialized())
            {
                throw newUninitializedMessageException(filedescriptorproto).asInvalidProtocolBufferException();
            } else
            {
                return filedescriptorproto;
            }
        }

        private static FileDescriptorProto.Builder create()
        {
            return new FileDescriptorProto.Builder();
        }

        private void ensureDependencyIsMutable()
        {
            if ((bitField0_ & 4) != 4)
            {
                dependency_ = new LazyStringArrayList(dependency_);
                bitField0_ = bitField0_ | 4;
            }
        }

        private void ensureEnumTypeIsMutable()
        {
            if ((bitField0_ & 0x10) != 16)
            {
                enumType_ = new ArrayList(enumType_);
                bitField0_ = bitField0_ | 0x10;
            }
        }

        private void ensureExtensionIsMutable()
        {
            if ((bitField0_ & 0x40) != 64)
            {
                extension_ = new ArrayList(extension_);
                bitField0_ = bitField0_ | 0x40;
            }
        }

        private void ensureMessageTypeIsMutable()
        {
            if ((bitField0_ & 8) != 8)
            {
                messageType_ = new ArrayList(messageType_);
                bitField0_ = bitField0_ | 8;
            }
        }

        private void ensureServiceIsMutable()
        {
            if ((bitField0_ & 0x20) != 32)
            {
                service_ = new ArrayList(service_);
                bitField0_ = bitField0_ | 0x20;
            }
        }

        private RepeatedFieldBuilder getEnumTypeFieldBuilder()
        {
            if (enumTypeBuilder_ == null)
            {
                List list = enumType_;
                boolean flag;
                if ((bitField0_ & 0x10) == 16)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                enumTypeBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                enumType_ = null;
            }
            return enumTypeBuilder_;
        }

        private RepeatedFieldBuilder getExtensionFieldBuilder()
        {
            if (extensionBuilder_ == null)
            {
                List list = extension_;
                boolean flag;
                if ((bitField0_ & 0x40) == 64)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                extensionBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                extension_ = null;
            }
            return extensionBuilder_;
        }

        private RepeatedFieldBuilder getMessageTypeFieldBuilder()
        {
            if (messageTypeBuilder_ == null)
            {
                List list = messageType_;
                boolean flag;
                if ((bitField0_ & 8) == 8)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                messageTypeBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                messageType_ = null;
            }
            return messageTypeBuilder_;
        }

        private SingleFieldBuilder getOptionsFieldBuilder()
        {
            if (optionsBuilder_ == null)
            {
                optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
                options_ = null;
            }
            return optionsBuilder_;
        }

        private RepeatedFieldBuilder getServiceFieldBuilder()
        {
            if (serviceBuilder_ == null)
            {
                List list = service_;
                boolean flag;
                if ((bitField0_ & 0x20) == 32)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                serviceBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                service_ = null;
            }
            return serviceBuilder_;
        }

        private SingleFieldBuilder getSourceCodeInfoFieldBuilder()
        {
            if (sourceCodeInfoBuilder_ == null)
            {
                sourceCodeInfoBuilder_ = new SingleFieldBuilder(sourceCodeInfo_, getParentForChildren(), isClean());
                sourceCodeInfo_ = null;
            }
            return sourceCodeInfoBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getMessageTypeFieldBuilder();
                getEnumTypeFieldBuilder();
                getServiceFieldBuilder();
                getExtensionFieldBuilder();
                getOptionsFieldBuilder();
                getSourceCodeInfoFieldBuilder();
            }
        }

        public FileDescriptorProto.Builder addEnumType(EnumDescriptorProto enumdescriptorproto)
        {
            if (enumTypeBuilder_ == null)
            {
                if (enumdescriptorproto == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureEnumTypeIsMutable();
                    enumType_.add(enumdescriptorproto);
                    onChanged();
                    return this;
                }
            } else
            {
                enumTypeBuilder_.addMessage(enumdescriptorproto);
                return this;
            }
        }

        public FileDescriptorProto.Builder addExtension(FieldDescriptorProto fielddescriptorproto)
        {
            if (extensionBuilder_ == null)
            {
                if (fielddescriptorproto == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureExtensionIsMutable();
                    extension_.add(fielddescriptorproto);
                    onChanged();
                    return this;
                }
            } else
            {
                extensionBuilder_.addMessage(fielddescriptorproto);
                return this;
            }
        }

        public FileDescriptorProto.Builder addMessageType(DescriptorProto descriptorproto)
        {
            if (messageTypeBuilder_ == null)
            {
                if (descriptorproto == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureMessageTypeIsMutable();
                    messageType_.add(descriptorproto);
                    onChanged();
                    return this;
                }
            } else
            {
                messageTypeBuilder_.addMessage(descriptorproto);
                return this;
            }
        }

        public FileDescriptorProto.Builder addService(ServiceDescriptorProto servicedescriptorproto)
        {
            if (serviceBuilder_ == null)
            {
                if (servicedescriptorproto == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureServiceIsMutable();
                    service_.add(servicedescriptorproto);
                    onChanged();
                    return this;
                }
            } else
            {
                serviceBuilder_.addMessage(servicedescriptorproto);
                return this;
            }
        }

        public FileDescriptorProto build()
        {
            FileDescriptorProto filedescriptorproto = buildPartial();
            if (!filedescriptorproto.isInitialized())
            {
                throw newUninitializedMessageException(filedescriptorproto);
            } else
            {
                return filedescriptorproto;
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

        public FileDescriptorProto buildPartial()
        {
            int i = 1;
            FileDescriptorProto filedescriptorproto = new FileDescriptorProto(this);
            int k = bitField0_;
            int j;
            if ((k & 1) != 1)
            {
                i = 0;
            }
            filedescriptorproto.name_ = name_;
            j = i;
            if ((k & 2) == 2)
            {
                j = i | 2;
            }
            filedescriptorproto.package_ = package_;
            if ((bitField0_ & 4) == 4)
            {
                dependency_ = new UnmodifiableLazyStringList(dependency_);
                bitField0_ = bitField0_ & -5;
            }
            filedescriptorproto.dependency_ = dependency_;
            if (messageTypeBuilder_ == null)
            {
                if ((bitField0_ & 8) == 8)
                {
                    messageType_ = Collections.unmodifiableList(messageType_);
                    bitField0_ = bitField0_ & -9;
                }
                filedescriptorproto.messageType_ = messageType_;
            } else
            {
                filedescriptorproto.messageType_ = messageTypeBuilder_.build();
            }
            if (enumTypeBuilder_ == null)
            {
                if ((bitField0_ & 0x10) == 16)
                {
                    enumType_ = Collections.unmodifiableList(enumType_);
                    bitField0_ = bitField0_ & 0xffffffef;
                }
                filedescriptorproto.enumType_ = enumType_;
            } else
            {
                filedescriptorproto.enumType_ = enumTypeBuilder_.build();
            }
            if (serviceBuilder_ == null)
            {
                if ((bitField0_ & 0x20) == 32)
                {
                    service_ = Collections.unmodifiableList(service_);
                    bitField0_ = bitField0_ & 0xffffffdf;
                }
                filedescriptorproto.service_ = service_;
            } else
            {
                filedescriptorproto.service_ = serviceBuilder_.build();
            }
            if (extensionBuilder_ == null)
            {
                if ((bitField0_ & 0x40) == 64)
                {
                    extension_ = Collections.unmodifiableList(extension_);
                    bitField0_ = bitField0_ & 0xffffffbf;
                }
                filedescriptorproto.extension_ = extension_;
            } else
            {
                filedescriptorproto.extension_ = extensionBuilder_.build();
            }
            if ((k & 0x80) == 128)
            {
                i = j | 4;
            } else
            {
                i = j;
            }
            if (optionsBuilder_ == null)
            {
                filedescriptorproto.options_ = options_;
            } else
            {
                filedescriptorproto.options_ = (FileOptions)optionsBuilder_.build();
            }
            j = i;
            if ((k & 0x100) == 256)
            {
                j = i | 8;
            }
            if (sourceCodeInfoBuilder_ == null)
            {
                filedescriptorproto.sourceCodeInfo_ = sourceCodeInfo_;
            } else
            {
                filedescriptorproto.sourceCodeInfo_ = (SourceCodeInfo)sourceCodeInfoBuilder_.build();
            }
            filedescriptorproto.bitField0_ = j;
            onBuilt();
            return filedescriptorproto;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public FileDescriptorProto.Builder clear()
        {
            super.clear();
            name_ = "";
            bitField0_ = bitField0_ & -2;
            package_ = "";
            bitField0_ = bitField0_ & -3;
            dependency_ = LazyStringArrayList.EMPTY;
            bitField0_ = bitField0_ & -5;
            if (messageTypeBuilder_ == null)
            {
                messageType_ = Collections.emptyList();
                bitField0_ = bitField0_ & -9;
            } else
            {
                messageTypeBuilder_.clear();
            }
            if (enumTypeBuilder_ == null)
            {
                enumType_ = Collections.emptyList();
                bitField0_ = bitField0_ & 0xffffffef;
            } else
            {
                enumTypeBuilder_.clear();
            }
            if (serviceBuilder_ == null)
            {
                service_ = Collections.emptyList();
                bitField0_ = bitField0_ & 0xffffffdf;
            } else
            {
                serviceBuilder_.clear();
            }
            if (extensionBuilder_ == null)
            {
                extension_ = Collections.emptyList();
                bitField0_ = bitField0_ & 0xffffffbf;
            } else
            {
                extensionBuilder_.clear();
            }
            if (optionsBuilder_ == null)
            {
                options_ = FileOptions.getDefaultInstance();
            } else
            {
                optionsBuilder_.clear();
            }
            bitField0_ = bitField0_ & 0xffffff7f;
            if (sourceCodeInfoBuilder_ == null)
            {
                sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
            } else
            {
                sourceCodeInfoBuilder_.clear();
            }
            bitField0_ = bitField0_ & 0xfffffeff;
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

        public FileDescriptorProto.Builder clone()
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

        public FileDescriptorProto getDefaultInstanceForType()
        {
            return FileDescriptorProto.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return FileDescriptorProto.getDescriptor();
        }

        public EnumDescriptorProto getEnumType(int i)
        {
            if (enumTypeBuilder_ == null)
            {
                return (EnumDescriptorProto)enumType_.get(i);
            } else
            {
                return (EnumDescriptorProto)enumTypeBuilder_.getMessage(i);
            }
        }

        public int getEnumTypeCount()
        {
            if (enumTypeBuilder_ == null)
            {
                return enumType_.size();
            } else
            {
                return enumTypeBuilder_.getCount();
            }
        }

        public FieldDescriptorProto getExtension(int i)
        {
            if (extensionBuilder_ == null)
            {
                return (FieldDescriptorProto)extension_.get(i);
            } else
            {
                return (FieldDescriptorProto)extensionBuilder_.getMessage(i);
            }
        }

        public int getExtensionCount()
        {
            if (extensionBuilder_ == null)
            {
                return extension_.size();
            } else
            {
                return extensionBuilder_.getCount();
            }
        }

        public DescriptorProto getMessageType(int i)
        {
            if (messageTypeBuilder_ == null)
            {
                return (DescriptorProto)messageType_.get(i);
            } else
            {
                return (DescriptorProto)messageTypeBuilder_.getMessage(i);
            }
        }

        public int getMessageTypeCount()
        {
            if (messageTypeBuilder_ == null)
            {
                return messageType_.size();
            } else
            {
                return messageTypeBuilder_.getCount();
            }
        }

        public FileOptions getOptions()
        {
            if (optionsBuilder_ == null)
            {
                return options_;
            } else
            {
                return (FileOptions)optionsBuilder_.getMessage();
            }
        }

        public ServiceDescriptorProto getService(int i)
        {
            if (serviceBuilder_ == null)
            {
                return (ServiceDescriptorProto)service_.get(i);
            } else
            {
                return (ServiceDescriptorProto)serviceBuilder_.getMessage(i);
            }
        }

        public int getServiceCount()
        {
            if (serviceBuilder_ == null)
            {
                return service_.size();
            } else
            {
                return serviceBuilder_.getCount();
            }
        }

        public SourceCodeInfo getSourceCodeInfo()
        {
            if (sourceCodeInfoBuilder_ == null)
            {
                return sourceCodeInfo_;
            } else
            {
                return (SourceCodeInfo)sourceCodeInfoBuilder_.getMessage();
            }
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 0x80) == 128;
        }

        public boolean hasSourceCodeInfo()
        {
            return (bitField0_ & 0x100) == 256;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L13:
            if (i >= getMessageTypeCount()) goto _L2; else goto _L1
_L1:
            if (getMessageType(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            i = 0;
_L6:
            if (i >= getEnumTypeCount())
            {
                break MISSING_BLOCK_LABEL_58;
            }
            if (!getEnumType(i).isInitialized()) goto _L3; else goto _L5
_L5:
            i++;
              goto _L6
            i = 0;
_L8:
            if (i >= getServiceCount())
            {
                break MISSING_BLOCK_LABEL_86;
            }
            if (!getService(i).isInitialized()) goto _L3; else goto _L7
_L7:
            i++;
              goto _L8
            i = 0;
_L10:
            if (i >= getExtensionCount())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!getExtension(i).isInitialized()) goto _L3; else goto _L9
_L9:
            i++;
              goto _L10
            if (hasOptions() && !getOptions().isInitialized()) goto _L3; else goto _L11
_L11:
            return true;
            if (true) goto _L13; else goto _L12
_L12:
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

        public FileDescriptorProto.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
                    name_ = codedinputstream.readBytes();
                    break;

                case 18: // '\022'
                    bitField0_ = bitField0_ | 2;
                    package_ = codedinputstream.readBytes();
                    break;

                case 26: // '\032'
                    ensureDependencyIsMutable();
                    dependency_.add(codedinputstream.readBytes());
                    break;

                case 34: // '"'
                    DescriptorProto.Builder builder1 = DescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addMessageType(builder1.buildPartial());
                    break;

                case 42: // '*'
                    EnumDescriptorProto.Builder builder2 = EnumDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder2, extensionregistrylite);
                    addEnumType(builder2.buildPartial());
                    break;

                case 50: // '2'
                    ServiceDescriptorProto.Builder builder3 = ServiceDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder3, extensionregistrylite);
                    addService(builder3.buildPartial());
                    break;

                case 58: // ':'
                    FieldDescriptorProto.Builder builder4 = FieldDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder4, extensionregistrylite);
                    addExtension(builder4.buildPartial());
                    break;

                case 66: // 'B'
                    FileOptions.Builder builder5 = FileOptions.newBuilder();
                    if (hasOptions())
                    {
                        builder5.mergeFrom(getOptions());
                    }
                    codedinputstream.readMessage(builder5, extensionregistrylite);
                    setOptions(builder5.buildPartial());
                    break;

                case 74: // 'J'
                    SourceCodeInfo.Builder builder6 = SourceCodeInfo.newBuilder();
                    if (hasSourceCodeInfo())
                    {
                        builder6.mergeFrom(getSourceCodeInfo());
                    }
                    codedinputstream.readMessage(builder6, extensionregistrylite);
                    setSourceCodeInfo(builder6.buildPartial());
                    break;
                }
            } while (true);
        }

        public FileDescriptorProto.Builder mergeFrom(FileDescriptorProto filedescriptorproto)
        {
            Object obj = null;
            if (filedescriptorproto == FileDescriptorProto.getDefaultInstance())
            {
                return this;
            }
            if (filedescriptorproto.hasName())
            {
                setName(filedescriptorproto.getName());
            }
            if (filedescriptorproto.hasPackage())
            {
                setPackage(filedescriptorproto.getPackage());
            }
            if (!filedescriptorproto.dependency_.isEmpty())
            {
                if (dependency_.isEmpty())
                {
                    dependency_ = filedescriptorproto.dependency_;
                    bitField0_ = bitField0_ & -5;
                } else
                {
                    ensureDependencyIsMutable();
                    dependency_.addAll(filedescriptorproto.dependency_);
                }
                onChanged();
            }
            if (messageTypeBuilder_ == null)
            {
                if (!filedescriptorproto.messageType_.isEmpty())
                {
                    if (messageType_.isEmpty())
                    {
                        messageType_ = filedescriptorproto.messageType_;
                        bitField0_ = bitField0_ & -9;
                    } else
                    {
                        ensureMessageTypeIsMutable();
                        messageType_.addAll(filedescriptorproto.messageType_);
                    }
                    onChanged();
                }
            } else
            if (!filedescriptorproto.messageType_.isEmpty())
            {
                if (messageTypeBuilder_.isEmpty())
                {
                    messageTypeBuilder_.dispose();
                    messageTypeBuilder_ = null;
                    messageType_ = filedescriptorproto.messageType_;
                    bitField0_ = bitField0_ & -9;
                    RepeatedFieldBuilder repeatedfieldbuilder;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getMessageTypeFieldBuilder();
                    } else
                    {
                        repeatedfieldbuilder = null;
                    }
                    messageTypeBuilder_ = repeatedfieldbuilder;
                } else
                {
                    messageTypeBuilder_.addAllMessages(filedescriptorproto.messageType_);
                }
            }
            if (enumTypeBuilder_ == null)
            {
                if (!filedescriptorproto.enumType_.isEmpty())
                {
                    if (enumType_.isEmpty())
                    {
                        enumType_ = filedescriptorproto.enumType_;
                        bitField0_ = bitField0_ & 0xffffffef;
                    } else
                    {
                        ensureEnumTypeIsMutable();
                        enumType_.addAll(filedescriptorproto.enumType_);
                    }
                    onChanged();
                }
            } else
            if (!filedescriptorproto.enumType_.isEmpty())
            {
                if (enumTypeBuilder_.isEmpty())
                {
                    enumTypeBuilder_.dispose();
                    enumTypeBuilder_ = null;
                    enumType_ = filedescriptorproto.enumType_;
                    bitField0_ = bitField0_ & 0xffffffef;
                    RepeatedFieldBuilder repeatedfieldbuilder1;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder1 = getEnumTypeFieldBuilder();
                    } else
                    {
                        repeatedfieldbuilder1 = null;
                    }
                    enumTypeBuilder_ = repeatedfieldbuilder1;
                } else
                {
                    enumTypeBuilder_.addAllMessages(filedescriptorproto.enumType_);
                }
            }
            if (serviceBuilder_ == null)
            {
                if (!filedescriptorproto.service_.isEmpty())
                {
                    if (service_.isEmpty())
                    {
                        service_ = filedescriptorproto.service_;
                        bitField0_ = bitField0_ & 0xffffffdf;
                    } else
                    {
                        ensureServiceIsMutable();
                        service_.addAll(filedescriptorproto.service_);
                    }
                    onChanged();
                }
            } else
            if (!filedescriptorproto.service_.isEmpty())
            {
                if (serviceBuilder_.isEmpty())
                {
                    serviceBuilder_.dispose();
                    serviceBuilder_ = null;
                    service_ = filedescriptorproto.service_;
                    bitField0_ = bitField0_ & 0xffffffdf;
                    RepeatedFieldBuilder repeatedfieldbuilder2;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder2 = getServiceFieldBuilder();
                    } else
                    {
                        repeatedfieldbuilder2 = null;
                    }
                    serviceBuilder_ = repeatedfieldbuilder2;
                } else
                {
                    serviceBuilder_.addAllMessages(filedescriptorproto.service_);
                }
            }
            if (extensionBuilder_ == null)
            {
                if (!filedescriptorproto.extension_.isEmpty())
                {
                    if (extension_.isEmpty())
                    {
                        extension_ = filedescriptorproto.extension_;
                        bitField0_ = bitField0_ & 0xffffffbf;
                    } else
                    {
                        ensureExtensionIsMutable();
                        extension_.addAll(filedescriptorproto.extension_);
                    }
                    onChanged();
                }
            } else
            if (!filedescriptorproto.extension_.isEmpty())
            {
                if (extensionBuilder_.isEmpty())
                {
                    extensionBuilder_.dispose();
                    extensionBuilder_ = null;
                    extension_ = filedescriptorproto.extension_;
                    bitField0_ = bitField0_ & 0xffffffbf;
                    RepeatedFieldBuilder repeatedfieldbuilder3 = obj;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder3 = getExtensionFieldBuilder();
                    }
                    extensionBuilder_ = repeatedfieldbuilder3;
                } else
                {
                    extensionBuilder_.addAllMessages(filedescriptorproto.extension_);
                }
            }
            if (filedescriptorproto.hasOptions())
            {
                mergeOptions(filedescriptorproto.getOptions());
            }
            if (filedescriptorproto.hasSourceCodeInfo())
            {
                mergeSourceCodeInfo(filedescriptorproto.getSourceCodeInfo());
            }
            mergeUnknownFields(filedescriptorproto.getUnknownFields());
            return this;
        }

        public FileDescriptorProto.Builder mergeFrom(Message message)
        {
            if (message instanceof FileDescriptorProto)
            {
                return mergeFrom((FileDescriptorProto)message);
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

        public FileDescriptorProto.Builder mergeOptions(FileOptions fileoptions)
        {
            if (optionsBuilder_ == null)
            {
                if ((bitField0_ & 0x80) == 128 && options_ != FileOptions.getDefaultInstance())
                {
                    options_ = FileOptions.newBuilder(options_).mergeFrom(fileoptions).buildPartial();
                } else
                {
                    options_ = fileoptions;
                }
                onChanged();
            } else
            {
                optionsBuilder_.mergeFrom(fileoptions);
            }
            bitField0_ = bitField0_ | 0x80;
            return this;
        }

        public FileDescriptorProto.Builder mergeSourceCodeInfo(SourceCodeInfo sourcecodeinfo)
        {
            if (sourceCodeInfoBuilder_ == null)
            {
                if ((bitField0_ & 0x100) == 256 && sourceCodeInfo_ != SourceCodeInfo.getDefaultInstance())
                {
                    sourceCodeInfo_ = SourceCodeInfo.newBuilder(sourceCodeInfo_).mergeFrom(sourcecodeinfo).buildPartial();
                } else
                {
                    sourceCodeInfo_ = sourcecodeinfo;
                }
                onChanged();
            } else
            {
                sourceCodeInfoBuilder_.mergeFrom(sourcecodeinfo);
            }
            bitField0_ = bitField0_ | 0x100;
            return this;
        }

        public FileDescriptorProto.Builder setName(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                name_ = s;
                onChanged();
                return this;
            }
        }

        public FileDescriptorProto.Builder setOptions(FileOptions fileoptions)
        {
            if (optionsBuilder_ == null)
            {
                if (fileoptions == null)
                {
                    throw new NullPointerException();
                }
                options_ = fileoptions;
                onChanged();
            } else
            {
                optionsBuilder_.setMessage(fileoptions);
            }
            bitField0_ = bitField0_ | 0x80;
            return this;
        }

        public FileDescriptorProto.Builder setPackage(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                package_ = s;
                onChanged();
                return this;
            }
        }

        public FileDescriptorProto.Builder setSourceCodeInfo(SourceCodeInfo sourcecodeinfo)
        {
            if (sourceCodeInfoBuilder_ == null)
            {
                if (sourcecodeinfo == null)
                {
                    throw new NullPointerException();
                }
                sourceCodeInfo_ = sourcecodeinfo;
                onChanged();
            } else
            {
                sourceCodeInfoBuilder_.setMessage(sourcecodeinfo);
            }
            bitField0_ = bitField0_ | 0x100;
            return this;
        }



        private FileDescriptorProto.Builder()
        {
            name_ = "";
            package_ = "";
            dependency_ = LazyStringArrayList.EMPTY;
            messageType_ = Collections.emptyList();
            enumType_ = Collections.emptyList();
            service_ = Collections.emptyList();
            extension_ = Collections.emptyList();
            options_ = FileOptions.getDefaultInstance();
            sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        private FileDescriptorProto.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            package_ = "";
            dependency_ = LazyStringArrayList.EMPTY;
            messageType_ = Collections.emptyList();
            enumType_ = Collections.emptyList();
            service_ = Collections.emptyList();
            extension_ = Collections.emptyList();
            options_ = FileOptions.getDefaultInstance();
            sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

    }

    public static interface FileDescriptorProtoOrBuilder
        extends MessageOrBuilder
    {
    }

    public static final class FileDescriptorSet extends GeneratedMessage
        implements FileDescriptorSetOrBuilder
    {

        private static final FileDescriptorSet defaultInstance;
        private List file_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        public static FileDescriptorSet getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
        }

        private void initFields()
        {
            file_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(FileDescriptorSet filedescriptorset)
        {
            return newBuilder().mergeFrom(filedescriptorset);
        }

        public FileDescriptorSet getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public FileDescriptorProto getFile(int i)
        {
            return (FileDescriptorProto)file_.get(i);
        }

        public int getFileCount()
        {
            return file_.size();
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            int j = 0;
            for (; i < file_.size(); i++)
            {
                j += CodedOutputStream.computeMessageSize(1, (MessageLite)file_.get(i));
            }

            i = getUnknownFields().getSerializedSize() + j;
            memoizedSerializedSize = i;
            return i;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i = 0; i < getFileCount(); i++)
            {
                if (!getFile(i).isInitialized())
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

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent builderparent)
        {
            return new Builder(builderparent);
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
            for (int i = 0; i < file_.size(); i++)
            {
                codedoutputstream.writeMessage(1, (MessageLite)file_.get(i));
            }

            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new FileDescriptorSet(true);
            defaultInstance.initFields();
        }



/*
        static List access$602(FileDescriptorSet filedescriptorset, List list)
        {
            filedescriptorset.file_ = list;
            return list;
        }

*/

        private FileDescriptorSet(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private FileDescriptorSet(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class FileDescriptorSet.Builder extends GeneratedMessage.Builder
        implements FileDescriptorSetOrBuilder
    {

        private int bitField0_;
        private RepeatedFieldBuilder fileBuilder_;
        private List file_;

        private static FileDescriptorSet.Builder create()
        {
            return new FileDescriptorSet.Builder();
        }

        private void ensureFileIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                file_ = new ArrayList(file_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private RepeatedFieldBuilder getFileFieldBuilder()
        {
            boolean flag = true;
            if (fileBuilder_ == null)
            {
                List list = file_;
                if ((bitField0_ & 1) != 1)
                {
                    flag = false;
                }
                fileBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                file_ = null;
            }
            return fileBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getFileFieldBuilder();
            }
        }

        public FileDescriptorSet.Builder addFile(FileDescriptorProto filedescriptorproto)
        {
            if (fileBuilder_ == null)
            {
                if (filedescriptorproto == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureFileIsMutable();
                    file_.add(filedescriptorproto);
                    onChanged();
                    return this;
                }
            } else
            {
                fileBuilder_.addMessage(filedescriptorproto);
                return this;
            }
        }

        public FileDescriptorSet build()
        {
            FileDescriptorSet filedescriptorset = buildPartial();
            if (!filedescriptorset.isInitialized())
            {
                throw newUninitializedMessageException(filedescriptorset);
            } else
            {
                return filedescriptorset;
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

        public FileDescriptorSet buildPartial()
        {
            FileDescriptorSet filedescriptorset = new FileDescriptorSet(this);
            int i = bitField0_;
            if (fileBuilder_ == null)
            {
                if ((bitField0_ & 1) == 1)
                {
                    file_ = Collections.unmodifiableList(file_);
                    bitField0_ = bitField0_ & -2;
                }
                filedescriptorset.file_ = file_;
            } else
            {
                filedescriptorset.file_ = fileBuilder_.build();
            }
            onBuilt();
            return filedescriptorset;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public FileDescriptorSet.Builder clear()
        {
            super.clear();
            if (fileBuilder_ == null)
            {
                file_ = Collections.emptyList();
                bitField0_ = bitField0_ & -2;
                return this;
            } else
            {
                fileBuilder_.clear();
                return this;
            }
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

        public FileDescriptorSet.Builder clone()
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

        public FileDescriptorSet getDefaultInstanceForType()
        {
            return FileDescriptorSet.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return FileDescriptorSet.getDescriptor();
        }

        public FileDescriptorProto getFile(int i)
        {
            if (fileBuilder_ == null)
            {
                return (FileDescriptorProto)file_.get(i);
            } else
            {
                return (FileDescriptorProto)fileBuilder_.getMessage(i);
            }
        }

        public int getFileCount()
        {
            if (fileBuilder_ == null)
            {
                return file_.size();
            } else
            {
                return fileBuilder_.getCount();
            }
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            for (int i = 0; i < getFileCount(); i++)
            {
                if (!getFile(i).isInitialized())
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

        public FileDescriptorSet.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
                    FileDescriptorProto.Builder builder1 = FileDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addFile(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public FileDescriptorSet.Builder mergeFrom(FileDescriptorSet filedescriptorset)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (filedescriptorset == FileDescriptorSet.getDefaultInstance())
            {
                return this;
            }
            if (fileBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!filedescriptorset.file_.isEmpty())
            {
                if (file_.isEmpty())
                {
                    file_ = filedescriptorset.file_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensureFileIsMutable();
                    file_.addAll(filedescriptorset.file_);
                }
                onChanged();
            }
_L4:
            mergeUnknownFields(filedescriptorset.getUnknownFields());
            return this;
_L2:
            if (!filedescriptorset.file_.isEmpty())
            {
                if (fileBuilder_.isEmpty())
                {
                    fileBuilder_.dispose();
                    fileBuilder_ = null;
                    file_ = filedescriptorset.file_;
                    bitField0_ = bitField0_ & -2;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getFileFieldBuilder();
                    }
                    fileBuilder_ = repeatedfieldbuilder;
                } else
                {
                    fileBuilder_.addAllMessages(filedescriptorset.file_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public FileDescriptorSet.Builder mergeFrom(Message message)
        {
            if (message instanceof FileDescriptorSet)
            {
                return mergeFrom((FileDescriptorSet)message);
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


        private FileDescriptorSet.Builder()
        {
            file_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private FileDescriptorSet.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            file_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

    }

    public static interface FileDescriptorSetOrBuilder
        extends MessageOrBuilder
    {
    }

    public static final class FileOptions extends GeneratedMessage.ExtendableMessage
        implements FileOptionsOrBuilder
    {

        private static final FileOptions defaultInstance;
        private int bitField0_;
        private boolean ccGenericServices_;
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private Object javaOuterClassname_;
        private Object javaPackage_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private OptimizeMode optimizeFor_;
        private boolean pyGenericServices_;
        private List uninterpretedOption_;

        public static FileOptions getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
        }

        private ByteString getJavaOuterClassnameBytes()
        {
            Object obj = javaOuterClassname_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                javaOuterClassname_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private ByteString getJavaPackageBytes()
        {
            Object obj = javaPackage_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                javaPackage_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private void initFields()
        {
            javaPackage_ = "";
            javaOuterClassname_ = "";
            javaMultipleFiles_ = false;
            javaGenerateEqualsAndHash_ = false;
            optimizeFor_ = OptimizeMode.SPEED;
            ccGenericServices_ = false;
            javaGenericServices_ = false;
            pyGenericServices_ = false;
            uninterpretedOption_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(FileOptions fileoptions)
        {
            return newBuilder().mergeFrom(fileoptions);
        }

        public boolean getCcGenericServices()
        {
            return ccGenericServices_;
        }

        public FileOptions getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public boolean getJavaGenerateEqualsAndHash()
        {
            return javaGenerateEqualsAndHash_;
        }

        public boolean getJavaGenericServices()
        {
            return javaGenericServices_;
        }

        public boolean getJavaMultipleFiles()
        {
            return javaMultipleFiles_;
        }

        public String getJavaOuterClassname()
        {
            Object obj = javaOuterClassname_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                javaOuterClassname_ = s;
            }
            return s;
        }

        public String getJavaPackage()
        {
            Object obj = javaPackage_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                javaPackage_ = s;
            }
            return s;
        }

        public OptimizeMode getOptimizeFor()
        {
            return optimizeFor_;
        }

        public boolean getPyGenericServices()
        {
            return pyGenericServices_;
        }

        public int getSerializedSize()
        {
            boolean flag = false;
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            int j;
            if ((bitField0_ & 1) == 1)
            {
                j = CodedOutputStream.computeBytesSize(1, getJavaPackageBytes()) + 0;
            } else
            {
                j = 0;
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeBytesSize(8, getJavaOuterClassnameBytes());
            }
            j = i;
            if ((bitField0_ & 0x10) == 16)
            {
                j = i + CodedOutputStream.computeEnumSize(9, optimizeFor_.getNumber());
            }
            i = j;
            if ((bitField0_ & 4) == 4)
            {
                i = j + CodedOutputStream.computeBoolSize(10, javaMultipleFiles_);
            }
            j = i;
            if ((bitField0_ & 0x20) == 32)
            {
                j = i + CodedOutputStream.computeBoolSize(16, ccGenericServices_);
            }
            i = j;
            if ((bitField0_ & 0x40) == 64)
            {
                i = j + CodedOutputStream.computeBoolSize(17, javaGenericServices_);
            }
            j = i;
            if ((bitField0_ & 0x80) == 128)
            {
                j = i + CodedOutputStream.computeBoolSize(18, pyGenericServices_);
            }
            i = j;
            if ((bitField0_ & 8) == 8)
            {
                i = j + CodedOutputStream.computeBoolSize(20, javaGenerateEqualsAndHash_);
            }
            for (j = ((flag) ? 1 : 0); j < uninterpretedOption_.size();)
            {
                int k = CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(j));
                j++;
                i = k + i;
            }

            i = extensionsSerializedSize() + i + getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            return (UninterpretedOption)uninterpretedOption_.get(i);
        }

        public int getUninterpretedOptionCount()
        {
            return uninterpretedOption_.size();
        }

        public boolean hasCcGenericServices()
        {
            return (bitField0_ & 0x20) == 32;
        }

        public boolean hasJavaGenerateEqualsAndHash()
        {
            return (bitField0_ & 8) == 8;
        }

        public boolean hasJavaGenericServices()
        {
            return (bitField0_ & 0x40) == 64;
        }

        public boolean hasJavaMultipleFiles()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasJavaOuterClassname()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasJavaPackage()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasOptimizeFor()
        {
            return (bitField0_ & 0x10) == 16;
        }

        public boolean hasPyGenericServices()
        {
            return (bitField0_ & 0x80) == 128;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++)
            {
                if (!getUninterpretedOption(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (!extensionsAreInitialized())
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
            return new Builder(builderparent);
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
            GeneratedMessage.ExtendableMessage.ExtensionWriter extensionwriter = newExtensionWriter();
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeBytes(1, getJavaPackageBytes());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBytes(8, getJavaOuterClassnameBytes());
            }
            if ((bitField0_ & 0x10) == 16)
            {
                codedoutputstream.writeEnum(9, optimizeFor_.getNumber());
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeBool(10, javaMultipleFiles_);
            }
            if ((bitField0_ & 0x20) == 32)
            {
                codedoutputstream.writeBool(16, ccGenericServices_);
            }
            if ((bitField0_ & 0x40) == 64)
            {
                codedoutputstream.writeBool(17, javaGenericServices_);
            }
            if ((bitField0_ & 0x80) == 128)
            {
                codedoutputstream.writeBool(18, pyGenericServices_);
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeBool(20, javaGenerateEqualsAndHash_);
            }
            for (int i = 0; i < uninterpretedOption_.size(); i++)
            {
                codedoutputstream.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
            }

            extensionwriter.writeUntil(0x20000000, codedoutputstream);
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new FileOptions(true);
            defaultInstance.initFields();
        }


/*
        static Object access$10802(FileOptions fileoptions, Object obj)
        {
            fileoptions.javaPackage_ = obj;
            return obj;
        }

*/


/*
        static Object access$10902(FileOptions fileoptions, Object obj)
        {
            fileoptions.javaOuterClassname_ = obj;
            return obj;
        }

*/


/*
        static boolean access$11002(FileOptions fileoptions, boolean flag)
        {
            fileoptions.javaMultipleFiles_ = flag;
            return flag;
        }

*/


/*
        static boolean access$11102(FileOptions fileoptions, boolean flag)
        {
            fileoptions.javaGenerateEqualsAndHash_ = flag;
            return flag;
        }

*/


/*
        static OptimizeMode access$11202(FileOptions fileoptions, OptimizeMode optimizemode)
        {
            fileoptions.optimizeFor_ = optimizemode;
            return optimizemode;
        }

*/


/*
        static boolean access$11302(FileOptions fileoptions, boolean flag)
        {
            fileoptions.ccGenericServices_ = flag;
            return flag;
        }

*/


/*
        static boolean access$11402(FileOptions fileoptions, boolean flag)
        {
            fileoptions.javaGenericServices_ = flag;
            return flag;
        }

*/


/*
        static boolean access$11502(FileOptions fileoptions, boolean flag)
        {
            fileoptions.pyGenericServices_ = flag;
            return flag;
        }

*/



/*
        static List access$11602(FileOptions fileoptions, List list)
        {
            fileoptions.uninterpretedOption_ = list;
            return list;
        }

*/


/*
        static int access$11702(FileOptions fileoptions, int i)
        {
            fileoptions.bitField0_ = i;
            return i;
        }

*/

        private FileOptions(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private FileOptions(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class FileOptions.Builder extends GeneratedMessage.ExtendableBuilder
        implements FileOptionsOrBuilder
    {

        private int bitField0_;
        private boolean ccGenericServices_;
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private Object javaOuterClassname_;
        private Object javaPackage_;
        private FileOptions.OptimizeMode optimizeFor_;
        private boolean pyGenericServices_;
        private RepeatedFieldBuilder uninterpretedOptionBuilder_;
        private List uninterpretedOption_;

        private static FileOptions.Builder create()
        {
            return new FileOptions.Builder();
        }

        private void ensureUninterpretedOptionIsMutable()
        {
            if ((bitField0_ & 0x100) != 256)
            {
                uninterpretedOption_ = new ArrayList(uninterpretedOption_);
                bitField0_ = bitField0_ | 0x100;
            }
        }

        private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder()
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                List list = uninterpretedOption_;
                boolean flag;
                if ((bitField0_ & 0x100) == 256)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                uninterpretedOption_ = null;
            }
            return uninterpretedOptionBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getUninterpretedOptionFieldBuilder();
            }
        }

        public FileOptions.Builder addUninterpretedOption(UninterpretedOption uninterpretedoption)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                if (uninterpretedoption == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.add(uninterpretedoption);
                    onChanged();
                    return this;
                }
            } else
            {
                uninterpretedOptionBuilder_.addMessage(uninterpretedoption);
                return this;
            }
        }

        public FileOptions build()
        {
            FileOptions fileoptions = buildPartial();
            if (!fileoptions.isInitialized())
            {
                throw newUninitializedMessageException(fileoptions);
            } else
            {
                return fileoptions;
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

        public FileOptions buildPartial()
        {
            int j = 1;
            FileOptions fileoptions = new FileOptions(this);
            int k = bitField0_;
            int i;
            if ((k & 1) != 1)
            {
                j = 0;
            }
            fileoptions.javaPackage_ = javaPackage_;
            i = j;
            if ((k & 2) == 2)
            {
                i = j | 2;
            }
            fileoptions.javaOuterClassname_ = javaOuterClassname_;
            j = i;
            if ((k & 4) == 4)
            {
                j = i | 4;
            }
            fileoptions.javaMultipleFiles_ = javaMultipleFiles_;
            i = j;
            if ((k & 8) == 8)
            {
                i = j | 8;
            }
            fileoptions.javaGenerateEqualsAndHash_ = javaGenerateEqualsAndHash_;
            j = i;
            if ((k & 0x10) == 16)
            {
                j = i | 0x10;
            }
            fileoptions.optimizeFor_ = optimizeFor_;
            i = j;
            if ((k & 0x20) == 32)
            {
                i = j | 0x20;
            }
            fileoptions.ccGenericServices_ = ccGenericServices_;
            j = i;
            if ((k & 0x40) == 64)
            {
                j = i | 0x40;
            }
            fileoptions.javaGenericServices_ = javaGenericServices_;
            i = j;
            if ((k & 0x80) == 128)
            {
                i = j | 0x80;
            }
            fileoptions.pyGenericServices_ = pyGenericServices_;
            if (uninterpretedOptionBuilder_ == null)
            {
                if ((bitField0_ & 0x100) == 256)
                {
                    uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
                    bitField0_ = bitField0_ & 0xfffffeff;
                }
                fileoptions.uninterpretedOption_ = uninterpretedOption_;
            } else
            {
                fileoptions.uninterpretedOption_ = uninterpretedOptionBuilder_.build();
            }
            fileoptions.bitField0_ = i;
            onBuilt();
            return fileoptions;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public FileOptions.Builder clear()
        {
            super.clear();
            javaPackage_ = "";
            bitField0_ = bitField0_ & -2;
            javaOuterClassname_ = "";
            bitField0_ = bitField0_ & -3;
            javaMultipleFiles_ = false;
            bitField0_ = bitField0_ & -5;
            javaGenerateEqualsAndHash_ = false;
            bitField0_ = bitField0_ & -9;
            optimizeFor_ = FileOptions.OptimizeMode.SPEED;
            bitField0_ = bitField0_ & 0xffffffef;
            ccGenericServices_ = false;
            bitField0_ = bitField0_ & 0xffffffdf;
            javaGenericServices_ = false;
            bitField0_ = bitField0_ & 0xffffffbf;
            pyGenericServices_ = false;
            bitField0_ = bitField0_ & 0xffffff7f;
            if (uninterpretedOptionBuilder_ == null)
            {
                uninterpretedOption_ = Collections.emptyList();
                bitField0_ = bitField0_ & 0xfffffeff;
                return this;
            } else
            {
                uninterpretedOptionBuilder_.clear();
                return this;
            }
        }

        public volatile GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile GeneratedMessage.ExtendableBuilder clear()
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

        public FileOptions.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile GeneratedMessage.Builder clone()
        {
            return clone();
        }

        public volatile GeneratedMessage.ExtendableBuilder clone()
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

        public FileOptions getDefaultInstanceForType()
        {
            return FileOptions.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return FileOptions.getDescriptor();
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return (UninterpretedOption)uninterpretedOption_.get(i);
            } else
            {
                return (UninterpretedOption)uninterpretedOptionBuilder_.getMessage(i);
            }
        }

        public int getUninterpretedOptionCount()
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return uninterpretedOption_.size();
            } else
            {
                return uninterpretedOptionBuilder_.getCount();
            }
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L7:
            if (i >= getUninterpretedOptionCount()) goto _L2; else goto _L1
_L1:
            if (getUninterpretedOption(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (!extensionsAreInitialized()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
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

        public FileOptions.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
                    javaPackage_ = codedinputstream.readBytes();
                    break;

                case 66: // 'B'
                    bitField0_ = bitField0_ | 2;
                    javaOuterClassname_ = codedinputstream.readBytes();
                    break;

                case 72: // 'H'
                    int j = codedinputstream.readEnum();
                    FileOptions.OptimizeMode optimizemode = FileOptions.OptimizeMode.valueOf(j);
                    if (optimizemode == null)
                    {
                        builder.mergeVarintField(9, j);
                    } else
                    {
                        bitField0_ = bitField0_ | 0x10;
                        optimizeFor_ = optimizemode;
                    }
                    break;

                case 80: // 'P'
                    bitField0_ = bitField0_ | 4;
                    javaMultipleFiles_ = codedinputstream.readBool();
                    break;

                case 128: 
                    bitField0_ = bitField0_ | 0x20;
                    ccGenericServices_ = codedinputstream.readBool();
                    break;

                case 136: 
                    bitField0_ = bitField0_ | 0x40;
                    javaGenericServices_ = codedinputstream.readBool();
                    break;

                case 144: 
                    bitField0_ = bitField0_ | 0x80;
                    pyGenericServices_ = codedinputstream.readBool();
                    break;

                case 160: 
                    bitField0_ = bitField0_ | 8;
                    javaGenerateEqualsAndHash_ = codedinputstream.readBool();
                    break;

                case 7994: 
                    UninterpretedOption.Builder builder1 = UninterpretedOption.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addUninterpretedOption(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public FileOptions.Builder mergeFrom(FileOptions fileoptions)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (fileoptions == FileOptions.getDefaultInstance())
            {
                return this;
            }
            if (fileoptions.hasJavaPackage())
            {
                setJavaPackage(fileoptions.getJavaPackage());
            }
            if (fileoptions.hasJavaOuterClassname())
            {
                setJavaOuterClassname(fileoptions.getJavaOuterClassname());
            }
            if (fileoptions.hasJavaMultipleFiles())
            {
                setJavaMultipleFiles(fileoptions.getJavaMultipleFiles());
            }
            if (fileoptions.hasJavaGenerateEqualsAndHash())
            {
                setJavaGenerateEqualsAndHash(fileoptions.getJavaGenerateEqualsAndHash());
            }
            if (fileoptions.hasOptimizeFor())
            {
                setOptimizeFor(fileoptions.getOptimizeFor());
            }
            if (fileoptions.hasCcGenericServices())
            {
                setCcGenericServices(fileoptions.getCcGenericServices());
            }
            if (fileoptions.hasJavaGenericServices())
            {
                setJavaGenericServices(fileoptions.getJavaGenericServices());
            }
            if (fileoptions.hasPyGenericServices())
            {
                setPyGenericServices(fileoptions.getPyGenericServices());
            }
            if (uninterpretedOptionBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!fileoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOption_.isEmpty())
                {
                    uninterpretedOption_ = fileoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & 0xfffffeff;
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.addAll(fileoptions.uninterpretedOption_);
                }
                onChanged();
            }
_L4:
            mergeExtensionFields(fileoptions);
            mergeUnknownFields(fileoptions.getUnknownFields());
            return this;
_L2:
            if (!fileoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOptionBuilder_.isEmpty())
                {
                    uninterpretedOptionBuilder_.dispose();
                    uninterpretedOptionBuilder_ = null;
                    uninterpretedOption_ = fileoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & 0xfffffeff;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getUninterpretedOptionFieldBuilder();
                    }
                    uninterpretedOptionBuilder_ = repeatedfieldbuilder;
                } else
                {
                    uninterpretedOptionBuilder_.addAllMessages(fileoptions.uninterpretedOption_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public FileOptions.Builder mergeFrom(Message message)
        {
            if (message instanceof FileOptions)
            {
                return mergeFrom((FileOptions)message);
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

        public FileOptions.Builder setCcGenericServices(boolean flag)
        {
            bitField0_ = bitField0_ | 0x20;
            ccGenericServices_ = flag;
            onChanged();
            return this;
        }

        public FileOptions.Builder setJavaGenerateEqualsAndHash(boolean flag)
        {
            bitField0_ = bitField0_ | 8;
            javaGenerateEqualsAndHash_ = flag;
            onChanged();
            return this;
        }

        public FileOptions.Builder setJavaGenericServices(boolean flag)
        {
            bitField0_ = bitField0_ | 0x40;
            javaGenericServices_ = flag;
            onChanged();
            return this;
        }

        public FileOptions.Builder setJavaMultipleFiles(boolean flag)
        {
            bitField0_ = bitField0_ | 4;
            javaMultipleFiles_ = flag;
            onChanged();
            return this;
        }

        public FileOptions.Builder setJavaOuterClassname(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                javaOuterClassname_ = s;
                onChanged();
                return this;
            }
        }

        public FileOptions.Builder setJavaPackage(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                javaPackage_ = s;
                onChanged();
                return this;
            }
        }

        public FileOptions.Builder setOptimizeFor(FileOptions.OptimizeMode optimizemode)
        {
            if (optimizemode == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x10;
                optimizeFor_ = optimizemode;
                onChanged();
                return this;
            }
        }

        public FileOptions.Builder setPyGenericServices(boolean flag)
        {
            bitField0_ = bitField0_ | 0x80;
            pyGenericServices_ = flag;
            onChanged();
            return this;
        }


        private FileOptions.Builder()
        {
            javaPackage_ = "";
            javaOuterClassname_ = "";
            optimizeFor_ = FileOptions.OptimizeMode.SPEED;
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private FileOptions.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            javaPackage_ = "";
            javaOuterClassname_ = "";
            optimizeFor_ = FileOptions.OptimizeMode.SPEED;
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

    }

    public static final class FileOptions.OptimizeMode extends Enum
        implements ProtocolMessageEnum
    {

        private static final FileOptions.OptimizeMode $VALUES[];
        public static final FileOptions.OptimizeMode CODE_SIZE;
        public static final FileOptions.OptimizeMode LITE_RUNTIME;
        public static final FileOptions.OptimizeMode SPEED;
        private static final FileOptions.OptimizeMode VALUES[];
        private static Internal.EnumLiteMap internalValueMap = new Internal.EnumLiteMap() {

        };
        private final int index;
        private final int value;

        public static FileOptions.OptimizeMode valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return SPEED;

            case 2: // '\002'
                return CODE_SIZE;

            case 3: // '\003'
                return LITE_RUNTIME;
            }
        }

        public static FileOptions.OptimizeMode valueOf(String s)
        {
            return (FileOptions.OptimizeMode)Enum.valueOf(com/google/protobuf/DescriptorProtos$FileOptions$OptimizeMode, s);
        }

        public static FileOptions.OptimizeMode[] values()
        {
            return (FileOptions.OptimizeMode[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            SPEED = new FileOptions.OptimizeMode("SPEED", 0, 0, 1);
            CODE_SIZE = new FileOptions.OptimizeMode("CODE_SIZE", 1, 1, 2);
            LITE_RUNTIME = new FileOptions.OptimizeMode("LITE_RUNTIME", 2, 2, 3);
            $VALUES = (new FileOptions.OptimizeMode[] {
                SPEED, CODE_SIZE, LITE_RUNTIME
            });
            VALUES = (new FileOptions.OptimizeMode[] {
                SPEED, CODE_SIZE, LITE_RUNTIME
            });
        }

        private FileOptions.OptimizeMode(String s, int i, int j, int k)
        {
            super(s, i);
            index = j;
            value = k;
        }
    }

    public static interface FileOptionsOrBuilder
        extends GeneratedMessage.ExtendableMessageOrBuilder
    {
    }

    public static final class MessageOptions extends GeneratedMessage.ExtendableMessage
        implements MessageOptionsOrBuilder
    {

        private static final MessageOptions defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private List uninterpretedOption_;

        public static MessageOptions getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
        }

        private void initFields()
        {
            messageSetWireFormat_ = false;
            noStandardDescriptorAccessor_ = false;
            uninterpretedOption_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(MessageOptions messageoptions)
        {
            return newBuilder().mergeFrom(messageoptions);
        }

        public MessageOptions getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public boolean getMessageSetWireFormat()
        {
            return messageSetWireFormat_;
        }

        public boolean getNoStandardDescriptorAccessor()
        {
            return noStandardDescriptorAccessor_;
        }

        public int getSerializedSize()
        {
            boolean flag = false;
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            int j;
            if ((bitField0_ & 1) == 1)
            {
                i = CodedOutputStream.computeBoolSize(1, messageSetWireFormat_) + 0;
            } else
            {
                i = 0;
            }
            j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeBoolSize(2, noStandardDescriptorAccessor_);
            }
            i = j;
            for (int k = ((flag) ? 1 : 0); k < uninterpretedOption_.size();)
            {
                int l = CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(k));
                k++;
                i = l + i;
            }

            i = extensionsSerializedSize() + i + getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            return (UninterpretedOption)uninterpretedOption_.get(i);
        }

        public int getUninterpretedOptionCount()
        {
            return uninterpretedOption_.size();
        }

        public boolean hasMessageSetWireFormat()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasNoStandardDescriptorAccessor()
        {
            return (bitField0_ & 2) == 2;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_MessageOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++)
            {
                if (!getUninterpretedOption(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (!extensionsAreInitialized())
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
            return new Builder(builderparent);
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
            GeneratedMessage.ExtendableMessage.ExtensionWriter extensionwriter = newExtensionWriter();
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeBool(1, messageSetWireFormat_);
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBool(2, noStandardDescriptorAccessor_);
            }
            for (int i = 0; i < uninterpretedOption_.size(); i++)
            {
                codedoutputstream.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
            }

            extensionwriter.writeUntil(0x20000000, codedoutputstream);
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new MessageOptions(true);
            defaultInstance.initFields();
        }


/*
        static boolean access$12402(MessageOptions messageoptions, boolean flag)
        {
            messageoptions.messageSetWireFormat_ = flag;
            return flag;
        }

*/


/*
        static boolean access$12502(MessageOptions messageoptions, boolean flag)
        {
            messageoptions.noStandardDescriptorAccessor_ = flag;
            return flag;
        }

*/



/*
        static List access$12602(MessageOptions messageoptions, List list)
        {
            messageoptions.uninterpretedOption_ = list;
            return list;
        }

*/


/*
        static int access$12702(MessageOptions messageoptions, int i)
        {
            messageoptions.bitField0_ = i;
            return i;
        }

*/

        private MessageOptions(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private MessageOptions(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class MessageOptions.Builder extends GeneratedMessage.ExtendableBuilder
        implements MessageOptionsOrBuilder
    {

        private int bitField0_;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private RepeatedFieldBuilder uninterpretedOptionBuilder_;
        private List uninterpretedOption_;

        private static MessageOptions.Builder create()
        {
            return new MessageOptions.Builder();
        }

        private void ensureUninterpretedOptionIsMutable()
        {
            if ((bitField0_ & 4) != 4)
            {
                uninterpretedOption_ = new ArrayList(uninterpretedOption_);
                bitField0_ = bitField0_ | 4;
            }
        }

        private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder()
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                List list = uninterpretedOption_;
                boolean flag;
                if ((bitField0_ & 4) == 4)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                uninterpretedOption_ = null;
            }
            return uninterpretedOptionBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getUninterpretedOptionFieldBuilder();
            }
        }

        public MessageOptions.Builder addUninterpretedOption(UninterpretedOption uninterpretedoption)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                if (uninterpretedoption == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.add(uninterpretedoption);
                    onChanged();
                    return this;
                }
            } else
            {
                uninterpretedOptionBuilder_.addMessage(uninterpretedoption);
                return this;
            }
        }

        public MessageOptions build()
        {
            MessageOptions messageoptions = buildPartial();
            if (!messageoptions.isInitialized())
            {
                throw newUninitializedMessageException(messageoptions);
            } else
            {
                return messageoptions;
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

        public MessageOptions buildPartial()
        {
            int i = 1;
            MessageOptions messageoptions = new MessageOptions(this);
            int k = bitField0_;
            int j;
            if ((k & 1) != 1)
            {
                i = 0;
            }
            messageoptions.messageSetWireFormat_ = messageSetWireFormat_;
            j = i;
            if ((k & 2) == 2)
            {
                j = i | 2;
            }
            messageoptions.noStandardDescriptorAccessor_ = noStandardDescriptorAccessor_;
            if (uninterpretedOptionBuilder_ == null)
            {
                if ((bitField0_ & 4) == 4)
                {
                    uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
                    bitField0_ = bitField0_ & -5;
                }
                messageoptions.uninterpretedOption_ = uninterpretedOption_;
            } else
            {
                messageoptions.uninterpretedOption_ = uninterpretedOptionBuilder_.build();
            }
            messageoptions.bitField0_ = j;
            onBuilt();
            return messageoptions;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public MessageOptions.Builder clear()
        {
            super.clear();
            messageSetWireFormat_ = false;
            bitField0_ = bitField0_ & -2;
            noStandardDescriptorAccessor_ = false;
            bitField0_ = bitField0_ & -3;
            if (uninterpretedOptionBuilder_ == null)
            {
                uninterpretedOption_ = Collections.emptyList();
                bitField0_ = bitField0_ & -5;
                return this;
            } else
            {
                uninterpretedOptionBuilder_.clear();
                return this;
            }
        }

        public volatile GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile GeneratedMessage.ExtendableBuilder clear()
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

        public MessageOptions.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile GeneratedMessage.Builder clone()
        {
            return clone();
        }

        public volatile GeneratedMessage.ExtendableBuilder clone()
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

        public MessageOptions getDefaultInstanceForType()
        {
            return MessageOptions.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return MessageOptions.getDescriptor();
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return (UninterpretedOption)uninterpretedOption_.get(i);
            } else
            {
                return (UninterpretedOption)uninterpretedOptionBuilder_.getMessage(i);
            }
        }

        public int getUninterpretedOptionCount()
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return uninterpretedOption_.size();
            } else
            {
                return uninterpretedOptionBuilder_.getCount();
            }
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_MessageOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L7:
            if (i >= getUninterpretedOptionCount()) goto _L2; else goto _L1
_L1:
            if (getUninterpretedOption(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (!extensionsAreInitialized()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
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

        public MessageOptions.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

                case 8: // '\b'
                    bitField0_ = bitField0_ | 1;
                    messageSetWireFormat_ = codedinputstream.readBool();
                    break;

                case 16: // '\020'
                    bitField0_ = bitField0_ | 2;
                    noStandardDescriptorAccessor_ = codedinputstream.readBool();
                    break;

                case 7994: 
                    UninterpretedOption.Builder builder1 = UninterpretedOption.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addUninterpretedOption(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public MessageOptions.Builder mergeFrom(MessageOptions messageoptions)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (messageoptions == MessageOptions.getDefaultInstance())
            {
                return this;
            }
            if (messageoptions.hasMessageSetWireFormat())
            {
                setMessageSetWireFormat(messageoptions.getMessageSetWireFormat());
            }
            if (messageoptions.hasNoStandardDescriptorAccessor())
            {
                setNoStandardDescriptorAccessor(messageoptions.getNoStandardDescriptorAccessor());
            }
            if (uninterpretedOptionBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!messageoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOption_.isEmpty())
                {
                    uninterpretedOption_ = messageoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & -5;
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.addAll(messageoptions.uninterpretedOption_);
                }
                onChanged();
            }
_L4:
            mergeExtensionFields(messageoptions);
            mergeUnknownFields(messageoptions.getUnknownFields());
            return this;
_L2:
            if (!messageoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOptionBuilder_.isEmpty())
                {
                    uninterpretedOptionBuilder_.dispose();
                    uninterpretedOptionBuilder_ = null;
                    uninterpretedOption_ = messageoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & -5;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getUninterpretedOptionFieldBuilder();
                    }
                    uninterpretedOptionBuilder_ = repeatedfieldbuilder;
                } else
                {
                    uninterpretedOptionBuilder_.addAllMessages(messageoptions.uninterpretedOption_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public MessageOptions.Builder mergeFrom(Message message)
        {
            if (message instanceof MessageOptions)
            {
                return mergeFrom((MessageOptions)message);
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

        public MessageOptions.Builder setMessageSetWireFormat(boolean flag)
        {
            bitField0_ = bitField0_ | 1;
            messageSetWireFormat_ = flag;
            onChanged();
            return this;
        }

        public MessageOptions.Builder setNoStandardDescriptorAccessor(boolean flag)
        {
            bitField0_ = bitField0_ | 2;
            noStandardDescriptorAccessor_ = flag;
            onChanged();
            return this;
        }


        private MessageOptions.Builder()
        {
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private MessageOptions.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

    }

    public static interface MessageOptionsOrBuilder
        extends GeneratedMessage.ExtendableMessageOrBuilder
    {
    }

    public static final class MethodDescriptorProto extends GeneratedMessage
        implements MethodDescriptorProtoOrBuilder
    {

        private static final MethodDescriptorProto defaultInstance;
        private int bitField0_;
        private Object inputType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private MethodOptions options_;
        private Object outputType_;

        public static MethodDescriptorProto getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
        }

        private ByteString getInputTypeBytes()
        {
            Object obj = inputType_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                inputType_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private ByteString getNameBytes()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                name_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private ByteString getOutputTypeBytes()
        {
            Object obj = outputType_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                outputType_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private void initFields()
        {
            name_ = "";
            inputType_ = "";
            outputType_ = "";
            options_ = MethodOptions.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(MethodDescriptorProto methoddescriptorproto)
        {
            return newBuilder().mergeFrom(methoddescriptorproto);
        }

        public MethodDescriptorProto getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public String getInputType()
        {
            Object obj = inputType_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                inputType_ = s;
            }
            return s;
        }

        public String getName()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                name_ = s;
            }
            return s;
        }

        public MethodOptions getOptions()
        {
            return options_;
        }

        public String getOutputType()
        {
            Object obj = outputType_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                outputType_ = s;
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
            int j = 0;
            if ((bitField0_ & 1) == 1)
            {
                j = 0 + CodedOutputStream.computeBytesSize(1, getNameBytes());
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeBytesSize(2, getInputTypeBytes());
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeBytesSize(3, getOutputTypeBytes());
            }
            i = j;
            if ((bitField0_ & 8) == 8)
            {
                i = j + CodedOutputStream.computeMessageSize(4, options_);
            }
            i += getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public boolean hasInputType()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasName()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 8) == 8;
        }

        public boolean hasOutputType()
        {
            return (bitField0_ & 4) == 4;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            if (hasOptions() && !getOptions().isInitialized())
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
            return new Builder(builderparent);
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
                codedoutputstream.writeBytes(1, getNameBytes());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBytes(2, getInputTypeBytes());
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeBytes(3, getOutputTypeBytes());
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeMessage(4, options_);
            }
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new MethodDescriptorProto(true);
            defaultInstance.initFields();
        }


/*
        static MethodOptions access$10002(MethodDescriptorProto methoddescriptorproto, MethodOptions methodoptions)
        {
            methoddescriptorproto.options_ = methodoptions;
            return methodoptions;
        }

*/


/*
        static int access$10102(MethodDescriptorProto methoddescriptorproto, int i)
        {
            methoddescriptorproto.bitField0_ = i;
            return i;
        }

*/


/*
        static Object access$9702(MethodDescriptorProto methoddescriptorproto, Object obj)
        {
            methoddescriptorproto.name_ = obj;
            return obj;
        }

*/


/*
        static Object access$9802(MethodDescriptorProto methoddescriptorproto, Object obj)
        {
            methoddescriptorproto.inputType_ = obj;
            return obj;
        }

*/


/*
        static Object access$9902(MethodDescriptorProto methoddescriptorproto, Object obj)
        {
            methoddescriptorproto.outputType_ = obj;
            return obj;
        }

*/

        private MethodDescriptorProto(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private MethodDescriptorProto(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class MethodDescriptorProto.Builder extends GeneratedMessage.Builder
        implements MethodDescriptorProtoOrBuilder
    {

        private int bitField0_;
        private Object inputType_;
        private Object name_;
        private SingleFieldBuilder optionsBuilder_;
        private MethodOptions options_;
        private Object outputType_;

        private static MethodDescriptorProto.Builder create()
        {
            return new MethodDescriptorProto.Builder();
        }

        private SingleFieldBuilder getOptionsFieldBuilder()
        {
            if (optionsBuilder_ == null)
            {
                optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
                options_ = null;
            }
            return optionsBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getOptionsFieldBuilder();
            }
        }

        public MethodDescriptorProto build()
        {
            MethodDescriptorProto methoddescriptorproto = buildPartial();
            if (!methoddescriptorproto.isInitialized())
            {
                throw newUninitializedMessageException(methoddescriptorproto);
            } else
            {
                return methoddescriptorproto;
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

        public MethodDescriptorProto buildPartial()
        {
            int j = 1;
            MethodDescriptorProto methoddescriptorproto = new MethodDescriptorProto(this);
            int k = bitField0_;
            int i;
            if ((k & 1) != 1)
            {
                j = 0;
            }
            methoddescriptorproto.name_ = name_;
            i = j;
            if ((k & 2) == 2)
            {
                i = j | 2;
            }
            methoddescriptorproto.inputType_ = inputType_;
            j = i;
            if ((k & 4) == 4)
            {
                j = i | 4;
            }
            methoddescriptorproto.outputType_ = outputType_;
            if ((k & 8) == 8)
            {
                i = j | 8;
            } else
            {
                i = j;
            }
            if (optionsBuilder_ == null)
            {
                methoddescriptorproto.options_ = options_;
            } else
            {
                methoddescriptorproto.options_ = (MethodOptions)optionsBuilder_.build();
            }
            methoddescriptorproto.bitField0_ = i;
            onBuilt();
            return methoddescriptorproto;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public MethodDescriptorProto.Builder clear()
        {
            super.clear();
            name_ = "";
            bitField0_ = bitField0_ & -2;
            inputType_ = "";
            bitField0_ = bitField0_ & -3;
            outputType_ = "";
            bitField0_ = bitField0_ & -5;
            if (optionsBuilder_ == null)
            {
                options_ = MethodOptions.getDefaultInstance();
            } else
            {
                optionsBuilder_.clear();
            }
            bitField0_ = bitField0_ & -9;
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

        public MethodDescriptorProto.Builder clone()
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

        public MethodDescriptorProto getDefaultInstanceForType()
        {
            return MethodDescriptorProto.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return MethodDescriptorProto.getDescriptor();
        }

        public MethodOptions getOptions()
        {
            if (optionsBuilder_ == null)
            {
                return options_;
            } else
            {
                return (MethodOptions)optionsBuilder_.getMessage();
            }
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 8) == 8;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            return !hasOptions() || getOptions().isInitialized();
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

        public MethodDescriptorProto.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
                    name_ = codedinputstream.readBytes();
                    break;

                case 18: // '\022'
                    bitField0_ = bitField0_ | 2;
                    inputType_ = codedinputstream.readBytes();
                    break;

                case 26: // '\032'
                    bitField0_ = bitField0_ | 4;
                    outputType_ = codedinputstream.readBytes();
                    break;

                case 34: // '"'
                    MethodOptions.Builder builder1 = MethodOptions.newBuilder();
                    if (hasOptions())
                    {
                        builder1.mergeFrom(getOptions());
                    }
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    setOptions(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public MethodDescriptorProto.Builder mergeFrom(MethodDescriptorProto methoddescriptorproto)
        {
            if (methoddescriptorproto == MethodDescriptorProto.getDefaultInstance())
            {
                return this;
            }
            if (methoddescriptorproto.hasName())
            {
                setName(methoddescriptorproto.getName());
            }
            if (methoddescriptorproto.hasInputType())
            {
                setInputType(methoddescriptorproto.getInputType());
            }
            if (methoddescriptorproto.hasOutputType())
            {
                setOutputType(methoddescriptorproto.getOutputType());
            }
            if (methoddescriptorproto.hasOptions())
            {
                mergeOptions(methoddescriptorproto.getOptions());
            }
            mergeUnknownFields(methoddescriptorproto.getUnknownFields());
            return this;
        }

        public MethodDescriptorProto.Builder mergeFrom(Message message)
        {
            if (message instanceof MethodDescriptorProto)
            {
                return mergeFrom((MethodDescriptorProto)message);
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

        public MethodDescriptorProto.Builder mergeOptions(MethodOptions methodoptions)
        {
            if (optionsBuilder_ == null)
            {
                if ((bitField0_ & 8) == 8 && options_ != MethodOptions.getDefaultInstance())
                {
                    options_ = MethodOptions.newBuilder(options_).mergeFrom(methodoptions).buildPartial();
                } else
                {
                    options_ = methodoptions;
                }
                onChanged();
            } else
            {
                optionsBuilder_.mergeFrom(methodoptions);
            }
            bitField0_ = bitField0_ | 8;
            return this;
        }

        public MethodDescriptorProto.Builder setInputType(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                inputType_ = s;
                onChanged();
                return this;
            }
        }

        public MethodDescriptorProto.Builder setName(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                name_ = s;
                onChanged();
                return this;
            }
        }

        public MethodDescriptorProto.Builder setOptions(MethodOptions methodoptions)
        {
            if (optionsBuilder_ == null)
            {
                if (methodoptions == null)
                {
                    throw new NullPointerException();
                }
                options_ = methodoptions;
                onChanged();
            } else
            {
                optionsBuilder_.setMessage(methodoptions);
            }
            bitField0_ = bitField0_ | 8;
            return this;
        }

        public MethodDescriptorProto.Builder setOutputType(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                outputType_ = s;
                onChanged();
                return this;
            }
        }


        private MethodDescriptorProto.Builder()
        {
            name_ = "";
            inputType_ = "";
            outputType_ = "";
            options_ = MethodOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        private MethodDescriptorProto.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            inputType_ = "";
            outputType_ = "";
            options_ = MethodOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

    }

    public static interface MethodDescriptorProtoOrBuilder
        extends MessageOrBuilder
    {
    }

    public static final class MethodOptions extends GeneratedMessage.ExtendableMessage
        implements MethodOptionsOrBuilder
    {

        private static final MethodOptions defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List uninterpretedOption_;

        public static MethodOptions getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor;
        }

        private void initFields()
        {
            uninterpretedOption_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(MethodOptions methodoptions)
        {
            return newBuilder().mergeFrom(methodoptions);
        }

        public MethodOptions getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            int j = 0;
            for (; i < uninterpretedOption_.size(); i++)
            {
                j += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
            }

            i = extensionsSerializedSize() + j + getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            return (UninterpretedOption)uninterpretedOption_.get(i);
        }

        public int getUninterpretedOptionCount()
        {
            return uninterpretedOption_.size();
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++)
            {
                if (!getUninterpretedOption(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (!extensionsAreInitialized())
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
            return new Builder(builderparent);
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
            GeneratedMessage.ExtendableMessage.ExtensionWriter extensionwriter = newExtensionWriter();
            for (int i = 0; i < uninterpretedOption_.size(); i++)
            {
                codedoutputstream.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
            }

            extensionwriter.writeUntil(0x20000000, codedoutputstream);
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new MethodOptions(true);
            defaultInstance.initFields();
        }



/*
        static List access$16702(MethodOptions methodoptions, List list)
        {
            methodoptions.uninterpretedOption_ = list;
            return list;
        }

*/

        private MethodOptions(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private MethodOptions(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class MethodOptions.Builder extends GeneratedMessage.ExtendableBuilder
        implements MethodOptionsOrBuilder
    {

        private int bitField0_;
        private RepeatedFieldBuilder uninterpretedOptionBuilder_;
        private List uninterpretedOption_;

        private static MethodOptions.Builder create()
        {
            return new MethodOptions.Builder();
        }

        private void ensureUninterpretedOptionIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                uninterpretedOption_ = new ArrayList(uninterpretedOption_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder()
        {
            boolean flag = true;
            if (uninterpretedOptionBuilder_ == null)
            {
                List list = uninterpretedOption_;
                if ((bitField0_ & 1) != 1)
                {
                    flag = false;
                }
                uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                uninterpretedOption_ = null;
            }
            return uninterpretedOptionBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getUninterpretedOptionFieldBuilder();
            }
        }

        public MethodOptions.Builder addUninterpretedOption(UninterpretedOption uninterpretedoption)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                if (uninterpretedoption == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.add(uninterpretedoption);
                    onChanged();
                    return this;
                }
            } else
            {
                uninterpretedOptionBuilder_.addMessage(uninterpretedoption);
                return this;
            }
        }

        public MethodOptions build()
        {
            MethodOptions methodoptions = buildPartial();
            if (!methodoptions.isInitialized())
            {
                throw newUninitializedMessageException(methodoptions);
            } else
            {
                return methodoptions;
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

        public MethodOptions buildPartial()
        {
            MethodOptions methodoptions = new MethodOptions(this);
            int i = bitField0_;
            if (uninterpretedOptionBuilder_ == null)
            {
                if ((bitField0_ & 1) == 1)
                {
                    uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
                    bitField0_ = bitField0_ & -2;
                }
                methodoptions.uninterpretedOption_ = uninterpretedOption_;
            } else
            {
                methodoptions.uninterpretedOption_ = uninterpretedOptionBuilder_.build();
            }
            onBuilt();
            return methodoptions;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public MethodOptions.Builder clear()
        {
            super.clear();
            if (uninterpretedOptionBuilder_ == null)
            {
                uninterpretedOption_ = Collections.emptyList();
                bitField0_ = bitField0_ & -2;
                return this;
            } else
            {
                uninterpretedOptionBuilder_.clear();
                return this;
            }
        }

        public volatile GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile GeneratedMessage.ExtendableBuilder clear()
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

        public MethodOptions.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile GeneratedMessage.Builder clone()
        {
            return clone();
        }

        public volatile GeneratedMessage.ExtendableBuilder clone()
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

        public MethodOptions getDefaultInstanceForType()
        {
            return MethodOptions.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return MethodOptions.getDescriptor();
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return (UninterpretedOption)uninterpretedOption_.get(i);
            } else
            {
                return (UninterpretedOption)uninterpretedOptionBuilder_.getMessage(i);
            }
        }

        public int getUninterpretedOptionCount()
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return uninterpretedOption_.size();
            } else
            {
                return uninterpretedOptionBuilder_.getCount();
            }
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L7:
            if (i >= getUninterpretedOptionCount()) goto _L2; else goto _L1
_L1:
            if (getUninterpretedOption(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (!extensionsAreInitialized()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
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

        public MethodOptions.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

                case 7994: 
                    UninterpretedOption.Builder builder1 = UninterpretedOption.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addUninterpretedOption(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public MethodOptions.Builder mergeFrom(MethodOptions methodoptions)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (methodoptions == MethodOptions.getDefaultInstance())
            {
                return this;
            }
            if (uninterpretedOptionBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!methodoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOption_.isEmpty())
                {
                    uninterpretedOption_ = methodoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.addAll(methodoptions.uninterpretedOption_);
                }
                onChanged();
            }
_L4:
            mergeExtensionFields(methodoptions);
            mergeUnknownFields(methodoptions.getUnknownFields());
            return this;
_L2:
            if (!methodoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOptionBuilder_.isEmpty())
                {
                    uninterpretedOptionBuilder_.dispose();
                    uninterpretedOptionBuilder_ = null;
                    uninterpretedOption_ = methodoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & -2;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getUninterpretedOptionFieldBuilder();
                    }
                    uninterpretedOptionBuilder_ = repeatedfieldbuilder;
                } else
                {
                    uninterpretedOptionBuilder_.addAllMessages(methodoptions.uninterpretedOption_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public MethodOptions.Builder mergeFrom(Message message)
        {
            if (message instanceof MethodOptions)
            {
                return mergeFrom((MethodOptions)message);
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


        private MethodOptions.Builder()
        {
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private MethodOptions.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

    }

    public static interface MethodOptionsOrBuilder
        extends GeneratedMessage.ExtendableMessageOrBuilder
    {
    }

    public static final class ServiceDescriptorProto extends GeneratedMessage
        implements ServiceDescriptorProtoOrBuilder
    {

        private static final ServiceDescriptorProto defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List method_;
        private Object name_;
        private ServiceOptions options_;

        public static ServiceDescriptorProto getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_descriptor;
        }

        private ByteString getNameBytes()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                name_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        private void initFields()
        {
            name_ = "";
            method_ = Collections.emptyList();
            options_ = ServiceOptions.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(ServiceDescriptorProto servicedescriptorproto)
        {
            return newBuilder().mergeFrom(servicedescriptorproto);
        }

        public ServiceDescriptorProto getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public MethodDescriptorProto getMethod(int i)
        {
            return (MethodDescriptorProto)method_.get(i);
        }

        public int getMethodCount()
        {
            return method_.size();
        }

        public String getName()
        {
            Object obj = name_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                name_ = s;
            }
            return s;
        }

        public ServiceOptions getOptions()
        {
            return options_;
        }

        public int getSerializedSize()
        {
            int j = 0;
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            if ((bitField0_ & 1) == 1)
            {
                i = CodedOutputStream.computeBytesSize(1, getNameBytes()) + 0;
            } else
            {
                i = 0;
            }
            while (j < method_.size()) 
            {
                int k = CodedOutputStream.computeMessageSize(2, (MessageLite)method_.get(j));
                j++;
                i = k + i;
            }
            j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeMessageSize(3, options_);
            }
            i = getUnknownFields().getSerializedSize() + j;
            memoizedSerializedSize = i;
            return i;
        }

        public boolean hasName()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 2) == 2;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i = 0; i < getMethodCount(); i++)
            {
                if (!getMethod(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (hasOptions() && !getOptions().isInitialized())
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
            return new Builder(builderparent);
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
                codedoutputstream.writeBytes(1, getNameBytes());
            }
            for (int i = 0; i < method_.size(); i++)
            {
                codedoutputstream.writeMessage(2, (MessageLite)method_.get(i));
            }

            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeMessage(3, options_);
            }
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new ServiceDescriptorProto(true);
            defaultInstance.initFields();
        }


/*
        static Object access$8702(ServiceDescriptorProto servicedescriptorproto, Object obj)
        {
            servicedescriptorproto.name_ = obj;
            return obj;
        }

*/



/*
        static List access$8802(ServiceDescriptorProto servicedescriptorproto, List list)
        {
            servicedescriptorproto.method_ = list;
            return list;
        }

*/


/*
        static ServiceOptions access$8902(ServiceDescriptorProto servicedescriptorproto, ServiceOptions serviceoptions)
        {
            servicedescriptorproto.options_ = serviceoptions;
            return serviceoptions;
        }

*/


/*
        static int access$9002(ServiceDescriptorProto servicedescriptorproto, int i)
        {
            servicedescriptorproto.bitField0_ = i;
            return i;
        }

*/

        private ServiceDescriptorProto(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private ServiceDescriptorProto(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class ServiceDescriptorProto.Builder extends GeneratedMessage.Builder
        implements ServiceDescriptorProtoOrBuilder
    {

        private int bitField0_;
        private RepeatedFieldBuilder methodBuilder_;
        private List method_;
        private Object name_;
        private SingleFieldBuilder optionsBuilder_;
        private ServiceOptions options_;

        private static ServiceDescriptorProto.Builder create()
        {
            return new ServiceDescriptorProto.Builder();
        }

        private void ensureMethodIsMutable()
        {
            if ((bitField0_ & 2) != 2)
            {
                method_ = new ArrayList(method_);
                bitField0_ = bitField0_ | 2;
            }
        }

        private RepeatedFieldBuilder getMethodFieldBuilder()
        {
            if (methodBuilder_ == null)
            {
                List list = method_;
                boolean flag;
                if ((bitField0_ & 2) == 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                methodBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                method_ = null;
            }
            return methodBuilder_;
        }

        private SingleFieldBuilder getOptionsFieldBuilder()
        {
            if (optionsBuilder_ == null)
            {
                optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
                options_ = null;
            }
            return optionsBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getMethodFieldBuilder();
                getOptionsFieldBuilder();
            }
        }

        public ServiceDescriptorProto.Builder addMethod(MethodDescriptorProto methoddescriptorproto)
        {
            if (methodBuilder_ == null)
            {
                if (methoddescriptorproto == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureMethodIsMutable();
                    method_.add(methoddescriptorproto);
                    onChanged();
                    return this;
                }
            } else
            {
                methodBuilder_.addMessage(methoddescriptorproto);
                return this;
            }
        }

        public ServiceDescriptorProto build()
        {
            ServiceDescriptorProto servicedescriptorproto = buildPartial();
            if (!servicedescriptorproto.isInitialized())
            {
                throw newUninitializedMessageException(servicedescriptorproto);
            } else
            {
                return servicedescriptorproto;
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

        public ServiceDescriptorProto buildPartial()
        {
            int i = 1;
            ServiceDescriptorProto servicedescriptorproto = new ServiceDescriptorProto(this);
            int j = bitField0_;
            if ((j & 1) != 1)
            {
                i = 0;
            }
            servicedescriptorproto.name_ = name_;
            if (methodBuilder_ == null)
            {
                if ((bitField0_ & 2) == 2)
                {
                    method_ = Collections.unmodifiableList(method_);
                    bitField0_ = bitField0_ & -3;
                }
                servicedescriptorproto.method_ = method_;
            } else
            {
                servicedescriptorproto.method_ = methodBuilder_.build();
            }
            if ((j & 4) == 4)
            {
                i |= 2;
            }
            if (optionsBuilder_ == null)
            {
                servicedescriptorproto.options_ = options_;
            } else
            {
                servicedescriptorproto.options_ = (ServiceOptions)optionsBuilder_.build();
            }
            servicedescriptorproto.bitField0_ = i;
            onBuilt();
            return servicedescriptorproto;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public ServiceDescriptorProto.Builder clear()
        {
            super.clear();
            name_ = "";
            bitField0_ = bitField0_ & -2;
            if (methodBuilder_ == null)
            {
                method_ = Collections.emptyList();
                bitField0_ = bitField0_ & -3;
            } else
            {
                methodBuilder_.clear();
            }
            if (optionsBuilder_ == null)
            {
                options_ = ServiceOptions.getDefaultInstance();
            } else
            {
                optionsBuilder_.clear();
            }
            bitField0_ = bitField0_ & -5;
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

        public ServiceDescriptorProto.Builder clone()
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

        public ServiceDescriptorProto getDefaultInstanceForType()
        {
            return ServiceDescriptorProto.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return ServiceDescriptorProto.getDescriptor();
        }

        public MethodDescriptorProto getMethod(int i)
        {
            if (methodBuilder_ == null)
            {
                return (MethodDescriptorProto)method_.get(i);
            } else
            {
                return (MethodDescriptorProto)methodBuilder_.getMessage(i);
            }
        }

        public int getMethodCount()
        {
            if (methodBuilder_ == null)
            {
                return method_.size();
            } else
            {
                return methodBuilder_.getCount();
            }
        }

        public ServiceOptions getOptions()
        {
            if (optionsBuilder_ == null)
            {
                return options_;
            } else
            {
                return (ServiceOptions)optionsBuilder_.getMessage();
            }
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 4) == 4;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L7:
            if (i >= getMethodCount()) goto _L2; else goto _L1
_L1:
            if (getMethod(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (hasOptions() && !getOptions().isInitialized()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
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

        public ServiceDescriptorProto.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
                    name_ = codedinputstream.readBytes();
                    break;

                case 18: // '\022'
                    MethodDescriptorProto.Builder builder1 = MethodDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addMethod(builder1.buildPartial());
                    break;

                case 26: // '\032'
                    ServiceOptions.Builder builder2 = ServiceOptions.newBuilder();
                    if (hasOptions())
                    {
                        builder2.mergeFrom(getOptions());
                    }
                    codedinputstream.readMessage(builder2, extensionregistrylite);
                    setOptions(builder2.buildPartial());
                    break;
                }
            } while (true);
        }

        public ServiceDescriptorProto.Builder mergeFrom(ServiceDescriptorProto servicedescriptorproto)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (servicedescriptorproto == ServiceDescriptorProto.getDefaultInstance())
            {
                return this;
            }
            if (servicedescriptorproto.hasName())
            {
                setName(servicedescriptorproto.getName());
            }
            if (methodBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!servicedescriptorproto.method_.isEmpty())
            {
                if (method_.isEmpty())
                {
                    method_ = servicedescriptorproto.method_;
                    bitField0_ = bitField0_ & -3;
                } else
                {
                    ensureMethodIsMutable();
                    method_.addAll(servicedescriptorproto.method_);
                }
                onChanged();
            }
_L4:
            if (servicedescriptorproto.hasOptions())
            {
                mergeOptions(servicedescriptorproto.getOptions());
            }
            mergeUnknownFields(servicedescriptorproto.getUnknownFields());
            return this;
_L2:
            if (!servicedescriptorproto.method_.isEmpty())
            {
                if (methodBuilder_.isEmpty())
                {
                    methodBuilder_.dispose();
                    methodBuilder_ = null;
                    method_ = servicedescriptorproto.method_;
                    bitField0_ = bitField0_ & -3;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getMethodFieldBuilder();
                    }
                    methodBuilder_ = repeatedfieldbuilder;
                } else
                {
                    methodBuilder_.addAllMessages(servicedescriptorproto.method_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public ServiceDescriptorProto.Builder mergeFrom(Message message)
        {
            if (message instanceof ServiceDescriptorProto)
            {
                return mergeFrom((ServiceDescriptorProto)message);
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

        public ServiceDescriptorProto.Builder mergeOptions(ServiceOptions serviceoptions)
        {
            if (optionsBuilder_ == null)
            {
                if ((bitField0_ & 4) == 4 && options_ != ServiceOptions.getDefaultInstance())
                {
                    options_ = ServiceOptions.newBuilder(options_).mergeFrom(serviceoptions).buildPartial();
                } else
                {
                    options_ = serviceoptions;
                }
                onChanged();
            } else
            {
                optionsBuilder_.mergeFrom(serviceoptions);
            }
            bitField0_ = bitField0_ | 4;
            return this;
        }

        public ServiceDescriptorProto.Builder setName(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                name_ = s;
                onChanged();
                return this;
            }
        }

        public ServiceDescriptorProto.Builder setOptions(ServiceOptions serviceoptions)
        {
            if (optionsBuilder_ == null)
            {
                if (serviceoptions == null)
                {
                    throw new NullPointerException();
                }
                options_ = serviceoptions;
                onChanged();
            } else
            {
                optionsBuilder_.setMessage(serviceoptions);
            }
            bitField0_ = bitField0_ | 4;
            return this;
        }


        private ServiceDescriptorProto.Builder()
        {
            name_ = "";
            method_ = Collections.emptyList();
            options_ = ServiceOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        private ServiceDescriptorProto.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            method_ = Collections.emptyList();
            options_ = ServiceOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

    }

    public static interface ServiceDescriptorProtoOrBuilder
        extends MessageOrBuilder
    {
    }

    public static final class ServiceOptions extends GeneratedMessage.ExtendableMessage
        implements ServiceOptionsOrBuilder
    {

        private static final ServiceOptions defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List uninterpretedOption_;

        public static ServiceOptions getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
        }

        private void initFields()
        {
            uninterpretedOption_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(ServiceOptions serviceoptions)
        {
            return newBuilder().mergeFrom(serviceoptions);
        }

        public ServiceOptions getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            int j = 0;
            for (; i < uninterpretedOption_.size(); i++)
            {
                j += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
            }

            i = extensionsSerializedSize() + j + getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            return (UninterpretedOption)uninterpretedOption_.get(i);
        }

        public int getUninterpretedOptionCount()
        {
            return uninterpretedOption_.size();
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++)
            {
                if (!getUninterpretedOption(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (!extensionsAreInitialized())
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
            return new Builder(builderparent);
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
            GeneratedMessage.ExtendableMessage.ExtensionWriter extensionwriter = newExtensionWriter();
            for (int i = 0; i < uninterpretedOption_.size(); i++)
            {
                codedoutputstream.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
            }

            extensionwriter.writeUntil(0x20000000, codedoutputstream);
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new ServiceOptions(true);
            defaultInstance.initFields();
        }



/*
        static List access$16002(ServiceOptions serviceoptions, List list)
        {
            serviceoptions.uninterpretedOption_ = list;
            return list;
        }

*/

        private ServiceOptions(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private ServiceOptions(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class ServiceOptions.Builder extends GeneratedMessage.ExtendableBuilder
        implements ServiceOptionsOrBuilder
    {

        private int bitField0_;
        private RepeatedFieldBuilder uninterpretedOptionBuilder_;
        private List uninterpretedOption_;

        private static ServiceOptions.Builder create()
        {
            return new ServiceOptions.Builder();
        }

        private void ensureUninterpretedOptionIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                uninterpretedOption_ = new ArrayList(uninterpretedOption_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder()
        {
            boolean flag = true;
            if (uninterpretedOptionBuilder_ == null)
            {
                List list = uninterpretedOption_;
                if ((bitField0_ & 1) != 1)
                {
                    flag = false;
                }
                uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                uninterpretedOption_ = null;
            }
            return uninterpretedOptionBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getUninterpretedOptionFieldBuilder();
            }
        }

        public ServiceOptions.Builder addUninterpretedOption(UninterpretedOption uninterpretedoption)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                if (uninterpretedoption == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.add(uninterpretedoption);
                    onChanged();
                    return this;
                }
            } else
            {
                uninterpretedOptionBuilder_.addMessage(uninterpretedoption);
                return this;
            }
        }

        public ServiceOptions build()
        {
            ServiceOptions serviceoptions = buildPartial();
            if (!serviceoptions.isInitialized())
            {
                throw newUninitializedMessageException(serviceoptions);
            } else
            {
                return serviceoptions;
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

        public ServiceOptions buildPartial()
        {
            ServiceOptions serviceoptions = new ServiceOptions(this);
            int i = bitField0_;
            if (uninterpretedOptionBuilder_ == null)
            {
                if ((bitField0_ & 1) == 1)
                {
                    uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
                    bitField0_ = bitField0_ & -2;
                }
                serviceoptions.uninterpretedOption_ = uninterpretedOption_;
            } else
            {
                serviceoptions.uninterpretedOption_ = uninterpretedOptionBuilder_.build();
            }
            onBuilt();
            return serviceoptions;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public ServiceOptions.Builder clear()
        {
            super.clear();
            if (uninterpretedOptionBuilder_ == null)
            {
                uninterpretedOption_ = Collections.emptyList();
                bitField0_ = bitField0_ & -2;
                return this;
            } else
            {
                uninterpretedOptionBuilder_.clear();
                return this;
            }
        }

        public volatile GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile GeneratedMessage.ExtendableBuilder clear()
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

        public ServiceOptions.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile GeneratedMessage.Builder clone()
        {
            return clone();
        }

        public volatile GeneratedMessage.ExtendableBuilder clone()
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

        public ServiceOptions getDefaultInstanceForType()
        {
            return ServiceOptions.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return ServiceOptions.getDescriptor();
        }

        public UninterpretedOption getUninterpretedOption(int i)
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return (UninterpretedOption)uninterpretedOption_.get(i);
            } else
            {
                return (UninterpretedOption)uninterpretedOptionBuilder_.getMessage(i);
            }
        }

        public int getUninterpretedOptionCount()
        {
            if (uninterpretedOptionBuilder_ == null)
            {
                return uninterpretedOption_.size();
            } else
            {
                return uninterpretedOptionBuilder_.getCount();
            }
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L7:
            if (i >= getUninterpretedOptionCount()) goto _L2; else goto _L1
_L1:
            if (getUninterpretedOption(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (!extensionsAreInitialized()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
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

        public ServiceOptions.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

                case 7994: 
                    UninterpretedOption.Builder builder1 = UninterpretedOption.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addUninterpretedOption(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public ServiceOptions.Builder mergeFrom(ServiceOptions serviceoptions)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (serviceoptions == ServiceOptions.getDefaultInstance())
            {
                return this;
            }
            if (uninterpretedOptionBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!serviceoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOption_.isEmpty())
                {
                    uninterpretedOption_ = serviceoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensureUninterpretedOptionIsMutable();
                    uninterpretedOption_.addAll(serviceoptions.uninterpretedOption_);
                }
                onChanged();
            }
_L4:
            mergeExtensionFields(serviceoptions);
            mergeUnknownFields(serviceoptions.getUnknownFields());
            return this;
_L2:
            if (!serviceoptions.uninterpretedOption_.isEmpty())
            {
                if (uninterpretedOptionBuilder_.isEmpty())
                {
                    uninterpretedOptionBuilder_.dispose();
                    uninterpretedOptionBuilder_ = null;
                    uninterpretedOption_ = serviceoptions.uninterpretedOption_;
                    bitField0_ = bitField0_ & -2;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getUninterpretedOptionFieldBuilder();
                    }
                    uninterpretedOptionBuilder_ = repeatedfieldbuilder;
                } else
                {
                    uninterpretedOptionBuilder_.addAllMessages(serviceoptions.uninterpretedOption_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public ServiceOptions.Builder mergeFrom(Message message)
        {
            if (message instanceof ServiceOptions)
            {
                return mergeFrom((ServiceOptions)message);
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


        private ServiceOptions.Builder()
        {
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private ServiceOptions.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            uninterpretedOption_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

    }

    public static interface ServiceOptionsOrBuilder
        extends GeneratedMessage.ExtendableMessageOrBuilder
    {
    }

    public static final class SourceCodeInfo extends GeneratedMessage
        implements SourceCodeInfoOrBuilder
    {

        private static final SourceCodeInfo defaultInstance;
        private List location_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        public static SourceCodeInfo getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor;
        }

        private void initFields()
        {
            location_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(SourceCodeInfo sourcecodeinfo)
        {
            return newBuilder().mergeFrom(sourcecodeinfo);
        }

        public SourceCodeInfo getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            int j = 0;
            for (; i < location_.size(); i++)
            {
                j += CodedOutputStream.computeMessageSize(1, (MessageLite)location_.get(i));
            }

            i = getUnknownFields().getSerializedSize() + j;
            memoizedSerializedSize = i;
            return i;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
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
            return new Builder(builderparent);
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
            for (int i = 0; i < location_.size(); i++)
            {
                codedoutputstream.writeMessage(1, (MessageLite)location_.get(i));
            }

            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new SourceCodeInfo(true);
            defaultInstance.initFields();
        }



/*
        static List access$20502(SourceCodeInfo sourcecodeinfo, List list)
        {
            sourcecodeinfo.location_ = list;
            return list;
        }

*/

        private SourceCodeInfo(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private SourceCodeInfo(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class SourceCodeInfo.Builder extends GeneratedMessage.Builder
        implements SourceCodeInfoOrBuilder
    {

        private int bitField0_;
        private RepeatedFieldBuilder locationBuilder_;
        private List location_;

        private static SourceCodeInfo.Builder create()
        {
            return new SourceCodeInfo.Builder();
        }

        private void ensureLocationIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                location_ = new ArrayList(location_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private RepeatedFieldBuilder getLocationFieldBuilder()
        {
            boolean flag = true;
            if (locationBuilder_ == null)
            {
                List list = location_;
                if ((bitField0_ & 1) != 1)
                {
                    flag = false;
                }
                locationBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                location_ = null;
            }
            return locationBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (GeneratedMessage.alwaysUseFieldBuilders)
            {
                getLocationFieldBuilder();
            }
        }

        public SourceCodeInfo.Builder addLocation(SourceCodeInfo.Location location)
        {
            if (locationBuilder_ == null)
            {
                if (location == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureLocationIsMutable();
                    location_.add(location);
                    onChanged();
                    return this;
                }
            } else
            {
                locationBuilder_.addMessage(location);
                return this;
            }
        }

        public SourceCodeInfo build()
        {
            SourceCodeInfo sourcecodeinfo = buildPartial();
            if (!sourcecodeinfo.isInitialized())
            {
                throw newUninitializedMessageException(sourcecodeinfo);
            } else
            {
                return sourcecodeinfo;
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

        public SourceCodeInfo buildPartial()
        {
            SourceCodeInfo sourcecodeinfo = new SourceCodeInfo(this);
            int i = bitField0_;
            if (locationBuilder_ == null)
            {
                if ((bitField0_ & 1) == 1)
                {
                    location_ = Collections.unmodifiableList(location_);
                    bitField0_ = bitField0_ & -2;
                }
                sourcecodeinfo.location_ = location_;
            } else
            {
                sourcecodeinfo.location_ = locationBuilder_.build();
            }
            onBuilt();
            return sourcecodeinfo;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public SourceCodeInfo.Builder clear()
        {
            super.clear();
            if (locationBuilder_ == null)
            {
                location_ = Collections.emptyList();
                bitField0_ = bitField0_ & -2;
                return this;
            } else
            {
                locationBuilder_.clear();
                return this;
            }
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

        public SourceCodeInfo.Builder clone()
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

        public SourceCodeInfo getDefaultInstanceForType()
        {
            return SourceCodeInfo.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return SourceCodeInfo.getDescriptor();
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
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

        public SourceCodeInfo.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
                    SourceCodeInfo.Location.Builder builder1 = SourceCodeInfo.Location.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addLocation(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public SourceCodeInfo.Builder mergeFrom(SourceCodeInfo sourcecodeinfo)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (sourcecodeinfo == SourceCodeInfo.getDefaultInstance())
            {
                return this;
            }
            if (locationBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!sourcecodeinfo.location_.isEmpty())
            {
                if (location_.isEmpty())
                {
                    location_ = sourcecodeinfo.location_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensureLocationIsMutable();
                    location_.addAll(sourcecodeinfo.location_);
                }
                onChanged();
            }
_L4:
            mergeUnknownFields(sourcecodeinfo.getUnknownFields());
            return this;
_L2:
            if (!sourcecodeinfo.location_.isEmpty())
            {
                if (locationBuilder_.isEmpty())
                {
                    locationBuilder_.dispose();
                    locationBuilder_ = null;
                    location_ = sourcecodeinfo.location_;
                    bitField0_ = bitField0_ & -2;
                    if (GeneratedMessage.alwaysUseFieldBuilders)
                    {
                        repeatedfieldbuilder = getLocationFieldBuilder();
                    }
                    locationBuilder_ = repeatedfieldbuilder;
                } else
                {
                    locationBuilder_.addAllMessages(sourcecodeinfo.location_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public SourceCodeInfo.Builder mergeFrom(Message message)
        {
            if (message instanceof SourceCodeInfo)
            {
                return mergeFrom((SourceCodeInfo)message);
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


        private SourceCodeInfo.Builder()
        {
            location_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private SourceCodeInfo.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            location_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

    }

    public static final class SourceCodeInfo.Location extends GeneratedMessage
        implements SourceCodeInfo.LocationOrBuilder
    {

        private static final SourceCodeInfo.Location defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int pathMemoizedSerializedSize;
        private List path_;
        private int spanMemoizedSerializedSize;
        private List span_;

        public static SourceCodeInfo.Location getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_descriptor;
        }

        private void initFields()
        {
            path_ = Collections.emptyList();
            span_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(SourceCodeInfo.Location location)
        {
            return newBuilder().mergeFrom(location);
        }

        public SourceCodeInfo.Location getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public List getPathList()
        {
            return path_;
        }

        public int getSerializedSize()
        {
            int k = 0;
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            int j = 0;
            for (; i < path_.size(); i++)
            {
                j += CodedOutputStream.computeInt32SizeNoTag(((Integer)path_.get(i)).intValue());
            }

            i = 0 + j;
            if (!getPathList().isEmpty())
            {
                i = i + 1 + CodedOutputStream.computeInt32SizeNoTag(j);
            }
            pathMemoizedSerializedSize = j;
            int l;
            for (j = 0; k < span_.size(); j = l + j)
            {
                l = CodedOutputStream.computeInt32SizeNoTag(((Integer)span_.get(k)).intValue());
                k++;
            }

            k = i + j;
            i = k;
            if (!getSpanList().isEmpty())
            {
                i = k + 1 + CodedOutputStream.computeInt32SizeNoTag(j);
            }
            spanMemoizedSerializedSize = j;
            i += getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public List getSpanList()
        {
            return span_;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
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
            return new Builder(builderparent);
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
            boolean flag = false;
            getSerializedSize();
            if (getPathList().size() > 0)
            {
                codedoutputstream.writeRawVarint32(10);
                codedoutputstream.writeRawVarint32(pathMemoizedSerializedSize);
            }
            for (int i = 0; i < path_.size(); i++)
            {
                codedoutputstream.writeInt32NoTag(((Integer)path_.get(i)).intValue());
            }

            int j = ((flag) ? 1 : 0);
            if (getSpanList().size() > 0)
            {
                codedoutputstream.writeRawVarint32(18);
                codedoutputstream.writeRawVarint32(spanMemoizedSerializedSize);
                j = ((flag) ? 1 : 0);
            }
            for (; j < span_.size(); j++)
            {
                codedoutputstream.writeInt32NoTag(((Integer)span_.get(j)).intValue());
            }

            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new SourceCodeInfo.Location(true);
            defaultInstance.initFields();
        }



/*
        static List access$19902(SourceCodeInfo.Location location, List list)
        {
            location.path_ = list;
            return list;
        }

*/



/*
        static List access$20002(SourceCodeInfo.Location location, List list)
        {
            location.span_ = list;
            return list;
        }

*/

        private SourceCodeInfo.Location(Builder builder)
        {
            super(builder);
            pathMemoizedSerializedSize = -1;
            spanMemoizedSerializedSize = -1;
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private SourceCodeInfo.Location(boolean flag)
        {
            pathMemoizedSerializedSize = -1;
            spanMemoizedSerializedSize = -1;
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class SourceCodeInfo.Location.Builder extends GeneratedMessage.Builder
        implements SourceCodeInfo.LocationOrBuilder
    {

        private int bitField0_;
        private List path_;
        private List span_;

        private static SourceCodeInfo.Location.Builder create()
        {
            return new SourceCodeInfo.Location.Builder();
        }

        private void ensurePathIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                path_ = new ArrayList(path_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private void ensureSpanIsMutable()
        {
            if ((bitField0_ & 2) != 2)
            {
                span_ = new ArrayList(span_);
                bitField0_ = bitField0_ | 2;
            }
        }

        private void maybeForceBuilderInitialization()
        {
            if (!GeneratedMessage.alwaysUseFieldBuilders);
        }

        public SourceCodeInfo.Location.Builder addPath(int i)
        {
            ensurePathIsMutable();
            path_.add(Integer.valueOf(i));
            onChanged();
            return this;
        }

        public SourceCodeInfo.Location.Builder addSpan(int i)
        {
            ensureSpanIsMutable();
            span_.add(Integer.valueOf(i));
            onChanged();
            return this;
        }

        public SourceCodeInfo.Location build()
        {
            SourceCodeInfo.Location location = buildPartial();
            if (!location.isInitialized())
            {
                throw newUninitializedMessageException(location);
            } else
            {
                return location;
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

        public SourceCodeInfo.Location buildPartial()
        {
            SourceCodeInfo.Location location = new SourceCodeInfo.Location(this);
            int i = bitField0_;
            if ((bitField0_ & 1) == 1)
            {
                path_ = Collections.unmodifiableList(path_);
                bitField0_ = bitField0_ & -2;
            }
            location.path_ = path_;
            if ((bitField0_ & 2) == 2)
            {
                span_ = Collections.unmodifiableList(span_);
                bitField0_ = bitField0_ & -3;
            }
            location.span_ = span_;
            onBuilt();
            return location;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public volatile AbstractMessage.Builder clear()
        {
            return clear();
        }

        public SourceCodeInfo.Location.Builder clear()
        {
            super.clear();
            path_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            span_ = Collections.emptyList();
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

        public SourceCodeInfo.Location.Builder clone()
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

        public SourceCodeInfo.Location getDefaultInstanceForType()
        {
            return SourceCodeInfo.Location.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return SourceCodeInfo.Location.getDescriptor();
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_fieldAccessorTable;
        }

        public final boolean isInitialized()
        {
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

        public SourceCodeInfo.Location.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

                case 8: // '\b'
                    ensurePathIsMutable();
                    path_.add(Integer.valueOf(codedinputstream.readInt32()));
                    break;

                case 10: // '\n'
                    int j = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
                    for (; codedinputstream.getBytesUntilLimit() > 0; addPath(codedinputstream.readInt32())) { }
                    codedinputstream.popLimit(j);
                    break;

                case 16: // '\020'
                    ensureSpanIsMutable();
                    span_.add(Integer.valueOf(codedinputstream.readInt32()));
                    break;

                case 18: // '\022'
                    int k = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
                    for (; codedinputstream.getBytesUntilLimit() > 0; addSpan(codedinputstream.readInt32())) { }
                    codedinputstream.popLimit(k);
                    break;
                }
            } while (true);
        }

        public SourceCodeInfo.Location.Builder mergeFrom(SourceCodeInfo.Location location)
        {
            if (location == SourceCodeInfo.Location.getDefaultInstance())
            {
                return this;
            }
            if (!location.path_.isEmpty())
            {
                if (path_.isEmpty())
                {
                    path_ = location.path_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensurePathIsMutable();
                    path_.addAll(location.path_);
                }
                onChanged();
            }
            if (!location.span_.isEmpty())
            {
                if (span_.isEmpty())
                {
                    span_ = location.span_;
                    bitField0_ = bitField0_ & -3;
                } else
                {
                    ensureSpanIsMutable();
                    span_.addAll(location.span_);
                }
                onChanged();
            }
            mergeUnknownFields(location.getUnknownFields());
            return this;
        }

        public SourceCodeInfo.Location.Builder mergeFrom(Message message)
        {
            if (message instanceof SourceCodeInfo.Location)
            {
                return mergeFrom((SourceCodeInfo.Location)message);
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


        private SourceCodeInfo.Location.Builder()
        {
            path_ = Collections.emptyList();
            span_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private SourceCodeInfo.Location.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            path_ = Collections.emptyList();
            span_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

    }

    public static interface SourceCodeInfo.LocationOrBuilder
        extends MessageOrBuilder
    {
    }

    public static interface SourceCodeInfoOrBuilder
        extends MessageOrBuilder
    {
    }

    public static final class UninterpretedOption extends GeneratedMessage
        implements UninterpretedOptionOrBuilder
    {

        private static final UninterpretedOption defaultInstance;
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

        public static UninterpretedOption getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
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

        public static Builder newBuilder(UninterpretedOption uninterpretedoption)
        {
            return newBuilder().mergeFrom(uninterpretedoption);
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

        public UninterpretedOption getDefaultInstanceForType()
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

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable;
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

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent builderparent)
        {
            return new Builder(builderparent);
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
            defaultInstance = new UninterpretedOption(true);
            defaultInstance.initFields();
        }



/*
        static List access$18302(UninterpretedOption uninterpretedoption, List list)
        {
            uninterpretedoption.name_ = list;
            return list;
        }

*/


/*
        static Object access$18402(UninterpretedOption uninterpretedoption, Object obj)
        {
            uninterpretedoption.identifierValue_ = obj;
            return obj;
        }

*/


/*
        static long access$18502(UninterpretedOption uninterpretedoption, long l)
        {
            uninterpretedoption.positiveIntValue_ = l;
            return l;
        }

*/


/*
        static long access$18602(UninterpretedOption uninterpretedoption, long l)
        {
            uninterpretedoption.negativeIntValue_ = l;
            return l;
        }

*/


/*
        static double access$18702(UninterpretedOption uninterpretedoption, double d)
        {
            uninterpretedoption.doubleValue_ = d;
            return d;
        }

*/


/*
        static ByteString access$18802(UninterpretedOption uninterpretedoption, ByteString bytestring)
        {
            uninterpretedoption.stringValue_ = bytestring;
            return bytestring;
        }

*/


/*
        static Object access$18902(UninterpretedOption uninterpretedoption, Object obj)
        {
            uninterpretedoption.aggregateValue_ = obj;
            return obj;
        }

*/


/*
        static int access$19002(UninterpretedOption uninterpretedoption, int i)
        {
            uninterpretedoption.bitField0_ = i;
            return i;
        }

*/

        private UninterpretedOption(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private UninterpretedOption(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class UninterpretedOption.Builder extends GeneratedMessage.Builder
        implements UninterpretedOptionOrBuilder
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

        private static UninterpretedOption.Builder create()
        {
            return new UninterpretedOption.Builder();
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

        public UninterpretedOption.Builder addName(UninterpretedOption.NamePart namepart)
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

        public UninterpretedOption build()
        {
            UninterpretedOption uninterpretedoption = buildPartial();
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

        public UninterpretedOption buildPartial()
        {
            int j = 1;
            UninterpretedOption uninterpretedoption = new UninterpretedOption(this);
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

        public UninterpretedOption.Builder clear()
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

        public UninterpretedOption.Builder clone()
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

        public UninterpretedOption getDefaultInstanceForType()
        {
            return UninterpretedOption.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return UninterpretedOption.getDescriptor();
        }

        public UninterpretedOption.NamePart getName(int i)
        {
            if (nameBuilder_ == null)
            {
                return (UninterpretedOption.NamePart)name_.get(i);
            } else
            {
                return (UninterpretedOption.NamePart)nameBuilder_.getMessage(i);
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
            return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable;
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

        public UninterpretedOption.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
                    UninterpretedOption.NamePart.Builder builder1 = UninterpretedOption.NamePart.newBuilder();
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

        public UninterpretedOption.Builder mergeFrom(UninterpretedOption uninterpretedoption)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (uninterpretedoption == UninterpretedOption.getDefaultInstance())
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

        public UninterpretedOption.Builder mergeFrom(Message message)
        {
            if (message instanceof UninterpretedOption)
            {
                return mergeFrom((UninterpretedOption)message);
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

        public UninterpretedOption.Builder setAggregateValue(String s)
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

        public UninterpretedOption.Builder setDoubleValue(double d)
        {
            bitField0_ = bitField0_ | 0x10;
            doubleValue_ = d;
            onChanged();
            return this;
        }

        public UninterpretedOption.Builder setIdentifierValue(String s)
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

        public UninterpretedOption.Builder setNegativeIntValue(long l)
        {
            bitField0_ = bitField0_ | 8;
            negativeIntValue_ = l;
            onChanged();
            return this;
        }

        public UninterpretedOption.Builder setPositiveIntValue(long l)
        {
            bitField0_ = bitField0_ | 4;
            positiveIntValue_ = l;
            onChanged();
            return this;
        }

        public UninterpretedOption.Builder setStringValue(ByteString bytestring)
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


        private UninterpretedOption.Builder()
        {
            name_ = Collections.emptyList();
            identifierValue_ = "";
            stringValue_ = ByteString.EMPTY;
            aggregateValue_ = "";
            maybeForceBuilderInitialization();
        }

        private UninterpretedOption.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = Collections.emptyList();
            identifierValue_ = "";
            stringValue_ = ByteString.EMPTY;
            aggregateValue_ = "";
            maybeForceBuilderInitialization();
        }

    }

    public static final class UninterpretedOption.NamePart extends GeneratedMessage
        implements UninterpretedOption.NamePartOrBuilder
    {

        private static final UninterpretedOption.NamePart defaultInstance;
        private int bitField0_;
        private boolean isExtension_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object namePart_;

        public static UninterpretedOption.NamePart getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor;
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

        public static Builder newBuilder(UninterpretedOption.NamePart namepart)
        {
            return newBuilder().mergeFrom(namepart);
        }

        public UninterpretedOption.NamePart getDefaultInstanceForType()
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
            return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable;
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
            return new Builder(builderparent);
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
            defaultInstance = new UninterpretedOption.NamePart(true);
            defaultInstance.initFields();
        }


/*
        static Object access$17602(UninterpretedOption.NamePart namepart, Object obj)
        {
            namepart.namePart_ = obj;
            return obj;
        }

*/


/*
        static boolean access$17702(UninterpretedOption.NamePart namepart, boolean flag)
        {
            namepart.isExtension_ = flag;
            return flag;
        }

*/


/*
        static int access$17802(UninterpretedOption.NamePart namepart, int i)
        {
            namepart.bitField0_ = i;
            return i;
        }

*/

        private UninterpretedOption.NamePart(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private UninterpretedOption.NamePart(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class UninterpretedOption.NamePart.Builder extends GeneratedMessage.Builder
        implements UninterpretedOption.NamePartOrBuilder
    {

        private int bitField0_;
        private boolean isExtension_;
        private Object namePart_;

        private static UninterpretedOption.NamePart.Builder create()
        {
            return new UninterpretedOption.NamePart.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
            if (!GeneratedMessage.alwaysUseFieldBuilders);
        }

        public UninterpretedOption.NamePart build()
        {
            UninterpretedOption.NamePart namepart = buildPartial();
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

        public UninterpretedOption.NamePart buildPartial()
        {
            int i = 1;
            UninterpretedOption.NamePart namepart = new UninterpretedOption.NamePart(this);
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

        public UninterpretedOption.NamePart.Builder clear()
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

        public UninterpretedOption.NamePart.Builder clone()
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

        public UninterpretedOption.NamePart getDefaultInstanceForType()
        {
            return UninterpretedOption.NamePart.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return UninterpretedOption.NamePart.getDescriptor();
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
            return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable;
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

        public UninterpretedOption.NamePart.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

        public UninterpretedOption.NamePart.Builder mergeFrom(UninterpretedOption.NamePart namepart)
        {
            if (namepart == UninterpretedOption.NamePart.getDefaultInstance())
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

        public UninterpretedOption.NamePart.Builder mergeFrom(Message message)
        {
            if (message instanceof UninterpretedOption.NamePart)
            {
                return mergeFrom((UninterpretedOption.NamePart)message);
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

        public UninterpretedOption.NamePart.Builder setIsExtension(boolean flag)
        {
            bitField0_ = bitField0_ | 2;
            isExtension_ = flag;
            onChanged();
            return this;
        }

        public UninterpretedOption.NamePart.Builder setNamePart(String s)
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


        private UninterpretedOption.NamePart.Builder()
        {
            namePart_ = "";
            maybeForceBuilderInitialization();
        }

        private UninterpretedOption.NamePart.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            namePart_ = "";
            maybeForceBuilderInitialization();
        }

    }

    public static interface UninterpretedOption.NamePartOrBuilder
        extends MessageOrBuilder
    {
    }

    public static interface UninterpretedOptionOrBuilder
        extends MessageOrBuilder
    {
    }


    private static Descriptors.FileDescriptor descriptor;
    private static Descriptors.Descriptor internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_DescriptorProto_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_DescriptorProto_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_EnumDescriptorProto_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_EnumOptions_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_EnumValueDescriptorProto_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_EnumValueOptions_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_FieldDescriptorProto_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_FieldOptions_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_FileDescriptorProto_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_FileDescriptorSet_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_FileOptions_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FileOptions_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_MessageOptions_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_MessageOptions_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_MethodDescriptorProto_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_MethodOptions_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_ServiceDescriptorProto_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_ServiceOptions_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_ServiceOptions_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_SourceCodeInfo_Location_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_SourceCodeInfo_Location_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_SourceCodeInfo_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_SourceCodeInfo_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_UninterpretedOption_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable;

    private DescriptorProtos()
    {
    }

    public static Descriptors.FileDescriptor getDescriptor()
    {
        return descriptor;
    }

    static 
    {
        Descriptors.FileDescriptor.InternalDescriptorAssigner internaldescriptorassigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {

            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor filedescriptor)
            {
                DescriptorProtos.descriptor = filedescriptor;
                DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(0);
                DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor, new String[] {
                    "File"
                }, com/google/protobuf/DescriptorProtos$FileDescriptorSet, com/google/protobuf/DescriptorProtos$FileDescriptorSet$Builder);
                DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(1);
                DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor, new String[] {
                    "Name", "Package", "Dependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo"
                }, com/google/protobuf/DescriptorProtos$FileDescriptorProto, com/google/protobuf/DescriptorProtos$FileDescriptorProto$Builder);
                DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(2);
                DescriptorProtos.internal_static_google_protobuf_DescriptorProto_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor, new String[] {
                    "Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "Options"
                }, com/google/protobuf/DescriptorProtos$DescriptorProto, com/google/protobuf/DescriptorProtos$DescriptorProto$Builder);
                DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor = (Descriptors.Descriptor)DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor.getNestedTypes().get(0);
                DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor, new String[] {
                    "Start", "End"
                }, com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange, com/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange$Builder);
                DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(3);
                DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor, new String[] {
                    "Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "Options"
                }, com/google/protobuf/DescriptorProtos$FieldDescriptorProto, com/google/protobuf/DescriptorProtos$FieldDescriptorProto$Builder);
                DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(4);
                DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor, new String[] {
                    "Name", "Value", "Options"
                }, com/google/protobuf/DescriptorProtos$EnumDescriptorProto, com/google/protobuf/DescriptorProtos$EnumDescriptorProto$Builder);
                DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(5);
                DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_descriptor, new String[] {
                    "Name", "Number", "Options"
                }, com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto, com/google/protobuf/DescriptorProtos$EnumValueDescriptorProto$Builder);
                DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(6);
                DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_descriptor, new String[] {
                    "Name", "Method", "Options"
                }, com/google/protobuf/DescriptorProtos$ServiceDescriptorProto, com/google/protobuf/DescriptorProtos$ServiceDescriptorProto$Builder);
                DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(7);
                DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor, new String[] {
                    "Name", "InputType", "OutputType", "Options"
                }, com/google/protobuf/DescriptorProtos$MethodDescriptorProto, com/google/protobuf/DescriptorProtos$MethodDescriptorProto$Builder);
                DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(8);
                DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor, new String[] {
                    "JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "OptimizeFor", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "UninterpretedOption"
                }, com/google/protobuf/DescriptorProtos$FileOptions, com/google/protobuf/DescriptorProtos$FileOptions$Builder);
                DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(9);
                DescriptorProtos.internal_static_google_protobuf_MessageOptions_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor, new String[] {
                    "MessageSetWireFormat", "NoStandardDescriptorAccessor", "UninterpretedOption"
                }, com/google/protobuf/DescriptorProtos$MessageOptions, com/google/protobuf/DescriptorProtos$MessageOptions$Builder);
                DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(10);
                DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor, new String[] {
                    "Ctype", "Packed", "Deprecated", "ExperimentalMapKey", "UninterpretedOption"
                }, com/google/protobuf/DescriptorProtos$FieldOptions, com/google/protobuf/DescriptorProtos$FieldOptions$Builder);
                DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(11);
                DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor, new String[] {
                    "UninterpretedOption"
                }, com/google/protobuf/DescriptorProtos$EnumOptions, com/google/protobuf/DescriptorProtos$EnumOptions$Builder);
                DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(12);
                DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor, new String[] {
                    "UninterpretedOption"
                }, com/google/protobuf/DescriptorProtos$EnumValueOptions, com/google/protobuf/DescriptorProtos$EnumValueOptions$Builder);
                DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(13);
                DescriptorProtos.internal_static_google_protobuf_ServiceOptions_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor, new String[] {
                    "UninterpretedOption"
                }, com/google/protobuf/DescriptorProtos$ServiceOptions, com/google/protobuf/DescriptorProtos$ServiceOptions$Builder);
                DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(14);
                DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor, new String[] {
                    "UninterpretedOption"
                }, com/google/protobuf/DescriptorProtos$MethodOptions, com/google/protobuf/DescriptorProtos$MethodOptions$Builder);
                DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(15);
                DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor, new String[] {
                    "Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"
                }, com/google/protobuf/DescriptorProtos$UninterpretedOption, com/google/protobuf/DescriptorProtos$UninterpretedOption$Builder);
                DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor = (Descriptors.Descriptor)DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor.getNestedTypes().get(0);
                DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor, new String[] {
                    "NamePart", "IsExtension"
                }, com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart, com/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart$Builder);
                DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor = (Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(16);
                DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor, new String[] {
                    "Location"
                }, com/google/protobuf/DescriptorProtos$SourceCodeInfo, com/google/protobuf/DescriptorProtos$SourceCodeInfo$Builder);
                DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_descriptor = (Descriptors.Descriptor)DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor.getNestedTypes().get(0);
                DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_descriptor, new String[] {
                    "Path", "Span"
                }, com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location, com/google/protobuf/DescriptorProtos$SourceCodeInfo$Location$Builder);
                return null;
            }

        };
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] {
            "\n google/protobuf/descriptor.proto\022\017google.protobuf\"G\n\021FileDescriptorSet\0222\n\004file\030\001 \003(\0132$.google.protobuf.FileDescriptorProto\"\227\003\n\023FileDescriptorProto\022\f\n\004name\030\001 \001(\t\022\017\n\007package\030\002 \001(\t\022\022\n\ndependency\030\003 \003(\t\0226\n\fmessage_type\030\004 \003(\0132 .google.protobuf.DescriptorProto\0227\n\tenum_type\030\005 \003(\0132$.google.protobuf.EnumDescriptorProto\0228\n\007service\030\006 \003(\0132'.google.protobuf.ServiceDescriptorProto\0228\n\textension\030\007 \003(\0132%.google.p", "rotobuf.FieldDescriptorProto\022-\n\007options\030\b \001(\0132\034.google.protobuf.FileOptions\0229\n\020source_code_info\030\t \001(\0132\037.google.protobuf.SourceCodeInfo\"\251\003\n\017DescriptorProto\022\f\n\004name\030\001 \001(\t\0224\n\005field\030\002 \003(\0132%.google.protobuf.FieldDescriptorProto\0228\n\textension\030\006 \003(\0132%.google.protobuf.FieldDescriptorProto\0225\n\013nested_type\030\003 \003(\0132 .google.protobuf.DescriptorProto\0227\n\tenum_type\030\004 \003(\0132$.google.protobuf.EnumDescriptorProto\022H\n\017exte", "nsion_range\030\005 \003(\0132/.google.protobuf.DescriptorProto.ExtensionRange\0220\n\007options\030\007 \001(\0132\037.google.protobuf.MessageOptions\032,\n\016ExtensionRange\022\r\n\005start\030\001 \001(\005\022\013\n\003end\030\002 \001(\005\"\224\005\n\024FieldDescriptorProto\022\f\n\004name\030\001 \001(\t\022\016\n\006number\030\003 \001(\005\022:\n\005label\030\004 \001(\0162+.google.protobuf.FieldDescriptorProto.Label\0228\n\004type\030\005 \001(\0162*.google.protobuf.FieldDescriptorProto.Type\022\021\n\ttype_name\030\006 \001(\t\022\020\n\bextendee\030\002 \001(\t\022\025\n\rdefault_value\030\007 \001(\t\022.\n\007o", "ptions\030\b \001(\0132\035.google.protobuf.FieldOptions\"\266\002\n\004Type\022\017\n\013TYPE_DOUBLE\020\001\022\016\n\nTYPE_FLOAT\020\002\022\016\n\nTYPE_INT64\020\003\022\017\n\013TYPE_UINT64\020\004\022\016\n\nTYPE_INT32\020\005\022\020\n\fTYPE_FIXED64\020\006\022\020\n\fTYPE_FIXED32\020\007\022\r\n\tTYPE_BOOL\020\b\022\017\n\013TYPE_STRING\020\t\022\016\n\nTYPE_GROUP\020\n\022\020\n\fTYPE_MESSAGE\020\013\022\016\n\nTYPE_BYTES\020\f\022\017\n\013TYPE_UINT32\020\r\022\r\n\tTYPE_ENUM\020\016\022\021\n\rTYPE_SFIXED32\020\017\022\021\n\rTYPE_SFIXED64\020\020\022\017\n\013TYPE_SINT32\020\021\022\017\n\013TYPE_SINT64\020\022\"C\n\005Label\022\022\n\016LABEL_OPTIONAL\020\001\022\022\n\016LABEL_REQUI", "RED\020\002\022\022\n\016LABEL_REPEATED\020\003\"\214\001\n\023EnumDescriptorProto\022\f\n\004name\030\001 \001(\t\0228\n\005value\030\002 \003(\0132).google.protobuf.EnumValueDescriptorProto\022-\n\007options\030\003 \001(\0132\034.google.protobuf.EnumOptions\"l\n\030EnumValueDescriptorProto\022\f\n\004name\030\001 \001(\t\022\016\n\006number\030\002 \001(\005\0222\n\007options\030\003 \001(\0132!.google.protobuf.EnumValueOptions\"\220\001\n\026ServiceDescriptorProto\022\f\n\004name\030\001 \001(\t\0226\n\006method\030\002 \003(\0132&.google.protobuf.MethodDescriptorProto\0220\n\007options\030\003 \001(\0132\037.googl", "e.protobuf.ServiceOptions\"\177\n\025MethodDescriptorProto\022\f\n\004name\030\001 \001(\t\022\022\n\ninput_type\030\002 \001(\t\022\023\n\013output_type\030\003 \001(\t\022/\n\007options\030\004 \001(\0132\036.google.protobuf.MethodOptions\"\325\003\n\013FileOptions\022\024\n\fjava_package\030\001 \001(\t\022\034\n\024java_outer_classname\030\b \001(\t\022\"\n\023java_multiple_files\030\n \001(\b:\005false\022,\n\035java_generate_equals_and_hash\030\024 \001(\b:\005false\022F\n\foptimize_for\030\t \001(\0162).google.protobuf.FileOptions.OptimizeMode:\005SPEED\022\"\n\023cc_generic_services\030", "\020 \001(\b:\005false\022$\n\025java_generic_services\030\021 \001(\b:\005false\022\"\n\023py_generic_services\030\022 \001(\b:\005false\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\022\t\n\005SPEED\020\001\022\r\n\tCODE_SIZE\020\002\022\020\n\fLITE_RUNTIME\020\003*\t\b\350\007\020\200\200\200\200\002\"\270\001\n\016MessageOptions\022&\n\027message_set_wire_format\030\001 \001(\b:\005false\022.\n\037no_standard_descriptor_accessor\030\002 \001(\b:\005false\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOpti", "on*\t\b\350\007\020\200\200\200\200\002\"\224\002\n\fFieldOptions\022:\n\005ctype\030\001 \001(\0162#.google.protobuf.FieldOptions.CType:\006STRING\022\016\n\006packed\030\002 \001(\b\022\031\n\ndeprecated\030\003 \001(\b:\005false\022\034\n\024experimental_map_key\030\t \001(\t\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOption\"/\n\005CType\022\n\n\006STRING\020\000\022\b\n\004CORD\020\001\022\020\n\fSTRING_PIECE\020\002*\t\b\350\007\020\200\200\200\200\002\"]\n\013EnumOptions\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\b\350\007\020\200\200\200\200\002\"b\n\020EnumValue", "Options\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\b\350\007\020\200\200\200\200\002\"`\n\016ServiceOptions\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\b\350\007\020\200\200\200\200\002\"_\n\rMethodOptions\022C\n\024uninterpreted_option\030\347\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\b\350\007\020\200\200\200\200\002\"\236\002\n\023UninterpretedOption\022;\n\004name\030\002 \003(\0132-.google.protobuf.UninterpretedOption.NamePart\022\030\n\020identifier_value\030\003 \001(\t\022\032\n\022pos", "itive_int_value\030\004 \001(\004\022\032\n\022negative_int_value\030\005 \001(\003\022\024\n\fdouble_value\030\006 \001(\001\022\024\n\fstring_value\030\007 \001(\f\022\027\n\017aggregate_value\030\b \001(\t\0323\n\bNamePart\022\021\n\tname_part\030\001 \002(\t\022\024\n\fis_extension\030\002 \002(\b\"|\n\016SourceCodeInfo\022:\n\blocation\030\001 \003(\0132(.google.protobuf.SourceCodeInfo.Location\032.\n\bLocation\022\020\n\004path\030\001 \003(\005B\002\020\001\022\020\n\004span\030\002 \003(\005B\002\020\001B)\n\023com.google.protobufB\020DescriptorProtosH\001"
        }, new Descriptors.FileDescriptor[0], internaldescriptorassigner);
    }



/*
    static Descriptors.Descriptor access$002(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_FileDescriptorSet_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$102(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$10202(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_FileOptions_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$10302(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_FileOptions_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$11802(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_MessageOptions_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$11902(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_MessageOptions_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$12802(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_FieldOptions_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$12902(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_FieldOptions_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$14002(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_EnumOptions_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$14102(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_EnumOptions_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$14702(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_EnumValueOptions_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$14802(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$15402(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_ServiceOptions_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$15502(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_ServiceOptions_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$16102(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_MethodOptions_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$16202(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_MethodOptions_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$16802(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_UninterpretedOption_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$16902(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$17002(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$17102(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$19102(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_SourceCodeInfo_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$19202(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_SourceCodeInfo_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$19302(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_SourceCodeInfo_Location_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$19402(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_SourceCodeInfo_Location_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/


/*
    static Descriptors.FileDescriptor access$20602(Descriptors.FileDescriptor filedescriptor)
    {
        descriptor = filedescriptor;
        return filedescriptor;
    }

*/



/*
    static Descriptors.Descriptor access$2302(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_DescriptorProto_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$2402(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_DescriptorProto_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$2502(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$2602(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$4602(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_FieldDescriptorProto_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$4702(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$6102(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_EnumDescriptorProto_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$6202(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$702(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_FileDescriptorProto_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static Descriptors.Descriptor access$7102(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_EnumValueDescriptorProto_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$7202(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$802(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$8102(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_ServiceDescriptorProto_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$8202(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static Descriptors.Descriptor access$9102(Descriptors.Descriptor descriptor1)
    {
        internal_static_google_protobuf_MethodDescriptorProto_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static GeneratedMessage.FieldAccessorTable access$9202(GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/
}
