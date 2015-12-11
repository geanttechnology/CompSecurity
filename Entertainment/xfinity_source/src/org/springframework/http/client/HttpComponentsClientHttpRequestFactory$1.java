// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import org.springframework.http.HttpMethod;

// Referenced classes of package org.springframework.http.client:
//            HttpComponentsClientHttpRequestFactory

static class 
{

    static final int $SwitchMap$org$springframework$http$HttpMethod[];

    static 
    {
        $SwitchMap$org$springframework$http$HttpMethod = new int[HttpMethod.values().length];
        try
        {
            $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.GET.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.DELETE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.HEAD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.OPTIONS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.POST.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.PUT.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$org$springframework$http$HttpMethod[HttpMethod.TRACE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
