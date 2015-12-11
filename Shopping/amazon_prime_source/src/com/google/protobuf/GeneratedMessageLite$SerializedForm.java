// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.Serializable;

// Referenced classes of package com.google.protobuf:
//            GeneratedMessageLite, MessageLite

static final class asBytes
    implements Serializable
{

    private byte asBytes[];
    private String messageClassName;

    (MessageLite messagelite)
    {
        messageClassName = messagelite.getClass().getName();
        asBytes = messagelite.toByteArray();
    }
}
