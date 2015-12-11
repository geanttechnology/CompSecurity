// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import java.util.List;

// Referenced classes of package com.google.analytics.containertag.proto:
//            Debug

public static interface Q
    extends MessageLiteOrBuilder
{

    public abstract String getAssociatedRuleName();

    public abstract ByteString getAssociatedRuleNameBytes();

    public abstract Q getProperties(int i);

    public abstract int getPropertiesCount();

    public abstract List getPropertiesList();

    public abstract com.google.analytics.midtier.proto.containertag.google.analytics.con_81_ getResult();

    public abstract boolean hasAssociatedRuleName();

    public abstract boolean hasResult();
}
