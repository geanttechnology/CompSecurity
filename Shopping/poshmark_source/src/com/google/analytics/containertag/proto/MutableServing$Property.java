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

// Referenced classes of package com.google.analytics.containertag.proto:
//            MutableServing

public static final class initFields extends GeneratedMutableMessageLite
    implements MutableMessageLite
{

    public static final int KEY_FIELD_NUMBER = 1;
    public static Parser PARSER;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final defaultInstance defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private int key_;
    private int value_;

    public static initFields getDefaultInstance()
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

    public <init> clear()
    {
        assertMutable();
        super.clear();
        key_ = 0;
        bitField0_ = bitField0_ & -2;
        value_ = 0;
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

    public clear clearKey()
    {
        assertMutable();
        bitField0_ = bitField0_ & -2;
        key_ = 0;
        return this;
    }

    public key_ clearValue()
    {
        assertMutable();
        bitField0_ = bitField0_ & -3;
        value_ = 0;
        return this;
    }

    public value_ clone()
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
        if (true && hasKey() == ((hasKey) (obj)).hasKey())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (hasKey())
        {
            if (flag && getKey() == ((getKey) (obj)).getKey())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1 && hasValue() == ((hasValue) (obj)).hasValue())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        flag3 = flag2;
        if (hasValue())
        {
            if (flag2 && getValue() == ((getValue) (obj)).getValue())
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
        }
        return flag3;
    }

    public final getValue getDefaultInstanceForType()
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

    public int getKey()
    {
        return key_;
    }

    public Parser getParserForType()
    {
        return PARSER;
    }

    public int getSerializedSize()
    {
        int i = 0 + CodedOutputStream.computeInt32Size(1, key_) + CodedOutputStream.computeInt32Size(2, value_) + unknownFields.size();
        cachedSize = i;
        return i;
    }

    public int getValue()
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
            i = 0x13a46 + getKey();
        }
        int j = i;
        if (hasValue())
        {
            j = (i * 37 + 2) * 53 + getValue();
        }
        return j * 29 + unknownFields.hashCode();
    }

    protected MessageLite internalImmutableDefault()
    {
        if (immutableDefault == null)
        {
            immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$Property");
        }
        return immutableDefault;
    }

    public final boolean isInitialized()
    {
        while (!hasKey() || !hasValue()) 
        {
            return false;
        }
        return true;
    }

    public hasValue mergeFrom(hasValue hasvalue)
    {
        if (this == hasvalue)
        {
            throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
        }
        assertMutable();
        if (hasvalue == getDefaultInstance())
        {
            return this;
        }
        if (hasvalue.hasKey())
        {
            setKey(hasvalue.getKey());
        }
        if (hasvalue.hasValue())
        {
            setValue(hasvalue.getValue());
        }
        unknownFields = unknownFields.concat(hasvalue.unknownFields);
        return this;
    }

    public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
    {
        return mergeFrom((mergeFrom)generatedmutablemessagelite);
    }

    public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
    {
        assertMutable();
        com.google.tagmanager.protobuf.Property property;
        CodedOutputStream codedoutputstream;
        boolean flag;
        int i;
        try
        {
            property = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(property);
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
        JVM INSTR lookupswitch 3: default 140
    //                   0: 143
    //                   8: 83
    //                   16: 104;
           goto _L3 _L4 _L5 _L6
_L3:
        if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        bitField0_ = bitField0_ | 1;
        key_ = codedinputstream.readInt32();
        continue; /* Loop/switch isn't completed */
_L6:
        bitField0_ = bitField0_ | 2;
        value_ = codedinputstream.readInt32();
        continue; /* Loop/switch isn't completed */
_L2:
        codedoutputstream.flush();
        unknownFields = property.String();
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

    public newMessageForType setKey(int i)
    {
        assertMutable();
        bitField0_ = bitField0_ | 1;
        key_ = i;
        return this;
    }

    public key_ setValue(int i)
    {
        assertMutable();
        bitField0_ = bitField0_ | 2;
        value_ = i;
        return this;
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
        codedoutputstream.writeInt32(1, key_);
        codedoutputstream.writeInt32(2, value_);
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
        defaultInstance.makeImmutable();
        PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    }

    private ()
    {
        initFields();
    }

    private initFields(boolean flag)
    {
    }
}
