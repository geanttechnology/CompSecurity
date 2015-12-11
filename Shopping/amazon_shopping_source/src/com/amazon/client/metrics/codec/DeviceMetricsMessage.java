// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DeviceMetricsMessage
{
    public static final class DataPointMessage extends GeneratedMessage
        implements DataPointMessageOrBuilder
    {

        public static final int NAME_FIELD_NUMBER = 1;
        public static final int SAMPLESIZE_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 4;
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final DataPointMessage defaultInstance;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private int sampleSize_;
        private DataType type_;
        private Object value_;

        public static DataPointMessage getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
        {
            return DeviceMetricsMessage.internal_static_metrics_DataPointMessage_descriptor;
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

        private ByteString getValueBytes()
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

        public static DataPointMessage parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(inputstream))
            {
                return builder.buildParsed();
            } else
            {
                return null;
            }
        }

        public static DataPointMessage parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(inputstream, extensionregistrylite))
            {
                return builder.buildParsed();
            } else
            {
                return null;
            }
        }

        public static DataPointMessage parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(bytestring)).buildParsed();
        }

        public static DataPointMessage parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(bytestring, extensionregistrylite)).buildParsed();
        }

        public static DataPointMessage parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return ((Builder)newBuilder().mergeFrom(codedinputstream)).buildParsed();
        }

        public static DataPointMessage parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return newBuilder().mergeFrom(codedinputstream, extensionregistrylite).buildParsed();
        }

        public static DataPointMessage parseFrom(InputStream inputstream)
            throws IOException
        {
            return ((Builder)newBuilder().mergeFrom(inputstream)).buildParsed();
        }

        public static DataPointMessage parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return ((Builder)newBuilder().mergeFrom(inputstream, extensionregistrylite)).buildParsed();
        }

        public static DataPointMessage parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(abyte0)).buildParsed();
        }

        public static DataPointMessage parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(abyte0, extensionregistrylite)).buildParsed();
        }

        public DataPointMessage getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
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

        public String getValue()
        {
            Object obj = value_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                value_ = s;
            }
            return s;
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
            return DeviceMetricsMessage.internal_static_metrics_DataPointMessage_fieldAccessorTable;
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

        public volatile com.google.protobuf.MessageLite.Builder newBuilderForType()
        {
            return newBuilderForType();
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

        private DataPointMessage(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private DataPointMessage(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
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

        private DataPointMessage buildParsed()
            throws InvalidProtocolBufferException
        {
            DataPointMessage datapointmessage = buildPartial();
            if (!datapointmessage.isInitialized())
            {
                throw newUninitializedMessageException(datapointmessage).asInvalidProtocolBufferException();
            } else
            {
                return datapointmessage;
            }
        }

        private static DataPointMessage.Builder create()
        {
            return new DataPointMessage.Builder();
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
        {
            return DeviceMetricsMessage.internal_static_metrics_DataPointMessage_descriptor;
        }

        private void maybeForceBuilderInitialization()
        {
            if (!
// JavaClassFileOutputException: get_constant: invalid tag

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

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public DataPointMessage.Builder clear()
        {
            clear();
            name_ = "";
            bitField0_ = bitField0_ & -2;
            value_ = "";
            bitField0_ = bitField0_ & -3;
            sampleSize_ = 0;
            bitField0_ = bitField0_ & -5;
            type_ = DataPointMessage.DataType.COUNTER;
            bitField0_ = bitField0_ & -9;
            return this;
        }

        public volatile com.google.protobuf.AbstractMessage.Builder clear()
        {
            return clear();
        }

        public volatile com.google.protobuf.GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile com.google.protobuf.Message.Builder clear()
        {
            return clear();
        }

        public volatile com.google.protobuf.MessageLite.Builder clear()
        {
            return clear();
        }

        public DataPointMessage.Builder clearName()
        {
            bitField0_ = bitField0_ & -2;
            name_ = DataPointMessage.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public DataPointMessage.Builder clearSampleSize()
        {
            bitField0_ = bitField0_ & -5;
            sampleSize_ = 0;
            onChanged();
            return this;
        }

        public DataPointMessage.Builder clearType()
        {
            bitField0_ = bitField0_ & -9;
            type_ = DataPointMessage.DataType.COUNTER;
            onChanged();
            return this;
        }

        public DataPointMessage.Builder clearValue()
        {
            bitField0_ = bitField0_ & -3;
            value_ = DataPointMessage.getDefaultInstance().getValue();
            onChanged();
            return this;
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

        public volatile com.google.protobuf.Message.Builder clone()
        {
            return clone();
        }

        public volatile com.google.protobuf.MessageLite.Builder clone()
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

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
        {
            return DataPointMessage.getDescriptor();
        }

        public String getName()
        {
            Object obj = name_;
            if (!(obj instanceof String))
            {
                obj = ((ByteString)obj).toStringUtf8();
                name_ = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public int getSampleSize()
        {
            return sampleSize_;
        }

        public DataPointMessage.DataType getType()
        {
            return type_;
        }

        public String getValue()
        {
            Object obj = value_;
            if (!(obj instanceof String))
            {
                obj = ((ByteString)obj).toStringUtf8();
                value_ = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
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
            return DeviceMetricsMessage.internal_static_metrics_DataPointMessage_fieldAccessorTable;
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
                setName(datapointmessage.getName());
            }
            if (datapointmessage.hasValue())
            {
                setValue(datapointmessage.getValue());
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
            com.google.protobuf.UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder(getUnknownFields());
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
                    value_ = codedinputstream.readBytes();
                    break;

                case 24: // '\030'
                    bitField0_ = bitField0_ | 4;
                    sampleSize_ = codedinputstream.readInt32();
                    break;

                case 32: // ' '
                    int j = codedinputstream.readEnum();
                    DataPointMessage.DataType datatype = DataPointMessage.DataType.valueOf(j);
                    if (datatype == null)
                    {
                        builder.mergeVarintField(4, j);
                    } else
                    {
                        bitField0_ = bitField0_ | 8;
                        type_ = datatype;
                    }
                    break;
                }
            } while (true);
        }

        public DataPointMessage.Builder mergeFrom(Message message)
        {
            if (message instanceof DataPointMessage)
            {
                return mergeFrom((DataPointMessage)message);
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

        public volatile com.google.protobuf.Message.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

        void setName(ByteString bytestring)
        {
            bitField0_ = bitField0_ | 1;
            name_ = bytestring;
            onChanged();
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

        void setValue(ByteString bytestring)
        {
            bitField0_ = bitField0_ | 2;
            value_ = bytestring;
            onChanged();
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
        public static final int CLICKSTREAM_VALUE = 3;
        public static final DataPointMessage.DataType COUNTER;
        public static final int COUNTER_VALUE = 0;
        public static final DataPointMessage.DataType DISCRETE;
        public static final int DISCRETE_VALUE = 2;
        public static final DataPointMessage.DataType TIMER;
        public static final int TIMER_VALUE = 1;
        private static final DataPointMessage.DataType VALUES[];
        private static com.google.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.protobuf.Internal.EnumLiteMap() {

            public DataPointMessage.DataType findValueByNumber(int i)
            {
                return DataPointMessage.DataType.valueOf(i);
            }

            public volatile com.google.protobuf.Internal.EnumLite findValueByNumber(int i)
            {
                return findValueByNumber(i);
            }

        };
        private final int index;
        private final int value;

        public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor()
        {
            return (com.google.protobuf.Descriptors.EnumDescriptor)DataPointMessage.getDescriptor().getEnumTypes().get(0);
        }

        public static com.google.protobuf.Internal.EnumLiteMap internalGetValueMap()
        {
            return internalValueMap;
        }

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

        public static DataPointMessage.DataType valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor enumvaluedescriptor)
        {
            if (enumvaluedescriptor.getType() != getDescriptor())
            {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else
            {
                return VALUES[enumvaluedescriptor.getIndex()];
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

        public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType()
        {
            return getDescriptor();
        }

        public final int getNumber()
        {
            return value;
        }

        public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor()
        {
            return (com.google.protobuf.Descriptors.EnumValueDescriptor)getDescriptor().getValues().get(index);
        }

        static 
        {
            COUNTER = new DataType("COUNTER", 0, 0, 0);
            TIMER = new DataType("TIMER", 1, 1, 1);
            DISCRETE = new DataType("DISCRETE", 2, 2, 2);
            CLICKSTREAM = new DataType("CLICKSTREAM", 3, 3, 3);
            $VALUES = (new DataPointMessage.DataType[] {
                COUNTER, TIMER, DISCRETE, CLICKSTREAM
            });
            VALUES = (new DataPointMessage.DataType[] {
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

        public abstract String getName();

        public abstract int getSampleSize();

        public abstract DataPointMessage.DataType getType();

        public abstract String getValue();

        public abstract boolean hasName();

        public abstract boolean hasSampleSize();

        public abstract boolean hasType();

        public abstract boolean hasValue();
    }

    public static final class KeyValue extends GeneratedMessage
        implements KeyValueOrBuilder
    {

        public static final int KEY_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final KeyValue defaultInstance;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private Object key_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object value_;

        public static KeyValue getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
        {
            return DeviceMetricsMessage.internal_static_metrics_KeyValue_descriptor;
        }

        private ByteString getKeyBytes()
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

        private ByteString getValueBytes()
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

        public static KeyValue parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(inputstream))
            {
                return builder.buildParsed();
            } else
            {
                return null;
            }
        }

        public static KeyValue parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(inputstream, extensionregistrylite))
            {
                return builder.buildParsed();
            } else
            {
                return null;
            }
        }

        public static KeyValue parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(bytestring)).buildParsed();
        }

        public static KeyValue parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(bytestring, extensionregistrylite)).buildParsed();
        }

        public static KeyValue parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return ((Builder)newBuilder().mergeFrom(codedinputstream)).buildParsed();
        }

        public static KeyValue parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return newBuilder().mergeFrom(codedinputstream, extensionregistrylite).buildParsed();
        }

        public static KeyValue parseFrom(InputStream inputstream)
            throws IOException
        {
            return ((Builder)newBuilder().mergeFrom(inputstream)).buildParsed();
        }

        public static KeyValue parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return ((Builder)newBuilder().mergeFrom(inputstream, extensionregistrylite)).buildParsed();
        }

        public static KeyValue parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(abyte0)).buildParsed();
        }

        public static KeyValue parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(abyte0, extensionregistrylite)).buildParsed();
        }

        public KeyValue getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public String getKey()
        {
            Object obj = key_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                key_ = s;
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

        public String getValue()
        {
            Object obj = value_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                value_ = s;
            }
            return s;
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
            return DeviceMetricsMessage.internal_static_metrics_KeyValue_fieldAccessorTable;
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

        public volatile com.google.protobuf.MessageLite.Builder newBuilderForType()
        {
            return newBuilderForType();
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

        private KeyValue(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private KeyValue(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }
    }

    public static final class KeyValue.Builder extends com.google.protobuf.GeneratedMessage.Builder
        implements KeyValueOrBuilder
    {

        private int bitField0_;
        private Object key_;
        private Object value_;

        private KeyValue buildParsed()
            throws InvalidProtocolBufferException
        {
            KeyValue keyvalue = buildPartial();
            if (!keyvalue.isInitialized())
            {
                throw newUninitializedMessageException(keyvalue).asInvalidProtocolBufferException();
            } else
            {
                return keyvalue;
            }
        }

        private static KeyValue.Builder create()
        {
            return new KeyValue.Builder();
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
        {
            return DeviceMetricsMessage.internal_static_metrics_KeyValue_descriptor;
        }

        private void maybeForceBuilderInitialization()
        {
            if (!newUninitializedMessageException);
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

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public KeyValue.Builder clear()
        {
            super.clear();
            key_ = "";
            bitField0_ = bitField0_ & -2;
            value_ = "";
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public volatile com.google.protobuf.AbstractMessage.Builder clear()
        {
            return clear();
        }

        public volatile com.google.protobuf.GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile com.google.protobuf.Message.Builder clear()
        {
            return clear();
        }

        public volatile com.google.protobuf.MessageLite.Builder clear()
        {
            return clear();
        }

        public KeyValue.Builder clearKey()
        {
            bitField0_ = bitField0_ & -2;
            key_ = KeyValue.getDefaultInstance().getKey();
            onChanged();
            return this;
        }

        public KeyValue.Builder clearValue()
        {
            bitField0_ = bitField0_ & -3;
            value_ = KeyValue.getDefaultInstance().getValue();
            onChanged();
            return this;
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

        public volatile com.google.protobuf.Message.Builder clone()
        {
            return clone();
        }

        public volatile com.google.protobuf.MessageLite.Builder clone()
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

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
        {
            return KeyValue.getDescriptor();
        }

        public String getKey()
        {
            Object obj = key_;
            if (!(obj instanceof String))
            {
                obj = ((ByteString)obj).toStringUtf8();
                key_ = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public String getValue()
        {
            Object obj = value_;
            if (!(obj instanceof String))
            {
                obj = ((ByteString)obj).toStringUtf8();
                value_ = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
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
            return DeviceMetricsMessage.internal_static_metrics_KeyValue_fieldAccessorTable;
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
                setKey(keyvalue.getKey());
            }
            if (keyvalue.hasValue())
            {
                setValue(keyvalue.getValue());
            }
            mergeUnknownFields(keyvalue.getUnknownFields());
            return this;
        }

        public KeyValue.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            com.google.protobuf.UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder(getUnknownFields());
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
                    key_ = codedinputstream.readBytes();
                    break;

                case 18: // '\022'
                    bitField0_ = bitField0_ | 2;
                    value_ = codedinputstream.readBytes();
                    break;
                }
            } while (true);
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

        public volatile com.google.protobuf.Message.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

        void setKey(ByteString bytestring)
        {
            bitField0_ = bitField0_ | 1;
            key_ = bytestring;
            onChanged();
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

        void setValue(ByteString bytestring)
        {
            bitField0_ = bitField0_ | 2;
            value_ = bytestring;
            onChanged();
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

        public abstract String getKey();

        public abstract String getValue();

        public abstract boolean hasKey();

        public abstract boolean hasValue();
    }

    public static final class MetricBatchMessage extends GeneratedMessage
        implements MetricBatchMessageOrBuilder
    {

        public static final int DEVICESERIALNUMBER_FIELD_NUMBER = 1;
        public static final int DEVICETYPE_FIELD_NUMBER = 2;
        public static final int METADATA_FIELD_NUMBER = 4;
        public static final int METRICENTRY_FIELD_NUMBER = 5;
        public static final int TAG_FIELD_NUMBER = 3;
        private static final MetricBatchMessage defaultInstance;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private Object deviceSerialNumber_;
        private Object deviceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List metadata_;
        private List metricEntry_;
        private Object tag_;

        public static MetricBatchMessage getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
        {
            return DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_descriptor;
        }

        private ByteString getDeviceSerialNumberBytes()
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

        private ByteString getDeviceTypeBytes()
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

        private ByteString getTagBytes()
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

        public static MetricBatchMessage parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(inputstream))
            {
                return builder.buildParsed();
            } else
            {
                return null;
            }
        }

        public static MetricBatchMessage parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(inputstream, extensionregistrylite))
            {
                return builder.buildParsed();
            } else
            {
                return null;
            }
        }

        public static MetricBatchMessage parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(bytestring)).buildParsed();
        }

        public static MetricBatchMessage parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(bytestring, extensionregistrylite)).buildParsed();
        }

        public static MetricBatchMessage parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return ((Builder)newBuilder().mergeFrom(codedinputstream)).buildParsed();
        }

        public static MetricBatchMessage parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return newBuilder().mergeFrom(codedinputstream, extensionregistrylite).buildParsed();
        }

        public static MetricBatchMessage parseFrom(InputStream inputstream)
            throws IOException
        {
            return ((Builder)newBuilder().mergeFrom(inputstream)).buildParsed();
        }

        public static MetricBatchMessage parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return ((Builder)newBuilder().mergeFrom(inputstream, extensionregistrylite)).buildParsed();
        }

        public static MetricBatchMessage parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(abyte0)).buildParsed();
        }

        public static MetricBatchMessage parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(abyte0, extensionregistrylite)).buildParsed();
        }

        public MetricBatchMessage getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public String getDeviceSerialNumber()
        {
            Object obj = deviceSerialNumber_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                deviceSerialNumber_ = s;
            }
            return s;
        }

        public String getDeviceType()
        {
            Object obj = deviceType_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                deviceType_ = s;
            }
            return s;
        }

        public KeyValue getMetadata(int i)
        {
            return (KeyValue)metadata_.get(i);
        }

        public int getMetadataCount()
        {
            return metadata_.size();
        }

        public List getMetadataList()
        {
            return metadata_;
        }

        public KeyValueOrBuilder getMetadataOrBuilder(int i)
        {
            return (KeyValueOrBuilder)metadata_.get(i);
        }

        public List getMetadataOrBuilderList()
        {
            return metadata_;
        }

        public MetricEntryMessage getMetricEntry(int i)
        {
            return (MetricEntryMessage)metricEntry_.get(i);
        }

        public int getMetricEntryCount()
        {
            return metricEntry_.size();
        }

        public List getMetricEntryList()
        {
            return metricEntry_;
        }

        public MetricEntryMessageOrBuilder getMetricEntryOrBuilder(int i)
        {
            return (MetricEntryMessageOrBuilder)metricEntry_.get(i);
        }

        public List getMetricEntryOrBuilderList()
        {
            return metricEntry_;
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

        public String getTag()
        {
            Object obj = tag_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                tag_ = s;
            }
            return s;
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
            return DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_fieldAccessorTable;
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

        public volatile com.google.protobuf.MessageLite.Builder newBuilderForType()
        {
            return newBuilderForType();
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

        private MetricBatchMessage(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private MetricBatchMessage(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
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

        private MetricBatchMessage buildParsed()
            throws InvalidProtocolBufferException
        {
            MetricBatchMessage metricbatchmessage = buildPartial();
            if (!metricbatchmessage.isInitialized())
            {
                throw newUninitializedMessageException(metricbatchmessage).asInvalidProtocolBufferException();
            } else
            {
                return metricbatchmessage;
            }
        }

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

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
        {
            return DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_descriptor;
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
            if (UninitializedMessageException)
            {
                getMetadataFieldBuilder();
                getMetricEntryFieldBuilder();
            }
        }

        public MetricBatchMessage.Builder addAllMetadata(Iterable iterable)
        {
            if (metadataBuilder_ == null)
            {
                ensureMetadataIsMutable();
                com.google.protobuf.GeneratedMessage.Builder.addAll(iterable, metadata_);
                onChanged();
                return this;
            } else
            {
                metadataBuilder_.addAllMessages(iterable);
                return this;
            }
        }

        public MetricBatchMessage.Builder addAllMetricEntry(Iterable iterable)
        {
            if (metricEntryBuilder_ == null)
            {
                ensureMetricEntryIsMutable();
                com.google.protobuf.GeneratedMessage.Builder.addAll(iterable, metricEntry_);
                onChanged();
                return this;
            } else
            {
                metricEntryBuilder_.addAllMessages(iterable);
                return this;
            }
        }

        public MetricBatchMessage.Builder addMetadata(int i, KeyValue.Builder builder)
        {
            if (metadataBuilder_ == null)
            {
                ensureMetadataIsMutable();
                metadata_.add(i, builder.build());
                onChanged();
                return this;
            } else
            {
                metadataBuilder_.addMessage(i, builder.build());
                return this;
            }
        }

        public MetricBatchMessage.Builder addMetadata(int i, KeyValue keyvalue)
        {
            if (metadataBuilder_ == null)
            {
                if (keyvalue == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureMetadataIsMutable();
                    metadata_.add(i, keyvalue);
                    onChanged();
                    return this;
                }
            } else
            {
                metadataBuilder_.addMessage(i, keyvalue);
                return this;
            }
        }

        public MetricBatchMessage.Builder addMetadata(KeyValue.Builder builder)
        {
            if (metadataBuilder_ == null)
            {
                ensureMetadataIsMutable();
                metadata_.add(builder.build());
                onChanged();
                return this;
            } else
            {
                metadataBuilder_.addMessage(builder.build());
                return this;
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

        public KeyValue.Builder addMetadataBuilder()
        {
            return (KeyValue.Builder)getMetadataFieldBuilder().addBuilder(KeyValue.getDefaultInstance());
        }

        public KeyValue.Builder addMetadataBuilder(int i)
        {
            return (KeyValue.Builder)getMetadataFieldBuilder().addBuilder(i, KeyValue.getDefaultInstance());
        }

        public MetricBatchMessage.Builder addMetricEntry(int i, MetricEntryMessage.Builder builder)
        {
            if (metricEntryBuilder_ == null)
            {
                ensureMetricEntryIsMutable();
                metricEntry_.add(i, builder.build());
                onChanged();
                return this;
            } else
            {
                metricEntryBuilder_.addMessage(i, builder.build());
                return this;
            }
        }

        public MetricBatchMessage.Builder addMetricEntry(int i, MetricEntryMessage metricentrymessage)
        {
            if (metricEntryBuilder_ == null)
            {
                if (metricentrymessage == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureMetricEntryIsMutable();
                    metricEntry_.add(i, metricentrymessage);
                    onChanged();
                    return this;
                }
            } else
            {
                metricEntryBuilder_.addMessage(i, metricentrymessage);
                return this;
            }
        }

        public MetricBatchMessage.Builder addMetricEntry(MetricEntryMessage.Builder builder)
        {
            if (metricEntryBuilder_ == null)
            {
                ensureMetricEntryIsMutable();
                metricEntry_.add(builder.build());
                onChanged();
                return this;
            } else
            {
                metricEntryBuilder_.addMessage(builder.build());
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

        public MetricEntryMessage.Builder addMetricEntryBuilder()
        {
            return (MetricEntryMessage.Builder)getMetricEntryFieldBuilder().addBuilder(MetricEntryMessage.getDefaultInstance());
        }

        public MetricEntryMessage.Builder addMetricEntryBuilder(int i)
        {
            return (MetricEntryMessage.Builder)getMetricEntryFieldBuilder().addBuilder(i, MetricEntryMessage.getDefaultInstance());
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

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public MetricBatchMessage.Builder clear()
        {
            super.clear();
            deviceSerialNumber_ = "";
            bitField0_ = bitField0_ & -2;
            deviceType_ = "";
            bitField0_ = bitField0_ & -3;
            tag_ = "";
            bitField0_ = bitField0_ & -5;
            if (metadataBuilder_ == null)
            {
                metadata_ = Collections.emptyList();
                bitField0_ = bitField0_ & -9;
            } else
            {
                metadataBuilder_.clear();
            }
            if (metricEntryBuilder_ == null)
            {
                metricEntry_ = Collections.emptyList();
                bitField0_ = bitField0_ & 0xffffffef;
                return this;
            } else
            {
                metricEntryBuilder_.clear();
                return this;
            }
        }

        public volatile com.google.protobuf.AbstractMessage.Builder clear()
        {
            return clear();
        }

        public volatile com.google.protobuf.GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile com.google.protobuf.Message.Builder clear()
        {
            return clear();
        }

        public volatile com.google.protobuf.MessageLite.Builder clear()
        {
            return clear();
        }

        public MetricBatchMessage.Builder clearDeviceSerialNumber()
        {
            bitField0_ = bitField0_ & -2;
            deviceSerialNumber_ = MetricBatchMessage.getDefaultInstance().getDeviceSerialNumber();
            onChanged();
            return this;
        }

        public MetricBatchMessage.Builder clearDeviceType()
        {
            bitField0_ = bitField0_ & -3;
            deviceType_ = MetricBatchMessage.getDefaultInstance().getDeviceType();
            onChanged();
            return this;
        }

        public MetricBatchMessage.Builder clearMetadata()
        {
            if (metadataBuilder_ == null)
            {
                metadata_ = Collections.emptyList();
                bitField0_ = bitField0_ & -9;
                onChanged();
                return this;
            } else
            {
                metadataBuilder_.clear();
                return this;
            }
        }

        public MetricBatchMessage.Builder clearMetricEntry()
        {
            if (metricEntryBuilder_ == null)
            {
                metricEntry_ = Collections.emptyList();
                bitField0_ = bitField0_ & 0xffffffef;
                onChanged();
                return this;
            } else
            {
                metricEntryBuilder_.clear();
                return this;
            }
        }

        public MetricBatchMessage.Builder clearTag()
        {
            bitField0_ = bitField0_ & -5;
            tag_ = MetricBatchMessage.getDefaultInstance().getTag();
            onChanged();
            return this;
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

        public volatile com.google.protobuf.Message.Builder clone()
        {
            return clone();
        }

        public volatile com.google.protobuf.MessageLite.Builder clone()
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

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
        {
            return MetricBatchMessage.getDescriptor();
        }

        public String getDeviceSerialNumber()
        {
            Object obj = deviceSerialNumber_;
            if (!(obj instanceof String))
            {
                obj = ((ByteString)obj).toStringUtf8();
                deviceSerialNumber_ = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public String getDeviceType()
        {
            Object obj = deviceType_;
            if (!(obj instanceof String))
            {
                obj = ((ByteString)obj).toStringUtf8();
                deviceType_ = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
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

        public KeyValue.Builder getMetadataBuilder(int i)
        {
            return (KeyValue.Builder)getMetadataFieldBuilder().getBuilder(i);
        }

        public List getMetadataBuilderList()
        {
            return getMetadataFieldBuilder().getBuilderList();
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

        public List getMetadataList()
        {
            if (metadataBuilder_ == null)
            {
                return Collections.unmodifiableList(metadata_);
            } else
            {
                return metadataBuilder_.getMessageList();
            }
        }

        public KeyValueOrBuilder getMetadataOrBuilder(int i)
        {
            if (metadataBuilder_ == null)
            {
                return (KeyValueOrBuilder)metadata_.get(i);
            } else
            {
                return (KeyValueOrBuilder)metadataBuilder_.getMessageOrBuilder(i);
            }
        }

        public List getMetadataOrBuilderList()
        {
            if (metadataBuilder_ != null)
            {
                return metadataBuilder_.getMessageOrBuilderList();
            } else
            {
                return Collections.unmodifiableList(metadata_);
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

        public MetricEntryMessage.Builder getMetricEntryBuilder(int i)
        {
            return (MetricEntryMessage.Builder)getMetricEntryFieldBuilder().getBuilder(i);
        }

        public List getMetricEntryBuilderList()
        {
            return getMetricEntryFieldBuilder().getBuilderList();
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

        public List getMetricEntryList()
        {
            if (metricEntryBuilder_ == null)
            {
                return Collections.unmodifiableList(metricEntry_);
            } else
            {
                return metricEntryBuilder_.getMessageList();
            }
        }

        public MetricEntryMessageOrBuilder getMetricEntryOrBuilder(int i)
        {
            if (metricEntryBuilder_ == null)
            {
                return (MetricEntryMessageOrBuilder)metricEntry_.get(i);
            } else
            {
                return (MetricEntryMessageOrBuilder)metricEntryBuilder_.getMessageOrBuilder(i);
            }
        }

        public List getMetricEntryOrBuilderList()
        {
            if (metricEntryBuilder_ != null)
            {
                return metricEntryBuilder_.getMessageOrBuilderList();
            } else
            {
                return Collections.unmodifiableList(metricEntry_);
            }
        }

        public String getTag()
        {
            Object obj = tag_;
            if (!(obj instanceof String))
            {
                obj = ((ByteString)obj).toStringUtf8();
                tag_ = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
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
            return DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_fieldAccessorTable;
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
                setDeviceSerialNumber(metricbatchmessage.getDeviceSerialNumber());
            }
            if (metricbatchmessage.hasDeviceType())
            {
                setDeviceType(metricbatchmessage.getDeviceType());
            }
            if (metricbatchmessage.hasTag())
            {
                setTag(metricbatchmessage.getTag());
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
                    if (UninitializedMessageException)
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
                    if (UninitializedMessageException)
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
            com.google.protobuf.UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder(getUnknownFields());
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
                    deviceSerialNumber_ = codedinputstream.readBytes();
                    break;

                case 18: // '\022'
                    bitField0_ = bitField0_ | 2;
                    deviceType_ = codedinputstream.readBytes();
                    break;

                case 26: // '\032'
                    bitField0_ = bitField0_ | 4;
                    tag_ = codedinputstream.readBytes();
                    break;

                case 34: // '"'
                    KeyValue.Builder builder1 = KeyValue.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addMetadata(builder1.buildPartial());
                    break;

                case 42: // '*'
                    MetricEntryMessage.Builder builder2 = MetricEntryMessage.newBuilder();
                    codedinputstream.readMessage(builder2, extensionregistrylite);
                    addMetricEntry(builder2.buildPartial());
                    break;
                }
            } while (true);
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

        public volatile com.google.protobuf.Message.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

        public MetricBatchMessage.Builder removeMetadata(int i)
        {
            if (metadataBuilder_ == null)
            {
                ensureMetadataIsMutable();
                metadata_.remove(i);
                onChanged();
                return this;
            } else
            {
                metadataBuilder_.remove(i);
                return this;
            }
        }

        public MetricBatchMessage.Builder removeMetricEntry(int i)
        {
            if (metricEntryBuilder_ == null)
            {
                ensureMetricEntryIsMutable();
                metricEntry_.remove(i);
                onChanged();
                return this;
            } else
            {
                metricEntryBuilder_.remove(i);
                return this;
            }
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

        void setDeviceSerialNumber(ByteString bytestring)
        {
            bitField0_ = bitField0_ | 1;
            deviceSerialNumber_ = bytestring;
            onChanged();
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

        void setDeviceType(ByteString bytestring)
        {
            bitField0_ = bitField0_ | 2;
            deviceType_ = bytestring;
            onChanged();
        }

        public MetricBatchMessage.Builder setMetadata(int i, KeyValue.Builder builder)
        {
            if (metadataBuilder_ == null)
            {
                ensureMetadataIsMutable();
                metadata_.set(i, builder.build());
                onChanged();
                return this;
            } else
            {
                metadataBuilder_.setMessage(i, builder.build());
                return this;
            }
        }

        public MetricBatchMessage.Builder setMetadata(int i, KeyValue keyvalue)
        {
            if (metadataBuilder_ == null)
            {
                if (keyvalue == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureMetadataIsMutable();
                    metadata_.set(i, keyvalue);
                    onChanged();
                    return this;
                }
            } else
            {
                metadataBuilder_.setMessage(i, keyvalue);
                return this;
            }
        }

        public MetricBatchMessage.Builder setMetricEntry(int i, MetricEntryMessage.Builder builder)
        {
            if (metricEntryBuilder_ == null)
            {
                ensureMetricEntryIsMutable();
                metricEntry_.set(i, builder.build());
                onChanged();
                return this;
            } else
            {
                metricEntryBuilder_.setMessage(i, builder.build());
                return this;
            }
        }

        public MetricBatchMessage.Builder setMetricEntry(int i, MetricEntryMessage metricentrymessage)
        {
            if (metricEntryBuilder_ == null)
            {
                if (metricentrymessage == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureMetricEntryIsMutable();
                    metricEntry_.set(i, metricentrymessage);
                    onChanged();
                    return this;
                }
            } else
            {
                metricEntryBuilder_.setMessage(i, metricentrymessage);
                return this;
            }
        }

        public MetricBatchMessage.Builder setTag(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                tag_ = s;
                onChanged();
                return this;
            }
        }

        void setTag(ByteString bytestring)
        {
            bitField0_ = bitField0_ | 4;
            tag_ = bytestring;
            onChanged();
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

        public abstract String getDeviceSerialNumber();

        public abstract String getDeviceType();

        public abstract KeyValue getMetadata(int i);

        public abstract int getMetadataCount();

        public abstract List getMetadataList();

        public abstract KeyValueOrBuilder getMetadataOrBuilder(int i);

        public abstract List getMetadataOrBuilderList();

        public abstract MetricEntryMessage getMetricEntry(int i);

        public abstract int getMetricEntryCount();

        public abstract List getMetricEntryList();

        public abstract MetricEntryMessageOrBuilder getMetricEntryOrBuilder(int i);

        public abstract List getMetricEntryOrBuilderList();

        public abstract String getTag();

        public abstract boolean hasDeviceSerialNumber();

        public abstract boolean hasDeviceType();

        public abstract boolean hasTag();
    }

    public static final class MetricEntryMessage extends GeneratedMessage
        implements MetricEntryMessageOrBuilder
    {

        public static final int DATAPOINT_FIELD_NUMBER = 4;
        public static final int PROGRAM_FIELD_NUMBER = 2;
        public static final int SOURCE_FIELD_NUMBER = 3;
        public static final int TIMESTAMP_FIELD_NUMBER = 1;
        private static final MetricEntryMessage defaultInstance;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private List dataPoint_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object program_;
        private Object source_;
        private long timestamp_;

        public static MetricEntryMessage getDefaultInstance()
        {
            return defaultInstance;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
        {
            return DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_descriptor;
        }

        private ByteString getProgramBytes()
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

        private ByteString getSourceBytes()
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

        public static MetricEntryMessage parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(inputstream))
            {
                return builder.buildParsed();
            } else
            {
                return null;
            }
        }

        public static MetricEntryMessage parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(inputstream, extensionregistrylite))
            {
                return builder.buildParsed();
            } else
            {
                return null;
            }
        }

        public static MetricEntryMessage parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(bytestring)).buildParsed();
        }

        public static MetricEntryMessage parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(bytestring, extensionregistrylite)).buildParsed();
        }

        public static MetricEntryMessage parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return ((Builder)newBuilder().mergeFrom(codedinputstream)).buildParsed();
        }

        public static MetricEntryMessage parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return newBuilder().mergeFrom(codedinputstream, extensionregistrylite).buildParsed();
        }

        public static MetricEntryMessage parseFrom(InputStream inputstream)
            throws IOException
        {
            return ((Builder)newBuilder().mergeFrom(inputstream)).buildParsed();
        }

        public static MetricEntryMessage parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return ((Builder)newBuilder().mergeFrom(inputstream, extensionregistrylite)).buildParsed();
        }

        public static MetricEntryMessage parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(abyte0)).buildParsed();
        }

        public static MetricEntryMessage parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return ((Builder)newBuilder().mergeFrom(abyte0, extensionregistrylite)).buildParsed();
        }

        public DataPointMessage getDataPoint(int i)
        {
            return (DataPointMessage)dataPoint_.get(i);
        }

        public int getDataPointCount()
        {
            return dataPoint_.size();
        }

        public List getDataPointList()
        {
            return dataPoint_;
        }

        public DataPointMessageOrBuilder getDataPointOrBuilder(int i)
        {
            return (DataPointMessageOrBuilder)dataPoint_.get(i);
        }

        public List getDataPointOrBuilderList()
        {
            return dataPoint_;
        }

        public MetricEntryMessage getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile Message getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public String getProgram()
        {
            Object obj = program_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                program_ = s;
            }
            return s;
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

        public String getSource()
        {
            Object obj = source_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (Internal.isValidUtf8(((ByteString) (obj))))
            {
                source_ = s;
            }
            return s;
        }

        public long getTimestamp()
        {
            return timestamp_;
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
            return DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_fieldAccessorTable;
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

        public volatile com.google.protobuf.MessageLite.Builder newBuilderForType()
        {
            return newBuilderForType();
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


        private MetricEntryMessage(Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
        }


        private MetricEntryMessage(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
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

        private MetricEntryMessage buildParsed()
            throws InvalidProtocolBufferException
        {
            MetricEntryMessage metricentrymessage = buildPartial();
            if (!metricentrymessage.isInitialized())
            {
                throw newUninitializedMessageException(metricentrymessage).asInvalidProtocolBufferException();
            } else
            {
                return metricentrymessage;
            }
        }

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

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
        {
            return DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_descriptor;
        }

        private void maybeForceBuilderInitialization()
        {
            if (buildPartial)
            {
                getDataPointFieldBuilder();
            }
        }

        public MetricEntryMessage.Builder addAllDataPoint(Iterable iterable)
        {
            if (dataPointBuilder_ == null)
            {
                ensureDataPointIsMutable();
                com.google.protobuf.GeneratedMessage.Builder.addAll(iterable, dataPoint_);
                onChanged();
                return this;
            } else
            {
                dataPointBuilder_.addAllMessages(iterable);
                return this;
            }
        }

        public MetricEntryMessage.Builder addDataPoint(int i, DataPointMessage.Builder builder)
        {
            if (dataPointBuilder_ == null)
            {
                ensureDataPointIsMutable();
                dataPoint_.add(i, builder.build());
                onChanged();
                return this;
            } else
            {
                dataPointBuilder_.addMessage(i, builder.build());
                return this;
            }
        }

        public MetricEntryMessage.Builder addDataPoint(int i, DataPointMessage datapointmessage)
        {
            if (dataPointBuilder_ == null)
            {
                if (datapointmessage == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureDataPointIsMutable();
                    dataPoint_.add(i, datapointmessage);
                    onChanged();
                    return this;
                }
            } else
            {
                dataPointBuilder_.addMessage(i, datapointmessage);
                return this;
            }
        }

        public MetricEntryMessage.Builder addDataPoint(DataPointMessage.Builder builder)
        {
            if (dataPointBuilder_ == null)
            {
                ensureDataPointIsMutable();
                dataPoint_.add(builder.build());
                onChanged();
                return this;
            } else
            {
                dataPointBuilder_.addMessage(builder.build());
                return this;
            }
        }

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

        public DataPointMessage.Builder addDataPointBuilder()
        {
            return (DataPointMessage.Builder)getDataPointFieldBuilder().addBuilder(DataPointMessage.getDefaultInstance());
        }

        public DataPointMessage.Builder addDataPointBuilder(int i)
        {
            return (DataPointMessage.Builder)getDataPointFieldBuilder().addBuilder(i, DataPointMessage.getDefaultInstance());
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

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public MetricEntryMessage.Builder clear()
        {
            super.clear();
            timestamp_ = 0L;
            bitField0_ = bitField0_ & -2;
            program_ = "";
            bitField0_ = bitField0_ & -3;
            source_ = "";
            bitField0_ = bitField0_ & -5;
            if (dataPointBuilder_ == null)
            {
                dataPoint_ = Collections.emptyList();
                bitField0_ = bitField0_ & -9;
                return this;
            } else
            {
                dataPointBuilder_.clear();
                return this;
            }
        }

        public volatile com.google.protobuf.AbstractMessage.Builder clear()
        {
            return clear();
        }

        public volatile com.google.protobuf.GeneratedMessage.Builder clear()
        {
            return clear();
        }

        public volatile com.google.protobuf.Message.Builder clear()
        {
            return clear();
        }

        public volatile com.google.protobuf.MessageLite.Builder clear()
        {
            return clear();
        }

        public MetricEntryMessage.Builder clearDataPoint()
        {
            if (dataPointBuilder_ == null)
            {
                dataPoint_ = Collections.emptyList();
                bitField0_ = bitField0_ & -9;
                onChanged();
                return this;
            } else
            {
                dataPointBuilder_.clear();
                return this;
            }
        }

        public MetricEntryMessage.Builder clearProgram()
        {
            bitField0_ = bitField0_ & -3;
            program_ = MetricEntryMessage.getDefaultInstance().getProgram();
            onChanged();
            return this;
        }

        public MetricEntryMessage.Builder clearSource()
        {
            bitField0_ = bitField0_ & -5;
            source_ = MetricEntryMessage.getDefaultInstance().getSource();
            onChanged();
            return this;
        }

        public MetricEntryMessage.Builder clearTimestamp()
        {
            bitField0_ = bitField0_ & -2;
            timestamp_ = 0L;
            onChanged();
            return this;
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

        public volatile com.google.protobuf.Message.Builder clone()
        {
            return clone();
        }

        public volatile com.google.protobuf.MessageLite.Builder clone()
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

        public DataPointMessage.Builder getDataPointBuilder(int i)
        {
            return (DataPointMessage.Builder)getDataPointFieldBuilder().getBuilder(i);
        }

        public List getDataPointBuilderList()
        {
            return getDataPointFieldBuilder().getBuilderList();
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

        public List getDataPointList()
        {
            if (dataPointBuilder_ == null)
            {
                return Collections.unmodifiableList(dataPoint_);
            } else
            {
                return dataPointBuilder_.getMessageList();
            }
        }

        public DataPointMessageOrBuilder getDataPointOrBuilder(int i)
        {
            if (dataPointBuilder_ == null)
            {
                return (DataPointMessageOrBuilder)dataPoint_.get(i);
            } else
            {
                return (DataPointMessageOrBuilder)dataPointBuilder_.getMessageOrBuilder(i);
            }
        }

        public List getDataPointOrBuilderList()
        {
            if (dataPointBuilder_ != null)
            {
                return dataPointBuilder_.getMessageOrBuilderList();
            } else
            {
                return Collections.unmodifiableList(dataPoint_);
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

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
        {
            return MetricEntryMessage.getDescriptor();
        }

        public String getProgram()
        {
            Object obj = program_;
            if (!(obj instanceof String))
            {
                obj = ((ByteString)obj).toStringUtf8();
                program_ = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public String getSource()
        {
            Object obj = source_;
            if (!(obj instanceof String))
            {
                obj = ((ByteString)obj).toStringUtf8();
                source_ = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public long getTimestamp()
        {
            return timestamp_;
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
            return DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_fieldAccessorTable;
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
                setProgram(metricentrymessage.getProgram());
            }
            if (metricentrymessage.hasSource())
            {
                setSource(metricentrymessage.getSource());
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
                    if (buildPartial)
                    {
                        repeatedfieldbuilder = getDataPointFieldBuilder();
                    }
                    dataPointBuilder_ = repeatedfieldbuilder;
                } else
                {
                    dataPointBuilder_.addAllMessages(metricentrymessage.dataPoint_);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public MetricEntryMessage.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            com.google.protobuf.UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder(getUnknownFields());
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
                    timestamp_ = codedinputstream.readInt64();
                    break;

                case 18: // '\022'
                    bitField0_ = bitField0_ | 2;
                    program_ = codedinputstream.readBytes();
                    break;

                case 26: // '\032'
                    bitField0_ = bitField0_ | 4;
                    source_ = codedinputstream.readBytes();
                    break;

                case 34: // '"'
                    DataPointMessage.Builder builder1 = DataPointMessage.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addDataPoint(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public MetricEntryMessage.Builder mergeFrom(Message message)
        {
            if (message instanceof MetricEntryMessage)
            {
                return mergeFrom((MetricEntryMessage)message);
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

        public volatile com.google.protobuf.Message.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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

        public MetricEntryMessage.Builder removeDataPoint(int i)
        {
            if (dataPointBuilder_ == null)
            {
                ensureDataPointIsMutable();
                dataPoint_.remove(i);
                onChanged();
                return this;
            } else
            {
                dataPointBuilder_.remove(i);
                return this;
            }
        }

        public MetricEntryMessage.Builder setDataPoint(int i, DataPointMessage.Builder builder)
        {
            if (dataPointBuilder_ == null)
            {
                ensureDataPointIsMutable();
                dataPoint_.set(i, builder.build());
                onChanged();
                return this;
            } else
            {
                dataPointBuilder_.setMessage(i, builder.build());
                return this;
            }
        }

        public MetricEntryMessage.Builder setDataPoint(int i, DataPointMessage datapointmessage)
        {
            if (dataPointBuilder_ == null)
            {
                if (datapointmessage == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ensureDataPointIsMutable();
                    dataPoint_.set(i, datapointmessage);
                    onChanged();
                    return this;
                }
            } else
            {
                dataPointBuilder_.setMessage(i, datapointmessage);
                return this;
            }
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

        void setProgram(ByteString bytestring)
        {
            bitField0_ = bitField0_ | 2;
            program_ = bytestring;
            onChanged();
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

        void setSource(ByteString bytestring)
        {
            bitField0_ = bitField0_ | 4;
            source_ = bytestring;
            onChanged();
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

        public abstract DataPointMessage getDataPoint(int i);

        public abstract int getDataPointCount();

        public abstract List getDataPointList();

        public abstract DataPointMessageOrBuilder getDataPointOrBuilder(int i);

        public abstract List getDataPointOrBuilderList();

        public abstract String getProgram();

        public abstract String getSource();

        public abstract long getTimestamp();

        public abstract boolean hasProgram();

        public abstract boolean hasSource();

        public abstract boolean hasTimestamp();
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

    private DeviceMetricsMessage()
    {
    }

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor()
    {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionregistry)
    {
    }

    static 
    {
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner internaldescriptorassigner = new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {

            public ExtensionRegistry assignDescriptors(com.google.protobuf.Descriptors.FileDescriptor filedescriptor)
            {
                DeviceMetricsMessage.descriptor = filedescriptor;
                DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_descriptor = (com.google.protobuf.Descriptors.Descriptor)DeviceMetricsMessage.getDescriptor().getMessageTypes().get(0);
                DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable(DeviceMetricsMessage.internal_static_metrics_MetricBatchMessage_descriptor, new String[] {
                    "DeviceSerialNumber", "DeviceType", "Tag", "Metadata", "MetricEntry"
                }, com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage, com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder);
                DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_descriptor = (com.google.protobuf.Descriptors.Descriptor)DeviceMetricsMessage.getDescriptor().getMessageTypes().get(1);
                DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable(DeviceMetricsMessage.internal_static_metrics_MetricEntryMessage_descriptor, new String[] {
                    "Timestamp", "Program", "Source", "DataPoint"
                }, com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage, com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder);
                DeviceMetricsMessage.internal_static_metrics_DataPointMessage_descriptor = (com.google.protobuf.Descriptors.Descriptor)DeviceMetricsMessage.getDescriptor().getMessageTypes().get(2);
                DeviceMetricsMessage.internal_static_metrics_DataPointMessage_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable(DeviceMetricsMessage.internal_static_metrics_DataPointMessage_descriptor, new String[] {
                    "Name", "Value", "SampleSize", "Type"
                }, com/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage, com/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder);
                DeviceMetricsMessage.internal_static_metrics_KeyValue_descriptor = (com.google.protobuf.Descriptors.Descriptor)DeviceMetricsMessage.getDescriptor().getMessageTypes().get(3);
                DeviceMetricsMessage.internal_static_metrics_KeyValue_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable(DeviceMetricsMessage.internal_static_metrics_KeyValue_descriptor, new String[] {
                    "Key", "Value"
                }, com/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue, com/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue$Builder);
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
