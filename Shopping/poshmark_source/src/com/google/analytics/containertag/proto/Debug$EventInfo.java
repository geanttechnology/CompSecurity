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
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

// Referenced classes of package com.google.analytics.containertag.proto:
//            Debug

public static final class unknownFields extends GeneratedMessageLite
    implements rBuilder
{
    public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements Debug.EventInfoOrBuilder
    {

        private int bitField0_;
        private Object containerId_;
        private Object containerVersion_;
        private Debug.DataLayerEventEvaluationInfo dataLayerEventResult_;
        private EventType eventType_;
        private Object key_;
        private Debug.MacroEvaluationInfo macroResult_;

        private static Builder create()
        {
            return new Builder();
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public Debug.EventInfo build()
        {
            Debug.EventInfo eventinfo = buildPartial();
            if (!eventinfo.isInitialized())
            {
                throw newUninitializedMessageException(eventinfo);
            } else
            {
                return eventinfo;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public Debug.EventInfo buildPartial()
        {
            Debug.EventInfo eventinfo = new Debug.EventInfo(this, null);
            int k = bitField0_;
            int j = 0;
            if ((k & 1) == 1)
            {
                j = false | true;
            }
            eventinfo.eventType_ = eventType_;
            int i = j;
            if ((k & 2) == 2)
            {
                i = j | 2;
            }
            eventinfo.containerVersion_ = containerVersion_;
            j = i;
            if ((k & 4) == 4)
            {
                j = i | 4;
            }
            eventinfo.containerId_ = containerId_;
            i = j;
            if ((k & 8) == 8)
            {
                i = j | 8;
            }
            eventinfo.key_ = key_;
            j = i;
            if ((k & 0x10) == 16)
            {
                j = i | 0x10;
            }
            eventinfo.macroResult_ = macroResult_;
            i = j;
            if ((k & 0x20) == 32)
            {
                i = j | 0x20;
            }
            eventinfo.dataLayerEventResult_ = dataLayerEventResult_;
            eventinfo.bitField0_ = i;
            return eventinfo;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public Builder clear()
        {
            super.clear();
            eventType_ = EventType.DATA_LAYER_EVENT;
            bitField0_ = bitField0_ & -2;
            containerVersion_ = "";
            bitField0_ = bitField0_ & -3;
            containerId_ = "";
            bitField0_ = bitField0_ & -5;
            key_ = "";
            bitField0_ = bitField0_ & -9;
            macroResult_ = Debug.MacroEvaluationInfo.getDefaultInstance();
            bitField0_ = bitField0_ & 0xffffffef;
            dataLayerEventResult_ = Debug.DataLayerEventEvaluationInfo.getDefaultInstance();
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

        public Builder clearContainerId()
        {
            bitField0_ = bitField0_ & -5;
            containerId_ = Debug.EventInfo.getDefaultInstance().getContainerId();
            return this;
        }

        public Builder clearContainerVersion()
        {
            bitField0_ = bitField0_ & -3;
            containerVersion_ = Debug.EventInfo.getDefaultInstance().getContainerVersion();
            return this;
        }

        public Builder clearDataLayerEventResult()
        {
            dataLayerEventResult_ = Debug.DataLayerEventEvaluationInfo.getDefaultInstance();
            bitField0_ = bitField0_ & 0xffffffdf;
            return this;
        }

        public Builder clearEventType()
        {
            bitField0_ = bitField0_ & -2;
            eventType_ = EventType.DATA_LAYER_EVENT;
            return this;
        }

        public Builder clearKey()
        {
            bitField0_ = bitField0_ & -9;
            key_ = Debug.EventInfo.getDefaultInstance().getKey();
            return this;
        }

        public Builder clearMacroResult()
        {
            macroResult_ = Debug.MacroEvaluationInfo.getDefaultInstance();
            bitField0_ = bitField0_ & 0xffffffef;
            return this;
        }

        public Builder clone()
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

        public String getContainerVersion()
        {
            Object obj = containerVersion_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    containerVersion_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getContainerVersionBytes()
        {
            Object obj = containerVersion_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                containerVersion_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public Debug.DataLayerEventEvaluationInfo getDataLayerEventResult()
        {
            return dataLayerEventResult_;
        }

        public Debug.EventInfo getDefaultInstanceForType()
        {
            return Debug.EventInfo.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public EventType getEventType()
        {
            return eventType_;
        }

        public String getKey()
        {
            Object obj = key_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    key_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
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

        public Debug.MacroEvaluationInfo getMacroResult()
        {
            return macroResult_;
        }

        public boolean hasContainerId()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasContainerVersion()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasDataLayerEventResult()
        {
            return (bitField0_ & 0x20) == 32;
        }

        public boolean hasEventType()
        {
            return (bitField0_ & 1) == 1;
        }

        public boolean hasKey()
        {
            return (bitField0_ & 8) == 8;
        }

        public boolean hasMacroResult()
        {
            return (bitField0_ & 0x10) == 16;
        }

        public final boolean isInitialized()
        {
            while (hasMacroResult() && !getMacroResult().isInitialized() || hasDataLayerEventResult() && !getDataLayerEventResult().isInitialized()) 
            {
                return false;
            }
            return true;
        }

        public Builder mergeDataLayerEventResult(Debug.DataLayerEventEvaluationInfo datalayereventevaluationinfo)
        {
            if ((bitField0_ & 0x20) == 32 && dataLayerEventResult_ != Debug.DataLayerEventEvaluationInfo.getDefaultInstance())
            {
                dataLayerEventResult_ = Debug.DataLayerEventEvaluationInfo.newBuilder(dataLayerEventResult_).mergeFrom(datalayereventevaluationinfo).buildPartial();
            } else
            {
                dataLayerEventResult_ = datalayereventevaluationinfo;
            }
            bitField0_ = bitField0_ | 0x20;
            return this;
        }

        public Builder mergeFrom(Debug.EventInfo eventinfo)
        {
            if (eventinfo == Debug.EventInfo.getDefaultInstance())
            {
                return this;
            }
            if (eventinfo.hasEventType())
            {
                setEventType(eventinfo.getEventType());
            }
            if (eventinfo.hasContainerVersion())
            {
                bitField0_ = bitField0_ | 2;
                containerVersion_ = eventinfo.containerVersion_;
            }
            if (eventinfo.hasContainerId())
            {
                bitField0_ = bitField0_ | 4;
                containerId_ = eventinfo.containerId_;
            }
            if (eventinfo.hasKey())
            {
                bitField0_ = bitField0_ | 8;
                key_ = eventinfo.key_;
            }
            if (eventinfo.hasMacroResult())
            {
                mergeMacroResult(eventinfo.getMacroResult());
            }
            if (eventinfo.hasDataLayerEventResult())
            {
                mergeDataLayerEventResult(eventinfo.getDataLayerEventResult());
            }
            setUnknownFields(getUnknownFields().concat(eventinfo.unknownFields));
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (Debug.EventInfo)Debug.EventInfo.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((Debug.EventInfo) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (Debug.EventInfo)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((Debug.EventInfo) (codedinputstream1)));
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
            return mergeFrom((Debug.EventInfo)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Builder mergeMacroResult(Debug.MacroEvaluationInfo macroevaluationinfo)
        {
            if ((bitField0_ & 0x10) == 16 && macroResult_ != Debug.MacroEvaluationInfo.getDefaultInstance())
            {
                macroResult_ = Debug.MacroEvaluationInfo.newBuilder(macroResult_).mergeFrom(macroevaluationinfo).buildPartial();
            } else
            {
                macroResult_ = macroevaluationinfo;
            }
            bitField0_ = bitField0_ | 0x10;
            return this;
        }

        public Builder setContainerId(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                containerId_ = s;
                return this;
            }
        }

        public Builder setContainerIdBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                containerId_ = bytestring;
                return this;
            }
        }

        public Builder setContainerVersion(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                containerVersion_ = s;
                return this;
            }
        }

        public Builder setContainerVersionBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                containerVersion_ = bytestring;
                return this;
            }
        }

        public Builder setDataLayerEventResult(Debug.DataLayerEventEvaluationInfo.Builder builder)
        {
            dataLayerEventResult_ = builder.build();
            bitField0_ = bitField0_ | 0x20;
            return this;
        }

        public Builder setDataLayerEventResult(Debug.DataLayerEventEvaluationInfo datalayereventevaluationinfo)
        {
            if (datalayereventevaluationinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                dataLayerEventResult_ = datalayereventevaluationinfo;
                bitField0_ = bitField0_ | 0x20;
                return this;
            }
        }

        public Builder setEventType(EventType eventtype)
        {
            if (eventtype == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                eventType_ = eventtype;
                return this;
            }
        }

        public Builder setKey(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 8;
                key_ = s;
                return this;
            }
        }

        public Builder setKeyBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 8;
                key_ = bytestring;
                return this;
            }
        }

        public Builder setMacroResult(Debug.MacroEvaluationInfo.Builder builder)
        {
            macroResult_ = builder.build();
            bitField0_ = bitField0_ | 0x10;
            return this;
        }

        public Builder setMacroResult(Debug.MacroEvaluationInfo macroevaluationinfo)
        {
            if (macroevaluationinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                macroResult_ = macroevaluationinfo;
                bitField0_ = bitField0_ | 0x10;
                return this;
            }
        }


        private Builder()
        {
            eventType_ = EventType.DATA_LAYER_EVENT;
            containerVersion_ = "";
            containerId_ = "";
            key_ = "";
            macroResult_ = Debug.MacroEvaluationInfo.getDefaultInstance();
            dataLayerEventResult_ = Debug.DataLayerEventEvaluationInfo.getDefaultInstance();
            maybeForceBuilderInitialization();
        }
    }

    public static final class EventType extends Enum
        implements com.google.tagmanager.protobuf.Internal.EnumLite
    {

        private static final EventType $VALUES[];
        public static final EventType DATA_LAYER_EVENT;
        public static final int DATA_LAYER_EVENT_VALUE = 1;
        public static final EventType MACRO_REFERENCE;
        public static final int MACRO_REFERENCE_VALUE = 2;
        private static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

            public EventType findValueByNumber(int i)
            {
                return EventType.valueOf(i);
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

        public static EventType valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return DATA_LAYER_EVENT;

            case 2: // '\002'
                return MACRO_REFERENCE;
            }
        }

        public static EventType valueOf(String s)
        {
            return (EventType)Enum.valueOf(com/google/analytics/container