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

public static final class enabledFunctions_ extends GeneratedMutableMessageLite
    implements MutableMessageLite
{

    public static final int ENABLED_FUNCTIONS_FIELD_NUMBER = 2;
    public static Parser PARSER;
    public static final int RULES_FIELD_NUMBER = 1;
    private static final defaultInstance defaultInstance;
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

    public static rules_ getDefaultInstance()
    {
        return defaultInstance;
    }

    private void initFields()
    {
    }

    public static defaultInstance newMessage()
    {
        return new <init>();
    }

    public <init> addAllEnabledFunctions(Iterable iterable)
    {
        assertMutable();
        ensureEnabledFunctionsInitialized();
        AbstractMutableMessageLite.addAll(iterable, enabledFunctions_);
        return this;
    }

    public enabledFunctions_ addAllRules(Iterable iterable)
    {
        assertMutable();
        ensureRulesInitialized();
        AbstractMutableMessageLite.addAll(iterable, rules_);
        return this;
    }

    public rules_ addEnabledFunctions()
    {
        assertMutable();
        ensureEnabledFunctionsInitialized();
        rules_ rules_1 = wMessage();
        enabledFunctions_.add(rules_1);
        return rules_1;
    }

    public enabledFunctions_ addEnabledFunctions(enabledFunctions_ enabledfunctions_)
    {
        assertMutable();
        if (enabledfunctions_ == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureEnabledFunctionsInitialized();
            enabledFunctions_.add(enabledfunctions_);
            return this;
        }
    }

    public enabledFunctions_ addRules()
    {
        assertMutable();
        ensureRulesInitialized();
        enabledFunctions_ enabledfunctions_ = ();
        rules_.add(enabledfunctions_);
        return enabledfunctions_;
    }

    public rules_ addRules(rules_ rules_1)
    {
        assertMutable();
        if (rules_1 == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureRulesInitialized();
            rules_.add(rules_1);
            return this;
        }
    }

    public rules_ clear()
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

    public clear clearEnabledFunctions()
    {
        assertMutable();
        enabledFunctions_ = null;
        return this;
    }

    public enabledFunctions_ clearRules()
    {
        assertMutable();
        rules_ = null;
        return this;
    }

    public rules_ clone()
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
        if (true && getRulesList().equals(((getRulesList) (obj)).getRulesList()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && getEnabledFunctionsList().equals(((getEnabledFunctionsList) (obj)).getEnabledFunctionsList()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag1;
    }

    public final getEnabledFunctionsList getDefaultInstanceForType()
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

    public getDefaultInstanceForType getEnabledFunctions(int i)
    {
        return (getDefaultInstanceForType)enabledFunctions_.get(i);
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

    public enabledFunctions_ getMutableEnabledFunctions(int i)
    {
        return (enabledFunctions_)enabledFunctions_.get(i);
    }

    public List getMutableEnabledFunctionsList()
    {
        assertMutable();
        ensureEnabledFunctionsInitialized();
        return enabledFunctions_;
    }

    public enabledFunctions_ getMutableRules(int i)
    {
        return (enabledFunctions_)rules_.get(i);
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

    public PARSER getRules(int i)
    {
        return (PARSER)rules_.get(i);
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
        if (getRules(i).zed()) goto _L4; else goto _L3
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
                if (!getEnabledFunctions(j).Initialized())
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

    public Initialized mergeFrom(Initialized initialized)
    {
        if (this == initialized)
        {
            throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
        }
        assertMutable();
        if (initialized == getDefaultInstance())
        {
            return this;
        }
        if (initialized.rules_ != null && !initialized.rules_.isEmpty())
        {
            ensureRulesInitialized();
            AbstractMutableMessageLite.addAll(initialized.rules_, rules_);
        }
        if (initialized.enabledFunctions_ != null && !initialized.enabledFunctions_.isEmpty())
        {
            ensureEnabledFunctionsInitialized();
            AbstractMutableMessageLite.addAll(initialized.enabledFunctions_, enabledFunctions_);
        }
        unknownFields = unknownFields.concat(initialized.unknownFields);
        return this;
    }

    public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
    {
        return mergeFrom((mergeFrom)generatedmutablemessagelite);
    }

    public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
    {
        assertMutable();
        com.google.tagmanager.protobuf.StepInfo stepinfo;
        CodedOutputStream codedoutputstream;
        boolean flag;
        int i;
        try
        {
            stepinfo = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(stepinfo);
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
    //                   0: 125
    //                   10: 83
    //                   18: 95;
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
        unknownFields = stepinfo.unknownFields();
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

    public newMessageForType setEnabledFunctions(int i, newMessageForType newmessagefortype)
    {
        assertMutable();
        if (newmessagefortype == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureEnabledFunctionsInitialized();
            enabledFunctions_.set(i, newmessagefortype);
            return this;
        }
    }

    public enabledFunctions_ setRules(int i, enabledFunctions_ enabledfunctions_)
    {
        assertMutable();
        if (enabledfunctions_ == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureRulesInitialized();
            rules_.set(i, enabledfunctions_);
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
        defaultInstance.makeImmutable();
        PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    }

    private Q()
    {
        rules_ = null;
        enabledFunctions_ = null;
        initFields();
    }

    private initFields(boolean flag)
    {
        rules_ = null;
        enabledFunctions_ = null;
    }
}
