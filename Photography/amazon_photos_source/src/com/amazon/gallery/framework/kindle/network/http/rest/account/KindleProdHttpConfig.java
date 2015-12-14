// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.network.http.rest.account;

import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.ProdHttpConfig;

public class KindleProdHttpConfig extends ProdHttpConfig
{

    private final AuthenticationManager authenticationManager;

    public KindleProdHttpConfig(AuthenticationManager authenticationmanager)
    {
        authenticationManager = authenticationmanager;
    }

    public Endpoint getDefaultEndpoint(String s, int i)
    {
        s = authenticationManager.getPFM();
        int j;
        boolean flag;
        if ("ATVPDKIKX0DER".equals(s))
        {
            j = 0;
        } else
        if ("A1F83G8C2ARO7P".equals(s) || "A1PA6795UKMFR9".equals(s) || "A13V1IB3VIYZZH".equals(s) || "A1RKKUPIHCS9HS".equals(s) || "APJ6JRA9NG5V4".equals(s))
        {
            j = 1;
        } else
        if ("A1VC38T7YXB528".equals(s))
        {
            j = 2;
        } else
        if ("AAHKV2X7AFYLW".equals(s))
        {
            j = 3;
        } else
        {
            j = 0;
        }
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertTrue(flag);
        i--;
        if (i < ENDPOINTS.length)
        {
            int k = ENDPOINTS.length;
            return new Endpoint(ENDPOINTS[(j + i) % k], true);
        } else
        {
            return null;
        }
    }
}
