// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.util;

import android.app.Activity;
import com.socialin.android.apiv3.model.ImageItem;

// Referenced classes of package com.socialin.android.picsart.profile.util:
//            GalleryUtils, v

public class u
{

    Activity a;
    ImageItem b;

    u(Activity activity, ImageItem imageitem)
    {
        a = activity;
        b = imageitem;
        super();
    }

    public void a(String s, v v)
    {
        GalleryUtils.a(a, b, s, v);
    }
}
