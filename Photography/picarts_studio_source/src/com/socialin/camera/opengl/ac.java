// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.camera.opengl:
//            ad

public final class ac
{

    public int a;
    ad b;
    private String c;
    private String d;

    public ac()
    {
        b = new ad();
    }

    public ac(String s, String s1)
    {
        c = s;
        d = s1;
        b = new ad();
    }

    public final void a(Activity activity)
    {
        a = m.c(activity, c, d);
    }
}
