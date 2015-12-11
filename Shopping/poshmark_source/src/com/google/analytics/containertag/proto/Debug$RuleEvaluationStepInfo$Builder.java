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
    private List enabledFunctions_;
    private List rules_;

    private static  create()
    {
        return new <init>();
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

    public bitField0_ addAllEnabledFunctions(Iterable iterable)
    {
        ensureEnabledFunctionsIsMutable();
        com.google.tagmanager.protobuf..Builder.ensureEnabledFunctionsIsMutable(iterable, enabledFunctions_);
        return this;
    }

    public enabledFunctions_ addAllRules(Iterable iterable)
    {
        ensureRulesIsMutable();
        com.google.tagmanager.protobuf..Builder.ensureRulesIsMutable(iterable, rules_);
        return this;
    }

    public rules_ addEnabledFunctions(int i, rules_ rules_1)
    {
        ensureEnabledFunctionsIsMutable();
        enabledFunctions_.add(i, rules_1.ild());
        return this;
    }

    public ild addEnabledFunctions(int i, ild ild)
    {
        if (ild == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureEnabledFunctionsIsMutable();
            enabledFunctions_.add(i, ild);
            return this;
        }
    }

    public enabledFunctions_ addEnabledFunctions(enabledFunctions_ enabledfunctions_)
    {
        ensureEnabledFunctionsIsMutable();
        enabledFunctions_.add(enabledfunctions_.ild());
        return this;
    }

    public ild addEnabledFunctions(ild ild)
    {
        if (ild == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureEnabledFunctionsIsMutable();
            enabledFunctions_.add(ild);
            return this;
        }
    }

    public enabledFunctions_ addRules(int i, enabledFunctions_ enabledfunctions_)
    {
        ensureRulesIsMutable();
        rules_.add(i, enabledfunctions_.rules_());
        return this;
    }

    public rules_ addRules(int i, rules_ rules_1)
    {
        if (rules_1 == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureRulesIsMutable();
            rules_.add(i, rules_1);
            return this;
        }
    }

    public rules_ addRules(rules_ rules_1)
    {
        ensureRulesIsMutable();
        rules_.add(rules_1.rules_());
        return this;
    }

    public rules_ addRules(rules_ rules_1)
    {
        if (rules_1 == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureRulesIsMutable();
            rules_.add(rules_1);
            return this;
        }
    }

    public rules_ build()
    {
        rules_ rules_1 = buildPartial();
        if (!rules_1.lized())
        {
            throw newUninitializedMessageException(rules_1);
        } else
        {
            return rules_1;
        }
    }

    public volatile MessageLite build()
    {
        return build();
    }

    public build buildPartial()
    {
        build build1 = new build(this, null);
        int i = bitField0_;
        if ((bitField0_ & 1) == 1)
        {
            rules_ = Collections.unmodifiableList(rules_);
            bitField0_ = bitField0_ & -2;
        }
        _mth902(build1, rules_);
        if ((bitField0_ & 2) == 2)
        {
            enabledFunctions_ = Collections.unmodifiableList(enabledFunctions_);
            bitField0_ = bitField0_ & -3;
        }
        _mth002(build1, enabledFunctions_);
        return build1;
    }

    public volatile MessageLite buildPartial()
    {
        return buildPartial();
    }

    public buildPartial clear()
    {
        super.Builder();
        rules_ = Collections.emptyList();
        bitField0_ = bitField0_ & -2;
        enabledFunctions_ = Collections.emptyList();
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

    public clear clearEnabledFunctions()
    {
        enabledFunctions_ = Collections.emptyList();
        bitField0_ = bitField0_ & -3;
        return this;
    }

    public bitField0_ clearRules()
    {
        rules_ = Collections.emptyList();
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

    public getDefaultInstanceForType getEnabledFunctions(int i)
    {
        return (getDefaultInstanceForType)enabledFunctions_.get(i);
    }

    public int getEnabledFunctionsCount()
    {
        return enabledFunctions_.size();
    }

    public List getEnabledFunctionsList()
    {
        return Collections.unmodifiableList(enabledFunctions_);
    }

    public enabledFunctions_ getRules(int i)
    {
        return (enabledFunctions_)rules_.get(i);
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
        if (getRules(i).getRules()) goto _L4; else goto _L3
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
                if (!getEnabledFunctions(j).zed())
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

    public zed mergeFrom(zed zed)
    {
        if (zed == ltInstance())
        {
            return this;
        }
        if (!_mth900(zed).isEmpty())
        {
            if (rules_.isEmpty())
            {
                rules_ = _mth900(zed);
                bitField0_ = bitField0_ & -2;
            } else
            {
                ensureRulesIsMutable();
                rules_.addAll(_mth900(zed));
            }
        }
        if (!_mth000(zed).isEmpty())
        {
            if (enabledFunctions_.isEmpty())
            {
                enabledFunctions_ = _mth000(zed);
                bitField0_ = bitField0_ & -3;
            } else
            {
                ensureEnabledFunctionsIsMutable();
                enabledFunctions_.addAll(_mth000(zed));
            }
        }
        setUnknownFields(getUnknownFields().concat(_mth100(zed)));
        return this;
    }

    public _cls100 mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        CodedInputStream codedinputstream1;
        Object obj;
        obj = null;
        codedinputstream1 = obj;
        codedinputstream = (_cls100)_fld100.parsePartialFrom(codedinputstream, extensionregistrylite);
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

    public mergeFrom removeEnabledFunctions(int i)
    {
        ensureEnabledFunctionsIsMutable();
        enabledFunctions_.remove(i);
        return this;
    }

    public enabledFunctions_ removeRules(int i)
    {
        ensureRulesIsMutable();
        rules_.remove(i);
        return this;
    }

    public rules_ setEnabledFunctions(int i, rules_ rules_1)
    {
        ensureEnabledFunctionsIsMutable();
        enabledFunctions_.set(i, rules_1.ild());
        return this;
    }

    public ild setEnabledFunctions(int i, ild ild)
    {
        if (ild == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureEnabledFunctionsIsMutable();
            enabledFunctions_.set(i, ild);
            return this;
        }
    }

    public enabledFunctions_ setRules(int i, enabledFunctions_ enabledfunctions_)
    {
        ensureRulesIsMutable();
        rules_.set(i, enabledfunctions_.rules_());
        return this;
    }

    public rules_ setRules(int i, rules_ rules_1)
    {
        if (rules_1 == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureRulesIsMutable();
            rules_.set(i, rules_1);
            return this;
        }
    }


    private ()
    {
        rules_ = Collections.emptyList();
        enabledFunctions_ = Collections.emptyList();
        maybeForceBuilderInitialization();
    }
}
