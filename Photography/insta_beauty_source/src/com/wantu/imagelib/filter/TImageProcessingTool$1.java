// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;


// Referenced classes of package com.wantu.imagelib.filter:
//            ProcessType

class 
{

    static final int $SwitchMap$com$wantu$imagelib$filter$ProcessType[];

    static 
    {
        $SwitchMap$com$wantu$imagelib$filter$ProcessType = new int[ProcessType.values().length];
        try
        {
            $SwitchMap$com$wantu$imagelib$filter$ProcessType[ProcessType.TSingleType.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$wantu$imagelib$filter$ProcessType[ProcessType.TGifType.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$wantu$imagelib$filter$ProcessType[ProcessType.TLightStream.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
