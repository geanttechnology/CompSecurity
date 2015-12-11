// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.facebook.k;
import java.util.Collection;

// Referenced classes of package android.support.v7:
//            kb

public final class ka
{

    public static final Collection a = kb.a(new String[] {
        "service_disabled", "AndroidAuthKillSwitchException"
    });
    public static final Collection b = kb.a(new String[] {
        "access_denied", "OAuthAccessDeniedException"
    });
    private static final String c = android/support/v7/ka.getName();

    public ka()
    {
    }

    public static final String a()
    {
        return String.format("m.%s", new Object[] {
            k.e()
        });
    }

    public static final String b()
    {
        return String.format("https://graph.%s", new Object[] {
            k.e()
        });
    }

    public static final String c()
    {
        return String.format("https://graph-video.%s", new Object[] {
            k.e()
        });
    }

    public static final String d()
    {
        return "v2.4";
    }

}
