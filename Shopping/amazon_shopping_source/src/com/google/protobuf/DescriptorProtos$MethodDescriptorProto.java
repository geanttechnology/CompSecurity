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
        implements DescriptorProtos.MethodDescriptorProtoOrBuilder
    {

        private int bitField0_;
        private Object inputType_;
        private Object name_;
        private SingleFieldBuilder optionsBuilder_;
        private DescriptorProtos.MethodOptions options_;
        private Object outputType_;

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

        public DescriptorProtos.MethodDescriptorProto build()
        {
            DescriptorProtos.MethodDescriptorProto methoddescriptorproto = buildPartial();
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

        public DescriptorProtos.MethodDescriptorProto buildPartial()
        {
            int j = 1;
            DescriptorProtos.MethodDescriptorProto methoddescriptorproto = new DescriptorProtos.MethodDescriptorProto(this, null);
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
                methoddescriptorproto.options_ = (DescriptorProtos.MethodOptions)optionsBuilder_.build();
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

        public Builder clear()
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
                options_ = DescriptorProtos.MethodOptions.getDefaultInstance();
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

        public DescriptorProtos.MethodDescriptorProto getDefaultInstanceForType()
        {
            return DescriptorProtos.MethodDescriptorProto.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return DescriptorProtos.MethodDescriptorProto.getDescriptor();
        }

        public DescriptorProtos.MethodOptions getOptions()
        {
            if (optionsBuilder_ == null)
            {
                return options_;
            } else
            {
                return (DescriptorProtos.MethodOptions)optionsBuilder_.getMessage();
            }
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 8) == 8;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.access$9200();
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

                case 18: // '\022'
                    bitField0_ = bitField0_ | 2;
                    inputType_ = codedinputstream.readBytes();
                    break;

                case 26: // '\032'
                    bitField0_ = bitField0_ | 4;
                    outputType_ = codedinputstream.readBytes();
                    break;

                case 34: // '"'
                    DescriptorProtos.MethodOptions.Builder builder1 = DescriptorProtos.MethodOptions.newBuilder();
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

        public Builder mergeFrom(DescriptorProtos.MethodDescriptorProto methoddescriptorproto)
        {
            if (methoddescriptorproto == DescriptorProtos.MethodDescriptorProto.getDefaultInstance())
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

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DescriptorProtos.MethodDescriptorProto)
            {
                return mergeFrom((DescriptorProtos.MethodDescriptorProto)message);
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

        public Builder mergeOptions(DescriptorProtos.MethodOptions methodoptions)
        {
            if (optionsBuilder_ == null)
            {
                if ((bitField0_ & 8) == 8 && options_ != DescriptorProtos.MethodOptions.getDefaultInstance())
                {
                    options_ = DescriptorProtos.MethodOptions.newBuilder(options_).mergeFrom(methodoptions).buildPartial();
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

        public Builder setInputType(String s)
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

        public Builder setOptions(DescriptorProtos.MethodOptions methodoptions)
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

        public Builder setOutputType(String s)
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


        private Builder()
        {
            name_ = "";
            inputType_ = "";
            outputType_ = "";
            options_ = DescriptorProtos.MethodOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            inputType_ = "";
            outputType_ = "";
            options_ = DescriptorProtos.MethodOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        Builder(GeneratedMessage.BuilderParent builderparent, DescriptorProtos._cls1 _pcls1)
        {
            this(builderparent);
        }
    }


    private static final initFields defaultInstance;
    private int bitField0_;
    private Object inputType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private Object name_;
    private initFields options_;
    private Object outputType_;

    public static Builder.onChanged getDefaultInstance()
    {
        return defaultInstance;
    }

    public static final defaultInstance getDescriptor()
    {
        return DescriptorProtos.access$9100();
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

    public name_ getOptions()
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

    protected bitField0_ internalGetFieldAccessorTable()
    {
        return DescriptorProtos.access$9200();
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
    }


/*
    static Builder access$10002(Builder builder, Builder builder1)
    {
        builder.options_ = builder1;
        return builder1;
    }

*/


/*
    static int access$10102(options_ options_1, int i)
    {
        options_1.bitField0_ = i;
        return i;
    }

*/


/*
    static Object access$9702(bitField0_ bitfield0_, Object obj)
    {
        bitfield0_.name_ = obj;
        return obj;
    }

*/


/*
    static Object access$9802(name_ name_1, Object obj)
    {
        name_1.inputType_ = obj;
        return obj;
    }

*/


/*
    static Object access$9902(inputType_ inputtype_, Object obj)
    {
        inputtype_.outputType_ = obj;
        return obj;
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
