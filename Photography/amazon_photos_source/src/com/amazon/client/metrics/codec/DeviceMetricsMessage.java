// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DeviceMetricsMessage
{
    public static final class DataPointMessage extends GeneratedMessage
        implements DataPointMessageOrBuilder
    {

        public static Parser PARSER = new AbstractParser() {

            public DataPointMessage parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new DataPointMessage(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        private static final DataPointMessage defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private int sampleSize_;
        private DataType type_;
        private final UnknownFieldSet unknownFields;
        private Object value_;

        public static DataPointMessage getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            name_ = "";
            value_ = "";
            sampleSize_ = 0;
            type_ = DataType.COUNTER;
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(DataPointMessage datapointmessage)
        {
            return newBuilder().mergeFrom(datapointmessage);
        }

        public DataPointMessage getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public ByteString getNameBytes()
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

        public Parser getParserForType()
        {
            return PARSER;
        }

        public int getSampleSize()
        {
            return sampleSize_;
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
                i = j + CodedOutputStream.computeBytesSize(2, getValueBytes());
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeInt32Size(3, sampleSize_);
            }
            i = j;
            if ((bitField0_ & 8) == 8)
            {
                i = j + CodedOutputStream.computeEnumSize(4, type_.getNumber());
            }
            i += getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public DataType getType()
        {
            return type_;
        }

        public final UnknownFieldSet getUnknownFields()
        {
            return unknownFields;
        }

        public ByteString getValueBytes()
        {
            Object obj = value_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                value_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public boolean hasName()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasSampleSize()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasType()
        {
            return (bitField0_ & 8) == 8;
        }

        public boolean hasValue()
        {
            return (bitField0_ & 2) == 2;
        }

        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DeviceMetricsMessage.internal_static_metrics_DataPointMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(com/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage, com/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder);
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
            if (!hasName())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasValue())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasSampleSize())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasType())
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

        protected Builder newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            return new Builder(builderparent);
        }

        public volatile com.google.protobuf.Message.Builder newBuilderForType()
        {
            return newBuilderForType();
        }

        protected volatile com.google.protobuf.Message.Builder newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            return newBuilderForType(builderparent);
        }

        public Builder toBuilder()
        {
            return newBuilder(this);
        }

        public volatile com.google.protobuf.Message.Builder toBuilder()
        {
            return toBuilder();
        }

        public volatile com.google.protobuf.MessageLite.Builder toBuilder()
        {
            return toBuilder();
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
                codedoutputstream.writeBytes(2, getValueBytes());
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeInt32(3, sampleSize_);
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeEnum(4, type_.getNumber());
            }
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new DataPointMessage(true);
            defaultInstance.initFields();
        }




/*
        static Object access$3502(DataPointMessage datapointmessage, Object obj)
        {
            datapointmessage.name_ = obj;
            return obj;
        }

*/



/*
        static Object access$3602(DataPointMessage datapointmessage, Object obj)
        {
            datapointmessage.value_ = obj;
            return obj;
        }

*/


/*
        static int access$3702(DataPointMessage datapointmessage, int i)
        {
            datapointmessage.sampleSize_ = i;
            return i;
        }

*/


/*
        static DataType access$3802(DataPointMessage datapointmessage, DataType datatype)
        {
            datapointmessage.type_ = datatype;
            return datatype;
        }

*/


/*
        static int access$3902(DataPointMessage datapointmessage, int i)
        {
            datapointmessage.bitField0_ = i;
            return i;
        }

*/

        private DataPointMessage(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            com.google.protobuf.UnknownFieldSet.Builder builder;
            boolean flag;
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            initFields();
            builder = UnknownFieldSet.newBuilder();
            flag = false;
_L12:
            if (flag) goto _L2; else goto _L1
_L1:
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 5: default 270
        //                       0: 273
        //                       10: 106
        //                       18: 149
        //                       24: 187
        //                       32: 208;
               goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
            if (!parseUnknownField(codedinputstream, builder, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            bitField0_ = bitField0_ | 1;
            name_ = codedinputstream.readBytes();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            unknownFields = builder.build();
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            bitField0_ = bitField0_ | 2;
            value_ = codedinputstream.readBytes();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L7:
            bitField0_ = bitField0_ | 4;
            sampleSize_ = codedinputstream.readInt32();
            continue; /* Loop/switch isn't completed */
_L8:
            DataType datatype;
            i = codedinputstream.readEnum();
            datatype = DataType.valueOf(i);
            if (datatype != null) goto _L10; else goto _L9
_L9:
            builder.mergeVarintField(4, i);
            continue; /* Loop/switch isn't completed */
_L10:
            bitField0_ = bitField0_ | 8;
            type_ = datatype;
            continue; /* Loop/switch isn't completed */
_L2:
            unknownFields = builder.build();
            makeExtensionsImmutable();
            return;
_L4:
            flag = true;
            if (true) goto _L12; else goto _L11
_L11:
        }


        private DataPointMessage(com.google.protobuf.GeneratedMessage.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private DataPointMessage(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = UnknownFieldSet.getDefaultInstance();
        }
    }

    public static final class DataPointMessage.Builder extends com.google.protobuf.GeneratedMessage.Builder
        implements DataPointMessageOrBuilder
    {

        private int bitField0_;
        private Object name_;
        private int sampleSize_;
        private DataPointMessage.DataType type_;
        private Object value_;

        private static DataPointMessage.Builder create()
        {
            return new DataPointMessage.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
            if (!DataPointMessage.access._fld3500);
        }

        public DataPointMessage build()
        {
            DataPointMessage datapointmessage = buildPartial();
            if (!datapointmessage.isInitialized())
            {
                throw newUninitializedMessageException(datapointmessage);
            } else
            {
                return datapointmessage;
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

        public DataPointMessage buildPartial()
        {
            int j = 1;
            DataPointMessage datapointmessage = new DataPointMessage(this);
            int k = bitField0_;
            int i;
            if ((k & 1) != 1)
            {
                j = 0;
            }
            datapointmessage.name_ = name_;
            i = j;
            if ((k & 2) == 2)
            {
                i = j | 2;
            }
            datapointmessage.value_ = value_;
            j = i;
            if ((k & 4) == 4)
            {
                j = i | 4;
            }
            datapointmessage.sampleSize_ = sampleSize_;
            i = j;
            if ((k & 8) == 8)
            {
                i = j | 8;
            }
            datapointmessage.type_ = type_;
            datapointmessage.bitField0_ = i;
            onBuilt();
            return datapointmessage;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public DataPointMessage.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile com.google.protobuf.AbstractMessage.Builder clone()
        {
            return clone();
        }

        public volatile com.google.protobuf.AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public volatile com.google.protobuf.GeneratedMessage.Builder clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public DataPointMessage getDefaultInstanceForType()
        {
            return DataPointMessage.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
        {
            return DeviceMetricsMessage.internal_static_metrics_DataPointMessage_descriptor;
        }

        public boolean hasName()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasSampleSize()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasType()
        {
            return (bitField0_ & 8) == 8;
        }

        public boolean hasValue()
        {
            return (bitField0_ & 2) == 2;
        }

        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DeviceMetricsMessage.internal_static_metrics_DataPointMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(com/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage, com/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder);
        }

        public final boolean isInitialized()
        {
            while (!hasName() || !hasValue() || !hasSampleSize() || !hasType()) 
            {
                return false;
            }
            return true;
        }

        public DataPointMessage.Builder mergeFrom(DataPointMessage datapointmessage)
        {
            if (datapointmessage == DataPointMessage.getDefaultInstance())
            {
                return this;
            }
            if (datapointmessage.hasName())
            {
                bitField0_ = bitField0_ | 1;
                name_ = datapointmessage.name_;
                onChanged();
            }
            if (datapointmessage.hasValue())
            {
                bitField0_ = bitField0_ | 2;
                value_ = datapointmessage.value_;
                onChanged();
            }
            if (datapointmessage.hasSampleSize())
            {
                setSampleSize(datapointmessage.getSampleSize());
            }
            if (datapointmessage.hasType())
            {
                setType(datapointmessage.getType());
            }
            mergeUnknownFields(datapointmessage.getUnknownFields());
            return this;
        }

        public DataPointMessage.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            codedinputstream = (DataPointMessage)DataPointMessage.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((DataPointMessage) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream = (DataPointMessage)extensionregistrylite.getUnfinishedMessage();
            throw extensionregistrylite;
            extensionregistrylite;
_L2:
            if (codedinputstream != null)
            {
                mergeFrom(((DataPointMessage) (codedinputstream)));
            }
            throw extensionregistrylite;
            extensionregistrylite;
            codedinputstream = null;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public DataPointMessage.Builder mergeFrom(Message message)
        {
            if (message instanceof DataPointMessage)
            {
                return mergeFrom((DataPointMessage)message);
            } else
            {
                super.mergeFrom(message);
                return this;
            }
        }

        public volatile com.google.protobuf.AbstractMessage.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile com.google.protobuf.AbstractMessage.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile com.google.protobuf.AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile com.google.protobuf.Message.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile com.google.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public DataPointMessage.Builder setName(String s)
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

        public DataPointMessage.Builder setSampleSize(int i)
        {
            bitField0_ = bitField0_ | 4;
            sampleSize_ = i;
            onChanged();
            return this;
        }

        public DataPointMessage.Builder setType(DataPointMessage.DataType datatype)
        {
            if (datatype == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 8;
                type_ = datatype;
                onChanged();
                return this;
            }
        }

        public DataPointMessage.Builder setValue(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                value_ = s;
                onChanged();
                return this;
            }
        }


        private DataPointMessage.Builder()
        {
            name_ = "";
            value_ = "";
            type_ = DataPointMessage.DataType.COUNTER;
            maybeForceBuilderInitialization();
        }

        private DataPointMessage.Builder(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            value_ = "";
            type_ = DataPointMessage.DataType.COUNTER;
            maybeForceBuilderInitialization();
        }

    }

    public static final class DataPointMessage.DataType extends Enum
        implements ProtocolMessageEnum
    {

        private static final DataPointMessage.DataType $VALUES[];
        public static final DataPointMessage.DataType CLICKSTREAM;
        public static final DataPointMessage.DataType COUNTER;
        public static final DataPointMessage.DataType DISCRETE;
        public static final DataPointMessage.DataType TIMER;
        private static final DataPointMessage.DataType VALUES[] = values();
        private static com.google.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.protobuf.Internal.EnumLiteMap() {

        };
        private final int index;
        private final int value;

        public static DataPointMessage.DataType valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 0: // '\0'
                return COUNTER;

            case 1: // '\001'
                return TIMER;

            case 2: // '\002'
                return DISCRETE;

            case 3: // '\003'
                return CLICKSTREAM;
            }
        }

        public static DataPointMessage.DataType valueOf(String s)
        {
            return (DataPointMessage.DataType)Enum.valueOf(com/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType, s);
        }

        public static DataPointMessage.DataType[] values()
        {
            return (DataPointMessage.DataType[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            COUNTER = new DataPointMessage.DataType("COUNTER", 0, 0, 0);
            TIMER = new DataPointMessage.DataType("TIMER", 1, 1, 1);
            DISCRETE = new DataPointMessage.DataType("DISCRETE", 2, 2, 2);
            CLICKSTREAM = new DataPointMessage.DataType("CLICKSTREAM", 3, 3, 3);
            $VALUES = (new DataPointMessage.DataType[] {
                COUNTER, TIMER, DISCRETE, CLICKSTREAM
            });
        }

        private DataPointMessage.DataType(String s, int i, int j, int k)
        {
            super(s, i);
            index = j;
            value = k;
        }
    }

    public static interface DataPointMessageOrBuilder
        extends MessageOrBuilder
    {
    }

    public static final class KeyValue extends GeneratedMessage
        implements KeyValueOrBuilder
    {

        public static Parser PARSER = new AbstractParser() {

            public KeyValue parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new KeyValue(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        private static final KeyValue defaultInstance;
        private int bitField0_;
        private Object key_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final UnknownFieldSet unknownFields;
        private Object value_;

        public static KeyValue getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            key_ = "";
            value_ = "";
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(KeyValue keyvalue)
        {
            return newBuilder().mergeFrom(keyvalue);
        }

        public KeyValue getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public ByteString getKeyBytes()
        {
            Object obj = key_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                key_ = obj;
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
                i = 0 + CodedOutputStream.computeBytesSize(1, getKeyBytes());
            }
            int j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeBytesSize(2, getValueBytes());
            }
            i = j + getUnknownFields().getSerializedSize();
            memoizedSerializedSize = i;
            return i;
        }

        public final UnknownFieldSet getUnknownFields()
        {
            return unknownFields;
        }

        public ByteString getValueBytes()
        {
            Object obj = value_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                value_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public boolean hasKey()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasValue()
        {
            return (bitField0_ & 2) == 2;
        }

        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DeviceMetricsMessage.internal_static_metrics_KeyValue_fieldAccessorTable.ensureFieldAccessorsInitialized(com/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue, com/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue$Builder);
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

        protected Builder newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            return new Builder(builderparent);
        }

        public volatile com.google.protobuf.Message.Builder newBuilderForType()
        {
            return newBuilderForType();
        }

        protected volatile com.google.protobuf.Message.Builder newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            return newBuilderForType(builderparent);
        }

        public Builder toBuilder()
        {
            return newBuilder(this);
        }

        public volatile com.google.protobuf.Message.Builder toBuilder()
        {
            return toBuilder();
        }

        public volatile com.google.protobuf.MessageLite.Builder toBuilder()
        {
            return toBuilder();
        }

        public void writeTo(CodedOutputStream codedoutputstream)
            throws IOException
        {
            getSerializedSize();
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeBytes(1, getKeyBytes());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBytes(2, getValueBytes());
            }
            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new KeyValue(true);
            defaultInstance.initFields();
        }




/*
        static Object access$4702(KeyValue keyvalue, Object obj)
        {
            keyvalue.key_ = obj;
            return obj;
        }

*/



/*
        static Object access$4802(KeyValue keyvalue, Object obj)
        {
            keyvalue.value_ = obj;
            return obj;
        }

*/


/*
        static int access$4902(KeyValue keyvalue, int i)
        {
            keyvalue.bitField0_ = i;
            return i;
        }

*/

        private KeyValue(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            com.google.protobuf.UnknownFieldSet.Builder builder;
            boolean flag;
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            initFields();
            builder = UnknownFieldSet.newBuilder();
            flag = false;
_L8:
            if (flag) goto _L2; else goto _L1
_L1:
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 3: default 184
        //                       0: 187
        //                       10: 90
        //                       18: 133;
               goto _L3 _L4 _L5 _L6
_L3:
            if (!parseUnknownField(codedinputstream, builder, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            bitField0_ = bitField0_ | 1;
            key_ = codedinputstream.readBytes();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            unknownFields = builder.build();
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            bitField0_ = bitField0_ | 2;
            value_ = codedinputstream.readBytes();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L2:
            unknownFields = builder.build();
            makeExtensionsImmutable();
            return;
_L4:
            flag = true;
            if (true) goto _L8; else goto _L7
_L7:
        }


        private KeyValue(com.google.protobuf.GeneratedMessage.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private KeyValue(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = UnknownFieldSet.getDefaultInstance();
        }
    }

    public static final class KeyValue.Builder extends com.google.protobuf.GeneratedMessage.Builder
        implements KeyValueOrBuilder
    {

        private int bitField0_;
        private Object key_;
        private Object value_;

        private static KeyValue.Builder create()
        {
            return new KeyValue.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
            if (!access$4700);
        }

        public KeyValue build()
        {
            KeyValue keyvalue = buildPartial();
            if (!keyvalue.isInitialized())
            {
                throw newUninitializedMessageException(keyvalue);
            } else
            {
                return keyvalue;
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

        public KeyValue buildPartial()
        {
            int i = 1;
            KeyValue keyvalue = new KeyValue(this);
            int k = bitField0_;
            int j;
            if ((k & 1) != 1)
            {
                i = 0;
            }
            keyvalue.key_ = key_;
            j = i;
            if ((k & 2) == 2)
            {
                j = i | 2;
            }
            keyvalue.value_ = value_;
            keyvalue.bitField0_ = j;
            onBuilt();
            return keyvalue;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public KeyValue.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile com.google.protobuf.AbstractMessage.Builder clone()
        {
            return clone();
        }

        public volatile com.google.protobuf.AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public volatile com.google.protobuf.GeneratedMessage.Builder clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public KeyValue getDefaultInstanceForType()
        {
            return KeyValue.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
        {
            return DeviceMetricsMessage.internal_static_metrics_KeyValue_descriptor;
        }

        public boolean hasKey()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasValue()
        {
            return (bitField0_ & 2) == 2;
        }

        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DeviceMetricsMessage.internal_static_metrics_KeyValue_fieldAccessorTable.ensureFieldAccessorsInitialized(com/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue, com/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue$Builder);
        }

        public final boolean isInitialized()
        {
            while (!hasKey() || !hasValue()) 
            {
                return false;
            }
            return true;
        }

        public KeyValue.Builder mergeFrom(KeyValue keyvalue)
        {
            if (keyvalue == KeyValue.getDefaultInstance())
            {
                return this;
            }
            if (keyvalue.hasKey())
            {
                bitField0_ = bitField0_ | 1;
                key_ = keyvalue.key_;
                onChanged();
            }
            if (keyvalue.hasValue())
            {
                bitField0_ = bitField0_ | 2;
                value_ = keyvalue.value_;
                onChanged();
            }
            mergeUnknownFields(keyvalue.getUnknownFields());
            return this;
        }

        public KeyValue.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            codedinputstream = (KeyValue)KeyValue.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((KeyValue) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream = (KeyValue)extensionregistrylite.getUnfinishedMessage();
            throw extensionregistrylite;
            extensionregistrylite;
_L2:
            if (codedinputstream != null)
            {
                mergeFrom(((KeyValue) (codedinputstream)));
            }
            throw extensionregistrylite;
            extensionregistrylite;
            codedinputstream = null;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public KeyValue.Builder mergeFrom(Message message)
        {
            if (message instanceof KeyValue)
            {
                return mergeFrom((KeyValue)message);
            } else
            {
                super.mergeFrom(message);
                return this;
            }
        }

        public volatile com.google.protobuf.AbstractMessage.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile com.google.protobuf.AbstractMessage.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile com.google.protobuf.AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile com.google.protobuf.Message.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile com.google.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public KeyValue.Builder setKey(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                key_ = s;
                onChanged();
                return this;
            }
        }

        public KeyValue.Builder setValue(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                value_ = s;
                onChanged();
                return this;
            }
        }


        private KeyValue.Builder()
        {
            key_ = "";
            value_ = "";
            maybeForceBuilderInitialization();
        }

        private KeyValue.Builder(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            key_ = "";
            value_ = "";
            maybeForceBuilderInitialization();
        }

    }

    public static interface KeyValueOrBuilder
        extends MessageOrBuilder
    {
    }

    public static final class MetricBatchMessage extends GeneratedMessage
        implements MetricBatchMessageOrBuilder
    {

        public static Parser PARSER = new AbstractParser() {

            public MetricBatchMessage parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new MetricBatchMessage(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        private static final MetricBatchMessage defaultInstance;
        private int bitField0_;
        private Object deviceSerialNumber_;
        private Object deviceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List metadata_;
        private List metricEntry_;
        private Object tag_;
        private final UnknownFieldSet unknownFields;

        public static MetricBatchMessage getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            deviceSerialNumber_ = "";
            deviceType_ = "";
            tag_ = "";
            metadata_ = Collections.emptyList();
            metricEntry_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(MetricBatchMessage metricbatchmessage)
        {
            return newBuilder().mergeFrom(metricbatchmessage);
        }

        public MetricBatchMessage getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public ByteString getDeviceSerialNumberBytes()
        {
            Object obj = deviceSerialNumber_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                deviceSerialNumber_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public ByteString getDeviceTypeBytes()
        {
            Object obj = deviceType_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                deviceType_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public KeyValue getMetadata(int i)
        {
            return (KeyValue)metadata_.get(i);
        }

        public int getMetadataCount()
        {
            return metadata_.size();
        }

        public MetricEntryMessage getMetricEntry(int i)
        {
            return (MetricEntryMessage)metricEntry_.get(i);
        }

        public int getMetricEntryCount()
        {
            return metricEntry_.size();
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public int getSerializedSize()
        {
            boolean flag = false;
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            int j;
            int k;
            int l;
            if ((bitField0_ & 1) == 1)
            {
                j = CodedOutputStream.computeBytesSize(1, getDeviceSerialNumberBytes()) + 0;
            } else
            {
                j = 0;
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeBytesSize(2, getDeviceTypeBytes());
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeBytesSize(3, getTagBytes());
            }
            k = 0;
            i = j;
            j = k;
            do
            {
                k = ((flag) ? 1 : 0);
                l = i;
                if (j >= metadata_.size())
                {
                    break;
                }
                i += CodedOutputStream.computeMessageSize(4, (MessageLite)metadata_.get(j));
                j++;
            } while (true);
            for (; k < metricEntry_.size(); k++)
            {
                l += CodedOutputStream.computeMessageSize(5, (MessageLite)metricEntry_.get(k));
            }

            i = getUnknownFields().getSerializedSize() + l;
            memoizedSerializedSize = i;
            return i;
        }

        public ByteString getTagBytes()
        {
            Object obj = tag_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                tag_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public final UnknownFieldSet getUnknownFields()
        {
            return unknownFields;
        }

        public boolean hasDeviceSerialNumber()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasDeviceType()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasTag()
        {
            return (bitField0_ & 4) == 4;
        }

        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage, com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder);
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
            if (!hasDeviceSerialNumber())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getMetadataCount(); i++)
            {
                if (!getMetadata(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int j = 0; j < getMetricEntryCount(); j++)
            {
                if (!getMetricEntry(j).isInitialized())
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

        protected Builder newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            return new Builder(builderparent);
        }

        public volatile com.google.protobuf.Message.Builder newBuilderForType()
        {
            return newBuilderForType();
        }

        protected volatile com.google.protobuf.Message.Builder newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            return newBuilderForType(builderparent);
        }

        public Builder toBuilder()
        {
            return newBuilder(this);
        }

        public volatile com.google.protobuf.Message.Builder toBuilder()
        {
            return toBuilder();
        }

        public volatile com.google.protobuf.MessageLite.Builder toBuilder()
        {
            return toBuilder();
        }

        public void writeTo(CodedOutputStream codedoutputstream)
            throws IOException
        {
            boolean flag = false;
            getSerializedSize();
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeBytes(1, getDeviceSerialNumberBytes());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBytes(2, getDeviceTypeBytes());
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeBytes(3, getTagBytes());
            }
            int i = 0;
            int j;
            do
            {
                j = ((flag) ? 1 : 0);
                if (i >= metadata_.size())
                {
                    break;
                }
                codedoutputstream.writeMessage(4, (MessageLite)metadata_.get(i));
                i++;
            } while (true);
            for (; j < metricEntry_.size(); j++)
            {
                codedoutputstream.writeMessage(5, (MessageLite)metricEntry_.get(j));
            }

            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new MetricBatchMessage(true);
            defaultInstance.initFields();
        }



/*
        static List access$1002(MetricBatchMessage metricbatchmessage, List list)
        {
            metricbatchmessage.metadata_ = list;
            return list;
        }

*/



/*
        static List access$1102(MetricBatchMessage metricbatchmessage, List list)
        {
            metricbatchmessage.metricEntry_ = list;
            return list;
        }

*/


/*
        static int access$1202(MetricBatchMessage metricbatchmessage, int i)
        {
            metricbatchmessage.bitField0_ = i;
            return i;
        }

*/






/*
        static Object access$702(MetricBatchMessage metricbatchmessage, Object obj)
        {
            metricbatchmessage.deviceSerialNumber_ = obj;
            return obj;
        }

*/



/*
        static Object access$802(MetricBatchMessage metricbatchmessage, Object obj)
        {
            metricbatchmessage.deviceType_ = obj;
            return obj;
        }

*/



/*
        static Object access$902(MetricBatchMessage metricbatchmessage, Object obj)
        {
            metricbatchmessage.tag_ = obj;
            return obj;
        }

*/

        private MetricBatchMessage(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            com.google.protobuf.UnknownFieldSet.Builder builder;
            int i;
            boolean flag;
            flag = false;
            super();
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            initFields();
            builder = UnknownFieldSet.newBuilder();
            i = 0;
_L15:
            if (flag) goto _L2; else goto _L1
_L1:
            int j;
            int l;
            int i1;
            l = i;
            j = i;
            i1 = i;
            int k = codedinputstream.readTag();
            k;
            JVM INSTR lookupswitch 6: default 583
        //                       0: 586
        //                       10: 142
        //                       18: 255
        //                       26: 321
        //                       34: 366
        //                       42: 447;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
            l = i;
            j = i;
            i1 = i;
            if (!parseUnknownField(codedinputstream, builder, extensionregistrylite, k))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            l = i;
            j = i;
            i1 = i;
            bitField0_ = bitField0_ | 1;
            l = i;
            j = i;
            i1 = i;
            deviceSerialNumber_ = codedinputstream.readBytes();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            j = l;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            if ((j & 8) == 8)
            {
                metadata_ = Collections.unmodifiableList(metadata_);
            }
            if ((j & 0x10) == 16)
            {
                metricEntry_ = Collections.unmodifiableList(metricEntry_);
            }
            unknownFields = builder.build();
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            l = i;
            j = i;
            i1 = i;
            bitField0_ = bitField0_ | 2;
            l = i;
            j = i;
            i1 = i;
            deviceType_ = codedinputstream.readBytes();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            j = i1;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L7:
            l = i;
            j = i;
            i1 = i;
            bitField0_ = bitField0_ | 4;
            l = i;
            j = i;
            i1 = i;
            tag_ = codedinputstream.readBytes();
            continue; /* Loop/switch isn't completed */
_L8:
            k = i;
            if ((i & 8) == 8) goto _L11; else goto _L10
_L10:
            l = i;
            j = i;
            i1 = i;
            metadata_ = new ArrayList();
            k = i | 8;
_L11:
            l = k;
            j = k;
            i1 = k;
            metadata_.add(codedinputstream.readMessage(KeyValue.PARSER, extensionregistrylite));
            i = k;
            continue; /* Loop/switch isn't completed */
_L9:
            k = i;
            if ((i & 0x10) == 16) goto _L13; else goto _L12
_L12:
            l = i;
            j = i;
            i1 = i;
            metricEntry_ = new ArrayList();
            k = i | 0x10;
_L13:
            l = k;
            j = k;
            i1 = k;
            metricEntry_.add(codedinputstream.readMessage(MetricEntryMessage.PARSER, extensionregistrylite));
            i = k;
            continue; /* Loop/switch isn't completed */
_L2:
            if ((i & 8) == 8)
            {
                metadata_ = Collections.unmodifiableList(metadata_);
            }
            if ((i & 0x10) == 16)
            {
                metricEntry_ = Collections.unmodifiableList(metricEntry_);
            }
            unknownFields = builder.build();
            makeExtensionsImmutable();
            return;
_L4:
            flag = true;
            if (true) goto _L15; else goto _L14
_L14:
        }


        private MetricBatchMessage(com.google.protobuf.GeneratedMessage.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private MetricBatchMessage(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = UnknownFieldSet.getDefaultInstance();
        }
    }

    public static final class MetricBatchMessage.Builder extends com.google.protobuf.GeneratedMessage.Builder
        implements MetricBatchMessageOrBuilder
    {

        private int bitField0_;
        private Object deviceSerialNumber_;
        private Object deviceType_;
        private RepeatedFieldBuilder metadataBuilder_;
        private List metadata_;
        private RepeatedFieldBuilder metricEntryBuilder_;
        private List metricEntry_;
        private Object tag_;

        private static MetricBatchMessage.Builder create()
        {
            return new MetricBatchMessage.Builder();
        }

        private void ensureMetadataIsMutable()
        {
            if ((bitField0_ & 8) != 8)
            {
                metadata_ = new ArrayList(metadata_);
                bitField0_ = bitField0_ | 8;
            }
        }

        private void ensureMetricEntryIsMutable()
        {
            if ((bitField0_ & 0x10) != 16)
            {
                metricEntry_ = new ArrayList(metricEntry_);
                bitField0_ = bitField0_ | 0x10;
            }
        }

        private RepeatedFieldBuilder getMetadataFieldBuilder()
        {
            if (metadataBuilder_ == null)
            {
                List list = metadata_;
                boolean flag;
                if ((bitField0_ & 8) == 8)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                metadataBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                metadata_ = null;
            }
            return metadataBuilder_;
        }

        private RepeatedFieldBuilder getMetricEntryFieldBuilder()
        {
            if (metricEntryBuilder_ == null)
            {
                List list = metricEntry_;
                boolean flag;
                if ((bitField0_ & 0x10) == 16)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                metricEntryBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                metricEntry_ = null;
            }
            return metricEntryBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (MetricBatchMessage.access._fld1202)
            {
                getMetadataFieldBuilder();
                getMetricEntryFieldBuilder();
            }
        }

        public MetricBatchMessage.Builder addMetadata(KeyValue keyvalue)
        {
            if (metadataBuilder_ == null)
            {
                if (keyvalue == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureMetadataIsMutable();
                    metadata_.add(keyvalue);
                    onChanged();
                    return this;
                }
            } else
            {
                metadataBuilder_.addMessage(keyvalue);
                return this;
            }
        }

        public MetricBatchMessage.Builder addMetricEntry(MetricEntryMessage metricentrymessage)
        {
            if (metricEntryBuilder_ == null)
            {
                if (metricentrymessage == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureMetricEntryIsMutable();
                    metricEntry_.add(metricentrymessage);
                    onChanged();
                    return this;
                }
            } else
            {
                metricEntryBuilder_.addMessage(metricentrymessage);
                return this;
            }
        }

        public MetricBatchMessage build()
        {
            MetricBatchMessage metricbatchmessage = buildPartial();
            if (!metricbatchmessage.isInitialized())
            {
                throw newUninitializedMessageException(metricbatchmessage);
            } else
            {
                return metricbatchmessage;
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

        public MetricBatchMessage buildPartial()
        {
            int j = 1;
            MetricBatchMessage metricbatchmessage = new MetricBatchMessage(this);
            int k = bitField0_;
            int i;
            if ((k & 1) != 1)
            {
                j = 0;
            }
            metricbatchmessage.deviceSerialNumber_ = deviceSerialNumber_;
            i = j;
            if ((k & 2) == 2)
            {
                i = j | 2;
            }
            metricbatchmessage.deviceType_ = deviceType_;
            j = i;
            if ((k & 4) == 4)
            {
                j = i | 4;
            }
            metricbatchmessage.tag_ = tag_;
            if (metadataBuilder_ == null)
            {
                if ((bitField0_ & 8) == 8)
                {
                    metadata_ = Collections.unmodifiableList(metadata_);
                    bitField0_ = bitField0_ & -9;
                }
                metricbatchmessage.metadata_ = metadata_;
            } else
            {
                metricbatchmessage.metadata_ = metadataBuilder_.build();
            }
            if (metricEntryBuilder_ == null)
            {
                if ((bitField0_ & 0x10) == 16)
                {
                    metricEntry_ = Collections.unmodifiableList(metricEntry_);
                    bitField0_ = bitField0_ & 0xffffffef;
                }
                metricbatchmessage.metricEntry_ = metricEntry_;
            } else
            {
                metricbatchmessage.metricEntry_ = metricEntryBuilder_.build();
            }
            metricbatchmessage.bitField0_ = j;
            onBuilt();
            return metricbatchmessage;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public MetricBatchMessage.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile com.google.protobuf.AbstractMessage.Builder clone()
        {
            return clone();
        }

        public volatile com.google.protobuf.AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public volatile com.google.protobuf.GeneratedMessage.Builder clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public MetricBatchMessage getDefaultInstanceForType()
        {
            return MetricBatchMessage.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
        {
            return DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_descriptor;
        }

        public KeyValue getMetadata(int i)
        {
            if (metadataBuilder_ == null)
            {
                return (KeyValue)metadata_.get(i);
            } else
            {
                return (KeyValue)metadataBuilder_.getMessage(i);
            }
        }

        public int getMetadataCount()
        {
            if (metadataBuilder_ == null)
            {
                return metadata_.size();
            } else
            {
                return metadataBuilder_.getCount();
            }
        }

        public MetricEntryMessage getMetricEntry(int i)
        {
            if (metricEntryBuilder_ == null)
            {
                return (MetricEntryMessage)metricEntry_.get(i);
            } else
            {
                return (MetricEntryMessage)metricEntryBuilder_.getMessage(i);
            }
        }

        public int getMetricEntryCount()
        {
            if (metricEntryBuilder_ == null)
            {
                return metricEntry_.size();
            } else
            {
                return metricEntryBuilder_.getCount();
            }
        }

        public boolean hasDeviceSerialNumber()
        {
            return (bitField0_ & 1) == 1;
        }

        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage, com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder);
        }

        public final boolean isInitialized()
        {
            if (hasDeviceSerialNumber()) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            for (int i = 0; i < getMetadataCount(); i++)
            {
                if (!getMetadata(i).isInitialized())
                {
                    continue; /* Loop/switch isn't completed */
                }
            }

            int j = 0;
label0:
            do
            {
label1:
                {
                    if (j >= getMetricEntryCount())
                    {
                        break label1;
                    }
                    if (!getMetricEntry(j).isInitialized())
                    {
                        break label0;
                    }
                    j++;
                }
            } while (true);
            if (true) goto _L1; else goto _L3
_L3:
            return true;
        }

        public MetricBatchMessage.Builder mergeFrom(MetricBatchMessage metricbatchmessage)
        {
            Object obj = null;
            if (metricbatchmessage == MetricBatchMessage.getDefaultInstance())
            {
                return this;
            }
            if (metricbatchmessage.hasDeviceSerialNumber())
            {
                bitField0_ = bitField0_ | 1;
                deviceSerialNumber_ = metricbatchmessage.deviceSerialNumber_;
                onChanged();
            }
            if (metricbatchmessage.hasDeviceType())
            {
                bitField0_ = bitField0_ | 2;
                deviceType_ = metricbatchmessage.deviceType_;
                onChanged();
            }
            if (metricbatchmessage.hasTag())
            {
                bitField0_ = bitField0_ | 4;
                tag_ = metricbatchmessage.tag_;
                onChanged();
            }
            if (metadataBuilder_ == null)
            {
                if (!metricbatchmessage.metadata_.isEmpty())
                {
                    if (metadata_.isEmpty())
                    {
                        metadata_ = metricbatchmessage.metadata_;
                        bitField0_ = bitField0_ & -9;
                    } else
                    {
                        ensureMetadataIsMutable();
                        metadata_.addAll(metricbatchmessage.metadata_);
                    }
                    onChanged();
                }
            } else
            if (!metricbatchmessage.metadata_.isEmpty())
            {
                if (metadataBuilder_.isEmpty())
                {
                    metadataBuilder_.dispose();
                    metadataBuilder_ = null;
                    metadata_ = metricbatchmessage.metadata_;
                    bitField0_ = bitField0_ & -9;
                    RepeatedFieldBuilder repeatedfieldbuilder;
                    if (MetricBatchMessage.access._fld1202)
                    {
                        repeatedfieldbuilder = getMetadataFieldBuilder();
                    } else
                    {
                        repeatedfieldbuilder = null;
                    }
                    metadataBuilder_ = repeatedfieldbuilder;
                } else
                {
                    metadataBuilder_.addAllMessages(metricbatchmessage.metadata_);
                }
            }
            if (metricEntryBuilder_ == null)
            {
                if (!metricbatchmessage.metricEntry_.isEmpty())
                {
                    if (metricEntry_.isEmpty())
                    {
                        metricEntry_ = metricbatchmessage.metricEntry_;
                        bitField0_ = bitField0_ & 0xffffffef;
                    } else
                    {
                        ensureMetricEntryIsMutable();
                        metricEntry_.addAll(metricbatchmessage.metricEntry_);
                    }
                    onChanged();
                }
            } else
            if (!metricbatchmessage.metricEntry_.isEmpty())
            {
                if (metricEntryBuilder_.isEmpty())
                {
                    metricEntryBuilder_.dispose();
                    metricEntryBuilder_ = null;
                    metricEntry_ = metricbatchmessage.metricEntry_;
                    bitField0_ = bitField0_ & 0xffffffef;
                    RepeatedFieldBuilder repeatedfieldbuilder1 = obj;
                    if (MetricBatchMessage.access._fld1202)
                    {
                        repeatedfieldbuilder1 = getMetricEntryFieldBuilder();
                    }
                    metricEntryBuilder_ = repeatedfieldbuilder1;
                } else
                {
                    metricEntryBuilder_.addAllMessages(metricbatchmessage.metricEntry_);
                }
            }
            mergeUnknownFields(metricbatchmessage.getUnknownFields());
            return this;
        }

        public MetricBatchMessage.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            codedinputstream = (MetricBatchMessage)MetricBatchMessage.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((MetricBatchMessage) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream = (MetricBatchMessage)extensionregistrylite.getUnfinishedMessage();
            throw extensionregistrylite;
            extensionregistrylite;
_L2:
            if (codedinputstream != null)
            {
                mergeFrom(((MetricBatchMessage) (codedinputstream)));
            }
            throw extensionregistrylite;
            extensionregistrylite;
            codedinputstream = null;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public MetricBatchMessage.Builder mergeFrom(Message message)
        {
            if (message instanceof MetricBatchMessage)
            {
                return mergeFrom((MetricBatchMessage)message);
            } else
            {
                super.mergeFrom(message);
                return this;
            }
        }

        public volatile com.google.protobuf.AbstractMessage.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile com.google.protobuf.AbstractMessage.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile com.google.protobuf.AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile com.google.protobuf.Message.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile com.google.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public MetricBatchMessage.Builder setDeviceSerialNumber(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                deviceSerialNumber_ = s;
                onChanged();
                return this;
            }
        }

        public MetricBatchMessage.Builder setDeviceType(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                deviceType_ = s;
                onChanged();
                return this;
            }
        }


        private MetricBatchMessage.Builder()
        {
            deviceSerialNumber_ = "";
            deviceType_ = "";
            tag_ = "";
            metadata_ = Collections.emptyList();
            metricEntry_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private MetricBatchMessage.Builder(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            deviceSerialNumber_ = "";
            deviceType_ = "";
            tag_ = "";
            metadata_ = Collections.emptyList();
            metricEntry_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

    }

    public static interface MetricBatchMessageOrBuilder
        extends MessageOrBuilder
    {
    }

    public static final class MetricEntryMessage extends GeneratedMessage
        implements MetricEntryMessageOrBuilder
    {

        public static Parser PARSER = new AbstractParser() {

            public MetricEntryMessage parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new MetricEntryMessage(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        private static final MetricEntryMessage defaultInstance;
        private int bitField0_;
        private List dataPoint_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object program_;
        private Object source_;
        private long timestamp_;
        private final UnknownFieldSet unknownFields;

        public static MetricEntryMessage getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            timestamp_ = 0L;
            program_ = "";
            source_ = "";
            dataPoint_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(MetricEntryMessage metricentrymessage)
        {
            return newBuilder().mergeFrom(metricentrymessage);
        }

        public DataPointMessage getDataPoint(int i)
        {
            return (DataPointMessage)dataPoint_.get(i);
        }

        public int getDataPointCount()
        {
            return dataPoint_.size();
        }

        public MetricEntryMessage getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public ByteString getProgramBytes()
        {
            Object obj = program_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                program_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public int getSerializedSize()
        {
            boolean flag = false;
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            int j;
            if ((bitField0_ & 1) == 1)
            {
                j = CodedOutputStream.computeInt64Size(1, timestamp_) + 0;
            } else
            {
                j = 0;
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeBytesSize(2, getProgramBytes());
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeBytesSize(3, getSourceBytes());
            }
            i = j;
            for (j = ((flag) ? 1 : 0); j < dataPoint_.size();)
            {
                int k = CodedOutputStream.computeMessageSize(4, (MessageLite)dataPoint_.get(j));
                j++;
                i = k + i;
            }

            i = getUnknownFields().getSerializedSize() + i;
            memoizedSerializedSize = i;
            return i;
        }

        public ByteString getSourceBytes()
        {
            Object obj = source_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                source_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public long getTimestamp()
        {
            return timestamp_;
        }

        public final UnknownFieldSet getUnknownFields()
        {
            return unknownFields;
        }

        public boolean hasProgram()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasSource()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasTimestamp()
        {
            return (bitField0_ & 1) == 1;
        }

        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage, com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder);
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
            if (!hasTimestamp())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasProgram())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasSource())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getDataPointCount(); i++)
            {
                if (!getDataPoint(i).isInitialized())
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

        protected Builder newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            return new Builder(builderparent);
        }

        public volatile com.google.protobuf.Message.Builder newBuilderForType()
        {
            return newBuilderForType();
        }

        protected volatile com.google.protobuf.Message.Builder newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            return newBuilderForType(builderparent);
        }

        public Builder toBuilder()
        {
            return newBuilder(this);
        }

        public volatile com.google.protobuf.Message.Builder toBuilder()
        {
            return toBuilder();
        }

        public volatile com.google.protobuf.MessageLite.Builder toBuilder()
        {
            return toBuilder();
        }

        public void writeTo(CodedOutputStream codedoutputstream)
            throws IOException
        {
            getSerializedSize();
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeInt64(1, timestamp_);
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBytes(2, getProgramBytes());
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeBytes(3, getSourceBytes());
            }
            for (int i = 0; i < dataPoint_.size(); i++)
            {
                codedoutputstream.writeMessage(4, (MessageLite)dataPoint_.get(i));
            }

            getUnknownFields().writeTo(codedoutputstream);
        }

        static 
        {
            defaultInstance = new MetricEntryMessage(true);
            defaultInstance.initFields();
        }



/*
        static long access$2202(MetricEntryMessage metricentrymessage, long l)
        {
            metricentrymessage.timestamp_ = l;
            return l;
        }

*/



/*
        static Object access$2302(MetricEntryMessage metricentrymessage, Object obj)
        {
            metricentrymessage.program_ = obj;
            return obj;
        }

*/



/*
        static Object access$2402(MetricEntryMessage metricentrymessage, Object obj)
        {
            metricentrymessage.source_ = obj;
            return obj;
        }

*/



/*
        static List access$2502(MetricEntryMessage metricentrymessage, List list)
        {
            metricentrymessage.dataPoint_ = list;
            return list;
        }

*/


/*
        static int access$2602(MetricEntryMessage metricentrymessage, int i)
        {
            metricentrymessage.bitField0_ = i;
            return i;
        }

*/


        private MetricEntryMessage(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            com.google.protobuf.UnknownFieldSet.Builder builder;
            int i;
            boolean flag;
            flag = false;
            super();
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            initFields();
            builder = UnknownFieldSet.newBuilder();
            i = 0;
_L12:
            if (flag) goto _L2; else goto _L1
_L1:
            int k;
            int l;
            int i1;
            l = i;
            k = i;
            i1 = i;
            int j = codedinputstream.readTag();
            j;
            JVM INSTR lookupswitch 5: default 452
        //                       0: 455
        //                       8: 134
        //                       18: 226
        //                       26: 292
        //                       34: 337;
               goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
            l = i;
            k = i;
            i1 = i;
            if (!parseUnknownField(codedinputstream, builder, extensionregistrylite, j))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            l = i;
            k = i;
            i1 = i;
            bitField0_ = bitField0_ | 1;
            l = i;
            k = i;
            i1 = i;
            timestamp_ = codedinputstream.readInt64();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            k = l;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            if ((k & 8) == 8)
            {
                dataPoint_ = Collections.unmodifiableList(dataPoint_);
            }
            unknownFields = builder.build();
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            l = i;
            k = i;
            i1 = i;
            bitField0_ = bitField0_ | 2;
            l = i;
            k = i;
            i1 = i;
            program_ = codedinputstream.readBytes();
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            k = i1;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L7:
            l = i;
            k = i;
            i1 = i;
            bitField0_ = bitField0_ | 4;
            l = i;
            k = i;
            i1 = i;
            source_ = codedinputstream.readBytes();
            continue; /* Loop/switch isn't completed */
_L8:
            j = i;
            if ((i & 8) == 8) goto _L10; else goto _L9
_L9:
            l = i;
            k = i;
            i1 = i;
            dataPoint_ = new ArrayList();
            j = i | 8;
_L10:
            l = j;
            k = j;
            i1 = j;
            dataPoint_.add(codedinputstream.readMessage(DataPointMessage.PARSER, extensionregistrylite));
            i = j;
            continue; /* Loop/switch isn't completed */
_L2:
            if ((i & 8) == 8)
            {
                dataPoint_ = Collections.unmodifiableList(dataPoint_);
            }
            unknownFields = builder.build();
            makeExtensionsImmutable();
            return;
_L4:
            flag = true;
            if (true) goto _L12; else goto _L11
_L11:
        }


        private MetricEntryMessage(com.google.protobuf.GeneratedMessage.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private MetricEntryMessage(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = UnknownFieldSet.getDefaultInstance();
        }
    }

    public static final class MetricEntryMessage.Builder extends com.google.protobuf.GeneratedMessage.Builder
        implements MetricEntryMessageOrBuilder
    {

        private int bitField0_;
        private RepeatedFieldBuilder dataPointBuilder_;
        private List dataPoint_;
        private Object program_;
        private Object source_;
        private long timestamp_;

        private static MetricEntryMessage.Builder create()
        {
            return new MetricEntryMessage.Builder();
        }

        private void ensureDataPointIsMutable()
        {
            if ((bitField0_ & 8) != 8)
            {
                dataPoint_ = new ArrayList(dataPoint_);
                bitField0_ = bitField0_ | 8;
            }
        }

        private RepeatedFieldBuilder getDataPointFieldBuilder()
        {
            if (dataPointBuilder_ == null)
            {
                List list = dataPoint_;
                boolean flag;
                if ((bitField0_ & 8) == 8)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                dataPointBuilder_ = new RepeatedFieldBuilder(list, flag, getParentForChildren(), isClean());
                dataPoint_ = null;
            }
            return dataPointBuilder_;
        }

        private void maybeForceBuilderInitialization()
        {
            if (
// JavaClassFileOutputException: get_constant: invalid tag

        public MetricEntryMessage.Builder addDataPoint(DataPointMessage datapointmessage)
        {
            if (dataPointBuilder_ == null)
            {
                if (datapointmessage == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureDataPointIsMutable();
                    dataPoint_.add(datapointmessage);
                    onChanged();
                    return this;
                }
            } else
            {
                dataPointBuilder_.addMessage(datapointmessage);
                return this;
            }
        }

        public MetricEntryMessage build()
        {
            MetricEntryMessage metricentrymessage = buildPartial();
            if (!metricentrymessage.isInitialized())
            {
                throw newUninitializedMessageException(metricentrymessage);
            } else
            {
                return metricentrymessage;
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

        public MetricEntryMessage buildPartial()
        {
            int j = 1;
            MetricEntryMessage metricentrymessage = new MetricEntryMessage(this);
            int k = bitField0_;
            int i;
            if ((k & 1) != 1)
            {
                j = 0;
            }
            metricentrymessage.timestamp_ = timestamp_;
            i = j;
            if ((k & 2) == 2)
            {
                i = j | 2;
            }
            metricentrymessage.program_ = program_;
            j = i;
            if ((k & 4) == 4)
            {
                j = i | 4;
            }
            metricentrymessage.source_ = source_;
            if (dataPointBuilder_ == null)
            {
                if ((bitField0_ & 8) == 8)
                {
                    dataPoint_ = Collections.unmodifiableList(dataPoint_);
                    bitField0_ = bitField0_ & -9;
                }
                metricentrymessage.dataPoint_ = dataPoint_;
            } else
            {
                metricentrymessage.dataPoint_ = dataPointBuilder_.build();
            }
            metricentrymessage.bitField0_ = j;
            onBuilt();
            return metricentrymessage;
        }

        public volatile Message buildPartial()
        {
            return buildPartial();
        }

        public MetricEntryMessage.Builder clone()
        {
            return create().mergeFrom(buildPartial());
        }

        public volatile com.google.protobuf.AbstractMessage.Builder clone()
        {
            return clone();
        }

        public volatile com.google.protobuf.AbstractMessageLite.Builder clone()
        {
            return clone();
        }

        public volatile com.google.protobuf.GeneratedMessage.Builder clone()
        {
            return clone();
        }

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public DataPointMessage getDataPoint(int i)
        {
            if (dataPointBuilder_ == null)
            {
                return (DataPointMessage)dataPoint_.get(i);
            } else
            {
                return (DataPointMessage)dataPointBuilder_.getMessage(i);
            }
        }

        public int getDataPointCount()
        {
            if (dataPointBuilder_ == null)
            {
                return dataPoint_.size();
            } else
            {
                return dataPointBuilder_.getCount();
            }
        }

        public MetricEntryMessage getDefaultInstanceForType()
        {
            return MetricEntryMessage.getDefaultInstance();
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
        {
            return DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_descriptor;
        }

        public boolean hasProgram()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasSource()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasTimestamp()
        {
            return (bitField0_ & 1) == 1;
        }

        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
            return DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage, com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder);
        }

        public final boolean isInitialized()
        {
_L2:
            return false;
            if (!hasTimestamp() || !hasProgram() || !hasSource()) goto _L2; else goto _L1
_L1:
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= getDataPointCount())
                    {
                        break label1;
                    }
                    if (!getDataPoint(i).isInitialized())
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
            if (true) goto _L2; else goto _L3
_L3:
            return true;
        }

        public MetricEntryMessage.Builder mergeFrom(MetricEntryMessage metricentrymessage)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (metricentrymessage == MetricEntryMessage.getDefaultInstance())
            {
                return this;
            }
            if (metricentrymessage.hasTimestamp())
            {
                setTimestamp(metricentrymessage.getTimestamp());
            }
            if (metricentrymessage.hasProgram())
            {
                bitField0_ = bitField0_ | 2;
                program_ = metricentrymessage.program_;
                onChanged();
            }
            if (metricentrymessage.hasSource())
            {
                bitField0_ = bitField0_ | 4;
                source_ = metricentrymessage.source_;
                onChanged();
            }
            if (dataPointBuilder_ != null) goto _L2; else goto _L1
_L1:
            if (!metricentrymessage.dataPoint_.isEmpty())
            {
                if (dataPoint_.isEmpty())
                {
                    dataPoint_ = metricentrymessage.dataPoint_;
                    bitField0_ = bitField0_ & -9;
                } else
                {
                    ensureDataPointIsMutable();
                    dataPoint_.addAll(metricentrymessage.dataPoint_);
                }
                onChanged();
            }
_L4:
            mergeUnknownFields(metricentrymessage.getUnknownFields());
            return this;
_L2:
            if (!metricentrymessage.dataPoint_.isEmpty())
            {
                if (dataPointBuilder_.isEmpty())
                {
                    dataPointBuilder_.dispose();
                    dataPointBuilder_ = null;
                    dataPoint_ = metricentrymessage.dataPoint_;
                    bitField0_ = bitField0_ & -9;
                    if (
// JavaClassFileOutputException: get_constant: invalid tag

        public MetricEntryMessage.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            codedinputstream = (MetricEntryMessage)MetricEntryMessage.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((MetricEntryMessage) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream = (MetricEntryMessage)extensionregistrylite.getUnfinishedMessage();
            throw extensionregistrylite;
            extensionregistrylite;
_L2:
            if (codedinputstream != null)
            {
                mergeFrom(((MetricEntryMessage) (codedinputstream)));
            }
            throw extensionregistrylite;
            extensionregistrylite;
            codedinputstream = null;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public MetricEntryMessage.Builder mergeFrom(Message message)
        {
            if (message instanceof MetricEntryMessage)
            {
                return mergeFrom((MetricEntryMessage)message);
            } else
            {
                mergeFrom(message);
                return this;
            }
        }

        public volatile com.google.protobuf.AbstractMessage.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile com.google.protobuf.AbstractMessage.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile com.google.protobuf.AbstractMessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public volatile com.google.protobuf.Message.Builder mergeFrom(Message message)
        {
            return mergeFrom(message);
        }

        public volatile com.google.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public MetricEntryMessage.Builder setProgram(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                program_ = s;
                onChanged();
                return this;
            }
        }

        public MetricEntryMessage.Builder setSource(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                source_ = s;
                onChanged();
                return this;
            }
        }

        public MetricEntryMessage.Builder setTimestamp(long l)
        {
            bitField0_ = bitField0_ | 1;
            timestamp_ = l;
            onChanged();
            return this;
        }


        private MetricEntryMessage.Builder()
        {
            program_ = "";
            source_ = "";
            dataPoint_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private MetricEntryMessage.Builder(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            program_ = "";
            source_ = "";
            dataPoint_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

    }

    public static interface MetricEntryMessageOrBuilder
        extends MessageOrBuilder
    {
    }


    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;
    private static com.google.protobuf.Descriptors.Descriptor internal_static_metrics_DataPointMessage_descriptor;
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_metrics_DataPointMessage_fieldAccessorTable;
    private static com.google.protobuf.Descriptors.Descriptor internal_static_metrics_KeyValue_descriptor;
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_metrics_KeyValue_fieldAccessorTable;
    private static com.google.protobuf.Descriptors.Descriptor internal_static_metrics_MetricBatchMessage_descriptor;
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_metrics_MetricBatchMessage_fieldAccessorTable;
    private static com.google.protobuf.Descriptors.Descriptor internal_static_metrics_MetricEntryMessage_descriptor;
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_metrics_MetricEntryMessage_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor()
    {
        return descriptor;
    }

    static 
    {
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner internaldescriptorassigner = new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {

            public ExtensionRegistry assignDescriptors(com.google.protobuf.Descriptors.FileDescriptor filedescriptor)
            {
                DeviceMetricsMessage.descriptor = filedescriptor;
                DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_descriptor = (com.google.protobuf.Descriptors.Descriptor)DeviceMetricsMessage.getDescriptor().getMessageTypes().get(0);
                DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_fieldAccessorTable = new FieldAccessorTable(DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_descriptor, new String[] {
                    "DeviceSerialNumber", "DeviceType", "Tag", "Metadata", "MetricEntry"
                });
                DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_descriptor = (com.google.protobuf.Descriptors.Descriptor)DeviceMetricsMessage.getDescriptor().getMessageTypes().get(1);
                DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_fieldAccessorTable = new FieldAccessorTable(DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_descriptor, new String[] {
                    "Timestamp", "Program", "Source", "DataPoint"
                });
                DeviceMetricsMessage.internal_static_metrics_DataPointMessage_descriptor = (com.google.protobuf.Descriptors.Descriptor)DeviceMetricsMessage.getDescriptor().getMessageTypes().get(2);
                DeviceMetricsMessage.internal_static_metrics_DataPointMessage_fieldAccessorTable = new FieldAccessorTable(DeviceMetricsMessage.internal_static_metrics_DataPointMessage_descriptor, new String[] {
                    "Name", "Value", "SampleSize", "Type"
                });
                DeviceMetricsMessage.internal_static_metrics_KeyValue_descriptor = (com.google.protobuf.Descriptors.Descriptor)DeviceMetricsMessage.getDescriptor().getMessageTypes().get(3);
                DeviceMetricsMessage.internal_static_metrics_KeyValue_fieldAccessorTable = new FieldAccessorTable(DeviceMetricsMessage.internal_static_metrics_KeyValue_descriptor, new String[] {
                    "Key", "Value"
                });
                return null;
            }

        };
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] {
            "\n\036DeviceMetricsMessage.0.2.proto\022\007metrics\"\250\001\n\022MetricBatchMessage\022\032\n\022deviceSerialNumber\030\001 \002(\t\022\022\n\ndeviceType\030\002 \001(\t\022\013\n\003tag\030\003 \001(\t\022#\n\bmetadata\030\004 \003(\0132\021.metrics.KeyValue\0220\n\013metricEntry\030\005 \003(\0132\033.metrics.MetricEntryMessage\"v\n\022MetricEntryMessage\022\021\n\ttimestamp\030\001 \002(\003\022\017\n\007program\030\002 \002(\t\022\016\n\006source\030\003 \002(\t\022,\n\tdataPoint\030\004 \003(\0132\031.metrics.DataPointMessage\"\270\001\n\020DataPointMessage\022\f\n\004name\030\001 \002(\t\022\r\n\005value\030\002 \002(\t\022\022\n\nSampleSize\030\003 \002", "(\005\0220\n\004type\030\004 \002(\0162\".metrics.DataPointMessage.DataType\"A\n\bDataType\022\013\n\007COUNTER\020\000\022\t\n\005TIMER\020\001\022\f\n\bDISCRETE\020\002\022\017\n\013CLICKSTREAM\020\003\"&\n\bKeyValue\022\013\n\003key\030\001 \002(\t\022\r\n\005value\030\002 \002(\tB7\n\037com.amazon.client.metrics.codecB\024DeviceMetricsMessage"
        }, new com.google.protobuf.Descriptors.FileDescriptor[0], internaldescriptorassigner);
    }



/*
    static com.google.protobuf.Descriptors.Descriptor access$002(com.google.protobuf.Descriptors.Descriptor descriptor1)
    {
        internal_static_metrics_MetricBatchMessage_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static com.google.protobuf.GeneratedMessage.FieldAccessorTable access$102(com.google.protobuf.GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_metrics_MetricBatchMessage_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static com.google.protobuf.Descriptors.Descriptor access$1502(com.google.protobuf.Descriptors.Descriptor descriptor1)
    {
        internal_static_metrics_MetricEntryMessage_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static com.google.protobuf.GeneratedMessage.FieldAccessorTable access$1602(com.google.protobuf.GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_metrics_MetricEntryMessage_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static com.google.protobuf.Descriptors.Descriptor access$2802(com.google.protobuf.Descriptors.Descriptor descriptor1)
    {
        internal_static_metrics_DataPointMessage_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static com.google.protobuf.GeneratedMessage.FieldAccessorTable access$2902(com.google.protobuf.GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_metrics_DataPointMessage_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/



/*
    static com.google.protobuf.Descriptors.Descriptor access$4002(com.google.protobuf.Descriptors.Descriptor descriptor1)
    {
        internal_static_metrics_KeyValue_descriptor = descriptor1;
        return descriptor1;
    }

*/



/*
    static com.google.protobuf.GeneratedMessage.FieldAccessorTable access$4102(com.google.protobuf.GeneratedMessage.FieldAccessorTable fieldaccessortable)
    {
        internal_static_metrics_KeyValue_fieldAccessorTable = fieldaccessortable;
        return fieldaccessortable;
    }

*/


/*
    static com.google.protobuf.Descriptors.FileDescriptor access$5002(com.google.protobuf.Descriptors.FileDescriptor filedescriptor)
    {
        descriptor = filedescriptor;
        return filedescriptor;
    }

*/
}
