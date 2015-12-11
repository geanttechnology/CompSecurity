// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import com.shazam.android.service.a.a;
import com.shazam.b.b.e;
import com.shazam.server.legacy.ErrorBean;
import java.util.Set;

public final class n
{

    private static final Set a = e.a(new String[] {
        "16030", "16022", "16031", "16032"
    });

    public static a a(ErrorBean errorbean)
    {
        String s = errorbean.getCode();
        errorbean = errorbean.getMessage();
        if (a.contains(s))
        {
            return new a(errorbean, s);
        } else
        {
            return new a((new StringBuilder("[#")).append(s).append("] ").append(errorbean).toString(), s);
        }
    }

}
