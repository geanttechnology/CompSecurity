// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage, DescriptorProtos, ByteString, Internal, 
//            CodedOutputStream, UnknownFieldSet, Message, SingleFieldBuilder, 
//            CodedInputStream, MessageLite, ExtensionRegistryLite

public static final class memoizedSerializedSize extends GeneratedMessage
    implements rBuilder
{
    public static final class Builder extends GeneratedMessage.Builder
        implements DescriptorProtos.EnumValueDescriptorProtoOrBuilder
    {

        private int bitField0_;
        private Object name_;
        private int number_;
        private SingleFieldBuilder optionsBuilder_;
        private DescriptorProtos.EnumValueOptions options_;

        private static Builder create()
        {
            return new Builder();
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

        public DescriptorProtos.EnumValueDescriptorProto build()
        {
            DescriptorProtos.EnumValueDescriptorProto enumvaluedescriptorproto = buildPartial();
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

        public DescriptorProtos.EnumValueDescriptorProto buildPartial()
        {
            int i = 1;
            DescriptorProtos.EnumValueDescriptorProto enumvaluedescriptorproto = new DescriptorProtos.EnumValueDescriptorProto(this, null);
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
                enumvaluedescriptorproto.options_ = (DescriptorProtos.EnumValueOptions)optionsBuilder_.build();
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

        public Builder clear()
        {
            super.clear();
            name_ = "";
            bitField0_ = bitField0_ & -2;
            number_ = 0;
            bitField0_ = bitField0_ & -3;
            if (optionsBuilder_ == null)
            {
                options_ = DescriptorProtos.EnumValueOptions.getDefaultInstance();
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

        public DescriptorProtos.EnumValueDescriptorProto getDefaultInstanceForType()
        {
            return DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return DescriptorProtos.EnumValueDescriptorProto.getDescriptor();
        }

        public DescriptorProtos.EnumValueOptions getOptions()
        {
            if (optionsBuilder_ == null)
            {
                return options_;
            } else
            {
                return (DescriptorProtos.EnumValueOptions)optionsBuilder_.getMessage();
            }
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 4) == 4;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.access$7200();
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

                case 16: // '\020'
                    bitField0_ = bitField0_ | 2;
                    number_ = codedinputstream.readInt32();
                    break;

                case 26: // '\032'
                    DescriptorProtos.EnumValueOptions.Builder builder1 = DescriptorProtos.EnumValueOptions.newBuilder();
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

        public Builder mergeFrom(DescriptorProtos.EnumValueDescriptorProto enumvaluedescriptorproto)
        {
            if (enumvaluedescriptorproto == DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance())
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

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DescriptorProtos.EnumValueDescriptorProto)
            {
                return mergeFrom((DescriptorProtos.EnumValueDescriptorProto)message);
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

        public Builder mergeOptions(DescriptorProtos.EnumValueOptions enumvalueoptions)
        {
            if (optionsBuilder_ == null)
            {
                if ((bitField0_ & 4) == 4 && options_ != DescriptorProtos.EnumValueOptions.getDefaultInstance())
                {
                    options_ = DescriptorProtos.EnumValueOptions.newBuilder(options_).mergeFrom(enumvalueoptions).buildPartial();
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

        public Builder setNumber(int i)
        {
            bitField0_ = bitField0_ | 2;
            number_ = i;
            onChanged();
            return this;
        }

        public Builder setOptions(DescriptorProtos.EnumValueOptions enumvalueoptions)
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


        private Builder()
        {
            name_ = "";
            options_ = DescriptorProtos.EnumValueOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            options_ = DescriptorProtos.EnumValueOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        Builder(GeneratedMessage.BuilderParent builderparent, DescriptorProtos._cls1 _pcls1)
        {
            this(builderparent);
        }
    }


    private static final initFields defaultInstance;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private Object name_;
    private int number_;
    private initFields options_;

    public static Builder.bitField0_ getDefaultInstance()
    {
        return defaultInstance;
    }

    public static final defaultInstance getDescriptor()
    {
        return DescriptorProtos.access$7100();
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
        options_ = ltInstance();
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

    public number_ getOptions()
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

    protected bitField0_ internalGetFieldAccessorTable()
    {
        return DescriptorProtos.access$7200();
    }

    public final boolean isInitialized()
    {
        byte byte0 = memoizedIsInitialized;
        if (byte0 != -1)
        {
            return byte0 == 1;
        }
        if (hasOptions() && !getOptions().lized())
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
    }


/*
    static Object access$7702(Builder builder, Object obj)
    {
        builder.name_ = obj;
        return obj;
    }

*/


/*
    static int access$7802(name_ name_1, int i)
    {
        name_1.number_ = i;
        return i;
    }

*/


/*
    static number_ access$7902(number_ number_1, number_ number_2)
    {
        number_1.options_ = number_2;
        return number_2;
    }

*/


/*
    static int access$8002(options_ options_1, int i)
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
