// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;


// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            FFmpeg, CpuArch

static class 
{

    static final int $SwitchMap$com$github$hiteshsondhi88$libffmpeg$CpuArch[];

    static 
    {
        $SwitchMap$com$github$hiteshsondhi88$libffmpeg$CpuArch = new int[CpuArch.values().length];
        try
        {
            $SwitchMap$com$github$hiteshsondhi88$libffmpeg$CpuArch[CpuArch.x86.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$github$hiteshsondhi88$libffmpeg$CpuArch[CpuArch.ARMv7.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$github$hiteshsondhi88$libffmpeg$CpuArch[CpuArch.ARMv7_NEON.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$github$hiteshsondhi88$libffmpeg$CpuArch[CpuArch.NONE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
