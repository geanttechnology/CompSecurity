// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.api.models;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.rdio.android.api.models:
//            ApiModel

public class Ad extends ApiModel
{
    public static class AdImage
    {

        public String altText;
        public String clickthroughUrl;
        public int height;
        public List impressionUrls;
        public String url;
        public int width;

        public AdImage()
        {
            impressionUrls = new ArrayList();
        }
    }


    public int duration;
    public AdImage image;
    public List impressionUrls;
    public boolean isAd;
    public String key;
    public String surl;
    public String title;
    public String type;

    public Ad()
    {
        image = new AdImage();
        impressionUrls = new ArrayList();
    }
}
