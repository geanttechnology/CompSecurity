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

    public static Parser PARSER;
    public static final int RESOURCE_FIELD_NUMBER = 2;
    private static final defaultInstance defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private defaultInstance resource_;

    private void ensureResourceInitialized()
    {
        if (resource_ == ltInstance())
        {
            resource_ = ge();
        }
    }

    public static ge getDefaultInstance()
    {
        return defaultInstance;
    }

    private void initFields()
    {
        resource_ = ltInstance();
    }

    public static ltInstance newMessage()
    {
        return new <init>();
    }

    public <init> clear()
    {
        assertMutable();
        super.clear();
        if (resource_ != ltInstance())
        {
            resource_.resource_();
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

    public clear clearResource()
    {
        assertMutable();
        bitField0_ = bitField0_ & -2;
        if (resource_ != ltInstance())
        {
            resource_.resource_();
        }
        return this;
    }

    public resource_ clone()
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
        if (true && hasResource() == ((hasResource) (obj)).hasResource())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (hasResource())
        {
            if (flag && getResource().getResource(((getResource) (obj)).getResource()))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        return flag1;
    }

    public final getResource getDefaultInstanceForType()
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

    public getDefaultInstanceForType getMutableResource()
    {
        assertMutable();
        ensureResourceInitialized();
        bitField0_ = bitField0_ | 1;
        return resource_;
    }

    public Parser getParserForType()
    {
        return PARSER;
    }

    public PARSER getResource()
    {
        return resource_;
    }

    public int getSerializedSize()
    {
        int i = 0;
        if ((bitField0_ & 1) == 1)
        {
            i = 0 + CodedOutputStream.computeMessageSize(2, resource_);
        }
        i += unknownFields.size();
        cachedSize = i;
        return i;
    }

    public boolean hasResource()
    {
        return (bitField0_ & 1) == 1;
    }

    public int hashCode()
    {
        int i = 41;
        if (hasResource())
        {
            i = 0x13a7b + getResource().();
        }
        return i * 29 + unknownFields.hashCode();
    }

    protected MessageLite internalImmutableDefault()
    {
        if (immutableDefault == null)
        {
            immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Serving$OptionalResource");
        }
        return immutableDefault;
    }

    public final boolean isInitialized()
    {
        return !hasResource() || getResource().lized();
    }

    public lized mergeFrom(lized lized)
    {
        if (this == lized)
        {
            throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
        }
        assertMutable();
        if (lized == getDefaultInstance())
        {
            return this;
        }
        if (lized.hasResource())
        {
            ensureResourceInitialized();
            resource_.m(lized.getResource());
            bitField0_ = bitField0_ | 1;
        }
        unknownFields = unknownFields.concat(lized.unknownFields);
        return this;
    }

    public volatile GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedmutablemessagelite)
    {
        return mergeFrom((mergeFrom)generatedmutablemessagelite);
    }

    public boolean mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
    {
        assertMutable();
        com.google.tagmanager.protobuf.Resource resource;
        CodedOutputStream codedoutputstream;
        boolean flag;
        int i;
        try
        {
            resource = ByteString.newOutput();
            codedoutputstream = CodedOutputStream.newInstance(resource);
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
        JVM INSTR lookupswitch 2: default 129
    //                   0: 132
    //                   18: 75;
           goto _L3 _L4 _L5
_L3:
        if (!parseUnknownField(codedinputstream, codedoutputstream, extensionregistrylite, i))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (resource_ == ltInstance())
        {
            resource_ = ge();
        }
        bitField0_ = bitField0_ | 1;
        codedinputstream.readMessage(resource_, extensionregistrylite);
        continue; /* Loop/switch isn't completed */
_L2:
        codedoutputstream.flush();
        unknownFields = resource.unknownFields();
        return true;
_L4:
        flag = true;
        if (true) goto _L7; else goto _L6
_L7:
        break MISSING_BLOCK_LABEL_17;
_L6:
    }

    public unknownFields newMessageForType()
    {
        return new <init>();
    }

    public volatile MutableMessageLite newMessageForType()
    {
        return newMessageForType();
    }

    public newMessageForType setResource(newMessageForType newmessagefortype)
    {
        assertMutable();
        if (newmessagefortype == null)
        {
            throw new NullPointerException();
        } else
        {
            bitField0_ = bitField0_ | 1;
            resource_ = newmessagefortype;
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
            codedoutputstream.writeMessageWithCachedSizes(2, resource_);
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

    private ()
    {
        initFields();
    }

    private initFields(boolean flag)
    {
    }
}
