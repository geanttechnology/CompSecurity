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

// Referenced classes of package com.google.analytics.containertag.proto:
//            MutableServing

public static final class CacheLevel.NO_CACHE extends GeneratedMutableMessageLite
    implements MutableMessageLite
{
    public static final class CacheLevel extends Enum
        implements com.google.tagmanager.protobuf.Internal.EnumLite
    {

        private static final CacheLevel $VALUES[];
        public static final CacheLevel NO_CACHE;
        public static final int NO_CACHE_VALUE = 1;
        public static final CacheLevel PRIVATE;
        public static final int PRIVATE_VALUE = 2;
        public static final CacheLevel PUBLIC;
        public static final int PUBLIC_VALUE = 3;
        private static com.google.tagmanager.protobuf.Internal.EnumLiteMap internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

            public CacheLevel findValueByNumber(int i)
            {
                return CacheLevel.valueOf(i);
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

        public static CacheLevel valueOf(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return NO_CACHE;

            case 2: // '\002'
                return PRIVATE;

            case 3: // '\003'
                return PUBLIC;
            }
        }

        public static CacheLevel valueOf(String s)
        {
            return (CacheLevel)Enum.valueOf(com/google/analytics/containertag/proto/MutableServing$CacheOption$CacheLevel, s);
        }

        public static CacheLevel[] values()
        {
            return (CacheLevel[])$VALUES.clone();
        }

        public final int getNumber()
        {
            return value;
        }

        static 
        {
            NO_CACHE = new CacheLevel("NO_CACHE", 0, 0, 1);
            PRIVATE = new CacheLevel("PRIVATE", 1, 1, 2);
            PUBLIC = new CacheLevel("PUBLIC", 2, 2, 3);
            $VALUES = (new CacheLevel[] {
                NO_CACHE, PRIVATE, PUBLIC
            });
        }

        private CacheLevel(String s, int i, int j, int k)
        {
            super(s, i);
            value = k;
        }
    }


    public static final int EXPIRATION_SECONDS_FIELD_NUMBER = 2;
    public static final int GCACHE_EXPIRATION_SECONDS_FIELD_NUMBER = 3;
    public static final int LEVEL_FIELD_NUMBER = 1;
    public static Parser PARSER;
    private static final defaultInstance defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private int expirationSeconds_;
    private int gcacheExpirationSeconds_;
    private CacheLevel level_;

    public static CacheLevel._cls1.findValueByNumber getDefaultInstance()
    {
        return defaultInstance;
    }

    private void initFields()
    {
        level_ = CacheLevel.NO_CACHE;
    }

    public static CacheLevel.NO_CACHE newMessage()
    {
        return new <init>();
    }

    public <init> clear()
    {
        assertMutable();
        super.clear();
        level_ = CacheLevel.NO_CACHE;
        bitField0_ = bitField0_ & -2;
        expirationSeconds_ = 0;
        bitField0_ = bitField0_ & -3;
        gcacheExpirationSeconds_ = 0;
        bitField0_ = bitField0_ & -5;
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

    public clear clearExpirationSeconds()
    {
        assertMutable();
        bitField0_ = bitField0_ & -3;
        expirationSeconds_ = 0;
        return this;
    }

    public expirationSeconds_ clearGcacheExpirationSeconds()
    {
        assertMutable();
        bitField0_ = bitField0_ & -5;
        gcacheExpirationSeconds_ = 0;
        return this;
    }

    public gcacheExpirationSeconds_ clearLevel()
    {
        assertMutable();
        bitField0_ = bitField0_ & -2;
        level_ = CacheLevel.NO_CACHE;
        return this;
    }

    public CacheLevel.NO_CACHE clone()
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
        if (true && hasLevel() == ((hasLevel) (obj)).hasLevel())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (hasLevel())
        {
            if (flag && getLevel() == ((getLevel) (obj)).getLevel())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1 && hasExpirationSeconds() == ((hasExpirationSeconds) (obj)).hasExpirationSeconds())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (hasExpirationSeconds())
        {
            if (flag && getExpirationSeconds() == ((getExpirationSeconds) (obj)).getExpirationSeconds())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1 && hasGcacheExpirationSeconds() == ((hasGcacheExpirationSeconds) (obj)).hasGcacheExpirationSeconds())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        flag3 = flag2;
        if (hasGcacheExpirationSeconds())
        {
            if (flag2 && getGcacheExpirationSeconds() == ((getGcacheExpirationSeconds) (obj)).getGcacheExpirationSeconds())
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
        }
        return flag3;
    }

    public final getGcacheExpirationSeconds getDefaultInstanceForType()
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

    public int getExpirationSeconds()
    {
        return expirationSeconds_;
    }

    public int getGcacheExpirationSeconds()
    {
        return gcacheExpirationSeconds_;
    }

    public CacheLevel getLevel()
    {
        return level_;
    }

    public Parser getParserForType()
    {
        return PARSER;
    }

    public int getSerializedSize()
    {
        int j = 0;
        if ((bitField0_ & 1) == 1)
        {
            j = 0 + CodedOutputStream.computeEnumSize(1, level_.getNumber());
        }
        int i = j;
        if ((bitField0_ & 2) == 2)
        {
            i = j + CodedOutputStream.computeInt32Size(2, expirationSeconds_);
        }
        j = i;
        if ((bitField0_ & 4) == 4)
        {
            j = i + CodedOutputStream.computeInt32Size(3, gcacheExpirationSeconds_);
        }
        i = j + unknownFields.size();
        cachedSize = i;
        return i;
    }

    public boolean hasExpirationSeconds()
    {
        return (bitField0_ & 2) == 2;
    }

    public boolean hasGcacheExpirationSeconds()
    {
        return (bitField0_ & 4) == 4;
    }

    public boolean hasLevel()
    {
        return (bitField0_ & 1) == 1;
    }

    public int hashCode()
    {
        int j = 41;
        if (hasLevel())
        {
            j = 0x13a46 + Internal.hashEnum(getLevel());
        }
        int i = j;
        if (hasExpirationSeconds())
        {
            i = (j * 37 + 2) * 53 + getExpirationSeconds();
        }
        j = i;
        if (hasGcacheExpirationSeconds())
        {
            j = (i * 37 + 3) * 53 + getGcacheExpirationSeconds();
        }
        return j * 29 + unknownFields.hashCode();
    }

    protected MessageLite internalImmutableDefault()
    {
        if (immutableDefault == null)
        {
            immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$CacheOption");
        }
        return immutableDefault;
    }

    public final boolean isInitialized()
    {
        return true;
    }

    public immutableDefault mergeFrom(immutableDefault immutabledefault)
    {
        if (this == immutabledefault)
        {
            throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
        }
        assertMutable();
        if (immutabledefault == getDefaultInstance())
        {
            return this;
        }
        if (immutabledefault.hasLevel())
        {
            setLevel(immutabledefault.getLevel());
        }
        if (immutabledefault.hasExpirationSeconds())
        {
            setExpirationSeconds(immutabledefault.getExpirationSeconds());
        }
        if (immutabledefault.hasGcacheExpirationSeconds())
        {
            setGcacheExpirationSeconds(immutabledefault.getGcacheExpirationSeconds());
        }
        unknownFields = unknownFields.concat(immutabledefault.unknownFields);
        return this;
    }

    public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
    {
        return mergeFrom((mergeFrom)generatedmutablemessagelite);
    }

    public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
    {
        assertMutable();
        com.google.tagmanager.protobuf.heOption heoption;
        CodedOutputStream codedoutputstream;
        CacheLevel cachelevel;
        boolean flag;
        int i;
        int j;
        try
        {
            heoption = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(heoption);
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
        JVM INSTR lookupswitch 4: default 202
    //                   0: 205
    //                   8: 91
    //                   16: 145
    //                   24: 166;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        j = codedinputstream.readEnum();
        cachelevel = CacheLevel.valueOf(j);
        if (cachelevel != null) goto _L9; else goto _L8
_L8:
        codedoutputstream.writeRawVarint32(i);
        codedoutputstream.writeRawVarint32(j);
        continue; /* Loop/switch isn't completed */
_L9:
        bitField0_ = bitField0_ | 1;
        level_ = cachelevel;
        continue; /* Loop/switch isn't completed */
_L6:
        bitField0_ = bitField0_ | 2;
        expirationSeconds_ = codedinputstream.readInt32();
        continue; /* Loop/switch isn't completed */
_L7:
        bitField0_ = bitField0_ | 4;
        gcacheExpirationSeconds_ = codedinputstream.readInt32();
        continue; /* Loop/switch isn't completed */
_L2:
        codedoutputstream.flush();
        unknownFields = heoption.ing();
        return true;
_L4:
        flag = true;
        if (true) goto _L11; else goto _L10
_L11:
        break MISSING_BLOCK_LABEL_17;
_L10:
    }

    public unknownFields newMessageForType()
    {
        return new <init>();
    }

    public volatile MutableMessageLite newMessageForType()
    {
        return newMessageForType();
    }

    public newMessageForType setExpirationSeconds(int i)
    {
        assertMutable();
        bitField0_ = bitField0_ | 2;
        expirationSeconds_ = i;
        return this;
    }

    public expirationSeconds_ setGcacheExpirationSeconds(int i)
    {
        assertMutable();
        bitField0_ = bitField0_ | 4;
        gcacheExpirationSeconds_ = i;
        return this;
    }

    public CacheLevel setLevel(CacheLevel cachelevel)
    {
        assertMutable();
        if (cachelevel == null)
        {
            throw new NullPointerException();
        } else
        {
            bitField0_ = bitField0_ | 1;
            level_ = cachelevel;
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
            codedoutputstream.writeEnum(1, level_.getNumber());
        }
        if ((bitField0_ & 2) == 2)
        {
            codedoutputstream.writeInt32(2, expirationSeconds_);
        }
        if ((bitField0_ & 4) == 4)
        {
            codedoutputstream.writeInt32(3, gcacheExpirationSeconds_);
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

    private CacheLevel.value()
    {
        level_ = CacheLevel.NO_CACHE;
        initFields();
    }

    private initFields(boolean flag)
    {
        level_ = CacheLevel.NO_CACHE;
    }
}
