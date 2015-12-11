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

public static final class removeMacros_ extends GeneratedMutableMessageLite
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
    private static final defaultInstance defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private List addMacros_;
    private List addTags_;
    private int bitField0_;
    private List negativePredicates_;
    private List positivePredicates_;
    private List removeMacros_;
    private List removeTags_;
    private com.google.analytics.midtier.proto.containertag.nstance result_;

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
        if (result_ == com.google.analytics.midtier.proto.containertag.tDefaultInstance())
        {
            result_ = com.google.analytics.midtier.proto.containertag.wMessage();
        }
    }

    public static Value.newMessage getDefaultInstance()
    {
        return defaultInstance;
    }

    private void initFields()
    {
        result_ = com.google.analytics.midtier.proto.containertag.tDefaultInstance();
    }

    public static Value.getDefaultInstance newMessage()
    {
        return new <init>();
    }

    public ionCall addAddMacros()
    {
        assertMutable();
        ensureAddMacrosInitialized();
        ionCall ioncall = ionCall.newMessage();
        addMacros_.add(ioncall);
        return ioncall;
    }

    public ionCall addAddMacros(ionCall ioncall)
    {
        assertMutable();
        if (ioncall == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureAddMacrosInitialized();
            addMacros_.add(ioncall);
            return this;
        }
    }

    public ionCall addAddTags()
    {
        assertMutable();
        ensureAddTagsInitialized();
        ionCall ioncall = ionCall.newMessage();
        addTags_.add(ioncall);
        return ioncall;
    }

    public ionCall addAddTags(ionCall ioncall)
    {
        assertMutable();
        if (ioncall == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureAddTagsInitialized();
            addTags_.add(ioncall);
            return this;
        }
    }

    public addTags_ addAllAddMacros(Iterable iterable)
    {
        assertMutable();
        ensureAddMacrosInitialized();
        AbstractMutableMessageLite.addAll(iterable, addMacros_);
        return this;
    }

    public addMacros_ addAllAddTags(Iterable iterable)
    {
        assertMutable();
        ensureAddTagsInitialized();
        AbstractMutableMessageLite.addAll(iterable, addTags_);
        return this;
    }

    public addTags_ addAllNegativePredicates(Iterable iterable)
    {
        assertMutable();
        ensureNegativePredicatesInitialized();
        AbstractMutableMessageLite.addAll(iterable, negativePredicates_);
        return this;
    }

    public negativePredicates_ addAllPositivePredicates(Iterable iterable)
    {
        assertMutable();
        ensurePositivePredicatesInitialized();
        AbstractMutableMessageLite.addAll(iterable, positivePredicates_);
        return this;
    }

    public positivePredicates_ addAllRemoveMacros(Iterable iterable)
    {
        assertMutable();
        ensureRemoveMacrosInitialized();
        AbstractMutableMessageLite.addAll(iterable, removeMacros_);
        return this;
    }

    public removeMacros_ addAllRemoveTags(Iterable iterable)
    {
        assertMutable();
        ensureRemoveTagsInitialized();
        AbstractMutableMessageLite.addAll(iterable, removeTags_);
        return this;
    }

    public ionCall addNegativePredicates()
    {
        assertMutable();
        ensureNegativePredicatesInitialized();
        ionCall ioncall = ionCall.newMessage();
        negativePredicates_.add(ioncall);
        return ioncall;
    }

    public ionCall addNegativePredicates(ionCall ioncall)
    {
        assertMutable();
        if (ioncall == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureNegativePredicatesInitialized();
            negativePredicates_.add(ioncall);
            return this;
        }
    }

    public ionCall addPositivePredicates()
    {
        assertMutable();
        ensurePositivePredicatesInitialized();
        ionCall ioncall = ionCall.newMessage();
        positivePredicates_.add(ioncall);
        return ioncall;
    }

    public ionCall addPositivePredicates(ionCall ioncall)
    {
        assertMutable();
        if (ioncall == null)
        {
            throw new NullPointerException();
        } else
        {
            ensurePositivePredicatesInitialized();
            positivePredicates_.add(ioncall);
            return this;
        }
    }

    public ionCall addRemoveMacros()
    {
        assertMutable();
        ensureRemoveMacrosInitialized();
        ionCall ioncall = ionCall.newMessage();
        removeMacros_.add(ioncall);
        return ioncall;
    }

    public ionCall addRemoveMacros(ionCall ioncall)
    {
        assertMutable();
        if (ioncall == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureRemoveMacrosInitialized();
            removeMacros_.add(ioncall);
            return this;
        }
    }

    public ionCall addRemoveTags()
    {
        assertMutable();
        ensureRemoveTagsInitialized();
        ionCall ioncall = ionCall.newMessage();
        removeTags_.add(ioncall);
        return ioncall;
    }

    public ionCall addRemoveTags(ionCall ioncall)
    {
        assertMutable();
        if (ioncall == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureRemoveTagsInitialized();
            removeTags_.add(ioncall);
            return this;
        }
    }

    public removeTags_ clear()
    {
        assertMutable();
        super.clear();
        positivePredicates_ = null;
        negativePredicates_ = null;
        addTags_ = null;
        removeTags_ = null;
        addMacros_ = null;
        removeMacros_ = null;
        if (result_ != com.google.analytics.midtier.proto.containertag.tDefaultInstance())
        {
            result_.ear();
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

    public clear clearAddMacros()
    {
        assertMutable();
        addMacros_ = null;
        return this;
    }

    public addMacros_ clearAddTags()
    {
        assertMutable();
        addTags_ = null;
        return this;
    }

    public addTags_ clearNegativePredicates()
    {
        assertMutable();
        negativePredicates_ = null;
        return this;
    }

    public negativePredicates_ clearPositivePredicates()
    {
        assertMutable();
        positivePredicates_ = null;
        return this;
    }

    public positivePredicates_ clearRemoveMacros()
    {
        assertMutable();
        removeMacros_ = null;
        return this;
    }

    public removeMacros_ clearRemoveTags()
    {
        assertMutable();
        removeTags_ = null;
        return this;
    }

    public removeTags_ clearResult()
    {
        assertMutable();
        bitField0_ = bitField0_ & -2;
        if (result_ != com.google.analytics.midtier.proto.containertag.tDefaultInstance())
        {
            result_.ear();
        }
        return this;
    }

    public Value.clear clone()
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
        if (true && getPositivePredicatesList().equals(((getPositivePredicatesList) (obj)).getPositivePredicatesList()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && getNegativePredicatesList().equals(((getNegativePredicatesList) (obj)).getNegativePredicatesList()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && getAddTagsList().equals(((getAddTagsList) (obj)).getAddTagsList()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && getRemoveTagsList().equals(((getRemoveTagsList) (obj)).getRemoveTagsList()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && getAddMacrosList().equals(((getAddMacrosList) (obj)).getAddMacrosList()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && getRemoveMacrosList().equals(((getRemoveMacrosList) (obj)).getRemoveMacrosList()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && hasResult() == ((hasResult) (obj)).hasResult())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag1;
        if (hasResult())
        {
            if (flag1 && getResult().uals(((Value.equals) (obj)).getResult()))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
        }
        return flag2;
    }

    public ionCall getAddMacros(int i)
    {
        return (ionCall)addMacros_.get(i);
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

    public ionCall getAddTags(int i)
    {
        return (ionCall)addTags_.get(i);
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

    public final addTags_ getDefaultInstanceForType()
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

    public ionCall getMutableAddMacros(int i)
    {
        return (ionCall)addMacros_.get(i);
    }

    public List getMutableAddMacrosList()
    {
        assertMutable();
        ensureAddMacrosInitialized();
        return addMacros_;
    }

    public ionCall getMutableAddTags(int i)
    {
        return (ionCall)addTags_.get(i);
    }

    public List getMutableAddTagsList()
    {
        assertMutable();
        ensureAddTagsInitialized();
        return addTags_;
    }

    public ionCall getMutableNegativePredicates(int i)
    {
        return (ionCall)negativePredicates_.get(i);
    }

    public List getMutableNegativePredicatesList()
    {
        assertMutable();
        ensureNegativePredicatesInitialized();
        return negativePredicates_;
    }

    public ionCall getMutablePositivePredicates(int i)
    {
        return (ionCall)positivePredicates_.get(i);
    }

    public List getMutablePositivePredicatesList()
    {
        assertMutable();
        ensurePositivePredicatesInitialized();
        return positivePredicates_;
    }

    public ionCall getMutableRemoveMacros(int i)
    {
        return (ionCall)removeMacros_.get(i);
    }

    public List getMutableRemoveMacrosList()
    {
        assertMutable();
        ensureRemoveMacrosInitialized();
        return removeMacros_;
    }

    public ionCall getMutableRemoveTags(int i)
    {
        return (ionCall)removeTags_.get(i);
    }

    public List getMutableRemoveTagsList()
    {
        assertMutable();
        ensureRemoveTagsInitialized();
        return removeTags_;
    }

    public com.google.analytics.midtier.proto.containertag.gs_ getMutableResult()
    {
        assertMutable();
        ensureResultInitialized();
        bitField0_ = bitField0_ | 1;
        return result_;
    }

    public ionCall getNegativePredicates(int i)
    {
        return (ionCall)negativePredicates_.get(i);
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

    public ionCall getPositivePredicates(int i)
    {
        return (ionCall)positivePredicates_.get(i);
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

    public ionCall getRemoveMacros(int i)
    {
        return (ionCall)removeMacros_.get(i);
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

    public ionCall getRemoveTags(int i)
    {
        return (ionCall)removeTags_.get(i);
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

    public com.google.analytics.midtier.proto.containertag.gs_ getResult()
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
            j = (i * 37 + 7) * 53 + getResult().shCode();
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
        if (hasResult() && !getResult().Initialized()) goto _L3; else goto _L15
_L15:
        return true;
        if (true) goto _L17; else goto _L16
_L16:
    }

    public Value.isInitialized mergeFrom(Value.isInitialized isinitialized)
    {
        if (this == isinitialized)
        {
            throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
        }
        assertMutable();
        if (isinitialized == getDefaultInstance())
        {
            return this;
        }
        if (isinitialized.positivePredicates_ != null && !isinitialized.positivePredicates_.isEmpty())
        {
            ensurePositivePredicatesInitialized();
            AbstractMutableMessageLite.addAll(isinitialized.positivePredicates_, positivePredicates_);
        }
        if (isinitialized.negativePredicates_ != null && !isinitialized.negativePredicates_.isEmpty())
        {
            ensureNegativePredicatesInitialized();
            AbstractMutableMessageLite.addAll(isinitialized.negativePredicates_, negativePredicates_);
        }
        if (isinitialized.addTags_ != null && !isinitialized.addTags_.isEmpty())
        {
            ensureAddTagsInitialized();
            AbstractMutableMessageLite.addAll(isinitialized.addTags_, addTags_);
        }
        if (isinitialized.removeTags_ != null && !isinitialized.removeTags_.isEmpty())
        {
            ensureRemoveTagsInitialized();
            AbstractMutableMessageLite.addAll(isinitialized.removeTags_, removeTags_);
        }
        if (isinitialized.addMacros_ != null && !isinitialized.addMacros_.isEmpty())
        {
            ensureAddMacrosInitialized();
            AbstractMutableMessageLite.addAll(isinitialized.addMacros_, addMacros_);
        }
        if (isinitialized.removeMacros_ != null && !isinitialized.removeMacros_.isEmpty())
        {
            ensureRemoveMacrosInitialized();
            AbstractMutableMessageLite.addAll(isinitialized.removeMacros_, removeMacros_);
        }
        if (isinitialized.hasResult())
        {
            ensureResultInitialized();
            result_.rgeFrom(isinitialized.getResult());
            bitField0_ = bitField0_ | 1;
        }
        unknownFields = unknownFields.concat(isinitialized.unknownFields);
        return this;
    }

    public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
    {
        return mergeFrom((mergeFrom)generatedmutablemessagelite);
    }

    public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
    {
        assertMutable();
        com.google.tagmanager.protobuf.lvedRule lvedrule;
        CodedOutputStream codedoutputstream;
        boolean flag;
        int i;
        try
        {
            lvedrule = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(lvedrule);
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
    //                   0: 252
    //                   10: 123
    //                   18: 135
    //                   26: 147
    //                   34: 159
    //                   42: 171
    //                   50: 183
    //                   58: 195;
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
        if (result_ == com.google.analytics.midtier.proto.containertag.tDefaultInstance())
        {
            result_ = com.google.analytics.midtier.proto.containertag.wMessage();
        }
        bitField0_ = bitField0_ | 1;
        codedinputstream.readMessage(result_, extensionregistrylite);
        continue; /* Loop/switch isn't completed */
_L2:
        codedoutputstream.flush();
        unknownFields = lvedrule.ring();
        return true;
_L4:
        flag = true;
        if (true) goto _L13; else goto _L12
_L13:
        break MISSING_BLOCK_LABEL_17;
_L12:
    }

    public unknownFields newMessageForType()
    {
        return new <init>();
    }

    public volatile MutableMessageLite newMessageForType()
    {
        return newMessageForType();
    }

    public ionCall setAddMacros(int i, ionCall ioncall)
    {
        assertMutable();
        if (ioncall == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureAddMacrosInitialized();
            addMacros_.set(i, ioncall);
            return this;
        }
    }

    public ionCall setAddTags(int i, ionCall ioncall)
    {
        assertMutable();
        if (ioncall == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureAddTagsInitialized();
            addTags_.set(i, ioncall);
            return this;
        }
    }

    public ionCall setNegativePredicates(int i, ionCall ioncall)
    {
        assertMutable();
        if (ioncall == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureNegativePredicatesInitialized();
            negativePredicates_.set(i, ioncall);
            return this;
        }
    }

    public ionCall setPositivePredicates(int i, ionCall ioncall)
    {
        assertMutable();
        if (ioncall == null)
        {
            throw new NullPointerException();
        } else
        {
            ensurePositivePredicatesInitialized();
            positivePredicates_.set(i, ioncall);
            return this;
        }
    }

    public ionCall setRemoveMacros(int i, ionCall ioncall)
    {
        assertMutable();
        if (ioncall == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureRemoveMacrosInitialized();
            removeMacros_.set(i, ioncall);
            return this;
        }
    }

    public ionCall setRemoveTags(int i, ionCall ioncall)
    {
        assertMutable();
        if (ioncall == null)
        {
            throw new NullPointerException();
        } else
        {
            ensureRemoveTagsInitialized();
            removeTags_.set(i, ioncall);
            return this;
        }
    }

    public Value setResult(com.google.analytics.midtier.proto.containertag.gs_ gs_)
    {
        assertMutable();
        if (gs_ == null)
        {
            throw new NullPointerException();
        } else
        {
            bitField0_ = bitField0_ | 1;
            result_ = gs_;
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
        defaultInstance.makeImmutable();
        PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    }

    private Value()
    {
        positivePredicates_ = null;
        negativePredicates_ = null;
        addTags_ = null;
        removeTags_ = null;
        addMacros_ = null;
        removeMacros_ = null;
        initFields();
    }

    private initFields(boolean flag)
    {
        positivePredicates_ = null;
        negativePredicates_ = null;
        addTags_ = null;
        removeTags_ = null;
        addMacros_ = null;
        removeMacros_ = null;
    }
}
