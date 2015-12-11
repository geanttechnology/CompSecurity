// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            ProfileImageActivity

final class gj
    implements android.view.View.OnClickListener
{

    private ProfileImageActivity a;

    gj(ProfileImageActivity profileimageactivity)
    {
        a = profileimageactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.finish();
    }
}
