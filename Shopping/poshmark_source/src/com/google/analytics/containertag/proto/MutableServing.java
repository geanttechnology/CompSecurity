// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.AbstractMutableMessageLite;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.LazyStringArrayList;
import com.google.tagmanager.protobuf.LazyStringList;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MutableServing
{
    public static final class CacheOption extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int EXPIRATION_SECONDS_FIELD_NUMBER = 2;
        public static final int GCACHE_EXPIRATION_SECONDS_FIELD_NUMBER = 3;
        public static final int LEVEL_FIELD_NUMBER = 1;
        public static Parser PARSER;
        private static final CacheOption defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private int expirationSeconds_;
        private int gcacheExpirationSeconds_;
        private CacheLevel level_;

        public static CacheOption getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            level_ = CacheLevel.NO_CACHE;
        }

        public static CacheOption newMessage()
        {
            return new CacheOption();
        }

        public CacheOption clear()
        {
            assertMutable();
            super.clear();
            level_ = CacheLevel.NO_CACHE;
            bitField0_ = bitField0_ & -2;
            expirationSeconds_ = 0;
            bitField0_ = bitField0_ & -3;
            gcacheExpirationSeconds_ = 0;
            bitField0_ = bitField0_ & -5;
            return this;
        }

        public volatile GeneratedMutableMessageLite clear()
        {
            return clear();
        }

        public volatile MutableMessageLite clear()
        {
            return clear();
        }

        public CacheOption clearExpirationSeconds()
        {
            assertMutable();
            bitField0_ = bitField0_ & -3;
            expirationSeconds_ = 0;
            return this;
        }

        public CacheOption clearGcacheExpirationSeconds()
        {
            assertMutable();
            bitField0_ = bitField0_ & -5;
            gcacheExpirationSeconds_ = 0;
            return this;
        }

        public CacheOption clearLevel()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            level_ = CacheLevel.NO_CACHE;
            return this;
        }

        public CacheOption clone()
        {
            return newMessageForType().mergeFrom(this);
        }

        public volatile MutableMessageLite clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
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

        public final CacheOption getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile GeneratedMutableMessageLite getDefaultInstanceForType()
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
            int j = 0;
            if ((bitField0_ & 1) == 1)
            {
                j = 0 + CodedOutputStream.computeEnumSize(1, level_.getNumber());
            }
            int i = j;
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
            cachedSize = i;
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
            int j = 41;
            if (hasLevel())
            {
                j = 0x13a46 + Internal.hashEnum(getLevel());
            }
            int i = j;
            if (hasExpirationSeconds())
            {
                i = (j * 37 + 2) * 53 + getExpirationSeconds();
            }
            j = i;
            if (hasGcacheExpirationSeconds())
            {
                j = (i * 37 + 3) * 53 + getGcacheExpirationSeconds();
            }
            return j * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$CacheOption");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            return true;
        }

        public CacheOption mergeFrom(CacheOption cacheoption)
        {
            if (this == cacheoption)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (cacheoption == getDefaultInstance())
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
            unknownFields = unknownFields.concat(cacheoption.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((CacheOption)generatedmutablemessagelite);
        }

        public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        {
            assertMutable();
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            CacheLevel cachelevel;
            boolean flag;
            int i;
            int j;
            try
            {
                output = ByteString.newOutput();
                codedoutputstream = CodedOutputStream.newInstance(output);
            }
            // Misplaced declaration of an exception variable
            catch (CodedInputStream codedinputstream)
            {
                return false;
            }
            flag = false;
            if (flag) goto _L2; else goto _L1
_L1:
            i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 4: default 202
        //                       0: 205
        //                       8: 91
        //                       16: 145
        //                       24: 166;
               goto _L3 _L4 _L5 _L6 _L7
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            j = codedinputstream.readEnum();
            cachelevel = CacheLevel.valueOf(j);
            if (cachelevel != null) goto _L9; else goto _L8
_L8:
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeRawVarint32(j);
            continue; /* Loop/switch isn't completed */
_L9:
            bitField0_ = bitField0_ | 1;
            level_ = cachelevel;
            continue; /* Loop/switch isn't completed */
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
            return true;
_L4:
            flag = true;
            if (true) goto _L11; else goto _L10
_L11:
            break MISSING_BLOCK_LABEL_17;
_L10:
        }

        public CacheOption newMessageForType()
        {
            return new CacheOption();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public CacheOption setExpirationSeconds(int i)
        {
            assertMutable();
            bitField0_ = bitField0_ | 2;
            expirationSeconds_ = i;
            return this;
        }

        public CacheOption setGcacheExpirationSeconds(int i)
        {
            assertMutable();
            bitField0_ = bitField0_ | 4;
            gcacheExpirationSeconds_ = i;
            return this;
        }

        public CacheOption setLevel(CacheLevel cachelevel)
        {
            assertMutable();
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

        protected Object writeReplace()
            throws ObjectStreamException
        {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedoutputstream)
            throws IOException
        {
            int i = codedoutputstream.getTotalBytesWritten();
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
            int j = codedoutputstream.getTotalBytesWritten();
            if (getCachedSize() != j - i)
            {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            } else
            {
                return;
            }
        }

        static 
        {
            defaultInstance = new CacheOption(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private CacheOption()
        {
            level_ = CacheLevel.NO_CACHE;
            initFields();
        }

        private CacheOption(boolean flag)
        {
            level_ = CacheLevel.NO_CACHE;
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
            return (CacheOption.CacheLevel)Enum.valueOf(com/google/analytics/containertag/proto/MutableServing$CacheOption$CacheLevel, s);
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

    public static final class Container extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int CONTAINER_ID_FIELD_NUMBER = 3;
        public static final int JS_RESOURCE_FIELD_NUMBER = 1;
        public static Parser PARSER;
        public static final int STATE_FIELD_NUMBER = 4;
        public static final int VERSION_FIELD_NUMBER = 5;
        private static final Container defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private Object containerId_;
        private Resource jsResource_;
        private ResourceState state_;
        private Object version_;

        private void ensureJsResourceInitialized()
        {
            if (jsResource_ == Resource.getDefaultInstance())
            {
                jsResource_ = Resource.newMessage();
            }
        }

        public static Container getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            jsResource_ = Resource.getDefaultInstance();
            state_ = ResourceState.PREVIEW;
        }

        public static Container newMessage()
        {
            return new Container();
        }

        public Container clear()
        {
            assertMutable();
            super.clear();
            if (jsResource_ != Resource.getDefaultInstance())
            {
                jsResource_.clear();
            }
            bitField0_ = bitField0_ & -2;
            containerId_ = Internal.EMPTY_BYTE_ARRAY;
            bitField0_ = bitField0_ & -3;
            state_ = ResourceState.PREVIEW;
            bitField0_ = bitField0_ & -5;
            version_ = Internal.EMPTY_BYTE_ARRAY;
            bitField0_ = bitField0_ & -9;
            return this;
        }

        public volatile GeneratedMutableMessageLite clear()
        {
            return clear();
        }

        public volatile MutableMessageLite clear()
        {
            return clear();
        }

        public Container clearContainerId()
        {
            assertMutable();
            bitField0_ = bitField0_ & -3;
            containerId_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Container clearJsResource()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            if (jsResource_ != Resource.getDefaultInstance())
            {
                jsResource_.clear();
            }
            return this;
        }

        public Container clearState()
        {
            assertMutable();
            bitField0_ = bitField0_ & -5;
            state_ = ResourceState.PREVIEW;
            return this;
        }

        public Container clearVersion()
        {
            assertMutable();
            bitField0_ = bitField0_ & -9;
            version_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Container clone()
        {
            return newMessageForType().mergeFrom(this);
        }

        public volatile MutableMessageLite clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
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
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                containerId_ = s;
            }
            return s;
        }

        public byte[] getContainerIdAsBytes()
        {
            byte abyte0[] = ((byte []) (containerId_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                containerId_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
            }
        }

        public final Container getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile GeneratedMutableMessageLite getDefaultInstanceForType()
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

        public Resource getMutableJsResource()
        {
            assertMutable();
            ensureJsResourceInitialized();
            bitField0_ = bitField0_ | 1;
            return jsResource_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public int getSerializedSize()
        {
            int j = 0 + CodedOutputStream.computeMessageSize(1, jsResource_) + CodedOutputStream.computeByteArraySize(3, getContainerIdAsBytes()) + CodedOutputStream.computeEnumSize(4, state_.getNumber());
            int i = j;
            if ((bitField0_ & 8) == 8)
            {
                i = j + CodedOutputStream.computeByteArraySize(5, getVersionAsBytes());
            }
            i += unknownFields.size();
            cachedSize = i;
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
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                version_ = s;
            }
            return s;
        }

        public byte[] getVersionAsBytes()
        {
            byte abyte0[] = ((byte []) (version_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                version_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
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
            int j = 41;
            if (hasJsResource())
            {
                j = 0x13a46 + getJsResource().hashCode();
            }
            int i = j;
            if (hasContainerId())
            {
                i = (j * 37 + 3) * 53 + getContainerId().hashCode();
            }
            j = i;
            if (hasState())
            {
                j = (i * 37 + 4) * 53 + Internal.hashEnum(getState());
            }
            i = j;
            if (hasVersion())
            {
                i = (j * 37 + 5) * 53 + getVersion().hashCode();
            }
            return i * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$Container");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            while (!hasJsResource() || !hasContainerId() || !hasState() || !getJsResource().isInitialized()) 
            {
                return false;
            }
            return true;
        }

        public Container mergeFrom(Container container)
        {
            if (this == container)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (container == getDefaultInstance())
            {
                return this;
            }
            if (container.hasJsResource())
            {
                ensureJsResourceInitialized();
                jsResource_.mergeFrom(container.getJsResource());
                bitField0_ = bitField0_ | 1;
            }
            if (container.hasContainerId())
            {
                bitField0_ = bitField0_ | 2;
                if (container.containerId_ instanceof String)
                {
                    containerId_ = container.containerId_;
                } else
                {
                    byte abyte0[] = (byte[])(byte[])container.containerId_;
                    containerId_ = Arrays.copyOf(abyte0, abyte0.length);
                }
            }
            if (container.hasState())
            {
                setState(container.getState());
            }
            if (container.hasVersion())
            {
                bitField0_ = bitField0_ | 8;
                if (container.version_ instanceof String)
                {
                    version_ = container.version_;
                } else
                {
                    byte abyte1[] = (byte[])(byte[])container.version_;
                    version_ = Arrays.copyOf(abyte1, abyte1.length);
                }
            }
            unknownFields = unknownFields.concat(container.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((Container)generatedmutablemessagelite);
        }

        public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        {
            assertMutable();
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            ResourceState resourcestate;
            boolean flag;
            int i;
            int j;
            try
            {
                output = ByteString.newOutput();
                codedoutputstream = CodedOutputStream.newInstance(output);
            }
            // Misplaced declaration of an exception variable
            catch (CodedInputStream codedinputstream)
            {
                return false;
            }
            flag = false;
            if (flag) goto _L2; else goto _L1
_L1:
            i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 5: default 250
        //                       0: 253
        //                       10: 99
        //                       26: 138
        //                       32: 159
        //                       42: 213;
               goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (jsResource_ == Resource.getDefaultInstance())
            {
                jsResource_ = Resource.newMessage();
            }
            bitField0_ = bitField0_ | 1;
            codedinputstream.readMessage(jsResource_, extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L6:
            bitField0_ = bitField0_ | 2;
            containerId_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L7:
            j = codedinputstream.readEnum();
            resourcestate = ResourceState.valueOf(j);
            if (resourcestate != null) goto _L10; else goto _L9
_L9:
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeRawVarint32(j);
            continue; /* Loop/switch isn't completed */
_L10:
            bitField0_ = bitField0_ | 4;
            state_ = resourcestate;
            continue; /* Loop/switch isn't completed */
_L8:
            bitField0_ = bitField0_ | 8;
            version_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
            return true;
_L4:
            flag = true;
            if (true) goto _L12; else goto _L11
_L12:
            break MISSING_BLOCK_LABEL_17;
_L11:
        }

        public Container newMessageForType()
        {
            return new Container();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public Container setContainerId(String s)
        {
            assertMutable();
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

        public Container setContainerIdAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                containerId_ = abyte0;
                return this;
            }
        }

        public Container setJsResource(Resource resource)
        {
            assertMutable();
            if (resource == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                jsResource_ = resource;
                return this;
            }
        }

        public Container setState(ResourceState resourcestate)
        {
            assertMutable();
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

        public Container setVersion(String s)
        {
            assertMutable();
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

        public Container setVersionAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 8;
                version_ = abyte0;
                return this;
            }
        }

        protected Object writeReplace()
            throws ObjectStreamException
        {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedoutputstream)
            throws IOException
        {
            int i = codedoutputstream.getTotalBytesWritten();
            codedoutputstream.writeMessageWithCachedSizes(1, jsResource_);
            codedoutputstream.writeByteArray(3, getContainerIdAsBytes());
            codedoutputstream.writeEnum(4, state_.getNumber());
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeByteArray(5, getVersionAsBytes());
            }
            codedoutputstream.writeRawBytes(unknownFields);
            int j = codedoutputstream.getTotalBytesWritten();
            if (getCachedSize() != j - i)
            {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            } else
            {
                return;
            }
        }

        static 
        {
            defaultInstance = new Container(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private Container()
        {
            containerId_ = Internal.EMPTY_BYTE_ARRAY;
            state_ = ResourceState.PREVIEW;
            version_ = Internal.EMPTY_BYTE_ARRAY;
            initFields();
        }

        private Container(boolean flag)
        {
            containerId_ = Internal.EMPTY_BYTE_ARRAY;
            state_ = ResourceState.PREVIEW;
            version_ = Internal.EMPTY_BYTE_ARRAY;
        }
    }

    public static final class FunctionCall extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int FUNCTION_FIELD_NUMBER = 2;
        public static final int LIVE_ONLY_FIELD_NUMBER = 6;
        public static final int NAME_FIELD_NUMBER = 4;
        public static Parser PARSER;
        public static final int PROPERTY_FIELD_NUMBER = 3;
        public static final int SERVER_SIDE_FIELD_NUMBER = 1;
        private static final FunctionCall defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private int function_;
        private boolean liveOnly_;
        private int name_;
        private List property_;
        private boolean serverSide_;

        private void ensurePropertyInitialized()
        {
            if (property_ == null)
            {
                property_ = new ArrayList();
            }
        }

        public static FunctionCall getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
        }

        public static FunctionCall newMessage()
        {
            return new FunctionCall();
        }

        public FunctionCall addAllProperty(Iterable iterable)
        {
            assertMutable();
            ensurePropertyInitialized();
            AbstractMutableMessageLite.addAll(iterable, property_);
            return this;
        }

        public FunctionCall addProperty(int i)
        {
            assertMutable();
            ensurePropertyInitialized();
            property_.add(Integer.valueOf(i));
            return this;
        }

        public FunctionCall clear()
        {
            assertMutable();
            super.clear();
            property_ = null;
            function_ = 0;
            bitField0_ = bitField0_ & -2;
            name_ = 0;
            bitField0_ = bitField0_ & -3;
            liveOnly_ = false;
            bitField0_ = bitField0_ & -5;
            serverSide_ = false;
            bitField0_ = bitField0_ & -9;
            return this;
        }

        public volatile GeneratedMutableMessageLite clear()
        {
            return clear();
        }

        public volatile MutableMessageLite clear()
        {
            return clear();
        }

        public FunctionCall clearFunction()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            function_ = 0;
            return this;
        }

        public FunctionCall clearLiveOnly()
        {
            assertMutable();
            bitField0_ = bitField0_ & -5;
            liveOnly_ = false;
            return this;
        }

        public FunctionCall clearName()
        {
            assertMutable();
            bitField0_ = bitField0_ & -3;
            name_ = 0;
            return this;
        }

        public FunctionCall clearProperty()
        {
            assertMutable();
            property_ = null;
            return this;
        }

        public FunctionCall clearServerSide()
        {
            assertMutable();
            bitField0_ = bitField0_ & -9;
            serverSide_ = false;
            return this;
        }

        public FunctionCall clone()
        {
            return newMessageForType().mergeFrom(this);
        }

        public volatile MutableMessageLite clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
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

        public final FunctionCall getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile GeneratedMutableMessageLite getDefaultInstanceForType()
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

        public List getMutablePropertyList()
        {
            assertMutable();
            ensurePropertyInitialized();
            return property_;
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
            if (property_ == null)
            {
                return 0;
            } else
            {
                return property_.size();
            }
        }

        public List getPropertyList()
        {
            if (property_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(property_);
            }
        }

        public int getSerializedSize()
        {
            int j = 0;
            int i = j;
            if (property_ != null)
            {
                i = j;
                if (property_.size() > 0)
                {
                    j = 0;
                    for (i = 0; i < property_.size(); i++)
                    {
                        j += CodedOutputStream.computeInt32SizeNoTag(((Integer)property_.get(i)).intValue());
                    }

                    i = 0 + j + getPropertyList().size() * 1;
                }
            }
            j = i + CodedOutputStream.computeInt32Size(2, function_);
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
            i = j;
            if ((bitField0_ & 8) == 8)
            {
                i = j + CodedOutputStream.computeBoolSize(1, serverSide_);
            }
            i += unknownFields.size();
            cachedSize = i;
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
            int j = 41;
            if (getPropertyCount() > 0)
            {
                j = 0x13ab0 + getPropertyList().hashCode();
            }
            int i = j;
            if (hasFunction())
            {
                i = (j * 37 + 2) * 53 + getFunction();
            }
            j = i;
            if (hasName())
            {
                j = (i * 37 + 4) * 53 + getName();
            }
            i = j;
            if (hasLiveOnly())
            {
                i = (j * 37 + 6) * 53 + Internal.hashBoolean(getLiveOnly());
            }
            j = i;
            if (hasServerSide())
            {
                j = (i * 37 + 1) * 53 + Internal.hashBoolean(getServerSide());
            }
            return j * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$FunctionCall");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            return hasFunction();
        }

        public FunctionCall mergeFrom(FunctionCall functioncall)
        {
            if (this == functioncall)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (functioncall == getDefaultInstance())
            {
                return this;
            }
            if (functioncall.hasServerSide())
            {
                setServerSide(functioncall.getServerSide());
            }
            if (functioncall.hasFunction())
            {
                setFunction(functioncall.getFunction());
            }
            if (functioncall.property_ != null && !functioncall.property_.isEmpty())
            {
                ensurePropertyInitialized();
                property_.addAll(functioncall.property_);
            }
            if (functioncall.hasName())
            {
                setName(functioncall.getName());
            }
            if (functioncall.hasLiveOnly())
            {
                setLiveOnly(functioncall.getLiveOnly());
            }
            unknownFields = unknownFields.concat(functioncall.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((FunctionCall)generatedmutablemessagelite);
        }

        public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        {
            assertMutable();
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            boolean flag;
            int i;
            try
            {
                output = ByteString.newOutput();
                codedoutputstream = CodedOutputStream.newInstance(output);
            }
            // Misplaced declaration of an exception variable
            catch (CodedInputStream codedinputstream)
            {
                return false;
            }
            flag = false;
            if (flag) goto _L2; else goto _L1
_L1:
            i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 7: default 317
        //                       0: 320
        //                       8: 115
        //                       16: 137
        //                       24: 158
        //                       26: 196
        //                       32: 260
        //                       48: 281;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            bitField0_ = bitField0_ | 8;
            serverSide_ = codedinputstream.readBool();
            continue; /* Loop/switch isn't completed */
_L6:
            bitField0_ = bitField0_ | 1;
            function_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L7:
            if (property_ == null)
            {
                property_ = new ArrayList();
            }
            property_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L8:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (property_ == null)
            {
                property_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; property_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L9:
            bitField0_ = bitField0_ | 2;
            name_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L10:
            bitField0_ = bitField0_ | 4;
            liveOnly_ = codedinputstream.readBool();
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
            return true;
_L4:
            flag = true;
            if (true) goto _L12; else goto _L11
_L12:
            break MISSING_BLOCK_LABEL_17;
_L11:
        }

        public FunctionCall newMessageForType()
        {
            return new FunctionCall();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public FunctionCall setFunction(int i)
        {
            assertMutable();
            bitField0_ = bitField0_ | 1;
            function_ = i;
            return this;
        }

        public FunctionCall setLiveOnly(boolean flag)
        {
            assertMutable();
            bitField0_ = bitField0_ | 4;
            liveOnly_ = flag;
            return this;
        }

        public FunctionCall setName(int i)
        {
            assertMutable();
            bitField0_ = bitField0_ | 2;
            name_ = i;
            return this;
        }

        public FunctionCall setProperty(int i, int j)
        {
            assertMutable();
            ensurePropertyInitialized();
            property_.set(i, Integer.valueOf(j));
            return this;
        }

        public FunctionCall setServerSide(boolean flag)
        {
            assertMutable();
            bitField0_ = bitField0_ | 8;
            serverSide_ = flag;
            return this;
        }

        protected Object writeReplace()
            throws ObjectStreamException
        {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedoutputstream)
            throws IOException
        {
            int k = codedoutputstream.getTotalBytesWritten();
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeBool(1, serverSide_);
            }
            codedoutputstream.writeInt32(2, function_);
            if (property_ != null)
            {
                for (int i = 0; i < property_.size(); i++)
                {
                    codedoutputstream.writeInt32(3, ((Integer)property_.get(i)).intValue());
                }

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
            int j = codedoutputstream.getTotalBytesWritten();
            if (getCachedSize() != j - k)
            {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            } else
            {
                return;
            }
        }

        static 
        {
            defaultInstance = new FunctionCall(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private FunctionCall()
        {
            property_ = null;
            initFields();
        }

        private FunctionCall(boolean flag)
        {
            property_ = null;
        }
    }

    public static final class OptionalResource extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static Parser PARSER;
        public static final int RESOURCE_FIELD_NUMBER = 2;
        private static final OptionalResource defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private Resource resource_;

        private void ensureResourceInitialized()
        {
            if (resource_ == Resource.getDefaultInstance())
            {
                resource_ = Resource.newMessage();
            }
        }

        public static OptionalResource getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            resource_ = Resource.getDefaultInstance();
        }

        public static OptionalResource newMessage()
        {
            return new OptionalResource();
        }

        public OptionalResource clear()
        {
            assertMutable();
            super.clear();
            if (resource_ != Resource.getDefaultInstance())
            {
                resource_.clear();
            }
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public volatile GeneratedMutableMessageLite clear()
        {
            return clear();
        }

        public volatile MutableMessageLite clear()
        {
            return clear();
        }

        public OptionalResource clearResource()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            if (resource_ != Resource.getDefaultInstance())
            {
                resource_.clear();
            }
            return this;
        }

        public OptionalResource clone()
        {
            return newMessageForType().mergeFrom(this);
        }

        public volatile MutableMessageLite clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
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

        public final OptionalResource getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile GeneratedMutableMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Resource getMutableResource()
        {
            assertMutable();
            ensureResourceInitialized();
            bitField0_ = bitField0_ | 1;
            return resource_;
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
            int i = 0;
            if ((bitField0_ & 1) == 1)
            {
                i = 0 + CodedOutputStream.computeMessageSize(2, resource_);
            }
            i += unknownFields.size();
            cachedSize = i;
            return i;
        }

        public boolean hasResource()
        {
            return (bitField0_ & 1) == 1;
        }

        public int hashCode()
        {
            int i = 41;
            if (hasResource())
            {
                i = 0x13a7b + getResource().hashCode();
            }
            return i * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$OptionalResource");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            return !hasResource() || getResource().isInitialized();
        }

        public OptionalResource mergeFrom(OptionalResource optionalresource)
        {
            if (this == optionalresource)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (optionalresource == getDefaultInstance())
            {
                return this;
            }
            if (optionalresource.hasResource())
            {
                ensureResourceInitialized();
                resource_.mergeFrom(optionalresource.getResource());
                bitField0_ = bitField0_ | 1;
            }
            unknownFields = unknownFields.concat(optionalresource.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((OptionalResource)generatedmutablemessagelite);
        }

        public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        {
            assertMutable();
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            boolean flag;
            int i;
            try
            {
                output = ByteString.newOutput();
                codedoutputstream = CodedOutputStream.newInstance(output);
            }
            // Misplaced declaration of an exception variable
            catch (CodedInputStream codedinputstream)
            {
                return false;
            }
            flag = false;
            if (flag) goto _L2; else goto _L1
_L1:
            i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 2: default 129
        //                       0: 132
        //                       18: 75;
               goto _L3 _L4 _L5
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (resource_ == Resource.getDefaultInstance())
            {
                resource_ = Resource.newMessage();
            }
            bitField0_ = bitField0_ | 1;
            codedinputstream.readMessage(resource_, extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
            return true;
_L4:
            flag = true;
            if (true) goto _L7; else goto _L6
_L7:
            break MISSING_BLOCK_LABEL_17;
_L6:
        }

        public OptionalResource newMessageForType()
        {
            return new OptionalResource();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public OptionalResource setResource(Resource resource)
        {
            assertMutable();
            if (resource == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                resource_ = resource;
                return this;
            }
        }

        protected Object writeReplace()
            throws ObjectStreamException
        {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedoutputstream)
            throws IOException
        {
            int i = codedoutputstream.getTotalBytesWritten();
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeMessageWithCachedSizes(2, resource_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
            int j = codedoutputstream.getTotalBytesWritten();
            if (getCachedSize() != j - i)
            {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            } else
            {
                return;
            }
        }

        static 
        {
            defaultInstance = new OptionalResource(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private OptionalResource()
        {
            initFields();
        }

        private OptionalResource(boolean flag)
        {
        }
    }

    public static final class Property extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int KEY_FIELD_NUMBER = 1;
        public static Parser PARSER;
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final Property defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private int key_;
        private int value_;

        public static Property getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
        }

        public static Property newMessage()
        {
            return new Property();
        }

        public Property clear()
        {
            assertMutable();
            super.clear();
            key_ = 0;
            bitField0_ = bitField0_ & -2;
            value_ = 0;
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public volatile GeneratedMutableMessageLite clear()
        {
            return clear();
        }

        public volatile MutableMessageLite clear()
        {
            return clear();
        }

        public Property clearKey()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            key_ = 0;
            return this;
        }

        public Property clearValue()
        {
            assertMutable();
            bitField0_ = bitField0_ & -3;
            value_ = 0;
            return this;
        }

        public Property clone()
        {
            return newMessageForType().mergeFrom(this);
        }

        public volatile MutableMessageLite clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
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

        public final Property getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile GeneratedMutableMessageLite getDefaultInstanceForType()
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

        public Parser getParserForType()
        {
            return PARSER;
        }

        public int getSerializedSize()
        {
            int i = 0 + CodedOutputStream.computeInt32Size(1, key_) + CodedOutputStream.computeInt32Size(2, value_) + unknownFields.size();
            cachedSize = i;
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
            int i = 41;
            if (hasKey())
            {
                i = 0x13a46 + getKey();
            }
            int j = i;
            if (hasValue())
            {
                j = (i * 37 + 2) * 53 + getValue();
            }
            return j * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$Property");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            while (!hasKey() || !hasValue()) 
            {
                return false;
            }
            return true;
        }

        public Property mergeFrom(Property property)
        {
            if (this == property)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (property == getDefaultInstance())
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
            unknownFields = unknownFields.concat(property.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((Property)generatedmutablemessagelite);
        }

        public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        {
            assertMutable();
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            boolean flag;
            int i;
            try
            {
                output = ByteString.newOutput();
                codedoutputstream = CodedOutputStream.newInstance(output);
            }
            // Misplaced declaration of an exception variable
            catch (CodedInputStream codedinputstream)
            {
                return false;
            }
            flag = false;
            if (flag) goto _L2; else goto _L1
_L1:
            i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 3: default 140
        //                       0: 143
        //                       8: 83
        //                       16: 104;
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
_L6:
            bitField0_ = bitField0_ | 2;
            value_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
            return true;
_L4:
            flag = true;
            if (true) goto _L8; else goto _L7
_L8:
            break MISSING_BLOCK_LABEL_17;
_L7:
        }

        public Property newMessageForType()
        {
            return new Property();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public Property setKey(int i)
        {
            assertMutable();
            bitField0_ = bitField0_ | 1;
            key_ = i;
            return this;
        }

        public Property setValue(int i)
        {
            assertMutable();
            bitField0_ = bitField0_ | 2;
            value_ = i;
            return this;
        }

        protected Object writeReplace()
            throws ObjectStreamException
        {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedoutputstream)
            throws IOException
        {
            int i = codedoutputstream.getTotalBytesWritten();
            codedoutputstream.writeInt32(1, key_);
            codedoutputstream.writeInt32(2, value_);
            codedoutputstream.writeRawBytes(unknownFields);
            int j = codedoutputstream.getTotalBytesWritten();
            if (getCachedSize() != j - i)
            {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            } else
            {
                return;
            }
        }

        static 
        {
            defaultInstance = new Property(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private Property()
        {
            initFields();
        }

        private Property(boolean flag)
        {
        }
    }

    public static final class Resource extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER = 18;
        public static final int KEY_FIELD_NUMBER = 1;
        public static final int LIVE_JS_CACHE_OPTION_FIELD_NUMBER = 14;
        public static final int MACRO_FIELD_NUMBER = 4;
        public static final int MALWARE_SCAN_AUTH_CODE_FIELD_NUMBER = 10;
        public static Parser PARSER;
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
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
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

        private void ensureKeyInitialized()
        {
            if (key_ == null)
            {
                key_ = new LazyStringArrayList();
            }
        }

        private void ensureLiveJsCacheOptionInitialized()
        {
            if (liveJsCacheOption_ == CacheOption.getDefaultInstance())
            {
                liveJsCacheOption_ = CacheOption.newMessage();
            }
        }

        private void ensureMacroInitialized()
        {
            if (macro_ == null)
            {
                macro_ = new ArrayList();
            }
        }

        private void ensurePredicateInitialized()
        {
            if (predicate_ == null)
            {
                predicate_ = new ArrayList();
            }
        }

        private void ensurePropertyInitialized()
        {
            if (property_ == null)
            {
                property_ = new ArrayList();
            }
        }

        private void ensureRuleInitialized()
        {
            if (rule_ == null)
            {
                rule_ = new ArrayList();
            }
        }

        private void ensureTagInitialized()
        {
            if (tag_ == null)
            {
                tag_ = new ArrayList();
            }
        }

        private void ensureUsageContextInitialized()
        {
            if (usageContext_ == null)
            {
                usageContext_ = new LazyStringArrayList();
            }
        }

        private void ensureValueInitialized()
        {
            if (value_ == null)
            {
                value_ = new ArrayList();
            }
        }

        public static Resource getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            liveJsCacheOption_ = CacheOption.getDefaultInstance();
        }

        public static Resource newMessage()
        {
            return new Resource();
        }

        public Resource addAllKey(Iterable iterable)
        {
            assertMutable();
            ensureKeyInitialized();
            AbstractMutableMessageLite.addAll(iterable, key_);
            return this;
        }

        public Resource addAllMacro(Iterable iterable)
        {
            assertMutable();
            ensureMacroInitialized();
            AbstractMutableMessageLite.addAll(iterable, macro_);
            return this;
        }

        public Resource addAllPredicate(Iterable iterable)
        {
            assertMutable();
            ensurePredicateInitialized();
            AbstractMutableMessageLite.addAll(iterable, predicate_);
            return this;
        }

        public Resource addAllProperty(Iterable iterable)
        {
            assertMutable();
            ensurePropertyInitialized();
            AbstractMutableMessageLite.addAll(iterable, property_);
            return this;
        }

        public Resource addAllRule(Iterable iterable)
        {
            assertMutable();
            ensureRuleInitialized();
            AbstractMutableMessageLite.addAll(iterable, rule_);
            return this;
        }

        public Resource addAllTag(Iterable iterable)
        {
            assertMutable();
            ensureTagInitialized();
            AbstractMutableMessageLite.addAll(iterable, tag_);
            return this;
        }

        public Resource addAllUsageContext(Iterable iterable)
        {
            assertMutable();
            ensureUsageContextInitialized();
            AbstractMutableMessageLite.addAll(iterable, usageContext_);
            return this;
        }

        public Resource addAllValue(Iterable iterable)
        {
            assertMutable();
            ensureValueInitialized();
            AbstractMutableMessageLite.addAll(iterable, value_);
            return this;
        }

        public Resource addKey(String s)
        {
            assertMutable();
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureKeyInitialized();
                key_.add(s);
                return this;
            }
        }

        public Resource addKeyAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureKeyInitialized();
                key_.add(abyte0);
                return this;
            }
        }

        public FunctionCall addMacro()
        {
            assertMutable();
            ensureMacroInitialized();
            FunctionCall functioncall = FunctionCall.newMessage();
            macro_.add(functioncall);
            return functioncall;
        }

        public Resource addMacro(FunctionCall functioncall)
        {
            assertMutable();
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMacroInitialized();
                macro_.add(functioncall);
                return this;
            }
        }

        public FunctionCall addPredicate()
        {
            assertMutable();
            ensurePredicateInitialized();
            FunctionCall functioncall = FunctionCall.newMessage();
            predicate_.add(functioncall);
            return functioncall;
        }

        public Resource addPredicate(FunctionCall functioncall)
        {
            assertMutable();
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePredicateInitialized();
                predicate_.add(functioncall);
                return this;
            }
        }

        public Property addProperty()
        {
            assertMutable();
            ensurePropertyInitialized();
            Property property = Property.newMessage();
            property_.add(property);
            return property;
        }

        public Resource addProperty(Property property)
        {
            assertMutable();
            if (property == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePropertyInitialized();
                property_.add(property);
                return this;
            }
        }

        public Resource addRule(Rule rule)
        {
            assertMutable();
            if (rule == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRuleInitialized();
                rule_.add(rule);
                return this;
            }
        }

        public Rule addRule()
        {
            assertMutable();
            ensureRuleInitialized();
            Rule rule = Rule.newMessage();
            rule_.add(rule);
            return rule;
        }

        public FunctionCall addTag()
        {
            assertMutable();
            ensureTagInitialized();
            FunctionCall functioncall = FunctionCall.newMessage();
            tag_.add(functioncall);
            return functioncall;
        }

        public Resource addTag(FunctionCall functioncall)
        {
            assertMutable();
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureTagInitialized();
                tag_.add(functioncall);
                return this;
            }
        }

        public Resource addUsageContext(String s)
        {
            assertMutable();
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureUsageContextInitialized();
                usageContext_.add(s);
                return this;
            }
        }

        public Resource addUsageContextAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureUsageContextInitialized();
                usageContext_.add(abyte0);
                return this;
            }
        }

        public Resource addValue(com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureValueInitialized();
                value_.add(value);
                return this;
            }
        }

        public com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value addValue()
        {
            assertMutable();
            ensureValueInitialized();
            com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value value = com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.newMessage();
            value_.add(value);
            return value;
        }

        public Resource clear()
        {
            assertMutable();
            super.clear();
            key_ = null;
            value_ = null;
            property_ = null;
            macro_ = null;
            tag_ = null;
            predicate_ = null;
            rule_ = null;
            previewAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
            bitField0_ = bitField0_ & -2;
            malwareScanAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
            bitField0_ = bitField0_ & -3;
            templateVersionSet_ = getDefaultInstance().getTemplateVersionSetAsBytes();
            bitField0_ = bitField0_ & -5;
            version_ = Internal.EMPTY_BYTE_ARRAY;
            bitField0_ = bitField0_ & -9;
            if (liveJsCacheOption_ != CacheOption.getDefaultInstance())
            {
                liveJsCacheOption_.clear();
            }
            bitField0_ = bitField0_ & 0xffffffef;
            reportingSampleRate_ = 0.0F;
            bitField0_ = bitField0_ & 0xffffffdf;
            enableAutoEventTracking_ = false;
            bitField0_ = bitField0_ & 0xffffffbf;
            usageContext_ = null;
            resourceFormatVersion_ = 0;
            bitField0_ = bitField0_ & 0xffffff7f;
            return this;
        }

        public volatile GeneratedMutableMessageLite clear()
        {
            return clear();
        }

        public volatile MutableMessageLite clear()
        {
            return clear();
        }

        public Resource clearEnableAutoEventTracking()
        {
            assertMutable();
            bitField0_ = bitField0_ & 0xffffffbf;
            enableAutoEventTracking_ = false;
            return this;
        }

        public Resource clearKey()
        {
            assertMutable();
            key_ = null;
            return this;
        }

        public Resource clearLiveJsCacheOption()
        {
            assertMutable();
            bitField0_ = bitField0_ & 0xffffffef;
            if (liveJsCacheOption_ != CacheOption.getDefaultInstance())
            {
                liveJsCacheOption_.clear();
            }
            return this;
        }

        public Resource clearMacro()
        {
            assertMutable();
            macro_ = null;
            return this;
        }

        public Resource clearMalwareScanAuthCode()
        {
            assertMutable();
            bitField0_ = bitField0_ & -3;
            malwareScanAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Resource clearPredicate()
        {
            assertMutable();
            predicate_ = null;
            return this;
        }

        public Resource clearPreviewAuthCode()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            previewAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Resource clearProperty()
        {
            assertMutable();
            property_ = null;
            return this;
        }

        public Resource clearReportingSampleRate()
        {
            assertMutable();
            bitField0_ = bitField0_ & 0xffffffdf;
            reportingSampleRate_ = 0.0F;
            return this;
        }

        public Resource clearResourceFormatVersion()
        {
            assertMutable();
            bitField0_ = bitField0_ & 0xffffff7f;
            resourceFormatVersion_ = 0;
            return this;
        }

        public Resource clearRule()
        {
            assertMutable();
            rule_ = null;
            return this;
        }

        public Resource clearTag()
        {
            assertMutable();
            tag_ = null;
            return this;
        }

        public Resource clearTemplateVersionSet()
        {
            assertMutable();
            bitField0_ = bitField0_ & -5;
            templateVersionSet_ = getDefaultInstance().getTemplateVersionSetAsBytes();
            return this;
        }

        public Resource clearUsageContext()
        {
            assertMutable();
            usageContext_ = null;
            return this;
        }

        public Resource clearValue()
        {
            assertMutable();
            value_ = null;
            return this;
        }

        public Resource clearVersion()
        {
            assertMutable();
            bitField0_ = bitField0_ & -9;
            version_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Resource clone()
        {
            return newMessageForType().mergeFrom(this);
        }

        public volatile MutableMessageLite clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
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

        public final Resource getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile GeneratedMutableMessageLite getDefaultInstanceForType()
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

        public byte[] getKeyAsBytes(int i)
        {
            return key_.getByteArray(i);
        }

        public int getKeyCount()
        {
            if (key_ == null)
            {
                return 0;
            } else
            {
                return key_.size();
            }
        }

        public List getKeyList()
        {
            if (key_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(key_);
            }
        }

        public List getKeyListAsBytes()
        {
            if (key_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(key_.asByteArrayList());
            }
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
            if (macro_ == null)
            {
                return 0;
            } else
            {
                return macro_.size();
            }
        }

        public List getMacroList()
        {
            if (macro_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(macro_);
            }
        }

        public String getMalwareScanAuthCode()
        {
            Object obj = malwareScanAuthCode_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                malwareScanAuthCode_ = s;
            }
            return s;
        }

        public byte[] getMalwareScanAuthCodeAsBytes()
        {
            byte abyte0[] = ((byte []) (malwareScanAuthCode_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                malwareScanAuthCode_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
            }
        }

        public List getMutableKeyList()
        {
            assertMutable();
            ensureKeyInitialized();
            return key_;
        }

        public List getMutableKeyListAsBytes()
        {
            assertMutable();
            ensureKeyInitialized();
            return key_.asByteArrayList();
        }

        public CacheOption getMutableLiveJsCacheOption()
        {
            assertMutable();
            ensureLiveJsCacheOptionInitialized();
            bitField0_ = bitField0_ | 0x10;
            return liveJsCacheOption_;
        }

        public FunctionCall getMutableMacro(int i)
        {
            return (FunctionCall)macro_.get(i);
        }

        public List getMutableMacroList()
        {
            assertMutable();
            ensureMacroInitialized();
            return macro_;
        }

        public FunctionCall getMutablePredicate(int i)
        {
            return (FunctionCall)predicate_.get(i);
        }

        public List getMutablePredicateList()
        {
            assertMutable();
            ensurePredicateInitialized();
            return predicate_;
        }

        public Property getMutableProperty(int i)
        {
            return (Property)property_.get(i);
        }

        public List getMutablePropertyList()
        {
            assertMutable();
            ensurePropertyInitialized();
            return property_;
        }

        public Rule getMutableRule(int i)
        {
            return (Rule)rule_.get(i);
        }

        public List getMutableRuleList()
        {
            assertMutable();
            ensureRuleInitialized();
            return rule_;
        }

        public FunctionCall getMutableTag(int i)
        {
            return (FunctionCall)tag_.get(i);
        }

        public List getMutableTagList()
        {
            assertMutable();
            ensureTagInitialized();
            return tag_;
        }

        public List getMutableUsageContextList()
        {
            assertMutable();
            ensureUsageContextInitialized();
            return usageContext_;
        }

        public List getMutableUsageContextListAsBytes()
        {
            assertMutable();
            ensureUsageContextInitialized();
            return usageContext_.asByteArrayList();
        }

        public com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value getMutableValue(int i)
        {
            return (com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value)value_.get(i);
        }

        public List getMutableValueList()
        {
            assertMutable();
            ensureValueInitialized();
            return value_;
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
            if (predicate_ == null)
            {
                return 0;
            } else
            {
                return predicate_.size();
            }
        }

        public List getPredicateList()
        {
            if (predicate_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(predicate_);
            }
        }

        public String getPreviewAuthCode()
        {
            Object obj = previewAuthCode_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                previewAuthCode_ = s;
            }
            return s;
        }

        public byte[] getPreviewAuthCodeAsBytes()
        {
            byte abyte0[] = ((byte []) (previewAuthCode_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                previewAuthCode_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
            }
        }

        public Property getProperty(int i)
        {
            return (Property)property_.get(i);
        }

        public int getPropertyCount()
        {
            if (property_ == null)
            {
                return 0;
            } else
            {
                return property_.size();
            }
        }

        public List getPropertyList()
        {
            if (property_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(property_);
            }
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
            if (rule_ == null)
            {
                return 0;
            } else
            {
                return rule_.size();
            }
        }

        public List getRuleList()
        {
            if (rule_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(rule_);
            }
        }

        public int getSerializedSize()
        {
            int i = 0;
            int j = i;
            if (key_ != null)
            {
                j = i;
                if (key_.size() > 0)
                {
                    j = 0;
                    for (i = 0; i < key_.size(); i++)
                    {
                        j += CodedOutputStream.computeByteArraySizeNoTag(key_.getByteArray(i));
                    }

                    j = 0 + j + key_.size() * 1;
                }
            }
            i = j;
            if (value_ != null)
            {
                int k = 0;
                do
                {
                    i = j;
                    if (k >= value_.size())
                    {
                        break;
                    }
                    j += CodedOutputStream.computeMessageSize(2, (MessageLite)value_.get(k));
                    k++;
                } while (true);
            }
            j = i;
            if (property_ != null)
            {
                int l = 0;
                do
                {
                    j = i;
                    if (l >= property_.size())
                    {
                        break;
                    }
                    i += CodedOutputStream.computeMessageSize(3, (MessageLite)property_.get(l));
                    l++;
                } while (true);
            }
            i = j;
            if (macro_ != null)
            {
                int i1 = 0;
                do
                {
                    i = j;
                    if (i1 >= macro_.size())
                    {
                        break;
                    }
                    j += CodedOutputStream.computeMessageSize(4, (MessageLite)macro_.get(i1));
                    i1++;
                } while (true);
            }
            j = i;
            if (tag_ != null)
            {
                int j1 = 0;
                do
                {
                    j = i;
                    if (j1 >= tag_.size())
                    {
                        break;
                    }
                    i += CodedOutputStream.computeMessageSize(5, (MessageLite)tag_.get(j1));
                    j1++;
                } while (true);
            }
            i = j;
            if (predicate_ != null)
            {
                int k1 = 0;
                do
                {
                    i = j;
                    if (k1 >= predicate_.size())
                    {
                        break;
                    }
                    j += CodedOutputStream.computeMessageSize(6, (MessageLite)predicate_.get(k1));
                    k1++;
                } while (true);
            }
            j = i;
            if (rule_ != null)
            {
                int l1 = 0;
                do
                {
                    j = i;
                    if (l1 >= rule_.size())
                    {
                        break;
                    }
                    i += CodedOutputStream.computeMessageSize(7, (MessageLite)rule_.get(l1));
                    l1++;
                } while (true);
            }
            i = j;
            if ((bitField0_ & 1) == 1)
            {
                i = j + CodedOutputStream.computeByteArraySize(9, getPreviewAuthCodeAsBytes());
            }
            j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeByteArraySize(10, getMalwareScanAuthCodeAsBytes());
            }
            i = j;
            if ((bitField0_ & 4) == 4)
            {
                i = j + CodedOutputStream.computeByteArraySize(12, getTemplateVersionSetAsBytes());
            }
            j = i;
            if ((bitField0_ & 8) == 8)
            {
                j = i + CodedOutputStream.computeByteArraySize(13, getVersionAsBytes());
            }
            i = j;
            if ((bitField0_ & 0x10) == 16)
            {
                i = j + CodedOutputStream.computeMessageSize(14, liveJsCacheOption_);
            }
            j = i;
            if ((bitField0_ & 0x20) == 32)
            {
                j = i + CodedOutputStream.computeFloatSize(15, reportingSampleRate_);
            }
            i = j;
            if ((bitField0_ & 0x40) == 64)
            {
                i = j + CodedOutputStream.computeBoolSize(18, enableAutoEventTracking_);
            }
            j = i;
            if (usageContext_ != null)
            {
                j = i;
                if (usageContext_.size() > 0)
                {
                    int i2 = 0;
                    for (j = 0; j < usageContext_.size(); j++)
                    {
                        i2 += CodedOutputStream.computeByteArraySizeNoTag(usageContext_.getByteArray(j));
                    }

                    j = i + i2 + usageContext_.size() * 2;
                }
            }
            i = j;
            if ((bitField0_ & 0x80) == 128)
            {
                i = j + CodedOutputStream.computeInt32Size(17, resourceFormatVersion_);
            }
            i += unknownFields.size();
            cachedSize = i;
            return i;
        }

        public FunctionCall getTag(int i)
        {
            return (FunctionCall)tag_.get(i);
        }

        public int getTagCount()
        {
            if (tag_ == null)
            {
                return 0;
            } else
            {
                return tag_.size();
            }
        }

        public List getTagList()
        {
            if (tag_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(tag_);
            }
        }

        public String getTemplateVersionSet()
        {
            Object obj = templateVersionSet_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                templateVersionSet_ = s;
            }
            return s;
        }

        public byte[] getTemplateVersionSetAsBytes()
        {
            byte abyte0[] = ((byte []) (templateVersionSet_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                templateVersionSet_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
            }
        }

        public String getUsageContext(int i)
        {
            return (String)usageContext_.get(i);
        }

        public byte[] getUsageContextAsBytes(int i)
        {
            return usageContext_.getByteArray(i);
        }

        public int getUsageContextCount()
        {
            if (usageContext_ == null)
            {
                return 0;
            } else
            {
                return usageContext_.size();
            }
        }

        public List getUsageContextList()
        {
            if (usageContext_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(usageContext_);
            }
        }

        public List getUsageContextListAsBytes()
        {
            if (usageContext_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(usageContext_.asByteArrayList());
            }
        }

        public com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value getValue(int i)
        {
            return (com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value)value_.get(i);
        }

        public int getValueCount()
        {
            if (value_ == null)
            {
                return 0;
            } else
            {
                return value_.size();
            }
        }

        public List getValueList()
        {
            if (value_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(value_);
            }
        }

        public String getVersion()
        {
            Object obj = version_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                version_ = s;
            }
            return s;
        }

        public byte[] getVersionAsBytes()
        {
            byte abyte0[] = ((byte []) (version_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                version_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
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
            int j = 41;
            if (getKeyCount() > 0)
            {
                j = 0x13a46 + getKeyList().hashCode();
            }
            int i = j;
            if (getValueCount() > 0)
            {
                i = (j * 37 + 2) * 53 + getValueList().hashCode();
            }
            j = i;
            if (getPropertyCount() > 0)
            {
                j = (i * 37 + 3) * 53 + getPropertyList().hashCode();
            }
            i = j;
            if (getMacroCount() > 0)
            {
                i = (j * 37 + 4) * 53 + getMacroList().hashCode();
            }
            j = i;
            if (getTagCount() > 0)
            {
                j = (i * 37 + 5) * 53 + getTagList().hashCode();
            }
            i = j;
            if (getPredicateCount() > 0)
            {
                i = (j * 37 + 6) * 53 + getPredicateList().hashCode();
            }
            j = i;
            if (getRuleCount() > 0)
            {
                j = (i * 37 + 7) * 53 + getRuleList().hashCode();
            }
            i = j;
            if (hasPreviewAuthCode())
            {
                i = (j * 37 + 9) * 53 + getPreviewAuthCode().hashCode();
            }
            j = i;
            if (hasMalwareScanAuthCode())
            {
                j = (i * 37 + 10) * 53 + getMalwareScanAuthCode().hashCode();
            }
            i = j;
            if (hasTemplateVersionSet())
            {
                i = (j * 37 + 12) * 53 + getTemplateVersionSet().hashCode();
            }
            j = i;
            if (hasVersion())
            {
                j = (i * 37 + 13) * 53 + getVersion().hashCode();
            }
            i = j;
            if (hasLiveJsCacheOption())
            {
                i = (j * 37 + 14) * 53 + getLiveJsCacheOption().hashCode();
            }
            j = i;
            if (hasReportingSampleRate())
            {
                j = (i * 37 + 15) * 53 + Float.floatToIntBits(getReportingSampleRate());
            }
            i = j;
            if (hasEnableAutoEventTracking())
            {
                i = (j * 37 + 18) * 53 + Internal.hashBoolean(getEnableAutoEventTracking());
            }
            j = i;
            if (getUsageContextCount() > 0)
            {
                j = (i * 37 + 16) * 53 + getUsageContextList().hashCode();
            }
            i = j;
            if (hasResourceFormatVersion())
            {
                i = (j * 37 + 17) * 53 + getResourceFormatVersion();
            }
            return i * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$Resource");
            }
            return immutableDefault;
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

        public Resource mergeFrom(Resource resource)
        {
            if (this == resource)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (resource == getDefaultInstance())
            {
                return this;
            }
            if (resource.key_ != null && !resource.key_.isEmpty())
            {
                ensureKeyInitialized();
                key_.mergeFrom(resource.key_);
            }
            if (resource.value_ != null && !resource.value_.isEmpty())
            {
                ensureValueInitialized();
                AbstractMutableMessageLite.addAll(resource.value_, value_);
            }
            if (resource.property_ != null && !resource.property_.isEmpty())
            {
                ensurePropertyInitialized();
                AbstractMutableMessageLite.addAll(resource.property_, property_);
            }
            if (resource.macro_ != null && !resource.macro_.isEmpty())
            {
                ensureMacroInitialized();
                AbstractMutableMessageLite.addAll(resource.macro_, macro_);
            }
            if (resource.tag_ != null && !resource.tag_.isEmpty())
            {
                ensureTagInitialized();
                AbstractMutableMessageLite.addAll(resource.tag_, tag_);
            }
            if (resource.predicate_ != null && !resource.predicate_.isEmpty())
            {
                ensurePredicateInitialized();
                AbstractMutableMessageLite.addAll(resource.predicate_, predicate_);
            }
            if (resource.rule_ != null && !resource.rule_.isEmpty())
            {
                ensureRuleInitialized();
                AbstractMutableMessageLite.addAll(resource.rule_, rule_);
            }
            if (resource.hasPreviewAuthCode())
            {
                bitField0_ = bitField0_ | 1;
                if (resource.previewAuthCode_ instanceof String)
                {
                    previewAuthCode_ = resource.previewAuthCode_;
                } else
                {
                    byte abyte0[] = (byte[])(byte[])resource.previewAuthCode_;
                    previewAuthCode_ = Arrays.copyOf(abyte0, abyte0.length);
                }
            }
            if (resource.hasMalwareScanAuthCode())
            {
                bitField0_ = bitField0_ | 2;
                if (resource.malwareScanAuthCode_ instanceof String)
                {
                    malwareScanAuthCode_ = resource.malwareScanAuthCode_;
                } else
                {
                    byte abyte1[] = (byte[])(byte[])resource.malwareScanAuthCode_;
                    malwareScanAuthCode_ = Arrays.copyOf(abyte1, abyte1.length);
                }
            }
            if (resource.hasTemplateVersionSet())
            {
                bitField0_ = bitField0_ | 4;
                if (resource.templateVersionSet_ instanceof String)
                {
                    templateVersionSet_ = resource.templateVersionSet_;
                } else
                {
                    byte abyte2[] = (byte[])(byte[])resource.templateVersionSet_;
                    templateVersionSet_ = Arrays.copyOf(abyte2, abyte2.length);
                }
            }
            if (resource.hasVersion())
            {
                bitField0_ = bitField0_ | 8;
                if (resource.version_ instanceof String)
                {
                    version_ = resource.version_;
                } else
                {
                    byte abyte3[] = (byte[])(byte[])resource.version_;
                    version_ = Arrays.copyOf(abyte3, abyte3.length);
                }
            }
            if (resource.hasLiveJsCacheOption())
            {
                ensureLiveJsCacheOptionInitialized();
                liveJsCacheOption_.mergeFrom(resource.getLiveJsCacheOption());
                bitField0_ = bitField0_ | 0x10;
            }
            if (resource.hasReportingSampleRate())
            {
                setReportingSampleRate(resource.getReportingSampleRate());
            }
            if (resource.usageContext_ != null && !resource.usageContext_.isEmpty())
            {
                ensureUsageContextInitialized();
                usageContext_.mergeFrom(resource.usageContext_);
            }
            if (resource.hasResourceFormatVersion())
            {
                setResourceFormatVersion(resource.getResourceFormatVersion());
            }
            if (resource.hasEnableAutoEventTracking())
            {
                setEnableAutoEventTracking(resource.getEnableAutoEventTracking());
            }
            unknownFields = unknownFields.concat(resource.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((Resource)generatedmutablemessagelite);
        }

        public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        {
            assertMutable();
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            boolean flag;
            int i;
            try
            {
                output = ByteString.newOutput();
                codedoutputstream = CodedOutputStream.newInstance(output);
            }
            // Misplaced declaration of an exception variable
            catch (CodedInputStream codedinputstream)
            {
                return false;
            }
            flag = false;
            if (flag) goto _L2; else goto _L1
_L1:
            i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 17: default 514
        //                       0: 517
        //                       10: 195
        //                       18: 215
        //                       26: 227
        //                       34: 239
        //                       42: 251
        //                       50: 263
        //                       58: 275
        //                       74: 287
        //                       82: 308
        //                       98: 329
        //                       106: 350
        //                       114: 372
        //                       125: 412
        //                       130: 434
        //                       136: 454
        //                       144: 477;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            ensureKeyInitialized();
            key_.add(codedinputstream.readByteArray());
            continue; /* Loop/switch isn't completed */
_L6:
            codedinputstream.readMessage(addValue(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L7:
            codedinputstream.readMessage(addProperty(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L8:
            codedinputstream.readMessage(addMacro(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L9:
            codedinputstream.readMessage(addTag(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L10:
            codedinputstream.readMessage(addPredicate(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L11:
            codedinputstream.readMessage(addRule(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L12:
            bitField0_ = bitField0_ | 1;
            previewAuthCode_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L13:
            bitField0_ = bitField0_ | 2;
            malwareScanAuthCode_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L14:
            bitField0_ = bitField0_ | 4;
            templateVersionSet_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L15:
            bitField0_ = bitField0_ | 8;
            version_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L16:
            if (liveJsCacheOption_ == CacheOption.getDefaultInstance())
            {
                liveJsCacheOption_ = CacheOption.newMessage();
            }
            bitField0_ = bitField0_ | 0x10;
            codedinputstream.readMessage(liveJsCacheOption_, extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L17:
            bitField0_ = bitField0_ | 0x20;
            reportingSampleRate_ = codedinputstream.readFloat();
            continue; /* Loop/switch isn't completed */
_L18:
            ensureUsageContextInitialized();
            usageContext_.add(codedinputstream.readByteArray());
            continue; /* Loop/switch isn't completed */
_L19:
            bitField0_ = bitField0_ | 0x80;
            resourceFormatVersion_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L20:
            bitField0_ = bitField0_ | 0x40;
            enableAutoEventTracking_ = codedinputstream.readBool();
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
            return true;
_L4:
            flag = true;
            if (true) goto _L22; else goto _L21
_L22:
            break MISSING_BLOCK_LABEL_17;
_L21:
        }

        public Resource newMessageForType()
        {
            return new Resource();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public Resource setEnableAutoEventTracking(boolean flag)
        {
            assertMutable();
            bitField0_ = bitField0_ | 0x40;
            enableAutoEventTracking_ = flag;
            return this;
        }

        public Resource setKey(int i, String s)
        {
            assertMutable();
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureKeyInitialized();
                key_.set(i, s);
                return this;
            }
        }

        public Resource setKeyAsBytes(int i, byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureKeyInitialized();
                key_.set(i, abyte0);
                return this;
            }
        }

        public Resource setLiveJsCacheOption(CacheOption cacheoption)
        {
            assertMutable();
            if (cacheoption == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x10;
                liveJsCacheOption_ = cacheoption;
                return this;
            }
        }

        public Resource setMacro(int i, FunctionCall functioncall)
        {
            assertMutable();
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureMacroInitialized();
                macro_.set(i, functioncall);
                return this;
            }
        }

        public Resource setMalwareScanAuthCode(String s)
        {
            assertMutable();
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                malwareScanAuthCode_ = s;
                return this;
            }
        }

        public Resource setMalwareScanAuthCodeAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                malwareScanAuthCode_ = abyte0;
                return this;
            }
        }

        public Resource setPredicate(int i, FunctionCall functioncall)
        {
            assertMutable();
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePredicateInitialized();
                predicate_.set(i, functioncall);
                return this;
            }
        }

        public Resource setPreviewAuthCode(String s)
        {
            assertMutable();
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                previewAuthCode_ = s;
                return this;
            }
        }

        public Resource setPreviewAuthCodeAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                previewAuthCode_ = abyte0;
                return this;
            }
        }

        public Resource setProperty(int i, Property property)
        {
            assertMutable();
            if (property == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePropertyInitialized();
                property_.set(i, property);
                return this;
            }
        }

        public Resource setReportingSampleRate(float f)
        {
            assertMutable();
            bitField0_ = bitField0_ | 0x20;
            reportingSampleRate_ = f;
            return this;
        }

        public Resource setResourceFormatVersion(int i)
        {
            assertMutable();
            bitField0_ = bitField0_ | 0x80;
            resourceFormatVersion_ = i;
            return this;
        }

        public Resource setRule(int i, Rule rule)
        {
            assertMutable();
            if (rule == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRuleInitialized();
                rule_.set(i, rule);
                return this;
            }
        }

        public Resource setTag(int i, FunctionCall functioncall)
        {
            assertMutable();
            if (functioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureTagInitialized();
                tag_.set(i, functioncall);
                return this;
            }
        }

        public Resource setTemplateVersionSet(String s)
        {
            assertMutable();
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                templateVersionSet_ = s;
                return this;
            }
        }

        public Resource setTemplateVersionSetAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                templateVersionSet_ = abyte0;
                return this;
            }
        }

        public Resource setUsageContext(int i, String s)
        {
            assertMutable();
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureUsageContextInitialized();
                usageContext_.set(i, s);
                return this;
            }
        }

        public Resource setUsageContextAsBytes(int i, byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureUsageContextInitialized();
                usageContext_.set(i, abyte0);
                return this;
            }
        }

        public Resource setValue(int i, com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureValueInitialized();
                value_.set(i, value);
                return this;
            }
        }

        public Resource setVersion(String s)
        {
            assertMutable();
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

        public Resource setVersionAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 8;
                version_ = abyte0;
                return this;
            }
        }

        protected Object writeReplace()
            throws ObjectStreamException
        {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedoutputstream)
            throws IOException
        {
            int j2 = codedoutputstream.getTotalBytesWritten();
            if (key_ != null)
            {
                for (int i = 0; i < key_.size(); i++)
                {
                    codedoutputstream.writeByteArray(1, key_.getByteArray(i));
                }

            }
            if (value_ != null)
            {
                for (int j = 0; j < value_.size(); j++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(2, (MutableMessageLite)value_.get(j));
                }

            }
            if (property_ != null)
            {
                for (int k = 0; k < property_.size(); k++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(3, (MutableMessageLite)property_.get(k));
                }

            }
            if (macro_ != null)
            {
                for (int l = 0; l < macro_.size(); l++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(4, (MutableMessageLite)macro_.get(l));
                }

            }
            if (tag_ != null)
            {
                for (int i1 = 0; i1 < tag_.size(); i1++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(5, (MutableMessageLite)tag_.get(i1));
                }

            }
            if (predicate_ != null)
            {
                for (int j1 = 0; j1 < predicate_.size(); j1++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(6, (MutableMessageLite)predicate_.get(j1));
                }

            }
            if (rule_ != null)
            {
                for (int k1 = 0; k1 < rule_.size(); k1++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(7, (MutableMessageLite)rule_.get(k1));
                }

            }
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeByteArray(9, getPreviewAuthCodeAsBytes());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeByteArray(10, getMalwareScanAuthCodeAsBytes());
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeByteArray(12, getTemplateVersionSetAsBytes());
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeByteArray(13, getVersionAsBytes());
            }
            if ((bitField0_ & 0x10) == 16)
            {
                codedoutputstream.writeMessageWithCachedSizes(14, liveJsCacheOption_);
            }
            if ((bitField0_ & 0x20) == 32)
            {
                codedoutputstream.writeFloat(15, reportingSampleRate_);
            }
            if (usageContext_ != null)
            {
                for (int l1 = 0; l1 < usageContext_.size(); l1++)
                {
                    codedoutputstream.writeByteArray(16, usageContext_.getByteArray(l1));
                }

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
            int i2 = codedoutputstream.getTotalBytesWritten();
            if (getCachedSize() != i2 - j2)
            {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            } else
            {
                return;
            }
        }

        static 
        {
            defaultInstance = new Resource(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private Resource()
        {
            key_ = null;
            value_ = null;
            property_ = null;
            macro_ = null;
            tag_ = null;
            predicate_ = null;
            rule_ = null;
            previewAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
            malwareScanAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
            templateVersionSet_ = Internal.byteArrayDefaultValue("0");
            version_ = Internal.EMPTY_BYTE_ARRAY;
            usageContext_ = null;
            initFields();
        }

        private Resource(boolean flag)
        {
            key_ = null;
            value_ = null;
            property_ = null;
            macro_ = null;
            tag_ = null;
            predicate_ = null;
            rule_ = null;
            previewAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
            malwareScanAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
            templateVersionSet_ = Internal.byteArrayDefaultValue("0");
            version_ = Internal.EMPTY_BYTE_ARRAY;
            usageContext_ = null;
        }
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
            return (ResourceState)Enum.valueOf(com/google/analytics/containertag/proto/MutableServing$ResourceState, s);
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
            return (ResourceType)Enum.valueOf(com/google/analytics/containertag/proto/MutableServing$ResourceType, s);
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

    public static final class Rule extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int ADD_MACRO_FIELD_NUMBER = 7;
        public static final int ADD_MACRO_RULE_NAME_FIELD_NUMBER = 9;
        public static final int ADD_TAG_FIELD_NUMBER = 3;
        public static final int ADD_TAG_RULE_NAME_FIELD_NUMBER = 5;
        public static final int NEGATIVE_PREDICATE_FIELD_NUMBER = 2;
        public static Parser PARSER;
        public static final int POSITIVE_PREDICATE_FIELD_NUMBER = 1;
        public static final int REMOVE_MACRO_FIELD_NUMBER = 8;
        public static final int REMOVE_MACRO_RULE_NAME_FIELD_NUMBER = 10;
        public static final int REMOVE_TAG_FIELD_NUMBER = 4;
        public static final int REMOVE_TAG_RULE_NAME_FIELD_NUMBER = 6;
        private static final Rule defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private List addMacroRuleName_;
        private List addMacro_;
        private List addTagRuleName_;
        private List addTag_;
        private List negativePredicate_;
        private List positivePredicate_;
        private List removeMacroRuleName_;
        private List removeMacro_;
        private List removeTagRuleName_;
        private List removeTag_;

        private void ensureAddMacroInitialized()
        {
            if (addMacro_ == null)
            {
                addMacro_ = new ArrayList();
            }
        }

        private void ensureAddMacroRuleNameInitialized()
        {
            if (addMacroRuleName_ == null)
            {
                addMacroRuleName_ = new ArrayList();
            }
        }

        private void ensureAddTagInitialized()
        {
            if (addTag_ == null)
            {
                addTag_ = new ArrayList();
            }
        }

        private void ensureAddTagRuleNameInitialized()
        {
            if (addTagRuleName_ == null)
            {
                addTagRuleName_ = new ArrayList();
            }
        }

        private void ensureNegativePredicateInitialized()
        {
            if (negativePredicate_ == null)
            {
                negativePredicate_ = new ArrayList();
            }
        }

        private void ensurePositivePredicateInitialized()
        {
            if (positivePredicate_ == null)
            {
                positivePredicate_ = new ArrayList();
            }
        }

        private void ensureRemoveMacroInitialized()
        {
            if (removeMacro_ == null)
            {
                removeMacro_ = new ArrayList();
            }
        }

        private void ensureRemoveMacroRuleNameInitialized()
        {
            if (removeMacroRuleName_ == null)
            {
                removeMacroRuleName_ = new ArrayList();
            }
        }

        private void ensureRemoveTagInitialized()
        {
            if (removeTag_ == null)
            {
                removeTag_ = new ArrayList();
            }
        }

        private void ensureRemoveTagRuleNameInitialized()
        {
            if (removeTagRuleName_ == null)
            {
                removeTagRuleName_ = new ArrayList();
            }
        }

        public static Rule getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
        }

        public static Rule newMessage()
        {
            return new Rule();
        }

        public Rule addAddMacro(int i)
        {
            assertMutable();
            ensureAddMacroInitialized();
            addMacro_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addAddMacroRuleName(int i)
        {
            assertMutable();
            ensureAddMacroRuleNameInitialized();
            addMacroRuleName_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addAddTag(int i)
        {
            assertMutable();
            ensureAddTagInitialized();
            addTag_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addAddTagRuleName(int i)
        {
            assertMutable();
            ensureAddTagRuleNameInitialized();
            addTagRuleName_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addAllAddMacro(Iterable iterable)
        {
            assertMutable();
            ensureAddMacroInitialized();
            AbstractMutableMessageLite.addAll(iterable, addMacro_);
            return this;
        }

        public Rule addAllAddMacroRuleName(Iterable iterable)
        {
            assertMutable();
            ensureAddMacroRuleNameInitialized();
            AbstractMutableMessageLite.addAll(iterable, addMacroRuleName_);
            return this;
        }

        public Rule addAllAddTag(Iterable iterable)
        {
            assertMutable();
            ensureAddTagInitialized();
            AbstractMutableMessageLite.addAll(iterable, addTag_);
            return this;
        }

        public Rule addAllAddTagRuleName(Iterable iterable)
        {
            assertMutable();
            ensureAddTagRuleNameInitialized();
            AbstractMutableMessageLite.addAll(iterable, addTagRuleName_);
            return this;
        }

        public Rule addAllNegativePredicate(Iterable iterable)
        {
            assertMutable();
            ensureNegativePredicateInitialized();
            AbstractMutableMessageLite.addAll(iterable, negativePredicate_);
            return this;
        }

        public Rule addAllPositivePredicate(Iterable iterable)
        {
            assertMutable();
            ensurePositivePredicateInitialized();
            AbstractMutableMessageLite.addAll(iterable, positivePredicate_);
            return this;
        }

        public Rule addAllRemoveMacro(Iterable iterable)
        {
            assertMutable();
            ensureRemoveMacroInitialized();
            AbstractMutableMessageLite.addAll(iterable, removeMacro_);
            return this;
        }

        public Rule addAllRemoveMacroRuleName(Iterable iterable)
        {
            assertMutable();
            ensureRemoveMacroRuleNameInitialized();
            AbstractMutableMessageLite.addAll(iterable, removeMacroRuleName_);
            return this;
        }

        public Rule addAllRemoveTag(Iterable iterable)
        {
            assertMutable();
            ensureRemoveTagInitialized();
            AbstractMutableMessageLite.addAll(iterable, removeTag_);
            return this;
        }

        public Rule addAllRemoveTagRuleName(Iterable iterable)
        {
            assertMutable();
            ensureRemoveTagRuleNameInitialized();
            AbstractMutableMessageLite.addAll(iterable, removeTagRuleName_);
            return this;
        }

        public Rule addNegativePredicate(int i)
        {
            assertMutable();
            ensureNegativePredicateInitialized();
            negativePredicate_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addPositivePredicate(int i)
        {
            assertMutable();
            ensurePositivePredicateInitialized();
            positivePredicate_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addRemoveMacro(int i)
        {
            assertMutable();
            ensureRemoveMacroInitialized();
            removeMacro_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addRemoveMacroRuleName(int i)
        {
            assertMutable();
            ensureRemoveMacroRuleNameInitialized();
            removeMacroRuleName_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addRemoveTag(int i)
        {
            assertMutable();
            ensureRemoveTagInitialized();
            removeTag_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addRemoveTagRuleName(int i)
        {
            assertMutable();
            ensureRemoveTagRuleNameInitialized();
            removeTagRuleName_.add(Integer.valueOf(i));
            return this;
        }

        public Rule clear()
        {
            assertMutable();
            super.clear();
            positivePredicate_ = null;
            negativePredicate_ = null;
            addTag_ = null;
            removeTag_ = null;
            addTagRuleName_ = null;
            removeTagRuleName_ = null;
            addMacro_ = null;
            removeMacro_ = null;
            addMacroRuleName_ = null;
            removeMacroRuleName_ = null;
            return this;
        }

        public volatile GeneratedMutableMessageLite clear()
        {
            return clear();
        }

        public volatile MutableMessageLite clear()
        {
            return clear();
        }

        public Rule clearAddMacro()
        {
            assertMutable();
            addMacro_ = null;
            return this;
        }

        public Rule clearAddMacroRuleName()
        {
            assertMutable();
            addMacroRuleName_ = null;
            return this;
        }

        public Rule clearAddTag()
        {
            assertMutable();
            addTag_ = null;
            return this;
        }

        public Rule clearAddTagRuleName()
        {
            assertMutable();
            addTagRuleName_ = null;
            return this;
        }

        public Rule clearNegativePredicate()
        {
            assertMutable();
            negativePredicate_ = null;
            return this;
        }

        public Rule clearPositivePredicate()
        {
            assertMutable();
            positivePredicate_ = null;
            return this;
        }

        public Rule clearRemoveMacro()
        {
            assertMutable();
            removeMacro_ = null;
            return this;
        }

        public Rule clearRemoveMacroRuleName()
        {
            assertMutable();
            removeMacroRuleName_ = null;
            return this;
        }

        public Rule clearRemoveTag()
        {
            assertMutable();
            removeTag_ = null;
            return this;
        }

        public Rule clearRemoveTagRuleName()
        {
            assertMutable();
            removeTagRuleName_ = null;
            return this;
        }

        public Rule clone()
        {
            return newMessageForType().mergeFrom(this);
        }

        public volatile MutableMessageLite clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
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
            if (addMacro_ == null)
            {
                return 0;
            } else
            {
                return addMacro_.size();
            }
        }

        public List getAddMacroList()
        {
            if (addMacro_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(addMacro_);
            }
        }

        public int getAddMacroRuleName(int i)
        {
            return ((Integer)addMacroRuleName_.get(i)).intValue();
        }

        public int getAddMacroRuleNameCount()
        {
            if (addMacroRuleName_ == null)
            {
                return 0;
            } else
            {
                return addMacroRuleName_.size();
            }
        }

        public List getAddMacroRuleNameList()
        {
            if (addMacroRuleName_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(addMacroRuleName_);
            }
        }

        public int getAddTag(int i)
        {
            return ((Integer)addTag_.get(i)).intValue();
        }

        public int getAddTagCount()
        {
            if (addTag_ == null)
            {
                return 0;
            } else
            {
                return addTag_.size();
            }
        }

        public List getAddTagList()
        {
            if (addTag_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(addTag_);
            }
        }

        public int getAddTagRuleName(int i)
        {
            return ((Integer)addTagRuleName_.get(i)).intValue();
        }

        public int getAddTagRuleNameCount()
        {
            if (addTagRuleName_ == null)
            {
                return 0;
            } else
            {
                return addTagRuleName_.size();
            }
        }

        public List getAddTagRuleNameList()
        {
            if (addTagRuleName_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(addTagRuleName_);
            }
        }

        public final Rule getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile GeneratedMutableMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public List getMutableAddMacroList()
        {
            assertMutable();
            ensureAddMacroInitialized();
            return addMacro_;
        }

        public List getMutableAddMacroRuleNameList()
        {
            assertMutable();
            ensureAddMacroRuleNameInitialized();
            return addMacroRuleName_;
        }

        public List getMutableAddTagList()
        {
            assertMutable();
            ensureAddTagInitialized();
            return addTag_;
        }

        public List getMutableAddTagRuleNameList()
        {
            assertMutable();
            ensureAddTagRuleNameInitialized();
            return addTagRuleName_;
        }

        public List getMutableNegativePredicateList()
        {
            assertMutable();
            ensureNegativePredicateInitialized();
            return negativePredicate_;
        }

        public List getMutablePositivePredicateList()
        {
            assertMutable();
            ensurePositivePredicateInitialized();
            return positivePredicate_;
        }

        public List getMutableRemoveMacroList()
        {
            assertMutable();
            ensureRemoveMacroInitialized();
            return removeMacro_;
        }

        public List getMutableRemoveMacroRuleNameList()
        {
            assertMutable();
            ensureRemoveMacroRuleNameInitialized();
            return removeMacroRuleName_;
        }

        public List getMutableRemoveTagList()
        {
            assertMutable();
            ensureRemoveTagInitialized();
            return removeTag_;
        }

        public List getMutableRemoveTagRuleNameList()
        {
            assertMutable();
            ensureRemoveTagRuleNameInitialized();
            return removeTagRuleName_;
        }

        public int getNegativePredicate(int i)
        {
            return ((Integer)negativePredicate_.get(i)).intValue();
        }

        public int getNegativePredicateCount()
        {
            if (negativePredicate_ == null)
            {
                return 0;
            } else
            {
                return negativePredicate_.size();
            }
        }

        public List getNegativePredicateList()
        {
            if (negativePredicate_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(negativePredicate_);
            }
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
            if (positivePredicate_ == null)
            {
                return 0;
            } else
            {
                return positivePredicate_.size();
            }
        }

        public List getPositivePredicateList()
        {
            if (positivePredicate_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(positivePredicate_);
            }
        }

        public int getRemoveMacro(int i)
        {
            return ((Integer)removeMacro_.get(i)).intValue();
        }

        public int getRemoveMacroCount()
        {
            if (removeMacro_ == null)
            {
                return 0;
            } else
            {
                return removeMacro_.size();
            }
        }

        public List getRemoveMacroList()
        {
            if (removeMacro_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(removeMacro_);
            }
        }

        public int getRemoveMacroRuleName(int i)
        {
            return ((Integer)removeMacroRuleName_.get(i)).intValue();
        }

        public int getRemoveMacroRuleNameCount()
        {
            if (removeMacroRuleName_ == null)
            {
                return 0;
            } else
            {
                return removeMacroRuleName_.size();
            }
        }

        public List getRemoveMacroRuleNameList()
        {
            if (removeMacroRuleName_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(removeMacroRuleName_);
            }
        }

        public int getRemoveTag(int i)
        {
            return ((Integer)removeTag_.get(i)).intValue();
        }

        public int getRemoveTagCount()
        {
            if (removeTag_ == null)
            {
                return 0;
            } else
            {
                return removeTag_.size();
            }
        }

        public List getRemoveTagList()
        {
            if (removeTag_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(removeTag_);
            }
        }

        public int getRemoveTagRuleName(int i)
        {
            return ((Integer)removeTagRuleName_.get(i)).intValue();
        }

        public int getRemoveTagRuleNameCount()
        {
            if (removeTagRuleName_ == null)
            {
                return 0;
            } else
            {
                return removeTagRuleName_.size();
            }
        }

        public List getRemoveTagRuleNameList()
        {
            if (removeTagRuleName_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(removeTagRuleName_);
            }
        }

        public int getSerializedSize()
        {
            int j = 0;
            int i = j;
            if (positivePredicate_ != null)
            {
                i = j;
                if (positivePredicate_.size() > 0)
                {
                    j = 0;
                    for (i = 0; i < positivePredicate_.size(); i++)
                    {
                        j += CodedOutputStream.computeInt32SizeNoTag(((Integer)positivePredicate_.get(i)).intValue());
                    }

                    i = 0 + j + getPositivePredicateList().size() * 1;
                }
            }
            j = i;
            if (negativePredicate_ != null)
            {
                j = i;
                if (negativePredicate_.size() > 0)
                {
                    int k = 0;
                    for (j = 0; j < negativePredicate_.size(); j++)
                    {
                        k += CodedOutputStream.computeInt32SizeNoTag(((Integer)negativePredicate_.get(j)).intValue());
                    }

                    j = i + k + getNegativePredicateList().size() * 1;
                }
            }
            i = j;
            if (addTag_ != null)
            {
                i = j;
                if (addTag_.size() > 0)
                {
                    int l = 0;
                    for (i = 0; i < addTag_.size(); i++)
                    {
                        l += CodedOutputStream.computeInt32SizeNoTag(((Integer)addTag_.get(i)).intValue());
                    }

                    i = j + l + getAddTagList().size() * 1;
                }
            }
            j = i;
            if (removeTag_ != null)
            {
                j = i;
                if (removeTag_.size() > 0)
                {
                    int i1 = 0;
                    for (j = 0; j < removeTag_.size(); j++)
                    {
                        i1 += CodedOutputStream.computeInt32SizeNoTag(((Integer)removeTag_.get(j)).intValue());
                    }

                    j = i + i1 + getRemoveTagList().size() * 1;
                }
            }
            i = j;
            if (addTagRuleName_ != null)
            {
                i = j;
                if (addTagRuleName_.size() > 0)
                {
                    int j1 = 0;
                    for (i = 0; i < addTagRuleName_.size(); i++)
                    {
                        j1 += CodedOutputStream.computeInt32SizeNoTag(((Integer)addTagRuleName_.get(i)).intValue());
                    }

                    i = j + j1 + getAddTagRuleNameList().size() * 1;
                }
            }
            j = i;
            if (removeTagRuleName_ != null)
            {
                j = i;
                if (removeTagRuleName_.size() > 0)
                {
                    int k1 = 0;
                    for (j = 0; j < removeTagRuleName_.size(); j++)
                    {
                        k1 += CodedOutputStream.computeInt32SizeNoTag(((Integer)removeTagRuleName_.get(j)).intValue());
                    }

                    j = i + k1 + getRemoveTagRuleNameList().size() * 1;
                }
            }
            i = j;
            if (addMacro_ != null)
            {
                i = j;
                if (addMacro_.size() > 0)
                {
                    int l1 = 0;
                    for (i = 0; i < addMacro_.size(); i++)
                    {
                        l1 += CodedOutputStream.computeInt32SizeNoTag(((Integer)addMacro_.get(i)).intValue());
                    }

                    i = j + l1 + getAddMacroList().size() * 1;
                }
            }
            j = i;
            if (removeMacro_ != null)
            {
                j = i;
                if (removeMacro_.size() > 0)
                {
                    int i2 = 0;
                    for (j = 0; j < removeMacro_.size(); j++)
                    {
                        i2 += CodedOutputStream.computeInt32SizeNoTag(((Integer)removeMacro_.get(j)).intValue());
                    }

                    j = i + i2 + getRemoveMacroList().size() * 1;
                }
            }
            i = j;
            if (addMacroRuleName_ != null)
            {
                i = j;
                if (addMacroRuleName_.size() > 0)
                {
                    int j2 = 0;
                    for (i = 0; i < addMacroRuleName_.size(); i++)
                    {
                        j2 += CodedOutputStream.computeInt32SizeNoTag(((Integer)addMacroRuleName_.get(i)).intValue());
                    }

                    i = j + j2 + getAddMacroRuleNameList().size() * 1;
                }
            }
            j = i;
            if (removeMacroRuleName_ != null)
            {
                j = i;
                if (removeMacroRuleName_.size() > 0)
                {
                    int k2 = 0;
                    for (j = 0; j < removeMacroRuleName_.size(); j++)
                    {
                        k2 += CodedOutputStream.computeInt32SizeNoTag(((Integer)removeMacroRuleName_.get(j)).intValue());
                    }

                    j = i + k2 + getRemoveMacroRuleNameList().size() * 1;
                }
            }
            i = j + unknownFields.size();
            cachedSize = i;
            return i;
        }

        public int hashCode()
        {
            int j = 41;
            if (getPositivePredicateCount() > 0)
            {
                j = 0x13a46 + getPositivePredicateList().hashCode();
            }
            int i = j;
            if (getNegativePredicateCount() > 0)
            {
                i = (j * 37 + 2) * 53 + getNegativePredicateList().hashCode();
            }
            j = i;
            if (getAddTagCount() > 0)
            {
                j = (i * 37 + 3) * 53 + getAddTagList().hashCode();
            }
            i = j;
            if (getRemoveTagCount() > 0)
            {
                i = (j * 37 + 4) * 53 + getRemoveTagList().hashCode();
            }
            j = i;
            if (getAddTagRuleNameCount() > 0)
            {
                j = (i * 37 + 5) * 53 + getAddTagRuleNameList().hashCode();
            }
            i = j;
            if (getRemoveTagRuleNameCount() > 0)
            {
                i = (j * 37 + 6) * 53 + getRemoveTagRuleNameList().hashCode();
            }
            j = i;
            if (getAddMacroCount() > 0)
            {
                j = (i * 37 + 7) * 53 + getAddMacroList().hashCode();
            }
            i = j;
            if (getRemoveMacroCount() > 0)
            {
                i = (j * 37 + 8) * 53 + getRemoveMacroList().hashCode();
            }
            j = i;
            if (getAddMacroRuleNameCount() > 0)
            {
                j = (i * 37 + 9) * 53 + getAddMacroRuleNameList().hashCode();
            }
            i = j;
            if (getRemoveMacroRuleNameCount() > 0)
            {
                i = (j * 37 + 10) * 53 + getRemoveMacroRuleNameList().hashCode();
            }
            return i * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$Rule");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            return true;
        }

        public Rule mergeFrom(Rule rule)
        {
            if (this == rule)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (rule == getDefaultInstance())
            {
                return this;
            }
            if (rule.positivePredicate_ != null && !rule.positivePredicate_.isEmpty())
            {
                ensurePositivePredicateInitialized();
                positivePredicate_.addAll(rule.positivePredicate_);
            }
            if (rule.negativePredicate_ != null && !rule.negativePredicate_.isEmpty())
            {
                ensureNegativePredicateInitialized();
                negativePredicate_.addAll(rule.negativePredicate_);
            }
            if (rule.addTag_ != null && !rule.addTag_.isEmpty())
            {
                ensureAddTagInitialized();
                addTag_.addAll(rule.addTag_);
            }
            if (rule.removeTag_ != null && !rule.removeTag_.isEmpty())
            {
                ensureRemoveTagInitialized();
                removeTag_.addAll(rule.removeTag_);
            }
            if (rule.addTagRuleName_ != null && !rule.addTagRuleName_.isEmpty())
            {
                ensureAddTagRuleNameInitialized();
                addTagRuleName_.addAll(rule.addTagRuleName_);
            }
            if (rule.removeTagRuleName_ != null && !rule.removeTagRuleName_.isEmpty())
            {
                ensureRemoveTagRuleNameInitialized();
                removeTagRuleName_.addAll(rule.removeTagRuleName_);
            }
            if (rule.addMacro_ != null && !rule.addMacro_.isEmpty())
            {
                ensureAddMacroInitialized();
                addMacro_.addAll(rule.addMacro_);
            }
            if (rule.removeMacro_ != null && !rule.removeMacro_.isEmpty())
            {
                ensureRemoveMacroInitialized();
                removeMacro_.addAll(rule.removeMacro_);
            }
            if (rule.addMacroRuleName_ != null && !rule.addMacroRuleName_.isEmpty())
            {
                ensureAddMacroRuleNameInitialized();
                addMacroRuleName_.addAll(rule.addMacroRuleName_);
            }
            if (rule.removeMacroRuleName_ != null && !rule.removeMacroRuleName_.isEmpty())
            {
                ensureRemoveMacroRuleNameInitialized();
                removeMacroRuleName_.addAll(rule.removeMacroRuleName_);
            }
            unknownFields = unknownFields.concat(rule.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((Rule)generatedmutablemessagelite);
        }

        public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        {
            assertMutable();
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            boolean flag;
            int i;
            try
            {
                output = ByteString.newOutput();
                codedoutputstream = CodedOutputStream.newInstance(output);
            }
            // Misplaced declaration of an exception variable
            catch (CodedInputStream codedinputstream)
            {
                return false;
            }
            flag = false;
            if (flag) goto _L2; else goto _L1
_L1:
            i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 21: default 1262
        //                       0: 1265
        //                       8: 227
        //                       10: 265
        //                       16: 329
        //                       18: 367
        //                       24: 431
        //                       26: 469
        //                       32: 533
        //                       34: 571
        //                       40: 635
        //                       42: 673
        //                       48: 737
        //                       50: 775
        //                       56: 839
        //                       58: 877
        //                       64: 941
        //                       66: 979
        //                       72: 1043
        //                       74: 1081
        //                       80: 1145
        //                       82: 1183;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (positivePredicate_ == null)
            {
                positivePredicate_ = new ArrayList();
            }
            positivePredicate_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L6:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (positivePredicate_ == null)
            {
                positivePredicate_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; positivePredicate_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L7:
            if (negativePredicate_ == null)
            {
                negativePredicate_ = new ArrayList();
            }
            negativePredicate_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L8:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (negativePredicate_ == null)
            {
                negativePredicate_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; negativePredicate_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L9:
            if (addTag_ == null)
            {
                addTag_ = new ArrayList();
            }
            addTag_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L10:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (addTag_ == null)
            {
                addTag_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; addTag_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L11:
            if (removeTag_ == null)
            {
                removeTag_ = new ArrayList();
            }
            removeTag_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L12:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (removeTag_ == null)
            {
                removeTag_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; removeTag_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L13:
            if (addTagRuleName_ == null)
            {
                addTagRuleName_ = new ArrayList();
            }
            addTagRuleName_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L14:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (addTagRuleName_ == null)
            {
                addTagRuleName_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; addTagRuleName_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L15:
            if (removeTagRuleName_ == null)
            {
                removeTagRuleName_ = new ArrayList();
            }
            removeTagRuleName_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L16:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (removeTagRuleName_ == null)
            {
                removeTagRuleName_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; removeTagRuleName_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L17:
            if (addMacro_ == null)
            {
                addMacro_ = new ArrayList();
            }
            addMacro_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L18:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (addMacro_ == null)
            {
                addMacro_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; addMacro_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L19:
            if (removeMacro_ == null)
            {
                removeMacro_ = new ArrayList();
            }
            removeMacro_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L20:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (removeMacro_ == null)
            {
                removeMacro_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; removeMacro_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L21:
            if (addMacroRuleName_ == null)
            {
                addMacroRuleName_ = new ArrayList();
            }
            addMacroRuleName_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L22:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (addMacroRuleName_ == null)
            {
                addMacroRuleName_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; addMacroRuleName_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L23:
            if (removeMacroRuleName_ == null)
            {
                removeMacroRuleName_ = new ArrayList();
            }
            removeMacroRuleName_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L24:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (removeMacroRuleName_ == null)
            {
                removeMacroRuleName_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; removeMacroRuleName_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
            return true;
_L4:
            flag = true;
            if (true) goto _L26; else goto _L25
_L26:
            break MISSING_BLOCK_LABEL_17;
_L25:
        }

        public Rule newMessageForType()
        {
            return new Rule();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public Rule setAddMacro(int i, int j)
        {
            assertMutable();
            ensureAddMacroInitialized();
            addMacro_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule setAddMacroRuleName(int i, int j)
        {
            assertMutable();
            ensureAddMacroRuleNameInitialized();
            addMacroRuleName_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule setAddTag(int i, int j)
        {
            assertMutable();
            ensureAddTagInitialized();
            addTag_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule setAddTagRuleName(int i, int j)
        {
            assertMutable();
            ensureAddTagRuleNameInitialized();
            addTagRuleName_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule setNegativePredicate(int i, int j)
        {
            assertMutable();
            ensureNegativePredicateInitialized();
            negativePredicate_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule setPositivePredicate(int i, int j)
        {
            assertMutable();
            ensurePositivePredicateInitialized();
            positivePredicate_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule setRemoveMacro(int i, int j)
        {
            assertMutable();
            ensureRemoveMacroInitialized();
            removeMacro_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule setRemoveMacroRuleName(int i, int j)
        {
            assertMutable();
            ensureRemoveMacroRuleNameInitialized();
            removeMacroRuleName_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule setRemoveTag(int i, int j)
        {
            assertMutable();
            ensureRemoveTagInitialized();
            removeTag_.set(i, Integer.valueOf(j));
            return this;
        }

        public Rule setRemoveTagRuleName(int i, int j)
        {
            assertMutable();
            ensureRemoveTagRuleNameInitialized();
            removeTagRuleName_.set(i, Integer.valueOf(j));
            return this;
        }

        protected Object writeReplace()
            throws ObjectStreamException
        {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedoutputstream)
            throws IOException
        {
            int l2 = codedoutputstream.getTotalBytesWritten();
            if (positivePredicate_ != null)
            {
                for (int i = 0; i < positivePredicate_.size(); i++)
                {
                    codedoutputstream.writeInt32(1, ((Integer)positivePredicate_.get(i)).intValue());
                }

            }
            if (negativePredicate_ != null)
            {
                for (int j = 0; j < negativePredicate_.size(); j++)
                {
                    codedoutputstream.writeInt32(2, ((Integer)negativePredicate_.get(j)).intValue());
                }

            }
            if (addTag_ != null)
            {
                for (int k = 0; k < addTag_.size(); k++)
                {
                    codedoutputstream.writeInt32(3, ((Integer)addTag_.get(k)).intValue());
                }

            }
            if (removeTag_ != null)
            {
                for (int l = 0; l < removeTag_.size(); l++)
                {
                    codedoutputstream.writeInt32(4, ((Integer)removeTag_.get(l)).intValue());
                }

            }
            if (addTagRuleName_ != null)
            {
                for (int i1 = 0; i1 < addTagRuleName_.size(); i1++)
                {
                    codedoutputstream.writeInt32(5, ((Integer)addTagRuleName_.get(i1)).intValue());
                }

            }
            if (removeTagRuleName_ != null)
            {
                for (int j1 = 0; j1 < removeTagRuleName_.size(); j1++)
                {
                    codedoutputstream.writeInt32(6, ((Integer)removeTagRuleName_.get(j1)).intValue());
                }

            }
            if (addMacro_ != null)
            {
                for (int k1 = 0; k1 < addMacro_.size(); k1++)
                {
                    codedoutputstream.writeInt32(7, ((Integer)addMacro_.get(k1)).intValue());
                }

            }
            if (removeMacro_ != null)
            {
                for (int l1 = 0; l1 < removeMacro_.size(); l1++)
                {
                    codedoutputstream.writeInt32(8, ((Integer)removeMacro_.get(l1)).intValue());
                }

            }
            if (addMacroRuleName_ != null)
            {
                for (int i2 = 0; i2 < addMacroRuleName_.size(); i2++)
                {
                    codedoutputstream.writeInt32(9, ((Integer)addMacroRuleName_.get(i2)).intValue());
                }

            }
            if (removeMacroRuleName_ != null)
            {
                for (int j2 = 0; j2 < removeMacroRuleName_.size(); j2++)
                {
                    codedoutputstream.writeInt32(10, ((Integer)removeMacroRuleName_.get(j2)).intValue());
                }

            }
            codedoutputstream.writeRawBytes(unknownFields);
            int k2 = codedoutputstream.getTotalBytesWritten();
            if (getCachedSize() != k2 - l2)
            {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            } else
            {
                return;
            }
        }

        static 
        {
            defaultInstance = new Rule(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private Rule()
        {
            positivePredicate_ = null;
            negativePredicate_ = null;
            addTag_ = null;
            removeTag_ = null;
            addTagRuleName_ = null;
            removeTagRuleName_ = null;
            addMacro_ = null;
            removeMacro_ = null;
            addMacroRuleName_ = null;
            removeMacroRuleName_ = null;
            initFields();
        }

        private Rule(boolean flag)
        {
            positivePredicate_ = null;
            negativePredicate_ = null;
            addTag_ = null;
            removeTag_ = null;
            addTagRuleName_ = null;
            removeTagRuleName_ = null;
            addMacro_ = null;
            removeMacro_ = null;
            addMacroRuleName_ = null;
            removeMacroRuleName_ = null;
        }
    }

    public static final class ServingValue extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int EXT_FIELD_NUMBER = 101;
        public static final int LIST_ITEM_FIELD_NUMBER = 1;
        public static final int MACRO_NAME_REFERENCE_FIELD_NUMBER = 6;
        public static final int MACRO_REFERENCE_FIELD_NUMBER = 4;
        public static final int MAP_KEY_FIELD_NUMBER = 2;
        public static final int MAP_VALUE_FIELD_NUMBER = 3;
        public static Parser PARSER;
        public static final int TEMPLATE_TOKEN_FIELD_NUMBER = 5;
        private static final ServingValue defaultInstance;
        public static final com.google.tagmanager.protobuf.GeneratedMessageLite.GeneratedExtension ext;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private List listItem_;
        private int macroNameReference_;
        private int macroReference_;
        private List mapKey_;
        private List mapValue_;
        private List templateToken_;

        private void ensureListItemInitialized()
        {
            if (listItem_ == null)
            {
                listItem_ = new ArrayList();
            }
        }

        private void ensureMapKeyInitialized()
        {
            if (mapKey_ == null)
            {
                mapKey_ = new ArrayList();
            }
        }

        private void ensureMapValueInitialized()
        {
            if (mapValue_ == null)
            {
                mapValue_ = new ArrayList();
            }
        }

        private void ensureTemplateTokenInitialized()
        {
            if (templateToken_ == null)
            {
                templateToken_ = new ArrayList();
            }
        }

        public static ServingValue getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
        }

        public static ServingValue newMessage()
        {
            return new ServingValue();
        }

        public ServingValue addAllListItem(Iterable iterable)
        {
            assertMutable();
            ensureListItemInitialized();
            AbstractMutableMessageLite.addAll(iterable, listItem_);
            return this;
        }

        public ServingValue addAllMapKey(Iterable iterable)
        {
            assertMutable();
            ensureMapKeyInitialized();
            AbstractMutableMessageLite.addAll(iterable, mapKey_);
            return this;
        }

        public ServingValue addAllMapValue(Iterable iterable)
        {
            assertMutable();
            ensureMapValueInitialized();
            AbstractMutableMessageLite.addAll(iterable, mapValue_);
            return this;
        }

        public ServingValue addAllTemplateToken(Iterable iterable)
        {
            assertMutable();
            ensureTemplateTokenInitialized();
            AbstractMutableMessageLite.addAll(iterable, templateToken_);
            return this;
        }

        public ServingValue addListItem(int i)
        {
            assertMutable();
            ensureListItemInitialized();
            listItem_.add(Integer.valueOf(i));
            return this;
        }

        public ServingValue addMapKey(int i)
        {
            assertMutable();
            ensureMapKeyInitialized();
            mapKey_.add(Integer.valueOf(i));
            return this;
        }

        public ServingValue addMapValue(int i)
        {
            assertMutable();
            ensureMapValueInitialized();
            mapValue_.add(Integer.valueOf(i));
            return this;
        }

        public ServingValue addTemplateToken(int i)
        {
            assertMutable();
            ensureTemplateTokenInitialized();
            templateToken_.add(Integer.valueOf(i));
            return this;
        }

        public ServingValue clear()
        {
            assertMutable();
            super.clear();
            listItem_ = null;
            mapKey_ = null;
            mapValue_ = null;
            macroReference_ = 0;
            bitField0_ = bitField0_ & -2;
            templateToken_ = null;
            macroNameReference_ = 0;
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public volatile GeneratedMutableMessageLite clear()
        {
            return clear();
        }

        public volatile MutableMessageLite clear()
        {
            return clear();
        }

        public ServingValue clearListItem()
        {
            assertMutable();
            listItem_ = null;
            return this;
        }

        public ServingValue clearMacroNameReference()
        {
            assertMutable();
            bitField0_ = bitField0_ & -3;
            macroNameReference_ = 0;
            return this;
        }

        public ServingValue clearMacroReference()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            macroReference_ = 0;
            return this;
        }

        public ServingValue clearMapKey()
        {
            assertMutable();
            mapKey_ = null;
            return this;
        }

        public ServingValue clearMapValue()
        {
            assertMutable();
            mapValue_ = null;
            return this;
        }

        public ServingValue clearTemplateToken()
        {
            assertMutable();
            templateToken_ = null;
            return this;
        }

        public ServingValue clone()
        {
            return newMessageForType().mergeFrom(this);
        }

        public volatile MutableMessageLite clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
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

        public final ServingValue getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile GeneratedMutableMessageLite getDefaultInstanceForType()
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
            if (listItem_ == null)
            {
                return 0;
            } else
            {
                return listItem_.size();
            }
        }

        public List getListItemList()
        {
            if (listItem_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(listItem_);
            }
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
            if (mapKey_ == null)
            {
                return 0;
            } else
            {
                return mapKey_.size();
            }
        }

        public List getMapKeyList()
        {
            if (mapKey_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(mapKey_);
            }
        }

        public int getMapValue(int i)
        {
            return ((Integer)mapValue_.get(i)).intValue();
        }

        public int getMapValueCount()
        {
            if (mapValue_ == null)
            {
                return 0;
            } else
            {
                return mapValue_.size();
            }
        }

        public List getMapValueList()
        {
            if (mapValue_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(mapValue_);
            }
        }

        public List getMutableListItemList()
        {
            assertMutable();
            ensureListItemInitialized();
            return listItem_;
        }

        public List getMutableMapKeyList()
        {
            assertMutable();
            ensureMapKeyInitialized();
            return mapKey_;
        }

        public List getMutableMapValueList()
        {
            assertMutable();
            ensureMapValueInitialized();
            return mapValue_;
        }

        public List getMutableTemplateTokenList()
        {
            assertMutable();
            ensureTemplateTokenInitialized();
            return templateToken_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public int getSerializedSize()
        {
            int j = 0;
            int i = j;
            if (listItem_ != null)
            {
                i = j;
                if (listItem_.size() > 0)
                {
                    j = 0;
                    for (i = 0; i < listItem_.size(); i++)
                    {
                        j += CodedOutputStream.computeInt32SizeNoTag(((Integer)listItem_.get(i)).intValue());
                    }

                    i = 0 + j + getListItemList().size() * 1;
                }
            }
            j = i;
            if (mapKey_ != null)
            {
                j = i;
                if (mapKey_.size() > 0)
                {
                    int k = 0;
                    for (j = 0; j < mapKey_.size(); j++)
                    {
                        k += CodedOutputStream.computeInt32SizeNoTag(((Integer)mapKey_.get(j)).intValue());
                    }

                    j = i + k + getMapKeyList().size() * 1;
                }
            }
            int l = j;
            if (mapValue_ != null)
            {
                l = j;
                if (mapValue_.size() > 0)
                {
                    l = 0;
                    for (i = 0; i < mapValue_.size(); i++)
                    {
                        l += CodedOutputStream.computeInt32SizeNoTag(((Integer)mapValue_.get(i)).intValue());
                    }

                    l = j + l + getMapValueList().size() * 1;
                }
            }
            i = l;
            if ((bitField0_ & 1) == 1)
            {
                i = l + CodedOutputStream.computeInt32Size(4, macroReference_);
            }
            j = i;
            if (templateToken_ != null)
            {
                j = i;
                if (templateToken_.size() > 0)
                {
                    int i1 = 0;
                    for (j = 0; j < templateToken_.size(); j++)
                    {
                        i1 += CodedOutputStream.computeInt32SizeNoTag(((Integer)templateToken_.get(j)).intValue());
                    }

                    j = i + i1 + getTemplateTokenList().size() * 1;
                }
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeInt32Size(6, macroNameReference_);
            }
            i += unknownFields.size();
            cachedSize = i;
            return i;
        }

        public int getTemplateToken(int i)
        {
            return ((Integer)templateToken_.get(i)).intValue();
        }

        public int getTemplateTokenCount()
        {
            if (templateToken_ == null)
            {
                return 0;
            } else
            {
                return templateToken_.size();
            }
        }

        public List getTemplateTokenList()
        {
            if (templateToken_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(templateToken_);
            }
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
            int j = 41;
            if (getListItemCount() > 0)
            {
                j = 0x13a46 + getListItemList().hashCode();
            }
            int i = j;
            if (getMapKeyCount() > 0)
            {
                i = (j * 37 + 2) * 53 + getMapKeyList().hashCode();
            }
            j = i;
            if (getMapValueCount() > 0)
            {
                j = (i * 37 + 3) * 53 + getMapValueList().hashCode();
            }
            i = j;
            if (hasMacroReference())
            {
                i = (j * 37 + 4) * 53 + getMacroReference();
            }
            j = i;
            if (getTemplateTokenCount() > 0)
            {
                j = (i * 37 + 5) * 53 + getTemplateTokenList().hashCode();
            }
            i = j;
            if (hasMacroNameReference())
            {
                i = (j * 37 + 6) * 53 + getMacroNameReference();
            }
            return i * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$ServingValue");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            return true;
        }

        public ServingValue mergeFrom(ServingValue servingvalue)
        {
            if (this == servingvalue)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (servingvalue == getDefaultInstance())
            {
                return this;
            }
            if (servingvalue.listItem_ != null && !servingvalue.listItem_.isEmpty())
            {
                ensureListItemInitialized();
                listItem_.addAll(servingvalue.listItem_);
            }
            if (servingvalue.mapKey_ != null && !servingvalue.mapKey_.isEmpty())
            {
                ensureMapKeyInitialized();
                mapKey_.addAll(servingvalue.mapKey_);
            }
            if (servingvalue.mapValue_ != null && !servingvalue.mapValue_.isEmpty())
            {
                ensureMapValueInitialized();
                mapValue_.addAll(servingvalue.mapValue_);
            }
            if (servingvalue.hasMacroReference())
            {
                setMacroReference(servingvalue.getMacroReference());
            }
            if (servingvalue.templateToken_ != null && !servingvalue.templateToken_.isEmpty())
            {
                ensureTemplateTokenInitialized();
                templateToken_.addAll(servingvalue.templateToken_);
            }
            if (servingvalue.hasMacroNameReference())
            {
                setMacroNameReference(servingvalue.getMacroNameReference());
            }
            unknownFields = unknownFields.concat(servingvalue.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((ServingValue)generatedmutablemessagelite);
        }

        public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        {
            assertMutable();
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            boolean flag;
            int i;
            try
            {
                output = ByteString.newOutput();
                codedoutputstream = CodedOutputStream.newInstance(output);
            }
            // Misplaced declaration of an exception variable
            catch (CodedInputStream codedinputstream)
            {
                return false;
            }
            flag = false;
            if (flag) goto _L2; else goto _L1
_L1:
            i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 11: default 612
        //                       0: 615
        //                       8: 147
        //                       10: 185
        //                       16: 249
        //                       18: 287
        //                       24: 351
        //                       26: 389
        //                       32: 453
        //                       40: 474
        //                       42: 512
        //                       48: 576;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (listItem_ == null)
            {
                listItem_ = new ArrayList();
            }
            listItem_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L6:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (listItem_ == null)
            {
                listItem_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; listItem_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L7:
            if (mapKey_ == null)
            {
                mapKey_ = new ArrayList();
            }
            mapKey_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L8:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (mapKey_ == null)
            {
                mapKey_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; mapKey_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L9:
            if (mapValue_ == null)
            {
                mapValue_ = new ArrayList();
            }
            mapValue_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L10:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (mapValue_ == null)
            {
                mapValue_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; mapValue_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L11:
            bitField0_ = bitField0_ | 1;
            macroReference_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L12:
            if (templateToken_ == null)
            {
                templateToken_ = new ArrayList();
            }
            templateToken_.add(Integer.valueOf(codedinputstream.readInt32()));
            continue; /* Loop/switch isn't completed */
_L13:
            i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
            if (templateToken_ == null)
            {
                templateToken_ = new ArrayList();
            }
            for (; codedinputstream.getBytesUntilLimit() > 0; templateToken_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
            codedinputstream.popLimit(i);
            continue; /* Loop/switch isn't completed */
_L14:
            bitField0_ = bitField0_ | 2;
            macroNameReference_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
            return true;
_L4:
            flag = true;
            if (true) goto _L16; else goto _L15
_L16:
            break MISSING_BLOCK_LABEL_17;
_L15:
        }

        public ServingValue newMessageForType()
        {
            return new ServingValue();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public ServingValue setListItem(int i, int j)
        {
            assertMutable();
            ensureListItemInitialized();
            listItem_.set(i, Integer.valueOf(j));
            return this;
        }

        public ServingValue setMacroNameReference(int i)
        {
            assertMutable();
            bitField0_ = bitField0_ | 2;
            macroNameReference_ = i;
            return this;
        }

        public ServingValue setMacroReference(int i)
        {
            assertMutable();
            bitField0_ = bitField0_ | 1;
            macroReference_ = i;
            return this;
        }

        public ServingValue setMapKey(int i, int j)
        {
            assertMutable();
            ensureMapKeyInitialized();
            mapKey_.set(i, Integer.valueOf(j));
            return this;
        }

        public ServingValue setMapValue(int i, int j)
        {
            assertMutable();
            ensureMapValueInitialized();
            mapValue_.set(i, Integer.valueOf(j));
            return this;
        }

        public ServingValue setTemplateToken(int i, int j)
        {
            assertMutable();
            ensureTemplateTokenInitialized();
            templateToken_.set(i, Integer.valueOf(j));
            return this;
        }

        protected Object writeReplace()
            throws ObjectStreamException
        {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedoutputstream)
            throws IOException
        {
            int j1 = codedoutputstream.getTotalBytesWritten();
            if (listItem_ != null)
            {
                for (int i = 0; i < listItem_.size(); i++)
                {
                    codedoutputstream.writeInt32(1, ((Integer)listItem_.get(i)).intValue());
                }

            }
            if (mapKey_ != null)
            {
                for (int j = 0; j < mapKey_.size(); j++)
                {
                    codedoutputstream.writeInt32(2, ((Integer)mapKey_.get(j)).intValue());
                }

            }
            if (mapValue_ != null)
            {
                for (int k = 0; k < mapValue_.size(); k++)
                {
                    codedoutputstream.writeInt32(3, ((Integer)mapValue_.get(k)).intValue());
                }

            }
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeInt32(4, macroReference_);
            }
            if (templateToken_ != null)
            {
                for (int l = 0; l < templateToken_.size(); l++)
                {
                    codedoutputstream.writeInt32(5, ((Integer)templateToken_.get(l)).intValue());
                }

            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeInt32(6, macroNameReference_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
            int i1 = codedoutputstream.getTotalBytesWritten();
            if (getCachedSize() != i1 - j1)
            {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            } else
            {
                return;
            }
        }

        static 
        {
            defaultInstance = new ServingValue(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, 101, com.google.tagmanager.protobuf.WireFormat.FieldType.MESSAGE, com/google/analytics/containertag/proto/MutableServing$ServingValue);
        }

        private ServingValue()
        {
            listItem_ = null;
            mapKey_ = null;
            mapValue_ = null;
            templateToken_ = null;
            initFields();
        }

        private ServingValue(boolean flag)
        {
            listItem_ = null;
            mapKey_ = null;
            mapValue_ = null;
            templateToken_ = null;
        }
    }


    private MutableServing()
    {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionregistrylite)
    {
        extensionregistrylite.add(ServingValue.ext);
    }

}
