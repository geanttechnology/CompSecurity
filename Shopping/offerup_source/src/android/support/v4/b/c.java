// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.b;

import android.content.ComponentName;
import android.content.Intent;

// Referenced classes of package android.support.v4.b:
//            e, d, b

public final class c
{

    private static final b a;

    public static Intent a(ComponentName componentname)
    {
        return a.a(componentname);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 15)
        {
            a = new e();
        } else
        if (i >= 11)
        {
            a = new d();
        } else
        {
            a = new b();
        }
    }
}
