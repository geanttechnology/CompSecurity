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
//            CodedOutputStream, MessageLite, UnknownFieldSet, Message, 
//            RepeatedFieldBuilder, SingleFieldBuilder, CodedInputStream, ExtensionRegistryLite, 
//            MessageOrBuilder

public static final class memoizedSerializedSize extends GeneratedMessage
    implements rBuilder
{
    public static final class Builder extends GeneratedMessage.Builder
        implements DescriptorProtos.DescriptorProtoOrBuilder
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
        private DescriptorProtos.MessageOptions options_;

        private static Builder create()
        {
            return new Builder();
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

        public Builder addEnumType(DescriptorProtos.EnumDescriptorProto enumdescriptorproto)
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

        public Builder addExtension(DescriptorProtos.FieldDescriptorProto fielddescriptorproto)
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

        public Builder addExtensionRange(ExtensionRange extensionrange)
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

        public Builder addField(DescriptorProtos.FieldDescriptorProto fielddescriptorproto)
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

        public Builder addNestedType(DescriptorProtos.DescriptorProto descriptorproto)
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

        public DescriptorProtos.DescriptorProto build()
        {
            DescriptorProtos.DescriptorProto descriptorproto = buildPartial();
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

        public DescriptorProtos.DescriptorProto buildPartial()
        {
            int i = 1;
            DescriptorProtos.DescriptorProto descriptorproto = new DescriptorProtos.DescriptorProto(this, null);
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
                descriptorproto.options_ = (DescriptorProtos.MessageOptions)optionsBuilder_.build();
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

        public Builder clear()
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
                options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
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

        public DescriptorProtos.DescriptorProto getDefaultInstanceForType()
        {
            return DescriptorProtos.DescriptorProto.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return DescriptorProtos.DescriptorProto.getDescriptor();
        }

        public DescriptorProtos.EnumDescriptorProto getEnumType(int i)
        {
            if (enumTypeBuilder_ == null)
            {
                return (DescriptorProtos.EnumDescriptorProto)enumType_.get(i);
            } else
            {
                return (DescriptorProtos.EnumDescriptorProto)enumTypeBuilder_.getMessage(i);
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

        public DescriptorProtos.FieldDescriptorProto getExtension(int i)
        {
            if (extensionBuilder_ == null)
            {
                return (DescriptorProtos.FieldDescriptorProto)extension_.get(i);
            } else
            {
                return (DescriptorProtos.FieldDescriptorProto)extensionBuilder_.getMessage(i);
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

        public DescriptorProtos.FieldDescriptorProto getField(int i)
        {
            if (fieldBuilder_ == null)
            {
                return (DescriptorProtos.FieldDescriptorProto)field_.get(i);
            } else
            {
                return (DescriptorProtos.FieldDescriptorProto)fieldBuilder_.getMessage(i);
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

        public DescriptorProtos.DescriptorProto getNestedType(int i)
        {
            if (nestedTypeBuilder_ == null)
            {
                return (DescriptorProtos.DescriptorProto)nestedType_.get(i);
            } else
            {
                return (DescriptorProtos.DescriptorProto)nestedTypeBuilder_.getMessage(i);
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

        public DescriptorProtos.MessageOptions getOptions()
        {
            if (optionsBuilder_ == null)
            {
                return options_;
            } else
            {
                return (DescriptorProtos.MessageOptions)optionsBuilder_.getMessage();
            }
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 0x40) == 64;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.access$2400();
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

                case 10: // '\n'
                    bitField0_ = bitField0_ | 1;
                    name_ = codedinputstream.readBytes();
                    break;

                case 18: // '\022'
                    DescriptorProtos.FieldDescriptorProto.Builder builder1 = DescriptorProtos.FieldDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addField(builder1.buildPartial());
                    break;

                case 26: // '\032'
                    Builder builder2 = DescriptorProtos.DescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder2, extensionregistrylite);
                    addNestedType(builder2.buildPartial());
                    break;

                case 34: // '"'
                    DescriptorProtos.EnumDescriptorProto.Builder builder3 = DescriptorProtos.EnumDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder3, extensionregistrylite);
                    addEnumType(builder3.buildPartial());
                    break;

                case 42: // '*'
                    ExtensionRange.Builder builder4 = ExtensionRange.newBuilder();
                    codedinputstream.readMessage(builder4, extensionregistrylite);
                    addExtensionRange(builder4.buildPartial());
                    break;

                case 50: // '2'
                    DescriptorProtos.FieldDescriptorProto.Builder builder5 = DescriptorProtos.FieldDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder5, extensionregistrylite);
                    addExtension(builder5.buildPartial());
                    break;

                case 58: // ':'
                    DescriptorProtos.MessageOptions.Builder builder6 = DescriptorProtos.MessageOptions.newBuilder();
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

        public Builder mergeFrom(DescriptorProtos.DescriptorProto descriptorproto)
        {
            Object obj = null;
            if (descriptorproto == DescriptorProtos.DescriptorProto.getDefaultInstance())
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

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DescriptorProtos.DescriptorProto)
            {
                return mergeFrom((DescriptorProtos.DescriptorProto)message);
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

        public Builder mergeOptions(DescriptorProtos.MessageOptions messageoptions)
        {
            if (optionsBuilder_ == null)
            {
                if ((bitField0_ & 0x40) == 64 && options_ != DescriptorProtos.MessageOptions.getDefaultInstance())
                {
                    options_ = DescriptorProtos.MessageOptions.newBuilder(options_).mergeFrom(messageoptions).buildPartial();
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

        public Builder setName(String s)
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

        public Builder setOptions(DescriptorProtos.MessageOptions messageoptions)
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


        private Builder()
        {
            name_ = "";
            field_ = Collections.emptyList();
            extension_ = Collections.emptyList();
            nestedType_ = Collections.emptyList();
            enumType_ = Collections.emptyList();
            extensionRange_ = Collections.emptyList();
            options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            field_ = Collections.emptyList();
            extension_ = Collections.emptyList();
            nestedType_ = Collections.emptyList();
            enumType_ = Collections.emptyList();
            extensionRange_ = Collections.emptyList();
            options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        Builder(GeneratedMessage.BuilderParent builderparent, DescriptorProtos._cls1 _pcls1)
        {
            this(builderparent);
        }
    }

    public static final class ExtensionRange extends GeneratedMessage
        implements ExtensionRangeOrBuilder
    {

        private static final ExtensionRange defaultInstance;
        private int bitField0_;
        private int end_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int start_;

        public static ExtensionRange getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor()
        {
            return DescriptorProtos.access$2500();
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

        public static Builder newBuilder(ExtensionRange extensionrange)
        {
            return newBuilder().mergeFrom(extensionrange);
        }

        public ExtensionRange getDefaultInstanceForType()
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
            return DescriptorProtos.access$2600();
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
            defaultInstance = new ExtensionRange(true);
            defaultInstance.initFields();
        }


/*
        static int access$3102(ExtensionRange extensionrange, int i)
        {
            extensionrange.start_ = i;
            return i;
        }

*/


/*
        static int access$3202(ExtensionRange extensionrange, int i)
        {
            extensionrange.end_ = i;
            return i;
        }

*/


/*
        static int access$3302(ExtensionRange extensionrange, int i)
        {
            extensionrange.bitField0_ = i;
            return i;
        }

*/

        private ExtensionRange(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }

        ExtensionRange(Builder builder, DescriptorProtos._cls1 _pcls1)
        {
            this(builder);
        }

        private ExtensionRange(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class ExtensionRange.Builder extends GeneratedMessage.Builder
        implements ExtensionRangeOrBuilder
    {

        private int bitField0_;
        private int end_;
        private int start_;

        private static ExtensionRange.Builder create()
        {
            return new ExtensionRange.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
            if (!GeneratedMessage.alwaysUseFieldBuilders);
        }

        public ExtensionRange build()
        {
            ExtensionRange extensionrange = buildPartial();
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

        public ExtensionRange buildPartial()
        {
            int i = 1;
            ExtensionRange extensionrange = new ExtensionRange(this, null);
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

        public ExtensionRange.Builder clear()
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

        public ExtensionRange.Builder clone()
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

        public ExtensionRange getDefaultInstanceForType()
        {
            return ExtensionRange.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return ExtensionRange.getDescriptor();
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.access$2600();
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

        public ExtensionRange.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

        public ExtensionRange.Builder mergeFrom(ExtensionRange extensionrange)
        {
            if (extensionrange == ExtensionRange.getDefaultInstance())
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

        public ExtensionRange.Builder mergeFrom(Message message)
        {
            if (message instanceof ExtensionRange)
            {
                return mergeFrom((ExtensionRange)message);
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

        public ExtensionRange.Builder setEnd(int i)
        {
            bitField0_ = bitField0_ | 2;
            end_ = i;
            onChanged();
            return this;
        }

        public ExtensionRange.Builder setStart(int i)
        {
            bitField0_ = bitField0_ | 1;
            start_ = i;
            onChanged();
            return this;
        }


        private ExtensionRange.Builder()
        {
            maybeForceBuilderInitialization();
        }

        private ExtensionRange.Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            maybeForceBuilderInitialization();
        }

        ExtensionRange.Builder(GeneratedMessage.BuilderParent builderparent, DescriptorProtos._cls1 _pcls1)
        {
            this(builderparent);
        }
    }

    public static interface ExtensionRangeOrBuilder
        extends MessageOrBuilder
    {
    }


    private static final initFields defaultInstance;
    private int bitField0_;
    private List enumType_;
    private List extensionRange_;
    private List extension_;
    private List field_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private Object name_;
    private List nestedType_;
    private initFields options_;

    public static ExtensionRangeOrBuilder getDefaultInstance()
    {
        return defaultInstance;
    }

    public static final defaultInstance getDescriptor()
    {
        return DescriptorProtos.access$2300();
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
        options_ = etDefaultInstance();
    }

    public static Builder newBuilder()
    {
        return Builder.create();
    }

    public static Builder newBuilder(Builder.create create)
    {
        return newBuilder().mergeFrom(create);
    }

    public Builder.mergeFrom getDefaultInstanceForType()
    {
        return defaultInstance;
    }

    public volatile Message getDefaultInstanceForType()
    {
        return getDefaultInstanceForType();
    }

    public oto getEnumType(int i)
    {
        return (oto)enumType_.get(i);
    }

    public int getEnumTypeCount()
    {
        return enumType_.size();
    }

    public roto getExtension(int i)
    {
        return (roto)extension_.get(i);
    }

    public int getExtensionCount()
    {
        return extension_.size();
    }

    public List getExtensionRangeList()
    {
        return extensionRange_;
    }

    public roto getField(int i)
    {
        return (roto)field_.get(i);
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

    public name_ getNestedType(int i)
    {
        return (name_)nestedType_.get(i);
    }

    public int getNestedTypeCount()
    {
        return nestedType_.size();
    }

    public nestedType_ getOptions()
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

    protected le internalGetFieldAccessorTable()
    {
        return DescriptorProtos.access$2400();
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

        if (hasOptions() && !getOptions().sInitialized())
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
    }


/*
    static Object access$3802(Builder builder, Object obj)
    {
        builder.name_ = obj;
        return obj;
    }

*/



/*
    static List access$3902(name_ name_1, List list)
    {
        name_1.field_ = list;
        return list;
    }

*/



/*
    static List access$4002(field_ field_1, List list)
    {
        field_1.extension_ = list;
        return list;
    }

*/



/*
    static List access$4102(extension_ extension_1, List list)
    {
        extension_1.nestedType_ = list;
        return list;
    }

*/



/*
    static List access$4202(nestedType_ nestedtype_, List list)
    {
        nestedtype_.enumType_ = list;
        return list;
    }

*/



/*
    static List access$4302(enumType_ enumtype_, List list)
    {
        enumtype_.extensionRange_ = list;
        return list;
    }

*/


/*
    static extensionRange_ access$4402(extensionRange_ extensionrange_, extensionRange_ extensionrange_1)
    {
        extensionrange_.options_ = extensionrange_1;
        return extensionrange_1;
    }

*/


/*
    static int access$4502(options_ options_1, int i)
    {
        options_1.bitField0_ = i;
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
