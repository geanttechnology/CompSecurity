// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.analytics.containertag.proto:
//            Debug

public static final class maybeForceBuilderInitialization extends com.google.tagmanager.protobuf..Builder
    implements 
{

    private int bitField0_;
    private List results_;
    private bitField0_ rulesEvaluation_;

    private static  create()
    {
        return new <init>();
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

    public bitField0_ addAllResults(Iterable iterable)
    {
        ensureResultsIsMutable();
        com.google.tagmanager.protobuf..Builder.ensureResultsIsMutable(iterable, results_);
        return this;
    }

    public results_ addResults(int i, results_ results_1)
    {
        ensureResultsIsMutable();
        results_.add(i, results_1.results_());
        return this;
    }

    public results_ addResults(int i, results_ results_1)
    {
        if (results_1 == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureResultsIsMutable();
            results_.add(i, results_1);
            return this;
        }
    }

    public results_ addResults(results_ results_1)
    {
        ensureResultsIsMutable();
        results_.add(results_1.results_());
        return this;
    }

    public results_ addResults(results_ results_1)
    {
        if (results_1 == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureResultsIsMutable();
            results_.add(results_1);
            return this;
        }
    }

    public results_ build()
    {
        results_ results_1 = buildPartial();
        if (!results_1.lized())
        {
            throw newUninitializedMessageException(results_1);
        } else
        {
            return results_1;
        }
    }

    public volatile MessageLite build()
    {
        return build();
    }

    public build buildPartial()
    {
        build build1 = new build(this, null);
        int j = bitField0_;
        int i = 0;
        if ((j & 1) == 1)
        {
            i = false | true;
        }
        _mth502(build1, rulesEvaluation_);
        if ((bitField0_ & 2) == 2)
        {
            results_ = Collections.unmodifiableList(results_);
            bitField0_ = bitField0_ & -3;
        }
        _mth602(build1, results_);
        _mth702(build1, i);
        return build1;
    }

    public volatile MessageLite buildPartial()
    {
        return buildPartial();
    }

    public buildPartial clear()
    {
        super.Builder();
        rulesEvaluation_ = ance();
        bitField0_ = bitField0_ & -2;
        results_ = Collections.emptyList();
        bitField0_ = bitField0_ & -3;
        return this;
    }

    public volatile com.google.tagmanager.protobuf..Builder clear()
    {
        return clear();
    }

    public volatile com.google.tagmanager.protobuf..Builder clear()
    {
        return clear();
    }

    public clear clearResults()
    {
        results_ = Collections.emptyList();
        bitField0_ = bitField0_ & -3;
        return this;
    }

    public bitField0_ clearRulesEvaluation()
    {
        rulesEvaluation_ = ance();
        bitField0_ = bitField0_ & -2;
        return this;
    }

    public bitField0_ clone()
    {
        return create().mergeFrom(buildPartial());
    }

    public volatile com.google.tagmanager.protobuf..Builder clone()
    {
        return clone();
    }

    public volatile com.google.tagmanager.protobuf..Builder clone()
    {
        return clone();
    }

    public volatile com.google.tagmanager.protobuf..Builder clone()
    {
        return clone();
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public clone getDefaultInstanceForType()
    {
        return ltInstance();
    }

    public volatile GeneratedMessageLite getDefaultInstanceForType()
    {
        return getDefaultInstanceForType();
    }

    public volatile MessageLite getDefaultInstanceForType()
    {
        return getDefaultInstanceForType();
    }

    public getDefaultInstanceForType getResults(int i)
    {
        return (getDefaultInstanceForType)results_.get(i);
    }

    public int getResultsCount()
    {
        return results_.size();
    }

    public List getResultsList()
    {
        return Collections.unmodifiableList(results_);
    }

    public results_ getRulesEvaluation()
    {
        return rulesEvaluation_;
    }

    public boolean hasRulesEvaluation()
    {
        return (bitField0_ & 1) == 1;
    }

    public final boolean isInitialized()
    {
        if (!hasRulesEvaluation() || getRulesEvaluation().getRulesEvaluation()) goto _L2; else goto _L1
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
                if (!getResults(i).getResults())
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

    public getResults mergeFrom(getResults getresults)
    {
        if (getresults == ltInstance())
        {
            return this;
        }
        if (getresults.Evaluation())
        {
            mergeRulesEvaluation(getresults.Evaluation());
        }
        if (!_mth600(getresults).isEmpty())
        {
            if (results_.isEmpty())
            {
                results_ = _mth600(getresults);
                bitField0_ = bitField0_ & -3;
            } else
            {
                ensureResultsIsMutable();
                results_.addAll(_mth600(getresults));
            }
        }
        setUnknownFields(getUnknownFields().concat(_mth800(getresults)));
        return this;
    }

    public _cls800 mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        CodedInputStream codedinputstream1;
        Object obj;
        obj = null;
        codedinputstream1 = obj;
        codedinputstream = (_cls800)_fld800.parsePartialFrom(codedinputstream, extensionregistrylite);
        if (codedinputstream != null)
        {
            mergeFrom(((mergeFrom) (codedinputstream)));
        }
        return this;
        extensionregistrylite;
        codedinputstream1 = obj;
        codedinputstream = (mergeFrom)extensionregistrylite.getUnfinishedMessage();
        codedinputstream1 = codedinputstream;
        throw extensionregistrylite;
        codedinputstream;
        if (codedinputstream1 != null)
        {
            mergeFrom(((mergeFrom) (codedinputstream1)));
        }
        throw codedinputstream;
    }

    public volatile com.google.tagmanager.protobuf..Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        return mergeFrom(codedinputstream, extensionregistrylite);
    }

    public volatile com.google.tagmanager.protobuf..Builder mergeFrom(GeneratedMessageLite generatedmessagelite)
    {
        return mergeFrom((mergeFrom)generatedmessagelite);
    }

    public volatile com.google.tagmanager.protobuf..Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        return mergeFrom(codedinputstream, extensionregistrylite);
    }

    public mergeFrom mergeRulesEvaluation(mergeFrom mergefrom)
    {
        if ((bitField0_ & 1) == 1 && rulesEvaluation_ != ance())
        {
            rulesEvaluation_ = rulesEvaluation_(rulesEvaluation_).rom(mergefrom).artial();
        } else
        {
            rulesEvaluation_ = mergefrom;
        }
        bitField0_ = bitField0_ | 1;
        return this;
    }

    public bitField0_ removeResults(int i)
    {
        ensureResultsIsMutable();
        results_.remove(i);
        return this;
    }

    public results_ setResults(int i, results_ results_1)
    {
        ensureResultsIsMutable();
        results_.set(i, results_1.results_());
        return this;
    }

    public results_ setResults(int i, results_ results_1)
    {
        if (results_1 == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureResultsIsMutable();
            results_.set(i, results_1);
            return this;
        }
    }

    public results_ setRulesEvaluation(results_ results_1)
    {
        rulesEvaluation_ = results_1.rulesEvaluation_();
        bitField0_ = bitField0_ | 1;
        return this;
    }

    public bitField0_ setRulesEvaluation(bitField0_ bitfield0_)
    {
        if (bitfield0_ == null)
        {
            throw new NullPointerException();
        } else
        {
            rulesEvaluation_ = bitfield0_;
            bitField0_ = bitField0_ | 1;
            return this;
        }
    }


    private ()
    {
        rulesEvaluation_ = ance();
        results_ = Collections.emptyList();
        maybeForceBuilderInitialization();
    }
}
