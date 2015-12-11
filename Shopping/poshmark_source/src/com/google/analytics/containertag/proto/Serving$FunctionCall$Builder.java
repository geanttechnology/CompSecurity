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
//            Serving

public static final class maybeForceBuilderInitialization extends com.google.tagmanager.protobuf..Builder
    implements 
{

    private int bitField0_;
    private int function_;
    private boolean liveOnly_;
    private int name_;
    private List property_;
    private boolean serverSide_;

    private static  create()
    {
        return new <init>();
    }

    private void ensurePropertyIsMutable()
    {
        if ((bitField0_ & 1) != 1)
        {
            property_ = new ArrayList(property_);
            bitField0_ = bitField0_ | 1;
        }
    }

    private void maybeForceBuilderInitialization()
    {
    }

    public bitField0_ addAllProperty(Iterable iterable)
    {
        ensurePropertyIsMutable();
        com.google.tagmanager.protobuf.ddAll(iterable, property_);
        return this;
    }

    public property_ addProperty(int i)
    {
        ensurePropertyIsMutable();
        property_.add(Integer.valueOf(i));
        return this;
    }

    public property_ build()
    {
        property_ property_1 = buildPartial();
        if (!property_1.lized())
        {
            throw newUninitializedMessageException(property_1);
        } else
        {
            return property_1;
        }
    }

    public volatile MessageLite build()
    {
        return build();
    }

    public build buildPartial()
    {
        build build1 = new build(this, null);
        int k = bitField0_;
        int j = 0;
        if ((bitField0_ & 1) == 1)
        {
            property_ = Collections.unmodifiableList(property_);
            bitField0_ = bitField0_ & -2;
        }
        _mth002(build1, property_);
        if ((k & 2) == 2)
        {
            j = false | true;
        }
        _mth102(build1, function_);
        int i = j;
        if ((k & 4) == 4)
        {
            i = j | 2;
        }
        _mth202(build1, name_);
        j = i;
        if ((k & 8) == 8)
        {
            j = i | 4;
        }
        _mth302(build1, liveOnly_);
        i = j;
        if ((k & 0x10) == 16)
        {
            i = j | 8;
        }
        _mth402(build1, serverSide_);
        _mth502(build1, i);
        return build1;
    }

    public volatile MessageLite buildPartial()
    {
        return buildPartial();
    }

    public buildPartial clear()
    {
        super.clear();
        property_ = Collections.emptyList();
        bitField0_ = bitField0_ & -2;
        function_ = 0;
        bitField0_ = bitField0_ & -3;
        name_ = 0;
        bitField0_ = bitField0_ & -5;
        liveOnly_ = false;
        bitField0_ = bitField0_ & -9;
        serverSide_ = false;
        bitField0_ = bitField0_ & 0xffffffef;
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

    public clear clearFunction()
    {
        bitField0_ = bitField0_ & -3;
        function_ = 0;
        return this;
    }

    public function_ clearLiveOnly()
    {
        bitField0_ = bitField0_ & -9;
        liveOnly_ = false;
        return this;
    }

    public liveOnly_ clearName()
    {
        bitField0_ = bitField0_ & -5;
        name_ = 0;
        return this;
    }

    public name_ clearProperty()
    {
        property_ = Collections.emptyList();
        bitField0_ = bitField0_ & -2;
        return this;
    }

    public bitField0_ clearServerSide()
    {
        bitField0_ = bitField0_ & 0xffffffef;
        serverSide_ = false;
        return this;
    }

    public serverSide_ clone()
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

    public int getFunction()
    {
        return function_;
    }

    public boolean getLiveOnly()
    {
        return liveOnly_;
    }

    public int getName()
    {
        return name_;
    }

    public int getProperty(int i)
    {
        return ((Integer)property_.get(i)).intValue();
    }

    public int getPropertyCount()
    {
        return property_.size();
    }

    public List getPropertyList()
    {
        return Collections.unmodifiableList(property_);
    }

    public boolean getServerSide()
    {
        return serverSide_;
    }

    public boolean hasFunction()
    {
        return (bitField0_ & 2) == 2;
    }

    public boolean hasLiveOnly()
    {
        return (bitField0_ & 8) == 8;
    }

    public boolean hasName()
    {
        return (bitField0_ & 4) == 4;
    }

    public boolean hasServerSide()
    {
        return (bitField0_ & 0x10) == 16;
    }

    public final boolean isInitialized()
    {
        return hasFunction();
    }

    public hasFunction mergeFrom(hasFunction hasfunction)
    {
        if (hasfunction == ltInstance())
        {
            return this;
        }
        if (!_mth000(hasfunction).isEmpty())
        {
            if (property_.isEmpty())
            {
                property_ = _mth000(hasfunction);
                bitField0_ = bitField0_ & -2;
            } else
            {
                ensurePropertyIsMutable();
                property_.addAll(_mth000(hasfunction));
            }
        }
        if (hasfunction.ion())
        {
            setFunction(hasfunction.ion());
        }
        if (hasfunction.ion())
        {
            setName(hasfunction.setName());
        }
        if (hasfunction.nly())
        {
            setLiveOnly(hasfunction.nly());
        }
        if (hasfunction.rSide())
        {
            setServerSide(hasfunction.rSide());
        }
        setUnknownFields(getUnknownFields().concat(_mth600(hasfunction)));
        return this;
    }

    public _cls600 mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        CodedInputStream codedinputstream1;
        Object obj;
        obj = null;
        codedinputstream1 = obj;
        codedinputstream = (_cls600)_fld600.parsePartialFrom(codedinputstream, extensionregistrylite);
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

    public mergeFrom setFunction(int i)
    {
        bitField0_ = bitField0_ | 2;
        function_ = i;
        return this;
    }

    public function_ setLiveOnly(boolean flag)
    {
        bitField0_ = bitField0_ | 8;
        liveOnly_ = flag;
        return this;
    }

    public liveOnly_ setName(int i)
    {
        bitField0_ = bitField0_ | 4;
        name_ = i;
        return this;
    }

    public name_ setProperty(int i, int j)
    {
        ensurePropertyIsMutable();
        property_.set(i, Integer.valueOf(j));
        return this;
    }

    public property_ setServerSide(boolean flag)
    {
        bitField0_ = bitField0_ | 0x10;
        serverSide_ = flag;
        return this;
    }


    private ()
    {
        property_ = Collections.emptyList();
        maybeForceBuilderInitialization();
    }
}
