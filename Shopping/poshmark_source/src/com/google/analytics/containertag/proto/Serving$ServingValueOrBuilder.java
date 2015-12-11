// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import java.util.List;

// Referenced classes of package com.google.analytics.containertag.proto:
//            Serving

public static interface 
    extends MessageLiteOrBuilder
{

    public abstract int getListItem(int i);

    public abstract int getListItemCount();

    public abstract List getListItemList();

    public abstract int getMacroNameReference();

    public abstract int getMacroReference();

    public abstract int getMapKey(int i);

    public abstract int getMapKeyCount();

    public abstract List getMapKeyList();

    public abstract int getMapValue(int i);

    public abstract int getMapValueCount();

    public abstract List getMapValueList();

    public abstract int getTemplateToken(int i);

    public abstract int getTemplateTokenCount();

    public abstract List getTemplateTokenList();

    public abstract boolean hasMacroNameReference();

    public abstract boolean hasMacroReference();
}
