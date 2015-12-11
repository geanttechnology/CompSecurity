// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.cameralibrary;


// Referenced classes of package com.a9.cameralibrary:
//            CameraConnectionRunnable, CameraOpenMode

static class 
{

    static final int $SwitchMap$com$a9$cameralibrary$CameraOpenMode[];

    static 
    {
        $SwitchMap$com$a9$cameralibrary$CameraOpenMode = new int[CameraOpenMode.values().length];
        try
        {
            $SwitchMap$com$a9$cameralibrary$CameraOpenMode[CameraOpenMode.FIRST_BACK_FACING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$a9$cameralibrary$CameraOpenMode[CameraOpenMode.FIRST_FRONT_FACING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
