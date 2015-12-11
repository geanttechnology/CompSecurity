// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseRequest

static class r
{

    static final int $SwitchMap$com$parse$http$ParseHttpRequest$Method[];

    static 
    {
        $SwitchMap$com$parse$http$ParseHttpRequest$Method = new int[com.parse.http.t.Method.values().length];
        try
        {
            $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.t.Method.GET.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.t.Method.DELETE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.t.Method.POST.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.t.Method.PUT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
