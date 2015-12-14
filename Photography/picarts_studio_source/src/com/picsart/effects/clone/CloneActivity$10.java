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

    private CloneActivity a;

    public final void run()
    {
        if (CloneActivity.h(a) != null && CloneActivity.h(a).isShowing())
        {
            CloneActivity.h(a).dismiss();
        }
    }

    (CloneActivity cloneactivity)
    {
        a = cloneactivity;
        super();
    }
}
