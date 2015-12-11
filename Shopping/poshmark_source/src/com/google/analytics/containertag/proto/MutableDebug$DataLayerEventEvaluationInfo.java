// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.AbstractMutableMessageLite;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.analytics.containertag.proto:
//            MutableDebug

public static final class results_ extends GeneratedMutableMessageLite
    implements MutableMessageLite
{

    public static Parser PARSER;
    public static final int RESULTS_FIELD_NUMBER = 2;
    public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
    private static final defaultInstance defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private List results_;
    private defaultInstance rulesEvaluation_;

    private void ensureResultsInitialized()
    {
        if (results_ == null)
        {
            results_ = new ArrayList();
        }
    }

    private void ensureRulesEvaluationInitialized()
    {
        if (rulesEvaluation_ == aultInstance())
        {
            rulesEvaluation_ = sage();
        }
    }

    public static sage getDefaultInstance()
    {
        return defaultInstance;
    }

    private void initFields()
    {
        rulesEvaluation_ = aultInstance();
    }

    public static aultInstance newMessage()
    {
        return new <init>();
    }

    public <init> addAllResults(Iterable iterable)
    {
        assertMutable();
        ensureResultsInitialized();
        AbstractMutableMessageLite.addAll(iterable, results_);
        return this;
    }

    public results_ addResults(results_ results_1)
    {
        assertMutable();
        if (results_1 == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureResultsInitialized();
            results_.add(results_1);
            return this;
        }
    }

    public results_ addResults()
    {
        assertMutable();
        ensureResultsInitialized();
        results_ results_1 = ge();
        results_.add(results_1);
        return results_1;
    }

    public results_ clear()
    {
        assertMutable();
        super.clear();
        if (rulesEvaluation_ != aultInstance())
        {
            rulesEvaluation_.rulesEvaluation_();
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

    public clear clearResults()
    {
        assertMutable();
        results_ = null;
        return this;
    }

    public results_ clearRulesEvaluation()
    {
        assertMutable();
        bitField0_ = bitField0_ & -2;
        if (rulesEvaluation_ != aultInstance())
        {
            rulesEvaluation_.rulesEvaluation_();
        }
        return this;
    }

    public rulesEvaluation_ clone()
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
        if (!(obj instanceof clone))
        {
            return super.equals(obj);
        }
        obj = (clone)obj;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (true && hasRulesEvaluation() == ((hasRulesEvaluation) (obj)).hasRulesEvaluation())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (hasRulesEvaluation())
        {
            if (flag && getRulesEvaluation().((() (obj)).getRulesEvaluation()))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1 && getResultsList().equals(((getResultsList) (obj)).getResultsList()))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        return flag2;
    }

    public final getResultsList getDefaultInstanceForType()
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

    public getDefaultInstanceForType getMutableResults(int i)
    {
        return (getDefaultInstanceForType)results_.get(i);
    }

    public List getMutableResultsList()
    {
        assertMutable();
        ensureResultsInitialized();
        return results_;
    }

    public results_ getMutableRulesEvaluation()
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

    public PARSER getResults(int i)
    {
        return (PARSER)results_.get(i);
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

    public results_ getRulesEvaluation()
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
            i = 0x13a46 + getRulesEvaluation().de();
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
        if (!hasRulesEvaluation() || getRulesEvaluation().ialized()) goto _L2; else goto _L1
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
                if (!getResults(i).lized())
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

    public lized mergeFrom(lized lized)
    {
        if (this == lized)
        {
            throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
        }
        assertMutable();
        if (lized == getDefaultInstance())
        {
            return this;
        }
        if (lized.hasRulesEvaluation())
        {
            ensureRulesEvaluationInitialized();
            rulesEvaluation_.rom(lized.getRulesEvaluation());
            bitField0_ = bitField0_ | 1;
        }
        if (lized.results_ != null && !lized.results_.isEmpty())
        {
            ensureResultsInitialized();
            AbstractMutableMessageLite.addAll(lized.results_, results_);
        }
        unknownFields = unknownFields.concat(lized.unknownFields);
        return this;
    }

    public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
    {
        return mergeFrom((mergeFrom)generatedmutablemessagelite);
    }

    public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
    {
        assertMutable();
        com.google.tagmanager.protobuf.tionInfo tioninfo;
        CodedOutputStream codedoutputstream;
        boolean flag;
        int i;
        try
        {
            tioninfo = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(tioninfo);
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
    //                   0: 152
    //                   10: 83
    //                   18: 122;
           goto _L3 _L4 _L5 _L6
_L3:
        if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (rulesEvaluation_ == aultInstance())
        {
            rulesEvaluation_ = sage();
        }
        bitField0_ = bitField0_ | 1;
        codedinputstream.readMessage(rulesEvaluation_, extensionregistrylite);
        continue; /* Loop/switch isn't completed */
_L6:
        codedinputstream.readMessage(addResults(), extensionregistrylite);
        continue; /* Loop/switch isn't completed */
_L2:
        codedoutputstream.flush();
        unknownFields = tioninfo.unknownFields();
        return true;
_L4:
        flag = true;
        if (true) goto _L8; else goto _L7
_L8:
        break MISSING_BLOCK_LABEL_17;
_L7:
    }

    public unknownFields newMessageForType()
    {
        return new <init>();
    }

    public volatile MutableMessageLite newMessageForType()
    {
        return newMessageForType();
    }

    public newMessageForType setResults(int i, newMessageForType newmessagefortype)
    {
        assertMutable();
        if (newmessagefortype == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureResultsInitialized();
            results_.set(i, newmessagefortype);
            return this;
        }
    }

    public results_ setRulesEvaluation(results_ results_1)
    {
        assertMutable();
        if (results_1 == null)
        {
            throw new NullPointerException();
        } else
        {
            bitField0_ = bitField0_ | 1;
            rulesEvaluation_ = results_1;
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
        defaultInstance.makeImmutable();
        PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    }

    private ()
    {
        results_ = null;
        initFields();
    }

    private initFields(boolean flag)
    {
        results_ = null;
    }
}
