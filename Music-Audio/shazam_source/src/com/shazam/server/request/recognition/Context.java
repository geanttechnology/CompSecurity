// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.recognition;


// Referenced classes of package com.shazam.server.request.recognition:
//            Watermark

public class Context
{

    public final Watermark watermark;

    private Context(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        watermark = Builder.access._mth000(builder);
    }

    Context(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
