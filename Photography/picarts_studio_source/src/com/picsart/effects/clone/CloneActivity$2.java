// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.view.View;

// Referenced classes of package com.picsart.effects.clone:
//            CloneActivity, CloneSurfaceView

final class a
    implements android.view.ener
{

    private CloneActivity a;

    public final void onClick(View view)
    {
        a.findViewById(0x7f100131).setBackgroundResource(0x7f0205a1);
        a.findViewById(0x7f100130).setBackgroundResource(0x7f02068f);
        if (a.findViewById(0x7f100133).getVisibility() == 0)
        {
            CloneActivity.c(a);
        }
        if (CloneActivity.b(a) != null)
        {
            CloneActivity.b(a).b(1);
        }
    }

    (CloneActivity cloneactivity)
    {
        a = cloneactivity;
        super();
    }
}
