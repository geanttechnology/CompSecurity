// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.a;

import android.content.ComponentName;
import android.content.Intent;

// Referenced classes of package android.support.v4.a:
//            i, h, g, f

public final class e
{

    private static final f a;

    public static Intent a(ComponentName componentname)
    {
        return a.a(componentname);
    }

    static 
    {
        int j = android.os.Build.VERSION.SDK_INT;
        if (j >= 15)
        {
            a = new i();
        } else
        if (j >= 11)
        {
            a = new h();
        } else
        {
            a = new g();
        }
    }
}
