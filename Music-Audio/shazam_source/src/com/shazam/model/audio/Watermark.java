// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.audio;


// Referenced classes of package com.shazam.model.audio:
//            Mood

public class Watermark
{

    public Mood mood;

    private Watermark()
    {
    }

    private Watermark(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        mood = Builder.a(builder);
    }

    Watermark(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
