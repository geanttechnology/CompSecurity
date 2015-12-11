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
//            GeneratedMessage, DescriptorProtos, CodedOutputStream, UnknownFieldSet, 
//            Message, CodedInputStream, MessageLite, ExtensionRegistryLite

public static final class memoizedSerializedSize extends GeneratedMessage
    implements rBuilder
{
    public static final class Builder extends GeneratedMessage.Builder
        implements DescriptorProtos.SourceCodeInfo.LocationOrBuilder
    {

        private int bitField0_;
        private List path_;
        private List span_;

        private static Builder create()
        {
            return new Builder();
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

        public Builder addPath(int i)
        {
            ensurePathIsMutable();
            path_.add(Integer.valueOf(i));
            onChanged();
            return this;
        }

        public Builder addSpan(int i)
        {
            ensureSpanIsMutable();
            span_.add(Integer.valueOf(i));
            onChanged();
            return this;
        }

        public DescriptorProtos.SourceCodeInfo.Location build()
        {
            DescriptorProtos.SourceCodeInfo.Location location = buildPartial();
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

        public DescriptorProtos.SourceCodeInfo.Location buildPartial()
        {
            DescriptorProtos.SourceCodeInfo.Location location = new DescriptorProtos.SourceCodeInfo.Location(this, null);
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

        public Builder clear()
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

        public DescriptorProtos.SourceCodeInfo.Location getDefaultInstanceForType()
        {
            return DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Descriptors.Descriptor getDescriptorForType()
        {
            return DescriptorProtos.SourceCodeInfo.Location.getDescriptor();
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DescriptorProtos.access$19400();
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

        public Builder mergeFrom(DescriptorProtos.SourceCodeInfo.Location location)
        {
            if (location == DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance())
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

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DescriptorProtos.SourceCodeInfo.Location)
            {
                return mergeFrom((DescriptorProtos.SourceCodeInfo.Location)message);
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
            path_ = Collections.emptyList();
            span_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            path_ = Collections.emptyList();
            span_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        Builder(GeneratedMessage.BuilderParent builderparent, DescriptorProtos._cls1 _pcls1)
        {
            this(builderparent);
        }
    }


    private static final initFields defaultInstance;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int pathMemoizedSerializedSize;
    private List path_;
    private int spanMemoizedSerializedSize;
    private List span_;

    public static Builder.mergeFrom getDefaultInstance()
    {
        return defaultInstance;
    }

    public static final defaultInstance getDescriptor()
    {
        return DescriptorProtos.access$19300();
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

    protected span_ internalGetFieldAccessorTable()
    {
        return DescriptorProtos.access$19400();
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
    }



/*
    static List access$19902(Builder builder, List list)
    {
        builder.path_ = list;
        return list;
    }

*/



/*
    static List access$20002(path_ path_1, List list)
    {
        path_1.span_ = list;
        return list;
    }

*/

    private Builder(Builder builder)
    {
        super(builder);
        pathMemoizedSerializedSize = -1;
        spanMemoizedSerializedSize = -1;
        memoizedIsInitialized = -1;
        memoizedSerializedSize = -1;
    }

    Builder(Builder builder, Builder builder1)
    {
        this(builder);
    }

    private Builder(boolean flag)
    {
        pathMemoizedSerializedSize = -1;
        spanMemoizedSerializedSize = -1;
        memoizedIsInitialized = -1;
        memoizedSerializedSize = -1;
    }
}
