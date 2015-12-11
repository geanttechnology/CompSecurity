// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;
import java.util.Locale;

final class ajy
    implements awo
{

    private boolean a;
    private aju b;

    ajy(aju aju1, boolean flag)
    {
        b = aju1;
        a = flag;
        super();
    }

    public final void a(awn awn)
    {
        aju aju1;
        Object obj = (auf)awn;
        if (b.h == aki.d)
        {
            b.a("connectionCallback: no longer connected");
            return;
        }
        if (!b.b.b())
        {
            b.a("connectionCallback: no connected client");
            return;
        }
        awn = ((auf) (obj)).a_();
        b.g = ((auf) (obj)).b();
        aju1 = b;
        String s = String.valueOf(awn);
        boolean flag = awn.a();
        obj = String.valueOf(((auf) (obj)).a());
        String s2 = b.g;
        boolean flag1 = a;
        aju1.a((new StringBuilder(String.valueOf(s).length() + 38 + String.valueOf(obj).length() + String.valueOf(s2).length())).append("onConnectionResult: ").append(s).append(": ").append(flag).append(": ").append(((String) (obj))).append(": ").append(s2).append(": ").append(flag1).toString());
        if (!awn.a())
        {
            b.c();
            return;
        }
        if (!b.c.a())
        {
            b.a("No video to fling locally");
            return;
        }
        if (!a)
        {
            b.a("Not flinging video locally because of reconnection");
            return;
        }
        aju1 = b;
        String s1;
        awn = aju1.c.a;
        int i = aju1.c.b;
        s1 = String.format(Locale.ENGLISH, "{\"type\":\"flingVideo\",\"data\":{\"videoId\":\"%s\",\"currentTime\":%.2f}}", new Object[] {
            awn, Double.valueOf((double)i / 1000D)
        });
        awn = String.valueOf(s1);
        if (awn.length() == 0)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        awn = "for the performance purposes sending message: ".concat(awn);
_L1:
        aju1.a(awn);
        aju1.b.b(s1);
        return;
        try
        {
            awn = new String("for the performance purposes sending message: ");
        }
        // Misplaced declaration of an exception variable
        catch (awn awn)
        {
            aju1.a("can't send message over Cast");
            return;
        }
          goto _L1
    }
}
