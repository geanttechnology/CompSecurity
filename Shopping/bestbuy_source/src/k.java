// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.io.File;

final class k
{

    final File a;
    final File b;
    final File c;
    final File d;

    private k(Context context, long l)
    {
        a = new File(context.getDir("com.appdynamics.eumagent.runtime", 0), "infopoints");
        b = new File(a, (new StringBuilder()).append(l).toString());
        d = new File(b, "cache");
        c = new File(b, "classes.apk");
    }

    k(Context context, long l, byte byte0)
    {
        this(context, l);
    }
}
