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

    public abstract int getFunction();

    public abstract boolean getLiveOnly();

    public abstract int getName();

    public abstract int getProperty(int i);

    public abstract int getPropertyCount();

    public abstract List getPropertyList();

    public abstract boolean getServerSide();

    public abstract boolean hasFunction();

    public abstract boolean hasLiveOnly();

    public abstract boolean hasName();

    public abstract boolean hasServerSide();
}
