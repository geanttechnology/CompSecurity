// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;
import com.target.mothership.services.v;
import com.target.mothership.services.x;
import com.target.mothership.services.z;

public class f
{

    private static final String ERROR_CODE_ERR_ACCOUNT_IN_USE = "ERR_ACCOUNT_IN_USE";
    private static final String ERROR_CODE_REAUTH_REQUIRED = "ERR_REAUTH_REQUIRED";
    private static final String ERROR_CODE_TOKEN_EXPIRED = "ERR_TOKEN_EXPIRED";
    private static final String ERROR_CODE_TOO_MANY_REQUESTS = "ERR_TOO_MANY_REQUESTS";
    private static final String PARSE_ERROR_MESSAGE = "Parsing of the response failed";

    public static j a(com.target.mothership.model.common.a.f f1, c c)
    {
        f1 = f1.c();
        int l = f1.length;
        for (int i = 0; i < l; i++)
        {
            j j1 = f1[i];
            c ac[] = j1.a();
            int i1 = ac.length;
            for (int k = 0; k < i1; k++)
            {
                if (ac[k] == c)
                {
                    return j1;
                }
            }

        }

        return null;
    }

    public static x a(v v1)
    {
        return x.a("Parsing of the response failed").a(z.INTERNAL_SERVER_ERROR).b(v1.a()).a();
    }

    public static boolean a(j j1)
        throws IllegalArgumentException
    {
        if (j1 == null)
        {
            throw new IllegalArgumentException("FailureReason must not be null");
        }
        j1 = j1.toString();
        return "ERR_TOKEN_EXPIRED".equals(j1) || "ERR_REAUTH_REQUIRED".equals(j1) || "ERR_ACCOUNT_IN_USE".equals(j1);
    }

    public static boolean b(j j1)
        throws IllegalArgumentException
    {
        if (j1 == null)
        {
            throw new IllegalArgumentException("FailureReason must not be null");
        } else
        {
            return "ERR_TOO_MANY_REQUESTS".equals(j1.toString());
        }
    }
}
