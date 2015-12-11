// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessage, DescriptorProtos, ByteString, Internal, 
//            CodedOutputStream, UnknownFieldSet, Message, CodedInputStream, 
//            MessageLite, ExtensionRegistryLite

public static final class memoizedSerializedSize extends GeneratedMessage
    implements rBuilder
{
    public static final class Builder extends GeneratedMessage.Builder
        implements DescriptorProtos.UninterpretedOption.NamePartOrBuilder
    {

        private int bitField0_;
        private boolean isExtension_;
        private Object namePart_;

        private static Builder create()
        {
            return new Builder();
        }

        private void maybeForceBuilderInitialization()
        {
            if (!GeneratedMessage.alwaysUseFieldBuilders);
        }

        public DescriptorProtos.UninterpretedOption.NamePart build()
        {
            DescriptorProtos.UninterpretedOption.NamePart namepart = buildPartial();
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

        public DescriptorProtos.UninterpretedOption.NamePart buildPartial()
        {
            int i = 1;
            DescriptorProtos.UninterpretedOption.NamePart namepart = new DescriptorProtos.UninterpretedOption.NamePart(this, null);
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

        public Builder clear()
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

        public DescriptorProtos.UninterpretedOption.NamePart getDefaultInstanceForType()
        {
            return DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return DescriptorProtos.UninterpretedOption.NamePart.getDescriptor();
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
                    namePart_ = codedinputstream.readBytes();
                    break;

                case 16: // '\020'
                    bitField0_ = bitField0_ | 2;
                    isExtension_ = codedinputstream.readBool();
                    break;
                }
            } while (true);
        }

        public Builder mergeFrom(DescriptorProtos.UninterpretedOption.NamePart namepart)
        {
            if (namepart == DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance())
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

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DescriptorProtos.UninterpretedOption.NamePart)
            {
                return mergeFrom((DescriptorProtos.UninterpretedOption.NamePart)message);
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

        public Builder setIsExtension(boolean flag)
        {
            bitField0_ = bitField0_ | 2;
            isExtension_ = flag;
            onChanged();
            return this;
        }

        public Builder setNamePart(String s)
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


        private Builder()
        {
            namePart_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            namePart_ = "";
            maybeForceBuilderInitialization();
        }

        Builder(GeneratedMessage.BuilderParent builderparent, DescriptorProtos._cls1 _pcls1)
        {
            this(builderparent);
        }
    }


    private static final initFields defaultInstance;
    private int bitField0_;
    private boolean isExtension_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private Object namePart_;

    public static Builder.onChanged getDefaultInstance()
    {
        return defaultInstance;
    }

    public static final defaultInstance getDescriptor()
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

    protected bitField0_ internalGetFieldAccessorTable()
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
    }


/*
    static Object access$17602(Builder builder, Object obj)
    {
        builder.namePart_ = obj;
        return obj;
    }

*/


/*
    static boolean access$17702(namePart_ namepart_, boolean flag)
    {
        namepart_.isExtension_ = flag;
        return flag;
    }

*/


/*
    static int access$17802(isExtension_ isextension_, int i)
    {
        isextension_.bitField0_ = i;
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
