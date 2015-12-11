// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage, DescriptorProtos, CodedOutputStream, UnknownFieldSet, 
//            Message, CodedInputStream, MessageLite, ExtensionRegistryLite

public static final class memoizedSerializedSize extends GeneratedMessage
    implements rBuilder
{
    public static final class Builder extends GeneratedMessage.Builder
        implements DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
    {

        private int bitField0_;
        private int end_;
        private int start_;

        private static Builder create()
        {
            return new Builder();
        }

        private void maybeForceBuilderInitialization()
        {
            if (!GeneratedMessage.alwaysUseFieldBuilders);
        }

        public DescriptorProtos.DescriptorProto.ExtensionRange build()
        {
            DescriptorProtos.DescriptorProto.ExtensionRange extensionrange = buildPartial();
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

        public DescriptorProtos.DescriptorProto.ExtensionRange buildPartial()
        {
            int i = 1;
            DescriptorProtos.DescriptorProto.ExtensionRange extensionrange = new DescriptorProtos.DescriptorProto.ExtensionRange(this, null);
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

        public Builder clear()
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

        public DescriptorProtos.DescriptorProto.ExtensionRange getDefaultInstanceForType()
        {
            return DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return DescriptorProtos.DescriptorProto.ExtensionRange.getDescriptor();
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

        public Builder mergeFrom(DescriptorProtos.DescriptorProto.ExtensionRange extensionrange)
        {
            if (extensionrange == DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance())
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

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DescriptorProtos.DescriptorProto.ExtensionRange)
            {
                return mergeFrom((DescriptorProtos.DescriptorProto.ExtensionRange)message);
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

        public Builder setEnd(int i)
        {
            bitField0_ = bitField0_ | 2;
            end_ = i;
            onChanged();
            return this;
        }

        public Builder setStart(int i)
        {
            bitField0_ = bitField0_ | 1;
            start_ = i;
            onChanged();
            return this;
        }


        private Builder()
        {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            maybeForceBuilderInitialization();
        }

        Builder(GeneratedMessage.BuilderParent builderparent, DescriptorProtos._cls1 _pcls1)
        {
            this(builderparent);
        }
    }


    private static final initFields defaultInstance;
    private int bitField0_;
    private int end_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int start_;

    public static Builder.onChanged getDefaultInstance()
    {
        return defaultInstance;
    }

    public static final defaultInstance getDescriptor()
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

    protected bitField0_ internalGetFieldAccessorTable()
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
    }


/*
    static int access$3102(Builder builder, int i)
    {
        builder.start_ = i;
        return i;
    }

*/


/*
    static int access$3202(start_ start_1, int i)
    {
        start_1.end_ = i;
        return i;
    }

*/


/*
    static int access$3302(end_ end_1, int i)
    {
        end_1.bitField0_ = i;
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
