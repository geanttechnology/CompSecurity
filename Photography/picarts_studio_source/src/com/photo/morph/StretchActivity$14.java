// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.app.DialogFragment;
import android.view.View;
import com.socialin.android.dialog.c;

// Referenced classes of package com.photo.morph:
//            StretchActivity

final class a
    implements c
{

    private StretchActivity a;

    public final void onViewCreated(View view, DialogFragment dialogfragment)
    {
        StretchActivity.b(a, view);
    }

    (StretchActivity stretchactivity)
    {
        a = stretchactivity;
        super();
    }
}
