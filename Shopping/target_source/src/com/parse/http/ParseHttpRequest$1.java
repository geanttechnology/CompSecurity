// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.http;


// Referenced classes of package com.parse.http:
//            ParseHttpRequest

static class thod
{

    static final int $SwitchMap$com$parse$http$ParseHttpRequest$Method[];

    static 
    {
        $SwitchMap$com$parse$http$ParseHttpRequest$Method = new int[thod.values().length];
        try
        {
            $SwitchMap$com$parse$http$ParseHttpRequest$Method[thod.GET.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$parse$http$ParseHttpRequest$Method[thod.POST.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$parse$http$ParseHttpRequest$Method[thod.PUT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$parse$http$ParseHttpRequest$Method[thod.DELETE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
