// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            PushService, PushType

static class or
{

    static final int $SwitchMap$com$parse$PushType[];

    static 
    {
        $SwitchMap$com$parse$PushType = new int[PushType.values().length];
        try
        {
            $SwitchMap$com$parse$PushType[PushType.PPNS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$parse$PushType[PushType.GCM.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
