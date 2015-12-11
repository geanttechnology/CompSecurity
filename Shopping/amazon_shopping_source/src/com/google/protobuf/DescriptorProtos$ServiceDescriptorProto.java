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
//            RepeatedFieldBuilder, SingleFieldBuilder, CodedInputStream, ExtensionRegistryLite

public static final class memoizedSerializedSize extends GeneratedMessage
    implements rBuilder
{
    public static final class Builder extends GeneratedMessage.Builder
        implements DescriptorProtos.ServiceDescriptorProtoOrBuilder
    {

        private int bitField0_;
        private RepeatedFieldBuilder methodBuilder_;
        private List method_;
        private Object name_;
        private SingleFieldBuilder optionsBuilder_;
        private DescriptorProtos.ServiceOptions options_;

        private static Builder create()
        {
            return new Builder();
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

        public Builder addMethod(DescriptorProtos.MethodDescriptorProto methoddescriptorproto)
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

        public DescriptorProtos.ServiceDescriptorProto build()
        {
            DescriptorProtos.ServiceDescriptorProto servicedescriptorproto = buildPartial();
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

        public DescriptorProtos.ServiceDescriptorProto buildPartial()
        {
            int i = 1;
            DescriptorProtos.ServiceDescriptorProto servicedescriptorproto = new DescriptorProtos.ServiceDescriptorProto(this, null);
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
                servicedescriptorproto.options_ = (DescriptorProtos.ServiceOptions)optionsBuilder_.build();
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

        public Builder clear()
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
                options_ = DescriptorProtos.ServiceOptions.getDefaultInstance();
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

        public DescriptorProtos.ServiceDescriptorProto getDefaultInstanceForType()
        {
            return DescriptorProtos.ServiceDescriptorProto.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return DescriptorProtos.ServiceDescriptorProto.getDescriptor();
        }

        public DescriptorProtos.MethodDescriptorProto getMethod(int i)
        {
            if (methodBuilder_ == null)
            {
                return (DescriptorProtos.MethodDescriptorProto)method_.get(i);
            } else
            {
                return (DescriptorProtos.MethodDescriptorProto)methodBuilder_.getMessage(i);
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

        public DescriptorProtos.ServiceOptions getOptions()
        {
            if (optionsBuilder_ == null)
            {
                return options_;
            } else
            {
                return (DescriptorProtos.ServiceOptions)optionsBuilder_.getMessage();
            }
        }

        public boolean hasOptions()
        {
            return (bitField0_ & 4) == 4;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.access$8200();
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
                    DescriptorProtos.MethodDescriptorProto.Builder builder1 = DescriptorProtos.MethodDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addMethod(builder1.buildPartial());
                    break;

                case 26: // '\032'
                    DescriptorProtos.ServiceOptions.Builder builder2 = DescriptorProtos.ServiceOptions.newBuilder();
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

        public Builder mergeFrom(DescriptorProtos.ServiceDescriptorProto servicedescriptorproto)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (servicedescriptorproto == DescriptorProtos.ServiceDescriptorProto.getDefaultInstance())
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

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DescriptorProtos.ServiceDescriptorProto)
            {
                return mergeFrom((DescriptorProtos.ServiceDescriptorProto)message);
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

        public Builder mergeOptions(DescriptorProtos.ServiceOptions serviceoptions)
        {
            if (optionsBuilder_ == null)
            {
                if ((bitField0_ & 4) == 4 && options_ != DescriptorProtos.ServiceOptions.getDefaultInstance())
                {
                    options_ = DescriptorProtos.ServiceOptions.newBuilder(options_).mergeFrom(serviceoptions).buildPartial();
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

        public Builder setOptions(DescriptorProtos.ServiceOptions serviceoptions)
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


        private Builder()
        {
            name_ = "";
            method_ = Collections.emptyList();
            options_ = DescriptorProtos.ServiceOptions.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            method_ = Collections.emptyList();
            options_ = DescriptorProtos.ServiceOptions.getDefaultInstance();
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
    private List method_;
    private Object name_;
    private initFields options_;

    public static Builder.bitField0_ getDefaultInstance()
    {
        return defaultInstance;
    }

    public static final defaultInstance getDescriptor()
    {
        return DescriptorProtos.access$8100();
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

    public getDefaultInstanceForType getMethod(int i)
    {
        return (getDefaultInstanceForType)method_.get(i);
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

    public name_ getOptions()
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

    protected bitField0_ internalGetFieldAccessorTable()
    {
        return DescriptorProtos.access$8200();
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
            if (!getMethod(i).sInitialized())
            {
                memoizedIsInitialized = 0;
                return false;
            }
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
    }


/*
    static Object access$8702(Builder builder, Object obj)
    {
        builder.name_ = obj;
        return obj;
    }

*/



/*
    static List access$8802(name_ name_1, List list)
    {
        name_1.method_ = list;
        return list;
    }

*/


/*
    static method_ access$8902(method_ method_1, method_ method_2)
    {
        method_1.options_ = method_2;
        return method_2;
    }

*/


/*
    static int access$9002(options_ options_1, int i)
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
