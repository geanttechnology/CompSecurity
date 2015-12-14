// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.view.View;

// Referenced classes of package com.picsart.effects.clone:
//            CloneActivity

final class a
    implements Runnable
{

    private boolean a;
    private CloneActivity b;

    public final void run()
    {
        View view = b.findViewById(0x7f100135);
        View view1 = b.findViewById(0x7f100137);
        view.setEnabled(a);
        view1.setEnabled(a);
    }

    (CloneActivity cloneactivity, boolean flag)
    {
        b = cloneactivity;
        a = flag;
        super();
    }
}
