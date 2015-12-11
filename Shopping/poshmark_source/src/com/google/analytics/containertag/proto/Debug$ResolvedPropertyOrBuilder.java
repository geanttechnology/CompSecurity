// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.MessageLiteOrBuilder;

// Referenced classes of package com.google.analytics.containertag.proto:
//            Debug

public static interface 
    extends MessageLiteOrBuilder
{

    public abstract String getKey();

    public abstract ByteString getKeyBytes();

    public abstract com.google.analytics.midtier.proto.containertag.com.google.analytics_81_ getValue();

    public abstract boolean hasKey();

    public abstract boolean hasValue();
}
