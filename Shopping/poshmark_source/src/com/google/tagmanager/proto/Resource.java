// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.proto;

import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

public final class Resource
{
    public static final class ResourceWithMetadata extends GeneratedMessageLite
        implements ResourceWithMetadataOrBuilder
    {

        public static Parser PARSER = new AbstractParser() {

            public ResourceWithMetadata parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new ResourceWithMetadata(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int RESOURCE_FIELD_NUMBER = 2;
        public static final int TIME_STAMP_FIELD_NUMBER = 1;
        private static final ResourceWithMetadata defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private com.google.analytics.containertag.proto.Serving.Resource resource_;
        private long timeStamp_;
        private final ByteString unknownFields;

        public static ResourceWithMetadata getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            timeStamp_ = 0L;
            resource_ = com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(ResourceWithMetadata resourcewithmetadata)
        {
            return newBuilder().mergeFrom(resourcewithmetadata);
        }

        public static ResourceWithMetadata parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (ResourceWithMetadata)PARSER.parseDelimitedFrom(inputstream);
        }

        public static ResourceWithMetadata parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ResourceWithMetadata)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static ResourceWithMetadata parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (ResourceWithMetadata)PARSER.parseFrom(bytestring);
        }

        public static ResourceWithMetadata parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (ResourceWithMetadata)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static ResourceWithMetadata parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (ResourceWithMetadata)PARSER.parseFrom(codedinputstream);
        }

        public static ResourceWithMetadata parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ResourceWithMetadata)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static ResourceWithMetadata parseFrom(InputStream inputstream)
            throws IOException
        {
            return (ResourceWithMetadata)PARSER.parseFrom(inputstream);
        }

        public static ResourceWithMetadata parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ResourceWithMetadata)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static ResourceWithMetadata parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (ResourceWithMetadata)PARSER.parseFrom(abyte0);
        }

        public static ResourceWithMetadata parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (ResourceWithMetadata)PARSER.parseFrom(abyte0, extensionregistrylite);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof ResourceWithMetadata))
            {
                return super.equals(obj);
            }
            obj = (ResourceWithMetadata)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (true && hasTimeStamp() == ((ResourceWithMetadata) (obj)).hasTimeStamp())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasTimeStamp())
            {
                if (flag && getTimeStamp() == ((ResourceWithMetadata) (obj)).getTimeStamp())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasResource() == ((ResourceWithMetadata) (obj)).hasResource())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag3 = flag2;
            if (hasResource())
            {
                if (flag2 && getResource().equals(((ResourceWithMetadata) (obj)).getResource()))
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
            return flag3;
        }

        public ResourceWithMetadata getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public com.google.analytics.containertag.proto.Serving.Resource getResource()
        {
            return resource_;
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
                i = 0 + CodedOutputStream.computeInt64Size(1, timeStamp_);
            }
            int j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeMessageSize(2, resource_);
            }
            i = j + unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public long getTimeStamp()
        {
            return timeStamp_;
        }

        public boolean hasResource()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasTimeStamp()
        {
            return (bitField0_ & 1) == 1;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/tagmanager/proto/Resource$ResourceWithMetadata.hashCode() + 779;
            int i = j;
            if (hasTimeStamp())
            {
                i = (j * 37 + 1) * 53 + Internal.hashLong(getTimeStamp());
            }
            j = i;
            if (hasResource())
            {
                j = (i * 37 + 2) * 53 + getResource().hashCode();
            }
            i = j * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.tagmanager.proto.MutableResource$ResourceWithMetadata");
            }
            return mutableDefault;
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
            if (!hasTimeStamp())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasResource())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!getResource().isInitialized())
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

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder newBuilderForType()
        {
            return newBuilderForType();
        }

        public Builder toBuilder()
        {
            return newBuilder(this);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder toBuilder()
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
                codedoutputstream.writeInt64(1, timeStamp_);
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeMessage(2, resource_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new ResourceWithMetadata(true);
            defaultInstance.initFields();
        }


/*
        static long access$302(ResourceWithMetadata resourcewithmetadata, long l)
        {
            resourcewithmetadata.timeStamp_ = l;
            return l;
        }

*/


/*
        static com.google.analytics.containertag.proto.Serving.Resource access$402(ResourceWithMetadata resourcewithmetadata, com.google.analytics.containertag.proto.Serving.Resource resource)
        {
            resourcewithmetadata.resource_ = resource;
            return resource;
        }

*/


/*
        static int access$502(ResourceWithMetadata resourcewithmetadata, int i)
        {
            resourcewithmetadata.bitField0_ = i;
            return i;
        }

*/


        private ResourceWithMetadata(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            boolean flag;
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            initFields();
            output = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(output);
            flag = false;
_L14:
            if (flag) goto _L2; else goto _L1
_L1:
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 3: default 303
        //                       0: 306
        //                       8: 99
        //                       18: 148;
               goto _L3 _L4 _L5 _L6
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            bitField0_ = bitField0_ | 1;
            timeStamp_ = codedinputstream.readInt64();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L12:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            com.google.analytics.containertag.proto.Serving.Resource.Builder builder = null;
            if ((bitField0_ & 2) == 2)
            {
                builder = resource_.toBuilder();
            }
            resource_ = (com.google.analytics.containertag.proto.Serving.Resource)codedinputstream.readMessage(com.google.analytics.containertag.proto.Serving.Resource.PARSER, extensionregistrylite);
            if (builder == null) goto _L8; else goto _L7
_L7:
            builder.mergeFrom(resource_);
            resource_ = builder.buildPartial();
_L8:
            bitField0_ = bitField0_ | 2;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L10:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L10; else goto _L9
_L9:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L12; else goto _L11
_L11:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L14; else goto _L13
_L13:
        }


        private ResourceWithMetadata(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private ResourceWithMetadata(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class ResourceWithMetadata.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements ResourceWithMetadataOrBuilder
    {

        private int bitField0_;
        private com.google.analytics.containertag.proto.Serving.Resource resource_;
        private long timeStamp_;

        private static ResourceWithMetadata.Builder create()
        {
            return new ResourceWithMetadata.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public ResourceWithMetadata build()
        {
            ResourceWithMetadata resourcewithmetadata = buildPartial();
            if (!resourcewithmetadata.isInitialized())
            {
                throw newUninitializedMessageException(resourcewithmetadata);
            } else
            {
                return resourcewithmetadata;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public ResourceWithMetadata buildPartial()
        {
            ResourceWithMetadata resourcewithmetadata = new ResourceWithMetadata(this);
            int k = bitField0_;
            int i = 0;
            if ((k & 1) == 1)
            {
                i = false | true;
            }
            resourcewithmetadata.timeStamp_ = timeStamp_;
            int j = i;
            if ((k & 2) == 2)
            {
                j = i | 2;
            }
            resourcewithmetadata.resource_ = resource_;
            resourcewithmetadata.bitField0_ = j;
            return resourcewithmetadata;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public ResourceWithMetadata.Builder clear()
        {
            super.clear();
            timeStamp_ = 0L;
            bitField0_ = bitField0_ & -2;
            resource_ = com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance();
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public volatile com.google.tagmanager.protobuf.GeneratedMessageLite.Builder clear()
        {
            return clear();
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder clear()
        {
            return clear();
        }

        public ResourceWithMetadata.Builder clearResource()
        {
            resource_ = com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance();
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public ResourceWithMetadata.Builder clearTimeStamp()
        {
            bitField0_ = bitField0_ & -2;
            timeStamp_ = 0L;
            return this;
        }

        public ResourceWithMetadata.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile com.google.tagmanager.protobuf.AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public volatile com.google.tagmanager.protobuf.GeneratedMessageLite.Builder clone()
        {
            return clone();
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public ResourceWithMetadata getDefaultInstanceForType()
        {
            return ResourceWithMetadata.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public com.google.analytics.containertag.proto.Serving.Resource getResource()
        {
            return resource_;
        }

        public long getTimeStamp()
        {
            return timeStamp_;
        }

        public boolean hasResource()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasTimeStamp()
        {
            return (bitField0_ & 1) == 1;
        }

        public final boolean isInitialized()
        {
            while (!hasTimeStamp() || !hasResource() || !getResource().isInitialized()) 
            {
                return false;
            }
            return true;
        }

        public ResourceWithMetadata.Builder mergeFrom(ResourceWithMetadata resourcewithmetadata)
        {
            if (resourcewithmetadata == ResourceWithMetadata.getDefaultInstance())
            {
                return this;
            }
            if (resourcewithmetadata.hasTimeStamp())
            {
                setTimeStamp(resourcewithmetadata.getTimeStamp());
            }
            if (resourcewithmetadata.hasResource())
            {
                mergeResource(resourcewithmetadata.getResource());
            }
            setUnknownFields(getUnknownFields().concat(resourcewithmetadata.unknownFields));
            return this;
        }

        public ResourceWithMetadata.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (ResourceWithMetadata)ResourceWithMetadata.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((ResourceWithMetadata) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (ResourceWithMetadata)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((ResourceWithMetadata) (codedinputstream1)));
            }
            throw codedinputstream;
        }

        public volatile com.google.tagmanager.protobuf.AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile com.google.tagmanager.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedmessagelite)
        {
            return mergeFrom((ResourceWithMetadata)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public ResourceWithMetadata.Builder mergeResource(com.google.analytics.containertag.proto.Serving.Resource resource)
        {
            if ((bitField0_ & 2) == 2 && resource_ != com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance())
            {
                resource_ = com.google.analytics.containertag.proto.Serving.Resource.newBuilder(resource_).mergeFrom(resource).buildPartial();
            } else
            {
                resource_ = resource;
            }
            bitField0_ = bitField0_ | 2;
            return this;
        }

        public ResourceWithMetadata.Builder setResource(com.google.analytics.containertag.proto.Serving.Resource.Builder builder)
        {
            resource_ = builder.build();
            bitField0_ = bitField0_ | 2;
            return this;
        }

        public ResourceWithMetadata.Builder setResource(com.google.analytics.containertag.proto.Serving.Resource resource)
        {
            if (resource == null)
            {
                throw new NullPointerException();
            } else
            {
                resource_ = resource;
                bitField0_ = bitField0_ | 2;
                return this;
            }
        }

        public ResourceWithMetadata.Builder setTimeStamp(long l)
        {
            bitField0_ = bitField0_ | 1;
            timeStamp_ = l;
            return this;
        }


        private ResourceWithMetadata.Builder()
        {
            resource_ = com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance();
            maybeForceBuilderInitialization();
        }
    }

    public static interface ResourceWithMetadataOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract com.google.analytics.containertag.proto.Serving.Resource getResource();

        public abstract long getTimeStamp();

        public abstract boolean hasResource();

        public abstract boolean hasTimeStamp();
    }


    private Resource()
    {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionregistrylite)
    {
    }

}
