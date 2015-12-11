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
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics.codec:
//            DeviceMetricsMessage

public static final class memoizedSerializedSize extends GeneratedMessage
    implements rBuilder
{
    public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder
        implements DeviceMetricsMessage.MetricBatchMessageOrBuilder
    {

        private int bitField0_;
        private Object deviceSerialNumber_;
        private Object deviceType_;
        private RepeatedFieldBuilder metadataBuilder_;
        private List metadata_;
        private RepeatedFieldBuilder metricEntryBuilder_;
        private List metricEntry_;
        private Object tag_;

        private DeviceMetricsMessage.MetricBatchMessage buildParsed()
            throws InvalidProtocolBufferException
        {
            DeviceMetricsMessage.MetricBatchMessage metricbatchmessage = buildPartial();
            if (!metricbatchmessage.isInitialized())
            {
                throw newUninitializedMessageException(metricbatchmessage).asInvalidProtocolBufferException();
            } else
            {
                return metricbatchmessage;
            }
        }

        private static Builder create()
        {
            return new Builder();
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
            return DeviceMetricsMessage.access$000();
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

        public Builder addAllMetadata(Iterable iterable)
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

        public Builder addAllMetricEntry(Iterable iterable)
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

        public Builder addMetadata(int i, DeviceMetricsMessage.KeyValue.Builder builder)
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

        public Builder addMetadata(int i, DeviceMetricsMessage.KeyValue keyvalue)
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

        public Builder addMetadata(DeviceMetricsMessage.KeyValue.Builder builder)
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

        public Builder addMetadata(DeviceMetricsMessage.KeyValue keyvalue)
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

        public DeviceMetricsMessage.KeyValue.Builder addMetadataBuilder()
        {
            return (DeviceMetricsMessage.KeyValue.Builder)getMetadataFieldBuilder().addBuilder(DeviceMetricsMessage.KeyValue.getDefaultInstance());
        }

        public DeviceMetricsMessage.KeyValue.Builder addMetadataBuilder(int i)
        {
            return (DeviceMetricsMessage.KeyValue.Builder)getMetadataFieldBuilder().addBuilder(i, DeviceMetricsMessage.KeyValue.getDefaultInstance());
        }

        public Builder addMetricEntry(int i, DeviceMetricsMessage.MetricEntryMessage.Builder builder)
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

        public Builder addMetricEntry(int i, DeviceMetricsMessage.MetricEntryMessage metricentrymessage)
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

        public Builder addMetricEntry(DeviceMetricsMessage.MetricEntryMessage.Builder builder)
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

        public Builder addMetricEntry(DeviceMetricsMessage.MetricEntryMessage metricentrymessage)
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

        public DeviceMetricsMessage.MetricEntryMessage.Builder addMetricEntryBuilder()
        {
            return (DeviceMetricsMessage.MetricEntryMessage.Builder)getMetricEntryFieldBuilder().addBuilder(DeviceMetricsMessage.MetricEntryMessage.getDefaultInstance());
        }

        public DeviceMetricsMessage.MetricEntryMessage.Builder addMetricEntryBuilder(int i)
        {
            return (DeviceMetricsMessage.MetricEntryMessage.Builder)getMetricEntryFieldBuilder().addBuilder(i, DeviceMetricsMessage.MetricEntryMessage.getDefaultInstance());
        }

        public DeviceMetricsMessage.MetricBatchMessage build()
        {
            DeviceMetricsMessage.MetricBatchMessage metricbatchmessage = buildPartial();
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

        public DeviceMetricsMessage.MetricBatchMessage buildPartial()
        {
            int j = 1;
            DeviceMetricsMessage.MetricBatchMessage metricbatchmessage = new DeviceMetricsMessage.MetricBatchMessage(this, null);
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

        public Builder clear()
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

        public Builder clearDeviceSerialNumber()
        {
            bitField0_ = bitField0_ & -2;
            deviceSerialNumber_ = DeviceMetricsMessage.MetricBatchMessage.getDefaultInstance().getDeviceSerialNumber();
            onChanged();
            return this;
        }

        public Builder clearDeviceType()
        {
            bitField0_ = bitField0_ & -3;
            deviceType_ = DeviceMetricsMessage.MetricBatchMessage.getDefaultInstance().getDeviceType();
            onChanged();
            return this;
        }

        public Builder clearMetadata()
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

        public Builder clearMetricEntry()
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

        public Builder clearTag()
        {
            bitField0_ = bitField0_ & -5;
            tag_ = DeviceMetricsMessage.MetricBatchMessage.getDefaultInstance().getTag();
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

        public DeviceMetricsMessage.MetricBatchMessage getDefaultInstanceForType()
        {
            return DeviceMetricsMessage.MetricBatchMessage.getDefaultInstance();
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
            return DeviceMetricsMessage.MetricBatchMessage.getDescriptor();
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

        public DeviceMetricsMessage.KeyValue getMetadata(int i)
        {
            if (metadataBuilder_ == null)
            {
                return (DeviceMetricsMessage.KeyValue)metadata_.get(i);
            } else
            {
                return (DeviceMetricsMessage.KeyValue)metadataBuilder_.getMessage(i);
            }
        }

        public DeviceMetricsMessage.KeyValue.Builder getMetadataBuilder(int i)
        {
            return (DeviceMetricsMessage.KeyValue.Builder)getMetadataFieldBuilder().getBuilder(i);
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

        public DeviceMetricsMessage.KeyValueOrBuilder getMetadataOrBuilder(int i)
        {
            if (metadataBuilder_ == null)
            {
                return (DeviceMetricsMessage.KeyValueOrBuilder)metadata_.get(i);
            } else
            {
                return (DeviceMetricsMessage.KeyValueOrBuilder)metadataBuilder_.getMessageOrBuilder(i);
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

        public DeviceMetricsMessage.MetricEntryMessage getMetricEntry(int i)
        {
            if (metricEntryBuilder_ == null)
            {
                return (DeviceMetricsMessage.MetricEntryMessage)metricEntry_.get(i);
            } else
            {
                return (DeviceMetricsMessage.MetricEntryMessage)metricEntryBuilder_.getMessage(i);
            }
        }

        public DeviceMetricsMessage.MetricEntryMessage.Builder getMetricEntryBuilder(int i)
        {
            return (DeviceMetricsMessage.MetricEntryMessage.Builder)getMetricEntryFieldBuilder().getBuilder(i);
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

        public DeviceMetricsMessage.MetricEntryMessageOrBuilder getMetricEntryOrBuilder(int i)
        {
            if (metricEntryBuilder_ == null)
            {
                return (DeviceMetricsMessage.MetricEntryMessageOrBuilder)metricEntry_.get(i);
            } else
            {
                return (DeviceMetricsMessage.MetricEntryMessageOrBuilder)metricEntryBuilder_.getMessageOrBuilder(i);
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
            return DeviceMetricsMessage.access$100();
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

        public Builder mergeFrom(DeviceMetricsMessage.MetricBatchMessage metricbatchmessage)
        {
            Object obj = null;
            if (metricbatchmessage == DeviceMetricsMessage.MetricBatchMessage.getDefaultInstance())
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
                    DeviceMetricsMessage.KeyValue.Builder builder1 = DeviceMetricsMessage.KeyValue.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addMetadata(builder1.buildPartial());
                    break;

                case 42: // '*'
                    DeviceMetricsMessage.MetricEntryMessage.Builder builder2 = DeviceMetricsMessage.MetricEntryMessage.newBuilder();
                    codedinputstream.readMessage(builder2, extensionregistrylite);
                    addMetricEntry(builder2.buildPartial());
                    break;
                }
            } while (true);
        }

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DeviceMetricsMessage.MetricBatchMessage)
            {
                return mergeFrom((DeviceMetricsMessage.MetricBatchMessage)message);
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

        public Builder removeMetadata(int i)
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

        public Builder removeMetricEntry(int i)
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

        public Builder setDeviceSerialNumber(String s)
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

        public Builder setDeviceType(String s)
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

        public Builder setMetadata(int i, DeviceMetricsMessage.KeyValue.Builder builder)
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

        public Builder setMetadata(int i, DeviceMetricsMessage.KeyValue keyvalue)
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

        public Builder setMetricEntry(int i, DeviceMetricsMessage.MetricEntryMessage.Builder builder)
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

        public Builder setMetricEntry(int i, DeviceMetricsMessage.MetricEntryMessage metricentrymessage)
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

        public Builder setTag(String s)
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



        private Builder()
        {
            deviceSerialNumber_ = "";
            deviceType_ = "";
            tag_ = "";
            metadata_ = Collections.emptyList();
            metricEntry_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessage.BuilderParent builderparent)
        {