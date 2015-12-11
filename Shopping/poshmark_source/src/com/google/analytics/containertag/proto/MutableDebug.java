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
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MutableDebug
{
    public static final class DataLayerEventEvaluationInfo extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static Parser PARSER;
        public static final int RESULTS_FIELD_NUMBER = 2;
        public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
        private static final DataLayerEventEvaluationInfo defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private List results_;
        private RuleEvaluationStepInfo rulesEvaluation_;

        private void ensureResultsInitialized()
        {
            if (results_ == null)
            {
                results_ = new ArrayList();
            }
        }

        private void ensureRulesEvaluationInitialized()
        {
            if (rulesEvaluation_ == RuleEvaluationStepInfo.getDefaultInstance())
            {
                rulesEvaluation_ = RuleEvaluationStepInfo.newMessage();
            }
        }

        public static DataLayerEventEvaluationInfo getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
        }

        public static DataLayerEventEvaluationInfo newMessage()
        {
            return new DataLayerEventEvaluationInfo();
        }

        public DataLayerEventEvaluationInfo addAllResults(Iterable iterable)
        {
            assertMutable();
            ensureResultsInitialized();
            AbstractMutableMessageLite.addAll(iterable, results_);
            return this;
        }

        public DataLayerEventEvaluationInfo addResults(ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureResultsInitialized();
                results_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedFunctionCall addResults()
        {
            assertMutable();
            ensureResultsInitialized();
            ResolvedFunctionCall resolvedfunctioncall = ResolvedFunctionCall.newMessage();
            results_.add(resolvedfunctioncall);
            return resolvedfunctioncall;
        }

        public DataLayerEventEvaluationInfo clear()
        {
            assertMutable();
            super.clear();
            if (rulesEvaluation_ != RuleEvaluationStepInfo.getDefaultInstance())
            {
                rulesEvaluation_.clear();
            }
            bitField0_ = bitField0_ & -2;
            results_ = null;
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

        public DataLayerEventEvaluationInfo clearResults()
        {
            assertMutable();
            results_ = null;
            return this;
        }

        public DataLayerEventEvaluationInfo clearRulesEvaluation()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            if (rulesEvaluation_ != RuleEvaluationStepInfo.getDefaultInstance())
            {
                rulesEvaluation_.clear();
            }
            return this;
        }

        public DataLayerEventEvaluationInfo clone()
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
            if (!(obj instanceof DataLayerEventEvaluationInfo))
            {
                return super.equals(obj);
            }
            obj = (DataLayerEventEvaluationInfo)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (true && hasRulesEvaluation() == ((DataLayerEventEvaluationInfo) (obj)).hasRulesEvaluation())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasRulesEvaluation())
            {
                if (flag && getRulesEvaluation().equals(((DataLayerEventEvaluationInfo) (obj)).getRulesEvaluation()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && getResultsList().equals(((DataLayerEventEvaluationInfo) (obj)).getResultsList()))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            return flag2;
        }

        public final DataLayerEventEvaluationInfo getDefaultInstanceForType()
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

        public ResolvedFunctionCall getMutableResults(int i)
        {
            return (ResolvedFunctionCall)results_.get(i);
        }

        public List getMutableResultsList()
        {
            assertMutable();
            ensureResultsInitialized();
            return results_;
        }

        public RuleEvaluationStepInfo getMutableRulesEvaluation()
        {
            assertMutable();
            ensureRulesEvaluationInitialized();
            bitField0_ = bitField0_ | 1;
            return rulesEvaluation_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public ResolvedFunctionCall getResults(int i)
        {
            return (ResolvedFunctionCall)results_.get(i);
        }

        public int getResultsCount()
        {
            if (results_ == null)
            {
                return 0;
            } else
            {
                return results_.size();
            }
        }

        public List getResultsList()
        {
            if (results_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(results_);
            }
        }

        public RuleEvaluationStepInfo getRulesEvaluation()
        {
            return rulesEvaluation_;
        }

        public int getSerializedSize()
        {
            int i = 0;
            if ((bitField0_ & 1) == 1)
            {
                i = 0 + CodedOutputStream.computeMessageSize(1, rulesEvaluation_);
            }
            int k = i;
            if (results_ != null)
            {
                int j = 0;
                do
                {
                    k = i;
                    if (j >= results_.size())
                    {
                        break;
                    }
                    i += CodedOutputStream.computeMessageSize(2, (MessageLite)results_.get(j));
                    j++;
                } while (true);
            }
            i = k + unknownFields.size();
            cachedSize = i;
            return i;
        }

        public boolean hasRulesEvaluation()
        {
            return (bitField0_ & 1) == 1;
        }

        public int hashCode()
        {
            int i = 41;
            if (hasRulesEvaluation())
            {
                i = 0x13a46 + getRulesEvaluation().hashCode();
            }
            int j = i;
            if (getResultsCount() > 0)
            {
                j = (i * 37 + 2) * 53 + getResultsList().hashCode();
            }
            return j * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$DataLayerEventEvaluationInfo");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            if (!hasRulesEvaluation() || getRulesEvaluation().isInitialized()) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= getResultsCount())
                    {
                        break label1;
                    }
                    if (!getResults(i).isInitialized())
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
            if (true) goto _L1; else goto _L3
_L3:
            return true;
        }

        public DataLayerEventEvaluationInfo mergeFrom(DataLayerEventEvaluationInfo datalayereventevaluationinfo)
        {
            if (this == datalayereventevaluationinfo)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (datalayereventevaluationinfo == getDefaultInstance())
            {
                return this;
            }
            if (datalayereventevaluationinfo.hasRulesEvaluation())
            {
                ensureRulesEvaluationInitialized();
                rulesEvaluation_.mergeFrom(datalayereventevaluationinfo.getRulesEvaluation());
                bitField0_ = bitField0_ | 1;
            }
            if (datalayereventevaluationinfo.results_ != null && !datalayereventevaluationinfo.results_.isEmpty())
            {
                ensureResultsInitialized();
                AbstractMutableMessageLite.addAll(datalayereventevaluationinfo.results_, results_);
            }
            unknownFields = unknownFields.concat(datalayereventevaluationinfo.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((DataLayerEventEvaluationInfo)generatedmutablemessagelite);
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
            JVM INSTR lookupswitch 3: default 149
        //                       0: 152
        //                       10: 83
        //                       18: 122;
               goto _L3 _L4 _L5 _L6
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (rulesEvaluation_ == RuleEvaluationStepInfo.getDefaultInstance())
            {
                rulesEvaluation_ = RuleEvaluationStepInfo.newMessage();
            }
            bitField0_ = bitField0_ | 1;
            codedinputstream.readMessage(rulesEvaluation_, extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L6:
            codedinputstream.readMessage(addResults(), extensionregistrylite);
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

        public DataLayerEventEvaluationInfo newMessageForType()
        {
            return new DataLayerEventEvaluationInfo();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public DataLayerEventEvaluationInfo setResults(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureResultsInitialized();
                results_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public DataLayerEventEvaluationInfo setRulesEvaluation(RuleEvaluationStepInfo ruleevaluationstepinfo)
        {
            assertMutable();
            if (ruleevaluationstepinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                rulesEvaluation_ = ruleevaluationstepinfo;
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
            int k = codedoutputstream.getTotalBytesWritten();
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeMessageWithCachedSizes(1, rulesEvaluation_);
            }
            if (results_ != null)
            {
                for (int i = 0; i < results_.size(); i++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(2, (MutableMessageLite)results_.get(i));
                }

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
            defaultInstance = new DataLayerEventEvaluationInfo(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private DataLayerEventEvaluationInfo()
        {
            results_ = null;
            initFields();
        }

        private DataLayerEventEvaluationInfo(boolean flag)
        {
            results_ = null;
        }
    }

    public static final class DebugEvents extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int EVENT_FIELD_NUMBER = 1;
        public static Parser PARSER;
        private static final DebugEvents defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private List event_;

        private void ensureEventInitialized()
        {
            if (event_ == null)
            {
                event_ = new ArrayList();
            }
        }

        public static DebugEvents getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
        }

        public static DebugEvents newMessage()
        {
            return new DebugEvents();
        }

        public DebugEvents addAllEvent(Iterable iterable)
        {
            assertMutable();
            ensureEventInitialized();
            AbstractMutableMessageLite.addAll(iterable, event_);
            return this;
        }

        public DebugEvents addEvent(EventInfo eventinfo)
        {
            assertMutable();
            if (eventinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEventInitialized();
                event_.add(eventinfo);
                return this;
            }
        }

        public EventInfo addEvent()
        {
            assertMutable();
            ensureEventInitialized();
            EventInfo eventinfo = EventInfo.newMessage();
            event_.add(eventinfo);
            return eventinfo;
        }

        public DebugEvents clear()
        {
            assertMutable();
            super.clear();
            event_ = null;
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

        public DebugEvents clearEvent()
        {
            assertMutable();
            event_ = null;
            return this;
        }

        public DebugEvents clone()
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
            if (!(obj instanceof DebugEvents))
            {
                return super.equals(obj);
            }
            obj = (DebugEvents)obj;
            boolean flag;
            if (true && getEventList().equals(((DebugEvents) (obj)).getEventList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;
        }

        public final DebugEvents getDefaultInstanceForType()
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

        public EventInfo getEvent(int i)
        {
            return (EventInfo)event_.get(i);
        }

        public int getEventCount()
        {
            if (event_ == null)
            {
                return 0;
            } else
            {
                return event_.size();
            }
        }

        public List getEventList()
        {
            if (event_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(event_);
            }
        }

        public EventInfo getMutableEvent(int i)
        {
            return (EventInfo)event_.get(i);
        }

        public List getMutableEventList()
        {
            assertMutable();
            ensureEventInitialized();
            return event_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public int getSerializedSize()
        {
            int k = 0;
            int i = 0;
            if (event_ != null)
            {
                int j = 0;
                do
                {
                    k = i;
                    if (j >= event_.size())
                    {
                        break;
                    }
                    i += CodedOutputStream.computeMessageSize(1, (MessageLite)event_.get(j));
                    j++;
                } while (true);
            }
            i = k + unknownFields.size();
            cachedSize = i;
            return i;
        }

        public int hashCode()
        {
            int i = 41;
            if (getEventCount() > 0)
            {
                i = 0x13a46 + getEventList().hashCode();
            }
            return i * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$DebugEvents");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            for (int i = 0; i < getEventCount(); i++)
            {
                if (!getEvent(i).isInitialized())
                {
                    return false;
                }
            }

            return true;
        }

        public DebugEvents mergeFrom(DebugEvents debugevents)
        {
            if (this == debugevents)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (debugevents == getDefaultInstance())
            {
                return this;
            }
            if (debugevents.event_ != null && !debugevents.event_.isEmpty())
            {
                ensureEventInitialized();
                AbstractMutableMessageLite.addAll(debugevents.event_, event_);
            }
            unknownFields = unknownFields.concat(debugevents.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((DebugEvents)generatedmutablemessagelite);
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
            JVM INSTR lookupswitch 2: default 102
        //                       0: 105
        //                       10: 75;
               goto _L3 _L4 _L5
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            codedinputstream.readMessage(addEvent(), extensionregistrylite);
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

        public DebugEvents newMessageForType()
        {
            return new DebugEvents();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public DebugEvents setEvent(int i, EventInfo eventinfo)
        {
            assertMutable();
            if (eventinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEventInitialized();
                event_.set(i, eventinfo);
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
            int k = codedoutputstream.getTotalBytesWritten();
            if (event_ != null)
            {
                for (int i = 0; i < event_.size(); i++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(1, (MutableMessageLite)event_.get(i));
                }

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
            defaultInstance = new DebugEvents(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private DebugEvents()
        {
            event_ = null;
            initFields();
        }

        private DebugEvents(boolean flag)
        {
            event_ = null;
        }
    }

    public static final class EventInfo extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int CONTAINER_ID_FIELD_NUMBER = 3;
        public static final int CONTAINER_VERSION_FIELD_NUMBER = 2;
        public static final int DATA_LAYER_EVENT_RESULT_FIELD_NUMBER = 7;
        public static final int EVENT_TYPE_FIELD_NUMBER = 1;
        public static final int KEY_FIELD_NUMBER = 4;
        public static final int MACRO_RESULT_FIELD_NUMBER = 6;
        public static Parser PARSER;
        private static final EventInfo defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private Object containerId_;
        private Object containerVersion_;
        private DataLayerEventEvaluationInfo dataLayerEventResult_;
        private EventType eventType_;
        private Object key_;
        private MacroEvaluationInfo macroResult_;

        private void ensureDataLayerEventResultInitialized()
        {
            if (dataLayerEventResult_ == DataLayerEventEvaluationInfo.getDefaultInstance())
            {
                dataLayerEventResult_ = DataLayerEventEvaluationInfo.newMessage();
            }
        }

        private void ensureMacroResultInitialized()
        {
            if (macroResult_ == MacroEvaluationInfo.getDefaultInstance())
            {
                macroResult_ = MacroEvaluationInfo.newMessage();
            }
        }

        public static EventInfo getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            eventType_ = EventType.DATA_LAYER_EVENT;
            macroResult_ = MacroEvaluationInfo.getDefaultInstance();
            dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
        }

        public static EventInfo newMessage()
        {
            return new EventInfo();
        }

        public EventInfo clear()
        {
            assertMutable();
            super.clear();
            eventType_ = EventType.DATA_LAYER_EVENT;
            bitField0_ = bitField0_ & -2;
            containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
            bitField0_ = bitField0_ & -3;
            containerId_ = Internal.EMPTY_BYTE_ARRAY;
            bitField0_ = bitField0_ & -5;
            key_ = Internal.EMPTY_BYTE_ARRAY;
            bitField0_ = bitField0_ & -9;
            if (macroResult_ != MacroEvaluationInfo.getDefaultInstance())
            {
                macroResult_.clear();
            }
            bitField0_ = bitField0_ & 0xffffffef;
            if (dataLayerEventResult_ != DataLayerEventEvaluationInfo.getDefaultInstance())
            {
                dataLayerEventResult_.clear();
            }
            bitField0_ = bitField0_ & 0xffffffdf;
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

        public EventInfo clearContainerId()
        {
            assertMutable();
            bitField0_ = bitField0_ & -5;
            containerId_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public EventInfo clearContainerVersion()
        {
            assertMutable();
            bitField0_ = bitField0_ & -3;
            containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public EventInfo clearDataLayerEventResult()
        {
            assertMutable();
            bitField0_ = bitField0_ & 0xffffffdf;
            if (dataLayerEventResult_ != DataLayerEventEvaluationInfo.getDefaultInstance())
            {
                dataLayerEventResult_.clear();
            }
            return this;
        }

        public EventInfo clearEventType()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            eventType_ = EventType.DATA_LAYER_EVENT;
            return this;
        }

        public EventInfo clearKey()
        {
            assertMutable();
            bitField0_ = bitField0_ & -9;
            key_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public EventInfo clearMacroResult()
        {
            assertMutable();
            bitField0_ = bitField0_ & 0xffffffef;
            if (macroResult_ != MacroEvaluationInfo.getDefaultInstance())
            {
                macroResult_.clear();
            }
            return this;
        }

        public EventInfo clone()
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
            if (!(obj instanceof EventInfo))
            {
                return super.equals(obj);
            }
            obj = (EventInfo)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (true && hasEventType() == ((EventInfo) (obj)).hasEventType())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasEventType())
            {
                if (flag && getEventType() == ((EventInfo) (obj)).getEventType())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasContainerVersion() == ((EventInfo) (obj)).hasContainerVersion())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasContainerVersion())
            {
                if (flag && getContainerVersion().equals(((EventInfo) (obj)).getContainerVersion()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasContainerId() == ((EventInfo) (obj)).hasContainerId())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasContainerId())
            {
                if (flag && getContainerId().equals(((EventInfo) (obj)).getContainerId()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasKey() == ((EventInfo) (obj)).hasKey())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasKey())
            {
                if (flag && getKey().equals(((EventInfo) (obj)).getKey()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasMacroResult() == ((EventInfo) (obj)).hasMacroResult())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasMacroResult())
            {
                if (flag && getMacroResult().equals(((EventInfo) (obj)).getMacroResult()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasDataLayerEventResult() == ((EventInfo) (obj)).hasDataLayerEventResult())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag3 = flag2;
            if (hasDataLayerEventResult())
            {
                if (flag2 && getDataLayerEventResult().equals(((EventInfo) (obj)).getDataLayerEventResult()))
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

        public String getContainerVersion()
        {
            Object obj = containerVersion_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                containerVersion_ = s;
            }
            return s;
        }

        public byte[] getContainerVersionAsBytes()
        {
            byte abyte0[] = ((byte []) (containerVersion_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                containerVersion_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
            }
        }

        public DataLayerEventEvaluationInfo getDataLayerEventResult()
        {
            return dataLayerEventResult_;
        }

        public final EventInfo getDefaultInstanceForType()
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

        public EventType getEventType()
        {
            return eventType_;
        }

        public String getKey()
        {
            Object obj = key_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                key_ = s;
            }
            return s;
        }

        public byte[] getKeyAsBytes()
        {
            byte abyte0[] = ((byte []) (key_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                key_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
            }
        }

        public MacroEvaluationInfo getMacroResult()
        {
            return macroResult_;
        }

        public DataLayerEventEvaluationInfo getMutableDataLayerEventResult()
        {
            assertMutable();
            ensureDataLayerEventResultInitialized();
            bitField0_ = bitField0_ | 0x20;
            return dataLayerEventResult_;
        }

        public MacroEvaluationInfo getMutableMacroResult()
        {
            assertMutable();
            ensureMacroResultInitialized();
            bitField0_ = bitField0_ | 0x10;
            return macroResult_;
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
                j = 0 + CodedOutputStream.computeEnumSize(1, eventType_.getNumber());
            }
            int i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeByteArraySize(2, getContainerVersionAsBytes());
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeByteArraySize(3, getContainerIdAsBytes());
            }
            i = j;
            if ((bitField0_ & 8) == 8)
            {
                i = j + CodedOutputStream.computeByteArraySize(4, getKeyAsBytes());
            }
            j = i;
            if ((bitField0_ & 0x10) == 16)
            {
                j = i + CodedOutputStream.computeMessageSize(6, macroResult_);
            }
            i = j;
            if ((bitField0_ & 0x20) == 32)
            {
                i = j + CodedOutputStream.computeMessageSize(7, dataLayerEventResult_);
            }
            i += unknownFields.size();
            cachedSize = i;
            return i;
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

        public int hashCode()
        {
            int j = 41;
            if (hasEventType())
            {
                j = 0x13a46 + Internal.hashEnum(getEventType());
            }
            int i = j;
            if (hasContainerVersion())
            {
                i = (j * 37 + 2) * 53 + getContainerVersion().hashCode();
            }
            j = i;
            if (hasContainerId())
            {
                j = (i * 37 + 3) * 53 + getContainerId().hashCode();
            }
            i = j;
            if (hasKey())
            {
                i = (j * 37 + 4) * 53 + getKey().hashCode();
            }
            j = i;
            if (hasMacroResult())
            {
                j = (i * 37 + 6) * 53 + getMacroResult().hashCode();
            }
            i = j;
            if (hasDataLayerEventResult())
            {
                i = (j * 37 + 7) * 53 + getDataLayerEventResult().hashCode();
            }
            return i * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$EventInfo");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            while (hasMacroResult() && !getMacroResult().isInitialized() || hasDataLayerEventResult() && !getDataLayerEventResult().isInitialized()) 
            {
                return false;
            }
            return true;
        }

        public EventInfo mergeFrom(EventInfo eventinfo)
        {
            if (this == eventinfo)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (eventinfo == getDefaultInstance())
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
                if (eventinfo.containerVersion_ instanceof String)
                {
                    containerVersion_ = eventinfo.containerVersion_;
                } else
                {
                    byte abyte0[] = (byte[])(byte[])eventinfo.containerVersion_;
                    containerVersion_ = Arrays.copyOf(abyte0, abyte0.length);
                }
            }
            if (eventinfo.hasContainerId())
            {
                bitField0_ = bitField0_ | 4;
                if (eventinfo.containerId_ instanceof String)
                {
                    containerId_ = eventinfo.containerId_;
                } else
                {
                    byte abyte1[] = (byte[])(byte[])eventinfo.containerId_;
                    containerId_ = Arrays.copyOf(abyte1, abyte1.length);
                }
            }
            if (eventinfo.hasKey())
            {
                bitField0_ = bitField0_ | 8;
                if (eventinfo.key_ instanceof String)
                {
                    key_ = eventinfo.key_;
                } else
                {
                    byte abyte2[] = (byte[])(byte[])eventinfo.key_;
                    key_ = Arrays.copyOf(abyte2, abyte2.length);
                }
            }
            if (eventinfo.hasMacroResult())
            {
                ensureMacroResultInitialized();
                macroResult_.mergeFrom(eventinfo.getMacroResult());
                bitField0_ = bitField0_ | 0x10;
            }
            if (eventinfo.hasDataLayerEventResult())
            {
                ensureDataLayerEventResultInitialized();
                dataLayerEventResult_.mergeFrom(eventinfo.getDataLayerEventResult());
                bitField0_ = bitField0_ | 0x20;
            }
            unknownFields = unknownFields.concat(eventinfo.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((EventInfo)generatedmutablemessagelite);
        }

        public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        {
            assertMutable();
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            EventType eventtype;
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
            JVM INSTR lookupswitch 7: default 328
        //                       0: 331
        //                       8: 115
        //                       18: 169
        //                       26: 190
        //                       34: 211
        //                       50: 233
        //                       58: 273;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            j = codedinputstream.readEnum();
            eventtype = EventType.valueOf(j);
            if (eventtype != null) goto _L12; else goto _L11
_L11:
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeRawVarint32(j);
            continue; /* Loop/switch isn't completed */
_L12:
            bitField0_ = bitField0_ | 1;
            eventType_ = eventtype;
            continue; /* Loop/switch isn't completed */
_L6:
            bitField0_ = bitField0_ | 2;
            containerVersion_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L7:
            bitField0_ = bitField0_ | 4;
            containerId_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L8:
            bitField0_ = bitField0_ | 8;
            key_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L9:
            if (macroResult_ == MacroEvaluationInfo.getDefaultInstance())
            {
                macroResult_ = MacroEvaluationInfo.newMessage();
            }
            bitField0_ = bitField0_ | 0x10;
            codedinputstream.readMessage(macroResult_, extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L10:
            if (dataLayerEventResult_ == DataLayerEventEvaluationInfo.getDefaultInstance())
            {
                dataLayerEventResult_ = DataLayerEventEvaluationInfo.newMessage();
            }
            bitField0_ = bitField0_ | 0x20;
            codedinputstream.readMessage(dataLayerEventResult_, extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
            return true;
_L4:
            flag = true;
            if (true) goto _L14; else goto _L13
_L14:
            break MISSING_BLOCK_LABEL_17;
_L13:
        }

        public EventInfo newMessageForType()
        {
            return new EventInfo();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public EventInfo setContainerId(String s)
        {
            assertMutable();
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

        public EventInfo setContainerIdAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                containerId_ = abyte0;
                return this;
            }
        }

        public EventInfo setContainerVersion(String s)
        {
            assertMutable();
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

        public EventInfo setContainerVersionAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                containerVersion_ = abyte0;
                return this;
            }
        }

        public EventInfo setDataLayerEventResult(DataLayerEventEvaluationInfo datalayereventevaluationinfo)
        {
            assertMutable();
            if (datalayereventevaluationinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x20;
                dataLayerEventResult_ = datalayereventevaluationinfo;
                return this;
            }
        }

        public EventInfo setEventType(EventType eventtype)
        {
            assertMutable();
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

        public EventInfo setKey(String s)
        {
            assertMutable();
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

        public EventInfo setKeyAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 8;
                key_ = abyte0;
                return this;
            }
        }

        public EventInfo setMacroResult(MacroEvaluationInfo macroevaluationinfo)
        {
            assertMutable();
            if (macroevaluationinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 0x10;
                macroResult_ = macroevaluationinfo;
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
                codedoutputstream.writeEnum(1, eventType_.getNumber());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeByteArray(2, getContainerVersionAsBytes());
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeByteArray(3, getContainerIdAsBytes());
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeByteArray(4, getKeyAsBytes());
            }
            if ((bitField0_ & 0x10) == 16)
            {
                codedoutputstream.writeMessageWithCachedSizes(6, macroResult_);
            }
            if ((bitField0_ & 0x20) == 32)
            {
                codedoutputstream.writeMessageWithCachedSizes(7, dataLayerEventResult_);
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
            defaultInstance = new EventInfo(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private EventInfo()
        {
            eventType_ = EventType.DATA_LAYER_EVENT;
            containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
            containerId_ = Internal.EMPTY_BYTE_ARRAY;
            key_ = Internal.EMPTY_BYTE_ARRAY;
            initFields();
        }

        private EventInfo(boolean flag)
        {
            eventType_ = EventType.DATA_LAYER_EVENT;
            containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
            containerId_ = Internal.EMPTY_BYTE_ARRAY;
            key_ = Internal.EMPTY_BYTE_ARRAY;
        }
    }

    public static final class EventInfo.EventType extends Enum
        implements com.google.tagmanager.protobuf.Internal.EnumLite
    {

        private static final EventInfo.EventType $VALUES[];
        public static final EventInfo.EventType DATA_LAYER_EVENT;
        public static final int DATA_LAYER_EVENT_VALUE = 1;
        public static final EventInfo.EventType MACRO_REFERENCE;
        public static final int MACRO_REFERENCE_VALUE = 2;
        private static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

            public EventInfo.EventType findValueByNumber(int i)
            {
                return EventInfo.EventType.valueOf(i);
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

        public static EventInfo.EventType valueOf(int i)
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

        public static EventInfo.EventType valueOf(String s)
        {
            return (EventInfo.EventType)Enum.valueOf(com/google/analytics/containertag/proto/MutableDebug$EventInfo$EventType, s);
        }

        public static EventInfo.EventType[] values()
        {
            return (EventInfo.EventType[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            DATA_LAYER_EVENT = new EventInfo.EventType("DATA_LAYER_EVENT", 0, 0, 1);
            MACRO_REFERENCE = new EventInfo.EventType("MACRO_REFERENCE", 1, 1, 2);
            $VALUES = (new EventInfo.EventType[] {
                DATA_LAYER_EVENT, MACRO_REFERENCE
            });
        }

        private EventInfo.EventType(String s, int i, int j, int k)
        {
            super(s, i);
            value = k;
        }
    }

    public static final class MacroEvaluationInfo extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int MACRO_FIELD_NUMBER = 0x2d4c0bd;
        public static Parser PARSER;
        public static final int RESULT_FIELD_NUMBER = 3;
        public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
        private static final MacroEvaluationInfo defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        public static final com.google.tagmanager.protobuf.GeneratedMessageLite.GeneratedExtension macro;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private ResolvedFunctionCall result_;
        private RuleEvaluationStepInfo rulesEvaluation_;

        private void ensureResultInitialized()
        {
            if (result_ == ResolvedFunctionCall.getDefaultInstance())
            {
                result_ = ResolvedFunctionCall.newMessage();
            }
        }

        private void ensureRulesEvaluationInitialized()
        {
            if (rulesEvaluation_ == RuleEvaluationStepInfo.getDefaultInstance())
            {
                rulesEvaluation_ = RuleEvaluationStepInfo.newMessage();
            }
        }

        public static MacroEvaluationInfo getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            result_ = ResolvedFunctionCall.getDefaultInstance();
        }

        public static MacroEvaluationInfo newMessage()
        {
            return new MacroEvaluationInfo();
        }

        public MacroEvaluationInfo clear()
        {
            assertMutable();
            super.clear();
            if (rulesEvaluation_ != RuleEvaluationStepInfo.getDefaultInstance())
            {
                rulesEvaluation_.clear();
            }
            bitField0_ = bitField0_ & -2;
            if (result_ != ResolvedFunctionCall.getDefaultInstance())
            {
                result_.clear();
            }
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

        public MacroEvaluationInfo clearResult()
        {
            assertMutable();
            bitField0_ = bitField0_ & -3;
            if (result_ != ResolvedFunctionCall.getDefaultInstance())
            {
                result_.clear();
            }
            return this;
        }

        public MacroEvaluationInfo clearRulesEvaluation()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            if (rulesEvaluation_ != RuleEvaluationStepInfo.getDefaultInstance())
            {
                rulesEvaluation_.clear();
            }
            return this;
        }

        public MacroEvaluationInfo clone()
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
            if (!(obj instanceof MacroEvaluationInfo))
            {
                return super.equals(obj);
            }
            obj = (MacroEvaluationInfo)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (true && hasRulesEvaluation() == ((MacroEvaluationInfo) (obj)).hasRulesEvaluation())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasRulesEvaluation())
            {
                if (flag && getRulesEvaluation().equals(((MacroEvaluationInfo) (obj)).getRulesEvaluation()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasResult() == ((MacroEvaluationInfo) (obj)).hasResult())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag3 = flag2;
            if (hasResult())
            {
                if (flag2 && getResult().equals(((MacroEvaluationInfo) (obj)).getResult()))
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
            return flag3;
        }

        public final MacroEvaluationInfo getDefaultInstanceForType()
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

        public ResolvedFunctionCall getMutableResult()
        {
            assertMutable();
            ensureResultInitialized();
            bitField0_ = bitField0_ | 2;
            return result_;
        }

        public RuleEvaluationStepInfo getMutableRulesEvaluation()
        {
            assertMutable();
            ensureRulesEvaluationInitialized();
            bitField0_ = bitField0_ | 1;
            return rulesEvaluation_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public ResolvedFunctionCall getResult()
        {
            return result_;
        }

        public RuleEvaluationStepInfo getRulesEvaluation()
        {
            return rulesEvaluation_;
        }

        public int getSerializedSize()
        {
            int i = 0;
            if ((bitField0_ & 1) == 1)
            {
                i = 0 + CodedOutputStream.computeMessageSize(1, rulesEvaluation_);
            }
            int j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeMessageSize(3, result_);
            }
            i = j + unknownFields.size();
            cachedSize = i;
            return i;
        }

        public boolean hasResult()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasRulesEvaluation()
        {
            return (bitField0_ & 1) == 1;
        }

        public int hashCode()
        {
            int i = 41;
            if (hasRulesEvaluation())
            {
                i = 0x13a46 + getRulesEvaluation().hashCode();
            }
            int j = i;
            if (hasResult())
            {
                j = (i * 37 + 3) * 53 + getResult().hashCode();
            }
            return j * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$MacroEvaluationInfo");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            while (hasRulesEvaluation() && !getRulesEvaluation().isInitialized() || hasResult() && !getResult().isInitialized()) 
            {
                return false;
            }
            return true;
        }

        public MacroEvaluationInfo mergeFrom(MacroEvaluationInfo macroevaluationinfo)
        {
            if (this == macroevaluationinfo)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (macroevaluationinfo == getDefaultInstance())
            {
                return this;
            }
            if (macroevaluationinfo.hasRulesEvaluation())
            {
                ensureRulesEvaluationInitialized();
                rulesEvaluation_.mergeFrom(macroevaluationinfo.getRulesEvaluation());
                bitField0_ = bitField0_ | 1;
            }
            if (macroevaluationinfo.hasResult())
            {
                ensureResultInitialized();
                result_.mergeFrom(macroevaluationinfo.getResult());
                bitField0_ = bitField0_ | 2;
            }
            unknownFields = unknownFields.concat(macroevaluationinfo.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((MacroEvaluationInfo)generatedmutablemessagelite);
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
            JVM INSTR lookupswitch 3: default 176
        //                       0: 179
        //                       10: 83
        //                       26: 122;
               goto _L3 _L4 _L5 _L6
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (rulesEvaluation_ == RuleEvaluationStepInfo.getDefaultInstance())
            {
                rulesEvaluation_ = RuleEvaluationStepInfo.newMessage();
            }
            bitField0_ = bitField0_ | 1;
            codedinputstream.readMessage(rulesEvaluation_, extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L6:
            if (result_ == ResolvedFunctionCall.getDefaultInstance())
            {
                result_ = ResolvedFunctionCall.newMessage();
            }
            bitField0_ = bitField0_ | 2;
            codedinputstream.readMessage(result_, extensionregistrylite);
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

        public MacroEvaluationInfo newMessageForType()
        {
            return new MacroEvaluationInfo();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public MacroEvaluationInfo setResult(ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                result_ = resolvedfunctioncall;
                return this;
            }
        }

        public MacroEvaluationInfo setRulesEvaluation(RuleEvaluationStepInfo ruleevaluationstepinfo)
        {
            assertMutable();
            if (ruleevaluationstepinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                rulesEvaluation_ = ruleevaluationstepinfo;
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
                codedoutputstream.writeMessageWithCachedSizes(1, rulesEvaluation_);
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeMessageWithCachedSizes(3, result_);
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
            defaultInstance = new MacroEvaluationInfo(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
            macro = GeneratedMessageLite.newSingularGeneratedExtension(com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, 0x2d4c0bd, com.google.tagmanager.protobuf.WireFormat.FieldType.MESSAGE, com/google/analytics/containertag/proto/MutableDebug$MacroEvaluationInfo);
        }

        private MacroEvaluationInfo()
        {
            initFields();
        }

        private MacroEvaluationInfo(boolean flag)
        {
        }
    }

    public static final class ResolvedFunctionCall extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int ASSOCIATED_RULE_NAME_FIELD_NUMBER = 3;
        public static Parser PARSER;
        public static final int PROPERTIES_FIELD_NUMBER = 1;
        public static final int RESULT_FIELD_NUMBER = 2;
        private static final ResolvedFunctionCall defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private Object associatedRuleName_;
        private int bitField0_;
        private List properties_;
        private com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value result_;

        private void ensurePropertiesInitialized()
        {
            if (properties_ == null)
            {
                properties_ = new ArrayList();
            }
        }

        private void ensureResultInitialized()
        {
            if (result_ == com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance())
            {
                result_ = com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.newMessage();
            }
        }

        public static ResolvedFunctionCall getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            result_ = com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance();
        }

        public static ResolvedFunctionCall newMessage()
        {
            return new ResolvedFunctionCall();
        }

        public ResolvedFunctionCall addAllProperties(Iterable iterable)
        {
            assertMutable();
            ensurePropertiesInitialized();
            AbstractMutableMessageLite.addAll(iterable, properties_);
            return this;
        }

        public ResolvedFunctionCall addProperties(ResolvedProperty resolvedproperty)
        {
            assertMutable();
            if (resolvedproperty == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePropertiesInitialized();
                properties_.add(resolvedproperty);
                return this;
            }
        }

        public ResolvedProperty addProperties()
        {
            assertMutable();
            ensurePropertiesInitialized();
            ResolvedProperty resolvedproperty = ResolvedProperty.newMessage();
            properties_.add(resolvedproperty);
            return resolvedproperty;
        }

        public ResolvedFunctionCall clear()
        {
            assertMutable();
            super.clear();
            properties_ = null;
            if (result_ != com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance())
            {
                result_.clear();
            }
            bitField0_ = bitField0_ & -2;
            associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
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

        public ResolvedFunctionCall clearAssociatedRuleName()
        {
            assertMutable();
            bitField0_ = bitField0_ & -3;
            associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public ResolvedFunctionCall clearProperties()
        {
            assertMutable();
            properties_ = null;
            return this;
        }

        public ResolvedFunctionCall clearResult()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            if (result_ != com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance())
            {
                result_.clear();
            }
            return this;
        }

        public ResolvedFunctionCall clone()
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
            if (!(obj instanceof ResolvedFunctionCall))
            {
                return super.equals(obj);
            }
            obj = (ResolvedFunctionCall)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (true && getPropertiesList().equals(((ResolvedFunctionCall) (obj)).getPropertiesList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && hasResult() == ((ResolvedFunctionCall) (obj)).hasResult())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasResult())
            {
                if (flag && getResult().equals(((ResolvedFunctionCall) (obj)).getResult()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasAssociatedRuleName() == ((ResolvedFunctionCall) (obj)).hasAssociatedRuleName())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag3 = flag2;
            if (hasAssociatedRuleName())
            {
                if (flag2 && getAssociatedRuleName().equals(((ResolvedFunctionCall) (obj)).getAssociatedRuleName()))
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
            return flag3;
        }

        public String getAssociatedRuleName()
        {
            Object obj = associatedRuleName_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                associatedRuleName_ = s;
            }
            return s;
        }

        public byte[] getAssociatedRuleNameAsBytes()
        {
            byte abyte0[] = ((byte []) (associatedRuleName_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                associatedRuleName_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
            }
        }

        public final ResolvedFunctionCall getDefaultInstanceForType()
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

        public ResolvedProperty getMutableProperties(int i)
        {
            return (ResolvedProperty)properties_.get(i);
        }

        public List getMutablePropertiesList()
        {
            assertMutable();
            ensurePropertiesInitialized();
            return properties_;
        }

        public com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value getMutableResult()
        {
            assertMutable();
            ensureResultInitialized();
            bitField0_ = bitField0_ | 1;
            return result_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public ResolvedProperty getProperties(int i)
        {
            return (ResolvedProperty)properties_.get(i);
        }

        public int getPropertiesCount()
        {
            if (properties_ == null)
            {
                return 0;
            } else
            {
                return properties_.size();
            }
        }

        public List getPropertiesList()
        {
            if (properties_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(properties_);
            }
        }

        public com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value getResult()
        {
            return result_;
        }

        public int getSerializedSize()
        {
            int i = 0;
            int j = 0;
            if (properties_ != null)
            {
                int k = 0;
                do
                {
                    i = j;
                    if (k >= properties_.size())
                    {
                        break;
                    }
                    j += CodedOutputStream.computeMessageSize(1, (MessageLite)properties_.get(k));
                    k++;
                } while (true);
            }
            j = i;
            if ((bitField0_ & 1) == 1)
            {
                j = i + CodedOutputStream.computeMessageSize(2, result_);
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeByteArraySize(3, getAssociatedRuleNameAsBytes());
            }
            i += unknownFields.size();
            cachedSize = i;
            return i;
        }

        public boolean hasAssociatedRuleName()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasResult()
        {
            return (bitField0_ & 1) == 1;
        }

        public int hashCode()
        {
            int j = 41;
            if (getPropertiesCount() > 0)
            {
                j = 0x13a46 + getPropertiesList().hashCode();
            }
            int i = j;
            if (hasResult())
            {
                i = (j * 37 + 2) * 53 + getResult().hashCode();
            }
            j = i;
            if (hasAssociatedRuleName())
            {
                j = (i * 37 + 3) * 53 + getAssociatedRuleName().hashCode();
            }
            return j * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$ResolvedFunctionCall");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L7:
            if (i >= getPropertiesCount()) goto _L2; else goto _L1
_L1:
            if (getProperties(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (hasResult() && !getResult().isInitialized()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
        }

        public ResolvedFunctionCall mergeFrom(ResolvedFunctionCall resolvedfunctioncall)
        {
            if (this == resolvedfunctioncall)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (resolvedfunctioncall == getDefaultInstance())
            {
                return this;
            }
            if (resolvedfunctioncall.properties_ != null && !resolvedfunctioncall.properties_.isEmpty())
            {
                ensurePropertiesInitialized();
                AbstractMutableMessageLite.addAll(resolvedfunctioncall.properties_, properties_);
            }
            if (resolvedfunctioncall.hasResult())
            {
                ensureResultInitialized();
                result_.mergeFrom(resolvedfunctioncall.getResult());
                bitField0_ = bitField0_ | 1;
            }
            if (resolvedfunctioncall.hasAssociatedRuleName())
            {
                bitField0_ = bitField0_ | 2;
                if (resolvedfunctioncall.associatedRuleName_ instanceof String)
                {
                    associatedRuleName_ = resolvedfunctioncall.associatedRuleName_;
                } else
                {
                    byte abyte0[] = (byte[])(byte[])resolvedfunctioncall.associatedRuleName_;
                    associatedRuleName_ = Arrays.copyOf(abyte0, abyte0.length);
                }
            }
            unknownFields = unknownFields.concat(resolvedfunctioncall.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((ResolvedFunctionCall)generatedmutablemessagelite);
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
            JVM INSTR lookupswitch 4: default 178
        //                       0: 181
        //                       10: 91
        //                       18: 103
        //                       26: 142;
               goto _L3 _L4 _L5 _L6 _L7
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            codedinputstream.readMessage(addProperties(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L6:
            if (result_ == com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance())
            {
                result_ = com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.newMessage();
            }
            bitField0_ = bitField0_ | 1;
            codedinputstream.readMessage(result_, extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L7:
            bitField0_ = bitField0_ | 2;
            associatedRuleName_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
            return true;
_L4:
            flag = true;
            if (true) goto _L9; else goto _L8
_L9:
            break MISSING_BLOCK_LABEL_17;
_L8:
        }

        public ResolvedFunctionCall newMessageForType()
        {
            return new ResolvedFunctionCall();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public ResolvedFunctionCall setAssociatedRuleName(String s)
        {
            assertMutable();
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                associatedRuleName_ = s;
                return this;
            }
        }

        public ResolvedFunctionCall setAssociatedRuleNameAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                associatedRuleName_ = abyte0;
                return this;
            }
        }

        public ResolvedFunctionCall setProperties(int i, ResolvedProperty resolvedproperty)
        {
            assertMutable();
            if (resolvedproperty == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePropertiesInitialized();
                properties_.set(i, resolvedproperty);
                return this;
            }
        }

        public ResolvedFunctionCall setResult(com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                result_ = value;
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
            int k = codedoutputstream.getTotalBytesWritten();
            if (properties_ != null)
            {
                for (int i = 0; i < properties_.size(); i++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(1, (MutableMessageLite)properties_.get(i));
                }

            }
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeMessageWithCachedSizes(2, result_);
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeByteArray(3, getAssociatedRuleNameAsBytes());
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
            defaultInstance = new ResolvedFunctionCall(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private ResolvedFunctionCall()
        {
            properties_ = null;
            associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
            initFields();
        }

        private ResolvedFunctionCall(boolean flag)
        {
            properties_ = null;
            associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
        }
    }

    public static final class ResolvedProperty extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int KEY_FIELD_NUMBER = 1;
        public static Parser PARSER;
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final ResolvedProperty defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private Object key_;
        private com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value value_;

        private void ensureValueInitialized()
        {
            if (value_ == com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance())
            {
                value_ = com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.newMessage();
            }
        }

        public static ResolvedProperty getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            value_ = com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance();
        }

        public static ResolvedProperty newMessage()
        {
            return new ResolvedProperty();
        }

        public ResolvedProperty clear()
        {
            assertMutable();
            super.clear();
            key_ = Internal.EMPTY_BYTE_ARRAY;
            bitField0_ = bitField0_ & -2;
            if (value_ != com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance())
            {
                value_.clear();
            }
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

        public ResolvedProperty clearKey()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            key_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public ResolvedProperty clearValue()
        {
            assertMutable();
            bitField0_ = bitField0_ & -3;
            if (value_ != com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance())
            {
                value_.clear();
            }
            return this;
        }

        public ResolvedProperty clone()
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
            if (!(obj instanceof ResolvedProperty))
            {
                return super.equals(obj);
            }
            obj = (ResolvedProperty)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (true && hasKey() == ((ResolvedProperty) (obj)).hasKey())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (hasKey())
            {
                if (flag && getKey().equals(((ResolvedProperty) (obj)).getKey()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && hasValue() == ((ResolvedProperty) (obj)).hasValue())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag3 = flag2;
            if (hasValue())
            {
                if (flag2 && getValue().equals(((ResolvedProperty) (obj)).getValue()))
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
            return flag3;
        }

        public final ResolvedProperty getDefaultInstanceForType()
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

        public String getKey()
        {
            Object obj = key_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            byte abyte0[] = (byte[])(byte[])obj;
            String s = Internal.toStringUtf8(abyte0);
            if (Internal.isValidUtf8(abyte0))
            {
                key_ = s;
            }
            return s;
        }

        public byte[] getKeyAsBytes()
        {
            byte abyte0[] = ((byte []) (key_));
            if (abyte0 instanceof String)
            {
                abyte0 = Internal.toByteArray((String)abyte0);
                key_ = abyte0;
                return abyte0;
            } else
            {
                return (byte[])(byte[])abyte0;
            }
        }

        public com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value getMutableValue()
        {
            assertMutable();
            ensureValueInitialized();
            bitField0_ = bitField0_ | 2;
            return value_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public int getSerializedSize()
        {
            int i = 0;
            if ((bitField0_ & 1) == 1)
            {
                i = 0 + CodedOutputStream.computeByteArraySize(1, getKeyAsBytes());
            }
            int j = i;
            if ((bitField0_ & 2) == 2)
            {
                j = i + CodedOutputStream.computeMessageSize(2, value_);
            }
            i = j + unknownFields.size();
            cachedSize = i;
            return i;
        }

        public com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value getValue()
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
                i = 0x13a46 + getKey().hashCode();
            }
            int j = i;
            if (hasValue())
            {
                j = (i * 37 + 2) * 53 + getValue().hashCode();
            }
            return j * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$ResolvedProperty");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            return !hasValue() || getValue().isInitialized();
        }

        public ResolvedProperty mergeFrom(ResolvedProperty resolvedproperty)
        {
            if (this == resolvedproperty)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (resolvedproperty == getDefaultInstance())
            {
                return this;
            }
            if (resolvedproperty.hasKey())
            {
                bitField0_ = bitField0_ | 1;
                if (resolvedproperty.key_ instanceof String)
                {
                    key_ = resolvedproperty.key_;
                } else
                {
                    byte abyte0[] = (byte[])(byte[])resolvedproperty.key_;
                    key_ = Arrays.copyOf(abyte0, abyte0.length);
                }
            }
            if (resolvedproperty.hasValue())
            {
                ensureValueInitialized();
                value_.mergeFrom(resolvedproperty.getValue());
                bitField0_ = bitField0_ | 2;
            }
            unknownFields = unknownFields.concat(resolvedproperty.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((ResolvedProperty)generatedmutablemessagelite);
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
            JVM INSTR lookupswitch 3: default 158
        //                       0: 161
        //                       10: 83
        //                       18: 104;
               goto _L3 _L4 _L5 _L6
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            bitField0_ = bitField0_ | 1;
            key_ = codedinputstream.readByteArray();
            continue; /* Loop/switch isn't completed */
_L6:
            if (value_ == com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance())
            {
                value_ = com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.newMessage();
            }
            bitField0_ = bitField0_ | 2;
            codedinputstream.readMessage(value_, extensionregistrylite);
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

        public ResolvedProperty newMessageForType()
        {
            return new ResolvedProperty();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public ResolvedProperty setKey(String s)
        {
            assertMutable();
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                key_ = s;
                return this;
            }
        }

        public ResolvedProperty setKeyAsBytes(byte abyte0[])
        {
            assertMutable();
            if (abyte0 == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                key_ = abyte0;
                return this;
            }
        }

        public ResolvedProperty setValue(com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 2;
                value_ = value;
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
                codedoutputstream.writeByteArray(1, getKeyAsBytes());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeMessageWithCachedSizes(2, value_);
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
            defaultInstance = new ResolvedProperty(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private ResolvedProperty()
        {
            key_ = Internal.EMPTY_BYTE_ARRAY;
            initFields();
        }

        private ResolvedProperty(boolean flag)
        {
            key_ = Internal.EMPTY_BYTE_ARRAY;
        }
    }

    public static final class ResolvedRule extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int ADD_MACROS_FIELD_NUMBER = 5;
        public static final int ADD_TAGS_FIELD_NUMBER = 3;
        public static final int NEGATIVE_PREDICATES_FIELD_NUMBER = 2;
        public static Parser PARSER;
        public static final int POSITIVE_PREDICATES_FIELD_NUMBER = 1;
        public static final int REMOVE_MACROS_FIELD_NUMBER = 6;
        public static final int REMOVE_TAGS_FIELD_NUMBER = 4;
        public static final int RESULT_FIELD_NUMBER = 7;
        private static final ResolvedRule defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private List addMacros_;
        private List addTags_;
        private int bitField0_;
        private List negativePredicates_;
        private List positivePredicates_;
        private List removeMacros_;
        private List removeTags_;
        private com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value result_;

        private void ensureAddMacrosInitialized()
        {
            if (addMacros_ == null)
            {
                addMacros_ = new ArrayList();
            }
        }

        private void ensureAddTagsInitialized()
        {
            if (addTags_ == null)
            {
                addTags_ = new ArrayList();
            }
        }

        private void ensureNegativePredicatesInitialized()
        {
            if (negativePredicates_ == null)
            {
                negativePredicates_ = new ArrayList();
            }
        }

        private void ensurePositivePredicatesInitialized()
        {
            if (positivePredicates_ == null)
            {
                positivePredicates_ = new ArrayList();
            }
        }

        private void ensureRemoveMacrosInitialized()
        {
            if (removeMacros_ == null)
            {
                removeMacros_ = new ArrayList();
            }
        }

        private void ensureRemoveTagsInitialized()
        {
            if (removeTags_ == null)
            {
                removeTags_ = new ArrayList();
            }
        }

        private void ensureResultInitialized()
        {
            if (result_ == com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance())
            {
                result_ = com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.newMessage();
            }
        }

        public static ResolvedRule getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            result_ = com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance();
        }

        public static ResolvedRule newMessage()
        {
            return new ResolvedRule();
        }

        public ResolvedFunctionCall addAddMacros()
        {
            assertMutable();
            ensureAddMacrosInitialized();
            ResolvedFunctionCall resolvedfunctioncall = ResolvedFunctionCall.newMessage();
            addMacros_.add(resolvedfunctioncall);
            return resolvedfunctioncall;
        }

        public ResolvedRule addAddMacros(ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureAddMacrosInitialized();
                addMacros_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedFunctionCall addAddTags()
        {
            assertMutable();
            ensureAddTagsInitialized();
            ResolvedFunctionCall resolvedfunctioncall = ResolvedFunctionCall.newMessage();
            addTags_.add(resolvedfunctioncall);
            return resolvedfunctioncall;
        }

        public ResolvedRule addAddTags(ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureAddTagsInitialized();
                addTags_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule addAllAddMacros(Iterable iterable)
        {
            assertMutable();
            ensureAddMacrosInitialized();
            AbstractMutableMessageLite.addAll(iterable, addMacros_);
            return this;
        }

        public ResolvedRule addAllAddTags(Iterable iterable)
        {
            assertMutable();
            ensureAddTagsInitialized();
            AbstractMutableMessageLite.addAll(iterable, addTags_);
            return this;
        }

        public ResolvedRule addAllNegativePredicates(Iterable iterable)
        {
            assertMutable();
            ensureNegativePredicatesInitialized();
            AbstractMutableMessageLite.addAll(iterable, negativePredicates_);
            return this;
        }

        public ResolvedRule addAllPositivePredicates(Iterable iterable)
        {
            assertMutable();
            ensurePositivePredicatesInitialized();
            AbstractMutableMessageLite.addAll(iterable, positivePredicates_);
            return this;
        }

        public ResolvedRule addAllRemoveMacros(Iterable iterable)
        {
            assertMutable();
            ensureRemoveMacrosInitialized();
            AbstractMutableMessageLite.addAll(iterable, removeMacros_);
            return this;
        }

        public ResolvedRule addAllRemoveTags(Iterable iterable)
        {
            assertMutable();
            ensureRemoveTagsInitialized();
            AbstractMutableMessageLite.addAll(iterable, removeTags_);
            return this;
        }

        public ResolvedFunctionCall addNegativePredicates()
        {
            assertMutable();
            ensureNegativePredicatesInitialized();
            ResolvedFunctionCall resolvedfunctioncall = ResolvedFunctionCall.newMessage();
            negativePredicates_.add(resolvedfunctioncall);
            return resolvedfunctioncall;
        }

        public ResolvedRule addNegativePredicates(ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureNegativePredicatesInitialized();
                negativePredicates_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedFunctionCall addPositivePredicates()
        {
            assertMutable();
            ensurePositivePredicatesInitialized();
            ResolvedFunctionCall resolvedfunctioncall = ResolvedFunctionCall.newMessage();
            positivePredicates_.add(resolvedfunctioncall);
            return resolvedfunctioncall;
        }

        public ResolvedRule addPositivePredicates(ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePositivePredicatesInitialized();
                positivePredicates_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedFunctionCall addRemoveMacros()
        {
            assertMutable();
            ensureRemoveMacrosInitialized();
            ResolvedFunctionCall resolvedfunctioncall = ResolvedFunctionCall.newMessage();
            removeMacros_.add(resolvedfunctioncall);
            return resolvedfunctioncall;
        }

        public ResolvedRule addRemoveMacros(ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRemoveMacrosInitialized();
                removeMacros_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedFunctionCall addRemoveTags()
        {
            assertMutable();
            ensureRemoveTagsInitialized();
            ResolvedFunctionCall resolvedfunctioncall = ResolvedFunctionCall.newMessage();
            removeTags_.add(resolvedfunctioncall);
            return resolvedfunctioncall;
        }

        public ResolvedRule addRemoveTags(ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRemoveTagsInitialized();
                removeTags_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule clear()
        {
            assertMutable();
            super.clear();
            positivePredicates_ = null;
            negativePredicates_ = null;
            addTags_ = null;
            removeTags_ = null;
            addMacros_ = null;
            removeMacros_ = null;
            if (result_ != com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance())
            {
                result_.clear();
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

        public ResolvedRule clearAddMacros()
        {
            assertMutable();
            addMacros_ = null;
            return this;
        }

        public ResolvedRule clearAddTags()
        {
            assertMutable();
            addTags_ = null;
            return this;
        }

        public ResolvedRule clearNegativePredicates()
        {
            assertMutable();
            negativePredicates_ = null;
            return this;
        }

        public ResolvedRule clearPositivePredicates()
        {
            assertMutable();
            positivePredicates_ = null;
            return this;
        }

        public ResolvedRule clearRemoveMacros()
        {
            assertMutable();
            removeMacros_ = null;
            return this;
        }

        public ResolvedRule clearRemoveTags()
        {
            assertMutable();
            removeTags_ = null;
            return this;
        }

        public ResolvedRule clearResult()
        {
            assertMutable();
            bitField0_ = bitField0_ & -2;
            if (result_ != com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance())
            {
                result_.clear();
            }
            return this;
        }

        public ResolvedRule clone()
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
            if (!(obj instanceof ResolvedRule))
            {
                return super.equals(obj);
            }
            obj = (ResolvedRule)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (true && getPositivePredicatesList().equals(((ResolvedRule) (obj)).getPositivePredicatesList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getNegativePredicatesList().equals(((ResolvedRule) (obj)).getNegativePredicatesList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getAddTagsList().equals(((ResolvedRule) (obj)).getAddTagsList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getRemoveTagsList().equals(((ResolvedRule) (obj)).getRemoveTagsList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getAddMacrosList().equals(((ResolvedRule) (obj)).getAddMacrosList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getRemoveMacrosList().equals(((ResolvedRule) (obj)).getRemoveMacrosList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && hasResult() == ((ResolvedRule) (obj)).hasResult())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag2 = flag1;
            if (hasResult())
            {
                if (flag1 && getResult().equals(((ResolvedRule) (obj)).getResult()))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
            }
            return flag2;
        }

        public ResolvedFunctionCall getAddMacros(int i)
        {
            return (ResolvedFunctionCall)addMacros_.get(i);
        }

        public int getAddMacrosCount()
        {
            if (addMacros_ == null)
            {
                return 0;
            } else
            {
                return addMacros_.size();
            }
        }

        public List getAddMacrosList()
        {
            if (addMacros_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(addMacros_);
            }
        }

        public ResolvedFunctionCall getAddTags(int i)
        {
            return (ResolvedFunctionCall)addTags_.get(i);
        }

        public int getAddTagsCount()
        {
            if (addTags_ == null)
            {
                return 0;
            } else
            {
                return addTags_.size();
            }
        }

        public List getAddTagsList()
        {
            if (addTags_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(addTags_);
            }
        }

        public final ResolvedRule getDefaultInstanceForType()
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

        public ResolvedFunctionCall getMutableAddMacros(int i)
        {
            return (ResolvedFunctionCall)addMacros_.get(i);
        }

        public List getMutableAddMacrosList()
        {
            assertMutable();
            ensureAddMacrosInitialized();
            return addMacros_;
        }

        public ResolvedFunctionCall getMutableAddTags(int i)
        {
            return (ResolvedFunctionCall)addTags_.get(i);
        }

        public List getMutableAddTagsList()
        {
            assertMutable();
            ensureAddTagsInitialized();
            return addTags_;
        }

        public ResolvedFunctionCall getMutableNegativePredicates(int i)
        {
            return (ResolvedFunctionCall)negativePredicates_.get(i);
        }

        public List getMutableNegativePredicatesList()
        {
            assertMutable();
            ensureNegativePredicatesInitialized();
            return negativePredicates_;
        }

        public ResolvedFunctionCall getMutablePositivePredicates(int i)
        {
            return (ResolvedFunctionCall)positivePredicates_.get(i);
        }

        public List getMutablePositivePredicatesList()
        {
            assertMutable();
            ensurePositivePredicatesInitialized();
            return positivePredicates_;
        }

        public ResolvedFunctionCall getMutableRemoveMacros(int i)
        {
            return (ResolvedFunctionCall)removeMacros_.get(i);
        }

        public List getMutableRemoveMacrosList()
        {
            assertMutable();
            ensureRemoveMacrosInitialized();
            return removeMacros_;
        }

        public ResolvedFunctionCall getMutableRemoveTags(int i)
        {
            return (ResolvedFunctionCall)removeTags_.get(i);
        }

        public List getMutableRemoveTagsList()
        {
            assertMutable();
            ensureRemoveTagsInitialized();
            return removeTags_;
        }

        public com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value getMutableResult()
        {
            assertMutable();
            ensureResultInitialized();
            bitField0_ = bitField0_ | 1;
            return result_;
        }

        public ResolvedFunctionCall getNegativePredicates(int i)
        {
            return (ResolvedFunctionCall)negativePredicates_.get(i);
        }

        public int getNegativePredicatesCount()
        {
            if (negativePredicates_ == null)
            {
                return 0;
            } else
            {
                return negativePredicates_.size();
            }
        }

        public List getNegativePredicatesList()
        {
            if (negativePredicates_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(negativePredicates_);
            }
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public ResolvedFunctionCall getPositivePredicates(int i)
        {
            return (ResolvedFunctionCall)positivePredicates_.get(i);
        }

        public int getPositivePredicatesCount()
        {
            if (positivePredicates_ == null)
            {
                return 0;
            } else
            {
                return positivePredicates_.size();
            }
        }

        public List getPositivePredicatesList()
        {
            if (positivePredicates_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(positivePredicates_);
            }
        }

        public ResolvedFunctionCall getRemoveMacros(int i)
        {
            return (ResolvedFunctionCall)removeMacros_.get(i);
        }

        public int getRemoveMacrosCount()
        {
            if (removeMacros_ == null)
            {
                return 0;
            } else
            {
                return removeMacros_.size();
            }
        }

        public List getRemoveMacrosList()
        {
            if (removeMacros_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(removeMacros_);
            }
        }

        public ResolvedFunctionCall getRemoveTags(int i)
        {
            return (ResolvedFunctionCall)removeTags_.get(i);
        }

        public int getRemoveTagsCount()
        {
            if (removeTags_ == null)
            {
                return 0;
            } else
            {
                return removeTags_.size();
            }
        }

        public List getRemoveTagsList()
        {
            if (removeTags_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(removeTags_);
            }
        }

        public com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value getResult()
        {
            return result_;
        }

        public int getSerializedSize()
        {
            int i = 0;
            int j = 0;
            if (positivePredicates_ != null)
            {
                int k = 0;
                do
                {
                    i = j;
                    if (k >= positivePredicates_.size())
                    {
                        break;
                    }
                    j += CodedOutputStream.computeMessageSize(1, (MessageLite)positivePredicates_.get(k));
                    k++;
                } while (true);
            }
            j = i;
            if (negativePredicates_ != null)
            {
                int l = 0;
                do
                {
                    j = i;
                    if (l >= negativePredicates_.size())
                    {
                        break;
                    }
                    i += CodedOutputStream.computeMessageSize(2, (MessageLite)negativePredicates_.get(l));
                    l++;
                } while (true);
            }
            i = j;
            if (addTags_ != null)
            {
                int i1 = 0;
                do
                {
                    i = j;
                    if (i1 >= addTags_.size())
                    {
                        break;
                    }
                    j += CodedOutputStream.computeMessageSize(3, (MessageLite)addTags_.get(i1));
                    i1++;
                } while (true);
            }
            j = i;
            if (removeTags_ != null)
            {
                int j1 = 0;
                do
                {
                    j = i;
                    if (j1 >= removeTags_.size())
                    {
                        break;
                    }
                    i += CodedOutputStream.computeMessageSize(4, (MessageLite)removeTags_.get(j1));
                    j1++;
                } while (true);
            }
            i = j;
            if (addMacros_ != null)
            {
                int k1 = 0;
                do
                {
                    i = j;
                    if (k1 >= addMacros_.size())
                    {
                        break;
                    }
                    j += CodedOutputStream.computeMessageSize(5, (MessageLite)addMacros_.get(k1));
                    k1++;
                } while (true);
            }
            j = i;
            if (removeMacros_ != null)
            {
                int l1 = 0;
                do
                {
                    j = i;
                    if (l1 >= removeMacros_.size())
                    {
                        break;
                    }
                    i += CodedOutputStream.computeMessageSize(6, (MessageLite)removeMacros_.get(l1));
                    l1++;
                } while (true);
            }
            i = j;
            if ((bitField0_ & 1) == 1)
            {
                i = j + CodedOutputStream.computeMessageSize(7, result_);
            }
            i += unknownFields.size();
            cachedSize = i;
            return i;
        }

        public boolean hasResult()
        {
            return (bitField0_ & 1) == 1;
        }

        public int hashCode()
        {
            int j = 41;
            if (getPositivePredicatesCount() > 0)
            {
                j = 0x13a46 + getPositivePredicatesList().hashCode();
            }
            int i = j;
            if (getNegativePredicatesCount() > 0)
            {
                i = (j * 37 + 2) * 53 + getNegativePredicatesList().hashCode();
            }
            j = i;
            if (getAddTagsCount() > 0)
            {
                j = (i * 37 + 3) * 53 + getAddTagsList().hashCode();
            }
            i = j;
            if (getRemoveTagsCount() > 0)
            {
                i = (j * 37 + 4) * 53 + getRemoveTagsList().hashCode();
            }
            j = i;
            if (getAddMacrosCount() > 0)
            {
                j = (i * 37 + 5) * 53 + getAddMacrosList().hashCode();
            }
            i = j;
            if (getRemoveMacrosCount() > 0)
            {
                i = (j * 37 + 6) * 53 + getRemoveMacrosList().hashCode();
            }
            j = i;
            if (hasResult())
            {
                j = (i * 37 + 7) * 53 + getResult().hashCode();
            }
            return j * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$ResolvedRule");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L17:
            if (i >= getPositivePredicatesCount()) goto _L2; else goto _L1
_L1:
            if (getPositivePredicates(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            i = 0;
_L6:
            if (i >= getNegativePredicatesCount())
            {
                break MISSING_BLOCK_LABEL_58;
            }
            if (!getNegativePredicates(i).isInitialized()) goto _L3; else goto _L5
_L5:
            i++;
              goto _L6
            i = 0;
_L8:
            if (i >= getAddTagsCount())
            {
                break MISSING_BLOCK_LABEL_86;
            }
            if (!getAddTags(i).isInitialized()) goto _L3; else goto _L7
_L7:
            i++;
              goto _L8
            i = 0;
_L10:
            if (i >= getRemoveTagsCount())
            {
                break MISSING_BLOCK_LABEL_114;
            }
            if (!getRemoveTags(i).isInitialized()) goto _L3; else goto _L9
_L9:
            i++;
              goto _L10
            i = 0;
_L12:
            if (i >= getAddMacrosCount())
            {
                break MISSING_BLOCK_LABEL_142;
            }
            if (!getAddMacros(i).isInitialized()) goto _L3; else goto _L11
_L11:
            i++;
              goto _L12
            i = 0;
_L14:
            if (i >= getRemoveMacrosCount())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!getRemoveMacros(i).isInitialized()) goto _L3; else goto _L13
_L13:
            i++;
              goto _L14
            if (hasResult() && !getResult().isInitialized()) goto _L3; else goto _L15
_L15:
            return true;
            if (true) goto _L17; else goto _L16
_L16:
        }

        public ResolvedRule mergeFrom(ResolvedRule resolvedrule)
        {
            if (this == resolvedrule)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (resolvedrule == getDefaultInstance())
            {
                return this;
            }
            if (resolvedrule.positivePredicates_ != null && !resolvedrule.positivePredicates_.isEmpty())
            {
                ensurePositivePredicatesInitialized();
                AbstractMutableMessageLite.addAll(resolvedrule.positivePredicates_, positivePredicates_);
            }
            if (resolvedrule.negativePredicates_ != null && !resolvedrule.negativePredicates_.isEmpty())
            {
                ensureNegativePredicatesInitialized();
                AbstractMutableMessageLite.addAll(resolvedrule.negativePredicates_, negativePredicates_);
            }
            if (resolvedrule.addTags_ != null && !resolvedrule.addTags_.isEmpty())
            {
                ensureAddTagsInitialized();
                AbstractMutableMessageLite.addAll(resolvedrule.addTags_, addTags_);
            }
            if (resolvedrule.removeTags_ != null && !resolvedrule.removeTags_.isEmpty())
            {
                ensureRemoveTagsInitialized();
                AbstractMutableMessageLite.addAll(resolvedrule.removeTags_, removeTags_);
            }
            if (resolvedrule.addMacros_ != null && !resolvedrule.addMacros_.isEmpty())
            {
                ensureAddMacrosInitialized();
                AbstractMutableMessageLite.addAll(resolvedrule.addMacros_, addMacros_);
            }
            if (resolvedrule.removeMacros_ != null && !resolvedrule.removeMacros_.isEmpty())
            {
                ensureRemoveMacrosInitialized();
                AbstractMutableMessageLite.addAll(resolvedrule.removeMacros_, removeMacros_);
            }
            if (resolvedrule.hasResult())
            {
                ensureResultInitialized();
                result_.mergeFrom(resolvedrule.getResult());
                bitField0_ = bitField0_ | 1;
            }
            unknownFields = unknownFields.concat(resolvedrule.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((ResolvedRule)generatedmutablemessagelite);
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
            JVM INSTR lookupswitch 8: default 249
        //                       0: 252
        //                       10: 123
        //                       18: 135
        //                       26: 147
        //                       34: 159
        //                       42: 171
        //                       50: 183
        //                       58: 195;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            codedinputstream.readMessage(addPositivePredicates(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L6:
            codedinputstream.readMessage(addNegativePredicates(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L7:
            codedinputstream.readMessage(addAddTags(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L8:
            codedinputstream.readMessage(addRemoveTags(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L9:
            codedinputstream.readMessage(addAddMacros(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L10:
            codedinputstream.readMessage(addRemoveMacros(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L11:
            if (result_ == com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.getDefaultInstance())
            {
                result_ = com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value.newMessage();
            }
            bitField0_ = bitField0_ | 1;
            codedinputstream.readMessage(result_, extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
            return true;
_L4:
            flag = true;
            if (true) goto _L13; else goto _L12
_L13:
            break MISSING_BLOCK_LABEL_17;
_L12:
        }

        public ResolvedRule newMessageForType()
        {
            return new ResolvedRule();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public ResolvedRule setAddMacros(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureAddMacrosInitialized();
                addMacros_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule setAddTags(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureAddTagsInitialized();
                addTags_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule setNegativePredicates(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureNegativePredicatesInitialized();
                negativePredicates_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule setPositivePredicates(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePositivePredicatesInitialized();
                positivePredicates_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule setRemoveMacros(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRemoveMacrosInitialized();
                removeMacros_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule setRemoveTags(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRemoveTagsInitialized();
                removeTags_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule setResult(com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value value)
        {
            assertMutable();
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                result_ = value;
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
            int l1 = codedoutputstream.getTotalBytesWritten();
            if (positivePredicates_ != null)
            {
                for (int i = 0; i < positivePredicates_.size(); i++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(1, (MutableMessageLite)positivePredicates_.get(i));
                }

            }
            if (negativePredicates_ != null)
            {
                for (int j = 0; j < negativePredicates_.size(); j++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(2, (MutableMessageLite)negativePredicates_.get(j));
                }

            }
            if (addTags_ != null)
            {
                for (int k = 0; k < addTags_.size(); k++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(3, (MutableMessageLite)addTags_.get(k));
                }

            }
            if (removeTags_ != null)
            {
                for (int l = 0; l < removeTags_.size(); l++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(4, (MutableMessageLite)removeTags_.get(l));
                }

            }
            if (addMacros_ != null)
            {
                for (int i1 = 0; i1 < addMacros_.size(); i1++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(5, (MutableMessageLite)addMacros_.get(i1));
                }

            }
            if (removeMacros_ != null)
            {
                for (int j1 = 0; j1 < removeMacros_.size(); j1++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(6, (MutableMessageLite)removeMacros_.get(j1));
                }

            }
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeMessageWithCachedSizes(7, result_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
            int k1 = codedoutputstream.getTotalBytesWritten();
            if (getCachedSize() != k1 - l1)
            {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            } else
            {
                return;
            }
        }

        static 
        {
            defaultInstance = new ResolvedRule(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private ResolvedRule()
        {
            positivePredicates_ = null;
            negativePredicates_ = null;
            addTags_ = null;
            removeTags_ = null;
            addMacros_ = null;
            removeMacros_ = null;
            initFields();
        }

        private ResolvedRule(boolean flag)
        {
            positivePredicates_ = null;
            negativePredicates_ = null;
            addTags_ = null;
            removeTags_ = null;
            addMacros_ = null;
            removeMacros_ = null;
        }
    }

    public static final class RuleEvaluationStepInfo extends GeneratedMutableMessageLite
        implements MutableMessageLite
    {

        public static final int ENABLED_FUNCTIONS_FIELD_NUMBER = 2;
        public static Parser PARSER;
        public static final int RULES_FIELD_NUMBER = 1;
        private static final RuleEvaluationStepInfo defaultInstance;
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0L;
        private List enabledFunctions_;
        private List rules_;

        private void ensureEnabledFunctionsInitialized()
        {
            if (enabledFunctions_ == null)
            {
                enabledFunctions_ = new ArrayList();
            }
        }

        private void ensureRulesInitialized()
        {
            if (rules_ == null)
            {
                rules_ = new ArrayList();
            }
        }

        public static RuleEvaluationStepInfo getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
        }

        public static RuleEvaluationStepInfo newMessage()
        {
            return new RuleEvaluationStepInfo();
        }

        public RuleEvaluationStepInfo addAllEnabledFunctions(Iterable iterable)
        {
            assertMutable();
            ensureEnabledFunctionsInitialized();
            AbstractMutableMessageLite.addAll(iterable, enabledFunctions_);
            return this;
        }

        public RuleEvaluationStepInfo addAllRules(Iterable iterable)
        {
            assertMutable();
            ensureRulesInitialized();
            AbstractMutableMessageLite.addAll(iterable, rules_);
            return this;
        }

        public ResolvedFunctionCall addEnabledFunctions()
        {
            assertMutable();
            ensureEnabledFunctionsInitialized();
            ResolvedFunctionCall resolvedfunctioncall = ResolvedFunctionCall.newMessage();
            enabledFunctions_.add(resolvedfunctioncall);
            return resolvedfunctioncall;
        }

        public RuleEvaluationStepInfo addEnabledFunctions(ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEnabledFunctionsInitialized();
                enabledFunctions_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule addRules()
        {
            assertMutable();
            ensureRulesInitialized();
            ResolvedRule resolvedrule = ResolvedRule.newMessage();
            rules_.add(resolvedrule);
            return resolvedrule;
        }

        public RuleEvaluationStepInfo addRules(ResolvedRule resolvedrule)
        {
            assertMutable();
            if (resolvedrule == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRulesInitialized();
                rules_.add(resolvedrule);
                return this;
            }
        }

        public RuleEvaluationStepInfo clear()
        {
            assertMutable();
            super.clear();
            rules_ = null;
            enabledFunctions_ = null;
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

        public RuleEvaluationStepInfo clearEnabledFunctions()
        {
            assertMutable();
            enabledFunctions_ = null;
            return this;
        }

        public RuleEvaluationStepInfo clearRules()
        {
            assertMutable();
            rules_ = null;
            return this;
        }

        public RuleEvaluationStepInfo clone()
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
            if (!(obj instanceof RuleEvaluationStepInfo))
            {
                return super.equals(obj);
            }
            obj = (RuleEvaluationStepInfo)obj;
            boolean flag;
            boolean flag1;
            if (true && getRulesList().equals(((RuleEvaluationStepInfo) (obj)).getRulesList()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && getEnabledFunctionsList().equals(((RuleEvaluationStepInfo) (obj)).getEnabledFunctionsList()))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            return flag1;
        }

        public final RuleEvaluationStepInfo getDefaultInstanceForType()
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

        public ResolvedFunctionCall getEnabledFunctions(int i)
        {
            return (ResolvedFunctionCall)enabledFunctions_.get(i);
        }

        public int getEnabledFunctionsCount()
        {
            if (enabledFunctions_ == null)
            {
                return 0;
            } else
            {
                return enabledFunctions_.size();
            }
        }

        public List getEnabledFunctionsList()
        {
            if (enabledFunctions_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(enabledFunctions_);
            }
        }

        public ResolvedFunctionCall getMutableEnabledFunctions(int i)
        {
            return (ResolvedFunctionCall)enabledFunctions_.get(i);
        }

        public List getMutableEnabledFunctionsList()
        {
            assertMutable();
            ensureEnabledFunctionsInitialized();
            return enabledFunctions_;
        }

        public ResolvedRule getMutableRules(int i)
        {
            return (ResolvedRule)rules_.get(i);
        }

        public List getMutableRulesList()
        {
            assertMutable();
            ensureRulesInitialized();
            return rules_;
        }

        public Parser getParserForType()
        {
            return PARSER;
        }

        public ResolvedRule getRules(int i)
        {
            return (ResolvedRule)rules_.get(i);
        }

        public int getRulesCount()
        {
            if (rules_ == null)
            {
                return 0;
            } else
            {
                return rules_.size();
            }
        }

        public List getRulesList()
        {
            if (rules_ == null)
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(rules_);
            }
        }

        public int getSerializedSize()
        {
            int i = 0;
            int j = 0;
            if (rules_ != null)
            {
                int l = 0;
                do
                {
                    i = j;
                    if (l >= rules_.size())
                    {
                        break;
                    }
                    j += CodedOutputStream.computeMessageSize(1, (MessageLite)rules_.get(l));
                    l++;
                } while (true);
            }
            int i1 = i;
            if (enabledFunctions_ != null)
            {
                int k = 0;
                do
                {
                    i1 = i;
                    if (k >= enabledFunctions_.size())
                    {
                        break;
                    }
                    i += CodedOutputStream.computeMessageSize(2, (MessageLite)enabledFunctions_.get(k));
                    k++;
                } while (true);
            }
            i = i1 + unknownFields.size();
            cachedSize = i;
            return i;
        }

        public int hashCode()
        {
            int i = 41;
            if (getRulesCount() > 0)
            {
                i = 0x13a46 + getRulesList().hashCode();
            }
            int j = i;
            if (getEnabledFunctionsCount() > 0)
            {
                j = (i * 37 + 2) * 53 + getEnabledFunctionsList().hashCode();
            }
            return j * 29 + unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault()
        {
            if (immutableDefault == null)
            {
                immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$RuleEvaluationStepInfo");
            }
            return immutableDefault;
        }

        public final boolean isInitialized()
        {
            int i = 0;
_L7:
            if (i >= getRulesCount()) goto _L2; else goto _L1
_L1:
            if (getRules(i).isInitialized()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i++;
            continue; /* Loop/switch isn't completed */
_L2:
            int j = 0;
label0:
            do
            {
label1:
                {
                    if (j >= getEnabledFunctionsCount())
                    {
                        break label1;
                    }
                    if (!getEnabledFunctions(j).isInitialized())
                    {
                        break label0;
                    }
                    j++;
                }
            } while (true);
            if (true) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
        }

        public RuleEvaluationStepInfo mergeFrom(RuleEvaluationStepInfo ruleevaluationstepinfo)
        {
            if (this == ruleevaluationstepinfo)
            {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (ruleevaluationstepinfo == getDefaultInstance())
            {
                return this;
            }
            if (ruleevaluationstepinfo.rules_ != null && !ruleevaluationstepinfo.rules_.isEmpty())
            {
                ensureRulesInitialized();
                AbstractMutableMessageLite.addAll(ruleevaluationstepinfo.rules_, rules_);
            }
            if (ruleevaluationstepinfo.enabledFunctions_ != null && !ruleevaluationstepinfo.enabledFunctions_.isEmpty())
            {
                ensureEnabledFunctionsInitialized();
                AbstractMutableMessageLite.addAll(ruleevaluationstepinfo.enabledFunctions_, enabledFunctions_);
            }
            unknownFields = unknownFields.concat(ruleevaluationstepinfo.unknownFields);
            return this;
        }

        public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
        {
            return mergeFrom((RuleEvaluationStepInfo)generatedmutablemessagelite);
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
            JVM INSTR lookupswitch 3: default 122
        //                       0: 125
        //                       10: 83
        //                       18: 95;
               goto _L3 _L4 _L5 _L6
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            codedinputstream.readMessage(addRules(), extensionregistrylite);
            continue; /* Loop/switch isn't completed */
_L6:
            codedinputstream.readMessage(addEnabledFunctions(), extensionregistrylite);
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

        public RuleEvaluationStepInfo newMessageForType()
        {
            return new RuleEvaluationStepInfo();
        }

        public volatile MutableMessageLite newMessageForType()
        {
            return newMessageForType();
        }

        public RuleEvaluationStepInfo setEnabledFunctions(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            assertMutable();
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEnabledFunctionsInitialized();
                enabledFunctions_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public RuleEvaluationStepInfo setRules(int i, ResolvedRule resolvedrule)
        {
            assertMutable();
            if (resolvedrule == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRulesInitialized();
                rules_.set(i, resolvedrule);
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
            int l = codedoutputstream.getTotalBytesWritten();
            if (rules_ != null)
            {
                for (int i = 0; i < rules_.size(); i++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(1, (MutableMessageLite)rules_.get(i));
                }

            }
            if (enabledFunctions_ != null)
            {
                for (int j = 0; j < enabledFunctions_.size(); j++)
                {
                    codedoutputstream.writeMessageWithCachedSizes(2, (MutableMessageLite)enabledFunctions_.get(j));
                }

            }
            codedoutputstream.writeRawBytes(unknownFields);
            int k = codedoutputstream.getTotalBytesWritten();
            if (getCachedSize() != k - l)
            {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            } else
            {
                return;
            }
        }

        static 
        {
            defaultInstance = new RuleEvaluationStepInfo(true);
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
            PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        }

        private RuleEvaluationStepInfo()
        {
            rules_ = null;
            enabledFunctions_ = null;
            initFields();
        }

        private RuleEvaluationStepInfo(boolean flag)
        {
            rules_ = null;
            enabledFunctions_ = null;
        }
    }


    private MutableDebug()
    {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionregistrylite)
    {
        extensionregistrylite.add(MacroEvaluationInfo.macro);
    }

}
