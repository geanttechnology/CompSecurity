// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import com.facebook.i;
import java.util.Collection;

// Referenced classes of package com.facebook.internal:
//            o

public final class n
{

    public static final Collection a = o.a(new String[] {
        "service_disabled", "AndroidAuthKillSwitchException"
    });
    public static final Collection b = o.a(new String[] {
        "access_denied", "OAuthAccessDeniedException"
    });
    private static final String c = com/facebook/internal/n.getName();

    public n()
    {
    }

    public static final String a()
    {
        return String.format("m.%s", new Object[] {
            i.e()
        });
    }

    public static final String b()
    {
        return String.format("https://graph.%s", new Object[] {
            i.e()
        });
    }

    public static final String c()
    {
        return String.format("https://graph-video.%s", new Object[] {
            i.e()
        });
    }

    public static final String d()
    {
        return "v2.5";
    }

}
