// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.midtier.proto.containertag;

import com.google.tagmanager.protobuf.ByteString;
import java.util.List;

// Referenced classes of package com.google.analytics.midtier.proto.containertag:
//            TypeSystem

public static interface lder
    extends com.google.tagmanager.protobuf.dableMessageOrBuilder
{

    public abstract boolean getBoolean();

    public abstract boolean getContainsReferences();

    public abstract lder getEscaping(int i);

    public abstract int getEscapingCount();

    public abstract List getEscapingList();

    public abstract String getFunctionId();

    public abstract ByteString getFunctionIdBytes();

    public abstract long getInteger();

    public abstract lder getListItem(int i);

    public abstract int getListItemCount();

    public abstract List getListItemList();

    public abstract String getMacroReference();

    public abstract ByteString getMacroReferenceBytes();

    public abstract lder getMapKey(int i);

    public abstract int getMapKeyCount();

    public abstract List getMapKeyList();

    public abstract lder getMapValue(int i);

    public abstract int getMapValueCount();

    public abstract List getMapValueList();

    public abstract String getString();

    public abstract ByteString getStringBytes();

    public abstract lder getTemplateToken(int i);

    public abstract int getTemplateTokenCount();

    public abstract List getTemplateTokenList();

    public abstract lder getType();

    public abstract boolean hasBoolean();

    public abstract boolean hasContainsReferences();

    public abstract boolean hasFunctionId();

    public abstract boolean hasInteger();

    public abstract boolean hasMacroReference();

    public abstract boolean hasString();

    public abstract boolean hasType();
}
