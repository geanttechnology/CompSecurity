// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseOkHttpClient

static class t.Method
{

    static final int $SwitchMap$com$parse$http$ParseHttpRequest$Method[];

    static 
    {
        $SwitchMap$com$parse$http$ParseHttpRequest$Method = new int[com.parse.http.hod.values().length];
        try
        {
            $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.hod.GET.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.hod.DELETE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.hod.POST.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.hod.PUT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
