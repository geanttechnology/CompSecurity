// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.view.co;
import com.offerup.android.tracker.PhotoGalleryUserInteractionRecord;

// Referenced classes of package com.offerup.android.activities:
//            GalleryActivity

final class cl
    implements co
{

    private GalleryActivity a;

    cl(GalleryActivity galleryactivity)
    {
        a = galleryactivity;
        super();
    }

    public final void a(int i)
    {
        GalleryActivity.a(a, i);
        GalleryActivity.b(a).a(i);
        GalleryActivity.c(a);
    }

    public final void a(int i, float f, int j)
    {
    }

    public final void b(int i)
    {
        if (i == 1)
        {
            GalleryActivity.b(a).c();
        }
    }
}
