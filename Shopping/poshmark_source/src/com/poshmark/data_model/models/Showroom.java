// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.models.inner_models.CoverShot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Showroom
{

    String content_type;
    CoverShot cover_shot;
    String created_at;
    String creator_id;
    String description;
    String id;
    String name;
    String short_url;
    List tags;
    String updated_at;

    public Showroom()
    {
        tags = Collections.synchronizedList(new ArrayList());
    }

    public CoverShot getCoverShot()
    {
        return cover_shot;
    }

    public String getDescription()
    {
        return description;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getShortURL()
    {
        return short_url;
    }

    public String getWebURL()
    {
        return String.format("%s/showroom/%s", new Object[] {
            "https://www.poshmark.com", id
        });
    }
}
