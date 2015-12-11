// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics.codec:
//            DeviceMetricsMessage

public static final class memoizedSerializedSize extends GeneratedMessage
    implements rBuilder
{
    public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder
        implements DeviceMetricsMessage.DataPointMessageOrBuilder
    {

        private int bitField0_;
        private Object name_;
        private int sampleSize_;
        private DataType type_;
        private Object value_;

        private DeviceMetricsMessage.DataPointMessage buildParsed()
            throws InvalidProtocolBufferException
        {
            DeviceMetricsMessage.DataPointMessage datapointmessage = buildPartial();
            if (!datapointmessage.isInitialized())
            {
                throw newUninitializedMessageException(datapointmessage).asInvalidProtocolBufferException();
            } else
            {
                return datapointmessage;
            }
        }

        private static Builder create()
        {
            return new Builder();
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
        {
            return DeviceMetricsMessage.access$2800();
        }

        private void maybeForceBuilderInitialization()
        {
            if (!
// JavaClassFileOutputException: get_constant: invalid tag

        public DeviceMetricsMessage.DataPointMessage build()
        {
            DeviceMetricsMessage.DataPointMessage datapointmessage = buildPartial();
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

        public DeviceMetricsMessage.DataPointMessage buildPartial()
        {
            int j = 1;
            DeviceMetricsMessage.DataPointMessage datapointmessage = new DataPointMessage(this, null);
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

        public Builder clear()
        {
            clear();
            name_ = "";
            bitField0_ = bitField0_ & -2;
            value_ = "";
            bitField0_ = bitField0_ & -3;
            sampleSize_ = 0;
            bitField0_ = bitField0_ & -5;
            type_ = DataType.COUNTER;
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

        public Builder clearName()
        {
            bitField0_ = bitField0_ & -2;
            name_ = DeviceMetricsMessage.DataPointMessage.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public Builder clearSampleSize()
        {
            bitField0_ = bitField0_ & -5;
            sampleSize_ = 0;
            onChanged();
            return this;
        }

        public Builder clearType()
        {
            bitField0_ = bitField0_ & -9;
            type_ = DataType.COUNTER;
            onChanged();
            return this;
        }

        public Builder clearValue()
        {
            bitField0_ = bitField0_ & -3;
            value_ = DeviceMetricsMessage.DataPointMessage.getDefaultInstance().getValue();
            onChanged();
            return this;
        }

        public Builder clone()
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

        public DeviceMetricsMessage.DataPointMessage getDefaultInstanceForType()
        {
            return DeviceMetricsMessage.DataPointMessage.getDefaultInstance();
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
            return DeviceMetricsMessage.DataPointMessage.getDescriptor();
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

        public DataType getType()
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
            return DeviceMetricsMessage.access$2900();
        }

        public final boolean isInitialized()
        {
            while (!hasName() || !hasValue() || !hasSampleSize() || !hasType()) 
            {
                return false;
            }
            return true;
        }

        public Builder mergeFrom(DeviceMetricsMessage.DataPointMessage datapointmessage)
        {
            if (datapointmessage == DeviceMetricsMessage.DataPointMessage.getDefaultInstance())
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

        public Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
                    DataType datatype = DataType.valueOf(j);
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

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DeviceMetricsMessage.DataPointMessage)
            {
                return mergeFrom((DeviceMetricsMessage.DataPointMessage)message);
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

        void setName(ByteString bytestring)
        {
            bitField0_ = bitField0_ | 1;
            name_ = bytestring;
            onChanged();
        }

        public Builder setSampleSize(int i)
        {
            bitField0_ = bitField0_ | 4;
            sampleSize_ = i;
            onChanged();
            return this;
        }

        public Builder setType(DataType datatype)
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

        public Builder setValue(String s)
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



        private Builder()
        {
            name_ = "";
            value_ = "";
            type_ = DataType.COUNTER;
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            name_ = "";
            value_ = "";
            type_ = DataType.COUNTER;
            maybeForceBuilderInitialization();
        }

        Builder(com.google.protobuf.GeneratedMessage.BuilderParent builderparent, DeviceMetricsMessage._cls1 _pcls1)
        {
            this(builderparent);
        }
    }

    public static final class DataType extends Enum
        implements ProtocolMessageEnum
    {

        private static final DataType $VALUES[];
        public static final DataType CLICKSTREAM;
        public static final int CLICKSTREAM_VALUE = 3;
        public static final DataType COUNTER;
        public static final int COUNTER_VALUE = 0;
        public static final DataType DISCRETE;
        public static final int DISCRETE_VALUE = 2;
        public static final DataType TIMER;
        public static final int TIMER_VALUE = 1;
        private static final DataType VALUES[];
        private static com.google.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.protobuf.Internal.EnumLiteMap() {

            public DataType fi