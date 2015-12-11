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

    public abstract String getContainerId();

    public abstract ByteString getContainerIdBytes();

    public abstract String getContainerVersion();

    public abstract ByteString getContainerVersionBytes();

    public abstract ationInfo getDataLayerEventResult();

    public abstract  getEventType();

    public abstract String getKey();

    public abstract ByteString getKeyBytes();

    public abstract  getMacroResult();

    public abstract boolean hasContainerId();

    public abstract boolean hasContainerVersion();

    public abstract boolean hasDataLayerEventResult();

    public abstract boolean hasEventType();

    public abstract boolean hasKey();

    public abstract boolean hasMacroResult();
}
