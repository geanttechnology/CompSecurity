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

// Referenced classes of package com.google.analytics.containertag.proto:
//            Debug

public static final class maybeForceBuilderInitialization extends com.google.tagmanager.protobuf..Builder
    implements 
{

    private int bitField0_;
    private bitField0_ result_;
    private bitField0_ rulesEvaluation_;

    private static  create()
    {
        return new <init>();
    }

    private void maybeForceBuilderInitialization()
    {
    }

    public <init> build()
    {
        <init> <init>1 = buildPartial();
        if (!<init>1.lized())
        {
            throw newUninitializedMessageException(<init>1);
        } else
        {
            return <init>1;
        }
    }

    public volatile MessageLite build()
    {
        return build();
    }

    public build buildPartial()
    {
        build build1 = new build(this, null);
        int k = bitField0_;
        int i = 0;
        if ((k & 1) == 1)
        {
            i = false | true;
        }
        _mth202(build1, rulesEvaluation_);
        int j = i;
        if ((k & 2) == 2)
        {
            j = i | 2;
        }
        _mth302(build1, result_);
        _mth402(build1, j);
        return build1;
    }

    public volatile MessageLite buildPartial()
    {
        return buildPartial();
    }

    public buildPartial clear()
    {
        super.();
        rulesEvaluation_ = faultInstance();
        bitField0_ = bitField0_ & -2;
        result_ = ultInstance();
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

    public clear clearResult()
    {
        result_ = ultInstance();
        bitField0_ = bitField0_ & -3;
        return this;
    }

    public bitField0_ clearRulesEvaluation()
    {
        rulesEvaluation_ = faultInstance();
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

    public getDefaultInstanceForType getResult()
    {
        return result_;
    }

    public result_ getRulesEvaluation()
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
        while (hasRulesEvaluation() && !getRulesEvaluation().tialized() || hasResult() && !getResult().alized()) 
        {
            return false;
        }
        return true;
    }

    public alized mergeFrom(alized alized)
    {
        if (alized == ltInstance())
        {
            return this;
        }
        if (alized.Evaluation())
        {
            mergeRulesEvaluation(alized.Evaluation());
        }
        if (alized.t())
        {
            mergeResult(alized.t());
        }
        setUnknownFields(getUnknownFields().concat(_mth500(alized)));
        return this;
    }

    public _cls500 mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        CodedInputStream codedinputstream1;
        Object obj;
        obj = null;
        codedinputstream1 = obj;
        codedinputstream = (_cls500)_fld500.parsePartialFrom(codedinputstream, extensionregistrylite);
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

    public mergeFrom mergeResult(mergeFrom mergefrom)
    {
        if ((bitField0_ & 2) == 2 && result_ != ultInstance())
        {
            result_ = der(result_).mergeFrom(mergefrom).buildPartial();
        } else
        {
            result_ = mergefrom;
        }
        bitField0_ = bitField0_ | 2;
        return this;
    }

    public bitField0_ mergeRulesEvaluation(bitField0_ bitfield0_)
    {
        if ((bitField0_ & 1) == 1 && rulesEvaluation_ != faultInstance())
        {
            rulesEvaluation_ = ilder(rulesEvaluation_).mergeFrom(bitfield0_).buildPartial();
        } else
        {
            rulesEvaluation_ = bitfield0_;
        }
        bitField0_ = bitField0_ | 1;
        return this;
    }

    public  setResult( )
    {
        result_ = .build();
        bitField0_ = bitField0_ | 2;
        return this;
    }

    public bitField0_ setResult(bitField0_ bitfield0_)
    {
        if (bitfield0_ == null)
        {
            throw new NullPointerException();
        } else
        {
            result_ = bitfield0_;
            bitField0_ = bitField0_ | 2;
            return this;
        }
    }

    public er setRulesEvaluation(er er)
    {
        rulesEvaluation_ = er.build();
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


    private er()
    {
        rulesEvaluation_ = faultInstance();
        result_ = ultInstance();
        maybeForceBuilderInitialization();
    }
}
