// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            TruYouInitActivity

final class hz
    implements android.view.View.OnClickListener
{

    private TruYouInitActivity a;

    hz(TruYouInitActivity truyouinitactivity)
    {
        a = truyouinitactivity;
        super();
    }

    public final void onClick(View view)
    {
        TruYouInitActivity.b(a);
    }
}
