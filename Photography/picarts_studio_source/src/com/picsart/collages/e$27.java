// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.app.Activity;
import myobfuscated.cv.c;

// Referenced classes of package com.picsart.collages:
//            f, e, CollageCreatorView

final class a
    implements f
{

    private Activity a;
    private e b;

    public final void a(String s)
    {
        c.a(a, s);
        e.b(b).setChanged(false);
    }

    geCreatorView(e e1, Activity activity)
    {
        b = e1;
        a = activity;
        super();
    }
}
