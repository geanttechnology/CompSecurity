// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;


public final class UploadControlAction extends Enum
{

    private static final UploadControlAction $VALUES[];
    public static final UploadControlAction CANCEL;
    public static final UploadControlAction PAUSE;
    public static final UploadControlAction RESUME;
    public static final UploadControlAction START;

    private UploadControlAction(String s, int i)
    {
        super(s, i);
    }

    public static UploadControlAction valueOf(String s)
    {
        return (UploadControlAction)Enum.valueOf(com/amazon/gallery/framework/network/multiqueueuploader/UploadControlAction, s);
    }

    public static UploadControlAction[] values()
    {
        return (UploadControlAction[])$VALUES.clone();
    }

    static 
    {
        START = new UploadControlAction("START", 0);
        RESUME = new UploadControlAction("RESUME", 1);
        PAUSE = new UploadControlAction("PAUSE", 2);
        CANCEL = new UploadControlAction("CANCEL", 3);
        $VALUES = (new UploadControlAction[] {
            START, RESUME, PAUSE, CANCEL
        });
    }
}
