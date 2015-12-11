// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.aa;
import android.support.v4.app.am;
import com.offerup.android.g.a.l;

// Referenced classes of package com.offerup.android.activities:
//            GalleryActivity

final class ck extends am
{

    private GalleryActivity a;

    ck(GalleryActivity galleryactivity, aa aa)
    {
        a = galleryactivity;
        super(aa);
    }

    public final Fragment a(int i)
    {
        Object obj = null;
        com.offerup.android.dto.Photo photo = obj;
        if (GalleryActivity.a(a) != null)
        {
            photo = obj;
            if (i < GalleryActivity.a(a).length)
            {
                photo = GalleryActivity.a(a)[i];
            }
        }
        return l.a(i, photo);
    }

    public final int b()
    {
        if (GalleryActivity.a(a) == null)
        {
            return 0;
        } else
        {
            return GalleryActivity.a(a).length;
        }
    }
}
