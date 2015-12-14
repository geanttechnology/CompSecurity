// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.link.model;

import android.content.Context;
import android.net.Uri;
import com.fotoable.exifutil.ImageInfo;
import dw;

public class TMetaInfo extends ImageInfo
{

    private static final long serialVersionUID = 0xd05865ea13bee513L;

    public TMetaInfo(Context context, Uri uri)
    {
        String s = dw.a(context, uri);
        onLoadFromUri(context, uri);
        if (s != null)
        {
            onLoadExifData(s);
            onLoadImageSize(s, rotation);
        }
    }
}
