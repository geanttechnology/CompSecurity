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
    private List listItem_;
    private int macroNameReference_;
    private int macroReference_;
    private List mapKey_;
    private List mapValue_;
    private List templateToken_;

    private static  create()
    {
        return new <init>();
    }

    private void ensureListItemIsMutable()
    {
        if ((bitField0_ & 1) != 1)
        {
            listItem_ = new ArrayList(listItem_);
            bitField0_ = bitField0_ | 1;
        }
    }

    private void ensureMapKeyIsMutable()
    {
        if ((bitField0_ & 2) != 2)
        {
            mapKey_ = new ArrayList(mapKey_);
            bitField0_ = bitField0_ | 2;
        }
    }

    private void ensureMapValueIsMutable()
    {
        if ((bitField0_ & 4) != 4)
        {
            mapValue_ = new ArrayList(mapValue_);
            bitField0_ = bitField0_ | 4;
        }
    }

    private void ensureTemplateTokenIsMutable()
    {
        if ((bitField0_ & 0x10) != 16)
        {
            templateToken_ = new ArrayList(templateToken_);
            bitField0_ = bitField0_ | 0x10;
        }
    }

    private void maybeForceBuilderInitialization()
    {
    }

    public bitField0_ addAllListItem(Iterable iterable)
    {
        ensureListItemIsMutable();
        com.google.tagmanager.protobuf.ddAll(iterable, listItem_);
        return this;
    }

    public listItem_ addAllMapKey(Iterable iterable)
    {
        ensureMapKeyIsMutable();
        com.google.tagmanager.protobuf.ddAll(iterable, mapKey_);
        return this;
    }

    public mapKey_ addAllMapValue(Iterable iterable)
    {
        ensureMapValueIsMutable();
        com.google.tagmanager.protobuf.ddAll(iterable, mapValue_);
        return this;
    }

    public mapValue_ addAllTemplateToken(Iterable iterable)
    {
        ensureTemplateTokenIsMutable();
        com.google.tagmanager.protobuf.ddAll(iterable, templateToken_);
        return this;
    }

    public templateToken_ addListItem(int i)
    {
        ensureListItemIsMutable();
        listItem_.add(Integer.valueOf(i));
        return this;
    }

    public listItem_ addMapKey(int i)
    {
        ensureMapKeyIsMutable();
        mapKey_.add(Integer.valueOf(i));
        return this;
    }

    public mapKey_ addMapValue(int i)
    {
        ensureMapValueIsMutable();
        mapValue_.add(Integer.valueOf(i));
        return this;
    }

    public mapValue_ addTemplateToken(int i)
    {
        ensureTemplateTokenIsMutable();
        templateToken_.add(Integer.valueOf(i));
        return this;
    }

    public templateToken_ build()
    {
        templateToken_ templatetoken_ = buildPartial();
        if (!templatetoken_.lized())
        {
            throw newUninitializedMessageException(templatetoken_);
        } else
        {
            return templatetoken_;
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
        int i = 0;
        if ((bitField0_ & 1) == 1)
        {
            listItem_ = Collections.unmodifiableList(listItem_);
            bitField0_ = bitField0_ & -2;
        }
        _mth202(build1, listItem_);
        if ((bitField0_ & 2) == 2)
        {
            mapKey_ = Collections.unmodifiableList(mapKey_);
            bitField0_ = bitField0_ & -3;
        }
        _mth302(build1, mapKey_);
        if ((bitField0_ & 4) == 4)
        {
            mapValue_ = Collections.unmodifiableList(mapValue_);
            bitField0_ = bitField0_ & -5;
        }
        _mth402(build1, mapValue_);
        if ((k & 8) == 8)
        {
            i = false | true;
        }
        _mth502(build1, macroReference_);
        if ((bitField0_ & 0x10) == 16)
        {
            templateToken_ = Collections.unmodifiableList(templateToken_);
            bitField0_ = bitField0_ & 0xffffffef;
        }
        _mth602(build1, templateToken_);
        int j = i;
        if ((k & 0x20) == 32)
        {
            j = i | 2;
        }
        _mth702(build1, macroNameReference_);
        _mth802(build1, j);
        return build1;
    }

    public volatile MessageLite buildPartial()
    {
        return buildPartial();
    }

    public buildPartial clear()
    {
        super.clear();
        listItem_ = Collections.emptyList();
        bitField0_ = bitField0_ & -2;
        mapKey_ = Collections.emptyList();
        bitField0_ = bitField0_ & -3;
        mapValue_ = Collections.emptyList();
        bitField0_ = bitField0_ & -5;
        macroReference_ = 0;
        bitField0_ = bitField0_ & -9;
        templateToken_ = Collections.emptyList();
        bitField0_ = bitField0_ & 0xffffffef;
        macroNameReference_ = 0;
        bitField0_ = bitField0_ & 0xffffffdf;
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

    public clear clearListItem()
    {
        listItem_ = Collections.emptyList();
        bitField0_ = bitField0_ & -2;
        return this;
    }

    public bitField0_ clearMacroNameReference()
    {
        bitField0_ = bitField0_ & 0xffffffdf;
        macroNameReference_ = 0;
        return this;
    }

    public macroNameReference_ clearMacroReference()
    {
        bitField0_ = bitField0_ & -9;
        macroReference_ = 0;
        return this;
    }

    public macroReference_ clearMapKey()
    {
        mapKey_ = Collections.emptyList();
        bitField0_ = bitField0_ & -3;
        return this;
    }

    public bitField0_ clearMapValue()
    {
        mapValue_ = Collections.emptyList();
        bitField0_ = bitField0_ & -5;
        return this;
    }

    public bitField0_ clearTemplateToken()
    {
        templateToken_ = Collections.emptyList();
        bitField0_ = bitField0_ & 0xffffffef;
        return this;
    }

    public bitField0_ clone()
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

    public int getListItem(int i)
    {
        return ((Integer)listItem_.get(i)).intValue();
    }

    public int getListItemCount()
    {
        return listItem_.size();
    }

    public List getListItemList()
    {
        return Collections.unmodifiableList(listItem_);
    }

    public int getMacroNameReference()
    {
        return macroNameReference_;
    }

    public int getMacroReference()
    {
        return macroReference_;
    }

    public int getMapKey(int i)
    {
        return ((Integer)mapKey_.get(i)).intValue();
    }

    public int getMapKeyCount()
    {
        return mapKey_.size();
    }

    public List getMapKeyList()
    {
        return Collections.unmodifiableList(mapKey_);
    }

    public int getMapValue(int i)
    {
        return ((Integer)mapValue_.get(i)).intValue();
    }

    public int getMapValueCount()
    {
        return mapValue_.size();
    }

    public List getMapValueList()
    {
        return Collections.unmodifiableList(mapValue_);
    }

    public int getTemplateToken(int i)
    {
        return ((Integer)templateToken_.get(i)).intValue();
    }

    public int getTemplateTokenCount()
    {
        return templateToken_.size();
    }

    public List getTemplateTokenList()
    {
        return Collections.unmodifiableList(templateToken_);
    }

    public boolean hasMacroNameReference()
    {
        return (bitField0_ & 0x20) == 32;
    }

    public boolean hasMacroReference()
    {
        return (bitField0_ & 8) == 8;
    }

    public final boolean isInitialized()
    {
        return true;
    }

    public bitField0_ mergeFrom(bitField0_ bitfield0_)
    {
        if (bitfield0_ == ltInstance())
        {
            return this;
        }
        if (!_mth200(bitfield0_).isEmpty())
        {
            if (listItem_.isEmpty())
            {
                listItem_ = _mth200(bitfield0_);
                bitField0_ = bitField0_ & -2;
            } else
            {
                ensureListItemIsMutable();
                listItem_.addAll(_mth200(bitfield0_));
            }
        }
        if (!_mth300(bitfield0_).isEmpty())
        {
            if (mapKey_.isEmpty())
            {
                mapKey_ = _mth300(bitfield0_);
                bitField0_ = bitField0_ & -3;
            } else
            {
                ensureMapKeyIsMutable();
                mapKey_.addAll(_mth300(bitfield0_));
            }
        }
        if (!_mth400(bitfield0_).isEmpty())
        {
            if (mapValue_.isEmpty())
            {
                mapValue_ = _mth400(bitfield0_);
                bitField0_ = bitField0_ & -5;
            } else
            {
                ensureMapValueIsMutable();
                mapValue_.addAll(_mth400(bitfield0_));
            }
        }
        if (bitfield0_.Reference())
        {
            setMacroReference(bitfield0_.Reference());
        }
        if (!_mth600(bitfield0_).isEmpty())
        {
            if (templateToken_.isEmpty())
            {
                templateToken_ = _mth600(bitfield0_);
                bitField0_ = bitField0_ & 0xffffffef;
            } else
            {
                ensureTemplateTokenIsMutable();
                templateToken_.addAll(_mth600(bitfield0_));
            }
        }
        if (bitfield0_.NameReference())
        {
            setMacroNameReference(bitfield0_.NameReference());
        }
        setUnknownFields(getUnknownFields().concat(_mth900(bitfield0_)));
        return this;
    }

    public _cls900 mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        CodedInputStream codedinputstream1;
        Object obj;
        obj = null;
        codedinputstream1 = obj;
        codedinputstream = (_cls900)_fld900.parsePartialFrom(codedinputstream, extensionregistrylite);
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

    public mergeFrom setListItem(int i, int j)
    {
        ensureListItemIsMutable();
        listItem_.set(i, Integer.valueOf(j));
        return this;
    }

    public listItem_ setMacroNameReference(int i)
    {
        bitField0_ = bitField0_ | 0x20;
        macroNameReference_ = i;
        return this;
    }

    public macroNameReference_ setMacroReference(int i)
    {
        bitField0_ = bitField0_ | 8;
        macroReference_ = i;
        return this;
    }

    public macroReference_ setMapKey(int i, int j)
    {
        ensureMapKeyIsMutable();
        mapKey_.set(i, Integer.valueOf(j));
        return this;
    }

    public mapKey_ setMapValue(int i, int j)
    {
        ensureMapValueIsMutable();
        mapValue_.set(i, Integer.valueOf(j));
        return this;
    }

    public mapValue_ setTemplateToken(int i, int j)
    {
        ensureTemplateTokenIsMutable();
        templateToken_.set(i, Integer.valueOf(j));
        return this;
    }


    private ()
    {
        listItem_ = Collections.emptyList();
        mapKey_ = Collections.emptyList();
        mapValue_ = Collections.emptyList();
        templateToken_ = Collections.emptyList();
        maybeForceBuilderInitialization();
    }
}
