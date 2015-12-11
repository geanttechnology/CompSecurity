// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.enums;


public final class DrmWorkflow extends Enum
{

    private static final DrmWorkflow $VALUES[];
    public static final DrmWorkflow LOCAL;
    public static final DrmWorkflow NO_DRM;
    public static final DrmWorkflow STREAMING;
    public static final DrmWorkflow WHITE_LIST;
    public static final DrmWorkflow drmWorkflow;

    private DrmWorkflow(String s, int i)
    {
        super(s, i);
    }

    public static DrmWorkflow valueOf(String s)
    {
        return (DrmWorkflow)Enum.valueOf(com/comcast/playerplatform/primetime/android/enums/DrmWorkflow, s);
    }

    public static DrmWorkflow[] values()
    {
        return (DrmWorkflow[])$VALUES.clone();
    }

    static 
    {
        STREAMING = new DrmWorkflow("STREAMING", 0);
        LOCAL = new DrmWorkflow("LOCAL", 1);
        NO_DRM = new DrmWorkflow("NO_DRM", 2);
        drmWorkflow = new DrmWorkflow("drmWorkflow", 3);
        WHITE_LIST = new DrmWorkflow("WHITE_LIST", 4);
        $VALUES = (new DrmWorkflow[] {
            STREAMING, LOCAL, NO_DRM, drmWorkflow, WHITE_LIST
        });
    }
}
