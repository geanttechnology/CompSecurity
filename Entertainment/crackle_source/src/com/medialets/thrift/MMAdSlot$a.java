// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.io.Serializable;

// Referenced classes of package com.medialets.thrift:
//            MMAdSlot

private static final class height
    implements Serializable
{

    public boolean adSlotID;
    public boolean height;
    public boolean width;

    ()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        adSlotID = false;
        width = false;
        height = false;
    }
}
