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
        implements DeviceMetricsMessage.MetricEntryMessageOrBuilder
    {

        private int bitField0_;
        private RepeatedFieldBuilder dataPointBuilder_;
        private List dataPoint_;
        private Object program_;
        private Object source_;
        private long timestamp_;

        private DeviceMetricsMessage.MetricEntryMessage buildParsed()
            throws InvalidProtocolBufferException
        {
            DeviceMetricsMessage.MetricEntryMessage metricentrymessage = buildPartial();
            if (!metricentrymessage.isInitialized())
            {
                throw newUninitializedMessageException(metricentrymessage).asInvalidProtocolBufferException();
            } else
            {
                return metricentrymessage;
            }
        }

        private static Builder create()
        {
            return new Builder();
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
            return DeviceMetricsMessage.access$1500();
        }

        private void maybeForceBuilderInitialization()
        {
            if (buildPartial)
            {
                getDataPointFieldBuilder();
            }
        }

        public Builder addAllDataPoint(Iterable iterable)
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

        public Builder addDataPoint(int i, DeviceMetricsMessage.DataPointMessage.Builder builder)
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

        public Builder addDataPoint(int i, DeviceMetricsMessage.DataPointMessage datapointmessage)
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

        public Builder addDataPoint(DeviceMetricsMessage.DataPointMessage.Builder builder)
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

        public Builder addDataPoint(DeviceMetricsMessage.DataPointMessage datapointmessage)
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

        public DeviceMetricsMessage.DataPointMessage.Builder addDataPointBuilder()
        {
            return (DeviceMetricsMessage.DataPointMessage.Builder)getDataPointFieldBuilder().addBuilder(DeviceMetricsMessage.DataPointMessage.getDefaultInstance());
        }

        public DeviceMetricsMessage.DataPointMessage.Builder addDataPointBuilder(int i)
        {
            return (DeviceMetricsMessage.DataPointMessage.Builder)getDataPointFieldBuilder().addBuilder(i, DeviceMetricsMessage.DataPointMessage.getDefaultInstance());
        }

        public DeviceMetricsMessage.MetricEntryMessage build()
        {
            DeviceMetricsMessage.MetricEntryMessage metricentrymessage = buildPartial();
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

        public DeviceMetricsMessage.MetricEntryMessage buildPartial()
        {
            int j = 1;
            DeviceMetricsMessage.MetricEntryMessage metricentrymessage = new DeviceMetricsMessage.MetricEntryMessage(this, null);
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

        public Builder clear()
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

        public Builder clearDataPoint()
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

        public Builder clearProgram()
        {
            bitField0_ = bitField0_ & -3;
            program_ = DeviceMetricsMessage.MetricEntryMessage.getDefaultInstance().getProgram();
            onChanged();
            return this;
        }

        public Builder clearSource()
        {
            bitField0_ = bitField0_ & -5;
            source_ = DeviceMetricsMessage.MetricEntryMessage.getDefaultInstance().getSource();
            onChanged();
            return this;
        }

        public Builder clearTimestamp()
        {
            bitField0_ = bitField0_ & -2;
            timestamp_ = 0L;
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

        public DeviceMetricsMessage.DataPointMessage getDataPoint(int i)
        {
            if (dataPointBuilder_ == null)
            {
                return (DeviceMetricsMessage.DataPointMessage)dataPoint_.get(i);
            } else
            {
                return (DeviceMetricsMessage.DataPointMessage)dataPointBuilder_.getMessage(i);
            }
        }

        public DeviceMetricsMessage.DataPointMessage.Builder getDataPointBuilder(int i)
        {
            return (DeviceMetricsMessage.DataPointMessage.Builder)getDataPointFieldBuilder().getBuilder(i);
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

        public DeviceMetricsMessage.DataPointMessageOrBuilder getDataPointOrBuilder(int i)
        {
            if (dataPointBuilder_ == null)
            {
                return (DeviceMetricsMessage.DataPointMessageOrBuilder)dataPoint_.get(i);
            } else
            {
                return (DeviceMetricsMessage.DataPointMessageOrBuilder)dataPointBuilder_.getMessageOrBuilder(i);
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

        public DeviceMetricsMessage.MetricEntryMessage getDefaultInstanceForType()
        {
            return DeviceMetricsMessage.MetricEntryMessage.getDefaultInstance();
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
            return DeviceMetricsMessage.MetricEntryMessage.getDescriptor();
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
            return DeviceMetricsMessage.access$1600();
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

        public Builder mergeFrom(DeviceMetricsMessage.MetricEntryMessage metricentrymessage)
        {
            RepeatedFieldBuilder repeatedfieldbuilder;
            repeatedfieldbuilder = null;
            if (metricentrymessage == DeviceMetricsMessage.MetricEntryMessage.getDefaultInstance())
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
                    DeviceMetricsMessage.DataPointMessage.Builder builder1 = DeviceMetricsMessage.DataPointMessage.newBuilder();
                    codedinputstream.readMessage(builder1, extensionregistrylite);
                    addDataPoint(builder1.buildPartial());
                    break;
                }
            } while (true);
        }

        public Builder mergeFrom(Message message)
        {
            if (message instanceof DeviceMetricsMessage.MetricEntryMessage)
            {
                return mergeFrom((DeviceMetricsMessage.MetricEntryMessage)message);
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

        public Builder removeDataPoint(int i)
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

        public Builder setDataPoint(int i, DeviceMetricsMessage.DataPointMessage.Builder builder)
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

        public Builder setDataPoint(int i, DeviceMetricsMessage.DataPointMessage datapointmessage)
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

        public Builder setProgram(String s)
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

        public Builder setSource(String s)
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

        public Buil