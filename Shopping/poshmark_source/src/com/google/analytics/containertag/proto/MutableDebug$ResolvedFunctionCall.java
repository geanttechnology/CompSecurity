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

// Referenced classes of package com.google.analytics.containertag.proto:
//            MutableDebug

public static final class associatedRuleName_ extends GeneratedMutableMessageLite
    implements MutableMessageLite
{

    public static final int ASSOCIATED_RULE_NAME_FIELD_NUMBER = 3;
    public static Parser PARSER;
    public static final int PROPERTIES_FIELD_NUMBER = 1;
    public static final int RESULT_FIELD_NUMBER = 2;
    private static final defaultInstance defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private Object associatedRuleName_;
    private int bitField0_;
    private List properties_;
    private com.google.analytics.midtier.proto.containertag.nstance result_;

    private void ensurePropertiesInitialized()
    {
        if (properties_ == null)
        {
            properties_ = new ArrayList();
        }
    }

    private void ensureResultInitialized()
    {
        if (result_ == com.google.analytics.midtier.proto.containertag.Instance())
        {
            result_ = com.google.analytics.midtier.proto.containertag.();
        }
    }

    public static wMessage getDefaultInstance()
    {
        return defaultInstance;
    }

    private void initFields()
    {
        result_ = com.google.analytics.midtier.proto.containertag.Instance();
    }

    public static tDefaultInstance newMessage()
    {
        return new <init>();
    }

    public <init> addAllProperties(Iterable iterable)
    {
        assertMutable();
        ensurePropertiesInitialized();
        AbstractMutableMessageLite.addAll(iterable, properties_);
        return this;
    }

    public properties_ addProperties(properties_ properties_1)
    {
        assertMutable();
        if (properties_1 == null)
        {
            throw new NullPointerException();
        } else
        {
            ensurePropertiesInitialized();
            properties_.add(properties_1);
            return this;
        }
    }

    public properties_ addProperties()
    {
        assertMutable();
        ensurePropertiesInitialized();
        properties_ properties_1 = essage();
        properties_.add(properties_1);
        return properties_1;
    }

    public properties_ clear()
    {
        assertMutable();
        super.clear();
        properties_ = null;
        if (result_ != com.google.analytics.midtier.proto.containertag.Instance())
        {
            result_.Instance();
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

    public clear clearAssociatedRuleName()
    {
        assertMutable();
        bitField0_ = bitField0_ & -3;
        associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
        return this;
    }

    public associatedRuleName_ clearProperties()
    {
        assertMutable();
        properties_ = null;
        return this;
    }

    public properties_ clearResult()
    {
        assertMutable();
        bitField0_ = bitField0_ & -2;
        if (result_ != com.google.analytics.midtier.proto.containertag.Instance())
        {
            result_.Instance();
        }
        return this;
    }

    public ear clone()
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
        boolean flag3;
        if (true && getPropertiesList().equals(((getPropertiesList) (obj)).getPropertiesList()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && hasResult() == ((hasResult) (obj)).hasResult())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (hasResult())
        {
            if (flag && getResult().t(((uals) (obj)).getResult()))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1 && hasAssociatedRuleName() == ((hasAssociatedRuleName) (obj)).hasAssociatedRuleName())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        flag3 = flag2;
        if (hasAssociatedRuleName())
        {
            if (flag2 && getAssociatedRuleName().equals(((getAssociatedRuleName) (obj)).getAssociatedRuleName()))
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

    public final associatedRuleName_ getDefaultInstanceForType()
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

    public getDefaultInstanceForType getMutableProperties(int i)
    {
        return (getDefaultInstanceForType)properties_.get(i);
    }

    public List getMutablePropertiesList()
    {
        assertMutable();
        ensurePropertiesInitialized();
        return properties_;
    }

    public com.google.analytics.midtier.proto.containertag.es_ getMutableResult()
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

    public PARSER getProperties(int i)
    {
        return (PARSER)properties_.get(i);
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

    public com.google.analytics.midtier.proto.containertag.es_ getResult()
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
            i = (j * 37 + 2) * 53 + getResult().t();
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
        if (getProperties(i).itialized()) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (hasResult() && !getResult().zed()) goto _L3; else goto _L5
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
        if (initialized.properties_ != null && !initialized.properties_.isEmpty())
        {
            ensurePropertiesInitialized();
            AbstractMutableMessageLite.addAll(initialized.properties_, properties_);
        }
        if (initialized.hasResult())
        {
            ensureResultInitialized();
            result_.sultInitialized(initialized.getResult());
            bitField0_ = bitField0_ | 1;
        }
        if (initialized.hasAssociatedRuleName())
        {
            bitField0_ = bitField0_ | 2;
            if (initialized.associatedRuleName_ instanceof String)
            {
                associatedRuleName_ = initialized.associatedRuleName_;
            } else
            {
                byte abyte0[] = (byte[])(byte[])initialized.associatedRuleName_;
                associatedRuleName_ = Arrays.copyOf(abyte0, abyte0.length);
            }
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
        com.google.tagmanager.protobuf.tionCall tioncall;
        CodedOutputStream codedoutputstream;
        boolean flag;
        int i;
        try
        {
            tioncall = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(tioncall);
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
    //                   0: 181
    //                   10: 91
    //                   18: 103
    //                   26: 142;
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
        if (result_ == com.google.analytics.midtier.proto.containertag.Instance())
        {
            result_ = com.google.analytics.midtier.proto.containertag.();
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
        unknownFields = tioncall.unknownFields();
        return true;
_L4:
        flag = true;
        if (true) goto _L9; else goto _L8
_L9:
        break MISSING_BLOCK_LABEL_17;
_L8:
    }

    public unknownFields newMessageForType()
    {
        return new <init>();
    }

    public volatile MutableMessageLite newMessageForType()
    {
        return newMessageForType();
    }

    public newMessageForType setAssociatedRuleName(String s)
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

    public associatedRuleName_ setAssociatedRuleNameAsBytes(byte abyte0[])
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

    public associatedRuleName_ setProperties(int i, associatedRuleName_ associatedrulename_)
    {
        assertMutable();
        if (associatedrulename_ == null)
        {
            throw new NullPointerException();
        } else
        {
            ensurePropertiesInitialized();
            properties_.set(i, associatedrulename_);
            return this;
        }
    }

    public properties_ setResult(com.google.analytics.midtier.proto.containertag.es_ es_)
    {
        assertMutable();
        if (es_ == null)
        {
            throw new NullPointerException();
        } else
        {
            bitField0_ = bitField0_ | 1;
            result_ = es_;
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
        defaultInstance.makeImmutable();
        PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    }

    private ()
    {
        properties_ = null;
        associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
        initFields();
    }

    private initFields(boolean flag)
    {
        properties_ = null;
        associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
    }
}
