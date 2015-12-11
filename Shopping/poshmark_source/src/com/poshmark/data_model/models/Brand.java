// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import android.net.Uri;
import com.poshmark.data_model.models.inner_models.CoverShot;

public class Brand
{

    public String canonical_name;
    public CoverShot cover_shot;
    public String description;
    public CoverShot logo;

    public Brand()
    {
    }

    public static String getDefaultBrandCovershotUrl()
    {
        return "https://d1g0nxoa63qf2e.cloudfront.net/apps/img/m_brand_share_default_v1.jpg";
    }

    public static String getUrlFromBrandName(String s)
    {
        String s1 = "https://www.poshmark.com/brand/";
        if (s != null)
        {
            s = Uri.encode(s.replace("/", "%2F"));
            s1 = (new StringBuilder()).append("https://www.poshmark.com/brand/").append(s).toString();
        }
        return s1;
    }

    String getBrandCanonicalName()
    {
        return canonical_name;
    }

    String getBrandCovershot()
    {
        if (cover_shot != null)
        {
            return cover_shot.url;
        } else
        {
            return null;
        }
    }

    String getBrandCovershotSmall()
    {
        if (cover_shot != null)
        {
            return cover_shot.url_small;
        } else
        {
            return null;
        }
    }

    String getBrandCovershotThumbnail()
    {
        if (cover_shot != null)
        {
            return cover_shot.url_thumb;
        } else
        {
            return null;
        }
    }

    String getBrandLogo()
    {
        if (logo != null)
        {
            return logo.url;
        } else
        {
            return null;
        }
    }

    String getBrandLogoSmall()
    {
        if (logo != null)
        {
            return logo.url_small;
        } else
        {
            return null;
        }
    }

    String getBrandLogoThumbnail()
    {
        if (logo != null)
        {
            return logo.url_thumb;
        } else
        {
            return null;
        }
    }
}
