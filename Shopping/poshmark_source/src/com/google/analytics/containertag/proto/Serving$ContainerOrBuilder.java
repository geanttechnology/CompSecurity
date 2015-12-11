// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.MessageLiteOrBuilder;

// Referenced classes of package com.google.analytics.containertag.proto:
//            Serving

public static interface 
    extends MessageLiteOrBuilder
{

    public abstract String getContainerId();

    public abstract ByteString getContainerIdBytes();

    public abstract  getJsResource();

    public abstract  getState();

    public abstract String getVersion();

    public abstract ByteString getVersionBytes();

    public abstract boolean hasContainerId();

    public abstract boolean hasJsResource();

    public abstract boolean hasState();

    public abstract boolean hasVersion();
}
