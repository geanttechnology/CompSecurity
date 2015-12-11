// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            GalleryActivity

final class cj
    implements android.view.View.OnClickListener
{

    private GalleryActivity a;

    cj(GalleryActivity galleryactivity)
    {
        a = galleryactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.onBackPressed();
    }
}
