// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;

import com.shazam.server.response.recognition.Match;

// Referenced classes of package com.shazam.model:
//            Identifiable

public class AutoTag
    implements Identifiable
{

    public static final int DEFAULT_TOAST_TIMEOUT = 6;
    public final Match match;
    public final long timestamp;
    public final String uuid;

    private AutoTag(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        uuid = Builder.a(builder);
        match = Builder.b(builder);
        timestamp = Builder.c(builder);
    }

    AutoTag(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public final String a()
    {
        return uuid;
    }
}
