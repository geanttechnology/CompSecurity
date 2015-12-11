// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.proto;

import com.google.tagmanager.protobuf.MessageLiteOrBuilder;

// Referenced classes of package com.google.tagmanager.proto:
//            Resource

public static interface 
    extends MessageLiteOrBuilder
{

    public abstract com.google.analytics.containertag.proto.gle.tagmanager.protoi getResource();

    public abstract long getTimeStamp();

    public abstract boolean hasResource();

    public abstract boolean hasTimeStamp();
}
