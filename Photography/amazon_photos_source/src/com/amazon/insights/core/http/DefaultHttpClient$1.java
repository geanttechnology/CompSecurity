// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;


// Referenced classes of package com.amazon.insights.core.http:
//            DefaultHttpClient

static class d
{

    static final int $SwitchMap$com$amazon$insights$core$http$HttpClient$HttpMethod[];

    static 
    {
        $SwitchMap$com$amazon$insights$core$http$HttpClient$HttpMethod = new int[d.values().length];
        try
        {
            $SwitchMap$com$amazon$insights$core$http$HttpClient$HttpMethod[d.GET.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$insights$core$http$HttpClient$HttpMethod[d.POST.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
