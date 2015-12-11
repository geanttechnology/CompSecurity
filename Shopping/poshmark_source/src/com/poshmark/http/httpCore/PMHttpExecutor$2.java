// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.httpCore;


// Referenced classes of package com.poshmark.http.httpCore:
//            PMHttpExecutor

static class 
{

    static final int $SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE[];

    static 
    {
        $SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE = new int[com.poshmark.http.UEST_TYPE.values().length];
        try
        {
            $SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE[com.poshmark.http.UEST_TYPE.HTTP_GET.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE[com.poshmark.http.UEST_TYPE.HTTP_POST.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE[com.poshmark.http.UEST_TYPE.HTTP_PUT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE[com.poshmark.http.UEST_TYPE.HTTP_DELETE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
