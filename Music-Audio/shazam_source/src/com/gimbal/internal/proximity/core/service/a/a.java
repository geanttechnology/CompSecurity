// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.service.a;

import com.gimbal.internal.rest.c;
import java.util.List;
import org.springframework.web.client.RestTemplate;

public final class a
{

    public RestTemplate a;
    public c b;

    public a(RestTemplate resttemplate, c c, com.gimbal.android.a.a a1)
    {
        a = resttemplate;
        b = c;
        resttemplate.getMessageConverters().add(a1);
    }
}
