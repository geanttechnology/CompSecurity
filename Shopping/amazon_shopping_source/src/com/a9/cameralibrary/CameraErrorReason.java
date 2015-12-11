// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.cameralibrary;


public final class CameraErrorReason extends Enum
{

    private static final CameraErrorReason $VALUES[];
    public static final CameraErrorReason CAMERA_CONNECTION_ERROR;
    public static final CameraErrorReason CAMERA_EXCEPTION_ERROR;
    public static final CameraErrorReason CAMERA_OBJECT_NULL;
    public static final CameraErrorReason NO_PREVIEW_SIZES_MEET_CONSTRAINTS;
    public static final CameraErrorReason UNKNOWN_ERROR;

    private CameraErrorReason(String s, int i)
    {
        super(s, i);
    }

    public static CameraErrorReason valueOf(String s)
    {
        return (CameraErrorReason)Enum.valueOf(com/a9/cameralibrary/CameraErrorReason, s);
    }

    public static CameraErrorReason[] values()
    {
        return (CameraErrorReason[])$VALUES.clone();
    }

    static 
    {
        CAMERA_CONNECTION_ERROR = new CameraErrorReason("CAMERA_CONNECTION_ERROR", 0);
        CAMERA_EXCEPTION_ERROR = new CameraErrorReason("CAMERA_EXCEPTION_ERROR", 1);
        CAMERA_OBJECT_NULL = new CameraErrorReason("CAMERA_OBJECT_NULL", 2);
        NO_PREVIEW_SIZES_MEET_CONSTRAINTS = new CameraErrorReason("NO_PREVIEW_SIZES_MEET_CONSTRAINTS", 3);
        UNKNOWN_ERROR = new CameraErrorReason("UNKNOWN_ERROR", 4);
        $VALUES = (new CameraErrorReason[] {
            CAMERA_CONNECTION_ERROR, CAMERA_EXCEPTION_ERROR, CAMERA_OBJECT_NULL, NO_PREVIEW_SIZES_MEET_CONSTRAINTS, UNKNOWN_ERROR
        });
    }
}
