// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.util;

import android.graphics.Bitmap;

public final class b extends com.socialin.android.apiv3.model.BannersResponse.ItemData
{

    Bitmap a;
    int b;

    public b(com.socialin.android.apiv3.model.BannersResponse.BannerItem banneritem)
    {
        a = null;
        b = -1;
        data = banneritem;
        a = null;
    }
}
