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
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

// Referenced classes of package com.amazon.client.metrics.codec:
//            DeviceMetricsMessage

public static final class memoizedSerializedSize extends GeneratedMessage
    implements rBuilder
{
    public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder
        implements DeviceMetricsMessage.KeyValueOrBuilder
    {

        private int bitField0_;
        private Object key_;
        private Object value_;

        private DeviceMetricsMessage.KeyValue buildParsed()
            throws InvalidProtocolBufferException
        {
            DeviceMetricsMessage.KeyValue keyvalue = buildPartial();
            if (!keyvalue.isInitialized())
            {
                throw newUninitializedMessageException(keyvalue).asInvalidProtocolBufferException();
            } else
            {
                return keyvalue;
            }
        }

        private static Builder create()
        {
            return new Builder();
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
        {
            return DeviceMetricsMessage.access$4000();
        }

        private void maybeForceBuilderInitialization()
        {
            if (!newUninitializedMessageException);
        }

        public DeviceMetricsMessage.KeyValue build()
        {
            DeviceMetricsMessage.KeyValue keyvalue = buildPartial();
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

        public DeviceMetricsMessage.KeyValue buildPartial()
        {
            int i = 1;
            DeviceMetricsMessage.KeyValue keyvalue = new DeviceMetricsMessage.KeyValue(this, null);
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

        public Builder clear()
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

        public Builder clearKey()
        {
            bitField0_ = bitField0_ & -2;
            key_ = DeviceMetricsMessage.KeyValue.getDefaultInstance().getKey();
            onChanged();
            return this;
        }

        public Builder clearValue()
        {
            bitField0_ = bitField0_ & -3;
            value_ = DeviceMetricsMessage.KeyValue.getDefaultInstance().getValue();
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

        public DeviceMetricsMessage.KeyValue getDefaultInstanceForType()
        {
            return DeviceMetricsMessage.KeyValue.getDefaultInstance();
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
            return DeviceMetricsMessage.KeyValue.getDescriptor();
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
            return DeviceMetricsMessage.access$4100();
        }

        public final boolean isInitialized()
        {
            while (!hasKey() || !hasValue()) 
            {
                return false;
            }
            return true;
        }

        public Builder mergeFrom(DeviceMetricsMessage.KeyValue keyvalue)
        {
            if (keyvalue == DeviceMetricsMessage.KeyValue.getDefaultInstance())
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
                    key_ = codedinputstream.readBytes();
                    break;

                case 18: // '\022'
                    bitField0_ = bitField0_ | 2;
                    value_ = codedinputstream.readBytes();
                    break;
                }
            } while (true);
        }

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DeviceMetricsMessage.KeyValue)
            {
                return mergeFrom((DeviceMetricsMessage.KeyValue)message);
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

        public Builder setKey(String s)
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
            key_ = "";
            value_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {
            super(builderparent);
            key_ = "";
            value_ = "";
            maybeForceBuilderInitialization();
        }

        Builder(com.