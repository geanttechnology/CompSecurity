// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.Channel;

// Referenced classes of package com.groupon.util:
//            GlobalSearchUtil

static class 
{

    static final int $SwitchMap$com$groupon$Channel[];

    static 
    {
        $SwitchMap$com$groupon$Channel = new int[Channel.values().length];
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.GOODS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.SHOPPING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.NEARBY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.GETAWAYS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$groupon$Channel[Channel.TRAVEL.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
