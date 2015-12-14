// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;


// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ActionSendActivity

public static final class  extends Enum
{

    private static final ActionSendUploadError $VALUES[];
    public static final ActionSendUploadError ActionSendUploadAlreadyExists;
    public static final ActionSendUploadError ActionSendUploadAttempt;
    public static final ActionSendUploadError ActionSendUploadError;
    public static final ActionSendUploadError ActionSendUploadSuccess;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/app/activity/ActionSendActivity$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ActionSendUploadAttempt = new <init>("ActionSendUploadAttempt", 0);
        ActionSendUploadSuccess = new <init>("ActionSendUploadSuccess", 1);
        ActionSendUploadAlreadyExists = new <init>("ActionSendUploadAlreadyExists", 2);
        ActionSendUploadError = new <init>("ActionSendUploadError", 3);
        $VALUES = (new .VALUES[] {
            ActionSendUploadAttempt, ActionSendUploadSuccess, ActionSendUploadAlreadyExists, ActionSendUploadError
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
