// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import android.net.Uri;
import java.util.List;

final class AssetUriParser
{

    private static final int ASSET_PREFIX_LENGTH = "file:///android_asset/".length();

    public static boolean isAssetUri(Uri uri)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if ("file".equals(uri.getScheme()))
        {
            flag = flag1;
            if (!uri.getPathSegments().isEmpty())
            {
                flag = flag1;
                if ("android_asset".equals(uri.getPathSegments().get(0)))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static String toAssetPath(Uri uri)
    {
        return uri.toString().substring(ASSET_PREFIX_LENGTH);
    }

}
