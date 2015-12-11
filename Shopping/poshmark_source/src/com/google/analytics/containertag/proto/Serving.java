// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;
import com.google.tagmanager.protobuf.LazyStringArrayList;
import com.google.tagmanager.protobuf.LazyStringList;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import com.google.tagmanager.protobuf.UnmodifiableLazyStringList;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Serving
{
    public static final class CacheOption extends GeneratedMessageLite
        implements CacheOptionOrBuilder
    {

        public static final int EXPIRATION_SECONDS_FIELD_NUMBER = 2;
        public static final int GCACHE_EXPIRATION_SECONDS_FIELD_NUMBER = 3;
        public static final int LEVEL_FIELD_NUMBER = 1;
        public static Parser PARSER = new AbstractParser() {

            public CacheOption parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new CacheOption(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        private static final CacheOption defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private int expirationSeconds_;
        private int gcacheExpirationSeconds_;
        private CacheLevel level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public static CacheOption getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            level_ = CacheLevel.NO_CACHE;
            expirationSeconds_ = 0;
            gcacheExpirationSeconds_ = 0;
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(CacheOption cacheoption)
        {
            return newBuilder().mergeFrom(cacheoption);
        }

        public static CacheOption parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (CacheOption)PARSER.parseDelimitedFrom(inputstream);
        }

        public static CacheOption parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (CacheOption)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static CacheOption parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (CacheOption)PARSER.parseFrom(bytestring);
        }

        public static CacheOption parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (CacheOption)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static CacheOption parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (CacheOption)PARSER.parseFrom(codedinputstream);
        }

        public static CacheOption parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (CacheOption)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static CacheOption parseFrom(InputStream inputstream)
            throws IOException
        {
            return (CacheOption)PARSER.parseFrom(inputstream);
        }

        public static CacheOption parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (CacheOption)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static CacheOption parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (CacheOption)PARSER.parseFrom(abyte0);
        }

        public static CacheOption parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (CacheOption)PARSER.parseFrom(abyte0, extensionregistrylite);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof CacheOption))
            {
                return super.equals(obj);
            }
            obj = (CacheOption)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (true && hasLevel() == ((CacheOption) (obj)).hasLevel())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasLevel())
            {
                if (flag && getLevel() == ((CacheOption) (obj)).getLevel())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasExpirationSeconds() == ((CacheOption) (obj)).hasExpirationSeconds())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasExpirationSeconds())
            {
                if (flag && getExpirationSeconds() == ((CacheOption) (obj)).getExpirationSeconds())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasGcacheExpirationSeconds() == ((CacheOption) (obj)).hasGcacheExpirationSeconds())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag3 = flag2;
            if (hasGcacheExpirationSeconds())
            {
                if (flag2 && getGcacheExpirationSeconds() == ((CacheOption) (obj)).getGcacheExpirationSeconds())
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
            return flag3;
        }

        public CacheOption getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getExpirationSeconds()
        {
            return expirationSeconds_;
        }

        public int getGcacheExpirationSeconds()
        {
            return gcacheExpirationSeconds_;
        }

        public CacheLevel getLevel()
        {
            return level_;
        }

        public Parser getParserForType()
        {
            return PARSER;
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
                j = 0 + CodedOutputStream.computeEnumSize(1, level_.getNumber());
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeInt32Size(2, expirationSeconds_);
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeInt32Size(3, gcacheExpirationSeconds_);
            }
            i = j + unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public boolean hasExpirationSeconds()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasGcacheExpirationSeconds()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasLevel()
        {
            return (bitField0_ & 1) == 1;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Serving$CacheOption.hashCode() + 779;
            int i = j;
            if (hasLevel())
            {
                i = (j * 37 + 1) * 53 + Internal.hashEnum(getLevel());
            }
            j = i;
            if (hasExpirationSeconds())
            {
                j = (i * 37 + 2) * 53 + getExpirationSeconds();
            }
            i = j;
            if (hasGcacheExpirationSeconds())
            {
                i = (j * 37 + 3) * 53 + getGcacheExpirationSeconds();
            }
            i = i * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$CacheOption");
            }
            return mutableDefault;
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
                codedoutputstream.writeEnum(1, level_.getNumber());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeInt32(2, expirationSeconds_);
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeInt32(3, gcacheExpirationSeconds_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new CacheOption(true);
            defaultInstance.initFields();
        }


/*
        static CacheLevel access$5402(CacheOption cacheoption, CacheLevel cachelevel)
        {
            cacheoption.level_ = cachelevel;
            return cachelevel;
        }

*/


/*
        static int access$5502(CacheOption cacheoption, int i)
        {
            cacheoption.expirationSeconds_ = i;
            return i;
        }

*/


/*
        static int access$5602(CacheOption cacheoption, int i)
        {
            cacheoption.gcacheExpirationSeconds_ = i;
            return i;
        }

*/


/*
        static int access$5702(CacheOption cacheoption, int i)
        {
            cacheoption.bitField0_ = i;
            return i;
        }

*/


        private CacheOption(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
_L15:
            if (flag) goto _L2; else goto _L1
_L1:
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 4: default 311
        //                       0: 314
        //                       8: 107
        //                       16: 205
        //                       24: 226;
               goto _L3 _L4 _L5 _L6 _L7
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            CacheLevel cachelevel;
            int j;
            j = codedinputstream.readEnum();
            cachelevel = CacheLevel.valueOf(j);
            if (cachelevel != null) goto _L9; else goto _L8
_L8:
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeRawVarint32(j);
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L13:
            makeExtensionsImmutable();
            throw codedinputstream;
_L9:
            bitField0_ = bitField0_ | 1;
            level_ = cachelevel;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L6:
            bitField0_ = bitField0_ | 2;
            expirationSeconds_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L7:
            bitField0_ = bitField0_ | 4;
            gcacheExpirationSeconds_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L11:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L11; else goto _L10
_L10:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L13; else goto _L12
_L12:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L15; else goto _L14
_L14:
        }


        private CacheOption(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private CacheOption(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class CacheOption.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements CacheOptionOrBuilder
    {

        private int bitField0_;
        private int expirationSeconds_;
        private int gcacheExpirationSeconds_;
        private CacheOption.CacheLevel level_;

        private static CacheOption.Builder create()
        {
            return new CacheOption.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public CacheOption build()
        {
            CacheOption cacheoption = buildPartial();
            if (!cacheoption.isInitialized())
            {
                throw newUninitializedMessageException(cacheoption);
            } else
            {
                return cacheoption;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public CacheOption buildPartial()
        {
            CacheOption cacheoption = new CacheOption(this);
            int k = bitField0_;
            int j = 0;
            if ((k & 1) == 1)
            {
                j = false | true;
            }
            cacheoption.level_ = level_;
            int i = j;
            if ((k & 2) == 2)
            {
                i = j | 2;
            }
            cacheoption.expirationSeconds_ = expirationSeconds_;
            j = i;
            if ((k & 4) == 4)
            {
                j = i | 4;
            }
            cacheoption.gcacheExpirationSeconds_ = gcacheExpirationSeconds_;
            cacheoption.bitField0_ = j;
            return cacheoption;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public CacheOption.Builder clear()
        {
            super.clear();
            level_ = CacheOption.CacheLevel.NO_CACHE;
            bitField0_ = bitField0_ & -2;
            expirationSeconds_ = 0;
            bitField0_ = bitField0_ & -3;
            gcacheExpirationSeconds_ = 0;
            bitField0_ = bitField0_ & -5;
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

        public CacheOption.Builder clearExpirationSeconds()
        {
            bitField0_ = bitField0_ & -3;
            expirationSeconds_ = 0;
            return this;
        }

        public CacheOption.Builder clearGcacheExpirationSeconds()
        {
            bitField0_ = bitField0_ & -5;
            gcacheExpirationSeconds_ = 0;
            return this;
        }

        public CacheOption.Builder clearLevel()
        {
            bitField0_ = bitField0_ & -2;
            level_ = CacheOption.CacheLevel.NO_CACHE;
            return this;
        }

        public CacheOption.Builder clone()
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

        public CacheOption getDefaultInstanceForType()
        {
            return CacheOption.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getExpirationSeconds()
        {
            return expirationSeconds_;
        }

        public int getGcacheExpirationSeconds()
        {
            return gcacheExpirationSeconds_;
        }

        public CacheOption.CacheLevel getLevel()
        {
            return level_;
        }

        public boolean hasExpirationSeconds()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasGcacheExpirationSeconds()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasLevel()
        {
            return (bitField0_ & 1) == 1;
        }

        public final boolean isInitialized()
        {
            return true;
        }

        public CacheOption.Builder mergeFrom(CacheOption cacheoption)
        {
            if (cacheoption == CacheOption.getDefaultInstance())
            {
                return this;
            }
            if (cacheoption.hasLevel())
            {
                setLevel(cacheoption.getLevel());
            }
            if (cacheoption.hasExpirationSeconds())
            {
                setExpirationSeconds(cacheoption.getExpirationSeconds());
            }
            if (cacheoption.hasGcacheExpirationSeconds())
            {
                setGcacheExpirationSeconds(cacheoption.getGcacheExpirationSeconds());
            }
            setUnknownFields(getUnknownFields().concat(cacheoption.unknownFields));
            return this;
        }

        public CacheOption.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (CacheOption)CacheOption.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((CacheOption) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (CacheOption)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((CacheOption) (codedinputstream1)));
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
            return mergeFrom((CacheOption)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public CacheOption.Builder setExpirationSeconds(int i)
        {
            bitField0_ = bitField0_ | 2;
            expirationSeconds_ = i;
            return this;
        }

        public CacheOption.Builder setGcacheExpirationSeconds(int i)
        {
            bitField0_ = bitField0_ | 4;
            gcacheExpirationSeconds_ = i;
            return this;
        }

        public CacheOption.Builder setLevel(CacheOption.CacheLevel cachelevel)
        {
            if (cachelevel == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                level_ = cachelevel;
                return this;
            }
        }


        private CacheOption.Builder()
        {
            level_ = CacheOption.CacheLevel.NO_CACHE;
            maybeForceBuilderInitialization();
        }
    }

    public static final class CacheOption.CacheLevel extends Enum
        implements com.google.tagmanager.protobuf.Internal.EnumLite
    {

        private static final CacheOption.CacheLevel $VALUES[];
        public static final CacheOption.CacheLevel NO_CACHE;
        public static final int NO_CACHE_VALUE = 1;
        public static final CacheOption.CacheLevel PRIVATE;
        public static final int PRIVATE_VALUE = 2;
        public static final CacheOption.CacheLevel PUBLIC;
        public static final int PUBLIC_VALUE = 3;
        private static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

            public CacheOption.CacheLevel findValueByNumber(int i)
            {
                return CacheOption.CacheLevel.valueOf(i);
            }

            public volatile com.google.tagmanager.protobuf.Internal.EnumLite findValueByNumber(int i)
            {
                return findValueByNumber(i);
            }

        };
        private final int value;

        public static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalGetValueMap()
        {
            return internalValueMap;
        }

        public static CacheOption.CacheLevel valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return NO_CACHE;

            case 2: // '\002'
                return PRIVATE;

            case 3: // '\003'
                return PUBLIC;
            }
        }

        public static CacheOption.CacheLevel valueOf(String s)
        {
            return (CacheOption.CacheLevel)Enum.valueOf(com/google/analytics/containertag/proto/Serving$CacheOption$CacheLevel, s);
        }

        public static CacheOption.CacheLevel[] values()
        {
            return (CacheOption.CacheLevel[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            NO_CACHE = new CacheOption.CacheLevel("NO_CACHE", 0, 0, 1);
            PRIVATE = new CacheOption.CacheLevel("PRIVATE", 1, 1, 2);
            PUBLIC = new CacheOption.CacheLevel("PUBLIC", 2, 2, 3);
            $VALUES = (new CacheOption.CacheLevel[] {
                NO_CACHE, PRIVATE, PUBLIC
            });
        }

        private CacheOption.CacheLevel(String s, int i, int j, int k)
        {
            super(s, i);
            value = k;
        }
    }

    public static interface CacheOptionOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract int getExpirationSeconds();

        public abstract int getGcacheExpirationSeconds();

        public abstract CacheOption.CacheLevel getLevel();

        public abstract boolean hasExpirationSeconds();

        public abstract boolean hasGcacheExpirationSeconds();

        public abstract boolean hasLevel();
    }

    public static final class Container extends GeneratedMessageLite
        implements ContainerOrBuilder
    {

        public static final int CONTAINER_ID_FIELD_NUMBER = 3;
        public static final int JS_RESOURCE_FIELD_NUMBER = 1;
        public static Parser PARSER = new AbstractParser() {

            public Container parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new Container(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int STATE_FIELD_NUMBER = 4;
        public static final int VERSION_FIELD_NUMBER = 5;
        private static final Container defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private Object containerId_;
        private Resource jsResource_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private ResourceState state_;
        private final ByteString unknownFields;
        private Object version_;

        public static Container getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            jsResource_ = Resource.getDefaultInstance();
            containerId_ = "";
            state_ = ResourceState.PREVIEW;
            version_ = "";
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(Container container)
        {
            return newBuilder().mergeFrom(container);
        }

        public static Container parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (Container)PARSER.parseDelimitedFrom(inputstream);
        }

        public static Container parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Container)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static Container parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (Container)PARSER.parseFrom(bytestring);
        }

        public static Container parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Container)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static Container parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (Container)PARSER.parseFrom(codedinputstream);
        }

        public static Container parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Container)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static Container parseFrom(InputStream inputstream)
            throws IOException
        {
            return (Container)PARSER.parseFrom(inputstream);
        }

        public static Container parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Container)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static Container parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (Container)PARSER.parseFrom(abyte0);
        }

        public static Container parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Container)PARSER.parseFrom(abyte0, extensionregistrylite);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof Container))
            {
                return super.equals(obj);
            }
            obj = (Container)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (true && hasJsResource() == ((Container) (obj)).hasJsResource())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasJsResource())
            {
                if (flag && getJsResource().equals(((Container) (obj)).getJsResource()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasContainerId() == ((Container) (obj)).hasContainerId())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasContainerId())
            {
                if (flag && getContainerId().equals(((Container) (obj)).getContainerId()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasState() == ((Container) (obj)).hasState())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasState())
            {
                if (flag && getState() == ((Container) (obj)).getState())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasVersion() == ((Container) (obj)).hasVersion())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag3 = flag2;
            if (hasVersion())
            {
                if (flag2 && getVersion().equals(((Container) (obj)).getVersion()))
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
            return flag3;
        }

        public String getContainerId()
        {
            Object obj = containerId_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (((ByteString) (obj)).isValidUtf8())
            {
                containerId_ = s;
            }
            return s;
        }

        public ByteString getContainerIdBytes()
        {
            Object obj = containerId_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                containerId_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public Container getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Resource getJsResource()
        {
            return jsResource_;
        }

        public Parser getParserForType()
        {
            return PARSER;
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
                j = 0 + CodedOutputStream.computeMessageSize(1, jsResource_);
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeBytesSize(3, getContainerIdBytes());
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeEnumSize(4, state_.getNumber());
            }
            i = j;
            if ((bitField0_ & 8) == 8)
            {
                i = j + CodedOutputStream.computeBytesSize(5, getVersionBytes());
            }
            i += unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public ResourceState getState()
        {
            return state_;
        }

        public String getVersion()
        {
            Object obj = version_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (((ByteString) (obj)).isValidUtf8())
            {
                version_ = s;
            }
            return s;
        }

        public ByteString getVersionBytes()
        {
            Object obj = version_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                version_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public boolean hasContainerId()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasJsResource()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasState()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasVersion()
        {
            return (bitField0_ & 8) == 8;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Serving$Container.hashCode() + 779;
            int i = j;
            if (hasJsResource())
            {
                i = (j * 37 + 1) * 53 + getJsResource().hashCode();
            }
            j = i;
            if (hasContainerId())
            {
                j = (i * 37 + 3) * 53 + getContainerId().hashCode();
            }
            i = j;
            if (hasState())
            {
                i = (j * 37 + 4) * 53 + Internal.hashEnum(getState());
            }
            j = i;
            if (hasVersion())
            {
                j = (i * 37 + 5) * 53 + getVersion().hashCode();
            }
            i = j * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$Container");
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
            if (!hasJsResource())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasContainerId())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasState())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!getJsResource().isInitialized())
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
                codedoutputstream.writeMessage(1, jsResource_);
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBytes(3, getContainerIdBytes());
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeEnum(4, state_.getNumber());
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeBytes(5, getVersionBytes());
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new Container(true);
            defaultInstance.initFields();
        }


/*
        static Resource access$302(Container container, Resource resource)
        {
            container.jsResource_ = resource;
            return resource;
        }

*/



/*
        static Object access$402(Container container, Object obj)
        {
            container.containerId_ = obj;
            return obj;
        }

*/


/*
        static ResourceState access$502(Container container, ResourceState resourcestate)
        {
            container.state_ = resourcestate;
            return resourcestate;
        }

*/



/*
        static Object access$602(Container container, Object obj)
        {
            container.version_ = obj;
            return obj;
        }

*/


/*
        static int access$702(Container container, int i)
        {
            container.bitField0_ = i;
            return i;
        }

*/


        private Container(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
_L18:
            if (flag) goto _L2; else goto _L1
_L1:
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 5: default 396
        //                       0: 399
        //                       10: 115
        //                       26: 212
        //                       32: 252
        //                       42: 303;
               goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            Object obj = null;
            if ((bitField0_ & 1) == 1)
            {
                obj = jsResource_.toBuilder();
            }
            jsResource_ = (Resource)codedinputstream.readMessage(Resource.PARSER, extensionregistrylite);
            if (obj == null) goto _L10; else goto _L9
_L9:
            ((Resource.Builder) (obj)).mergeFrom(jsResource_);
            jsResource_ = ((Resource.Builder) (obj)).buildPartial();
_L10:
            bitField0_ = bitField0_ | 1;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L16:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            obj = codedinputstream.readBytes();
            bitField0_ = bitField0_ | 2;
            containerId_ = obj;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L7:
            int j;
            j = codedinputstream.readEnum();
            obj = ResourceState.valueOf(j);
            if (obj != null) goto _L12; else goto _L11
_L11:
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeRawVarint32(j);
            continue; /* Loop/switch isn't completed */
_L12:
            bitField0_ = bitField0_ | 4;
            state_ = ((ResourceState) (obj));
            continue; /* Loop/switch isn't completed */
_L8:
            ByteString bytestring = codedinputstream.readBytes();
            bitField0_ = bitField0_ | 8;
            version_ = bytestring;
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L14:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L14; else goto _L13
_L13:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L16; else goto _L15
_L15:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L18; else goto _L17
_L17:
        }


        private Container(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private Container(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class Container.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements ContainerOrBuilder
    {

        private int bitField0_;
        private Object containerId_;
        private Resource jsResource_;
        private ResourceState state_;
        private Object version_;

        private static Container.Builder create()
        {
            return new Container.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public Container build()
        {
            Container container = buildPartial();
            if (!container.isInitialized())
            {
                throw newUninitializedMessageException(container);
            } else
            {
                return container;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public Container buildPartial()
        {
            Container container = new Container(this);
            int k = bitField0_;
            int j = 0;
            if ((k & 1) == 1)
            {
                j = false | true;
            }
            container.jsResource_ = jsResource_;
            int i = j;
            if ((k & 2) == 2)
            {
                i = j | 2;
            }
            container.containerId_ = containerId_;
            j = i;
            if ((k & 4) == 4)
            {
                j = i | 4;
            }
            container.state_ = state_;
            i = j;
            if ((k & 8) == 8)
            {
                i = j | 8;
            }
            container.version_ = version_;
            container.bitField0_ = i;
            return container;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public Container.Builder clear()
        {
            super.clear();
            jsResource_ = Resource.getDefaultInstance();
            bitField0_ = bitField0_ & -2;
            containerId_ = "";
            bitField0_ = bitField0_ & -3;
            state_ = ResourceState.PREVIEW;
            bitField0_ = bitField0_ & -5;
            version_ = "";
            bitField0_ = bitField0_ & -9;
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

        public Container.Builder clearContainerId()
        {
            bitField0_ = bitField0_ & -3;
            containerId_ = Container.getDefaultInstance().getContainerId();
            return this;
        }

        public Container.Builder clearJsResource()
        {
            jsResource_ = Resource.getDefaultInstance();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public Container.Builder clearState()
        {
            bitField0_ = bitField0_ & -5;
            state_ = ResourceState.PREVIEW;
            return this;
        }

        public Container.Builder clearVersion()
        {
            bitField0_ = bitField0_ & -9;
            version_ = Container.getDefaultInstance().getVersion();
            return this;
        }

        public Container.Builder clone()
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

        public String getContainerId()
        {
            Object obj = containerId_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    containerId_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getContainerIdBytes()
        {
            Object obj = containerId_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                containerId_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public Container getDefaultInstanceForType()
        {
            return Container.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Resource getJsResource()
        {
            return jsResource_;
        }

        public ResourceState getState()
        {
            return state_;
        }

        public String getVersion()
        {
            Object obj = version_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    version_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getVersionBytes()
        {
            Object obj = version_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                version_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public boolean hasContainerId()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasJsResource()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasState()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasVersion()
        {
            return (bitField0_ & 8) == 8;
        }

        public final boolean isInitialized()
        {
            while (!hasJsResource() || !hasContainerId() || !hasState() || !getJsResource().isInitialized()) 
            {
                return false;
            }
            return true;
        }

        public Container.Builder mergeFrom(Container container)
        {
            if (container == Container.getDefaultInstance())
            {
                return this;
            }
            if (container.hasJsResource())
            {
                mergeJsResource(container.getJsResource());
            }
            if (container.hasContainerId())
            {
                bitField0_ = bitField0_ | 2;
                containerId_ = container.containerId_;
            }
            if (container.hasState())
            {
                setState(container.getState());
            }
            if (container.hasVersion())
            {
                bitField0_ = bitField0_ | 8;
                version_ = container.version_;
            }
            setUnknownFields(getUnknownFields().concat(container.unknownFields));
            return this;
        }

        public Container.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (Container)Container.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((Container) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (Container)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((Container) (codedinputstream1)));
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
            return mergeFrom((Container)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Container.Builder mergeJsResource(Resource resource)
        {
            if ((bitField0_ & 1) == 1 && jsResource_ != Resource.getDefaultInstance())
            {
                jsResource_ = Resource.newBuilder(jsResource_).mergeFrom(resource).buildPartial();
            } else
            {
                jsResource_ = resource;
            }
            bitField0_ = bitField0_ | 1;
            return this;
        }

        public Container.Builder setContainerId(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                containerId_ = s;
                return this;
            }
        }

        public Container.Builder setContainerIdBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                containerId_ = bytestring;
                return this;
            }
        }

        public Container.Builder setJsResource(Resource.Builder builder)
        {
            jsResource_ = builder.build();
            bitField0_ = bitField0_ | 1;
            return this;
        }

        public Container.Builder setJsResource(Resource resource)
        {
            if (resource == null)
            {
                throw new NullPointerException();
            } else
            {
                jsResource_ = resource;
                bitField0_ = bitField0_ | 1;
                return this;
            }
        }

        public Container.Builder setState(ResourceState resourcestate)
        {
            if (resourcestate == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                state_ = resourcestate;
                return this;
            }
        }

        public Container.Builder setVersion(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 8;
                version_ = s;
                return this;
            }
        }

        public Container.Builder setVersionBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 8;
                version_ = bytestring;
                return this;
            }
        }


        private Container.Builder()
        {
            jsResource_ = Resource.getDefaultInstance();
            containerId_ = "";
            state_ = ResourceState.PREVIEW;
            version_ = "";
            maybeForceBuilderInitialization();
        }
    }

    public static interface ContainerOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract String getContainerId();

        public abstract ByteString getContainerIdBytes();

        public abstract Resource getJsResource();

        public abstract ResourceState getState();

        public abstract String getVersion();

        public abstract ByteString getVersionBytes();

        public abstract boolean hasContainerId();

        public abstract boolean hasJsResource();

        public abstract boolean hasState();

        public abstract boolean hasVersion();
    }

    public static final class FunctionCall extends GeneratedMessageLite
        implements FunctionCallOrBuilder
    {

        public static final int FUNCTION_FIELD_NUMBER = 2;
        public static final int LIVE_ONLY_FIELD_NUMBER = 6;
        public static final int NAME_FIELD_NUMBER = 4;
        public static Parser PARSER = new AbstractParser() {

            public FunctionCall parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new FunctionCall(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int PROPERTY_FIELD_NUMBER = 3;
        public static final int SERVER_SIDE_FIELD_NUMBER = 1;
        private static final FunctionCall defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private int function_;
        private boolean liveOnly_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private List property_;
        private boolean serverSide_;
        private final ByteString unknownFields;

        public static FunctionCall getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            property_ = Collections.emptyList();
            function_ = 0;
            name_ = 0;
            liveOnly_ = false;
            serverSide_ = false;
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(FunctionCall functioncall)
        {
            return newBuilder().mergeFrom(functioncall);
        }

        public static FunctionCall parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (FunctionCall)PARSER.parseDelimitedFrom(inputstream);
        }

        public static FunctionCall parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (FunctionCall)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static FunctionCall parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (FunctionCall)PARSER.parseFrom(bytestring);
        }

        public static FunctionCall parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (FunctionCall)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static FunctionCall parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (FunctionCall)PARSER.parseFrom(codedinputstream);
        }

        public static FunctionCall parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (FunctionCall)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static FunctionCall parseFrom(InputStream inputstream)
            throws IOException
        {
            return (FunctionCall)PARSER.parseFrom(inputstream);
        }

        public static FunctionCall parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (FunctionCall)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static FunctionCall parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (FunctionCall)PARSER.parseFrom(abyte0);
        }

        public static FunctionCall parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (FunctionCall)PARSER.parseFrom(abyte0, extensionregistrylite);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof FunctionCall))
            {
                return super.equals(obj);
            }
            obj = (FunctionCall)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (true && getPropertyList().equals(((FunctionCall) (obj)).getPropertyList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && hasFunction() == ((FunctionCall) (obj)).hasFunction())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasFunction())
            {
                if (flag && getFunction() == ((FunctionCall) (obj)).getFunction())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasName() == ((FunctionCall) (obj)).hasName())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasName())
            {
                if (flag && getName() == ((FunctionCall) (obj)).getName())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasLiveOnly() == ((FunctionCall) (obj)).hasLiveOnly())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasLiveOnly())
            {
                if (flag && getLiveOnly() == ((FunctionCall) (obj)).getLiveOnly())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasServerSide() == ((FunctionCall) (obj)).hasServerSide())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag3 = flag2;
            if (hasServerSide())
            {
                if (flag2 && getServerSide() == ((FunctionCall) (obj)).getServerSide())
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
            return flag3;
        }

        public FunctionCall getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getFunction()
        {
            return function_;
        }

        public boolean getLiveOnly()
        {
            return liveOnly_;
        }

        public int getName()
        {
            return name_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public int getProperty(int i)
        {
            return ((Integer)property_.get(i)).intValue();
        }

        public int getPropertyCount()
        {
            return property_.size();
        }

        public List getPropertyList()
        {
            return property_;
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            if ((bitField0_ & 8) == 8)
            {
                i = 0 + CodedOutputStream.computeBoolSize(1, serverSide_);
            }
            int j = i;
            if ((bitField0_ & 1) == 1)
            {
                j = i + CodedOutputStream.computeInt32Size(2, function_);
            }
            int k = 0;
            for (i = 0; i < property_.size(); i++)
            {
                k += CodedOutputStream.computeInt32SizeNoTag(((Integer)property_.get(i)).intValue());
            }

            j = j + k + getPropertyList().size() * 1;
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeInt32Size(4, name_);
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeBoolSize(6, liveOnly_);
            }
            i = j + unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public boolean getServerSide()
        {
            return serverSide_;
        }

        public boolean hasFunction()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasLiveOnly()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasName()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasServerSide()
        {
            return (bitField0_ & 8) == 8;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Serving$FunctionCall.hashCode() + 779;
            int i = j;
            if (getPropertyCount() > 0)
            {
                i = (j * 37 + 3) * 53 + getPropertyList().hashCode();
            }
            j = i;
            if (hasFunction())
            {
                j = (i * 37 + 2) * 53 + getFunction();
            }
            i = j;
            if (hasName())
            {
                i = (j * 37 + 4) * 53 + getName();
            }
            j = i;
            if (hasLiveOnly())
            {
                j = (i * 37 + 6) * 53 + Internal.hashBoolean(getLiveOnly());
            }
            i = j;
            if (hasServerSide())
            {
                i = (j * 37 + 1) * 53 + Internal.hashBoolean(getServerSide());
            }
            i = i * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$FunctionCall");
            }
            return mutableDefault;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            if (!hasFunction())
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
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeBool(1, serverSide_);
            }
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeInt32(2, function_);
            }
            for (int i = 0; i < property_.size(); i++)
            {
                codedoutputstream.writeInt32(3, ((Integer)property_.get(i)).intValue());
            }

            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeInt32(4, name_);
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeBool(6, liveOnly_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new FunctionCall(true);
            defaultInstance.initFields();
        }



/*
        static List access$3002(FunctionCall functioncall, List list)
        {
            functioncall.property_ = list;
            return list;
        }

*/


/*
        static int access$3102(FunctionCall functioncall, int i)
        {
            functioncall.function_ = i;
            return i;
        }

*/


/*
        static int access$3202(FunctionCall functioncall, int i)
        {
            functioncall.name_ = i;
            return i;
        }

*/


/*
        static boolean access$3302(FunctionCall functioncall, boolean flag)
        {
            functioncall.liveOnly_ = flag;
            return flag;
        }

*/


/*
        static boolean access$3402(FunctionCall functioncall, boolean flag)
        {
            functioncall.serverSide_ = flag;
            return flag;
        }

*/


/*
        static int access$3502(FunctionCall functioncall, int i)
        {
            functioncall.bitField0_ = i;
            return i;
        }

*/


        private FunctionCall(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            boolean flag;
            boolean flag4;
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            initFields();
            flag = false;
            output = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(output);
            flag4 = false;
_L20:
            if (flag4) goto _L2; else goto _L1
_L1:
            boolean flag1;
            boolean flag2;
            boolean flag3;
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 7: default 729
        //                       0: 732
        //                       8: 155
        //                       16: 251
        //                       24: 317
        //                       26: 394
        //                       32: 556
        //                       48: 601;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L3:
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag4 = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            bitField0_ = bitField0_ | 8;
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            serverSide_ = codedinputstream.readBool();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            flag1 = flag2;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            if ((flag1 & true))
            {
                property_ = Collections.unmodifiableList(property_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L18:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            bitField0_ = bitField0_ | 1;
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            function_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            flag1 = flag3;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L7:
            i = ((flag) ? 1 : 0);
            if ((flag & true)) goto _L12; else goto _L11
_L11:
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            property_ = new ArrayList();
            i = flag | true;
_L12:
            flag2 = i;
            flag1 = i;
            flag3 = i;
            property_.add(Integer.valueOf(codedinputstream.readInt32()));
            flag = i;
            continue; /* Loop/switch isn't completed */
_L8:
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            int j = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i = ((flag) ? 1 : 0);
            if ((flag & true))
            {
                break MISSING_BLOCK_LABEL_480;
            }
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            i = ((flag) ? 1 : 0);
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_480;
            }
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            property_ = new ArrayList();
            i = flag | true;
_L14:
            flag2 = i;
            flag1 = i;
            flag3 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            flag2 = i;
            flag1 = i;
            flag3 = i;
            property_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L14; else goto _L13
_L13:
            flag2 = i;
            flag1 = i;
            flag3 = i;
            codedinputstream.popLimit(j);
            flag = i;
            continue; /* Loop/switch isn't completed */
_L9:
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            bitField0_ = bitField0_ | 2;
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            name_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L10:
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            bitField0_ = bitField0_ | 4;
            flag2 = flag;
            flag1 = flag;
            flag3 = flag;
            liveOnly_ = codedinputstream.readBool();
            continue; /* Loop/switch isn't completed */
_L2:
            if ((flag & true))
            {
                property_ = Collections.unmodifiableList(property_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L16:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L16; else goto _L15
_L15:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L18; else goto _L17
_L17:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag4 = true;
            if (true) goto _L20; else goto _L19
_L19:
        }


        private FunctionCall(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private FunctionCall(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class FunctionCall.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements FunctionCallOrBuilder
    {

        private int bitField0_;
        private int function_;
        private boolean liveOnly_;
        private int name_;
        private List property_;
        private boolean serverSide_;

        private static FunctionCall.Builder create()
        {
            return new FunctionCall.Builder();
        }

        private void ensurePropertyIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                property_ = new ArrayList(property_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public FunctionCall.Builder addAllProperty(Iterable iterable)
        {
            ensurePropertyIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, property_);
            return this;
        }

        public FunctionCall.Builder addProperty(int i)
        {
            ensurePropertyIsMutable();
            property_.add(Integer.valueOf(i));
            return this;
        }

        public FunctionCall build()
        {
            FunctionCall functioncall = buildPartial();
            if (!functioncall.isInitialized())
            {
                throw newUninitializedMessageException(functioncall);
            } else
            {
                return functioncall;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public FunctionCall buildPartial()
        {
            FunctionCall functioncall = new FunctionCall(this);
            int k = bitField0_;
            int j = 0;
            if ((bitField0_ & 1) == 1)
            {
                property_ = Collections.unmodifiableList(property_);
                bitField0_ = bitField0_ & -2;
            }
            functioncall.property_ = property_;
            if ((k & 2) == 2)
            {
                j = false | true;
            }
            functioncall.function_ = function_;
            int i = j;
            if ((k & 4) == 4)
            {
                i = j | 2;
            }
            functioncall.name_ = name_;
            j = i;
            if ((k & 8) == 8)
            {
                j = i | 4;
            }
            functioncall.liveOnly_ = liveOnly_;
            i = j;
            if ((k & 0x10) == 16)
            {
                i = j | 8;
            }
            functioncall.serverSide_ = serverSide_;
            functioncall.bitField0_ = i;
            return functioncall;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public FunctionCall.Builder clear()
        {
            super.clear();
            property_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            function_ = 0;
            bitField0_ = bitField0_ & -3;
            name_ = 0;
            bitField0_ = bitField0_ & -5;
            liveOnly_ = false;
            bitField0_ = bitField0_ & -9;
            serverSide_ = false;
            bitField0_ = bitField0_ & 0xffffffef;
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

        public FunctionCall.Builder clearFunction()
        {
            bitField0_ = bitField0_ & -3;
            function_ = 0;
            return this;
        }

        public FunctionCall.Builder clearLiveOnly()
        {
            bitField0_ = bitField0_ & -9;
            liveOnly_ = false;
            return this;
        }

        public FunctionCall.Builder clearName()
        {
            bitField0_ = bitField0_ & -5;
            name_ = 0;
            return this;
        }

        public FunctionCall.Builder clearProperty()
        {
            property_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public FunctionCall.Builder clearServerSide()
        {
            bitField0_ = bitField0_ & 0xffffffef;
            serverSide_ = false;
            return this;
        }

        public FunctionCall.Builder clone()
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

        public FunctionCall getDefaultInstanceForType()
        {
            return FunctionCall.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getFunction()
        {
            return function_;
        }

        public boolean getLiveOnly()
        {
            return liveOnly_;
        }

        public int getName()
        {
            return name_;
        }

        public int getProperty(int i)
        {
            return ((Integer)property_.get(i)).intValue();
        }

        public int getPropertyCount()
        {
            return property_.size();
        }

        public List getPropertyList()
        {
            return Collections.unmodifiableList(property_);
        }

        public boolean getServerSide()
        {
            return serverSide_;
        }

        public boolean hasFunction()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasLiveOnly()
        {
            return (bitField0_ & 8) == 8;
        }

        public boolean hasName()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasServerSide()
        {
            return (bitField0_ & 0x10) == 16;
        }

        public final boolean isInitialized()
        {
            return hasFunction();
        }

        public FunctionCall.Builder mergeFrom(FunctionCall functioncall)
        {
            if (functioncall == FunctionCall.getDefaultInstance())
            {
                return this;
            }
            if (!functioncall.property_.isEmpty())
            {
                if (property_.isEmpty())
                {
                    property_ = functioncall.property_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensurePropertyIsMutable();
                    property_.addAll(functioncall.property_);
                }
            }
            if (functioncall.hasFunction())
            {
                setFunction(functioncall.getFunction());
            }
            if (functioncall.hasName())
            {
                setName(functioncall.getName());
            }
            if (functioncall.hasLiveOnly())
            {
                setLiveOnly(functioncall.getLiveOnly());
            }
            if (functioncall.hasServerSide())
            {
                setServerSide(functioncall.getServerSide());
            }
            setUnknownFields(getUnknownFields().concat(functioncall.unknownFields));
            return this;
        }

        public FunctionCall.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (FunctionCall)FunctionCall.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((FunctionCall) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (FunctionCall)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((FunctionCall) (codedinputstream1)));
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
            return mergeFrom((FunctionCall)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public FunctionCall.Builder setFunction(int i)
        {
            bitField0_ = bitField0_ | 2;
            function_ = i;
            return this;
        }

        public FunctionCall.Builder setLiveOnly(boolean flag)
        {
            bitField0_ = bitField0_ | 8;
            liveOnly_ = flag;
            return this;
        }

        public FunctionCall.Builder setName(int i)
        {
            bitField0_ = bitField0_ | 4;
            name_ = i;
            return this;
        }

        public FunctionCall.Builder setProperty(int i, int j)
        {
            ensurePropertyIsMutable();
            property_.set(i, Integer.valueOf(j));
            return this;
        }

        public FunctionCall.Builder setServerSide(boolean flag)
        {
            bitField0_ = bitField0_ | 0x10;
            serverSide_ = flag;
            return this;
        }


        private FunctionCall.Builder()
        {
            property_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }
    }

    public static interface FunctionCallOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract int getFunction();

        public abstract boolean getLiveOnly();

        public abstract int getName();

        public abstract int getProperty(int i);

        public abstract int getPropertyCount();

        public abstract List getPropertyList();

        public abstract boolean getServerSide();

        public abstract boolean hasFunction();

        public abstract boolean hasLiveOnly();

        public abstract boolean hasName();

        public abstract boolean hasServerSide();
    }

    public static final class OptionalResource extends GeneratedMessageLite
        implements OptionalResourceOrBuilder
    {

        public static Parser PARSER = new AbstractParser() {

            public OptionalResource parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new OptionalResource(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int RESOURCE_FIELD_NUMBER = 2;
        private static final OptionalResource defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Resource resource_;
        private final ByteString unknownFields;

        public static OptionalResource getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            resource_ = Resource.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(OptionalResource optionalresource)
        {
            return newBuilder().mergeFrom(optionalresource);
        }

        public static OptionalResource parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (OptionalResource)PARSER.parseDelimitedFrom(inputstream);
        }

        public static OptionalResource parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (OptionalResource)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static OptionalResource parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (OptionalResource)PARSER.parseFrom(bytestring);
        }

        public static OptionalResource parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (OptionalResource)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static OptionalResource parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (OptionalResource)PARSER.parseFrom(codedinputstream);
        }

        public static OptionalResource parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (OptionalResource)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static OptionalResource parseFrom(InputStream inputstream)
            throws IOException
        {
            return (OptionalResource)PARSER.parseFrom(inputstream);
        }

        public static OptionalResource parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (OptionalResource)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static OptionalResource parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (OptionalResource)PARSER.parseFrom(abyte0);
        }

        public static OptionalResource parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (OptionalResource)PARSER.parseFrom(abyte0, extensionregistrylite);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof OptionalResource))
            {
                return super.equals(obj);
            }
            obj = (OptionalResource)obj;
            boolean flag;
            boolean flag1;
            if (true && hasResource() == ((OptionalResource) (obj)).hasResource())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasResource())
            {
                if (flag && getResource().equals(((OptionalResource) (obj)).getResource()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            return flag1;
        }

        public OptionalResource getDefaultInstanceForType()
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

        public Resource getResource()
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
                i = 0 + CodedOutputStream.computeMessageSize(2, resource_);
            }
            i += unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public boolean hasResource()
        {
            return (bitField0_ & 1) == 1;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Serving$OptionalResource.hashCode() + 779;
            int i = j;
            if (hasResource())
            {
                i = (j * 37 + 2) * 53 + getResource().hashCode();
            }
            i = i * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$OptionalResource");
            }
            return mutableDefault;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            if (hasResource() && !getResource().isInitialized())
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
                codedoutputstream.writeMessage(2, resource_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new OptionalResource(true);
            defaultInstance.initFields();
        }


/*
        static Resource access$8302(OptionalResource optionalresource, Resource resource)
        {
            optionalresource.resource_ = resource;
            return resource;
        }

*/


/*
        static int access$8402(OptionalResource optionalresource, int i)
        {
            optionalresource.bitField0_ = i;
            return i;
        }

*/


        private OptionalResource(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
_L13:
            if (flag) goto _L2; else goto _L1
_L1:
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 2: default 274
        //                       0: 277
        //                       18: 91;
               goto _L3 _L4 _L5
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            Resource.Builder builder = null;
            if ((bitField0_ & 1) == 1)
            {
                builder = resource_.toBuilder();
            }
            resource_ = (Resource)codedinputstream.readMessage(Resource.PARSER, extensionregistrylite);
            if (builder == null) goto _L7; else goto _L6
_L6:
            builder.mergeFrom(resource_);
            resource_ = builder.buildPartial();
_L7:
            bitField0_ = bitField0_ | 1;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L11:
            makeExtensionsImmutable();
            throw codedinputstream;
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L9:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L9; else goto _L8
_L8:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            codedinputstream;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L11; else goto _L10
_L10:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L13; else goto _L12
_L12:
        }


        private OptionalResource(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private OptionalResource(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class OptionalResource.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements OptionalResourceOrBuilder
    {

        private int bitField0_;
        private Resource resource_;

        private static OptionalResource.Builder create()
        {
            return new OptionalResource.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public OptionalResource build()
        {
            OptionalResource optionalresource = buildPartial();
            if (!optionalresource.isInitialized())
            {
                throw newUninitializedMessageException(optionalresource);
            } else
            {
                return optionalresource;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public OptionalResource buildPartial()
        {
            OptionalResource optionalresource = new OptionalResource(this);
            int j = bitField0_;
            int i = 0;
            if ((j & 1) == 1)
            {
                i = false | true;
            }
            optionalresource.resource_ = resource_;
            optionalresource.bitField0_ = i;
            return optionalresource;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public OptionalResource.Builder clear()
        {
            super.clear();
            resource_ = Resource.getDefaultInstance();
            bitField0_ = bitField0_ & -2;
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

        public OptionalResource.Builder clearResource()
        {
            resource_ = Resource.getDefaultInstance();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public OptionalResource.Builder clone()
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

        public OptionalResource getDefaultInstanceForType()
        {
            return OptionalResource.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Resource getResource()
        {
            return resource_;
        }

        public boolean hasResource()
        {
            return (bitField0_ & 1) == 1;
        }

        public final boolean isInitialized()
        {
            return !hasResource() || getResource().isInitialized();
        }

        public OptionalResource.Builder mergeFrom(OptionalResource optionalresource)
        {
            if (optionalresource == OptionalResource.getDefaultInstance())
            {
                return this;
            }
            if (optionalresource.hasResource())
            {
                mergeResource(optionalresource.getResource());
            }
            setUnknownFields(getUnknownFields().concat(optionalresource.unknownFields));
            return this;
        }

        public OptionalResource.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (OptionalResource)OptionalResource.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((OptionalResource) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (OptionalResource)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((OptionalResource) (codedinputstream1)));
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
            return mergeFrom((OptionalResource)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public OptionalResource.Builder mergeResource(Resource resource)
        {
            if ((bitField0_ & 1) == 1 && resource_ != Resource.getDefaultInstance())
            {
                resource_ = Resource.newBuilder(resource_).mergeFrom(resource).buildPartial();
            } else
            {
                resource_ = resource;
            }
            bitField0_ = bitField0_ | 1;
            return this;
        }

        public OptionalResource.Builder setResource(Resource.Builder builder)
        {
            resource_ = builder.build();
            bitField0_ = bitField0_ | 1;
            return this;
        }

        public OptionalResource.Builder setResource(Resource resource)
        {
            if (resource == null)
            {
                throw new NullPointerException();
            } else
            {
                resource_ = resource;
                bitField0_ = bitField0_ | 1;
                return this;
            }
        }


        private OptionalResource.Builder()
        {
            resource_ = Resource.getDefaultInstance();
            maybeForceBuilderInitialization();
        }
    }

    public static interface OptionalResourceOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract Resource getResource();

        public abstract boolean hasResource();
    }

    public static final class Property extends GeneratedMessageLite
        implements PropertyOrBuilder
    {

        public static final int KEY_FIELD_NUMBER = 1;
        public static Parser PARSER = new AbstractParser() {

            public Property parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new Property(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final Property defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private int key_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;
        private int value_;

        public static Property getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            key_ = 0;
            value_ = 0;
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(Property property)
        {
            return newBuilder().mergeFrom(property);
        }

        public static Property parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (Property)PARSER.parseDelimitedFrom(inputstream);
        }

        public static Property parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Property)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static Property parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (Property)PARSER.parseFrom(bytestring);
        }

        public static Property parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Property)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static Property parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (Property)PARSER.parseFrom(codedinputstream);
        }

        public static Property parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Property)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static Property parseFrom(InputStream inputstream)
            throws IOException
        {
            return (Property)PARSER.parseFrom(inputstream);
        }

        public static Property parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Property)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static Property parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (Property)PARSER.parseFrom(abyte0);
        }

        public static Property parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Property)PARSER.parseFrom(abyte0, extensionregistrylite);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof Property))
            {
                return super.equals(obj);
            }
            obj = (Property)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (true && hasKey() == ((Property) (obj)).hasKey())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasKey())
            {
                if (flag && getKey() == ((Property) (obj)).getKey())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasValue() == ((Property) (obj)).hasValue())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag3 = flag2;
            if (hasValue())
            {
                if (flag2 && getValue() == ((Property) (obj)).getValue())
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
            return flag3;
        }

        public Property getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getKey()
        {
            return key_;
        }

        public Parser getParserForType()
        {
            return PARSER;
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
                i = 0 + CodedOutputStream.computeInt32Size(1, key_);
            }
            int j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeInt32Size(2, value_);
            }
            i = j + unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public int getValue()
        {
            return value_;
        }

        public boolean hasKey()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasValue()
        {
            return (bitField0_ & 2) == 2;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Serving$Property.hashCode() + 779;
            int i = j;
            if (hasKey())
            {
                i = (j * 37 + 1) * 53 + getKey();
            }
            j = i;
            if (hasValue())
            {
                j = (i * 37 + 2) * 53 + getValue();
            }
            i = j * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$Property");
            }
            return mutableDefault;
        }

        public final boolean isInitialized()
        {
            byte byte0 = memoizedIsInitialized;
            if (byte0 != -1)
            {
                return byte0 == 1;
            }
            if (!hasKey())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasValue())
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
                codedoutputstream.writeInt32(1, key_);
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeInt32(2, value_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new Property(true);
            defaultInstance.initFields();
        }


/*
        static int access$2302(Property property, int i)
        {
            property.key_ = i;
            return i;
        }

*/


/*
        static int access$2402(Property property, int i)
        {
            property.value_ = i;
            return i;
        }

*/


/*
        static int access$2502(Property property, int i)
        {
            property.bitField0_ = i;
            return i;
        }

*/


        private Property(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
_L12:
            if (flag) goto _L2; else goto _L1
_L1:
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 3: default 249
        //                       0: 252
        //                       8: 99
        //                       16: 147;
               goto _L3 _L4 _L5 _L6
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            bitField0_ = bitField0_ | 1;
            key_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L10:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            bitField0_ = bitField0_ | 2;
            value_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L8:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L8; else goto _L7
_L7:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L10; else goto _L9
_L9:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L12; else goto _L11
_L11:
        }


        private Property(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private Property(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class Property.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements PropertyOrBuilder
    {

        private int bitField0_;
        private int key_;
        private int value_;

        private static Property.Builder create()
        {
            return new Property.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public Property build()
        {
            Property property = buildPartial();
            if (!property.isInitialized())
            {
                throw newUninitializedMessageException(property);
            } else
            {
                return property;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public Property buildPartial()
        {
            Property property = new Property(this);
            int k = bitField0_;
            int i = 0;
            if ((k & 1) == 1)
            {
                i = false | true;
            }
            property.key_ = key_;
            int j = i;
            if ((k & 2) == 2)
            {
                j = i | 2;
            }
            property.value_ = value_;
            property.bitField0_ = j;
            return property;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public Property.Builder clear()
        {
            super.clear();
            key_ = 0;
            bitField0_ = bitField0_ & -2;
            value_ = 0;
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

        public Property.Builder clearKey()
        {
            bitField0_ = bitField0_ & -2;
            key_ = 0;
            return this;
        }

        public Property.Builder clearValue()
        {
            bitField0_ = bitField0_ & -3;
            value_ = 0;
            return this;
        }

        public Property.Builder clone()
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

        public Property getDefaultInstanceForType()
        {
            return Property.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getKey()
        {
            return key_;
        }

        public int getValue()
        {
            return value_;
        }

        public boolean hasKey()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasValue()
        {
            return (bitField0_ & 2) == 2;
        }

        public final boolean isInitialized()
        {
            while (!hasKey() || !hasValue()) 
            {
                return false;
            }
            return true;
        }

        public Property.Builder mergeFrom(Property property)
        {
            if (property == Property.getDefaultInstance())
            {
                return this;
            }
            if (property.hasKey())
            {
                setKey(property.getKey());
            }
            if (property.hasValue())
            {
                setValue(property.getValue());
            }
            setUnknownFields(getUnknownFields().concat(property.unknownFields));
            return this;
        }

        public Property.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (Property)Property.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((Property) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (Property)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((Property) (codedinputstream1)));
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
            return mergeFrom((Property)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Property.Builder setKey(int i)
        {
            bitField0_ = bitField0_ | 1;
            key_ = i;
            return this;
        }

        public Property.Builder setValue(int i)
        {
            bitField0_ = bitField0_ | 2;
            value_ = i;
            return this;
        }


        private Property.Builder()
        {
            maybeForceBuilderInitialization();
        }
    }

    public static interface PropertyOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract int getKey();

        public abstract int getValue();

        public abstract boolean hasKey();

        public abstract boolean hasValue();
    }

    public static final class Resource extends GeneratedMessageLite
        implements ResourceOrBuilder
    {

        public static final int ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER = 18;
        public static final int KEY_FIELD_NUMBER = 1;
        public static final int LIVE_JS_CACHE_OPTION_FIELD_NUMBER = 14;
        public static final int MACRO_FIELD_NUMBER = 4;
        public static final int MALWARE_SCAN_AUTH_CODE_FIELD_NUMBER = 10;
        public static Parser PARSER = new AbstractParser() {

            public Resource parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new Resource(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int PREDICATE_FIELD_NUMBER = 6;
        public static final int PREVIEW_AUTH_CODE_FIELD_NUMBER = 9;
        public static final int PROPERTY_FIELD_NUMBER = 3;
        public static final int REPORTING_SAMPLE_RATE_FIELD_NUMBER = 15;
        public static final int RESOURCE_FORMAT_VERSION_FIELD_NUMBER = 17;
        public static final int RULE_FIELD_NUMBER = 7;
        public static final int TAG_FIELD_NUMBER = 5;
        public static final int TEMPLATE_VERSION_SET_FIELD_NUMBER = 12;
        public static final int USAGE_CONTEXT_FIELD_NUMBER = 16;
        public static final int VALUE_FIELD_NUMBER = 2;
        public static final int VERSION_FIELD_NUMBER = 13;
        private static final Resource defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private boolean enableAutoEventTracking_;
        private LazyStringList key_;
        private CacheOption liveJsCacheOption_;
        private List macro_;
        private Object malwareScanAuthCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List predicate_;
        private Object previewAuthCode_;
        private List property_;
        private float reportingSampleRate_;
        private int resourceFormatVersion_;
        private List rule_;
        private List tag_;
        private Object templateVersionSet_;
        private final ByteString unknownFields;
        private LazyStringList usageContext_;
        private List value_;
        private Object version_;

        public static Resource getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            key_ = LazyStringArrayList.EMPTY;
            value_ = Collections.emptyList();
            property_ = Collections.emptyList();
            macro_ = Collections.emptyList();
            tag_ = Collections.emptyList();
            predicate_ = Collections.emptyList();
            rule_ = Collections.emptyList();
            previewAuthCode_ = "";
            malwareScanAuthCode_ = "";
            templateVersionSet_ = "0";
            version_ = "";
            liveJsCacheOption_ = CacheOption.getDefaultInstance();
            reportingSampleRate_ = 0.0F;
            enableAutoEventTracking_ = false;
            usageContext_ = LazyStringArrayList.EMPTY;
            resourceFormatVersion_ = 0;
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(Resource resource)
        {
            return newBuilder().mergeFrom(resource);
        }

        public static Resource parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (Resource)PARSER.parseDelimitedFrom(inputstream);
        }

        public static Resource parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Resource)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static Resource parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (Resource)PARSER.parseFrom(bytestring);
        }

        public static Resource parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Resource)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static Resource parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (Resource)PARSER.parseFrom(codedinputstream);
        }

        public static Resource parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Resource)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static Resource parseFrom(InputStream inputstream)
            throws IOException
        {
            return (Resource)PARSER.parseFrom(inputstream);
        }

        public static Resource parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Resource)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static Resource parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (Resource)PARSER.parseFrom(abyte0);
        }

        public static Resource parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Resource)PARSER.parseFrom(abyte0, extensionregistrylite);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof Resource))
            {
                return super.equals(obj);
            }
            obj = (Resource)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (true && getKeyList().equals(((Resource) (obj)).getKeyList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getValueList().equals(((Resource) (obj)).getValueList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getPropertyList().equals(((Resource) (obj)).getPropertyList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getMacroList().equals(((Resource) (obj)).getMacroList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getTagList().equals(((Resource) (obj)).getTagList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getPredicateList().equals(((Resource) (obj)).getPredicateList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getRuleList().equals(((Resource) (obj)).getRuleList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && hasPreviewAuthCode() == ((Resource) (obj)).hasPreviewAuthCode())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasPreviewAuthCode())
            {
                if (flag && getPreviewAuthCode().equals(((Resource) (obj)).getPreviewAuthCode()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasMalwareScanAuthCode() == ((Resource) (obj)).hasMalwareScanAuthCode())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasMalwareScanAuthCode())
            {
                if (flag && getMalwareScanAuthCode().equals(((Resource) (obj)).getMalwareScanAuthCode()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasTemplateVersionSet() == ((Resource) (obj)).hasTemplateVersionSet())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasTemplateVersionSet())
            {
                if (flag && getTemplateVersionSet().equals(((Resource) (obj)).getTemplateVersionSet()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasVersion() == ((Resource) (obj)).hasVersion())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasVersion())
            {
                if (flag && getVersion().equals(((Resource) (obj)).getVersion()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasLiveJsCacheOption() == ((Resource) (obj)).hasLiveJsCacheOption())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasLiveJsCacheOption())
            {
                if (flag && getLiveJsCacheOption().equals(((Resource) (obj)).getLiveJsCacheOption()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasReportingSampleRate() == ((Resource) (obj)).hasReportingSampleRate())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasReportingSampleRate())
            {
                if (flag && Float.floatToIntBits(getReportingSampleRate()) == Float.floatToIntBits(((Resource) (obj)).getReportingSampleRate()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasEnableAutoEventTracking() == ((Resource) (obj)).hasEnableAutoEventTracking())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasEnableAutoEventTracking())
            {
                if (flag && getEnableAutoEventTracking() == ((Resource) (obj)).getEnableAutoEventTracking())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && getUsageContextList().equals(((Resource) (obj)).getUsageContextList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && hasResourceFormatVersion() == ((Resource) (obj)).hasResourceFormatVersion())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag3 = flag2;
            if (hasResourceFormatVersion())
            {
                if (flag2 && getResourceFormatVersion() == ((Resource) (obj)).getResourceFormatVersion())
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
            return flag3;
        }

        public Resource getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public boolean getEnableAutoEventTracking()
        {
            return enableAutoEventTracking_;
        }

        public String getKey(int i)
        {
            return (String)key_.get(i);
        }

        public ByteString getKeyBytes(int i)
        {
            return key_.getByteString(i);
        }

        public int getKeyCount()
        {
            return key_.size();
        }

        public List getKeyList()
        {
            return key_;
        }

        public CacheOption getLiveJsCacheOption()
        {
            return liveJsCacheOption_;
        }

        public FunctionCall getMacro(int i)
        {
            return (FunctionCall)macro_.get(i);
        }

        public int getMacroCount()
        {
            return macro_.size();
        }

        public List getMacroList()
        {
            return macro_;
        }

        public FunctionCallOrBuilder getMacroOrBuilder(int i)
        {
            return (FunctionCallOrBuilder)macro_.get(i);
        }

        public List getMacroOrBuilderList()
        {
            return macro_;
        }

        public String getMalwareScanAuthCode()
        {
            Object obj = malwareScanAuthCode_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (((ByteString) (obj)).isValidUtf8())
            {
                malwareScanAuthCode_ = s;
            }
            return s;
        }

        public ByteString getMalwareScanAuthCodeBytes()
        {
            Object obj = malwareScanAuthCode_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                malwareScanAuthCode_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public FunctionCall getPredicate(int i)
        {
            return (FunctionCall)predicate_.get(i);
        }

        public int getPredicateCount()
        {
            return predicate_.size();
        }

        public List getPredicateList()
        {
            return predicate_;
        }

        public FunctionCallOrBuilder getPredicateOrBuilder(int i)
        {
            return (FunctionCallOrBuilder)predicate_.get(i);
        }

        public List getPredicateOrBuilderList()
        {
            return predicate_;
        }

        public String getPreviewAuthCode()
        {
            Object obj = previewAuthCode_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (((ByteString) (obj)).isValidUtf8())
            {
                previewAuthCode_ = s;
            }
            return s;
        }

        public ByteString getPreviewAuthCodeBytes()
        {
            Object obj = previewAuthCode_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                previewAuthCode_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public Property getProperty(int i)
        {
            return (Property)property_.get(i);
        }

        public int getPropertyCount()
        {
            return property_.size();
        }

        public List getPropertyList()
        {
            return property_;
        }

        public PropertyOrBuilder getPropertyOrBuilder(int i)
        {
            return (PropertyOrBuilder)property_.get(i);
        }

        public List getPropertyOrBuilderList()
        {
            return property_;
        }

        public float getReportingSampleRate()
        {
            return reportingSampleRate_;
        }

        public int getResourceFormatVersion()
        {
            return resourceFormatVersion_;
        }

        public Rule getRule(int i)
        {
            return (Rule)rule_.get(i);
        }

        public int getRuleCount()
        {
            return rule_.size();
        }

        public List getRuleList()
        {
            return rule_;
        }

        public RuleOrBuilder getRuleOrBuilder(int i)
        {
            return (RuleOrBuilder)rule_.get(i);
        }

        public List getRuleOrBuilderList()
        {
            return rule_;
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            int j = 0;
            for (i = 0; i < key_.size(); i++)
            {
                j += CodedOutputStream.computeBytesSizeNoTag(key_.getByteString(i));
            }

            i = 0 + j + getKeyList().size() * 1;
            for (j = 0; j < value_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(2, (MessageLite)value_.get(j));
            }

            for (j = 0; j < property_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(3, (MessageLite)property_.get(j));
            }

            for (j = 0; j < macro_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(4, (MessageLite)macro_.get(j));
            }

            for (j = 0; j < tag_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(5, (MessageLite)tag_.get(j));
            }

            for (j = 0; j < predicate_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(6, (MessageLite)predicate_.get(j));
            }

            for (j = 0; j < rule_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(7, (MessageLite)rule_.get(j));
            }

            j = i;
            if ((bitField0_ & 1) == 1)
            {
                j = i + CodedOutputStream.computeBytesSize(9, getPreviewAuthCodeBytes());
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeBytesSize(10, getMalwareScanAuthCodeBytes());
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeBytesSize(12, getTemplateVersionSetBytes());
            }
            i = j;
            if ((bitField0_ & 8) == 8)
            {
                i = j + CodedOutputStream.computeBytesSize(13, getVersionBytes());
            }
            j = i;
            if ((bitField0_ & 0x10) == 16)
            {
                j = i + CodedOutputStream.computeMessageSize(14, liveJsCacheOption_);
            }
            i = j;
            if ((bitField0_ & 0x20) == 32)
            {
                i = j + CodedOutputStream.computeFloatSize(15, reportingSampleRate_);
            }
            int k = 0;
            for (j = 0; j < usageContext_.size(); j++)
            {
                k += CodedOutputStream.computeBytesSizeNoTag(usageContext_.getByteString(j));
            }

            j = i + k + getUsageContextList().size() * 2;
            i = j;
            if ((bitField0_ & 0x80) == 128)
            {
                i = j + CodedOutputStream.computeInt32Size(17, resourceFormatVersion_);
            }
            j = i;
            if ((bitField0_ & 0x40) == 64)
            {
                j = i + CodedOutputStream.computeBoolSize(18, enableAutoEventTracking_);
            }
            i = j + unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public FunctionCall getTag(int i)
        {
            return (FunctionCall)tag_.get(i);
        }

        public int getTagCount()
        {
            return tag_.size();
        }

        public List getTagList()
        {
            return tag_;
        }

        public FunctionCallOrBuilder getTagOrBuilder(int i)
        {
            return (FunctionCallOrBuilder)tag_.get(i);
        }

        public List getTagOrBuilderList()
        {
            return tag_;
        }

        public String getTemplateVersionSet()
        {
            Object obj = templateVersionSet_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (((ByteString) (obj)).isValidUtf8())
            {
                templateVersionSet_ = s;
            }
            return s;
        }

        public ByteString getTemplateVersionSetBytes()
        {
            Object obj = templateVersionSet_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                templateVersionSet_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public String getUsageContext(int i)
        {
            return (String)usageContext_.get(i);
        }

        public ByteString getUsageContextBytes(int i)
        {
            return usageContext_.getByteString(i);
        }

        public int getUsageContextCount()
        {
            return usageContext_.size();
        }

        public List getUsageContextList()
        {
            return usageContext_;
        }

        public com.google.analytics.midtier.proto.containertag.TypeSystem.Value getValue(int i)
        {
            return (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)value_.get(i);
        }

        public int getValueCount()
        {
            return value_.size();
        }

        public List getValueList()
        {
            return value_;
        }

        public com.google.analytics.midtier.proto.containertag.TypeSystem.ValueOrBuilder getValueOrBuilder(int i)
        {
            return (com.google.analytics.midtier.proto.containertag.TypeSystem.ValueOrBuilder)value_.get(i);
        }

        public List getValueOrBuilderList()
        {
            return value_;
        }

        public String getVersion()
        {
            Object obj = version_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (((ByteString) (obj)).isValidUtf8())
            {
                version_ = s;
            }
            return s;
        }

        public ByteString getVersionBytes()
        {
            Object obj = version_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                version_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public boolean hasEnableAutoEventTracking()
        {
            return (bitField0_ & 0x40) == 64;
        }

        public boolean hasLiveJsCacheOption()
        {
            return (bitField0_ & 0x10) == 16;
        }

        public boolean hasMalwareScanAuthCode()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasPreviewAuthCode()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasReportingSampleRate()
        {
            return (bitField0_ & 0x20) == 32;
        }

        public boolean hasResourceFormatVersion()
        {
            return (bitField0_ & 0x80) == 128;
        }

        public boolean hasTemplateVersionSet()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasVersion()
        {
            return (bitField0_ & 8) == 8;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Serving$Resource.hashCode() + 779;
            int i = j;
            if (getKeyCount() > 0)
            {
                i = (j * 37 + 1) * 53 + getKeyList().hashCode();
            }
            j = i;
            if (getValueCount() > 0)
            {
                j = (i * 37 + 2) * 53 + getValueList().hashCode();
            }
            i = j;
            if (getPropertyCount() > 0)
            {
                i = (j * 37 + 3) * 53 + getPropertyList().hashCode();
            }
            j = i;
            if (getMacroCount() > 0)
            {
                j = (i * 37 + 4) * 53 + getMacroList().hashCode();
            }
            i = j;
            if (getTagCount() > 0)
            {
                i = (j * 37 + 5) * 53 + getTagList().hashCode();
            }
            j = i;
            if (getPredicateCount() > 0)
            {
                j = (i * 37 + 6) * 53 + getPredicateList().hashCode();
            }
            i = j;
            if (getRuleCount() > 0)
            {
                i = (j * 37 + 7) * 53 + getRuleList().hashCode();
            }
            j = i;
            if (hasPreviewAuthCode())
            {
                j = (i * 37 + 9) * 53 + getPreviewAuthCode().hashCode();
            }
            i = j;
            if (hasMalwareScanAuthCode())
            {
                i = (j * 37 + 10) * 53 + getMalwareScanAuthCode().hashCode();
            }
            j = i;
            if (hasTemplateVersionSet())
            {
                j = (i * 37 + 12) * 53 + getTemplateVersionSet().hashCode();
            }
            i = j;
            if (hasVersion())
            {
                i = (j * 37 + 13) * 53 + getVersion().hashCode();
            }
            j = i;
            if (hasLiveJsCacheOption())
            {
                j = (i * 37 + 14) * 53 + getLiveJsCacheOption().hashCode();
            }
            i = j;
            if (hasReportingSampleRate())
            {
                i = (j * 37 + 15) * 53 + Float.floatToIntBits(getReportingSampleRate());
            }
            j = i;
            if (hasEnableAutoEventTracking())
            {
                j = (i * 37 + 18) * 53 + Internal.hashBoolean(getEnableAutoEventTracking());
            }
            i = j;
            if (getUsageContextCount() > 0)
            {
                i = (j * 37 + 16) * 53 + getUsageContextList().hashCode();
            }
            j = i;
            if (hasResourceFormatVersion())
            {
                j = (i * 37 + 17) * 53 + getResourceFormatVersion();
            }
            i = j * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$Resource");
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
            for (int i = 0; i < getValueCount(); i++)
            {
                if (!getValue(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int j = 0; j < getPropertyCount(); j++)
            {
                if (!getProperty(j).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int k = 0; k < getMacroCount(); k++)
            {
                if (!getMacro(k).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int l = 0; l < getTagCount(); l++)
            {
                if (!getTag(l).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int i1 = 0; i1 < getPredicateCount(); i1++)
            {
                if (!getPredicate(i1).isInitialized())
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
            for (int i = 0; i < key_.size(); i++)
            {
                codedoutputstream.writeBytes(1, key_.getByteString(i));
            }

            for (int j = 0; j < value_.size(); j++)
            {
                codedoutputstream.writeMessage(2, (MessageLite)value_.get(j));
            }

            for (int k = 0; k < property_.size(); k++)
            {
                codedoutputstream.writeMessage(3, (MessageLite)property_.get(k));
            }

            for (int l = 0; l < macro_.size(); l++)
            {
                codedoutputstream.writeMessage(4, (MessageLite)macro_.get(l));
            }

            for (int i1 = 0; i1 < tag_.size(); i1++)
            {
                codedoutputstream.writeMessage(5, (MessageLite)tag_.get(i1));
            }

            for (int j1 = 0; j1 < predicate_.size(); j1++)
            {
                codedoutputstream.writeMessage(6, (MessageLite)predicate_.get(j1));
            }

            for (int k1 = 0; k1 < rule_.size(); k1++)
            {
                codedoutputstream.writeMessage(7, (MessageLite)rule_.get(k1));
            }

            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeBytes(9, getPreviewAuthCodeBytes());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBytes(10, getMalwareScanAuthCodeBytes());
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeBytes(12, getTemplateVersionSetBytes());
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeBytes(13, getVersionBytes());
            }
            if ((bitField0_ & 0x10) == 16)
            {
                codedoutputstream.writeMessage(14, liveJsCacheOption_);
            }
            if ((bitField0_ & 0x20) == 32)
            {
                codedoutputstream.writeFloat(15, reportingSampleRate_);
            }
            for (int l1 = 0; l1 < usageContext_.size(); l1++)
            {
                codedoutputstream.writeBytes(16, usageContext_.getByteString(l1));
            }

            if ((bitField0_ & 0x80) == 128)
            {
                codedoutputstream.writeInt32(17, resourceFormatVersion_);
            }
            if ((bitField0_ & 0x40) == 64)
            {
                codedoutputstream.writeBool(18, enableAutoEventTracking_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new Resource(true);
            defaultInstance.initFields();
        }



/*
        static LazyStringList access$6202(Resource resource, LazyStringList lazystringlist)
        {
            resource.key_ = lazystringlist;
            return lazystringlist;
        }

*/



/*
        static List access$6302(Resource resource, List list)
        {
            resource.value_ = list;
            return list;
        }

*/



/*
        static List access$6402(Resource resource, List list)
        {
            resource.property_ = list;
            return list;
        }

*/



/*
        static List access$6502(Resource resource, List list)
        {
            resource.macro_ = list;
            return list;
        }

*/



/*
        static List access$6602(Resource resource, List list)
        {
            resource.tag_ = list;
            return list;
        }

*/



/*
        static List access$6702(Resource resource, List list)
        {
            resource.predicate_ = list;
            return list;
        }

*/



/*
        static List access$6802(Resource resource, List list)
        {
            resource.rule_ = list;
            return list;
        }

*/



/*
        static Object access$6902(Resource resource, Object obj)
        {
            resource.previewAuthCode_ = obj;
            return obj;
        }

*/



/*
        static Object access$7002(Resource resource, Object obj)
        {
            resource.malwareScanAuthCode_ = obj;
            return obj;
        }

*/



/*
        static Object access$7102(Resource resource, Object obj)
        {
            resource.templateVersionSet_ = obj;
            return obj;
        }

*/



/*
        static Object access$7202(Resource resource, Object obj)
        {
            resource.version_ = obj;
            return obj;
        }

*/


/*
        static CacheOption access$7302(Resource resource, CacheOption cacheoption)
        {
            resource.liveJsCacheOption_ = cacheoption;
            return cacheoption;
        }

*/


/*
        static float access$7402(Resource resource, float f)
        {
            resource.reportingSampleRate_ = f;
            return f;
        }

*/


/*
        static boolean access$7502(Resource resource, boolean flag)
        {
            resource.enableAutoEventTracking_ = flag;
            return flag;
        }

*/



/*
        static LazyStringList access$7602(Resource resource, LazyStringList lazystringlist)
        {
            resource.usageContext_ = lazystringlist;
            return lazystringlist;
        }

*/


/*
        static int access$7702(Resource resource, int i)
        {
            resource.resourceFormatVersion_ = i;
            return i;
        }

*/


/*
        static int access$7802(Resource resource, int i)
        {
            resource.bitField0_ = i;
            return i;
        }

*/


        private Resource(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            int i;
            boolean flag;
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            initFields();
            i = 0;
            output = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(output);
            flag = false;
_L46:
            if (flag) goto _L2; else goto _L1
_L1:
            int j;
            int k;
            int l;
            k = i;
            j = i;
            l = i;
            int i1 = codedinputstream.readTag();
            i1;
            JVM INSTR lookupswitch 17: default 1885
        //                       0: 1888
        //                       10: 239
        //                       18: 530
        //                       26: 629
        //                       34: 707
        //                       42: 788
        //                       50: 869
        //                       58: 950
        //                       74: 1031
        //                       82: 1090
        //                       98: 1149
        //                       106: 1208
        //                       114: 1268
        //                       125: 1412
        //                       130: 1458
        //                       136: 1551
        //                       144: 1598;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20
_L3:
            k = i;
            j = i;
            l = i;
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i1))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            k = i;
            j = i;
            l = i;
            Object obj = codedinputstream.readBytes();
            i1 = i;
            if ((i & 1) == 1) goto _L22; else goto _L21
_L21:
            k = i;
            j = i;
            l = i;
            key_ = new LazyStringArrayList();
            i1 = i | 1;
_L22:
            k = i1;
            j = i1;
            l = i1;
            key_.add(((ByteString) (obj)));
            i = i1;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            j = k;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            if ((j & 1) == 1)
            {
                key_ = new UnmodifiableLazyStringList(key_);
            }
            if ((j & 2) == 2)
            {
                value_ = Collections.unmodifiableList(value_);
            }
            if ((j & 4) == 4)
            {
                property_ = Collections.unmodifiableList(property_);
            }
            if ((j & 8) == 8)
            {
                macro_ = Collections.unmodifiableList(macro_);
            }
            if ((j & 0x10) == 16)
            {
                tag_ = Collections.unmodifiableList(tag_);
            }
            if ((j & 0x20) == 32)
            {
                predicate_ = Collections.unmodifiableList(predicate_);
            }
            if ((j & 0x40) == 64)
            {
                rule_ = Collections.unmodifiableList(rule_);
            }
            if ((j & 0x4000) == 16384)
            {
                usageContext_ = new UnmodifiableLazyStringList(usageContext_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L44:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            i1 = i;
            if ((i & 2) == 2) goto _L24; else goto _L23
_L23:
            k = i;
            j = i;
            l = i;
            value_ = new ArrayList();
            i1 = i | 2;
_L24:
            k = i1;
            j = i1;
            l = i1;
            value_.add(codedinputstream.readMessage(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            j = l;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L7:
            i1 = i;
            if ((i & 4) == 4) goto _L26; else goto _L25
_L25:
            k = i;
            j = i;
            l = i;
            property_ = new ArrayList();
            i1 = i | 4;
_L26:
            k = i1;
            j = i1;
            l = i1;
            property_.add(codedinputstream.readMessage(Property.PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L8:
            i1 = i;
            if ((i & 8) == 8) goto _L28; else goto _L27
_L27:
            k = i;
            j = i;
            l = i;
            macro_ = new ArrayList();
            i1 = i | 8;
_L28:
            k = i1;
            j = i1;
            l = i1;
            macro_.add(codedinputstream.readMessage(FunctionCall.PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L9:
            i1 = i;
            if ((i & 0x10) == 16) goto _L30; else goto _L29
_L29:
            k = i;
            j = i;
            l = i;
            tag_ = new ArrayList();
            i1 = i | 0x10;
_L30:
            k = i1;
            j = i1;
            l = i1;
            tag_.add(codedinputstream.readMessage(FunctionCall.PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L10:
            i1 = i;
            if ((i & 0x20) == 32) goto _L32; else goto _L31
_L31:
            k = i;
            j = i;
            l = i;
            predicate_ = new ArrayList();
            i1 = i | 0x20;
_L32:
            k = i1;
            j = i1;
            l = i1;
            predicate_.add(codedinputstream.readMessage(FunctionCall.PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L11:
            i1 = i;
            if ((i & 0x40) == 64) goto _L34; else goto _L33
_L33:
            k = i;
            j = i;
            l = i;
            rule_ = new ArrayList();
            i1 = i | 0x40;
_L34:
            k = i1;
            j = i1;
            l = i1;
            rule_.add(codedinputstream.readMessage(Rule.PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L12:
            k = i;
            j = i;
            l = i;
            obj = codedinputstream.readBytes();
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 1;
            k = i;
            j = i;
            l = i;
            previewAuthCode_ = obj;
            continue; /* Loop/switch isn't completed */
_L13:
            k = i;
            j = i;
            l = i;
            obj = codedinputstream.readBytes();
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 2;
            k = i;
            j = i;
            l = i;
            malwareScanAuthCode_ = obj;
            continue; /* Loop/switch isn't completed */
_L14:
            k = i;
            j = i;
            l = i;
            obj = codedinputstream.readBytes();
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 4;
            k = i;
            j = i;
            l = i;
            templateVersionSet_ = obj;
            continue; /* Loop/switch isn't completed */
_L15:
            k = i;
            j = i;
            l = i;
            obj = codedinputstream.readBytes();
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 8;
            k = i;
            j = i;
            l = i;
            version_ = obj;
            continue; /* Loop/switch isn't completed */
_L16:
            obj = null;
            k = i;
            j = i;
            l = i;
            if ((bitField0_ & 0x10) != 16) goto _L36; else goto _L35
_L35:
            k = i;
            j = i;
            l = i;
            obj = liveJsCacheOption_.toBuilder();
_L36:
            k = i;
            j = i;
            l = i;
            liveJsCacheOption_ = (CacheOption)codedinputstream.readMessage(CacheOption.PARSER, extensionregistrylite);
            if (obj == null) goto _L38; else goto _L37
_L37:
            k = i;
            j = i;
            l = i;
            ((CacheOption.Builder) (obj)).mergeFrom(liveJsCacheOption_);
            k = i;
            j = i;
            l = i;
            liveJsCacheOption_ = ((CacheOption.Builder) (obj)).buildPartial();
_L38:
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 0x10;
            continue; /* Loop/switch isn't completed */
_L17:
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 0x20;
            k = i;
            j = i;
            l = i;
            reportingSampleRate_ = codedinputstream.readFloat();
            continue; /* Loop/switch isn't completed */
_L18:
            k = i;
            j = i;
            l = i;
            obj = codedinputstream.readBytes();
            i1 = i;
            if ((i & 0x4000) == 16384) goto _L40; else goto _L39
_L39:
            k = i;
            j = i;
            l = i;
            usageContext_ = new LazyStringArrayList();
            i1 = i | 0x4000;
_L40:
            k = i1;
            j = i1;
            l = i1;
            usageContext_.add(((ByteString) (obj)));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L19:
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 0x80;
            k = i;
            j = i;
            l = i;
            resourceFormatVersion_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L20:
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 0x40;
            k = i;
            j = i;
            l = i;
            enableAutoEventTracking_ = codedinputstream.readBool();
            continue; /* Loop/switch isn't completed */
_L2:
            if ((i & 1) == 1)
            {
                key_ = new UnmodifiableLazyStringList(key_);
            }
            if ((i & 2) == 2)
            {
                value_ = Collections.unmodifiableList(value_);
            }
            if ((i & 4) == 4)
            {
                property_ = Collections.unmodifiableList(property_);
            }
            if ((i & 8) == 8)
            {
                macro_ = Collections.unmodifiableList(macro_);
            }
            if ((i & 0x10) == 16)
            {
                tag_ = Collections.unmodifiableList(tag_);
            }
            if ((i & 0x20) == 32)
            {
                predicate_ = Collections.unmodifiableList(predicate_);
            }
            if ((i & 0x40) == 64)
            {
                rule_ = Collections.unmodifiableList(rule_);
            }
            if ((i & 0x4000) == 16384)
            {
                usageContext_ = new UnmodifiableLazyStringList(usageContext_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L42:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L42; else goto _L41
_L41:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L44; else goto _L43
_L43:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L46; else goto _L45
_L45:
        }


        private Resource(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private Resource(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class Resource.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements ResourceOrBuilder
    {

        private int bitField0_;
        private boolean enableAutoEventTracking_;
        private LazyStringList key_;
        private CacheOption liveJsCacheOption_;
        private List macro_;
        private Object malwareScanAuthCode_;
        private List predicate_;
        private Object previewAuthCode_;
        private List property_;
        private float reportingSampleRate_;
        private int resourceFormatVersion_;
        private List rule_;
        private List tag_;
        private Object templateVersionSet_;
        private LazyStringList usageContext_;
        private List value_;
        private Object version_;

        private static Resource.Builder create()
        {
            return new Resource.Builder();
        }

        private void ensureKeyIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                key_ = new LazyStringArrayList(key_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private void ensureMacroIsMutable()
        {
            if ((bitField0_ & 8) != 8)
            {
                macro_ = new ArrayList(macro_);
                bitField0_ = bitField0_ | 8;
            }
        }

        private void ensurePredicateIsMutable()
        {
            if ((bitField0_ & 0x20) != 32)
            {
                predicate_ = new ArrayList(predicate_);
                bitField0_ = bitField0_ | 0x20;
            }
        }

        private void ensurePropertyIsMutable()
        {
            if ((bitField0_ & 4) != 4)
            {
                property_ = new ArrayList(property_);
                bitField0_ = bitField0_ | 4;
            }
        }

        private void ensureRuleIsMutable()
        {
            if ((bitField0_ & 0x40) != 64)
            {
                rule_ = new ArrayList(rule_);
                bitField0_ = bitField0_ | 0x40;
            }
        }

        private void ensureTagIsMutable()
        {
            if ((bitField0_ & 0x10) != 16)
            {
                tag_ = new ArrayList(tag_);
                bitField0_ = bitField0_ | 0x10;
            }
        }

        private void ensureUsageContextIsMutable()
        {
            if ((bitField0_ & 0x4000) != 16384)
            {
                usageContext_ = new LazyStringArrayList(usageContext_);
                bitField0_ = bitField0_ | 0x4000;
            }
        }

        private void ensureValueIsMutable()
        {
            if ((bitField0_ & 2) != 2)
            {
                value_ = new ArrayList(value_);
                bitField0_ = bitField0_ | 2;
            }
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public Resource.Builder addAllKey(Iterable iterable)
        {
            ensureKeyIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, key_);
            return this;
        }

        public Resource.Builder addAllMacro(Iterable iterable)
        {
            ensureMacroIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, macro_);
            return this;
        }

        public Resource.Builder addAllPredicate(Iterable iterable)
        {
            ensurePredicateIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, predicate_);
            return this;
        }

        public Resource.Builder addAllProperty(Iterable iterable)
        {
            ensurePropertyIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, property_);
            return this;
        }

        public Resource.Builder addAllRule(Iterable iterable)
        {
            ensureRuleIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, rule_);
            return this;
        }

        public Resource.Builder addAllTag(Iterable iterable)
        {
            ensureTagIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, tag_);
            return this;
        }

        public Resource.Builder addAllUsageContext(Iterable iterable)
        {
            ensureUsageContextIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, usageContext_);
            return this;
        }

        public Resource.Builder addAllValue(Iterable iterable)
        {
            ensureValueIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, value_);
            return this;
        }

        public Resource.Builder addKey(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureKeyIsMutable();
                key_.add(s);
                return this;
            }
        }

        public Resource.Builder addKeyBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureKeyIsMutable();
                key_.add(bytestring);
                return this;
            }
        }

        public Resource.Builder addMacro(int i, FunctionCall.Builder builder)
        {
            ensureMacroIsMutable();
            macro_.add(i, builder.build());
            return this;
        }

        public Resource.Builder addMacro(int i, FunctionCall functioncall)
        {
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMacroIsMutable();
                macro_.add(i, functioncall);
                return this;
            }
        }

        public Resource.Builder addMacro(FunctionCall.Builder builder)
        {
            ensureMacroIsMutable();
            macro_.add(builder.build());
            return this;
        }

        public Resource.Builder addMacro(FunctionCall functioncall)
        {
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMacroIsMutable();
                macro_.add(functioncall);
                return this;
            }
        }

        public Resource.Builder addPredicate(int i, FunctionCall.Builder builder)
        {
            ensurePredicateIsMutable();
            predicate_.add(i, builder.build());
            return this;
        }

        public Resource.Builder addPredicate(int i, FunctionCall functioncall)
        {
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePredicateIsMutable();
                predicate_.add(i, functioncall);
                return this;
            }
        }

        public Resource.Builder addPredicate(FunctionCall.Builder builder)
        {
            ensurePredicateIsMutable();
            predicate_.add(builder.build());
            return this;
        }

        public Resource.Builder addPredicate(FunctionCall functioncall)
        {
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePredicateIsMutable();
                predicate_.add(functioncall);
                return this;
            }
        }

        public Resource.Builder addProperty(int i, Property.Builder builder)
        {
            ensurePropertyIsMutable();
            property_.add(i, builder.build());
            return this;
        }

        public Resource.Builder addProperty(int i, Property property)
        {
            if (property == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePropertyIsMutable();
                property_.add(i, property);
                return this;
            }
        }

        public Resource.Builder addProperty(Property.Builder builder)
        {
            ensurePropertyIsMutable();
            property_.add(builder.build());
            return this;
        }

        public Resource.Builder addProperty(Property property)
        {
            if (property == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePropertyIsMutable();
                property_.add(property);
                return this;
            }
        }

        public Resource.Builder addRule(int i, Rule.Builder builder)
        {
            ensureRuleIsMutable();
            rule_.add(i, builder.build());
            return this;
        }

        public Resource.Builder addRule(int i, Rule rule)
        {
            if (rule == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRuleIsMutable();
                rule_.add(i, rule);
                return this;
            }
        }

        public Resource.Builder addRule(Rule.Builder builder)
        {
            ensureRuleIsMutable();
            rule_.add(builder.build());
            return this;
        }

        public Resource.Builder addRule(Rule rule)
        {
            if (rule == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRuleIsMutable();
                rule_.add(rule);
                return this;
            }
        }

        public Resource.Builder addTag(int i, FunctionCall.Builder builder)
        {
            ensureTagIsMutable();
            tag_.add(i, builder.build());
            return this;
        }

        public Resource.Builder addTag(int i, FunctionCall functioncall)
        {
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureTagIsMutable();
                tag_.add(i, functioncall);
                return this;
            }
        }

        public Resource.Builder addTag(FunctionCall.Builder builder)
        {
            ensureTagIsMutable();
            tag_.add(builder.build());
            return this;
        }

        public Resource.Builder addTag(FunctionCall functioncall)
        {
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureTagIsMutable();
                tag_.add(functioncall);
                return this;
            }
        }

        public Resource.Builder addUsageContext(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureUsageContextIsMutable();
                usageContext_.add(s);
                return this;
            }
        }

        public Resource.Builder addUsageContextBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureUsageContextIsMutable();
                usageContext_.add(bytestring);
                return this;
            }
        }

        public Resource.Builder addValue(int i, com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder)
        {
            ensureValueIsMutable();
            value_.add(i, builder.build());
            return this;
        }

        public Resource.Builder addValue(int i, com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureValueIsMutable();
                value_.add(i, value);
                return this;
            }
        }

        public Resource.Builder addValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder)
        {
            ensureValueIsMutable();
            value_.add(builder.build());
            return this;
        }

        public Resource.Builder addValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureValueIsMutable();
                value_.add(value);
                return this;
            }
        }

        public Resource build()
        {
            Resource resource = buildPartial();
            if (!resource.isInitialized())
            {
                throw newUninitializedMessageException(resource);
            } else
            {
                return resource;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public Resource buildPartial()
        {
            Resource resource = new Resource(this);
            int k = bitField0_;
            int j = 0;
            if ((bitField0_ & 1) == 1)
            {
                key_ = new UnmodifiableLazyStringList(key_);
                bitField0_ = bitField0_ & -2;
            }
            resource.key_ = key_;
            if ((bitField0_ & 2) == 2)
            {
                value_ = Collections.unmodifiableList(value_);
                bitField0_ = bitField0_ & -3;
            }
            resource.value_ = value_;
            if ((bitField0_ & 4) == 4)
            {
                property_ = Collections.unmodifiableList(property_);
                bitField0_ = bitField0_ & -5;
            }
            resource.property_ = property_;
            if ((bitField0_ & 8) == 8)
            {
                macro_ = Collections.unmodifiableList(macro_);
                bitField0_ = bitField0_ & -9;
            }
            resource.macro_ = macro_;
            if ((bitField0_ & 0x10) == 16)
            {
                tag_ = Collections.unmodifiableList(tag_);
                bitField0_ = bitField0_ & 0xffffffef;
            }
            resource.tag_ = tag_;
            if ((bitField0_ & 0x20) == 32)
            {
                predicate_ = Collections.unmodifiableList(predicate_);
                bitField0_ = bitField0_ & 0xffffffdf;
            }
            resource.predicate_ = predicate_;
            if ((bitField0_ & 0x40) == 64)
            {
                rule_ = Collections.unmodifiableList(rule_);
                bitField0_ = bitField0_ & 0xffffffbf;
            }
            resource.rule_ = rule_;
            if ((k & 0x80) == 128)
            {
                j = false | true;
            }
            resource.previewAuthCode_ = previewAuthCode_;
            int i = j;
            if ((k & 0x100) == 256)
            {
                i = j | 2;
            }
            resource.malwareScanAuthCode_ = malwareScanAuthCode_;
            j = i;
            if ((k & 0x200) == 512)
            {
                j = i | 4;
            }
            resource.templateVersionSet_ = templateVersionSet_;
            i = j;
            if ((k & 0x400) == 1024)
            {
                i = j | 8;
            }
            resource.version_ = version_;
            j = i;
            if ((k & 0x800) == 2048)
            {
                j = i | 0x10;
            }
            resource.liveJsCacheOption_ = liveJsCacheOption_;
            i = j;
            if ((k & 0x1000) == 4096)
            {
                i = j | 0x20;
            }
            resource.reportingSampleRate_ = reportingSampleRate_;
            j = i;
            if ((k & 0x2000) == 8192)
            {
                j = i | 0x40;
            }
            resource.enableAutoEventTracking_ = enableAutoEventTracking_;
            if ((bitField0_ & 0x4000) == 16384)
            {
                usageContext_ = new UnmodifiableLazyStringList(usageContext_);
                bitField0_ = bitField0_ & 0xffffbfff;
            }
            resource.usageContext_ = usageContext_;
            i = j;
            if ((k & 0x8000) == 32768)
            {
                i = j | 0x80;
            }
            resource.resourceFormatVersion_ = resourceFormatVersion_;
            resource.bitField0_ = i;
            return resource;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public Resource.Builder clear()
        {
            super.clear();
            key_ = LazyStringArrayList.EMPTY;
            bitField0_ = bitField0_ & -2;
            value_ = Collections.emptyList();
            bitField0_ = bitField0_ & -3;
            property_ = Collections.emptyList();
            bitField0_ = bitField0_ & -5;
            macro_ = Collections.emptyList();
            bitField0_ = bitField0_ & -9;
            tag_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffef;
            predicate_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffdf;
            rule_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffbf;
            previewAuthCode_ = "";
            bitField0_ = bitField0_ & 0xffffff7f;
            malwareScanAuthCode_ = "";
            bitField0_ = bitField0_ & 0xfffffeff;
            templateVersionSet_ = "0";
            bitField0_ = bitField0_ & 0xfffffdff;
            version_ = "";
            bitField0_ = bitField0_ & 0xfffffbff;
            liveJsCacheOption_ = CacheOption.getDefaultInstance();
            bitField0_ = bitField0_ & 0xfffff7ff;
            reportingSampleRate_ = 0.0F;
            bitField0_ = bitField0_ & 0xffffefff;
            enableAutoEventTracking_ = false;
            bitField0_ = bitField0_ & 0xffffdfff;
            usageContext_ = LazyStringArrayList.EMPTY;
            bitField0_ = bitField0_ & 0xffffbfff;
            resourceFormatVersion_ = 0;
            bitField0_ = bitField0_ & 0xffff7fff;
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

        public Resource.Builder clearEnableAutoEventTracking()
        {
            bitField0_ = bitField0_ & 0xffffdfff;
            enableAutoEventTracking_ = false;
            return this;
        }

        public Resource.Builder clearKey()
        {
            key_ = LazyStringArrayList.EMPTY;
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public Resource.Builder clearLiveJsCacheOption()
        {
            liveJsCacheOption_ = CacheOption.getDefaultInstance();
            bitField0_ = bitField0_ & 0xfffff7ff;
            return this;
        }

        public Resource.Builder clearMacro()
        {
            macro_ = Collections.emptyList();
            bitField0_ = bitField0_ & -9;
            return this;
        }

        public Resource.Builder clearMalwareScanAuthCode()
        {
            bitField0_ = bitField0_ & 0xfffffeff;
            malwareScanAuthCode_ = Resource.getDefaultInstance().getMalwareScanAuthCode();
            return this;
        }

        public Resource.Builder clearPredicate()
        {
            predicate_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffdf;
            return this;
        }

        public Resource.Builder clearPreviewAuthCode()
        {
            bitField0_ = bitField0_ & 0xffffff7f;
            previewAuthCode_ = Resource.getDefaultInstance().getPreviewAuthCode();
            return this;
        }

        public Resource.Builder clearProperty()
        {
            property_ = Collections.emptyList();
            bitField0_ = bitField0_ & -5;
            return this;
        }

        public Resource.Builder clearReportingSampleRate()
        {
            bitField0_ = bitField0_ & 0xffffefff;
            reportingSampleRate_ = 0.0F;
            return this;
        }

        public Resource.Builder clearResourceFormatVersion()
        {
            bitField0_ = bitField0_ & 0xffff7fff;
            resourceFormatVersion_ = 0;
            return this;
        }

        public Resource.Builder clearRule()
        {
            rule_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffbf;
            return this;
        }

        public Resource.Builder clearTag()
        {
            tag_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffef;
            return this;
        }

        public Resource.Builder clearTemplateVersionSet()
        {
            bitField0_ = bitField0_ & 0xfffffdff;
            templateVersionSet_ = Resource.getDefaultInstance().getTemplateVersionSet();
            return this;
        }

        public Resource.Builder clearUsageContext()
        {
            usageContext_ = LazyStringArrayList.EMPTY;
            bitField0_ = bitField0_ & 0xffffbfff;
            return this;
        }

        public Resource.Builder clearValue()
        {
            value_ = Collections.emptyList();
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public Resource.Builder clearVersion()
        {
            bitField0_ = bitField0_ & 0xfffffbff;
            version_ = Resource.getDefaultInstance().getVersion();
            return this;
        }

        public Resource.Builder clone()
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

        public Resource getDefaultInstanceForType()
        {
            return Resource.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public boolean getEnableAutoEventTracking()
        {
            return enableAutoEventTracking_;
        }

        public String getKey(int i)
        {
            return (String)key_.get(i);
        }

        public ByteString getKeyBytes(int i)
        {
            return key_.getByteString(i);
        }

        public int getKeyCount()
        {
            return key_.size();
        }

        public List getKeyList()
        {
            return Collections.unmodifiableList(key_);
        }

        public CacheOption getLiveJsCacheOption()
        {
            return liveJsCacheOption_;
        }

        public FunctionCall getMacro(int i)
        {
            return (FunctionCall)macro_.get(i);
        }

        public int getMacroCount()
        {
            return macro_.size();
        }

        public List getMacroList()
        {
            return Collections.unmodifiableList(macro_);
        }

        public String getMalwareScanAuthCode()
        {
            Object obj = malwareScanAuthCode_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    malwareScanAuthCode_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getMalwareScanAuthCodeBytes()
        {
            Object obj = malwareScanAuthCode_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                malwareScanAuthCode_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public FunctionCall getPredicate(int i)
        {
            return (FunctionCall)predicate_.get(i);
        }

        public int getPredicateCount()
        {
            return predicate_.size();
        }

        public List getPredicateList()
        {
            return Collections.unmodifiableList(predicate_);
        }

        public String getPreviewAuthCode()
        {
            Object obj = previewAuthCode_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    previewAuthCode_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getPreviewAuthCodeBytes()
        {
            Object obj = previewAuthCode_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                previewAuthCode_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public Property getProperty(int i)
        {
            return (Property)property_.get(i);
        }

        public int getPropertyCount()
        {
            return property_.size();
        }

        public List getPropertyList()
        {
            return Collections.unmodifiableList(property_);
        }

        public float getReportingSampleRate()
        {
            return reportingSampleRate_;
        }

        public int getResourceFormatVersion()
        {
            return resourceFormatVersion_;
        }

        public Rule getRule(int i)
        {
            return (Rule)rule_.get(i);
        }

        public int getRuleCount()
        {
            return rule_.size();
        }

        public List getRuleList()
        {
            return Collections.unmodifiableList(rule_);
        }

        public FunctionCall getTag(int i)
        {
            return (FunctionCall)tag_.get(i);
        }

        public int getTagCount()
        {
            return tag_.size();
        }

        public List getTagList()
        {
            return Collections.unmodifiableList(tag_);
        }

        public String getTemplateVersionSet()
        {
            Object obj = templateVersionSet_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    templateVersionSet_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getTemplateVersionSetBytes()
        {
            Object obj = templateVersionSet_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                templateVersionSet_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public String getUsageContext(int i)
        {
            return (String)usageContext_.get(i);
        }

        public ByteString getUsageContextBytes(int i)
        {
            return usageContext_.getByteString(i);
        }

        public int getUsageContextCount()
        {
            return usageContext_.size();
        }

        public List getUsageContextList()
        {
            return Collections.unmodifiableList(usageContext_);
        }

        public com.google.analytics.midtier.proto.containertag.TypeSystem.Value getValue(int i)
        {
            return (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)value_.get(i);
        }

        public int getValueCount()
        {
            return value_.size();
        }

        public List getValueList()
        {
            return Collections.unmodifiableList(value_);
        }

        public String getVersion()
        {
            Object obj = version_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    version_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getVersionBytes()
        {
            Object obj = version_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                version_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public boolean hasEnableAutoEventTracking()
        {
            return (bitField0_ & 0x2000) == 8192;
        }

        public boolean hasLiveJsCacheOption()
        {
            return (bitField0_ & 0x800) == 2048;
        }

        public boolean hasMalwareScanAuthCode()
        {
            return (bitField0_ & 0x100) == 256;
        }

        public boolean hasPreviewAuthCode()
        {
            return (bitField0_ & 0x80) == 128;
        }

        public boolean hasReportingSampleRate()
        {
            return (bitField0_ & 0x1000) == 4096;
        }

        public boolean hasResourceFormatVersion()
        {
            return (bitField0_ & 0x8000) == 32768;
        }

        public boolean hasTemplateVersionSet()
        {
            return (bitField0_ & 0x200) == 512;
        }

        public boolean hasVersion()
        {
            return (bitField0_ & 0x400) == 1024;
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
            for (int j = 0; j < getPropertyCount(); j++)
            {
                if (!getProperty(j).isInitialized())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }

            for (int k = 0; k < getMacroCount(); k++)
            {
                if (!getMacro(k).isInitialized())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }

            for (int l = 0; l < getTagCount(); l++)
            {
                if (!getTag(l).isInitialized())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }

            int i1 = 0;
label0:
            do
            {
label1:
                {
                    if (i1 >= getPredicateCount())
                    {
                        break label1;
                    }
                    if (!getPredicate(i1).isInitialized())
                    {
                        break label0;
                    }
                    i1++;
                }
            } while (true);
            if (true) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
        }

        public Resource.Builder mergeFrom(Resource resource)
        {
            if (resource == Resource.getDefaultInstance())
            {
                return this;
            }
            if (!resource.key_.isEmpty())
            {
                if (key_.isEmpty())
                {
                    key_ = resource.key_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensureKeyIsMutable();
                    key_.addAll(resource.key_);
                }
            }
            if (!resource.value_.isEmpty())
            {
                if (value_.isEmpty())
                {
                    value_ = resource.value_;
                    bitField0_ = bitField0_ & -3;
                } else
                {
                    ensureValueIsMutable();
                    value_.addAll(resource.value_);
                }
            }
            if (!resource.property_.isEmpty())
            {
                if (property_.isEmpty())
                {
                    property_ = resource.property_;
                    bitField0_ = bitField0_ & -5;
                } else
                {
                    ensurePropertyIsMutable();
                    property_.addAll(resource.property_);
                }
            }
            if (!resource.macro_.isEmpty())
            {
                if (macro_.isEmpty())
                {
                    macro_ = resource.macro_;
                    bitField0_ = bitField0_ & -9;
                } else
                {
                    ensureMacroIsMutable();
                    macro_.addAll(resource.macro_);
                }
            }
            if (!resource.tag_.isEmpty())
            {
                if (tag_.isEmpty())
                {
                    tag_ = resource.tag_;
                    bitField0_ = bitField0_ & 0xffffffef;
                } else
                {
                    ensureTagIsMutable();
                    tag_.addAll(resource.tag_);
                }
            }
            if (!resource.predicate_.isEmpty())
            {
                if (predicate_.isEmpty())
                {
                    predicate_ = resource.predicate_;
                    bitField0_ = bitField0_ & 0xffffffdf;
                } else
                {
                    ensurePredicateIsMutable();
                    predicate_.addAll(resource.predicate_);
                }
            }
            if (!resource.rule_.isEmpty())
            {
                if (rule_.isEmpty())
                {
                    rule_ = resource.rule_;
                    bitField0_ = bitField0_ & 0xffffffbf;
                } else
                {
                    ensureRuleIsMutable();
                    rule_.addAll(resource.rule_);
                }
            }
            if (resource.hasPreviewAuthCode())
            {
                bitField0_ = bitField0_ | 0x80;
                previewAuthCode_ = resource.previewAuthCode_;
            }
            if (resource.hasMalwareScanAuthCode())
            {
                bitField0_ = bitField0_ | 0x100;
                malwareScanAuthCode_ = resource.malwareScanAuthCode_;
            }
            if (resource.hasTemplateVersionSet())
            {
                bitField0_ = bitField0_ | 0x200;
                templateVersionSet_ = resource.templateVersionSet_;
            }
            if (resource.hasVersion())
            {
                bitField0_ = bitField0_ | 0x400;
                version_ = resource.version_;
            }
            if (resource.hasLiveJsCacheOption())
            {
                mergeLiveJsCacheOption(resource.getLiveJsCacheOption());
            }
            if (resource.hasReportingSampleRate())
            {
                setReportingSampleRate(resource.getReportingSampleRate());
            }
            if (resource.hasEnableAutoEventTracking())
            {
                setEnableAutoEventTracking(resource.getEnableAutoEventTracking());
            }
            if (!resource.usageContext_.isEmpty())
            {
                if (usageContext_.isEmpty())
                {
                    usageContext_ = resource.usageContext_;
                    bitField0_ = bitField0_ & 0xffffbfff;
                } else
                {
                    ensureUsageContextIsMutable();
                    usageContext_.addAll(resource.usageContext_);
                }
            }
            if (resource.hasResourceFormatVersion())
            {
                setResourceFormatVersion(resource.getResourceFormatVersion());
            }
            setUnknownFields(getUnknownFields().concat(resource.unknownFields));
            return this;
        }

        public Resource.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (Resource)Resource.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((Resource) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (Resource)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((Resource) (codedinputstream1)));
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
            return mergeFrom((Resource)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Resource.Builder mergeLiveJsCacheOption(CacheOption cacheoption)
        {
            if ((bitField0_ & 0x800) == 2048 && liveJsCacheOption_ != CacheOption.getDefaultInstance())
            {
                liveJsCacheOption_ = CacheOption.newBuilder(liveJsCacheOption_).mergeFrom(cacheoption).buildPartial();
            } else
            {
                liveJsCacheOption_ = cacheoption;
            }
            bitField0_ = bitField0_ | 0x800;
            return this;
        }

        public Resource.Builder removeMacro(int i)
        {
            ensureMacroIsMutable();
            macro_.remove(i);
            return this;
        }

        public Resource.Builder removePredicate(int i)
        {
            ensurePredicateIsMutable();
            predicate_.remove(i);
            return this;
        }

        public Resource.Builder removeProperty(int i)
        {
            ensurePropertyIsMutable();
            property_.remove(i);
            return this;
        }

        public Resource.Builder removeRule(int i)
        {
            ensureRuleIsMutable();
            rule_.remove(i);
            return this;
        }

        public Resource.Builder removeTag(int i)
        {
            ensureTagIsMutable();
            tag_.remove(i);
            return this;
        }

        public Resource.Builder removeValue(int i)
        {
            ensureValueIsMutable();
            value_.remove(i);
            return this;
        }

        public Resource.Builder setEnableAutoEventTracking(boolean flag)
        {
            bitField0_ = bitField0_ | 0x2000;
            enableAutoEventTracking_ = flag;
            return this;
        }

        public Resource.Builder setKey(int i, String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureKeyIsMutable();
                key_.set(i, s);
                return this;
            }
        }

        public Resource.Builder setLiveJsCacheOption(CacheOption.Builder builder)
        {
            liveJsCacheOption_ = builder.build();
            bitField0_ = bitField0_ | 0x800;
            return this;
        }

        public Resource.Builder setLiveJsCacheOption(CacheOption cacheoption)
        {
            if (cacheoption == null)
            {
                throw new NullPointerException();
            } else
            {
                liveJsCacheOption_ = cacheoption;
                bitField0_ = bitField0_ | 0x800;
                return this;
            }
        }

        public Resource.Builder setMacro(int i, FunctionCall.Builder builder)
        {
            ensureMacroIsMutable();
            macro_.set(i, builder.build());
            return this;
        }

        public Resource.Builder setMacro(int i, FunctionCall functioncall)
        {
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMacroIsMutable();
                macro_.set(i, functioncall);
                return this;
            }
        }

        public Resource.Builder setMalwareScanAuthCode(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x100;
                malwareScanAuthCode_ = s;
                return this;
            }
        }

        public Resource.Builder setMalwareScanAuthCodeBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x100;
                malwareScanAuthCode_ = bytestring;
                return this;
            }
        }

        public Resource.Builder setPredicate(int i, FunctionCall.Builder builder)
        {
            ensurePredicateIsMutable();
            predicate_.set(i, builder.build());
            return this;
        }

        public Resource.Builder setPredicate(int i, FunctionCall functioncall)
        {
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePredicateIsMutable();
                predicate_.set(i, functioncall);
                return this;
            }
        }

        public Resource.Builder setPreviewAuthCode(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x80;
                previewAuthCode_ = s;
                return this;
            }
        }

        public Resource.Builder setPreviewAuthCodeBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x80;
                previewAuthCode_ = bytestring;
                return this;
            }
        }

        public Resource.Builder setProperty(int i, Property.Builder builder)
        {
            ensurePropertyIsMutable();
            property_.set(i, builder.build());
            return this;
        }

        public Resource.Builder setProperty(int i, Property property)
        {
            if (property == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePropertyIsMutable();
                property_.set(i, property);
                return this;
            }
        }

        public Resource.Builder setReportingSampleRate(float f)
        {
            bitField0_ = bitField0_ | 0x1000;
            reportingSampleRate_ = f;
            return this;
        }

        public Resource.Builder setResourceFormatVersion(int i)
        {
            bitField0_ = bitField0_ | 0x8000;
            resourceFormatVersion_ = i;
            return this;
        }

        public Resource.Builder setRule(int i, Rule.Builder builder)
        {
            ensureRuleIsMutable();
            rule_.set(i, builder.build());
            return this;
        }

        public Resource.Builder setRule(int i, Rule rule)
        {
            if (rule == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRuleIsMutable();
                rule_.set(i, rule);
                return this;
            }
        }

        public Resource.Builder setTag(int i, FunctionCall.Builder builder)
        {
            ensureTagIsMutable();
            tag_.set(i, builder.build());
            return this;
        }

        public Resource.Builder setTag(int i, FunctionCall functioncall)
        {
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureTagIsMutable();
                tag_.set(i, functioncall);
                return this;
            }
        }

        public Resource.Builder setTemplateVersionSet(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x200;
                templateVersionSet_ = s;
                return this;
            }
        }

        public Resource.Builder setTemplateVersionSetBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x200;
                templateVersionSet_ = bytestring;
                return this;
            }
        }

        public Resource.Builder setUsageContext(int i, String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureUsageContextIsMutable();
                usageContext_.set(i, s);
                return this;
            }
        }

        public Resource.Builder setValue(int i, com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder)
        {
            ensureValueIsMutable();
            value_.set(i, builder.build());
            return this;
        }

        public Resource.Builder setValue(int i, com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureValueIsMutable();
                value_.set(i, value);
                return this;
            }
        }

        public Resource.Builder setVersion(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x400;
                version_ = s;
                return this;
            }
        }

        public Resource.Builder setVersionBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x400;
                version_ = bytestring;
                return this;
            }
        }


        private Resource.Builder()
        {
            key_ = LazyStringArrayList.EMPTY;
            value_ = Collections.emptyList();
            property_ = Collections.emptyList();
            macro_ = Collections.emptyList();
            tag_ = Collections.emptyList();
            predicate_ = Collections.emptyList();
            rule_ = Collections.emptyList();
            previewAuthCode_ = "";
            malwareScanAuthCode_ = "";
            templateVersionSet_ = "0";
            version_ = "";
            liveJsCacheOption_ = CacheOption.getDefaultInstance();
            usageContext_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }
    }

    public static interface ResourceOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract boolean getEnableAutoEventTracking();

        public abstract String getKey(int i);

        public abstract ByteString getKeyBytes(int i);

        public abstract int getKeyCount();

        public abstract List getKeyList();

        public abstract CacheOption getLiveJsCacheOption();

        public abstract FunctionCall getMacro(int i);

        public abstract int getMacroCount();

        public abstract List getMacroList();

        public abstract String getMalwareScanAuthCode();

        public abstract ByteString getMalwareScanAuthCodeBytes();

        public abstract FunctionCall getPredicate(int i);

        public abstract int getPredicateCount();

        public abstract List getPredicateList();

        public abstract String getPreviewAuthCode();

        public abstract ByteString getPreviewAuthCodeBytes();

        public abstract Property getProperty(int i);

        public abstract int getPropertyCount();

        public abstract List getPropertyList();

        public abstract float getReportingSampleRate();

        public abstract int getResourceFormatVersion();

        public abstract Rule getRule(int i);

        public abstract int getRuleCount();

        public abstract List getRuleList();

        public abstract FunctionCall getTag(int i);

        public abstract int getTagCount();

        public abstract List getTagList();

        public abstract String getTemplateVersionSet();

        public abstract ByteString getTemplateVersionSetBytes();

        public abstract String getUsageContext(int i);

        public abstract ByteString getUsageContextBytes(int i);

        public abstract int getUsageContextCount();

        public abstract List getUsageContextList();

        public abstract com.google.analytics.midtier.proto.containertag.TypeSystem.Value getValue(int i);

        public abstract int getValueCount();

        public abstract List getValueList();

        public abstract String getVersion();

        public abstract ByteString getVersionBytes();

        public abstract boolean hasEnableAutoEventTracking();

        public abstract boolean hasLiveJsCacheOption();

        public abstract boolean hasMalwareScanAuthCode();

        public abstract boolean hasPreviewAuthCode();

        public abstract boolean hasReportingSampleRate();

        public abstract boolean hasResourceFormatVersion();

        public abstract boolean hasTemplateVersionSet();

        public abstract boolean hasVersion();
    }

    public static final class ResourceState extends Enum
        implements com.google.tagmanager.protobuf.Internal.EnumLite
    {

        private static final ResourceState $VALUES[];
        public static final ResourceState LIVE;
        public static final int LIVE_VALUE = 2;
        public static final ResourceState PREVIEW;
        public static final int PREVIEW_VALUE = 1;
        private static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

            public ResourceState findValueByNumber(int i)
            {
                return ResourceState.valueOf(i);
            }

            public volatile com.google.tagmanager.protobuf.Internal.EnumLite findValueByNumber(int i)
            {
                return findValueByNumber(i);
            }

        };
        private final int value;

        public static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalGetValueMap()
        {
            return internalValueMap;
        }

        public static ResourceState valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return PREVIEW;

            case 2: // '\002'
                return LIVE;
            }
        }

        public static ResourceState valueOf(String s)
        {
            return (ResourceState)Enum.valueOf(com/google/analytics/containertag/proto/Serving$ResourceState, s);
        }

        public static ResourceState[] values()
        {
            return (ResourceState[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            PREVIEW = new ResourceState("PREVIEW", 0, 0, 1);
            LIVE = new ResourceState("LIVE", 1, 1, 2);
            $VALUES = (new ResourceState[] {
                PREVIEW, LIVE
            });
        }

        private ResourceState(String s, int i, int j, int k)
        {
            super(s, i);
            value = k;
        }
    }

    public static final class ResourceType extends Enum
        implements com.google.tagmanager.protobuf.Internal.EnumLite
    {

        private static final ResourceType $VALUES[];
        public static final ResourceType CLEAR_CACHE;
        public static final int CLEAR_CACHE_VALUE = 6;
        public static final ResourceType GET_COOKIE;
        public static final int GET_COOKIE_VALUE = 5;
        public static final ResourceType JS_RESOURCE;
        public static final int JS_RESOURCE_VALUE = 1;
        public static final ResourceType NS_RESOURCE;
        public static final int NS_RESOURCE_VALUE = 2;
        public static final ResourceType PIXEL_COLLECTION;
        public static final int PIXEL_COLLECTION_VALUE = 3;
        public static final ResourceType RAW_PROTO;
        public static final int RAW_PROTO_VALUE = 7;
        public static final ResourceType SET_COOKIE;
        public static final int SET_COOKIE_VALUE = 4;
        private static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

            public ResourceType findValueByNumber(int i)
            {
                return ResourceType.valueOf(i);
            }

            public volatile com.google.tagmanager.protobuf.Internal.EnumLite findValueByNumber(int i)
            {
                return findValueByNumber(i);
            }

        };
        private final int value;

        public static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalGetValueMap()
        {
            return internalValueMap;
        }

        public static ResourceType valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return JS_RESOURCE;

            case 2: // '\002'
                return NS_RESOURCE;

            case 3: // '\003'
                return PIXEL_COLLECTION;

            case 4: // '\004'
                return SET_COOKIE;

            case 5: // '\005'
                return GET_COOKIE;

            case 6: // '\006'
                return CLEAR_CACHE;

            case 7: // '\007'
                return RAW_PROTO;
            }
        }

        public static ResourceType valueOf(String s)
        {
            return (ResourceType)Enum.valueOf(com/google/analytics/containertag/proto/Serving$ResourceType, s);
        }

        public static ResourceType[] values()
        {
            return (ResourceType[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            JS_RESOURCE = new ResourceType("JS_RESOURCE", 0, 0, 1);
            NS_RESOURCE = new ResourceType("NS_RESOURCE", 1, 1, 2);
            PIXEL_COLLECTION = new ResourceType("PIXEL_COLLECTION", 2, 2, 3);
            SET_COOKIE = new ResourceType("SET_COOKIE", 3, 3, 4);
            GET_COOKIE = new ResourceType("GET_COOKIE", 4, 4, 5);
            CLEAR_CACHE = new ResourceType("CLEAR_CACHE", 5, 5, 6);
            RAW_PROTO = new ResourceType("RAW_PROTO", 6, 6, 7);
            $VALUES = (new ResourceType[] {
                JS_RESOURCE, NS_RESOURCE, PIXEL_COLLECTION, SET_COOKIE, GET_COOKIE, CLEAR_CACHE, RAW_PROTO
            });
        }

        private ResourceType(String s, int i, int j, int k)
        {
            super(s, i);
            value = k;
        }
    }

    public static final class Rule extends GeneratedMessageLite
        implements RuleOrBuilder
    {

        public static final int ADD_MACRO_FIELD_NUMBER = 7;
        public static final int ADD_MACRO_RULE_NAME_FIELD_NUMBER = 9;
        public static final int ADD_TAG_FIELD_NUMBER = 3;
        public static final int ADD_TAG_RULE_NAME_FIELD_NUMBER = 5;
        public static final int NEGATIVE_PREDICATE_FIELD_NUMBER = 2;
        public static Parser PARSER = new AbstractParser() {

            public Rule parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new Rule(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int POSITIVE_PREDICATE_FIELD_NUMBER = 1;
        public static final int REMOVE_MACRO_FIELD_NUMBER = 8;
        public static final int REMOVE_MACRO_RULE_NAME_FIELD_NUMBER = 10;
        public static final int REMOVE_TAG_FIELD_NUMBER = 4;
        public static final int REMOVE_TAG_RULE_NAME_FIELD_NUMBER = 6;
        private static final Rule defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private List addMacroRuleName_;
        private List addMacro_;
        private List addTagRuleName_;
        private List addTag_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List negativePredicate_;
        private List positivePredicate_;
        private List removeMacroRuleName_;
        private List removeMacro_;
        private List removeTagRuleName_;
        private List removeTag_;
        private final ByteString unknownFields;

        public static Rule getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            positivePredicate_ = Collections.emptyList();
            negativePredicate_ = Collections.emptyList();
            addTag_ = Collections.emptyList();
            removeTag_ = Collections.emptyList();
            addTagRuleName_ = Collections.emptyList();
            removeTagRuleName_ = Collections.emptyList();
            addMacro_ = Collections.emptyList();
            removeMacro_ = Collections.emptyList();
            addMacroRuleName_ = Collections.emptyList();
            removeMacroRuleName_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(Rule rule)
        {
            return newBuilder().mergeFrom(rule);
        }

        public static Rule parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (Rule)PARSER.parseDelimitedFrom(inputstream);
        }

        public static Rule parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Rule)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static Rule parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (Rule)PARSER.parseFrom(bytestring);
        }

        public static Rule parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Rule)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static Rule parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (Rule)PARSER.parseFrom(codedinputstream);
        }

        public static Rule parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Rule)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static Rule parseFrom(InputStream inputstream)
            throws IOException
        {
            return (Rule)PARSER.parseFrom(inputstream);
        }

        public static Rule parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (Rule)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static Rule parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (Rule)PARSER.parseFrom(abyte0);
        }

        public static Rule parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (Rule)PARSER.parseFrom(abyte0, extensionregistrylite);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof Rule))
            {
                return super.equals(obj);
            }
            obj = (Rule)obj;
            boolean flag;
            boolean flag1;
            if (true && getPositivePredicateList().equals(((Rule) (obj)).getPositivePredicateList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getNegativePredicateList().equals(((Rule) (obj)).getNegativePredicateList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getAddTagList().equals(((Rule) (obj)).getAddTagList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getRemoveTagList().equals(((Rule) (obj)).getRemoveTagList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getAddTagRuleNameList().equals(((Rule) (obj)).getAddTagRuleNameList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getRemoveTagRuleNameList().equals(((Rule) (obj)).getRemoveTagRuleNameList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getAddMacroList().equals(((Rule) (obj)).getAddMacroList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getRemoveMacroList().equals(((Rule) (obj)).getRemoveMacroList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getAddMacroRuleNameList().equals(((Rule) (obj)).getAddMacroRuleNameList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getRemoveMacroRuleNameList().equals(((Rule) (obj)).getRemoveMacroRuleNameList()))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            return flag1;
        }

        public int getAddMacro(int i)
        {
            return ((Integer)addMacro_.get(i)).intValue();
        }

        public int getAddMacroCount()
        {
            return addMacro_.size();
        }

        public List getAddMacroList()
        {
            return addMacro_;
        }

        public int getAddMacroRuleName(int i)
        {
            return ((Integer)addMacroRuleName_.get(i)).intValue();
        }

        public int getAddMacroRuleNameCount()
        {
            return addMacroRuleName_.size();
        }

        public List getAddMacroRuleNameList()
        {
            return addMacroRuleName_;
        }

        public int getAddTag(int i)
        {
            return ((Integer)addTag_.get(i)).intValue();
        }

        public int getAddTagCount()
        {
            return addTag_.size();
        }

        public List getAddTagList()
        {
            return addTag_;
        }

        public int getAddTagRuleName(int i)
        {
            return ((Integer)addTagRuleName_.get(i)).intValue();
        }

        public int getAddTagRuleNameCount()
        {
            return addTagRuleName_.size();
        }

        public List getAddTagRuleNameList()
        {
            return addTagRuleName_;
        }

        public Rule getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getNegativePredicate(int i)
        {
            return ((Integer)negativePredicate_.get(i)).intValue();
        }

        public int getNegativePredicateCount()
        {
            return negativePredicate_.size();
        }

        public List getNegativePredicateList()
        {
            return negativePredicate_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public int getPositivePredicate(int i)
        {
            return ((Integer)positivePredicate_.get(i)).intValue();
        }

        public int getPositivePredicateCount()
        {
            return positivePredicate_.size();
        }

        public List getPositivePredicateList()
        {
            return positivePredicate_;
        }

        public int getRemoveMacro(int i)
        {
            return ((Integer)removeMacro_.get(i)).intValue();
        }

        public int getRemoveMacroCount()
        {
            return removeMacro_.size();
        }

        public List getRemoveMacroList()
        {
            return removeMacro_;
        }

        public int getRemoveMacroRuleName(int i)
        {
            return ((Integer)removeMacroRuleName_.get(i)).intValue();
        }

        public int getRemoveMacroRuleNameCount()
        {
            return removeMacroRuleName_.size();
        }

        public List getRemoveMacroRuleNameList()
        {
            return removeMacroRuleName_;
        }

        public int getRemoveTag(int i)
        {
            return ((Integer)removeTag_.get(i)).intValue();
        }

        public int getRemoveTagCount()
        {
            return removeTag_.size();
        }

        public List getRemoveTagList()
        {
            return removeTag_;
        }

        public int getRemoveTagRuleName(int i)
        {
            return ((Integer)removeTagRuleName_.get(i)).intValue();
        }

        public int getRemoveTagRuleNameCount()
        {
            return removeTagRuleName_.size();
        }

        public List getRemoveTagRuleNameList()
        {
            return removeTagRuleName_;
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            for (int j = 0; j < positivePredicate_.size(); j++)
            {
                i += CodedOutputStream.computeInt32SizeNoTag(((Integer)positivePredicate_.get(j)).intValue());
            }

            int i5 = getPositivePredicateList().size();
            int k = 0;
            for (int l = 0; l < negativePredicate_.size(); l++)
            {
                k += CodedOutputStream.computeInt32SizeNoTag(((Integer)negativePredicate_.get(l)).intValue());
            }

            int j5 = getNegativePredicateList().size();
            int i1 = 0;
            for (int j1 = 0; j1 < addTag_.size(); j1++)
            {
                i1 += CodedOutputStream.computeInt32SizeNoTag(((Integer)addTag_.get(j1)).intValue());
            }

            int k5 = getAddTagList().size();
            int k1 = 0;
            for (int l1 = 0; l1 < removeTag_.size(); l1++)
            {
                k1 += CodedOutputStream.computeInt32SizeNoTag(((Integer)removeTag_.get(l1)).intValue());
            }

            int l5 = getRemoveTagList().size();
            int i2 = 0;
            for (int j2 = 0; j2 < addTagRuleName_.size(); j2++)
            {
                i2 += CodedOutputStream.computeInt32SizeNoTag(((Integer)addTagRuleName_.get(j2)).intValue());
            }

            int i6 = getAddTagRuleNameList().size();
            int k2 = 0;
            for (int l2 = 0; l2 < removeTagRuleName_.size(); l2++)
            {
                k2 += CodedOutputStream.computeInt32SizeNoTag(((Integer)removeTagRuleName_.get(l2)).intValue());
            }

            int j6 = getRemoveTagRuleNameList().size();
            int i3 = 0;
            for (int j3 = 0; j3 < addMacro_.size(); j3++)
            {
                i3 += CodedOutputStream.computeInt32SizeNoTag(((Integer)addMacro_.get(j3)).intValue());
            }

            int k6 = getAddMacroList().size();
            int k3 = 0;
            for (int l3 = 0; l3 < removeMacro_.size(); l3++)
            {
                k3 += CodedOutputStream.computeInt32SizeNoTag(((Integer)removeMacro_.get(l3)).intValue());
            }

            int l6 = getRemoveMacroList().size();
            int i4 = 0;
            for (int j4 = 0; j4 < addMacroRuleName_.size(); j4++)
            {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer)addMacroRuleName_.get(j4)).intValue());
            }

            int i7 = getAddMacroRuleNameList().size();
            int l4 = 0;
            for (int k4 = 0; k4 < removeMacroRuleName_.size(); k4++)
            {
                l4 += CodedOutputStream.computeInt32SizeNoTag(((Integer)removeMacroRuleName_.get(k4)).intValue());
            }

            i = 0 + i + i5 * 1 + k + j5 * 1 + i1 + k5 * 1 + k1 + l5 * 1 + i2 + i6 * 1 + k2 + j6 * 1 + i3 + k6 * 1 + k3 + l6 * 1 + i4 + i7 * 1 + l4 + getRemoveMacroRuleNameList().size() * 1 + unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Serving$Rule.hashCode() + 779;
            int i = j;
            if (getPositivePredicateCount() > 0)
            {
                i = (j * 37 + 1) * 53 + getPositivePredicateList().hashCode();
            }
            j = i;
            if (getNegativePredicateCount() > 0)
            {
                j = (i * 37 + 2) * 53 + getNegativePredicateList().hashCode();
            }
            i = j;
            if (getAddTagCount() > 0)
            {
                i = (j * 37 + 3) * 53 + getAddTagList().hashCode();
            }
            j = i;
            if (getRemoveTagCount() > 0)
            {
                j = (i * 37 + 4) * 53 + getRemoveTagList().hashCode();
            }
            i = j;
            if (getAddTagRuleNameCount() > 0)
            {
                i = (j * 37 + 5) * 53 + getAddTagRuleNameList().hashCode();
            }
            j = i;
            if (getRemoveTagRuleNameCount() > 0)
            {
                j = (i * 37 + 6) * 53 + getRemoveTagRuleNameList().hashCode();
            }
            i = j;
            if (getAddMacroCount() > 0)
            {
                i = (j * 37 + 7) * 53 + getAddMacroList().hashCode();
            }
            j = i;
            if (getRemoveMacroCount() > 0)
            {
                j = (i * 37 + 8) * 53 + getRemoveMacroList().hashCode();
            }
            i = j;
            if (getAddMacroRuleNameCount() > 0)
            {
                i = (j * 37 + 9) * 53 + getAddMacroRuleNameList().hashCode();
            }
            j = i;
            if (getRemoveMacroRuleNameCount() > 0)
            {
                j = (i * 37 + 10) * 53 + getRemoveMacroRuleNameList().hashCode();
            }
            i = j * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$Rule");
            }
            return mutableDefault;
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
            for (int i = 0; i < positivePredicate_.size(); i++)
            {
                codedoutputstream.writeInt32(1, ((Integer)positivePredicate_.get(i)).intValue());
            }

            for (int j = 0; j < negativePredicate_.size(); j++)
            {
                codedoutputstream.writeInt32(2, ((Integer)negativePredicate_.get(j)).intValue());
            }

            for (int k = 0; k < addTag_.size(); k++)
            {
                codedoutputstream.writeInt32(3, ((Integer)addTag_.get(k)).intValue());
            }

            for (int l = 0; l < removeTag_.size(); l++)
            {
                codedoutputstream.writeInt32(4, ((Integer)removeTag_.get(l)).intValue());
            }

            for (int i1 = 0; i1 < addTagRuleName_.size(); i1++)
            {
                codedoutputstream.writeInt32(5, ((Integer)addTagRuleName_.get(i1)).intValue());
            }

            for (int j1 = 0; j1 < removeTagRuleName_.size(); j1++)
            {
                codedoutputstream.writeInt32(6, ((Integer)removeTagRuleName_.get(j1)).intValue());
            }

            for (int k1 = 0; k1 < addMacro_.size(); k1++)
            {
                codedoutputstream.writeInt32(7, ((Integer)addMacro_.get(k1)).intValue());
            }

            for (int l1 = 0; l1 < removeMacro_.size(); l1++)
            {
                codedoutputstream.writeInt32(8, ((Integer)removeMacro_.get(l1)).intValue());
            }

            for (int i2 = 0; i2 < addMacroRuleName_.size(); i2++)
            {
                codedoutputstream.writeInt32(9, ((Integer)addMacroRuleName_.get(i2)).intValue());
            }

            for (int j2 = 0; j2 < removeMacroRuleName_.size(); j2++)
            {
                codedoutputstream.writeInt32(10, ((Integer)removeMacroRuleName_.get(j2)).intValue());
            }

            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new Rule(true);
            defaultInstance.initFields();
        }



/*
        static List access$4002(Rule rule, List list)
        {
            rule.positivePredicate_ = list;
            return list;
        }

*/



/*
        static List access$4102(Rule rule, List list)
        {
            rule.negativePredicate_ = list;
            return list;
        }

*/



/*
        static List access$4202(Rule rule, List list)
        {
            rule.addTag_ = list;
            return list;
        }

*/



/*
        static List access$4302(Rule rule, List list)
        {
            rule.removeTag_ = list;
            return list;
        }

*/



/*
        static List access$4402(Rule rule, List list)
        {
            rule.addTagRuleName_ = list;
            return list;
        }

*/



/*
        static List access$4502(Rule rule, List list)
        {
            rule.removeTagRuleName_ = list;
            return list;
        }

*/



/*
        static List access$4602(Rule rule, List list)
        {
            rule.addMacro_ = list;
            return list;
        }

*/



/*
        static List access$4702(Rule rule, List list)
        {
            rule.removeMacro_ = list;
            return list;
        }

*/



/*
        static List access$4802(Rule rule, List list)
        {
            rule.addMacroRuleName_ = list;
            return list;
        }

*/



/*
        static List access$4902(Rule rule, List list)
        {
            rule.removeMacroRuleName_ = list;
            return list;
        }

*/


        private Rule(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            int i;
            boolean flag;
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            initFields();
            i = 0;
            output = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(output);
            flag = false;
_L71:
            if (flag) goto _L2; else goto _L1
_L1:
            int j;
            int k;
            int l;
            k = i;
            j = i;
            l = i;
            int i1 = codedinputstream.readTag();
            i1;
            JVM INSTR lookupswitch 21: default 3253
        //                       0: 3256
        //                       8: 267
        //                       10: 585
        //                       16: 768
        //                       18: 845
        //                       24: 1007
        //                       26: 1084
        //                       32: 1246
        //                       34: 1326
        //                       40: 1491
        //                       42: 1571
        //                       48: 1736
        //                       50: 1816
        //                       56: 1981
        //                       58: 2061
        //                       64: 2226
        //                       66: 2309
        //                       72: 2477
        //                       74: 2560
        //                       80: 2728
        //                       82: 2811;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L3:
            k = i;
            j = i;
            l = i;
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i1))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            i1 = i;
            if ((i & 1) == 1) goto _L26; else goto _L25
_L25:
            k = i;
            j = i;
            l = i;
            positivePredicate_ = new ArrayList();
            i1 = i | 1;
_L26:
            k = i1;
            j = i1;
            l = i1;
            positivePredicate_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            j = k;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            if ((j & 1) == 1)
            {
                positivePredicate_ = Collections.unmodifiableList(positivePredicate_);
            }
            if ((j & 2) == 2)
            {
                negativePredicate_ = Collections.unmodifiableList(negativePredicate_);
            }
            if ((j & 4) == 4)
            {
                addTag_ = Collections.unmodifiableList(addTag_);
            }
            if ((j & 8) == 8)
            {
                removeTag_ = Collections.unmodifiableList(removeTag_);
            }
            if ((j & 0x10) == 16)
            {
                addTagRuleName_ = Collections.unmodifiableList(addTagRuleName_);
            }
            if ((j & 0x20) == 32)
            {
                removeTagRuleName_ = Collections.unmodifiableList(removeTagRuleName_);
            }
            if ((j & 0x40) == 64)
            {
                addMacro_ = Collections.unmodifiableList(addMacro_);
            }
            if ((j & 0x80) == 128)
            {
                removeMacro_ = Collections.unmodifiableList(removeMacro_);
            }
            if ((j & 0x100) == 256)
            {
                addMacroRuleName_ = Collections.unmodifiableList(addMacroRuleName_);
            }
            if ((j & 0x200) == 512)
            {
                removeMacroRuleName_ = Collections.unmodifiableList(removeMacroRuleName_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L69:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            k = i;
            j = i;
            l = i;
            int j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 1) == 1)
            {
                break MISSING_BLOCK_LABEL_671;
            }
            k = i;
            j = i;
            i1 = i;
            l = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_671;
            }
            k = i;
            j = i;
            l = i;
            positivePredicate_ = new ArrayList();
            i1 = i | 1;
_L29:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0) goto _L28; else goto _L27
_L27:
            k = i1;
            j = i1;
            l = i1;
            positivePredicate_.add(Integer.valueOf(codedinputstream.readInt32()));
              goto _L29
            codedinputstream;
            j = l;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L28:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L7:
            i1 = i;
            if ((i & 2) == 2) goto _L31; else goto _L30
_L30:
            k = i;
            j = i;
            l = i;
            negativePredicate_ = new ArrayList();
            i1 = i | 2;
_L31:
            k = i1;
            j = i1;
            l = i1;
            negativePredicate_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L8:
            k = i;
            j = i;
            l = i;
            j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 2) == 2)
            {
                break MISSING_BLOCK_LABEL_931;
            }
            k = i;
            j = i;
            l = i;
            i1 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_931;
            }
            k = i;
            j = i;
            l = i;
            negativePredicate_ = new ArrayList();
            i1 = i | 2;
_L33:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i1;
            j = i1;
            l = i1;
            negativePredicate_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L33; else goto _L32
_L32:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L9:
            i1 = i;
            if ((i & 4) == 4) goto _L35; else goto _L34
_L34:
            k = i;
            j = i;
            l = i;
            addTag_ = new ArrayList();
            i1 = i | 4;
_L35:
            k = i1;
            j = i1;
            l = i1;
            addTag_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L10:
            k = i;
            j = i;
            l = i;
            j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 4) == 4)
            {
                break MISSING_BLOCK_LABEL_1170;
            }
            k = i;
            j = i;
            l = i;
            i1 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_1170;
            }
            k = i;
            j = i;
            l = i;
            addTag_ = new ArrayList();
            i1 = i | 4;
_L37:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i1;
            j = i1;
            l = i1;
            addTag_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L37; else goto _L36
_L36:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L11:
            i1 = i;
            if ((i & 8) == 8) goto _L39; else goto _L38
_L38:
            k = i;
            j = i;
            l = i;
            removeTag_ = new ArrayList();
            i1 = i | 8;
_L39:
            k = i1;
            j = i1;
            l = i1;
            removeTag_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L12:
            k = i;
            j = i;
            l = i;
            j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 8) == 8)
            {
                break MISSING_BLOCK_LABEL_1415;
            }
            k = i;
            j = i;
            l = i;
            i1 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_1415;
            }
            k = i;
            j = i;
            l = i;
            removeTag_ = new ArrayList();
            i1 = i | 8;
_L41:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i1;
            j = i1;
            l = i1;
            removeTag_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L41; else goto _L40
_L40:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L13:
            i1 = i;
            if ((i & 0x10) == 16) goto _L43; else goto _L42
_L42:
            k = i;
            j = i;
            l = i;
            addTagRuleName_ = new ArrayList();
            i1 = i | 0x10;
_L43:
            k = i1;
            j = i1;
            l = i1;
            addTagRuleName_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L14:
            k = i;
            j = i;
            l = i;
            j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 0x10) == 16)
            {
                break MISSING_BLOCK_LABEL_1660;
            }
            k = i;
            j = i;
            l = i;
            i1 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_1660;
            }
            k = i;
            j = i;
            l = i;
            addTagRuleName_ = new ArrayList();
            i1 = i | 0x10;
_L45:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i1;
            j = i1;
            l = i1;
            addTagRuleName_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L45; else goto _L44
_L44:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L15:
            i1 = i;
            if ((i & 0x20) == 32) goto _L47; else goto _L46
_L46:
            k = i;
            j = i;
            l = i;
            removeTagRuleName_ = new ArrayList();
            i1 = i | 0x20;
_L47:
            k = i1;
            j = i1;
            l = i1;
            removeTagRuleName_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L16:
            k = i;
            j = i;
            l = i;
            j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 0x20) == 32)
            {
                break MISSING_BLOCK_LABEL_1905;
            }
            k = i;
            j = i;
            l = i;
            i1 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_1905;
            }
            k = i;
            j = i;
            l = i;
            removeTagRuleName_ = new ArrayList();
            i1 = i | 0x20;
_L49:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i1;
            j = i1;
            l = i1;
            removeTagRuleName_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L49; else goto _L48
_L48:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L17:
            i1 = i;
            if ((i & 0x40) == 64) goto _L51; else goto _L50
_L50:
            k = i;
            j = i;
            l = i;
            addMacro_ = new ArrayList();
            i1 = i | 0x40;
_L51:
            k = i1;
            j = i1;
            l = i1;
            addMacro_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L18:
            k = i;
            j = i;
            l = i;
            j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 0x40) == 64)
            {
                break MISSING_BLOCK_LABEL_2150;
            }
            k = i;
            j = i;
            l = i;
            i1 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_2150;
            }
            k = i;
            j = i;
            l = i;
            addMacro_ = new ArrayList();
            i1 = i | 0x40;
_L53:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i1;
            j = i1;
            l = i1;
            addMacro_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L53; else goto _L52
_L52:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L19:
            i1 = i;
            if ((i & 0x80) == 128) goto _L55; else goto _L54
_L54:
            k = i;
            j = i;
            l = i;
            removeMacro_ = new ArrayList();
            i1 = i | 0x80;
_L55:
            k = i1;
            j = i1;
            l = i1;
            removeMacro_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L20:
            k = i;
            j = i;
            l = i;
            j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 0x80) == 128)
            {
                break MISSING_BLOCK_LABEL_2401;
            }
            k = i;
            j = i;
            l = i;
            i1 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_2401;
            }
            k = i;
            j = i;
            l = i;
            removeMacro_ = new ArrayList();
            i1 = i | 0x80;
_L57:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i1;
            j = i1;
            l = i1;
            removeMacro_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L57; else goto _L56
_L56:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L21:
            i1 = i;
            if ((i & 0x100) == 256) goto _L59; else goto _L58
_L58:
            k = i;
            j = i;
            l = i;
            addMacroRuleName_ = new ArrayList();
            i1 = i | 0x100;
_L59:
            k = i1;
            j = i1;
            l = i1;
            addMacroRuleName_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L22:
            k = i;
            j = i;
            l = i;
            j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 0x100) == 256)
            {
                break MISSING_BLOCK_LABEL_2652;
            }
            k = i;
            j = i;
            l = i;
            i1 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_2652;
            }
            k = i;
            j = i;
            l = i;
            addMacroRuleName_ = new ArrayList();
            i1 = i | 0x100;
_L61:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i1;
            j = i1;
            l = i1;
            addMacroRuleName_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L61; else goto _L60
_L60:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L23:
            i1 = i;
            if ((i & 0x200) == 512) goto _L63; else goto _L62
_L62:
            k = i;
            j = i;
            l = i;
            removeMacroRuleName_ = new ArrayList();
            i1 = i | 0x200;
_L63:
            k = i1;
            j = i1;
            l = i1;
            removeMacroRuleName_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L24:
            k = i;
            j = i;
            l = i;
            j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 0x200) == 512)
            {
                break MISSING_BLOCK_LABEL_2903;
            }
            k = i;
            j = i;
            l = i;
            i1 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_2903;
            }
            k = i;
            j = i;
            l = i;
            removeMacroRuleName_ = new ArrayList();
            i1 = i | 0x200;
_L65:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i1;
            j = i1;
            l = i1;
            removeMacroRuleName_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L65; else goto _L64
_L64:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L2:
            if ((i & 1) == 1)
            {
                positivePredicate_ = Collections.unmodifiableList(positivePredicate_);
            }
            if ((i & 2) == 2)
            {
                negativePredicate_ = Collections.unmodifiableList(negativePredicate_);
            }
            if ((i & 4) == 4)
            {
                addTag_ = Collections.unmodifiableList(addTag_);
            }
            if ((i & 8) == 8)
            {
                removeTag_ = Collections.unmodifiableList(removeTag_);
            }
            if ((i & 0x10) == 16)
            {
                addTagRuleName_ = Collections.unmodifiableList(addTagRuleName_);
            }
            if ((i & 0x20) == 32)
            {
                removeTagRuleName_ = Collections.unmodifiableList(removeTagRuleName_);
            }
            if ((i & 0x40) == 64)
            {
                addMacro_ = Collections.unmodifiableList(addMacro_);
            }
            if ((i & 0x80) == 128)
            {
                removeMacro_ = Collections.unmodifiableList(removeMacro_);
            }
            if ((i & 0x100) == 256)
            {
                addMacroRuleName_ = Collections.unmodifiableList(addMacroRuleName_);
            }
            if ((i & 0x200) == 512)
            {
                removeMacroRuleName_ = Collections.unmodifiableList(removeMacroRuleName_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L67:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L67; else goto _L66
_L66:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L69; else goto _L68
_L68:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L71; else goto _L70
_L70:
        }


        private Rule(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private Rule(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class Rule.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements RuleOrBuilder
    {

        private List addMacroRuleName_;
        private List addMacro_;
        private List addTagRuleName_;
        private List addTag_;
        private int bitField0_;
        private List negativePredicate_;
        private List positivePredicate_;
        private List removeMacroRuleName_;
        private List removeMacro_;
        private List removeTagRuleName_;
        private List removeTag_;

        private static Rule.Builder create()
        {
            return new Rule.Builder();
        }

        private void ensureAddMacroIsMutable()
        {
            if ((bitField0_ & 0x40) != 64)
            {
                addMacro_ = new ArrayList(addMacro_);
                bitField0_ = bitField0_ | 0x40;
            }
        }

        private void ensureAddMacroRuleNameIsMutable()
        {
            if ((bitField0_ & 0x100) != 256)
            {
                addMacroRuleName_ = new ArrayList(addMacroRuleName_);
                bitField0_ = bitField0_ | 0x100;
            }
        }

        private void ensureAddTagIsMutable()
        {
            if ((bitField0_ & 4) != 4)
            {
                addTag_ = new ArrayList(addTag_);
                bitField0_ = bitField0_ | 4;
            }
        }

        private void ensureAddTagRuleNameIsMutable()
        {
            if ((bitField0_ & 0x10) != 16)
            {
                addTagRuleName_ = new ArrayList(addTagRuleName_);
                bitField0_ = bitField0_ | 0x10;
            }
        }

        private void ensureNegativePredicateIsMutable()
        {
            if ((bitField0_ & 2) != 2)
            {
                negativePredicate_ = new ArrayList(negativePredicate_);
                bitField0_ = bitField0_ | 2;
            }
        }

        private void ensurePositivePredicateIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                positivePredicate_ = new ArrayList(positivePredicate_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private void ensureRemoveMacroIsMutable()
        {
            if ((bitField0_ & 0x80) != 128)
            {
                removeMacro_ = new ArrayList(removeMacro_);
                bitField0_ = bitField0_ | 0x80;
            }
        }

        private void ensureRemoveMacroRuleNameIsMutable()
        {
            if ((bitField0_ & 0x200) != 512)
            {
                removeMacroRuleName_ = new ArrayList(removeMacroRuleName_);
                bitField0_ = bitField0_ | 0x200;
            }
        }

        private void ensureRemoveTagIsMutable()
        {
            if ((bitField0_ & 8) != 8)
            {
                removeTag_ = new ArrayList(removeTag_);
                bitField0_ = bitField0_ | 8;
            }
        }

        private void ensureRemoveTagRuleNameIsMutable()
        {
            if ((bitField0_ & 0x20) != 32)
            {
                removeTagRuleName_ = new ArrayList(removeTagRuleName_);
                bitField0_ = bitField0_ | 0x20;
            }
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public Rule.Builder addAddMacro(int i)
        {
            ensureAddMacroIsMutable();
            addMacro_.add(Integer.valueOf(i));
            return this;
        }

        public Rule.Builder addAddMacroRuleName(int i)
        {
            ensureAddMacroRuleNameIsMutable();
            addMacroRuleName_.add(Integer.valueOf(i));
            return this;
        }

        public Rule.Builder addAddTag(int i)
        {
            ensureAddTagIsMutable();
            addTag_.add(Integer.valueOf(i));
            return this;
        }

        public Rule.Builder addAddTagRuleName(int i)
        {
            ensureAddTagRuleNameIsMutable();
            addTagRuleName_.add(Integer.valueOf(i));
            return this;
        }

        public Rule.Builder addAllAddMacro(Iterable iterable)
        {
            ensureAddMacroIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, addMacro_);
            return this;
        }

        public Rule.Builder addAllAddMacroRuleName(Iterable iterable)
        {
            ensureAddMacroRuleNameIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, addMacroRuleName_);
            return this;
        }

        public Rule.Builder addAllAddTag(Iterable iterable)
        {
            ensureAddTagIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, addTag_);
            return this;
        }

        public Rule.Builder addAllAddTagRuleName(Iterable iterable)
        {
            ensureAddTagRuleNameIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, addTagRuleName_);
            return this;
        }

        public Rule.Builder addAllNegativePredicate(Iterable iterable)
        {
            ensureNegativePredicateIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, negativePredicate_);
            return this;
        }

        public Rule.Builder addAllPositivePredicate(Iterable iterable)
        {
            ensurePositivePredicateIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, positivePredicate_);
            return this;
        }

        public Rule.Builder addAllRemoveMacro(Iterable iterable)
        {
            ensureRemoveMacroIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, removeMacro_);
            return this;
        }

        public Rule.Builder addAllRemoveMacroRuleName(Iterable iterable)
        {
            ensureRemoveMacroRuleNameIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, removeMacroRuleName_);
            return this;
        }

        public Rule.Builder addAllRemoveTag(Iterable iterable)
        {
            ensureRemoveTagIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, removeTag_);
            return this;
        }

        public Rule.Builder addAllRemoveTagRuleName(Iterable iterable)
        {
            ensureRemoveTagRuleNameIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, removeTagRuleName_);
            return this;
        }

        public Rule.Builder addNegativePredicate(int i)
        {
            ensureNegativePredicateIsMutable();
            negativePredicate_.add(Integer.valueOf(i));
            return this;
        }

        public Rule.Builder addPositivePredicate(int i)
        {
            ensurePositivePredicateIsMutable();
            positivePredicate_.add(Integer.valueOf(i));
            return this;
        }

        public Rule.Builder addRemoveMacro(int i)
        {
            ensureRemoveMacroIsMutable();
            removeMacro_.add(Integer.valueOf(i));
            return this;
        }

        public Rule.Builder addRemoveMacroRuleName(int i)
        {
            ensureRemoveMacroRuleNameIsMutable();
            removeMacroRuleName_.add(Integer.valueOf(i));
            return this;
        }

        public Rule.Builder addRemoveTag(int i)
        {
            ensureRemoveTagIsMutable();
            removeTag_.add(Integer.valueOf(i));
            return this;
        }

        public Rule.Builder addRemoveTagRuleName(int i)
        {
            ensureRemoveTagRuleNameIsMutable();
            removeTagRuleName_.add(Integer.valueOf(i));
            return this;
        }

        public Rule build()
        {
            Rule rule = buildPartial();
            if (!rule.isInitialized())
            {
                throw newUninitializedMessageException(rule);
            } else
            {
                return rule;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public Rule buildPartial()
        {
            Rule rule = new Rule(this);
            int i = bitField0_;
            if ((bitField0_ & 1) == 1)
            {
                positivePredicate_ = Collections.unmodifiableList(positivePredicate_);
                bitField0_ = bitField0_ & -2;
            }
            rule.positivePredicate_ = positivePredicate_;
            if ((bitField0_ & 2) == 2)
            {
                negativePredicate_ = Collections.unmodifiableList(negativePredicate_);
                bitField0_ = bitField0_ & -3;
            }
            rule.negativePredicate_ = negativePredicate_;
            if ((bitField0_ & 4) == 4)
            {
                addTag_ = Collections.unmodifiableList(addTag_);
                bitField0_ = bitField0_ & -5;
            }
            rule.addTag_ = addTag_;
            if ((bitField0_ & 8) == 8)
            {
                removeTag_ = Collections.unmodifiableList(removeTag_);
                bitField0_ = bitField0_ & -9;
            }
            rule.removeTag_ = removeTag_;
            if ((bitField0_ & 0x10) == 16)
            {
                addTagRuleName_ = Collections.unmodifiableList(addTagRuleName_);
                bitField0_ = bitField0_ & 0xffffffef;
            }
            rule.addTagRuleName_ = addTagRuleName_;
            if ((bitField0_ & 0x20) == 32)
            {
                removeTagRuleName_ = Collections.unmodifiableList(removeTagRuleName_);
                bitField0_ = bitField0_ & 0xffffffdf;
            }
            rule.removeTagRuleName_ = removeTagRuleName_;
            if ((bitField0_ & 0x40) == 64)
            {
                addMacro_ = Collections.unmodifiableList(addMacro_);
                bitField0_ = bitField0_ & 0xffffffbf;
            }
            rule.addMacro_ = addMacro_;
            if ((bitField0_ & 0x80) == 128)
            {
                removeMacro_ = Collections.unmodifiableList(removeMacro_);
                bitField0_ = bitField0_ & 0xffffff7f;
            }
            rule.removeMacro_ = removeMacro_;
            if ((bitField0_ & 0x100) == 256)
            {
                addMacroRuleName_ = Collections.unmodifiableList(addMacroRuleName_);
                bitField0_ = bitField0_ & 0xfffffeff;
            }
            rule.addMacroRuleName_ = addMacroRuleName_;
            if ((bitField0_ & 0x200) == 512)
            {
                removeMacroRuleName_ = Collections.unmodifiableList(removeMacroRuleName_);
                bitField0_ = bitField0_ & 0xfffffdff;
            }
            rule.removeMacroRuleName_ = removeMacroRuleName_;
            return rule;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public Rule.Builder clear()
        {
            super.clear();
            positivePredicate_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            negativePredicate_ = Collections.emptyList();
            bitField0_ = bitField0_ & -3;
            addTag_ = Collections.emptyList();
            bitField0_ = bitField0_ & -5;
            removeTag_ = Collections.emptyList();
            bitField0_ = bitField0_ & -9;
            addTagRuleName_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffef;
            removeTagRuleName_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffdf;
            addMacro_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffbf;
            removeMacro_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffff7f;
            addMacroRuleName_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xfffffeff;
            removeMacroRuleName_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xfffffdff;
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

        public Rule.Builder clearAddMacro()
        {
            addMacro_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffbf;
            return this;
        }

        public Rule.Builder clearAddMacroRuleName()
        {
            addMacroRuleName_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xfffffeff;
            return this;
        }

        public Rule.Builder clearAddTag()
        {
            addTag_ = Collections.emptyList();
            bitField0_ = bitField0_ & -5;
            return this;
        }

        public Rule.Builder clearAddTagRuleName()
        {
            addTagRuleName_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffef;
            return this;
        }

        public Rule.Builder clearNegativePredicate()
        {
            negativePredicate_ = Collections.emptyList();
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public Rule.Builder clearPositivePredicate()
        {
            positivePredicate_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public Rule.Builder clearRemoveMacro()
        {
            removeMacro_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffff7f;
            return this;
        }

        public Rule.Builder clearRemoveMacroRuleName()
        {
            removeMacroRuleName_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xfffffdff;
            return this;
        }

        public Rule.Builder clearRemoveTag()
        {
            removeTag_ = Collections.emptyList();
            bitField0_ = bitField0_ & -9;
            return this;
        }

        public Rule.Builder clearRemoveTagRuleName()
        {
            removeTagRuleName_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffdf;
            return this;
        }

        public Rule.Builder clone()
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

        public int getAddMacro(int i)
        {
            return ((Integer)addMacro_.get(i)).intValue();
        }

        public int getAddMacroCount()
        {
            return addMacro_.size();
        }

        public List getAddMacroList()
        {
            return Collections.unmodifiableList(addMacro_);
        }

        public int getAddMacroRuleName(int i)
        {
            return ((Integer)addMacroRuleName_.get(i)).intValue();
        }

        public int getAddMacroRuleNameCount()
        {
            return addMacroRuleName_.size();
        }

        public List getAddMacroRuleNameList()
        {
            return Collections.unmodifiableList(addMacroRuleName_);
        }

        public int getAddTag(int i)
        {
            return ((Integer)addTag_.get(i)).intValue();
        }

        public int getAddTagCount()
        {
            return addTag_.size();
        }

        public List getAddTagList()
        {
            return Collections.unmodifiableList(addTag_);
        }

        public int getAddTagRuleName(int i)
        {
            return ((Integer)addTagRuleName_.get(i)).intValue();
        }

        public int getAddTagRuleNameCount()
        {
            return addTagRuleName_.size();
        }

        public List getAddTagRuleNameList()
        {
            return Collections.unmodifiableList(addTagRuleName_);
        }

        public Rule getDefaultInstanceForType()
        {
            return Rule.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getNegativePredicate(int i)
        {
            return ((Integer)negativePredicate_.get(i)).intValue();
        }

        public int getNegativePredicateCount()
        {
            return negativePredicate_.size();
        }

        public List getNegativePredicateList()
        {
            return Collections.unmodifiableList(negativePredicate_);
        }

        public int getPositivePredicate(int i)
        {
            return ((Integer)positivePredicate_.get(i)).intValue();
        }

        public int getPositivePredicateCount()
        {
            return positivePredicate_.size();
        }

        public List getPositivePredicateList()
        {
            return Collections.unmodifiableList(positivePredicate_);
        }

        public int getRemoveMacro(int i)
        {
            return ((Integer)removeMacro_.get(i)).intValue();
        }

        public int getRemoveMacroCount()
        {
            return removeMacro_.size();
        }

        public List getRemoveMacroList()
        {
            return Collections.unmodifiableList(removeMacro_);
        }

        public int getRemoveMacroRuleName(int i)
        {
            return ((Integer)removeMacroRuleName_.get(i)).intValue();
        }

        public int getRemoveMacroRuleNameCount()
        {
            return removeMacroRuleName_.size();
        }

        public List getRemoveMacroRuleNameList()
        {
            return Collections.unmodifiableList(removeMacroRuleName_);
        }

        public int getRemoveTag(int i)
        {
            return ((Integer)removeTag_.get(i)).intValue();
        }

        public int getRemoveTagCount()
        {
            return removeTag_.size();
        }

        public List getRemoveTagList()
        {
            return Collections.unmodifiableList(removeTag_);
        }

        public int getRemoveTagRuleName(int i)
        {
            return ((Integer)removeTagRuleName_.get(i)).intValue();
        }

        public int getRemoveTagRuleNameCount()
        {
            return removeTagRuleName_.size();
        }

        public List getRemoveTagRuleNameList()
        {
            return Collections.unmodifiableList(removeTagRuleName_);
        }

        public final boolean isInitialized()
        {
            return true;
        }

        public Rule.Builder mergeFrom(Rule rule)
        {
            if (rule == Rule.getDefaultInstance())
            {
                return this;
            }
            if (!rule.positivePredicate_.isEmpty())
            {
                if (positivePredicate_.isEmpty())
                {
                    positivePredicate_ = rule.positivePredicate_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensurePositivePredicateIsMutable();
                    positivePredicate_.addAll(rule.positivePredicate_);
                }
            }
            if (!rule.negativePredicate_.isEmpty())
            {
                if (negativePredicate_.isEmpty())
                {
                    negativePredicate_ = rule.negativePredicate_;
                    bitField0_ = bitField0_ & -3;
                } else
                {
                    ensureNegativePredicateIsMutable();
                    negativePredicate_.addAll(rule.negativePredicate_);
                }
            }
            if (!rule.addTag_.isEmpty())
            {
                if (addTag_.isEmpty())
                {
                    addTag_ = rule.addTag_;
                    bitField0_ = bitField0_ & -5;
                } else
                {
                    ensureAddTagIsMutable();
                    addTag_.addAll(rule.addTag_);
                }
            }
            if (!rule.removeTag_.isEmpty())
            {
                if (removeTag_.isEmpty())
                {
                    removeTag_ = rule.removeTag_;
                    bitField0_ = bitField0_ & -9;
                } else
                {
                    ensureRemoveTagIsMutable();
                    removeTag_.addAll(rule.removeTag_);
                }
            }
            if (!rule.addTagRuleName_.isEmpty())
            {
                if (addTagRuleName_.isEmpty())
                {
                    addTagRuleName_ = rule.addTagRuleName_;
                    bitField0_ = bitField0_ & 0xffffffef;
                } else
                {
                    ensureAddTagRuleNameIsMutable();
                    addTagRuleName_.addAll(rule.addTagRuleName_);
                }
            }
            if (!rule.removeTagRuleName_.isEmpty())
            {
                if (removeTagRuleName_.isEmpty())
                {
                    removeTagRuleName_ = rule.removeTagRuleName_;
                    bitField0_ = bitField0_ & 0xffffffdf;
                } else
                {
                    ensureRemoveTagRuleNameIsMutable();
                    removeTagRuleName_.addAll(rule.removeTagRuleName_);
                }
            }
            if (!rule.addMacro_.isEmpty())
            {
                if (addMacro_.isEmpty())
                {
                    addMacro_ = rule.addMacro_;
                    bitField0_ = bitField0_ & 0xffffffbf;
                } else
                {
                    ensureAddMacroIsMutable();
                    addMacro_.addAll(rule.addMacro_);
                }
            }
            if (!rule.removeMacro_.isEmpty())
            {
                if (removeMacro_.isEmpty())
                {
                    removeMacro_ = rule.removeMacro_;
                    bitField0_ = bitField0_ & 0xffffff7f;
                } else
                {
                    ensureRemoveMacroIsMutable();
                    removeMacro_.addAll(rule.removeMacro_);
                }
            }
            if (!rule.addMacroRuleName_.isEmpty())
            {
                if (addMacroRuleName_.isEmpty())
                {
                    addMacroRuleName_ = rule.addMacroRuleName_;
                    bitField0_ = bitField0_ & 0xfffffeff;
                } else
                {
                    ensureAddMacroRuleNameIsMutable();
                    addMacroRuleName_.addAll(rule.addMacroRuleName_);
                }
            }
            if (!rule.removeMacroRuleName_.isEmpty())
            {
                if (removeMacroRuleName_.isEmpty())
                {
                    removeMacroRuleName_ = rule.removeMacroRuleName_;
                    bitField0_ = bitField0_ & 0xfffffdff;
                } else
                {
                    ensureRemoveMacroRuleNameIsMutable();
                    removeMacroRuleName_.addAll(rule.removeMacroRuleName_);
                }
            }
            setUnknownFields(getUnknownFields().concat(rule.unknownFields));
            return this;
        }

        public Rule.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (Rule)Rule.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((Rule) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (Rule)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((Rule) (codedinputstream1)));
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
            return mergeFrom((Rule)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Rule.Builder setAddMacro(int i, int j)
        {
            ensureAddMacroIsMutable();
            addMacro_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule.Builder setAddMacroRuleName(int i, int j)
        {
            ensureAddMacroRuleNameIsMutable();
            addMacroRuleName_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule.Builder setAddTag(int i, int j)
        {
            ensureAddTagIsMutable();
            addTag_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule.Builder setAddTagRuleName(int i, int j)
        {
            ensureAddTagRuleNameIsMutable();
            addTagRuleName_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule.Builder setNegativePredicate(int i, int j)
        {
            ensureNegativePredicateIsMutable();
            negativePredicate_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule.Builder setPositivePredicate(int i, int j)
        {
            ensurePositivePredicateIsMutable();
            positivePredicate_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule.Builder setRemoveMacro(int i, int j)
        {
            ensureRemoveMacroIsMutable();
            removeMacro_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule.Builder setRemoveMacroRuleName(int i, int j)
        {
            ensureRemoveMacroRuleNameIsMutable();
            removeMacroRuleName_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule.Builder setRemoveTag(int i, int j)
        {
            ensureRemoveTagIsMutable();
            removeTag_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule.Builder setRemoveTagRuleName(int i, int j)
        {
            ensureRemoveTagRuleNameIsMutable();
            removeTagRuleName_.set(i, Integer.valueOf(j));
            return this;
        }


        private Rule.Builder()
        {
            positivePredicate_ = Collections.emptyList();
            negativePredicate_ = Collections.emptyList();
            addTag_ = Collections.emptyList();
            removeTag_ = Collections.emptyList();
            addTagRuleName_ = Collections.emptyList();
            removeTagRuleName_ = Collections.emptyList();
            addMacro_ = Collections.emptyList();
            removeMacro_ = Collections.emptyList();
            addMacroRuleName_ = Collections.emptyList();
            removeMacroRuleName_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }
    }

    public static interface RuleOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract int getAddMacro(int i);

        public abstract int getAddMacroCount();

        public abstract List getAddMacroList();

        public abstract int getAddMacroRuleName(int i);

        public abstract int getAddMacroRuleNameCount();

        public abstract List getAddMacroRuleNameList();

        public abstract int getAddTag(int i);

        public abstract int getAddTagCount();

        public abstract List getAddTagList();

        public abstract int getAddTagRuleName(int i);

        public abstract int getAddTagRuleNameCount();

        public abstract List getAddTagRuleNameList();

        public abstract int getNegativePredicate(int i);

        public abstract int getNegativePredicateCount();

        public abstract List getNegativePredicateList();

        public abstract int getPositivePredicate(int i);

        public abstract int getPositivePredicateCount();

        public abstract List getPositivePredicateList();

        public abstract int getRemoveMacro(int i);

        public abstract int getRemoveMacroCount();

        public abstract List getRemoveMacroList();

        public abstract int getRemoveMacroRuleName(int i);

        public abstract int getRemoveMacroRuleNameCount();

        public abstract List getRemoveMacroRuleNameList();

        public abstract int getRemoveTag(int i);

        public abstract int getRemoveTagCount();

        public abstract List getRemoveTagList();

        public abstract int getRemoveTagRuleName(int i);

        public abstract int getRemoveTagRuleNameCount();

        public abstract List getRemoveTagRuleNameList();
    }

    public static final class ServingValue extends GeneratedMessageLite
        implements ServingValueOrBuilder
    {

        public static final int EXT_FIELD_NUMBER = 101;
        public static final int LIST_ITEM_FIELD_NUMBER = 1;
        public static final int MACRO_NAME_REFERENCE_FIELD_NUMBER = 6;
        public static final int MACRO_REFERENCE_FIELD_NUMBER = 4;
        public static final int MAP_KEY_FIELD_NUMBER = 2;
        public static final int MAP_VALUE_FIELD_NUMBER = 3;
        public static Parser PARSER = new AbstractParser() {

            public ServingValue parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new ServingValue(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int TEMPLATE_TOKEN_FIELD_NUMBER = 5;
        private static final ServingValue defaultInstance;
        public static final com.google.tagmanager.protobuf.GeneratedMessageLite.GeneratedExtension ext;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private List listItem_;
        private int macroNameReference_;
        private int macroReference_;
        private List mapKey_;
        private List mapValue_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List templateToken_;
        private final ByteString unknownFields;

        public static ServingValue getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            listItem_ = Collections.emptyList();
            mapKey_ = Collections.emptyList();
            mapValue_ = Collections.emptyList();
            macroReference_ = 0;
            templateToken_ = Collections.emptyList();
            macroNameReference_ = 0;
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(ServingValue servingvalue)
        {
            return newBuilder().mergeFrom(servingvalue);
        }

        public static ServingValue parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (ServingValue)PARSER.parseDelimitedFrom(inputstream);
        }

        public static ServingValue parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ServingValue)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static ServingValue parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (ServingValue)PARSER.parseFrom(bytestring);
        }

        public static ServingValue parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (ServingValue)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static ServingValue parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (ServingValue)PARSER.parseFrom(codedinputstream);
        }

        public static ServingValue parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ServingValue)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static ServingValue parseFrom(InputStream inputstream)
            throws IOException
        {
            return (ServingValue)PARSER.parseFrom(inputstream);
        }

        public static ServingValue parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ServingValue)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static ServingValue parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (ServingValue)PARSER.parseFrom(abyte0);
        }

        public static ServingValue parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (ServingValue)PARSER.parseFrom(abyte0, extensionregistrylite);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (!(obj instanceof ServingValue))
            {
                return super.equals(obj);
            }
            obj = (ServingValue)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (true && getListItemList().equals(((ServingValue) (obj)).getListItemList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getMapKeyList().equals(((ServingValue) (obj)).getMapKeyList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getMapValueList().equals(((ServingValue) (obj)).getMapValueList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && hasMacroReference() == ((ServingValue) (obj)).hasMacroReference())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasMacroReference())
            {
                if (flag && getMacroReference() == ((ServingValue) (obj)).getMacroReference())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && getTemplateTokenList().equals(((ServingValue) (obj)).getTemplateTokenList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && hasMacroNameReference() == ((ServingValue) (obj)).hasMacroNameReference())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag3 = flag2;
            if (hasMacroNameReference())
            {
                if (flag2 && getMacroNameReference() == ((ServingValue) (obj)).getMacroNameReference())
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
            return flag3;
        }

        public ServingValue getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getListItem(int i)
        {
            return ((Integer)listItem_.get(i)).intValue();
        }

        public int getListItemCount()
        {
            return listItem_.size();
        }

        public List getListItemList()
        {
            return listItem_;
        }

        public int getMacroNameReference()
        {
            return macroNameReference_;
        }

        public int getMacroReference()
        {
            return macroReference_;
        }

        public int getMapKey(int i)
        {
            return ((Integer)mapKey_.get(i)).intValue();
        }

        public int getMapKeyCount()
        {
            return mapKey_.size();
        }

        public List getMapKeyList()
        {
            return mapKey_;
        }

        public int getMapValue(int i)
        {
            return ((Integer)mapValue_.get(i)).intValue();
        }

        public int getMapValueCount()
        {
            return mapValue_.size();
        }

        public List getMapValueList()
        {
            return mapValue_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            for (int j = 0; j < listItem_.size(); j++)
            {
                i += CodedOutputStream.computeInt32SizeNoTag(((Integer)listItem_.get(j)).intValue());
            }

            int l1 = getListItemList().size();
            int k = 0;
            for (int l = 0; l < mapKey_.size(); l++)
            {
                k += CodedOutputStream.computeInt32SizeNoTag(((Integer)mapKey_.get(l)).intValue());
            }

            int i2 = getMapKeyList().size();
            int k1 = 0;
            for (int i1 = 0; i1 < mapValue_.size(); i1++)
            {
                k1 += CodedOutputStream.computeInt32SizeNoTag(((Integer)mapValue_.get(i1)).intValue());
            }

            k = 0 + i + l1 * 1 + k + i2 * 1 + k1 + getMapValueList().size() * 1;
            i = k;
            if ((bitField0_ & 1) == 1)
            {
                i = k + CodedOutputStream.computeInt32Size(4, macroReference_);
            }
            int j1 = 0;
            for (k = 0; k < templateToken_.size(); k++)
            {
                j1 += CodedOutputStream.computeInt32SizeNoTag(((Integer)templateToken_.get(k)).intValue());
            }

            k = i + j1 + getTemplateTokenList().size() * 1;
            i = k;
            if ((bitField0_ & 2) == 2)
            {
                i = k + CodedOutputStream.computeInt32Size(6, macroNameReference_);
            }
            i += unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public int getTemplateToken(int i)
        {
            return ((Integer)templateToken_.get(i)).intValue();
        }

        public int getTemplateTokenCount()
        {
            return templateToken_.size();
        }

        public List getTemplateTokenList()
        {
            return templateToken_;
        }

        public boolean hasMacroNameReference()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasMacroReference()
        {
            return (bitField0_ & 1) == 1;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Serving$ServingValue.hashCode() + 779;
            int i = j;
            if (getListItemCount() > 0)
            {
                i = (j * 37 + 1) * 53 + getListItemList().hashCode();
            }
            j = i;
            if (getMapKeyCount() > 0)
            {
                j = (i * 37 + 2) * 53 + getMapKeyList().hashCode();
            }
            i = j;
            if (getMapValueCount() > 0)
            {
                i = (j * 37 + 3) * 53 + getMapValueList().hashCode();
            }
            j = i;
            if (hasMacroReference())
            {
                j = (i * 37 + 4) * 53 + getMacroReference();
            }
            i = j;
            if (getTemplateTokenCount() > 0)
            {
                i = (j * 37 + 5) * 53 + getTemplateTokenList().hashCode();
            }
            j = i;
            if (hasMacroNameReference())
            {
                j = (i * 37 + 6) * 53 + getMacroNameReference();
            }
            i = j * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$ServingValue");
            }
            return mutableDefault;
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
            for (int i = 0; i < listItem_.size(); i++)
            {
                codedoutputstream.writeInt32(1, ((Integer)listItem_.get(i)).intValue());
            }

            for (int j = 0; j < mapKey_.size(); j++)
            {
                codedoutputstream.writeInt32(2, ((Integer)mapKey_.get(j)).intValue());
            }

            for (int k = 0; k < mapValue_.size(); k++)
            {
                codedoutputstream.writeInt32(3, ((Integer)mapValue_.get(k)).intValue());
            }

            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeInt32(4, macroReference_);
            }
            for (int l = 0; l < templateToken_.size(); l++)
            {
                codedoutputstream.writeInt32(5, ((Integer)templateToken_.get(l)).intValue());
            }

            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeInt32(6, macroNameReference_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new ServingValue(true);
            defaultInstance.initFields();
            ext = GeneratedMessageLite.newSingularGeneratedExtension(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, 101, com.google.tagmanager.protobuf.WireFormat.FieldType.MESSAGE, com/google/analytics/containertag/proto/Serving$ServingValue);
        }



/*
        static List access$1202(ServingValue servingvalue, List list)
        {
            servingvalue.listItem_ = list;
            return list;
        }

*/



/*
        static List access$1302(ServingValue servingvalue, List list)
        {
            servingvalue.mapKey_ = list;
            return list;
        }

*/



/*
        static List access$1402(ServingValue servingvalue, List list)
        {
            servingvalue.mapValue_ = list;
            return list;
        }

*/


/*
        static int access$1502(ServingValue servingvalue, int i)
        {
            servingvalue.macroReference_ = i;
            return i;
        }

*/



/*
        static List access$1602(ServingValue servingvalue, List list)
        {
            servingvalue.templateToken_ = list;
            return list;
        }

*/


/*
        static int access$1702(ServingValue servingvalue, int i)
        {
            servingvalue.macroNameReference_ = i;
            return i;
        }

*/


/*
        static int access$1802(ServingValue servingvalue, int i)
        {
            servingvalue.bitField0_ = i;
            return i;
        }

*/


        private ServingValue(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            int i;
            boolean flag;
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            initFields();
            i = 0;
            output = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(output);
            flag = false;
_L37:
            if (flag) goto _L2; else goto _L1
_L1:
            int j;
            int k;
            int l;
            k = i;
            j = i;
            l = i;
            int i1 = codedinputstream.readTag();
            i1;
            JVM INSTR lookupswitch 11: default 1511
        //                       0: 1514
        //                       8: 187
        //                       10: 373
        //                       16: 556
        //                       18: 633
        //                       24: 795
        //                       26: 872
        //                       32: 1034
        //                       40: 1079
        //                       42: 1159
        //                       48: 1324;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L3:
            k = i;
            j = i;
            l = i;
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i1))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            i1 = i;
            if ((i & 1) == 1) goto _L16; else goto _L15
_L15:
            k = i;
            j = i;
            l = i;
            listItem_ = new ArrayList();
            i1 = i | 1;
_L16:
            k = i1;
            j = i1;
            l = i1;
            listItem_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            j = k;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            if ((j & 1) == 1)
            {
                listItem_ = Collections.unmodifiableList(listItem_);
            }
            if ((j & 2) == 2)
            {
                mapKey_ = Collections.unmodifiableList(mapKey_);
            }
            if ((j & 4) == 4)
            {
                mapValue_ = Collections.unmodifiableList(mapValue_);
            }
            if ((j & 0x10) == 16)
            {
                templateToken_ = Collections.unmodifiableList(templateToken_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L35:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            k = i;
            j = i;
            l = i;
            int j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 1) == 1)
            {
                break MISSING_BLOCK_LABEL_459;
            }
            k = i;
            j = i;
            i1 = i;
            l = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_459;
            }
            k = i;
            j = i;
            l = i;
            listItem_ = new ArrayList();
            i1 = i | 1;
_L19:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0) goto _L18; else goto _L17
_L17:
            k = i1;
            j = i1;
            l = i1;
            listItem_.add(Integer.valueOf(codedinputstream.readInt32()));
              goto _L19
            codedinputstream;
            j = l;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L18:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L7:
            i1 = i;
            if ((i & 2) == 2) goto _L21; else goto _L20
_L20:
            k = i;
            j = i;
            l = i;
            mapKey_ = new ArrayList();
            i1 = i | 2;
_L21:
            k = i1;
            j = i1;
            l = i1;
            mapKey_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L8:
            k = i;
            j = i;
            l = i;
            j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 2) == 2)
            {
                break MISSING_BLOCK_LABEL_719;
            }
            k = i;
            j = i;
            l = i;
            i1 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_719;
            }
            k = i;
            j = i;
            l = i;
            mapKey_ = new ArrayList();
            i1 = i | 2;
_L23:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i1;
            j = i1;
            l = i1;
            mapKey_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L23; else goto _L22
_L22:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L9:
            i1 = i;
            if ((i & 4) == 4) goto _L25; else goto _L24
_L24:
            k = i;
            j = i;
            l = i;
            mapValue_ = new ArrayList();
            i1 = i | 4;
_L25:
            k = i1;
            j = i1;
            l = i1;
            mapValue_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L10:
            k = i;
            j = i;
            l = i;
            j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 4) == 4)
            {
                break MISSING_BLOCK_LABEL_958;
            }
            k = i;
            j = i;
            l = i;
            i1 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_958;
            }
            k = i;
            j = i;
            l = i;
            mapValue_ = new ArrayList();
            i1 = i | 4;
_L27:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i1;
            j = i1;
            l = i1;
            mapValue_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L27; else goto _L26
_L26:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L11:
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 1;
            k = i;
            j = i;
            l = i;
            macroReference_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L12:
            i1 = i;
            if ((i & 0x10) == 16) goto _L29; else goto _L28
_L28:
            k = i;
            j = i;
            l = i;
            templateToken_ = new ArrayList();
            i1 = i | 0x10;
_L29:
            k = i1;
            j = i1;
            l = i1;
            templateToken_.add(Integer.valueOf(codedinputstream.readInt32()));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L13:
            k = i;
            j = i;
            l = i;
            j1 = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            i1 = i;
            if ((i & 0x10) == 16)
            {
                break MISSING_BLOCK_LABEL_1248;
            }
            k = i;
            j = i;
            l = i;
            i1 = i;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break MISSING_BLOCK_LABEL_1248;
            }
            k = i;
            j = i;
            l = i;
            templateToken_ = new ArrayList();
            i1 = i | 0x10;
_L31:
            k = i1;
            j = i1;
            l = i1;
            if (codedinputstream.getBytesUntilLimit() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = i1;
            j = i1;
            l = i1;
            templateToken_.add(Integer.valueOf(codedinputstream.readInt32()));
            if (true) goto _L31; else goto _L30
_L30:
            k = i1;
            j = i1;
            l = i1;
            codedinputstream.popLimit(j1);
            i = i1;
            continue; /* Loop/switch isn't completed */
_L14:
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 2;
            k = i;
            j = i;
            l = i;
            macroNameReference_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L2:
            if ((i & 1) == 1)
            {
                listItem_ = Collections.unmodifiableList(listItem_);
            }
            if ((i & 2) == 2)
            {
                mapKey_ = Collections.unmodifiableList(mapKey_);
            }
            if ((i & 4) == 4)
            {
                mapValue_ = Collections.unmodifiableList(mapValue_);
            }
            if ((i & 0x10) == 16)
            {
                templateToken_ = Collections.unmodifiableList(templateToken_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L33:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L33; else goto _L32
_L32:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L35; else goto _L34
_L34:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L37; else goto _L36
_L36:
        }


        private ServingValue(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private ServingValue(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class ServingValue.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements ServingValueOrBuilder
    {

        private int bitField0_;
        private List listItem_;
        private int macroNameReference_;
        private int macroReference_;
        private List mapKey_;
        private List mapValue_;
        private List templateToken_;

        private static ServingValue.Builder create()
        {
            return new ServingValue.Builder();
        }

        private void ensureListItemIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                listItem_ = new ArrayList(listItem_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private void ensureMapKeyIsMutable()
        {
            if ((bitField0_ & 2) != 2)
            {
                mapKey_ = new ArrayList(mapKey_);
                bitField0_ = bitField0_ | 2;
            }
        }

        private void ensureMapValueIsMutable()
        {
            if ((bitField0_ & 4) != 4)
            {
                mapValue_ = new ArrayList(mapValue_);
                bitField0_ = bitField0_ | 4;
            }
        }

        private void ensureTemplateTokenIsMutable()
        {
            if ((bitField0_ & 0x10) != 16)
            {
                templateToken_ = new ArrayList(templateToken_);
                bitField0_ = bitField0_ | 0x10;
            }
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public ServingValue.Builder addAllListItem(Iterable iterable)
        {
            ensureListItemIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, listItem_);
            return this;
        }

        public ServingValue.Builder addAllMapKey(Iterable iterable)
        {
            ensureMapKeyIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, mapKey_);
            return this;
        }

        public ServingValue.Builder addAllMapValue(Iterable iterable)
        {
            ensureMapValueIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, mapValue_);
            return this;
        }

        public ServingValue.Builder addAllTemplateToken(Iterable iterable)
        {
            ensureTemplateTokenIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, templateToken_);
            return this;
        }

        public ServingValue.Builder addListItem(int i)
        {
            ensureListItemIsMutable();
            listItem_.add(Integer.valueOf(i));
            return this;
        }

        public ServingValue.Builder addMapKey(int i)
        {
            ensureMapKeyIsMutable();
            mapKey_.add(Integer.valueOf(i));
            return this;
        }

        public ServingValue.Builder addMapValue(int i)
        {
            ensureMapValueIsMutable();
            mapValue_.add(Integer.valueOf(i));
            return this;
        }

        public ServingValue.Builder addTemplateToken(int i)
        {
            ensureTemplateTokenIsMutable();
            templateToken_.add(Integer.valueOf(i));
            return this;
        }

        public ServingValue build()
        {
            ServingValue servingvalue = buildPartial();
            if (!servingvalue.isInitialized())
            {
                throw newUninitializedMessageException(servingvalue);
            } else
            {
                return servingvalue;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public ServingValue buildPartial()
        {
            ServingValue servingvalue = new ServingValue(this);
            int k = bitField0_;
            int i = 0;
            if ((bitField0_ & 1) == 1)
            {
                listItem_ = Collections.unmodifiableList(listItem_);
                bitField0_ = bitField0_ & -2;
            }
            servingvalue.listItem_ = listItem_;
            if ((bitField0_ & 2) == 2)
            {
                mapKey_ = Collections.unmodifiableList(mapKey_);
                bitField0_ = bitField0_ & -3;
            }
            servingvalue.mapKey_ = mapKey_;
            if ((bitField0_ & 4) == 4)
            {
                mapValue_ = Collections.unmodifiableList(mapValue_);
                bitField0_ = bitField0_ & -5;
            }
            servingvalue.mapValue_ = mapValue_;
            if ((k & 8) == 8)
            {
                i = false | true;
            }
            servingvalue.macroReference_ = macroReference_;
            if ((bitField0_ & 0x10) == 16)
            {
                templateToken_ = Collections.unmodifiableList(templateToken_);
                bitField0_ = bitField0_ & 0xffffffef;
            }
            servingvalue.templateToken_ = templateToken_;
            int j = i;
            if ((k & 0x20) == 32)
            {
                j = i | 2;
            }
            servingvalue.macroNameReference_ = macroNameReference_;
            servingvalue.bitField0_ = j;
            return servingvalue;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public ServingValue.Builder clear()
        {
            super.clear();
            listItem_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            mapKey_ = Collections.emptyList();
            bitField0_ = bitField0_ & -3;
            mapValue_ = Collections.emptyList();
            bitField0_ = bitField0_ & -5;
            macroReference_ = 0;
            bitField0_ = bitField0_ & -9;
            templateToken_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffef;
            macroNameReference_ = 0;
            bitField0_ = bitField0_ & 0xffffffdf;
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

        public ServingValue.Builder clearListItem()
        {
            listItem_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public ServingValue.Builder clearMacroNameReference()
        {
            bitField0_ = bitField0_ & 0xffffffdf;
            macroNameReference_ = 0;
            return this;
        }

        public ServingValue.Builder clearMacroReference()
        {
            bitField0_ = bitField0_ & -9;
            macroReference_ = 0;
            return this;
        }

        public ServingValue.Builder clearMapKey()
        {
            mapKey_ = Collections.emptyList();
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public ServingValue.Builder clearMapValue()
        {
            mapValue_ = Collections.emptyList();
            bitField0_ = bitField0_ & -5;
            return this;
        }

        public ServingValue.Builder clearTemplateToken()
        {
            templateToken_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffef;
            return this;
        }

        public ServingValue.Builder clone()
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

        public ServingValue getDefaultInstanceForType()
        {
            return ServingValue.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public int getListItem(int i)
        {
            return ((Integer)listItem_.get(i)).intValue();
        }

        public int getListItemCount()
        {
            return listItem_.size();
        }

        public List getListItemList()
        {
            return Collections.unmodifiableList(listItem_);
        }

        public int getMacroNameReference()
        {
            return macroNameReference_;
        }

        public int getMacroReference()
        {
            return macroReference_;
        }

        public int getMapKey(int i)
        {
            return ((Integer)mapKey_.get(i)).intValue();
        }

        public int getMapKeyCount()
        {
            return mapKey_.size();
        }

        public List getMapKeyList()
        {
            return Collections.unmodifiableList(mapKey_);
        }

        public int getMapValue(int i)
        {
            return ((Integer)mapValue_.get(i)).intValue();
        }

        public int getMapValueCount()
        {
            return mapValue_.size();
        }

        public List getMapValueList()
        {
            return Collections.unmodifiableList(mapValue_);
        }

        public int getTemplateToken(int i)
        {
            return ((Integer)templateToken_.get(i)).intValue();
        }

        public int getTemplateTokenCount()
        {
            return templateToken_.size();
        }

        public List getTemplateTokenList()
        {
            return Collections.unmodifiableList(templateToken_);
        }

        public boolean hasMacroNameReference()
        {
            return (bitField0_ & 0x20) == 32;
        }

        public boolean hasMacroReference()
        {
            return (bitField0_ & 8) == 8;
        }

        public final boolean isInitialized()
        {
            return true;
        }

        public ServingValue.Builder mergeFrom(ServingValue servingvalue)
        {
            if (servingvalue == ServingValue.getDefaultInstance())
            {
                return this;
            }
            if (!servingvalue.listItem_.isEmpty())
            {
                if (listItem_.isEmpty())
                {
                    listItem_ = servingvalue.listItem_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensureListItemIsMutable();
                    listItem_.addAll(servingvalue.listItem_);
                }
            }
            if (!servingvalue.mapKey_.isEmpty())
            {
                if (mapKey_.isEmpty())
                {
                    mapKey_ = servingvalue.mapKey_;
                    bitField0_ = bitField0_ & -3;
                } else
                {
                    ensureMapKeyIsMutable();
                    mapKey_.addAll(servingvalue.mapKey_);
                }
            }
            if (!servingvalue.mapValue_.isEmpty())
            {
                if (mapValue_.isEmpty())
                {
                    mapValue_ = servingvalue.mapValue_;
                    bitField0_ = bitField0_ & -5;
                } else
                {
                    ensureMapValueIsMutable();
                    mapValue_.addAll(servingvalue.mapValue_);
                }
            }
            if (servingvalue.hasMacroReference())
            {
                setMacroReference(servingvalue.getMacroReference());
            }
            if (!servingvalue.templateToken_.isEmpty())
            {
                if (templateToken_.isEmpty())
                {
                    templateToken_ = servingvalue.templateToken_;
                    bitField0_ = bitField0_ & 0xffffffef;
                } else
                {
                    ensureTemplateTokenIsMutable();
                    templateToken_.addAll(servingvalue.templateToken_);
                }
            }
            if (servingvalue.hasMacroNameReference())
            {
                setMacroNameReference(servingvalue.getMacroNameReference());
            }
            setUnknownFields(getUnknownFields().concat(servingvalue.unknownFields));
            return this;
        }

        public ServingValue.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (ServingValue)ServingValue.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((ServingValue) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (ServingValue)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((ServingValue) (codedinputstream1)));
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
            return mergeFrom((ServingValue)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public ServingValue.Builder setListItem(int i, int j)
        {
            ensureListItemIsMutable();
            listItem_.set(i, Integer.valueOf(j));
            return this;
        }

        public ServingValue.Builder setMacroNameReference(int i)
        {
            bitField0_ = bitField0_ | 0x20;
            macroNameReference_ = i;
            return this;
        }

        public ServingValue.Builder setMacroReference(int i)
        {
            bitField0_ = bitField0_ | 8;
            macroReference_ = i;
            return this;
        }

        public ServingValue.Builder setMapKey(int i, int j)
        {
            ensureMapKeyIsMutable();
            mapKey_.set(i, Integer.valueOf(j));
            return this;
        }

        public ServingValue.Builder setMapValue(int i, int j)
        {
            ensureMapValueIsMutable();
            mapValue_.set(i, Integer.valueOf(j));
            return this;
        }

        public ServingValue.Builder setTemplateToken(int i, int j)
        {
            ensureTemplateTokenIsMutable();
            templateToken_.set(i, Integer.valueOf(j));
            return this;
        }


        private ServingValue.Builder()
        {
            listItem_ = Collections.emptyList();
            mapKey_ = Collections.emptyList();
            mapValue_ = Collections.emptyList();
            templateToken_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }
    }

    public static interface ServingValueOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract int getListItem(int i);

        public abstract int getListItemCount();

        public abstract List getListItemList();

        public abstract int getMacroNameReference();

        public abstract int getMacroReference();

        public abstract int getMapKey(int i);

        public abstract int getMapKeyCount();

        public abstract List getMapKeyList();

        public abstract int getMapValue(int i);

        public abstract int getMapValueCount();

        public abstract List getMapValueList();

        public abstract int getTemplateToken(int i);

        public abstract int getTemplateTokenCount();

        public abstract List getTemplateTokenList();

        public abstract boolean hasMacroNameReference();

        public abstract boolean hasMacroReference();
    }


    private Serving()
    {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionregistrylite)
    {
        extensionregistrylite.add(ServingValue.ext);
    }

}
