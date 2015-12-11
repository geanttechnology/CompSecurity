// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.aa;
import android.support.v4.app.am;
import com.offerup.android.dto.Item;

// Referenced classes of package com.offerup.android.g.a:
//            y, p

final class z extends am
{

    private y a;

    z(y y1, aa aa)
    {
        a = y1;
        super(aa);
    }

    public final Fragment a(int i)
    {
        Object obj = null;
        com.offerup.android.dto.Photo photo = obj;
        if (a.a != null)
        {
            photo = obj;
            if (a.a.getPhotos() != null)
            {
                photo = obj;
                if (i < a.a.getPhotos().length)
                {
                    photo = a.a.getPhotos()[i];
                }
            }
        }
        return p.a(y.a(a), i, photo);
    }

    public final int b()
    {
        if (a.a == null || a.a.getPhotos() == null)
        {
            return 0;
        } else
        {
            return a.a.getPhotos().length;
        }
    }
}
