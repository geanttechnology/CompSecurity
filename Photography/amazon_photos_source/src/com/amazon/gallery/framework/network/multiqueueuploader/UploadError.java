// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;


public final class UploadError extends Enum
{

    private static final UploadError $VALUES[];
    public static final UploadError ACCOUNT_CHANGED;
    public static final UploadError LOW_BATTERY;
    public static final UploadError NO_ERROR;
    public static final UploadError NO_NETWORK;
    public static final UploadError NO_SPACE;
    public static final UploadError UNKNOWN_ERROR;
    public static final UploadError UNREGISTERED;
    public static final UploadError UPLOAD_DISABLED;
    public static final UploadError WAITING_FOR_POWER;
    public static final UploadError WAITING_FOR_WIFI;

    private UploadError(String s, int i)
    {
        super(s, i);
    }

    public static UploadError valueOf(String s)
    {
        return (UploadError)Enum.valueOf(com/amazon/gallery/framework/network/multiqueueuploader/UploadError, s);
    }

    public static UploadError[] values()
    {
        return (UploadError[])$VALUES.clone();
    }

    static 
    {
        NO_ERROR = new UploadError("NO_ERROR", 0);
        NO_SPACE = new UploadError("NO_SPACE", 1);
        NO_NETWORK = new UploadError("NO_NETWORK", 2);
        WAITING_FOR_WIFI = new UploadError("WAITING_FOR_WIFI", 3);
        WAITING_FOR_POWER = new UploadError("WAITING_FOR_POWER", 4);
        LOW_BATTERY = new UploadError("LOW_BATTERY", 5);
        ACCOUNT_CHANGED = new UploadError("ACCOUNT_CHANGED", 6);
        UNREGISTERED = new UploadError("UNREGISTERED", 7);
        UPLOAD_DISABLED = new UploadError("UPLOAD_DISABLED", 8);
        UNKNOWN_ERROR = new UploadError("UNKNOWN_ERROR", 9);
        $VALUES = (new UploadError[] {
            NO_ERROR, NO_SPACE, NO_NETWORK, WAITING_FOR_WIFI, WAITING_FOR_POWER, LOW_BATTERY, ACCOUNT_CHANGED, UNREGISTERED, UPLOAD_DISABLED, UNKNOWN_ERROR
        });
    }
}
