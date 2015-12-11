// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.b;

import android.content.Context;
import c.a.a.a.a.a.a;
import c.a.a.a.a.a.c;
import c.a.a.a.e;
import c.a.a.a.q;

// Referenced classes of package c.a.a.a.a.b:
//            aa

public final class z
{

    private final c a = new aa(this);
    private final a b = new a();

    public z()
    {
    }

    public final String a(Context context)
    {
        boolean flag;
        try
        {
            context = (String)b.a(context, a);
            flag = "".equals(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            e.d().c("Fabric", "Failed to determine installer package name", context);
            return null;
        }
        if (flag)
        {
            context = null;
        }
        return context;
    }
}
