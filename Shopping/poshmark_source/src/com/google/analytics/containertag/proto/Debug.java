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
import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Debug
{
    public static final class DataLayerEventEvaluationInfo extends GeneratedMessageLite
        implements DataLayerEventEvaluationInfoOrBuilder
    {

        public static Parser PARSER = new AbstractParser() {

            public DataLayerEventEvaluationInfo parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new DataLayerEventEvaluationInfo(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int RESULTS_FIELD_NUMBER = 2;
        public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
        private static final DataLayerEventEvaluationInfo defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List results_;
        private RuleEvaluationStepInfo rulesEvaluation_;
        private final ByteString unknownFields;

        public static DataLayerEventEvaluationInfo getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            results_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(DataLayerEventEvaluationInfo datalayereventevaluationinfo)
        {
            return newBuilder().mergeFrom(datalayereventevaluationinfo);
        }

        public static DataLayerEventEvaluationInfo parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (DataLayerEventEvaluationInfo)PARSER.parseDelimitedFrom(inputstream);
        }

        public static DataLayerEventEvaluationInfo parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (DataLayerEventEvaluationInfo)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static DataLayerEventEvaluationInfo parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (DataLayerEventEvaluationInfo)PARSER.parseFrom(bytestring);
        }

        public static DataLayerEventEvaluationInfo parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (DataLayerEventEvaluationInfo)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static DataLayerEventEvaluationInfo parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (DataLayerEventEvaluationInfo)PARSER.parseFrom(codedinputstream);
        }

        public static DataLayerEventEvaluationInfo parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (DataLayerEventEvaluationInfo)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static DataLayerEventEvaluationInfo parseFrom(InputStream inputstream)
            throws IOException
        {
            return (DataLayerEventEvaluationInfo)PARSER.parseFrom(inputstream);
        }

        public static DataLayerEventEvaluationInfo parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (DataLayerEventEvaluationInfo)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static DataLayerEventEvaluationInfo parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (DataLayerEventEvaluationInfo)PARSER.parseFrom(abyte0);
        }

        public static DataLayerEventEvaluationInfo parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (DataLayerEventEvaluationInfo)PARSER.parseFrom(abyte0, extensionregistrylite);
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

        public DataLayerEventEvaluationInfo getDefaultInstanceForType()
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

        public ResolvedFunctionCall getResults(int i)
        {
            return (ResolvedFunctionCall)results_.get(i);
        }

        public int getResultsCount()
        {
            return results_.size();
        }

        public List getResultsList()
        {
            return results_;
        }

        public ResolvedFunctionCallOrBuilder getResultsOrBuilder(int i)
        {
            return (ResolvedFunctionCallOrBuilder)results_.get(i);
        }

        public List getResultsOrBuilderList()
        {
            return results_;
        }

        public RuleEvaluationStepInfo getRulesEvaluation()
        {
            return rulesEvaluation_;
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
                i = 0 + CodedOutputStream.computeMessageSize(1, rulesEvaluation_);
            }
            boolean flag = false;
            int j = i;
            for (i = ((flag) ? 1 : 0); i < results_.size(); i++)
            {
                j += CodedOutputStream.computeMessageSize(2, (MessageLite)results_.get(i));
            }

            i = j + unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public boolean hasRulesEvaluation()
        {
            return (bitField0_ & 1) == 1;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Debug$DataLayerEventEvaluationInfo.hashCode() + 779;
            int i = j;
            if (hasRulesEvaluation())
            {
                i = (j * 37 + 1) * 53 + getRulesEvaluation().hashCode();
            }
            j = i;
            if (getResultsCount() > 0)
            {
                j = (i * 37 + 2) * 53 + getResultsList().hashCode();
            }
            i = j * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$DataLayerEventEvaluationInfo");
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
            if (hasRulesEvaluation() && !getRulesEvaluation().isInitialized())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getResultsCount(); i++)
            {
                if (!getResults(i).isInitialized())
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
            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeMessage(1, rulesEvaluation_);
            }
            for (int i = 0; i < results_.size(); i++)
            {
                codedoutputstream.writeMessage(2, (MessageLite)results_.get(i));
            }

            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new DataLayerEventEvaluationInfo(true);
            defaultInstance.initFields();
        }


/*
        static RuleEvaluationStepInfo access$4502(DataLayerEventEvaluationInfo datalayereventevaluationinfo, RuleEvaluationStepInfo ruleevaluationstepinfo)
        {
            datalayereventevaluationinfo.rulesEvaluation_ = ruleevaluationstepinfo;
            return ruleevaluationstepinfo;
        }

*/



/*
        static List access$4602(DataLayerEventEvaluationInfo datalayereventevaluationinfo, List list)
        {
            datalayereventevaluationinfo.results_ = list;
            return list;
        }

*/


/*
        static int access$4702(DataLayerEventEvaluationInfo datalayereventevaluationinfo, int i)
        {
            datalayereventevaluationinfo.bitField0_ = i;
            return i;
        }

*/


        private DataLayerEventEvaluationInfo(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
_L18:
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
            JVM INSTR lookupswitch 3: default 506
        //                       0: 509
        //                       10: 127
        //                       18: 319;
               goto _L3 _L4 _L5 _L6
_L3:
            l = i;
            k = i;
            i1 = i;
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, j))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            RuleEvaluationStepInfo.Builder builder;
            builder = null;
            l = i;
            k = i;
            i1 = i;
            if ((bitField0_ & 1) != 1) goto _L8; else goto _L7
_L7:
            l = i;
            k = i;
            i1 = i;
            builder = rulesEvaluation_.toBuilder();
_L8:
            l = i;
            k = i;
            i1 = i;
            rulesEvaluation_ = (RuleEvaluationStepInfo)codedinputstream.readMessage(RuleEvaluationStepInfo.PARSER, extensionregistrylite);
            if (builder == null) goto _L10; else goto _L9
_L9:
            l = i;
            k = i;
            i1 = i;
            builder.mergeFrom(rulesEvaluation_);
            l = i;
            k = i;
            i1 = i;
            rulesEvaluation_ = builder.buildPartial();
_L10:
            l = i;
            k = i;
            i1 = i;
            bitField0_ = bitField0_ | 1;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            k = l;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            if ((k & 2) == 2)
            {
                results_ = Collections.unmodifiableList(results_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L16:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            j = i;
            if ((i & 2) == 2) goto _L12; else goto _L11
_L11:
            l = i;
            k = i;
            i1 = i;
            results_ = new ArrayList();
            j = i | 2;
_L12:
            l = j;
            k = j;
            i1 = j;
            results_.add(codedinputstream.readMessage(ResolvedFunctionCall.PARSER, extensionregistrylite));
            i = j;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            k = i1;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L2:
            if ((i & 2) == 2)
            {
                results_ = Collections.unmodifiableList(results_);
            }
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


        private DataLayerEventEvaluationInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private DataLayerEventEvaluationInfo(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class DataLayerEventEvaluationInfo.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements DataLayerEventEvaluationInfoOrBuilder
    {

        private int bitField0_;
        private List results_;
        private RuleEvaluationStepInfo rulesEvaluation_;

        private static DataLayerEventEvaluationInfo.Builder create()
        {
            return new DataLayerEventEvaluationInfo.Builder();
        }

        private void ensureResultsIsMutable()
        {
            if ((bitField0_ & 2) != 2)
            {
                results_ = new ArrayList(results_);
                bitField0_ = bitField0_ | 2;
            }
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public DataLayerEventEvaluationInfo.Builder addAllResults(Iterable iterable)
        {
            ensureResultsIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, results_);
            return this;
        }

        public DataLayerEventEvaluationInfo.Builder addResults(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureResultsIsMutable();
            results_.add(i, builder.build());
            return this;
        }

        public DataLayerEventEvaluationInfo.Builder addResults(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureResultsIsMutable();
                results_.add(i, resolvedfunctioncall);
                return this;
            }
        }

        public DataLayerEventEvaluationInfo.Builder addResults(ResolvedFunctionCall.Builder builder)
        {
            ensureResultsIsMutable();
            results_.add(builder.build());
            return this;
        }

        public DataLayerEventEvaluationInfo.Builder addResults(ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureResultsIsMutable();
                results_.add(resolvedfunctioncall);
                return this;
            }
        }

        public DataLayerEventEvaluationInfo build()
        {
            DataLayerEventEvaluationInfo datalayereventevaluationinfo = buildPartial();
            if (!datalayereventevaluationinfo.isInitialized())
            {
                throw newUninitializedMessageException(datalayereventevaluationinfo);
            } else
            {
                return datalayereventevaluationinfo;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public DataLayerEventEvaluationInfo buildPartial()
        {
            DataLayerEventEvaluationInfo datalayereventevaluationinfo = new DataLayerEventEvaluationInfo(this);
            int j = bitField0_;
            int i = 0;
            if ((j & 1) == 1)
            {
                i = false | true;
            }
            datalayereventevaluationinfo.rulesEvaluation_ = rulesEvaluation_;
            if ((bitField0_ & 2) == 2)
            {
                results_ = Collections.unmodifiableList(results_);
                bitField0_ = bitField0_ & -3;
            }
            datalayereventevaluationinfo.results_ = results_;
            datalayereventevaluationinfo.bitField0_ = i;
            return datalayereventevaluationinfo;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public DataLayerEventEvaluationInfo.Builder clear()
        {
            super.clear();
            rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            bitField0_ = bitField0_ & -2;
            results_ = Collections.emptyList();
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

        public DataLayerEventEvaluationInfo.Builder clearResults()
        {
            results_ = Collections.emptyList();
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public DataLayerEventEvaluationInfo.Builder clearRulesEvaluation()
        {
            rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public DataLayerEventEvaluationInfo.Builder clone()
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

        public DataLayerEventEvaluationInfo getDefaultInstanceForType()
        {
            return DataLayerEventEvaluationInfo.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public ResolvedFunctionCall getResults(int i)
        {
            return (ResolvedFunctionCall)results_.get(i);
        }

        public int getResultsCount()
        {
            return results_.size();
        }

        public List getResultsList()
        {
            return Collections.unmodifiableList(results_);
        }

        public RuleEvaluationStepInfo getRulesEvaluation()
        {
            return rulesEvaluation_;
        }

        public boolean hasRulesEvaluation()
        {
            return (bitField0_ & 1) == 1;
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

        public DataLayerEventEvaluationInfo.Builder mergeFrom(DataLayerEventEvaluationInfo datalayereventevaluationinfo)
        {
            if (datalayereventevaluationinfo == DataLayerEventEvaluationInfo.getDefaultInstance())
            {
                return this;
            }
            if (datalayereventevaluationinfo.hasRulesEvaluation())
            {
                mergeRulesEvaluation(datalayereventevaluationinfo.getRulesEvaluation());
            }
            if (!datalayereventevaluationinfo.results_.isEmpty())
            {
                if (results_.isEmpty())
                {
                    results_ = datalayereventevaluationinfo.results_;
                    bitField0_ = bitField0_ & -3;
                } else
                {
                    ensureResultsIsMutable();
                    results_.addAll(datalayereventevaluationinfo.results_);
                }
            }
            setUnknownFields(getUnknownFields().concat(datalayereventevaluationinfo.unknownFields));
            return this;
        }

        public DataLayerEventEvaluationInfo.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (DataLayerEventEvaluationInfo)DataLayerEventEvaluationInfo.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((DataLayerEventEvaluationInfo) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (DataLayerEventEvaluationInfo)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((DataLayerEventEvaluationInfo) (codedinputstream1)));
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
            return mergeFrom((DataLayerEventEvaluationInfo)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public DataLayerEventEvaluationInfo.Builder mergeRulesEvaluation(RuleEvaluationStepInfo ruleevaluationstepinfo)
        {
            if ((bitField0_ & 1) == 1 && rulesEvaluation_ != RuleEvaluationStepInfo.getDefaultInstance())
            {
                rulesEvaluation_ = RuleEvaluationStepInfo.newBuilder(rulesEvaluation_).mergeFrom(ruleevaluationstepinfo).buildPartial();
            } else
            {
                rulesEvaluation_ = ruleevaluationstepinfo;
            }
            bitField0_ = bitField0_ | 1;
            return this;
        }

        public DataLayerEventEvaluationInfo.Builder removeResults(int i)
        {
            ensureResultsIsMutable();
            results_.remove(i);
            return this;
        }

        public DataLayerEventEvaluationInfo.Builder setResults(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureResultsIsMutable();
            results_.set(i, builder.build());
            return this;
        }

        public DataLayerEventEvaluationInfo.Builder setResults(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureResultsIsMutable();
                results_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public DataLayerEventEvaluationInfo.Builder setRulesEvaluation(RuleEvaluationStepInfo.Builder builder)
        {
            rulesEvaluation_ = builder.build();
            bitField0_ = bitField0_ | 1;
            return this;
        }

        public DataLayerEventEvaluationInfo.Builder setRulesEvaluation(RuleEvaluationStepInfo ruleevaluationstepinfo)
        {
            if (ruleevaluationstepinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                rulesEvaluation_ = ruleevaluationstepinfo;
                bitField0_ = bitField0_ | 1;
                return this;
            }
        }


        private DataLayerEventEvaluationInfo.Builder()
        {
            rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            results_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }
    }

    public static interface DataLayerEventEvaluationInfoOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract ResolvedFunctionCall getResults(int i);

        public abstract int getResultsCount();

        public abstract List getResultsList();

        public abstract RuleEvaluationStepInfo getRulesEvaluation();

        public abstract boolean hasRulesEvaluation();
    }

    public static final class DebugEvents extends GeneratedMessageLite
        implements DebugEventsOrBuilder
    {

        public static final int EVENT_FIELD_NUMBER = 1;
        public static Parser PARSER = new AbstractParser() {

            public DebugEvents parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new DebugEvents(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        private static final DebugEvents defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private List event_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public static DebugEvents getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            event_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(DebugEvents debugevents)
        {
            return newBuilder().mergeFrom(debugevents);
        }

        public static DebugEvents parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (DebugEvents)PARSER.parseDelimitedFrom(inputstream);
        }

        public static DebugEvents parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (DebugEvents)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static DebugEvents parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (DebugEvents)PARSER.parseFrom(bytestring);
        }

        public static DebugEvents parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (DebugEvents)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static DebugEvents parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (DebugEvents)PARSER.parseFrom(codedinputstream);
        }

        public static DebugEvents parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (DebugEvents)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static DebugEvents parseFrom(InputStream inputstream)
            throws IOException
        {
            return (DebugEvents)PARSER.parseFrom(inputstream);
        }

        public static DebugEvents parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (DebugEvents)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static DebugEvents parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (DebugEvents)PARSER.parseFrom(abyte0);
        }

        public static DebugEvents parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (DebugEvents)PARSER.parseFrom(abyte0, extensionregistrylite);
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

        public DebugEvents getDefaultInstanceForType()
        {
            return defaultInstance;
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
            return event_.size();
        }

        public List getEventList()
        {
            return event_;
        }

        public EventInfoOrBuilder getEventOrBuilder(int i)
        {
            return (EventInfoOrBuilder)event_.get(i);
        }

        public List getEventOrBuilderList()
        {
            return event_;
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
            for (i = 0; i < event_.size(); i++)
            {
                j += CodedOutputStream.computeMessageSize(1, (MessageLite)event_.get(i));
            }

            i = j + unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Debug$DebugEvents.hashCode() + 779;
            int i = j;
            if (getEventCount() > 0)
            {
                i = (j * 37 + 1) * 53 + getEventList().hashCode();
            }
            i = i * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$DebugEvents");
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
            for (int i = 0; i < getEventCount(); i++)
            {
                if (!getEvent(i).isInitialized())
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
            for (int i = 0; i < event_.size(); i++)
            {
                codedoutputstream.writeMessage(1, (MessageLite)event_.get(i));
            }

            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new DebugEvents(true);
            defaultInstance.initFields();
        }



/*
        static List access$302(DebugEvents debugevents, List list)
        {
            debugevents.event_ = list;
            return list;
        }

*/


        private DebugEvents(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            boolean flag;
            boolean flag2;
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            initFields();
            flag = false;
            output = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(output);
            flag2 = false;
_L13:
            if (flag2) goto _L2; else goto _L1
_L1:
            boolean flag1;
            boolean flag3;
            boolean flag4;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 2: default 347
        //                       0: 350
        //                       10: 115;
               goto _L3 _L4 _L5
_L3:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag2 = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            i = ((flag) ? 1 : 0);
            if ((flag & true)) goto _L7; else goto _L6
_L6:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            event_ = new ArrayList();
            i = flag | true;
_L7:
            flag3 = i;
            flag1 = i;
            flag4 = i;
            event_.add(codedinputstream.readMessage(EventInfo.PARSER, extensionregistrylite));
            flag = i;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            flag1 = flag3;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            if ((flag1 & true))
            {
                event_ = Collections.unmodifiableList(event_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L11:
            makeExtensionsImmutable();
            throw codedinputstream;
_L2:
            if ((flag & true))
            {
                event_ = Collections.unmodifiableList(event_);
            }
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
            flag1 = flag4;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L11; else goto _L10
_L10:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag2 = true;
            if (true) goto _L13; else goto _L12
_L12:
        }


        private DebugEvents(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private DebugEvents(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class DebugEvents.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements DebugEventsOrBuilder
    {

        private int bitField0_;
        private List event_;

        private static DebugEvents.Builder create()
        {
            return new DebugEvents.Builder();
        }

        private void ensureEventIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                event_ = new ArrayList(event_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public DebugEvents.Builder addAllEvent(Iterable iterable)
        {
            ensureEventIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, event_);
            return this;
        }

        public DebugEvents.Builder addEvent(int i, EventInfo.Builder builder)
        {
            ensureEventIsMutable();
            event_.add(i, builder.build());
            return this;
        }

        public DebugEvents.Builder addEvent(int i, EventInfo eventinfo)
        {
            if (eventinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEventIsMutable();
                event_.add(i, eventinfo);
                return this;
            }
        }

        public DebugEvents.Builder addEvent(EventInfo.Builder builder)
        {
            ensureEventIsMutable();
            event_.add(builder.build());
            return this;
        }

        public DebugEvents.Builder addEvent(EventInfo eventinfo)
        {
            if (eventinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEventIsMutable();
                event_.add(eventinfo);
                return this;
            }
        }

        public DebugEvents build()
        {
            DebugEvents debugevents = buildPartial();
            if (!debugevents.isInitialized())
            {
                throw newUninitializedMessageException(debugevents);
            } else
            {
                return debugevents;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public DebugEvents buildPartial()
        {
            DebugEvents debugevents = new DebugEvents(this);
            int i = bitField0_;
            if ((bitField0_ & 1) == 1)
            {
                event_ = Collections.unmodifiableList(event_);
                bitField0_ = bitField0_ & -2;
            }
            debugevents.event_ = event_;
            return debugevents;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public DebugEvents.Builder clear()
        {
            super.clear();
            event_ = Collections.emptyList();
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

        public DebugEvents.Builder clearEvent()
        {
            event_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public DebugEvents.Builder clone()
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

        public DebugEvents getDefaultInstanceForType()
        {
            return DebugEvents.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
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
            return event_.size();
        }

        public List getEventList()
        {
            return Collections.unmodifiableList(event_);
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

        public DebugEvents.Builder mergeFrom(DebugEvents debugevents)
        {
            if (debugevents == DebugEvents.getDefaultInstance())
            {
                return this;
            }
            if (!debugevents.event_.isEmpty())
            {
                if (event_.isEmpty())
                {
                    event_ = debugevents.event_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensureEventIsMutable();
                    event_.addAll(debugevents.event_);
                }
            }
            setUnknownFields(getUnknownFields().concat(debugevents.unknownFields));
            return this;
        }

        public DebugEvents.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (DebugEvents)DebugEvents.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((DebugEvents) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (DebugEvents)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((DebugEvents) (codedinputstream1)));
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
            return mergeFrom((DebugEvents)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public DebugEvents.Builder removeEvent(int i)
        {
            ensureEventIsMutable();
            event_.remove(i);
            return this;
        }

        public DebugEvents.Builder setEvent(int i, EventInfo.Builder builder)
        {
            ensureEventIsMutable();
            event_.set(i, builder.build());
            return this;
        }

        public DebugEvents.Builder setEvent(int i, EventInfo eventinfo)
        {
            if (eventinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEventIsMutable();
                event_.set(i, eventinfo);
                return this;
            }
        }


        private DebugEvents.Builder()
        {
            event_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }
    }

    public static interface DebugEventsOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract EventInfo getEvent(int i);

        public abstract int getEventCount();

        public abstract List getEventList();
    }

    public static final class EventInfo extends GeneratedMessageLite
        implements EventInfoOrBuilder
    {

        public static final int CONTAINER_ID_FIELD_NUMBER = 3;
        public static final int CONTAINER_VERSION_FIELD_NUMBER = 2;
        public static final int DATA_LAYER_EVENT_RESULT_FIELD_NUMBER = 7;
        public static final int EVENT_TYPE_FIELD_NUMBER = 1;
        public static final int KEY_FIELD_NUMBER = 4;
        public static final int MACRO_RESULT_FIELD_NUMBER = 6;
        public static Parser PARSER = new AbstractParser() {

            public EventInfo parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new EventInfo(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        private static final EventInfo defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private Object containerId_;
        private Object containerVersion_;
        private DataLayerEventEvaluationInfo dataLayerEventResult_;
        private EventType eventType_;
        private Object key_;
        private MacroEvaluationInfo macroResult_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public static EventInfo getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            eventType_ = EventType.DATA_LAYER_EVENT;
            containerVersion_ = "";
            containerId_ = "";
            key_ = "";
            macroResult_ = MacroEvaluationInfo.getDefaultInstance();
            dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(EventInfo eventinfo)
        {
            return newBuilder().mergeFrom(eventinfo);
        }

        public static EventInfo parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (EventInfo)PARSER.parseDelimitedFrom(inputstream);
        }

        public static EventInfo parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (EventInfo)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static EventInfo parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (EventInfo)PARSER.parseFrom(bytestring);
        }

        public static EventInfo parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (EventInfo)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static EventInfo parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (EventInfo)PARSER.parseFrom(codedinputstream);
        }

        public static EventInfo parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (EventInfo)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static EventInfo parseFrom(InputStream inputstream)
            throws IOException
        {
            return (EventInfo)PARSER.parseFrom(inputstream);
        }

        public static EventInfo parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (EventInfo)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static EventInfo parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (EventInfo)PARSER.parseFrom(abyte0);
        }

        public static EventInfo parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (EventInfo)PARSER.parseFrom(abyte0, extensionregistrylite);
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

        public String getContainerVersion()
        {
            Object obj = containerVersion_;
            if (obj instanceof String)
            {
                return (String)obj;
            }
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (((ByteString) (obj)).isValidUtf8())
            {
                containerVersion_ = s;
            }
            return s;
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

        public DataLayerEventEvaluationInfo getDataLayerEventResult()
        {
            return dataLayerEventResult_;
        }

        public EventInfo getDefaultInstanceForType()
        {
            return defaultInstance;
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
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (((ByteString) (obj)).isValidUtf8())
            {
                key_ = s;
            }
            return s;
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

        public MacroEvaluationInfo getMacroResult()
        {
            return macroResult_;
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
                j = 0 + CodedOutputStream.computeEnumSize(1, eventType_.getNumber());
            }
            i = j;
            if ((bitField0_ & 2) == 2)
            {
                i = j + CodedOutputStream.computeBytesSize(2, getContainerVersionBytes());
            }
            j = i;
            if ((bitField0_ & 4) == 4)
            {
                j = i + CodedOutputStream.computeBytesSize(3, getContainerIdBytes());
            }
            i = j;
            if ((bitField0_ & 8) == 8)
            {
                i = j + CodedOutputStream.computeBytesSize(4, getKeyBytes());
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
            memoizedSerializedSize = i;
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
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Debug$EventInfo.hashCode() + 779;
            int i = j;
            if (hasEventType())
            {
                i = (j * 37 + 1) * 53 + Internal.hashEnum(getEventType());
            }
            j = i;
            if (hasContainerVersion())
            {
                j = (i * 37 + 2) * 53 + getContainerVersion().hashCode();
            }
            i = j;
            if (hasContainerId())
            {
                i = (j * 37 + 3) * 53 + getContainerId().hashCode();
            }
            j = i;
            if (hasKey())
            {
                j = (i * 37 + 4) * 53 + getKey().hashCode();
            }
            i = j;
            if (hasMacroResult())
            {
                i = (j * 37 + 6) * 53 + getMacroResult().hashCode();
            }
            j = i;
            if (hasDataLayerEventResult())
            {
                j = (i * 37 + 7) * 53 + getDataLayerEventResult().hashCode();
            }
            i = j * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$EventInfo");
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
            if (hasMacroResult() && !getMacroResult().isInitialized())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (hasDataLayerEventResult() && !getDataLayerEventResult().isInitialized())
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
                codedoutputstream.writeEnum(1, eventType_.getNumber());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBytes(2, getContainerVersionBytes());
            }
            if ((bitField0_ & 4) == 4)
            {
                codedoutputstream.writeBytes(3, getContainerIdBytes());
            }
            if ((bitField0_ & 8) == 8)
            {
                codedoutputstream.writeBytes(4, getKeyBytes());
            }
            if ((bitField0_ & 0x10) == 16)
            {
                codedoutputstream.writeMessage(6, macroResult_);
            }
            if ((bitField0_ & 0x20) == 32)
            {
                codedoutputstream.writeMessage(7, dataLayerEventResult_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new EventInfo(true);
            defaultInstance.initFields();
        }



/*
        static Object access$1002(EventInfo eventinfo, Object obj)
        {
            eventinfo.containerId_ = obj;
            return obj;
        }

*/



/*
        static Object access$1102(EventInfo eventinfo, Object obj)
        {
            eventinfo.key_ = obj;
            return obj;
        }

*/


/*
        static MacroEvaluationInfo access$1202(EventInfo eventinfo, MacroEvaluationInfo macroevaluationinfo)
        {
            eventinfo.macroResult_ = macroevaluationinfo;
            return macroevaluationinfo;
        }

*/


/*
        static DataLayerEventEvaluationInfo access$1302(EventInfo eventinfo, DataLayerEventEvaluationInfo datalayereventevaluationinfo)
        {
            eventinfo.dataLayerEventResult_ = datalayereventevaluationinfo;
            return datalayereventevaluationinfo;
        }

*/


/*
        static int access$1402(EventInfo eventinfo, int i)
        {
            eventinfo.bitField0_ = i;
            return i;
        }

*/



/*
        static EventType access$802(EventInfo eventinfo, EventType eventtype)
        {
            eventinfo.eventType_ = eventtype;
            return eventtype;
        }

*/



/*
        static Object access$902(EventInfo eventinfo, Object obj)
        {
            eventinfo.containerVersion_ = obj;
            return obj;
        }

*/

        private EventInfo(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
_L22:
            if (flag) goto _L2; else goto _L1
_L1:
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 7: default 510
        //                       0: 513
        //                       8: 131
        //                       18: 227
        //                       26: 250
        //                       34: 273
        //                       50: 297
        //                       58: 369;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            Object obj;
            int j;
            j = codedinputstream.readEnum();
            obj = EventType.valueOf(j);
            if (obj != null) goto _L12; else goto _L11
_L11:
            codedoutputstream.writeRawVarint32(i);
            codedoutputstream.writeRawVarint32(j);
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L20:
            makeExtensionsImmutable();
            throw codedinputstream;
_L12:
            bitField0_ = bitField0_ | 1;
            eventType_ = ((EventType) (obj));
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L6:
            obj = codedinputstream.readBytes();
            bitField0_ = bitField0_ | 2;
            containerVersion_ = obj;
            continue; /* Loop/switch isn't completed */
_L7:
            obj = codedinputstream.readBytes();
            bitField0_ = bitField0_ | 4;
            containerId_ = obj;
            continue; /* Loop/switch isn't completed */
_L8:
            obj = codedinputstream.readBytes();
            bitField0_ = bitField0_ | 8;
            key_ = obj;
            continue; /* Loop/switch isn't completed */
_L9:
            obj = null;
            if ((bitField0_ & 0x10) == 16)
            {
                obj = macroResult_.toBuilder();
            }
            macroResult_ = (MacroEvaluationInfo)codedinputstream.readMessage(MacroEvaluationInfo.PARSER, extensionregistrylite);
            if (obj == null) goto _L14; else goto _L13
_L13:
            ((MacroEvaluationInfo.Builder) (obj)).mergeFrom(macroResult_);
            macroResult_ = ((MacroEvaluationInfo.Builder) (obj)).buildPartial();
_L14:
            bitField0_ = bitField0_ | 0x10;
            continue; /* Loop/switch isn't completed */
_L10:
            obj = null;
            if ((bitField0_ & 0x20) == 32)
            {
                obj = dataLayerEventResult_.toBuilder();
            }
            dataLayerEventResult_ = (DataLayerEventEvaluationInfo)codedinputstream.readMessage(DataLayerEventEvaluationInfo.PARSER, extensionregistrylite);
            if (obj == null) goto _L16; else goto _L15
_L15:
            ((DataLayerEventEvaluationInfo.Builder) (obj)).mergeFrom(dataLayerEventResult_);
            dataLayerEventResult_ = ((DataLayerEventEvaluationInfo.Builder) (obj)).buildPartial();
_L16:
            bitField0_ = bitField0_ | 0x20;
            continue; /* Loop/switch isn't completed */
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L18:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L18; else goto _L17
_L17:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L20; else goto _L19
_L19:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L22; else goto _L21
_L21:
        }


        private EventInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private EventInfo(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class EventInfo.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements EventInfoOrBuilder
    {

        private int bitField0_;
        private Object containerId_;
        private Object containerVersion_;
        private DataLayerEventEvaluationInfo dataLayerEventResult_;
        private EventInfo.EventType eventType_;
        private Object key_;
        private MacroEvaluationInfo macroResult_;

        private static EventInfo.Builder create()
        {
            return new EventInfo.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public EventInfo build()
        {
            EventInfo eventinfo = buildPartial();
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

        public EventInfo buildPartial()
        {
            EventInfo eventinfo = new EventInfo(this);
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

        public EventInfo.Builder clear()
        {
            super.clear();
            eventType_ = EventInfo.EventType.DATA_LAYER_EVENT;
            bitField0_ = bitField0_ & -2;
            containerVersion_ = "";
            bitField0_ = bitField0_ & -3;
            containerId_ = "";
            bitField0_ = bitField0_ & -5;
            key_ = "";
            bitField0_ = bitField0_ & -9;
            macroResult_ = MacroEvaluationInfo.getDefaultInstance();
            bitField0_ = bitField0_ & 0xffffffef;
            dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
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

        public EventInfo.Builder clearContainerId()
        {
            bitField0_ = bitField0_ & -5;
            containerId_ = EventInfo.getDefaultInstance().getContainerId();
            return this;
        }

        public EventInfo.Builder clearContainerVersion()
        {
            bitField0_ = bitField0_ & -3;
            containerVersion_ = EventInfo.getDefaultInstance().getContainerVersion();
            return this;
        }

        public EventInfo.Builder clearDataLayerEventResult()
        {
            dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
            bitField0_ = bitField0_ & 0xffffffdf;
            return this;
        }

        public EventInfo.Builder clearEventType()
        {
            bitField0_ = bitField0_ & -2;
            eventType_ = EventInfo.EventType.DATA_LAYER_EVENT;
            return this;
        }

        public EventInfo.Builder clearKey()
        {
            bitField0_ = bitField0_ & -9;
            key_ = EventInfo.getDefaultInstance().getKey();
            return this;
        }

        public EventInfo.Builder clearMacroResult()
        {
            macroResult_ = MacroEvaluationInfo.getDefaultInstance();
            bitField0_ = bitField0_ & 0xffffffef;
            return this;
        }

        public EventInfo.Builder clone()
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

        public DataLayerEventEvaluationInfo getDataLayerEventResult()
        {
            return dataLayerEventResult_;
        }

        public EventInfo getDefaultInstanceForType()
        {
            return EventInfo.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public EventInfo.EventType getEventType()
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

        public MacroEvaluationInfo getMacroResult()
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

        public EventInfo.Builder mergeDataLayerEventResult(DataLayerEventEvaluationInfo datalayereventevaluationinfo)
        {
            if ((bitField0_ & 0x20) == 32 && dataLayerEventResult_ != DataLayerEventEvaluationInfo.getDefaultInstance())
            {
                dataLayerEventResult_ = DataLayerEventEvaluationInfo.newBuilder(dataLayerEventResult_).mergeFrom(datalayereventevaluationinfo).buildPartial();
            } else
            {
                dataLayerEventResult_ = datalayereventevaluationinfo;
            }
            bitField0_ = bitField0_ | 0x20;
            return this;
        }

        public EventInfo.Builder mergeFrom(EventInfo eventinfo)
        {
            if (eventinfo == EventInfo.getDefaultInstance())
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

        public EventInfo.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (EventInfo)EventInfo.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((EventInfo) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (EventInfo)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((EventInfo) (codedinputstream1)));
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
            return mergeFrom((EventInfo)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public EventInfo.Builder mergeMacroResult(MacroEvaluationInfo macroevaluationinfo)
        {
            if ((bitField0_ & 0x10) == 16 && macroResult_ != MacroEvaluationInfo.getDefaultInstance())
            {
                macroResult_ = MacroEvaluationInfo.newBuilder(macroResult_).mergeFrom(macroevaluationinfo).buildPartial();
            } else
            {
                macroResult_ = macroevaluationinfo;
            }
            bitField0_ = bitField0_ | 0x10;
            return this;
        }

        public EventInfo.Builder setContainerId(String s)
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

        public EventInfo.Builder setContainerIdBytes(ByteString bytestring)
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

        public EventInfo.Builder setContainerVersion(String s)
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

        public EventInfo.Builder setContainerVersionBytes(ByteString bytestring)
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

        public EventInfo.Builder setDataLayerEventResult(DataLayerEventEvaluationInfo.Builder builder)
        {
            dataLayerEventResult_ = builder.build();
            bitField0_ = bitField0_ | 0x20;
            return this;
        }

        public EventInfo.Builder setDataLayerEventResult(DataLayerEventEvaluationInfo datalayereventevaluationinfo)
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

        public EventInfo.Builder setEventType(EventInfo.EventType eventtype)
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

        public EventInfo.Builder setKey(String s)
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

        public EventInfo.Builder setKeyBytes(ByteString bytestring)
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

        public EventInfo.Builder setMacroResult(MacroEvaluationInfo.Builder builder)
        {
            macroResult_ = builder.build();
            bitField0_ = bitField0_ | 0x10;
            return this;
        }

        public EventInfo.Builder setMacroResult(MacroEvaluationInfo macroevaluationinfo)
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


        private EventInfo.Builder()
        {
            eventType_ = EventInfo.EventType.DATA_LAYER_EVENT;
            containerVersion_ = "";
            containerId_ = "";
            key_ = "";
            macroResult_ = MacroEvaluationInfo.getDefaultInstance();
            dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
            maybeForceBuilderInitialization();
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
            return (EventInfo.EventType)Enum.valueOf(com/google/analytics/containertag/proto/Debug$EventInfo$EventType, s);
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

    public static interface EventInfoOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract String getContainerId();

        public abstract ByteString getContainerIdBytes();

        public abstract String getContainerVersion();

        public abstract ByteString getContainerVersionBytes();

        public abstract DataLayerEventEvaluationInfo getDataLayerEventResult();

        public abstract EventInfo.EventType getEventType();

        public abstract String getKey();

        public abstract ByteString getKeyBytes();

        public abstract MacroEvaluationInfo getMacroResult();

        public abstract boolean hasContainerId();

        public abstract boolean hasContainerVersion();

        public abstract boolean hasDataLayerEventResult();

        public abstract boolean hasEventType();

        public abstract boolean hasKey();

        public abstract boolean hasMacroResult();
    }

    public static final class MacroEvaluationInfo extends GeneratedMessageLite
        implements MacroEvaluationInfoOrBuilder
    {

        public static final int MACRO_FIELD_NUMBER = 0x2d4c0bd;
        public static Parser PARSER = new AbstractParser() {

            public MacroEvaluationInfo parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new MacroEvaluationInfo(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int RESULT_FIELD_NUMBER = 3;
        public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
        private static final MacroEvaluationInfo defaultInstance;
        public static final com.google.tagmanager.protobuf.GeneratedMessageLite.GeneratedExtension macro;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private ResolvedFunctionCall result_;
        private RuleEvaluationStepInfo rulesEvaluation_;
        private final ByteString unknownFields;

        public static MacroEvaluationInfo getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            result_ = ResolvedFunctionCall.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(MacroEvaluationInfo macroevaluationinfo)
        {
            return newBuilder().mergeFrom(macroevaluationinfo);
        }

        public static MacroEvaluationInfo parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (MacroEvaluationInfo)PARSER.parseDelimitedFrom(inputstream);
        }

        public static MacroEvaluationInfo parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (MacroEvaluationInfo)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static MacroEvaluationInfo parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (MacroEvaluationInfo)PARSER.parseFrom(bytestring);
        }

        public static MacroEvaluationInfo parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (MacroEvaluationInfo)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static MacroEvaluationInfo parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (MacroEvaluationInfo)PARSER.parseFrom(codedinputstream);
        }

        public static MacroEvaluationInfo parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (MacroEvaluationInfo)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static MacroEvaluationInfo parseFrom(InputStream inputstream)
            throws IOException
        {
            return (MacroEvaluationInfo)PARSER.parseFrom(inputstream);
        }

        public static MacroEvaluationInfo parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (MacroEvaluationInfo)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static MacroEvaluationInfo parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (MacroEvaluationInfo)PARSER.parseFrom(abyte0);
        }

        public static MacroEvaluationInfo parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (MacroEvaluationInfo)PARSER.parseFrom(abyte0, extensionregistrylite);
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

        public MacroEvaluationInfo getDefaultInstanceForType()
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
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
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
            memoizedSerializedSize = i;
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
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Debug$MacroEvaluationInfo.hashCode() + 779;
            int i = j;
            if (hasRulesEvaluation())
            {
                i = (j * 37 + 1) * 53 + getRulesEvaluation().hashCode();
            }
            j = i;
            if (hasResult())
            {
                j = (i * 37 + 3) * 53 + getResult().hashCode();
            }
            i = j * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$MacroEvaluationInfo");
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
            if (hasRulesEvaluation() && !getRulesEvaluation().isInitialized())
            {
                memoizedIsInitialized = 0;
                return false;
            }
            if (hasResult() && !getResult().isInitialized())
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
                codedoutputstream.writeMessage(1, rulesEvaluation_);
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeMessage(3, result_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new MacroEvaluationInfo(true);
            defaultInstance.initFields();
            macro = GeneratedMessageLite.newSingularGeneratedExtension(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, 0x2d4c0bd, com.google.tagmanager.protobuf.WireFormat.FieldType.MESSAGE, com/google/analytics/containertag/proto/Debug$MacroEvaluationInfo);
        }


/*
        static RuleEvaluationStepInfo access$5202(MacroEvaluationInfo macroevaluationinfo, RuleEvaluationStepInfo ruleevaluationstepinfo)
        {
            macroevaluationinfo.rulesEvaluation_ = ruleevaluationstepinfo;
            return ruleevaluationstepinfo;
        }

*/


/*
        static ResolvedFunctionCall access$5302(MacroEvaluationInfo macroevaluationinfo, ResolvedFunctionCall resolvedfunctioncall)
        {
            macroevaluationinfo.result_ = resolvedfunctioncall;
            return resolvedfunctioncall;
        }

*/


/*
        static int access$5402(MacroEvaluationInfo macroevaluationinfo, int i)
        {
            macroevaluationinfo.bitField0_ = i;
            return i;
        }

*/


        private MacroEvaluationInfo(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
_L16:
            if (flag) goto _L2; else goto _L1
_L1:
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 3: default 351
        //                       0: 354
        //                       10: 99
        //                       26: 196;
               goto _L3 _L4 _L5 _L6
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
                obj = rulesEvaluation_.toBuilder();
            }
            rulesEvaluation_ = (RuleEvaluationStepInfo)codedinputstream.readMessage(RuleEvaluationStepInfo.PARSER, extensionregistrylite);
            if (obj == null) goto _L8; else goto _L7
_L7:
            ((RuleEvaluationStepInfo.Builder) (obj)).mergeFrom(rulesEvaluation_);
            rulesEvaluation_ = ((RuleEvaluationStepInfo.Builder) (obj)).buildPartial();
_L8:
            bitField0_ = bitField0_ | 1;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L14:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            obj = null;
            if ((bitField0_ & 2) == 2)
            {
                obj = result_.toBuilder();
            }
            result_ = (ResolvedFunctionCall)codedinputstream.readMessage(ResolvedFunctionCall.PARSER, extensionregistrylite);
            if (obj == null) goto _L10; else goto _L9
_L9:
            ((ResolvedFunctionCall.Builder) (obj)).mergeFrom(result_);
            result_ = ((ResolvedFunctionCall.Builder) (obj)).buildPartial();
_L10:
            bitField0_ = bitField0_ | 2;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L12:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L12; else goto _L11
_L11:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L14; else goto _L13
_L13:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L16; else goto _L15
_L15:
        }


        private MacroEvaluationInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private MacroEvaluationInfo(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class MacroEvaluationInfo.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements MacroEvaluationInfoOrBuilder
    {

        private int bitField0_;
        private ResolvedFunctionCall result_;
        private RuleEvaluationStepInfo rulesEvaluation_;

        private static MacroEvaluationInfo.Builder create()
        {
            return new MacroEvaluationInfo.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public MacroEvaluationInfo build()
        {
            MacroEvaluationInfo macroevaluationinfo = buildPartial();
            if (!macroevaluationinfo.isInitialized())
            {
                throw newUninitializedMessageException(macroevaluationinfo);
            } else
            {
                return macroevaluationinfo;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public MacroEvaluationInfo buildPartial()
        {
            MacroEvaluationInfo macroevaluationinfo = new MacroEvaluationInfo(this);
            int k = bitField0_;
            int i = 0;
            if ((k & 1) == 1)
            {
                i = false | true;
            }
            macroevaluationinfo.rulesEvaluation_ = rulesEvaluation_;
            int j = i;
            if ((k & 2) == 2)
            {
                j = i | 2;
            }
            macroevaluationinfo.result_ = result_;
            macroevaluationinfo.bitField0_ = j;
            return macroevaluationinfo;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public MacroEvaluationInfo.Builder clear()
        {
            super.clear();
            rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            bitField0_ = bitField0_ & -2;
            result_ = ResolvedFunctionCall.getDefaultInstance();
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

        public MacroEvaluationInfo.Builder clearResult()
        {
            result_ = ResolvedFunctionCall.getDefaultInstance();
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public MacroEvaluationInfo.Builder clearRulesEvaluation()
        {
            rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public MacroEvaluationInfo.Builder clone()
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

        public MacroEvaluationInfo getDefaultInstanceForType()
        {
            return MacroEvaluationInfo.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public ResolvedFunctionCall getResult()
        {
            return result_;
        }

        public RuleEvaluationStepInfo getRulesEvaluation()
        {
            return rulesEvaluation_;
        }

        public boolean hasResult()
        {
            return (bitField0_ & 2) == 2;
        }

        public boolean hasRulesEvaluation()
        {
            return (bitField0_ & 1) == 1;
        }

        public final boolean isInitialized()
        {
            while (hasRulesEvaluation() && !getRulesEvaluation().isInitialized() || hasResult() && !getResult().isInitialized()) 
            {
                return false;
            }
            return true;
        }

        public MacroEvaluationInfo.Builder mergeFrom(MacroEvaluationInfo macroevaluationinfo)
        {
            if (macroevaluationinfo == MacroEvaluationInfo.getDefaultInstance())
            {
                return this;
            }
            if (macroevaluationinfo.hasRulesEvaluation())
            {
                mergeRulesEvaluation(macroevaluationinfo.getRulesEvaluation());
            }
            if (macroevaluationinfo.hasResult())
            {
                mergeResult(macroevaluationinfo.getResult());
            }
            setUnknownFields(getUnknownFields().concat(macroevaluationinfo.unknownFields));
            return this;
        }

        public MacroEvaluationInfo.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (MacroEvaluationInfo)MacroEvaluationInfo.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((MacroEvaluationInfo) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (MacroEvaluationInfo)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((MacroEvaluationInfo) (codedinputstream1)));
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
            return mergeFrom((MacroEvaluationInfo)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public MacroEvaluationInfo.Builder mergeResult(ResolvedFunctionCall resolvedfunctioncall)
        {
            if ((bitField0_ & 2) == 2 && result_ != ResolvedFunctionCall.getDefaultInstance())
            {
                result_ = ResolvedFunctionCall.newBuilder(result_).mergeFrom(resolvedfunctioncall).buildPartial();
            } else
            {
                result_ = resolvedfunctioncall;
            }
            bitField0_ = bitField0_ | 2;
            return this;
        }

        public MacroEvaluationInfo.Builder mergeRulesEvaluation(RuleEvaluationStepInfo ruleevaluationstepinfo)
        {
            if ((bitField0_ & 1) == 1 && rulesEvaluation_ != RuleEvaluationStepInfo.getDefaultInstance())
            {
                rulesEvaluation_ = RuleEvaluationStepInfo.newBuilder(rulesEvaluation_).mergeFrom(ruleevaluationstepinfo).buildPartial();
            } else
            {
                rulesEvaluation_ = ruleevaluationstepinfo;
            }
            bitField0_ = bitField0_ | 1;
            return this;
        }

        public MacroEvaluationInfo.Builder setResult(ResolvedFunctionCall.Builder builder)
        {
            result_ = builder.build();
            bitField0_ = bitField0_ | 2;
            return this;
        }

        public MacroEvaluationInfo.Builder setResult(ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                result_ = resolvedfunctioncall;
                bitField0_ = bitField0_ | 2;
                return this;
            }
        }

        public MacroEvaluationInfo.Builder setRulesEvaluation(RuleEvaluationStepInfo.Builder builder)
        {
            rulesEvaluation_ = builder.build();
            bitField0_ = bitField0_ | 1;
            return this;
        }

        public MacroEvaluationInfo.Builder setRulesEvaluation(RuleEvaluationStepInfo ruleevaluationstepinfo)
        {
            if (ruleevaluationstepinfo == null)
            {
                throw new NullPointerException();
            } else
            {
                rulesEvaluation_ = ruleevaluationstepinfo;
                bitField0_ = bitField0_ | 1;
                return this;
            }
        }


        private MacroEvaluationInfo.Builder()
        {
            rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            result_ = ResolvedFunctionCall.getDefaultInstance();
            maybeForceBuilderInitialization();
        }
    }

    public static interface MacroEvaluationInfoOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract ResolvedFunctionCall getResult();

        public abstract RuleEvaluationStepInfo getRulesEvaluation();

        public abstract boolean hasResult();

        public abstract boolean hasRulesEvaluation();
    }

    public static final class ResolvedFunctionCall extends GeneratedMessageLite
        implements ResolvedFunctionCallOrBuilder
    {

        public static final int ASSOCIATED_RULE_NAME_FIELD_NUMBER = 3;
        public static Parser PARSER = new AbstractParser() {

            public ResolvedFunctionCall parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new ResolvedFunctionCall(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int PROPERTIES_FIELD_NUMBER = 1;
        public static final int RESULT_FIELD_NUMBER = 2;
        private static final ResolvedFunctionCall defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private Object associatedRuleName_;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List properties_;
        private com.google.analytics.midtier.proto.containertag.TypeSystem.Value result_;
        private final ByteString unknownFields;

        public static ResolvedFunctionCall getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            properties_ = Collections.emptyList();
            result_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance();
            associatedRuleName_ = "";
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(ResolvedFunctionCall resolvedfunctioncall)
        {
            return newBuilder().mergeFrom(resolvedfunctioncall);
        }

        public static ResolvedFunctionCall parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (ResolvedFunctionCall)PARSER.parseDelimitedFrom(inputstream);
        }

        public static ResolvedFunctionCall parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ResolvedFunctionCall)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static ResolvedFunctionCall parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (ResolvedFunctionCall)PARSER.parseFrom(bytestring);
        }

        public static ResolvedFunctionCall parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (ResolvedFunctionCall)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static ResolvedFunctionCall parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (ResolvedFunctionCall)PARSER.parseFrom(codedinputstream);
        }

        public static ResolvedFunctionCall parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ResolvedFunctionCall)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static ResolvedFunctionCall parseFrom(InputStream inputstream)
            throws IOException
        {
            return (ResolvedFunctionCall)PARSER.parseFrom(inputstream);
        }

        public static ResolvedFunctionCall parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ResolvedFunctionCall)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static ResolvedFunctionCall parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (ResolvedFunctionCall)PARSER.parseFrom(abyte0);
        }

        public static ResolvedFunctionCall parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (ResolvedFunctionCall)PARSER.parseFrom(abyte0, extensionregistrylite);
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
            obj = (ByteString)obj;
            String s = ((ByteString) (obj)).toStringUtf8();
            if (((ByteString) (obj)).isValidUtf8())
            {
                associatedRuleName_ = s;
            }
            return s;
        }

        public ByteString getAssociatedRuleNameBytes()
        {
            Object obj = associatedRuleName_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                associatedRuleName_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public ResolvedFunctionCall getDefaultInstanceForType()
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

        public ResolvedProperty getProperties(int i)
        {
            return (ResolvedProperty)properties_.get(i);
        }

        public int getPropertiesCount()
        {
            return properties_.size();
        }

        public List getPropertiesList()
        {
            return properties_;
        }

        public ResolvedPropertyOrBuilder getPropertiesOrBuilder(int i)
        {
            return (ResolvedPropertyOrBuilder)properties_.get(i);
        }

        public List getPropertiesOrBuilderList()
        {
            return properties_;
        }

        public com.google.analytics.midtier.proto.containertag.TypeSystem.Value getResult()
        {
            return result_;
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            for (int j = 0; j < properties_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(1, (MessageLite)properties_.get(j));
            }

            int k = i;
            if ((bitField0_ & 1) == 1)
            {
                k = i + CodedOutputStream.computeMessageSize(2, result_);
            }
            i = k;
            if ((bitField0_ & 2) == 2)
            {
                i = k + CodedOutputStream.computeBytesSize(3, getAssociatedRuleNameBytes());
            }
            i += unknownFields.size();
            memoizedSerializedSize = i;
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
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Debug$ResolvedFunctionCall.hashCode() + 779;
            int i = j;
            if (getPropertiesCount() > 0)
            {
                i = (j * 37 + 1) * 53 + getPropertiesList().hashCode();
            }
            j = i;
            if (hasResult())
            {
                j = (i * 37 + 2) * 53 + getResult().hashCode();
            }
            i = j;
            if (hasAssociatedRuleName())
            {
                i = (j * 37 + 3) * 53 + getAssociatedRuleName().hashCode();
            }
            i = i * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$ResolvedFunctionCall");
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
            for (int i = 0; i < getPropertiesCount(); i++)
            {
                if (!getProperties(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (hasResult() && !getResult().isInitialized())
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
            for (int i = 0; i < properties_.size(); i++)
            {
                codedoutputstream.writeMessage(1, (MessageLite)properties_.get(i));
            }

            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeMessage(2, result_);
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeBytes(3, getAssociatedRuleNameBytes());
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new ResolvedFunctionCall(true);
            defaultInstance.initFields();
        }



/*
        static List access$3102(ResolvedFunctionCall resolvedfunctioncall, List list)
        {
            resolvedfunctioncall.properties_ = list;
            return list;
        }

*/


/*
        static com.google.analytics.midtier.proto.containertag.TypeSystem.Value access$3202(ResolvedFunctionCall resolvedfunctioncall, com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            resolvedfunctioncall.result_ = value;
            return value;
        }

*/



/*
        static Object access$3302(ResolvedFunctionCall resolvedfunctioncall, Object obj)
        {
            resolvedfunctioncall.associatedRuleName_ = obj;
            return obj;
        }

*/


/*
        static int access$3402(ResolvedFunctionCall resolvedfunctioncall, int i)
        {
            resolvedfunctioncall.bitField0_ = i;
            return i;
        }

*/


        private ResolvedFunctionCall(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            com.google.tagmanager.protobuf.ByteString.Output output;
            CodedOutputStream codedoutputstream;
            boolean flag;
            boolean flag2;
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            initFields();
            flag = false;
            output = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(output);
            flag2 = false;
_L19:
            if (flag2) goto _L2; else goto _L1
_L1:
            boolean flag1;
            boolean flag3;
            boolean flag4;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 4: default 573
        //                       0: 576
        //                       10: 135
        //                       18: 264
        //                       26: 426;
               goto _L3 _L4 _L5 _L6 _L7
_L3:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag2 = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            i = ((flag) ? 1 : 0);
            if ((flag & true)) goto _L9; else goto _L8
_L8:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            properties_ = new ArrayList();
            i = flag | true;
_L9:
            flag3 = i;
            flag1 = i;
            flag4 = i;
            properties_.add(codedinputstream.readMessage(ResolvedProperty.PARSER, extensionregistrylite));
            flag = i;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            flag1 = flag3;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            if ((flag1 & true))
            {
                properties_ = Collections.unmodifiableList(properties_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L17:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            Object obj;
            obj = null;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            if ((bitField0_ & 1) != 1) goto _L11; else goto _L10
_L10:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            obj = result_.toBuilder();
_L11:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            result_ = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)codedinputstream.readMessage(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.PARSER, extensionregistrylite);
            if (obj == null) goto _L13; else goto _L12
_L12:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            ((com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder) (obj)).mergeFrom(result_);
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            result_ = ((com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder) (obj)).buildPartial();
_L13:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            bitField0_ = bitField0_ | 1;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            flag1 = flag4;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L7:
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            obj = codedinputstream.readBytes();
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            bitField0_ = bitField0_ | 2;
            flag3 = flag;
            flag1 = flag;
            flag4 = flag;
            associatedRuleName_ = obj;
            continue; /* Loop/switch isn't completed */
_L2:
            if ((flag & true))
            {
                properties_ = Collections.unmodifiableList(properties_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L15:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L15; else goto _L14
_L14:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L17; else goto _L16
_L16:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag2 = true;
            if (true) goto _L19; else goto _L18
_L18:
        }


        private ResolvedFunctionCall(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private ResolvedFunctionCall(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class ResolvedFunctionCall.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements ResolvedFunctionCallOrBuilder
    {

        private Object associatedRuleName_;
        private int bitField0_;
        private List properties_;
        private com.google.analytics.midtier.proto.containertag.TypeSystem.Value result_;

        private static ResolvedFunctionCall.Builder create()
        {
            return new ResolvedFunctionCall.Builder();
        }

        private void ensurePropertiesIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                properties_ = new ArrayList(properties_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public ResolvedFunctionCall.Builder addAllProperties(Iterable iterable)
        {
            ensurePropertiesIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, properties_);
            return this;
        }

        public ResolvedFunctionCall.Builder addProperties(int i, ResolvedProperty.Builder builder)
        {
            ensurePropertiesIsMutable();
            properties_.add(i, builder.build());
            return this;
        }

        public ResolvedFunctionCall.Builder addProperties(int i, ResolvedProperty resolvedproperty)
        {
            if (resolvedproperty == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePropertiesIsMutable();
                properties_.add(i, resolvedproperty);
                return this;
            }
        }

        public ResolvedFunctionCall.Builder addProperties(ResolvedProperty.Builder builder)
        {
            ensurePropertiesIsMutable();
            properties_.add(builder.build());
            return this;
        }

        public ResolvedFunctionCall.Builder addProperties(ResolvedProperty resolvedproperty)
        {
            if (resolvedproperty == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePropertiesIsMutable();
                properties_.add(resolvedproperty);
                return this;
            }
        }

        public ResolvedFunctionCall build()
        {
            ResolvedFunctionCall resolvedfunctioncall = buildPartial();
            if (!resolvedfunctioncall.isInitialized())
            {
                throw newUninitializedMessageException(resolvedfunctioncall);
            } else
            {
                return resolvedfunctioncall;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public ResolvedFunctionCall buildPartial()
        {
            ResolvedFunctionCall resolvedfunctioncall = new ResolvedFunctionCall(this);
            int k = bitField0_;
            int i = 0;
            if ((bitField0_ & 1) == 1)
            {
                properties_ = Collections.unmodifiableList(properties_);
                bitField0_ = bitField0_ & -2;
            }
            resolvedfunctioncall.properties_ = properties_;
            if ((k & 2) == 2)
            {
                i = false | true;
            }
            resolvedfunctioncall.result_ = result_;
            int j = i;
            if ((k & 4) == 4)
            {
                j = i | 2;
            }
            resolvedfunctioncall.associatedRuleName_ = associatedRuleName_;
            resolvedfunctioncall.bitField0_ = j;
            return resolvedfunctioncall;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public ResolvedFunctionCall.Builder clear()
        {
            super.clear();
            properties_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            result_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance();
            bitField0_ = bitField0_ & -3;
            associatedRuleName_ = "";
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

        public ResolvedFunctionCall.Builder clearAssociatedRuleName()
        {
            bitField0_ = bitField0_ & -5;
            associatedRuleName_ = ResolvedFunctionCall.getDefaultInstance().getAssociatedRuleName();
            return this;
        }

        public ResolvedFunctionCall.Builder clearProperties()
        {
            properties_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public ResolvedFunctionCall.Builder clearResult()
        {
            result_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance();
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public ResolvedFunctionCall.Builder clone()
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

        public String getAssociatedRuleName()
        {
            Object obj = associatedRuleName_;
            if (!(obj instanceof String))
            {
                obj = (ByteString)obj;
                String s = ((ByteString) (obj)).toStringUtf8();
                if (((ByteString) (obj)).isValidUtf8())
                {
                    associatedRuleName_ = s;
                }
                return s;
            } else
            {
                return (String)obj;
            }
        }

        public ByteString getAssociatedRuleNameBytes()
        {
            Object obj = associatedRuleName_;
            if (obj instanceof String)
            {
                obj = ByteString.copyFromUtf8((String)obj);
                associatedRuleName_ = obj;
                return ((ByteString) (obj));
            } else
            {
                return (ByteString)obj;
            }
        }

        public ResolvedFunctionCall getDefaultInstanceForType()
        {
            return ResolvedFunctionCall.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public ResolvedProperty getProperties(int i)
        {
            return (ResolvedProperty)properties_.get(i);
        }

        public int getPropertiesCount()
        {
            return properties_.size();
        }

        public List getPropertiesList()
        {
            return Collections.unmodifiableList(properties_);
        }

        public com.google.analytics.midtier.proto.containertag.TypeSystem.Value getResult()
        {
            return result_;
        }

        public boolean hasAssociatedRuleName()
        {
            return (bitField0_ & 4) == 4;
        }

        public boolean hasResult()
        {
            return (bitField0_ & 2) == 2;
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

        public ResolvedFunctionCall.Builder mergeFrom(ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == ResolvedFunctionCall.getDefaultInstance())
            {
                return this;
            }
            if (!resolvedfunctioncall.properties_.isEmpty())
            {
                if (properties_.isEmpty())
                {
                    properties_ = resolvedfunctioncall.properties_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensurePropertiesIsMutable();
                    properties_.addAll(resolvedfunctioncall.properties_);
                }
            }
            if (resolvedfunctioncall.hasResult())
            {
                mergeResult(resolvedfunctioncall.getResult());
            }
            if (resolvedfunctioncall.hasAssociatedRuleName())
            {
                bitField0_ = bitField0_ | 4;
                associatedRuleName_ = resolvedfunctioncall.associatedRuleName_;
            }
            setUnknownFields(getUnknownFields().concat(resolvedfunctioncall.unknownFields));
            return this;
        }

        public ResolvedFunctionCall.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (ResolvedFunctionCall)ResolvedFunctionCall.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((ResolvedFunctionCall) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (ResolvedFunctionCall)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((ResolvedFunctionCall) (codedinputstream1)));
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
            return mergeFrom((ResolvedFunctionCall)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public ResolvedFunctionCall.Builder mergeResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            if ((bitField0_ & 2) == 2 && result_ != com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance())
            {
                result_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.newBuilder(result_).mergeFrom(value).buildPartial();
            } else
            {
                result_ = value;
            }
            bitField0_ = bitField0_ | 2;
            return this;
        }

        public ResolvedFunctionCall.Builder removeProperties(int i)
        {
            ensurePropertiesIsMutable();
            properties_.remove(i);
            return this;
        }

        public ResolvedFunctionCall.Builder setAssociatedRuleName(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                associatedRuleName_ = s;
                return this;
            }
        }

        public ResolvedFunctionCall.Builder setAssociatedRuleNameBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 4;
                associatedRuleName_ = bytestring;
                return this;
            }
        }

        public ResolvedFunctionCall.Builder setProperties(int i, ResolvedProperty.Builder builder)
        {
            ensurePropertiesIsMutable();
            properties_.set(i, builder.build());
            return this;
        }

        public ResolvedFunctionCall.Builder setProperties(int i, ResolvedProperty resolvedproperty)
        {
            if (resolvedproperty == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePropertiesIsMutable();
                properties_.set(i, resolvedproperty);
                return this;
            }
        }

        public ResolvedFunctionCall.Builder setResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder)
        {
            result_ = builder.build();
            bitField0_ = bitField0_ | 2;
            return this;
        }

        public ResolvedFunctionCall.Builder setResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                result_ = value;
                bitField0_ = bitField0_ | 2;
                return this;
            }
        }


        private ResolvedFunctionCall.Builder()
        {
            properties_ = Collections.emptyList();
            result_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance();
            associatedRuleName_ = "";
            maybeForceBuilderInitialization();
        }
    }

    public static interface ResolvedFunctionCallOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract String getAssociatedRuleName();

        public abstract ByteString getAssociatedRuleNameBytes();

        public abstract ResolvedProperty getProperties(int i);

        public abstract int getPropertiesCount();

        public abstract List getPropertiesList();

        public abstract com.google.analytics.midtier.proto.containertag.TypeSystem.Value getResult();

        public abstract boolean hasAssociatedRuleName();

        public abstract boolean hasResult();
    }

    public static final class ResolvedProperty extends GeneratedMessageLite
        implements ResolvedPropertyOrBuilder
    {

        public static final int KEY_FIELD_NUMBER = 1;
        public static Parser PARSER = new AbstractParser() {

            public ResolvedProperty parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new ResolvedProperty(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final ResolvedProperty defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        private Object key_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;
        private com.google.analytics.midtier.proto.containertag.TypeSystem.Value value_;

        public static ResolvedProperty getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            key_ = "";
            value_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(ResolvedProperty resolvedproperty)
        {
            return newBuilder().mergeFrom(resolvedproperty);
        }

        public static ResolvedProperty parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (ResolvedProperty)PARSER.parseDelimitedFrom(inputstream);
        }

        public static ResolvedProperty parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ResolvedProperty)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static ResolvedProperty parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (ResolvedProperty)PARSER.parseFrom(bytestring);
        }

        public static ResolvedProperty parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (ResolvedProperty)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static ResolvedProperty parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (ResolvedProperty)PARSER.parseFrom(codedinputstream);
        }

        public static ResolvedProperty parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ResolvedProperty)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static ResolvedProperty parseFrom(InputStream inputstream)
            throws IOException
        {
            return (ResolvedProperty)PARSER.parseFrom(inputstream);
        }

        public static ResolvedProperty parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ResolvedProperty)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static ResolvedProperty parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (ResolvedProperty)PARSER.parseFrom(abyte0);
        }

        public static ResolvedProperty parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (ResolvedProperty)PARSER.parseFrom(abyte0, extensionregistrylite);
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

        public ResolvedProperty getDefaultInstanceForType()
        {
            return defaultInstance;
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
            if (((ByteString) (obj)).isValidUtf8())
            {
                key_ = s;
            }
            return s;
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
                j = i + CodedOutputStream.computeMessageSize(2, value_);
            }
            i = j + unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public com.google.analytics.midtier.proto.containertag.TypeSystem.Value getValue()
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
            int j = com/google/analytics/containertag/proto/Debug$ResolvedProperty.hashCode() + 779;
            int i = j;
            if (hasKey())
            {
                i = (j * 37 + 1) * 53 + getKey().hashCode();
            }
            j = i;
            if (hasValue())
            {
                j = (i * 37 + 2) * 53 + getValue().hashCode();
            }
            i = j * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$ResolvedProperty");
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
            if (hasValue() && !getValue().isInitialized())
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
                codedoutputstream.writeBytes(1, getKeyBytes());
            }
            if ((bitField0_ & 2) == 2)
            {
                codedoutputstream.writeMessage(2, value_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new ResolvedProperty(true);
            defaultInstance.initFields();
        }



/*
        static Object access$5902(ResolvedProperty resolvedproperty, Object obj)
        {
            resolvedproperty.key_ = obj;
            return obj;
        }

*/


/*
        static com.google.analytics.midtier.proto.containertag.TypeSystem.Value access$6002(ResolvedProperty resolvedproperty, com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            resolvedproperty.value_ = value;
            return value;
        }

*/


/*
        static int access$6102(ResolvedProperty resolvedproperty, int i)
        {
            resolvedproperty.bitField0_ = i;
            return i;
        }

*/


        private ResolvedProperty(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
_L14:
            if (flag) goto _L2; else goto _L1
_L1:
            int i = codedinputstream.readTag();
            i;
            JVM INSTR lookupswitch 3: default 305
        //                       0: 308
        //                       10: 99
        //                       18: 150;
               goto _L3 _L4 _L5 _L6
_L3:
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            ByteString bytestring = codedinputstream.readBytes();
            bitField0_ = bitField0_ | 1;
            key_ = bytestring;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L12:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder = null;
            if ((bitField0_ & 2) == 2)
            {
                builder = value_.toBuilder();
            }
            value_ = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)codedinputstream.readMessage(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.PARSER, extensionregistrylite);
            if (builder == null) goto _L8; else goto _L7
_L7:
            builder.mergeFrom(value_);
            value_ = builder.buildPartial();
_L8:
            bitField0_ = bitField0_ | 2;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L2:
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L10:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L10; else goto _L9
_L9:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L12; else goto _L11
_L11:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L14; else goto _L13
_L13:
        }


        private ResolvedProperty(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private ResolvedProperty(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class ResolvedProperty.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements ResolvedPropertyOrBuilder
    {

        private int bitField0_;
        private Object key_;
        private com.google.analytics.midtier.proto.containertag.TypeSystem.Value value_;

        private static ResolvedProperty.Builder create()
        {
            return new ResolvedProperty.Builder();
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public ResolvedProperty build()
        {
            ResolvedProperty resolvedproperty = buildPartial();
            if (!resolvedproperty.isInitialized())
            {
                throw newUninitializedMessageException(resolvedproperty);
            } else
            {
                return resolvedproperty;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public ResolvedProperty buildPartial()
        {
            ResolvedProperty resolvedproperty = new ResolvedProperty(this);
            int k = bitField0_;
            int i = 0;
            if ((k & 1) == 1)
            {
                i = false | true;
            }
            resolvedproperty.key_ = key_;
            int j = i;
            if ((k & 2) == 2)
            {
                j = i | 2;
            }
            resolvedproperty.value_ = value_;
            resolvedproperty.bitField0_ = j;
            return resolvedproperty;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public ResolvedProperty.Builder clear()
        {
            super.clear();
            key_ = "";
            bitField0_ = bitField0_ & -2;
            value_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance();
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

        public ResolvedProperty.Builder clearKey()
        {
            bitField0_ = bitField0_ & -2;
            key_ = ResolvedProperty.getDefaultInstance().getKey();
            return this;
        }

        public ResolvedProperty.Builder clearValue()
        {
            value_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance();
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public ResolvedProperty.Builder clone()
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

        public ResolvedProperty getDefaultInstanceForType()
        {
            return ResolvedProperty.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
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

        public com.google.analytics.midtier.proto.containertag.TypeSystem.Value getValue()
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
            return !hasValue() || getValue().isInitialized();
        }

        public ResolvedProperty.Builder mergeFrom(ResolvedProperty resolvedproperty)
        {
            if (resolvedproperty == ResolvedProperty.getDefaultInstance())
            {
                return this;
            }
            if (resolvedproperty.hasKey())
            {
                bitField0_ = bitField0_ | 1;
                key_ = resolvedproperty.key_;
            }
            if (resolvedproperty.hasValue())
            {
                mergeValue(resolvedproperty.getValue());
            }
            setUnknownFields(getUnknownFields().concat(resolvedproperty.unknownFields));
            return this;
        }

        public ResolvedProperty.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (ResolvedProperty)ResolvedProperty.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((ResolvedProperty) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (ResolvedProperty)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((ResolvedProperty) (codedinputstream1)));
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
            return mergeFrom((ResolvedProperty)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public ResolvedProperty.Builder mergeValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            if ((bitField0_ & 2) == 2 && value_ != com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance())
            {
                value_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.newBuilder(value_).mergeFrom(value).buildPartial();
            } else
            {
                value_ = value;
            }
            bitField0_ = bitField0_ | 2;
            return this;
        }

        public ResolvedProperty.Builder setKey(String s)
        {
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

        public ResolvedProperty.Builder setKeyBytes(ByteString bytestring)
        {
            if (bytestring == null)
            {
                throw new NullPointerException();
            } else
            {
                bitField0_ = bitField0_ | 1;
                key_ = bytestring;
                return this;
            }
        }

        public ResolvedProperty.Builder setValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder)
        {
            value_ = builder.build();
            bitField0_ = bitField0_ | 2;
            return this;
        }

        public ResolvedProperty.Builder setValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                value_ = value;
                bitField0_ = bitField0_ | 2;
                return this;
            }
        }


        private ResolvedProperty.Builder()
        {
            key_ = "";
            value_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance();
            maybeForceBuilderInitialization();
        }
    }

    public static interface ResolvedPropertyOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract String getKey();

        public abstract ByteString getKeyBytes();

        public abstract com.google.analytics.midtier.proto.containertag.TypeSystem.Value getValue();

        public abstract boolean hasKey();

        public abstract boolean hasValue();
    }

    public static final class ResolvedRule extends GeneratedMessageLite
        implements ResolvedRuleOrBuilder
    {

        public static final int ADD_MACROS_FIELD_NUMBER = 5;
        public static final int ADD_TAGS_FIELD_NUMBER = 3;
        public static final int NEGATIVE_PREDICATES_FIELD_NUMBER = 2;
        public static Parser PARSER = new AbstractParser() {

            public ResolvedRule parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new ResolvedRule(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int POSITIVE_PREDICATES_FIELD_NUMBER = 1;
        public static final int REMOVE_MACROS_FIELD_NUMBER = 6;
        public static final int REMOVE_TAGS_FIELD_NUMBER = 4;
        public static final int RESULT_FIELD_NUMBER = 7;
        private static final ResolvedRule defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private List addMacros_;
        private List addTags_;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List negativePredicates_;
        private List positivePredicates_;
        private List removeMacros_;
        private List removeTags_;
        private com.google.analytics.midtier.proto.containertag.TypeSystem.Value result_;
        private final ByteString unknownFields;

        public static ResolvedRule getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            positivePredicates_ = Collections.emptyList();
            negativePredicates_ = Collections.emptyList();
            addTags_ = Collections.emptyList();
            removeTags_ = Collections.emptyList();
            addMacros_ = Collections.emptyList();
            removeMacros_ = Collections.emptyList();
            result_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(ResolvedRule resolvedrule)
        {
            return newBuilder().mergeFrom(resolvedrule);
        }

        public static ResolvedRule parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (ResolvedRule)PARSER.parseDelimitedFrom(inputstream);
        }

        public static ResolvedRule parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ResolvedRule)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static ResolvedRule parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (ResolvedRule)PARSER.parseFrom(bytestring);
        }

        public static ResolvedRule parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (ResolvedRule)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static ResolvedRule parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (ResolvedRule)PARSER.parseFrom(codedinputstream);
        }

        public static ResolvedRule parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ResolvedRule)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static ResolvedRule parseFrom(InputStream inputstream)
            throws IOException
        {
            return (ResolvedRule)PARSER.parseFrom(inputstream);
        }

        public static ResolvedRule parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (ResolvedRule)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static ResolvedRule parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (ResolvedRule)PARSER.parseFrom(abyte0);
        }

        public static ResolvedRule parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (ResolvedRule)PARSER.parseFrom(abyte0, extensionregistrylite);
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
            return addMacros_.size();
        }

        public List getAddMacrosList()
        {
            return addMacros_;
        }

        public ResolvedFunctionCallOrBuilder getAddMacrosOrBuilder(int i)
        {
            return (ResolvedFunctionCallOrBuilder)addMacros_.get(i);
        }

        public List getAddMacrosOrBuilderList()
        {
            return addMacros_;
        }

        public ResolvedFunctionCall getAddTags(int i)
        {
            return (ResolvedFunctionCall)addTags_.get(i);
        }

        public int getAddTagsCount()
        {
            return addTags_.size();
        }

        public List getAddTagsList()
        {
            return addTags_;
        }

        public ResolvedFunctionCallOrBuilder getAddTagsOrBuilder(int i)
        {
            return (ResolvedFunctionCallOrBuilder)addTags_.get(i);
        }

        public List getAddTagsOrBuilderList()
        {
            return addTags_;
        }

        public ResolvedRule getDefaultInstanceForType()
        {
            return defaultInstance;
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public ResolvedFunctionCall getNegativePredicates(int i)
        {
            return (ResolvedFunctionCall)negativePredicates_.get(i);
        }

        public int getNegativePredicatesCount()
        {
            return negativePredicates_.size();
        }

        public List getNegativePredicatesList()
        {
            return negativePredicates_;
        }

        public ResolvedFunctionCallOrBuilder getNegativePredicatesOrBuilder(int i)
        {
            return (ResolvedFunctionCallOrBuilder)negativePredicates_.get(i);
        }

        public List getNegativePredicatesOrBuilderList()
        {
            return negativePredicates_;
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
            return positivePredicates_.size();
        }

        public List getPositivePredicatesList()
        {
            return positivePredicates_;
        }

        public ResolvedFunctionCallOrBuilder getPositivePredicatesOrBuilder(int i)
        {
            return (ResolvedFunctionCallOrBuilder)positivePredicates_.get(i);
        }

        public List getPositivePredicatesOrBuilderList()
        {
            return positivePredicates_;
        }

        public ResolvedFunctionCall getRemoveMacros(int i)
        {
            return (ResolvedFunctionCall)removeMacros_.get(i);
        }

        public int getRemoveMacrosCount()
        {
            return removeMacros_.size();
        }

        public List getRemoveMacrosList()
        {
            return removeMacros_;
        }

        public ResolvedFunctionCallOrBuilder getRemoveMacrosOrBuilder(int i)
        {
            return (ResolvedFunctionCallOrBuilder)removeMacros_.get(i);
        }

        public List getRemoveMacrosOrBuilderList()
        {
            return removeMacros_;
        }

        public ResolvedFunctionCall getRemoveTags(int i)
        {
            return (ResolvedFunctionCall)removeTags_.get(i);
        }

        public int getRemoveTagsCount()
        {
            return removeTags_.size();
        }

        public List getRemoveTagsList()
        {
            return removeTags_;
        }

        public ResolvedFunctionCallOrBuilder getRemoveTagsOrBuilder(int i)
        {
            return (ResolvedFunctionCallOrBuilder)removeTags_.get(i);
        }

        public List getRemoveTagsOrBuilderList()
        {
            return removeTags_;
        }

        public com.google.analytics.midtier.proto.containertag.TypeSystem.Value getResult()
        {
            return result_;
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            for (int j = 0; j < positivePredicates_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(1, (MessageLite)positivePredicates_.get(j));
            }

            for (int k = 0; k < negativePredicates_.size(); k++)
            {
                i += CodedOutputStream.computeMessageSize(2, (MessageLite)negativePredicates_.get(k));
            }

            for (int l = 0; l < addTags_.size(); l++)
            {
                i += CodedOutputStream.computeMessageSize(3, (MessageLite)addTags_.get(l));
            }

            for (int i1 = 0; i1 < removeTags_.size(); i1++)
            {
                i += CodedOutputStream.computeMessageSize(4, (MessageLite)removeTags_.get(i1));
            }

            for (int j1 = 0; j1 < addMacros_.size(); j1++)
            {
                i += CodedOutputStream.computeMessageSize(5, (MessageLite)addMacros_.get(j1));
            }

            for (int k1 = 0; k1 < removeMacros_.size(); k1++)
            {
                i += CodedOutputStream.computeMessageSize(6, (MessageLite)removeMacros_.get(k1));
            }

            int l1 = i;
            if ((bitField0_ & 1) == 1)
            {
                l1 = i + CodedOutputStream.computeMessageSize(7, result_);
            }
            i = l1 + unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public boolean hasResult()
        {
            return (bitField0_ & 1) == 1;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Debug$ResolvedRule.hashCode() + 779;
            int i = j;
            if (getPositivePredicatesCount() > 0)
            {
                i = (j * 37 + 1) * 53 + getPositivePredicatesList().hashCode();
            }
            j = i;
            if (getNegativePredicatesCount() > 0)
            {
                j = (i * 37 + 2) * 53 + getNegativePredicatesList().hashCode();
            }
            i = j;
            if (getAddTagsCount() > 0)
            {
                i = (j * 37 + 3) * 53 + getAddTagsList().hashCode();
            }
            j = i;
            if (getRemoveTagsCount() > 0)
            {
                j = (i * 37 + 4) * 53 + getRemoveTagsList().hashCode();
            }
            i = j;
            if (getAddMacrosCount() > 0)
            {
                i = (j * 37 + 5) * 53 + getAddMacrosList().hashCode();
            }
            j = i;
            if (getRemoveMacrosCount() > 0)
            {
                j = (i * 37 + 6) * 53 + getRemoveMacrosList().hashCode();
            }
            i = j;
            if (hasResult())
            {
                i = (j * 37 + 7) * 53 + getResult().hashCode();
            }
            i = i * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$ResolvedRule");
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
            for (int i = 0; i < getPositivePredicatesCount(); i++)
            {
                if (!getPositivePredicates(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int j = 0; j < getNegativePredicatesCount(); j++)
            {
                if (!getNegativePredicates(j).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int k = 0; k < getAddTagsCount(); k++)
            {
                if (!getAddTags(k).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int l = 0; l < getRemoveTagsCount(); l++)
            {
                if (!getRemoveTags(l).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int i1 = 0; i1 < getAddMacrosCount(); i1++)
            {
                if (!getAddMacros(i1).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int j1 = 0; j1 < getRemoveMacrosCount(); j1++)
            {
                if (!getRemoveMacros(j1).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            if (hasResult() && !getResult().isInitialized())
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
            for (int i = 0; i < positivePredicates_.size(); i++)
            {
                codedoutputstream.writeMessage(1, (MessageLite)positivePredicates_.get(i));
            }

            for (int j = 0; j < negativePredicates_.size(); j++)
            {
                codedoutputstream.writeMessage(2, (MessageLite)negativePredicates_.get(j));
            }

            for (int k = 0; k < addTags_.size(); k++)
            {
                codedoutputstream.writeMessage(3, (MessageLite)addTags_.get(k));
            }

            for (int l = 0; l < removeTags_.size(); l++)
            {
                codedoutputstream.writeMessage(4, (MessageLite)removeTags_.get(l));
            }

            for (int i1 = 0; i1 < addMacros_.size(); i1++)
            {
                codedoutputstream.writeMessage(5, (MessageLite)addMacros_.get(i1));
            }

            for (int j1 = 0; j1 < removeMacros_.size(); j1++)
            {
                codedoutputstream.writeMessage(6, (MessageLite)removeMacros_.get(j1));
            }

            if ((bitField0_ & 1) == 1)
            {
                codedoutputstream.writeMessage(7, result_);
            }
            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new ResolvedRule(true);
            defaultInstance.initFields();
        }



/*
        static List access$1902(ResolvedRule resolvedrule, List list)
        {
            resolvedrule.positivePredicates_ = list;
            return list;
        }

*/



/*
        static List access$2002(ResolvedRule resolvedrule, List list)
        {
            resolvedrule.negativePredicates_ = list;
            return list;
        }

*/



/*
        static List access$2102(ResolvedRule resolvedrule, List list)
        {
            resolvedrule.addTags_ = list;
            return list;
        }

*/



/*
        static List access$2202(ResolvedRule resolvedrule, List list)
        {
            resolvedrule.removeTags_ = list;
            return list;
        }

*/



/*
        static List access$2302(ResolvedRule resolvedrule, List list)
        {
            resolvedrule.addMacros_ = list;
            return list;
        }

*/



/*
        static List access$2402(ResolvedRule resolvedrule, List list)
        {
            resolvedrule.removeMacros_ = list;
            return list;
        }

*/


/*
        static com.google.analytics.midtier.proto.containertag.TypeSystem.Value access$2502(ResolvedRule resolvedrule, com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            resolvedrule.result_ = value;
            return value;
        }

*/


/*
        static int access$2602(ResolvedRule resolvedrule, int i)
        {
            resolvedrule.bitField0_ = i;
            return i;
        }

*/


        private ResolvedRule(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
_L33:
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
            JVM INSTR lookupswitch 8: default 1147
        //                       0: 1150
        //                       10: 167
        //                       18: 397
        //                       26: 496
        //                       34: 574
        //                       42: 655
        //                       50: 736
        //                       58: 817;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
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
            if ((i & 1) == 1) goto _L13; else goto _L12
_L12:
            k = i;
            j = i;
            l = i;
            positivePredicates_ = new ArrayList();
            i1 = i | 1;
_L13:
            k = i1;
            j = i1;
            l = i1;
            positivePredicates_.add(codedinputstream.readMessage(ResolvedFunctionCall.PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            j = k;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            if ((j & 1) == 1)
            {
                positivePredicates_ = Collections.unmodifiableList(positivePredicates_);
            }
            if ((j & 2) == 2)
            {
                negativePredicates_ = Collections.unmodifiableList(negativePredicates_);
            }
            if ((j & 4) == 4)
            {
                addTags_ = Collections.unmodifiableList(addTags_);
            }
            if ((j & 8) == 8)
            {
                removeTags_ = Collections.unmodifiableList(removeTags_);
            }
            if ((j & 0x10) == 16)
            {
                addMacros_ = Collections.unmodifiableList(addMacros_);
            }
            if ((j & 0x20) == 32)
            {
                removeMacros_ = Collections.unmodifiableList(removeMacros_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L31:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            i1 = i;
            if ((i & 2) == 2) goto _L15; else goto _L14
_L14:
            k = i;
            j = i;
            l = i;
            negativePredicates_ = new ArrayList();
            i1 = i | 2;
_L15:
            k = i1;
            j = i1;
            l = i1;
            negativePredicates_.add(codedinputstream.readMessage(ResolvedFunctionCall.PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            j = l;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L7:
            i1 = i;
            if ((i & 4) == 4) goto _L17; else goto _L16
_L16:
            k = i;
            j = i;
            l = i;
            addTags_ = new ArrayList();
            i1 = i | 4;
_L17:
            k = i1;
            j = i1;
            l = i1;
            addTags_.add(codedinputstream.readMessage(ResolvedFunctionCall.PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L8:
            i1 = i;
            if ((i & 8) == 8) goto _L19; else goto _L18
_L18:
            k = i;
            j = i;
            l = i;
            removeTags_ = new ArrayList();
            i1 = i | 8;
_L19:
            k = i1;
            j = i1;
            l = i1;
            removeTags_.add(codedinputstream.readMessage(ResolvedFunctionCall.PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L9:
            i1 = i;
            if ((i & 0x10) == 16) goto _L21; else goto _L20
_L20:
            k = i;
            j = i;
            l = i;
            addMacros_ = new ArrayList();
            i1 = i | 0x10;
_L21:
            k = i1;
            j = i1;
            l = i1;
            addMacros_.add(codedinputstream.readMessage(ResolvedFunctionCall.PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L10:
            i1 = i;
            if ((i & 0x20) == 32) goto _L23; else goto _L22
_L22:
            k = i;
            j = i;
            l = i;
            removeMacros_ = new ArrayList();
            i1 = i | 0x20;
_L23:
            k = i1;
            j = i1;
            l = i1;
            removeMacros_.add(codedinputstream.readMessage(ResolvedFunctionCall.PARSER, extensionregistrylite));
            i = i1;
            continue; /* Loop/switch isn't completed */
_L11:
            com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder;
            builder = null;
            k = i;
            j = i;
            l = i;
            if ((bitField0_ & 1) != 1) goto _L25; else goto _L24
_L24:
            k = i;
            j = i;
            l = i;
            builder = result_.toBuilder();
_L25:
            k = i;
            j = i;
            l = i;
            result_ = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)codedinputstream.readMessage(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.PARSER, extensionregistrylite);
            if (builder == null) goto _L27; else goto _L26
_L26:
            k = i;
            j = i;
            l = i;
            builder.mergeFrom(result_);
            k = i;
            j = i;
            l = i;
            result_ = builder.buildPartial();
_L27:
            k = i;
            j = i;
            l = i;
            bitField0_ = bitField0_ | 1;
            continue; /* Loop/switch isn't completed */
_L2:
            if ((i & 1) == 1)
            {
                positivePredicates_ = Collections.unmodifiableList(positivePredicates_);
            }
            if ((i & 2) == 2)
            {
                negativePredicates_ = Collections.unmodifiableList(negativePredicates_);
            }
            if ((i & 4) == 4)
            {
                addTags_ = Collections.unmodifiableList(addTags_);
            }
            if ((i & 8) == 8)
            {
                removeTags_ = Collections.unmodifiableList(removeTags_);
            }
            if ((i & 0x10) == 16)
            {
                addMacros_ = Collections.unmodifiableList(addMacros_);
            }
            if ((i & 0x20) == 32)
            {
                removeMacros_ = Collections.unmodifiableList(removeMacros_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L29:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L29; else goto _L28
_L28:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L31; else goto _L30
_L30:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L33; else goto _L32
_L32:
        }


        private ResolvedRule(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private ResolvedRule(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class ResolvedRule.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements ResolvedRuleOrBuilder
    {

        private List addMacros_;
        private List addTags_;
        private int bitField0_;
        private List negativePredicates_;
        private List positivePredicates_;
        private List removeMacros_;
        private List removeTags_;
        private com.google.analytics.midtier.proto.containertag.TypeSystem.Value result_;

        private static ResolvedRule.Builder create()
        {
            return new ResolvedRule.Builder();
        }

        private void ensureAddMacrosIsMutable()
        {
            if ((bitField0_ & 0x10) != 16)
            {
                addMacros_ = new ArrayList(addMacros_);
                bitField0_ = bitField0_ | 0x10;
            }
        }

        private void ensureAddTagsIsMutable()
        {
            if ((bitField0_ & 4) != 4)
            {
                addTags_ = new ArrayList(addTags_);
                bitField0_ = bitField0_ | 4;
            }
        }

        private void ensureNegativePredicatesIsMutable()
        {
            if ((bitField0_ & 2) != 2)
            {
                negativePredicates_ = new ArrayList(negativePredicates_);
                bitField0_ = bitField0_ | 2;
            }
        }

        private void ensurePositivePredicatesIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                positivePredicates_ = new ArrayList(positivePredicates_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private void ensureRemoveMacrosIsMutable()
        {
            if ((bitField0_ & 0x20) != 32)
            {
                removeMacros_ = new ArrayList(removeMacros_);
                bitField0_ = bitField0_ | 0x20;
            }
        }

        private void ensureRemoveTagsIsMutable()
        {
            if ((bitField0_ & 8) != 8)
            {
                removeTags_ = new ArrayList(removeTags_);
                bitField0_ = bitField0_ | 8;
            }
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public ResolvedRule.Builder addAddMacros(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureAddMacrosIsMutable();
            addMacros_.add(i, builder.build());
            return this;
        }

        public ResolvedRule.Builder addAddMacros(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureAddMacrosIsMutable();
                addMacros_.add(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder addAddMacros(ResolvedFunctionCall.Builder builder)
        {
            ensureAddMacrosIsMutable();
            addMacros_.add(builder.build());
            return this;
        }

        public ResolvedRule.Builder addAddMacros(ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureAddMacrosIsMutable();
                addMacros_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder addAddTags(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureAddTagsIsMutable();
            addTags_.add(i, builder.build());
            return this;
        }

        public ResolvedRule.Builder addAddTags(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureAddTagsIsMutable();
                addTags_.add(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder addAddTags(ResolvedFunctionCall.Builder builder)
        {
            ensureAddTagsIsMutable();
            addTags_.add(builder.build());
            return this;
        }

        public ResolvedRule.Builder addAddTags(ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureAddTagsIsMutable();
                addTags_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder addAllAddMacros(Iterable iterable)
        {
            ensureAddMacrosIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, addMacros_);
            return this;
        }

        public ResolvedRule.Builder addAllAddTags(Iterable iterable)
        {
            ensureAddTagsIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, addTags_);
            return this;
        }

        public ResolvedRule.Builder addAllNegativePredicates(Iterable iterable)
        {
            ensureNegativePredicatesIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, negativePredicates_);
            return this;
        }

        public ResolvedRule.Builder addAllPositivePredicates(Iterable iterable)
        {
            ensurePositivePredicatesIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, positivePredicates_);
            return this;
        }

        public ResolvedRule.Builder addAllRemoveMacros(Iterable iterable)
        {
            ensureRemoveMacrosIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, removeMacros_);
            return this;
        }

        public ResolvedRule.Builder addAllRemoveTags(Iterable iterable)
        {
            ensureRemoveTagsIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, removeTags_);
            return this;
        }

        public ResolvedRule.Builder addNegativePredicates(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureNegativePredicatesIsMutable();
            negativePredicates_.add(i, builder.build());
            return this;
        }

        public ResolvedRule.Builder addNegativePredicates(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureNegativePredicatesIsMutable();
                negativePredicates_.add(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder addNegativePredicates(ResolvedFunctionCall.Builder builder)
        {
            ensureNegativePredicatesIsMutable();
            negativePredicates_.add(builder.build());
            return this;
        }

        public ResolvedRule.Builder addNegativePredicates(ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureNegativePredicatesIsMutable();
                negativePredicates_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder addPositivePredicates(int i, ResolvedFunctionCall.Builder builder)
        {
            ensurePositivePredicatesIsMutable();
            positivePredicates_.add(i, builder.build());
            return this;
        }

        public ResolvedRule.Builder addPositivePredicates(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePositivePredicatesIsMutable();
                positivePredicates_.add(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder addPositivePredicates(ResolvedFunctionCall.Builder builder)
        {
            ensurePositivePredicatesIsMutable();
            positivePredicates_.add(builder.build());
            return this;
        }

        public ResolvedRule.Builder addPositivePredicates(ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePositivePredicatesIsMutable();
                positivePredicates_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder addRemoveMacros(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureRemoveMacrosIsMutable();
            removeMacros_.add(i, builder.build());
            return this;
        }

        public ResolvedRule.Builder addRemoveMacros(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRemoveMacrosIsMutable();
                removeMacros_.add(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder addRemoveMacros(ResolvedFunctionCall.Builder builder)
        {
            ensureRemoveMacrosIsMutable();
            removeMacros_.add(builder.build());
            return this;
        }

        public ResolvedRule.Builder addRemoveMacros(ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRemoveMacrosIsMutable();
                removeMacros_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder addRemoveTags(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureRemoveTagsIsMutable();
            removeTags_.add(i, builder.build());
            return this;
        }

        public ResolvedRule.Builder addRemoveTags(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRemoveTagsIsMutable();
                removeTags_.add(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder addRemoveTags(ResolvedFunctionCall.Builder builder)
        {
            ensureRemoveTagsIsMutable();
            removeTags_.add(builder.build());
            return this;
        }

        public ResolvedRule.Builder addRemoveTags(ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRemoveTagsIsMutable();
                removeTags_.add(resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule build()
        {
            ResolvedRule resolvedrule = buildPartial();
            if (!resolvedrule.isInitialized())
            {
                throw newUninitializedMessageException(resolvedrule);
            } else
            {
                return resolvedrule;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public ResolvedRule buildPartial()
        {
            ResolvedRule resolvedrule = new ResolvedRule(this);
            int j = bitField0_;
            int i = 0;
            if ((bitField0_ & 1) == 1)
            {
                positivePredicates_ = Collections.unmodifiableList(positivePredicates_);
                bitField0_ = bitField0_ & -2;
            }
            resolvedrule.positivePredicates_ = positivePredicates_;
            if ((bitField0_ & 2) == 2)
            {
                negativePredicates_ = Collections.unmodifiableList(negativePredicates_);
                bitField0_ = bitField0_ & -3;
            }
            resolvedrule.negativePredicates_ = negativePredicates_;
            if ((bitField0_ & 4) == 4)
            {
                addTags_ = Collections.unmodifiableList(addTags_);
                bitField0_ = bitField0_ & -5;
            }
            resolvedrule.addTags_ = addTags_;
            if ((bitField0_ & 8) == 8)
            {
                removeTags_ = Collections.unmodifiableList(removeTags_);
                bitField0_ = bitField0_ & -9;
            }
            resolvedrule.removeTags_ = removeTags_;
            if ((bitField0_ & 0x10) == 16)
            {
                addMacros_ = Collections.unmodifiableList(addMacros_);
                bitField0_ = bitField0_ & 0xffffffef;
            }
            resolvedrule.addMacros_ = addMacros_;
            if ((bitField0_ & 0x20) == 32)
            {
                removeMacros_ = Collections.unmodifiableList(removeMacros_);
                bitField0_ = bitField0_ & 0xffffffdf;
            }
            resolvedrule.removeMacros_ = removeMacros_;
            if ((j & 0x40) == 64)
            {
                i = false | true;
            }
            resolvedrule.result_ = result_;
            resolvedrule.bitField0_ = i;
            return resolvedrule;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public ResolvedRule.Builder clear()
        {
            super.clear();
            positivePredicates_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            negativePredicates_ = Collections.emptyList();
            bitField0_ = bitField0_ & -3;
            addTags_ = Collections.emptyList();
            bitField0_ = bitField0_ & -5;
            removeTags_ = Collections.emptyList();
            bitField0_ = bitField0_ & -9;
            addMacros_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffef;
            removeMacros_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffdf;
            result_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance();
            bitField0_ = bitField0_ & 0xffffffbf;
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

        public ResolvedRule.Builder clearAddMacros()
        {
            addMacros_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffef;
            return this;
        }

        public ResolvedRule.Builder clearAddTags()
        {
            addTags_ = Collections.emptyList();
            bitField0_ = bitField0_ & -5;
            return this;
        }

        public ResolvedRule.Builder clearNegativePredicates()
        {
            negativePredicates_ = Collections.emptyList();
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public ResolvedRule.Builder clearPositivePredicates()
        {
            positivePredicates_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public ResolvedRule.Builder clearRemoveMacros()
        {
            removeMacros_ = Collections.emptyList();
            bitField0_ = bitField0_ & 0xffffffdf;
            return this;
        }

        public ResolvedRule.Builder clearRemoveTags()
        {
            removeTags_ = Collections.emptyList();
            bitField0_ = bitField0_ & -9;
            return this;
        }

        public ResolvedRule.Builder clearResult()
        {
            result_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance();
            bitField0_ = bitField0_ & 0xffffffbf;
            return this;
        }

        public ResolvedRule.Builder clone()
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

        public ResolvedFunctionCall getAddMacros(int i)
        {
            return (ResolvedFunctionCall)addMacros_.get(i);
        }

        public int getAddMacrosCount()
        {
            return addMacros_.size();
        }

        public List getAddMacrosList()
        {
            return Collections.unmodifiableList(addMacros_);
        }

        public ResolvedFunctionCall getAddTags(int i)
        {
            return (ResolvedFunctionCall)addTags_.get(i);
        }

        public int getAddTagsCount()
        {
            return addTags_.size();
        }

        public List getAddTagsList()
        {
            return Collections.unmodifiableList(addTags_);
        }

        public ResolvedRule getDefaultInstanceForType()
        {
            return ResolvedRule.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public volatile MessageLite getDefaultInstanceForType()
        {
            return getDefaultInstanceForType();
        }

        public ResolvedFunctionCall getNegativePredicates(int i)
        {
            return (ResolvedFunctionCall)negativePredicates_.get(i);
        }

        public int getNegativePredicatesCount()
        {
            return negativePredicates_.size();
        }

        public List getNegativePredicatesList()
        {
            return Collections.unmodifiableList(negativePredicates_);
        }

        public ResolvedFunctionCall getPositivePredicates(int i)
        {
            return (ResolvedFunctionCall)positivePredicates_.get(i);
        }

        public int getPositivePredicatesCount()
        {
            return positivePredicates_.size();
        }

        public List getPositivePredicatesList()
        {
            return Collections.unmodifiableList(positivePredicates_);
        }

        public ResolvedFunctionCall getRemoveMacros(int i)
        {
            return (ResolvedFunctionCall)removeMacros_.get(i);
        }

        public int getRemoveMacrosCount()
        {
            return removeMacros_.size();
        }

        public List getRemoveMacrosList()
        {
            return Collections.unmodifiableList(removeMacros_);
        }

        public ResolvedFunctionCall getRemoveTags(int i)
        {
            return (ResolvedFunctionCall)removeTags_.get(i);
        }

        public int getRemoveTagsCount()
        {
            return removeTags_.size();
        }

        public List getRemoveTagsList()
        {
            return Collections.unmodifiableList(removeTags_);
        }

        public com.google.analytics.midtier.proto.containertag.TypeSystem.Value getResult()
        {
            return result_;
        }

        public boolean hasResult()
        {
            return (bitField0_ & 0x40) == 64;
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

        public ResolvedRule.Builder mergeFrom(ResolvedRule resolvedrule)
        {
            if (resolvedrule == ResolvedRule.getDefaultInstance())
            {
                return this;
            }
            if (!resolvedrule.positivePredicates_.isEmpty())
            {
                if (positivePredicates_.isEmpty())
                {
                    positivePredicates_ = resolvedrule.positivePredicates_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensurePositivePredicatesIsMutable();
                    positivePredicates_.addAll(resolvedrule.positivePredicates_);
                }
            }
            if (!resolvedrule.negativePredicates_.isEmpty())
            {
                if (negativePredicates_.isEmpty())
                {
                    negativePredicates_ = resolvedrule.negativePredicates_;
                    bitField0_ = bitField0_ & -3;
                } else
                {
                    ensureNegativePredicatesIsMutable();
                    negativePredicates_.addAll(resolvedrule.negativePredicates_);
                }
            }
            if (!resolvedrule.addTags_.isEmpty())
            {
                if (addTags_.isEmpty())
                {
                    addTags_ = resolvedrule.addTags_;
                    bitField0_ = bitField0_ & -5;
                } else
                {
                    ensureAddTagsIsMutable();
                    addTags_.addAll(resolvedrule.addTags_);
                }
            }
            if (!resolvedrule.removeTags_.isEmpty())
            {
                if (removeTags_.isEmpty())
                {
                    removeTags_ = resolvedrule.removeTags_;
                    bitField0_ = bitField0_ & -9;
                } else
                {
                    ensureRemoveTagsIsMutable();
                    removeTags_.addAll(resolvedrule.removeTags_);
                }
            }
            if (!resolvedrule.addMacros_.isEmpty())
            {
                if (addMacros_.isEmpty())
                {
                    addMacros_ = resolvedrule.addMacros_;
                    bitField0_ = bitField0_ & 0xffffffef;
                } else
                {
                    ensureAddMacrosIsMutable();
                    addMacros_.addAll(resolvedrule.addMacros_);
                }
            }
            if (!resolvedrule.removeMacros_.isEmpty())
            {
                if (removeMacros_.isEmpty())
                {
                    removeMacros_ = resolvedrule.removeMacros_;
                    bitField0_ = bitField0_ & 0xffffffdf;
                } else
                {
                    ensureRemoveMacrosIsMutable();
                    removeMacros_.addAll(resolvedrule.removeMacros_);
                }
            }
            if (resolvedrule.hasResult())
            {
                mergeResult(resolvedrule.getResult());
            }
            setUnknownFields(getUnknownFields().concat(resolvedrule.unknownFields));
            return this;
        }

        public ResolvedRule.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (ResolvedRule)ResolvedRule.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((ResolvedRule) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (ResolvedRule)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((ResolvedRule) (codedinputstream1)));
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
            return mergeFrom((ResolvedRule)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public ResolvedRule.Builder mergeResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            if ((bitField0_ & 0x40) == 64 && result_ != com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance())
            {
                result_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.newBuilder(result_).mergeFrom(value).buildPartial();
            } else
            {
                result_ = value;
            }
            bitField0_ = bitField0_ | 0x40;
            return this;
        }

        public ResolvedRule.Builder removeAddMacros(int i)
        {
            ensureAddMacrosIsMutable();
            addMacros_.remove(i);
            return this;
        }

        public ResolvedRule.Builder removeAddTags(int i)
        {
            ensureAddTagsIsMutable();
            addTags_.remove(i);
            return this;
        }

        public ResolvedRule.Builder removeNegativePredicates(int i)
        {
            ensureNegativePredicatesIsMutable();
            negativePredicates_.remove(i);
            return this;
        }

        public ResolvedRule.Builder removePositivePredicates(int i)
        {
            ensurePositivePredicatesIsMutable();
            positivePredicates_.remove(i);
            return this;
        }

        public ResolvedRule.Builder removeRemoveMacros(int i)
        {
            ensureRemoveMacrosIsMutable();
            removeMacros_.remove(i);
            return this;
        }

        public ResolvedRule.Builder removeRemoveTags(int i)
        {
            ensureRemoveTagsIsMutable();
            removeTags_.remove(i);
            return this;
        }

        public ResolvedRule.Builder setAddMacros(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureAddMacrosIsMutable();
            addMacros_.set(i, builder.build());
            return this;
        }

        public ResolvedRule.Builder setAddMacros(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureAddMacrosIsMutable();
                addMacros_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder setAddTags(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureAddTagsIsMutable();
            addTags_.set(i, builder.build());
            return this;
        }

        public ResolvedRule.Builder setAddTags(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureAddTagsIsMutable();
                addTags_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder setNegativePredicates(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureNegativePredicatesIsMutable();
            negativePredicates_.set(i, builder.build());
            return this;
        }

        public ResolvedRule.Builder setNegativePredicates(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureNegativePredicatesIsMutable();
                negativePredicates_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder setPositivePredicates(int i, ResolvedFunctionCall.Builder builder)
        {
            ensurePositivePredicatesIsMutable();
            positivePredicates_.set(i, builder.build());
            return this;
        }

        public ResolvedRule.Builder setPositivePredicates(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensurePositivePredicatesIsMutable();
                positivePredicates_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder setRemoveMacros(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureRemoveMacrosIsMutable();
            removeMacros_.set(i, builder.build());
            return this;
        }

        public ResolvedRule.Builder setRemoveMacros(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRemoveMacrosIsMutable();
                removeMacros_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder setRemoveTags(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureRemoveTagsIsMutable();
            removeTags_.set(i, builder.build());
            return this;
        }

        public ResolvedRule.Builder setRemoveTags(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRemoveTagsIsMutable();
                removeTags_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public ResolvedRule.Builder setResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder)
        {
            result_ = builder.build();
            bitField0_ = bitField0_ | 0x40;
            return this;
        }

        public ResolvedRule.Builder setResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            if (value == null)
            {
                throw new NullPointerException();
            } else
            {
                result_ = value;
                bitField0_ = bitField0_ | 0x40;
                return this;
            }
        }


        private ResolvedRule.Builder()
        {
            positivePredicates_ = Collections.emptyList();
            negativePredicates_ = Collections.emptyList();
            addTags_ = Collections.emptyList();
            removeTags_ = Collections.emptyList();
            addMacros_ = Collections.emptyList();
            removeMacros_ = Collections.emptyList();
            result_ = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.getDefaultInstance();
            maybeForceBuilderInitialization();
        }
    }

    public static interface ResolvedRuleOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract ResolvedFunctionCall getAddMacros(int i);

        public abstract int getAddMacrosCount();

        public abstract List getAddMacrosList();

        public abstract ResolvedFunctionCall getAddTags(int i);

        public abstract int getAddTagsCount();

        public abstract List getAddTagsList();

        public abstract ResolvedFunctionCall getNegativePredicates(int i);

        public abstract int getNegativePredicatesCount();

        public abstract List getNegativePredicatesList();

        public abstract ResolvedFunctionCall getPositivePredicates(int i);

        public abstract int getPositivePredicatesCount();

        public abstract List getPositivePredicatesList();

        public abstract ResolvedFunctionCall getRemoveMacros(int i);

        public abstract int getRemoveMacrosCount();

        public abstract List getRemoveMacrosList();

        public abstract ResolvedFunctionCall getRemoveTags(int i);

        public abstract int getRemoveTagsCount();

        public abstract List getRemoveTagsList();

        public abstract com.google.analytics.midtier.proto.containertag.TypeSystem.Value getResult();

        public abstract boolean hasResult();
    }

    public static final class RuleEvaluationStepInfo extends GeneratedMessageLite
        implements RuleEvaluationStepInfoOrBuilder
    {

        public static final int ENABLED_FUNCTIONS_FIELD_NUMBER = 2;
        public static Parser PARSER = new AbstractParser() {

            public RuleEvaluationStepInfo parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return new RuleEvaluationStepInfo(codedinputstream, extensionregistrylite);
            }

            public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
                throws InvalidProtocolBufferException
            {
                return parsePartialFrom(codedinputstream, extensionregistrylite);
            }

        };
        public static final int RULES_FIELD_NUMBER = 1;
        private static final RuleEvaluationStepInfo defaultInstance;
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0L;
        private List enabledFunctions_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List rules_;
        private final ByteString unknownFields;

        public static RuleEvaluationStepInfo getDefaultInstance()
        {
            return defaultInstance;
        }

        private void initFields()
        {
            rules_ = Collections.emptyList();
            enabledFunctions_ = Collections.emptyList();
        }

        public static Builder newBuilder()
        {
            return Builder.create();
        }

        public static Builder newBuilder(RuleEvaluationStepInfo ruleevaluationstepinfo)
        {
            return newBuilder().mergeFrom(ruleevaluationstepinfo);
        }

        public static RuleEvaluationStepInfo parseDelimitedFrom(InputStream inputstream)
            throws IOException
        {
            return (RuleEvaluationStepInfo)PARSER.parseDelimitedFrom(inputstream);
        }

        public static RuleEvaluationStepInfo parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (RuleEvaluationStepInfo)PARSER.parseDelimitedFrom(inputstream, extensionregistrylite);
        }

        public static RuleEvaluationStepInfo parseFrom(ByteString bytestring)
            throws InvalidProtocolBufferException
        {
            return (RuleEvaluationStepInfo)PARSER.parseFrom(bytestring);
        }

        public static RuleEvaluationStepInfo parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (RuleEvaluationStepInfo)PARSER.parseFrom(bytestring, extensionregistrylite);
        }

        public static RuleEvaluationStepInfo parseFrom(CodedInputStream codedinputstream)
            throws IOException
        {
            return (RuleEvaluationStepInfo)PARSER.parseFrom(codedinputstream);
        }

        public static RuleEvaluationStepInfo parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (RuleEvaluationStepInfo)PARSER.parseFrom(codedinputstream, extensionregistrylite);
        }

        public static RuleEvaluationStepInfo parseFrom(InputStream inputstream)
            throws IOException
        {
            return (RuleEvaluationStepInfo)PARSER.parseFrom(inputstream);
        }

        public static RuleEvaluationStepInfo parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return (RuleEvaluationStepInfo)PARSER.parseFrom(inputstream, extensionregistrylite);
        }

        public static RuleEvaluationStepInfo parseFrom(byte abyte0[])
            throws InvalidProtocolBufferException
        {
            return (RuleEvaluationStepInfo)PARSER.parseFrom(abyte0);
        }

        public static RuleEvaluationStepInfo parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
            throws InvalidProtocolBufferException
        {
            return (RuleEvaluationStepInfo)PARSER.parseFrom(abyte0, extensionregistrylite);
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

        public RuleEvaluationStepInfo getDefaultInstanceForType()
        {
            return defaultInstance;
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
            return enabledFunctions_.size();
        }

        public List getEnabledFunctionsList()
        {
            return enabledFunctions_;
        }

        public ResolvedFunctionCallOrBuilder getEnabledFunctionsOrBuilder(int i)
        {
            return (ResolvedFunctionCallOrBuilder)enabledFunctions_.get(i);
        }

        public List getEnabledFunctionsOrBuilderList()
        {
            return enabledFunctions_;
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
            return rules_.size();
        }

        public List getRulesList()
        {
            return rules_;
        }

        public ResolvedRuleOrBuilder getRulesOrBuilder(int i)
        {
            return (ResolvedRuleOrBuilder)rules_.get(i);
        }

        public List getRulesOrBuilderList()
        {
            return rules_;
        }

        public int getSerializedSize()
        {
            int i = memoizedSerializedSize;
            if (i != -1)
            {
                return i;
            }
            i = 0;
            for (int j = 0; j < rules_.size(); j++)
            {
                i += CodedOutputStream.computeMessageSize(1, (MessageLite)rules_.get(j));
            }

            boolean flag = false;
            int k = i;
            for (i = ((flag) ? 1 : 0); i < enabledFunctions_.size(); i++)
            {
                k += CodedOutputStream.computeMessageSize(2, (MessageLite)enabledFunctions_.get(i));
            }

            i = k + unknownFields.size();
            memoizedSerializedSize = i;
            return i;
        }

        public int hashCode()
        {
            if (memoizedHashCode != 0)
            {
                return memoizedHashCode;
            }
            int j = com/google/analytics/containertag/proto/Debug$RuleEvaluationStepInfo.hashCode() + 779;
            int i = j;
            if (getRulesCount() > 0)
            {
                i = (j * 37 + 1) * 53 + getRulesList().hashCode();
            }
            j = i;
            if (getEnabledFunctionsCount() > 0)
            {
                j = (i * 37 + 2) * 53 + getEnabledFunctionsList().hashCode();
            }
            i = j * 29 + unknownFields.hashCode();
            memoizedHashCode = i;
            return i;
        }

        protected MutableMessageLite internalMutableDefault()
        {
            if (mutableDefault == null)
            {
                mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$RuleEvaluationStepInfo");
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
            for (int i = 0; i < getRulesCount(); i++)
            {
                if (!getRules(i).isInitialized())
                {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }

            for (int j = 0; j < getEnabledFunctionsCount(); j++)
            {
                if (!getEnabledFunctions(j).isInitialized())
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
            for (int i = 0; i < rules_.size(); i++)
            {
                codedoutputstream.writeMessage(1, (MessageLite)rules_.get(i));
            }

            for (int j = 0; j < enabledFunctions_.size(); j++)
            {
                codedoutputstream.writeMessage(2, (MessageLite)enabledFunctions_.get(j));
            }

            codedoutputstream.writeRawBytes(unknownFields);
        }

        static 
        {
            defaultInstance = new RuleEvaluationStepInfo(true);
            defaultInstance.initFields();
        }



/*
        static List access$3902(RuleEvaluationStepInfo ruleevaluationstepinfo, List list)
        {
            ruleevaluationstepinfo.rules_ = list;
            return list;
        }

*/



/*
        static List access$4002(RuleEvaluationStepInfo ruleevaluationstepinfo, List list)
        {
            ruleevaluationstepinfo.enabledFunctions_ = list;
            return list;
        }

*/


        private RuleEvaluationStepInfo(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
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
_L16:
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
            JVM INSTR lookupswitch 3: default 471
        //                       0: 474
        //                       10: 123
        //                       18: 270;
               goto _L3 _L4 _L5 _L6
_L3:
            l = i;
            j = i;
            i1 = i;
            if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, k))
            {
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            k = i;
            if ((i & 1) == 1) goto _L8; else goto _L7
_L7:
            l = i;
            j = i;
            i1 = i;
            rules_ = new ArrayList();
            k = i | 1;
_L8:
            l = k;
            j = k;
            i1 = k;
            rules_.add(codedinputstream.readMessage(ResolvedRule.PARSER, extensionregistrylite));
            i = k;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            j = l;
            throw codedinputstream.setUnfinishedMessage(this);
            codedinputstream;
            if ((j & 1) == 1)
            {
                rules_ = Collections.unmodifiableList(rules_);
            }
            if ((j & 2) == 2)
            {
                enabledFunctions_ = Collections.unmodifiableList(enabledFunctions_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L14:
            makeExtensionsImmutable();
            throw codedinputstream;
_L6:
            k = i;
            if ((i & 2) == 2) goto _L10; else goto _L9
_L9:
            l = i;
            j = i;
            i1 = i;
            enabledFunctions_ = new ArrayList();
            k = i | 2;
_L10:
            l = k;
            j = k;
            i1 = k;
            enabledFunctions_.add(codedinputstream.readMessage(ResolvedFunctionCall.PARSER, extensionregistrylite));
            i = k;
            continue; /* Loop/switch isn't completed */
            codedinputstream;
            j = i1;
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(this);
_L2:
            if ((i & 1) == 1)
            {
                rules_ = Collections.unmodifiableList(rules_);
            }
            if ((i & 2) == 2)
            {
                enabledFunctions_ = Collections.unmodifiableList(enabledFunctions_);
            }
            codedoutputstream.flush();
            unknownFields = output.toByteString();
_L12:
            makeExtensionsImmutable();
            return;
            codedinputstream;
            unknownFields = output.toByteString();
            if (true) goto _L12; else goto _L11
_L11:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
            extensionregistrylite;
            unknownFields = output.toByteString();
            if (true) goto _L14; else goto _L13
_L13:
            codedinputstream;
            unknownFields = output.toByteString();
            throw codedinputstream;
_L4:
            flag = true;
            if (true) goto _L16; else goto _L15
_L15:
        }


        private RuleEvaluationStepInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder)
        {
            super(builder);
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = builder.getUnknownFields();
        }


        private RuleEvaluationStepInfo(boolean flag)
        {
            memoizedIsInitialized = -1;
            memoizedSerializedSize = -1;
            unknownFields = ByteString.EMPTY;
        }
    }

    public static final class RuleEvaluationStepInfo.Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder
        implements RuleEvaluationStepInfoOrBuilder
    {

        private int bitField0_;
        private List enabledFunctions_;
        private List rules_;

        private static RuleEvaluationStepInfo.Builder create()
        {
            return new RuleEvaluationStepInfo.Builder();
        }

        private void ensureEnabledFunctionsIsMutable()
        {
            if ((bitField0_ & 2) != 2)
            {
                enabledFunctions_ = new ArrayList(enabledFunctions_);
                bitField0_ = bitField0_ | 2;
            }
        }

        private void ensureRulesIsMutable()
        {
            if ((bitField0_ & 1) != 1)
            {
                rules_ = new ArrayList(rules_);
                bitField0_ = bitField0_ | 1;
            }
        }

        private void maybeForceBuilderInitialization()
        {
        }

        public RuleEvaluationStepInfo.Builder addAllEnabledFunctions(Iterable iterable)
        {
            ensureEnabledFunctionsIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, enabledFunctions_);
            return this;
        }

        public RuleEvaluationStepInfo.Builder addAllRules(Iterable iterable)
        {
            ensureRulesIsMutable();
            com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, rules_);
            return this;
        }

        public RuleEvaluationStepInfo.Builder addEnabledFunctions(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureEnabledFunctionsIsMutable();
            enabledFunctions_.add(i, builder.build());
            return this;
        }

        public RuleEvaluationStepInfo.Builder addEnabledFunctions(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEnabledFunctionsIsMutable();
                enabledFunctions_.add(i, resolvedfunctioncall);
                return this;
            }
        }

        public RuleEvaluationStepInfo.Builder addEnabledFunctions(ResolvedFunctionCall.Builder builder)
        {
            ensureEnabledFunctionsIsMutable();
            enabledFunctions_.add(builder.build());
            return this;
        }

        public RuleEvaluationStepInfo.Builder addEnabledFunctions(ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEnabledFunctionsIsMutable();
                enabledFunctions_.add(resolvedfunctioncall);
                return this;
            }
        }

        public RuleEvaluationStepInfo.Builder addRules(int i, ResolvedRule.Builder builder)
        {
            ensureRulesIsMutable();
            rules_.add(i, builder.build());
            return this;
        }

        public RuleEvaluationStepInfo.Builder addRules(int i, ResolvedRule resolvedrule)
        {
            if (resolvedrule == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRulesIsMutable();
                rules_.add(i, resolvedrule);
                return this;
            }
        }

        public RuleEvaluationStepInfo.Builder addRules(ResolvedRule.Builder builder)
        {
            ensureRulesIsMutable();
            rules_.add(builder.build());
            return this;
        }

        public RuleEvaluationStepInfo.Builder addRules(ResolvedRule resolvedrule)
        {
            if (resolvedrule == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRulesIsMutable();
                rules_.add(resolvedrule);
                return this;
            }
        }

        public RuleEvaluationStepInfo build()
        {
            RuleEvaluationStepInfo ruleevaluationstepinfo = buildPartial();
            if (!ruleevaluationstepinfo.isInitialized())
            {
                throw newUninitializedMessageException(ruleevaluationstepinfo);
            } else
            {
                return ruleevaluationstepinfo;
            }
        }

        public volatile MessageLite build()
        {
            return build();
        }

        public RuleEvaluationStepInfo buildPartial()
        {
            RuleEvaluationStepInfo ruleevaluationstepinfo = new RuleEvaluationStepInfo(this);
            int i = bitField0_;
            if ((bitField0_ & 1) == 1)
            {
                rules_ = Collections.unmodifiableList(rules_);
                bitField0_ = bitField0_ & -2;
            }
            ruleevaluationstepinfo.rules_ = rules_;
            if ((bitField0_ & 2) == 2)
            {
                enabledFunctions_ = Collections.unmodifiableList(enabledFunctions_);
                bitField0_ = bitField0_ & -3;
            }
            ruleevaluationstepinfo.enabledFunctions_ = enabledFunctions_;
            return ruleevaluationstepinfo;
        }

        public volatile MessageLite buildPartial()
        {
            return buildPartial();
        }

        public RuleEvaluationStepInfo.Builder clear()
        {
            super.clear();
            rules_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            enabledFunctions_ = Collections.emptyList();
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

        public RuleEvaluationStepInfo.Builder clearEnabledFunctions()
        {
            enabledFunctions_ = Collections.emptyList();
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public RuleEvaluationStepInfo.Builder clearRules()
        {
            rules_ = Collections.emptyList();
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public RuleEvaluationStepInfo.Builder clone()
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

        public RuleEvaluationStepInfo getDefaultInstanceForType()
        {
            return RuleEvaluationStepInfo.getDefaultInstance();
        }

        public volatile GeneratedMessageLite getDefaultInstanceForType()
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
            return enabledFunctions_.size();
        }

        public List getEnabledFunctionsList()
        {
            return Collections.unmodifiableList(enabledFunctions_);
        }

        public ResolvedRule getRules(int i)
        {
            return (ResolvedRule)rules_.get(i);
        }

        public int getRulesCount()
        {
            return rules_.size();
        }

        public List getRulesList()
        {
            return Collections.unmodifiableList(rules_);
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

        public RuleEvaluationStepInfo.Builder mergeFrom(RuleEvaluationStepInfo ruleevaluationstepinfo)
        {
            if (ruleevaluationstepinfo == RuleEvaluationStepInfo.getDefaultInstance())
            {
                return this;
            }
            if (!ruleevaluationstepinfo.rules_.isEmpty())
            {
                if (rules_.isEmpty())
                {
                    rules_ = ruleevaluationstepinfo.rules_;
                    bitField0_ = bitField0_ & -2;
                } else
                {
                    ensureRulesIsMutable();
                    rules_.addAll(ruleevaluationstepinfo.rules_);
                }
            }
            if (!ruleevaluationstepinfo.enabledFunctions_.isEmpty())
            {
                if (enabledFunctions_.isEmpty())
                {
                    enabledFunctions_ = ruleevaluationstepinfo.enabledFunctions_;
                    bitField0_ = bitField0_ & -3;
                } else
                {
                    ensureEnabledFunctionsIsMutable();
                    enabledFunctions_.addAll(ruleevaluationstepinfo.enabledFunctions_);
                }
            }
            setUnknownFields(getUnknownFields().concat(ruleevaluationstepinfo.unknownFields));
            return this;
        }

        public RuleEvaluationStepInfo.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            CodedInputStream codedinputstream1;
            Object obj;
            obj = null;
            codedinputstream1 = obj;
            codedinputstream = (RuleEvaluationStepInfo)RuleEvaluationStepInfo.PARSER.parsePartialFrom(codedinputstream, extensionregistrylite);
            if (codedinputstream != null)
            {
                mergeFrom(((RuleEvaluationStepInfo) (codedinputstream)));
            }
            return this;
            extensionregistrylite;
            codedinputstream1 = obj;
            codedinputstream = (RuleEvaluationStepInfo)extensionregistrylite.getUnfinishedMessage();
            codedinputstream1 = codedinputstream;
            throw extensionregistrylite;
            codedinputstream;
            if (codedinputstream1 != null)
            {
                mergeFrom(((RuleEvaluationStepInfo) (codedinputstream1)));
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
            return mergeFrom((RuleEvaluationStepInfo)generatedmessagelite);
        }

        public volatile com.google.tagmanager.protobuf.MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public RuleEvaluationStepInfo.Builder removeEnabledFunctions(int i)
        {
            ensureEnabledFunctionsIsMutable();
            enabledFunctions_.remove(i);
            return this;
        }

        public RuleEvaluationStepInfo.Builder removeRules(int i)
        {
            ensureRulesIsMutable();
            rules_.remove(i);
            return this;
        }

        public RuleEvaluationStepInfo.Builder setEnabledFunctions(int i, ResolvedFunctionCall.Builder builder)
        {
            ensureEnabledFunctionsIsMutable();
            enabledFunctions_.set(i, builder.build());
            return this;
        }

        public RuleEvaluationStepInfo.Builder setEnabledFunctions(int i, ResolvedFunctionCall resolvedfunctioncall)
        {
            if (resolvedfunctioncall == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureEnabledFunctionsIsMutable();
                enabledFunctions_.set(i, resolvedfunctioncall);
                return this;
            }
        }

        public RuleEvaluationStepInfo.Builder setRules(int i, ResolvedRule.Builder builder)
        {
            ensureRulesIsMutable();
            rules_.set(i, builder.build());
            return this;
        }

        public RuleEvaluationStepInfo.Builder setRules(int i, ResolvedRule resolvedrule)
        {
            if (resolvedrule == null)
            {
                throw new NullPointerException();
            } else
            {
                ensureRulesIsMutable();
                rules_.set(i, resolvedrule);
                return this;
            }
        }


        private RuleEvaluationStepInfo.Builder()
        {
            rules_ = Collections.emptyList();
            enabledFunctions_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }
    }

    public static interface RuleEvaluationStepInfoOrBuilder
        extends MessageLiteOrBuilder
    {

        public abstract ResolvedFunctionCall getEnabledFunctions(int i);

        public abstract int getEnabledFunctionsCount();

        public abstract List getEnabledFunctionsList();

        public abstract ResolvedRule getRules(int i);

        public abstract int getRulesCount();

        public abstract List getRulesList();
    }


    private Debug()
    {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionregistrylite)
    {
        extensionregistrylite.add(MacroEvaluationInfo.macro);
    }

}
