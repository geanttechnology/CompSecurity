// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.recognition;

import java.util.TimeZone;

// Referenced classes of package com.shazam.server.request.recognition:
//            Context, Geolocation, Signature

public class RecognitionRequest
{

    public final Context context;
    public final Geolocation geolocation;
    public final Signature signature;
    public final TimeZone timeZone;
    public final long timestamp;

    private RecognitionRequest(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        timestamp = Builder.access._mth000(builder);
        timeZone = Builder.access._mth100(builder);
        geolocation = Builder.access._mth200(builder);
        context = Builder.access._mth300(builder);
        signature = Builder.access._mth400(builder);
    }

    RecognitionRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
