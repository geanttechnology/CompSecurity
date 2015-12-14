// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import com.socialin.android.apiv3.model.RecentTagsResponse;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            GalleryItemTagActivity

final class e
    implements d
{

    private GalleryItemTagActivity a;

    private e(GalleryItemTagActivity galleryitemtagactivity)
    {
        a = galleryitemtagactivity;
        super();
    }

    e(GalleryItemTagActivity galleryitemtagactivity, byte byte0)
    {
        this(galleryitemtagactivity);
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (RecentTagsResponse)obj;
        GalleryItemTagActivity.a(a, ((RecentTagsResponse) (obj)));
    }
}
