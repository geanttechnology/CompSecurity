// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.t;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;

// Referenced classes of package myobfuscated.t:
//            p

public final class o
{

    public final Context a;
    public ActivityManager b;
    public p c;
    public float d;
    public float e;
    public float f;
    public float g;
    public int h;

    public o(Context context)
    {
        d = 2.0F;
        e = 4F;
        f = 0.4F;
        g = 0.33F;
        h = 0x400000;
        a = context;
        b = (ActivityManager)context.getSystemService("activity");
        c = new p(context.getResources().getDisplayMetrics());
    }
}
