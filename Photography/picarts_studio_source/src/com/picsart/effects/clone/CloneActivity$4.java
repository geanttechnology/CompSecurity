// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.app.DialogFragment;
import android.view.View;
import com.socialin.android.dialog.c;

// Referenced classes of package com.picsart.effects.clone:
//            CloneActivity

final class a
    implements c
{

    private CloneActivity a;

    public final void onViewCreated(View view, DialogFragment dialogfragment)
    {
        CloneActivity.a(a, view);
    }

    (CloneActivity cloneactivity)
    {
        a = cloneactivity;
        super();
    }
}
