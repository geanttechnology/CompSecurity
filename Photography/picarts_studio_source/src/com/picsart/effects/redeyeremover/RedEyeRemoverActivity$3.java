// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.redeyeremover;

import android.view.View;

// Referenced classes of package com.picsart.effects.redeyeremover:
//            RedEyeRemoverActivity

final class a
    implements android.view.EyeRemoverActivity._cls3
{

    private RedEyeRemoverActivity a;

    public final void onClick(View view)
    {
        view.setEnabled(false);
        a.findViewById(0x7f10079a).setEnabled(false);
        a.findViewById(0x7f100799).setEnabled(false);
        RedEyeRemoverActivity.b(a);
    }

    (RedEyeRemoverActivity redeyeremoveractivity)
    {
        a = redeyeremoveractivity;
        super();
    }
}
