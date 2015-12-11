// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            PrePostingHelpActivity

final class gc
    implements android.view.View.OnClickListener
{

    private PrePostingHelpActivity a;

    gc(PrePostingHelpActivity prepostinghelpactivity)
    {
        a = prepostinghelpactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.finish();
    }
}
