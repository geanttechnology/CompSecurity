// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import com.socialin.android.dialog.g;

// Referenced classes of package com.picsart.effects.clone:
//            CloneActivity

final class a
    implements Runnable
{

    private int a;
    private CloneActivity b;

    public final void run()
    {
        b.e();
        CloneActivity.a(b, g.a(b, null, b.getString(a)));
    }

    (CloneActivity cloneactivity, int i)
    {
        b = cloneactivity;
        a = i;
        super();
    }
}
