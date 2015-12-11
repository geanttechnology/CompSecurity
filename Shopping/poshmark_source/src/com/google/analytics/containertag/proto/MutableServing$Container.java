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
//            MutableServing

public static final class version_ extends GeneratedMutableMessageLite
    implements MutableMessageLite
{

    public static final int CONTAINER_ID_FIELD_NUMBER = 3;
    public static final int JS_RESOURCE_FIELD_NUMBER = 1;
    public static Parser PARSER;
    public static final int STATE_FIELD_NUMBER = 4;
    public static final int VERSION_FIELD_NUMBER = 5;
    private static final defaultInstance defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private Object containerId_;
    private defaultInstance jsResource_;
    private ate state_;
    private Object version_;

    private void ensureJsResourceInitialized()
    {
        if (jsResource_ == etDefaultInstance())
        {
            jsResource_ = ewMessage();
        }
    }

    public static ewMessage getDefaultInstance()
    {
        return defaultInstance;
    }

    private void initFields()
    {
        jsResource_ = etDefaultInstance();
        state_ = ate.PREVIEW;
    }

    public static ate.PREVIEW newMessage()
    {
        return new <init>();
    }

    public <init> clear()
    {
        assertMutable();
        super.clear();
        if (jsResource_ != etDefaultInstance())
        {
            jsResource_.lear();
        }
        bitField0_ = bitField0_ & -2;
        containerId_ = Internal.EMPTY_BYTE_ARRAY;
        bitField0_ = bitField0_ & -3;
        state_ = ate.PREVIEW;
        bitField0_ = bitField0_ & -5;
        version_ = Internal.EMPTY_BYTE_ARRAY;
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

    public clear clearContainerId()
    {
        assertMutable();
        bitField0_ = bitField0_ & -3;
        containerId_ = Internal.EMPTY_BYTE_ARRAY;
        return this;
    }

    public containerId_ clearJsResource()
    {
        assertMutable();
        bitField0_ = bitField0_ & -2;
        if (jsResource_ != etDefaultInstance())
        {
            jsResource_.lear();
        }
        return this;
    }

    public lear clearState()
    {
        assertMutable();
        bitField0_ = bitField0_ & -5;
        state_ = ate.PREVIEW;
        return this;
    }

    public ate.PREVIEW clearVersion()
    {
        assertMutable();
        bitField0_ = bitField0_ & -9;
        version_ = Internal.EMPTY_BYTE_ARRAY;
        return this;
    }

    public version_ clone()
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
        if (true && hasJsResource() == ((hasJsResource) (obj)).hasJsResource())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (hasJsResource())
        {
            if (flag && getJsResource().quals(((quals) (obj)).getJsResource()))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1 && hasContainerId() == ((hasContainerId) (obj)).hasContainerId())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (hasContainerId())
        {
            if (flag && getContainerId().equals(((getContainerId) (obj)).getContainerId()))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1 && hasState() == ((hasState) (obj)).hasState())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (hasState())
        {
            if (flag && getState() == ((getState) (obj)).getState())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1 && hasVersion() == ((hasVersion) (obj)).hasVersion())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        flag3 = flag2;
        if (hasVersion())
        {
            if (flag2 && getVersion().equals(((getVersion) (obj)).getVersion()))
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
        }
        return flag3;
    }

    public String getContainerId()
    {
        Object obj = containerId_;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        byte abyte0[] = (byte[])(byte[])obj;
        String s = Internal.toStringUtf8(abyte0);
        if (Internal.isValidUtf8(abyte0))
        {
            containerId_ = s;
        }
        return s;
    }

    public byte[] getContainerIdAsBytes()
    {
        byte abyte0[] = ((byte []) (containerId_));
        if (abyte0 instanceof String)
        {
            abyte0 = Internal.toByteArray((String)abyte0);
            containerId_ = abyte0;
            return abyte0;
        } else
        {
            return (byte[])(byte[])abyte0;
        }
    }

    public final containerId_ getDefaultInstanceForType()
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

    public getDefaultInstanceForType getJsResource()
    {
        return jsResource_;
    }

    public jsResource_ getMutableJsResource()
    {
        assertMutable();
        ensureJsResourceInitialized();
        bitField0_ = bitField0_ | 1;
        return jsResource_;
    }

    public Parser getParserForType()
    {
        return PARSER;
    }

    public int getSerializedSize()
    {
        int j = 0 + CodedOutputStream.computeMessageSize(1, jsResource_) + CodedOutputStream.computeByteArraySize(3, getContainerIdAsBytes()) + CodedOutputStream.computeEnumSize(4, state_.getNumber());
        int i = j;
        if ((bitField0_ & 8) == 8)
        {
            i = j + CodedOutputStream.computeByteArraySize(5, getVersionAsBytes());
        }
        i += unknownFields.size();
        cachedSize = i;
        return i;
    }

    public ate getState()
    {
        return state_;
    }

    public String getVersion()
    {
        Object obj = version_;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        byte abyte0[] = (byte[])(byte[])obj;
        String s = Internal.toStringUtf8(abyte0);
        if (Internal.isValidUtf8(abyte0))
        {
            version_ = s;
        }
        return s;
    }

    public byte[] getVersionAsBytes()
    {
        byte abyte0[] = ((byte []) (version_));
        if (abyte0 instanceof String)
        {
            abyte0 = Internal.toByteArray((String)abyte0);
            version_ = abyte0;
            return abyte0;
        } else
        {
            return (byte[])(byte[])abyte0;
        }
    }

    public boolean hasContainerId()
    {
        return (bitField0_ & 2) == 2;
    }

    public boolean hasJsResource()
    {
        return (bitField0_ & 1) == 1;
    }

    public boolean hasState()
    {
        return (bitField0_ & 4) == 4;
    }

    public boolean hasVersion()
    {
        return (bitField0_ & 8) == 8;
    }

    public int hashCode()
    {
        int j = 41;
        if (hasJsResource())
        {
            j = 0x13a46 + getJsResource().ashCode();
        }
        int i = j;
        if (hasContainerId())
        {
            i = (j * 37 + 3) * 53 + getContainerId().hashCode();
        }
        j = i;
        if (hasState())
        {
            j = (i * 37 + 4) * 53 + Internal.hashEnum(getState());
        }
        i = j;
        if (hasVersion())
        {
            i = (j * 37 + 5) * 53 + getVersion().hashCode();
        }
        return i * 29 + unknownFields.hashCode();
    }

    protected MessageLite internalImmutableDefault()
    {
        if (immutableDefault == null)
        {
            immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$Container");
        }
        return immutableDefault;
    }

    public final boolean isInitialized()
    {
        while (!hasJsResource() || !hasContainerId() || !hasState() || !getJsResource().sInitialized()) 
        {
            return false;
        }
        return true;
    }

    public sInitialized mergeFrom(sInitialized sinitialized)
    {
        if (this == sinitialized)
        {
            throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
        }
        assertMutable();
        if (sinitialized == getDefaultInstance())
        {
            return this;
        }
        if (sinitialized.hasJsResource())
        {
            ensureJsResourceInitialized();
            jsResource_.ergeFrom(sinitialized.getJsResource());
            bitField0_ = bitField0_ | 1;
        }
        if (sinitialized.hasContainerId())
        {
            bitField0_ = bitField0_ | 2;
            if (sinitialized.containerId_ instanceof String)
            {
                containerId_ = sinitialized.containerId_;
            } else
            {
                byte abyte0[] = (byte[])(byte[])sinitialized.containerId_;
                containerId_ = Arrays.copyOf(abyte0, abyte0.length);
            }
        }
        if (sinitialized.hasState())
        {
            setState(sinitialized.getState());
        }
        if (sinitialized.hasVersion())
        {
            bitField0_ = bitField0_ | 8;
            if (sinitialized.version_ instanceof String)
            {
                version_ = sinitialized.version_;
            } else
            {
                byte abyte1[] = (byte[])(byte[])sinitialized.version_;
                version_ = Arrays.copyOf(abyte1, abyte1.length);
            }
        }
        unknownFields = unknownFields.concat(sinitialized.unknownFields);
        return this;
    }

    public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
    {
        return mergeFrom((mergeFrom)generatedmutablemessagelite);
    }

    public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
    {
        assertMutable();
        com.google.tagmanager.protobuf.ontainer ontainer;
        CodedOutputStream codedoutputstream;
        ate ate;
        boolean flag;
        int i;
        int j;
        try
        {
            ontainer = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(ontainer);
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
        JVM INSTR lookupswitch 5: default 250
    //                   0: 253
    //                   10: 99
    //                   26: 138
    //                   32: 159
    //                   42: 213;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (jsResource_ == etDefaultInstance())
        {
            jsResource_ = ewMessage();
        }
        bitField0_ = bitField0_ | 1;
        codedinputstream.readMessage(jsResource_, extensionregistrylite);
        continue; /* Loop/switch isn't completed */
_L6:
        bitField0_ = bitField0_ | 2;
        containerId_ = codedinputstream.readByteArray();
        continue; /* Loop/switch isn't completed */
_L7:
        j = codedinputstream.readEnum();
        ate = com.google.analytics.containertag.proto.ate.valueOf(j);
        if (ate != null) goto _L10; else goto _L9
_L9:
        codedoutputstream.writeRawVarint32(i);
        codedoutputstream.writeRawVarint32(j);
        continue; /* Loop/switch isn't completed */
_L10:
        bitField0_ = bitField0_ | 4;
        state_ = ate;
        continue; /* Loop/switch isn't completed */
_L8:
        bitField0_ = bitField0_ | 8;
        version_ = codedinputstream.readByteArray();
        continue; /* Loop/switch isn't completed */
_L2:
        codedoutputstream.flush();
        unknownFields = ontainer.tring();
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

    public newMessageForType setContainerId(String s)
    {
        assertMutable();
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            bitField0_ = bitField0_ | 2;
            containerId_ = s;
            return this;
        }
    }

    public containerId_ setContainerIdAsBytes(byte abyte0[])
    {
        assertMutable();
        if (abyte0 == null)
        {
            throw new NullPointerException();
        } else
        {
            bitField0_ = bitField0_ | 2;
            containerId_ = abyte0;
            return this;
        }
    }

    public containerId_ setJsResource(containerId_ containerid_)
    {
        assertMutable();
        if (containerid_ == null)
        {
            throw new NullPointerException();
        } else
        {
            bitField0_ = bitField0_ | 1;
            jsResource_ = containerid_;
            return this;
        }
    }

    public ate setState(ate ate)
    {
        assertMutable();
        if (ate == null)
        {
            throw new NullPointerException();
        } else
        {
            bitField0_ = bitField0_ | 4;
            state_ = ate;
            return this;
        }
    }

    public state_ setVersion(String s)
    {
        assertMutable();
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            bitField0_ = bitField0_ | 8;
            version_ = s;
            return this;
        }
    }

    public version_ setVersionAsBytes(byte abyte0[])
    {
        assertMutable();
        if (abyte0 == null)
        {
            throw new NullPointerException();
        } else
        {
            bitField0_ = bitField0_ | 8;
            version_ = abyte0;
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
        codedoutputstream.writeMessageWithCachedSizes(1, jsResource_);
        codedoutputstream.writeByteArray(3, getContainerIdAsBytes());
        codedoutputstream.writeEnum(4, state_.getNumber());
        if ((bitField0_ & 8) == 8)
        {
            codedoutputstream.writeByteArray(5, getVersionAsBytes());
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

    private ate()
    {
        containerId_ = Internal.EMPTY_BYTE_ARRAY;
        state_ = ate.PREVIEW;
        version_ = Internal.EMPTY_BYTE_ARRAY;
        initFields();
    }

    private initFields(boolean flag)
    {
        containerId_ = Internal.EMPTY_BYTE_ARRAY;
        state_ = ate.PREVIEW;
        version_ = Internal.EMPTY_BYTE_ARRAY;
    }
}
