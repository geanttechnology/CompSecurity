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
//            GeneratedMessage, DescriptorProtos, MessageLite, CodedOutputStream, 
//            UnknownFieldSet, Message, RepeatedFieldBuilder, CodedInputStream, 
//            ExtensionRegistryLite

public static final class memoizedSerializedSize extends GeneratedMessage
    implements rBuilder
{
    public static final class Builder extends GeneratedMessage.Builder
        implements DescriptorProtos.FileDescriptorSetOrBuilder
    {

        private int bitField0_;
        private RepeatedFieldBuilder fileBuilder_;
        private List file_;

        private static Builder create()
        {
            return new Builder();
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

        public Builder addFile(DescriptorProtos.FileDescriptorProto filedescriptorproto)
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

        public DescriptorProtos.FileDescriptorSet build()
        {
            DescriptorProtos.FileDescriptorSet filedescriptorset = buildPartial();
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

        public DescriptorProtos.FileDescriptorSet buildPartial()
        {
            DescriptorProtos.FileDescriptorSet filedescriptorset = new DescriptorProtos.FileDescriptorSet(this, null);
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

        public Builder clear()
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

        public DescriptorProtos.FileDescriptorSet getDefaultInstanceForType()
        {
            return DescriptorProtos.FileDescriptorSet.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return DescriptorProtos.FileDescriptorSet.getDescriptor();
        }

        public DescriptorProtos.FileDescriptorProto getFile(int i)
        {
            if (fileBuilder_ == null)
            {
                return (DescriptorProtos.FileDescriptorProto)file_.get(i);
            } else
            {
                return (DescriptorProtos.FileDescriptorProto)fileBuilder_.getMessage(i);
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
            return DescriptorProtos.access$100();
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
                    DescriptorProtos.FileDescriptorProto.Builder builder1 = DescriptorProtos.FileDescriptorProto.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addFile(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public Builder mergeFrom(DescriptorProtos.FileDescriptorSet filedescriptorset)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (filedescriptorset == DescriptorProtos.FileDescriptorSet.getDefaultInstance())
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

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DescriptorProtos.FileDescriptorSet)
            {
                return mergeFrom((DescriptorProtos.FileDescriptorSet)message);
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


        private Builder()
        {
            file_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            file_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        Builder(GeneratedMessage.BuilderParent builderparent, DescriptorProtos._cls1 _pcls1)
        {
            this(builderparent);
        }
    }


    private static final initFields defaultInstance;
    private List file_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;

    public static Builder.mergeFrom getDefaultInstance()
    {
        return defaultInstance;
    }

    public static final defaultInstance getDescriptor()
    {
        return DescriptorProtos.access$000();
    }

    private void initFields()
    {
        file_ = Collections.emptyList();
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

    public o getFile(int i)
    {
        return (o)file_.get(i);
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

    protected  internalGetFieldAccessorTable()
    {
        return DescriptorProtos.access$100();
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
        for (int i = 0; i < file_.size(); i++)
        {
            codedoutputstream.writeMessage(1, (MessageLite)file_.get(i));
        }

        getUnknownFields().writeTo(codedoutputstream);
    }

    static 
    {
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
    }



/*
    static List access$602(Builder builder, List list)
    {
        builder.file_ = list;
        return list;
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
