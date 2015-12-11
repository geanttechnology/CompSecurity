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
import java.util.Arrays;

// Referenced classes of package com.google.analytics.containertag.proto:
//            MutableDebug

public static final class key_ extends GeneratedMutableMessageLite
    implements MutableMessageLite
{

    public static final int KEY_FIELD_NUMBER = 1;
    public static Parser PARSER;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final defaultInstance defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private Object key_;
    private com.google.analytics.midtier.proto.containertag.nstance value_;

    private void ensureValueInitialized()
    {
        if (value_ == com.google.analytics.midtier.proto.containertag.aultInstance())
        {
            value_ = com.google.analytics.midtier.proto.containertag.sage();
        }
    }

    public static e.newMessage getDefaultInstance()
    {
        return defaultInstance;
    }

    private void initFields()
    {
        value_ = com.google.analytics.midtier.proto.containertag.aultInstance();
    }

    public static e.getDefaultInstance newMessage()
    {
        return new <init>();
    }

    public <init> clear()
    {
        assertMutable();
        super.clear();
        key_ = Internal.EMPTY_BYTE_ARRAY;
        bitField0_ = bitField0_ & -2;
        if (value_ != com.google.analytics.midtier.proto.containertag.aultInstance())
        {
            value_.aultInstance();
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

    public clear clearKey()
    {
        assertMutable();
        bitField0_ = bitField0_ & -2;
        key_ = Internal.EMPTY_BYTE_ARRAY;
        return this;
    }

    public key_ clearValue()
    {
        assertMutable();
        bitField0_ = bitField0_ & -3;
        if (value_ != com.google.analytics.midtier.proto.containertag.aultInstance())
        {
            value_.aultInstance();
        }
        return this;
    }

    public e.clear clone()
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
            if (flag && getKey().equals(((getKey) (obj)).getKey()))
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
            if (flag2 && getValue().(((e.equals) (obj)).getValue()))
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

    public com.google.analytics.midtier.proto.containertag.ltInstanceForType getMutableValue()
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

    public com.google.analytics.midtier.proto.containertag.ze getValue()
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
            j = (i * 37 + 2) * 53 + getValue().de();
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
        return !hasValue() || getValue().ialized();
    }

    public e.isInitialized mergeFrom(e.isInitialized isinitialized)
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
        if (isinitialized.hasKey())
        {
            bitField0_ = bitField0_ | 1;
            if (isinitialized.key_ instanceof String)
            {
                key_ = isinitialized.key_;
            } else
            {
                byte abyte0[] = (byte[])(byte[])isinitialized.key_;
                key_ = Arrays.copyOf(abyte0, abyte0.length);
            }
        }
        if (isinitialized.hasValue())
        {
            ensureValueInitialized();
            value_.rom(isinitialized.getValue());
            bitField0_ = bitField0_ | 2;
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
        JVM INSTR lookupswitch 3: default 158
    //                   0: 161
    //                   10: 83
    //                   18: 104;
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
        if (value_ == com.google.analytics.midtier.proto.containertag.aultInstance())
        {
            value_ = com.google.analytics.midtier.proto.containertag.sage();
        }
        bitField0_ = bitField0_ | 2;
        codedinputstream.readMessage(value_, extensionregistrylite);
        continue; /* Loop/switch isn't completed */
_L2:
        codedoutputstream.flush();
        unknownFields = property.();
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

    public newMessageForType setKey(String s)
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

    public key_ setKeyAsBytes(byte abyte0[])
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

    public e setValue(com.google.analytics.midtier.proto.containertag._cls0_ _pcls0_)
    {
        assertMutable();
        if (_pcls0_ == null)
        {
            throw new NullPointerException();
        } else
        {
            bitField0_ = bitField0_ | 2;
            value_ = _pcls0_;
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
        defaultInstance = new <init>(true);
        defaultInstance.initFields();
        defaultInstance.makeImmutable();
        PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    }

    private e()
    {
        key_ = Internal.EMPTY_BYTE_ARRAY;
        initFields();
    }

    private initFields(boolean flag)
    {
        key_ = Internal.EMPTY_BYTE_ARRAY;
    }
}
