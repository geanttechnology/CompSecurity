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
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.analytics.containertag.proto:
//            MutableServing

public static final class property_ extends GeneratedMutableMessageLite
    implements MutableMessageLite
{

    public static final int FUNCTION_FIELD_NUMBER = 2;
    public static final int LIVE_ONLY_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 4;
    public static Parser PARSER;
    public static final int PROPERTY_FIELD_NUMBER = 3;
    public static final int SERVER_SIDE_FIELD_NUMBER = 1;
    private static final defaultInstance defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private int function_;
    private boolean liveOnly_;
    private int name_;
    private List property_;
    private boolean serverSide_;

    private void ensurePropertyInitialized()
    {
        if (property_ == null)
        {
            property_ = new ArrayList();
        }
    }

    public static property_ getDefaultInstance()
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

    public <init> addAllProperty(Iterable iterable)
    {
        assertMutable();
        ensurePropertyInitialized();
        AbstractMutableMessageLite.addAll(iterable, property_);
        return this;
    }

    public property_ addProperty(int i)
    {
        assertMutable();
        ensurePropertyInitialized();
        property_.add(Integer.valueOf(i));
        return this;
    }

    public property_ clear()
    {
        assertMutable();
        super.clear();
        property_ = null;
        function_ = 0;
        bitField0_ = bitField0_ & -2;
        name_ = 0;
        bitField0_ = bitField0_ & -3;
        liveOnly_ = false;
        bitField0_ = bitField0_ & -5;
        serverSide_ = false;
        bitField0_ = bitField0_ & -9;
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

    public clear clearFunction()
    {
        assertMutable();
        bitField0_ = bitField0_ & -2;
        function_ = 0;
        return this;
    }

    public function_ clearLiveOnly()
    {
        assertMutable();
        bitField0_ = bitField0_ & -5;
        liveOnly_ = false;
        return this;
    }

    public liveOnly_ clearName()
    {
        assertMutable();
        bitField0_ = bitField0_ & -3;
        name_ = 0;
        return this;
    }

    public name_ clearProperty()
    {
        assertMutable();
        property_ = null;
        return this;
    }

    public property_ clearServerSide()
    {
        assertMutable();
        bitField0_ = bitField0_ & -9;
        serverSide_ = false;
        return this;
    }

    public serverSide_ clone()
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
        if (true && getPropertyList().equals(((getPropertyList) (obj)).getPropertyList()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && hasFunction() == ((hasFunction) (obj)).hasFunction())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (hasFunction())
        {
            if (flag && getFunction() == ((getFunction) (obj)).getFunction())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1 && hasName() == ((hasName) (obj)).hasName())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (hasName())
        {
            if (flag && getName() == ((getName) (obj)).getName())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1 && hasLiveOnly() == ((hasLiveOnly) (obj)).hasLiveOnly())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (hasLiveOnly())
        {
            if (flag && getLiveOnly() == ((getLiveOnly) (obj)).getLiveOnly())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1 && hasServerSide() == ((hasServerSide) (obj)).hasServerSide())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        flag3 = flag2;
        if (hasServerSide())
        {
            if (flag2 && getServerSide() == ((getServerSide) (obj)).getServerSide())
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
        }
        return flag3;
    }

    public final getServerSide getDefaultInstanceForType()
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

    public int getFunction()
    {
        return function_;
    }

    public boolean getLiveOnly()
    {
        return liveOnly_;
    }

    public List getMutablePropertyList()
    {
        assertMutable();
        ensurePropertyInitialized();
        return property_;
    }

    public int getName()
    {
        return name_;
    }

    public Parser getParserForType()
    {
        return PARSER;
    }

    public int getProperty(int i)
    {
        return ((Integer)property_.get(i)).intValue();
    }

    public int getPropertyCount()
    {
        if (property_ == null)
        {
            return 0;
        } else
        {
            return property_.size();
        }
    }

    public List getPropertyList()
    {
        if (property_ == null)
        {
            return Collections.emptyList();
        } else
        {
            return Collections.unmodifiableList(property_);
        }
    }

    public int getSerializedSize()
    {
        int j = 0;
        int i = j;
        if (property_ != null)
        {
            i = j;
            if (property_.size() > 0)
            {
                j = 0;
                for (i = 0; i < property_.size(); i++)
                {
                    j += CodedOutputStream.computeInt32SizeNoTag(((Integer)property_.get(i)).intValue());
                }

                i = 0 + j + getPropertyList().size() * 1;
            }
        }
        j = i + CodedOutputStream.computeInt32Size(2, function_);
        i = j;
        if ((bitField0_ & 2) == 2)
        {
            i = j + CodedOutputStream.computeInt32Size(4, name_);
        }
        j = i;
        if ((bitField0_ & 4) == 4)
        {
            j = i + CodedOutputStream.computeBoolSize(6, liveOnly_);
        }
        i = j;
        if ((bitField0_ & 8) == 8)
        {
            i = j + CodedOutputStream.computeBoolSize(1, serverSide_);
        }
        i += unknownFields.size();
        cachedSize = i;
        return i;
    }

    public boolean getServerSide()
    {
        return serverSide_;
    }

    public boolean hasFunction()
    {
        return (bitField0_ & 1) == 1;
    }

    public boolean hasLiveOnly()
    {
        return (bitField0_ & 4) == 4;
    }

    public boolean hasName()
    {
        return (bitField0_ & 2) == 2;
    }

    public boolean hasServerSide()
    {
        return (bitField0_ & 8) == 8;
    }

    public int hashCode()
    {
        int j = 41;
        if (getPropertyCount() > 0)
        {
            j = 0x13ab0 + getPropertyList().hashCode();
        }
        int i = j;
        if (hasFunction())
        {
            i = (j * 37 + 2) * 53 + getFunction();
        }
        j = i;
        if (hasName())
        {
            j = (i * 37 + 4) * 53 + getName();
        }
        i = j;
        if (hasLiveOnly())
        {
            i = (j * 37 + 6) * 53 + Internal.hashBoolean(getLiveOnly());
        }
        j = i;
        if (hasServerSide())
        {
            j = (i * 37 + 1) * 53 + Internal.hashBoolean(getServerSide());
        }
        return j * 29 + unknownFields.hashCode();
    }

    protected MessageLite internalImmutableDefault()
    {
        if (immutableDefault == null)
        {
            immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$FunctionCall");
        }
        return immutableDefault;
    }

    public final boolean isInitialized()
    {
        return hasFunction();
    }

    public hasFunction mergeFrom(hasFunction hasfunction)
    {
        if (this == hasfunction)
        {
            throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
        }
        assertMutable();
        if (hasfunction == getDefaultInstance())
        {
            return this;
        }
        if (hasfunction.hasServerSide())
        {
            setServerSide(hasfunction.getServerSide());
        }
        if (hasfunction.hasFunction())
        {
            setFunction(hasfunction.getFunction());
        }
        if (hasfunction.property_ != null && !hasfunction.property_.isEmpty())
        {
            ensurePropertyInitialized();
            property_.addAll(hasfunction.property_);
        }
        if (hasfunction.hasName())
        {
            setName(hasfunction.getName());
        }
        if (hasfunction.hasLiveOnly())
        {
            setLiveOnly(hasfunction.getLiveOnly());
        }
        unknownFields = unknownFields.concat(hasfunction.unknownFields);
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
        JVM INSTR lookupswitch 7: default 317
    //                   0: 320
    //                   8: 115
    //                   16: 137
    //                   24: 158
    //                   26: 196
    //                   32: 260
    //                   48: 281;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L3:
        if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        bitField0_ = bitField0_ | 8;
        serverSide_ = codedinputstream.readBool();
        continue; /* Loop/switch isn't completed */
_L6:
        bitField0_ = bitField0_ | 1;
        function_ = codedinputstream.readInt32();
        continue; /* Loop/switch isn't completed */
_L7:
        if (property_ == null)
        {
            property_ = new ArrayList();
        }
        property_.add(Integer.valueOf(codedinputstream.readInt32()));
        continue; /* Loop/switch isn't completed */
_L8:
        i = codedinputstream.pushLimit(codedinputstream.readRawVarint32());
        if (property_ == null)
        {
            property_ = new ArrayList();
        }
        for (; codedinputstream.getBytesUntilLimit() > 0; property_.add(Integer.valueOf(codedinputstream.readInt32()))) { }
        codedinputstream.popLimit(i);
        continue; /* Loop/switch isn't completed */
_L9:
        bitField0_ = bitField0_ | 2;
        name_ = codedinputstream.readInt32();
        continue; /* Loop/switch isn't completed */
_L10:
        bitField0_ = bitField0_ | 4;
        liveOnly_ = codedinputstream.readBool();
        continue; /* Loop/switch isn't completed */
_L2:
        codedoutputstream.flush();
        unknownFields = tioncall.ng();
        return true;
_L4:
        flag = true;
        if (true) goto _L12; else goto _L11
_L12:
        break MISSING_BLOCK_LABEL_17;
_L11:
    }

    public unknownFields newMessageForType()
    {
        return new <init>();
    }

    public volatile MutableMessageLite newMessageForType()
    {
        return newMessageForType();
    }

    public newMessageForType setFunction(int i)
    {
        assertMutable();
        bitField0_ = bitField0_ | 1;
        function_ = i;
        return this;
    }

    public function_ setLiveOnly(boolean flag)
    {
        assertMutable();
        bitField0_ = bitField0_ | 4;
        liveOnly_ = flag;
        return this;
    }

    public liveOnly_ setName(int i)
    {
        assertMutable();
        bitField0_ = bitField0_ | 2;
        name_ = i;
        return this;
    }

    public name_ setProperty(int i, int j)
    {
        assertMutable();
        ensurePropertyInitialized();
        property_.set(i, Integer.valueOf(j));
        return this;
    }

    public property_ setServerSide(boolean flag)
    {
        assertMutable();
        bitField0_ = bitField0_ | 8;
        serverSide_ = flag;
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
        int k = codedoutputstream.getTotalBytesWritten();
        if ((bitField0_ & 8) == 8)
        {
            codedoutputstream.writeBool(1, serverSide_);
        }
        codedoutputstream.writeInt32(2, function_);
        if (property_ != null)
        {
            for (int i = 0; i < property_.size(); i++)
            {
                codedoutputstream.writeInt32(3, ((Integer)property_.get(i)).intValue());
            }

        }
        if ((bitField0_ & 2) == 2)
        {
            codedoutputstream.writeInt32(4, name_);
        }
        if ((bitField0_ & 4) == 4)
        {
            codedoutputstream.writeBool(6, liveOnly_);
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

    private I()
    {
        property_ = null;
        initFields();
    }

    private initFields(boolean flag)
    {
        property_ = null;
    }
}
