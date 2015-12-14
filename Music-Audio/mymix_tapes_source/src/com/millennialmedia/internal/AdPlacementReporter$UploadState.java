// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;


// Referenced classes of package com.millennialmedia.internal:
//            AdPlacementReporter

static final class  extends Enum
{

    private static final ERROR_SENDING_TO_SERVER $VALUES[];
    public static final ERROR_SENDING_TO_SERVER ERROR_NETWORK_UNAVAILABLE;
    public static final ERROR_SENDING_TO_SERVER ERROR_SENDING_TO_SERVER;
    public static final ERROR_SENDING_TO_SERVER IDLE;
    public static final ERROR_SENDING_TO_SERVER UPLOADING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/millennialmedia/internal/AdPlacementReporter$UploadState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IDLE = new <init>("IDLE", 0);
        UPLOADING = new <init>("UPLOADING", 1);
        ERROR_NETWORK_UNAVAILABLE = new <init>("ERROR_NETWORK_UNAVAILABLE", 2);
        ERROR_SENDING_TO_SERVER = new <init>("ERROR_SENDING_TO_SERVER", 3);
        $VALUES = (new .VALUES[] {
            IDLE, UPLOADING, ERROR_NETWORK_UNAVAILABLE, ERROR_SENDING_TO_SERVER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
