// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.i;
import com.offerup.android.dto.ItemPost;
import com.offerup.android.g.c.ae;
import com.offerup.android.g.c.g;
import com.offerup.android.g.c.s;
import com.offerup.android.g.c.y;

// Referenced classes of package com.offerup.android.activities:
//            NewPostActivity

final class ei
{

    private NewPostActivity a;

    ei(NewPostActivity newpostactivity)
    {
        a = newpostactivity;
        super();
    }

    public final void onPostCategoryUpdated(g g1)
    {
        NewPostActivity.a(a).setCategory(g1.a());
        NewPostActivity.a(a).setDescription(g1.b());
        if (NewPostActivity.b(a) && !NewPostActivity.c(a))
        {
            NewPostActivity.d(a).a(NewPostActivity.a(a));
        }
    }

    public final void onPostPhotoUpdated(s s1)
    {
        NewPostActivity.a(a).setTitle(s1.a());
        NewPostActivity.a(a).setItemPostPhotos(s1.b());
        if (NewPostActivity.b(a) && !NewPostActivity.c(a))
        {
            NewPostActivity.d(a).a(NewPostActivity.a(a));
        }
    }

    public final void onPostPriceUpdated(y y1)
    {
        NewPostActivity.a(a).setCondition(y1.b());
        NewPostActivity.a(a).setPrice((new StringBuilder()).append(y1.c()).toString());
        NewPostActivity.a(a).setListingType(y1.a());
        if (NewPostActivity.b(a) && !NewPostActivity.c(a))
        {
            NewPostActivity.d(a).a(NewPostActivity.a(a));
        }
    }

    public final void onPostShareUpdated(ae ae1)
    {
        NewPostActivity.a(a).setLatitude(ae1.c());
        NewPostActivity.a(a).setLongitude(ae1.d());
        NewPostActivity.a(a).setZipcode(ae1.b());
        NewPostActivity.a(a).setLocationName(ae1.e());
        ItemPost itempost = NewPostActivity.a(a);
        int j;
        if (ae1.a())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        itempost.setShareToFacebook(Integer.valueOf(j));
        if (NewPostActivity.b(a) && !NewPostActivity.c(a))
        {
            NewPostActivity.d(a).a(NewPostActivity.a(a));
        }
    }
}
