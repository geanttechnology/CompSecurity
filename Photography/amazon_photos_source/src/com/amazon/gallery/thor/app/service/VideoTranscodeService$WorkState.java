// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;


// Referenced classes of package com.amazon.gallery.thor.app.service:
//            VideoTranscodeService

public static final class I extends Enum
{

    private static final FAILED $VALUES[];
    public static final FAILED CANCELLED;
    public static final FAILED COMPLETED;
    public static final FAILED FAILED;
    public static final FAILED NOT_REQUESTED;
    public static final FAILED NOT_STARTED;
    public static final FAILED STARTED;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/amazon/gallery/thor/app/service/VideoTranscodeService$WorkState, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        CANCELLED = new <init>("CANCELLED", 0);
        COMPLETED = new <init>("COMPLETED", 1);
        STARTED = new <init>("STARTED", 2);
        NOT_STARTED = new <init>("NOT_STARTED", 3);
        NOT_REQUESTED = new <init>("NOT_REQUESTED", 4);
        FAILED = new <init>("FAILED", 5);
        $VALUES = (new .VALUES[] {
            CANCELLED, COMPLETED, STARTED, NOT_STARTED, NOT_REQUESTED, FAILED
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
