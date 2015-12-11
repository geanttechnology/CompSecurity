// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile.ADBScene7;

import android.graphics.Bitmap;

// Referenced classes of package com.adobe.mobile.ADBScene7:
//            S7CachedResource, S7ResourceType

public class Scene7Image
{

    private static String _company;
    private static int _height;
    private static int _width;
    private static S7CachedResource s7Resource;

    public Scene7Image()
    {
    }

    public static void GetAsset(String s, final S7CachedResource.S7Callback callback)
    {
        if (s7Resource == null)
        {
            s7Resource = new S7CachedResource();
        }
        s7Resource.GetS7CachedResource(_company, S7ResourceType.S7ResourceTypeImage, _height, _width, s, new S7CachedResource.S7Callback() {

            final S7CachedResource.S7Callback val$callback;

            public void call(Bitmap bitmap)
            {
                if (callback != null)
                {
                    callback.call(bitmap);
                }
            }

            public volatile void call(Object obj)
            {
                call((Bitmap)obj);
            }

            
            {
                callback = s7callback;
                super();
            }
        });
    }

    public static void SetCompany(String s)
    {
        _company = s;
    }

    public static void SetDimensions(int i, int j)
    {
        _height = i;
        _width = j;
    }
}
